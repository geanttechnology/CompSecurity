// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.http.api.PMApi;

// Referenced classes of package com.poshmark.ui.fragments:
//            FeedFragment

class this._cls0
    implements android.view.tener
{

    final FeedFragment this$0;

    public void onClick(View view)
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "refresh_myfeed_clicked", null);
        PMApi.getViewTrackingInfo("fd");
        FeedFragment.access$000(FeedFragment.this, false);
    }

    ()
    {
        this$0 = FeedFragment.this;
        super();
    }
}
