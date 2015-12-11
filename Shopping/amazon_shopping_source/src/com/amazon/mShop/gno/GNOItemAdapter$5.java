// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import com.amazon.mShop.AmazonActivity;

// Referenced classes of package com.amazon.mShop.gno:
//            GNOItemAdapter, GNODrawer

class val.activity
    implements Runnable
{

    final GNOItemAdapter this$0;
    final AmazonActivity val$activity;

    public void run()
    {
        GNODrawer gnodrawer = val$activity.getGNODrawer();
        if (!gnodrawer.isItemDisplayed(GNOItemAdapter.access$400(GNOItemAdapter.this)))
        {
            gnodrawer.scrollItemToTop(GNOItemAdapter.access$400(GNOItemAdapter.this));
        }
    }

    ()
    {
        this$0 = final_gnoitemadapter;
        val$activity = AmazonActivity.this;
        super();
    }
}
