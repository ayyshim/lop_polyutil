#import "LopPolyutilPlugin.h"
#if __has_include(<lop_polyutil/lop_polyutil-Swift.h>)
#import <lop_polyutil/lop_polyutil-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "lop_polyutil-Swift.h"
#endif

@implementation LopPolyutilPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftLopPolyutilPlugin registerWithRegistrar:registrar];
}
@end
