// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.view.ViewTreeObserver;

// Referenced classes of package com.ebay.mobile.myebay:
//            ScrollingTabView

class this._cls0
    implements android.view.GlobalLayoutListener
{

    final ScrollingTabView this$0;

    public void onGlobalLayout()
    {
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
        ScrollingTabView.access$302(ScrollingTabView.this, true);
        ScrollingTabView.access$400(ScrollingTabView.this, ScrollingTabView.access$000(ScrollingTabView.this), 0);
    }

    utListener()
    {
        this$0 = ScrollingTabView.this;
        super();
    }
}
