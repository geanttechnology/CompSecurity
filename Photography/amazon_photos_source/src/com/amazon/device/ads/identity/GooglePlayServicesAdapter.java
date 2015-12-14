// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

// Referenced classes of package com.amazon.device.ads.identity:
//            AmazonRegistration, IAmazonRegistration, Log

class GooglePlayServicesAdapter
{

    private static final String LOG_TAG = com/amazon/device/ads/identity/GooglePlayServicesAdapter.getSimpleName();

    GooglePlayServicesAdapter()
    {
    }

    public GooglePlayServices.AdvertisingInfo getAdvertisingIdentifierInfo()
    {
        Object obj = AmazonRegistration.getInstance().getApplicationContext();
        String s;
        boolean flag;
        try
        {
            obj = AdvertisingIdClient.getAdvertisingIdInfo(((android.content.Context) (obj)));
        }
        catch (IllegalStateException illegalstateexception)
        {
            Log.e(LOG_TAG, "The Google Play Services Advertising Id API was called from a non-background thread.", new Object[0]);
            return new GooglePlayServices.AdvertisingInfo();
        }
        catch (IOException ioexception)
        {
            Log.e(LOG_TAG, "Retrieving the Google Play Services Advertising Identifier caused an IOException.", new Object[0]);
            return new GooglePlayServices.AdvertisingInfo();
        }
        catch (GooglePlayServicesNotAvailableException googleplayservicesnotavailableexception)
        {
            Log.v(LOG_TAG, "Retrieving the Google Play Services Advertising Identifier caused a GooglePlayServicesNotAvailableException.", new Object[0]);
            return GooglePlayServices.AdvertisingInfo.createNotAvailable();
        }
        catch (GooglePlayServicesRepairableException googleplayservicesrepairableexception)
        {
            Log.v(LOG_TAG, "Retrieving the Google Play Services Advertising Identifier caused a GooglePlayServicesRepairableException.", new Object[0]);
            return new GooglePlayServices.AdvertisingInfo();
        }
        Log.v(LOG_TAG, "The Google Play Services Advertising Identifier was successfully retrieved.", new Object[0]);
        s = ((com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) (obj)).getId();
        flag = ((com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) (obj)).isLimitAdTrackingEnabled();
        return (new GooglePlayServices.AdvertisingInfo()).setAdvertisingIdentifier(s).setLimitAdTrackingEnabled(flag);
    }

}
