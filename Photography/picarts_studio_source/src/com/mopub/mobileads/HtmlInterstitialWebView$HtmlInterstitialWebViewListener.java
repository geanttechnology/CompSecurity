// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;


// Referenced classes of package com.mopub.mobileads:
//            HtmlWebViewListener, MoPubErrorCode, BaseHtmlWebView

class mCustomEventInterstitialListener
    implements HtmlWebViewListener
{

    private final onInterstitialLoaded mCustomEventInterstitialListener;

    public void onClicked()
    {
        mCustomEventInterstitialListener.onInterstitialClicked();
    }

    public void onCollapsed()
    {
    }

    public void onFailed(MoPubErrorCode mopuberrorcode)
    {
        mCustomEventInterstitialListener.onInterstitialFailed(mopuberrorcode);
    }

    public void onLoaded(BaseHtmlWebView basehtmlwebview)
    {
        mCustomEventInterstitialListener.onInterstitialLoaded();
    }

    public Q(Q q)
    {
        mCustomEventInterstitialListener = q;
    }
}
