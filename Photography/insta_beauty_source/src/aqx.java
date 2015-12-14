// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.model.res.TResInfo;

public class aqx
{

    private static String a = "wantu_shareprefsname";

    public static int a(Context context, String s, int i)
    {
        return context.getSharedPreferences(a, 0).getInt(s, i);
    }

    public static void a(Context context, String s, String s1)
    {
        context = context.getSharedPreferences(s, 0).edit();
        context.remove(s1);
        context.apply();
    }

    public static void a(Context context, String s, String s1, String s2)
    {
        context = context.getSharedPreferences(s, 0).edit();
        context.putString(s1, s2);
        context.apply();
    }

    public static void a(String s)
    {
        if (s != null && (!s.equalsIgnoreCase("") || !s.equalsIgnoreCase("0")))
        {
            Object obj = InstaBeautyApplication.a.getSharedPreferences("shareStyleID", 0);
            s = (new StringBuilder()).append("hasSharedID_").append(s).toString();
            obj = ((SharedPreferences) (obj)).edit();
            ((android.content.SharedPreferences.Editor) (obj)).putBoolean(s, true);
            ((android.content.SharedPreferences.Editor) (obj)).apply();
        }
    }

    public static boolean a(Context context, String s, String s1, boolean flag)
    {
        return context.getSharedPreferences(s, 0).getBoolean(s1, flag);
    }

    public static boolean a(Context context, String s, boolean flag)
    {
        return context.getSharedPreferences(a, 0).getBoolean(s, flag);
    }

    public static boolean a(TResInfo tresinfo)
    {
        while (tresinfo.shareStyleID == null || tresinfo.shareStyleID.equalsIgnoreCase("") || tresinfo.shareStyleID.equalsIgnoreCase("0")) 
        {
            return false;
        }
        return InstaBeautyApplication.a.getSharedPreferences("shareStyleID", 0).getBoolean((new StringBuilder()).append("hasSharedID_").append(tresinfo.shareStyleID).toString(), false);
    }

    public static String b(Context context, String s, String s1)
    {
        return context.getSharedPreferences(s, 0).getString(s1, null);
    }

    public static void b(Context context, String s, int i)
    {
        context = context.getSharedPreferences(a, 0).edit();
        context.putInt(s, i);
        context.apply();
    }

    public static void b(Context context, String s, String s1, boolean flag)
    {
        context = context.getSharedPreferences(s, 0).edit();
        context.putBoolean(s1, flag);
        context.apply();
    }

    public static void b(Context context, String s, boolean flag)
    {
        context = context.getSharedPreferences(a, 0).edit();
        context.putBoolean(s, flag);
        context.apply();
    }

    public static String c(Context context, String s, String s1)
    {
        return context.getSharedPreferences(a, 0).getString(s, s1);
    }

    public static void d(Context context, String s, String s1)
    {
        context = context.getSharedPreferences(a, 0).edit();
        context.putString(s, s1);
        context.apply();
    }

    public static boolean e(Context context, String s, String s1)
    {
        return context.getSharedPreferences(s, 0).getBoolean(s1, false);
    }

}
