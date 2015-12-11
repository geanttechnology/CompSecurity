// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.analytics.Analytics;

// Referenced classes of package com.poshmark.ui.fragments:
//            UserSharesFragment

class this._cls0
    implements com.poshmark.ui.customviews.t.UserFollowButtonListener
{

    final UserSharesFragment this$0;

    public void onFollowClick()
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "follow_tapped", null);
    }

    public void onFollowingClick()
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "unfollow_tapped", null);
    }

    out.UserFollowButtonListener()
    {
        this$0 = UserSharesFragment.this;
        super();
    }
}
