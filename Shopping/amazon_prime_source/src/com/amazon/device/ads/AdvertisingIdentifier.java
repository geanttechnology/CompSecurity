// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            Settings, MobileAdsInfoStore, MobileAdsLoggerFactory, DebugProperties, 
//            MobileAdsLogger, StringUtils, RegistrationInfo, GooglePlayServices, 
//            ThreadUtils

class AdvertisingIdentifier
{
    static class Info
    {

        private String advertisingIdentifier;
        private boolean canDo;
        private final DebugProperties debugProperties;
        private boolean limitAdTrackingEnabled;
        private String sisDeviceIdentifier;

        private Info setAdvertisingIdentifier(String s)
        {
            advertisingIdentifier = s;
            return this;
        }

        private Info setCanDo(boolean flag)
        {
            canDo = flag;
            return this;
        }

        private Info setLimitAdTrackingEnabled(boolean flag)
        {
            limitAdTrackingEnabled = flag;
            return this;
        }

        boolean canDo()
        {
            return canDo;
        }

        String getAdvertisingIdentifier()
        {
            return debugProperties.getDebugPropertyAsString("debug.idfa", advertisingIdentifier);
        }

        String getSISDeviceIdentifier()
        {
            return debugProperties.getDebugPropertyAsString("debug.adid", sisDeviceIdentifier);
        }

        boolean hasAdvertisingIdentifier()
        {
            return !StringUtils.isNullOrEmpty(getAdvertisingIdentifier());
        }

        boolean hasSISDeviceIdentifier()
        {
            return getSISDeviceIdentifier() != null;
        }

        boolean isLimitAdTrackingEnabled()
        {
            return debugProperties.getDebugPropertyAsBoolean("debug.optOut", Boolean.valueOf(limitAdTrackingEnabled)).booleanValue();
        }

        Info setSISDeviceIdentifier(String s)
        {
            sisDeviceIdentifier = s;
            return this;
        }




        private Info(DebugProperties debugproperties)
        {
            debugProperties = debugproperties;
            canDo = true;
        }

    }


    private static final String GPS_ADVERTISING_IDENTIFIER_SETTING = "gpsAdId";
    private static final String LOGTAG = com/amazon/device/ads/AdvertisingIdentifier.getSimpleName();
    private static final String TRANSITION_MIGRATE = "migrate";
    private static final String TRANSITION_RESET = "reset";
    private static final String TRANSITION_REVERT = "revert";
    private static final String TRANSITION_SETTING = "adIdTransistion";
    private final DebugProperties debugProperties;
    private GooglePlayServices.AdvertisingInfo gpsAdvertisingInfo;
    private final MobileAdsInfoStore infoStore;
    private final MobileAdsLogger logger;
    private final Settings settings;
    private boolean shouldSetCurrentAdvertisingIdentifier;

    public AdvertisingIdentifier()
    {
        this(Settings.getInstance(), MobileAdsInfoStore.getInstance(), new MobileAdsLoggerFactory(), DebugProperties.getInstance());
    }

    AdvertisingIdentifier(Settings settings1, MobileAdsInfoStore mobileadsinfostore, MobileAdsLoggerFactory mobileadsloggerfactory, DebugProperties debugproperties)
    {
        shouldSetCurrentAdvertisingIdentifier = true;
        settings = settings1;
        infoStore = mobileadsinfostore;
        logger = mobileadsloggerfactory.createMobileAdsLogger(LOGTAG);
        debugProperties = debugproperties;
    }

    private void determineTransition()
    {
        String s = null;
        if (isTransitionMigrated())
        {
            s = "migrate";
        } else
        if (isTransitionReset())
        {
            s = "reset";
        } else
        if (isTransitionReverted())
        {
            s = "revert";
        }
        if (s != null)
        {
            setTransition(s);
            return;
        } else
        {
            logger.d("No transition detected.");
            return;
        }
    }

    private String getCurrentGPSAID()
    {
        return settings.getString("gpsAdId", "");
    }

    private boolean hasCurrentGPSAID()
    {
        return !StringUtils.isNullOrEmpty(getCurrentGPSAID());
    }

    private boolean isTransitionMigrated()
    {
        return infoStore.getRegistrationInfo().hasAdId() && RegistrationInfo.isAdIdOriginatedFromNonAdvertisingIdentifier() && !hasCurrentGPSAID() && getGPSAdvertisingInfo().hasAdvertisingIdentifier();
    }

    private boolean isTransitionReset()
    {
        return hasCurrentGPSAID() && getGPSAdvertisingInfo().hasAdvertisingIdentifier() && !getCurrentGPSAID().equals(getGPSAdvertisingInfo().getAdvertisingIdentifier());
    }

    private boolean isTransitionReverted()
    {
        return hasCurrentGPSAID() && !getGPSAdvertisingInfo().hasAdvertisingIdentifier();
    }

    private void setCurrentGPSAID(String s)
    {
        settings.putString("gpsAdId", s);
    }

    private void setTransition(String s)
    {
        logger.d("Transition: %s", new Object[] {
            s
        });
        settings.putString("adIdTransistion", s);
    }

    protected void fetchGooglePlayServicesAdvertisingIdentifierInfo()
    {
        gpsAdvertisingInfo = (new GooglePlayServices()).getAdvertisingIdentifierInfo();
    }

    Info getAdvertisingIdentifierInfo()
    {
        if (ThreadUtils.isOnMainThread())
        {
            logger.e("You must obtain the advertising indentifier information on a background thread.");
            return (new Info(debugProperties)).setCanDo(false);
        }
        fetchGooglePlayServicesAdvertisingIdentifierInfo();
        if (shouldSetCurrentAdvertisingIdentifier)
        {
            determineTransition();
        }
        Info info = new Info(debugProperties);
        if (getGPSAdvertisingInfo().hasAdvertisingIdentifier())
        {
            info.setAdvertisingIdentifier(getGPSAdvertisingInfo().getAdvertisingIdentifier());
            info.setLimitAdTrackingEnabled(getGPSAdvertisingInfo().isLimitAdTrackingEnabled());
            if (shouldSetCurrentAdvertisingIdentifier)
            {
                setCurrentGPSAID(getGPSAdvertisingInfo().getAdvertisingIdentifier());
            }
        }
        RegistrationInfo registrationinfo = infoStore.getRegistrationInfo();
        if (registrationinfo.isAdIdCurrent(info))
        {
            info.setSISDeviceIdentifier(registrationinfo.getAdId());
            return info;
        } else
        {
            registrationinfo.requestNewSISDeviceIdentifier();
            return info;
        }
    }

    String getAndClearTransition()
    {
        String s = settings.getString("adIdTransistion", null);
        settings.remove("adIdTransistion");
        return s;
    }

    protected GooglePlayServices.AdvertisingInfo getGPSAdvertisingInfo()
    {
        return gpsAdvertisingInfo;
    }

    AdvertisingIdentifier setShouldSetCurrentAdvertisingIdentifier(boolean flag)
    {
        shouldSetCurrentAdvertisingIdentifier = flag;
        return this;
    }

}
