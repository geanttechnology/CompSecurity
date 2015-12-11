// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.widgetcards;

import android.view.View;
import com.groupon.db.models.DealSummary;
import com.groupon.view.DealSetCallbacks;

// Referenced classes of package com.groupon.view.widgetcards:
//            DealWidgetCard

class val.dealSummary
    implements android.view.ner
{

    final DealWidgetCard this$0;
    final DealSetCallbacks val$dealSetCallbacks;
    final DealSummary val$dealSummary;

    public void onClick(View view)
    {
        val$dealSetCallbacks.onMemberClick(view, val$dealSummary);
    }

    ()
    {
        this$0 = final_dealwidgetcard;
        val$dealSetCallbacks = dealsetcallbacks;
        val$dealSummary = DealSummary.this;
        super();
    }
}
