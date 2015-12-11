// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.device.ads:
//            Settings, InternalAdRegistration, IInternalAdRegistration, RegistrationInfo, 
//            DebugProperties, AdvertisingIdentifier, SISGenerateDIDRequest, SISRequestor, 
//            SISRequest, ThreadUtils, Log, AppEventRegistrationHandler, 
//            SISRegisterEventRequest, SISUpdateDeviceInfoRequest, Configuration, SISRequestorCallback

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


    private static final String LOG_TAG = com/amazon/device/ads/SISRegistration.getSimpleName();
    protected static final long SIS_CHECKIN_INTERVAL = 0x5265c00L;
    private static final String SIS_LAST_CHECKIN_PREF_NAME = "amzn-ad-sis-last-checkin";
    private static final ExecutorService executorService = Executors.newSingleThreadExecutor();

    SISRegistration()
    {
    }

    private void putLastSISCheckin(long l)
    {
        Settings.getInstance().putLong("amzn-ad-sis-last-checkin", l);
    }

    protected boolean canRegister(long l)
    {
        boolean flag = false;
        RegistrationInfo registrationinfo = InternalAdRegistration.getInstance().getRegistrationInfo();
        if (exceededCheckinInterval(l) || registrationinfo.shouldGetNewSISDeviceIdentifer() || registrationinfo.shouldGetNewSISRegistration() || DebugProperties.getDebugPropertyAsBoolean("debug.shouldRegisterSIS", false))
        {
            flag = true;
        }
        return flag;
    }

    protected AdvertisingIdentifier.Info createAdvertisingIdentifierInfo()
    {
        return (new AdvertisingIdentifier()).getAdvertisingIdentifierInfo();
    }

    protected boolean exceededCheckinInterval(long l)
    {
        return l - getLastSISCheckin() > 0x5265c00L;
    }

    protected long getLastSISCheckin()
    {
        return Settings.getInstance().getLong("amzn-ad-sis-last-checkin", 0L);
    }

    protected void register(AdvertisingIdentifier.Info info)
    {
        info = (new SISGenerateDIDRequest()).setAdvertisingIdentifierInfo(info);
        (new SISRequestor(new RegisterEventsSISRequestorCallback(this), new SISRequest[] {
            info
        })).startCallSIS();
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
        executorService.submit(runnable);
    }

    void registerAppWorker()
    {
        AdvertisingIdentifier.Info info;
label0:
        {
            long l = System.currentTimeMillis();
            info = createAdvertisingIdentifierInfo();
            if (info.canDo() && canRegister(l))
            {
                putLastSISCheckin(l);
                if (!shouldUpdateDeviceInfo())
                {
                    break label0;
                }
                updateDeviceInfo(info);
            }
            return;
        }
        register(info);
    }

    protected void registerEvents()
    {
        if (ThreadUtils.isOnMainThread())
        {
            Log.e(LOG_TAG, "Registering events must be done on a background thread.");
        } else
        {
            AdvertisingIdentifier.Info info = (new AdvertisingIdentifier()).getAdvertisingIdentifierInfo();
            if (info.hasSISDeviceIdentifier())
            {
                org.json.JSONArray jsonarray = AppEventRegistrationHandler.getInstance().getAppEventsJSONArray();
                if (jsonarray != null)
                {
                    (new SISRequestor(new SISRequest[] {
                        new SISRegisterEventRequest(info, jsonarray)
                    })).startCallSIS();
                    return;
                }
            }
        }
    }

    protected boolean shouldUpdateDeviceInfo()
    {
        return InternalAdRegistration.getInstance().getRegistrationInfo().isRegisteredWithSIS();
    }

    protected void updateDeviceInfo(AdvertisingIdentifier.Info info)
    {
        info = (new SISUpdateDeviceInfoRequest()).setAdvertisingIdentifierInfo(info);
        (new SISRequestor(new RegisterEventsSISRequestorCallback(this), new SISRequest[] {
            info
        })).startCallSIS();
    }

    void waitForConfigurationThenBeginRegistration()
    {
        final CountDownLatch latch = new CountDownLatch(1);
        final AtomicBoolean canRegister = new AtomicBoolean(false);
        Configuration.getInstance().queueConfigurationListener(new Configuration.ConfigurationListener() {

            final SISRegistration this$0;
            final AtomicBoolean val$canRegister;
            final CountDownLatch val$latch;

            public void onConfigurationFailure()
            {
                Log.w(SISRegistration.LOG_TAG, "Configuration fetching failed so device registration will not proceed.");
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
