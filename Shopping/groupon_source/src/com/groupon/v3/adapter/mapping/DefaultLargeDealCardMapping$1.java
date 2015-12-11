// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.view.View;
import com.groupon.db.models.DealSummary;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.view.callbacks.DealCallbacks;
import com.groupon.v3.view.holder.GrouponViewHolder;
import com.groupon.v3.view.param.DealInfo;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            DefaultLargeDealCardMapping

class val.universalListAdapter extends GrouponViewHolder
{

    final DefaultLargeDealCardMapping this$0;
    final UniversalListAdapter val$universalListAdapter;

    public void onClick(View view)
    {
        DealCallbacks dealcallbacks = (DealCallbacks)getCallback(com/groupon/v3/view/callbacks/DealCallbacks);
        if (dealcallbacks != null)
        {
            dealcallbacks.onDealClick(view, new DealInfo((DealSummary)val$universalListAdapter.getItem(getPosition())));
        }
    }

    (UniversalListAdapter universallistadapter)
    {
        this$0 = final_defaultlargedealcardmapping;
        val$universalListAdapter = universallistadapter;
        super(View.this);
    }
}
