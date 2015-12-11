// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import android.widget.ListAdapter;
import com.groupon.db.models.DealSummary;
import com.groupon.util.DealCardMultiColumnListAdapter;

// Referenced classes of package com.groupon.fragment:
//            DealCardListFragment

class ter extends DealCardMultiColumnListAdapter
{

    final DealCardListFragment this$0;

    public void onDealCardClicked(int i, View view, DealSummary dealsummary)
    {
        DealCardListFragment.this.onDealCardClicked(i, view, dealsummary);
    }

    public void onWidgetDealCardClicked(View view, DealSummary dealsummary)
    {
        onMemberClick(view, dealsummary);
    }

    ter(ListAdapter listadapter, int i)
    {
        this$0 = DealCardListFragment.this;
        super(listadapter, i);
    }
}
