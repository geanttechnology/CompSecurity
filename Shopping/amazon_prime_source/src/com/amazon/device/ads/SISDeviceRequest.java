// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.HashMap;

// Referenced classes of package com.amazon.device.ads:
//            SISRequest, MobileAdsLoggerFactory, MobileAdsInfoStore, DeviceInfo, 
//            RegistrationInfo, Configuration, AppInfo, AdvertisingIdentifier, 
//            MobileAdsLogger

abstract class SISDeviceRequest
    implements SISRequest
{

    private AdvertisingIdentifier advertisingIdentifier;
    private AdvertisingIdentifier.Info advertisingIdentifierInfo;
    private Metrics.MetricType callMetricType;
    private String logTag;
    private final MobileAdsLogger logger;
    private String path;

    SISDeviceRequest()
    {
        logger = (new MobileAdsLoggerFactory()).createMobileAdsLogger(logTag);
    }

    private static String convertOptOutBooleanToStringInt(boolean flag)
    {
        if (flag)
        {
            return "1";
        } else
        {
            return "0";
        }
    }

    public static String getDInfoProperty()
    {
        DeviceInfo deviceinfo = MobileAdsInfoStore.getInstance().getDeviceInfo();
        return String.format("{\"make\":\"%s\",\"model\":\"%s\",\"os\":\"%s\",\"osVersion\":\"%s\"}", new Object[] {
            deviceinfo.getMake(), deviceinfo.getModel(), deviceinfo.getOS(), deviceinfo.getOSVersion()
        });
    }

    protected AdvertisingIdentifier.Info getAdvertisingIdentifierInfo()
    {
        return advertisingIdentifierInfo;
    }

    public Metrics.MetricType getCallMetricType()
    {
        return callMetricType;
    }

    public String getLogTag()
    {
        return logTag;
    }

    public MobileAdsLogger getLogger()
    {
        return logger;
    }

    public String getPath()
    {
        return path;
    }

    public HashMap getPostParameters()
    {
        return null;
    }

    public WebRequest.QueryStringParameters getQueryParameters()
    {
        WebRequest.QueryStringParameters querystringparameters = new WebRequest.QueryStringParameters();
        querystringparameters.putUrlEncoded("dt", MobileAdsInfoStore.getInstance().getDeviceInfo().getDeviceType());
        querystringparameters.putUrlEncoded("app", MobileAdsInfoStore.getInstance().getRegistrationInfo().getAppName());
        querystringparameters.putUrlEncoded("aud", Configuration.getInstance().getString(Configuration.ConfigOption.SIS_DOMAIN));
        querystringparameters.putUnencoded("ua", MobileAdsInfoStore.getInstance().getDeviceInfo().getUserAgentString());
        querystringparameters.putUnencoded("dinfo", getDInfoProperty());
        querystringparameters.putUnencoded("pkg", MobileAdsInfoStore.getInstance().getAppInfo().getPackageInfoJSONString());
        String s;
        boolean flag;
        if (advertisingIdentifierInfo.hasAdvertisingIdentifier())
        {
            querystringparameters.putUrlEncoded("idfa", advertisingIdentifierInfo.getAdvertisingIdentifier());
            querystringparameters.putUrlEncoded("oo", convertOptOutBooleanToStringInt(advertisingIdentifierInfo.isLimitAdTrackingEnabled()));
        } else
        {
            DeviceInfo deviceinfo = MobileAdsInfoStore.getInstance().getDeviceInfo();
            querystringparameters.putUrlEncoded("sha1_mac", deviceinfo.getMacSha1());
            querystringparameters.putUrlEncoded("sha1_serial", deviceinfo.getSerialSha1());
            querystringparameters.putUrlEncoded("sha1_udid", deviceinfo.getUdidSha1());
            querystringparameters.putUrlEncodedIfTrue("badMac", "true", deviceinfo.isMacBad());
            querystringparameters.putUrlEncodedIfTrue("badSerial", "true", deviceinfo.isSerialBad());
            querystringparameters.putUrlEncodedIfTrue("badUdid", "true", deviceinfo.isUdidBad());
        }
        s = advertisingIdentifier.getAndClearTransition();
        if (s != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        querystringparameters.putUrlEncodedIfTrue("aidts", s, flag);
        return querystringparameters;
    }

    public SISDeviceRequest setAdvertisingIdentifier(AdvertisingIdentifier advertisingidentifier)
    {
        advertisingIdentifier = advertisingidentifier;
        advertisingIdentifierInfo = advertisingIdentifier.getAdvertisingIdentifierInfo();
        return this;
    }

    public SISDeviceRequest setCallMetricType(Metrics.MetricType metrictype)
    {
        callMetricType = metrictype;
        return this;
    }

    public SISDeviceRequest setLogTag(String s)
    {
        logTag = s;
        logger.withLogTag(s);
        return this;
    }

    public SISDeviceRequest setPath(String s)
    {
        path = s;
        return this;
    }
}
