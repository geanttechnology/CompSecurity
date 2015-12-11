// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.data_model.models.UserReferenceList;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            FindFriendsFragment

class this._cls0
    implements android.view.dsFragment._cls4
{

    final FindFriendsFragment this$0;

    public void onClick(View view)
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "onramp_suggested_users_viewed", null);
        if (suggestedUserList != null && suggestedUserList.getConnectionInfoList().size() > 0)
        {
            FindFriendsFragment.access$000(FindFriendsFragment.this, suggestedUserList, LIST_MODE.SUGGESTED_USERS_MODE);
        }
    }

    LIST_MODE()
    {
        this$0 = FindFriendsFragment.this;
        super();
    }
}
