// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.account;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.AmazonBrandedWebView;
import com.amazon.mShop.TaskCallbackFactory;
import com.amazon.mShop.control.TaskCallback;
import com.amazon.mShop.control.account.OneClickController;
import com.amazon.mShop.control.account.SignInController;
import com.amazon.mShop.control.account.SignInSubscriber;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.net.PageMetricsObserver;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.primeupsell.PrimeUpsellHelper;
import com.amazon.mShop.pushnotification.PushNotificationManager;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.AmazonErrorUtils;
import com.amazon.mShop.util.MShopPushNotificationUtils;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.Notification;

// Referenced classes of package com.amazon.mShop.account:
//            NonZeroLengthTextWatcher, LoginView, CreateNewAccountView

public class LoginActivity extends AmazonActivity
    implements android.view.View.OnClickListener, android.view.View.OnKeyListener, SignInSubscriber
{
    private final class LogInTextWatcher extends NonZeroLengthTextWatcher
    {

        final LoginActivity this$0;

        public void update()
        {
            updateLoginButtonEnabled();
        }

        public LogInTextWatcher(EditText edittext)
        {
            this$0 = LoginActivity.this;
            super(edittext);
        }
    }


    private TextView changeEmailPreference;
    private Button createNewButton;
    NonZeroLengthTextWatcher emailTextWatcher;
    private boolean hasPostHidePasswordRefMarker;
    private boolean hasPostShowPasswordRefMarker;
    private Button loginButton;
    private EditText loginEmailEditText;
    private TextView loginForgotYourPassword;
    private boolean loginHideMenu;
    private TextView loginLegalInformationLink;
    private EditText loginPasswordEditText;
    private boolean mAccountPhoneNumberNeeded;
    private boolean mForceFinishOnStop;
    private boolean mHasSignedIn;
    private boolean mIsUserSignedInCalled;
    private PageMetricsObserver mPageMetricsObserver;
    private String mRefMarkerForCreateAccount;
    private String mRefMarkerForLogin;
    private CheckBox mShowPassword;
    private boolean mUserForceSignIn;
    NonZeroLengthTextWatcher passwordTextWatcher;
    private SignInController signInController;
    private TaskCallback taskCallback;
    private boolean userInitiatedLogin;

    public LoginActivity()
    {
        userInitiatedLogin = false;
        mUserForceSignIn = false;
        mForceFinishOnStop = false;
        mIsUserSignedInCalled = false;
        loginHideMenu = false;
        hasPostShowPasswordRefMarker = false;
        hasPostHidePasswordRefMarker = false;
        mAccountPhoneNumberNeeded = false;
    }

    private void callUserSignedIn(boolean flag)
    {
        if (!mIsUserSignedInCalled && flag)
        {
            User.userSignedIn(User.getUser());
            mIsUserSignedInCalled = true;
        }
    }

    private boolean canLogin()
    {
        return loginEmailEditText.length() > 0 && loginPasswordEditText.length() > 0;
    }

    private void cancelMetric()
    {
        if (mPageMetricsObserver != null && !mPageMetricsObserver.isFinished())
        {
            mPageMetricsObserver.onCancelled();
        }
    }

    private void completeMetric()
    {
        if (mPageMetricsObserver != null && !mPageMetricsObserver.isFinished())
        {
            mPageMetricsObserver.onComplete();
        }
        RefMarkerObserver.logRefMarker("si_succeed");
        mHasSignedIn = true;
    }

    private void dismissKeyboardAttemptLogin()
    {
        if (!signInController.hasServiceCallRunning())
        {
            startMetric();
            UIUtils.closeSoftKeyboard(getCurrentView());
            com.amazon.rio.j2me.client.services.mShop.NotificationTarget notificationtarget = null;
            if (MShopPushNotificationUtils.isPushNotificationAvailable())
            {
                notificationtarget = PushNotificationManager.getInstance().getNewNotificationTarget(null);
            }
            signInController.signIn(loginEmailEditText.getText().toString().trim(), loginPasswordEditText.getText().toString(), notificationtarget, userInitiatedLogin, taskCallback);
        }
    }

    private void postLogin(boolean flag, Notification notification)
    {
        callUserSignedIn(flag);
        if (notification != null)
        {
            Object obj = AmazonActivity.getTopMostBaseActivity();
            if (obj != null)
            {
                obj = (new com.amazon.mShop.AmazonAlertDialog.Builder(((android.content.Context) (obj)))).setTitle(notification.getTitle()).setMessage(notification.getMessage());
                if (!OneClickController.isOneClickNotification(notification))
                {
                    notification = null;
                    if (flag)
                    {
                        notification = new android.content.DialogInterface.OnClickListener() {

                            final LoginActivity this$0;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                finish();
                            }

            
            {
                this$0 = LoginActivity.this;
                super();
            }
                        };
                    }
                    ((com.amazon.mShop.AmazonAlertDialog.Builder) (obj)).setNegativeButton(com.amazon.mShop.android.lib.R.string.alert_dialog_ok_button, notification);
                    ((com.amazon.mShop.AmazonAlertDialog.Builder) (obj)).create().show();
                }
            }
        } else
        if (flag)
        {
            finish();
            return;
        }
    }

    private void pushSignInView()
    {
        View view = createLoginContentView();
        pushView(view);
        loginEmailEditText = (EditText)view.findViewById(com.amazon.mShop.android.lib.R.id.login_email_edit);
        loginEmailEditText.setOnKeyListener(this);
        Object obj = loginEmailEditText;
        int i;
        if (mAccountPhoneNumberNeeded)
        {
            i = com.amazon.mShop.android.lib.R.string.sign_in_email_phone_number_hint;
        } else
        {
            i = com.amazon.mShop.android.lib.R.string.sign_in_email_hint;
        }
        ((EditText) (obj)).setHint(i);
        emailTextWatcher = new LogInTextWatcher(loginEmailEditText);
        UIUtils.setMaxLengthFromRule(loginEmailEditText, com.amazon.mShop.android.lib.R.string.sign_in_email_rule);
        loginPasswordEditText = (EditText)view.findViewById(com.amazon.mShop.android.lib.R.id.login_password_edit);
        loginPasswordEditText.setOnKeyListener(this);
        passwordTextWatcher = new LogInTextWatcher(loginPasswordEditText);
        UIUtils.setMaxLengthFromRule(loginEmailEditText, com.amazon.mShop.android.lib.R.string.sign_in_password_rule);
        loginButton = (Button)view.findViewById(com.amazon.mShop.android.lib.R.id.login_button);
        loginButton.setOnClickListener(this);
        obj = User.getLastUserEmail();
        if (obj != null)
        {
            loginEmailEditText.setText(((CharSequence) (obj)));
            loginPasswordEditText.requestFocus();
        } else
        {
            view.findViewById(com.amazon.mShop.android.lib.R.id.login_layout).requestFocus();
        }
        loginButton.setEnabled(canLogin());
        loginForgotYourPassword = (TextView)view.findViewById(com.amazon.mShop.android.lib.R.id.login_forget_your_password);
        loginForgotYourPassword.setOnClickListener(this);
        changeEmailPreference = (TextView)view.findViewById(com.amazon.mShop.android.lib.R.id.change_email_preference);
        changeEmailPreference.setOnClickListener(this);
        if (!Util.isEmpty(view.getResources().getString(com.amazon.mShop.android.lib.R.string.ya_site_email_pref_button)))
        {
            changeEmailPreference.setVisibility(0);
        } else
        {
            changeEmailPreference.setVisibility(8);
        }
        createNewButton = (Button)view.findViewById(com.amazon.mShop.android.lib.R.id.login_create_new_button);
        if (createNewButton != null)
        {
            createNewButton.setOnClickListener(this);
        }
        loginLegalInformationLink = (TextView)view.findViewById(com.amazon.mShop.android.lib.R.id.login_legal_information);
        loginLegalInformationLink.setOnClickListener(this);
        obj = view.getResources().getString(com.amazon.mShop.android.lib.R.string.sign_in_legal_text);
        if (!Util.isEmpty(((String) (obj))))
        {
            loginLegalInformationLink.setText(((CharSequence) (obj)));
            loginLegalInformationLink.setVisibility(0);
        } else
        {
            loginLegalInformationLink.setVisibility(8);
        }
        mShowPassword = (CheckBox)view.findViewById(com.amazon.mShop.android.lib.R.id.show_password);
        mShowPassword.setOnClickListener(this);
    }

    private void startMetric()
    {
        mPageMetricsObserver = PageMetricsObserver.start("Signin");
    }

    private void updateLoginButtonEnabled()
    {
        Button button = loginButton;
        boolean flag;
        if (emailTextWatcher.isWatchedNonZeroLength() && passwordTextWatcher.isWatchedNonZeroLength())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        button.setEnabled(flag);
    }

    private void updateShowPassword(boolean flag)
    {
        EditText edittext = loginPasswordEditText;
        char c;
        if (flag)
        {
            c = '\220';
        } else
        {
            c = '\200';
        }
        edittext.setInputType(c | '\001');
        loginPasswordEditText.setTypeface(Typeface.DEFAULT);
        loginPasswordEditText.setText(loginPasswordEditText.getText().toString());
        loginPasswordEditText.setSelection(loginPasswordEditText.getText().length());
    }

    protected View createLoginContentView()
    {
        return new LoginView(this);
    }

    public boolean hasSignedIn()
    {
        return mHasSignedIn;
    }

    public boolean isAccountPhoneNumberNeeded()
    {
        return mAccountPhoneNumberNeeded;
    }

    public boolean isUserForceSignIn()
    {
        return mUserForceSignIn;
    }

    public void onClick(View view)
    {
        if (view.getId() == com.amazon.mShop.android.lib.R.id.login_button)
        {
            if (mShowPassword.isChecked())
            {
                mShowPassword.setChecked(false);
                updateShowPassword(false);
            }
            dismissKeyboardAttemptLogin();
            RefMarkerObserver.logRefMarker(mRefMarkerForLogin);
            RefMarkerObserver.logRefMarker("sign_in");
        } else
        {
            if (view.getId() == com.amazon.mShop.android.lib.R.id.login_forget_your_password)
            {
                pushView(new AmazonBrandedWebView(this, getResources().getString(com.amazon.mShop.android.lib.R.string.sign_in_forgot_your_password_url), getResources().getString(com.amazon.mShop.android.lib.R.string.sign_in_forgot_your_password)));
                return;
            }
            if (view.getId() == com.amazon.mShop.android.lib.R.id.change_email_preference)
            {
                pushView(new AmazonBrandedWebView(this, getResources().getString(com.amazon.mShop.android.lib.R.string.ya_site_email_pref_url), getResources().getString(com.amazon.mShop.android.lib.R.string.ya_site_email_pref_button)));
                return;
            }
            if (view.getId() == com.amazon.mShop.android.lib.R.id.login_create_new_button)
            {
                RefMarkerObserver.logRefMarker("si_newcust");
                pushView(new CreateNewAccountView(this, mRefMarkerForCreateAccount));
                return;
            }
            if (view.getId() == com.amazon.mShop.android.lib.R.id.login_legal_information)
            {
                pushView(new AmazonBrandedWebView(this, getResources().getString(com.amazon.mShop.android.lib.R.string.sign_in_legal_link_url), getResources().getString(com.amazon.mShop.android.lib.R.string.sign_in_legal_text)));
                return;
            }
            if (view.getId() == com.amazon.mShop.android.lib.R.id.show_password)
            {
                boolean flag = ((CheckBox)view).isChecked();
                updateShowPassword(flag);
                if (flag && !hasPostShowPasswordRefMarker)
                {
                    RefMarkerObserver.logRefMarker("si_pwd_show");
                    hasPostShowPasswordRefMarker = true;
                    return;
                }
                if (!flag && !hasPostHidePasswordRefMarker)
                {
                    RefMarkerObserver.logRefMarker("si_pwd_hide");
                    hasPostHidePasswordRefMarker = true;
                    return;
                }
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        signInController = new SignInController(this, false);
        taskCallback = (new TaskCallbackFactory(this)).getFinishTaskCallback(signInController, this, com.amazon.mShop.android.lib.R.string.sign_in_in_progress);
        setTitle(com.amazon.mShop.android.lib.R.string.sign_in_title);
        if (bundle != null)
        {
            finish();
        }
        bundle = getIntent().getStringExtra("REFMARKER");
        if (Util.isEmpty(bundle)) goto _L2; else goto _L1
_L1:
        mRefMarkerForLogin = bundle;
        if (!"crt_si".equals(mRefMarkerForLogin)) goto _L4; else goto _L3
_L3:
        mRefMarkerForCreateAccount = "crt_ca";
_L2:
        mAccountPhoneNumberNeeded = ActivityUtils.isAccountPhoneNumber();
        return;
_L4:
        if ("hm_si".equals(mRefMarkerForLogin))
        {
            mRefMarkerForCreateAccount = "hm_ca";
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        if (userInitiatedLogin && !loginHideMenu && !mUserForceSignIn)
        {
            return super.onCreateOptionsMenu(menu);
        } else
        {
            return false;
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
        cancelMetric();
    }

    public void onError(Exception exception, ServiceCall servicecall)
    {
        cancelMetric();
        loginPasswordEditText.setText(null);
        AmazonErrorUtils.reportMShopServerError(this, null, getCurrentView(), exception);
    }

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        while (keyevent.getAction() == 0 || view.getId() != com.amazon.mShop.android.lib.R.id.login_email_edit && view.getId() != com.amazon.mShop.android.lib.R.id.login_password_edit || !canLogin() || i != 66 && i != 23) 
        {
            return false;
        }
        dismissKeyboardAttemptLogin();
        return true;
    }

    protected void onPause()
    {
        super.onPause();
        UIUtils.closeSoftKeyboard(getCurrentView());
    }

    public boolean onSearchRequested()
    {
        if (mUserForceSignIn)
        {
            return false;
        } else
        {
            return super.onSearchRequested();
        }
    }

    public void onSignInCompleted(final boolean successful, final Notification notification)
    {
        String s;
        if (successful)
        {
            setResult(-1);
            completeMetric();
            mIsUserSignedInCalled = false;
        } else
        {
            cancelMetric();
        }
        s = getIntent().getStringExtra("LOGIN_ORIGIN_KEY");
        if (PrimeUpsellHelper.shouldTryToShowPrimeAfterLogin(s, userInitiatedLogin, isUserForceSignIn()))
        {
            if (!PrimeUpsellHelper.showPrimeUpsell(this, new com.amazon.mShop.primeupsell.PrimeUpsellHelper.PrimeUpsellSubscriber() {

        final LoginActivity this$0;
        final Notification val$notification;
        final boolean val$successful;

        public void onComplete(boolean flag)
        {
            postLogin(successful, null);
        }

        public void onPageLoadFinished()
        {
            callUserSignedIn(successful);
        }

        public void onUserCancel()
        {
            postLogin(successful, notification);
        }

            
            {
                this$0 = LoginActivity.this;
                successful = flag;
                notification = notification1;
                super();
            }
    }, PrimeUpsellHelper.getPrimeRefMarkerFromLoginOrigin(mUserForceSignIn, s)))
            {
                postLogin(successful, notification);
                return;
            } else
            {
                mForceFinishOnStop = true;
                return;
            }
        } else
        {
            postLogin(successful, notification);
            return;
        }
    }

    public void onStart()
    {
        super.onStart();
        Intent intent = getIntent();
        userInitiatedLogin = intent.getBooleanExtra("USER_INITIATED_LOGIN", false);
        loginHideMenu = intent.getBooleanExtra("LOGIN_HIDE_MENU", false);
        mUserForceSignIn = intent.getBooleanExtra("FORCE_SIGN_IN", false);
        if (intent.getBooleanExtra("IS_CREATE_NEW_ACCOUNT", false))
        {
            pushView(new CreateNewAccountView(this, mRefMarkerForCreateAccount));
            return;
        } else
        {
            pushSignInView();
            return;
        }
    }

    protected void onStop()
    {
        byte byte0;
        if (mUserForceSignIn && !mForceFinishOnStop)
        {
            byte0 = 2;
        } else
        {
            byte0 = 1;
        }
        setStopBehavior(byte0);
        super.onStop();
    }



}
