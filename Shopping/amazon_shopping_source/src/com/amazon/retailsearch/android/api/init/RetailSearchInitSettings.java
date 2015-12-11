// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.init;

import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.android.api.experimentation.WeblabClient;

public class RetailSearchInitSettings
{

    private String appVersion;
    private boolean debugMode;
    private String deviceId;
    private FeatureConfiguration featureConfiguration;
    private String userAgent;
    private WeblabClient weblabClient;

    public RetailSearchInitSettings()
    {
    }

    public String getAppVersion()
    {
        return appVersion;
    }

    public String getDeviceId()
    {
        return deviceId;
    }

    public FeatureConfiguration getFeatureConfiguration()
    {
        return featureConfiguration;
    }

    public String getUserAgent()
    {
        return userAgent;
    }

    public WeblabClient getWeblabClient()
    {
        return weblabClient;
    }

    public boolean isDebugMode()
    {
        return debugMode;
    }

    public void setAppVersion(String s)
    {
        appVersion = s;
    }

    public void setDebugMode(boolean flag)
    {
        debugMode = flag;
    }

    public void setDeviceId(String s)
    {
        deviceId = s;
    }

    public void setFeatureConfiguration(FeatureConfiguration featureconfiguration)
    {
        featureConfiguration = featureconfiguration;
    }

    public void setUserAgent(String s)
    {
        userAgent = s;
    }

    public void setWeblabClient(WeblabClient weblabclient)
    {
        weblabClient = weblabclient;
    }
}
