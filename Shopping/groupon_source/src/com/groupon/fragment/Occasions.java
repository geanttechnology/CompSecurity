// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.Channel;
import com.groupon.manager.AnyChannelSyncManager;
import com.groupon.manager.OccasionsSyncManager;
import com.groupon.tracking.mobile.sdk.Logger;
import commonlib.manager.PaginatedSyncManager;

// Referenced classes of package com.groupon.fragment:
//            DealCardListFragment

public class Occasions extends DealCardListFragment
{

    private OccasionsSyncManager occasionsSyncManager;

    public Occasions()
    {
        super(Channel.OCCASIONS);
    }

    public volatile AnyChannelSyncManager getSyncManager()
    {
        return getSyncManager();
    }

    public OccasionsSyncManager getSyncManager()
    {
        return occasionsSyncManager;
    }

    public volatile PaginatedSyncManager getSyncManager()
    {
        return getSyncManager();
    }

    public void setUserVisibleHint(boolean flag)
    {
        super.setUserVisibleHint(flag);
        if (flag)
        {
            String s = getClass().getSimpleName();
            logger.logPageView("", s, Logger.NULL_NST_FIELD);
        }
    }
}
