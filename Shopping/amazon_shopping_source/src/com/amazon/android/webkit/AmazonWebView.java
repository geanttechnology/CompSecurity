// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.FrameLayout;
import java.util.UUID;

// Referenced classes of package com.amazon.android.webkit:
//            AmazonWebViewDelegate, AmazonWebSettings, AmazonWebBackForwardList, AmazonDownloadDelegate, 
//            AmazonDownloadListener, AmazonFindListener, AmazonOverScrollByListener, AmazonOnScrollChangedListener, 
//            AmazonOnScrollingListener, AmazonSelectPopupHandler, AmazonWebBackForwardListClient, AmazonWebChromeClient, 
//            AmazonWebViewClient

public class AmazonWebView extends FrameLayout
{
    public static class HitTestResult
    {

        private final String extra;
        private final int type;

        public HitTestResult(int i, String s)
        {
            type = i;
            extra = s;
        }
    }

    public static interface OnUrlLoadRequestedListener
    {

        public abstract void urlLoadRequested(AmazonWebView amazonwebview, String s);
    }


    private Object attachment;
    private String pageLoadID;
    private AmazonWebViewDelegate webViewDelegate;

    public AmazonWebView(Context context)
    {
        super(context);
        pageLoadID = UUID.randomUUID().toString();
        attachment = null;
    }

    public AmazonWebView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        pageLoadID = UUID.randomUUID().toString();
        attachment = null;
    }

    public AmazonWebView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        pageLoadID = UUID.randomUUID().toString();
        attachment = null;
    }

    public AmazonWebView(Context context, Object obj)
    {
        super(context);
        pageLoadID = UUID.randomUUID().toString();
        setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        attachment = obj;
    }

    private static void checkThread()
    {
        if (Looper.myLooper() != Looper.getMainLooper())
        {
            throw new RuntimeException((new StringBuilder()).append("Warning: A WebView method was called on thread '").append(Thread.currentThread().getName()).append("'. ").append("All WebView methods must be called on the UI thread.").toString());
        } else
        {
            return;
        }
    }

    public void addJavascriptInterface(Object obj, String s)
    {
        checkThread();
        getWebViewDelegate().addJavascriptInterface(obj, s);
    }

    public boolean canGoBack()
    {
        checkThread();
        return getWebViewDelegate().canGoBack();
    }

    public boolean canScrollHorizontally(int i)
    {
        checkThread();
        return getWebViewDelegate().canScrollHorizontally(i);
    }

    public boolean canScrollVertically(int i)
    {
        checkThread();
        return getWebViewDelegate().canScrollVertically(i);
    }

    public void clearFormData()
    {
        checkThread();
        getWebViewDelegate().clearFormData();
    }

    public void computeScroll()
    {
        getWebViewDelegate().computeScroll();
    }

    public void destroy()
    {
        checkThread();
        getWebViewDelegate().destroy();
    }

    public void draw(Canvas canvas)
    {
        checkThread();
        Log.e(com/amazon/android/webkit/AmazonWebView.getName(), "AmazonWebView.draw() -- Unsupported method; Use capturePicture(int, int, int, int, int, AmazonPictureReadyListener) instead");
    }

    public Object getAttachment()
    {
        checkThread();
        return attachment;
    }

    public SslCertificate getCertificate()
    {
        checkThread();
        return getWebViewDelegate().getCertificate();
    }

    public int getContentHeight()
    {
        checkThread();
        return getWebViewDelegate().getContentHeight();
    }

    public Bitmap getFavicon()
    {
        checkThread();
        return getWebViewDelegate().getFavicon();
    }

    public HitTestResult getHitTestResult()
    {
        checkThread();
        return getWebViewDelegate().getHitTestResult();
    }

    public String getLoadingUrl()
    {
        checkThread();
        return getWebViewDelegate().getLoadingUrl();
    }

    public String getMimeType()
    {
        checkThread();
        return getWebViewDelegate().getMimeType();
    }

    public String getOriginalUrl()
    {
        checkThread();
        return getWebViewDelegate().getOriginalUrl();
    }

    public String getPageLoadID()
    {
        checkThread();
        return pageLoadID;
    }

    public int getProgress()
    {
        checkThread();
        return getWebViewDelegate().getProgress();
    }

    public float getScale()
    {
        checkThread();
        return getWebViewDelegate().getScale();
    }

    public int getScrollBarStyle()
    {
        return getWebViewDelegate().getScrollBarStyle();
    }

    public AmazonWebSettings getSettings()
    {
        return getWebViewDelegate().getSettings();
    }

    public int getSolidColor()
    {
        checkThread();
        return getWebViewDelegate().getSolidColor();
    }

    public String getTitle()
    {
        checkThread();
        return getWebViewDelegate().getTitle();
    }

    public String getTouchIconUrl()
    {
        return getWebViewDelegate().getTouchIconUrl();
    }

    public String getUrl()
    {
        checkThread();
        return getWebViewDelegate().getUrl();
    }

    public int getVerticalScrollOffset()
    {
        checkThread();
        return getWebViewDelegate().getVerticalScrollOffset();
    }

    public AmazonWebViewDelegate getWebViewDelegate()
    {
        if (webViewDelegate == null)
        {
            throw new IllegalStateException("webview delegate not set because user did not call AmazonWebKitFactory.initializeWebView() first");
        } else
        {
            return webViewDelegate;
        }
    }

    public void goBack()
    {
        checkThread();
        getWebViewDelegate().goBack();
    }

    public boolean isHorizontalScrollBarEnabled()
    {
        checkThread();
        return getWebViewDelegate().isHorizontalScrollBarEnabled();
    }

    public boolean isVerticalScrollBarEnabled()
    {
        checkThread();
        return getWebViewDelegate().isVerticalScrollBarEnabled();
    }

    public void loadUrl(String s)
    {
        checkThread();
        getWebViewDelegate().loadUrl(s);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorinfo)
    {
        return getWebViewDelegate().onCreateInputConnection(editorinfo);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        getWebViewDelegate().onInitializeAccessibilityEvent(accessibilityevent);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo)
    {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        getWebViewDelegate().onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        return getWebViewDelegate().onTouchEvent(motionevent);
    }

    public void onWindowFocusChanged(boolean flag)
    {
        getWebViewDelegate().onWindowFocusChanged(flag);
    }

    public void pauseTimers()
    {
        checkThread();
        getWebViewDelegate().pauseTimers();
    }

    public boolean performAccessibilityAction(int i, Bundle bundle)
    {
        boolean flag1 = getWebViewDelegate().performAccessibilityAction(i, bundle);
        boolean flag = flag1;
        if (!flag1)
        {
            flag = super.performAccessibilityAction(i, bundle);
        }
        return flag;
    }

    public boolean performLongClick()
    {
        return getWebViewDelegate().performLongClick();
    }

    public void reload()
    {
        checkThread();
        getWebViewDelegate().reload();
    }

    public boolean requestFocus(int i, Rect rect)
    {
        return getWebViewDelegate().requestFocus(i, rect);
    }

    public AmazonWebBackForwardList restoreState(Bundle bundle)
    {
        checkThread();
        return getWebViewDelegate().restoreState(bundle);
    }

    public void resumeTimers()
    {
        checkThread();
        getWebViewDelegate().resumeTimers();
    }

    public void saveState(Bundle bundle)
    {
        checkThread();
        getWebViewDelegate().saveState(bundle);
    }

    public void scrollBy(int i, int j)
    {
        checkThread();
        getWebViewDelegate().scrollBy(i, j);
    }

    public void setBackgroundColor(int i)
    {
        getWebViewDelegate().setBackgroundColor(i);
    }

    public void setCertificate(SslCertificate sslcertificate)
    {
        checkThread();
        getWebViewDelegate().setCertificate(sslcertificate);
    }

    public void setContentDescription(CharSequence charsequence)
    {
        super.setContentDescription(charsequence);
        getWebViewDelegate().setContentDescription(charsequence);
    }

    public void setDownloadDelegate(AmazonDownloadDelegate amazondownloaddelegate)
    {
        checkThread();
        getWebViewDelegate().setDownloadDelegate(amazondownloaddelegate);
    }

    public void setDownloadListener(AmazonDownloadListener amazondownloadlistener)
    {
        checkThread();
        getWebViewDelegate().setDownloadListener(amazondownloadlistener);
    }

    public void setFindIsUp(boolean flag)
    {
        checkThread();
        getWebViewDelegate().setFindIsUp(flag);
    }

    public void setFindListener(AmazonFindListener amazonfindlistener)
    {
        checkThread();
        getWebViewDelegate().setFindListener(amazonfindlistener);
    }

    public void setHorizontalScrollBarEnabled(boolean flag)
    {
        checkThread();
        getWebViewDelegate().setHorizontalScrollBarEnabled(flag);
    }

    public void setHorizontalScrollbarOverlay(boolean flag)
    {
        checkThread();
        getWebViewDelegate().setHorizontalScrollbarOverlay(flag);
    }

    public void setInitialScale(int i)
    {
        checkThread();
        getWebViewDelegate().setInitialScale(i);
    }

    public void setLayerType(int i, Paint paint)
    {
        if (getWebViewDelegate().setLayerType(i, paint))
        {
            super.setLayerType(i, paint);
        }
    }

    public void setLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        super.setLayoutParams(layoutparams);
        if (webViewDelegate != null)
        {
            webViewDelegate.setLayoutParams(layoutparams);
        }
    }

    public void setLoadingUrl(String s)
    {
        checkThread();
        getWebViewDelegate().setLoadingUrl(s);
    }

    public void setMapTrackballToArrowKeys(boolean flag)
    {
        checkThread();
        getWebViewDelegate().setMapTrackballToArrowKeys(flag);
    }

    public void setNetworkAvailable(boolean flag)
    {
        checkThread();
        getWebViewDelegate().setNetworkAvailable(flag);
    }

    public void setOnKeyListener(android.view.View.OnKeyListener onkeylistener)
    {
        checkThread();
        getWebViewDelegate().setOnKeyListener(onkeylistener);
    }

    public void setOnOverscrollByListener(AmazonOverScrollByListener amazonoverscrollbylistener)
    {
        checkThread();
        getWebViewDelegate().setOnOverscrollByListener(amazonoverscrollbylistener);
    }

    public void setOnScrollChangedListener(AmazonOnScrollChangedListener amazononscrollchangedlistener)
    {
        checkThread();
        getWebViewDelegate().setOnScrollChangedListener(amazononscrollchangedlistener);
    }

    public void setOnScrollingListener(AmazonOnScrollingListener amazononscrollinglistener)
    {
        checkThread();
        getWebViewDelegate().setOnScrollingListener(amazononscrollinglistener);
    }

    public void setOnTouchListener(android.view.View.OnTouchListener ontouchlistener)
    {
        checkThread();
        getWebViewDelegate().setOnTouchListener(ontouchlistener);
    }

    public void setOnTouchOverride(android.view.View.OnTouchListener ontouchlistener)
    {
        checkThread();
        getWebViewDelegate().setOnTouchOverride(ontouchlistener);
    }

    public void setOnUrlLoadRequested(OnUrlLoadRequestedListener onurlloadrequestedlistener)
    {
        checkThread();
        getWebViewDelegate().setOnUrlLoadRequested(onurlloadrequestedlistener);
    }

    public void setOverScrollMode(int i)
    {
        if (webViewDelegate != null)
        {
            webViewDelegate.setOverScrollMode(i);
        }
    }

    public void setScrollBarStyle(int i)
    {
        getWebViewDelegate().setScrollBarStyle(i);
    }

    public void setSelectPopupHandler(AmazonSelectPopupHandler amazonselectpopuphandler)
    {
        checkThread();
        getWebViewDelegate().setSelectPopupHandler(amazonselectpopuphandler);
    }

    public void setVerticalScrollBarEnabled(boolean flag)
    {
        checkThread();
        getWebViewDelegate().setVerticalScrollBarEnabled(flag);
    }

    public void setVerticalScrollbarOverlay(boolean flag)
    {
        checkThread();
        getWebViewDelegate().setVerticalScrollbarOverlay(flag);
    }

    public void setWebBackForwardListClient(AmazonWebBackForwardListClient amazonwebbackforwardlistclient)
    {
        checkThread();
        getWebViewDelegate().setWebBackForwardListClient(amazonwebbackforwardlistclient);
    }

    public void setWebChromeClient(AmazonWebChromeClient amazonwebchromeclient)
    {
        checkThread();
        getWebViewDelegate().setWebChromeClient(amazonwebchromeclient);
    }

    public void setWebViewClient(AmazonWebViewClient amazonwebviewclient)
    {
        checkThread();
        getWebViewDelegate().setWebViewClient(amazonwebviewclient);
    }

    public void setWebViewDelegate(AmazonWebViewDelegate amazonwebviewdelegate)
    {
        if (webViewDelegate == null)
        {
            webViewDelegate = amazonwebviewdelegate;
            return;
        } else
        {
            throw new IllegalStateException("WebViewDelegate is already set.");
        }
    }

    public void setZOrderOverlay(boolean flag)
    {
        checkThread();
        getWebViewDelegate().setZOrderOverlay(flag);
    }

    public boolean shouldDelayChildPressedState()
    {
        return getWebViewDelegate().shouldDelayChildPressedState();
    }

    public void stopLoading()
    {
        checkThread();
        getWebViewDelegate().stopLoading();
    }
}
