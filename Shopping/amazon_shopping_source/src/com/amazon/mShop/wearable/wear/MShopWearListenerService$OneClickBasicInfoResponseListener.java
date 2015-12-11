// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wearable.wear;

import android.util.Log;
import com.amazon.mShop.wearable.model.MobileState;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.GetOneClickBasicInfoResponse;
import com.amazon.rio.j2me.client.services.mShop.GetOneClickBasicInfoResponseListener;

// Referenced classes of package com.amazon.mShop.wearable.wear:
//            MShopWearListenerService

private static class <init>
    implements GetOneClickBasicInfoResponseListener
{

    public void cancelled(ServiceCall servicecall)
    {
    }

    public void completed(GetOneClickBasicInfoResponse getoneclickbasicinforesponse, ServiceCall servicecall)
    {
        if (getoneclickbasicinforesponse != null)
        {
            MShopWearListenerService.access$700().oneClickCity = getoneclickbasicinforesponse.getCity();
            MShopWearListenerService.access$700().oneClickName = getoneclickbasicinforesponse.getFullName();
            MShopWearListenerService.access$1200();
        }
    }

    public void error(Exception exception, ServiceCall servicecall)
    {
        Log.e("WearListenerService", "Unable to query one click info", exception);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
