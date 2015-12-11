// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.content.Context;
import android.view.View;
import com.groupon.db.models.DealCollection;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.view.callbacks.CollectionCardCallback;
import com.groupon.v3.view.holder.GrouponViewHolder;
import com.groupon.view.widgetcards.CollectionCardView;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            Mapping

public abstract class CollectionCardMapping extends Mapping
{

    public CollectionCardMapping()
    {
        super(com/groupon/db/models/DealCollection);
    }

    public void bindView(int i, android.support.v7.widget.RecyclerView.ViewHolder viewholder, UniversalListAdapter universallistadapter)
    {
        universallistadapter = (DealCollection)universallistadapter.getItem(i);
        if (viewholder.itemView instanceof CollectionCardView)
        {
            viewholder = (CollectionCardView)viewholder.itemView;
            viewholder.updateContent(universallistadapter);
            viewholder.setTag(0x7f100001, universallistadapter);
            viewholder = (CollectionCardCallback)getCallback(com/groupon/v3/view/callbacks/CollectionCardCallback);
            if (viewholder != null)
            {
                viewholder.onCollectionCardBound(universallistadapter);
            }
        }
    }

    public android.support.v7.widget.RecyclerView.ViewHolder createViewHolder(Context context, UniversalListAdapter universallistadapter)
    {
        return getHolderWithCallback(context, universallistadapter);
    }

    protected GrouponViewHolder getHolderWithCallback(Context context, UniversalListAdapter universallistadapter)
    {
        return new GrouponViewHolder(universallistadapter) {

            final CollectionCardMapping this$0;
            final UniversalListAdapter val$universalListAdapter;

            public void onClick(View view)
            {
                CollectionCardCallback collectioncardcallback = (CollectionCardCallback)getCallback(com/groupon/v3/view/callbacks/CollectionCardCallback);
                if (collectioncardcallback != null)
                {
                    collectioncardcallback.onCollectionCardClicked(view, (DealCollection)universalListAdapter.getItem(getPosition()));
                }
            }

            
            {
                this$0 = CollectionCardMapping.this;
                universalListAdapter = universallistadapter;
                super(final_view);
            }
        };
    }
}
