// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;


// Referenced classes of package com.groupon.db.models:
//            Location, CouponMerchant

public class CouponPlace
{
    public static class CouponAddress
    {

        public String city;
        public String country;
        public String postalCode;
        public String state;
        public String street;

        public CouponAddress()
        {
            street = "";
            city = "";
            state = "";
            country = "";
            postalCode = "";
        }
    }

    public static class CouponLocation
    {

        public double latitude;
        public double longitude;

        public CouponLocation()
        {
            latitude = 0.0D;
            longitude = 0.0D;
        }
    }


    public CouponAddress address;
    public CouponLocation location;
    public CouponMerchant merchant;
    public String phone;

    public CouponPlace()
    {
        phone = "";
    }

    public Location getLocation()
    {
        Location location1 = new Location();
        location1.streetAddress1 = address.street;
        location1.city = address.city;
        location1.state = address.state;
        location1.country = address.country;
        location1.postalCode = address.postalCode;
        location1.lat = location.latitude;
        location1.lng = location.longitude;
        location1.phoneNumber = phone;
        return location1;
    }

    public CouponMerchant getMerchant()
    {
        return merchant;
    }
}
