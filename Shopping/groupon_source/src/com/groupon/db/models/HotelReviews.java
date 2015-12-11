// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

// Referenced classes of package com.groupon.db.models:
//            HotelReview, Hotel

public class HotelReviews
{

    public Hotel parentHotel;
    public double percentRecommended;
    public Long primaryKey;
    public double rating;
    public double reviewCount;
    public Collection reviews;
    public String sourceType;

    public HotelReviews()
    {
        sourceType = "";
        reviews = Collections.emptyList();
    }

    public void setReviews(Collection collection)
    {
        Object obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        for (collection = ((Collection) (obj)).iterator(); collection.hasNext();)
        {
            ((HotelReview)collection.next()).parentHotelReviews = this;
        }

        reviews = ((Collection) (obj));
    }
}
