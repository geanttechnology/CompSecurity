// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import android.app.Activity;
import android.content.Context;
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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.amazon.android.webkit.AmazonWebChromeClient;
import com.amazon.android.webkit.AmazonWebSettings;
import com.amazon.android.webkit.AmazonWebView;
import com.amazon.identity.auth.accounts.AccountsCallbackHelpers;
import com.amazon.identity.auth.accounts.AmazonAccountManager;
import com.amazon.identity.auth.device.api.AmazonWebViewUtils;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.DeviceDataStore;
import com.amazon.identity.auth.device.api.DeviceDataStoreException;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.api.RegistrationType;
import com.amazon.identity.auth.device.callback.RemoteCallbackWrapper;
import com.amazon.identity.auth.device.endpoint.OpenIdRequest;
import com.amazon.identity.auth.device.endpoint.OpenIdResponse;
import com.amazon.identity.auth.device.endpoint.TokenRequestHelpers;
import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.storage.BackwardsCompatiableDataStorage;
import com.amazon.identity.auth.device.token.AccessToken;
import com.amazon.identity.auth.device.token.MAPCookie;
import com.amazon.identity.auth.device.token.TokenCallbackHelpers;
import com.amazon.identity.auth.device.utils.AmazonWebviewCookieUtils;
import com.amazon.identity.auth.device.utils.CookieUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ReflectionHelper;
import com.amazon.identity.auth.device.utils.ResourceHelper;
import com.amazon.identity.auth.device.utils.SecurityHelpers;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import com.amazon.identity.platform.metric.MetricUtils;
import com.amazon.identity.platform.metric.MetricsHelper;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.cookie.Cookie;

// Referenced classes of package com.amazon.identity.auth.device:
//            AuthenticationWebViewClient

public class AuthPortalUIActivity extends Activity
{
    private class _cls3
        implements Callback
    {

        final AuthPortalUIActivity this$0;
        final OpenIdResponse val$response;
        final String val$sid;

        public void onError(Bundle bundle)
        {
            finishOnError(bundle);
        }

        public void onSuccess(Bundle bundle)
        {
            String s = bundle.getString("com.amazon.dcp.sso.property.account.acctId");
            if (s != null) goto _L2; else goto _L1
_L1:
            MAPLog.w(AuthPortalUIActivity.TAG, "directedId returned from registration was null. Not setting Auth Portal domain.");
_L4:
            bundle.putBoolean("com.amazon.identity.auth.device.accountManager.newaccount", response.isNewAccount().booleanValue());
            returnSuccess(bundle);
            return;
_L2:
            MAPLog.i(AuthPortalUIActivity.TAG, (new StringBuilder("Account registered with domain: ")).append(mUrlHost).toString());
            mBackwardsCompatiableDataStorage.setUserData(s, "authDomain", mUrlHost);
            if (!TextUtils.isEmpty(sid))
            {
                mBackwardsCompatiableDataStorage.setToken(s, "com.amazon.dcp.sso.token.cookie.sid", sid);
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        _cls3()
        {
            this$0 = AuthPortalUIActivity.this;
            sid = s;
            response = openidresponse;
            super();
        }
    }

    public static final class AuthPortalUIActivityOptions
    {

        public static final String KEY_DIRECTEDID = "directedid";
        public static final String KEY_REQUEST_TYPE = "requestType";
        public static final String KEY_SESSIONID = "com.amazon.identity.sessionid";
        public static final String KEY_UBID = "com.amazon.identity.ubid";

        public AuthPortalUIActivityOptions()
        {
        }
    }

    private class TimeoutTimerTask extends TimerTask
    {

        final AuthPortalUIActivity this$0;

        public void run()
        {
            String s = (new StringBuilder()).append(mTimeoutMetricsName).append(":NetworkState:").append(MetricUtils.isNetworkAvailable(mContext)).toString();
            mTracer.incrementCounter(s);
            finishOnError(AccountsCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.NETWORK_FAILURE.value(), "Unable to render content. Request timed out."));
        }

        private TimeoutTimerTask()
        {
            this$0 = AuthPortalUIActivity.this;
            super();
        }

    }


    public static final String EMPTY_SID_COOKIE_VALUE_METRIC_NAME = "EmptySidCookieValue";
    public static final String KEY_IS_WARM_SEAT_AUTHENTICATION = "isWarmSeatAuthentication";
    public static final String MFA_SID_COOKIE_NAME = "sid";
    private static final String TAG = com/amazon/identity/auth/device/AuthPortalUIActivity.getName();
    private AmazonAccountManager mAmazonAccountManager;
    private AuthenticationWebViewClient mAuthenticationWebViewClient;
    private PlatformMetricsTimer mBackPressedTimer;
    private BackwardsCompatiableDataStorage mBackwardsCompatiableDataStorage;
    private boolean mBarFade;
    private boolean mBarFaded;
    private boolean mBarOn;
    private Context mContext;
    private String mCookieUrl;
    private PlatformMetricsTimer mDcqChallengeQuestionEnterTimer;
    private boolean mDismissSpinnerEarly;
    private PlatformMetricsTimer mFirstOnPageStartedTimer;
    private PlatformMetricsTimer mFirstPageLoadTimer;
    private AtomicBoolean mIsRegistrationInFlight;
    private MAPAccountManager mMapAccountManager;
    private PlatformMetricsTimer mMfaChallengeCodeEnterTimer;
    private Bundle mOptions;
    private PlatformMetricsTimer mPageLoadToFirstRenderTimer;
    private PlatformWrapper mPlatform;
    private int mProgressbarId;
    private Timer mRequestTimeoutTimer;
    private RemoteCallbackWrapper mResponse;
    private String mTimeoutMetricsName;
    private Tracer mTracer;
    private String mUrlHost;
    private AmazonWebView mWebView;

    public AuthPortalUIActivity()
    {
        mFirstOnPageStartedTimer = null;
        mFirstPageLoadTimer = null;
        mPageLoadToFirstRenderTimer = null;
        mBackPressedTimer = null;
        mDismissSpinnerEarly = true;
        mIsRegistrationInFlight = new AtomicBoolean(false);
    }

    private void closeActivity()
    {
        mIsRegistrationInFlight.set(false);
        super.finish();
    }

    private void finishOnError(final Bundle errorBundle)
    {
        ThreadUtils.runOffMainThread(new Runnable() );
    }

    private String getClientId()
    {
        String s;
        try
        {
            s = DeviceDataStore.getInstance(mContext).getValue("Client Id");
        }
        catch (DeviceDataStoreException devicedatastoreexception)
        {
            MAPLog.e(TAG, "Cannot fetch dsn from the DeviceDataStore.", devicedatastoreexception);
            return null;
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
                android.text.TextUtils.SimpleStringSplitter simplestringsplitter = new SimpleStringSplitter(',');
                simplestringsplitter.setString(s);
                do
                {
                    if (!simplestringsplitter.hasNext())
                    {
                        break;
                    }
                    String s1 = simplestringsplitter.next();
                    android.text.TextUtils.SimpleStringSplitter simplestringsplitter1 = new SimpleStringSplitter('=');
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

    private com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE getRequestTypeFromIntent()
    {
        com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE request_type;
        Object obj;
        request_type = com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.SIGN_IN;
        obj = getIntent();
        if (obj == null)
        {
            return request_type;
        }
        obj = ((Intent) (obj)).getExtras();
        if (obj == null)
        {
            return request_type;
        }
        obj = ((Bundle) (obj)).getString("requestType");
        if (obj == null)
        {
            return request_type;
        }
        if (!com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.REGISTER.toString().equalsIgnoreCase(((String) (obj)))) goto _L2; else goto _L1
_L1:
        request_type = com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.REGISTER;
_L4:
        return request_type;
_L2:
        if (com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.SIGN_IN.toString().equalsIgnoreCase(((String) (obj))))
        {
            request_type = com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.SIGN_IN;
        } else
        if (com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.CONFIRM_CREDENTIAL.toString().equalsIgnoreCase(((String) (obj))))
        {
            request_type = com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.CONFIRM_CREDENTIAL;
        } else
        if (com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.AUTHENTICATE.toString().equalsIgnoreCase(((String) (obj))))
        {
            request_type = com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.AUTHENTICATE;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private AmazonWebView getWebView()
    {
        if (mWebView != null)
        {
            return mWebView;
        }
        int i = ResourceHelper.getId(this, "apwebview");
        mWebView = AmazonWebViewUtils.getAmazonWebViewFromView(findViewById(i), mContext);
        if (mWebView != null)
        {
            return mWebView;
        } else
        {
            MAPLog.e(TAG, String.format("Unexpected Error Occured. Webview returned from AmazonWebViewUtils getAmazonWebViewFromView method for view Id %d", new Object[] {
                Integer.valueOf(i)
            }));
            return null;
        }
    }

    private void hideProgressBar()
    {
        if (mAuthenticationWebViewClient.isMFA() && mMfaChallengeCodeEnterTimer == null)
        {
            String s = TAG;
            mMfaChallengeCodeEnterTimer = mTracer.startTimer("MFA:ChallengeCodeEnterTime");
        }
        if (mAuthenticationWebViewClient.isDCQ() && mDcqChallengeQuestionEnterTimer == null)
        {
            String s1 = TAG;
            mDcqChallengeQuestionEnterTimer = mTracer.startTimer("DCQ:ChallengeQuestionEnterTime");
        }
        mRequestTimeoutTimer.cancel();
        ProgressBar progressbar = (ProgressBar)findViewById(mProgressbarId);
        if (progressbar.getVisibility() == 0)
        {
            if (mBarFade && mBarOn && !mBarFaded)
            {
                int i = ResourceHelper.getAnimId(this, "delay_fade_anim");
                final Animation delayFadeAnimation = AnimationUtils.loadAnimation(getBaseContext(), i);
                mBarFaded = true;
                ThreadUtils.runOnMainThread(new Runnable() {

                    final AuthPortalUIActivity this$0;
                    final Animation val$delayFadeAnimation;

                    public void run()
                    {
                        ProgressBar progressbar1 = (ProgressBar)findViewById(mProgressbarId);
                        progressbar1.startAnimation(delayFadeAnimation);
                        progressbar1.setVisibility(4);
                    }

            
            {
                this$0 = AuthPortalUIActivity.this;
                delayFadeAnimation = animation;
                super();
            }
                });
            }
            if (mBarOn)
            {
                progressbar.setVisibility(4);
            }
        }
    }

    private void returnSuccess(final Bundle result)
    {
        ThreadUtils.runOffMainThread(new Runnable() );
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

    private void setupWebChromeClient(AmazonWebView amazonwebview)
    {
        amazonwebview.setWebChromeClient(new AmazonWebChromeClient() {

            final AuthPortalUIActivity this$0;

            public void onProgressChanged(AmazonWebView amazonwebview1, int i)
            {
                AuthPortalUIActivity.access$400(AuthPortalUIActivity.this, amazonwebview1, i);
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
            String s = TAG;
            finishOnError(AccountsCallbackHelpers.getAccountManagerErrorBundle(4, "Registration canceled"));
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
            onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        onConfigurationChanged(configuration);
        try
        {
            configuration = getWebView();
        }
        // Misplaced declaration of an exception variable
        catch (Configuration configuration)
        {
            String s = TAG;
            (new StringBuilder("Android Resource error: ")).append(configuration.getMessage()).toString();
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
        Object obj;
        MAPLog.i(TAG, String.format("Login webview called in package %s by package %s", new Object[] {
            getPackageName(), getCallingPackage()
        }));
        SecurityHelpers.checkCallingPackagePermissionsOrSystem(this);
        obj = getIntent();
        if (obj == null) goto _L2; else goto _L1
_L1:
        mOptions = ((Intent) (obj)).getExtras();
        mTracer = Tracer.createFromIntent(((Intent) (obj)), "MAP_AuthPortalUIActivity");
_L6:
        mContext = ServiceWrappingContext.create(getApplicationContext());
        mMapAccountManager = new MAPAccountManager(mContext);
        mAmazonAccountManager = new AmazonAccountManager(mContext);
        mPlatform = (PlatformWrapper)mContext.getSystemService("sso_platform");
        mBackwardsCompatiableDataStorage = new BackwardsCompatiableDataStorage(mContext);
        getWindow().addFlags(0x10000);
        getWindow().addFlags(256);
        requestWindowFeature(1);
        onCreate(bundle);
        if (mOptions == null) goto _L4; else goto _L3
_L3:
        mResponse = (RemoteCallbackWrapper)mOptions.getParcelable("callback");
        mOptions.remove("callback");
        obj = mOptions;
        if (obj == null) goto _L4; else goto _L5
_L5:
        Object obj1;
        int i;
        if (!((Bundle) (obj)).containsKey("AuthPortalActivityUIOptions.amazonScreenModes"))
        {
            break MISSING_BLOCK_LABEL_285;
        }
        i = ((Bundle) (obj)).getInt("AuthPortalActivityUIOptions.amazonScreenModes");
        obj1 = getWindow().getDecorView();
        (new ReflectionHelper()).invokeStatic("setAmazonSystemUi", "com.amazon.android.view.AmazonScreenModes", new Class[] {
            android/view/View, Integer.TYPE
        }, new Object[] {
            obj1, Integer.valueOf(i)
        });
_L7:
        if (((Bundle) (obj)).getBoolean("AuthPortalActivityUIOptions.aboveLockScreen"))
        {
            getWindow().addFlags(0x80000);
        }
        if (((Bundle) (obj)).containsKey("AuthPortalActivityUIOptions.requestedOrientation"))
        {
            setRequestedOrientation(((Bundle) (obj)).getInt("AuthPortalActivityUIOptions.requestedOrientation"));
        }
        if (((Bundle) (obj)).getBoolean("AuthPortalActivityUIOptions.fullscreen"))
        {
            getWindow().addFlags(1024);
        }
_L4:
        if (TextUtils.isEmpty(getClientId()))
        {
            finishOnError(AccountsCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED.value(), "An unexpected error occured while setting up the WebView. Cannot fetch client id!"));
            return;
        }
        break MISSING_BLOCK_LABEL_436;
_L2:
        MAPLog.e(TAG, "The intent in AuthPortalUIActivity is null! This should be a bug!");
          goto _L6
        com.amazon.identity.auth.device.utils.ReflectionHelper.CannotCallMethodException cannotcallmethodexception;
        cannotcallmethodexception;
        MAPLog.w(TAG, "Unable to set AmazonScreenModes. Could not invoke com.amazon.android.view.AmazonScreenModes.setAmazonSystemUi() from the Amazon SDK.");
          goto _L7
        OpenIdRequest openidrequest;
        openidrequest = new OpenIdRequest(getClientId(), getRequestTypeFromIntent(), mOptions);
        mUrlHost = openidrequest.getHost();
        setContentView(ResourceHelper.getLayoutId(this, "apwebviewlayout"));
        cannotcallmethodexception = getWebView();
        if (cannotcallmethodexception != null) goto _L9; else goto _L8
_L8:
        cannotcallmethodexception = null;
_L10:
        if (cannotcallmethodexception == null)
        {
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
        break MISSING_BLOCK_LABEL_626;
_L9:
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_538;
        }
        cannotcallmethodexception.restoreState(bundle);
        cannotcallmethodexception.setScrollBarStyle(0);
        bundle = cannotcallmethodexception.getSettings();
        bundle.setSavePassword(false);
        bundle.setSaveFormData(false);
        bundle.setRenderPriority(com.amazon.android.webkit.AmazonWebSettings.RenderPriority.HIGH);
        cannotcallmethodexception.clearFormData();
        cannotcallmethodexception.getSettings().setJavaScriptEnabled(true);
        bundle = new AuthenticationWebViewClient.AuthenticationWebViewClientCallback() {

            final AuthPortalUIActivity this$0;

            public void onCodeEnterFinished()
            {
                String _tmp = AuthPortalUIActivity.TAG;
                if (mAuthenticationWebViewClient.isMFA() && mMfaChallengeCodeEnterTimer != null)
                {
                    String _tmp1 = AuthPortalUIActivity.TAG;
                    mMfaChallengeCodeEnterTimer.stopAndDiscard();
                    mMfaChallengeCodeEnterTimer = null;
                }
                if (mAuthenticationWebViewClient.isDCQ() && mDcqChallengeQuestionEnterTimer != null)
                {
                    String _tmp2 = AuthPortalUIActivity.TAG;
                    mDcqChallengeQuestionEnterTimer.stopAndDiscard();
                    mDcqChallengeQuestionEnterTimer = null;
                }
            }

            public void onPageFinished()
            {
                int i1 = ResourceHelper.getId(AuthPortalUIActivity.this, "apimageview");
                ImageView imageview = (ImageView)findViewById(i1);
                AmazonWebView amazonwebview = getWebView();
                if (amazonwebview == null)
                {
                    finishOnError(AccountsCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED.value(), "An unexpected error occured while setting up the WebView."));
                } else
                {
                    if (imageview.getVisibility() == 0)
                    {
                        imageview.setVisibility(8);
                    }
                    if (amazonwebview.getVisibility() != 0)
                    {
                        amazonwebview.setVisibility(0);
                        amazonwebview.requestFocusFromTouch();
                    }
                    setProgressBarProgress(100);
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
                if (mFirstOnPageStartedTimer != null)
                {
                    mFirstOnPageStartedTimer.stopAndDiscard();
                }
                s1 = (new StringBuilder("AuthPortalPageTimeout:")).append(getRequestTypeFromIntent().name()).toString();
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
                mRequestTimeoutTimer.schedule(new TimeoutTimerTask(), 0x3d090L);
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
                cancel();
                finishOnError(bundle2);
            }

            public void setResult(OpenIdResponse openidresponse)
            {
                AuthPortalUIActivity.access$500(AuthPortalUIActivity.this, openidresponse);
            }

            
            {
                this$0 = AuthPortalUIActivity.this;
                super();
            }
        };
        mAuthenticationWebViewClient = new AuthenticationWebViewClient(openidrequest.getRequestType(), openidrequest.getReturnToUrl(), com.amazon.identity.auth.device.endpoint.OpenIdRequest.TOKEN_SCOPE.ACCESS, bundle, mTracer);
        cannotcallmethodexception.setWebViewClient(mAuthenticationWebViewClient);
          goto _L10
        mCookieUrl = openidrequest.getCookieUrl();
        bundle = mCookieUrl;
        AmazonWebviewCookieUtils.setCookie(mContext, bundle, "sid", "", "/", CookieUtils.getNonExpiringCookieExpiresString(), true, true);
        bundle = mCookieUrl;
        obj = mOptions.getString("directedid");
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            obj = mBackwardsCompatiableDataStorage.getToken(((String) (obj)), "com.amazon.dcp.sso.token.cookie.sid");
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                AmazonWebviewCookieUtils.setCookie(mContext, bundle, "sid", ((String) (obj)), "/", CookieUtils.getNonExpiringCookieExpiresString(), true, true);
            }
        }
        if (!getRequestTypeFromIntent().equals(com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.AUTHENTICATE)) goto _L12; else goto _L11
_L11:
        boolean flag = mOptions.getBoolean("isWarmSeatAuthentication", false);
_L56:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_766;
        }
        openidrequest.setMaxAuthAge("0");
        openidrequest.setIgnoreAuthCookiesOnResponse(true);
        if (openidrequest.getRequestType() != com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.CONFIRM_CREDENTIAL) goto _L14; else goto _L13
_L13:
        if (!mPlatform.isOtter()) goto _L16; else goto _L15
_L15:
        Object obj2 = mBackwardsCompatiableDataStorage.getToken(mOptions.getString("directedid"), "com.amazon.dcp.sso.token.cookie.xmain");
        if (!TextUtils.isEmpty(((CharSequence) (obj2)))) goto _L18; else goto _L17
_L17:
        finishOnError(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED, "X-MAIN should exist. There is likely a registration bug."));
_L43:
        obj2 = mOptions;
        bundle = com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ProgressBarState.OFF;
        obj = com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ScreenPosition.BOTTOM_CENTER;
        mBarFade = true;
        int j;
        i = -1;
        j = -1;
        if (obj2 == null) goto _L20; else goto _L19
_L19:
        Object obj3 = ((Bundle) (obj2)).getString("progressbar_state");
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_881;
        }
        bundle = com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ProgressBarState.get(((String) (obj3)));
        obj3 = ((Bundle) (obj2)).getString("progressbar_position");
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_902;
        }
        obj = com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ScreenPosition.get(((String) (obj3)));
        int k;
        int l;
        boolean flag1;
        mBarFade = ((Bundle) (obj2)).getBoolean("progressbar_fade", mBarFade);
        flag1 = ((Bundle) (obj2)).getBoolean("progressbar_stretch", true);
        flag = ((Bundle) (obj2)).getBoolean("progressbar_invert_spinner", false);
        l = ((Bundle) (obj2)).getInt("progressbar_resource", -1);
        k = ((Bundle) (obj2)).getInt("progressbar_background_resource", -1);
        i = ((Bundle) (obj2)).getInt("progressbar_primary_color", -1);
        j = ((Bundle) (obj2)).getInt("progressbar_secondary_color", -1);
        obj2 = obj;
        obj = bundle;
        bundle = ((Bundle) (obj2));
_L55:
        mProgressbarId = ResourceHelper.getId(this, "approgressbar");
        obj2 = (ProgressBar)findViewById(mProgressbarId);
        obj3 = (android.widget.RelativeLayout.LayoutParams)((ProgressBar) (obj2)).getLayoutParams();
        static class _cls7
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

        _cls7..SwitchMap.com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ProgressBarState[((com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ProgressBarState) (obj)).ordinal()];
        JVM INSTR tableswitch 1 2: default 2004
    //                   1 1708
    //                   2 1874;
           goto _L21 _L22 _L23
_L21:
        mBarOn = true;
        i = 0;
        _cls7..SwitchMap.com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ProgressBarState[((com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ProgressBarState) (obj)).ordinal()];
        JVM INSTR tableswitch 3 5: default 2007
    //                   3 2056
    //                   4 2077
    //                   5 2098;
           goto _L24 _L25 _L26 _L27
_L24:
        MAPLog.e(TAG, "Bar State not recongized");
_L59:
        obj3.width = -2;
        ((ProgressBar) (obj2)).setVisibility(8);
        obj = new ProgressBar(this, null, i);
        getParentLayout().addView(((View) (obj)));
        i = ResourceHelper.getId(this, "apspinner_progressbar");
        ((ProgressBar) (obj)).setId(i);
        mProgressbarId = i;
        setupWebChromeClient(cannotcallmethodexception);
_L51:
        if (!mBarOn) goto _L29; else goto _L28
_L28:
        obj2 = TAG;
        bundle.getValue();
        _cls7..SwitchMap.com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ScreenPosition[bundle.ordinal()];
        JVM INSTR tableswitch 1 9: default 2010
    //                   1 1892
    //                   2 1892
    //                   3 1892
    //                   4 1902
    //                   5 1902
    //                   6 1902
    //                   7 1912
    //                   8 1912
    //                   9 1912;
           goto _L30 _L31 _L31 _L31 _L32 _L32 _L32 _L33 _L33 _L33
_L30:
        _cls7..SwitchMap.com.amazon.identity.auth.device.api.MAPAccountManager.AuthPortalActivityUIOptions.ScreenPosition[bundle.ordinal()];
        JVM INSTR tableswitch 1 9: default 2013
    //                   1 1922
    //                   2 1932
    //                   3 1942
    //                   4 1922
    //                   5 1932
    //                   6 1942
    //                   7 1922
    //                   8 1932
    //                   9 1942;
           goto _L34 _L35 _L36 _L37 _L35 _L36 _L37 _L35 _L36 _L37
_L34:
        ((ProgressBar) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj3)));
        ((ProgressBar) (obj)).bringToFront();
_L29:
        obj2 = mOptions;
        i = -1;
        bundle = null;
        obj = (ImageView)findViewById(ResourceHelper.getId(this, "apimageview"));
        if (obj2 == null) goto _L39; else goto _L38
_L38:
        i = ((Bundle) (obj2)).getInt("splashscreen_resource", -1);
        bundle = ((Bundle) (obj2)).getString("splashscreen_scale_type");
_L39:
        if (-1 != i) goto _L41; else goto _L40
_L40:
        ((ImageView) (obj)).setVisibility(8);
        cannotcallmethodexception.setVisibility(0);
        cannotcallmethodexception.requestFocusFromTouch();
_L54:
        if (TextUtils.isEmpty(cannotcallmethodexception.getUrl()))
        {
            openidrequest.setDebugParams(getDebugParameters());
            bundle = openidrequest.getRequestUrl();
            obj = TAG;
            mFirstOnPageStartedTimer = mTracer.startTimer((new StringBuilder("AuthPortalUIActivity_FirstOnPageStarted:")).append(MetricUtils.getAuthPortalUrlPathAndDomain(bundle)).toString());
            mFirstPageLoadTimer = mTracer.startTimer((new StringBuilder("AuthPortalUIActivity_FirstPageLoad:")).append(MetricUtils.getAuthPortalUrlPathAndDomain(bundle)).toString());
            mPageLoadToFirstRenderTimer = mTracer.startTimer((new StringBuilder("AuthPortalUIActivity_FirstPageRender:")).append(MetricUtils.getAuthPortalUrlPathAndDomain(bundle)).toString());
            mBackPressedTimer = mTracer.startTimer((new StringBuilder("AuthPortalUIActivity_BackPressedInWebView:")).append(MetricUtils.getAuthPortalUrlPathAndDomain(bundle)).toString());
            mDismissSpinnerEarly = true;
            cannotcallmethodexception.loadUrl(bundle);
            return;
        }
          goto _L42
_L18:
        if (openidrequest.getHost().contains("development.amazon.com"))
        {
            bundle = "x-tacbus";
            obj = "development.amazon.com";
        } else
        {
            bundle = "x-main";
            obj = ".amazon.com";
        }
        bundle = new MAPCookie(bundle, ((String) (obj2)), ((String) (obj)), CookieUtils.getNonExpiringCookieExpiresString(), "/", null, false, false);
        openidrequest.setClaimedId("http://www.amazon.com/ap/specs/auth/confirm_credentials");
        AmazonWebviewCookieUtils.setCookie(mContext, openidrequest.getRequestUrl(), bundle);
_L44:
        openidrequest.setMaxAuthAge("0");
        openidrequest.setDisableLoginPrepopulate("0");
          goto _L43
_L16:
        bundle = new StringBuilder();
        bundle.append(TokenRequestHelpers.getRequestUrlSchemeAndAuthority(mOptions, com.amazon.identity.auth.device.endpoint.TokenRequestHelpers.PROTOCOL.HTTPS, openidrequest.getHost()));
        bundle.append("/ap/id/");
        bundle.append(mOptions.get("directedid"));
        openidrequest.setClaimedId(bundle.toString());
          goto _L44
_L14:
        openidrequest.setDisableLoginPrepopulate("1");
          goto _L43
_L22:
        mBarOn = true;
        if (!flag1) goto _L46; else goto _L45
_L45:
        obj3.width = -1;
_L52:
        if (-1 == l) goto _L48; else goto _L47
_L47:
        obj = getResources().getDrawable(l);
        ((ProgressBar) (obj2)).setProgressDrawable(new ClipDrawable(((Drawable) (obj)), 3, 1));
        if (-1 == k) goto _L50; else goto _L49
_L49:
        ((ProgressBar) (obj2)).setBackgroundDrawable(getResources().getDrawable(k));
_L50:
        obj3.width = ((Drawable) (obj)).getMinimumWidth();
_L53:
        setupWebChromeClient(cannotcallmethodexception);
        obj = obj2;
          goto _L51
_L46:
        obj3.width = -2;
          goto _L52
_L58:
        obj = new GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, new int[] {
            i, k
        });
        ((GradientDrawable) (obj)).setShape(0);
        ((GradientDrawable) (obj)).setCornerRadius(5F);
        ((ProgressBar) (obj2)).setProgressDrawable(new ClipDrawable(((Drawable) (obj)), 3, 1));
        ((ProgressBar) (obj2)).setBackgroundDrawable(getResources().getDrawable(0x108006c));
          goto _L53
_L23:
        mBarOn = false;
        ((ProgressBar) (obj2)).setVisibility(8);
        obj = obj2;
          goto _L51
_L31:
        ((android.widget.RelativeLayout.LayoutParams) (obj3)).addRule(10);
          goto _L30
_L32:
        ((android.widget.RelativeLayout.LayoutParams) (obj3)).addRule(15);
          goto _L30
_L33:
        ((android.widget.RelativeLayout.LayoutParams) (obj3)).addRule(12);
          goto _L30
_L35:
        ((android.widget.RelativeLayout.LayoutParams) (obj3)).addRule(9);
          goto _L34
_L36:
        ((android.widget.RelativeLayout.LayoutParams) (obj3)).addRule(14);
          goto _L34
_L37:
        ((android.widget.RelativeLayout.LayoutParams) (obj3)).addRule(11);
          goto _L34
_L41:
        ((ImageView) (obj)).setImageResource(i);
        if (!TextUtils.isEmpty(bundle))
        {
            ((ImageView) (obj)).setScaleType(android.widget.ImageView.ScaleType.valueOf(bundle));
        }
          goto _L54
_L42:
        cannotcallmethodexception.requestLayout();
        return;
_L20:
        Bundle bundle1 = bundle;
        flag = false;
        flag1 = true;
        k = -1;
        l = -1;
        bundle = ((Bundle) (obj));
        obj = bundle1;
          goto _L55
_L12:
        flag = false;
          goto _L56
_L48:
        if (-1 == i) goto _L53; else goto _L57
_L57:
        k = j;
        if (-1 == j)
        {
            k = i;
        }
          goto _L58
_L25:
        if (flag)
        {
            i = 0x1010288;
        } else
        {
            i = 0x1010079;
        }
          goto _L59
_L26:
        if (flag)
        {
            i = 0x1010287;
        } else
        {
            i = 0x1010077;
        }
          goto _L59
_L27:
        if (flag)
        {
            i = 0x1010289;
        } else
        {
            i = 0x101007a;
        }
          goto _L59
    }

    protected void onDestroy()
    {
        String s = TAG;
        mTracer.finishTrace();
        super.onDestroy();
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
            if (mAuthenticationWebViewClient.isMFA())
            {
                MAPLog.i(TAG, "MFA canceled");
                mTracer.incrementCounter("MFACanceled");
            }
            if (mAuthenticationWebViewClient.isDCQ())
            {
                MAPLog.i(TAG, "DCQ canceled");
                mTracer.incrementCounter("DCQCanceled");
            }
            AmazonWebView amazonwebview = getWebView();
            if (amazonwebview == null)
            {
                finishOnError(AccountsCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED.value(), "An unexpected error occured while setting up the WebView."));
                return false;
            }
            if (amazonwebview.canGoBack())
            {
                amazonwebview.goBack();
                return true;
            }
        }
        return super.onKeyDown(i, keyevent);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        getWebView().saveState(bundle);
    }




/*
    static String access$002(AuthPortalUIActivity authportaluiactivity, String s)
    {
        authportaluiactivity.mTimeoutMetricsName = s;
        return s;
    }

*/




/*
    static Timer access$1002(AuthPortalUIActivity authportaluiactivity, Timer timer)
    {
        authportaluiactivity.mRequestTimeoutTimer = timer;
        return timer;
    }

*/


/*
    static void access$1200(AuthPortalUIActivity authportaluiactivity)
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
    static PlatformMetricsTimer access$1902(AuthPortalUIActivity authportaluiactivity, PlatformMetricsTimer platformmetricstimer)
    {
        authportaluiactivity.mMfaChallengeCodeEnterTimer = platformmetricstimer;
        return platformmetricstimer;
    }

*/




/*
    static PlatformMetricsTimer access$2002(AuthPortalUIActivity authportaluiactivity, PlatformMetricsTimer platformmetricstimer)
    {
        authportaluiactivity.mDcqChallengeQuestionEnterTimer = platformmetricstimer;
        return platformmetricstimer;
    }

*/






/*
    static RemoteCallbackWrapper access$2500(AuthPortalUIActivity authportaluiactivity)
    {
        RemoteCallbackWrapper remotecallbackwrapper = authportaluiactivity.mResponse;
        authportaluiactivity.mResponse = null;
        return remotecallbackwrapper;
    }

*/




/*
    static void access$400(AuthPortalUIActivity authportaluiactivity, AmazonWebView amazonwebview, int i)
    {
        if (i > 60 && amazonwebview != null && amazonwebview.getContentHeight() > 0 && authportaluiactivity.mDismissSpinnerEarly)
        {
            authportaluiactivity.mDismissSpinnerEarly = false;
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
    static void access$500(AuthPortalUIActivity authportaluiactivity, final OpenIdResponse response)
    {
        final Object sid;
        Object obj;
        String s;
        Object obj1;
        obj = null;
        if (authportaluiactivity.mIsRegistrationInFlight.getAndSet(true))
        {
            authportaluiactivity = TAG;
            return;
        }
        MetricsHelper.increasePeriodicCounter((new StringBuilder("WebViewSuccess:")).append(authportaluiactivity.getRequestTypeFromIntent().name()).toString(), new String[0]);
        s = response.getDirectedId();
        obj1 = authportaluiactivity.mCookieUrl;
        sid = obj;
        if (TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        if (!TextUtils.isEmpty(((CharSequence) (obj1)))) goto _L4; else goto _L3
_L3:
        sid = obj;
_L2:
        if (authportaluiactivity.getRequestTypeFromIntent().equals(com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.CONFIRM_CREDENTIAL) || authportaluiactivity.getRequestTypeFromIntent().equals(com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.AUTHENTICATE))
        {
            if (!TextUtils.isEmpty(((CharSequence) (sid))))
            {
                authportaluiactivity.mBackwardsCompatiableDataStorage.setToken(s, "com.amazon.dcp.sso.token.cookie.sid", ((String) (sid)));
            }
            sid = new Bundle();
            ((Bundle) (sid)).putString("com.amazon.dcp.sso.property.account.acctId", response.getDirectedId());
            ((Bundle) (sid)).putString("com.amazon.dcp.sso.AddAccount.options.AccessToken", response.getAccessToken().toString());
            authportaluiactivity.returnSuccess(((Bundle) (sid)));
            return;
        }
        break; /* Loop/switch isn't completed */
_L4:
        obj1 = AmazonWebviewCookieUtils.getCookieFromCookieManager(authportaluiactivity.mContext, s, ((String) (obj1)), "sid");
        sid = obj;
        if (obj1 != null)
        {
            sid = ((Cookie) (obj1)).getValue();
            if (TextUtils.isEmpty(((CharSequence) (sid))))
            {
                MAPLog.e(TAG, "sid cookie returned from Authportal but the value was empty. This should not happen, please open a contact with the MAP team. ref: SIM MFASettings-51");
                MetricsHelper.increasePeriodicCounter("EmptySidCookieValue:InsideCookieFromCookieManager", new String[0]);
                sid = obj;
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
        Bundle bundle;
        if (authportaluiactivity.mOptions != null)
        {
            bundle = authportaluiactivity.mOptions;
        } else
        {
            bundle = new Bundle();
        }
        bundle.putString("com.amazon.dcp.sso.AddAccount.options.AccessToken", response.getAccessToken().toString());
        if (authportaluiactivity.mAmazonAccountManager.doesAccountExistAfterDeregisteringStateCleanup(s))
        {
            MAPLog.i(TAG, "Fast failing since account already exists");
            authportaluiactivity.finishOnError(AccountsCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.ACCOUNT_ALREADY_EXISTS.value(), "Account already exists"));
            return;
        } else
        {
            authportaluiactivity.mMapAccountManager.registerAccount(RegistrationType.FROM_ACCESS_TOKEN, bundle, authportaluiactivity. new _cls3());
            return;
        }
    }

*/




}
