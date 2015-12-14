// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinSdkUtils;

// Referenced classes of package com.applovin.impl.sdk:
//            AppLovinSdkImpl, bw, c, b, 
//            NativeAdImpl, bb, bz, r, 
//            cd, cr, cq, cb, 
//            a, y, bm

class cp
    implements Runnable
{

    private final AppLovinSdkImpl a;
    private final AppLovinLogger b;
    private final Context c;
    private final AppLovinSdkSettings d;

    cp(AppLovinSdkImpl applovinsdkimpl, AppLovinSdkSettings applovinsdksettings)
    {
        a = applovinsdkimpl;
        c = applovinsdkimpl.getApplicationContext();
        d = applovinsdksettings;
        b = applovinsdkimpl.getLogger();
    }

    private void c()
    {
        String s = (String)a.a(bw.J);
        if (s.length() > 0)
        {
            String as[] = s.split(",");
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                String s1 = as[i];
                a.c().d(new c(AppLovinAdSize.fromString(s1), AppLovinAdType.REGULAR));
            }

        }
        if (((Boolean)a.a(bw.K)).booleanValue())
        {
            a.c().d(new c(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED));
        }
        if (((Boolean)a.a(bw.aM)).booleanValue())
        {
            a.d().d(NativeAdImpl.SPEC_NATIVE);
        }
    }

    private void d()
    {
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(c);
        if (sharedpreferences.getInt("com.applovin.sdk.impl.lastKnownVersionCode", 0) >= 614) goto _L2; else goto _L1
_L1:
        Log.i("TaskInitializeSdk", "SDK has been updated since last run. Continuing...");
        a.getSettingsManager().d();
        a.getSettingsManager().b();
_L4:
        sharedpreferences.edit().putInt("com.applovin.sdk.impl.lastKnownVersionCode", 614).apply();
        return;
_L2:
        Log.d("TaskInitializeSdk", "SDK has not been updated since last run. Continuing...");
        if (true) goto _L4; else goto _L3
_L3:
        Object obj;
        obj;
        a.getLogger().e("TaskInitializeSdk", "Unable to check for SDK update", ((Throwable) (obj)));
        sharedpreferences.edit().putInt("com.applovin.sdk.impl.lastKnownVersionCode", 614).apply();
        return;
        obj;
        sharedpreferences.edit().putInt("com.applovin.sdk.impl.lastKnownVersionCode", 614).apply();
        throw obj;
    }

    boolean a()
    {
        if (!r.a("android.permission.INTERNET", c))
        {
            b.userError("TaskInitializeSdk", "Unable to enable AppLovin SDK: no android.permission.INTERNET");
            return false;
        } else
        {
            return true;
        }
    }

    void b()
    {
        cd cd1 = new cd(a);
        a.a().a(cd1, cr.a, 500L);
    }

    public void run()
    {
        long l;
        l = System.currentTimeMillis();
        b.d("TaskInitializeSdk", "Initializing AppLovin SDK 6.1.4...");
        if (!a())
        {
            break MISSING_BLOCK_LABEL_268;
        }
        d();
        Object obj = a.getSettingsManager();
        ((bz) (obj)).c();
        if (((Boolean)((bz) (obj)).a(bw.b)).booleanValue())
        {
            ((bz) (obj)).a(d);
            ((bz) (obj)).b();
        }
        obj = a.b();
        ((cb) (obj)).c();
        ((cb) (obj)).c("ad_imp_session");
        com.applovin.impl.sdk.a.b(a);
        a.getFileManager().d(c);
        c();
        b();
        obj = PreferenceManager.getDefaultSharedPreferences(c);
        if (!AppLovinSdkUtils.isValidString(((SharedPreferences) (obj)).getString("com.applovin.sdk.impl.isFirstRun", null)))
        {
            ((SharedPreferences) (obj)).edit().putString("com.applovin.sdk.impl.isFirstRun", Boolean.toString(true)).commit();
        }
        a.getPersistentPostbackManager().a();
        a.getEventService().trackEvent("landing");
        a.a(true);
_L1:
        Object obj1;
        AppLovinLogger applovinlogger = b;
        StringBuilder stringbuilder = (new StringBuilder()).append("AppLovin SDK 6.1.4 initialization ");
        if (a.isEnabled())
        {
            obj1 = "succeeded";
        } else
        {
            obj1 = "failed";
        }
        applovinlogger.d("TaskInitializeSdk", stringbuilder.append(((String) (obj1))).append(" in ").append(System.currentTimeMillis() - l).append("ms").toString());
        return;
        a.a(false);
          goto _L1
        obj1;
        b.e("TaskInitializeSdk", "Unable to intialize SDK, disabling the SDK", ((Throwable) (obj1)));
        a.a(false);
        applovinlogger = b;
        stringbuilder = (new StringBuilder()).append("AppLovin SDK 6.1.4 initialization ");
        if (a.isEnabled())
        {
            obj1 = "succeeded";
        } else
        {
            obj1 = "failed";
        }
        applovinlogger.d("TaskInitializeSdk", stringbuilder.append(((String) (obj1))).append(" in ").append(System.currentTimeMillis() - l).append("ms").toString());
        return;
        Exception exception;
        exception;
        AppLovinLogger applovinlogger1 = b;
        StringBuilder stringbuilder1 = (new StringBuilder()).append("AppLovin SDK 6.1.4 initialization ");
        String s;
        if (a.isEnabled())
        {
            s = "succeeded";
        } else
        {
            s = "failed";
        }
        applovinlogger1.d("TaskInitializeSdk", stringbuilder1.append(s).append(" in ").append(System.currentTimeMillis() - l).append("ms").toString());
        throw exception;
    }
}
