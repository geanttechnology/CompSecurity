// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import com.poshmark.application.PMApplicationSession;
import com.poshmark.utils.FeatureManager;

// Referenced classes of package com.poshmark.data_model.models:
//            ShareBannerInfo

class Feature.listing_flow_visibility
{
    class Feature
    {

        boolean listing_flow_share_toggle;
        boolean listing_flow_visibility;
        final ShareBannerInfo.ExternalConnectSetting this$1;

        public Feature()
        {
            this$1 = ShareBannerInfo.ExternalConnectSetting.this;
            super();
        }
    }


    Feature fb;
    Feature pn;
    final ShareBannerInfo this$0;
    Feature tm;
    Feature tw;

    public Feature.this._cls1()
    {
        this$0 = ShareBannerInfo.this;
        super();
        fb = new Feature();
        fb.listing_flow_share_toggle = PMApplicationSession.GetPMSession().getFacebookSharingFlag().booleanValue();
        fb.listing_flow_visibility = true;
        pn = new Feature();
        pn.listing_flow_share_toggle = PMApplicationSession.GetPMSession().getPinterestSharingFlag().booleanValue();
        pn.listing_flow_visibility = FeatureManager.getGlobalFeatureManager().isPinterestButtonEnabled();
        tw = new Feature();
        tw.listing_flow_share_toggle = PMApplicationSession.GetPMSession().getTwitterSharingFlag().booleanValue();
        tw.listing_flow_visibility = true;
        tm = new Feature();
        tm.listing_flow_share_toggle = PMApplicationSession.GetPMSession().getTumblrSharingFlag().booleanValue();
        tm.listing_flow_visibility = true;
    }
}
