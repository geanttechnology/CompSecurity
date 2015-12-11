// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.notifications.PMNotificationManager;

// Referenced classes of package com.poshmark.ui.fragments:
//            FeedFragment

class this._cls0
    implements android.view.tener
{

    final FeedFragment this$0;

    public void onClick(View view)
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "app", "search_listings_button_clicked", null);
        view = new Bundle();
        view.putInt("TAB_INDEX", 1);
        PMNotificationManager.fireNotification("com.poshmark.intents.SWITCH_TAB", view);
    }

    Manager()
    {
        this$0 = FeedFragment.this;
        super();
    }
}
