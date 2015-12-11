// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.support.v7.widget.Toolbar;
import android.view.View;
import com.groupon.view.PagerSlidingTabStrip;

// Referenced classes of package com.groupon.util:
//            SwipeRefreshManager, ScrollToolBarHelper

protected class this._cls0
    implements SwipeRefreshManager
{

    final ScrollToolBarHelper this$0;

    public boolean canSwipeRefresh()
    {
        return ScrollToolBarHelper.access$200(ScrollToolBarHelper.this).getY() == (float)(ScrollToolBarHelper.access$100(ScrollToolBarHelper.this).getHeight() + ScrollToolBarHelper.access$000(ScrollToolBarHelper.this).getHeight());
    }

    protected A()
    {
        this$0 = ScrollToolBarHelper.this;
        super();
    }
}
