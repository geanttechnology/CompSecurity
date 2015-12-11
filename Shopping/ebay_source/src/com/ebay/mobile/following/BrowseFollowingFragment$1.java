// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.following;

import android.support.v4.widget.SwipeRefreshLayout;
import com.ebay.common.UserCache;
import com.ebay.nautilus.domain.content.dm.FollowingContentDataManager;
import com.ebay.nautilus.domain.content.dm.UssFeedDataManager;

// Referenced classes of package com.ebay.mobile.following:
//            BrowseFollowingFragment

class this._cls0
    implements android.support.v4.widget.shListener
{

    final BrowseFollowingFragment this$0;

    public void onRefresh()
    {
        if (followingContentDataManager != null)
        {
            refreshLayout.setRefreshing(true);
            followingContentDataManager.invalidateAndForceReloadData();
        }
        if (feedDataManager != null)
        {
            feedDataManager.invalidateAndForceReloadData();
        }
        (new UserCache(getBaseActivity())).refreshSavedSearchList();
    }

    er()
    {
        this$0 = BrowseFollowingFragment.this;
        super();
    }
}
