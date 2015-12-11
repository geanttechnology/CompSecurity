// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.widget.ListView;

// Referenced classes of package com.ebay.mobile.activities:
//            RecentlyViewedItemsActivity

class this._cls0
    implements com.ebay.common.Activity._cls3
{

    final RecentlyViewedItemsActivity this$0;

    public void OnTimer()
    {
        ((centlyViewedItemsAdapter)getListView().getAdapter()).refresh(getListView());
    }

    centlyViewedItemsAdapter()
    {
        this$0 = RecentlyViewedItemsActivity.this;
        super();
    }
}
