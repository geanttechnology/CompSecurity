// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.amazon.mShop.net.CookieBridge;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.AmazonErrorUtils;
import com.amazon.mShop.util.BuildUtils;
import com.amazon.mShop.util.LayoutUtils;
import com.amazon.mShop.util.WebUtils;
import com.amazon.mShop.web.security.WebViewSecurity;

// Referenced classes of package com.amazon.mShop:
//            TitleProvider, AmazonProgressDialog, AmazonActivity

public class AmazonBrandedWebView extends LinearLayout
    implements TitleProvider
{
    private class DefaultWebChromeClient extends WebChromeClient
    {

        final AmazonBrandedWebView this$0;

        public void onReceivedTitle(WebView webview, String s)
        {
            if (mIsReceivedError)
            {
                mIsReceivedError = false;
            } else
            {
                mTitle = s;
                webview = webview.getContext();
                if (webview instanceof AmazonActivity)
                {
                    ((AmazonActivity)webview).updateTitle(AmazonBrandedWebView.this);
                    return;
                }
            }
        }

        private DefaultWebChromeClient()
        {
            this$0 = AmazonBrandedWebView.this;
            super();
        }

    }

    private class DialogDismisser
        implements Runnable
    {

        private final int myPageStartCount;
        final AmazonBrandedWebView this$0;

        public void run()
        {
            if (myPageStartCount == mPageStartCount)
            {
                dismissDialogIfShowing();
            }
        }

        private DialogDismisser()
        {
            this$0 = AmazonBrandedWebView.this;
            super();
            myPageStartCount = mPageStartCount;
        }

    }

    private class MyWebViewClient extends WebViewClient
    {

        final AmazonBrandedWebView this$0;

        public void onPageFinished(WebView webview, String s)
        {
            if (isAttachedToWindow())
            {
                com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new DialogDismisser(), 350L);
            }
        }

        public void onPageStarted(WebView webview, String s, Bitmap bitmap)
        {
            boolean flag = WebViewSecurity.shouldBlockWebViewLoading(webview, s);
            if (WebViewSecurity.isHTTPUrl(s))
            {
                WebViewSecurity.logMetricsForHTTPRequest(webview.getUrl(), s, flag);
            }
            if (flag)
            {
                webview.stopLoading();
                AmazonErrorUtils.reportErrorWithGeneralErrorMessageAndGoToAmazonHome((AmazonActivity)webview.getContext(), 5);
            } else
            if (isAttachedToWindow())
            {
                int i = ((onReceivedError) (this)).onReceivedError + 1;
                if (!mDialog.isShowing())
                {
                    try
                    {
                        mDialog.show();
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (WebView webview)
                    {
                        Log.e("ProgressDialog", webview.getMessage());
                    }
                    return;
                }
            }
        }

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            super.onReceivedError(webview, i, s, s1);
            mIsReceivedError = true;
            s = webview.getContext();
            if (s instanceof AmazonActivity)
            {
                s = (AmazonActivity)s;
                AmazonErrorUtils.reportWebViewClientError(s, webview, s.getCurrentView());
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            if (WebUtils.handleMailtoLink(webview.getContext(), s))
            {
                return true;
            }
            if (WebViewSecurity.shouldBlockWebViewLoading(webview, s))
            {
                AmazonErrorUtils.reportErrorWithGeneralErrorMessageAndGoToAmazonHome((AmazonActivity)webview.getContext(), 5);
                WebViewSecurity.logMetricsForHTTPRequest(webview.getUrl(), s, true);
                return true;
            } else
            {
                return false;
            }
        }

        private MyWebViewClient()
        {
            this$0 = AmazonBrandedWebView.this;
            super();
        }

    }


    private final AmazonProgressDialog mDialog;
    private boolean mIsAttachedToWindow;
    private boolean mIsReceivedError;
    private int mPageStartCount;
    private String mTitle;
    private final WebView mWebView;

    public AmazonBrandedWebView(Context context, String s, String s1)
    {
        this(context, s, s1, false);
    }

    public AmazonBrandedWebView(Context context, String s, String s1, boolean flag)
    {
        super(context);
        mIsReceivedError = false;
        mIsAttachedToWindow = false;
        mTitle = s1;
        setOrientation(1);
        setLayoutParams(LayoutUtils.fillBoth());
        initializeBrandedWebViewCookie(context);
        mWebView = new WebView(context);
        mWebView.setLayoutParams(LayoutUtils.fillBoth());
        mWebView.setWebViewClient(new MyWebViewClient());
        if (flag)
        {
            mWebView.setWebChromeClient(new DefaultWebChromeClient());
        }
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setScrollBarStyle(0);
        addView(mWebView);
        mDialog = new AmazonProgressDialog(context);
        mDialog.setTitle(com.amazon.mShop.android.lib.R.string.web_view_loading);
        mPageStartCount = 0;
        mWebView.loadUrl(s);
        mWebView.requestFocus();
        mWebView.requestFocus(130);
        mWebView.setOnTouchListener(new android.view.View.OnTouchListener() {

            final AmazonBrandedWebView this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                motionevent.getAction();
                JVM INSTR tableswitch 0 1: default 28
            //                           0 30
            //                           1 30;
                   goto _L1 _L2 _L2
_L1:
                return false;
_L2:
                if (!view.hasFocus())
                {
                    view.requestFocus();
                }
                if (true) goto _L1; else goto _L3
_L3:
            }

            
            {
                this$0 = AmazonBrandedWebView.this;
                super();
            }
        });
    }

    public void dismissDialogIfShowing()
    {
        if (mDialog.isShowing())
        {
            mDialog.dismiss();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        Context context = getContext();
        if ((context instanceof AmazonActivity) && ((AmazonActivity)context).menuDispatchedKeyEvent(keyevent))
        {
            return true;
        }
        if (keyevent.getKeyCode() == 4 && keyevent.getAction() == 0)
        {
            dismissDialogIfShowing();
            if (mWebView.canGoBack())
            {
                if (getContext() instanceof AmazonActivity)
                {
                    ((AmazonActivity)getContext()).clearErrorOnView(this);
                    mWebView.setVisibility(0);
                }
                mWebView.goBack();
                return true;
            }
        }
        return super.dispatchKeyEvent(keyevent);
    }

    public CharSequence getTitle()
    {
        return mTitle;
    }

    public void initializeBrandedWebViewCookie(Context context)
    {
        String s = (new StringBuilder()).append(AndroidPlatform.getInstance().getApplicationName()).append("/").append(AndroidPlatform.getInstance().getApplicationVersion()).append("/").append(BuildUtils.getRevisionNumber(context)).toString();
        context = CookieBridge.getCookieDomain(context, true);
        CookieManager.getInstance().setCookie((new StringBuilder()).append("www").append(context).toString(), (new StringBuilder()).append("amzn-app-id=").append(s).append("; Domain=").append(context).toString());
    }

    public boolean isAttachedToWindow()
    {
        return mIsAttachedToWindow;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        setAttachedtoWindow(true);
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        setAttachedtoWindow(false);
    }

    public void setAttachedtoWindow(boolean flag)
    {
        mIsAttachedToWindow = flag;
    }



/*
    static int access$204(AmazonBrandedWebView amazonbrandedwebview)
    {
        int i = amazonbrandedwebview.mPageStartCount + 1;
        amazonbrandedwebview.mPageStartCount = i;
        return i;
    }

*/




/*
    static boolean access$502(AmazonBrandedWebView amazonbrandedwebview, boolean flag)
    {
        amazonbrandedwebview.mIsReceivedError = flag;
        return flag;
    }

*/


/*
    static String access$602(AmazonBrandedWebView amazonbrandedwebview, String s)
    {
        amazonbrandedwebview.mTitle = s;
        return s;
    }

*/
}
