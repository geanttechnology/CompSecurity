// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.customviews.RoundedImageView;
import com.poshmark.user.UserInfoDetails;

// Referenced classes of package com.poshmark.ui.fragments:
//            ClosetFragment, AboutMePageFragment

class this._cls0
    implements android.view.er
{

    final ClosetFragment this$0;

    public void onClick(View view)
    {
        if (ClosetFragment.access$100(ClosetFragment.this) != null)
        {
            if (view instanceof RoundedImageView)
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "profile_image_tapped", null);
            }
            view = new Bundle();
            view.putString("URL", (new StringBuilder()).append("https://www.poshmark.com/mapp/users/").append(ClosetFragment.access$100(ClosetFragment.this).getPMUserId()).append("/about_me").toString());
            view.putString("ANALYTICS_PAGE_NAME", "AboutPage");
            ((PMActivity)getActivity()).launchFragmentInNewActivity(view, com/poshmark/ui/fragments/AboutMePageFragment, null);
        }
    }

    t()
    {
        this$0 = ClosetFragment.this;
        super();
    }
}
