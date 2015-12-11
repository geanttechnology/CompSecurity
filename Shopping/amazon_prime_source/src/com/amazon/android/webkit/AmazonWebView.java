// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.FrameLayout;
import java.util.Map;
import java.util.UUID;

// Referenced classes of package com.amazon.android.webkit:
//            AmazonWebViewDelegate, AmazonPictureReadyListener, AmazonWebBackForwardList, AmazonWebSettings, 
//            AmazonValueCallback, AmazonDownloadDelegate, AmazonDownloadListener, AmazonFindListener, 
//            AmazonOverScrollByListener, AmazonOnScrollChangedListener, AmazonOnScrollingListener, AmazonSelectPopupHandler, 
//            AmazonWebBackForwardListClient, AmazonWebChromeClient, AmazonWebViewClient

public class AmazonWebView extends FrameLayout
{
    public static class HitTestResult
    {

        public static final int ANCHOR_TYPE = 1;
        public static final int EDIT_TEXT_TYPE = 9;
        public static final int EMAIL_TYPE = 4;
        public static final int GEO_TYPE = 3;
        public static final int IMAGE_TYPE = 5;
        public static final int PHONE_TYPE = 2;
        public static final int SRC_ANCHOR_TYPE = 7;
        public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
        public static final int UNKNOWN_TYPE = 0;
        private final String extra;
        private final int type;

        public String getExtra()
        {
            return extra;
        }

        public int getType()
        {
            return type;
        }

        public HitTestResult(int i, String s)
        {
            type = i;
            extra = s;
        }

        public HitTestResult(AmazonWebView amazonwebview, int i, String s)
        {
            this(i, s);
        }
    }

    public static interface OnUrlLoadRequestedListener
    {

        public abstract void urlLoadRequested(AmazonWebView amazonwebview, String s);
    }


    public static final String SCHEME_GEO = "geo:0,0?q=";
    public static final String SCHEME_MAILTO = "mailto:";
    public static final String SCHEME_TEL = "tel:";
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

    public static int scale(float f, int i)
    {
        checkThread();
        int j = (int)((float)i * f);
        i = j;
        if (j < 1)
        {
            i = 1;
        }
        return i;
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

    public boolean canGoBackOrForward(int i)
    {
        checkThread();
        return getWebViewDelegate().canGoBackOrForward(i);
    }

    public boolean canGoForward()
    {
        checkThread();
        return getWebViewDelegate().canGoForward();
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

    public boolean canZoomIn()
    {
        checkThread();
        return getWebViewDelegate().canZoomIn();
    }

    public boolean canZoomOut()
    {
        checkThread();
        return getWebViewDelegate().canZoomOut();
    }

    public Picture capturePicture()
    {
        checkThread();
        UnsupportedOperationException unsupportedoperationexception = new UnsupportedOperationException("Use capturePicture(int, int, int, int, int, AmazonPictureReadyListener) instead");
        Log.e(com/amazon/android/webkit/AmazonWebView.getName(), "Unsupported method", unsupportedoperationexception);
        throw unsupportedoperationexception;
    }

    public void capturePicture(int i, int j, int k, int l, int i1, AmazonPictureReadyListener amazonpicturereadylistener)
    {
        checkThread();
        getWebViewDelegate().capturePicture(i, j, k, l, i1, amazonpicturereadylistener);
    }

    public void capturePicture(int i, int j, int k, AmazonPictureReadyListener amazonpicturereadylistener)
    {
        checkThread();
        getWebViewDelegate().capturePicture(i, j, k, amazonpicturereadylistener);
    }

    public void clearCache(boolean flag)
    {
        checkThread();
        getWebViewDelegate().clearCache(flag);
    }

    public void clearFormData()
    {
        checkThread();
        getWebViewDelegate().clearFormData();
    }

    public void clearHistory()
    {
        checkThread();
        getWebViewDelegate().clearHistory();
    }

    public void clearMatches()
    {
        checkThread();
        getWebViewDelegate().clearMatches();
    }

    public void clearSslPreferences()
    {
        checkThread();
        getWebViewDelegate().clearSslPreferences();
    }

    public void clearView()
    {
        checkThread();
        getWebViewDelegate().clearView();
    }

    public void computeScroll()
    {
        getWebViewDelegate().computeScroll();
    }

    public AmazonWebBackForwardList copyBackForwardList()
    {
        checkThread();
        return getWebViewDelegate().copyBackForwardList();
    }

    public void debugDump()
    {
        checkThread();
        getWebViewDelegate().debugDump();
    }

    public void destroy()
    {
        checkThread();
        getWebViewDelegate().destroy();
    }

    public void documentHasImages(Message message)
    {
        checkThread();
        getWebViewDelegate().documentHasImages(message);
    }

    public void draw(Canvas canvas)
    {
        checkThread();
        Log.e(com/amazon/android/webkit/AmazonWebView.getName(), "AmazonWebView.draw() -- Unsupported method; Use capturePicture(int, int, int, int, int, AmazonPictureReadyListener) instead");
    }

    public void dumpDisplayTree()
    {
        checkThread();
        getWebViewDelegate().dumpDisplayTree();
    }

    public void dumpDomTree(boolean flag)
    {
        checkThread();
        getWebViewDelegate().dumpDomTree(flag);
    }

    public void dumpRenderTree(boolean flag)
    {
        checkThread();
        getWebViewDelegate().dumpRenderTree(flag);
    }

    public void dumpV8Counters()
    {
        checkThread();
        getWebViewDelegate().dumpV8Counters();
    }

    public void exitFullscreen()
    {
        checkThread();
        getWebViewDelegate().exitFullscreen();
    }

    public int findAll(String s)
    {
        checkThread();
        return getWebViewDelegate().findAll(s);
    }

    public void findAllAsync(String s)
    {
        checkThread();
        getWebViewDelegate().findAllAsync(s);
    }

    public void findNext(boolean flag)
    {
        checkThread();
        getWebViewDelegate().findNext(flag);
    }

    public void flingScroll(int i, int j)
    {
        checkThread();
        getWebViewDelegate().flingScroll(i, j);
    }

    public void freeMemory()
    {
        checkThread();
        getWebViewDelegate().freeMemory();
    }

    public void generateNewPageLoadID()
    {
        checkThread();
        pageLoadID = UUID.randomUUID().toString();
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

    public String[] getHttpAuthUsernamePassword(String s, String s1)
    {
        checkThread();
        return getWebViewDelegate().getHttpAuthUsernamePassword(s, s1);
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

    public int getScrollBarStyle(int i)
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

    public void goBackOrForward(int i)
    {
        checkThread();
        getWebViewDelegate().goBackOrForward(i);
    }

    public void goForward()
    {
        checkThread();
        getWebViewDelegate().goForward();
    }

    public void invokeZoomPicker()
    {
        checkThread();
        getWebViewDelegate().invokeZoomPicker();
    }

    public boolean isHorizontalScrollBarEnabled()
    {
        checkThread();
        return getWebViewDelegate().isHorizontalScrollBarEnabled();
    }

    public boolean isPrivateBrowsingEnabled()
    {
        checkThread();
        return getWebViewDelegate().isPrivateBrowsingEnabled();
    }

    public boolean isVerticalScrollBarEnabled()
    {
        checkThread();
        return getWebViewDelegate().isVerticalScrollBarEnabled();
    }

    public void loadData(String s, String s1, String s2)
    {
        checkThread();
        getWebViewDelegate().loadData(s, s1, s2);
    }

    public void loadDataWithBaseURL(String s, String s1, String s2, String s3, String s4)
    {
        checkThread();
        getWebViewDelegate().loadDataWithBaseURL(s, s1, s2, s3, s4);
    }

    public void loadUrl(String s)
    {
        checkThread();
        getWebViewDelegate().loadUrl(s);
    }

    public void loadUrl(String s, Map map)
    {
        checkThread();
        getWebViewDelegate().loadUrl(s, map);
    }

    public void loadWebArchive(String s)
    {
        checkThread();
        getWebViewDelegate().loadWebArchive(s);
    }

    public void notifyFindDialogDismissed()
    {
        checkThread();
        getWebViewDelegate().notifyFindDialogDismissed();
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

    public void onPause()
    {
        checkThread();
        getWebViewDelegate().onPause();
    }

    public void onResume()
    {
        checkThread();
        getWebViewDelegate().onResume();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        return getWebViewDelegate().onTouchEvent(motionevent);
    }

    public void onWindowFocusChanged(boolean flag)
    {
        getWebViewDelegate().onWindowFocusChanged(flag);
    }

    public boolean overlayHorizontalScrollbar()
    {
        checkThread();
        return getWebViewDelegate().overlayHorizontalScrollbar();
    }

    public boolean overlayVerticalScrollbar()
    {
        checkThread();
        return getWebViewDelegate().overlayVerticalScrollbar();
    }

    public boolean pageDown(boolean flag)
    {
        checkThread();
        return getWebViewDelegate().pageDown(flag);
    }

    public boolean pageUp(boolean flag)
    {
        checkThread();
        return getWebViewDelegate().pageUp(flag);
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

    public void postUrl(String s, byte abyte0[])
    {
        checkThread();
        getWebViewDelegate().postUrl(s, abyte0);
    }

    public boolean print()
    {
        return getWebViewDelegate().print();
    }

    public void reload()
    {
        checkThread();
        getWebViewDelegate().reload();
    }

    public void removeJavascriptInterface(String s)
    {
        checkThread();
        getWebViewDelegate().removeJavascriptInterface(s);
    }

    public boolean requestFocus(int i, Rect rect)
    {
        return getWebViewDelegate().requestFocus(i, rect);
    }

    public void requestFocusNodeHref(Message message)
    {
        checkThread();
        getWebViewDelegate().requestFocusNodeHref(message);
    }

    public void requestImageRef(Message message)
    {
        checkThread();
        getWebViewDelegate().requestImageRef(message);
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

    public void savePassword(String s, String s1, String s2)
    {
        checkThread();
        getWebViewDelegate().savePassword(s, s1, s2);
    }

    public void saveState(Bundle bundle)
    {
        checkThread();
        getWebViewDelegate().saveState(bundle);
    }

    public void saveWebArchive(String s)
    {
        checkThread();
        getWebViewDelegate().saveWebArchive(s);
    }

    public void saveWebArchive(String s, boolean flag, AmazonValueCallback amazonvaluecallback)
    {
        checkThread();
        getWebViewDelegate().saveWebArchive(s, flag, amazonvaluecallback);
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

    public void setHttpAuthUsernamePassword(String s, String s1, String s2, String s3)
    {
        checkThread();
        getWebViewDelegate().setHttpAuthUsernamePassword(s, s1, s2, s3);
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

    public void setNetworkType(String s, String s1)
    {
        checkThread();
        getWebViewDelegate().setNetworkType(s, s1);
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

    public boolean showFindDialog(String s, boolean flag)
    {
        checkThread();
        return getWebViewDelegate().showFindDialog(s, flag);
    }

    public void stopLoading()
    {
        checkThread();
        getWebViewDelegate().stopLoading();
    }

    public boolean super_requestFocus(int i, Rect rect)
    {
        return super.requestFocus(i, rect);
    }

    public boolean zoomIn()
    {
        checkThread();
        return getWebViewDelegate().zoomIn();
    }

    public boolean zoomOut()
    {
        checkThread();
        return getWebViewDelegate().zoomOut();
    }
}
