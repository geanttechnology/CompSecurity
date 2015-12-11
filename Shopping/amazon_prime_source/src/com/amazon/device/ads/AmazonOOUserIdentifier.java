// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            StartUpWaiter, UserIdentifier, AdvertisingIdentifier, MobileAdsInfoStore, 
//            Configuration, WebRequest, DebugProperties, JSONUtils, 
//            RegistrationInfo, Version, DeviceInfo, AppInfo, 
//            TrustedPackageManager, Settings, SystemTime

abstract class AmazonOOUserIdentifier extends StartUpWaiter
    implements UserIdentifier
{
    static interface IdentifyUserListener
    {

        public abstract void userIdentified();
    }


    private static ReentrantLock serviceCallLock = new ReentrantLock();
    private final AdvertisingIdentifier advertisingIdentifier;
    private AdvertisingIdentifier.Info advertisingIdentifierInfo;
    private final Configuration configuration;
    private final DebugProperties debugProperties;
    private MobileAdsInfoStore infoStore;
    private final ArrayList listeners = new ArrayList();
    private final Settings settings;
    private final SystemTime systemTime;
    private final TrustedPackageManager trustedPackageManager;

    AmazonOOUserIdentifier(AdvertisingIdentifier advertisingidentifier, Configuration configuration1, Settings settings1, TrustedPackageManager trustedpackagemanager, SystemTime systemtime, DebugProperties debugproperties)
    {
        super(settings1, configuration1);
        advertisingIdentifier = advertisingidentifier;
        configuration = configuration1;
        settings = settings1;
        trustedPackageManager = trustedpackagemanager;
        systemTime = systemtime;
        debugProperties = debugproperties;
    }

    private void notifyListeners()
    {
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((IdentifyUserListener)iterator.next()).userIdentified()) { }
    }

    public void addIdentifyUserListener(IdentifyUserListener identifyuserlistener)
    {
        listeners.add(identifyuserlistener);
    }

    public void executeRequest()
    {
        start();
    }

    protected AdvertisingIdentifier.Info getAdvertisingIdentifierInfo()
    {
        if (advertisingIdentifierInfo == null)
        {
            advertisingIdentifierInfo = advertisingIdentifier.getAdvertisingIdentifierInfo();
        }
        return advertisingIdentifierInfo;
    }

    abstract void processExtraParameters(JSONObject jsonobject);

    public void setMobileAdsInfoStore(MobileAdsInfoStore mobileadsinfostore)
    {
        infoStore = mobileadsinfostore;
    }

    protected final void setParametersAndHost(WebRequest webrequest)
    {
        RegistrationInfo registrationinfo = infoStore.getRegistrationInfo();
        DeviceInfo deviceinfo = infoStore.getDeviceInfo();
        AppInfo appinfo = infoStore.getAppInfo();
        webrequest.setHost(configuration.getString(Configuration.ConfigOption.MADS_HOSTNAME));
        webrequest.setUseSecure(debugProperties.getDebugPropertyAsBoolean("debug.madsUseSecure", Boolean.valueOf(true)).booleanValue());
        JSONObject jsonobject = new JSONObject();
        JSONUtils.put(jsonobject, "dt", "android");
        JSONUtils.put(jsonobject, "app", registrationinfo.getAppName());
        JSONUtils.put(jsonobject, "aud", configuration.getString(Configuration.ConfigOption.SIS_DOMAIN));
        JSONUtils.put(jsonobject, "appId", registrationinfo.getAppKey());
        JSONUtils.put(jsonobject, "sdkVer", Version.getSDKVersion());
        if (getAdvertisingIdentifierInfo().hasAdvertisingIdentifier())
        {
            JSONUtils.put(jsonobject, "idfa", getAdvertisingIdentifierInfo().getAdvertisingIdentifier());
            JSONUtils.put(jsonobject, "oo", Boolean.toString(getAdvertisingIdentifierInfo().isLimitAdTrackingEnabled()));
        } else
        {
            JSONUtils.put(jsonobject, "shamac", deviceinfo.getMacSha1());
            JSONUtils.put(jsonobject, "shaudid", deviceinfo.getUdidSha1());
            JSONUtils.put(jsonobject, "shaserial", deviceinfo.getSerialSha1());
        }
        JSONUtils.put(jsonobject, "ua", deviceinfo.getUserAgentString());
        JSONUtils.put(jsonobject, "dinfo", deviceinfo.getDInfoProperty().toString());
        JSONUtils.put(jsonobject, "pkg", appinfo.getPackageInfoJSONString());
        JSONUtils.put(jsonobject, "pkgs", trustedPackageManager.getTrustedInstalledPackagesJSONArray().toString());
        processExtraParameters(jsonobject);
        webrequest.setRequestBodyString(jsonobject.toString());
    }

    protected void startUpFailed()
    {
    }

    protected void startUpReady()
    {
        if (!configuration.hasValue(Configuration.ConfigOption.MADS_HOSTNAME))
        {
            return;
        }
        serviceCallLock.lock();
        boolean flag = getAdvertisingIdentifierInfo().canDo();
        if (!flag)
        {
            serviceCallLock.unlock();
            return;
        }
        long l;
        long l1;
        l = settings.getWrittenLong("amzn-ad-iu-last-checkin", 0L);
        l1 = systemTime.currentTimeMillis();
        if (l1 > configuration.getLong(Configuration.ConfigOption.IDENTIFY_USER_INTERVAL) + l)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (debugProperties.getDebugPropertyAsBoolean("debug.shouldIdentifyUser", Boolean.valueOf(flag)).booleanValue() && identifyUser())
        {
            settings.putLong("amzn-ad-iu-last-checkin", l1);
            notifyListeners();
        }
        serviceCallLock.unlock();
        return;
        Exception exception;
        exception;
        serviceCallLock.unlock();
        throw exception;
    }

}
