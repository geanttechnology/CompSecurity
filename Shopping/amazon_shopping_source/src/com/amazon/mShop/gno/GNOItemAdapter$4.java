// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.widget.ListView;
import com.amazon.mShop.AmazonActivity;

// Referenced classes of package com.amazon.mShop.gno:
//            GNOItemAdapter, GNODrawer

class val.activity
    implements Runnable
{

    final GNOItemAdapter this$0;
    final AmazonActivity val$activity;
    final boolean val$shouldShowExpandingArea;

    public void run()
    {
        if (val$shouldShowExpandingArea)
        {
            val$activity.getGNODrawer().getListView().setTranscriptMode(0);
        }
    }

    ()
    {
        this$0 = final_gnoitemadapter;
        val$shouldShowExpandingArea = flag;
        val$activity = AmazonActivity.this;
        super();
    }
}
