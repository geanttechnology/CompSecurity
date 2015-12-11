// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.config.NewRelicWrapper;
import com.poshmark.http.api.PMApi;
import com.poshmark.ui.customviews.PMButton;
import com.poshmark.utils.NewRelicCustomInteractions;

// Referenced classes of package com.poshmark.ui.fragments:
//            NewFeedFragment

class this._cls0
    implements android.view.er
{

    final NewFeedFragment this$0;

    public void onClick(View view)
    {
        NewRelicWrapper.startCustomInteraction(NewRelicCustomInteractions.USER_TRIGGERED_FEED_REFRESH);
        newItemsBubble.setVisibility(8);
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "refresh_myfeed_clicked", null);
        PMApi.getViewTrackingInfo("fd");
        NewFeedFragment.access$000(NewFeedFragment.this, false);
    }

    s()
    {
        this$0 = NewFeedFragment.this;
        super();
    }
}
