// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.webkit.CookieManager;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebHistoryItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.amazon.identity.auth.accounts.AccountsCallbackHelpers;
import com.amazon.identity.auth.accounts.AmazonAccountManager;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.DeviceDataStore;
import com.amazon.identity.auth.device.api.DeviceDataStoreException;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.api.RegistrationType;
import com.amazon.identity.auth.device.attribute.DeviceAttribute;
import com.amazon.identity.auth.device.callback.RemoteCallbackWrapper;
import com.amazon.identity.auth.device.endpoint.OpenIdRequest;
import com.amazon.identity.auth.device.endpoint.OpenIdResponse;
import com.amazon.identity.auth.device.endpoint.TokenRequestHelpers;
import com.amazon.identity.auth.device.framework.AuthenticationWebViewClient;
import com.amazon.identity.auth.device.framework.MAPJavascriptInterface;
import com.amazon.identity.auth.device.framework.MAPSmsReceiver;
import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.metadata.DeviceMetadataCollector;
import com.amazon.identity.auth.device.storage.AccountTransaction;
import com.amazon.identity.auth.device.storage.BackwardsCompatiableDataStorage;
import com.amazon.identity.auth.device.token.AccessToken;
import com.amazon.identity.auth.device.token.MAPCookie;
import com.amazon.identity.auth.device.token.TokenCallbackHelpers;
import com.amazon.identity.auth.device.utils.AmazonDomainHelper;
import com.amazon.identity.auth.device.utils.CookieUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.Platform;
import com.amazon.identity.auth.device.utils.ResourceHelper;
import com.amazon.identity.auth.device.utils.SecurityHelpers;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import com.amazon.identity.auth.device.utils.WebViewCookieUtils;
import com.amazon.identity.auth.device.utils.WebViewUtils;
import com.amazon.identity.platform.metric.MetricUtils;
import com.amazon.identity.platform.metric.MetricsHelper;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;
import com.amazon.identity.platform.util.PlatformUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.cookie.Cookie;

public class AuthPortalUIActivity extends Activity
{
    private class _cls7
        implements Runnable
    {

        final AuthPortalUIActivity this$0;
        final RemoteCallbackWrapper val$callbackWrapper;
        final Bundle val$errorBundle;

        public void run()
        {
            if (errorBundle == null)
            {
                finish();
                return;
            }
            if (callbackWrapper != null)
            {
                callbackWrapper.onError(errorBundle);
            }
            closeActivity();
        }

        _cls7()
        {
            this$0 = AuthPortalUIActivity.this;
            errorBundle = bundle;
            callbackWrapper = remotecallbackwrapper;
            super();
        }
    }

    private class _cls4
        implements Callback
    {

        final AuthPortalUIActivity this$0;
        final RemoteCallbackWrapper val$callbackWrapper;
        final OpenIdResponse val$response;
        final String val$sid;

        public void onError(Bundle bundle)
        {
            ThreadUtils.runOffMainThread(AuthPortalUIActivity.this, bundle, callbackWrapper);
        }

        public void onSuccess(Bundle bundle)
        {
            Object obj = bundle.getString("com.amazon.dcp.sso.property.account.acctId");
            if (obj == null)
            {
                MAPLog.w(AuthPortalUIActivity.TAG, "directedId returned from registration was null. Not setting Auth Portal domain.");
            } else
            {
                MAPLog.i(AuthPortalUIActivity.TAG, (new StringBuilder("Account registered with domain: ")).append(mUrlHost).toString());
                obj = new AccountTransaction(((String) (obj)), null, null);
                ((AccountTransaction) (obj)).setUserData("authDomain", mUrlHost);
                if (!TextUtils.isEmpty(sid))
                {
                    ((AccountTransaction) (obj)).setToken("com.amazon.dcp.sso.token.cookie.sid", sid);
                }
                mBackwardsCompatiableDataStorage.setData(((AccountTransaction) (obj)));
            }
            bundle.putBoolean("com.amazon.identity.auth.device.accountManager.newaccount", response.isNewAccount().booleanValue());
            bundle.putString("claim_type", response.getClaimType());
            returnSuccess(bundle, callbackWrapper);
        }

        _cls4()
        {
            this$0 = AuthPortalUIActivity.this;
            sid = s;
            response = openidresponse;
            callbackWrapper = remotecallbackwrapper;
            super();
        }
    }

    private class TimeoutTimerTask extends TimerTask
    {

        final AuthPortalUIActivity this$0;

        public void run()
        {
            if (mTracer != null)
            {
                String s = (new StringBuilder()).append(mTimeoutMetricsName).append(":NetworkState:").append(MetricUtils.isNetworkAvailable(mContext)).toString();
                mTracer.incrementCounter(s);
            }
            finishOnError(AccountsCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.NETWORK_FAILURE.value(), "Unable to render content. Request timed out."));
        }

        private TimeoutTimerTask()
        {
            this$0 = AuthPortalUIActivity.this;
            super();
        }

        TimeoutTimerTask(byte byte0)
        {
            this();
        }
    }


    private static final String TAG = com/amazon/identity/auth/device/AuthPortalUIActivity.getName();
    private Set mAllowedSignInDomains;
    private AmazonAccountManager mAmazonAccountManager;
    private AuthenticationWebViewClient mAuthenticationWebViewClient;
    private PlatformMetricsTimer mBackPressedTimer;
    private BackwardsCompatiableDataStorage mBackwardsCompatiableDataStorage;
    private boolean mBarFade;
    private boolean mBarFaded;
    private boolean mBarOn;
    private String mClientId;
    private ServiceWrappingContext mContext;
    private String mCookieUrl;
    private PlatformMetricsTimer mCriticalFeatureLoadTimer;
    private PlatformMetricsTimer mDcqChallengeQuestionEnterTimer;
    private String mDeviceType;
    private String mDsn;
    private PlatformMetricsTimer mFirstOnPageStartedTimer;
    private PlatformMetricsTimer mFirstPageLoadTimer;
    private Set mFrcCookieUrlSet;
    private String mFrcCookieValue;
    private AtomicBoolean mIsRegistrationInFlight;
    private MAPAccountManager mMapAccountManager;
    private PlatformMetricsTimer mMfaChallengeCodeEnterTimer;
    private Bundle mOptions;
    private PlatformMetricsTimer mPageLoadToFirstRenderTimer;
    private PlatformWrapper mPlatform;
    private int mProgressbarId;
    private Timer mRequestTimeoutTimer;
    private RemoteCallbackWrapper mResponse;
    private MAPSmsReceiver mSmsReceiver;
    private String mTimeoutMetricsName;
    private Tracer mTracer;
    private String mUrlHost;
    private WebView mWebView;

    public AuthPortalUIActivity()
    {
        mFirstOnPageStartedTimer = null;
        mFirstPageLoadTimer = null;
        mPageLoadToFirstRenderTimer = null;
        mBackPressedTimer = null;
        mCriticalFeatureLoadTimer = null;
        mIsRegistrationInFlight = new AtomicBoolean(false);
    }

    private void cancelMetricsAndTimeoutTimers()
    {
        if (mRequestTimeoutTimer != null)
        {
            mRequestTimeoutTimer.cancel();
        }
    }

    private RemoteCallbackWrapper claimResponseCallback()
    {
        RemoteCallbackWrapper remotecallbackwrapper = mResponse;
        mResponse = null;
        return remotecallbackwrapper;
    }

    private void clearSpecificCookie(String s, String s1, String s2, String s3, boolean flag)
    {
        WebViewCookieUtils.setCookie$218ec1f1(mContext, s, s1, "", s2, s3, flag);
    }

    private void closeActivity()
    {
        mIsRegistrationInFlight.set(false);
        super.finish();
    }

    private void finishOnError(final Bundle errorBundle)
    {
        ThreadUtils.runOffMainThread(new Runnable() {

            final AuthPortalUIActivity this$0;
            final Bundle val$errorBundle;
            final RemoteCallbackWrapper val$response;

            public void run()
            {
                if (errorBundle == null)
                {
                    finish();
                    return;
                }
                if (response != null)
                {
                    response.onError(errorBundle);
                }
                closeActivity();
            }

            
            {
                this$0 = AuthPortalUIActivity.this;
                errorBundle = bundle;
                response = remotecallbackwrapper;
                super();
            }
        });
    }

    private String getDSN()
    {
        String s;
        try
        {
            s = DeviceDataStore.getInstance(mContext).getValue("Device Serial Number");
        }
        catch (DeviceDataStoreException devicedatastoreexception)
        {
            if (PlatformUtils.hasGroverVersion3orLater(mContext) || PlatformUtils.hasCanary(mContext))
            {
                return UUID.randomUUID().toString().replace("-", "");
            } else
            {
                MAPLog.e(TAG, "Cannot fetch dsn from the DeviceDataStore.", devicedatastoreexception);
                return null;
            }
        }
        return s;
    }

    private Map getDebugParameters()
    {
        HashMap hashmap = new HashMap();
        Bundle bundle = getPackageManager().getApplicationInfo(getPackageName(), 128).metaData;
        if (bundle == null)
        {
            return hashmap;
        }
        try
        {
            String s = bundle.getString("debugParams");
            if (!TextUtils.isEmpty(s))
            {
                android.text.TextUtils.SimpleStringSplitter simplestringsplitter = new android.text.TextUtils.SimpleStringSplitter(',');
                simplestringsplitter.setString(s);
                do
                {
                    if (!simplestringsplitter.hasNext())
                    {
                        break;
                    }
                    String s1 = simplestringsplitter.next();
                    android.text.TextUtils.SimpleStringSplitter simplestringsplitter1 = new android.text.TextUtils.SimpleStringSplitter('=');
                    simplestringsplitter1.setString(s1);
                    if (simplestringsplitter1.hasNext())
                    {
                        String s2 = simplestringsplitter1.next();
                        if (simplestringsplitter1.hasNext())
                        {
                            hashmap.put(s2, simplestringsplitter1.next());
                        }
                    }
                } while (true);
            }
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            MAPLog.e(TAG, "No meta found for this package", namenotfoundexception);
        }
        return hashmap;
    }

    private RelativeLayout getParentLayout()
    {
        return (RelativeLayout)findViewById(ResourceHelper.getId(this, "apparentlayout"));
    }

    private WebView getWebView()
    {
        if (mWebView != null)
        {
            return mWebView;
        } else
        {
            mWebView = (WebView)findViewById(ResourceHelper.getId(this, "apwebview"));
            return mWebView;
        }
    }

    private void hideProgressBar()
    {
        if (mAuthenticationWebViewClient.isMFA() && mMfaChallengeCodeEnterTimer == null && mTracer != null)
        {
            mMfaChallengeCodeEnterTimer = mTracer.startTimer("MFA:ChallengeCodeEnterTime");
        }
        if (mAuthenticationWebViewClient.isDCQ() && mDcqChallengeQuestionEnterTimer == null && mTracer != null)
        {
            mDcqChallengeQuestionEnterTimer = mTracer.startTimer("DCQ:ChallengeQuestionEnterTime");
        }
        cancelMetricsAndTimeoutTimers();
        final ProgressBar progressBar = (ProgressBar)findViewById(mProgressbarId);
        if (progressBar.getVisibility() == 0)
        {
            ThreadUtils.runOnMainThread(new Runnable() {

                final AuthPortalUIActivity this$0;
                final ProgressBar val$progressBar;

                public void run()
                {
                    if (mBarFade)
                    {
                        AuthPortalUIActivity.access$2800(AuthPortalUIActivity.this);
                    }
                    if (mBarOn)
                    {
                        progressBar.setVisibility(4);
                    }
                }

            
            {
                this$0 = AuthPortalUIActivity.this;
                progressBar = progressbar;
                super();
            }
            });
        }
    }

    private boolean isEnsureAccountStateFlow()
    {
        return mOptions.getBoolean("isAccountStateFixUpFlow");
    }

    private OpenIdRequest parseIntentForOptionsAndRequest(Intent intent)
    {
        Object obj1;
        Object obj2;
        String s;
        if (intent != null)
        {
            mOptions = intent.getExtras();
            mTracer = Tracer.createFromIntent(intent, "MAP_AuthPortalUIActivity");
            if (mOptions != null && mOptions.containsKey("AuthPortalActivityUIOptions.systemUiVisibility") && android.os.Build.VERSION.SDK_INT >= 11)
            {
                int i = mOptions.getInt("AuthPortalActivityUIOptions.systemUiVisibility");
                Object obj = getWindow();
                if (obj != null)
                {
                    obj = ((Window) (obj)).getDecorView();
                    if (obj != null)
                    {
                        ((View) (obj)).setSystemUiVisibility(i);
                    }
                }
            }
            if (mOptions != null)
            {
                mResponse = (RemoteCallbackWrapper)mOptions.getParcelable("callback");
                mOptions.remove("callback");
            }
            Bundle bundle = mOptions;
            if (bundle != null)
            {
                if (bundle.getBoolean("AuthPortalActivityUIOptions.aboveLockScreen"))
                {
                    getWindow().addFlags(0x80000);
                }
                if (bundle.containsKey("AuthPortalActivityUIOptions.requestedOrientation"))
                {
                    setRequestedOrientation(bundle.getInt("AuthPortalActivityUIOptions.requestedOrientation"));
                }
                if (bundle.getBoolean("AuthPortalActivityUIOptions.fullscreen"))
                {
                    getWindow().addFlags(1024);
                }
            }
        } else
        {
            MAPLog.e(TAG, "The intent in AuthPortalUIActivity is null. This should never happen.");
        }
        s = mClientId;
        obj2 = com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.SIGN_IN;
        obj1 = obj2;
        if (intent == null) goto _L2; else goto _L1
_L1:
        intent = intent.getExtras();
        obj1 = obj2;
        if (intent == null) goto _L2; else goto _L3
_L3:
        intent = intent.getString("requestType");
        obj1 = obj2;
        if (intent == null) goto _L2; else goto _L4
_L4:
        if (!com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.REGISTER.toString().equalsIgnoreCase(intent)) goto _L6; else goto _L5
_L5:
        obj1 = com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.REGISTER;
_L2:
        intent = new OpenIdRequest(s, ((com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE) (obj1)), mOptions);
        mUrlHost = intent.getHost();
        if (mOptions != null)
        {
            obj1 = mOptions.getStringArrayList("signin_domains");
            if (obj1 != null)
            {
                mAllowedSignInDomains.addAll(((java.util.Collection) (obj1)));
            }
        }
        mAllowedSignInDomains.add(mUrlHost);
        obj2 = mAllowedSignInDomains;
        obj1 = new HashSet();
        for (obj2 = ((Set) (obj2)).iterator(); ((Iterator) (obj2)).hasNext(); ((Set) (obj1)).add(AmazonDomainHelper.getDomainWithoutWWW((String)((Iterator) (obj2)).next()))) { }
        break; /* Loop/switch isn't completed */
_L6:
        if (com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.SIGN_IN.toString().equalsIgnoreCase(intent))
        {
            obj1 = com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.SIGN_IN;
        } else
        if (com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.CONFIRM_CREDENTIAL.toString().equalsIgnoreCase(intent))
        {
            obj1 = com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.CONFIRM_CREDENTIAL;
        } else
        {
            obj1 = obj2;
            if (com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.AUTHENTICATE.toString().equalsIgnoreCase(intent))
            {
                obj1 = com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.AUTHENTICATE;
            }
        }
        if (true) goto _L2; else goto _L7
_L7:
        mAllowedSignInDomains = ((Set) (obj1));
        (new StringBuilder("Allowed signin domains after formatting ")).append(mAllowedSignInDomains);
        return intent;
    }

    private void returnSuccess(final Bundle result, final RemoteCallbackWrapper callbackWrapper)
    {
        ThreadUtils.runOffMainThread(new Runnable() {

            final AuthPortalUIActivity this$0;
            final RemoteCallbackWrapper val$callbackWrapper;
            final Bundle val$result;

            public void run()
            {
                if (callbackWrapper != null)
                {
                    callbackWrapper.onSuccess(result);
                }
                finish();
            }

            
            {
                this$0 = AuthPortalUIActivity.this;
                callbackWrapper = remotecallbackwrapper;
                result = bundle;
                super();
            }
        });
    }

    private void setProgressBarProgress(int i)
    {
        if (mBarOn)
        {
            ProgressBar progressbar = (ProgressBar)findViewById(mProgressbarId);
            if (progressbar.getVisibility() == 0)
            {
                progressbar.setProgress(i);
            }
        }
    }

    private void setWebViewAuthCookiesIfNecessary(String s)
    {
        if (mOptions.containsKey("InjectCookiesToAuthPortalUIActivity"))
        {
            MAPLog.i(TAG, "Need to inject the cookies into the webview.");
            String as[] = mOptions.getStringArray("InjectCookiesToAuthPortalUIActivity");
            if (as != null)
            {
                CookieManager cookiemanager = CookieManager.getInstance();
                cookiemanager.setAcceptCookie(true);
                WebViewUtils.syncCookieSyncManager(mContext);
                int j = as.length;
                for (int i = 0; i < j; i++)
                {
                    cookiemanager.setCookie(s, as[i]);
                }

                WebViewUtils.syncCookieSyncManager(mContext);
            }
        }
    }

    private void setWindowFlagsFromIntent(Intent intent)
    {
        Window window = getWindow();
        if (window != null)
        {
            window.addFlags(0x10000);
            window.addFlags(256);
            intent = intent.getExtras();
            if (intent != null)
            {
                intent = intent.getIntArray("AuthPortalActivityUIOptions.windowFlags");
                if (intent != null)
                {
                    for (int i = 0; i < intent.length; i++)
                    {
                        window.addFlags(intent[i]);
                    }

                }
            }
        }
    }

    private void setupFrcCookie(String s)
    {
        if (!TextUtils.isEmpty(mFrcCookieValue))
        {
            s = WebViewCookieUtils.getCookieUrl(s);
            break MISSING_BLOCK_LABEL_15;
        }
        do
        {
            return;
        } while (s == null || mFrcCookieUrlSet.contains(s));
        WebViewCookieUtils.setCookie$218ec1f1(mContext, s, "frc", mFrcCookieValue, "/ap", null, true);
        mFrcCookieUrlSet.add(s);
    }

    private void setupWebChromeClient(WebView webview)
    {
        webview.setWebChromeClient(new WebChromeClient() {

            final AuthPortalUIActivity this$0;

            public void onProgressChanged(WebView webview1, int i)
            {
                AuthPortalUIActivity.access$600(AuthPortalUIActivity.this, webview1, i);
            }

            
            {
                this$0 = AuthPortalUIActivity.this;
                super();
            }
        });
    }

    public void finish()
    {
        if (!mIsRegistrationInFlight.get())
        {
            Bundle bundle = AccountsCallbackHelpers.getAccountManagerErrorBundle(4, "Registration canceled");
            if (isEnsureAccountStateFlow())
            {
                bundle.putStringArrayList("AccountMissingAttributes", mOptions.getStringArrayList("AccountMissingAttributes"));
            }
            finishOnError(bundle);
            return;
        } else
        {
            closeActivity();
            return;
        }
    }

    public void onBackPressed()
    {
        if (!mIsRegistrationInFlight.get())
        {
            if (mBackPressedTimer != null)
            {
                mBackPressedTimer.stopAndDiscard();
            }
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        try
        {
            configuration = getWebView();
        }
        // Misplaced declaration of an exception variable
        catch (Configuration configuration)
        {
            (new StringBuilder("Android Resource error: ")).append(configuration.getMessage());
            return;
        }
        if (configuration == null)
        {
            break MISSING_BLOCK_LABEL_18;
        }
        configuration.invalidate();
    }

    protected void onCreate(Bundle bundle)
    {
        MAPLog.i(TAG, String.format("Login webview called in package %s by package %s", new Object[] {
            getPackageName(), getCallingPackage()
        }));
        SecurityHelpers.checkCallingPackagePermissionsOrSystem(this);
        mContext = ServiceWrappingContext.create(getApplicationContext());
        mMapAccountManager = new MAPAccountManager(mContext);
        mAmazonAccountManager = new AmazonAccountManager(mContext);
        mPlatform = (PlatformWrapper)mContext.getSystemService("sso_platform");
        mBackwardsCompatiableDataStorage = new BackwardsCompatiableDataStorage(mContext);
        mFrcCookieUrlSet = new HashSet();
        mAllowedSignInDomains = new HashSet();
        mDsn = getDSN();
        mDeviceType = Platform.getDeviceAttribute(mContext, DeviceAttribute.CentralDeviceType);
        mClientId = OpenIdRequest.constructClientIdWithDsnAndDeviceType(mDsn, mDeviceType);
        setWindowFlagsFromIntent(getIntent());
        requestWindowFeature(1);
        super.onCreate(bundle);
        if (TextUtils.isEmpty(mDsn) || TextUtils.isEmpty(mDeviceType))
        {
            finishOnError(AccountsCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED.value(), "An unexpected error occured while setting up the WebView. Cannot fetch client id! If it is an unregistered Grover(versions lesser than )/Canary(all version) device, it is expected."));
            return;
        }
        WebView webview;
        final OpenIdRequest request;
        request = parseIntentForOptionsAndRequest(getIntent());
        setContentView(ResourceHelper.getLayoutId(this, "apwebviewlayout"));
        webview = getWebView();
        if (webview != null) goto _L2; else goto _L1
_L1:
        webview = null;
_L3:
        Object obj;
        Object obj1;
        Object obj2;
        int i;
        int j;
        int k;
        int l;
        boolean flag;
        boolean flag1;
        if (webview == null)
        {
            static class _cls9
            {

                static final int $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$AuthPortalActivityUIOptions$ProgressBarState[];
                static final int $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$AuthPortalActivityUIOptions$ScreenPosition[];

                static 
                {
                    $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$AuthPortalActivityUIOptions$ScreenPosition = new int[com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ScreenPosition.values().length];
                    try
                    {
                        $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$AuthPortalActivityUIOptions$ScreenPosition[com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ScreenPosition.TOP_LEFT.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror13) { }
                    try
                    {
                        $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$AuthPortalActivityUIOptions$ScreenPosition[com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ScreenPosition.TOP_CENTER.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror12) { }
                    try
                    {
                        $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$AuthPortalActivityUIOptions$ScreenPosition[com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ScreenPosition.TOP_RIGHT.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror11) { }
                    try
                    {
                        $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$AuthPortalActivityUIOptions$ScreenPosition[com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ScreenPosition.CENTER_LEFT.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror10) { }
                    try
                    {
                        $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$AuthPortalActivityUIOptions$ScreenPosition[com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ScreenPosition.CENTER_CENTER.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror9) { }
                    try
                    {
                        $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$AuthPortalActivityUIOptions$ScreenPosition[com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ScreenPosition.CENTER_RIGHT.ordinal()] = 6;
                    }
                    catch (NoSuchFieldError nosuchfielderror8) { }
                    try
                    {
                        $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$AuthPortalActivityUIOptions$ScreenPosition[com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ScreenPosition.BOTTOM_LEFT.ordinal()] = 7;
                    }
                    catch (NoSuchFieldError nosuchfielderror7) { }
                    try
                    {
                        $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$AuthPortalActivityUIOptions$ScreenPosition[com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ScreenPosition.BOTTOM_CENTER.ordinal()] = 8;
                    }
                    catch (NoSuchFieldError nosuchfielderror6) { }
                    try
                    {
                        $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$AuthPortalActivityUIOptions$ScreenPosition[com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ScreenPosition.BOTTOM_RIGHT.ordinal()] = 9;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$AuthPortalActivityUIOptions$ProgressBarState = new int[com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ProgressBarState.values().length];
                    try
                    {
                        $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$AuthPortalActivityUIOptions$ProgressBarState[com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ProgressBarState.PROGRESS_BAR.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$AuthPortalActivityUIOptions$ProgressBarState[com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ProgressBarState.OFF.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$AuthPortalActivityUIOptions$ProgressBarState[com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ProgressBarState.SPINNER_SMALL.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$AuthPortalActivityUIOptions$ProgressBarState[com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ProgressBarState.SPINNER_MEDIUM.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$AuthPortalActivityUIOptions$ProgressBarState[com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ProgressBarState.SPINNER_LARGE.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            try
            {
                finishOnError(AccountsCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED.value(), "An unexpected error occured while setting up the WebView."));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                finishOnError(AccountsCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST.value(), bundle.getMessage()));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                finishOnError(AccountsCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED.value(), bundle.getMessage()));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                finishOnError(AccountsCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED.value(), bundle.getMessage()));
            }
            return;
        }
        break MISSING_BLOCK_LABEL_365;
_L2:
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        webview.restoreState(bundle);
        webview.setScrollBarStyle(0);
        bundle = webview.getSettings();
        bundle.setSavePassword(false);
        bundle.setSaveFormData(false);
        bundle.setRenderPriority(android.webkit.WebSettings.RenderPriority.HIGH);
        webview.clearFormData();
        webview.getSettings().setJavaScriptEnabled(true);
          goto _L3
        mSmsReceiver = new MAPSmsReceiver(mTracer, webview);
        bundle = new com.amazon.identity.auth.device.framework.AuthenticationWebViewClient.AuthenticationWebViewClientCallback() {

            final AuthPortalUIActivity this$0;
            final OpenIdRequest val$request;

            public void onCodeEnterFinished()
            {
                String _tmp = AuthPortalUIActivity.TAG;
                if (mAuthenticationWebViewClient.isMFA() && mMfaChallengeCodeEnterTimer != null)
                {
                    String _tmp1 = AuthPortalUIActivity.TAG;
                    mMfaChallengeCodeEnterTimer.stopAndDiscard();
                    mMfaChallengeCodeEnterTimer;
                }
                if (mAuthenticationWebViewClient.isDCQ() && mDcqChallengeQuestionEnterTimer != null)
                {
                    String _tmp2 = AuthPortalUIActivity.TAG;
                    mDcqChallengeQuestionEnterTimer.stopAndDiscard();
                    mDcqChallengeQuestionEnterTimer;
                }
            }

            public void onPageFinished()
            {
                int i1 = ResourceHelper.getId(AuthPortalUIActivity.this, "apimageview");
                ImageView imageview = (ImageView)findViewById(i1);
                WebView webview1 = getWebView();
                if (webview1 == null)
                {
                    finishOnError(AccountsCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED.value(), "An unexpected error occured while setting up the WebView."));
                } else
                {
                    if (imageview.getVisibility() == 0)
                    {
                        imageview.setVisibility(8);
                    }
                    if (webview1.getVisibility() != 0)
                    {
                        webview1.setVisibility(0);
                        webview1.requestFocusFromTouch();
                    }
                    setProgressBarProgress();
                    hideProgressBar();
                    if (mPageLoadToFirstRenderTimer != null)
                    {
                        mPageLoadToFirstRenderTimer.stopAndDiscard();
                    }
                    if (mFirstPageLoadTimer != null)
                    {
                        mFirstPageLoadTimer.stopAndDiscard();
                        return;
                    }
                }
            }

            public void onPageStarted(String s)
            {
                String s1;
                setupFrcCookie(s);
                if (mFirstOnPageStartedTimer != null)
                {
                    mFirstOnPageStartedTimer.stopAndDiscard();
                }
                s1 = (new StringBuilder("AuthPortalPageTimeout:")).append(request.getRequestType().name()).toString();
                if (!mAuthenticationWebViewClient.isMFA()) goto _L2; else goto _L1
_L1:
                s = (new StringBuilder()).append(s1).append(":MFA").toString();
_L4:
                mTimeoutMetricsName = s;
                if (mRequestTimeoutTimer != null)
                {
                    mRequestTimeoutTimer.cancel();
                }
                mRequestTimeoutTimer = new Timer();
                mRequestTimeoutTimer.schedule(new TimeoutTimerTask((byte)0), 0x3d090L);
                mBarFaded;
                return;
_L2:
                s = s1;
                if (mAuthenticationWebViewClient.isDCQ())
                {
                    s = (new StringBuilder()).append(s1).append(":DCQ").toString();
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            public void setError(Bundle bundle2)
            {
                cancelMetricsAndTimeoutTimers();
                finishOnError(bundle2);
            }

            public void setResult(OpenIdResponse openidresponse)
            {
                mSmsReceiver.incrementCounterForAutoPhoneVerificationSuccess();
                AuthPortalUIActivity.access$800(AuthPortalUIActivity.this, request.getRequestType(), openidresponse);
            }

            
            {
                this$0 = AuthPortalUIActivity.this;
                request = openidrequest;
                super();
            }
        };
        mAuthenticationWebViewClient = new AuthenticationWebViewClient(mContext, mSmsReceiver, request.getRequestType(), request.getReturnToUrl(), com.amazon.identity.auth.device.endpoint.OpenIdRequest.TOKEN_SCOPE.ACCESS, mAllowedSignInDomains, bundle, mTracer);
        mWebView.setWebViewClient(mAuthenticationWebViewClient);
        safelySetUpJavascriptInterface(webview, new com.amazon.identity.auth.device.framework.MAPJavascriptInterface.MAPJavascriptInterfaceCallback() {

            final AuthPortalUIActivity this$0;

            
            {
                this$0 = AuthPortalUIActivity.this;
                super();
            }
        });
        mCookieUrl = request.getCookieUrl();
        clearSpecificCookie(mCookieUrl, "sid", "/", CookieUtils.getNonExpiringCookieExpiresString(), false);
        if (mOptions != null)
        {
            bundle = mOptions.getString("directedid");
            if (!TextUtils.isEmpty(bundle))
            {
                bundle = mBackwardsCompatiableDataStorage.getToken(bundle, "com.amazon.dcp.sso.token.cookie.sid");
                if (!TextUtils.isEmpty(bundle))
                {
                    WebViewCookieUtils.setCookie$218ec1f1(mContext, mCookieUrl, "sid", bundle, "/", CookieUtils.getNonExpiringCookieExpiresString(), false);
                }
            }
        }
        bundle = getDSN();
        mFrcCookieValue = DeviceMetadataCollector.getFraudMetadata(mContext, bundle, mTracer);
        setupFrcCookie(mCookieUrl);
        bundle = DeviceMetadataCollector.getMapToAuthPortalMetadataCookie(mContext, mSmsReceiver, getPackageName(), mTracer);
        if (!TextUtils.isEmpty(bundle))
        {
            WebViewCookieUtils.setCookie$218ec1f1(mContext, mCookieUrl, "map-md", bundle, "/ap", null, true);
        }
        if (!request.getRequestType().equals(com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.AUTHENTICATE)) goto _L5; else goto _L4
_L4:
        flag = mOptions.getBoolean("isWarmSeatAuthentication", false);
_L36:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_671;
        }
        request.setMaxAuthAge("0");
        request.setIgnoreAuthCookiesOnResponse$1385ff();
        if (request.getRequestType() != com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.CONFIRM_CREDENTIAL) goto _L7; else goto _L6
_L6:
        if (!mPlatform.isOtter()) goto _L9; else goto _L8
_L8:
        obj1 = mBackwardsCompatiableDataStorage.getToken(mOptions.getString("directedid"), "com.amazon.dcp.sso.token.cookie.xmain");
        if (!TextUtils.isEmpty(((CharSequence) (obj1)))) goto _L11; else goto _L10
_L10:
        finishOnError(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED, "X-MAIN should exist. There is likely a registration bug."));
_L37:
        setWebViewAuthCookiesIfNecessary(mCookieUrl);
        obj1 = mOptions;
        bundle = com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ProgressBarState.OFF;
        obj = com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ScreenPosition.BOTTOM_CENTER;
        mBarFade = true;
        i = -1;
        j = -1;
        if (obj1 == null) goto _L13; else goto _L12
_L12:
        obj2 = ((Bundle) (obj1)).getString("progressbar_state");
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_794;
        }
        bundle = com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ProgressBarState.get(((String) (obj2)));
        obj2 = ((Bundle) (obj1)).getString("progressbar_position");
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_815;
        }
        obj = com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ScreenPosition.get(((String) (obj2)));
        mBarFade = ((Bundle) (obj1)).getBoolean("progressbar_fade", mBarFade);
        flag1 = ((Bundle) (obj1)).getBoolean("progressbar_stretch", true);
        flag = ((Bundle) (obj1)).getBoolean("progressbar_invert_spinner", false);
        l = ((Bundle) (obj1)).getInt("progressbar_resource", -1);
        k = ((Bundle) (obj1)).getInt("progressbar_background_resource", -1);
        i = ((Bundle) (obj1)).getInt("progressbar_primary_color", -1);
        j = ((Bundle) (obj1)).getInt("progressbar_secondary_color", -1);
        obj1 = obj;
        obj = bundle;
        bundle = ((Bundle) (obj1));
_L49:
        mProgressbarId = ResourceHelper.getId(this, "approgressbar");
        obj1 = (ProgressBar)findViewById(mProgressbarId);
        obj2 = (android.widget.RelativeLayout.LayoutParams)((ProgressBar) (obj1)).getLayoutParams();
        _cls9..SwitchMap.com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ProgressBarState[((com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ProgressBarState) (obj)).ordinal()];
        JVM INSTR tableswitch 1 2: default 1981
    //                   1 1685
    //                   2 1851;
           goto _L14 _L15 _L16
_L14:
        mBarOn = true;
        i = 0;
        _cls9..SwitchMap.com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ProgressBarState[((com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ProgressBarState) (obj)).ordinal()];
        JVM INSTR tableswitch 3 5: default 1984
    //                   3 2027
    //                   4 2048
    //                   5 2069;
           goto _L17 _L18 _L19 _L20
_L17:
        MAPLog.e(TAG, "Bar State not recongized");
_L52:
        obj2.width = -2;
        ((ProgressBar) (obj1)).setVisibility(8);
        obj = new ProgressBar(this, null, i);
        getParentLayout().addView(((View) (obj)));
        i = ResourceHelper.getId(this, "apspinner_progressbar");
        ((ProgressBar) (obj)).setId(i);
        mProgressbarId = i;
        setupWebChromeClient(webview);
_L45:
        if (!mBarOn) goto _L22; else goto _L21
_L21:
        bundle.getValue();
        _cls9..SwitchMap.com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ScreenPosition[bundle.ordinal()];
        JVM INSTR tableswitch 1 9: default 1987
    //                   1 1869
    //                   2 1869
    //                   3 1869
    //                   4 1879
    //                   5 1879
    //                   6 1879
    //                   7 1889
    //                   8 1889
    //                   9 1889;
           goto _L23 _L24 _L24 _L24 _L25 _L25 _L25 _L26 _L26 _L26
_L23:
        _cls9..SwitchMap.com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ScreenPosition[bundle.ordinal()];
        JVM INSTR tableswitch 1 9: default 1990
    //                   1 1899
    //                   2 1909
    //                   3 1919
    //                   4 1899
    //                   5 1909
    //                   6 1919
    //                   7 1899
    //                   8 1909
    //                   9 1919;
           goto _L27 _L28 _L29 _L30 _L28 _L29 _L30 _L28 _L29 _L30
_L27:
        ((ProgressBar) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
        ((ProgressBar) (obj)).bringToFront();
_L22:
        obj1 = mOptions;
        i = -1;
        bundle = null;
        obj = (ImageView)findViewById(ResourceHelper.getId(this, "apimageview"));
        if (obj1 == null) goto _L32; else goto _L31
_L31:
        i = ((Bundle) (obj1)).getInt("splashscreen_resource", -1);
        bundle = ((Bundle) (obj1)).getString("splashscreen_scale_type");
_L32:
        if (-1 != i) goto _L34; else goto _L33
_L33:
        ((ImageView) (obj)).setVisibility(8);
        webview.setVisibility(0);
        webview.requestFocusFromTouch();
_L48:
        if (TextUtils.isEmpty(webview.getUrl()))
        {
            request.setDebugParams(getDebugParameters());
            bundle = request.getRequestUrl();
            if (mTracer != null)
            {
                mFirstOnPageStartedTimer = mTracer.startTimer((new StringBuilder("AuthPortalUIActivity_FirstOnPageStarted:")).append(MetricUtils.getAuthPortalUrlPathAndDomain(bundle)).toString());
                mFirstPageLoadTimer = mTracer.startTimer((new StringBuilder("AuthPortalUIActivity_FirstPageLoad:")).append(MetricUtils.getAuthPortalUrlPathAndDomain(bundle)).toString());
                mPageLoadToFirstRenderTimer = mTracer.startTimer((new StringBuilder("AuthPortalUIActivity_FirstPageRender:")).append(MetricUtils.getAuthPortalUrlPathAndDomain(bundle)).toString());
                mBackPressedTimer = mTracer.startTimer((new StringBuilder("AuthPortalUIActivity_BackPressedInWebView:")).append(MetricUtils.getAuthPortalUrlPathAndDomain(bundle)).toString());
            }
            if (android.os.Build.VERSION.SDK_INT >= 17 && mTracer != null)
            {
                mCriticalFeatureLoadTimer = mTracer.startTimer((new StringBuilder("AuthPortalUIActivity_CriticalFeatureLoaded:")).append(MetricUtils.getAuthPortalUrlPathAndDomain(bundle)).toString());
            }
            webview.loadUrl(bundle);
            return;
        }
          goto _L35
_L5:
        flag = false;
          goto _L36
_L11:
        if (request.getHost().contains("development.amazon.com"))
        {
            bundle = "x-tacbus";
            obj = "development.amazon.com";
        } else
        {
            bundle = "x-main";
            obj = ".amazon.com";
        }
        bundle = new MAPCookie(bundle, ((String) (obj1)), ((String) (obj)), CookieUtils.getNonExpiringCookieExpiresString(), "/", null, false, false);
        request.setClaimedId("http://www.amazon.com/ap/specs/auth/confirm_credentials");
        WebViewCookieUtils.setCookie(mContext, request.getRequestUrl(), bundle);
_L38:
        request.setMaxAuthAge("0");
        request.setDisableLoginPrepopulate("0");
          goto _L37
_L9:
        bundle = new StringBuilder();
        bundle.append(TokenRequestHelpers.getRequestUrlSchemeAndAuthority(mOptions, com.amazon.identity.auth.device.endpoint.TokenRequestHelpers.PROTOCOL.HTTPS, request.getHost()));
        bundle.append("/ap/id/");
        bundle.append(mOptions.get("directedid"));
        request.setClaimedId(bundle.toString());
          goto _L38
_L7:
        request.setDisableLoginPrepopulate("1");
          goto _L37
_L15:
        mBarOn = true;
        if (!flag1) goto _L40; else goto _L39
_L39:
        obj2.width = -1;
_L46:
        if (-1 == l) goto _L42; else goto _L41
_L41:
        obj = getResources().getDrawable(l);
        ((ProgressBar) (obj1)).setProgressDrawable(new ClipDrawable(((Drawable) (obj)), 3, 1));
        if (-1 == k) goto _L44; else goto _L43
_L43:
        ((ProgressBar) (obj1)).setBackgroundDrawable(getResources().getDrawable(k));
_L44:
        obj2.width = ((Drawable) (obj)).getMinimumWidth();
_L47:
        setupWebChromeClient(webview);
        obj = obj1;
          goto _L45
_L40:
        obj2.width = -2;
          goto _L46
_L51:
        obj = new GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, new int[] {
            i, k
        });
        ((GradientDrawable) (obj)).setShape(0);
        ((GradientDrawable) (obj)).setCornerRadius(5F);
        ((ProgressBar) (obj1)).setProgressDrawable(new ClipDrawable(((Drawable) (obj)), 3, 1));
        ((ProgressBar) (obj1)).setBackgroundDrawable(getResources().getDrawable(0x108006c));
          goto _L47
_L16:
        mBarOn = false;
        ((ProgressBar) (obj1)).setVisibility(8);
        obj = obj1;
          goto _L45
_L24:
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(10);
          goto _L23
_L25:
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(15);
          goto _L23
_L26:
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(12);
          goto _L23
_L28:
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(9);
          goto _L27
_L29:
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(14);
          goto _L27
_L30:
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(11);
          goto _L27
_L34:
        ((ImageView) (obj)).setImageResource(i);
        if (!TextUtils.isEmpty(bundle))
        {
            ((ImageView) (obj)).setScaleType(android.widget.ImageView.ScaleType.valueOf(bundle));
        }
          goto _L48
_L35:
        webview.requestLayout();
        return;
_L13:
        Bundle bundle1 = bundle;
        flag = false;
        flag1 = true;
        k = -1;
        l = -1;
        bundle = ((Bundle) (obj));
        obj = bundle1;
          goto _L49
_L42:
        if (-1 == i) goto _L47; else goto _L50
_L50:
        k = j;
        if (-1 == j)
        {
            k = i;
        }
          goto _L51
_L18:
        if (flag)
        {
            i = 0x1010288;
        } else
        {
            i = 0x1010079;
        }
          goto _L52
_L19:
        if (flag)
        {
            i = 0x1010287;
        } else
        {
            i = 0x1010077;
        }
          goto _L52
_L20:
        if (flag)
        {
            i = 0x1010289;
        } else
        {
            i = 0x101007a;
        }
          goto _L52
    }

    protected void onDestroy()
    {
        if (mSmsReceiver != null)
        {
            mSmsReceiver.unregisterMAPSmsReceiverIfRegistered(mContext);
        }
        if (mFrcCookieUrlSet != null && mFrcCookieUrlSet.size() > 0)
        {
            for (Iterator iterator = mFrcCookieUrlSet.iterator(); iterator.hasNext(); clearSpecificCookie((String)iterator.next(), "frc", "/ap", null, true)) { }
            mFrcCookieUrlSet.clear();
        }
        clearSpecificCookie(mCookieUrl, "map-md", "/ap", null, true);
        if (mTracer != null)
        {
            mTracer.finishTrace();
        }
        if (mWebView != null)
        {
            getParentLayout().removeView(mWebView);
            mWebView.removeAllViews();
            mWebView.destroy();
            mWebView = null;
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            if (mAuthenticationWebViewClient.isMFA() && mTracer != null)
            {
                MAPLog.i(TAG, "MFA canceled");
                mTracer.incrementCounter("MFACanceled");
            }
            if (mAuthenticationWebViewClient.isDCQ() && mTracer != null)
            {
                MAPLog.i(TAG, "DCQ canceled");
                mTracer.incrementCounter("DCQCanceled");
            }
            WebView webview = getWebView();
            if (webview == null)
            {
                finishOnError(AccountsCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED.value(), "An unexpected error occured while setting up the WebView."));
                return false;
            }
            if (webview.canGoBack())
            {
                keyevent = webview.copyBackForwardList();
                if (keyevent != null && keyevent.getSize() > 0)
                {
                    keyevent = keyevent.getItemAtIndex(keyevent.getCurrentIndex() - 1);
                    if (keyevent != null)
                    {
                        keyevent = keyevent.getUrl();
                        if (mSmsReceiver.shouldRegisterMAPSmsReceiver(keyevent, mContext))
                        {
                            if (webview.canGoBackOrForward(-2))
                            {
                                webview.goBackOrForward(-2);
                                return true;
                            } else
                            {
                                MAPLog.logAndReportError(TAG, mTracer, "Cannot go the the page before previous page. Something is wrong.", "SkipAutoPhoneVerificationPageError");
                                finish();
                                return false;
                            }
                        }
                    }
                }
                webview.goBack();
                return true;
            }
        }
        return super.onKeyDown(i, keyevent);
    }

    protected void onNewIntent(Intent intent)
    {
        MAPLog.i(TAG, String.format("Existing login webview called in package %s by package %s", new Object[] {
            getPackageName(), getCallingPackage()
        }));
        SecurityHelpers.checkCallingPackagePermissionsOrSystem(this);
        RemoteCallbackWrapper remotecallbackwrapper = claimResponseCallback();
        if (remotecallbackwrapper != null)
        {
            remotecallbackwrapper.onError(AccountsCallbackHelpers.getAccountManagerErrorBundle(4, "Registration canceled"));
        }
        setWindowFlagsFromIntent(intent);
        intent = parseIntentForOptionsAndRequest(intent);
        getWebView().loadUrl(intent.getRequestUrl());
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        WebView webview = getWebView();
        if (webview != null)
        {
            webview.saveState(bundle);
        }
    }

    public void safelySetUpJavascriptInterface(WebView webview, com.amazon.identity.auth.device.framework.MAPJavascriptInterface.MAPJavascriptInterfaceCallback mapjavascriptinterfacecallback)
    {
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            webview.addJavascriptInterface(new MAPJavascriptInterface(mapjavascriptinterfacecallback), "embedNotification");
        }
    }






/*
    static String access$102(AuthPortalUIActivity authportaluiactivity, String s)
    {
        authportaluiactivity.mTimeoutMetricsName = s;
        return s;
    }

*/





/*
    static Timer access$1302(AuthPortalUIActivity authportaluiactivity, Timer timer)
    {
        authportaluiactivity.mRequestTimeoutTimer = timer;
        return timer;
    }

*/


/*
    static void access$1500(AuthPortalUIActivity authportaluiactivity)
    {
        authportaluiactivity.mBarFaded = false;
        if (authportaluiactivity.mBarOn)
        {
            authportaluiactivity = (ProgressBar)authportaluiactivity.findViewById(authportaluiactivity.mProgressbarId);
            authportaluiactivity.setProgress(0);
            authportaluiactivity.setVisibility(0);
        }
        return;
    }

*/









/*
    static PlatformMetricsTimer access$2102$707f9f0f(AuthPortalUIActivity authportaluiactivity)
    {
        authportaluiactivity.mMfaChallengeCodeEnterTimer = null;
        return null;
    }

*/



/*
    static PlatformMetricsTimer access$2202$707f9f0f(AuthPortalUIActivity authportaluiactivity)
    {
        authportaluiactivity.mDcqChallengeQuestionEnterTimer = null;
        return null;
    }

*/







/*
    static void access$2800(AuthPortalUIActivity authportaluiactivity)
    {
        if (authportaluiactivity.mBarOn && !authportaluiactivity.mBarFaded)
        {
            int i = ResourceHelper.getAnimId(authportaluiactivity, "delay_fade_anim");
            android.view.animation.Animation animation = AnimationUtils.loadAnimation(authportaluiactivity.getBaseContext(), i);
            authportaluiactivity.mBarFaded = true;
            authportaluiactivity = (ProgressBar)authportaluiactivity.findViewById(authportaluiactivity.mProgressbarId);
            authportaluiactivity.startAnimation(animation);
            authportaluiactivity.setVisibility(4);
        }
        return;
    }

*/






/*
    static void access$600(AuthPortalUIActivity authportaluiactivity, WebView webview, int i)
    {
        if (android.os.Build.VERSION.SDK_INT < 17 && i > 60 && webview != null && webview.getContentHeight() > 0)
        {
            authportaluiactivity.setProgressBarProgress(100);
            authportaluiactivity.hideProgressBar();
            if (authportaluiactivity.mPageLoadToFirstRenderTimer != null)
            {
                authportaluiactivity.mPageLoadToFirstRenderTimer.stopAndDiscard();
            }
            return;
        } else
        {
            authportaluiactivity.setProgressBarProgress(i);
            return;
        }
    }

*/



/*
    static void access$800(AuthPortalUIActivity authportaluiactivity, com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE request_type, final OpenIdResponse response)
    {
        if (authportaluiactivity.mIsRegistrationInFlight.getAndSet(true)) goto _L2; else goto _L1
_L1:
        final Object sid;
        String s1;
        MetricsHelper.incrementCounter((new StringBuilder("WebViewSuccess:")).append(request_type.name()).toString(), new String[0]);
        s1 = response.getDirectedId();
        sid = authportaluiactivity.mCookieUrl;
        if (!TextUtils.isEmpty(s1) && !TextUtils.isEmpty(((CharSequence) (sid)))) goto _L4; else goto _L3
_L3:
        sid = null;
_L11:
        if (!request_type.equals(com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.CONFIRM_CREDENTIAL) && !request_type.equals(com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.AUTHENTICATE)) goto _L6; else goto _L5
_L5:
        if (!authportaluiactivity.isEnsureAccountStateFlow()) goto _L8; else goto _L7
_L7:
        request_type = authportaluiactivity.claimResponseCallback();
        response = new Bundle();
        response.putStringArrayList("EnsureAccountStateAttributes", authportaluiactivity.mOptions.getStringArrayList("EnsureAccountStateAttributes"));
        authportaluiactivity.returnSuccess(response, request_type);
_L2:
        return;
_L4:
        sid = WebViewCookieUtils.getCookieFromCookieManager(authportaluiactivity.mContext, s1, ((String) (sid)), "sid");
        if (sid == null)
        {
            sid = null;
        } else
        {
            String s = ((Cookie) (sid)).getValue();
            sid = s;
            if (TextUtils.isEmpty(s))
            {
                sid = null;
            }
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (!TextUtils.isEmpty(((CharSequence) (sid))))
        {
            authportaluiactivity.mBackwardsCompatiableDataStorage.setToken(s1, "com.amazon.dcp.sso.token.cookie.sid", ((String) (sid)));
        }
        request_type = authportaluiactivity.claimResponseCallback();
        sid = new Bundle();
        ((Bundle) (sid)).putString("com.amazon.dcp.sso.property.account.acctId", response.getDirectedId());
        ((Bundle) (sid)).putString("com.amazon.dcp.sso.AddAccount.options.AccessToken", response.getAccessToken().toString());
        authportaluiactivity.returnSuccess(((Bundle) (sid)), request_type);
        return;
_L6:
        final RemoteCallbackWrapper callbackWrapper;
        if (authportaluiactivity.mOptions != null)
        {
            request_type = authportaluiactivity.mOptions;
        } else
        {
            request_type = new Bundle();
        }
        request_type.putString("com.amazon.dcp.sso.AddAccount.options.AccessToken", response.getAccessToken().toString());
        callbackWrapper = request_type.getString("registration_domain");
        if (!TextUtils.isEmpty(callbackWrapper))
        {
            MAPLog.i(TAG, (new StringBuilder("Passing domain ")).append(callbackWrapper).append(" to registerAccount from registerAccountWithUI").toString());
            request_type.putString("com.amazon.identity.ap.domain", callbackWrapper);
        }
        request_type.putString("registration_domain", null);
        request_type.putBoolean("com.amazon.identity.auth.device.accountManager.newaccount", response.isNewAccount().booleanValue());
        if (!TextUtils.isEmpty(((CharSequence) (sid))))
        {
            request_type.putString("sid_cookie_value", ((String) (sid)));
        }
        if (authportaluiactivity.mAmazonAccountManager.doesAccountExistAfterDeregisteringStateCleanup(s1))
        {
            MAPLog.i(TAG, "Fast failing since account already exists");
            authportaluiactivity.finishOnError(AccountsCallbackHelpers.getAccountAlreadyExistsErrorBundle(s1));
            return;
        }
        callbackWrapper = authportaluiactivity.claimResponseCallback();
        if (callbackWrapper == null) goto _L2; else goto _L9
_L9:
        authportaluiactivity.mMapAccountManager.registerAccount(RegistrationType.FROM_ACCESS_TOKEN, request_type, authportaluiactivity. new _cls4());
        return;
        if (true) goto _L11; else goto _L10
_L10:
        return;
    }

*/

}
