// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.content.Context;
import android.view.View;
import com.groupon.db.models.Business;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.view.callbacks.BusinessCardCallback;
import com.groupon.v3.view.holder.GrouponViewHolder;
import com.groupon.view.BusinessExactMatchCardView;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            Mapping

public class BusinessCardMapping extends Mapping
{

    public BusinessCardMapping()
    {
        super(com/groupon/db/models/Business);
    }

    public void bindView(int i, android.support.v7.widget.RecyclerView.ViewHolder viewholder, UniversalListAdapter universallistadapter)
    {
        universallistadapter = (Business)universallistadapter.getItem(i);
        ((BusinessExactMatchCardView)(BusinessExactMatchCardView)viewholder.itemView).setInfo(universallistadapter);
        viewholder.itemView.setTag(0x7f100001, universallistadapter);
        viewholder = (BusinessCardCallback)getCallback(com/groupon/v3/view/callbacks/BusinessCardCallback);
        if (viewholder != null)
        {
            viewholder.onBusinessCardBound(universallistadapter);
        }
    }

    public View createView(Context context)
    {
        return new BusinessExactMatchCardView(context);
    }

    public android.support.v7.widget.RecyclerView.ViewHolder createViewHolder(Context context, UniversalListAdapter universallistadapter)
    {
        return getHolderWithCallback(context, universallistadapter);
    }

    protected GrouponViewHolder getHolderWithCallback(Context context, UniversalListAdapter universallistadapter)
    {
        return new GrouponViewHolder(universallistadapter) {

            final BusinessCardMapping this$0;
            final UniversalListAdapter val$universalListAdapter;

            public void onClick(View view)
            {
                BusinessCardCallback businesscardcallback = (BusinessCardCallback)getCallback(com/groupon/v3/view/callbacks/BusinessCardCallback);
                if (businesscardcallback != null)
                {
                    businesscardcallback.onBusinessCardClicked(view, (Business)universalListAdapter.getItem(getPosition()));
                }
            }

            
            {
                this$0 = BusinessCardMapping.this;
                universalListAdapter = universallistadapter;
                super(final_view);
            }
        };
    }
}
