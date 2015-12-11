// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.view.View;
import com.groupon.db.models.Business;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.view.callbacks.BusinessCardCallback;
import com.groupon.v3.view.holder.GrouponViewHolder;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            BusinessCardMapping

class val.universalListAdapter extends GrouponViewHolder
{

    final BusinessCardMapping this$0;
    final UniversalListAdapter val$universalListAdapter;

    public void onClick(View view)
    {
        BusinessCardCallback businesscardcallback = (BusinessCardCallback)getCallback(com/groupon/v3/view/callbacks/BusinessCardCallback);
        if (businesscardcallback != null)
        {
            businesscardcallback.onBusinessCardClicked(view, (Business)val$universalListAdapter.getItem(getPosition()));
        }
    }

    (UniversalListAdapter universallistadapter)
    {
        this$0 = final_businesscardmapping;
        val$universalListAdapter = universallistadapter;
        super(View.this);
    }
}
