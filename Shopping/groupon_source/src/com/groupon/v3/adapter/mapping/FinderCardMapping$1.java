// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.view.View;
import com.groupon.db.models.Finder;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.view.callbacks.FinderCardCallback;
import com.groupon.v3.view.holder.GrouponViewHolder;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            FinderCardMapping

class  extends GrouponViewHolder
{

    final FinderCardMapping this$0;
    final UniversalListAdapter val$universalListAdapter;

    public void onClick(View view)
    {
        FinderCardCallback findercardcallback = (FinderCardCallback)getCallback(com/groupon/v3/view/callbacks/FinderCardCallback);
        if (findercardcallback != null)
        {
            findercardcallback.onFinderCardClicked(view, (Finder)val$universalListAdapter.getItem(getPosition()));
        }
    }

    (UniversalListAdapter universallistadapter)
    {
        this$0 = final_findercardmapping;
        val$universalListAdapter = universallistadapter;
        super(View.this);
    }
}
