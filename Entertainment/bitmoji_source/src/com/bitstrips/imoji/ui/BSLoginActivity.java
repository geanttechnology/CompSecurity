// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.bitstrips.imoji.InjectorApplication;
import com.bitstrips.imoji.analytics.Action;
import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.analytics.Category;
import com.bitstrips.imoji.api.BSAuthResponse;
import com.bitstrips.imoji.api.BSAuthService;
import com.bitstrips.imoji.api.BitstripsService;
import com.bitstrips.imoji.auth.FacebookService;
import com.bitstrips.imoji.models.AvatarInfo;
import com.bitstrips.imoji.ui.views.Form;
import com.bitstrips.imoji.ui.views.FormField;
import com.bitstrips.imoji.util.PreferenceUtils;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.bitstrips.imoji.ui:
//            OnboardingFormBaseActivity, BSPasswordRecoveryActivity

public class BSLoginActivity extends OnboardingFormBaseActivity
{

    private static final String TAG = "BSLoginActivity";
    AnalyticsService analytics;
    BitstripsService bitstripsService;
    BSAuthService bsAuthService;
    private FormField emailField;
    FacebookService facebookService;
    private Button loginButton;
    private FormField passwordField;
    PreferenceUtils preferenceUtils;

    public BSLoginActivity()
    {
    }

    private void addFieldsToForm()
    {
        Form form = new Form(this);
        form.addField(emailField, new com.bitstrips.imoji.ui.views.Form.EmailValidator(emailField, form));
        form.addField(passwordField, new com.bitstrips.imoji.ui.views.Form.PasswordValidator(passwordField, form));
    }

    private void authorizeUser(String s, String s1)
    {
        bsAuthService.getToken("imoji", s1, "password", s, s1, new Callback() {

            final BSLoginActivity this$0;

            public void failure(RetrofitError retrofiterror)
            {
                retrofiterror = retrofiterror.getResponse();
                if (retrofiterror != null && retrofiterror.getStatus() == 400)
                {
                    showWrongEmailOrPasswordErrorDialog();
                } else
                {
                    showSignUpErrorDialog();
                }
                enableButtons();
            }

            public void success(BSAuthResponse bsauthresponse, Response response)
            {
                bsauthresponse = bsauthresponse.getAccessToken();
                preferenceUtils.putString(0x7f06003a, bsauthresponse);
                preferenceUtils.putBoolean(0x7f06008a, true);
                analytics.sendEvent(Category.AUTH, Action.LOGIN, "BSAuth login");
                getAvatarInfo(bsauthresponse);
            }

            public volatile void success(Object obj, Response response)
            {
                success((BSAuthResponse)obj, response);
            }

            
            {
                this$0 = BSLoginActivity.this;
                super();
            }
        });
    }

    private void doLogin()
    {
        disableButtons();
        authorizeUser(emailField.getText().toString(), passwordField.getText().toString());
    }

    private void getAvatarInfo(String s)
    {
        String s1 = getString(0x7f060017);
        bitstripsService.getAvatarInfo(null, s, s1, new Callback() {

            final BSLoginActivity this$0;

            public void failure(RetrofitError retrofiterror)
            {
                enableButtons();
            }

            public void success(AvatarInfo avatarinfo, Response response)
            {
                preferenceUtils.putString(0x7f06002a, avatarinfo.getId());
                setResult(-1);
                finish();
            }

            public volatile void success(Object obj, Response response)
            {
                success((AvatarInfo)obj, response);
            }

            
            {
                this$0 = BSLoginActivity.this;
                super();
            }
        });
    }

    private void goToPasswordRecovery()
    {
        Log.d("BSLoginActivity", "Go to password recovery");
        startActivity(new Intent(getApplicationContext(), com/bitstrips/imoji/ui/BSPasswordRecoveryActivity));
    }

    private void setupCustomActionBar()
    {
        setSupportActionBar((Toolbar)findViewById(0x7f0b0074));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(0x7f0600a2);
    }

    private void showSignUpErrorDialog()
    {
        (new android.app.AlertDialog.Builder(this)).setTitle(0x7f06006d).setMessage(0x7f06007b).setNeutralButton(0x104000a, new android.content.DialogInterface.OnClickListener() {

            final BSLoginActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = BSLoginActivity.this;
                super();
            }
        }).show();
    }

    private void showWrongEmailOrPasswordErrorDialog()
    {
        (new android.app.AlertDialog.Builder(this)).setTitle(0x7f06006d).setMessage(0x7f060077).setNeutralButton(0x104000a, new android.content.DialogInterface.OnClickListener() {

            final BSLoginActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = BSLoginActivity.this;
                super();
            }
        }).show();
    }

    public Menu getOptionsMenu()
    {
        return mOptionsMenu;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        ((InjectorApplication)getApplication()).inject(this);
        setContentView(0x7f030021);
        setupCustomActionBar();
        emailField = (FormField)findViewById(0x7f0b0091);
        passwordField = (FormField)findViewById(0x7f0b0092);
        loginButton = (Button)findViewById(0x7f0b0093);
        setMainButton(loginButton);
        addFieldsToForm();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f0e0002, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onForgotPasswordClicked(View view)
    {
        goToPasswordRecovery();
    }

    public void onLoginClicked(View view)
    {
        doLogin();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        int i = menuitem.getItemId();
        if (i == 0x7f0b0113)
        {
            doLogin();
            return true;
        }
        if (i == 0x102002c)
        {
            finish();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void onPause()
    {
        super.onPause();
        facebookService.logDeactivate(this);
    }

    public void onResume()
    {
        super.onResume();
        facebookService.logActivate(this);
    }

    protected void onStart()
    {
        super.onStart();
        analytics.reportStart(this);
    }

    protected void onStop()
    {
        super.onStop();
        analytics.reportStop(this);
    }



}
