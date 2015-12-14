// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.autoupdatesdk.AppUpdateInfo;
import com.baidu.autoupdatesdk.AppUpdateInfoForInstall;

public final class an
{

    private static final String a = "bdp_pref";
    private static final String b = "ignore_version_code";
    private static final String c = "install_info";
    private static final String d = "installed_last_modified";
    private static final String e = "installed_md5";

    private an()
    {
    }

    public static int a(Context context)
    {
        return context.getSharedPreferences("bdp_pref", 0).getInt("ignore_version_code", -1);
    }

    public static void a(Context context, int i)
    {
        context = context.getSharedPreferences("bdp_pref", 0).edit();
        context.putInt("ignore_version_code", i);
        context.commit();
    }

    public static void a(Context context, long l)
    {
        context = context.getSharedPreferences("bdp_pref", 0).edit();
        context.putLong("installed_last_modified", l);
        context.commit();
    }

    public static void a(Context context, AppUpdateInfo appupdateinfo)
    {
        appupdateinfo = AppUpdateInfoForInstall.toJson(appupdateinfo);
        if (!TextUtils.isEmpty(appupdateinfo))
        {
            context = context.getSharedPreferences("bdp_pref", 0).edit();
            context.putString("install_info", appupdateinfo);
            context.commit();
        }
    }

    public static void a(Context context, String s)
    {
        context = context.getSharedPreferences("bdp_pref", 0).edit();
        context.putString("installed_md5", s);
        context.commit();
    }

    public static AppUpdateInfoForInstall b(Context context)
    {
        return AppUpdateInfoForInstall.build(context.getSharedPreferences("bdp_pref", 0).getString("install_info", null));
    }

    public static long c(Context context)
    {
        return context.getSharedPreferences("bdp_pref", 0).getLong("installed_last_modified", 0L);
    }

    public static String d(Context context)
    {
        return context.getSharedPreferences("bdp_pref", 0).getString("installed_md5", "");
    }
}
