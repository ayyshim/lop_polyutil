import 'package:flutter/material.dart';
import 'package:google_maps_flutter/google_maps_flutter.dart';
import 'package:lop_polyutil/lop_polyutil.dart';

void main() => runApp(MaterialApp(
      title: "LocationOnPath - PolyUtil",
      home: Home(),
    ));

class Home extends StatefulWidget {
  @override
  _HomeState createState() => _HomeState();
}

class _HomeState extends State<Home> {

  bool _result;

  @override
  void initState() {
    super.initState();
    initPlatformCode();
  }

  Future<void> initPlatformCode() async {
    List<LatLng> path =[];
    path.add(LatLng(0, 0));
    path.add(LatLng(0, 1));
    path.add(LatLng(0, 3));
    path.add(LatLng(0, 4));

    LatLng point = LatLng(30, 74);

    final result = await LopPolyutil.isLocationOnPath(path: path, point: point);
    setState(() {
      this._result = result;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("LocationOnPath - PolyUtil"),
      ),
      body: Container(
        child: Center(
          child: Text("isLocationOnPath ? ${this._result}"),
        ),
      ),
    );
  }
}
