// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.Map;

// Referenced classes of package com.amazon.device.ads:
//            AdRenderer, IAdController, AdLayout, Log, 
//            AndroidTargetUtils, AdUtils, AdData, WebViewFactory, 
//            AdWebViewClient, AdProperties

class HtmlRenderer extends AdRenderer
{

    public static final String LOG_TAG = com/amazon/device/ads/HtmlRenderer.getSimpleName();
    protected WebView adView_;
    protected boolean hasLoadedAd;
    protected boolean shouldForceRenderFailure;

    protected HtmlRenderer(AdData addata, IAdController iadcontroller, WebView webview, Context context)
    {
        super(addata, iadcontroller, context);
        hasLoadedAd = false;
        shouldForceRenderFailure = false;
        adView_ = webview;
        setupAdView();
        if (android.os.Build.VERSION.SDK_INT >= 11 && controller.shouldDisableWebViewHardwareAcceleration())
        {
            disableHardwareAcceleration();
        }
    }

    protected void adLoaded(AdProperties adproperties)
    {
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-2, -2, 17);
        controller.getAdLayout().addView(adView_, layoutparams);
        super.adLoaded(adproperties);
    }

    protected void destroy()
    {
        if (isAdViewNull())
        {
            Log.w(LOG_TAG, "Called destroy(), but view is already null.");
        } else
        {
            adView_.destroy();
            adView_ = null;
        }
        isDestroyed = true;
    }

    protected void disableHardwareAcceleration()
    {
        AndroidTargetUtils.disableHardwareAcceleration(adView_);
    }

    protected boolean getAdState(AdRenderer.AdState adstate)
    {
        return false;
    }

    public void initialize()
    {
        setupAdView();
        super.initialize();
    }

    protected boolean isAdViewNull()
    {
        return adView_ == null;
    }

    public boolean launchExternalBrowserForLink(String s)
    {
        AdUtils.launchActivityForIntentLink(s, context);
        return true;
    }

    public void onPageFinished()
    {
        if (!isDestroyed && !hasLoadedAd)
        {
            hasLoadedAd = true;
            adLoaded(adData.getProperties());
        }
    }

    protected void prepareToGoAway()
    {
    }

    protected void removeView()
    {
        if (controller.getAdLayout() != null)
        {
            controller.getAdLayout().removeView(adView_);
        }
        viewRemoved = true;
    }

    protected boolean render()
    {
        if (isAdViewNull() || isAdViewDestroyed() || shouldForceRenderFailure)
        {
            return false;
        } else
        {
            renderAdView();
            return true;
        }
    }

    protected void renderAdView()
    {
        adView_.loadUrl("about:blank");
        hasLoadedAd = false;
        String s = adData.getCreative();
        s = (new StringBuilder()).append("<html><meta name=\"viewport\" content=\"width=").append(controller.getWindowWidth()).append(", height=").append(controller.getWindowHeight()).append(", initial-scale=").append(AdUtils.getViewportInitialScale(getScalingMultiplier())).append(", minimum-scale=").append(getScalingMultiplier()).append(", maximum-scale=").append(getScalingMultiplier()).append("\">").append(s).append("</html>").toString().replace("<head>", "<head><script type=\"text/javascript\">htmlWillCallFinishLoad = 1;</script>");
        adView_.loadDataWithBaseURL("http://amazon-adsystem.amazon.com/", s, "text/html", "utf-8", null);
    }

    protected boolean sendCommand(String s, Map map)
    {
        return true;
    }

    protected void setupAdView()
    {
        boolean flag = true;
        adView_.setHorizontalScrollBarEnabled(false);
        adView_.setHorizontalScrollbarOverlay(false);
        adView_.setVerticalScrollBarEnabled(false);
        adView_.setVerticalScrollbarOverlay(false);
        adView_.getSettings().setSupportZoom(false);
        AdWebViewClient adwebviewclient;
        if (WebViewFactory.setJavaScriptEnabledForWebView(true, adView_, LOG_TAG))
        {
            flag = false;
        }
        shouldForceRenderFailure = flag;
        adView_.setBackgroundColor(0);
        adwebviewclient = new AdWebViewClient(this, context);
        adwebviewclient.putUrlExecutor("amazonmobile", controller.getSpecialUrlExecutor());
        adView_.setWebViewClient(adwebviewclient);
    }

    protected boolean shouldReuse()
    {
        return true;
    }

}
