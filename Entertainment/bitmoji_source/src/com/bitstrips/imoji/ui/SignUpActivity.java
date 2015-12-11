// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bitstrips.imoji.InjectorApplication;
import com.bitstrips.imoji.analytics.Action;
import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.analytics.Category;
import com.bitstrips.imoji.api.BSAuthResponse;
import com.bitstrips.imoji.api.BSAuthService;
import com.bitstrips.imoji.api.BitstripsService;
import com.bitstrips.imoji.auth.FacebookService;
import com.bitstrips.imoji.manager.FloaterServiceManager;
import com.bitstrips.imoji.models.BSAuthEmailLookup;
import com.bitstrips.imoji.models.BSUser;
import com.bitstrips.imoji.models.LinkAccountsResult;
import com.bitstrips.imoji.ui.tasks.GetImageTask;
import com.bitstrips.imoji.ui.views.Form;
import com.bitstrips.imoji.ui.views.FormField;
import com.bitstrips.imoji.util.PreferenceUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.bitstrips.imoji.ui:
//            OnboardingFormBaseActivity, ImageLoader, RetrieveAvatarActivity

public class SignUpActivity extends OnboardingFormBaseActivity
{

    public static final int MIN_PASSWORD_LENGTH = 6;
    private static final String TAG = "SignUpActivity";
    AnalyticsService analytics;
    BitstripsService bitstripsService;
    BSAuthService bsAuthService;
    private FormField emailField;
    FacebookService facebookService;
    private FormField firstNameField;
    FloaterServiceManager floaterServiceManager;
    ImageLoader imageLoader;
    private FormField lastNameField;
    private FormField passwordField;
    PreferenceUtils preferenceUtils;
    private Button submitButton;

    public SignUpActivity()
    {
    }

    private void addFieldsToForm()
    {
        Form form = new Form(this);
        form.addField(firstNameField, new com.bitstrips.imoji.ui.views.Form.RequiredFieldValidator(firstNameField, form));
        form.addField(lastNameField, new com.bitstrips.imoji.ui.views.Form.RequiredFieldValidator(lastNameField, form));
        form.addField(emailField, new com.bitstrips.imoji.ui.views.Form.EmailValidator(emailField, form));
        form.addField(passwordField, new com.bitstrips.imoji.ui.views.Form.PasswordValidator(passwordField, form));
    }

    private void attemptToPopulateEmailField()
    {
        FormField formfield = (FormField)findViewById(0x7f0b0091);
        String s = "";
        Account aaccount[] = AccountManager.get(this).getAccounts();
        int j = aaccount.length;
        for (int i = 0; i < j; i++)
        {
            Account account = aaccount[i];
            if (Patterns.EMAIL_ADDRESS.matcher(account.name).matches())
            {
                s = account.name;
            }
        }

        if (!TextUtils.isEmpty(s))
        {
            formfield.setText(s);
        }
    }

    private void attemptToPopulateFirstAndLastName()
    {
        Object obj = getIntent();
        String s = ((Intent) (obj)).getStringExtra(getString(0x7f06007c));
        obj = ((Intent) (obj)).getStringExtra(getString(0x7f06007d));
        if (!TextUtils.isEmpty(s))
        {
            firstNameField.setText(s);
        }
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            lastNameField.setText(((CharSequence) (obj)));
        }
    }

    private void createUser(final BSUser user)
    {
        bsAuthService.createUser(user, new Callback() {

            final SignUpActivity this$0;
            final BSUser val$user;

            public void failure(RetrofitError retrofiterror)
            {
                enableButtons();
                retrofiterror = retrofiterror.getResponse();
                if (retrofiterror != null && retrofiterror.getStatus() == 400)
                {
                    showEmailTakenDialog();
                    return;
                } else
                {
                    showSignUpErrorDialog();
                    return;
                }
            }

            public void success(BSAuthResponse bsauthresponse, Response response)
            {
                sendSignUpAnalytics();
                preferenceUtils.putBoolean(0x7f06008a, true);
                getAuthToken(user);
            }

            public volatile void success(Object obj, Response response)
            {
                success((BSAuthResponse)obj, response);
            }

            
            {
                this$0 = SignUpActivity.this;
                user = bsuser;
                super();
            }
        });
    }

    private BSUser createUserModel()
    {
        BSUser bsuser = new BSUser();
        bsuser.setFirstName(firstNameField.getText().toString());
        bsuser.setLastName(lastNameField.getText().toString());
        bsuser.setEmail(emailField.getText().toString());
        bsuser.setPassword(passwordField.getText().toString());
        bsuser.setAppName(getString(0x7f060017));
        return bsuser;
    }

    private void doSignUp()
    {
        disableButtons();
        createUser(createUserModel());
    }

    private void existingUserSignUpOverrides()
    {
        TextView textview = (TextView)findViewById(0x7f0b007a);
        if (isExistingUser())
        {
            setTitle(0x7f0600e0);
            findViewById(0x7f0b0102).setVisibility(0);
            findViewById(0x7f0b0101).setVisibility(8);
            attemptToPopulateFirstAndLastName();
            return;
        } else
        {
            setTitle(0x7f0600dc);
            findViewById(0x7f0b0102).setVisibility(8);
            findViewById(0x7f0b0101).setVisibility(0);
            return;
        }
    }

    private void getAuthToken(BSUser bsuser)
    {
        bsAuthService.getToken("imoji", bsuser.getPassword(), "password", bsuser.getEmail(), bsuser.getPassword(), new Callback() {

            final SignUpActivity this$0;
            final Activity val$self;

            public void failure(RetrofitError retrofiterror)
            {
            }

            public void success(BSAuthResponse bsauthresponse, Response response)
            {
                bsauthresponse = bsauthresponse.getAccessToken();
                preferenceUtils.putString(0x7f06003a, bsauthresponse);
                setResult(-1);
                response = facebookService.getToken();
                if (!TextUtils.isEmpty(response))
                {
                    String s = getString(0x7f060017);
                    bitstripsService.linkAccounts(response, bsauthresponse, s, new Callback() {

                        final _cls4 this$1;

                        public void failure(RetrofitError retrofiterror)
                        {
                        }

                        public void success(LinkAccountsResult linkaccountsresult, Response response)
                        {
                        }

                        public volatile void success(Object obj, Response response)
                        {
                            success((LinkAccountsResult)obj, response);
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    });
                    finish();
                    return;
                } else
                {
                    preferenceUtils.putBoolean(0x7f06009e, true);
                    bitstripsService.bsAuthEmailLookup(bsauthresponse, new Callback() {

                        final _cls4 this$1;

                        public void failure(RetrofitError retrofiterror)
                        {
                            finish();
                        }

                        public void success(BSAuthEmailLookup bsauthemaillookup, Response response)
                        {
                            if (bsauthemaillookup.matchFound().booleanValue())
                            {
                                try
                                {
                                    (new GetImageTask(self, imageLoader) {

                                        final _cls2 this$2;

                                        protected void onPostExecute(Bitmap bitmap)
                                        {
                                            RetrieveAvatarActivity.avatarBitmap = bitmap;
                                            finish();
                                        }

                                        protected volatile void onPostExecute(Object obj)
                                        {
                                            onPostExecute((Bitmap)obj);
                                        }

            
            {
                this$2 = _cls2.this;
                super(activity, imageloader);
            }
                                    }).execute(new String[] {
                                        bsauthemaillookup.getURL()
                                    });
                                    return;
                                }
                                // Misplaced declaration of an exception variable
                                catch (Response response)
                                {
                                    Log.e("SignUpActivity", (new StringBuilder()).append("Failed to load image [").append(bsauthemaillookup.getURL()).append("]").toString(), response);
                                }
                                finish();
                                return;
                            } else
                            {
                                finish();
                                return;
                            }
                        }

                        public volatile void success(Object obj, Response response)
                        {
                            success((BSAuthEmailLookup)obj, response);
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    });
                    return;
                }
            }

            public volatile void success(Object obj, Response response)
            {
                success((BSAuthResponse)obj, response);
            }

            
            {
                this$0 = SignUpActivity.this;
                self = activity;
                super();
            }
        });
    }

    private boolean isExistingUser()
    {
        return getIntent().getBooleanExtra(getString(0x7f06009d), false);
    }

    private void logout()
    {
        floaterServiceManager.stopFloaterService();
        analytics.sendEvent(Category.AUTH, Action.LOGOUT, null);
        facebookService.logout();
        returnToLogin();
    }

    private void makeTermsAndPrivacyLinksClickable()
    {
        TextView textview = (TextView)findViewById(0x7f0b0106);
        textview.setLinkTextColor(getResources().getColor(0x7f090053));
        textview.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void returnToLogin()
    {
        setResult(-1);
        finish();
    }

    private void sendSignUpAnalytics()
    {
        String s;
        if (facebookService.getToken() == null)
        {
            s = "BSAuth user";
        } else
        {
            s = "Facebook user";
        }
        analytics.sendEvent(Category.SIGN_UP, Action.SIGN_UP, s);
        if (!TextUtils.isEmpty(preferenceUtils.getString(0x7f06002a, "")))
        {
            analytics.sendEvent(Category.AVATAR, Action.CREATED, "Existing Bitstrips User");
        }
    }

    private void setupCustomActionBar()
    {
        setSupportActionBar((Toolbar)findViewById(0x7f0b0074));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void showEmailTakenDialog()
    {
        (new android.app.AlertDialog.Builder(this)).setTitle(0x7f06006d).setMessage(0x7f06007a).setNeutralButton(0x104000a, new android.content.DialogInterface.OnClickListener() {

            final SignUpActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = SignUpActivity.this;
                super();
            }
        }).show();
    }

    private void showSignUpErrorDialog()
    {
        (new android.app.AlertDialog.Builder(this)).setTitle(0x7f06006d).setMessage(0x7f06007b).setNeutralButton(0x104000a, new android.content.DialogInterface.OnClickListener() {

            final SignUpActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = SignUpActivity.this;
                super();
            }
        }).show();
    }

    public void onBackPressed()
    {
        if (isExistingUser())
        {
            logout();
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        ((InjectorApplication)getApplication()).inject(this);
        setContentView(0x7f030067);
        firstNameField = (FormField)findViewById(0x7f0b0103);
        lastNameField = (FormField)findViewById(0x7f0b0104);
        emailField = (FormField)findViewById(0x7f0b0091);
        passwordField = (FormField)findViewById(0x7f0b0092);
        submitButton = (Button)findViewById(0x7f0b0105);
        setMainButton(submitButton);
        setupCustomActionBar();
        addFieldsToForm();
        attemptToPopulateEmailField();
        existingUserSignUpOverrides();
        makeTermsAndPrivacyLinksClickable();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f0e0008, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        int i = menuitem.getItemId();
        if (i == 0x7f0b011e)
        {
            doSignUp();
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

    public void onSignUpClicked(View view)
    {
        doSignUp();
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
