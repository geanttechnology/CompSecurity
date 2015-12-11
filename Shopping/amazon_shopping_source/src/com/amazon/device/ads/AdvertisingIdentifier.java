// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            Log, Settings, Utils, InternalAdRegistration, 
//            IInternalAdRegistration, RegistrationInfo, GooglePlayServices, ThreadUtils, 
//            DebugProperties

class AdvertisingIdentifier
{
    static class Info
    {

        private String advertisingIdentifier;
        private boolean canDo;
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

        private Info setSISDeviceIdentifier(String s)
        {
            sisDeviceIdentifier = s;
            return this;
        }

        boolean canDo()
        {
            return canDo;
        }

        String getAdvertisingIdentifier()
        {
            return DebugProperties.getDebugPropertyAsString("debug.idfa", advertisingIdentifier);
        }

        String getSISDeviceIdentifier()
        {
            return DebugProperties.getDebugPropertyAsString("debug.adid", sisDeviceIdentifier);
        }

        boolean hasAdvertisingIdentifier()
        {
            return !Utils.isNullOrEmpty(getAdvertisingIdentifier());
        }

        boolean hasSISDeviceIdentifier()
        {
            return getSISDeviceIdentifier() != null;
        }

        boolean isLimitAdTrackingEnabled()
        {
            return DebugProperties.getDebugPropertyAsBoolean("debug.optOut", limitAdTrackingEnabled);
        }





        Info()
        {
            canDo = true;
        }
    }


    private static final String GPS_ADVERTISING_IDENTIFIER_SETTING = "gpsAdId";
    private static final String LOG_TAG = com/amazon/device/ads/AdvertisingIdentifier.getSimpleName();
    private static final String TRANSITION_MIGRATE = "migrate";
    private static final String TRANSITION_RESET = "reset";
    private static final String TRANSITION_REVERT = "revert";
    private static final String TRANSITION_SETTING = "adIdTransistion";
    private GooglePlayServices.AdvertisingInfo gpsAdvertisingInfo;
    private boolean shouldSetCurrentAdvertisingIdentifier;

    AdvertisingIdentifier()
    {
        shouldSetCurrentAdvertisingIdentifier = true;
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
            Log.d(LOG_TAG, "No transition detected.");
            return;
        }
    }

    static String getAndClearTransition()
    {
        Settings settings = Settings.getInstance();
        String s = settings.getString("adIdTransistion", null);
        settings.remove("adIdTransistion");
        return s;
    }

    private static String getCurrentGPSAID()
    {
        return Settings.getInstance().getString("gpsAdId", "");
    }

    private boolean hasCurrentGPSAID()
    {
        return !Utils.isNullOrEmpty(getCurrentGPSAID());
    }

    private boolean isTransitionMigrated()
    {
        return InternalAdRegistration.getInstance().getRegistrationInfo().hasAdId() && RegistrationInfo.isAdIdOriginatedFromNonAdvertisingIdentifier() && !hasCurrentGPSAID() && getGPSAdvertisingInfo().hasAdvertisingIdentifier();
    }

    private boolean isTransitionReset()
    {
        return hasCurrentGPSAID() && getGPSAdvertisingInfo().hasAdvertisingIdentifier() && !getCurrentGPSAID().equals(getGPSAdvertisingInfo().getAdvertisingIdentifier());
    }

    private boolean isTransitionReverted()
    {
        return hasCurrentGPSAID() && !getGPSAdvertisingInfo().hasAdvertisingIdentifier();
    }

    private static void setCurrentGPSAID(String s)
    {
        Settings.getInstance().putString("gpsAdId", s);
    }

    private static void setTransition(String s)
    {
        Log.d(LOG_TAG, "Transition: %s", new Object[] {
            s
        });
        Settings.getInstance().putString("adIdTransistion", s);
    }

    protected void fetchGooglePlayServicesAdvertisingIdentifierInfo()
    {
        gpsAdvertisingInfo = (new GooglePlayServices()).getAdvertisingIdentifierInfo();
    }

    Info getAdvertisingIdentifierInfo()
    {
        if (ThreadUtils.isOnMainThread())
        {
            Log.e(LOG_TAG, "You must obtain the advertising indentifier information on a background thread.");
            return (new Info()).setCanDo(false);
        }
        fetchGooglePlayServicesAdvertisingIdentifierInfo();
        if (shouldSetCurrentAdvertisingIdentifier)
        {
            determineTransition();
        }
        Info info = new Info();
        if (getGPSAdvertisingInfo().hasAdvertisingIdentifier())
        {
            info.setAdvertisingIdentifier(getGPSAdvertisingInfo().getAdvertisingIdentifier());
            info.setLimitAdTrackingEnabled(getGPSAdvertisingInfo().isLimitAdTrackingEnabled());
            if (shouldSetCurrentAdvertisingIdentifier)
            {
                setCurrentGPSAID(getGPSAdvertisingInfo().getAdvertisingIdentifier());
            }
        }
        RegistrationInfo registrationinfo = InternalAdRegistration.getInstance().getRegistrationInfo();
        if (RegistrationInfo.isAdIdCurrent(info))
        {
            info.setSISDeviceIdentifier(registrationinfo.getAdId());
            return info;
        } else
        {
            registrationinfo.requestNewSISDeviceIdentifier();
            return info;
        }
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
