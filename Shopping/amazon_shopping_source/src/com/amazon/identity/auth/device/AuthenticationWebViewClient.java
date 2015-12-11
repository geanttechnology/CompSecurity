// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.android.webkit.AmazonWebResourceResponse;
import com.amazon.android.webkit.AmazonWebView;
import com.amazon.identity.auth.accounts.AccountsCallbackHelpers;
import com.amazon.identity.auth.device.api.AbstractMAPWebViewClient;
import com.amazon.identity.auth.device.endpoint.OpenIdResponse;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.metrics.SSOMetrics;
import com.amazon.identity.auth.device.token.Token;
import com.amazon.identity.auth.device.utils.MAPArgContracts;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.platform.metric.MetricUtils;
import com.amazon.identity.platform.metric.MetricsHelper;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;
import java.net.MalformedURLException;
import java.net.URL;

public final class AuthenticationWebViewClient extends AbstractMAPWebViewClient
{
    public static interface AuthenticationWebViewClientCallback
    {

        public abstract void onCodeEnterFinished();

        public abstract void onPageFinished();

        public abstract void onPageStarted(String s);

        public abstract void setError(Bundle bundle);

        public abstract void setResult(OpenIdResponse openidresponse);
    }


    private static final String LOG_TAG = com/amazon/identity/auth/device/AuthenticationWebViewClient.getName();
    private final AuthenticationWebViewClientCallback mCallback;
    private PlatformMetricsTimer mDcqPageRenderTimer;
    private final String mExpectedReturnToURL;
    private volatile boolean mIsDCQ;
    private volatile boolean mIsMFA;
    private PlatformMetricsTimer mMfaPageRenderTimer;
    public boolean mRedirected;
    private final com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE mRequestType;
    private final com.amazon.identity.auth.device.endpoint.OpenIdRequest.TOKEN_SCOPE mScope;
    private PlatformMetricsTimer mSignInRegisterFormSubmitTimer;
    private final Tracer mTracer;

    public AuthenticationWebViewClient(com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE request_type, String s, com.amazon.identity.auth.device.endpoint.OpenIdRequest.TOKEN_SCOPE token_scope, AuthenticationWebViewClientCallback authenticationwebviewclientcallback, Tracer tracer)
    {
        mRedirected = false;
        mSignInRegisterFormSubmitTimer = null;
        mIsMFA = false;
        mIsDCQ = false;
        MAPArgContracts.throwIfNull(authenticationwebviewclientcallback, "callback");
        mExpectedReturnToURL = s;
        mCallback = authenticationwebviewclientcallback;
        mScope = token_scope;
        mRequestType = request_type;
        mTracer = tracer;
    }

    public static boolean isMAPUrl(String s)
    {
        if (s == null)
        {
            MAPLog.i(LOG_TAG, "URL is null");
        } else
        {
            URL url;
            try
            {
                url = new URL(s);
            }
            catch (MalformedURLException malformedurlexception)
            {
                String s1 = LOG_TAG;
                (new StringBuilder("MalformedURLException url=")).append(s).toString();
                return false;
            }
            s = url.getProtocol();
            if (!TextUtils.isEmpty(s) && s.contains("http"))
            {
                s = url.getHost();
                if (!TextUtils.isEmpty(s) && s.contains(".amazon."))
                {
                    s = url.getPath();
                    boolean flag = TextUtils.isEmpty(s);
                    boolean flag1 = s.startsWith("/ap/");
                    boolean flag2 = s.startsWith("/gp/yourstore/home");
                    boolean flag3 = s.equals("/ap/forgotpassword");
                    s = LOG_TAG;
                    (new StringBuilder(" isEmpty=")).append(flag).append("startsWithAP=").append(flag1).append("equalsGP=").append(flag2).append("equalsForgotPassword=").append(flag3).toString();
                    if (!flag && (flag1 && !flag3 || flag2))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
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

    public void onPageFinished(AmazonWebView amazonwebview, String s)
    {
        String s1 = LOG_TAG;
        super.onPageFinished(amazonwebview, s);
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

    public void onPageStarted(AmazonWebView amazonwebview, String s, Bitmap bitmap)
    {
        bitmap = LOG_TAG;
        (new StringBuilder("On Page Started with scope =")).append(mScope).toString();
        if (!s.startsWith(mExpectedReturnToURL))
        {
            if (isSignInOrRegisterPost(s) && (mIsMFA || mIsDCQ))
            {
                mCallback.onCodeEnterFinished();
            }
            if (s.contains("ap/dcq"))
            {
                mTracer.incrementCounter((new StringBuilder("WebView:ContactedDCQ:")).append(mRequestType.name()).toString());
                mDcqPageRenderTimer = mTracer.startTimer("DCQ:PageRender");
                mIsDCQ = true;
                mIsMFA = false;
            } else
            if (s.contains("ap/mfa"))
            {
                mTracer.incrementCounter((new StringBuilder("WebView:ContactedMFA:")).append(mRequestType.name()).toString());
                mMfaPageRenderTimer = mTracer.startTimer("MFA:PageRender");
                mIsMFA = true;
                mIsDCQ = false;
            } else
            {
                mIsMFA = false;
                mIsDCQ = false;
            }
            mCallback.onPageStarted(s);
        } else
        {
            mCallback.onPageStarted(s);
            mRedirected = true;
            bitmap = LOG_TAG;
            amazonwebview.stopLoading();
            amazonwebview = new OpenIdResponse(s);
            if (amazonwebview.isCancelEvent(mExpectedReturnToURL))
            {
                mCallback.setError(AccountsCallbackHelpers.getAccountManagerErrorBundle(4, "Registration canceled"));
                if (mIsDCQ)
                {
                    mTracer.incrementCounter("DCQCanceled");
                }
                if (mIsMFA)
                {
                    mTracer.incrementCounter("MFACanceled");
                    return;
                }
            } else
            {
                bitmap = LOG_TAG;
                if (!"device_auth_access".equalsIgnoreCase(amazonwebview.getScope()))
                {
                    MetricsHelper.increasePeriodicCounter((new StringBuilder("WebViewFailure:InvalidScope:")).append(mRequestType.name()).append(":").append(MetricUtils.getAuthPortalUrlPathAndDomain(s)).toString(), new String[0]);
                    mCallback.setError(AccountsCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.PARSE_ERROR.value(), String.format("Received token with invalid scope %s", new Object[] {
                        amazonwebview.getScope()
                    })));
                    return;
                }
                bitmap = amazonwebview.getAccessToken();
                if (bitmap == null || TextUtils.isEmpty(bitmap.toString()))
                {
                    MetricsHelper.increasePeriodicCounter((new StringBuilder("WebViewFailure:NoAccessToken:")).append(mRequestType.name()).append(":").append(MetricUtils.getAuthPortalUrlPathAndDomain(s)).toString(), new String[0]);
                    mCallback.setError(AccountsCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.REGISTER_FAILED.value(), "Received an invalid access token"));
                    return;
                }
                if (TextUtils.isEmpty(amazonwebview.getDirectedId()))
                {
                    MetricsHelper.increasePeriodicCounter((new StringBuilder("WebViewFailure:NoDirectedID:")).append(mRequestType.name()).append(":").append(MetricUtils.getAuthPortalUrlPathAndDomain(s)).toString(), new String[0]);
                    mCallback.setError(AccountsCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.REGISTER_FAILED.value(), "Registration response received invalid because it did not contain a directed id"));
                    return;
                } else
                {
                    mCallback.setResult(amazonwebview);
                    return;
                }
            }
        }
    }

    public void onReceivedError(AmazonWebView amazonwebview, int i, String s, String s1)
    {
        MAPLog.e(LOG_TAG, (new StringBuilder("Got an error from the webview. Returning false for SignIn (")).append(i).append(") ").append(s).toString());
        SSOMetrics.recordWebViewLoadFailure(s1, i);
        mCallback.setError(AccountsCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.NETWORK_FAILURE.value(), String.format("Received error code %d and description: %s", new Object[] {
            Integer.valueOf(i), s
        })));
    }

    public AmazonWebResourceResponse shouldInterceptRequest(AmazonWebView amazonwebview, String s)
    {
        if (isSignInOrRegisterPost(s) && mSignInRegisterFormSubmitTimer == null)
        {
            mSignInRegisterFormSubmitTimer = mTracer.startTimer((new StringBuilder("AuthenticationWebViewClient_SignInRegisterPost:")).append(mRequestType.name()).toString());
        }
        return super.shouldInterceptRequest(amazonwebview, s);
    }

    public boolean shouldOverrideUrlLoading(AmazonWebView amazonwebview, String s)
    {
        if (isMAPUrl(s))
        {
            amazonwebview = LOG_TAG;
            (new StringBuilder("should override called - no override - url=")).append(s).toString();
            return false;
        } else
        {
            String s1 = LOG_TAG;
            (new StringBuilder("should override called - override - url=")).append(s).toString();
            s = new Intent("android.intent.action.VIEW", Uri.parse(s));
            amazonwebview.getContext().startActivity(s);
            return true;
        }
    }

}
