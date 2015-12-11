// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.callbacks.DefaultHotelReviewsRequestCallback;
import com.groupon.db.models.HotelReviews;
import java.lang.ref.WeakReference;

// Referenced classes of package com.groupon.activity:
//            DealDetails

private static class activityWeakReference extends DefaultHotelReviewsRequestCallback
{

    private WeakReference activityWeakReference;

    public void onHotelReviewsSuccess(HotelReviews hotelreviews)
    {
        if (hotelreviews != null && activityWeakReference.get() != null)
        {
            DealDetails.access$4800((DealDetails)activityWeakReference.get(), DealDetails.access$4700((DealDetails)activityWeakReference.get(), hotelreviews));
        }
    }

    public A(DealDetails dealdetails)
    {
        activityWeakReference = new WeakReference(dealdetails);
    }
}
