// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.device.ads:
//            Configuration, Log, Utils, Settings, 
//            DeviceInfo, Version, PermissionChecker, AmazonOODMSUserIdentifier, 
//            InternalAdRegistration, IInternalAdRegistration, AmazonOOMAPUserIdentifier, AmazonOOAppEvent, 
//            AppEventRegistrationHandler, RegistrationInfo, AppEvent, ThreadUtils, 
//            AmazonOOMAPPreferredMarketplaceRetriever, ReflectionUtils, AmazonOOAdPreferencesURLListener, AmazonOOAdRegistrationListener, 
//            PreferredMarketplaceRetriever, StartUpWaiter, AdvertisingIdentifier

public class AmazonOOAdRegistration
{
    private static class AdPreferencesURLFetcher extends StartUpWaiter
    {

        private AmazonOOAdPreferencesURLListener listener;

        private void onFetched(String s)
        {
            (new Handler(Looper.getMainLooper())).post(s. new Runnable() {

                final AdPreferencesURLFetcher this$0;
                final String val$adPreferencesURL;

                public void run()
                {
                    listener.onAdPreferencesURLFetched(adPreferencesURL);
                }

            
            {
                this$0 = final_adpreferencesurlfetcher;
                adPreferencesURL = String.this;
                super();
            }
            });
        }

        protected void startUpFailed()
        {
            onFetched(null);
        }

        protected void startUpReady()
        {
            AdvertisingIdentifier.Info info = (new AdvertisingIdentifier()).getAdvertisingIdentifierInfo();
            String s = Configuration.getInstance().getString(Configuration.ConfigOption.AD_PREF_URL);
            StringBuilder stringbuilder = new StringBuilder(s);
            if (s.indexOf('?') == -1)
            {
                stringbuilder.append("?");
            } else
            {
                stringbuilder.append("&");
            }
            stringbuilder.append("adId=");
            s = info.getSISDeviceIdentifier();
            if (!info.hasSISDeviceIdentifier())
            {
                Log.w("AmazonOOAdRegistration", "Ad-id not found, using blank");
                s = "";
            }
            stringbuilder.append(Utils.getURLEncodedString(s));
            stringbuilder.append("&appId=");
            stringbuilder.append(Utils.getURLEncodedString(InternalAdRegistration.getInstance().getRegistrationInfo().getAppKey()));
            onFetched(stringbuilder.toString());
        }


        protected AdPreferencesURLFetcher(AmazonOOAdPreferencesURLListener amazonooadpreferencesurllistener)
        {
            listener = amazonooadpreferencesurllistener;
        }
    }

    public static class AmazonOOAdRegistrationInfo
    {

        private final AdvertisingIdentifier.Info advertisingIdentifierInfo = (new AdvertisingIdentifier()).getAdvertisingIdentifierInfo();

        protected static AmazonOOAdRegistrationInfo getAmazonOOAdRegistrationInfo()
        {
            return new AmazonOOAdRegistrationInfo();
        }

        private long getLastIdentifyUserWithSISTime()
        {
            if (AmazonOOAdRegistration.sLastIdentifyUserWithSisTime <= 0L)
            {
                AmazonOOAdRegistration.sLastIdentifyUserWithSisTime = Settings.getInstance().getLong("lastIdentifyUserWithSisTime", 0L);
            }
            return AmazonOOAdRegistration.sLastIdentifyUserWithSisTime;
        }

        public String getAmazonDeviceID()
        {
            return advertisingIdentifierInfo.getSISDeviceIdentifier();
        }

        public String getDeviceInfoAsJSON()
        {
            return InternalAdRegistration.getInstance().getDeviceInfo().toJsonString();
        }

        public Map getDeviceInfoParams(boolean flag)
        {
            DeviceInfo deviceinfo;
            HashMap hashmap;
label0:
            {
                deviceinfo = InternalAdRegistration.getInstance().getDeviceInfo();
                RegistrationInfo registrationinfo = InternalAdRegistration.getInstance().getRegistrationInfo();
                hashmap = new HashMap();
                AmazonOOAdRegistration.addParam(hashmap, "dt", DeviceInfo.getDeviceType(), flag);
                AmazonOOAdRegistration.addParam(hashmap, "app", registrationinfo.getAppName(), flag);
                AmazonOOAdRegistration.addParam(hashmap, "aud", Configuration.getInstance().getString(Configuration.ConfigOption.SIS_DOMAIN), flag);
                AmazonOOAdRegistration.addParam(hashmap, "appId", registrationinfo.getAppKey(), flag);
                if (advertisingIdentifierInfo.canDo())
                {
                    if (!advertisingIdentifierInfo.hasAdvertisingIdentifier())
                    {
                        break label0;
                    }
                    AmazonOOAdRegistration.addParam(hashmap, "idfa", advertisingIdentifierInfo.getAdvertisingIdentifier(), flag);
                    AmazonOOAdRegistration.addParam(hashmap, "oo", Boolean.toString(advertisingIdentifierInfo.isLimitAdTrackingEnabled()), flag);
                }
                return hashmap;
            }
            AmazonOOAdRegistration.addParam(hashmap, "sha1_mac", deviceinfo.getMacSha1(), flag);
            AmazonOOAdRegistration.addParam(hashmap, "md5_mac", deviceinfo.getMacMd5(), flag);
            AmazonOOAdRegistration.addParam(hashmap, "sha1_serial", deviceinfo.getSerialSha1(), flag);
            AmazonOOAdRegistration.addParam(hashmap, "md5_serial", deviceinfo.getSerialMd5(), flag);
            AmazonOOAdRegistration.addParam(hashmap, "sha1_udid", deviceinfo.getUdidSha1(), flag);
            AmazonOOAdRegistration.addParam(hashmap, "md5_udid", deviceinfo.getUdidMd5(), flag);
            return hashmap;
        }

        public boolean shouldIdentifyUser()
        {
            return System.currentTimeMillis() - getLastIdentifyUserWithSISTime() > 0x1b77400L;
        }

        private AmazonOOAdRegistrationInfo()
        {
        }
    }

    private static class AmazonOOStartUpWaiter extends StartUpWaiter
    {

        private final AmazonOOAdRegistrationListener listener;

        protected void startUpFailed()
        {
            listener.onRegistrationInfoReady(AmazonOOAdRegistrationInfo.getAmazonOOAdRegistrationInfo());
        }

        protected void startUpReady()
        {
            listener.onRegistrationInfoReady(AmazonOOAdRegistrationInfo.getAmazonOOAdRegistrationInfo());
        }

        public AmazonOOStartUpWaiter(AmazonOOAdRegistrationListener amazonooadregistrationlistener)
        {
            listener = amazonooadregistrationlistener;
        }
    }


    protected static final long IDENTIFY_USER_WITH_SIS_INTERVAL_MSEC = 0x1b77400L;
    protected static final String LAST_IDENTIFY_USER_WITH_SIS_TIME_KEY = "lastIdentifyUserWithSisTime";
    private static final String LOG_TAG = "AmazonOOAdRegistration";
    private static AmazonOOAdRegistration instance = new AmazonOOAdRegistration();
    protected static long sLastIdentifyUserWithSisTime = 0L;

    AmazonOOAdRegistration()
    {
        Configuration.getInstance().setIsFirstParty(true);
        if (isMAPLibraryAvailable())
        {
            Configuration.getInstance().setPreferredMarketplaceRetriever(createPreferredMarketplaceRetriever());
            return;
        } else
        {
            Log.d("AmazonOOAdRegistration", "MAP Library not available");
            return;
        }
    }

    private static void addParam(HashMap hashmap, String s, String s1, boolean flag)
    {
        if (s1 != null)
        {
            hashmap.put(s, decodeIfNeeded(flag, s1));
        }
    }

    private static String decodeIfNeeded(boolean flag, String s)
    {
        String s1 = s;
        if (flag)
        {
            s1 = Utils.getURLDecodedString(s);
        }
        return s1;
    }

    public static final void enableLogging(boolean flag)
    {
        Log.enableLoggingWithSetterNotification("AmazonOOAdRegistration", flag);
    }

    public static void enableTLS(boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            Settings.getInstance().putTransientBoolean("tlsEnabled", flag);
            String s;
            if (flag)
            {
                s = "enabled";
            } else
            {
                s = "disabled";
            }
            Log.i(true, "AmazonOOAdRegistration", "Transport Layer Security %s by default.", new Object[] {
                s
            });
            return;
        } else
        {
            Log.i(true, "AmazonOOAdRegistration", "Enabling Transport Layer Security is only supported on Android API Level 8 and higher.");
            return;
        }
    }

    public static final void enableTesting(boolean flag)
    {
        Settings.getInstance().putTransientBoolean("testingEnabled", flag);
        Log.logSetterNotification("AmazonOOAdRegistration", "Test mode", Boolean.valueOf(flag));
    }

    public static void fetchAdPreferencesURL(AmazonOOAdPreferencesURLListener amazonooadpreferencesurllistener)
    {
        (new AdPreferencesURLFetcher(amazonooadpreferencesurllistener)).start();
    }

    public static Map getDeviceNativeParams()
    {
        HashMap hashmap = new HashMap();
        addParam(hashmap, "os", DeviceInfo.getOS(), false);
        addParam(hashmap, "model", DeviceInfo.getModel(), false);
        addParam(hashmap, "make", DeviceInfo.getMake(), false);
        addParam(hashmap, "osVersion", DeviceInfo.getOSVersion(), false);
        return hashmap;
    }

    static AmazonOOAdRegistration getInstance()
    {
        return instance;
    }

    public static final String getVersion()
    {
        return Version.getSDKVersion();
    }

    public static void identifyAmazonUserUsingDMS(Context context, String s, String s1)
    {
        if (!PermissionChecker.getInstance().passesInternetPermissionCheck(context, "AmazonOOAdRegistration"))
        {
            return;
        } else
        {
            prepareRegistrationInfo(context);
            (new AmazonOODMSUserIdentifier(s, s1)).executeRequest();
            return;
        }
    }

    public static void identifyAmazonUserUsingMAP()
    {
        if (!InternalAdRegistration.getInstance().isRegistered())
        {
            throw new IllegalStateException("AmazonOOAdRegistration.registerApp must be called before identify user.");
        } else
        {
            (new AmazonOOMAPUserIdentifier()).executeRequest();
            return;
        }
    }

    public static final void listenForRegistrationInfo(AmazonOOAdRegistrationListener amazonooadregistrationlistener)
    {
        (new AmazonOOStartUpWaiter(amazonooadregistrationlistener)).start();
    }

    public static final void prepareRegistrationInfo(Context context)
    {
        InternalAdRegistration.getInstance().contextReceived(context);
    }

    public static final void prepareRegistrationInfo(Context context, AmazonOOAdRegistrationListener amazonooadregistrationlistener)
    {
        prepareRegistrationInfo(context);
        listenForRegistrationInfo(amazonooadregistrationlistener);
    }

    public static final void registerApp(Context context)
    {
        registerApp(context, null);
    }

    public static final void registerApp(Context context, AmazonOOAdRegistrationListener amazonooadregistrationlistener)
    {
        if (PermissionChecker.getInstance().passesInternetPermissionCheck(context, "AmazonOOAdRegistration"))
        {
            prepareRegistrationInfo(context);
            InternalAdRegistration.getInstance().register();
            if (amazonooadregistrationlistener != null)
            {
                listenForRegistrationInfo(amazonooadregistrationlistener);
                return;
            }
        }
    }

    public static void registerEvent(Context context, AmazonOOAppEvent amazonooappevent)
    {
        if (amazonooappevent == null)
        {
            Log.e("AmazonOOAdRegistration", "Application event was null. Could not register the application event.");
            return;
        }
        if (amazonooappevent.getEventName() == null || amazonooappevent.getEventName().equals(""))
        {
            Log.e("AmazonOOAdRegistration", "Event name should not be null or empty. Could not register the application event.");
            return;
        }
        if (amazonooappevent.getTimestamp() <= 0L)
        {
            Log.e("AmazonOOAdRegistration", "Invalid time stamp value for the event. Could not register the application event.");
            return;
        } else
        {
            prepareRegistrationInfo(context);
            AppEventRegistrationHandler.getInstance().addEventToAppEventsCacheFile(amazonooappevent);
            Log.logSetterNotification("AmazonOOAdRegistration", "New event", amazonooappevent.getEventName());
            return;
        }
    }

    public static void setAppDefinedMarketplace(String s)
    {
        Configuration.getInstance().setAppDefinedMarketplace(s);
    }

    public static final void setAppKey(String s)
        throws IllegalArgumentException
    {
        InternalAdRegistration.getInstance().getRegistrationInfo().putAppKey(s);
    }

    public static void setAppName(String s)
    {
        InternalAdRegistration.getInstance().getRegistrationInfo().putAppName(s);
    }

    public static final void setReferrer(Context context, String s)
    {
        if (Utils.isNullOrEmpty(s))
        {
            Log.e("AmazonOOAdRegistration", "Referrer was null or emtpy. Could not set the referrer.");
            return;
        } else
        {
            prepareRegistrationInfo(context);
            context = new AmazonOOAppEvent("INSTALL_REFERRER", System.currentTimeMillis());
            context.setProperty("referrer", s);
            AppEventRegistrationHandler.getInstance().addEventToAppEventsCacheFile(context);
            Log.logSetterNotification("AmazonOOAdRegistration", "Referrer", s);
            return;
        }
    }

    public static void setShouldPauseWebViewTimersInWebViewRelatedActivities(Context context, boolean flag)
    {
        prepareRegistrationInfo(context);
        Settings.getInstance().putBoolean("shouldPauseWebViewTimersInWebViewRelatedActivities", flag);
        Log.logSetterNotification("AmazonOOAdRegistration", "WebView timer pausing", Boolean.valueOf(flag));
    }

    public static void updateLastIdentifyUserWithSISTime(Context context)
    {
        sLastIdentifyUserWithSisTime = System.currentTimeMillis();
        ThreadUtils.executeRunnable(new Runnable(context) {

            final Context val$context;

            public void run()
            {
                AmazonOOAdRegistration.prepareRegistrationInfo(context);
                Settings.getInstance().putLong("lastIdentifyUserWithSisTime", AmazonOOAdRegistration.sLastIdentifyUserWithSisTime);
            }

            
            {
                context = context1;
                super();
            }
        });
    }

    PreferredMarketplaceRetriever createPreferredMarketplaceRetriever()
    {
        AmazonOOMAPPreferredMarketplaceRetriever amazonoomappreferredmarketplaceretriever;
        try
        {
            amazonoomappreferredmarketplaceretriever = new AmazonOOMAPPreferredMarketplaceRetriever();
        }
        catch (VerifyError verifyerror)
        {
            Log.d("AmazonOOAdRegistration", "Incompatible version of MAP found. Upgrade to MAP R5 to allow preferred marketplace to be retrieved.");
            return null;
        }
        return amazonoomappreferredmarketplaceretriever;
    }

    boolean isMAPLibraryAvailable()
    {
        return ReflectionUtils.isClassAvailable("com.amazon.identity.auth.device.api.MAPAccountManager");
    }


}
