// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

// Referenced classes of package com.medialets.advertising:
//            AdView, JSBridge, y, AdManager, 
//            ae, AdWebView, AdManagerService, ag, 
//            a

public final class InterstitialAdView extends AdView
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener, android.view.animation.Animation.AnimationListener
{

    private int a;
    private boolean b;

    public InterstitialAdView(Context context)
    {
        super(context);
        b = false;
        renderLayout();
    }

    public InterstitialAdView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b = false;
        renderLayout();
    }

    public InterstitialAdView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        b = false;
        renderLayout();
    }

    protected final void dismiss()
    {
        b = true;
        mJsBridge.cleanUp();
        Object obj = new DisplayMetrics();
        y.c().getMetrics(((DisplayMetrics) (obj)));
        obj = new TranslateAnimation(0.0F, ((DisplayMetrics) (obj)).widthPixels, 0.0F, 0.0F);
        ((TranslateAnimation) (obj)).setDuration(1000L);
        ((TranslateAnimation) (obj)).setAnimationListener(this);
        startAnimation(((Animation) (obj)));
    }

    public final void display()
    {
        Object obj;
        Activity activity;
        int i;
        super.display();
        if (mAdvertisement == null)
        {
            return;
        }
        obj = AdManager.getInstance();
        activity = ((AdManager) (obj)).getCurrentActivity();
        i = y.f();
        a = activity.getRequestedOrientation();
        if (!y.g()) goto _L2; else goto _L1
_L1:
        activity.setRequestedOrientation(1);
_L4:
        handleFullscreen();
        String s = String.format("%s/%s/%s/%s", new Object[] {
            getContext().getFilesDir(), "medialytics", mAdvertisement.d(), mAdvertisement.a()
        });
        mWebView.load(s);
        invalidate();
        requestLayout();
        ((ViewGroup)activity.getWindow().findViewById(0x1020002)).addView(this);
        setVisibility(0);
        setFocusable(true);
        setFocusableInTouchMode(true);
        bringToFront();
        requestFocus();
        obj = ((AdManager) (obj)).mService.getDataStore();
        mAdvertisement.v();
        ((ag) (obj)).a(mAdvertisement);
        com.medialets.advertising.a.a((new StringBuilder()).append("Advertisement is visible for slot: ").append(mSlotName).toString());
        return;
_L2:
        if (i == 1)
        {
            activity.setRequestedOrientation(1);
        } else
        if (i == 2)
        {
            activity.setRequestedOrientation(0);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final int getSlotType()
    {
        return 2;
    }

    protected final boolean isDismissing()
    {
        return b;
    }

    public final void onAnimationEnd(Animation animation)
    {
        animation = AdManager.getInstance().getCurrentActivity();
        dismissFullscreen();
        ((ViewGroup)animation.getWindow().findViewById(0x1020002)).removeView(this);
        animation.setRequestedOrientation(a);
        commitEventData();
        if (mAdListener != null)
        {
            mAdListener.onInterstitialDismissed(this);
        }
        com.medialets.advertising.a.a((new StringBuilder()).append("Interstitial view dismissed: ").append(mSlotName).toString());
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }

    public final void onGlobalLayout()
    {
        if (!isViewHidden() && getWindowVisibility() == 0)
        {
            startDurationTimer();
            return;
        } else
        {
            com.medialets.advertising.a.a("InterstitialAdView onGlobalLayout calling stopDurationTimer");
            stopDurationTimer();
            return;
        }
    }

    public final boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (keyevent.getKeyCode() == 4)
        {
            if (!b)
            {
                dismiss();
            }
            return true;
        } else
        {
            return false;
        }
    }

    protected final void renderLayout()
    {
        com.medialets.advertising.a.a("InterstitialAdView renderLayout");
        setVisibility(8);
        mWidth = 320;
        mHeight = 480;
        setId(8772);
        setNextFocusDownId(8772);
        setNextFocusUpId(8772);
        setNextFocusRightId(8772);
        setNextFocusLeftId(8772);
        mWebView = new AdWebView(getContext());
        Object obj = mWebView.getSettings();
        ((WebSettings) (obj)).setJavaScriptEnabled(true);
        ((WebSettings) (obj)).setAllowFileAccess(true);
        ((WebSettings) (obj)).setJavaScriptCanOpenWindowsAutomatically(true);
        final class a extends WebChromeClient
        {

            public final boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
            {
                com.medialets.advertising.a.b((new StringBuilder()).append("AlertMessage: ").append(s1).toString());
                return super.onJsAlert(webview, s, s1, jsresult);
            }

            a()
            {
            }
        }

        mWebView.setWebChromeClient(new a());
        mWebView.setHorizontalScrollBarEnabled(false);
        mWebView.setVerticalScrollBarEnabled(false);
        com.medialets.advertising.a.a("InterstitialAdView: creating JSBridge");
        mJsBridge = new JSBridge(this);
        mWebView.setWebViewClient(mJsBridge);
        getViewTreeObserver().addOnGlobalLayoutListener(this);
        obj = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        addView(mWebView, ((android.view.ViewGroup.LayoutParams) (obj)));
        setGravity(17);
        setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        invalidate();
        requestLayout();
    }
}
