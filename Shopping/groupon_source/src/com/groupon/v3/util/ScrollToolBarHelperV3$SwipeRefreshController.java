// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.util;

import android.support.v7.widget.Toolbar;
import android.view.View;
import com.groupon.util.SwipeRefreshManager;
import com.groupon.view.PagerSlidingTabStrip;

// Referenced classes of package com.groupon.v3.util:
//            ScrollToolBarHelperV3

protected class this._cls0
    implements SwipeRefreshManager
{

    final ScrollToolBarHelperV3 this$0;

    public boolean canSwipeRefresh()
    {
        boolean flag;
        if (ScrollToolBarHelperV3.access$200(ScrollToolBarHelperV3.this).getY() == (float)(ScrollToolBarHelperV3.access$100(ScrollToolBarHelperV3.this).getHeight() + ScrollToolBarHelperV3.access$000(ScrollToolBarHelperV3.this).getHeight()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    protected ()
    {
        this$0 = ScrollToolBarHelperV3.this;
        super();
    }
}
