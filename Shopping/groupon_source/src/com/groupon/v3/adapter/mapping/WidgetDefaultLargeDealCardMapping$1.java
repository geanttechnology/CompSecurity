// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.view.View;
import com.groupon.db.models.DealSummary;
import com.groupon.v3.view.holder.GrouponViewHolder;
import com.groupon.view.DealSetCallbacks;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            WidgetDefaultLargeDealCardMapping

class val.dealSetCallbacks extends GrouponViewHolder
{

    final WidgetDefaultLargeDealCardMapping this$0;
    final DealSetCallbacks val$dealSetCallbacks;

    public void onClick(View view)
    {
        DealSummary dealsummary = (DealSummary)view.getTag(0x7f100001);
        if (val$dealSetCallbacks != null)
        {
            val$dealSetCallbacks.onMemberClick(view, dealsummary);
        }
    }

    (DealSetCallbacks dealsetcallbacks)
    {
        this$0 = final_widgetdefaultlargedealcardmapping;
        val$dealSetCallbacks = dealsetcallbacks;
        super(View.this);
    }
}
