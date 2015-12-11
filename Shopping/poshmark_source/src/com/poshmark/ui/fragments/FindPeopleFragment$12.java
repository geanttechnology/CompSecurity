// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.ui.PMActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            FindPeopleFragment, UserListFragment

class this._cls0
    implements android.view.eFragment._cls12
{

    final FindPeopleFragment this$0;

    public void onClick(View view)
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "load_new_closets", null);
        view = new Bundle();
        view.putString("ID", PMApplicationSession.GetPMSession().getUserId());
        view.putString("MODE", LIST_MODE.NEWLY_OPENED_CLOSETS.name());
        PMActivity pmactivity = getParentActivity();
        if (pmactivity != null && pmactivity.isActivityInForeground())
        {
            pmactivity.launchFragment(view, com/poshmark/ui/fragments/UserListFragment, null);
        }
    }

    LIST_MODE()
    {
        this$0 = FindPeopleFragment.this;
        super();
    }
}
