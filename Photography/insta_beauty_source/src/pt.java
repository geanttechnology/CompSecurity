// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;

public class pt
{

    public static String a = "camera_picture_degree";
    public static String b = "oneCaptureIsSaveImg";
    public static String c = "continusCaptureIsSaveImg";
    public static String d = "closeShootSound";
    public static String e = "auto_blemish_on";
    public static String f = "auto_eyebag_on";
    public static String g = "auto_beauty_on";
    public static String h = "realtime_beauty_on";
    public static String i = "CameraSettingDelayCapture";
    public static String j = "CameraSettingClickScreenCapture";
    public static String k = "PreviewAdjustFront";
    public static String l = "PreviewAdjustBack";
    public static String m = "CameraCheckMagicIsSet";
    public static String n = "CameraIsOpenMagic";
    public static String o = "photoautowhitening";
    public static String p = "camera_need_change";
    public static String q = "cam_tip_filter_slider";
    public static String r = "cam_new_tip_heiping";
    public static String s = "cam_new_filter";
    public static String t = "intelligent_beauty_on";
    private static String u = "camera_basic_info";

    public static void a(android.hardware.Camera.Size size, Context context)
    {
        context = context.getSharedPreferences("camera_size", 32768);
        context.edit().putFloat("size_width", size.width).commit();
        context.edit().putFloat("size_height", size.height).commit();
    }

    public static void a(String s1, Context context, float f1)
    {
        context.getSharedPreferences(u, 32768).edit().putFloat(s1, f1).commit();
    }

    public static void a(String s1, Context context, int i1)
    {
        context.getSharedPreferences(u, 32768).edit().putInt(s1, i1).commit();
    }

    public static void a(String s1, Context context, boolean flag)
    {
        context.getSharedPreferences(u, 32768).edit().putBoolean(s1, flag).commit();
    }

    public static int b(String s1, Context context, int i1)
    {
        return context.getSharedPreferences(u, 32768).getInt(s1, i1);
    }

    public static boolean b(String s1, Context context, boolean flag)
    {
        return context.getSharedPreferences(u, 32768).getBoolean(s1, flag);
    }

}
