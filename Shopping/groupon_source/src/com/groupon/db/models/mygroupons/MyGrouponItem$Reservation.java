// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models.mygroupons;

import java.util.Collections;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.groupon.db.models.mygroupons:
//            MyGrouponItem

protected static class images
{

    public Date checkInDate;
    public Date checkOutDate;
    public int dealTimezoneOffsetInSeconds;
    public String hotelName;
    public String hotelTimezoneIdentifier;
    public String id;
    public List images;
    public int numOfNights;
    public Date purchaseDate;
    public String purchaseStatus;
    public String status;
    public String travellerFirstName;
    public String travellerLastName;

    protected ()
    {
        dealTimezoneOffsetInSeconds = 0;
        numOfNights = 0;
        travellerFirstName = "";
        travellerLastName = "";
        hotelTimezoneIdentifier = "";
        checkInDate = null;
        purchaseDate = null;
        purchaseStatus = "";
        checkOutDate = null;
        hotelName = "";
        status = "";
        id = "";
        images = Collections.emptyList();
    }
}
