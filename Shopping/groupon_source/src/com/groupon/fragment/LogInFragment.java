// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import com.google.android.gms.auth.api.credentials.Credential;
import com.groupon.Channel;
import com.groupon.abtest.GoogleSignInAbTestHelper;
import com.groupon.activity.FacebookAppUtils;
import com.groupon.activity.Login;
import com.groupon.dogfood.DogfoodHelper;
import com.groupon.models.country.Country;
import com.groupon.models.nst.GoogleSmartLockExtraInfo;
import com.groupon.models.nst.LoginSignUpGenericExtraInfo;
import com.groupon.service.LoginService;
import com.groupon.service.core.UserManager;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.googlesmartlock.GoogleSmartLockService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.CountryUtil;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.LoginUtil;
import com.groupon.view.SpinnerButton;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            BaseSignUpFragment, ForgotPasswordFragment

public class LogInFragment extends BaseSignUpFragment
{
    private class GoogleSmartLockOnCredentialsRetrievedCallback
        implements com.groupon.service.googlesmartlock.GoogleSmartLockService.OnCredentialsRetrievedCallback
    {

        final LogInFragment this$0;

        public void onCredentialResolutionRequired()
        {
            hasGoogleSmartLockMultipleCredentials = true;
            logger.logImpression("", "google_smartlock_multiple_pwd_modal", channelId, "", new GoogleSmartLockExtraInfo(getClass().getSimpleName(), trigger));
        }

        public void onCredentialsRetrieveFailed()
        {
            if (googleSmartLockCredentialsProgressDialog != null)
            {
                googleSmartLockCredentialsProgressDialog.dismiss();
            }
            if (email != null)
            {
                prePopulateEmailFieldIfAvailable();
                if (Strings.isEmpty(email.getText().toString()))
                {
                    email.requestFocus();
                }
            }
        }

        public void onCredentialsRetrieved(Credential credential)
        {
            googleSmartLockCredentialsProgressDialog.dismiss();
            email.setText(credential.getId());
            password.setText(credential.getPassword());
            if (!prefs.getBoolean(GOOGLE_SMARTLOCK_AUTOMATICALLY_LOGIN_ALREADY_PERFORMED_EXTRA_KEY, false))
            {
                credential = prefs.edit();
                credential.putBoolean(GOOGLE_SMARTLOCK_AUTOMATICALLY_LOGIN_ALREADY_PERFORMED_EXTRA_KEY, true);
                credential.apply();
                login();
            }
            if (!hasGoogleSmartLockMultipleCredentials)
            {
                logger.logImpression("", "google_smartlock_pwd_modal", channelId, "", new GoogleSmartLockExtraInfo(getClass().getSimpleName(), trigger));
            }
        }

        private GoogleSmartLockOnCredentialsRetrievedCallback()
        {
            this$0 = LogInFragment.this;
            super();
        }

    }

    private class OnLoginFailedCallback
        implements Function1
    {

        final LogInFragment this$0;

        public void execute(Exception exception)
        {
            submit.stopSpinning();
            Toast.makeText(getActivity().getApplicationContext(), getString(0x7f08017d, new Object[] {
                countryUtil.getDisplayNameByIsoName(currentCountryManager.getCurrentCountry())
            }), 1).show();
        }

        public volatile void execute(Object obj)
            throws Exception
        {
            execute((Exception)obj);
        }

        private OnLoginFailedCallback()
        {
            this$0 = LogInFragment.this;
            super();
        }

    }

    private class OnLoginSuccessCallback
        implements Function0
    {

        final LogInFragment this$0;
        private String username;

        public void execute()
        {
            onLoginSuccess(username);
        }

        public OnLoginSuccessCallback(String s)
        {
            this$0 = LogInFragment.this;
            super();
            username = s;
        }
    }


    public static final String TAG = com/groupon/fragment/LogInFragment.getName();
    private final String IMPRESSION_TYPE_GOOGLE_SMARTLOCK_MULTIPLE_PWD_MODAL = "google_smartlock_multiple_pwd_modal";
    private final String IMPRESSION_TYPE_GOOGLE_SMARTLOCK_PWD_MODAL = "google_smartlock_pwd_modal";
    private final String IMPRESSION_TYPE_LOGIN_PAGE_AFTER_SMARTLOCK_SIGNOFF = "login_page_after_smartlock_signoff";
    private String channelId;
    private DogfoodHelper dogfoodHelper;
    AutoCompleteTextView email;
    SpinnerButton facebook;
    View forgotPassword;
    SpinnerButton google;
    private ProgressDialog googleSmartLockCredentialsProgressDialog;
    private boolean hasGoogleSmartLockMultipleCredentials;
    private boolean isNewCheckoutFlow1408;
    private ArraySharedPreferences loginPrefs;
    private LoginSignUpGenericExtraInfo loginSignUpGenericExtraInfo;
    View orText;
    EditText password;
    private SharedPreferences prefs;
    SpinnerButton submit;
    private UserManager userManager;

    public LogInFragment()
    {
    }

    private boolean isCheckoutFlow1408()
    {
        return isComingFromCheckout != null && isComingFromCheckout.booleanValue() && isNewCheckoutFlow1408;
    }

    private void login()
    {
        submit.startSpinning();
        String s = Strings.toString(email.getText()).trim();
        String s1 = Strings.toString(password.getText());
        loginService.login(s, s1, new OnLoginSuccessCallback(s), new OnLoginFailedCallback(), null);
    }

    private void prePopulateEmailFieldIfAvailable()
    {
        String s = userManager.getDeviceFirstEmailAccount();
        if (!loginPrefs.contains("email") || !Strings.notEmpty(loginPrefs.getString("email", ""))) goto _L2; else goto _L1
_L1:
        email.setText(loginPrefs.getString("email", ""));
_L4:
        email.setSelection(email.getText().length());
        return;
_L2:
        if (prefs.contains("emailPrefill") && Strings.notEmpty(prefs.getString("emailPrefill", "")))
        {
            email.setText(prefs.getString("emailPrefill", ""));
        } else
        if (isNewCheckoutFlow1408 && Strings.notEmpty(s))
        {
            email.setText(s);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private boolean valid()
    {
        if (Strings.isEmpty(email.getText()))
        {
            email.setError(getString(0x7f08015f));
            return false;
        }
        if (Strings.isEmpty(password.getText()))
        {
            password.setError(getString(0x7f080195));
            return false;
        } else
        {
            return true;
        }
    }

    protected void facebookCleanUp()
    {
        facebook.stopSpinning();
        super.facebookCleanUp();
    }

    public void fbRequestNewReadPermission()
    {
        facebook.startSpinning();
        super.fbRequestNewReadPermission();
    }

    public int getGoogleSignInRequestCode()
    {
        return 40000;
    }

    protected String getUsername()
    {
        return Strings.toString(email.getText()).trim();
    }

    protected void googleCleanUp()
    {
        if (getActivity() != null)
        {
            getActivity().runOnUiThread(new Runnable() {

                final LogInFragment this$0;

                public void run()
                {
                    google.stopSpinning();
                }

            
            {
                this$0 = LogInFragment.this;
                super();
            }
            });
        }
        super.googleCleanUp();
    }

    public void onActivityCreated(Bundle bundle)
    {
        boolean flag1 = true;
        super.onActivityCreated(bundle);
        boolean flag;
        if (getArguments() != null)
        {
            bundle = getArguments().getString("discount");
        } else
        {
            bundle = null;
        }
        flag = flag1;
        if (getArguments() != null)
        {
            if (getArguments().getBoolean("should_display_discount", true))
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
        }
        setLoginButtonText(bundle, flag);
        if (isGoogleSmartLock1511 && !googleSmartLockService.isWaitingForGoogleSmartLockResolution())
        {
            googleSmartLockCredentialsProgressDialog = new ProgressDialog(getActivity());
            googleSmartLockCredentialsProgressDialog.setCancelable(false);
            googleSmartLockCredentialsProgressDialog.setMessage(getString(0x7f080256));
            googleSmartLockCredentialsProgressDialog.show();
            googleSmartLockService.setOnCredentialsRetrievedCallback(new GoogleSmartLockOnCredentialsRetrievedCallback());
            googleSmartLockService.retrieveSmartLockCredentials();
            boolean flag2;
            if (channel != null)
            {
                bundle = channel.name();
            } else
            {
                bundle = Channel.UNKNOWN.name();
            }
            channelId = bundle;
            email.clearFocus();
            password.requestFocus();
            if (prefs.getBoolean(GOOGLE_SMARTLOCK_AUTOMATICALLY_LOGIN_ALREADY_PERFORMED_EXTRA_KEY, false))
            {
                logger.logImpression("", "login_page_after_smartlock_signoff", channelId, "", new GoogleSmartLockExtraInfo(getClass().getSimpleName(), trigger));
            }
        } else
        {
            prePopulateEmailFieldIfAvailable();
        }
        flag = facebookAppUtils.isFacebookLoginAvailable();
        flag2 = googleSignInAbTestHelper.isGoogleLoginUSCA1508Enabled();
        setFacebookGoogleVisible(flag, flag2);
        if (flag)
        {
            facebook.setOnClickListener(new android.view.View.OnClickListener() {

                final LogInFragment this$0;

                public void onClick(View view)
                {
                    facebook.startSpinning();
                    logger.logClick("", "facebook_signin_click", com/groupon/activity/Login.getSimpleName(), "");
                    fbSignUp();
                }

            
            {
                this$0 = LogInFragment.this;
                super();
            }
            });
        }
        if (flag2)
        {
            google.setOnClickListener(new android.view.View.OnClickListener() {

                final LogInFragment this$0;

                public void onClick(View view)
                {
                    google.startSpinning();
                    logger.logClick("", "google_login_click", com/groupon/activity/Login.getSimpleName(), Logger.NULL_NST_FIELD, loginSignUpGenericExtraInfo);
                    googleSignUp();
                }

            
            {
                this$0 = LogInFragment.this;
                super();
            }
            });
        }
        dogfoodHelper.logHideViewId(0x7f1002ae);
        submit.setOnClickListener(new android.view.View.OnClickListener() {

            final LogInFragment this$0;

            public void onClick(View view)
            {
                if (!valid() || !isAdded())
                {
                    return;
                }
                String s = getLoginRedesign().getDealId();
                Logger logger = LogInFragment.this.logger;
                if (Strings.notEmpty(s))
                {
                    view = "purchase_flow";
                } else
                {
                    view = "other";
                }
                logger.logLogin("", view, s, Logger.NULL_NST_FIELD);
                LogInFragment.this.logger.logClick("", "signin_click", com/groupon/activity/Login.getSimpleName(), "");
                view = getLoginRedesign().getIsComingFromCheckout();
                if (view != null && view.booleanValue())
                {
                    LogInFragment.this.logger.logClick("", "signin_click", "checkout", s);
                }
                if (loginService.hasAccessToken() ^ loginService.hasFacebookSession() && !loginService.isLoggedInViaEmail())
                {
                    loginService.logout();
                }
                login();
            }

            
            {
                this$0 = LogInFragment.this;
                super();
            }
        });
        email.setAdapter(new ArrayAdapter(getActivity(), 0x109000a, userManager.getDeviceAndGrouponEmailAccounts()));
        if (isNewCheckoutFlow1408)
        {
            email.setOnClickListener(new android.view.View.OnClickListener() {

                final LogInFragment this$0;

                public void onClick(View view)
                {
                    email.showDropDown();
                }

            
            {
                this$0 = LogInFragment.this;
                super();
            }
            });
        }
        if (isNewCheckoutFlow1408)
        {
            password.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

                final LogInFragment this$0;

                public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
                {
                    if (i == 6)
                    {
                        submit.performClick();
                    }
                    return false;
                }

            
            {
                this$0 = LogInFragment.this;
                super();
            }
            });
        }
        forgotPassword.setOnClickListener(new android.view.View.OnClickListener() {

            final LogInFragment this$0;

            public void onClick(View view)
            {
                view = new ForgotPasswordFragment();
                view.setCancelable(false);
                view.show(getActivity().getFragmentManager(), "FP");
            }

            
            {
                this$0 = LogInFragment.this;
                super();
            }
        });
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i == 10153 && googleSmartLockService != null)
        {
            googleSmartLockService.getCredentialsFromIntent(intent, j);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        loginSignUpGenericExtraInfo = new LoginSignUpGenericExtraInfo();
        loginSignUpGenericExtraInfo.pageId = getClass().getSimpleName();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        int j;
        j = 0x7f0300ec;
        isNewCheckoutFlow1408 = currentCountryManager.getCurrentCountry().isUSACompatible();
        hasGoogleSmartLockMultipleCredentials = false;
        if (!googleSignInAbTestHelper.isGoogleLoginUSCA1508Top()) goto _L2; else goto _L1
_L1:
        int i = 0x7f0300ee;
_L4:
        layoutinflater = layoutinflater.inflate(i, viewgroup, false);
        ButterKnife.bind(this, layoutinflater);
        return layoutinflater;
_L2:
        i = j;
        if (!googleSignInAbTestHelper.isGoogleLoginUSCA1508Bottom())
        {
            i = j;
            if (isCheckoutFlow1408())
            {
                i = 0x7f0300ed;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onDestroyView()
    {
        if (googleSmartLockCredentialsProgressDialog != null)
        {
            googleSmartLockCredentialsProgressDialog.dismiss();
        }
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

    protected void onFbSuccess()
    {
        if (!isAdded())
        {
            return;
        } else
        {
            super.onFbSuccess();
            return;
        }
    }

    public void onLoginSuccess(String s)
    {
        if (isAdded())
        {
            android.content.SharedPreferences.Editor editor = prefs.edit();
            if (!Strings.notEmpty(s))
            {
                s = getUsername();
            }
            editor.putString("emailPrefill", s).apply();
            getShoppingCartItems();
            s = getLoginRedesign().getNext();
            getActivity().setResult(-1);
            loginUtil.startNextActivity(s);
            submit.stopSpinning();
            getActivity().finish();
        }
    }

    public void setFacebookGoogleVisible(boolean flag, boolean flag1)
    {
        boolean flag2 = false;
        int i;
        if (orText != null)
        {
            Object obj = orText;
            if (flag || flag1)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            ((View) (obj)).setVisibility(i);
        }
        obj = facebook;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((SpinnerButton) (obj)).setVisibility(i);
        obj = google;
        if (flag1)
        {
            i = ((flag2) ? 1 : 0);
        } else
        {
            i = 8;
        }
        ((SpinnerButton) (obj)).setVisibility(i);
    }

    public void setLoginButtonText(final String buttonText, boolean flag)
    {
        if (isCheckoutFlow1408() && flag && Strings.notEmpty(buttonText))
        {
            buttonText = getString(0x7f0801d2, new Object[] {
                buttonText
            });
        } else
        {
            buttonText = getString(0x7f0801cd);
        }
        submit.setText(buttonText);
        submit.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final LogInFragment this$0;
            final String val$buttonText;

            public void onGlobalLayout()
            {
                int i = submit.getPaddingLeft();
                int j = submit.getPaddingRight();
                i = submit.getWidth() - (i + j) - submit.getCompoundDrawables()[0].getIntrinsicWidth();
                j = Math.round(submit.getPaint().measureText(buttonText));
                if (i > 0 && i < j)
                {
                    submit.setText(0x7f0801cd);
                }
                submit.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }

            
            {
                this$0 = LogInFragment.this;
                buttonText = s;
                super();
            }
        });
    }

    public void setUserVisibleHint(boolean flag)
    {
        super.setUserVisibleHint(flag);
        if (!flag)
        {
            return;
        }
        if (email != null && Strings.isEmpty(email.getText().toString()) && !isGoogleSmartLock1511)
        {
            email.requestFocus();
        }
        if (googleSignInAbTestHelper.isGoogleLoginUSCA1508Enabled())
        {
            logger.logImpression("", "google_login_button", com/groupon/activity/Login.getSimpleName(), "", loginSignUpGenericExtraInfo);
        }
        logger.logPageView("", "login_page", Logger.NULL_NST_FIELD);
    }









/*
    static boolean access$702(LogInFragment loginfragment, boolean flag)
    {
        loginfragment.hasGoogleSmartLockMultipleCredentials = flag;
        return flag;
    }

*/


}
