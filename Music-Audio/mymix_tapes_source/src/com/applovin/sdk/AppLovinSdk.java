// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.sdk;

import android.content.Context;
import android.util.Log;
import com.applovin.impl.sdk.AppLovinSdkImpl;
import com.applovin.nativeAds.AppLovinNativeAdService;

// Referenced classes of package com.applovin.sdk:
//            AppLovinSdkUtils, AppLovinSdkSettings, AppLovinAdService, AppLovinEventService, 
//            AppLovinLogger, AppLovinPostbackService, AppLovinTargetingData

public abstract class AppLovinSdk
{

    public static final String URI_HOST = "com.applovin.sdk";
    public static final String URI_SCHEME = "applovin";
    public static final String VERSION = "6.1.4";
    public static final int VERSION_CODE = 614;
    private static AppLovinSdk a[] = new AppLovinSdk[0];
    private static final Object b = new Object();

    public AppLovinSdk()
    {
    }

    public static AppLovinSdk getInstance(Context context)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("No context specified");
        } else
        {
            return getInstance(AppLovinSdkUtils.retrieveSdkKey(context), AppLovinSdkUtils.retrieveUserSettings(context), context);
        }
    }

    public static AppLovinSdk getInstance(AppLovinSdkSettings applovinsdksettings, Context context)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("No context specified");
        } else
        {
            return getInstance(AppLovinSdkUtils.retrieveSdkKey(context), applovinsdksettings, context);
        }
    }

    public static AppLovinSdk getInstance(String s, AppLovinSdkSettings applovinsdksettings, Context context)
    {
label0:
        {
            synchronized (b)
            {
                if (a.length != 1 || !a[0].getSdkKey().equals(s))
                {
                    break label0;
                }
                s = a[0];
            }
            return s;
        }
        AppLovinSdk aapplovinsdk[];
        int j;
        aapplovinsdk = a;
        j = aapplovinsdk.length;
        int i = 0;
_L2:
        AppLovinSdk applovinsdk;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        applovinsdk = aapplovinsdk[i];
        if (!applovinsdk.getSdkKey().equals(s))
        {
            break MISSING_BLOCK_LABEL_88;
        }
        obj;
        JVM INSTR monitorexit ;
        return applovinsdk;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        AppLovinSdkImpl applovinsdkimpl;
        applovinsdkimpl = new AppLovinSdkImpl();
        applovinsdkimpl.initialize(s, applovinsdksettings, context.getApplicationContext());
        s = new AppLovinSdk[a.length + 1];
        System.arraycopy(a, 0, s, 0, a.length);
        s[a.length] = applovinsdkimpl;
        a = s;
        obj;
        JVM INSTR monitorexit ;
        return applovinsdkimpl;
        s;
        Log.e("AppLovinSdk", "Failed to build AppLovin SDK. Try cleaning application data and starting the application again.", s);
        throw new RuntimeException("Unable to build AppLovin SDK");
    }

    public static void initializeSdk(Context context)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("No context specified");
        }
        context = getInstance(context);
        if (context != null)
        {
            context.initializeSdk();
            return;
        } else
        {
            Log.e("AppLovinSdk", "Unable to initialize AppLovin SDK: SDK object not created");
            return;
        }
    }

    public abstract AppLovinAdService getAdService();

    public abstract Context getApplicationContext();

    public abstract AppLovinEventService getEventService();

    public abstract AppLovinLogger getLogger();

    public abstract AppLovinNativeAdService getNativeAdService();

    public abstract AppLovinPostbackService getPostbackService();

    public abstract String getSdkKey();

    public abstract AppLovinSdkSettings getSettings();

    public abstract AppLovinTargetingData getTargetingData();

    public abstract boolean hasCriticalErrors();

    protected abstract void initialize(String s, AppLovinSdkSettings applovinsdksettings, Context context);

    public abstract void initializeSdk();

    public abstract boolean isEnabled();

    public abstract void setPluginVersion(String s);

}
