// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import android.widget.ListAdapter;
import com.groupon.db.models.DealSummary;
import com.groupon.util.DealCardMultiColumnListAdapter;

// Referenced classes of package com.groupon.fragment:
//            PartitionedDealSubsetFragment

class > extends DealCardMultiColumnListAdapter
{

    final PartitionedDealSubsetFragment this$0;

    public void onDealCardClicked(int i, View view, DealSummary dealsummary)
    {
        PartitionedDealSubsetFragment.this.onDealCardClicked(i, view, dealsummary);
    }

    public void onWidgetDealCardClicked(View view, DealSummary dealsummary)
    {
        onMemberClick(view, dealsummary);
    }

    (ListAdapter listadapter, int i)
    {
        this$0 = PartitionedDealSubsetFragment.this;
        super(listadapter, i);
    }
}
