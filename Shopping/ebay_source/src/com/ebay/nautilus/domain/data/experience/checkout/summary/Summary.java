// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.checkout.summary;

import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain.data.experience.checkout.summary:
//            AccessibilityData, SummaryItem, UserAgreement

public class Summary
{

    public AccessibilityData accessibilityData;
    public Map actions;
    public String legalText;
    public List summaryItemList;
    public SummaryItem total;
    public UserAgreement userAgreement;

    public Summary()
    {
    }
}
