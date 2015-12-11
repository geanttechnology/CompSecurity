// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.following;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import com.ebay.mobile.common.view.RecyclerContentAdapter;
import com.ebay.mobile.notifications.ItemCache;
import com.ebay.mobile.notifications.NotificationPreferenceManager;
import com.ebay.mobile.notifications.PollServiceListCache;
import com.ebay.nautilus.domain.analytics.DeviceInfoUtil;
import com.ebay.nautilus.domain.app.Authentication;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

// Referenced classes of package com.ebay.mobile.following:
//            FollowedSearchViewHolder, NestedLinearLayoutManager, NestedGridLayoutManager, FollowedSearchViewModel

public class BrowseFollowingSearchesFragmentAdapter extends RecyclerContentAdapter
{

    private static final int VIEW_TYPE_ITEM = 0;
    private final boolean isLandscape;
    private final boolean isTablet;

    public BrowseFollowingSearchesFragmentAdapter(Context context, boolean flag)
    {
        boolean flag1 = false;
        super(context);
        if (!flag)
        {
            addViewType(0, com/ebay/mobile/following/FollowedSearchViewHolder, 0x7f030034);
        } else
        {
            addViewType(0, com/ebay/mobile/following/FollowedSearchViewHolder, 0x7f030092);
        }
        isTablet = context.getResources().getBoolean(0x7f0b0006);
        flag = flag1;
        if (!DeviceInfoUtil.isPortrait(context))
        {
            flag = true;
        }
        isLandscape = flag;
    }

    public android.support.v7.widget.RecyclerView.LayoutManager createLayoutManager()
    {
        int i = getNumSpans();
        if (1 == i)
        {
            return new NestedLinearLayoutManager((Context)contextReference.get(), 1, false);
        } else
        {
            NestedGridLayoutManager nestedgridlayoutmanager = new NestedGridLayoutManager((Context)contextReference.get(), i, 1, false);
            nestedgridlayoutmanager.setSpanSizeLookup(new android.support.v7.widget.GridLayoutManager.DefaultSpanSizeLookup());
            return nestedgridlayoutmanager;
        }
    }

    public int getNumSpans()
    {
        if (isTablet && isLandscape)
        {
            return 3;
        }
        return !isTablet && !isLandscape ? 1 : 2;
    }

    public void removeItem(FollowedSearchViewModel followedsearchviewmodel)
    {
        dataSet.remove(followedsearchviewmodel);
        notifyDataSetChanged();
    }

    public void setContents(List list)
    {
        setContents(list, null, null, null);
    }

    public void setContents(List list, ItemCache itemcache, NotificationPreferenceManager notificationpreferencemanager, Authentication authentication)
    {
        dataSet.clear();
        if (list == null) goto _L2; else goto _L1
_L1:
        boolean flag;
        boolean flag1;
        Iterator iterator;
        com.ebay.nautilus.domain.data.FollowingContent.FollowedInterest followedinterest;
        if (itemcache != null)
        {
            itemcache = itemcache.getSavedSearches();
        } else
        {
            itemcache = null;
        }
        iterator = list.iterator();
        if (!iterator.hasNext()) goto _L2; else goto _L3
_L3:
        followedinterest = (com.ebay.nautilus.domain.data.FollowingContent.FollowedInterest)iterator.next();
        flag1 = false;
        flag = flag1;
        if (itemcache == null) goto _L5; else goto _L4
_L4:
        flag = flag1;
        if (followedinterest.interestId == null) goto _L5; else goto _L6
_L6:
        list = (com.ebay.mobile.notifications.PollService.SavedSearchPollData)itemcache.get(Long.valueOf(Long.parseLong(followedinterest.interestId)));
        if (list == null) goto _L8; else goto _L7
_L7:
        flag = PollServiceListCache.hasNew(list);
        if (!flag) goto _L8; else goto _L9
_L9:
        flag = true;
_L5:
        if (notificationpreferencemanager != null && authentication != null)
        {
            list = Boolean.valueOf(notificationpreferencemanager.isNotifyEnabledForSavedSearch(authentication.user, followedinterest.interestId));
        } else
        {
            list = null;
        }
        dataSet.add(new FollowedSearchViewModel(0, followedinterest, flag, list, getOnClickListener(0)));
        break MISSING_BLOCK_LABEL_30;
_L8:
        flag = false;
        continue; /* Loop/switch isn't completed */
_L2:
        notifyDataSetChanged();
        return;
        list;
        flag = flag1;
        if (true) goto _L5; else goto _L10
_L10:
    }
}
