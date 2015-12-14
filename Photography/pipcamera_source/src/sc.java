// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;

public class sc
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
    private static String t = "camera_basic_info";

    public static boolean a(String s1, Context context, boolean flag)
    {
        return context.getSharedPreferences(t, 32768).getBoolean(s1, flag);
    }

}
