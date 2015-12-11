// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.mobilescheduler;


// Referenced classes of package com.groupon.models.mobilescheduler:
//            Deal, LocalBookingInfo, Merchant, Location, 
//            DealOption

public class MobileSchedulerData
{

    public boolean bookable;
    public String channel;
    public Deal deal;
    public DealOption dealOption;
    public String gdtOrderId;
    public String grouponCode;
    public LocalBookingInfo localBookingInfo;
    public Location location;
    public Merchant merchant;
    public String orderId;

    public MobileSchedulerData()
    {
        deal = new Deal();
        grouponCode = "";
        localBookingInfo = new LocalBookingInfo();
        merchant = new Merchant();
        location = new Location();
        dealOption = new DealOption();
        orderId = "";
    }
}
