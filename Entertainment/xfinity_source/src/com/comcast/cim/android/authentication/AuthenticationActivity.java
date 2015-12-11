// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.authentication;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.comcast.cim.android.view.common.BaseActivity;
import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import com.comcast.cim.cmasl.http.exceptions.CimHttpException;
import com.comcast.cim.cmasl.utils.exceptions.CimException;
import com.comcast.cim.cmasl.xip.XipHttpErrorException;
import com.comcast.cim.container.CALContainer;
import com.comcast.cim.model.user.AuthKeys;
import com.comcast.cim.model.user.XipUser;
import com.comcast.cim.model.user.XipUserManager;

// Referenced classes of package com.comcast.cim.android.authentication:
//            SignInListener, UserCredentials

public abstract class AuthenticationActivity extends BaseActivity
{
    private class HTCEditTextFix
        implements TextWatcher
    {

        private EditText mEditText;
        final AuthenticationActivity this$0;

        public void afterTextChanged(Editable editable)
        {
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            mEditText.getText().setSpan(new ForegroundColorSpan(-1), i, i, 33);
        }

        public HTCEditTextFix(EditText edittext)
        {
            this$0 = AuthenticationActivity.this;
            super();
            mEditText = edittext;
        }
    }


    private Handler handler;
    private InternetConnection internetConnection;
    private EditText passwordField;
    private SignInListener signInListener;
    private View signinButton;
    private TextView signinButtonLabel;
    private EditText userIdField;
    private ViewFlipper viewFlipper;

    public AuthenticationActivity()
    {
        signInListener = CALContainer.getInstance().getSignInListener();
        handler = new Handler();
        internetConnection = CALContainer.getInstance().getInternetConnection();
    }

    private void applyListener(int i, final int urlId)
    {
        View view = findViewById(i);
        if (view != null)
        {
            view.setOnClickListener(new android.view.View.OnClickListener() {

                final AuthenticationActivity this$0;
                final int val$urlId;

                public void onClick(View view1)
                {
                    view1 = new Bundle();
                    view1.putParcelable("uri", Uri.parse(getResources().getString(urlId)));
                    CALDialogFragment caldialogfragment = CALDialogFragment.newInstance("openAnotherAppDlg");
                    caldialogfragment.addArguments(view1);
                    caldialogfragment.show(getFragmentManager(), "caldialogfragment");
                }

            
            {
                this$0 = AuthenticationActivity.this;
                urlId = i;
                super();
            }
            });
        }
    }

    private void clearIdAndPasswordEditTexts()
    {
        userIdField.getEditableText().clear();
        passwordField.getEditableText().clear();
    }

    private android.content.DialogInterface.OnCancelListener createSigninErrorCancelListener()
    {
        return new android.content.DialogInterface.OnCancelListener() {

            final AuthenticationActivity this$0;

            public void onCancel(DialogInterface dialoginterface)
            {
                hideSigningInSpinner();
            }

            
            {
                this$0 = AuthenticationActivity.this;
                super();
            }
        };
    }

    private XipUser fetchCurrentUserData()
    {
        return (XipUser)getUserManager().getUser();
    }

    private void prepForSignIn()
    {
        clearIdAndPasswordEditTexts();
        hideSigningInSpinner();
        handler.post(new Runnable() {

            final AuthenticationActivity this$0;

            public void run()
            {
                if (viewFlipper != null)
                {
                    viewFlipper.setDisplayedChild(1);
                }
            }

            
            {
                this$0 = AuthenticationActivity.this;
                super();
            }
        });
    }

    private void updateUser(XipUser xipuser)
    {
        getUserManager().setUser(xipuser);
    }

    protected int getErrorResourceForException(Exception exception)
    {
        int j = com.comcast.cim.android.R.string.UNKNOWN_ERROR;
        if (!(exception instanceof CimHttpException)) goto _L2; else goto _L1
_L1:
        int i;
label0:
        {
            exception = (CimHttpException)exception;
            int k = exception.getStatusCode();
            if (exception.getDetailedStatusCode() != 3004 && k != 401)
            {
                i = j;
                if (k != 403)
                {
                    break label0;
                }
            }
            i = com.comcast.cim.android.R.string.ENTER_VALID_CREDENTIALS;
        }
_L4:
        return i;
_L2:
        i = j;
        if (exception instanceof CimException)
        {
            i = j;
            if (internetConnection.isConnected())
            {
                return com.comcast.cim.android.R.string.CHECK_INTERNET_CONNECTION;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected String getPassword()
    {
        if (passwordField == null)
        {
            return null;
        } else
        {
            return passwordField.getText().toString().trim();
        }
    }

    protected abstract XipUserManager getUserManager();

    protected String getUsername()
    {
        if (userIdField == null)
        {
            return null;
        } else
        {
            return userIdField.getText().toString().trim();
        }
    }

    public IBinder getWindowToken()
    {
        return passwordField.getWindowToken();
    }

    protected void hideSigningInSpinner()
    {
        signinButton.findViewById(com.comcast.cim.android.R.id.sign_in_progress).setVisibility(8);
        signinButtonLabel.setText("Sign In");
        userIdField.setEnabled(true);
        passwordField.setEnabled(true);
        signinButton.setEnabled(true);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(com.comcast.cim.android.R.layout.sign_in);
        passwordField = (EditText)findViewById(com.comcast.cim.android.R.id.password);
        userIdField = (EditText)findViewById(com.comcast.cim.android.R.id.user_id);
        signinButton = findViewById(com.comcast.cim.android.R.id.sign_in);
        signinButtonLabel = (TextView)findViewById(com.comcast.cim.android.R.id.sign_in_label);
        viewFlipper = (ViewFlipper)findViewById(com.comcast.cim.android.R.id.flipper);
        passwordField.setTypeface(userIdField.getTypeface(), 0);
        passwordField.setOnEditorActionListener(signInListener);
        signinButton = findViewById(com.comcast.cim.android.R.id.sign_in);
        signinButton.setOnClickListener(signInListener);
        findViewById(com.comcast.cim.android.R.id.need_id).setOnClickListener(new android.view.View.OnClickListener() {

            final AuthenticationActivity this$0;

            public void onClick(View view)
            {
                CALDialogFragment.newInstance("hsdPromptDlg").show(getFragmentManager(), "caldialogfragment");
            }

            
            {
                this$0 = AuthenticationActivity.this;
                super();
            }
        });
        applyListener(com.comcast.cim.android.R.id.forgot_password, com.comcast.cim.android.R.string.URL_FORGOT_PASSWORD);
        applyListener(com.comcast.cim.android.R.id.need_help_icon, com.comcast.cim.android.R.string.URL_NEED_HELP);
        applyListener(com.comcast.cim.android.R.id.need_help_signing_in, com.comcast.cim.android.R.string.URL_NEED_HELP);
        userIdField.addTextChangedListener(new HTCEditTextFix(userIdField));
        passwordField.addTextChangedListener(new HTCEditTextFix(passwordField));
        (new AsyncTask() {

            final AuthenticationActivity this$0;

            protected transient XipUser doInBackground(Void avoid[])
            {
                return fetchCurrentUserData();
            }

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected void onPostExecute(XipUser xipuser)
            {
                if (xipuser == null)
                {
                    hideSigningInSpinner();
                    return;
                }
                if (xipuser.equals(getUserManager().getUser()))
                {
                    updateUser(xipuser);
                    setResult(1);
                    finish();
                    return;
                } else
                {
                    updateUser(xipuser);
                    setResult(2);
                    finish();
                    return;
                }
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((XipUser)obj);
            }

            
            {
                this$0 = AuthenticationActivity.this;
                super();
            }
        }).execute(new Void[0]);
    }

    protected void onPostSignIn()
    {
    }

    protected void onResume()
    {
        super.onResume();
        if (viewFlipper != null)
        {
            viewFlipper.setDisplayedChild(0);
        }
        prepForSignIn();
    }

    public boolean onSearchRequested()
    {
        return false;
    }

    public void onSigninFailed(final Exception exception)
    {
        if (!isFinishing())
        {
            handler.post(new Runnable() {

                final AuthenticationActivity this$0;
                final Exception val$exception;

                public void run()
                {
                    hideSigningInSpinner();
                    Bundle bundle = new Bundle();
                    CALDialogFragment caldialogfragment = CALDialogFragment.newInstance("errorDlg");
                    if ((exception instanceof XipHttpErrorException) && ((XipHttpErrorException)exception).getDetailedStatusCode() == 3009)
                    {
                        bundle.putString("description", getResources().getString(com.comcast.cim.android.R.string.XIP_ERROR_CLOCK_SKEW));
                        caldialogfragment.addArguments(bundle);
                        caldialogfragment.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                            final _cls5 this$1;

                            public void onCancel(DialogInterface dialoginterface)
                            {
                                startActivity((new Intent("android.settings.DATE_SETTINGS")).addFlags(0x10000000));
                            }

            
            {
                this$1 = _cls5.this;
                super();
            }
                        });
                    } else
                    {
                        int i = getErrorResourceForException(exception);
                        bundle.putString("description", getResources().getString(i));
                        caldialogfragment.addArguments(bundle);
                        caldialogfragment.setOnCancelListener(createSigninErrorCancelListener());
                    }
                    caldialogfragment.show(getFragmentManager(), "caldialogfragment");
                }

            
            {
                this$0 = AuthenticationActivity.this;
                exception = exception1;
                super();
            }
            });
        }
    }

    public void onSigninSuccess(final UserCredentials userCredentials, final AuthKeys authKeys)
    {
        if (!isFinishing())
        {
            handler.post(new Runnable() {

                final AuthenticationActivity this$0;
                final AuthKeys val$authKeys;
                final UserCredentials val$userCredentials;

                public void run()
                {
                    XipUser xipuser = getUserManager().createUser(userCredentials, authKeys);
                    updateUser(xipuser);
                    setResult(3);
                    onPostSignIn();
                    finish();
                }

            
            {
                this$0 = AuthenticationActivity.this;
                userCredentials = usercredentials;
                authKeys = authkeys;
                super();
            }
            });
        }
    }

    public void showSigningInSpinner()
    {
        signinButton.findViewById(com.comcast.cim.android.R.id.sign_in_progress).setVisibility(0);
        signinButtonLabel.setText("Signing In");
        userIdField.setEnabled(false);
        passwordField.setEnabled(false);
        signinButton.setEnabled(false);
    }

    public void showZeroLengthDialog()
    {
        Bundle bundle = new Bundle();
        bundle.putString("description", getResources().getString(com.comcast.cim.android.R.string.zero_length_userpass_error));
        CALDialogFragment caldialogfragment = CALDialogFragment.newInstance("errorDlg");
        caldialogfragment.addArguments(bundle);
        caldialogfragment.show(getFragmentManager(), "caldialogfragment");
    }




}
