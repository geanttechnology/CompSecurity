// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.text.style.UnderlineSpan;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.apilevel.Api;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.messaging.SetupAccountEvent;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.util.StorageInformationFetcher;
import com.amazon.gallery.framework.kindle.util.StorageInformationLoadedListener;
import com.amazon.gallery.framework.metrics.customer.CustomerMetricsHelper;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.http.adrive.operations.StorageInformation;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.thor.app.AccountStateReceiver;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.authentication.AospPreferences;
import com.amazon.gallery.thor.app.authentication.FetchCustomerEmailService;
import com.amazon.gallery.thor.widget.BackableEditText;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.CustomerAttributeStore;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.api.MultipleAccountManager;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            ThorChooserActivity, ThorNativeGalleryActivity

public class SignInActivity extends Activity
{
    private static class DoNothingTransformationMethod
        implements TransformationMethod
    {

        public CharSequence getTransformation(CharSequence charsequence, View view)
        {
            return charsequence;
        }

        public void onFocusChanged(View view, CharSequence charsequence, boolean flag, int i, Rect rect)
        {
        }

        private DoNothingTransformationMethod()
        {
        }

    }

    private static final class MetricEvent extends Enum
    {

        private static final MetricEvent $VALUES[];
        public static final MetricEvent NewUserNoSSO;
        public static final MetricEvent NewUserSSO;
        public static final MetricEvent OpenSignIn;
        public static final MetricEvent ReferredAppFirstSignIn;
        public static final MetricEvent SignInFailure;
        public static final MetricEvent SignInSuccess;
        public static final MetricEvent UseDifferentAccount;

        public static MetricEvent valueOf(String s)
        {
            return (MetricEvent)Enum.valueOf(com/amazon/gallery/thor/app/activity/SignInActivity$MetricEvent, s);
        }

        public static MetricEvent[] values()
        {
            return (MetricEvent[])$VALUES.clone();
        }

        static 
        {
            OpenSignIn = new MetricEvent("OpenSignIn", 0);
            NewUserSSO = new MetricEvent("NewUserSSO", 1);
            NewUserNoSSO = new MetricEvent("NewUserNoSSO", 2);
            UseDifferentAccount = new MetricEvent("UseDifferentAccount", 3);
            SignInSuccess = new MetricEvent("SignInSuccess", 4);
            SignInFailure = new MetricEvent("SignInFailure", 5);
            ReferredAppFirstSignIn = new MetricEvent("ReferredAppFirstSignIn", 6);
            $VALUES = (new MetricEvent[] {
                OpenSignIn, NewUserSSO, NewUserNoSSO, UseDifferentAccount, SignInSuccess, SignInFailure, ReferredAppFirstSignIn
            });
        }

        private MetricEvent(String s, int i)
        {
            super(s, i);
        }
    }

    private class SignInCallback
        implements Callback
    {

        final SignInActivity this$0;

        public void onError(Bundle bundle)
        {
            mHandler.post(bundle. new Runnable() {

                final SignInCallback this$1;
                final Bundle val$result;

                public void run()
                {
                    int i = result.getInt("com.amazon.dcp.sso.ErrorCode");
                    int j = result.getInt("errorCode");
                    String s = result.getString("com.amazon.dcp.sso.ErrorMessage");
                    String s1 = result.getString("auth_data_additional_info");
                    com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError registrationerror = com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.fromValue(i);
                    if (registrationerror == com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.ACCOUNT_ALREADY_EXISTS)
                    {
                        GLogger.w(SignInActivity.TAG, "ACCOUNT_ALREADY_EXISTS; passing through as signed-in", new Object[0]);
                        onSuccess(result);
                        return;
                    }
                    setBackgroundBlurred(false);
                    animateCloudsDrifting();
                    if (j == 4)
                    {
                        GLogger.d(SignInActivity.TAG, "User cancelled MFA", new Object[0]);
                        setStartState();
                        return;
                    }
                    setErrorState(s);
                    static class _cls17
                    {

                        static final int $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[];

                        static 
                        {
                            $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError = new int[com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.values().length];
                            try
                            {
                                $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.AUTHENTICATION_FAILED.ordinal()] = 1;
                            }
                            catch (NoSuchFieldError nosuchfielderror12) { }
                            try
                            {
                                $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.CUSTOMER_NOT_FOUND.ordinal()] = 2;
                            }
                            catch (NoSuchFieldError nosuchfielderror11) { }
                            try
                            {
                                $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.NETWORK_FAILURE.ordinal()] = 3;
                            }
                            catch (NoSuchFieldError nosuchfielderror10) { }
                            try
                            {
                                $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.ALREADY_DEREGISTERED.ordinal()] = 4;
                            }
                            catch (NoSuchFieldError nosuchfielderror9) { }
                            try
                            {
                                $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST.ordinal()] = 5;
                            }
                            catch (NoSuchFieldError nosuchfielderror8) { }
                            try
                            {
                                $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_SECRET.ordinal()] = 6;
                            }
                            catch (NoSuchFieldError nosuchfielderror7) { }
                            try
                            {
                                $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.DEREGISTER_FAILED.ordinal()] = 7;
                            }
                            catch (NoSuchFieldError nosuchfielderror6) { }
                            try
                            {
                                $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.DEVICE_ALREADY_REGISTERED.ordinal()] = 8;
                            }
                            catch (NoSuchFieldError nosuchfielderror5) { }
                            try
                            {
                                $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.DUPLICATE_DEVICE_NAME.ordinal()] = 9;
                            }
                            catch (NoSuchFieldError nosuchfielderror4) { }
                            try
                            {
                                $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.NO_ACCOUNT.ordinal()] = 10;
                            }
                            catch (NoSuchFieldError nosuchfielderror3) { }
                            try
                            {
                                $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.PARSE_ERROR.ordinal()] = 11;
                            }
                            catch (NoSuchFieldError nosuchfielderror2) { }
                            try
                            {
                                $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.REGISTER_FAILED.ordinal()] = 12;
                            }
                            catch (NoSuchFieldError nosuchfielderror1) { }
                            try
                            {
                                $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED.ordinal()] = 13;
                            }
                            catch (NoSuchFieldError nosuchfielderror)
                            {
                                return;
                            }
                        }
                    }

                    switch (_cls17..SwitchMap.com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError[registrationerror.ordinal()])
                    {
                    default:
                        setErrorState(getString(0x7f0e01ee));
                        return;

                    case 1: // '\001'
                    case 2: // '\002'
                        if ("CountryCodeRequired".equals(s1))
                        {
                            setErrorState(getResources().getString(0x7f0e01ed));
                            return;
                        } else
                        {
                            setErrorState(getResources().getString(0x7f0e01ec));
                            return;
                        }

                    case 3: // '\003'
                        setErrorState(getString(0x7f0e0054));
                        return;
                    }
                }

            
            {
                this$1 = final_signincallback;
                result = Bundle.this;
                super();
            }
            });
        }

        public void onSuccess(Bundle bundle)
        {
            mReturnFromMFA = true;
            bundle = bundle.getString("com.amazon.dcp.sso.property.account.acctId");
            if (!mMultipleAccountManager.doesAccountHaveMapping(bundle, com.amazon.identity.auth.device.api.MultipleAccountManager.PackageMappingType.createCurrentPackageMapping(getApplicationContext())))
            {
                mMultipleAccountManager.setAccountMappings(bundle, new com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType[] {
                    com.amazon.identity.auth.device.api.MultipleAccountManager.PackageMappingType.createCurrentPackageMapping(getApplicationContext())
                });
            }
            completeSignIn();
        }

        private SignInCallback()
        {
            this$0 = SignInActivity.this;
            super();
        }

    }


    private static final String TAG = com/amazon/gallery/thor/app/activity/SignInActivity.getName();
    private boolean cameFromActionSendActivity;
    private ComponentProfiler componentProfiler;
    private RelativeLayout mBackground;
    private View mBackgroundBlurred;
    private View mCloudLogo;
    private AnimationSet mDriftingCloudsAnimationSet;
    private ImageView mDriftingCloudsView;
    private TextView mErrorMessage;
    private Handler mHandler;
    private CheckBox mHidePasswordCheckBox;
    private MAPAccountManager mMAPAccountManager;
    private MultipleAccountManager mMultipleAccountManager;
    private BackableEditText mPassword;
    private AospPreferences mPrefs;
    private boolean mReturnFromMFA;
    private TextView mSSOErrorMessage;
    private int mScreenWidth;
    private View mScrollView;
    private Button mSignInButton;
    private View mSignInSpinner;
    private TextView mTermsOfUse;
    private BackableEditText mUserName;
    private View mWelcomeView;

    public SignInActivity()
    {
        mReturnFromMFA = false;
    }

    private void animateCloudsDrifting()
    {
        mDriftingCloudsView.setVisibility(0);
        mDriftingCloudsView.startAnimation(mDriftingCloudsAnimationSet);
    }

    private void completeSignIn()
    {
        mPrefs.setSignedInAccount(mMAPAccountManager.getAccount());
        mReturnFromMFA = false;
        Object obj = new Intent();
        ((Intent) (obj)).setComponent(new ComponentName(getApplicationContext(), com/amazon/gallery/thor/app/AccountStateReceiver));
        ((Intent) (obj)).setAction("com.amazon.clouddrive.photos.do_setup_account");
        sendBroadcast(((Intent) (obj)));
        obj = getIntent().getExtras();
        if (obj != null && ((Bundle) (obj)).getBoolean("KEY_SIGN_IN_FOR_ACTION_SEND", false))
        {
            cameFromActionSendActivity = true;
        }
    }

    private void fetchCustomerIdAndPersist(final Context applicationContext)
    {
        StorageInformationFetcher storageinformationfetcher = new StorageInformationFetcher();
        storageinformationfetcher.setRestClient((RestClient)ThorGalleryApplication.getBean(Keys.REST_CLIENT));
        storageinformationfetcher.setNetworkExecutor(NetworkExecutor.getInstance());
        storageinformationfetcher.setNetworkConnectivity((NetworkConnectivity)ThorGalleryApplication.getBean(Keys.NETWORK_CONNECTIVITY));
        storageinformationfetcher.setStorageInformationLoadedListener(new StorageInformationLoadedListener() {

            final SignInActivity this$0;
            final Context val$applicationContext;

            public void onSetBuyStorageInformation(Intent intent)
            {
            }

            public void onStorageInformationLoaded(StorageInformation storageinformation)
            {
                storageinformation = storageinformation.customerId;
                if (storageinformation != null)
                {
                    (new AospPreferences(applicationContext)).setCustomerId(storageinformation);
                }
            }

            
            {
                this$0 = SignInActivity.this;
                applicationContext = context;
                super();
            }
        });
        storageinformationfetcher.fetchStorageInformation();
    }

    private void goToGalleryActivity()
    {
        Runnable runnable = new Runnable() {

            final SignInActivity this$0;

            public void run()
            {
                Object obj;
                if (getIntent().hasExtra("intent_extra_came_from_chooser"))
                {
                    obj = new Intent(SignInActivity.this, com/amazon/gallery/thor/app/activity/ThorChooserActivity);
                    ((Intent) (obj)).putExtra("intent_extra_came_from_chooser", true);
                } else
                {
                    obj = new Intent(SignInActivity.this, com/amazon/gallery/thor/app/activity/ThorNativeGalleryActivity);
                }
                ((Intent) (obj)).setAction("android.intent.action.MAIN");
                ((Intent) (obj)).putExtra("intent_extra_came_from_sign_in", true);
                startActivity(((Intent) (obj)));
                componentProfiler.trackEvent(MetricEvent.SignInSuccess);
                obj = PreferenceManager.getDefaultSharedPreferences(SignInActivity.this);
                if (((SharedPreferences) (obj)).getString("referrer", null) != null && !((SharedPreferences) (obj)).getBoolean("ref_signin_complete_key", false))
                {
                    String s = ((SharedPreferences) (obj)).getString("AMZN_REF_KEY", "NO_REF");
                    componentProfiler.trackEvent(MetricEvent.ReferredAppFirstSignIn, CustomerMetricsHelper.getExtraEventTag(s));
                    ((SharedPreferences) (obj)).edit().putBoolean("ref_signin_complete_key", true).apply();
                }
                finish();
            }

            
            {
                this$0 = SignInActivity.this;
                super();
            }
        };
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            runnable.run();
            return;
        } else
        {
            mHandler.post(runnable);
            return;
        }
    }

    private boolean hasGroverInstalled()
    {
        return hasPackageInstalled("com.amazon.fv") || hasPackageInstalled("com.amazon.canary");
    }

    private boolean hasPackageInstalled(String s)
    {
        boolean flag1 = false;
        boolean flag;
        boolean flag2;
        try
        {
            getPackageManager().getPackageInfo(s, 0);
            s = getPackageManager().getApplicationInfo(s, 0);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        flag = flag1;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        flag2 = ((ApplicationInfo) (s)).enabled;
        flag = flag1;
        if (flag2)
        {
            flag = true;
        }
        return flag;
    }

    private void hidePassword()
    {
        int i = mPassword.getSelectionStart();
        mPassword.setTransformationMethod(new PasswordTransformationMethod());
        if (i >= 0)
        {
            mPassword.setSelection(i);
        }
    }

    private boolean isOtterDevice()
    {
        return Build.MODEL.equals("Kindle Fire") && Build.DEVICE.equals("D01E") && Build.MANUFACTURER.equals("Amazon");
    }

    private void setBackgroundBlurred(boolean flag)
    {
        if (flag && mBackgroundBlurred.getVisibility() != 0)
        {
            AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
            alphaanimation.setDuration(500L);
            alphaanimation.setFillAfter(true);
            mBackgroundBlurred.startAnimation(alphaanimation);
            mBackgroundBlurred.setVisibility(0);
            mBackgroundBlurred.bringToFront();
            mBackgroundBlurred.invalidate();
            mScrollView.bringToFront();
            mScrollView.invalidate();
            mSignInSpinner.bringToFront();
            mSignInSpinner.invalidate();
            mCloudLogo.bringToFront();
            mCloudLogo.invalidate();
        } else
        if (!flag && mBackgroundBlurred.getVisibility() != 4)
        {
            AlphaAnimation alphaanimation1 = new AlphaAnimation(1.0F, 0.0F);
            alphaanimation1.setDuration(500L);
            alphaanimation1.setFillAfter(true);
            alphaanimation1.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                final SignInActivity this$0;

                public void onAnimationEnd(Animation animation)
                {
                    mBackgroundBlurred.setVisibility(4);
                }

                public void onAnimationRepeat(Animation animation)
                {
                }

                public void onAnimationStart(Animation animation)
                {
                }

            
            {
                this$0 = SignInActivity.this;
                super();
            }
            });
            mBackgroundBlurred.startAnimation(alphaanimation1);
            return;
        }
    }

    private void setErrorState(String s)
    {
        mSignInSpinner.setVisibility(4);
        setStartState();
        if (s == null || s.length() == 0)
        {
            mErrorMessage.setText(getString(0x7f0e01ee));
        } else
        {
            mErrorMessage.setText(s);
        }
        mErrorMessage.setVisibility(0);
        s = AnimationUtils.loadAnimation(this, 0x7f040031);
        mUserName.startAnimation(s);
        mPassword.startAnimation(s);
    }

    private void setSigningInState()
    {
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(mUserName.getWindowToken(), 0);
        mUserName.setEnabled(false);
        mPassword.setEnabled(false);
        mUserName.clearFocus();
        mPassword.clearFocus();
        mHidePasswordCheckBox.setChecked(true);
        hidePassword();
        mSignInButton.setEnabled(false);
        mSignInButton.setText("");
        mSignInSpinner.setVisibility(0);
    }

    private void setStartState()
    {
        mUserName.setEnabled(true);
        mPassword.setEnabled(true);
        mSignInSpinner.setVisibility(8);
        if (mUserName.getText() != null && mPassword.getText() != null && mUserName.getText().length() > 0 && mPassword.getText().length() > 0)
        {
            mSignInButton.setEnabled(true);
        }
        mSignInButton.setText(getString(0x7f0e01e9));
    }

    private void setupDriftingCloudsAnimation()
    {
        mDriftingCloudsAnimationSet = new AnimationSet(true);
        mDriftingCloudsAnimationSet.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final SignInActivity this$0;

            public void onAnimationEnd(Animation animation)
            {
                mHandler.post(new Runnable() {

                    final _cls14 this$1;

                    public void run()
                    {
                        if (mBackgroundBlurred.getVisibility() != 0)
                        {
                            animateCloudsDrifting();
                        }
                    }

            
            {
                this$1 = _cls14.this;
                super();
            }
                });
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$0 = SignInActivity.this;
                super();
            }
        });
        AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
        alphaanimation.setDuration(5000L);
        alphaanimation.setFillAfter(true);
        alphaanimation.setStartOffset(0x17318L);
        TranslateAnimation translateanimation = new TranslateAnimation(mScreenWidth / 2, -(mScreenWidth / 2), 0.0F, 0.0F);
        translateanimation.setDuration(0x186a0L);
        AlphaAnimation alphaanimation1 = new AlphaAnimation(0.0F, 1.0F);
        alphaanimation1.setDuration(5000L);
        alphaanimation1.setFillAfter(true);
        mDriftingCloudsAnimationSet.addAnimation(translateanimation);
        mDriftingCloudsAnimationSet.addAnimation(alphaanimation1);
        mDriftingCloudsAnimationSet.addAnimation(alphaanimation);
    }

    private void showPassword()
    {
        int i = mPassword.getSelectionStart();
        mPassword.setTransformationMethod(new DoNothingTransformationMethod());
        if (i >= 0)
        {
            mPassword.setSelection(i);
        }
    }

    private void showSSOWelcomeView()
    {
        mScrollView.setVisibility(8);
        mSSOErrorMessage.setVisibility(8);
        mWelcomeView.setVisibility(0);
        mWelcomeView.bringToFront();
        mWelcomeView.invalidate();
        final TextView titleText = (TextView)findViewById(0x7f0c01da);
        TextView textview = (TextView)findViewById(0x7f0c01db);
        final TextView emailText = (TextView)findViewById(0x7f0c01dc);
        Object obj = (TextView)findViewById(0x7f0c01df);
        Button button = (Button)findViewById(0x7f0c01de);
        button.setTransformationMethod(null);
        String s = mMAPAccountManager.getAccount();
        CustomerAttributeStore.getInstance(this).getAttribute(s, "com.amazon.dcp.sso.property.username", new Callback() {

            final SignInActivity this$0;
            final TextView val$titleText;

            public void onError(Bundle bundle)
            {
                GLogger.d(SignInActivity.TAG, "Error occurred trying to fetch customer name for SSO", new Object[0]);
            }

            public void onSuccess(Bundle bundle)
            {
                mHandler.post(bundle. new Runnable() {

                    final _cls10 this$1;
                    final Bundle val$bundle;

                    public void run()
                    {
                        String s = bundle.getString("value_key");
                        if (s != null && !s.equals(""))
                        {
                            String as[] = s.split("\\s");
                            if (as.length > 0)
                            {
                                as = as[0];
                            } else
                            {
                                as = "";
                            }
                            titleText.setText(getString(0x7f0e01f2, new Object[] {
                                as
                            }));
                            return;
                        } else
                        {
                            titleText.setText(getString(0x7f0e01f1));
                            return;
                        }
                    }

            
            {
                this$1 = final__pcls10;
                bundle = Bundle.this;
                super();
            }
                });
            }

            
            {
                this$0 = SignInActivity.this;
                titleText = textview;
                super();
            }
        });
        if (isOtterDevice() || hasGroverInstalled())
        {
            ((TextView) (obj)).setVisibility(8);
            ((TextView) (obj)).setClickable(false);
            ((TextView) (obj)).setFocusable(false);
        } else
        {
            SpannableString spannablestring = new SpannableString(getString(0x7f0e01f6));
            spannablestring.setSpan(new UnderlineSpan(), 0, spannablestring.length(), 0);
            ((TextView) (obj)).setText(spannablestring);
            ((TextView) (obj)).setVisibility(0);
            ((TextView) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                final SignInActivity this$0;

                public void onClick(View view)
                {
                    mMAPAccountManager.deregisterAccount(mMAPAccountManager.getAccount(), null);
                    componentProfiler.trackEvent(MetricEvent.UseDifferentAccount);
                    showSignInView();
                }

            
            {
                this$0 = SignInActivity.this;
                super();
            }
            });
        }
        obj = mPrefs.getEmail();
        if (obj != null && ((String) (obj)).length() > 0)
        {
            emailText.setText(((CharSequence) (obj)));
        } else
        {
            FetchCustomerEmailService.addListener(new com.amazon.gallery.thor.app.authentication.FetchCustomerEmailService.CustomerEmailListener() {

                final SignInActivity this$0;
                final TextView val$emailText;

                public void onCustomerEmailFetched()
                {
                    mHandler.post(new Runnable() {

                        final _cls12 this$1;
                        final com.amazon.gallery.thor.app.authentication.FetchCustomerEmailService.CustomerEmailListener val$listener;

                        public void run()
                        {
                            Object obj = mPrefs.getEmail();
                            emailText.setText(((CharSequence) (obj)));
                            obj = new AlphaAnimation(0.0F, 1.0F);
                            ((Animation) (obj)).setDuration(1000L);
                            ((Animation) (obj)).setFillAfter(true);
                            emailText.startAnimation(((Animation) (obj)));
                            FetchCustomerEmailService.removeListener(listener);
                        }

            
            {
                this$1 = final__pcls12;
                listener = com.amazon.gallery.thor.app.authentication.FetchCustomerEmailService.CustomerEmailListener.this;
                super();
            }
                    });
                }

            
            {
                this$0 = SignInActivity.this;
                emailText = textview;
                super();
            }
            });
            startService(new Intent(this, com/amazon/gallery/thor/app/authentication/FetchCustomerEmailService));
        }
        textview.setText(getString(0x7f0e01f3));
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final SignInActivity this$0;

            public void onClick(View view)
            {
                if (!((NetworkConnectivity)ThorGalleryApplication.getBean(Keys.NETWORK_CONNECTIVITY)).isNetworkConnected())
                {
                    mSignInSpinner.setVisibility(4);
                    mSSOErrorMessage.setText(getString(0x7f0e0054));
                    mSSOErrorMessage.setVisibility(0);
                    return;
                } else
                {
                    completeSignIn();
                    return;
                }
            }

            
            {
                this$0 = SignInActivity.this;
                super();
            }
        });
    }

    private void showSignInView()
    {
        mSSOErrorMessage.setVisibility(8);
        mErrorMessage.setVisibility(8);
        mWelcomeView.setVisibility(8);
        mScrollView.setVisibility(0);
    }

    private void signIn()
    {
        if (!((NetworkConnectivity)ThorGalleryApplication.getBean(Keys.NETWORK_CONNECTIVITY)).isNetworkConnected())
        {
            setErrorState(getString(0x7f0e0054));
            return;
        } else
        {
            setSigningInState();
            mErrorMessage.setVisibility(8);
            Bundle bundle = new Bundle();
            bundle.putString("authAccount", mUserName.getText().toString());
            bundle.putString("password", mPassword.getText().toString());
            bundle.putBoolean("com.amazon.dcp.sso.AddAccount.options.AddAsSecondary", true);
            Bundle bundle1 = new Bundle();
            mMAPAccountManager.registerAccount(this, bundle, bundle1, new SignInCallback());
            return;
        }
    }

    public void onBackPressed()
    {
        if (mBackgroundBlurred != null && mBackgroundBlurred.getVisibility() == 0)
        {
            ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(mPassword.getWindowToken(), 0);
            setBackgroundBlurred(false);
            animateCloudsDrifting();
            mUserName.clearFocus();
            mPassword.clearFocus();
            return;
        } else
        {
            finish();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (Api.isAtLeastKitkat())
        {
            bundle = getWindow();
            bundle.setFlags(0x8000000, 0x8000000);
            bundle.setFlags(0x4000000, 0x4000000);
        }
        mHandler = new Handler();
        componentProfiler = new ComponentProfiler((Profiler)ThorGalleryApplication.getBean(Keys.PROFILER), com/amazon/gallery/thor/app/activity/SignInActivity);
        componentProfiler.trackEvent(MetricEvent.OpenSignIn);
        mMAPAccountManager = new MAPAccountManager(this);
        mMultipleAccountManager = new MultipleAccountManager(this);
        mPrefs = new AospPreferences(this);
        setContentView(0x7f0300d4);
        mCloudLogo = findViewById(0x7f0c01cf);
        mWelcomeView = findViewById(0x7f0c01d9);
        mScrollView = findViewById(0x7f0c01d0);
        mBackground = (RelativeLayout)findViewById(0x7f0c01ca);
        mBackgroundBlurred = findViewById(0x7f0c01cb);
        mErrorMessage = (TextView)findViewById(0x7f0c01d5);
        mSSOErrorMessage = (TextView)findViewById(0x7f0c01e0);
        mSignInButton = (Button)findViewById(0x7f0c01d7);
        mSignInButton.setTransformationMethod(null);
        mSignInButton.setOnClickListener(new android.view.View.OnClickListener() {

            final SignInActivity this$0;

            public void onClick(View view)
            {
                signIn();
            }

            
            {
                this$0 = SignInActivity.this;
                super();
            }
        });
        bundle = new TextWatcher() {

            final SignInActivity this$0;

            public void afterTextChanged(Editable editable)
            {
                if (mPassword.length() > 0 && mUserName.length() > 0)
                {
                    mSignInButton.setEnabled(true);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        mSignInButton.setAlpha(1.0F);
                    }
                } else
                {
                    mSignInButton.setEnabled(false);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        mSignInButton.setAlpha(0.66F);
                    }
                }
                if (mPassword.length() > 0)
                {
                    mHidePasswordCheckBox.setVisibility(0);
                    return;
                } else
                {
                    mHidePasswordCheckBox.setVisibility(4);
                    return;
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            
            {
                this$0 = SignInActivity.this;
                super();
            }
        };
        android.view.View.OnFocusChangeListener onfocuschangelistener = new android.view.View.OnFocusChangeListener() {

            final SignInActivity this$0;

            public void onFocusChange(View view, boolean flag)
            {
                if (flag && mBackgroundBlurred.getVisibility() != 0)
                {
                    setBackgroundBlurred(true);
                    mDriftingCloudsView.setVisibility(4);
                    mDriftingCloudsView.clearAnimation();
                }
            }

            
            {
                this$0 = SignInActivity.this;
                super();
            }
        };
        mUserName = (BackableEditText)findViewById(0x7f0c01d1);
        mUserName.addTextChangedListener(bundle);
        mUserName.setOnFocusChangeListener(onfocuschangelistener);
        mPassword = (BackableEditText)findViewById(0x7f0c01d2);
        mPassword.addTextChangedListener(bundle);
        mPassword.setOnFocusChangeListener(onfocuschangelistener);
        mPassword.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final SignInActivity this$0;

            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
            {
                if (i == 6)
                {
                    signIn();
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = SignInActivity.this;
                super();
            }
        });
        mHidePasswordCheckBox = (CheckBox)findViewById(0x7f0c01d4);
        mHidePasswordCheckBox.setChecked(true);
        hidePassword();
        findViewById(0x7f0c01d3).setOnClickListener(new android.view.View.OnClickListener() {

            final SignInActivity this$0;

            public void onClick(View view)
            {
                if (mHidePasswordCheckBox.isChecked())
                {
                    mHidePasswordCheckBox.setChecked(false);
                    showPassword();
                    return;
                } else
                {
                    mHidePasswordCheckBox.setChecked(true);
                    hidePassword();
                    return;
                }
            }

            
            {
                this$0 = SignInActivity.this;
                super();
            }
        });
        mSignInSpinner = findViewById(0x7f0c01d8);
        mTermsOfUse = (TextView)findViewById(0x7f0c01cd);
        mTermsOfUse.setOnClickListener(new android.view.View.OnClickListener() {

            final SignInActivity this$0;

            public void onClick(View view)
            {
                view = new android.support.v7.app.AlertDialog.Builder(SignInActivity.this);
                view.setCancelable(true);
                ProgressBar progressbar = new ProgressBar(SignInActivity.this, null, 0x1010077);
                Object obj = new WebView(SignInActivity.this);
                ((WebView) (obj)).setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
                ((WebView) (obj)).setWebViewClient(progressbar. new WebViewClient() {

                    final _cls6 this$1;
                    final ProgressBar val$spinner;

                    public void onPageFinished(WebView webview, String s)
                    {
                        spinner.setVisibility(8);
                    }

            
            {
                this$1 = final__pcls6;
                spinner = ProgressBar.this;
                super();
            }
                });
                ((WebView) (obj)).loadUrl("https://www.amazon.com/cd/tou/flagpage");
                RelativeLayout relativelayout = new RelativeLayout(SignInActivity.this);
                relativelayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
                relativelayout.addView(((View) (obj)));
                relativelayout.addView(progressbar);
                obj = (android.widget.RelativeLayout.LayoutParams)progressbar.getLayoutParams();
                ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13, -1);
                progressbar.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
                view.setView(relativelayout);
                view.setPositiveButton("Close", new android.content.DialogInterface.OnClickListener() {

                    final _cls6 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = _cls6.this;
                super();
            }
                });
                view.show();
            }

            
            {
                this$0 = SignInActivity.this;
                super();
            }
        });
        setStartState();
        bundle = getWindowManager().getDefaultDisplay();
        if (android.os.Build.VERSION.SDK_INT >= 13)
        {
            Point point = new Point();
            bundle.getSize(point);
            mScreenWidth = point.x;
        } else
        {
            mScreenWidth = getWindowManager().getDefaultDisplay().getWidth();
        }
        mDriftingCloudsView = new ImageView(this);
        mDriftingCloudsView.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
        mDriftingCloudsView.setBackgroundDrawable(getResources().getDrawable(0x7f02012c));
        mBackground.addView(mDriftingCloudsView);
        setupDriftingCloudsAnimation();
        animateCloudsDrifting();
    }

    public void onDestroy()
    {
        if (mDriftingCloudsView != null)
        {
            mDriftingCloudsView.setBackgroundDrawable(null);
        }
        if (mBackground != null)
        {
            mBackground.setBackgroundDrawable(null);
        }
        if (mBackgroundBlurred != null)
        {
            mBackgroundBlurred.setBackgroundDrawable(null);
        }
        if (mCloudLogo != null)
        {
            mCloudLogo.setBackgroundDrawable(null);
        }
        super.onDestroy();
    }

    public void onPause()
    {
        super.onPause();
        GlobalMessagingBus.unregister(this);
    }

    public void onResume()
    {
        super.onResume();
        GlobalMessagingBus.register(this);
        if (mReturnFromMFA)
        {
            return;
        }
        if (mPrefs.signedIn())
        {
            goToGalleryActivity();
            return;
        }
        if (mMAPAccountManager.getAccount() != null)
        {
            componentProfiler.trackEvent(MetricEvent.NewUserSSO);
            showSSOWelcomeView();
            return;
        } else
        {
            componentProfiler.trackEvent(MetricEvent.NewUserNoSSO);
            showSignInView();
            return;
        }
    }

    public void onSetupAccountEvent(SetupAccountEvent setupaccountevent)
    {
        if (setupaccountevent.succeeded)
        {
            fetchCustomerIdAndPersist(getApplicationContext());
            if (cameFromActionSendActivity)
            {
                mHandler.post(new Runnable() {

                    final SignInActivity this$0;

                    public void run()
                    {
                        setResult(-1);
                        finish();
                    }

            
            {
                this$0 = SignInActivity.this;
                super();
            }
                });
                return;
            } else
            {
                goToGalleryActivity();
                return;
            }
        } else
        {
            componentProfiler.trackEvent(MetricEvent.SignInFailure);
            mMAPAccountManager.deregisterAccount(mMAPAccountManager.getAccount(), null);
            mPrefs.setSignedInAccount(null);
            mHandler.post(new Runnable() {

                final SignInActivity this$0;

                public void run()
                {
                    setErrorState(null);
                }

            
            {
                this$0 = SignInActivity.this;
                super();
            }
            });
            return;
        }
    }

















/*
    static boolean access$2302(SignInActivity signinactivity, boolean flag)
    {
        signinactivity.mReturnFromMFA = flag;
        return flag;
    }

*/









}
