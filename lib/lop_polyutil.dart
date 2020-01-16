import 'dart:async';

import 'package:flutter/services.dart';
import 'package:google_maps_flutter/google_maps_flutter.dart';
import 'package:meta/meta.dart';

class LopPolyutil {
  static const MethodChannel _channel = const MethodChannel('lop_polyutil');

  static Future<bool> isLocationOnPath(
      {@required List<LatLng> path,
      @required LatLng point,
      double radius = 200.0}) async {
    // Normalizing List of LatLng into List of Mapped Object
    final mappedPath =
        path.map((p) => {"lat": p.latitude, "lng": p.longitude}).toList();

    // Normalizing LatLng into Mapped object
    final normalPoint = {"lat": point.latitude, "lng": point.longitude};

    // Arguments to pass on invokeMethod
    Map<String, dynamic> args = {
      "path": mappedPath,
      "point": normalPoint,
      "radius": radius
    };

    // Invoking method
    final result = await _channel.invokeMethod('isLocationOnPath', args);

    return result;
  }
}
