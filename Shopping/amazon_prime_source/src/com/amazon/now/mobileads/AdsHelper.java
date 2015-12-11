// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mobileads;

import android.content.Context;
import com.amazon.device.ads.AmazonOOAdRegistration;
import com.amazon.device.ads.AmazonOOAppEvent;
import com.amazon.now.location.LocaleManager;
import com.amazon.now.util.AppUtils;
import com.amazon.now.util.DataStore;
import java.util.Locale;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AdsHelper
{

    private static final ScheduledThreadPoolExecutor sExecutor = new ScheduledThreadPoolExecutor(1);

    public AdsHelper()
    {
    }

    private static boolean hasRegisteredAds()
    {
        boolean flag = DataStore.getBoolean("keyHasRegisteredAds");
        if (!flag)
        {
            DataStore.putBoolean("keyHasRegisteredAds", true);
        }
        return flag;
    }

    public static void setup(Context context)
    {
        sExecutor.schedule(new Runnable(context) {

            final Context val$context;

            public void run()
            {
                AmazonOOAdRegistration.enableLogging(AppUtils.isAppDebuggable(context));
                AmazonOOAdRegistration.setAppName("primenow");
                AmazonOOAdRegistration.setAppKey("31ab0985655f496e8c08952dc3275002");
                AmazonOOAdRegistration.setAppDefinedMarketplace(LocaleManager.getInstance().getLocale().getCountry());
                AmazonOOAdRegistration.registerApp(context);
                AmazonOOAdRegistration.identifyAmazonUserUsingMAP();
                if (!AdsHelper.hasRegisteredAds())
                {
                    AmazonOOAdRegistration.registerEvent(context, AmazonOOAppEvent.createAppEventWithTimestamp(AmazonOOAppEvent.FIRST_LOGIN, System.currentTimeMillis()));
                }
            }

            
            {
                context = context1;
                super();
            }
        }, 10L, TimeUnit.SECONDS);
    }


}
