// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.notifications.ItemCache;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentSourceEnum;
import java.util.List;
import java.util.TreeMap;

public class FollowingViewModel extends ViewModel
{

    public final List followedInterests;
    public final List followedUsers;
    public final TreeMap pollMap;

    public FollowingViewModel(int i, com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup contentgroup, ItemCache itemcache, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        super(i, onclicklistener);
        if (contentgroup.contentSource != ContentSourceEnum.FOLLOW)
        {
            throw new IllegalArgumentException("contentGroup.contentSource doesn't match what this viewModel accepts");
        }
        if (contentgroup.contents != null && contentgroup.contents.size() > 0 && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)contentgroup.contents.get(0)).followedEntities != null)
        {
            contentgroup = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)contentgroup.contents.get(0)).followedEntities;
            followedUsers = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedEntities) (contentgroup)).followedUsers;
            followedInterests = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedEntities) (contentgroup)).followedInterests;
        } else
        {
            followedUsers = null;
            followedInterests = null;
        }
        pollMap = itemcache.getSavedSearches();
    }
}
