// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.io.File;

public final class c
{

    private static Context a;

    public static final Context a()
    {
        if (a == null)
        {
            return null;
        } else
        {
            return a;
        }
    }

    public static final void a(Context context)
    {
        a = context;
    }

    public static final String b()
    {
        if (a() == null)
        {
            return "";
        } else
        {
            return a().getPackageName();
        }
    }

    public static final File c()
    {
        if (a() == null)
        {
            return null;
        } else
        {
            return a().getFilesDir();
        }
    }

    public static void d()
    {
        Object obj = a();
        if (obj != null) goto _L2; else goto _L1
_L1:
        PackageInfo packageinfo;
        return;
_L2:
        if ((packageinfo = ((Context) (obj)).getPackageManager().getPackageInfo(((Context) (obj)).getPackageName(), 0)) == null) goto _L1; else goto _L3
_L3:
        try
        {
            obj = ((Context) (obj)).getSharedPreferences("openSdk.pref", 0).edit();
            ((android.content.SharedPreferences.Editor) (obj)).putInt("app.vercode", packageinfo.versionCode);
            ((android.content.SharedPreferences.Editor) (obj)).commit();
            return;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            namenotfoundexception.printStackTrace();
        }
        return;
    }
}
