// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.init;

import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.android.api.experimentation.WeblabClient;

// Referenced classes of package com.amazon.retailsearch.android.api.init:
//            RetailSearchAppType

public class RetailSearchInitSettings
{

    private boolean appStoreEnabled;
    private RetailSearchAppType appType;
    private String appVersion;
    private String configId;
    private String dataVersion;
    private boolean debugMode;
    private String deviceId;
    private FeatureConfiguration featureConfiguration;
    private boolean isFirePhone;
    private String obsfucatedMarketplaceId;
    private String userAgent;
    private WeblabClient weblabClient;

    public RetailSearchInitSettings()
    {
        appStoreEnabled = false;
        isFirePhone = false;
    }

    public RetailSearchAppType getAppType()
    {
        return appType;
    }

    public String getAppVersion()
    {
        return appVersion;
    }

    public String getConfigId()
    {
        return configId;
    }

    public String getDataVersion()
    {
        return dataVersion;
    }

    public String getDeviceId()
    {
        return deviceId;
    }

    public FeatureConfiguration getFeatureConfiguration()
    {
        return featureConfiguration;
    }

    public String getObsfucatedMarketplaceId()
    {
        return obsfucatedMarketplaceId;
    }

    public String getUserAgent()
    {
        return userAgent;
    }

    public WeblabClient getWeblabClient()
    {
        return weblabClient;
    }

    public boolean isAppStoreEnabled()
    {
        return appStoreEnabled;
    }

    public boolean isDebugMode()
    {
        return debugMode;
    }

    public boolean isFirePhone()
    {
        return isFirePhone;
    }

    public void setAppStoreEnabled(boolean flag)
    {
        appStoreEnabled = flag;
    }

    public void setAppType(RetailSearchAppType retailsearchapptype)
    {
        appType = retailsearchapptype;
    }

    public void setAppVersion(String s)
    {
        appVersion = s;
    }

    public void setConfigId(String s)
    {
        configId = s;
    }

    public void setDataVersion(String s)
    {
        dataVersion = s;
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

    public void setFirePhone(boolean flag)
    {
        isFirePhone = flag;
    }

    public void setObsfucatedMarketplaceId(String s)
    {
        obsfucatedMarketplaceId = s;
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
