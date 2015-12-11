// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import com.ebay.mobile.Item;
import com.ebay.mobile.util.ContentSyncManager;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewActivity

static final class val.item
    implements Runnable
{

    final Item val$item;

    public void run()
    {
        ContentSyncManager.notifyUpdate(val$item, com/ebay/mobile/Item.getName());
    }

    (Item item1)
    {
        val$item = item1;
        super();
    }
}
