// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.utils.ExternalAppUtils;
import com.poshmark.utils.FeatureManager;
import com.poshmark.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;

public class ShareBannerInfo
{
    public class BannnerResponse
    {

        public Data data;
        final ShareBannerInfo this$0;

        public BannnerResponse()
        {
            this$0 = ShareBannerInfo.this;
            super();
        }
    }

    public class BannnerResponse.Data
    {

        public String bg_color;
        public String image_url;
        final BannnerResponse this$1;

        public BannnerResponse.Data()
        {
            this$1 = BannnerResponse.this;
            super();
        }
    }

    class DeviceInfo
    {

        float height;
        final ShareBannerInfo this$0;
        float width;

        public DeviceInfo(Activity activity1)
        {
            this$0 = ShareBannerInfo.this;
            super();
            float f = activity1.getResources().getDisplayMetrics().widthPixels;
            height = ViewUtils.dipToPixels(activity1, 200F);
            width = f;
        }
    }

    class ExternalConnectSetting
    {

        Feature fb;
        Feature pn;
        final ShareBannerInfo this$0;
        Feature tm;
        Feature tw;

        public ExternalConnectSetting()
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

    class ExternalConnectSetting.Feature
    {

        boolean listing_flow_share_toggle;
        boolean listing_flow_visibility;
        final ExternalConnectSetting this$1;

        public ExternalConnectSetting.Feature()
        {
            this$1 = ExternalConnectSetting.this;
            super();
        }
    }


    public transient Activity activity;
    public DeviceInfo device_info;
    public List ext_apps_installed;
    public ExternalConnectSetting ext_connect_settings;

    public ShareBannerInfo(Activity activity1)
    {
        activity = activity1;
        ext_apps_installed = new ArrayList();
        ext_connect_settings = new ExternalConnectSetting();
        device_info = new DeviceInfo(activity1);
        if (ExternalAppUtils.isFacebookInstalled(activity1))
        {
            ext_apps_installed.add("fb");
        }
        if (ExternalAppUtils.isPinterestAllInstalled(activity1))
        {
            ext_apps_installed.add("pn");
        }
        if (ExternalAppUtils.isTumblrAppInstalled(activity1))
        {
            ext_apps_installed.add("tm");
        }
        if (ExternalAppUtils.isTwitterAppInstalled(activity1))
        {
            ext_apps_installed.add("tw");
        }
    }
}
