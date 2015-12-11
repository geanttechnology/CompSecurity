// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorActivity;
import android.accounts.AccountManager;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import co.vine.android.client.AppController;
import co.vine.android.client.VineAccountHelper;
import co.vine.android.service.VineService;
import co.vine.android.service.VineServiceCallback;
import co.vine.android.service.VineServiceResponder;

public class AuthenticatorActivity extends AccountAuthenticatorActivity
{

    private static final int DIALOG_PROGRESS_ID = 1;
    public static final String PARAM_AUTH_TOKEN_TYPE = "auth_token_type";
    public static final String PARAM_CONFIRM_CREDENTIALS = "confirm_credentials";
    public static final String PARAM_USERNAME = "username";
    private AccountManager mAccountManager;
    Boolean mConfirmCredentials;
    private String mLoginEmail;
    private EditText mPasswordEditView;

    public AuthenticatorActivity()
    {
    }

    private void saveAuth(String s)
    {
        Account account = new Account(mLoginEmail, VineAccountHelper.ACCOUNT_TYPE);
        mAccountManager.setAuthToken(account, "co.vine.android.basic_auth.token.secret", s);
    }

    void finishConfirmCredentials(String s, boolean flag)
    {
        saveAuth(s);
        s = new Intent();
        s.putExtra("booleanResult", flag);
        setAccountAuthenticatorResult(s.getExtras());
        setResult(-1, s);
        finish();
    }

    void finishLogin(String s)
    {
        saveAuth(s);
        Object obj = new Intent();
        ((Intent) (obj)).putExtra("authAccount", mLoginEmail);
        ((Intent) (obj)).putExtra("accountType", VineAccountHelper.ACCOUNT_TYPE);
        ((Intent) (obj)).putExtra("authtoken", s);
        setAccountAuthenticatorResult(((Intent) (obj)).getExtras());
        setResult(-1, ((Intent) (obj)));
        obj = AppController.getInstance(this);
        if (((AppController) (obj)).isLoggedIn())
        {
            ((AppController) (obj)).updateCredentials(s);
        }
        finish();
    }

    public void onClickHandler(View view)
    {
        view = mPasswordEditView.getText().toString();
        if (TextUtils.isEmpty(view))
        {
            return;
        } else
        {
            showDialog(1);
            VineServiceResponder vineserviceresponder = new VineServiceResponder() {

                final AuthenticatorActivity this$0;

                public void onServiceResponse(int i, int j, String s, Bundle bundle)
                {
                    removeDialog(1);
                    if (j == 200)
                    {
                        s = bundle.getString("s_key");
                        if (!mConfirmCredentials.booleanValue())
                        {
                            finishLogin(s);
                            return;
                        } else
                        {
                            finishConfirmCredentials(s, true);
                            return;
                        }
                    } else
                    {
                        throw new UnsupportedOperationException("handle bad password scenario");
                    }
                }

            
            {
                this$0 = AuthenticatorActivity.this;
                super();
            }
            };
            Intent intent = new Intent(this, co/vine/android/service/VineService);
            intent.setAction("co.vine.android.session.login");
            intent.putExtra("login", mLoginEmail);
            intent.putExtra("pass", view);
            intent.putExtra("ibinder", new VineServiceCallback(vineserviceresponder));
            startService(intent);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(3);
        setContentView(0x7f030051);
        getWindow().setFeatureDrawableResource(3, 0x1080027);
        mAccountManager = AccountManager.get(this);
        bundle = getIntent();
        mLoginEmail = bundle.getStringExtra("username");
        mConfirmCredentials = Boolean.valueOf(bundle.getBooleanExtra("confirm_credentials", false));
        ((TextView)findViewById(0x7f0a0115)).setText(mLoginEmail);
        mPasswordEditView = (EditText)findViewById(0x7f0a0118);
    }

    protected Dialog onCreateDialog(int i)
    {
        ProgressDialog progressdialog;
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            progressdialog = new ProgressDialog(this, 0x7f0f0037);
            break;
        }
        progressdialog.setMessage(getText(0x7f0e0120));
        progressdialog.setIndeterminate(true);
        progressdialog.setCancelable(true);
        return progressdialog;
    }
}
