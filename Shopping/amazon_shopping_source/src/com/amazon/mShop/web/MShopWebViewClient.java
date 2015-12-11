// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Message;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonProgressDialog;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.mash.interception.MShopUrlIntercepter;
import com.amazon.mShop.mash.nav.AmazonNavManager;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.AmazonErrorUtils;
import com.amazon.mShop.util.DebugUtil;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.util.Util;
import com.amazon.mShop.util.WebUtils;
import com.amazon.mShop.web.security.WebViewSecurity;
import com.amazon.mobile.mash.MASHWebView;
import com.amazon.mobile.mash.MASHWebViewClient;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewContainer, MShopWebViewTransitionManager, MShopWebView, MShopWebActivity

public class MShopWebViewClient extends MASHWebViewClient
{

    private static final Pattern AUTH_PORTAL_SERVER = Pattern.compile("^https?://.*\\.amazon\\.[\\w\\.]+/ap/signin");
    protected static final boolean DEBUG = DebugSettings.isDebugEnabled();
    private boolean mIsAlreadyPageLoadHandled;
    private boolean mNeedHandleSignIn;
    private String mPendingUrl;
    private AmazonProgressDialog mProgressDialog;
    private MShopWebViewContainer mWebViewContainer;

    public MShopWebViewClient(CordovaInterface cordovainterface)
    {
        super(cordovainterface, new AmazonNavManager(), new MShopUrlIntercepter());
        mPendingUrl = null;
        mIsAlreadyPageLoadHandled = false;
        mNeedHandleSignIn = true;
    }

    public MShopWebViewClient(CordovaInterface cordovainterface, AmazonNavManager amazonnavmanager)
    {
        super(cordovainterface, amazonnavmanager, new MShopUrlIntercepter());
        mPendingUrl = null;
        mIsAlreadyPageLoadHandled = false;
        mNeedHandleSignIn = true;
    }

    private boolean handleURLProtocolUnsupportedScheme(Context context, String s)
    {
        if (s != null)
        {
            try
            {
                new URL(s);
            }
            catch (MalformedURLException malformedurlexception)
            {
                if (DEBUG)
                {
                    Log.i("MShopWebViewClient", (new StringBuilder()).append("handleURLProtocolUnsupportedScheme: url = ").append(s).toString());
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(s));
                try
                {
                    context.startActivity(intent);
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    Log.e("MShopWebViewClient", (new StringBuilder()).append("handleURLProtocolUnsupportedScheme ").append(context.toString()).toString());
                }
                return true;
            }
        }
        return false;
    }

    private void logViewHistoryInUDP(WebView webview, String s)
    {
        MShopWebViewTransitionManager mshopwebviewtransitionmanager = mWebViewContainer.getTransitionManager();
        if (mshopwebviewtransitionmanager == null || !mshopwebviewtransitionmanager.isBackTransitionPending())
        {
            if (!Util.isEmpty(s = Uri.parse(s).getPath()) && s.startsWith("/gp/aw/d/"))
            {
                int i = "/gp/aw/d/".length();
                int j = s.indexOf("/", i);
                if (j != -1)
                {
                    s = s.substring(i, j);
                } else
                {
                    s = s.substring(i);
                }
                if (!Util.isEmpty(s))
                {
                    ActivityUtils.logViewHistory(webview.getContext(), s);
                }
                if (DEBUG)
                {
                    Log.v("MShopWebViewClient", (new StringBuilder()).append("logViewHistory In UDP, asin = ").append(s).toString());
                    return;
                }
            }
        }
    }

    public void doUpdateVisitedHistory(WebView webview, String s, boolean flag)
    {
        super.doUpdateVisitedHistory(webview, s, flag);
        mWebViewContainer.doUpdateVisitedHistory(true);
    }

    public boolean handleAuthentication(WebView webview, String s)
    {
        if (isAuthenticationRedirect(webview, s) && (webview.getContext() instanceof AmazonActivity))
        {
            final AmazonActivity amazonActivity = (AmazonActivity)webview.getContext();
            amazonActivity.authenticateUser(new com.amazon.mShop.model.auth.UserSubscriber.Callback() {

                final MShopWebViewClient this$0;
                final AmazonActivity val$amazonActivity;
                final String val$urlAfterSuccessfulLogin;
                final WebView val$webView;

                public void userCancelledSignIn()
                {
                    amazonActivity.popView();
                }

                public void userSuccessfullySignedIn()
                {
                    if (!Util.isEmpty(urlAfterSuccessfulLogin))
                    {
                        webView.clearView();
                        webView.loadUrl(urlAfterSuccessfulLogin);
                    }
                }

            
            {
                this$0 = MShopWebViewClient.this;
                amazonActivity = amazonactivity;
                urlAfterSuccessfulLogin = s;
                webView = webview;
                super();
            }
            }, null);
            return true;
        } else
        {
            return false;
        }
    }

    protected boolean handlePageLoadNatively(MASHWebView mashwebview, String s)
    {
        boolean flag = super.handlePageLoadNatively(mashwebview, s);
        mIsAlreadyPageLoadHandled = true;
        mWebViewContainer.setIsPageLoadHandledNatively(flag);
        return flag;
    }

    protected boolean isAuthenticationRedirect(WebView webview, String s)
    {
        boolean flag1 = false;
        boolean flag;
        if (DEBUG)
        {
            flag = AUTH_PORTAL_SERVER.matcher(s).find();
        } else
        {
            webview = webview.getContext().getString(com.amazon.mShop.android.lib.R.string.authportal);
            flag = flag1;
            if (s.length() > webview.length())
            {
                flag = flag1;
                if (webview.equals(s.subSequence(0, webview.length())))
                {
                    return true;
                }
            }
        }
        return flag;
    }

    public void onFormResubmission(WebView webview, Message message, Message message1)
    {
        message1.sendToTarget();
    }

    public void onLoadResource(WebView webview, String s)
    {
        if (DEBUG)
        {
            Log.v("MShopWebViewClient", (new StringBuilder()).append("onLoadResource: url = ").append(s).toString());
        }
    }

    public void onPageFinished(WebView webview, String s)
    {
        if (DEBUG)
        {
            Log.i("MShopWebViewClient", (new StringBuilder()).append("onPageFinished: url = ").append(s).toString());
        }
        super.onPageFinished(webview, s);
        if (mProgressDialog != null)
        {
            try
            {
                mProgressDialog.dismiss();
            }
            catch (Exception exception)
            {
                Log.e("MShopWebViewClient", exception.getMessage());
            }
        }
        mPendingUrl = null;
        mNeedHandleSignIn = true;
        webview = (MShopWebView)webview;
        if (!Util.isEmpty(webview.getJsNeedToCall(s)))
        {
            String s1 = webview.getJsNeedToCall(s);
            webview.loadUrl(s1);
            webview.clearAllPendingJs();
            if (DEBUG)
            {
                Log.i("MShopWebViewClient", (new StringBuilder()).append("onPageFinished: call js = ").append(s1).toString());
            }
        }
        mWebViewContainer.onPageFinished(s);
        mIsAlreadyPageLoadHandled = false;
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        if (DEBUG)
        {
            Log.i("MShopWebViewClient", (new StringBuilder()).append("onPageStarted: url = ").append(s).toString());
        }
        super.onPageStarted(webview, s, bitmap);
        CookieManager.getInstance().setAcceptCookie(true);
        bitmap = Uri.parse(s);
        MShopWebView mshopwebview;
        boolean flag;
        if (mPendingUrl == null)
        {
            mPendingUrl = s;
        } else
        if (mNeedHandleSignIn && handleAuthentication(webview, s))
        {
            mNeedHandleSignIn = false;
            webview.stopLoading();
            if (mProgressDialog != null && mProgressDialog.isShowing())
            {
                mProgressDialog.dismiss();
            }
            mPendingUrl = null;
            return;
        }
        mshopwebview = (MShopWebView)webview;
        flag = false;
        if (!mIsAlreadyPageLoadHandled && !mshopwebview.isInitialPageLoad())
        {
            flag = handlePageLoadNatively((MShopWebView)webview, s);
        } else
        {
            mshopwebview.setInitialPageLoad(false);
        }
        if (flag)
        {
            webview.stopLoading();
            return;
        }
        flag = WebViewSecurity.shouldBlockWebViewLoading(webview, s);
        if (WebViewSecurity.isHTTPUrl(s))
        {
            WebViewSecurity.logMetricsForHTTPRequest(webview.getUrl(), s, flag);
        }
        if (flag)
        {
            webview.stopLoading();
            mWebViewContainer.showSslError(5);
            return;
        }
        if (bitmap != null && bitmap.isHierarchical())
        {
            bitmap = Uri.decode(bitmap.getQueryParameter("app-loading-dialog-title"));
            if (!Util.isEmpty(bitmap))
            {
                if (mProgressDialog == null)
                {
                    mProgressDialog = new AmazonProgressDialog(webview.getContext());
                }
                mProgressDialog.setTitle(webview.getContext().getString(com.amazon.mShop.android.lib.R.string.sns_loading_dialog_title, new Object[] {
                    bitmap
                }));
                mProgressDialog.show();
            }
        }
        mWebViewContainer.onPageStarted(s);
        logViewHistoryInUDP(webview, s);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        MShopWebView mshopwebview = (MShopWebView)webview;
        mshopwebview.setInitialPageLoad(true);
        mshopwebview.setReceivedError(true);
        webview.clearView();
        webview.setVisibility(8);
        mWebViewContainer.showError();
        AmazonErrorUtils.postWebViewError(i, s, s1);
        if (DEBUG)
        {
            Log.i("MShopWebViewClient", (new StringBuilder()).append("onReceivedError: errorCode = ").append(i).append(", description = ").append(s).toString());
        }
    }

    public void onReceivedHttpAuthRequest(WebView webview, HttpAuthHandler httpauthhandler, String s, String s1)
    {
        if (DEBUG)
        {
            String as[] = webview.getHttpAuthUsernamePassword(s, s1);
            if (httpauthhandler.useHttpAuthUsernamePassword() && as != null && as.length == 2)
            {
                httpauthhandler.proceed(as[0], as[1]);
                return;
            } else
            {
                DebugUtil.handleOnReceivedHTTPAuthenticationRequest((Activity)webview.getContext(), webview, httpauthhandler, s, s1);
                return;
            }
        } else
        {
            super.onReceivedHttpAuthRequest(webview, httpauthhandler, s, s1);
            return;
        }
    }

    public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        if (DEBUG)
        {
            Log.i("MShopWebViewClient", (new StringBuilder()).append("onReceivedSslError: ").append(sslerror).toString());
            sslerrorhandler.proceed();
            return;
        }
        ((MShopWebView)webview).setReceivedError(true);
        sslerrorhandler.cancel();
        mWebViewContainer.showSslError(3);
        if (sslerror != null)
        {
            AmazonErrorUtils.postWebViewError(sslerror.getPrimaryError(), (new StringBuilder()).append(sslerror.getClass().getSimpleName()).append("  ").append(sslerror.toString()).toString(), webview.getUrl());
        }
        webview.setVisibility(8);
        RefMarkerObserver.logRefMarker("ssl_error_html");
    }

    void setWebViewContainer(MShopWebViewContainer mshopwebviewcontainer)
    {
        mWebViewContainer = mshopwebviewcontainer;
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (DEBUG)
        {
            Log.i("MShopWebViewClient", (new StringBuilder()).append("shouldOverrideUrl: url = ").append(s).toString());
        }
        if (webview.getContext() instanceof MShopWebActivity)
        {
            ((MShopWebActivity)webview.getContext()).calcWebviewStartTime();
        }
        String s1 = Uri.parse(s).getPath();
        if (s1 != null && s1.contains("404.html"))
        {
            UIUtils.alert(webview.getContext(), com.amazon.mShop.android.lib.R.string.alert_error_service_please_try_again);
            return true;
        }
        if (mNeedHandleSignIn && handleAuthentication(webview, s))
        {
            mNeedHandleSignIn = false;
            return true;
        }
        if (WebUtils.handleMailtoLink(webview.getContext(), s))
        {
            return true;
        }
        if (super.shouldOverrideUrlLoading(webview, s))
        {
            return true;
        }
        if (handleURLProtocolUnsupportedScheme(webview.getContext(), s))
        {
            return true;
        }
        if (WebViewSecurity.shouldBlockWebViewLoading(webview, s))
        {
            mWebViewContainer.showSslError(5);
            WebViewSecurity.logMetricsForHTTPRequest(webview.getUrl(), s, true);
            return true;
        } else
        {
            mWebViewContainer.navigateForward(s);
            return false;
        }
    }

}
