// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.amazon.device.ads:
//            StartUpWaiter, AdvertisingIdentifier, InternalAdRegistration, IInternalAdRegistration, 
//            Configuration, WebRequest, DebugProperties, RegistrationInfo, 
//            Version, DeviceInfo, SISDeviceRequest, Settings, 
//            Utils

abstract class AmazonOOUserIdentifier extends StartUpWaiter
{

    private static final int IU_SERVICE_CHECKIN_INTERVAL = 0x5265c00;
    private static final String IU_SERVICE_LAST_CHECKIN_PREF_NAME = "amzn-ad-iu-last-checkin";
    private static ReentrantLock serviceCallLock = new ReentrantLock();
    private AdvertisingIdentifier.Info advertisingIdentifierInfo;

    AmazonOOUserIdentifier()
    {
    }

    protected AdvertisingIdentifier.Info createAdvertisingIdentifierInfo()
    {
        return (new AdvertisingIdentifier()).getAdvertisingIdentifierInfo();
    }

    public void executeRequest()
    {
        start();
    }

    protected AdvertisingIdentifier.Info getAdvertisingIdentifierInfo()
    {
        return advertisingIdentifierInfo;
    }

    protected abstract boolean identifyUser();

    protected final void setParametersAndHost(WebRequest webrequest)
    {
        RegistrationInfo registrationinfo = InternalAdRegistration.getInstance().getRegistrationInfo();
        DeviceInfo deviceinfo = InternalAdRegistration.getInstance().getDeviceInfo();
        Configuration configuration = Configuration.getInstance();
        webrequest.setHost(configuration.getString(Configuration.ConfigOption.MADS_HOSTNAME));
        webrequest.setUseSecure(DebugProperties.getDebugPropertyAsBoolean("debug.madsUseSecure", true));
        webrequest.putUrlEncodedQueryParameter("dt", "android");
        webrequest.putUnencodedQueryParameter("app", registrationinfo.getAppName());
        webrequest.putUrlEncodedQueryParameter("aud", configuration.getString(Configuration.ConfigOption.SIS_DOMAIN));
        webrequest.putUnencodedQueryParameter("appId", registrationinfo.getAppKey());
        webrequest.putUrlEncodedQueryParameter("sdkVer", Version.getSDKVersion());
        if (getAdvertisingIdentifierInfo().hasAdvertisingIdentifier())
        {
            webrequest.putUrlEncodedQueryParameter("idfa", advertisingIdentifierInfo.getAdvertisingIdentifier());
            webrequest.putUrlEncodedQueryParameter("oo", Boolean.toString(advertisingIdentifierInfo.isLimitAdTrackingEnabled()));
        } else
        {
            webrequest.putUrlEncodedQueryParameter("sm", deviceinfo.getMacSha1());
            webrequest.putUrlEncodedQueryParameter("su", deviceinfo.getUdidSha1());
            webrequest.putUrlEncodedQueryParameter("ss", deviceinfo.getSerialSha1());
        }
        webrequest.putUnencodedQueryParameter("ua", DeviceInfo.getUserAgentString());
        webrequest.putUnencodedQueryParameter("di", SISDeviceRequest.getDInfoProperty());
    }

    protected void startUpFailed()
    {
    }

    protected void startUpReady()
    {
        serviceCallLock.lock();
        boolean flag;
        advertisingIdentifierInfo = createAdvertisingIdentifierInfo();
        flag = advertisingIdentifierInfo.canDo();
        if (!flag)
        {
            serviceCallLock.unlock();
            return;
        }
        Settings settings;
        long l;
        long l1;
        settings = Settings.getInstance();
        l = settings.getLong("amzn-ad-iu-last-checkin", 0L);
        l1 = System.currentTimeMillis();
        if (l1 > 0x5265c00L + l)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (DebugProperties.getDebugPropertyAsBoolean("debug.shouldIdentifyUser", flag) && !Utils.isNullOrWhiteSpace(Configuration.getInstance().getString(Configuration.ConfigOption.MADS_HOSTNAME)) && identifyUser())
        {
            settings.putLong("amzn-ad-iu-last-checkin", l1);
        }
        serviceCallLock.unlock();
        return;
        Exception exception;
        exception;
        serviceCallLock.unlock();
        throw exception;
    }

}
