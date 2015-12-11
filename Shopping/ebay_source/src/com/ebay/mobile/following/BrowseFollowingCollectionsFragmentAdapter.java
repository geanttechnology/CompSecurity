// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.following;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import com.ebay.mobile.common.view.RecyclerContentAdapter;
import com.ebay.nautilus.domain.analytics.DeviceInfoUtil;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.following:
//            FollowedCollectionViewHolder, NestedLinearLayoutManager, NestedGridLayoutManager, FollowedCollectionViewModel

public class BrowseFollowingCollectionsFragmentAdapter extends RecyclerContentAdapter
{

    private static final int VIEW_TYPE_ITEM = 0;
    private final boolean isLandscape;
    private final boolean isTablet;

    public BrowseFollowingCollectionsFragmentAdapter(Context context, boolean flag)
    {
        boolean flag1 = false;
        super(context);
        if (!flag)
        {
            addViewType(0, com/ebay/mobile/following/FollowedCollectionViewHolder, 0x7f030040);
        } else
        {
            addViewType(0, com/ebay/mobile/following/FollowedCollectionViewHolder, 0x7f03008f);
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
        return !isTablet && !isLandscape ? 1 : 2;
    }

    public void setContents(List list)
    {
        dataSet.clear();
        if (list != null)
        {
            com.ebay.nautilus.domain.data.FollowingContent.FollowedCollection followedcollection;
            for (list = list.iterator(); list.hasNext(); dataSet.add(new FollowedCollectionViewModel(0, followedcollection, getOnClickListener(0))))
            {
                followedcollection = (com.ebay.nautilus.domain.data.FollowingContent.FollowedCollection)list.next();
            }

        }
        notifyDataSetChanged();
    }
}
