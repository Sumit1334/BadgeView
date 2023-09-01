# Add any ProGuard configurations specific to this
# extension here.

-keep public class com.sumit.badgeview.BadgeView {
    public *;
 }
-keeppackagenames gnu.kawa**, gnu.expr**

-optimizationpasses 4
-allowaccessmodification
-mergeinterfacesaggressively

-repackageclasses 'com/sumit/badgeview/repack'
-flattenpackagehierarchy
-dontpreverify
