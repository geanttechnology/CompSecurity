// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.device.ads:
//            AdvertisingIdentifier, MobileAdsInfoStore, Configuration, Settings, 
//            AppEventRegistrationHandler, SystemTime, MobileAdsLoggerFactory, DebugProperties, 
//            RegistrationInfo, SISDeviceRequest, SISRequest, SISRequestor, 
//            MobileAdsLogger, SISRequestorCallback

class SISRegistration
{
    protected static class RegisterEventsSISRequestorCallback
        implements SISRequestorCallback
    {

        private final SISRegistration sisRegistration;

        public void onSISCallComplete()
        {
            sisRegistration.registerEvents();
        }

        public RegisterEventsSISRequestorCallback(SISRegistration sisregistration)
        {
            sisRegistration = sisregistration;
        }
    }


    protected static final long DEFAULT_SIS_CHECKIN_INTERVAL = 0x5265c00L;
    private static final String LOGTAG = com/amazon/device/ads/SISRegistration.getSimpleName();
    private static final String SIS_LAST_CHECKIN_PREF_NAME = "amzn-ad-sis-last-checkin";
    private static final ThreadUtils.SingleThreadScheduler singleThreadScheduler = new ThreadUtils.SingleThreadScheduler();
    private final AdvertisingIdentifier advertisingIdentifier;
    private final AppEventRegistrationHandler appEventRegistrationHandler;
    private final Configuration configuration;
    private final DebugProperties debugProperties;
    private final ThreadUtils.RunnableExecutor executor;
    private final MobileAdsInfoStore infoStore;
    private final MobileAdsLogger logger;
    private final Settings settings;
    private final SISRegisterEventRequest.SISRequestFactory sisRequestFactory;
    private final SISRequestor.SISRequestorFactory sisRequestorFactory;
    private final SystemTime systemTime;
    private final ThreadUtils.ThreadVerify threadVerify;

    public SISRegistration()
    {
        this(new SISRegisterEventRequest.SISRequestFactory(), new SISRequestor.SISRequestorFactory(), new AdvertisingIdentifier(), MobileAdsInfoStore.getInstance(), Configuration.getInstance(), Settings.getInstance(), AppEventRegistrationHandler.getInstance(), new SystemTime(), ((ThreadUtils.RunnableExecutor) (singleThreadScheduler)), new ThreadUtils.ThreadVerify(), new MobileAdsLoggerFactory(), DebugProperties.getInstance());
    }

    SISRegistration(SISRegisterEventRequest.SISRequestFactory sisrequestfactory, SISRequestor.SISRequestorFactory sisrequestorfactory, AdvertisingIdentifier advertisingidentifier, MobileAdsInfoStore mobileadsinfostore, Configuration configuration1, Settings settings1, AppEventRegistrationHandler appeventregistrationhandler, 
            SystemTime systemtime, ThreadUtils.RunnableExecutor runnableexecutor, ThreadUtils.ThreadVerify threadverify, MobileAdsLoggerFactory mobileadsloggerfactory, DebugProperties debugproperties)
    {
        sisRequestFactory = sisrequestfactory;
        sisRequestorFactory = sisrequestorfactory;
        advertisingIdentifier = advertisingidentifier;
        infoStore = mobileadsinfostore;
        configuration = configuration1;
        settings = settings1;
        appEventRegistrationHandler = appeventregistrationhandler;
        systemTime = systemtime;
        executor = runnableexecutor;
        threadVerify = threadverify;
        logger = mobileadsloggerfactory.createMobileAdsLogger(LOGTAG);
        debugProperties = debugproperties;
    }

    private MobileAdsLogger getLogger()
    {
        return logger;
    }

    private void putLastSISCheckin(long l)
    {
        settings.putLong("amzn-ad-sis-last-checkin", l);
    }

    protected boolean canRegister(long l)
    {
        boolean flag = false;
        RegistrationInfo registrationinfo = infoStore.getRegistrationInfo();
        if (exceededCheckinInterval(l) || registrationinfo.shouldGetNewSISDeviceIdentifer() || registrationinfo.shouldGetNewSISRegistration() || debugProperties.getDebugPropertyAsBoolean("debug.shouldRegisterSIS", Boolean.valueOf(false)).booleanValue())
        {
            flag = true;
        }
        return flag;
    }

    protected boolean exceededCheckinInterval(long l)
    {
        return l - getLastSISCheckin() > debugProperties.getDebugPropertyAsLong("debug.sisCheckinInterval", Long.valueOf(0x5265c00L)).longValue();
    }

    protected long getLastSISCheckin()
    {
        return settings.getLong("amzn-ad-sis-last-checkin", 0L);
    }

    protected void register(AdvertisingIdentifier advertisingidentifier)
    {
        advertisingidentifier = sisRequestFactory.createDeviceRequest(SISRegisterEventRequest.SISRequestType.GENERATE_DID).setAdvertisingIdentifier(advertisingidentifier);
        RegisterEventsSISRequestorCallback registereventssisrequestorcallback = new RegisterEventsSISRequestorCallback(this);
        sisRequestorFactory.createSISRequestor(registereventssisrequestorcallback, new SISRequest[] {
            advertisingidentifier
        }).startCallSIS();
    }

    public void registerApp()
    {
        Runnable runnable = new Runnable() {

            final SISRegistration this$0;

            public void run()
            {
                waitForConfigurationThenBeginRegistration();
            }

            
            {
                this$0 = SISRegistration.this;
                super();
            }
        };
        executor.execute(runnable);
    }

    void registerAppWorker()
    {
label0:
        {
            long l = systemTime.currentTimeMillis();
            if (advertisingIdentifier.getAdvertisingIdentifierInfo().canDo() && canRegister(l))
            {
                putLastSISCheckin(l);
                if (!shouldUpdateDeviceInfo())
                {
                    break label0;
                }
                updateDeviceInfo(advertisingIdentifier);
            }
            return;
        }
        register(advertisingIdentifier);
    }

    protected void registerEvents()
    {
        if (threadVerify.isOnMainThread())
        {
            getLogger().e("Registering events must be done on a background thread.");
        } else
        {
            Object obj = advertisingIdentifier.getAdvertisingIdentifierInfo();
            if (((AdvertisingIdentifier.Info) (obj)).hasSISDeviceIdentifier())
            {
                org.json.JSONArray jsonarray = appEventRegistrationHandler.getAppEventsJSONArray();
                if (jsonarray != null)
                {
                    obj = sisRequestFactory.createRegisterEventRequest(((AdvertisingIdentifier.Info) (obj)), jsonarray);
                    sisRequestorFactory.createSISRequestor(new SISRequest[] {
                        obj
                    }).startCallSIS();
                    return;
                }
            }
        }
    }

    protected boolean shouldUpdateDeviceInfo()
    {
        return infoStore.getRegistrationInfo().isRegisteredWithSIS();
    }

    protected void updateDeviceInfo(AdvertisingIdentifier advertisingidentifier)
    {
        advertisingidentifier = sisRequestFactory.createDeviceRequest(SISRegisterEventRequest.SISRequestType.UPDATE_DEVICE_INFO).setAdvertisingIdentifier(advertisingidentifier);
        RegisterEventsSISRequestorCallback registereventssisrequestorcallback = new RegisterEventsSISRequestorCallback(this);
        sisRequestorFactory.createSISRequestor(registereventssisrequestorcallback, new SISRequest[] {
            advertisingidentifier
        }).startCallSIS();
    }

    void waitForConfigurationThenBeginRegistration()
    {
        final CountDownLatch latch = new CountDownLatch(1);
        final AtomicBoolean canRegister = new AtomicBoolean(false);
        configuration.queueConfigurationListener(new Configuration.ConfigurationListener() {

            final SISRegistration this$0;
            final AtomicBoolean val$canRegister;
            final CountDownLatch val$latch;

            public void onConfigurationFailure()
            {
                getLogger().w("Configuration fetching failed so device registration will not proceed.");
                latch.countDown();
            }

            public void onConfigurationReady()
            {
                canRegister.set(true);
                latch.countDown();
            }

            
            {
                this$0 = SISRegistration.this;
                canRegister = atomicboolean;
                latch = countdownlatch;
                super();
            }
        });
        try
        {
            latch.await();
        }
        catch (InterruptedException interruptedexception) { }
        if (canRegister.get())
        {
            registerAppWorker();
        }
    }


}
