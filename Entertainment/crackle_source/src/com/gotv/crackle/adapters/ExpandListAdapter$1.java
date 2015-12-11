// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.adapters;

import android.view.View;
import com.gotv.crackle.base.BaseActivity;
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
        ((BaseActivity)ExpandListAdapter.access$000(ExpandListAdapter.this)).playMediaItem(val$childItem.getID());
    }

    ()
    {
        this$0 = final_expandlistadapter;
        val$childItem = MediaListItem.this;
        super();
    }
}
