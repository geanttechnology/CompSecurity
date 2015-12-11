// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.dealcards;

import android.view.View;
import com.groupon.db.models.DealSummary;
import com.groupon.v3.view.callbacks.DealCardBookingsViewHandler;
import com.groupon.v3.view.param.DealCardWithTimePillClickInfo;

// Referenced classes of package com.groupon.view.dealcards:
//            DealCardBase

private static class dealSummary
    implements android.view.ClickListener
{

    final View dealCardBase;
    final DealCardBookingsViewHandler dealCardBookingsViewHandler;
    final DealSummary dealSummary;

    public void onClick(View view)
    {
        dealCardBookingsViewHandler.onDealClick(dealCardBase, new DealCardWithTimePillClickInfo(dealSummary, view));
    }

    public (DealCardBase dealcardbase, DealCardBookingsViewHandler dealcardbookingsviewhandler, DealSummary dealsummary)
    {
        dealCardBase = dealcardbase;
        dealCardBookingsViewHandler = dealcardbookingsviewhandler;
        dealSummary = dealsummary;
    }
}
