// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.net.Uri;
import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.data_model.models.BannerInfo;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.utils.DeepLinkLaunchInfo;
import com.poshmark.utils.DeepLinkUtils;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingDetailsFragment

class this._cls0
    implements android.view.sFragment._cls11
{

    final ListingDetailsFragment this$0;

    public void onClick(View view)
    {
        if (bannerInfo.destination_url != null)
        {
            view = Uri.parse(bannerInfo.destination_url);
            if (DeepLinkUtils.isValidDeepLink(view))
            {
                view = DeepLinkUtils.getDeepLinkLaunchInfo(view);
                if (view != null && ((DeepLinkLaunchInfo) (view)).fragmentClass != null)
                {
                    if (bannerInfo.banner_tap_analytics_event != null)
                    {
                        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", bannerInfo.banner_tap_analytics_event, null);
                    }
                    ((PMContainerActivity)getActivity()).launchFragmentInNewActivity(((DeepLinkLaunchInfo) (view)).bundle, ((DeepLinkLaunchInfo) (view)).fragmentClass, ((DeepLinkLaunchInfo) (view)).data);
                }
            }
        }
    }

    _cls9()
    {
        this$0 = ListingDetailsFragment.this;
        super();
    }
}
