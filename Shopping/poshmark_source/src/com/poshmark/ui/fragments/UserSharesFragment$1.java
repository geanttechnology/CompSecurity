// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.customviews.RoundedImageView;

// Referenced classes of package com.poshmark.ui.fragments:
//            UserSharesFragment, ClosetFragment

class this._cls0
    implements android.view.esFragment._cls1
{

    final UserSharesFragment this$0;

    public void onClick(View view)
    {
        if (UserSharesFragment.access$000(UserSharesFragment.this) != null)
        {
            if (view instanceof RoundedImageView)
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "profile_image_tapped", null);
            }
            view = new Bundle();
            view.putString("NAME", UserSharesFragment.access$100(UserSharesFragment.this));
            ((PMActivity)getActivity()).launchFragment(view, com/poshmark/ui/fragments/ClosetFragment, null);
        }
    }

    ()
    {
        this$0 = UserSharesFragment.this;
        super();
    }
}
