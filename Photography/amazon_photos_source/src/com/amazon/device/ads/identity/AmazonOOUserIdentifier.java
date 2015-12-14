// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads.identity:
//            StartUpWaiter, AdvertisingIdentifier, IAmazonRegistration, Configuration, 
//            WebRequest, DebugProperties, JSONUtils, RegistrationInfo, 
//            Version, DeviceInfo, AppInfo, TrustedPackageManager, 
//            Settings, SystemTime

abstract class AmazonOOUserIdentifier extends StartUpWaiter
{
    static interface IdentifyUserListener
    {

        public abstract void userIdentified();
    }


    private static ReentrantLock serviceCallLock = new ReentrantLock();
    private final AdvertisingIdentifier advertisingIdentifier;
    private AdvertisingIdentifier.Info advertisingIdentifierInfo;
    private IAmazonRegistration amazonRegistration;
    private boolean calledFromIdModule;
    private final Configuration configuration;
    private final DebugProperties debugProperties;
    private final ArrayList listeners = new ArrayList();
    private final Settings settings;
    private final SystemTime systemTime;
    private final TrustedPackageManager trustedPackageManager;

    AmazonOOUserIdentifier(AdvertisingIdentifier advertisingidentifier, Configuration configuration1, Settings settings1, TrustedPackageManager trustedpackagemanager, SystemTime systemtime, DebugProperties debugproperties)
    {
        super(settings1, configuration1);
        calledFromIdModule = false;
        advertisingIdentifier = advertisingidentifier;
        configuration = configuration1;
        settings = settings1;
        trustedPackageManager = trustedpackagemanager;
        systemTime = systemtime;
        debugProperties = debugproperties;
    }

    public void addIdentifyUserListener(IdentifyUserListener identifyuserlistener)
    {
        listeners.add(identifyuserlistener);
    }

    public abstract String getAccount();

    protected AdvertisingIdentifier.Info getAdvertisingIdentifierInfo()
    {
        if (advertisingIdentifierInfo == null)
        {
            advertisingIdentifierInfo = advertisingIdentifier.getAdvertisingIdentifierInfo();
        }
        return advertisingIdentifierInfo;
    }

    protected abstract boolean identifyUser();

    public void identifyUserFromIdModule()
    {
        calledFromIdModule = true;
        startUpReady();
    }

    public void setAmazonRegistration(IAmazonRegistration iamazonregistration)
    {
        amazonRegistration = iamazonregistration;
    }

    protected final void setParametersAndHost(WebRequest webrequest)
    {
        RegistrationInfo registrationinfo = amazonRegistration.getRegistrationInfo();
        DeviceInfo deviceinfo = amazonRegistration.getDeviceInfo();
        AppInfo appinfo = amazonRegistration.getAppInfo();
        webrequest.setHost(configuration.getString(Configuration.ConfigOption.MADS_HOSTNAME));
        webrequest.setUseSecure(debugProperties.getDebugPropertyAsBoolean("debug.madsUseSecure", true));
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
        if (calledFromIdModule)
        {
            try
            {
                jsonobject.put("idModule", true);
            }
            catch (JSONException jsonexception) { }
        }
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
        Exception exception;
        if (l1 > 0x5265c00L + l)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (debugProperties.getDebugPropertyAsBoolean("debug.shouldIdentifyUser", flag) && identifyUser())
        {
            settings.putLong("amzn-ad-iu-last-checkin", l1);
            for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((IdentifyUserListener)iterator.next()).userIdentified()) { }
        }
        break MISSING_BLOCK_LABEL_159;
        exception;
        serviceCallLock.unlock();
        throw exception;
        serviceCallLock.unlock();
        return;
    }

}
