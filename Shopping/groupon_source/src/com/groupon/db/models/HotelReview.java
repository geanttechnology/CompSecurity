// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.util.Date;

// Referenced classes of package com.groupon.db.models:
//            HotelReviews

public class HotelReview
{

    public String body;
    public String languageCode;
    public HotelReviews parentHotelReviews;
    public Long primaryKey;
    public Date publishedDate;
    public double rating;
    public String title;
    public String url;
    public String userLocation;
    public String userName;

    public HotelReview()
    {
        userLocation = "";
        publishedDate = null;
        languageCode = "";
        body = "";
        title = "";
        userName = "";
        url = "";
    }
}
