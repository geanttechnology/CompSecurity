// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.following;

import com.ebay.mobile.common.view.ViewModel;
import java.util.List;

public class FollowedSearchViewModel extends ViewModel
{

    public final List categoryId;
    public final com.ebay.nautilus.domain.data.Feed.Entities.Interest.Constraints constraints;
    public final boolean hasNewItems;
    public final String id;
    public Boolean isNotifyEnabled;
    public final String title;

    public FollowedSearchViewModel(int i, com.ebay.nautilus.domain.data.FollowingContent.FollowedInterest followedinterest, boolean flag, Boolean boolean1, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        Object obj = null;
        super(i, onclicklistener);
        id = followedinterest.interestId;
        title = followedinterest.getDisplayTitle();
        if (followedinterest.searchRequest != null)
        {
            onclicklistener = followedinterest.searchRequest.categoryId;
        } else
        {
            onclicklistener = null;
        }
        categoryId = onclicklistener;
        onclicklistener = obj;
        if (followedinterest.searchRequest != null)
        {
            onclicklistener = followedinterest.searchRequest.constraints;
        }
        constraints = onclicklistener;
        hasNewItems = flag;
        isNotifyEnabled = boolean1;
    }
}
