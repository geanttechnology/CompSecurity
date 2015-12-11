// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.analytics.Analytics;

// Referenced classes of package com.poshmark.ui.fragments:
//            SignInSignUpWallFragment

class this._cls0
    implements android.view.llFragment._cls2
{

    final SignInSignUpWallFragment this$0;

    public void onClick(View view)
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "fb_connect_click", null);
        SignInSignUpWallFragment.access$000(SignInSignUpWallFragment.this);
    }

    ()
    {
        this$0 = SignInSignUpWallFragment.this;
        super();
    }
}
