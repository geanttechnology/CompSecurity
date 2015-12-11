// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.Channel;
import com.groupon.manager.AnyChannelSyncManager;
import com.groupon.manager.GoodsSyncManager;
import com.groupon.manager.ShoppingSyncManager;
import commonlib.manager.PaginatedSyncManager;

// Referenced classes of package com.groupon.fragment:
//            Goods

public class Shopping extends Goods
{

    ShoppingSyncManager shoppingSyncManager;

    public Shopping()
    {
        super(Channel.SHOPPING);
    }

    public volatile AnyChannelSyncManager getSyncManager()
    {
        return getSyncManager();
    }

    public GoodsSyncManager getSyncManager()
    {
        return shoppingSyncManager;
    }

    public volatile PaginatedSyncManager getSyncManager()
    {
        return getSyncManager();
    }
}
