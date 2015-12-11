// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.adapters;

import android.app.Activity;
import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.data_model.models.ListingSocial;
import com.poshmark.http.api.PMApi;
import com.poshmark.notifications.ListingNotificationManager;
import com.poshmark.utils.FBDPAHelper;
import com.poshmark.utils.MetricsTrackingUtils;

// Referenced classes of package com.poshmark.data_model.adapters:
//            HetroFeedListAdapter

class this._cls0
    implements android.view.roFeedListAdapter._cls2
{

    final HetroFeedListAdapter this$0;

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
        } else
        {
            Analytics.getInstance().trackEvent("listings_feed_screen", "listing", "unlike", null);
            PMApi.unLike(listingsocial.getIdAsString(), null);
            listingsocial.setListingLikeStatus(false);
        }
        ListingNotificationManager.getListingNotificationManager().fireListingLikedMessage(listingsocial.getIdAsString(), flag);
    }

    ()
    {
        this$0 = HetroFeedListAdapter.this;
        super();
    }
}
