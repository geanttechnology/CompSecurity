// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

// Referenced classes of package com.amazon.android.webkit:
//            AmazonOverScrollByListener, AmazonOnScrollChangedListener, AmazonOnScrollingListener, AmazonWebView, 
//            AmazonWebSettings, AmazonWebBackForwardList, AmazonDownloadDelegate, AmazonDownloadListener, 
//            AmazonFindListener, AmazonSelectPopupHandler, AmazonWebBackForwardListClient, AmazonWebChromeClient, 
//            AmazonWebViewClient

public abstract class AmazonWebViewDelegate
{

    private String loadingUrl;
    private AmazonOnScrollChangedListener onScrollChangedListener;
    private AmazonOnScrollingListener onScrollingListener;
    private android.view.View.OnTouchListener onTouchListenerOverride;
    private AmazonWebView.OnUrlLoadRequestedListener onUrlLoadRequestedListener;
    private AmazonOverScrollByListener overScrollByListener;
    private final AmazonWebView view;

    protected AmazonWebViewDelegate(AmazonWebView amazonwebview)
    {
        onTouchListenerOverride = null;
        overScrollByListener = null;
        onScrollChangedListener = null;
        onUrlLoadRequestedListener = null;
        loadingUrl = null;
        view = amazonwebview;
    }

    protected abstract void addJavascriptInterface(Object obj, String s);

    protected abstract boolean canGoBack();

    protected abstract boolean canScrollHorizontally(int i);

    protected abstract boolean canScrollVertically(int i);

    protected abstract void clearFormData();

    protected abstract void computeScroll();

    protected abstract void destroy();

    protected abstract SslCertificate getCertificate();

    protected abstract int getContentHeight();

    protected abstract Bitmap getFavicon();

    protected abstract AmazonWebView.HitTestResult getHitTestResult();

    protected String getLoadingUrl()
    {
        if (loadingUrl != null)
        {
            return loadingUrl;
        } else
        {
            return getUrl();
        }
    }

    protected String getMimeType()
    {
        return "application/octet-stream";
    }

    protected abstract String getOriginalUrl();

    protected abstract int getProgress();

    protected abstract float getScale();

    protected abstract int getScrollBarStyle();

    protected abstract AmazonWebSettings getSettings();

    protected abstract int getSolidColor();

    protected abstract String getTitle();

    protected abstract String getTouchIconUrl();

    protected abstract String getUrl();

    protected abstract int getVerticalScrollOffset();

    protected AmazonWebView getWebView()
    {
        return view;
    }

    protected abstract void goBack();

    protected abstract boolean isHorizontalScrollBarEnabled();

    protected abstract boolean isVerticalScrollBarEnabled();

    protected abstract void loadUrl(String s);

    protected abstract InputConnection onCreateInputConnection(EditorInfo editorinfo);

    protected abstract void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent);

    protected abstract void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo);

    protected abstract boolean onTouchEvent(MotionEvent motionevent);

    protected void onUrlLoadRequested(String s)
    {
        if (onUrlLoadRequestedListener != null)
        {
            onUrlLoadRequestedListener.urlLoadRequested(view, s);
        }
    }

    protected void onWebViewOverScrollBy(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, boolean flag)
    {
        if (overScrollByListener != null)
        {
            overScrollByListener.onOverScrollBy(i, j, k, l, i1, j1, k1, l1, flag);
        }
    }

    protected void onWebViewScrollChanged(int i, int j)
    {
        if (onScrollChangedListener != null)
        {
            onScrollChangedListener.onScrollChanged(i, j);
        }
    }

    protected void onWebViewScrolling(int i, int j, int k, int l)
    {
        if (onScrollingListener != null)
        {
            onScrollingListener.onScrolling(i, j, k, l);
        }
    }

    protected boolean onWebViewTouchEvent(MotionEvent motionevent)
    {
        if (onTouchListenerOverride != null)
        {
            return onTouchListenerOverride.onTouch(view, motionevent);
        } else
        {
            return false;
        }
    }

    protected abstract void onWindowFocusChanged(boolean flag);

    protected abstract void pauseTimers();

    protected abstract boolean performAccessibilityAction(int i, Bundle bundle);

    protected abstract boolean performLongClick();

    protected abstract void reload();

    protected abstract boolean requestFocus(int i, Rect rect);

    protected abstract AmazonWebBackForwardList restoreState(Bundle bundle);

    protected abstract void resumeTimers();

    protected abstract void saveState(Bundle bundle);

    protected void scrollBy(int i, int j)
    {
        throw new UnsupportedOperationException();
    }

    protected abstract void setBackgroundColor(int i);

    protected abstract void setCertificate(SslCertificate sslcertificate);

    protected abstract void setContentDescription(CharSequence charsequence);

    protected abstract void setDownloadDelegate(AmazonDownloadDelegate amazondownloaddelegate);

    protected abstract void setDownloadListener(AmazonDownloadListener amazondownloadlistener);

    protected abstract void setFindIsUp(boolean flag);

    protected abstract void setFindListener(AmazonFindListener amazonfindlistener);

    protected abstract void setHorizontalScrollBarEnabled(boolean flag);

    protected abstract void setHorizontalScrollbarOverlay(boolean flag);

    protected abstract void setInitialScale(int i);

    protected abstract boolean setLayerType(int i, Paint paint);

    protected void setLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
    }

    protected void setLoadingUrl(String s)
    {
        loadingUrl = s;
    }

    protected abstract void setMapTrackballToArrowKeys(boolean flag);

    protected abstract void setNetworkAvailable(boolean flag);

    protected abstract void setOnKeyListener(android.view.View.OnKeyListener onkeylistener);

    protected void setOnOverscrollByListener(AmazonOverScrollByListener amazonoverscrollbylistener)
    {
        overScrollByListener = amazonoverscrollbylistener;
    }

    protected void setOnScrollChangedListener(AmazonOnScrollChangedListener amazononscrollchangedlistener)
    {
        onScrollChangedListener = amazononscrollchangedlistener;
    }

    protected void setOnScrollingListener(AmazonOnScrollingListener amazononscrollinglistener)
    {
        onScrollingListener = amazononscrollinglistener;
    }

    protected abstract void setOnTouchListener(android.view.View.OnTouchListener ontouchlistener);

    protected void setOnTouchOverride(android.view.View.OnTouchListener ontouchlistener)
    {
        onTouchListenerOverride = ontouchlistener;
    }

    protected void setOnUrlLoadRequested(AmazonWebView.OnUrlLoadRequestedListener onurlloadrequestedlistener)
    {
        onUrlLoadRequestedListener = onurlloadrequestedlistener;
    }

    protected abstract void setOverScrollMode(int i);

    protected abstract void setScrollBarStyle(int i);

    protected abstract void setSelectPopupHandler(AmazonSelectPopupHandler amazonselectpopuphandler);

    protected abstract void setVerticalScrollBarEnabled(boolean flag);

    protected abstract void setVerticalScrollbarOverlay(boolean flag);

    protected abstract void setWebBackForwardListClient(AmazonWebBackForwardListClient amazonwebbackforwardlistclient);

    protected abstract void setWebChromeClient(AmazonWebChromeClient amazonwebchromeclient);

    protected abstract void setWebViewClient(AmazonWebViewClient amazonwebviewclient);

    protected void setZOrderOverlay(boolean flag)
    {
        throw new UnsupportedOperationException();
    }

    protected abstract boolean shouldDelayChildPressedState();

    protected abstract void stopLoading();
}
