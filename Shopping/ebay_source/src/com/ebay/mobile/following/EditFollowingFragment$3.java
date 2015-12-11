// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.following;

import android.content.DialogInterface;
import android.view.View;
import com.ebay.common.content.dm.FollowedEntityDataManager;
import com.ebay.common.model.followinterest.FollowType;
import com.ebay.mobile.common.view.ViewModel;
import java.util.HashMap;

// Referenced classes of package com.ebay.mobile.following:
//            EditFollowingFragment, FollowedSearchViewModel

class val.model
    implements android.content.istener
{

    final EditFollowingFragment this$0;
    final FollowedSearchViewModel val$followedSearchViewModel;
    final String val$iafToken;
    final ViewModel val$model;
    final View val$view;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        followedEntityDataManager.deleteFollow(FollowType.INTEREST, val$followedSearchViewModel.id, val$iafToken);
        val$view.setEnabled(false);
        updatePendingMap.put(val$followedSearchViewModel.id, new ndingFollowUpdate(val$view, val$model));
    }

    ndingFollowUpdate()
    {
        this$0 = final_editfollowingfragment;
        val$followedSearchViewModel = followedsearchviewmodel;
        val$iafToken = s;
        val$view = view1;
        val$model = ViewModel.this;
        super();
    }
}
