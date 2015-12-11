// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import com.ebay.mobile.Item;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewBiddingUpdater

class val.item
    implements com.ebay.common.pdater._cls1
{

    final ItemViewBiddingUpdater this$0;
    final Item val$item;

    public void OnTimer()
    {
        if (updateMode == dateMode.NONE && val$item.isListingTypeBid && !val$item.finalized && !val$item.isTransacted)
        {
            ItemViewBiddingUpdater.access$100(ItemViewBiddingUpdater.this);
        }
    }

    dateMode()
    {
        this$0 = final_itemviewbiddingupdater;
        val$item = Item.this;
        super();
    }
}
