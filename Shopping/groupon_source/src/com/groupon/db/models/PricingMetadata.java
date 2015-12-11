// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.util.Date;

// Referenced classes of package com.groupon.db.models:
//            Option

public class PricingMetadata
{

    public int expiryInMinutes;
    public int maxBuyCount;
    public int minBuyCount;
    public Date offerBeginsAt;
    public Date offerEndsAt;
    public String offerLabel;
    public String offerLabelDescriptive;
    public String offerType;
    public Option parentOption;
    public Long primaryKey;
    public String remoteId;
    public String timerLabel;

    public PricingMetadata()
    {
        offerLabelDescriptive = "";
        offerBeginsAt = null;
        offerEndsAt = null;
        offerLabel = "";
        timerLabel = "";
        offerType = "";
        minBuyCount = 0;
        maxBuyCount = 0;
        expiryInMinutes = 0;
    }
}
