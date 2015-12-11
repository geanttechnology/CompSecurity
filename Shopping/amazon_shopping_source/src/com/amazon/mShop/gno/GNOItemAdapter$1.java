// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import java.util.Collection;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.gno:
//            GNOItemAdapter

class val.items
    implements Runnable
{

    final GNOItemAdapter this$0;
    final Collection val$items;

    public void run()
    {
        GNOItemAdapter.access$000(GNOItemAdapter.this).clear();
        GNOItemAdapter.access$100(GNOItemAdapter.this, val$items);
        GNOItemAdapter.access$200(GNOItemAdapter.this);
        notifyDataSetChanged();
    }

    ()
    {
        this$0 = final_gnoitemadapter;
        val$items = Collection.this;
        super();
    }
}
