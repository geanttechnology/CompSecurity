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
//            UserSettingsFragment, MappPageFragment

class this._cls0
    implements android.view.gsFragment._cls1
{

    final UserSettingsFragment this$0;

    public void onClick(View view)
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "account_balance_button_tapped", null);
        view = new Bundle();
        view.putString("URL", (new StringBuilder()).append("https://www.poshmark.com/mapp/users/").append(PMApplicationSession.GetPMSession().getUserId()).append("/account_list").append("?pageName=USER_ACCOUNT-account_list").toString());
        view.putString("ANALYTICS_PAGE_NAME", "account_balances_screen");
        ((PMActivity)getActivity()).launchFragmentInNewActivity(view, com/poshmark/ui/fragments/MappPageFragment, null);
    }

    ()
    {
        this$0 = UserSettingsFragment.this;
        super();
    }
}
