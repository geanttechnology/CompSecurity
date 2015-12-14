// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.a;

import android.app.AlertDialog;
import android.os.Environment;
import java.io.File;

public class b
{

    private static AlertDialog a = null;

    public static boolean a()
    {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static String b()
    {
        String s = Environment.getRootDirectory().getPath();
        if (a())
        {
            s = Environment.getExternalStorageDirectory().getPath();
        }
        return s;
    }

    public static boolean c()
    {
        return android.os.Build.VERSION.SDK_INT >= 8;
    }

    public static boolean d()
    {
        return android.os.Build.VERSION.SDK_INT >= 9;
    }

    public static boolean e()
    {
        return android.os.Build.VERSION.SDK_INT >= 11;
    }

    public static boolean f()
    {
        return android.os.Build.VERSION.SDK_INT >= 12;
    }

}
