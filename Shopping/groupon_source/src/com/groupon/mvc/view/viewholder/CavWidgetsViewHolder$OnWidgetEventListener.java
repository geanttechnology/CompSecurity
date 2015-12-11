// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.view.View;
import com.groupon.callbacks.OnDealDetailsWidgetsEventListener;
import com.groupon.db.models.DealSummary;
import com.groupon.db.models.WidgetSummary;
import com.groupon.view.DealSetCallbacks;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            CavWidgetsViewHolder

private class <init>
    implements DealSetCallbacks
{

    final CavWidgetsViewHolder this$0;

    public void onMemberClick(View view, DealSummary dealsummary)
    {
        if (callback != null)
        {
            ((OnDealDetailsWidgetsEventListener)callback).onCavWidgetClick(view, dealsummary);
        }
    }

    public void onSubsetClick(WidgetSummary widgetsummary)
    {
    }

    private ()
    {
        this$0 = CavWidgetsViewHolder.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
