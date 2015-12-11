// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.account;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.Editable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.AmazonBrandedWebView;
import com.amazon.mShop.TaskCallbackFactory;
import com.amazon.mShop.TitleProvider;
import com.amazon.mShop.control.TaskCallback;
import com.amazon.mShop.control.account.NewAccountController;
import com.amazon.mShop.control.account.NewAccountSubscriber;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.Notification;

// Referenced classes of package com.amazon.mShop.account:
//            LoginActivity, NonZeroLengthTextWatcher

public class CreateNewAccountView extends ScrollView
    implements TitleProvider, NewAccountSubscriber
{
    private final class CreateNewTextWatcher extends NonZeroLengthTextWatcher
    {

        final CreateNewAccountView this$0;

        public void update()
        {
            updateContinueButtonEnabled();
        }

        public CreateNewTextWatcher(EditText edittext)
        {
            this$0 = CreateNewAccountView.this;
            super(edittext);
        }
    }


    private final int MIN_PASSWORD_LENGTH = 6;
    private TextView cnaLegalInformationLink;
    private final View content;
    private Button continueButton;
    private EditText email;
    NonZeroLengthTextWatcher emailTextWatcher;
    private EditText fullName;
    private EditText furigana;
    NonZeroLengthTextWatcher furiganaTextWatcher;
    private final LoginActivity loginActivity;
    private final String mRefMarker;
    NonZeroLengthTextWatcher nameTextWatcher;
    private final NewAccountController newAccountController = new NewAccountController(this);
    private EditText password;
    NonZeroLengthTextWatcher passwordTextWatcher;
    private EditText reenter_password;
    NonZeroLengthTextWatcher reenterpasswordTextWatcher;
    private final TaskCallback taskCallback;

    public CreateNewAccountView(final LoginActivity loginActivity, String s)
    {
        super(loginActivity);
        this.loginActivity = loginActivity;
        mRefMarker = s;
        content = LayoutInflater.from(getContext()).inflate(com.amazon.mShop.android.lib.R.layout.create_new_account, null);
        continueButton = (Button)content.findViewById(com.amazon.mShop.android.lib.R.id.create_account_button);
        continueButton.setOnClickListener(new android.view.View.OnClickListener() {

            final CreateNewAccountView this$0;
            final LoginActivity val$loginActivity;

            public void onClick(View view)
            {
                if (isValidEmail() && isValidPassword() && !newAccountController.hasServiceCallRunning())
                {
                    if (ConfigUtils.isEnabled(loginActivity, com.amazon.mShop.android.lib.R.string.config_cna_requires_furigana))
                    {
                        newAccountController.createNewAccount(fullName.getText().toString(), furigana.getText().toString(), email.getText().toString(), password.getText().toString(), false, taskCallback);
                    } else
                    {
                        newAccountController.createNewAccount(fullName.getText().toString(), null, email.getText().toString(), password.getText().toString(), false, taskCallback);
                    }
                    if (!Util.isEmpty(mRefMarker))
                    {
                        RefMarkerObserver.logRefMarker(mRefMarker);
                    }
                }
            }

            
            {
                this$0 = CreateNewAccountView.this;
                loginActivity = loginactivity;
                super();
            }
        });
        continueButton.setEnabled(false);
        fullName = (EditText)content.findViewById(com.amazon.mShop.android.lib.R.id.cna_name_edit);
        furigana = (EditText)content.findViewById(com.amazon.mShop.android.lib.R.id.cna_furigana_edit);
        email = (EditText)content.findViewById(com.amazon.mShop.android.lib.R.id.cna_email_edit);
        s = email;
        String s1;
        int i;
        if (loginActivity.isAccountPhoneNumberNeeded())
        {
            i = com.amazon.mShop.android.lib.R.string.cna_email_phone_number_hint;
        } else
        {
            i = com.amazon.mShop.android.lib.R.string.cna_email_hint;
        }
        s.setHint(i);
        password = (EditText)content.findViewById(com.amazon.mShop.android.lib.R.id.cna_password_edit);
        reenter_password = (EditText)content.findViewById(com.amazon.mShop.android.lib.R.id.cna_duplicate_password_edit);
        nameTextWatcher = new CreateNewTextWatcher(fullName);
        furiganaTextWatcher = new CreateNewTextWatcher(furigana);
        emailTextWatcher = new CreateNewTextWatcher(email);
        passwordTextWatcher = new CreateNewTextWatcher(password);
        reenterpasswordTextWatcher = new CreateNewTextWatcher(reenter_password);
        if (ConfigUtils.isEnabled(loginActivity, com.amazon.mShop.android.lib.R.string.config_cna_requires_furigana))
        {
            furigana.setVisibility(0);
        } else
        {
            furigana.setVisibility(8);
        }
        UIUtils.setMaxLengthFromRule(fullName, com.amazon.mShop.android.lib.R.string.cna_name_rule);
        UIUtils.setMaxLengthFromRule(furigana, com.amazon.mShop.android.lib.R.string.cna_furigana_rule);
        UIUtils.setMaxLengthFromRule(email, com.amazon.mShop.android.lib.R.string.cna_email_rule);
        UIUtils.setMaxLengthFromRule(password, com.amazon.mShop.android.lib.R.string.cna_password_rule);
        UIUtils.setMaxLengthFromRule(reenter_password, com.amazon.mShop.android.lib.R.string.cna_password_rule);
        cnaLegalInformationLink = (TextView)content.findViewById(com.amazon.mShop.android.lib.R.id.cna_legal_information);
        cnaLegalInformationLink.setOnClickListener(new android.view.View.OnClickListener() {

            final CreateNewAccountView this$0;
            final LoginActivity val$loginActivity;

            public void onClick(View view)
            {
                view = getResources().getString(com.amazon.mShop.android.lib.R.string.cna_legal_link_url);
                String s2 = getResources().getString(com.amazon.mShop.android.lib.R.string.cna_legal_text);
                loginActivity.pushView(new AmazonBrandedWebView(loginActivity, view, s2));
            }

            
            {
                this$0 = CreateNewAccountView.this;
                loginActivity = loginactivity;
                super();
            }
        });
        s = (TextView)content.findViewById(com.amazon.mShop.android.lib.R.id.cna_registration_agreement);
        s1 = content.getResources().getString(com.amazon.mShop.android.lib.R.string.cna_registration_agreement);
        if (!Util.isEmpty(s1))
        {
            SpannableString spannablestring = new SpannableString(s1);
            UIUtils.addEmbeddedLink(loginActivity, spannablestring, s1, content.getResources().getString(com.amazon.mShop.android.lib.R.string.cna_conditions_of_use_and_sale_text), content.getResources().getString(com.amazon.mShop.android.lib.R.string.cna_conditions_of_use_and_sale_url));
            UIUtils.addEmbeddedLink(loginActivity, spannablestring, s1, content.getResources().getString(com.amazon.mShop.android.lib.R.string.cna_privacy_notice_text), content.getResources().getString(com.amazon.mShop.android.lib.R.string.cna_privacy_notice_url));
            s.setText(spannablestring);
            s.setMovementMethod(LinkMovementMethod.getInstance());
        }
        addView(content);
        taskCallback = (new TaskCallbackFactory(loginActivity)).getFinishTaskCallback(newAccountController, loginActivity, com.amazon.mShop.android.lib.R.string.cna_in_progress);
    }

    private boolean checkValidAccountFormat()
    {
        boolean flag1 = newAccountController.isValidEmail(email.getText().toString());
        boolean flag = flag1;
        if (ConfigUtils.isEnabled(loginActivity, com.amazon.mShop.android.lib.R.string.config_account_phone_number_support))
        {
            flag = flag1;
            if (loginActivity.isAccountPhoneNumberNeeded())
            {
                flag = true;
            }
        }
        return flag;
    }

    private boolean isValidEmail()
    {
        if (!checkValidAccountFormat())
        {
            email.requestFocus();
            email.setError(getContext().getString(com.amazon.mShop.android.lib.R.string.cna_email_requirement_error));
            return false;
        } else
        {
            return true;
        }
    }

    private boolean isValidPassword()
    {
        if (!password.getText().toString().equals(reenter_password.getText().toString()))
        {
            password.requestFocus();
            password.setError(getContext().getString(com.amazon.mShop.android.lib.R.string.cna_no_passwords_not_same_error));
            return false;
        }
        if (password.getText().length() < 6)
        {
            password.requestFocus();
            password.setError(getContext().getString(com.amazon.mShop.android.lib.R.string.cna_password_requirement_error));
            return false;
        } else
        {
            return true;
        }
    }

    private void updateContinueButtonEnabled()
    {
        Button button = continueButton;
        boolean flag;
        if (emailTextWatcher.isWatchedNonZeroLength() && passwordTextWatcher.isWatchedNonZeroLength() && reenterpasswordTextWatcher.isWatchedNonZeroLength() && nameTextWatcher.isWatchedNonZeroLength() && (!ConfigUtils.isEnabled(loginActivity, com.amazon.mShop.android.lib.R.string.config_cna_requires_furigana) || furiganaTextWatcher.isWatchedNonZeroLength()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        button.setEnabled(flag);
    }

    public volatile CharSequence getTitle()
    {
        return getTitle();
    }

    public String getTitle()
    {
        return getContext().getString(com.amazon.mShop.android.lib.R.string.cna_title);
    }

    public void onError(Exception exception, ServiceCall servicecall)
    {
        UIUtils.alert(loginActivity, exception);
    }

    public void onNewAccountCreation(boolean flag, Notification notification)
    {
        if (flag)
        {
            loginActivity.setResult(-1);
        }
        if (notification != null)
        {
            com.amazon.mShop.AmazonAlertDialog.Builder builder = (new com.amazon.mShop.AmazonAlertDialog.Builder(loginActivity)).setTitle(notification.getTitle()).setMessage(notification.getMessage());
            if (notification.getType() == 1)
            {
                notification = new android.content.DialogInterface.OnClickListener() {

                    final CreateNewAccountView this$0;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        if (i == -2)
                        {
                            email.requestFocus();
                        } else
                        if (!newAccountController.hasServiceCallRunning())
                        {
                            if (ConfigUtils.isEnabled(loginActivity, com.amazon.mShop.android.lib.R.string.config_cna_requires_furigana))
                            {
                                newAccountController.createNewAccount(fullName.getText().toString(), furigana.getText().toString(), email.getText().toString(), password.getText().toString(), true, taskCallback);
                                return;
                            } else
                            {
                                newAccountController.createNewAccount(fullName.getText().toString(), null, email.getText().toString(), password.getText().toString(), true, taskCallback);
                                return;
                            }
                        }
                    }

            
            {
                this$0 = CreateNewAccountView.this;
                super();
            }
                };
                builder.setPositiveButton(com.amazon.mShop.android.lib.R.string.alert_ok_button, notification);
                builder.setNegativeButton(com.amazon.mShop.android.lib.R.string.alert_cancel_button, notification);
            } else
            {
                notification = null;
                if (flag)
                {
                    notification = new android.content.DialogInterface.OnClickListener() {

                        final CreateNewAccountView this$0;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            loginActivity.finish();
                        }

            
            {
                this$0 = CreateNewAccountView.this;
                super();
            }
                    };
                }
                builder.setNegativeButton(com.amazon.mShop.android.lib.R.string.alert_dialog_ok_button, notification);
            }
            builder.create().show();
        } else
        if (flag)
        {
            loginActivity.finish();
            return;
        }
    }











}
