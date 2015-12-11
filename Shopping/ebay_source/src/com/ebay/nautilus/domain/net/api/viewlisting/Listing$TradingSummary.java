// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;

import com.ebay.nautilus.domain.net.EbayDateUtils;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class labilityByLogisticsPlans
{

    public Date lastVisitDate;
    public Integer publishedAnswerCount;
    public List purchaseOptions;
    public labilityByLogisticsPlans quantityAndAvailabilityByLogisticsPlans;
    public List questionAndAnswers;
    public Integer totalQuestionCount;
    public Integer unansweredQuestionCount;
    public Integer visitCount;
    public Integer watchCount;

    protected void setLastVisitDate(String s)
    {
        if (lastVisitDate != null)
        {
            break MISSING_BLOCK_LABEL_15;
        }
        lastVisitDate = EbayDateUtils.parse(s);
        return;
        s;
        Listing.access$000()._mth000("error parsing date", s);
        return;
    }

    public labilityByLogisticsPlans()
    {
    }
}
