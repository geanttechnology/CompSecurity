// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import java.util.Locale;

public class WebUtils
{

    public static final String BITMOJI_USER_AGENT_HEADER = "Bitmoji-User-Agent";
    private static final String USER_AGENT_DELIMITER = "|";
    private static final int USER_AGENT_ITERATION = 1;
    private static final String USER_AGENT_OS = "Android";

    public WebUtils()
    {
    }

    public static String getBitmojiUserAgent(Context context)
    {
        String s1 = context.getPackageName();
        String s;
        String s2;
        String s3;
        String s4;
        String s5;
        try
        {
            s = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            namenotfoundexception = "";
        }
        s2 = android.os.Build.VERSION.RELEASE;
        s3 = (new StringBuilder()).append(Build.MANUFACTURER).append(" ").append(Build.MODEL).toString();
        s4 = (new StringBuilder()).append("").append(android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id")).toString();
        context = Float.toString(context.getResources().getDisplayMetrics().density);
        s5 = Locale.getDefault().toString();
        return (new StringBuilder()).append("1|").append(s1.replaceAll("|", "")).append("|").append(s.replaceAll("|", "")).append("|").append("Android".replaceAll("|", "")).append("|").append(s2.replaceAll("|", "")).append("|").append(s3.replaceAll("|", "")).append("|").append(s4.replaceAll("|", "")).append("|").append(context.replaceAll("|", "")).append("|").append(s5.replaceAll("|", "")).toString();
    }
}
