// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.app.Activity;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.amazon.identity.auth.device.WebViewUtils;
import com.amazon.identity.auth.device.token.TokenCallbackHelpers;
import com.amazon.identity.auth.device.utils.AmazonDomainHelper;
import com.amazon.identity.auth.device.utils.MAPAndroidWebviewSharedPrefCookieUtils;
import com.amazon.identity.auth.device.utils.MAPArgContracts;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            MAPAccountManager, TokenManagement, SigninOption, Callback

public class MAPAndroidWebViewHelper
{
    private class Parameters
    {

        public String associationHandle;
        public String claimedId;
        public String clientContext;
        public String domain;
        public String identity;
        public String pageId;
        public String requestType;
        public String returnToURL;
        public String userAgent;

        private Parameters()
        {
        }

        Parameters(byte byte0)
        {
            this();
        }
    }

    private class _cls4
        implements Runnable
    {

        final MAPAndroidWebViewHelper this$0;
        final WebView val$webView;

        public void run()
        {
            webView.loadUrl(mParams.returnToURL);
        }

        _cls4()
        {
            this$0 = MAPAndroidWebViewHelper.this;
            webView = webview;
            super();
        }
    }

    private static final class URL_TYPE extends Enum
    {

        private static final URL_TYPE $VALUES[];
        public static final URL_TYPE CONFIRM_CREDENTIAL;
        public static final URL_TYPE REGULAR;
        public static final URL_TYPE SIGNIN;

        public static URL_TYPE valueOf(String s)
        {
            return (URL_TYPE)Enum.valueOf(com/amazon/identity/auth/device/api/MAPAndroidWebViewHelper$URL_TYPE, s);
        }

        public static URL_TYPE[] values()
        {
            return (URL_TYPE[])$VALUES.clone();
        }

        static 
        {
            REGULAR = new URL_TYPE("REGULAR", 0);
            SIGNIN = new URL_TYPE("SIGNIN", 1);
            CONFIRM_CREDENTIAL = new URL_TYPE("CONFIRM_CREDENTIAL", 2);
            $VALUES = (new URL_TYPE[] {
                REGULAR, SIGNIN, CONFIRM_CREDENTIAL
            });
        }

        private URL_TYPE(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String LOG_TAG = com/amazon/identity/auth/device/api/MAPAndroidWebViewHelper.getName();
    public static final String ON_REGISTRATION_SUCCESS = "ON_REGISTRATION_SUCCESS";
    public static final String ON_UNABLE_TO_GET_COOKIES = "ON_UNABLE_TO_GET_COOKIES";
    private final Activity mActivity;
    private Callback mAuthCallback;
    private final MAPAccountManager mMAPAccountManager;
    private Parameters mParams;
    private boolean mParseUrl;
    private final MAPAndroidWebviewSharedPrefCookieUtils mSharedPrefCookieUtils;
    private final TokenManagement mTokenManagement;

    public MAPAndroidWebViewHelper(Activity activity)
    {
        mParams = new Parameters((byte)0);
        MAPArgContracts.throwIfNull(activity, "Activity");
        mActivity = activity;
        mMAPAccountManager = new MAPAccountManager(mActivity);
        mTokenManagement = new TokenManagement(mActivity);
        mSharedPrefCookieUtils = new MAPAndroidWebviewSharedPrefCookieUtils(mActivity);
    }

    private static URI encodeToSafeUrl(String s)
        throws MalformedURLException
    {
        s = new URL(s);
        try
        {
            s = new URI(s.getProtocol(), s.getUserInfo(), s.getHost(), s.getPort(), s.getPath(), s.getQuery(), s.getRef());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new MalformedURLException("The url cannot be parsed!");
        }
        return s;
    }

    private void getCookiesFromTokenManagement(final WebView webView, boolean flag, final String directedId, final String domain, final Callback callback)
    {
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.amazon.identity.auth.device.api.cookiekeys.options.forcerefresh", flag);
        bundle.putString("domain", domain);
        bundle.putSerializable("cookietype", com.amazon.identity.auth.device.AccountManagerConstants.GetCookiesParams.COOKIE_TYPE.COOKIE);
        bundle.putString("user_agent", mParams.userAgent);
        String s = LOG_TAG;
        mTokenManagement.getCookies(directedId, domain, bundle, new Callback() {

            final MAPAndroidWebViewHelper this$0;
            final Callback val$callback;
            final String val$directedId;
            final String val$domain;
            final WebView val$webView;

            public void onError(Bundle bundle1)
            {
                callback.onError(bundle1);
            }

            public void onSuccess(Bundle bundle1)
            {
                String as[] = bundle1.getStringArray("com.amazon.identity.auth.device.api.cookiekeys.all");
                addCookieNamesToSharedPrefs(as, domain, directedId);
                MAPAndroidWebViewHelper.access$500(MAPAndroidWebViewHelper.this, webView);
                callback.onSuccess(bundle1);
            }

            
            {
                this$0 = MAPAndroidWebViewHelper.this;
                domain = s;
                directedId = s1;
                webView = webview;
                callback = callback1;
                super();
            }
        });
    }

    private List getParamsFromUrlString(String s)
        throws MalformedURLException
    {
        URI uri = URI.create(s);
        s = uri;
_L2:
        return URLEncodedUtils.parse(s, null);
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        s = encodeToSafeUrl(s);
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void handleAuthResultSuccess(WebView webview, final Bundle directedId)
    {
        onEvent("ON_REGISTRATION_SUCCESS", directedId);
        String s = LOG_TAG;
        directedId = directedId.getString("com.amazon.dcp.sso.property.account.acctId");
        getCookiesFromTokenManagement(webview, false, directedId, mParams.domain, new Callback() {

            final MAPAndroidWebViewHelper this$0;
            final String val$directedId;

            public void onError(Bundle bundle)
            {
                onEvent("ON_UNABLE_TO_GET_COOKIES", bundle);
            }

            public void onSuccess(Bundle bundle)
            {
                MAPLog.i(MAPAndroidWebViewHelper.LOG_TAG, (new StringBuilder("Cookies successfully set into webview for directed id: ")).append(directedId).toString());
            }

            
            {
                this$0 = MAPAndroidWebViewHelper.this;
                directedId = s;
                super();
            }
        });
    }

    public static final boolean isInterceptableUrl(String s)
    {
        return !TextUtils.isEmpty(s) && s.contains("/ap/signin");
    }

    private void startRegistration(Activity activity)
    {
        if (activity == null)
        {
            throw new InvalidParameterException("Activity object must not be null");
        } else
        {
            Bundle bundle = new Bundle();
            bundle.putString("com.amazon.identity.ap.assoc_handle", mParams.associationHandle);
            bundle.putString("com.amazon.identity.ap.pageid", mParams.pageId);
            bundle.putString("com.amazon.identity.ap.clientContext", mParams.clientContext);
            bundle.putString("com.amazon.identity.ap.domain", mParams.domain);
            bundle.putString("requestType", com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.SIGN_IN.toString());
            bundle.putAll(getOptions());
            mMAPAccountManager.registerAccountWithUI(activity, SigninOption.WebviewSignin, bundle, mAuthCallback);
            return;
        }
    }

    public String getAccount()
    {
        return mMAPAccountManager.getAccount();
    }

    public Bundle getOptions()
    {
        return new Bundle();
    }

    public final boolean handleAuthentication(final WebView webView, final String activity)
    {
        final String directedId;
        Object obj;
        String s3;
        Object obj2;
        boolean flag;
        boolean flag1;
        flag1 = false;
        directedId = getAccount();
        if (mSharedPrefCookieUtils.needsToCleanupCookiesInSharedPrefsAndCookieJar(directedId))
        {
            mSharedPrefCookieUtils.cleanUpKnownCookies();
        }
        if (!isInterceptableUrl(activity))
        {
            return false;
        }
        obj = webView.getSettings().getUserAgentString();
        Object obj1;
        try
        {
            obj1 = getParamsFromUrlString(activity);
        }
        // Misplaced declaration of an exception variable
        catch (final WebView webView)
        {
            onEvent("ON_UNABLE_TO_GET_COOKIES", TokenCallbackHelpers.getErrorBundle(MAPAccountManager.RegistrationError.BAD_REQUEST.value(), (new StringBuilder("Error occured while getting parameters from url.")).append(webView.getMessage()).toString()));
            return true;
        }
        // Misplaced declaration of an exception variable
        catch (final WebView webView)
        {
            onEvent("ON_UNABLE_TO_GET_COOKIES", TokenCallbackHelpers.getErrorBundle(MAPAccountManager.RegistrationError.BAD_REQUEST.value(), (new StringBuilder("URL is invalid.")).append(webView.getMessage()).toString()));
            return true;
        }
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        if (!((List) (obj1)).isEmpty()) goto _L3; else goto _L2
_L13:
        if (flag) goto _L5; else goto _L4
_L4:
        mParams = new Parameters((byte)0);
        obj1 = ((List) (obj1)).iterator();
_L9:
        if (!((Iterator) (obj1)).hasNext()) goto _L7; else goto _L6
_L6:
        obj2 = (NameValuePair)((Iterator) (obj1)).next();
        s3 = ((NameValuePair) (obj2)).getName();
        obj2 = ((NameValuePair) (obj2)).getValue();
        if (TextUtils.isEmpty(s3) || TextUtils.isEmpty(((CharSequence) (obj2)))) goto _L9; else goto _L8
_L8:
        s3 = s3.trim();
        obj2 = ((String) (obj2)).trim();
        if (!s3.equalsIgnoreCase("openid.return_to")) goto _L11; else goto _L10
_L10:
        if (TextUtils.isEmpty(((CharSequence) (obj2))))
        {
            MAPLog.e(LOG_TAG, "No Return to url in the main url");
            throw new InvalidParameterException("No Return to url in the main url");
        }
          goto _L12
_L3:
        flag = false;
          goto _L13
_L12:
        mParams.returnToURL = ((String) (obj2));
          goto _L9
_L11:
label0:
        {
            if (!mParseUrl || !s3.equalsIgnoreCase("openid.assoc_handle"))
            {
                break label0;
            }
            mParams.associationHandle = ((String) (obj2));
        }
          goto _L9
label1:
        {
            if (!mParseUrl || !s3.equalsIgnoreCase("pageId"))
            {
                break label1;
            }
            mParams.pageId = ((String) (obj2));
        }
          goto _L9
label2:
        {
            if (!mParseUrl || !s3.equalsIgnoreCase("clientContext"))
            {
                break label2;
            }
            mParams.clientContext = ((String) (obj2));
        }
          goto _L9
        if (!s3.equalsIgnoreCase("openid.claimed_id")) goto _L15; else goto _L14
_L14:
        mParams.claimedId = ((String) (obj2));
          goto _L9
_L15:
        if (!s3.equalsIgnoreCase("openid.identity")) goto _L9; else goto _L16
_L16:
        mParams.identity = ((String) (obj2));
          goto _L9
_L7:
        activity = AmazonDomainHelper.getDomainWithoutWWW((new URL(activity)).getHost());
        String s1 = LOG_TAG;
        (new StringBuilder("Domain used for parameters : ")).append(activity).toString();
        mParams.domain = activity;
        mParams.userAgent = ((String) (obj));
        obj = mParams;
        flag = flag1;
        if (TextUtils.isEmpty(mParams.claimedId)) goto _L18; else goto _L17
_L17:
        flag = flag1;
        if (TextUtils.isEmpty(mParams.identity)) goto _L18; else goto _L19
_L19:
        if (mParams.claimedId.equals(mParams.identity)) goto _L21; else goto _L20
_L20:
        flag = flag1;
_L18:
        if (!flag) goto _L23; else goto _L22
_L22:
        MAPLog.i(LOG_TAG, "URL type set to confirm credential");
        activity = URL_TYPE.CONFIRM_CREDENTIAL;
_L26:
        obj.requestType = activity.toString();
          goto _L24
_L21:
        if (mParams.claimedId.equals("http://www.amazon.com/ap/specs/auth/confirm_credentials"))
        {
            break MISSING_BLOCK_LABEL_859;
        }
        flag = flag1;
        if (!mParams.claimedId.contains("/ap/id/")) goto _L18; else goto _L25
_L25:
        break MISSING_BLOCK_LABEL_859;
_L23:
        activity = URL_TYPE.SIGNIN;
          goto _L26
_L5:
        return false;
_L24:
        mAuthCallback = new Callback() {

            final MAPAndroidWebViewHelper this$0;
            final WebView val$webView;

            public void onError(Bundle bundle)
            {
                MAPAndroidWebViewHelper.access$800(MAPAndroidWebViewHelper.this, webView, bundle);
            }

            public void onSuccess(Bundle bundle)
            {
                handleAuthResultSuccess(webView, bundle);
            }

            
            {
                this$0 = MAPAndroidWebViewHelper.this;
                webView = webview;
                super();
            }
        };
        webView.stopLoading();
        activity = LOG_TAG;
        (new StringBuilder("Authentication URL seen:")).append(mParams.requestType).toString();
        if (TextUtils.equals(mParams.requestType, com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.CONFIRM_CREDENTIAL.toString()))
        {
            webView = mActivity;
            activity = new Bundle();
            activity.putString("com.amazon.identity.ap.assoc_handle", mParams.associationHandle);
            activity.putString("com.amazon.identity.ap.pageid", mParams.pageId);
            activity.putString("com.amazon.identity.ap.clientContext", mParams.clientContext);
            activity.putString("com.amazon.identity.ap.domain", mParams.domain);
            activity.putAll(getOptions());
            activity.putString("com.amazon.dcp.sso.property.account.acctId", directedId);
            mMAPAccountManager.authenticateAccountWithUI(webView, SigninOption.WebviewConfirmCredentials, activity, mAuthCallback);
            return true;
        }
        if (TextUtils.isEmpty(directedId))
        {
            startRegistration(mActivity);
            return true;
        } else
        {
            activity = mActivity;
            String s = mParams.domain;
            String s2 = LOG_TAG;
            getCookiesFromTokenManagement(webView, true, directedId, s, new Callback() {

                final MAPAndroidWebViewHelper this$0;
                final Activity val$activity;
                final String val$directedId;

                public void onError(Bundle bundle)
                {
                    String _tmp = MAPAndroidWebViewHelper.LOG_TAG;
                    (new StringBuilder("getCookies call failed with error ")).append(bundle.getString("com.amazon.dcp.sso.ErrorMessage")).toString();
                    if (!mMAPAccountManager.isAccountRegistered(directedId))
                    {
                        String _tmp1 = MAPAndroidWebViewHelper.LOG_TAG;
                        (new StringBuilder("account ")).append(directedId).append(" is not registered").toString();
                        startRegistration(activity);
                        return;
                    } else
                    {
                        onEvent("ON_UNABLE_TO_GET_COOKIES", bundle);
                        return;
                    }
                }

                public void onSuccess(Bundle bundle)
                {
                    bundle = bundle.getStringArray("com.amazon.identity.auth.device.api.cookiekeys.all");
                    if (bundle == null || bundle.length == 0)
                    {
                        String _tmp = MAPAndroidWebViewHelper.LOG_TAG;
                        startRegistration(activity);
                    }
                }

            
            {
                this$0 = MAPAndroidWebViewHelper.this;
                activity = activity1;
                directedId = s;
                super();
            }
            });
            return true;
        }
_L2:
        flag = true;
          goto _L13
        flag = true;
          goto _L18
    }

    protected void handleSSLError(SslError sslerror)
    {
        onEvent("ON_UNABLE_TO_GET_COOKIES", TokenCallbackHelpers.getErrorBundle(MAPAccountManager.RegistrationError.NETWORK_FAILURE.value(), (new StringBuilder("SSL error: ")).append(sslerror.toString()).toString()));
    }

    public void onEvent(String s, Bundle bundle)
    {
        String s1 = LOG_TAG;
        (new StringBuilder("Event response received: ")).append(s).append(" Result: ").append(bundle.toString()).toString();
    }






/*
    static void access$400(MAPAndroidWebViewHelper mapandroidwebviewhelper, String as[], String s, String s1)
    {
        mapandroidwebviewhelper.mSharedPrefCookieUtils.addCookieNamesToSharedPrefs(s1, s, as);
        WebViewUtils.setCookies(mapandroidwebviewhelper.mActivity, s, as);
        return;
    }

*/


/*
    static void access$500(MAPAndroidWebViewHelper mapandroidwebviewhelper, final WebView webView)
    {
        if (mapandroidwebviewhelper.mParams.returnToURL != null)
        {
            String s = LOG_TAG;
            (new StringBuilder("Loading ReturnToUrl:")).append(mapandroidwebviewhelper.mParams.returnToURL).toString();
            ThreadUtils.runOnMainThread(mapandroidwebviewhelper. new _cls4());
        }
        return;
    }

*/




/*
    static void access$800(MAPAndroidWebViewHelper mapandroidwebviewhelper, WebView webview, Bundle bundle)
    {
        if (bundle.getInt("com.amazon.dcp.sso.ErrorCode") == MAPAccountManager.RegistrationError.ACCOUNT_ALREADY_EXISTS.value())
        {
            mapandroidwebviewhelper.handleAuthResultSuccess(webview, bundle);
            return;
        } else
        {
            MAPLog.e(LOG_TAG, "Error in handleAuthActivityResultError");
            mapandroidwebviewhelper.onEvent("ON_UNABLE_TO_GET_COOKIES", bundle);
            return;
        }
    }

*/
}
