// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewActivity

class val.visibility
    implements android.view.GlobalLayoutListener
{

    final ItemViewActivity this$0;
    final LinearLayout val$googleTextAdContainer;
    final int val$visibility;

    public void onGlobalLayout()
    {
        val$googleTextAdContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        val$googleTextAdContainer.setVisibility(val$visibility);
        ItemViewActivity.access$700(ItemViewActivity.this, val$googleTextAdContainer);
    }

    Listener()
    {
        this$0 = final_itemviewactivity;
        val$googleTextAdContainer = linearlayout;
        val$visibility = I.this;
        super();
    }
}
