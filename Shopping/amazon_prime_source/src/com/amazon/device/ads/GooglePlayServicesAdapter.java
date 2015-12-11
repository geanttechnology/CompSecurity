// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

// Referenced classes of package com.amazon.device.ads:
//            MobileAdsLoggerFactory, MobileAdsInfoStore, MobileAdsLogger

class GooglePlayServicesAdapter
{

    private static final String LOGTAG = com/amazon/device/ads/GooglePlayServicesAdapter.getSimpleName();
    private final MobileAdsLogger logger;

    GooglePlayServicesAdapter()
    {
        logger = (new MobileAdsLoggerFactory()).createMobileAdsLogger(LOGTAG);
    }

    public GooglePlayServices.AdvertisingInfo getAdvertisingIdentifierInfo()
    {
        Object obj = MobileAdsInfoStore.getInstance().getApplicationContext();
        String s;
        boolean flag;
        try
        {
            obj = AdvertisingIdClient.getAdvertisingIdInfo(((android.content.Context) (obj)));
        }
        catch (IllegalStateException illegalstateexception)
        {
            logger.e("The Google Play Services Advertising Id API was called from a non-background thread.");
            return new GooglePlayServices.AdvertisingInfo();
        }
        catch (IOException ioexception)
        {
            logger.e("Retrieving the Google Play Services Advertising Identifier caused an IOException.");
            return new GooglePlayServices.AdvertisingInfo();
        }
        catch (GooglePlayServicesNotAvailableException googleplayservicesnotavailableexception)
        {
            logger.v("Retrieving the Google Play Services Advertising Identifier caused a GooglePlayServicesNotAvailableException.");
            return GooglePlayServices.AdvertisingInfo.createNotAvailable();
        }
        catch (GooglePlayServicesRepairableException googleplayservicesrepairableexception)
        {
            logger.v("Retrieving the Google Play Services Advertising Identifier caused a GooglePlayServicesRepairableException.");
            return new GooglePlayServices.AdvertisingInfo();
        }
        logger.v("The Google Play Services Advertising Identifier was successfully retrieved.");
        s = ((com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) (obj)).getId();
        flag = ((com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) (obj)).isLimitAdTrackingEnabled();
        return (new GooglePlayServices.AdvertisingInfo()).setAdvertisingIdentifier(s).setLimitAdTrackingEnabled(flag);
    }

}
