// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            MobileAdsLoggerFactory, ReflectionUtils, Settings, GooglePlayServicesAdapter, 
//            MobileAdsLogger

class GooglePlayServices
{
    static class AdvertisingInfo
    {

        private String advertisingIdentifier;
        private boolean gpsAvailable;
        private boolean limitAdTrackingEnabled;

        static AdvertisingInfo createNotAvailable()
        {
            return (new AdvertisingInfo()).setGPSAvailable(false);
        }

        private AdvertisingInfo setGPSAvailable(boolean flag)
        {
            gpsAvailable = flag;
            return this;
        }

        String getAdvertisingIdentifier()
        {
            return advertisingIdentifier;
        }

        boolean hasAdvertisingIdentifier()
        {
            return getAdvertisingIdentifier() != null;
        }

        boolean isGPSAvailable()
        {
            return gpsAvailable;
        }

        boolean isLimitAdTrackingEnabled()
        {
            return limitAdTrackingEnabled;
        }

        AdvertisingInfo setAdvertisingIdentifier(String s)
        {
            advertisingIdentifier = s;
            return this;
        }

        AdvertisingInfo setLimitAdTrackingEnabled(boolean flag)
        {
            limitAdTrackingEnabled = flag;
            return this;
        }

        protected AdvertisingInfo()
        {
            gpsAvailable = true;
        }
    }


    private static final String GPS_AVAILABLE_SETTING = "gps-available";
    private static final String LOGTAG = com/amazon/device/ads/GooglePlayServices.getSimpleName();
    private final MobileAdsLogger logger;
    private final ReflectionUtils reflectionUtils;

    public GooglePlayServices()
    {
        this(new MobileAdsLoggerFactory(), new ReflectionUtils());
    }

    GooglePlayServices(MobileAdsLoggerFactory mobileadsloggerfactory, ReflectionUtils reflectionutils)
    {
        logger = mobileadsloggerfactory.createMobileAdsLogger(LOGTAG);
        reflectionUtils = reflectionutils;
    }

    private boolean isGPSAvailable()
    {
        return Settings.getInstance().getBoolean("gps-available", true);
    }

    private boolean isGPSAvailableSet()
    {
        return Settings.getInstance().containsKey("gps-available");
    }

    private void setGooglePlayServicesAvailable(boolean flag)
    {
        Settings.getInstance().putTransientBoolean("gps-available", flag);
    }

    protected GooglePlayServicesAdapter createGooglePlayServicesAdapter()
    {
        return new GooglePlayServicesAdapter();
    }

    public AdvertisingInfo getAdvertisingIdentifierInfo()
    {
        if (!isGPSAvailable())
        {
            logger.v("The Google Play Services Advertising Identifier feature is not available.");
            return AdvertisingInfo.createNotAvailable();
        }
        if (!isGPSAvailableSet() && !reflectionUtils.isClassAvailable("com.google.android.gms.ads.identifier.AdvertisingIdClient"))
        {
            logger.v("The Google Play Services Advertising Identifier feature is not available.");
            setGooglePlayServicesAvailable(false);
            return AdvertisingInfo.createNotAvailable();
        } else
        {
            AdvertisingInfo advertisinginfo = createGooglePlayServicesAdapter().getAdvertisingIdentifierInfo();
            setGooglePlayServicesAvailable(advertisinginfo.isGPSAvailable());
            return advertisinginfo;
        }
    }

}
