// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.content.Context;
import android.view.View;
import com.groupon.db.models.BusinessSummary;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.adapter.callback.IViewCallback;
import com.groupon.view.PoGSearchRecommendationCardListView;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            Mapping

public class PoGBusinessSearchRecommendationMapping extends Mapping
{

    public PoGBusinessSearchRecommendationMapping()
    {
        super(com/groupon/db/models/BusinessSummary);
    }

    public void bindView(int i, android.support.v7.widget.RecyclerView.ViewHolder viewholder, UniversalListAdapter universallistadapter)
    {
        universallistadapter = (BusinessSummary)universallistadapter.getItem(i);
        ((PoGSearchRecommendationCardListView)viewholder.itemView).setInfo(universallistadapter);
        viewholder.itemView.setTag(0x7f100001, universallistadapter);
        viewholder = (IViewCallback)getCallback(com/groupon/v3/adapter/callback/IViewCallback);
        if (viewholder != null)
        {
            viewholder.onViewBound(i, universallistadapter);
        }
    }

    public View createView(Context context)
    {
        return new PoGSearchRecommendationCardListView(context);
    }

    public android.support.v7.widget.RecyclerView.ViewHolder createViewHolder(Context context, UniversalListAdapter universallistadapter)
    {
        return getHolderWithCallback(context, universallistadapter);
    }
}
