// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.widgetcards;

import android.view.View;
import com.groupon.db.models.WidgetSummary;
import com.groupon.view.DealSetCallbacks;

// Referenced classes of package com.groupon.view.widgetcards:
//            LimitedListWidgetHeaderCard

class val.widget
    implements android.view.getHeaderCard._cls2
{

    final LimitedListWidgetHeaderCard this$0;
    final DealSetCallbacks val$dealSetCallbacks;
    final WidgetSummary val$widget;

    public void onClick(View view)
    {
        val$dealSetCallbacks.onSubsetClick(val$widget);
    }

    ()
    {
        this$0 = final_limitedlistwidgetheadercard;
        val$dealSetCallbacks = dealsetcallbacks;
        val$widget = WidgetSummary.this;
        super();
    }
}
