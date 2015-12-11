// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;


// Referenced classes of package com.amazon.mShop.gno:
//            GNOItemAdapter

class this._cls0
    implements Runnable
{

    final GNOItemAdapter this$0;

    public void run()
    {
        GNOItemAdapter.access$200(GNOItemAdapter.this);
        notifyDataSetChanged();
    }

    ()
    {
        this$0 = GNOItemAdapter.this;
        super();
    }
}
