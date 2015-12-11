// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.view.View;
import com.groupon.db.models.DealCollection;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.view.callbacks.CollectionCardCallback;
import com.groupon.v3.view.holder.GrouponViewHolder;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            CollectionCardMapping

class val.universalListAdapter extends GrouponViewHolder
{

    final CollectionCardMapping this$0;
    final UniversalListAdapter val$universalListAdapter;

    public void onClick(View view)
    {
        CollectionCardCallback collectioncardcallback = (CollectionCardCallback)getCallback(com/groupon/v3/view/callbacks/CollectionCardCallback);
        if (collectioncardcallback != null)
        {
            collectioncardcallback.onCollectionCardClicked(view, (DealCollection)val$universalListAdapter.getItem(getPosition()));
        }
    }

    (UniversalListAdapter universallistadapter)
    {
        this$0 = final_collectioncardmapping;
        val$universalListAdapter = universallistadapter;
        super(View.this);
    }
}
