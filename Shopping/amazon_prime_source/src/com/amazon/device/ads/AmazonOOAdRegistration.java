// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.device.ads:
//            AmazonOOAdRegistrationExecutor, AmazonOOAdPreferencesURLListener, AmazonOOAdRegistrationListener, AmazonOOAppEvent, 
//            AdvertisingIdentifier, Settings, MobileAdsInfoStore, DeviceInfo, 
//            RegistrationInfo, Configuration, SystemTime

public class AmazonOOAdRegistration
{
    public static class AmazonOOAdRegistrationInfo
    {

        private final AdvertisingIdentifier.Info advertisingIdentifierInfo;
        private final AmazonOOAdRegistrationExecutor amazonOOAdRegistrationExecutor;
        private final Configuration configuration;
        private final MobileAdsInfoStore infoStore;
        private final Settings settings;
        private final SystemTime systemTime;

        private long getLastIdentifyUserWithSISTime()
        {
            return settings.getWrittenLong("amzn-ad-iu-last-checkin", 0L);
        }

        public String getAmazonDeviceID()
        {
            return advertisingIdentifierInfo.getSISDeviceIdentifier();
        }

        public String getDeviceInfoAsJSON()
        {
            return infoStore.getDeviceInfo().toJsonString();
        }

        public Map getDeviceInfoParams(boolean flag)
        {
            DeviceInfo deviceinfo;
            HashMap hashmap;
label0:
            {
                deviceinfo = infoStore.getDeviceInfo();
                RegistrationInfo registrationinfo = infoStore.getRegistrationInfo();
                hashmap = new HashMap();
                amazonOOAdRegistrationExecutor.addParam(hashmap, "dt", deviceinfo.getDeviceType(), flag);
                amazonOOAdRegistrationExecutor.addParam(hashmap, "app", registrationinfo.getAppName(), flag);
                amazonOOAdRegistrationExecutor.addParam(hashmap, "aud", configuration.getString(Configuration.ConfigOption.SIS_DOMAIN), flag);
                amazonOOAdRegistrationExecutor.addParam(hashmap, "appId", registrationinfo.getAppKey(), flag);
                if (advertisingIdentifierInfo.canDo())
                {
                    if (!advertisingIdentifierInfo.hasAdvertisingIdentifier())
                    {
                        break label0;
                    }
                    amazonOOAdRegistrationExecutor.addParam(hashmap, "idfa", advertisingIdentifierInfo.getAdvertisingIdentifier(), flag);
                    amazonOOAdRegistrationExecutor.addParam(hashmap, "oo", Boolean.toString(advertisingIdentifierInfo.isLimitAdTrackingEnabled()), flag);
                }
                return hashmap;
            }
            amazonOOAdRegistrationExecutor.addParam(hashmap, "sha1_mac", deviceinfo.getMacSha1(), flag);
            amazonOOAdRegistrationExecutor.addParam(hashmap, "sha1_serial", deviceinfo.getSerialSha1(), flag);
            amazonOOAdRegistrationExecutor.addParam(hashmap, "sha1_udid", deviceinfo.getUdidSha1(), flag);
            return hashmap;
        }

        public boolean shouldIdentifyUser()
        {
            return systemTime.currentTimeMillis() - getLastIdentifyUserWithSISTime() > configuration.getLong(Configuration.ConfigOption.IDENTIFY_USER_INTERVAL);
        }

        AmazonOOAdRegistrationInfo(AdvertisingIdentifier advertisingidentifier, MobileAdsInfoStore mobileadsinfostore, Settings settings1, Configuration configuration1, SystemTime systemtime, AmazonOOAdRegistrationExecutor amazonooadregistrationexecutor)
        {
            advertisingIdentifierInfo = advertisingidentifier.getAdvertisingIdentifierInfo();
            infoStore = mobileadsinfostore;
            settings = settings1;
            configuration = configuration1;
            systemTime = systemtime;
            amazonOOAdRegistrationExecutor = amazonooadregistrationexecutor;
        }
    }


    private static final AmazonOOAdRegistrationExecutor executor = new AmazonOOAdRegistrationExecutor();

    public AmazonOOAdRegistration()
    {
    }

    public static final void enableLogging(boolean flag)
    {
        executor.enableLogging(flag);
    }

    public static void enableTLS(boolean flag)
    {
        executor.enableTLS(flag);
    }

    public static final void enableTesting(boolean flag)
    {
        executor.enableTesting(flag);
    }

    public static void fetchAdPreferencesURL(AmazonOOAdPreferencesURLListener amazonooadpreferencesurllistener)
    {
        executor.fetchAdPreferencesURL(amazonooadpreferencesurllistener);
    }

    static AmazonOOAdRegistrationExecutor getAmazonOOAdRegistrationExecutor()
    {
        return executor;
    }

    public static Map getDeviceNativeParams()
    {
        return executor.getDeviceNativeParams();
    }

    public static final String getVersion()
    {
        return executor.getVersion();
    }

    public static void identifyAmazonUserUsingDMS(Context context, String s, String s1)
    {
        executor.identifyAmazonUserUsingDMS(context, s, s1);
    }

    public static void identifyAmazonUserUsingMAP()
    {
        executor.identifyAmazonUserUsingMAP();
    }

    public static void identifyAmazonUserUsingSessionId(String s)
    {
        executor.identifyAmazonUserUsingSessionId(s);
    }

    public static final void listenForRegistrationInfo(AmazonOOAdRegistrationListener amazonooadregistrationlistener)
    {
        executor.listenForRegistrationInfo(amazonooadregistrationlistener);
    }

    public static final void prepareRegistrationInfo(Context context)
    {
        executor.prepareRegistrationInfo(context);
    }

    public static final void prepareRegistrationInfo(Context context, AmazonOOAdRegistrationListener amazonooadregistrationlistener)
    {
        executor.prepareRegistrationInfo(context, amazonooadregistrationlistener);
    }

    public static final void registerApp(Context context)
    {
        executor.registerApp(context);
    }

    public static final void registerApp(Context context, AmazonOOAdRegistrationListener amazonooadregistrationlistener)
    {
        executor.registerApp(context, amazonooadregistrationlistener);
    }

    public static void registerEvent(Context context, AmazonOOAppEvent amazonooappevent)
    {
        executor.registerEvent(context, amazonooappevent);
    }

    public static void setAppDefinedMarketplace(String s)
    {
        executor.setAppDefinedMarketplace(s);
    }

    public static final void setAppKey(String s)
        throws IllegalArgumentException
    {
        executor.setAppKey(s);
    }

    public static void setAppName(String s)
    {
        executor.setAppName(s);
    }

    public static void setReferrer(Context context, String s)
    {
        executor.setReferrer(context, s);
    }

    public static void setShouldPauseWebViewTimersInWebViewRelatedActivities(Context context, boolean flag)
    {
        executor.setShouldPauseWebViewTimersInWebViewRelatedActivities(context, flag);
    }

    public static void updateLastIdentifyUserWithSISTime(Context context)
    {
        executor.updateLastIdentifyUserWithSISTime(context);
    }

}
