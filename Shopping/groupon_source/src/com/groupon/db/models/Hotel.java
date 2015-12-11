// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.db.models:
//            HotelAddress, HotelReviews, MarketRateResult

public class Hotel
    implements Serializable
{

    public boolean active;
    protected HotelAddress address;
    public String bucksDisclaimer;
    public double bucksPercentage;
    public String derivedHotelAddressCity;
    public String derivedHotelAddressCountry;
    public Double derivedHotelAddressLat;
    public Double derivedHotelAddressLng;
    public String derivedHotelAddressPostalCode;
    public String derivedHotelAddressState;
    public String derivedHotelAddressStreetAddress1;
    public String derivedHotelAddressStreetAddress2;
    public String description;
    public String hotelAmenities[];
    public Double hotelRating;
    public Collection hotelReviews;
    public MarketRateResult marketRateResult;
    public String mediumImageUrl;
    public Date modificationDate;
    public String name;
    public String phoneNumber;
    public Long primaryKey;
    public String remoteId;
    public String roomAmenities[];
    public String roomRateDisclaimer;
    public String timeZone;
    public String timeZoneIdentifier;
    public String uuid;

    public Hotel()
    {
        uuid = "";
        name = "";
        mediumImageUrl = "";
        phoneNumber = "";
        description = "";
        hotelAmenities = new String[0];
        roomAmenities = new String[0];
        bucksDisclaimer = "";
        roomRateDisclaimer = "";
        timeZone = "";
        timeZoneIdentifier = "";
        derivedHotelAddressStreetAddress1 = "";
        derivedHotelAddressStreetAddress2 = "";
        derivedHotelAddressCity = "";
        derivedHotelAddressState = "";
        derivedHotelAddressPostalCode = "";
        derivedHotelAddressCountry = "";
        hotelReviews = Collections.emptyList();
    }

    public void afterJsonDeserializationPostProcessor()
    {
        if (address != null)
        {
            derivedHotelAddressStreetAddress1 = address.streetAddress1;
            derivedHotelAddressStreetAddress2 = address.streetAddress2;
            derivedHotelAddressCity = address.city;
            derivedHotelAddressState = address.state;
            derivedHotelAddressCountry = address.country;
            derivedHotelAddressPostalCode = address.postalCode;
            derivedHotelAddressLat = address.lat;
            derivedHotelAddressLng = address.lng;
        }
    }

    public String getBucksDisclaimer()
    {
        if (bucksDisclaimer != null)
        {
            return bucksDisclaimer;
        } else
        {
            return "";
        }
    }

    public HotelReviews getHotelReviews(String s)
    {
        if (hotelReviews != null) goto _L2; else goto _L1
_L1:
        hotelReviews = Collections.emptyList();
_L4:
        return null;
_L2:
        HotelReviews hotelreviews;
        Iterator iterator = hotelReviews.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            hotelreviews = (HotelReviews)iterator.next();
        } while (!Strings.equalsIgnoreCase(hotelreviews.sourceType, s));
        break; /* Loop/switch isn't completed */
        if (true) goto _L4; else goto _L3
_L3:
        return hotelreviews;
    }

    public void setHotelReviews(Collection collection)
    {
        Object obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        for (collection = ((Collection) (obj)).iterator(); collection.hasNext();)
        {
            ((HotelReviews)collection.next()).parentHotel = this;
        }

        hotelReviews = ((Collection) (obj));
    }
}
