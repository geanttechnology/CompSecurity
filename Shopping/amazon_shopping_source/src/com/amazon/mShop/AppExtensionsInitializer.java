// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.content.Context;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.feature.Features;
import com.amazon.mShop.feature.WeblabCsmUtils;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.android.api.experimentation.WeblabClient;
import com.amazon.retailsearch.android.api.init.RetailSearchInitSettings;
import com.amazon.retailsearch.android.api.init.RetailSearchInitializer;

public class AppExtensionsInitializer
{
    private static class AppFeatureConfiguration
        implements FeatureConfiguration
    {

        public String getFeatureState(String s)
        {
            return Features.getInstance().getFeatureState(s);
        }

        public boolean isFeatureActivated(String s)
        {
            return Features.getInstance().isFeatureActivated(s);
        }

        private AppFeatureConfiguration()
        {
        }

    }

    private static class AppWeblabClient
        implements WeblabClient
    {

        public String getTreatment(String s)
        {
            return Features.getInstance().getFeatureState(s);
        }

        public void postFeatureTrigger(String s)
        {
            WeblabCsmUtils.postFeatureTrigger(s);
        }

        private AppWeblabClient()
        {
        }

    }


    public AppExtensionsInitializer()
    {
    }

    public static void initializeSearch(Context context)
    {
        RetailSearchInitSettings retailsearchinitsettings = new RetailSearchInitSettings();
        retailsearchinitsettings.setDebugMode(DebugSettings.isDebugEnabled());
        retailsearchinitsettings.setFeatureConfiguration(new AppFeatureConfiguration());
        retailsearchinitsettings.setWeblabClient(new AppWeblabClient());
        retailsearchinitsettings.setUserAgent(AndroidPlatform.getInstance().getUserAgent());
        retailsearchinitsettings.setAppVersion(AndroidPlatform.getInstance().getApplicationVersion());
        RetailSearchInitializer.getInstance().initialize(context, retailsearchinitsettings);
    }
}
