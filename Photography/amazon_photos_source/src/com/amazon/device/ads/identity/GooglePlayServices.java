// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;


// Referenced classes of package com.amazon.device.ads.identity:
//            Settings, GooglePlayServicesAdapter, Log, ReflectionUtils

class GooglePlayServices
{
    static class AdvertisingInfo
    {

        private String advertisingIdentifier;
        private boolean gpsAvailable;
        private boolean limitAdTrackingEnabled;

        static AdvertisingInfo createNotAvailable()
        {
            AdvertisingInfo advertisinginfo = new AdvertisingInfo();
            advertisinginfo.gpsAvailable = false;
            return advertisinginfo;
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


    private static final String LOG_TAG = com/amazon/device/ads/identity/GooglePlayServices.getSimpleName();

    GooglePlayServices()
    {
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
        if (!Settings.getInstance().getBoolean("gps-available", true))
        {
            Log.v(LOG_TAG, "The Google Play Services Advertising Identifier feature is not available.", new Object[0]);
            return AdvertisingInfo.createNotAvailable();
        }
        if (!Settings.getInstance().containsKey("gps-available") && !ReflectionUtils.isClassAvailable("com.google.android.gms.ads.identifier.AdvertisingIdClient"))
        {
            Log.v(LOG_TAG, "The Google Play Services Advertising Identifier feature is not available.", new Object[0]);
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
