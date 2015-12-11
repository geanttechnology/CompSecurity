// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.util.Date;
import java.util.List;

// Referenced classes of package com.groupon.db.models:
//            AbstractBusiness, Business, Location

public class BusinessSummary extends AbstractBusiness
{

    public String channel;
    public String city;
    public double lat;
    public double lng;
    public Date modificationDate;
    public Long primaryKey;
    public String remoteId;
    public String streetAddress1;
    public String streetNumber;

    public BusinessSummary()
    {
        streetAddress1 = "";
        streetNumber = "";
        city = "";
        lat = 0.0D;
        lng = 0.0D;
    }

    public BusinessSummary(Business business, String s)
    {
        super(business);
        streetAddress1 = "";
        streetNumber = "";
        city = "";
        lat = 0.0D;
        lng = 0.0D;
        remoteId = business.remoteId;
        channel = s;
        business = business.getLocations();
        if (!business.isEmpty())
        {
            business = (Location)business.get(0);
            streetAddress1 = ((Location) (business)).streetAddress1;
            streetNumber = ((Location) (business)).streetNumber;
            city = ((Location) (business)).city;
            lat = ((Location) (business)).lat;
            lng = ((Location) (business)).lng;
        }
    }
}
