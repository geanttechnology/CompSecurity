// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.android.webkit.AmazonCookieManager;
import com.amazon.android.webkit.AmazonWebSettings;
import com.amazon.android.webkit.AmazonWebView;
import com.amazon.identity.auth.device.token.TokenCallbackHelpers;
import com.amazon.identity.auth.device.utils.AmazonDomainHelper;
import com.amazon.identity.auth.device.utils.AmazonWebviewSharedPrefCookieUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            MAPInit, MAPAccountManager, TokenManagement, MAPWebViewEventHelper, 
//            AmazonWebViewUtils, SigninOption, MAPWebViewActivityInterface, Callback

public final class MAPWebViewHelper
{
    private class Parameters
    {

        public static final String KEY_ASSOCIATION_HANDLE = "association_handle";
        public static final String KEY_AUTH_COOKIES = "authCookies";
        public static final String KEY_CLAIMED_ID = "claimed_id";
        public static final String KEY_CLIENT_CONTEXT = "client_context";
        public static final String KEY_DOMAIN = "domain";
        public static final String KEY_IDENTITY = "identity";
        public static final String KEY_MAX_AUTH_AGE = "max_auth_age";
        public static final String KEY_PAGE_ID = "page_id";
        public static final String KEY_REQUEST_TYPE = "request_type";
        public static final String KEY_RETURN_TO_URL = "return_to_url";
        public static final String KEY_SITE_STATE = "site_state";
        public static final String KEY_URL = "url";
        public static final String KEY_USER_AGENT = "user_agent";
        public String associationHandle;
        public String authCookies;
        public String claimedId;
        public String clientContext;
        public String domain;
        public String identity;
        public String maxAuthAge;
        public String pageId;
        public String requestType;
        public String returnToURL;
        public String siteState;
        final MAPWebViewHelper this$0;
        public String url;
        public String userAgent;

        private Parameters()
        {
            this$0 = MAPWebViewHelper.this;
            super();
        }

        Parameters(byte byte0)
        {
            this();
        }
    }

    public static final class URL_TYPE extends Enum
    {

        private static final URL_TYPE $VALUES[];
        public static final URL_TYPE CONFIRM_CREDENTIAL;
        public static final URL_TYPE REGULAR;
        public static final URL_TYPE SIGNIN;

        public static URL_TYPE valueOf(String s)
        {
            return (URL_TYPE)Enum.valueOf(com/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE, s);
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


    public static final int AP_WEBVIEW_SIGNIN_ACTIVITY_REQUEST_CODE = 100;
    private static final String LOG_TAG = com/amazon/identity/auth/device/api/MAPWebViewHelper.getName();
    private final Callback mAuthCallback;
    private final Callback mClientEventCallback;
    private final Context mContext;
    private final Object mLock[] = new Object[0];
    private final MAPAccountManager mMAPAccountManager;
    private final AtomicBoolean mNeedForceRefreshCookies = new AtomicBoolean(false);
    private final Bundle mOptions;
    private Parameters mParams;
    private boolean mParseUrl;
    private final AmazonWebviewSharedPrefCookieUtils mSharedPrefCookieUtils;
    private final TokenManagement mTokenManagement;
    private final AmazonWebView mWebView;

    public MAPWebViewHelper(Context context, AmazonWebView amazonwebview, Callback callback, Callback callback1, Bundle bundle)
    {
        mParams = new Parameters((byte)0);
        MAPInit.getInstance(context).initialize();
        mContext = context;
        mParseUrl = false;
        context = bundle;
        if (bundle == null)
        {
            context = new Bundle();
        }
        mOptions = context;
        mMAPAccountManager = new MAPAccountManager(mContext);
        mTokenManagement = new TokenManagement(mContext);
        mSharedPrefCookieUtils = new AmazonWebviewSharedPrefCookieUtils(mContext);
        mWebView = amazonwebview;
        mClientEventCallback = callback;
        mAuthCallback = callback1;
    }

    private void continueLoadingURL()
    {
        if (mParams.returnToURL != null)
        {
            String s = LOG_TAG;
            (new StringBuilder("Loading ReturnToUrl:")).append(mParams.returnToURL).toString();
            ThreadUtils.runOnMainThread(new Runnable() {

                final MAPWebViewHelper this$0;

                public void run()
                {
                    mWebView.loadUrl(mParams.returnToURL);
                }

            
            {
                this$0 = MAPWebViewHelper.this;
                super();
            }
            });
        }
    }

    private URI encodeToSafeUrl(String s)
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

    public static String getCookieDomainFromUrl(String s)
        throws MalformedURLException
    {
        return AmazonDomainHelper.getDomainWithoutWWW((new URL(s)).getHost());
    }

    private void getCookiesFromTokenManagement(boolean flag, final Callback callback)
    {
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.amazon.identity.auth.device.api.cookiekeys.options.forcerefresh", flag);
        String s = mParams.domain;
        bundle.putString("domain", s);
        bundle.putSerializable("cookietype", com.amazon.identity.auth.device.AccountManagerConstants.GetCookiesParams.COOKIE_TYPE.COOKIE);
        bundle.putString("user_agent", mParams.userAgent);
        String s2 = LOG_TAG;
        if (s != null)
        {
            String s1 = mMAPAccountManager.getAccount();
            String s3;
            try
            {
                s3 = (new URL(mParams.url)).getHost();
            }
            catch (MalformedURLException malformedurlexception)
            {
                MAPWebViewEventHelper.setError(TokenCallbackHelpers.getErrorBundle(MAPAccountManager.RegistrationError.BAD_REQUEST.value(), "Domain is incorrect."), callback);
                return;
            }
            mTokenManagement.getCookies(s1, s3, bundle, new Callback() {

                final MAPWebViewHelper this$0;
                final Callback val$callback;

                public void onError(Bundle bundle1)
                {
                    callback.onError(bundle1);
                }

                public void onSuccess(Bundle bundle1)
                {
                    try
                    {
                        String as[] = bundle1.getStringArray("com.amazon.identity.auth.device.api.cookiekeys.all");
                        String s = _22_Unexpected_20_error_20_during_20_getCookie_20_call_22_;
                        continueLoadingURL();
                        callback.onSuccess(bundle1);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Bundle bundle1)
                    {
                        MAPLog.e(MAPWebViewHelper.LOG_TAG, "Unexpected error during getCookie call", bundle1);
                    }
                }

            
            {
                this$0 = MAPWebViewHelper.this;
                callback = callback1;
                super();
            }
            });
        }
    }

    private boolean isAuthenticationUrl(String s)
    {
        return !TextUtils.isEmpty(s) && s.contains("/ap/signin");
    }

    private void startAuthentication(Activity activity)
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
            bundle.putAll(mOptions);
            mMAPAccountManager.registerAccountWithUI(activity, SigninOption.WebviewSignin, bundle, mAuthCallback);
            return;
        }
    }

    public void checkAndCleanUpCookiesAroundRegistrationState()
    {
        if (!mSharedPrefCookieUtils.checkIfProcessKnowsSameRegistration())
        {
            mSharedPrefCookieUtils.cleanUpKnownCookies();
        }
    }

    public URL_TYPE getAuthenticationUrlType(String s)
    {
        if (!isAuthenticationUrl(s))
        {
            return URL_TYPE.REGULAR;
        }
        if (isConfirmCredentialRequest())
        {
            MAPLog.i(LOG_TAG, "URL type set to confirm credential");
            return URL_TYPE.CONFIRM_CREDENTIAL;
        } else
        {
            return URL_TYPE.SIGNIN;
        }
    }

    public String getHostFromUrl(String s)
        throws MalformedURLException
    {
        return (new URL(s)).getHost();
    }

    public void getParams(String s, String s1)
        throws InvalidParameterException, MalformedURLException
    {
        Object obj;
        try
        {
            obj = URI.create(s);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            illegalargumentexception = encodeToSafeUrl(s);
        }
        obj = URLEncodedUtils.parse(((URI) (obj)), null);
        mParams = new Parameters((byte)0);
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Object obj1 = (NameValuePair)((Iterator) (obj)).next();
            String s2 = ((NameValuePair) (obj1)).getName();
            obj1 = ((NameValuePair) (obj1)).getValue();
            if (!TextUtils.isEmpty(s2) && !TextUtils.isEmpty(((CharSequence) (obj1))))
            {
                s2 = s2.trim();
                obj1 = ((String) (obj1)).trim();
                if (s2.equalsIgnoreCase("openid.return_to"))
                {
                    if (TextUtils.isEmpty(((CharSequence) (obj1))))
                    {
                        MAPLog.e(LOG_TAG, "No Return to url in the main url");
                        throw new InvalidParameterException("No Return to url in the main url");
                    }
                    mParams.returnToURL = ((String) (obj1));
                } else
                if (s2.equalsIgnoreCase("siteState"))
                {
                    mParams.siteState = ((String) (obj1));
                } else
                if (mParseUrl && s2.equalsIgnoreCase("openid.assoc_handle"))
                {
                    mParams.associationHandle = ((String) (obj1));
                } else
                if (mParseUrl && s2.equalsIgnoreCase("pageId"))
                {
                    mParams.pageId = ((String) (obj1));
                } else
                if (mParseUrl && s2.equalsIgnoreCase("clientContext"))
                {
                    mParams.clientContext = ((String) (obj1));
                } else
                if (s2.equalsIgnoreCase("openid.claimed_id"))
                {
                    mParams.claimedId = ((String) (obj1));
                } else
                if (s2.equalsIgnoreCase("openid.identity"))
                {
                    mParams.identity = ((String) (obj1));
                } else
                if (s2.equalsIgnoreCase("openid.pape.max_auth_age"))
                {
                    mParams.maxAuthAge = ((String) (obj1));
                } else
                if (s2.equalsIgnoreCase("authCookies"))
                {
                    mParams.authCookies = ((String) (obj1));
                }
            }
        } while (true);
        illegalargumentexception = getCookieDomainFromUrl(s);
        String s3 = LOG_TAG;
        (new StringBuilder("Domain used for parameters : ")).append(illegalargumentexception).toString();
        mParams.domain = illegalargumentexception;
        mParams.url = s;
        mParams.userAgent = s1;
        mParams.requestType = getAuthenticationUrlType(s).toString();
    }

    public void handleAuthResultError(Bundle bundle)
    {
        synchronized (mLock)
        {
            MAPLog.e(LOG_TAG, "Error in handleAuthActivityResultError");
            MAPWebViewEventHelper.setError(bundle, mClientEventCallback);
        }
    }

    public void handleAuthSuccessResult(Bundle bundle)
    {
        boolean flag = true;
        bundle = ((Bundle) (mLock));
        bundle;
        JVM INSTR monitorenter ;
        Exception exception;
        if (isWarmSeatAuthenticationRequest())
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        getCookiesFromTokenManagement(true, new Callback() {

            final MAPWebViewHelper this$0;

            public void onError(Bundle bundle1)
            {
                MAPWebViewEventHelper.setError(bundle1, mClientEventCallback);
            }

            public void onSuccess(Bundle bundle1)
            {
                MAPWebViewEventHelper.setAuthenticationEvent(MAPWebViewHelper.this);
            }

            
            {
                this$0 = MAPWebViewHelper.this;
                super();
            }
        });
_L2:
        bundle;
        JVM INSTR monitorexit ;
        return;
        continueLoadingURL();
        MAPWebViewEventHelper.setAuthenticationOnlyEvent(mClientEventCallback);
        if (true) goto _L2; else goto _L1
_L1:
        exception;
        throw exception;
    }

    public boolean handleAuthentication(final Activity activity, String s)
    {
        checkAndCleanUpCookiesAroundRegistrationState();
        String s1 = mWebView.getSettings().getUserAgentString();
        if (isAuthenticationUrl(s))
        {
            try
            {
                getParams(s, s1);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                MAPWebViewEventHelper.setError(TokenCallbackHelpers.getErrorBundle(MAPAccountManager.RegistrationError.BAD_REQUEST.value(), "Invalid Parameter"), mClientEventCallback);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                MAPWebViewEventHelper.setError(TokenCallbackHelpers.getErrorBundle(MAPAccountManager.RegistrationError.BAD_REQUEST.value(), "Invalid URL"), mClientEventCallback);
            }
            if (!TextUtils.equals(mParams.requestType, URL_TYPE.REGULAR.toString()))
            {
                MAPLog.i(LOG_TAG, (new StringBuilder("URL TYPE: ")).append(mParams.requestType).toString());
                mWebView.stopLoading();
                s = LOG_TAG;
                if (TextUtils.equals(mParams.requestType, com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.CONFIRM_CREDENTIAL.toString()))
                {
                    if (activity == null)
                    {
                        throw new InvalidParameterException("Activity object must not be null");
                    } else
                    {
                        s = mMAPAccountManager.getAccount();
                        Bundle bundle = new Bundle();
                        bundle.putString("com.amazon.identity.ap.assoc_handle", mParams.associationHandle);
                        bundle.putString("com.amazon.identity.ap.pageid", mParams.pageId);
                        bundle.putString("com.amazon.identity.ap.clientContext", mParams.clientContext);
                        bundle.putString("com.amazon.identity.ap.domain", mParams.domain);
                        bundle.putAll(mOptions);
                        mMAPAccountManager.confirmCredential(activity, s, bundle, mAuthCallback);
                        return true;
                    }
                }
                if (!mMAPAccountManager.isDeviceRegistered())
                {
                    startAuthentication(activity);
                    return true;
                }
                if (isWarmSeatAuthenticationRequest())
                {
                    if (activity == null)
                    {
                        throw new InvalidParameterException("Activity object must not be null");
                    }
                    s = new Bundle();
                    s.putString("com.amazon.identity.ap.assoc_handle", mParams.associationHandle);
                    s.putString("com.amazon.identity.ap.pageid", mParams.pageId);
                    s.putString("com.amazon.identity.ap.clientContext", mParams.clientContext);
                    s.putBoolean("isWarmSeatAuthentication", true);
                    s.putAll(mOptions);
                    mMAPAccountManager.authenticateAccountWithUI(activity, SigninOption.WebviewSignin, s, mAuthCallback);
                } else
                {
                    boolean flag = mNeedForceRefreshCookies.getAndSet(true);
                    s = LOG_TAG;
                    getCookiesFromTokenManagement(flag, new Callback() {

                        final MAPWebViewHelper this$0;
                        final Activity val$activity;

                        public void onError(Bundle bundle1)
                        {
                            MAPWebViewEventHelper.setError(bundle1, mClientEventCallback);
                        }

                        public void onSuccess(Bundle bundle1)
                        {
                            bundle1 = bundle1.getStringArray("com.amazon.identity.auth.device.api.cookiekeys.all");
                            if (bundle1 != null && bundle1.length != 0)
                            {
                                break MISSING_BLOCK_LABEL_31;
                            }
                            MAPWebViewHelper.LOG_TAG;
                            startAuthentication(activity);
                            return;
                            bundle1;
                            MAPWebViewHelper.LOG_TAG;
                            (new StringBuilder("Android Resource error: ")).append(bundle1.getMessage()).toString();
                            MAPWebViewEventHelper.setError(TokenCallbackHelpers.getErrorBundle(MAPAccountManager.RegistrationError.BAD_REQUEST.value(), "NoSuchFieldError: Check your resources."), mClientEventCallback);
                            return;
                        }

            
            {
                this$0 = MAPWebViewHelper.this;
                activity = activity1;
                super();
            }
                    });
                }
                return true;
            }
        }
        return false;
    }

    public void handleOnCreate(MAPWebViewActivityInterface mapwebviewactivityinterface, Bundle bundle)
    {
        Object aobj[] = mLock;
        aobj;
        JVM INSTR monitorenter ;
        if (mapwebviewactivityinterface == null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        if (mapwebviewactivityinterface.getActivity() != null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        throw new InvalidParameterException("Activity must not be null");
        mapwebviewactivityinterface;
        aobj;
        JVM INSTR monitorexit ;
        throw mapwebviewactivityinterface;
        AmazonWebViewUtils.makeSureAmazonCookieSyncManagerIsInitialized(mapwebviewactivityinterface.getActivity());
        AmazonWebViewUtils.getAmazonCookieManager(mapwebviewactivityinterface.getActivity()).setAcceptCookie(true);
        setUpLocalState(bundle);
        checkAndCleanUpCookiesAroundRegistrationState();
        aobj;
        JVM INSTR monitorexit ;
    }

    public boolean isConfirmCredentialRequest()
    {
        while (TextUtils.isEmpty(mParams.claimedId) || TextUtils.isEmpty(mParams.identity) || !mParams.claimedId.equals(mParams.identity) || !mParams.claimedId.equals("http://www.amazon.com/ap/specs/auth/confirm_credentials") && !mParams.claimedId.contains("/ap/id/")) 
        {
            return false;
        }
        return true;
    }

    boolean isWarmSeatAuthenticationRequest()
    {
        while (TextUtils.isEmpty(mParams.maxAuthAge) || TextUtils.isEmpty(mParams.authCookies) || !mParams.maxAuthAge.equals("0") || !mParams.authCookies.equals("0")) 
        {
            return false;
        }
        return true;
    }

    public void saveInstanceState(Bundle bundle)
    {
        if (!TextUtils.isEmpty(mParams.returnToURL))
        {
            bundle.putString("return_to_url", mParams.returnToURL);
        }
        if (!TextUtils.isEmpty(mParams.siteState))
        {
            bundle.putString("site_state", mParams.siteState);
        }
        if (!TextUtils.isEmpty(mParams.associationHandle))
        {
            bundle.putString("association_handle", mParams.associationHandle);
        }
        if (!TextUtils.isEmpty(mParams.pageId))
        {
            bundle.putString("page_id", mParams.pageId);
        }
        if (!TextUtils.isEmpty(mParams.clientContext))
        {
            bundle.putString("client_context", mParams.clientContext);
        }
        if (!TextUtils.isEmpty(mParams.userAgent))
        {
            bundle.putString("user_agent", mParams.userAgent);
        }
        if (!TextUtils.isEmpty(mParams.requestType))
        {
            bundle.putString("request_type", mParams.requestType);
        }
        if (!TextUtils.isEmpty(mParams.domain))
        {
            bundle.putString("domain", mParams.domain);
        }
        if (!TextUtils.isEmpty(mParams.url))
        {
            bundle.putString("url", mParams.url);
        }
        if (!TextUtils.isEmpty(mParams.claimedId))
        {
            bundle.putString("claimed_id", mParams.claimedId);
        }
        if (!TextUtils.isEmpty(mParams.identity))
        {
            bundle.putString("identity", mParams.identity);
        }
        if (!TextUtils.isEmpty(mParams.maxAuthAge))
        {
            bundle.putString("max_auth_age", mParams.maxAuthAge);
        }
        if (!TextUtils.isEmpty(mParams.authCookies))
        {
            bundle.putString("authCookies", mParams.authCookies);
        }
    }

    public void setParseUrl(boolean flag)
    {
        mParseUrl = flag;
    }

    public void setUpLocalState(Bundle bundle)
    {
        if (bundle != null)
        {
            if (bundle.containsKey("return_to_url"))
            {
                mParams.returnToURL = bundle.getString("return_to_url");
            }
            if (bundle.containsKey("site_state"))
            {
                mParams.siteState = bundle.getString("site_state");
            }
            if (bundle.containsKey("association_handle"))
            {
                mParams.associationHandle = bundle.getString("association_handle");
            }
            if (bundle.containsKey("page_id"))
            {
                mParams.pageId = bundle.getString("page_id");
            }
            if (bundle.containsKey("client_context"))
            {
                mParams.clientContext = bundle.getString("client_context");
            }
            if (bundle.containsKey("user_agent"))
            {
                mParams.userAgent = bundle.getString("user_agent");
            }
            if (bundle.containsKey("request_type"))
            {
                mParams.requestType = bundle.getString("request_type");
            }
            if (bundle.containsKey("domain"))
            {
                mParams.domain = bundle.getString("domain");
            }
            if (bundle.containsKey("url"))
            {
                mParams.url = bundle.getString("url");
            }
            if (bundle.containsKey("claimed_id"))
            {
                mParams.claimedId = bundle.getString("claimed_id");
            }
            if (bundle.containsKey("identity"))
            {
                mParams.identity = bundle.getString("identity");
            }
            if (bundle.containsKey("max_auth_age"))
            {
                mParams.maxAuthAge = bundle.getString("max_auth_age");
            }
            if (bundle.containsKey("authCookies"))
            {
                mParams.authCookies = bundle.getString("authCookies");
                return;
            }
        }
    }







/*
    static void access$500(MAPWebViewHelper mapwebviewhelper, String as[])
    {
        String s = LOG_TAG;
        AmazonCookieManager amazoncookiemanager = AmazonWebViewUtils.getAmazonCookieManager(mapwebviewhelper.mContext);
        amazoncookiemanager.setAcceptCookie(true);
        AmazonWebViewUtils.syncAmazonCookieSyncManager(mapwebviewhelper.mContext);
        String s1 = mapwebviewhelper.mParams.url;
        s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = mapwebviewhelper.mParams.domain;
            String s2 = LOG_TAG;
        }
        mapwebviewhelper.mSharedPrefCookieUtils.addCookiesToSharedPrefs(s, as);
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s3 = as[i];
            String s4 = LOG_TAG;
            (new StringBuilder("Adding cookie to CookieManager: ")).append(s3).toString();
            amazoncookiemanager.setCookie(s, s3);
        }

        AmazonWebViewUtils.syncAmazonCookieSyncManager(mapwebviewhelper.mContext);
        return;
    }

*/



}
