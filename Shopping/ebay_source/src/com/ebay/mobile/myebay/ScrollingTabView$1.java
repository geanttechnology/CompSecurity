// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.support.v4.view.ViewPager;
import android.view.View;

// Referenced classes of package com.ebay.mobile.myebay:
//            ScrollingTabView

class this._cls0
    implements android.view.r
{

    final ScrollingTabView this$0;

    public void onClick(View view)
    {
        int i = ((Integer)view.getTag()).intValue();
        if (ScrollingTabView.access$000(ScrollingTabView.this) == i && ScrollingTabView.access$100(ScrollingTabView.this) != null)
        {
            ScrollingTabView.access$100(ScrollingTabView.this).onTabReselected(ScrollingTabView.access$000(ScrollingTabView.this));
        }
        ScrollingTabView.access$200(ScrollingTabView.this).setCurrentItem(i);
    }

    CurrentTabReselected()
    {
        this$0 = ScrollingTabView.this;
        super();
    }
}
