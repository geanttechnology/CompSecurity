// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.data_model.models.UserReferenceList;
import com.poshmark.fb_tmblr_twitter.FBPermissionStates;
import com.poshmark.fb_tmblr_twitter.FbHelper;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            FindFriendsFragment

class this._cls0
    implements android.view.dsFragment._cls3
{

    final FindFriendsFragment this$0;

    public void onClick(View view)
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "load_facebook_friends", null);
        if (FbHelper.getInstance().isPermissionEnabled(FBPermissionStates.FRIENDS_PERMISSION) && fbList != null && fbList.getConnectionInfoList().size() > 0)
        {
            FindFriendsFragment.access$000(FindFriendsFragment.this, fbList, LIST_MODE.FB_FRIENDS_MODE);
            return;
        } else
        {
            FbHelper.getInstance().link(FindFriendsFragment.this, 5, 5, FbHelper.FB_CONNECT_FRIENDS_REQUEST);
            return;
        }
    }

    LIST_MODE()
    {
        this$0 = FindFriendsFragment.this;
        super();
    }
}
