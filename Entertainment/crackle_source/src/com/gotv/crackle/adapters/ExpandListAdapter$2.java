// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.gotv.crackle.Application;
import com.gotv.crackle.model.MediaListItem;

// Referenced classes of package com.gotv.crackle.adapters:
//            ExpandListAdapter

class val.childItem
    implements android.view.
{

    final ExpandListAdapter this$0;
    final MediaListItem val$childItem;

    public void onClick(View view)
    {
        ExpandListAdapter.access$100(ExpandListAdapter.this).onChildItemClicked(val$childItem);
        if (Application.getInstance().isTablet())
        {
            if (ExpandListAdapter.access$200(ExpandListAdapter.this) != null)
            {
                ExpandListAdapter.access$200(ExpandListAdapter.this).setBackgroundColor(ExpandListAdapter.access$000(ExpandListAdapter.this).getResources().getColor(0x7f07001b));
            }
            view.setBackgroundColor(ExpandListAdapter.access$000(ExpandListAdapter.this).getResources().getColor(0x7f070021));
            ExpandListAdapter.access$202(ExpandListAdapter.this, view);
            ExpandListAdapter.access$302(ExpandListAdapter.this, val$childItem.getID());
        }
    }

    pandListListener()
    {
        this$0 = final_expandlistadapter;
        val$childItem = MediaListItem.this;
        super();
    }
}
