// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import com.ebay.mobile.widget.EbayScrollView;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewActivity

class val.scrollY
    implements Runnable
{

    final ItemViewActivity this$0;
    final EbayScrollView val$scrollView;
    final int val$scrollY;

    public void run()
    {
        val$scrollView.scrollTo(0, val$scrollY);
    }

    ()
    {
        this$0 = final_itemviewactivity;
        val$scrollView = ebayscrollview;
        val$scrollY = I.this;
        super();
    }
}
