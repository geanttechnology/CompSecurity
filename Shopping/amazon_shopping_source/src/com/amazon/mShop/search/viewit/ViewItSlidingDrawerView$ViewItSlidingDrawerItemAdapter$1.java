// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.view.View;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItSlidingDrawerView, ViewItItemView

class val.itemView
    implements Runnable
{

    final val.itemView this$1;
    final ViewItItemView val$itemView;

    public void run()
    {
        if (ViewItSlidingDrawerView.access$200(_fld0).getVisibility() == 8)
        {
            setBottomOffsetToFirstItemHeight(val$itemView);
        }
    }

    ()
    {
        this$1 = final_;
        val$itemView = ViewItItemView.this;
        super();
    }
}
