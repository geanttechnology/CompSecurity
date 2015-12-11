// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.analytics.Analytics;

// Referenced classes of package com.poshmark.ui.fragments:
//            FindFriendsFragment

class this._cls0
    implements android.view.dsFragment._cls1
{

    final FindFriendsFragment this$0;

    public void onClick(View view)
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "completed_on_ramp", null);
        finishActivity();
    }

    ()
    {
        this$0 = FindFriendsFragment.this;
        super();
    }
}
