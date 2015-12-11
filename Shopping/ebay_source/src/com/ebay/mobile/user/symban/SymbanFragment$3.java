// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.user.symban;

import android.support.v4.widget.SwipeRefreshLayout;

// Referenced classes of package com.ebay.mobile.user.symban:
//            SymbanFragment

class this._cls0
    implements android.support.v4.widget.t.OnRefreshListener
{

    final SymbanFragment this$0;

    public void onRefresh()
    {
        refreshLayout.setRefreshing(true);
        refresh();
    }

    OnRefreshListener()
    {
        this$0 = SymbanFragment.this;
        super();
    }
}
