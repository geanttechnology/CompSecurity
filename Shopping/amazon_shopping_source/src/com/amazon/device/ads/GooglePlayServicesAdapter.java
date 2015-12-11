// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

// Referenced classes of package com.amazon.device.ads:
//            InternalAdRegistration, IInternalAdRegistration, Log

class GooglePlayServicesAdapter
{

    private static final String LOG_TAG = com/amazon/device/ads/GooglePlayServicesAdapter.getSimpleName();

    GooglePlayServicesAdapter()
    {
    }

    protected AdvertisingIdClient createAdvertisingIdClient()
    {
        return new AdvertisingIdClient();
    }

    public GooglePlayServices.AdvertisingInfo getAdvertisingIdentifierInfo()
    {
        Object obj = InternalAdRegistration.getInstance().getApplicationContext();
        String s;
        boolean flag;
        try
        {
            obj = AdvertisingIdClient.getAdvertisingIdInfo(((android.content.Context) (obj)));
        }
        catch (IllegalStateException illegalstateexception)
        {
            Log.e(LOG_TAG, "The Google Play Services Advertising Id API was called from a non-background thread.");
            return new GooglePlayServices.AdvertisingInfo();
        }
        catch (IOException ioexception)
        {
            Log.e(LOG_TAG, "Retrieving the Google Play Services Advertising Identifier caused an IOException.");
            return new GooglePlayServices.AdvertisingInfo();
        }
        catch (GooglePlayServicesNotAvailableException googleplayservicesnotavailableexception)
        {
            Log.v(LOG_TAG, "Retrieving the Google Play Services Advertising Identifier caused a GooglePlayServicesNotAvailableException.");
            return GooglePlayServices.AdvertisingInfo.createNotAvailable();
        }
        catch (GooglePlayServicesRepairableException googleplayservicesrepairableexception)
        {
            Log.v(LOG_TAG, "Retrieving the Google Play Services Advertising Identifier caused a GooglePlayServicesRepairableException.");
            return new GooglePlayServices.AdvertisingInfo();
        }
        Log.v(LOG_TAG, "The Google Play Services Advertising Identifier was successfully retrieved.");
        s = ((com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) (obj)).getId();
        flag = ((com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) (obj)).isLimitAdTrackingEnabled();
        return (new GooglePlayServices.AdvertisingInfo()).setAdvertisingIdentifier(s).setLimitAdTrackingEnabled(flag);
    }

}
