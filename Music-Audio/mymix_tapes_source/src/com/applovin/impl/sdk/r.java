// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.applovin.sdk.AppLovinLogger;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Locale;

// Referenced classes of package com.applovin.impl.sdk:
//            AppLovinSdkImpl, u, t, s

class r
{

    private final AppLovinSdkImpl a;
    private final Context b;
    private final AppLovinLogger c;

    r(AppLovinSdkImpl applovinsdkimpl)
    {
        if (applovinsdkimpl == null)
        {
            throw new IllegalArgumentException("No sdk specified");
        } else
        {
            a = applovinsdkimpl;
            c = applovinsdkimpl.getLogger();
            b = applovinsdkimpl.getApplicationContext();
            return;
        }
    }

    static boolean a(String s1, Context context)
    {
        if (s1 == null)
        {
            throw new IllegalArgumentException("No permission name specified");
        }
        if (context == null)
        {
            throw new IllegalArgumentException("No context specified");
        }
        return context.getPackageManager().checkPermission(s1, context.getPackageName()) == 0;
    }

    u a()
    {
        u u1 = new u();
        u1.h = Locale.getDefault();
        u1.a = Build.MODEL;
        u1.b = android.os.Build.VERSION.RELEASE;
        u1.c = Build.MANUFACTURER;
        u1.e = android.os.Build.VERSION.SDK_INT;
        u1.d = Build.DEVICE;
        if (a("android.permission.READ_PHONE_STATE"))
        {
            Object obj = (TelephonyManager)b.getSystemService("phone");
            if (obj != null)
            {
                u1.f = ((TelephonyManager) (obj)).getSimCountryIso().toUpperCase(Locale.ENGLISH);
                obj = ((TelephonyManager) (obj)).getNetworkOperatorName();
                try
                {
                    u1.g = URLEncoder.encode(((String) (obj)), "UTF-8");
                }
                catch (UnsupportedEncodingException unsupportedencodingexception)
                {
                    u1.g = ((String) (obj));
                    return u1;
                }
            }
        }
        return u1;
    }

    boolean a(String s1)
    {
        return a(s1, b);
    }

    t b()
    {
        Object obj;
        ApplicationInfo applicationinfo;
        PackageManager packagemanager;
        long l;
        applicationinfo = b.getApplicationInfo();
        l = (new File(applicationinfo.sourceDir)).lastModified();
        packagemanager = b.getPackageManager();
        obj = null;
        PackageInfo packageinfo = packagemanager.getPackageInfo(b.getPackageName(), 0);
        obj = packageinfo;
_L2:
        t t1 = new t();
        t1.c = applicationinfo.packageName;
        t1.d = l;
        t1.a = String.valueOf(packagemanager.getApplicationLabel(applicationinfo));
        if (obj != null)
        {
            obj = ((PackageInfo) (obj)).versionName;
        } else
        {
            obj = "";
        }
        t1.b = ((String) (obj));
        return t1;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    s c()
    {
        Object obj = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        obj = ((Class) (obj)).getMethod("getAdvertisingIdInfo", new Class[] {
            android/content/Context
        }).invoke(null, new Object[] {
            b
        });
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        Object obj2;
        Object obj3;
        obj3 = obj.getClass();
        obj2 = ((Class) (obj3)).getMethod("isLimitAdTrackingEnabled", null).invoke(obj, null);
        obj = ((Class) (obj3)).getMethod("getId", null).invoke(obj, null);
        obj3 = new s();
        obj = (String)obj;
        if (obj == null)
        {
            obj = "";
        }
        obj3.a = ((Boolean)obj2).booleanValue();
        obj3.b = ((String) (obj));
        return ((s) (obj3));
        Object obj1;
        obj1;
        c.userError("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }", ((Throwable) (obj1)));
_L2:
        s s1 = new s();
        s1.b = "";
        s1.a = false;
        return s1;
        s1;
        c.e("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }", s1);
        if (true) goto _L2; else goto _L1
_L1:
    }
}
