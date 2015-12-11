// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import com.groupon.v3.view.GrouponSwipeRefreshLayoutV3;

// Referenced classes of package com.groupon.util:
//            BaseRecyclerViewDelegate

private class swipeLayout
    implements Runnable
{

    private GrouponSwipeRefreshLayoutV3 swipeLayout;
    final BaseRecyclerViewDelegate this$0;

    public void run()
    {
        swipeLayout.setRefreshing(true);
    }

    public (GrouponSwipeRefreshLayoutV3 grouponswiperefreshlayoutv3)
    {
        this$0 = BaseRecyclerViewDelegate.this;
        super();
        swipeLayout = grouponswiperefreshlayoutv3;
    }
}
