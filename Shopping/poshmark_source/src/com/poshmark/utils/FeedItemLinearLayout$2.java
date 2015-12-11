// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.app.Activity;
import android.view.View;
import com.facebook.appevents.AppEventsLogger;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplication;
import com.poshmark.data_model.models.ListingSocial;
import com.poshmark.http.api.PMApi;
import com.poshmark.notifications.ListingNotificationManager;

// Referenced classes of package com.poshmark.utils:
//            FeedItemLinearLayout, MetricsTrackingUtils, FBDPAHelper

class this._cls0
    implements android.view.out._cls2
{

    final FeedItemLinearLayout this$0;

    public void onClick(View view)
    {
        ListingSocial listingsocial = (ListingSocial)view.getTag();
        boolean flag;
        if (!listingsocial.getListingLikeStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            view = MetricsTrackingUtils.getTrackingJson((Activity)view.getContext(), "lk");
            Analytics.getInstance().trackEvent("listings_feed_screen", "listing", "like", null);
            FBDPAHelper.trackListingLike(listingsocial);
            PMApi.like(listingsocial.getIdAsString(), view, null);
            listingsocial.setListingLikeStatus(true);
            AppEventsLogger.newLogger(PMApplication.getContext()).logEvent("like");
        } else
        {
            Analytics.getInstance().trackEvent("listings_feed_screen", "listing", "unlike", null);
            PMApi.unLike(listingsocial.getIdAsString(), null);
            listingsocial.setListingLikeStatus(false);
        }
        ListingNotificationManager.getListingNotificationManager().fireListingLikedMessage(listingsocial.getIdAsString(), flag);
    }

    tionManager()
    {
        this$0 = FeedItemLinearLayout.this;
        super();
    }
}
