// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.amazon.identity.auth.accounts.AccountsCallbackHelpers;
import com.amazon.identity.auth.device.endpoint.OpenIdResponse;
import com.amazon.identity.auth.device.metrics.SSOMetrics;
import com.amazon.identity.auth.device.token.Token;
import com.amazon.identity.auth.device.utils.MAPArgContracts;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.WebViewUtils;
import com.amazon.identity.platform.metric.MetricUtils;
import com.amazon.identity.platform.metric.MetricsHelper;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            MAPSmsReceiver, Tracer

public final class AuthenticationWebViewClient extends WebViewClient
{
    public static interface AuthenticationWebViewClientCallback
    {

        public abstract void onCodeEnterFinished();

        public abstract void onPageFinished();

        public abstract void onPageStarted(String s);

        public abstract void setError(Bundle bundle);

        public abstract void setResult(OpenIdResponse openidresponse);
    }


    private static final String LOG_TAG = com/amazon/identity/auth/device/framework/AuthenticationWebViewClient.getName();
    private final AuthenticationWebViewClientCallback mCallback;
    private final Context mContext;
    private PlatformMetricsTimer mDcqPageRenderTimer;
    private final String mExpectedReturnToURL;
    private volatile boolean mIsDCQ;
    private volatile boolean mIsMFA;
    private final MAPSmsReceiver mMAPSmsReceiver;
    private PlatformMetricsTimer mMfaPageRenderTimer;
    public boolean mRedirected;
    private final com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE mRequestType;
    private final com.amazon.identity.auth.device.endpoint.OpenIdRequest.TOKEN_SCOPE mScope;
    private final Set mSignInDomains;
    private PlatformMetricsTimer mSignInRegisterFormSubmitTimer;
    private final Tracer mTracer;

    public AuthenticationWebViewClient(Context context, MAPSmsReceiver mapsmsreceiver, com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE request_type, String s, com.amazon.identity.auth.device.endpoint.OpenIdRequest.TOKEN_SCOPE token_scope, Set set, AuthenticationWebViewClientCallback authenticationwebviewclientcallback, 
            Tracer tracer)
    {
        mRedirected = false;
        mSignInRegisterFormSubmitTimer = null;
        mIsMFA = false;
        mIsDCQ = false;
        MAPArgContracts.throwIfNull(authenticationwebviewclientcallback, "callback");
        mContext = context;
        mMAPSmsReceiver = mapsmsreceiver;
        mExpectedReturnToURL = s;
        mCallback = authenticationwebviewclientcallback;
        mScope = token_scope;
        mRequestType = request_type;
        mSignInDomains = set;
        mTracer = tracer;
    }

    public static boolean isAllowedSignInDomain(String s, Set set)
    {
        for (set = set.iterator(); set.hasNext();)
        {
            if (s.endsWith((String)set.next()))
            {
                return true;
            }
        }

        return false;
    }

    public static boolean isSessionExpiredUrl(URI uri)
    {
_L2:
        return false;
        if (uri == null || !TextUtils.equals(uri.getPath(), "/ap/register") && !TextUtils.equals(uri.getPath(), "/ap/register/")) goto _L2; else goto _L1
_L1:
        NameValuePair namevaluepair;
        try
        {
            uri = URLEncodedUtils.parse(uri, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (URI uri)
        {
            MAPLog.e(LOG_TAG, "Exception happened when checking whether it is session expired url", uri);
            return false;
        }
        if (uri == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        uri = uri.iterator();
        do
        {
            if (!uri.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            namevaluepair = (NameValuePair)uri.next();
        } while (!TextUtils.equals(namevaluepair.getName(), "alertCodes") || !TextUtils.equals(namevaluepair.getValue(), "SESSION_EXPIRED"));
        break; /* Loop/switch isn't completed */
        if (true) goto _L2; else goto _L3
_L3:
        MAPLog.i(LOG_TAG, "The session for phone verification url is expired.");
        return true;
    }

    private boolean isSignInOrRegisterPost(String s)
    {
        return (s.contains("ap/signin") || s.contains("ap/register")) && !s.contains("openid.assoc_handle");
    }

    public void handleSSLError(SslError sslerror)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            SSOMetrics.recordWebViewLoadFailureSSL(sslerror.getUrl(), sslerror.getPrimaryError());
        } else
        {
            SSOMetrics.recordWebViewLoadFailureSSL("CannotGetURL", sslerror.getPrimaryError());
        }
        mCallback.setError(AccountsCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.NETWORK_FAILURE.value(), String.format("SSL Failure. SSL Error code %d.", new Object[] {
            Integer.valueOf(sslerror.getPrimaryError())
        })));
    }

    public boolean isDCQ()
    {
        return mIsDCQ;
    }

    public boolean isMFA()
    {
        return mIsMFA;
    }

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        WebViewUtils.syncCookieSyncManager(mContext);
        if (mIsMFA && mMfaPageRenderTimer != null)
        {
            mMfaPageRenderTimer.stop();
        }
        if (mIsDCQ && mDcqPageRenderTimer != null)
        {
            mDcqPageRenderTimer.stop();
        }
        if (s.startsWith(mExpectedReturnToURL) || mRedirected)
        {
            if (mSignInRegisterFormSubmitTimer != null)
            {
                mSignInRegisterFormSubmitTimer.stop();
                mSignInRegisterFormSubmitTimer = null;
            }
            return;
        } else
        {
            mCallback.onPageFinished();
            return;
        }
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        (new StringBuilder("On Page Started with scope =")).append(mScope);
        if (!mMAPSmsReceiver.shouldRegisterMAPSmsReceiver(s, mContext))
        {
            mMAPSmsReceiver.unregisterMAPSmsReceiverIfRegistered(mContext);
        }
        bitmap = null;
        URI uri;
        try
        {
            uri = new URI(s);
        }
        catch (URISyntaxException urisyntaxexception)
        {
            MAPLog.e(LOG_TAG, "Exception while trying to parse url in onPageStarted. Continue with page load.", urisyntaxexception);
            continue; /* Loop/switch isn't completed */
        }
        bitmap = uri;
_L6:
        mCallback.onPageStarted(s);
        if (!isSessionExpiredUrl(bitmap)) goto _L2; else goto _L1
_L1:
        mMAPSmsReceiver.recordSessionExpired();
        mCallback.setError(AccountsCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST.value(), "The phone verification link already expired"));
_L4:
        return;
_L2:
        boolean flag;
        if (bitmap != null && bitmap.getQuery() == null && (TextUtils.equals("/gp/yourstore/home", bitmap.getPath()) || TextUtils.equals("/gp/yourstore/home/", bitmap.getPath())))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        mCallback.setError(AccountsCallbackHelpers.getAccountManagerErrorBundle(4, "Registration canceled"));
        if (mTracer != null)
        {
            if (mIsDCQ)
            {
                mTracer.incrementCounter("DCQCanceled");
            }
            if (mIsMFA)
            {
                mTracer.incrementCounter("MFACanceled");
                return;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        boolean flag1;
        if (bitmap != null && TextUtils.equals(bitmap.getPath(), "/ap/maplanding"))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag1)
        {
            if (isSignInOrRegisterPost(s) && (mIsMFA || mIsDCQ))
            {
                mCallback.onCodeEnterFinished();
            }
            if (s.contains("ap/dcq"))
            {
                if (mTracer != null)
                {
                    mTracer.incrementCounter((new StringBuilder("WebView:ContactedDCQ:")).append(mRequestType.name()).toString());
                    mDcqPageRenderTimer = mTracer.startTimer("DCQ:PageRender");
                }
                mIsDCQ = true;
                mIsMFA = false;
                return;
            }
            if (s.contains("ap/mfa"))
            {
                if (mTracer != null)
                {
                    mTracer.incrementCounter((new StringBuilder("WebView:ContactedMFA:")).append(mRequestType.name()).toString());
                    mMfaPageRenderTimer = mTracer.startTimer("MFA:PageRender");
                }
                mIsMFA = true;
                mIsDCQ = false;
                return;
            } else
            {
                mIsMFA = false;
                mIsDCQ = false;
                return;
            }
        }
        mRedirected = true;
        webview.stopLoading();
        webview = new OpenIdResponse(s);
        if (!"device_auth_access".equalsIgnoreCase(webview.getScope()))
        {
            MetricsHelper.incrementCounter((new StringBuilder("WebViewFailure:InvalidScope:")).append(mRequestType.name()).append(":").append(MetricUtils.getAuthPortalUrlPathAndDomain(s)).toString(), new String[0]);
            mCallback.setError(AccountsCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.PARSE_ERROR.value(), String.format("Received token with invalid scope %s", new Object[] {
                webview.getScope()
            })));
            return;
        }
        bitmap = webview.getAccessToken();
        if (bitmap == null || TextUtils.isEmpty(bitmap.toString()))
        {
            MetricsHelper.incrementCounter((new StringBuilder("WebViewFailure:NoAccessToken:")).append(mRequestType.name()).append(":").append(MetricUtils.getAuthPortalUrlPathAndDomain(s)).toString(), new String[0]);
            mCallback.setError(AccountsCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.REGISTER_FAILED.value(), "Received an invalid access token"));
            return;
        }
        if (TextUtils.isEmpty(webview.getDirectedId()))
        {
            MetricsHelper.incrementCounter((new StringBuilder("WebViewFailure:NoDirectedID:")).append(mRequestType.name()).append(":").append(MetricUtils.getAuthPortalUrlPathAndDomain(s)).toString(), new String[0]);
            mCallback.setError(AccountsCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.REGISTER_FAILED.value(), "Registration response received invalid because it did not contain a directed id"));
            return;
        }
        mCallback.setResult(webview);
        return;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        MAPLog.e(LOG_TAG, (new StringBuilder("Got an error from the webview. Returning false for SignIn (")).append(i).append(") ").append(s).toString());
        SSOMetrics.recordWebViewLoadFailure(s1, i);
        mCallback.setError(AccountsCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.NETWORK_FAILURE.value(), String.format("Received error code %d and description: %s", new Object[] {
            Integer.valueOf(i), s
        })));
    }

    public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        (new StringBuilder("Got an SSL error:")).append(sslerror.toString());
        if (android.os.Build.VERSION.SDK_INT < 8)
        {
            handleSSLError(sslerror);
            return;
        } else
        {
            super.onReceivedSslError(webview, sslerrorhandler, sslerror);
            return;
        }
    }

    public WebResourceResponse shouldInterceptRequest(WebView webview, String s)
    {
        if (isSignInOrRegisterPost(s) && mSignInRegisterFormSubmitTimer == null && mTracer != null)
        {
            mSignInRegisterFormSubmitTimer = mTracer.startTimer((new StringBuilder("AuthenticationWebViewClient_SignInRegisterPost:")).append(mRequestType.name()).toString());
        }
        return super.shouldInterceptRequest(webview, s);
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        MAPLog.e(LOG_TAG, "URL is null");
_L3:
        return false;
_L2:
        URL url = null;
        URL url1 = new URL(s);
        url = url1;
_L4:
        boolean flag;
        if (url == null)
        {
            break MISSING_BLOCK_LABEL_286;
        }
        Object obj = mSignInDomains;
        String s1 = url.getProtocol();
        if (TextUtils.isEmpty(s1) || !s1.contains("http"))
        {
            break MISSING_BLOCK_LABEL_280;
        }
        s1 = url.getHost();
        if (TextUtils.isEmpty(s1) || !isAllowedSignInDomain(s1, ((Set) (obj))))
        {
            break MISSING_BLOCK_LABEL_280;
        }
        obj = url.getPath();
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            break MISSING_BLOCK_LABEL_280;
        }
        boolean flag1 = ((String) (obj)).startsWith("/ap/");
        boolean flag2 = ((String) (obj)).startsWith("/ap/maplanding");
        boolean flag3 = ((String) (obj)).startsWith("/gp/yourstore/home");
        boolean flag4 = ((String) (obj)).equals("/ap/forgotpassword");
        (new StringBuilder("startsWithAP= equalsForgotPassword=")).append(flag4).append(flag1).append(" equalsReturnTo=").append(flag2).append(" equalsCancelButton=").append(flag3);
        if ((!flag1 || flag4) && !flag2 && !flag3)
        {
            break MISSING_BLOCK_LABEL_280;
        }
        flag = true;
_L5:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_286;
        }
        (new StringBuilder("should override called - opening in MAP webview - url=")).append(url);
        if (mMAPSmsReceiver.shouldRegisterMAPSmsReceiver(url, mContext))
        {
            mMAPSmsReceiver.registerMAPSmsReceiverIfUnregistered(mContext);
            return false;
        }
          goto _L3
        MalformedURLException malformedurlexception;
        malformedurlexception;
        (new StringBuilder("MalformedURLException url=")).append(null);
          goto _L4
        flag = false;
          goto _L5
        (new StringBuilder("should override called - opening in external browser - url=")).append(url);
        s = new Intent("android.intent.action.VIEW", Uri.parse(s));
        webview.getContext().startActivity(s);
        return true;
          goto _L4
    }

}
