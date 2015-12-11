// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import android.webkit.WebView;
import com.poshmark.analytics.Analytics;
import com.poshmark.config.NewRelicWrapper;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.utils.NewRelicCustomInteractions;

// Referenced classes of package com.poshmark.ui.fragments:
//            NewsPageFragment

class this._cls0
    implements android.view.r
{

    final NewsPageFragment this$0;

    public void onClick(View view)
    {
        NewRelicWrapper.startCustomInteraction(NewRelicCustomInteractions.NEWS_FEED_REFRESH);
        webView.reload();
        PMNotificationManager.fireNotification("com.poshmark.intents.CLEAR_NEWS_BADGE");
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "refresh_news_clicked", null);
    }

    ger()
    {
        this$0 = NewsPageFragment.this;
        super();
    }
}
