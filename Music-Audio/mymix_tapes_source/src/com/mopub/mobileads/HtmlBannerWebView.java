// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.AdReport;

// Referenced classes of package com.mopub.mobileads:
//            BaseHtmlWebView, HtmlWebViewClient, HtmlWebViewListener, MoPubErrorCode

public class HtmlBannerWebView extends BaseHtmlWebView
{
    static class HtmlBannerWebViewListener
        implements HtmlWebViewListener
    {

        private final CustomEventBanner.CustomEventBannerListener mCustomEventBannerListener;

        public void onClicked()
        {
            mCustomEventBannerListener.onBannerClicked();
        }

        public void onCollapsed()
        {
            mCustomEventBannerListener.onBannerCollapsed();
        }

        public void onFailed(MoPubErrorCode mopuberrorcode)
        {
            mCustomEventBannerListener.onBannerFailed(mopuberrorcode);
        }

        public void onLoaded(BaseHtmlWebView basehtmlwebview)
        {
            mCustomEventBannerListener.onBannerLoaded(basehtmlwebview);
        }

        public HtmlBannerWebViewListener(CustomEventBanner.CustomEventBannerListener customeventbannerlistener)
        {
            mCustomEventBannerListener = customeventbannerlistener;
        }
    }


    public static final String EXTRA_AD_CLICK_DATA = "com.mopub.intent.extra.AD_CLICK_DATA";

    public HtmlBannerWebView(Context context, AdReport adreport)
    {
        super(context, adreport);
    }

    public void init(CustomEventBanner.CustomEventBannerListener customeventbannerlistener, boolean flag, String s, String s1)
    {
        super.init(flag);
        setWebViewClient(new HtmlWebViewClient(new HtmlBannerWebViewListener(customeventbannerlistener), this, s1, s));
    }
}
