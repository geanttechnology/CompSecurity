// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.medialets.analytics.MMEvent;

// Referenced classes of package com.medialets.advertising:
//            AdView, JSBridge, AdWebView, y, 
//            ae, a, AdManager, AdManagerService, 
//            ag, g

public final class BannerAdView extends AdView
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener, android.view.ViewTreeObserver.OnScrollChangedListener
{

    private boolean a;
    private boolean b;
    protected int mScreenHeight;

    public BannerAdView(Context context)
    {
        super(context);
        a = false;
        b = false;
        mScreenHeight = -1;
        renderLayout();
    }

    public BannerAdView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = false;
        b = false;
        mScreenHeight = -1;
        renderLayout();
    }

    public BannerAdView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = false;
        b = false;
        mScreenHeight = -1;
        renderLayout();
    }

    public final void dismiss()
    {
        commitEventData();
        mJsBridge.cleanUp();
        if (mWebView != null)
        {
            mWebView.destroy();
        }
        ViewGroup viewgroup = (ViewGroup)getParent();
        if (viewgroup != null)
        {
            viewgroup.removeView(this);
        }
        isDismissed = true;
    }

    public final void display()
    {
        super.display();
        if (mAdvertisement == null)
        {
            return;
        }
        Object obj1 = new DisplayMetrics();
        Object obj = y.c();
        ((Display) (obj)).getMetrics(((DisplayMetrics) (obj1)));
        mScreenHeight = ((DisplayMetrics) (obj1)).heightPixels;
        com.medialets.advertising.a.d((new StringBuilder()).append("Displaying banner: ").append(mAdvertisement.d()).toString());
        obj1 = String.format("%s/%s/%s/%s", new Object[] {
            getContext().getFilesDir(), "medialytics", mAdvertisement.d(), mAdvertisement.a()
        });
        if (mAdvertisement.g())
        {
            mWebView.setBackgroundColor(0);
        } else
        {
            setBackgroundColor(0xff000000);
        }
        ((Display) (obj)).getOrientation();
        obj = new android.widget.RelativeLayout.LayoutParams(mWidth, mHeight);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13, -1);
        getViewTreeObserver().addOnGlobalLayoutListener(this);
        getViewTreeObserver().addOnScrollChangedListener(this);
        mWebView.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        mWebView.load(((String) (obj1)));
        invalidate();
        requestLayout();
        setVisibility(0);
        obj = AdManager.getInstance().mService.getDataStore();
        mAdvertisement.v();
        ((ag) (obj)).a(mAdvertisement);
    }

    protected final void expand()
    {
        expand(false);
    }

    protected final void expand(boolean flag)
    {
        if (a)
        {
            return;
        } else
        {
            a = true;
            b = flag;
            g g1 = new g(getContext());
            g1.setAdvertisement(mAdvertisement);
            g1.setAdEvent(mAdEvent);
            g1.setCustomMacros(mCustomMacros);
            g1.setSlotName(mSlotName);
            g1.a(this);
            g1.mStandardMacros = mStandardMacros;
            g1.loadAdvertisement();
            g1.display();
            return;
        }
    }

    public final void forceExpand()
    {
        mAdEvent.setNumberForKey("MMAdAppForceExpand", new Double(System.currentTimeMillis()));
        expand(true);
    }

    public final int getSlotType()
    {
        return 1;
    }

    protected final boolean isDismissing()
    {
        return false;
    }

    protected final void onCollapseComplete()
    {
        mJsBridge.onCollapseComplete();
    }

    protected final void onCollapseStarted()
    {
        mJsBridge.onCollapseStart();
    }

    protected final void onExpansionComplete()
    {
        if (!b)
        {
            mAdEvent.incrementNumberForKey("MMAdExpand");
        }
        mJsBridge.onExpandComplete();
        a = false;
        b = false;
    }

    protected final void onExpansionStarted()
    {
        mJsBridge.onExpandStart();
    }

    public final void onGlobalLayout()
    {
        if (!isViewHidden() && getWindowVisibility() == 0)
        {
            super.startDurationTimer();
            return;
        } else
        {
            super.stopDurationTimer();
            return;
        }
    }

    public final void onScrollChanged()
    {
        if (!isViewHidden() && getWindowVisibility() == 0 && (getBottom() >= 0 || getTop() <= mScreenHeight))
        {
            super.startDurationTimer();
            return;
        } else
        {
            com.medialets.advertising.a.d("onScrollChanged called, stopping timer");
            super.stopDurationTimer();
            return;
        }
    }

    protected final void renderLayout()
    {
        if (mViewRendered)
        {
            return;
        } else
        {
            setVisibility(8);
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
            mWebView.setVerticalScrollBarEnabled(false);
            mWebView.setHorizontalScrollBarEnabled(false);
            com.medialets.advertising.a.a("BannerAdView: creating JSBridge");
            mJsBridge = new JSBridge(this);
            mWebView.setWebViewClient(mJsBridge);
            obj = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            addView(mWebView, ((android.view.ViewGroup.LayoutParams) (obj)));
            setGravity(17);
            invalidate();
            requestLayout();
            mViewRendered = true;
            return;
        }
    }

    protected final void startDurationTimer()
    {
        super.startDurationTimer();
    }

    protected final void stopDurationTimer()
    {
        super.stopDurationTimer();
    }
}
