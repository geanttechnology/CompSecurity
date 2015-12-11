// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.models.hotel.RaoResponseWrapper;
import java.lang.ref.WeakReference;

// Referenced classes of package com.groupon.activity:
//            HotelDetails

private static class hotelDetailsWeakReference
    implements com.groupon.fragment.scountServiceCallback
{

    private WeakReference hotelDetailsWeakReference;

    public void onRequestRaOResult(RaoResponseWrapper raoresponsewrapper, Exception exception)
    {
label0:
        {
            if (hotelDetailsWeakReference.get() != null)
            {
                if (exception != null)
                {
                    break label0;
                }
                HotelDetails.access$2300((HotelDetails)hotelDetailsWeakReference.get(), true, raoresponsewrapper.waitTimeSecond, raoresponsewrapper.attemptsLeft);
            }
            return;
        }
        HotelDetails.access$2300((HotelDetails)hotelDetailsWeakReference.get(), false, 0, 0);
    }

    public scountServiceCallback(HotelDetails hoteldetails)
    {
        hotelDetailsWeakReference = new WeakReference(hoteldetails);
    }
}
