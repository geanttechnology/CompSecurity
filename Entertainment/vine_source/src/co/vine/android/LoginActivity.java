// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import co.vine.android.api.VineLogin;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.client.Session;
import co.vine.android.util.Util;
import co.vine.android.widget.Typefaces;
import co.vine.android.widgets.PromptDialogSupportFragment;

// Referenced classes of package co.vine.android:
//            BaseControllerActionBarActivity, StartActivity, ResetPasswordActivity

public class LoginActivity extends BaseControllerActionBarActivity
    implements TextWatcher, android.view.View.OnClickListener, co.vine.android.widgets.PromptDialogSupportFragment.OnDialogDoneListener
{
    class LoginSessionListener extends AppSessionListener
    {

        final LoginActivity this$0;

        public void onLoginComplete(Session session, String s, int i, String s1, int j, VineLogin vinelogin)
        {
            completeLogin(i, s1, j);
            mAppController.getEditions();
            dismissDialog();
        }

        LoginSessionListener()
        {
            this$0 = LoginActivity.this;
            super();
        }
    }


    private static final int DIALOG_ACTIVATE_ACCOUNT = 1;
    public static final String EXTRA_FINISH = "finish";
    private boolean mFinish;
    private MenuItem mLoginButton;
    private EditText mPassword;
    private EditText mUsername;

    public LoginActivity()
    {
    }

    public static Intent getIntent(Context context)
    {
        return new Intent(context, co/vine/android/LoginActivity);
    }

    public static Intent getIntentWithFinish(Context context)
    {
        context = new Intent(context, co/vine/android/LoginActivity);
        context.putExtra("finish", true);
        return context;
    }

    private void login(boolean flag)
    {
        Object obj = mUsername.getText().toString();
        String s = mPassword.getText().toString();
        Object obj1 = new ProgressDialog(this, 0x7f0f0037);
        ((ProgressDialog) (obj1)).setProgressStyle(0);
        ((ProgressDialog) (obj1)).setMessage(getString(0x7f0e0120));
        try
        {
            ((ProgressDialog) (obj1)).show();
        }
        catch (Exception exception) { }
        mProgressDialog = ((ProgressDialog) (obj1));
        obj1 = mAppController.getSession(((String) (obj)));
        obj = new VineLogin(null, ((String) (obj)), 0L, null);
        mAppController.login(((Session) (obj1)), ((VineLogin) (obj)), s, flag);
    }

    private boolean validate()
    {
        return mUsername.length() >= 3 && mPassword.length() >= 8;
    }

    public void afterTextChanged(Editable editable)
    {
        if (mLoginButton != null)
        {
            mLoginButton.setEnabled(validate());
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    void completeLogin(int i, String s, int j)
    {
        switch (i)
        {
        default:
            if (j == co.vine.android.api.VineError.VineKnownErrors.ACCOUNT_DEACTIVATED.code)
            {
                s = PromptDialogSupportFragment.newInstance(1);
                s.setMessage(0x7f0e01ce);
                s.setTitle(0x7f0e01cf);
                s.setNegativeButton(0x7f0e0057);
                s.setPositiveButton(0x7f0e01cd);
                s.show(getSupportFragmentManager());
                return;
            } else
            {
                Util.showCenteredToast(this, s);
                return;
            }

        case 200: 
            break;
        }
        if (!mFinish)
        {
            StartActivity.toStart(this);
        }
        finish();
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131362074: 
            view = new Intent(this, co/vine/android/ResetPasswordActivity);
            break;
        }
        String s = mUsername.getText().toString();
        if (!TextUtils.isEmpty(s))
        {
            view.putExtra("email", s);
        }
        startActivity(view);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f030051, false);
        setupActionBar(Boolean.valueOf(true), Boolean.valueOf(true), 0x7f0e0123, Boolean.valueOf(true));
        mAppSessionListener = new LoginSessionListener();
        mUsername = (EditText)findViewById(0x7f0a0115);
        mUsername.setTypeface(Typefaces.get(this).getContentTypeface(0, 2));
        mUsername.addTextChangedListener(this);
        mPassword = (EditText)findViewById(0x7f0a0118);
        mPassword.setTypeface(Typefaces.get(this).getContentTypeface(0, 2));
        mPassword.addTextChangedListener(this);
        mPassword.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final LoginActivity this$0;

            public boolean onEditorAction(TextView textview1, int i, KeyEvent keyevent)
            {
                if (keyevent != null && keyevent.getKeyCode() == 66 || i == 6 && validate())
                {
                    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(mPassword.getWindowToken(), 0);
                    login(false);
                }
                return true;
            }

            
            {
                this$0 = LoginActivity.this;
                super();
            }
        });
        bundle = new StyleSpan(1);
        TextView textview = (TextView)findViewById(0x7f0a011a);
        String s = getString(0x7f0e011f);
        textview.setText(Util.getSpannedText(new StyleSpan[] {
            bundle
        }, s, '"'), android.widget.TextView.BufferType.SPANNABLE);
        textview.setOnClickListener(this);
        bundle = getIntent();
        if (bundle != null)
        {
            mFinish = bundle.getBooleanExtra("finish", false);
            return;
        } else
        {
            mFinish = false;
            return;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f100008, menu);
        mLoginButton = menu.findItem(0x7f0a0248);
        return true;
    }

    public void onDialogDone(DialogInterface dialoginterface, int i, int j)
    {
        i;
        JVM INSTR tableswitch 1 1: default 20
    //                   1 21;
           goto _L1 _L2
_L1:
        return;
_L2:
        switch (j)
        {
        default:
            return;

        case -2: 
            continue; /* Loop/switch isn't completed */

        case -1: 
            login(true);
            break;
        }
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131362376: 
            break;
        }
        if (validate())
        {
            login(false);
        }
        return true;
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }



}
