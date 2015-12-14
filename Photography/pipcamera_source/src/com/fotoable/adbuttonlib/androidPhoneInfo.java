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
import com.crashlytics.android.Crashlytics;
import eu;
import java.util.Locale;
import jj;

public class androidPhoneInfo
{

    public androidPhoneInfo()
    {
    }

    public static String WTAppBaseParams(Context context)
    {
        Object obj;
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        String s6;
        obj = (TelephonyManager)context.getSystemService("phone");
        obj = eu.a(((WifiManager)context.getSystemService("wifi")).getConnectionInfo().getMacAddress());
        s4 = Locale.getDefault().getLanguage();
        s2 = Locale.getDefault().getLanguage();
        s3 = Locale.getDefault().getCountry();
        s6 = jj.a().a(context);
        s5 = Build.MODEL;
        s1 = android.os.Build.VERSION.RELEASE;
        context = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
_L6:
        if (context == null) goto _L2; else goto _L1
_L1:
        String s = ((PackageInfo) (context)).versionName;
_L4:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_399;
        }
        context = (new StringBuilder()).append("openuuid=").append(((String) (obj))).toString();
        context = (new StringBuilder()).append(context).append("&appid=").append("pipcam").toString();
        obj = (new StringBuilder()).append(context).append("&os=").append("android").toString();
        context = ((Context) (obj));
        if (s6 == null)
        {
            break MISSING_BLOCK_LABEL_199;
        }
        context = (new StringBuilder()).append(((String) (obj))).append("&deviceToken=").append(s6).toString();
        obj = context;
        if (s5 == null)
        {
            break MISSING_BLOCK_LABEL_231;
        }
        obj = (new StringBuilder()).append(context).append("&devicetype=").append(s5).toString();
        context = ((Context) (obj));
        if (s4 == null)
        {
            break MISSING_BLOCK_LABEL_263;
        }
        context = (new StringBuilder()).append(((String) (obj))).append("&langcode=").append(s4).toString();
        obj = context;
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_295;
        }
        obj = (new StringBuilder()).append(context).append("&countrycode=").append(s3).toString();
        context = ((Context) (obj));
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_327;
        }
        context = (new StringBuilder()).append(((String) (obj))).append("&prelang=").append(s2).toString();
        obj = context;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_357;
        }
        obj = (new StringBuilder()).append(context).append("&ver=").append(s).toString();
        if (s1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        try
        {
            return (new StringBuilder()).append(((String) (obj))).append("&deviceVersion=").append(s1).toString();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Crashlytics.logException(context);
        }
        break MISSING_BLOCK_LABEL_406;
        context;
        context.printStackTrace();
        Crashlytics.logException(context);
        context = null;
        continue; /* Loop/switch isn't completed */
        return null;
        return null;
_L2:
        s = null;
        if (true) goto _L4; else goto _L3
_L3:
        return ((String) (obj));
        if (true) goto _L6; else goto _L5
_L5:
    }
}
