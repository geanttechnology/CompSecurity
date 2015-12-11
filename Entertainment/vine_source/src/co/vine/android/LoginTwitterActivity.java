// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import co.vine.android.api.VineLogin;
import co.vine.android.api.VineUser;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.Util;
import co.vine.android.widget.SpanClickListener;
import co.vine.android.widget.StyledClickableSpan;
import co.vine.android.widget.Typefaces;
import co.vine.android.widgets.PromptDialogSupportFragment;

// Referenced classes of package co.vine.android:
//            BaseControllerActionBarActivity, WebViewActivity, VineLoggingException, StartActivity, 
//            SignUpPagerActivity

public class LoginTwitterActivity extends BaseControllerActionBarActivity
    implements TextWatcher, SpanClickListener, co.vine.android.widgets.PromptDialogSupportFragment.OnDialogDoneListener
{
    class LoginTwitterListener extends AppSessionListener
    {

        final LoginTwitterActivity this$0;

        public void onCheckTwitterComplete(String s, int i, String s1, int j, boolean flag, VineUser vineuser, VineLogin vinelogin)
        {
            if (!flag || i != 200)
            {
                break MISSING_BLOCK_LABEL_95;
            }
            mAppController.loginComplete(mAppController.getActiveSession(), i, vineuser.username, null, vinelogin, vineuser.avatarUrl);
            if (mFinish)
            {
                finish();
                return;
            }
            try
            {
                StartActivity.toStart(LoginTwitterActivity.this);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Util.showCenteredToast(LoginTwitterActivity.this, 0x7f0e00d7);
            }
            CrashUtil.logException(s);
            finish();
            return;
            dismissDialog();
            if (i == 400)
            {
                s = new Bundle();
                s.putParcelable("user", vinelogin);
                startActivity(SignUpPagerActivity.getIntent(LoginTwitterActivity.this, s));
                return;
            }
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
                Util.showCenteredToast(LoginTwitterActivity.this, s1);
                return;
            }
        }

        public void onTwitterxAuthComplete(String s, int i, String s1, VineLogin vinelogin)
        {
            if (mFinish)
            {
                if (i == 200)
                {
                    if (!mAppController.isLoggedIn())
                    {
                        mAppController.loginCheckTwitter(vinelogin.twitterUsername, vinelogin.twitterToken, vinelogin.twitterSecret, vinelogin.twitterUserId, false);
                        return;
                    } else
                    {
                        s = new Intent();
                        s.putExtra("token", vinelogin.twitterToken);
                        s.putExtra("secret", vinelogin.twitterSecret);
                        s.putExtra("user_id", vinelogin.twitterUserId);
                        s.putExtra("screen_name", vinelogin.twitterUsername);
                        setResult(-1, s);
                        finish();
                        return;
                    }
                } else
                {
                    dismissDialog();
                    Util.showCenteredToast(LoginTwitterActivity.this, 0x7f0e00f2);
                    return;
                }
            }
            if (i == 200 && vinelogin != null)
            {
                mVineLogin = vinelogin;
                mAppController.loginCheckTwitter(vinelogin.twitterUsername, vinelogin.twitterToken, vinelogin.twitterSecret, vinelogin.twitterUserId, false);
                return;
            }
            dismissDialog();
            if (!TextUtils.isEmpty(s1))
            {
                Util.showCenteredToast(LoginTwitterActivity.this, s1);
                return;
            } else
            {
                Util.showCenteredToast(LoginTwitterActivity.this, 0x7f0e00d0);
                return;
            }
        }

        LoginTwitterListener()
        {
            this$0 = LoginTwitterActivity.this;
            super();
        }
    }


    private static final int DIALOG_ACTIVATE_ACCOUNT = 1;
    public static final String EXTRA_FINISH = "finish";
    public static final String EXTRA_SCREEN_NAME = "screen_name";
    public static final String EXTRA_SECRET = "secret";
    public static final String EXTRA_TOKEN = "token";
    public static final String EXTRA_USER_ID = "user_id";
    private static final int SPAN_VINE_PP = 1;
    private static final int SPAN_VINE_TOS = 2;
    private static final String STATE_VINE_LOGIN = "vine_login";
    private boolean mFinish;
    private EditText mPassword;
    private MenuItem mSignIn;
    private EditText mUsername;
    private VineLogin mVineLogin;

    public LoginTwitterActivity()
    {
    }

    public static Intent getIntent(Context context)
    {
        return new Intent(context, co/vine/android/LoginTwitterActivity);
    }

    public static Intent getIntentWithFinish(Context context)
    {
        context = new Intent(context, co/vine/android/LoginTwitterActivity);
        context.putExtra("finish", true);
        return context;
    }

    private void login(boolean flag)
    {
label0:
        {
            if (validate())
            {
                Object obj = new ProgressDialog(this, 0x7f0f0037);
                ((ProgressDialog) (obj)).setMessage(getString(0x7f0e021d));
                ((ProgressDialog) (obj)).setProgress(0);
                try
                {
                    ((ProgressDialog) (obj)).show();
                }
                catch (android.view.WindowManager.BadTokenException badtokenexception) { }
                mProgressDialog = ((ProgressDialog) (obj));
                if (flag)
                {
                    break label0;
                }
                mAppController.loginWithxAuth(mUsername.getText().toString(), mPassword.getText().toString());
            }
            return;
        }
        if (mVineLogin != null)
        {
            obj = mVineLogin;
            mAppController.loginCheckTwitter(((VineLogin) (obj)).twitterUsername, ((VineLogin) (obj)).twitterToken, ((VineLogin) (obj)).twitterSecret, ((VineLogin) (obj)).twitterUserId, true);
            return;
        } else
        {
            Util.showCenteredToast(this, 0x7f0e00d0);
            return;
        }
    }

    private boolean validate()
    {
        return mUsername.length() >= 1 && mPassword.length() >= 1;
    }

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f0300aa, false);
        setupActionBar(Boolean.valueOf(true), Boolean.valueOf(true), 0x7f0e012b, Boolean.valueOf(true));
        mUsername = (EditText)findViewById(0x7f0a0115);
        mUsername.setTypeface(Typefaces.get(this).getContentTypeface(0, 2));
        mUsername.addTextChangedListener(this);
        mPassword = (EditText)findViewById(0x7f0a0118);
        mPassword.setTypeface(Typefaces.get(this).getContentTypeface(0, 2));
        mPassword.addTextChangedListener(this);
        mPassword.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final LoginTwitterActivity this$0;

            public boolean onEditorAction(TextView textview, int k, KeyEvent keyevent)
            {
                if (keyevent != null && keyevent.getKeyCode() == 66 || k == 6)
                {
                    login(false);
                }
                return false;
            }

            
            {
                this$0 = LoginTwitterActivity.this;
                super();
            }
        });
        mFinish = getIntent().getBooleanExtra("finish", false);
        mAppSessionListener = new LoginTwitterListener();
        Object obj1 = (TextView)findViewById(0x7f0a021e);
        Object obj = new StyleSpan(1);
        Object obj2 = new StyleSpan(1);
        String s = getString(0x7f0e012d);
        obj = Util.getSpannedText(new StyleSpan[] {
            obj, obj2
        }, s, '"');
        ((TextView) (obj1)).setText(((CharSequence) (obj)));
        ((TextView) (obj1)).setMovementMethod(LinkMovementMethod.getInstance());
        obj1 = (Spannable)((TextView) (obj1)).getText();
        StyleSpan astylespan[] = (StyleSpan[])((Spanned) (obj)).getSpans(0, ((Spanned) (obj)).length(), android/text/style/StyleSpan);
        obj2 = getResources();
        int i = ((Spanned) (obj)).getSpanStart(astylespan[0]);
        int j = ((Spanned) (obj)).getSpanEnd(astylespan[0]);
        StyledClickableSpan styledclickablespan = new StyledClickableSpan(2, null, this);
        styledclickablespan.setColor(((Resources) (obj2)).getColor(0x7f09008d));
        Util.safeSetSpan(((Spannable) (obj1)), styledclickablespan, i, j, 33);
        if (bundle != null && bundle.containsKey("vine_login"))
        {
            mVineLogin = (VineLogin)bundle.getParcelable("vine_login");
        }
        i = ((Spanned) (obj)).getSpanStart(astylespan[1]);
        j = ((Spanned) (obj)).getSpanEnd(astylespan[1]);
        bundle = new StyledClickableSpan(1, null, this);
        bundle.setColor(((Resources) (obj2)).getColor(0x7f09008d));
        Util.safeSetSpan(((Spannable) (obj1)), bundle, i, j, 33);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f100008, menu);
        mSignIn = menu.findItem(0x7f0a0248);
        return true;
    }

    public void onDialogDone(DialogInterface dialoginterface, int i, int j)
    {
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
            switch (j)
            {
            default:
                return;

            case -1: 
                login(true);
                break;
            }
            break;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131362376: 
            login(false);
            break;
        }
        return true;
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (mVineLogin != null)
        {
            bundle.putParcelable("vine_login", mVineLogin);
        }
    }

    public void onSpanClicked(View view, int i, Object obj)
    {
        view = new Intent(this, co/vine/android/WebViewActivity);
        i;
        JVM INSTR tableswitch 1 2: default 36
    //                   1 37
    //                   2 52;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        view.putExtra("type", 1);
_L5:
        startActivity(view);
        return;
_L3:
        view.putExtra("type", 2);
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (mSignIn != null)
        {
            mSignIn.setEnabled(validate());
        }
    }




/*
    static VineLogin access$202(LoginTwitterActivity logintwitteractivity, VineLogin vinelogin)
    {
        logintwitteractivity.mVineLogin = vinelogin;
        return vinelogin;
    }

*/
}
