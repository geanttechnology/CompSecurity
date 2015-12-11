// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.console;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class a
{

    private static Application a;

    public static int a(String s)
    {
        int i;
        try
        {
            i = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return 0;
        }
        return i;
    }

    public static Application a()
    {
        return a;
    }

    public static String a(int i)
    {
        return a.getString(i);
    }

    public static String a(byte abyte0[])
    {
        return b(abyte0[3] << 24 | abyte0[2] << 16 | abyte0[1] << 8 | abyte0[0]);
    }

    public static void a(Application application)
    {
        a = application;
    }

    public static String b()
    {
        Object obj;
        try
        {
            obj = a();
            obj = ((Context) (obj)).getPackageManager().getPackageInfo(((Context) (obj)).getPackageName(), 0).versionName;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return null;
        }
        return ((String) (obj));
    }

    public static String b(int i)
    {
        StringBuilder stringbuilder = new StringBuilder(15);
        stringbuilder.append(i & 0xff).append(".").append(i >> 8 & 0xff).append(".").append(i >> 16 & 0xff).append(".").append(i >> 24 & 0xff);
        return stringbuilder.toString();
    }

    public static boolean b(String s)
    {
        return s == null || s.length() == 0;
    }

    public static String c()
    {
        return "setosoft@gmail.com";
    }
}
