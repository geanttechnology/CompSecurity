// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.callbacks;

import com.groupon.db.models.HotelReviews;

public interface HotelReviewsRequestCallback
{

    public abstract void onException(Exception exception);

    public abstract void onHotelReviewsSuccess(HotelReviews hotelreviews);
}
