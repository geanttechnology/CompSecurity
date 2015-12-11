// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.content.Context;
import android.view.View;
import com.groupon.db.models.DealSummary;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.adapter.widget.WidgetPartV3;
import com.groupon.v3.view.holder.GrouponViewHolder;
import com.groupon.view.DealSetCallbacks;
import com.groupon.view.dealcards.DefaultLargeDealCard;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            Mapping

public class WidgetDefaultLargeDealCardMapping extends Mapping
{

    public WidgetDefaultLargeDealCardMapping()
    {
        super(com/groupon/v3/adapter/mapping/WidgetDefaultLargeDealCardMapping);
    }

    public void bindView(int i, android.support.v7.widget.RecyclerView.ViewHolder viewholder, UniversalListAdapter universallistadapter)
    {
        universallistadapter = (WidgetPartV3)universallistadapter.getItem(i);
        viewholder.itemView.setTag(0x7f100001, universallistadapter.getDealSummary());
        ((DefaultLargeDealCard)viewholder.itemView).setInfoWithPlace(universallistadapter.getDealSummary(), null);
    }

    public View createView(Context context)
    {
        return new DefaultLargeDealCard(context);
    }

    public android.support.v7.widget.RecyclerView.ViewHolder createViewHolder(Context context, DealSetCallbacks dealsetcallbacks)
    {
        return new GrouponViewHolder(dealsetcallbacks) {

            final WidgetDefaultLargeDealCardMapping this$0;
            final DealSetCallbacks val$dealSetCallbacks;

            public void onClick(View view)
            {
                DealSummary dealsummary = (DealSummary)view.getTag(0x7f100001);
                if (dealSetCallbacks != null)
                {
                    dealSetCallbacks.onMemberClick(view, dealsummary);
                }
            }

            
            {
                this$0 = WidgetDefaultLargeDealCardMapping.this;
                dealSetCallbacks = dealsetcallbacks;
                super(final_view);
            }
        };
    }

    public boolean getSpanAllColumns()
    {
        return true;
    }
}
