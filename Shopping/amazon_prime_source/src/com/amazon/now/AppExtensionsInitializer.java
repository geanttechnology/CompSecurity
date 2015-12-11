// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now;

import android.content.Context;
import com.amazon.now.location.Location;
import com.amazon.now.platform.AndroidPlatform;
import com.amazon.now.util.AppUtils;
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
            return "C";
        }

        public boolean isFeatureActivated(String s)
        {
            return false;
        }

        private AppFeatureConfiguration()
        {
        }

    }

    private static class AppWeblabClient
        implements WeblabClient
    {

        private boolean isSparkleFeature(String s)
        {
            return s.contains("Android_Sparkle");
        }

        public String getTreatment(String s)
        {
            return "C";
        }

        public String getTreatmentAndTrigger(String s)
        {
            if (isSparkleFeature(s))
            {
                return "T1";
            } else
            {
                return "C";
            }
        }

        public void postFeatureTrigger(String s)
        {
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
        retailsearchinitsettings.setDebugMode(AppUtils.isAppDebuggable(context));
        retailsearchinitsettings.setFeatureConfiguration(new AppFeatureConfiguration());
        retailsearchinitsettings.setWeblabClient(new AppWeblabClient());
        retailsearchinitsettings.setUserAgent(AndroidPlatform.getInstance().getUserAgent());
        retailsearchinitsettings.setAppVersion(AndroidPlatform.getInstance().getApplicationVersion());
        retailsearchinitsettings.setConfigId("houdini");
        if (Location.isSet())
        {
            retailsearchinitsettings.setObsfucatedMarketplaceId(Location.getMarketplace());
        }
        RetailSearchInitializer.getInstance().initialize(context, retailsearchinitsettings);
    }

    public static void setMarketplace(String s)
    {
        RetailSearchInitializer.getInstance().reset(s);
    }
}
