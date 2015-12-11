// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.checkout.incentive;

import com.ebay.nautilus.domain.data.experience.checkout.summary.SummaryItem;

// Referenced classes of package com.ebay.nautilus.domain.data.experience.checkout.incentive:
//            IncentiveBrandNameType, IncentiveType

public class Incentive
{

    private boolean applied;
    private IncentiveBrandNameType brandName;
    private String expirationDate;
    private String maskedCode;
    private String message;
    private SummaryItem redeemedAmount;
    private String redemptionCode;
    private SummaryItem remainingAmount;
    private String text;
    private SummaryItem totalAmount;
    private IncentiveType type;

    public Incentive()
    {
    }
}
