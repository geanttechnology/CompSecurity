// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

// Referenced classes of package com.medialets.advertising:
//            AdView, JSBridge, AdManager, y, 
//            ae, BannerAdView, AdWebView, a

final class g extends AdView
    implements android.view.animation.Animation.AnimationListener
{

    private BannerAdView a;
    private boolean b;
    private boolean c;
    private boolean d;
    private int e;

    public g(Context context)
    {
        super(context);
        b = false;
        c = false;
        d = true;
        renderLayout();
    }

    public final BannerAdView a()
    {
        return a;
    }

    public final void a(BannerAdView banneradview)
    {
        a = banneradview;
    }

    protected final void dismiss()
    {
        c = true;
        mJsBridge.cleanUp();
        Object obj = AdManager.getInstance().getCurrentActivity();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        y.c().getMetrics(displaymetrics);
        int i = displaymetrics.heightPixels;
        if (((Activity) (obj)).getRequestedOrientation() == 0)
        {
            i = displaymetrics.widthPixels;
        }
        int j;
        if (!d)
        {
            j = mAdvertisement.i();
            i = j << 1;
        } else
        {
            j = i;
            i = 1000;
        }
        if (((Activity) (obj)).getRequestedOrientation() == 0)
        {
            obj = new TranslateAnimation(0.0F, j, 0.0F, 0.0F);
        } else
        {
            obj = new TranslateAnimation(0.0F, 0.0F, 0.0F, j);
        }
        ((TranslateAnimation) (obj)).setDuration(i);
        ((TranslateAnimation) (obj)).setInterpolator(new LinearInterpolator());
        ((TranslateAnimation) (obj)).setAnimationListener(this);
        startAnimation(((Animation) (obj)));
        a.setAdEvent(mAdEvent);
    }

    protected final void display()
    {
        if (mAdvertisement == null)
        {
            return;
        }
        Object obj = AdManager.getInstance().getCurrentActivity();
        int i = y.f();
        e = ((Activity) (obj)).getRequestedOrientation();
        Object obj1;
        android.widget.RelativeLayout.LayoutParams layoutparams;
        int j;
        if (y.g())
        {
            ((Activity) (obj)).setRequestedOrientation(1);
        } else
        if (i == 1)
        {
            ((Activity) (obj)).setRequestedOrientation(1);
        } else
        if (i == 2)
        {
            ((Activity) (obj)).setRequestedOrientation(0);
        }
        obj1 = String.format("%s/%s/%s/%s", new Object[] {
            getContext().getFilesDir(), "medialytics", mAdvertisement.d(), mAdvertisement.b()
        });
        i = android.view.View.MeasureSpec.makeMeasureSpec(mAdvertisement.j(), 0x40000000);
        j = android.view.View.MeasureSpec.makeMeasureSpec(mAdvertisement.k(), 0x40000000);
        mWebView.measure(i, j);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(14, -1);
        addView(mWebView, layoutparams);
        if (d)
        {
            setGravity(17);
        } else
        {
            setGravity(80);
        }
        if (mAdvertisement.g())
        {
            mWebView.setBackgroundColor(0);
        } else
        {
            setBackgroundColor(0xff000000);
        }
        mWebView.clearCache(true);
        mWebView.load(((String) (obj1)));
        invalidate();
        requestLayout();
        ((ViewGroup)((Activity) (obj)).getWindow().findViewById(0x1020002)).addView(this);
        setVisibility(0);
        obj1 = new DisplayMetrics();
        y.c().getMetrics(((DisplayMetrics) (obj1)));
        i = ((DisplayMetrics) (obj1)).heightPixels;
        if (((Activity) (obj)).getRequestedOrientation() == 0)
        {
            i = ((DisplayMetrics) (obj1)).widthPixels;
        }
        if (!d)
        {
            j = mAdvertisement.k();
            i = j << 1;
        } else
        {
            j = i;
            i = 1000;
        }
        if (((Activity) (obj)).getRequestedOrientation() == 1)
        {
            obj = new TranslateAnimation(0.0F, 0.0F, j, 0.0F);
        } else
        {
            obj = new TranslateAnimation(((DisplayMetrics) (obj1)).widthPixels, 0.0F, 0.0F, 0.0F);
        }
        ((TranslateAnimation) (obj)).setDuration(i);
        ((TranslateAnimation) (obj)).setInterpolator(new LinearInterpolator());
        ((TranslateAnimation) (obj)).setAnimationListener(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        b = true;
        startAnimation(((Animation) (obj)));
        bringToFront();
        requestFocus();
    }

    public final int getSlotType()
    {
        return 3;
    }

    protected final boolean isDismissing()
    {
        return c;
    }

    protected final void loadAdvertisement()
    {
label0:
        {
            super.loadAdvertisement();
            if (mAdvertisement != null)
            {
                if (mAdvertisement.j() < 320 || mAdvertisement.k() < 400)
                {
                    break label0;
                }
                d = true;
            }
            return;
        }
        d = false;
    }

    public final void onAnimationEnd(Animation animation)
    {
        animation = AdManager.getInstance().getCurrentActivity();
        if (b)
        {
            a.onExpansionComplete();
            mJsBridge.onExpandComplete();
            b = false;
        }
        if (c)
        {
            mWebView.destroy();
            ((ViewGroup)animation.getWindow().findViewById(0x1020002)).removeView(this);
            if (d)
            {
                dismissFullscreen();
            }
            animation.setRequestedOrientation(e);
            a.onCollapseComplete();
            c = false;
        }
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
        if (c)
        {
            AdManager.getInstance().getCurrentActivity();
            a.onCollapseStarted();
            mJsBridge.onCollapseStart();
        }
        if (b)
        {
            if (d)
            {
                handleFullscreen();
            }
            setVisibility(0);
            a.onExpansionStarted();
            mJsBridge.onExpandStart();
        }
    }

    public final boolean onKeyDown(int i, KeyEvent keyevent)
    {
        super.onKeyDown(i, keyevent);
        if (keyevent.getKeyCode() == 4 && !c && !b)
        {
            dismiss();
        }
        return true;
    }

    protected final void renderLayout()
    {
        com.medialets.advertising.a.d("ExpandedAdView renderLayout");
        setId(8772);
        setNextFocusDownId(8772);
        setNextFocusUpId(8772);
        setNextFocusRightId(8772);
        setNextFocusLeftId(8772);
        mWebView = new AdWebView(getContext());
        WebSettings websettings = mWebView.getSettings();
        websettings.setJavaScriptEnabled(true);
        websettings.setJavaScriptCanOpenWindowsAutomatically(true);
        websettings.setAllowFileAccess(true);
        websettings.setSupportZoom(false);
        websettings.setSupportMultipleWindows(false);
        final class a extends WebChromeClient
        {

            public final boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
            {
                com.medialets.advertising.a.b((new StringBuilder()).append("Javascript Alert Message: ").append(s1).toString());
                return super.onJsAlert(webview, s, s1, jsresult);
            }

            a()
            {
            }
        }

        mWebView.setWebChromeClient(new a());
        mWebView.setHorizontalScrollBarEnabled(false);
        mWebView.setVerticalScrollBarEnabled(false);
        mJsBridge = new JSBridge(this);
        mWebView.setWebViewClient(mJsBridge);
        setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        invalidate();
        requestLayout();
    }
}
