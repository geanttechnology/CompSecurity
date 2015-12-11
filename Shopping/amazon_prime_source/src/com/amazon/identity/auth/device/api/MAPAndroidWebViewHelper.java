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
import com.amazon.identity.auth.device.token.TokenCallbackHelpers;
import com.amazon.identity.auth.device.utils.AmazonDomainHelper;
import com.amazon.identity.auth.device.utils.CollectionUtils;
import com.amazon.identity.auth.device.utils.MAPAndroidWebviewSharedPrefCookieUtils;
import com.amazon.identity.auth.device.utils.MAPArgContracts;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import com.amazon.identity.auth.device.utils.WebViewUtils;
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
    private final MAPAccountManager mMAPAccountManager;
    private Parameters mParams;
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

    private Callback getAuthActivityCallback(final WebView webView, final String url)
    {
        return new Callback() {

            final MAPAndroidWebViewHelper this$0;
            final String val$url;
            final WebView val$webView;

            public void onError(Bundle bundle)
            {
                MAPAndroidWebViewHelper.access$800(MAPAndroidWebViewHelper.this, webView, bundle, url);
            }

            public void onSuccess(Bundle bundle)
            {
                handleAuthResultSuccess(webView, bundle, url);
            }

            
            {
                this$0 = MAPAndroidWebViewHelper.this;
                webView = webview;
                url = s;
                super();
            }
        };
    }

    private void getCookiesFromTokenManagement(final WebView webView, boolean flag, final String directedId, final String domain, String s, final Callback callback)
    {
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.amazon.identity.auth.device.api.cookiekeys.options.forcerefresh", flag);
        bundle.putString("domain", domain);
        bundle.putSerializable("cookietype", com.amazon.identity.auth.accounts.AccountManagerConstants.GetCookiesParams.COOKIE_TYPE.COOKIE);
        bundle.putString("user_agent", mParams.userAgent);
        bundle.putString("com.amazon.identity.auth.device.api.cookiekeys.options.SignInUrl", s);
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
                if (as.length != 0)
                {
                    addCookieNamesToSharedPrefs(as, domain, directedId);
                }
                String s1 = bundle1.getString("com.amazon.identity.auth.device.api.cookiekeys.ResponseUrl");
                MAPAndroidWebViewHelper.access$600(MAPAndroidWebViewHelper.this, webView, s1);
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

    private void handleAuthResultSuccess(WebView webview, Bundle bundle, String s)
    {
        onEvent("ON_REGISTRATION_SUCCESS", bundle);
        MAPLog.i(LOG_TAG, "Registration successful. Starting get cookies.");
        getCookiesFromTokenManagement(webview, false, bundle.getString("com.amazon.dcp.sso.property.account.acctId"), mParams.domain, s, new Callback() {

            final MAPAndroidWebViewHelper this$0;

            public void onError(Bundle bundle1)
            {
                onEvent("ON_UNABLE_TO_GET_COOKIES", bundle1);
            }

            public void onSuccess(Bundle bundle1)
            {
                MAPLog.i(MAPAndroidWebViewHelper.LOG_TAG, "Successfully registered account, set cookies in WebView, and loaded return_to url");
            }

            
            {
                this$0 = MAPAndroidWebViewHelper.this;
                super();
            }
        });
    }

    public static final boolean isInterceptableUrl(String s)
    {
        return !TextUtils.isEmpty(s) && s.contains("/ap/signin");
    }

    private static void loadUrlInWebView(WebView webview, String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            ThreadUtils.runOnMainThread(new Runnable(webview, s) {

                final String val$url;
                final WebView val$webView;

                public void run()
                {
                    webView.loadUrl(url);
                }

            
            {
                webView = webview;
                url = s;
                super();
            }
            });
        }
    }

    private void startRegistration(Activity activity, Callback callback)
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
            mMAPAccountManager.registerAccountWithUI(activity, SigninOption.WebviewSignin, bundle, callback);
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

    public final boolean handleAuthentication(final WebView webView, final String url)
    {
        final Object directedId;
        if (!isInterceptableUrl(url))
        {
            return false;
        }
        directedId = webView.getSettings().getUserAgentString();
        Object obj = getParamsFromUrlString(url);
        if (!CollectionUtils.isEmpty(((java.util.Collection) (obj)))) goto _L2; else goto _L1
_L1:
        boolean flag1 = false;
          goto _L3
_L2:
        Object obj1 = ((List) (obj)).iterator();
_L7:
        if (!((Iterator) (obj1)).hasNext()) goto _L5; else goto _L4
_L4:
        Object obj2 = (NameValuePair)((Iterator) (obj1)).next();
        if (!TextUtils.equals("intercept", ((NameValuePair) (obj2)).getName())) goto _L7; else goto _L6
_L6:
        flag1 = Boolean.parseBoolean(((NameValuePair) (obj2)).getValue());
          goto _L3
_L21:
        mParams = new Parameters((byte)0);
        obj = ((List) (obj)).iterator();
_L10:
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_433;
            }
            obj2 = (NameValuePair)((Iterator) (obj)).next();
            obj1 = ((NameValuePair) (obj2)).getName();
            obj2 = ((NameValuePair) (obj2)).getValue();
        } while (TextUtils.isEmpty(((CharSequence) (obj1))) || TextUtils.isEmpty(((CharSequence) (obj2))));
        obj1 = ((String) (obj1)).trim();
        obj2 = ((String) (obj2)).trim();
        if (!((String) (obj1)).equalsIgnoreCase("openid.return_to")) goto _L9; else goto _L8
_L8:
        if (TextUtils.isEmpty(((CharSequence) (obj2))))
        {
            MAPLog.e(LOG_TAG, "No Return to url in the main url");
            throw new InvalidParameterException("No Return to url in the main url");
        }
        try
        {
            mParams.returnToURL = ((String) (obj2));
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
          goto _L10
_L9:
label0:
        {
            if (!((String) (obj1)).equalsIgnoreCase("openid.assoc_handle"))
            {
                break label0;
            }
            mParams.associationHandle = ((String) (obj2));
        }
          goto _L10
label1:
        {
            if (!((String) (obj1)).equalsIgnoreCase("pageId"))
            {
                break label1;
            }
            mParams.pageId = ((String) (obj2));
        }
          goto _L10
label2:
        {
            if (!((String) (obj1)).equalsIgnoreCase("clientContext"))
            {
                break label2;
            }
            mParams.clientContext = ((String) (obj2));
        }
          goto _L10
        if (!((String) (obj1)).equalsIgnoreCase("openid.claimed_id")) goto _L12; else goto _L11
_L11:
        mParams.claimedId = ((String) (obj2));
          goto _L10
_L12:
        if (!((String) (obj1)).equalsIgnoreCase("openid.identity")) goto _L10; else goto _L13
_L13:
        mParams.identity = ((String) (obj2));
          goto _L10
        obj = AmazonDomainHelper.getDomainWithoutWWW((new URL(url)).getHost());
        mParams.domain = ((String) (obj));
        mParams.userAgent = ((String) (directedId));
        obj = mParams;
        if (TextUtils.isEmpty(mParams.claimedId) || TextUtils.isEmpty(mParams.identity) || !mParams.claimedId.equals(mParams.identity))
        {
            break MISSING_BLOCK_LABEL_839;
        }
          goto _L14
_L18:
        boolean flag;
        if (!flag) goto _L16; else goto _L15
_L15:
        MAPLog.i(LOG_TAG, "URL type set to confirm credential");
        directedId = URL_TYPE.CONFIRM_CREDENTIAL;
_L19:
        obj.requestType = ((URL_TYPE) (directedId)).toString();
          goto _L17
_L14:
        if (mParams.claimedId.equals("http://www.amazon.com/ap/specs/auth/confirm_credentials") || mParams.claimedId.contains("/ap/id/"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L18
_L16:
        directedId = URL_TYPE.SIGNIN;
          goto _L19
_L17:
        webView.stopLoading();
        (new StringBuilder("Authentication URL seen:")).append(mParams.requestType);
        directedId = getAccount();
        if (mSharedPrefCookieUtils.needsToCleanupCookiesInSharedPrefsAndCookieJar(((String) (directedId))))
        {
            mSharedPrefCookieUtils.cleanUpKnownCookies();
        }
        if (TextUtils.equals(mParams.requestType, com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.CONFIRM_CREDENTIAL.toString()))
        {
            Activity activity1 = mActivity;
            webView = getAuthActivityCallback(webView, url);
            url = new Bundle();
            url.putString("com.amazon.identity.ap.assoc_handle", mParams.associationHandle);
            url.putString("com.amazon.identity.ap.pageid", mParams.pageId);
            url.putString("com.amazon.identity.ap.clientContext", mParams.clientContext);
            url.putString("com.amazon.identity.ap.domain", mParams.domain);
            url.putAll(getOptions());
            url.putString("com.amazon.dcp.sso.property.account.acctId", ((String) (directedId)));
            mMAPAccountManager.authenticateAccountWithUI(activity1, SigninOption.WebviewConfirmCredentials, url, webView);
            return true;
        }
        if (TextUtils.isEmpty(((CharSequence) (directedId))))
        {
            startRegistration(mActivity, getAuthActivityCallback(webView, url));
            return true;
        } else
        {
            final Activity activity = mActivity;
            getCookiesFromTokenManagement(webView, true, ((String) (directedId)), mParams.domain, url, new Callback() {

                final MAPAndroidWebViewHelper this$0;
                final Activity val$activity;
                final String val$directedId;
                final String val$url;
                final WebView val$webView;

                public void onError(Bundle bundle)
                {
                    String _tmp = MAPAndroidWebViewHelper.LOG_TAG;
                    (new StringBuilder("getCookies call failed with error ")).append(bundle.getString("com.amazon.dcp.sso.ErrorMessage"));
                    if (!mMAPAccountManager.isAccountRegistered(directedId))
                    {
                        String _tmp1 = MAPAndroidWebViewHelper.LOG_TAG;
                        (new StringBuilder("account ")).append(directedId).append(" is not registered");
                        startRegistration(activity, getAuthActivityCallback(webView, url));
                        return;
                    } else
                    {
                        onEvent("ON_UNABLE_TO_GET_COOKIES", bundle);
                        return;
                    }
                }

                public void onSuccess(Bundle bundle)
                {
                    MAPLog.i(MAPAndroidWebViewHelper.LOG_TAG, "Sign in skipped successfully. Loaded next URL in WebView.");
                }

            
            {
                this$0 = MAPAndroidWebViewHelper.this;
                directedId = s;
                activity = activity1;
                webView = webview;
                url = s1;
                super();
            }
            });
            return true;
        }
          goto _L18
_L3:
        if (flag1) goto _L21; else goto _L20
_L20:
        return false;
_L5:
        flag1 = true;
          goto _L3
          goto _L21
        flag = false;
          goto _L18
    }

    protected void handleSSLError(SslError sslerror)
    {
        onEvent("ON_UNABLE_TO_GET_COOKIES", TokenCallbackHelpers.getErrorBundle(MAPAccountManager.RegistrationError.NETWORK_FAILURE.value(), (new StringBuilder("SSL error: ")).append(sslerror.toString()).toString()));
    }

    public void onEvent(String s, Bundle bundle)
    {
        (new StringBuilder("Event response received: ")).append(s).append(" Result: ").append(bundle.toString());
    }







/*
    static void access$500(MAPAndroidWebViewHelper mapandroidwebviewhelper, String as[], String s, String s1)
    {
        mapandroidwebviewhelper.mSharedPrefCookieUtils.addCookieNamesToSharedPrefs(s1, s, as);
        WebViewUtils.setCookies(mapandroidwebviewhelper.mActivity, s, as);
        return;
    }

*/


/*
    static void access$600(MAPAndroidWebViewHelper mapandroidwebviewhelper, WebView webview, String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            loadUrlInWebView(webview, s);
        } else
        if (!TextUtils.isEmpty(mapandroidwebviewhelper.mParams.returnToURL))
        {
            loadUrlInWebView(webview, mapandroidwebviewhelper.mParams.returnToURL);
            return;
        }
        return;
    }

*/



/*
    static void access$800(MAPAndroidWebViewHelper mapandroidwebviewhelper, WebView webview, Bundle bundle, String s)
    {
        if (bundle.getInt("com.amazon.dcp.sso.ErrorCode") == MAPAccountManager.RegistrationError.ACCOUNT_ALREADY_EXISTS.value())
        {
            mapandroidwebviewhelper.handleAuthResultSuccess(webview, bundle, s);
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
