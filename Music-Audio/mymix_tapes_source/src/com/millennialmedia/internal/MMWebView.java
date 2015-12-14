// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.utils.EnvironmentUtils;
import com.millennialmedia.internal.utils.ThreadUtils;
import com.millennialmedia.internal.utils.Utils;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.millennialmedia.internal:
//            JSBridge

public class MMWebView extends WebView
    implements android.view.ViewTreeObserver.OnScrollChangedListener
{
    class MMWebChromeClient extends WebChromeClient
    {

        final MMWebView this$0;

        public boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
        {
            if (webview.getContext() != EnvironmentUtils.getApplicationContext())
            {
                return super.onJsAlert(webview, s, s1, jsresult);
            } else
            {
                Toast.makeText(webview.getContext(), s1, 0).show();
                jsresult.confirm();
                return true;
            }
        }

        public boolean onJsBeforeUnload(WebView webview, String s, String s1, JsResult jsresult)
        {
            if (webview.getContext() != EnvironmentUtils.getApplicationContext())
            {
                return super.onJsBeforeUnload(webview, s, s1, jsresult);
            } else
            {
                Toast.makeText(webview.getContext(), s1, 0).show();
                jsresult.confirm();
                return true;
            }
        }

        public boolean onJsConfirm(WebView webview, String s, String s1, JsResult jsresult)
        {
            if (webview.getContext() != EnvironmentUtils.getApplicationContext())
            {
                return super.onJsConfirm(webview, s, s1, jsresult);
            } else
            {
                Toast.makeText(webview.getContext(), s1, 0).show();
                jsresult.confirm();
                return true;
            }
        }

        public boolean onJsPrompt(WebView webview, String s, String s1, String s2, JsPromptResult jspromptresult)
        {
            if (webview.getContext() != EnvironmentUtils.getApplicationContext())
            {
                return super.onJsPrompt(webview, s, s1, s2, jspromptresult);
            } else
            {
                Toast.makeText(webview.getContext(), s1, 0).show();
                jspromptresult.confirm(s2);
                return true;
            }
        }

        MMWebChromeClient()
        {
            this$0 = MMWebView.this;
            super();
        }
    }

    class MMWebViewClient extends WebViewClient
    {

        final MMWebView this$0;

        public void onPageFinished(WebView webview, String s)
        {
            if (!isOriginalUrl(s))
            {
                pageFinished = true;
                setLoaded();
            }
            super.onPageFinished(webview, s);
        }

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            webViewListener.onFailed();
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            while (((MMWebView)webview).isOriginalUrl(s) || !Utils.startActivityFromUrl(s)) 
            {
                return true;
            }
            webViewListener.onAdLeftApplication();
            return true;
        }

        MMWebViewClient()
        {
            this$0 = MMWebView.this;
            super();
        }
    }

    public static interface MMWebViewListener
    {

        public abstract void close();

        public abstract boolean expand(SizableStateManager.ExpandParams expandparams);

        public abstract void onAdLeftApplication();

        public abstract void onClicked();

        public abstract void onFailed();

        public abstract void onLoaded();

        public abstract void onReady();

        public abstract boolean resize(SizableStateManager.ResizeParams resizeparams);

        public abstract void setOrientation(int i);

        public abstract void showCloseIndicator(boolean flag);
    }


    private static final String ASSET_FILE_PATH = "file:///android_asset/";
    private static final String TAG = com/millennialmedia/internal/MMWebView.getSimpleName();
    private int currentPosition[];
    String currentUrl;
    private final Map dimensions = new HashMap();
    private GestureDetector gestureDetector;
    JSBridge jsBridge;
    private boolean jsScriptsInjected;
    private int lastPosition[];
    private boolean pageFinished;
    private final com.millennialmedia.internal.utils.ViewUtils.ViewabilityWatcher viewabilityWatcher = new com.millennialmedia.internal.utils.ViewUtils.ViewabilityWatcher(this, new com.millennialmedia.internal.utils.ViewUtils.ViewabilityListener() {

        final MMWebView this$0;

        public void onViewableChanged(boolean flag2)
        {
            if (jsBridge != null)
            {
                jsBridge.setViewable(flag2);
            }
        }

            
            {
                this$0 = MMWebView.this;
                super();
            }
    });
    private final MMWebViewListener webViewListener;

    public MMWebView(Context context, boolean flag, boolean flag1, final MMWebViewListener webViewListener)
    {
        super(new MutableContextWrapper(context));
        pageFinished = false;
        jsScriptsInjected = false;
        lastPosition = new int[2];
        currentPosition = new int[2];
        if (webViewListener == null)
        {
            throw new IllegalArgumentException("Unable to create MMWebView instance, specified listener is null");
        }
        this.webViewListener = webViewListener;
        if (flag1)
        {
            setBackgroundColor(0);
        }
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        gestureDetector = new GestureDetector(context.getApplicationContext(), new android.view.GestureDetector.SimpleOnGestureListener() {

            final MMWebView this$0;
            final MMWebViewListener val$webViewListener;

            public boolean onSingleTapConfirmed(MotionEvent motionevent)
            {
                webViewListener.onClicked();
                return true;
            }

            
            {
                this$0 = MMWebView.this;
                webViewListener = mmwebviewlistener;
                super();
            }
        });
        setWebViewClient(new MMWebViewClient());
        setWebChromeClient(new MMWebChromeClient());
        context = getSettings();
        context.setJavaScriptEnabled(true);
        context.setCacheMode(-1);
        context.setDefaultTextEncodingName("UTF-8");
        context.setLoadWithOverviewMode(true);
        context.setGeolocationEnabled(true);
        context.setJavaScriptCanOpenWindowsAutomatically(true);
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, "Disabling user gesture requirement for media playback");
            }
            context.setMediaPlaybackRequiresUserGesture(false);
        }
        if (android.os.Build.VERSION.SDK_INT <= 18)
        {
            context.setAllowUniversalAccessFromFileURLs(true);
        }
        jsBridge = new JSBridge(this, flag, new JSBridge.JSBridgeListener() {

            final MMWebView this$0;
            final MMWebViewListener val$webViewListener;

            public void close()
            {
                webViewListener.close();
            }

            public boolean expand(SizableStateManager.ExpandParams expandparams)
            {
                return webViewListener.expand(expandparams);
            }

            public void onAdLeftApplication()
            {
                webViewListener.onAdLeftApplication();
            }

            public void onInjectedScriptsLoaded()
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(MMWebView.TAG, "Injected scripts have been loaded");
                }
                jsScriptsInjected = true;
                setLoaded();
            }

            public void onJSBridgeReady()
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(MMWebView.TAG, "JSBridge is ready");
                }
                jsBridge.setLogLevel(MMLog.logLevel);
                webViewListener.onReady();
            }

            public boolean resize(SizableStateManager.ResizeParams resizeparams)
            {
                return webViewListener.resize(resizeparams);
            }

            public void setOrientation(int i)
            {
                webViewListener.setOrientation(i);
            }

            public void showCloseIndicator(boolean flag2)
            {
                webViewListener.showCloseIndicator(flag2);
            }

            
            {
                this$0 = MMWebView.this;
                webViewListener = mmwebviewlistener;
                super();
            }
        });
        viewabilityWatcher.startWatching();
    }

    private boolean isOriginalUrl(String s)
    {
        return !TextUtils.isEmpty(currentUrl) && (s.startsWith((new StringBuilder()).append(currentUrl).append("?").toString()) || s.startsWith((new StringBuilder()).append(currentUrl).append("#").toString()));
    }

    private void loadUrlOnUiThread(String s)
    {
        try
        {
            super.loadUrl(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MMLog.e(TAG, "Error loading url", s);
        }
    }

    private void setLoaded()
    {
        if (pageFinished && jsScriptsInjected)
        {
            webViewListener.onLoaded();
        }
    }

    public transient void callJavascript(String s, Object aobj[])
    {
        if (jsBridge != null)
        {
            jsBridge.callJavascript(s, aobj);
        }
    }

    public transient void invokeCallback(String s, Object aobj[])
    {
        if (jsBridge != null)
        {
            jsBridge.invokeCallback(s, aobj);
        }
    }

    public void loadDataWithBaseURL(String s, String s1, String s2, String s3, String s4)
    {
        currentUrl = s;
        try
        {
            super.loadDataWithBaseURL(s, s1, s2, s3, s4);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MMLog.e(TAG, "Error hit when calling through to loadDataWithBaseUrl", s);
        }
    }

    public void loadUrl(final String url)
    {
        if (TextUtils.isEmpty(url))
        {
            MMLog.e(TAG, "Url is null or empty");
            return;
        }
        if (url.startsWith("http"))
        {
            currentUrl = url;
        }
        ThreadUtils.runOnUiThread(new Runnable() {

            final MMWebView this$0;
            final String val$url;

            public void run()
            {
                loadUrlOnUiThread(url);
            }

            
            {
                this$0 = MMWebView.this;
                url = s;
                super();
            }
        });
    }

    public void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        getLocationOnScreen(lastPosition);
        ViewTreeObserver viewtreeobserver = getViewTreeObserver();
        if (viewtreeobserver.isAlive())
        {
            viewtreeobserver.addOnScrollChangedListener(this);
        }
    }

    public void onDetachedFromWindow()
    {
        ViewTreeObserver viewtreeobserver = getViewTreeObserver();
        if (viewtreeobserver.isAlive())
        {
            viewtreeobserver.removeOnScrollChangedListener(this);
        }
        super.onDetachedFromWindow();
    }

    public void onNotifyClicked()
    {
        webViewListener.onClicked();
    }

    public void onScrollChanged()
    {
        getLocationOnScreen(currentPosition);
        if (currentPosition[0] != lastPosition[0] || currentPosition[1] != lastPosition[1])
        {
            lastPosition[0] = currentPosition[0];
            lastPosition[1] = currentPosition[1];
            if (jsBridge != null)
            {
                jsBridge.setScrolledPosition(this);
                return;
            }
        }
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        if (jsBridge != null)
        {
            jsBridge.setCurrentPosition(this);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getAction() == 0)
        {
            jsBridge.enableApiCalls();
        }
        gestureDetector.onTouchEvent(motionevent);
        return super.onTouchEvent(motionevent);
    }

    public void setContent(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            webViewListener.onFailed();
            return;
        } else
        {
            jsScriptsInjected = false;
            pageFinished = false;
            ThreadUtils.runOnUiThread(new Runnable() {

                final MMWebView this$0;
                final String val$injectedContent;

                public void run()
                {
                    loadDataWithBaseURL("file:///android_asset/", injectedContent, "text/html", "UTF-8", null);
                }

            
            {
                this$0 = MMWebView.this;
                injectedContent = s;
                super();
            }
            });
            return;
        }
    }

    public void setStateCollapsed()
    {
        if (jsBridge != null)
        {
            jsBridge.setStateCollapsed();
        }
    }

    public void setStateExpanded()
    {
        if (jsBridge != null)
        {
            jsBridge.setStateExpanded();
        }
    }

    public void setStateResized()
    {
        if (jsBridge != null)
        {
            jsBridge.setStateResized();
        }
    }

    public void setStateResizing()
    {
        if (jsBridge != null)
        {
            jsBridge.setStateResizing();
        }
    }

    public void setStateUnresized()
    {
        if (jsBridge != null)
        {
            jsBridge.setStateUnresized();
        }
    }

    public void setTwoPartExpand()
    {
        if (jsBridge != null)
        {
            jsBridge.setTwoPartExpand();
        }
    }




/*
    static boolean access$102(MMWebView mmwebview, boolean flag)
    {
        mmwebview.pageFinished = flag;
        return flag;
    }

*/





/*
    static boolean access$502(MMWebView mmwebview, boolean flag)
    {
        mmwebview.jsScriptsInjected = flag;
        return flag;
    }

*/

}
