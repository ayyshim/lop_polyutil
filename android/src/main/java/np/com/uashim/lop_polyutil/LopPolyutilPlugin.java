package np.com.uashim.lop_polyutil;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.PolyUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** LopPolyutilPlugin */
public class LopPolyutilPlugin implements FlutterPlugin, MethodCallHandler {
  @Override
  public void onAttachedToEngine( FlutterPluginBinding flutterPluginBinding) {
    final MethodChannel channel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "lop_polyutil");
    channel.setMethodCallHandler(new LopPolyutilPlugin());
  }

  // This static function is optional and equivalent to onAttachedToEngine. It supports the old
  // pre-Flutter-1.12 Android projects. You are encouraged to continue supporting
  // plugin registration via this function while apps migrate to use the new Android APIs
  // post-flutter-1.12 via https://flutter.dev/go/android-project-migration.
  //
  // It is encouraged to share logic between onAttachedToEngine and registerWith to keep
  // them functionally equivalent. Only one of onAttachedToEngine or registerWith will be called
  // depending on the user's project. onAttachedToEngine or registerWith must both be defined
  // in the same class.
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "lop_polyutil");
    channel.setMethodCallHandler(new LopPolyutilPlugin());
  }

  @Override
  public void onMethodCall( MethodCall call, Result result) {
    if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    } else if (call.method.equals("isLocationOnPath")) {
      Log.d("Mapped Arguments", String.valueOf(call.arguments));
      Log.d("Path type: ", call.argument("path").getClass().getName());
      ArrayList<HashMap> normalMappedList = (ArrayList<HashMap>) call.argument("path");
      List<LatLng> path = new ArrayList<LatLng>();
      for(HashMap p: normalMappedList) {
        double lat = (double) p.get("lat");
        double lng = (double) p.get("lng");
        path.add(new LatLng(lat, lng));
      }

      HashMap normalMappedPoint = call.argument("point");
      double pointLat = (double) normalMappedPoint.get("lat");
      double pointLng = (double) normalMappedPoint.get("lng");
      LatLng point = new LatLng(pointLat, pointLng);

      double radius = (double) call.argument("radius");

      if(PolyUtil.isLocationOnPath(point, path, true, radius)) {
        result.success(true);
      } else {
        result.success(false);
      }

    } else {
      result.notImplemented();
    }
  }

  @Override
  public void onDetachedFromEngine( FlutterPluginBinding binding) {
  }
}
