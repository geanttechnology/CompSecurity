// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mobileads;

import android.content.Context;
import android.content.res.Resources;
import com.amazon.device.ads.AmazonOOAdPreferencesURLListener;
import com.amazon.device.ads.AmazonOOAdRegistration;
import com.amazon.device.ads.AmazonOOAdRegistrationListener;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonApplication;
import com.amazon.mShop.AmazonProgressDialog;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.SisUtil;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.mobileads:
//            DebugSettingsActivityForAds

public class AdsHelper
{

    private static final Map AUTH_LOCALE_MAP = new HashMap(8) {

            
            {
                put("en_US", "US");
                put("ja_JP", "JP");
                put("de_DE", "DE");
                put("fr_FR", "FR");
                put("en_GB", "UK");
            }
    };

    public AdsHelper()
    {
    }

    public static boolean isAdsClientConfigEnabled()
    {
        return ConfigUtils.isEnabled(com.amazon.mShop.android.lib.R.string.config_hasMobileAds);
    }

    public static boolean isAdsEnabled()
    {
        return ConfigUtils.isEnabled(com.amazon.mShop.android.lib.R.string.config_hasMobileAds);
    }

    public static void openUserPreferences(AmazonActivity amazonactivity)
    {
        Context context = (Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext();
        AmazonProgressDialog amazonprogressdialog = new AmazonProgressDialog(amazonactivity);
        amazonprogressdialog.setTitle(com.amazon.mShop.android.lib.R.string.web_view_loading);
        amazonprogressdialog.show();
        AmazonOOAdRegistration.prepareRegistrationInfo(context, new AmazonOOAdRegistrationListener(amazonprogressdialog, amazonactivity) {

            final AmazonActivity val$activity;
            final AmazonProgressDialog val$progressDialog;

            public void onRegistrationInfoReady(com.amazon.device.ads.AmazonOOAdRegistration.AmazonOOAdRegistrationInfo amazonooadregistrationinfo)
            {
                if (amazonooadregistrationinfo != null)
                {
                    AmazonOOAdRegistration.fetchAdPreferencesURL(new AmazonOOAdPreferencesURLListener() {

                        final _cls2 this$0;

                        public void onAdPreferencesURLFetched(String s)
                        {
                            progressDialog.dismiss();
                            ActivityUtils.startAdsWebActivity(activity, s);
                        }

            
            {
                this$0 = _cls2.this;
                super();
            }
                    });
                    return;
                } else
                {
                    progressDialog.dismiss();
                    return;
                }
            }

            
            {
                progressDialog = amazonprogressdialog;
                activity = amazonactivity;
                super();
            }
        });
    }

    private static void registerApp(Context context)
    {
        String s = ConfigUtils.getString(context, com.amazon.mShop.android.lib.R.string.config_mobileadsAppId);
        String s1 = context.getResources().getString(com.amazon.mShop.android.lib.R.string.config_mobileadsAppName);
        if (DebugSettings.isDebugEnabled())
        {
            AmazonOOAdRegistration.enableLogging(DebugSettingsActivityForAds.isLogging(context));
        }
        AmazonOOAdRegistration.setAppKey(s);
        AmazonOOAdRegistration.setAppName(s1);
        AmazonOOAdRegistration.setAppDefinedMarketplace((String)AUTH_LOCALE_MAP.get(AppLocale.getInstance().getCurrentLocaleName()));
        boolean flag;
        if (!AmazonApplication.isWebViewCacheEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        AmazonOOAdRegistration.setShouldPauseWebViewTimersInWebViewRelatedActivities(context, flag);
    }

    public static void resetIfNecessary(Context context)
    {
        if (isAdsClientConfigEnabled())
        {
            registerApp(context);
            SisUtil.reset(context);
        }
    }

}
