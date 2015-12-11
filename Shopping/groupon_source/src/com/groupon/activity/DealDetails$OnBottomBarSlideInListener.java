// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.groupon.callbacks.OnBottomBarAnimationFinishedListener;
import com.groupon.callbacks.OnPageLoadComplete;

// Referenced classes of package com.groupon.activity:
//            DealDetails

private class <init>
    implements OnBottomBarAnimationFinishedListener
{

    final DealDetails this$0;

    public void onBottomBarAnimationFinished(View view)
    {
        if (DealDetails.access$3500(DealDetails.this) != null)
        {
            DealDetails.access$3500(DealDetails.this).onLoadComplete();
        }
        view = (android.widget.e)detailsRecyclerView.getLayoutParams();
        view.(2, 0x7f1000a0);
        detailsRecyclerView.setLayoutParams(view);
    }

    private A()
    {
        this$0 = DealDetails.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
