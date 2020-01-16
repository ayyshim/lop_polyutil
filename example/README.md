# lop_polyutil

**LopPolyutil** is an implementation of `isLocationOnPath()` google map PolyUtil method.

## Usage

Import `package:lop_polyutil/lop_polyutil.dart` and then call a static method `isLocationOnPath` which will return a _boolean_.

```dart
// import package
import 'package:lop_polyutil/lop_polyutil.dart';

// Prepare arguments to pass.
// It takes 2 @required and 1 optional arguments.

// List of LatLng
List<LatLng> paths = [];
paths.add(LatLng(0,0));
paths.add(LatLng(0,1));
paths.add(LatLng(0,2));
paths.add(LatLng(0,4));

// Coordinate you want to check if it lies within or near path.
LatLng point = LatLng(0, 3);

// radius is optional argument. By default radius is set at 200 meters.
double radius = 200;

// isLocationOnPath a Future method so we will use .then()
LopPolyutil.isLocationOnPath(path: paths, point: point, radius: radius)
    .then((result) {
      	if(result == true) {
    		// things you can do when point is within or near path goes here...
		} else {
    		// things you can do when point isn't within or near path goes here...
		}
    });

```

## Author

**[Ashim Upadhaya](https://github.com/ayyshim)**

#### Note

This plugin is not supported by ios yet.
