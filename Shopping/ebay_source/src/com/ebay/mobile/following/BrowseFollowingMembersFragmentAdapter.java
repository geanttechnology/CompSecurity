// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.following;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import com.ebay.mobile.common.view.RecyclerContentAdapter;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.following:
//            FollowedMemberViewHolder, NestedLinearLayoutManager, NestedGridLayoutManager, FollowedMemberViewModel

public class BrowseFollowingMembersFragmentAdapter extends RecyclerContentAdapter
{

    private static final int VIEW_TYPE_ITEM = 0;
    private final boolean isTablet;

    public BrowseFollowingMembersFragmentAdapter(Context context, boolean flag)
    {
        super(context);
        if (!flag)
        {
            addViewType(0, com/ebay/mobile/following/FollowedMemberViewHolder, 0x7f030032);
        } else
        {
            addViewType(0, com/ebay/mobile/following/FollowedMemberViewHolder, 0x7f030091);
        }
        isTablet = context.getResources().getBoolean(0x7f0b0006);
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

    public void setContents(List list)
    {
        dataSet.clear();
        if (list != null)
        {
            com.ebay.nautilus.domain.data.FollowingContent.FollowedUser followeduser;
            for (list = list.iterator(); list.hasNext(); dataSet.add(new FollowedMemberViewModel(0, followeduser, getOnClickListener(0))))
            {
                followeduser = (com.ebay.nautilus.domain.data.FollowingContent.FollowedUser)list.next();
            }

        }
        notifyDataSetChanged();
    }
}
