// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import com.pipcamera.application.PIPCameraApplication;

public class sb
{

    public static SharedPreferences a;

    public static void a()
    {
        android.content.SharedPreferences.Editor editor = a.edit();
        editor.putBoolean("five_star_rate", false);
        editor.commit();
    }

    public static void b()
    {
        android.content.SharedPreferences.Editor editor = a.edit();
        editor.putBoolean("five_star_rate", true);
        editor.commit();
    }

    public static boolean c()
    {
        return a.getBoolean("five_star_rate", false);
    }

    static 
    {
        a = PIPCameraApplication.a.getSharedPreferences("config", 0);
    }
}
