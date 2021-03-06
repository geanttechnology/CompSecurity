// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import com.mopub.common.AdReport;

// Referenced classes of package com.mopub.mobileads:
//            BaseHtmlWebView, HtmlWebViewClient

public class HtmlInterstitialWebView extends BaseHtmlWebView
{

    private Handler mHandler;

    public HtmlInterstitialWebView(Context context, AdReport adreport)
    {
        super(context, adreport);
        mHandler = new Handler();
    }

    private void postHandlerRunnable(Runnable runnable)
    {
        mHandler.post(runnable);
    }

    public void init(CustomEventInterstitial.CustomEventInterstitialListener customeventinterstitiallistener, boolean flag, String s, String s1)
    {
        super.init(flag);
        setWebViewClient(new HtmlWebViewClient(new HtmlInterstitialWebViewListener(customeventinterstitiallistener), this, s1, s));
    }

    private class HtmlInterstitialWebViewListener
        implements HtmlWebViewListener
    {

        private final CustomEventInterstitial.CustomEventInterstitialListener mCustomEventInterstitialListener;

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

        public HtmlInterstitialWebViewListener(CustomEventInterstitial.CustomEventInterstitialListener customeventinterstitiallistener)
        {
            mCustomEventInterstitialListener = customeventinterstitiallistener;
        }
    }

}
