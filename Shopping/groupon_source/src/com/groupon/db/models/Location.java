// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import com.groupon.db.models.mygroupons.MyGrouponItem;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

// Referenced classes of package com.groupon.db.models:
//            Rating, Business, CouponMerchant, Option

public class Location
{

    public String city;
    public String country;
    public double lat;
    public double lng;
    public String name;
    public String neighborhood;
    public Business parentBusiness;
    public CouponMerchant parentCouponMerchant;
    public MyGrouponItem parentMyGrouponItem;
    public Option parentOption;
    public String phoneNumber;
    public String postalCode;
    public Long primaryKey;
    public Collection ratings;
    public String remoteId;
    public String state;
    public String storesHtml;
    public String streetAddress1;
    public String streetAddress2;
    public String streetNumber;

    public Location()
    {
        name = "";
        neighborhood = "";
        city = "";
        streetAddress1 = "";
        streetAddress2 = "";
        streetNumber = "";
        state = "";
        postalCode = "";
        country = "";
        phoneNumber = "";
        lat = 0.0D;
        lng = 0.0D;
        storesHtml = "";
        ratings = Collections.emptyList();
    }

    public void setRatings(Collection collection)
    {
        Object obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        for (collection = ((Collection) (obj)).iterator(); collection.hasNext();)
        {
            ((Rating)collection.next()).parentLocation = this;
        }

        ratings = ((Collection) (obj));
    }
}
