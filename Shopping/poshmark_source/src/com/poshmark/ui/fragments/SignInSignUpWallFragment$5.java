// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.ui.PMActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            SignInSignUpWallFragment, SignupFormFragment

class this._cls0
    implements android.view.llFragment._cls5
{

    final SignInSignUpWallFragment this$0;

    public void onClick(View view)
    {
        ((PMActivity)getActivity()).launchFragment(null, com/poshmark/ui/fragments/SignupFormFragment, null);
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "email_signup_flow_initiated", null);
    }

    ()
    {
        this$0 = SignInSignUpWallFragment.this;
        super();
    }
}
