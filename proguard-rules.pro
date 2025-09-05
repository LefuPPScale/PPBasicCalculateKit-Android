# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#-keep class *.R
#-keepclasseswithmembers class **.R$* { public static <fields>;}

-keep class **.R$* {
    <fields>;
}
-dontwarn **.R$*

-keep class com.lefu.body_sl.** {*;}
-keep enum com.lefu.body_sl.** {*;}
-keep enum com.lefu.ppbasecalculatekit.** {*;}
-keep class com.lefu.ppbasecalculatekit.** {*;}

-keep class com.besthealth.bhBodyComposition.** {*;}
-keep class com.besthealth.bh1BodyComposition.** {*;}
-keep class com.besthealth.bh2BodyComposition.** {*;}
-keep class com.besthealth.bh3BodyComposition.** {*;}
-keep class com.besthealth.bh4BodyComposition.** {*;}
-keep class com.besthealth.bh5BodyComposition.** {*;}

# 保留 Kotlin 元数据
-keepclassmembers class ** {
    @kotlin.Metadata *;
}

# 保留 Kotlin 特有功能
-keep class kotlin.** { *; }
-keepclassmembers class **$WhenMappings { *; }
-keepclassmembers class * {
    @kotlin.jvm.* *;
}

# 保留 StringConcatFactory 相关类
-dontwarn java.lang.invoke.StringConcatFactory
-keep class java.lang.invoke.StringConcatFactory { *; }

# 保留字符串连接相关的方法
-keepclassmembers class * {
    java.lang.String toString();
}




