// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.connection.myebay;

import android.support.v4.widget.SwipeRefreshLayout;

// Referenced classes of package com.ebay.mobile.connection.myebay:
//            MyEbayListFragmentBase

class this._cls0
    implements android.support.v4.widget.eshListener
{

    final MyEbayListFragmentBase this$0;

    public void onRefresh()
    {
        pullToRefresh.setRefreshing(false);
        invalidate();
    }

    ner()
    {
        this$0 = MyEbayListFragmentBase.this;
        super();
    }
}
