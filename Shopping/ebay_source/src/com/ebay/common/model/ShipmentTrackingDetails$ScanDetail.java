// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import java.util.Date;

// Referenced classes of package com.ebay.common.model:
//            ShipmentTrackingDetails

public static final class 
{

    public String eventCity;
    public String eventDesc;
    public String eventPostalCode;
    public String eventStateOrProvince;
    public String eventStatus;
    public Date eventTime;

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("eventStatus: ").append(eventStatus).append('\n');
        stringbuilder.append("eventDesc: ").append(eventDesc).append('\n');
        stringbuilder.append("eventTime: ").append(eventTime).append('\n');
        stringbuilder.append("eventCity: ").append(eventCity).append('\n');
        stringbuilder.append("eventStateOrProvince: ").append(eventStateOrProvince).append('\n');
        stringbuilder.append("eventPostalCode: ").append(eventPostalCode).append('\n');
        return stringbuilder.toString();
    }

    public ()
    {
    }
}
