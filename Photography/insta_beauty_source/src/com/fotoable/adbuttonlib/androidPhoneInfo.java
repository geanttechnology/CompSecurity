// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import aoo;
import bpa;
import java.util.Locale;

public class androidPhoneInfo
{

    public androidPhoneInfo()
    {
    }

    public static String WTAppBaseParams(Context context)
    {
        Object obj;
        String s;
        String s2;
        String s1;
        String s3;
        String s4;
        String s5;
        String s6;
        String s7;
        String s8;
        try
        {
            TelephonyManager telephonymanager = (TelephonyManager)context.getSystemService("phone");
            s2 = bpa.a(((WifiManager)context.getSystemService("wifi")).getConnectionInfo().getMacAddress());
            s = telephonymanager.getDeviceId();
            s6 = Locale.getDefault().getLanguage();
            s4 = Locale.getDefault().getLanguage();
            s5 = Locale.getDefault().getCountry();
            s8 = aoo.a().a(context);
            s7 = Build.MODEL;
            s3 = android.os.Build.VERSION.RELEASE;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        obj = s;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        obj = s;
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            obj = Build.SERIAL;
        }
        context = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
_L12:
        if (context == null) goto _L2; else goto _L1
_L1:
        s = ((PackageInfo) (context)).versionName;
_L8:
        context = (new StringBuilder()).append("openuuid=").append(s2).toString();
        context = (new StringBuilder()).append(context).append("&appid=").append("instabeauty").toString();
        s1 = (new StringBuilder()).append(context).append("&os=").append("android").toString();
        context = s1;
        if (s8 == null)
        {
            break MISSING_BLOCK_LABEL_223;
        }
        context = (new StringBuilder()).append(s1).append("&deviceToken=").append(s8).toString();
        if (obj == null) goto _L4; else goto _L3
_L3:
        obj = (new StringBuilder()).append(context).append("&uuid=").append(((String) (obj))).toString();
_L7:
        context = ((Context) (obj));
        if (s7 == null)
        {
            break MISSING_BLOCK_LABEL_283;
        }
        context = (new StringBuilder()).append(((String) (obj))).append("&devicetype=").append(s7).toString();
        obj = context;
        if (s6 == null)
        {
            break MISSING_BLOCK_LABEL_315;
        }
        obj = (new StringBuilder()).append(context).append("&langcode=").append(s6).toString();
        context = ((Context) (obj));
        if (s5 == null)
        {
            break MISSING_BLOCK_LABEL_347;
        }
        context = (new StringBuilder()).append(((String) (obj))).append("&countrycode=").append(s5).toString();
        obj = context;
        if (s4 == null)
        {
            break MISSING_BLOCK_LABEL_379;
        }
        obj = (new StringBuilder()).append(context).append("&prelang=").append(s4).toString();
        context = ((Context) (obj));
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_409;
        }
        context = (new StringBuilder()).append(((String) (obj))).append("&ver=").append(s).toString();
        obj = context;
        if (s3 == null) goto _L6; else goto _L5
_L5:
        obj = (new StringBuilder()).append(context).append("&deviceVersion=").append(s3).toString();
          goto _L6
        context;
        context.printStackTrace();
        context = null;
        continue; /* Loop/switch isn't completed */
_L10:
        return null;
_L4:
        obj = context;
          goto _L7
_L2:
        s = null;
          goto _L8
_L6:
        if (s2 == null) goto _L10; else goto _L9
_L9:
        return ((String) (obj));
        if (true) goto _L12; else goto _L11
_L11:
    }
}
