// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.ui.PMActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            ViewBundleFragment, ClosetFragment

class this._cls0
    implements android.view.leFragment._cls2
{

    final ViewBundleFragment this$0;

    public void onClick(View view)
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "bundle", "add_more_listings_to_bundle_tapped", null);
        view = new Bundle();
        view.putString("NAME", userName);
        getParentActivity().launchFragment(view, com/poshmark/ui/fragments/ClosetFragment, null);
    }

    ()
    {
        this$0 = ViewBundleFragment.this;
        super();
    }
}
