// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.lists;

import android.support.v4.widget.SwipeRefreshLayout;

// Referenced classes of package com.ebay.mobile.sell.lists:
//            SellListBaseFragment

class this._cls0
    implements android.support.v4.widget.freshListener
{

    final SellListBaseFragment this$0;

    public void onRefresh()
    {
        refreshLayout.setRefreshing(false);
        invalidate();
    }

    reshListener()
    {
        this$0 = SellListBaseFragment.this;
        super();
    }
}
