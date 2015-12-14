// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;


// Referenced classes of package com.mopub.mobileads:
//            HtmlWebViewListener, MoPubErrorCode, BaseHtmlWebView

class mCustomEventBannerListener
    implements HtmlWebViewListener
{

    private final onBannerLoaded mCustomEventBannerListener;

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

    public ( )
    {
        mCustomEventBannerListener = ;
    }
}
