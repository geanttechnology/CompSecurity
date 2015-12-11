// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class CalendarMetadata extends JsonEncodedNSTField
{

    public String calendarBefore;
    public String checkInDate;
    public String checkOutDate;
    public String dealId;
    public String dealUuid;
    public String optionUuid;

    public CalendarMetadata()
    {
        calendarBefore = null;
        dealUuid = null;
        dealId = null;
        optionUuid = null;
        checkInDate = null;
        checkOutDate = null;
    }
}
