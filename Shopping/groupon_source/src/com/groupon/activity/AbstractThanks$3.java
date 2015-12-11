// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.ListAdapter;
import com.groupon.db.models.DealSummary;
import com.groupon.util.DealCardMultiColumnListAdapter;

// Referenced classes of package com.groupon.activity:
//            AbstractThanks

class stAdapter extends DealCardMultiColumnListAdapter
{

    final AbstractThanks this$0;

    public void onWidgetDealCardClicked(View view, DealSummary dealsummary)
    {
        onMemberClick(view, dealsummary);
    }

    stAdapter(ListAdapter listadapter, int i)
    {
        this$0 = AbstractThanks.this;
        super(listadapter, i);
    }
}
