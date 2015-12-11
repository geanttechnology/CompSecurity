// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.bitstrips.imoji.InjectorApplication;
import com.bitstrips.imoji.api.BSAuthPasswordResetResponse;
import com.bitstrips.imoji.api.BSAuthPasswordService;
import com.bitstrips.imoji.auth.FacebookService;
import com.bitstrips.imoji.ui.views.Form;
import com.bitstrips.imoji.ui.views.FormField;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class BSPasswordRecoveryActivity extends AppCompatActivity
    implements com.bitstrips.imoji.ui.views.Form.ValidationCallbacksActivity
{

    private static final String TAG = "BSPasswordRecovery";
    BSAuthPasswordService bsAuthPasswordService;
    private FormField emailField;
    FacebookService facebookService;
    private Button submitButton;

    public BSPasswordRecoveryActivity()
    {
    }

    private void addFieldsToForm()
    {
        Form form = new Form(this);
        form.addField(emailField, new com.bitstrips.imoji.ui.views.Form.EmailValidator(emailField, form));
    }

    private void disableButtons()
    {
        submitButton.setEnabled(false);
    }

    private void displayErrorDialog()
    {
        (new android.app.AlertDialog.Builder(this)).setTitle(0x7f06006d).setMessage(0x7f06006c).setPositiveButton(0x7f060079, new android.content.DialogInterface.OnClickListener() {

            final BSPasswordRecoveryActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                doResetPassword();
            }

            
            {
                this$0 = BSPasswordRecoveryActivity.this;
                super();
            }
        }).setNeutralButton(0x1040000, null).show();
    }

    private void doResetPassword()
    {
        requestPasswordResetEmail(emailField.getText().toString());
    }

    private void enableButtons()
    {
        submitButton.setEnabled(true);
    }

    private void requestPasswordResetEmail(String s)
    {
        disableButtons();
        bsAuthPasswordService.resetPassword(s, new Callback() {

            final BSPasswordRecoveryActivity this$0;

            public void failure(RetrofitError retrofiterror)
            {
                Log.e("BSPasswordRecovery", "Unable to contact password recovery service.");
                displayErrorDialog();
                enableButtons();
            }

            public void success(BSAuthPasswordResetResponse bsauthpasswordresetresponse, Response response)
            {
                findViewById(0x7f0b0095).setVisibility(8);
                findViewById(0x7f0b0096).setVisibility(0);
                Log.d("BSPasswordRecovery", (new StringBuilder()).append("TOKEN: ").append(bsauthpasswordresetresponse.getPasswordResetToken()).toString());
            }

            public volatile void success(Object obj, Response response)
            {
                success((BSAuthPasswordResetResponse)obj, response);
            }

            
            {
                this$0 = BSPasswordRecoveryActivity.this;
                super();
            }
        });
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        ((InjectorApplication)getApplication()).inject(this);
        setContentView(0x7f030022);
        setSupportActionBar((Toolbar)findViewById(0x7f0b0074));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        emailField = (FormField)findViewById(0x7f0b0091);
        submitButton = (Button)findViewById(0x7f0b0097);
        addFieldsToForm();
    }

    public void onInvalidData()
    {
        disableButtons();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            onBackPressed();
            break;
        }
        return true;
    }

    protected void onPause()
    {
        super.onPause();
        facebookService.logDeactivate(this);
    }

    public void onResetPasswordClicked(View view)
    {
        doResetPassword();
    }

    public void onResume()
    {
        super.onResume();
        findViewById(0x7f0b0095).setVisibility(0);
        findViewById(0x7f0b0096).setVisibility(8);
        facebookService.logActivate(this);
    }

    public void onValidData()
    {
        enableButtons();
    }



}
