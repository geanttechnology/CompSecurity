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
import com.poshmark.utils.MetricsTrackingUtils;

// Referenced classes of package com.poshmark.data_model.adapters:
//            FeedListAdapter

class this._cls0
    implements android.view.er
{

    final FeedListAdapter this$0;

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
            PMApi.like(listingsocial.getIdAsString(), view, null);
        } else
        {
            Analytics.getInstance().trackEvent("listings_feed_screen", "listing", "unlike", null);
            PMApi.unLike(listingsocial.getIdAsString(), null);
        }
        ListingNotificationManager.getListingNotificationManager().fireListingLikedMessage(listingsocial.getIdAsString(), flag);
    }

    er()
    {
        this$0 = FeedListAdapter.this;
        super();
    }
}
