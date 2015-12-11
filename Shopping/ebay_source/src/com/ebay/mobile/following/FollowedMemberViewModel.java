// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.following;

import com.ebay.mobile.common.view.ViewModel;

public class FollowedMemberViewModel extends ViewModel
{

    public final String userId;
    public final String username;

    public FollowedMemberViewModel(int i, com.ebay.nautilus.domain.data.FollowingContent.FollowedUser followeduser, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        super(i, onclicklistener);
        userId = followeduser.userId;
        username = followeduser.username;
    }
}
