// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.lists;

import android.support.v4.widget.SwipeRefreshLayout;

// Referenced classes of package com.ebay.mobile.sell.lists:
//            ListingDraftListFragment

class this._cls0
    implements android.support.v4.widget.hListener
{

    final ListingDraftListFragment this$0;

    public void onRefresh()
    {
        refreshLayout.setRefreshing(false);
        invalidate();
    }

    Listener()
    {
        this$0 = ListingDraftListFragment.this;
        super();
    }
}
