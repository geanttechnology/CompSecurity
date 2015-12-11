// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebBackForwardListClient;
import android.webkit.WebHistoryItem;
import android.webkit.WebView;
import com.amazon.android.webkit.AmazonDownloadDelegate;
import com.amazon.android.webkit.AmazonDownloadListener;
import com.amazon.android.webkit.AmazonFindListener;
import com.amazon.android.webkit.AmazonPictureReadyListener;
import com.amazon.android.webkit.AmazonSelectPopupHandler;
import com.amazon.android.webkit.AmazonValueCallback;
import com.amazon.android.webkit.AmazonWebBackForwardList;
import com.amazon.android.webkit.AmazonWebBackForwardListClient;
import com.amazon.android.webkit.AmazonWebChromeClient;
import com.amazon.android.webkit.AmazonWebHistoryItem;
import com.amazon.android.webkit.AmazonWebSettings;
import com.amazon.android.webkit.AmazonWebView;
import com.amazon.android.webkit.AmazonWebViewClient;
import com.amazon.android.webkit.AmazonWebViewDelegate;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.amazon.android.webkit.android:
//            Reflect, AndroidWebSettings, AndroidWebViewReflection, AndroidWebChromeClient, 
//            AndroidWebViewClient

public class AndroidWebViewDelegate extends AmazonWebViewDelegate
{

    private static final Method DEBUG_DUMP;
    private static final int KITKAT_VERSION_NUMBER = 19;
    private static final Field WEB_HISTORY_ITEM_DATA_FIELD;
    private final int solidColor;
    private final AtomicReference urlRequestHandler;
    private final AmazonWebSettings webSettings;
    private final WebView webviewDelegate;
    private final AndroidWebViewReflection webviewReflection;

    public AndroidWebViewDelegate(AmazonWebView amazonwebview, int i, AtomicReference atomicreference)
    {
        super(amazonwebview);
        amazonwebview.setVerticalFadingEdgeEnabled(true);
        amazonwebview.setFadingEdgeLength(10);
        solidColor = i;
        webviewDelegate = new WebView(amazonwebview.getContext()) {

            final AndroidWebViewDelegate this$0;

            protected void onScrollChanged(int j, int k, int l, int i1)
            {
                onWebViewScrollChanged(j, k);
                super.onScrollChanged(j, k, l, i1);
            }

            public boolean onTouchEvent(MotionEvent motionevent)
            {
                return onWebViewTouchEvent(motionevent) || super.onTouchEvent(motionevent);
            }

            public boolean overScrollBy(int j, int k, int l, int i1, int j1, int k1, int l1, 
                    int i2, boolean flag)
            {
                onWebViewOverScrollBy(j, k, l, i1, j1, k1, l1, i2, flag);
                onWebViewScrolling(j, k, l, i1);
                return super.overScrollBy(j, k, l, i1, j1, k1, l1, i2, flag);
            }

            
            {
                this$0 = AndroidWebViewDelegate.this;
                super(context);
            }
        };
        urlRequestHandler = atomicreference;
        webSettings = new AndroidWebSettings(webviewDelegate.getSettings());
        webviewReflection = AndroidWebViewReflection.create(webviewDelegate);
        amazonwebview.addView(webviewDelegate);
    }

    private AmazonWebBackForwardList convertWebBackForwardList(WebBackForwardList webbackforwardlist)
    {
        if (webbackforwardlist == null)
        {
            return null;
        }
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < webbackforwardlist.getSize(); i++)
        {
            WebHistoryItem webhistoryitem = webbackforwardlist.getItemAtIndex(i);
            arraylist.add(new AmazonWebHistoryItem(webhistoryitem.getFavicon(), 0, webhistoryitem.getOriginalUrl(), webhistoryitem.getTitle(), webhistoryitem.getUrl(), getWebHistoryItemFlattenedData(webhistoryitem)));
        }

        return new AmazonWebBackForwardList(arraylist, webbackforwardlist.getCurrentIndex());
    }

    private byte[] getWebHistoryItemFlattenedData(WebHistoryItem webhistoryitem)
    {
        if (WEB_HISTORY_ITEM_DATA_FIELD == null)
        {
            Log.e(com/amazon/android/webkit/android/AndroidWebViewDelegate.getName(), "Method not supported in Android WebView", new UnsupportedOperationException());
            return null;
        }
        try
        {
            webhistoryitem = (byte[])(byte[])WEB_HISTORY_ITEM_DATA_FIELD.get(webhistoryitem);
        }
        // Misplaced declaration of an exception variable
        catch (WebHistoryItem webhistoryitem)
        {
            throw new RuntimeException(webhistoryitem);
        }
        // Misplaced declaration of an exception variable
        catch (WebHistoryItem webhistoryitem)
        {
            throw new RuntimeException(webhistoryitem);
        }
        return webhistoryitem;
    }

    private AndroidWebViewReflection getWebViewReflection()
    {
        if (webviewReflection == null)
        {
            Log.e(com/amazon/android/webkit/android/AndroidWebViewDelegate.getName(), "Method not supported in Android WebView", new UnsupportedOperationException());
        }
        return webviewReflection;
    }

    public void addJavascriptInterface(Object obj, String s)
    {
        webviewDelegate.addJavascriptInterface(obj, s);
    }

    public boolean canGoBack()
    {
        return webviewDelegate.canGoBack();
    }

    public boolean canGoBackOrForward(int i)
    {
        return webviewDelegate.canGoBackOrForward(i);
    }

    public boolean canGoForward()
    {
        return webviewDelegate.canGoForward();
    }

    public boolean canScrollHorizontally(int i)
    {
        return webviewDelegate.canScrollHorizontally(i);
    }

    public boolean canScrollVertically(int i)
    {
        return webviewDelegate.canScrollVertically(i);
    }

    public boolean canZoomIn()
    {
        return webviewDelegate.canZoomIn();
    }

    public boolean canZoomOut()
    {
        return webviewDelegate.canZoomOut();
    }

    public Picture capturePicture()
    {
        return webviewDelegate.capturePicture();
    }

    public void capturePicture(int i, int j, int k, int l, int i1, AmazonPictureReadyListener amazonpicturereadylistener)
    {
        Object obj;
label0:
        {
            if (k <= 0 || l <= 0 || i1 <= 0)
            {
                throw new IllegalArgumentException("Invalid width or height.");
            }
            if (amazonpicturereadylistener == null)
            {
                throw new IllegalArgumentException("AmazonPictureReadyListener cannot be null.");
            }
            int j1 = AmazonWebView.scale((float)l / (float)k, i1);
            Bitmap bitmap = Bitmap.createBitmap(k, l, android.graphics.Bitmap.Config.ARGB_8888);
            obj = bitmap;
            if (bitmap == null)
            {
                break label0;
            }
            obj = new Canvas(bitmap);
            ((Canvas) (obj)).translate(-i, -j);
            webviewDelegate.draw(((Canvas) (obj)));
            if (i1 == k)
            {
                obj = bitmap;
                if (j1 == l)
                {
                    break label0;
                }
            }
            obj = Bitmap.createScaledBitmap(bitmap, i1, j1, true);
            bitmap.recycle();
        }
        amazonpicturereadylistener.onPictureReady(((Bitmap) (obj)));
    }

    public void capturePicture(int i, int j, int k, AmazonPictureReadyListener amazonpicturereadylistener)
    {
        capturePicture(0, 0, i, j, k, amazonpicturereadylistener);
    }

    public void clearCache(boolean flag)
    {
        webviewDelegate.clearCache(flag);
    }

    public void clearFormData()
    {
        webviewDelegate.clearFormData();
    }

    public void clearHistory()
    {
        webviewDelegate.clearHistory();
    }

    public void clearMatches()
    {
        webviewDelegate.clearMatches();
    }

    public void clearSslPreferences()
    {
        webviewDelegate.clearSslPreferences();
    }

    public void clearView()
    {
        webviewDelegate.clearView();
    }

    public void computeScroll()
    {
        webviewDelegate.computeScroll();
    }

    public AmazonWebBackForwardList copyBackForwardList()
    {
        return convertWebBackForwardList(webviewDelegate.copyBackForwardList());
    }

    public void debugDump()
    {
        if (DEBUG_DUMP != null)
        {
            Reflect.invokeMethod(DEBUG_DUMP, webviewDelegate, new Object[0]);
        }
    }

    public void destroy()
    {
        webviewDelegate.destroy();
    }

    public void documentHasImages(Message message)
    {
        webviewDelegate.documentHasImages(message);
    }

    public void dumpDisplayTree()
    {
        if (getWebViewReflection() != null)
        {
            getWebViewReflection().dumpDisplayTree();
        }
    }

    public void dumpDomTree(boolean flag)
    {
        if (getWebViewReflection() != null)
        {
            getWebViewReflection().dumpDomTree(flag);
        }
    }

    public void dumpRenderTree(boolean flag)
    {
        if (getWebViewReflection() != null)
        {
            getWebViewReflection().dumpRenderTree(flag);
        }
    }

    public void dumpV8Counters()
    {
        if (getWebViewReflection() != null)
        {
            getWebViewReflection().dumpV8Counters();
        }
    }

    public void exitFullscreen()
    {
        throw new UnsupportedOperationException();
    }

    public int findAll(String s)
    {
        return webviewDelegate.findAll(s);
    }

    public void findAllAsync(String s)
    {
        if (getWebViewReflection() != null)
        {
            getWebViewReflection().findAllAsync(s);
        }
    }

    public void findNext(boolean flag)
    {
        webviewDelegate.findNext(flag);
    }

    public void flingScroll(int i, int j)
    {
        webviewDelegate.flingScroll(i, j);
    }

    public void freeMemory()
    {
        webviewDelegate.freeMemory();
    }

    public SslCertificate getCertificate()
    {
        return webviewDelegate.getCertificate();
    }

    public int getContentHeight()
    {
        return webviewDelegate.getContentHeight();
    }

    WebView getDelegate()
    {
        return webviewDelegate;
    }

    public Bitmap getFavicon()
    {
        return webviewDelegate.getFavicon();
    }

    public com.amazon.android.webkit.AmazonWebView.HitTestResult getHitTestResult()
    {
        android.webkit.WebView.HitTestResult hittestresult = webviewDelegate.getHitTestResult();
        return new com.amazon.android.webkit.AmazonWebView.HitTestResult(hittestresult.getType(), hittestresult.getExtra());
    }

    public String[] getHttpAuthUsernamePassword(String s, String s1)
    {
        return webviewDelegate.getHttpAuthUsernamePassword(s, s1);
    }

    public String getOriginalUrl()
    {
        return webviewDelegate.getOriginalUrl();
    }

    public int getProgress()
    {
        return webviewDelegate.getProgress();
    }

    public float getScale()
    {
        return webviewDelegate.getScale();
    }

    public int getScrollBarStyle()
    {
        return webviewDelegate.getScrollBarStyle();
    }

    public AmazonWebSettings getSettings()
    {
        return webSettings;
    }

    public int getSolidColor()
    {
        return solidColor;
    }

    public String getTitle()
    {
        return webviewDelegate.getTitle();
    }

    public String getTouchIconUrl()
    {
        if (getWebViewReflection() == null)
        {
            return null;
        } else
        {
            return getWebViewReflection().getTouchIconUrl();
        }
    }

    public String getUrl()
    {
        return webviewDelegate.getUrl();
    }

    public int getVerticalScrollOffset()
    {
        if (getWebViewReflection() == null)
        {
            return 0;
        } else
        {
            return getWebViewReflection().getVerticalScrollOffset();
        }
    }

    public void goBack()
    {
        webviewDelegate.goBack();
    }

    public void goBackOrForward(int i)
    {
        webviewDelegate.goBackOrForward(i);
    }

    public void goForward()
    {
        webviewDelegate.goForward();
    }

    public void invokeZoomPicker()
    {
        webviewDelegate.invokeZoomPicker();
    }

    public boolean isHorizontalScrollBarEnabled()
    {
        return webviewDelegate.isHorizontalScrollBarEnabled();
    }

    public boolean isPrivateBrowsingEnabled()
    {
        return webviewDelegate.isPrivateBrowsingEnabled();
    }

    public boolean isVerticalScrollBarEnabled()
    {
        return webviewDelegate.isVerticalScrollBarEnabled();
    }

    public void loadData(String s, String s1, String s2)
    {
        webviewDelegate.loadData(s, s1, s2);
    }

    public void loadDataWithBaseURL(String s, String s1, String s2, String s3, String s4)
    {
        webviewDelegate.loadDataWithBaseURL(s, s1, s2, s3, s4);
    }

    public void loadUrl(String s)
    {
        onUrlLoadRequested(s);
        webviewDelegate.loadUrl(s);
    }

    public void loadUrl(String s, Map map)
    {
        onUrlLoadRequested(s);
        webviewDelegate.loadUrl(s, map);
    }

    public void loadWebArchive(String s)
    {
        if (getWebViewReflection() != null)
        {
            getWebViewReflection().loadWebArchive(s);
        }
    }

    public void notifyFindDialogDismissed()
    {
        if (getWebViewReflection() != null)
        {
            getWebViewReflection().notifyFindDialogDismissed();
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorinfo)
    {
        return webviewDelegate.onCreateInputConnection(editorinfo);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        webviewDelegate.onInitializeAccessibilityEvent(accessibilityevent);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo)
    {
        webviewDelegate.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
    }

    public void onPause()
    {
        if (getWebViewReflection() != null)
        {
            getWebViewReflection().onPause();
            return;
        } else
        {
            webviewDelegate.onPause();
            return;
        }
    }

    public void onResume()
    {
        if (getWebViewReflection() != null)
        {
            getWebViewReflection().onResume();
            return;
        } else
        {
            webviewDelegate.onResume();
            return;
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        return false;
    }

    public void onWindowFocusChanged(boolean flag)
    {
        webviewDelegate.onWindowFocusChanged(flag);
    }

    public boolean overlayHorizontalScrollbar()
    {
        return webviewDelegate.overlayHorizontalScrollbar();
    }

    public boolean overlayVerticalScrollbar()
    {
        return webviewDelegate.overlayVerticalScrollbar();
    }

    public boolean pageDown(boolean flag)
    {
        return webviewDelegate.pageDown(flag);
    }

    public boolean pageUp(boolean flag)
    {
        return webviewDelegate.pageUp(flag);
    }

    public void pauseTimers()
    {
        webviewDelegate.pauseTimers();
    }

    public boolean performAccessibilityAction(int i, Bundle bundle)
    {
        return webviewDelegate.performAccessibilityAction(i, bundle);
    }

    public boolean performLongClick()
    {
        return webviewDelegate.performLongClick();
    }

    public void postUrl(String s, byte abyte0[])
    {
        webviewDelegate.postUrl(s, abyte0);
    }

    public void reload()
    {
        onUrlLoadRequested(getUrl());
        webviewDelegate.reload();
    }

    public void removeJavascriptInterface(String s)
    {
        webviewDelegate.removeJavascriptInterface(s);
    }

    public boolean requestFocus(int i, Rect rect)
    {
        return webviewDelegate.requestFocus(i, rect);
    }

    public void requestFocusNodeHref(Message message)
    {
        webviewDelegate.requestFocusNodeHref(message);
    }

    public void requestImageRef(Message message)
    {
        webviewDelegate.requestImageRef(message);
    }

    public AmazonWebBackForwardList restoreState(Bundle bundle)
    {
        return convertWebBackForwardList(webviewDelegate.restoreState(bundle));
    }

    public void resumeTimers()
    {
        webviewDelegate.resumeTimers();
    }

    public void savePassword(String s, String s1, String s2)
    {
        webviewDelegate.savePassword(s, s1, s2);
    }

    public void saveState(Bundle bundle)
    {
        webviewDelegate.saveState(bundle);
    }

    public void saveWebArchive(String s)
    {
        webviewDelegate.saveWebArchive(s);
    }

    public void saveWebArchive(String s, boolean flag, final AmazonValueCallback callback)
    {
        webviewDelegate.saveWebArchive(s, flag, new ValueCallback() {

            final AndroidWebViewDelegate this$0;
            final AmazonValueCallback val$callback;

            public volatile void onReceiveValue(Object obj)
            {
                onReceiveValue((String)obj);
            }

            public void onReceiveValue(String s1)
            {
                callback.onReceiveValue(s1);
            }

            
            {
                this$0 = AndroidWebViewDelegate.this;
                callback = amazonvaluecallback;
                super();
            }
        });
    }

    public void scrollBy(int i, int j)
    {
        webviewDelegate.scrollBy(i, j);
    }

    public void setBackgroundColor(int i)
    {
        webviewDelegate.setBackgroundColor(i);
    }

    public void setCertificate(SslCertificate sslcertificate)
    {
        webviewDelegate.setCertificate(sslcertificate);
    }

    public void setContentDescription(CharSequence charsequence)
    {
        webviewDelegate.setContentDescription(charsequence);
    }

    public void setDownloadDelegate(final AmazonDownloadDelegate delegate)
    {
        DownloadListener downloadlistener = null;
        if (delegate != null)
        {
            downloadlistener = new DownloadListener() {

                final AndroidWebViewDelegate this$0;
                final AmazonDownloadDelegate val$delegate;

                public void onDownloadStart(String s, String s1, String s2, String s3, long l)
                {
                    delegate.requestHttpGetDownload(s, s1, s2, s3, "", "", l);
                }

            
            {
                this$0 = AndroidWebViewDelegate.this;
                delegate = amazondownloaddelegate;
                super();
            }
            };
        }
        webviewDelegate.setDownloadListener(downloadlistener);
    }

    public void setDownloadListener(final AmazonDownloadListener listener)
    {
        DownloadListener downloadlistener = null;
        if (listener != null)
        {
            downloadlistener = new DownloadListener() {

                final AndroidWebViewDelegate this$0;
                final AmazonDownloadListener val$listener;

                public void onDownloadStart(String s, String s1, String s2, String s3, long l)
                {
                    listener.onDownloadStart(s, s1, s2, s3, l);
                }

            
            {
                this$0 = AndroidWebViewDelegate.this;
                listener = amazondownloadlistener;
                super();
            }
            };
        }
        webviewDelegate.setDownloadListener(downloadlistener);
    }

    public void setFindIsUp(boolean flag)
    {
        if (getWebViewReflection() != null)
        {
            getWebViewReflection().setFindIsUp(flag);
        }
    }

    public void setFindListener(AmazonFindListener amazonfindlistener)
    {
        if (getWebViewReflection() != null)
        {
            getWebViewReflection().setFindListener(amazonfindlistener);
        }
    }

    public void setHorizontalScrollBarEnabled(boolean flag)
    {
        webviewDelegate.setHorizontalScrollBarEnabled(flag);
    }

    public void setHorizontalScrollbarOverlay(boolean flag)
    {
        webviewDelegate.setHorizontalScrollbarOverlay(flag);
    }

    public void setHttpAuthUsernamePassword(String s, String s1, String s2, String s3)
    {
        webviewDelegate.setHttpAuthUsernamePassword(s, s1, s2, s3);
    }

    public void setInitialScale(int i)
    {
        webviewDelegate.setInitialScale(i);
    }

    public boolean setLayerType(int i, Paint paint)
    {
        webviewDelegate.setLayerType(i, paint);
        return true;
    }

    public void setMapTrackballToArrowKeys(boolean flag)
    {
        webviewDelegate.setMapTrackballToArrowKeys(flag);
    }

    public void setNetworkAvailable(boolean flag)
    {
        webviewDelegate.setNetworkAvailable(flag);
    }

    public void setNetworkType(String s, String s1)
    {
        if (getWebViewReflection() != null)
        {
            getWebViewReflection().setNetworkType(s, s1);
        }
    }

    public void setOnKeyListener(android.view.View.OnKeyListener onkeylistener)
    {
        webviewDelegate.setOnKeyListener(onkeylistener);
    }

    public void setOnTouchListener(android.view.View.OnTouchListener ontouchlistener)
    {
        webviewDelegate.setOnTouchListener(ontouchlistener);
    }

    public void setOverScrollMode(int i)
    {
        if (webviewDelegate != null)
        {
            webviewDelegate.setOverScrollMode(i);
        }
    }

    public void setScrollBarStyle(int i)
    {
        webviewDelegate.setScrollBarStyle(i);
    }

    public void setSelectPopupHandler(AmazonSelectPopupHandler amazonselectpopuphandler)
    {
        throw new UnsupportedOperationException();
    }

    public void setVerticalScrollBarEnabled(boolean flag)
    {
        webviewDelegate.setVerticalScrollBarEnabled(flag);
    }

    public void setVerticalScrollbarOverlay(boolean flag)
    {
        webviewDelegate.setVerticalScrollbarOverlay(flag);
    }

    public void setWebBackForwardListClient(final AmazonWebBackForwardListClient client)
    {
        if (getWebViewReflection() == null)
        {
            return;
        }
        WebBackForwardListClient webbackforwardlistclient = null;
        if (client != null)
        {
            webbackforwardlistclient = new WebBackForwardListClient() {

                final AndroidWebViewDelegate this$0;
                final AmazonWebBackForwardListClient val$client;

                public void onIndexChanged(WebHistoryItem webhistoryitem, int i)
                {
                    client.onIndexChanged(new AmazonWebHistoryItem(webhistoryitem.getFavicon(), 0, webhistoryitem.getOriginalUrl(), webhistoryitem.getTitle(), webhistoryitem.getUrl(), getWebHistoryItemFlattenedData(webhistoryitem)), i);
                }

                public void onNewHistoryItem(WebHistoryItem webhistoryitem)
                {
                    client.onNewHistoryItem(new AmazonWebHistoryItem(webhistoryitem.getFavicon(), 0, webhistoryitem.getOriginalUrl(), webhistoryitem.getTitle(), webhistoryitem.getUrl(), getWebHistoryItemFlattenedData(webhistoryitem)));
                }

            
            {
                this$0 = AndroidWebViewDelegate.this;
                client = amazonwebbackforwardlistclient;
                super();
            }
            };
        }
        getWebViewReflection().setWebBackForwardListClient(webbackforwardlistclient);
    }

    public void setWebChromeClient(AmazonWebChromeClient amazonwebchromeclient)
    {
        webviewDelegate.setWebChromeClient(new AndroidWebChromeClient(getWebView(), amazonwebchromeclient));
    }

    public void setWebViewClient(AmazonWebViewClient amazonwebviewclient)
    {
        AndroidWebViewClient androidwebviewclient = null;
        if (amazonwebviewclient != null)
        {
            androidwebviewclient = new AndroidWebViewClient(getWebView(), amazonwebviewclient);
        }
        webviewDelegate.setWebViewClient(androidwebviewclient);
    }

    public void setZOrderOverlay(boolean flag)
    {
    }

    public boolean shouldDelayChildPressedState()
    {
        return webviewDelegate.shouldDelayChildPressedState();
    }

    public boolean showFindDialog(String s, boolean flag)
    {
        return webviewDelegate.showFindDialog(s, flag);
    }

    public void stopLoading()
    {
        webviewDelegate.stopLoading();
    }

    public boolean zoomIn()
    {
        return webviewDelegate.zoomIn();
    }

    public boolean zoomOut()
    {
        return webviewDelegate.zoomOut();
    }

    static 
    {
        Object obj;
        Object obj1;
        /*<invalid signature>*/java.lang.Object local;
        local = android/webkit/WebHistoryItem;
        obj1 = null;
        obj = local;
        if (android.os.Build.VERSION.SDK_INT <= 16)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        obj = local;
        if (android.os.Build.VERSION.SDK_INT < 19)
        {
            obj = Reflect.getRequiredClass("android.webkit.WebHistoryItemClassic");
        }
        obj = Reflect.getRequiredPrivateField(((Class) (obj)), "mFlattenedData");
_L2:
        WEB_HISTORY_ITEM_DATA_FIELD = ((Field) (obj));
        DEBUG_DUMP = Reflect.getOptionalMethod(android/webkit/WebView, "debugDump", new Class[0]);
        return;
        AssertionError assertionerror;
        assertionerror;
        assertionerror = obj1;
        if (true) goto _L2; else goto _L1
_L1:
    }





}
