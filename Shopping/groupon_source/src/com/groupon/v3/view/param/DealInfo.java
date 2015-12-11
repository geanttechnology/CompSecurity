// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.view.param;

import com.groupon.db.models.DealSummary;

// Referenced classes of package com.groupon.v3.view.param:
//            DealCardClickInfo

public class DealInfo
    implements DealCardClickInfo
{

    private final DealSummary dealSummary;

    public DealInfo(DealSummary dealsummary)
    {
        dealSummary = dealsummary;
    }

    public DealSummary getDealSummary()
    {
        return dealSummary;
    }
}
