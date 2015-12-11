// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mobileads;

import android.content.Context;
import com.amazon.device.ads.AmazonOOAdRegistration;
import com.amazon.device.ads.AmazonOOAppEvent;
import com.amazon.now.location.LocaleManager;
import com.amazon.now.util.AppUtils;
import java.util.Locale;

// Referenced classes of package com.amazon.now.mobileads:
//            AdsHelper

static final class val.context
    implements Runnable
{

    final Context val$context;

    public void run()
    {
        AmazonOOAdRegistration.enableLogging(AppUtils.isAppDebuggable(val$context));
        AmazonOOAdRegistration.setAppName("primenow");
        AmazonOOAdRegistration.setAppKey("31ab0985655f496e8c08952dc3275002");
        AmazonOOAdRegistration.setAppDefinedMarketplace(LocaleManager.getInstance().getLocale().getCountry());
        AmazonOOAdRegistration.registerApp(val$context);
        AmazonOOAdRegistration.identifyAmazonUserUsingMAP();
        if (!AdsHelper.access$000())
        {
            AmazonOOAdRegistration.registerEvent(val$context, AmazonOOAppEvent.createAppEventWithTimestamp(AmazonOOAppEvent.FIRST_LOGIN, System.currentTimeMillis()));
        }
    }

    t(Context context1)
    {
        val$context = context1;
        super();
    }
}
