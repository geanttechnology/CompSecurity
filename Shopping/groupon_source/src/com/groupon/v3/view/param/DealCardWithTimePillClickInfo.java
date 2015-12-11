// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.view.param;

import android.view.View;
import com.groupon.db.models.DealSummary;

// Referenced classes of package com.groupon.v3.view.param:
//            DealCardClickInfo

public class DealCardWithTimePillClickInfo
    implements DealCardClickInfo
{

    private final DealSummary dealSummary;
    private final View timePill;

    public DealCardWithTimePillClickInfo(DealSummary dealsummary, View view)
    {
        dealSummary = dealsummary;
        timePill = view;
    }

    public DealSummary getDealSummary()
    {
        return dealSummary;
    }

    public View getTimePill()
    {
        return timePill;
    }
}
