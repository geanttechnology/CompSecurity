// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.home;

import com.amazon.rio.j2me.client.services.mShop.HomeItem;

// Referenced classes of package com.amazon.mShop.home:
//            HomeShovelerItemsAdapter

private class mRetryCounts
{

    private HomeItem mHomeItem;
    private int mRetryCounts;
    final HomeShovelerItemsAdapter this$0;

    public HomeItem getHomeShoveler()
    {
        return mHomeItem;
    }

    public int getRetryCounts()
    {
        return mRetryCounts;
    }

    public void setRetryCounts(int i)
    {
        mRetryCounts = i;
    }

    public (HomeItem homeitem, int i)
    {
        this$0 = HomeShovelerItemsAdapter.this;
        super();
        mRetryCounts = 0;
        mHomeItem = homeitem;
        mRetryCounts = i;
    }
}
