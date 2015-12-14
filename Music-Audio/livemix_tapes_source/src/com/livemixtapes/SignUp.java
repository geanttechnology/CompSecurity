// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import com.google.android.gms.analytics.Tracker;
import com.livemixtapes.ui.BaseActivity;

// Referenced classes of package com.livemixtapes:
//            User, console, App, Login

public class SignUp extends BaseActivity
{

    static final int DATE_DIALOG_ID = 0;
    private TextView continueAsGuest;
    private Spinner countrySelector;
    private TextView forgotPassword;
    private RadioButton genderFemale;
    private RadioButton genderMale;
    private LinearLayout layout;
    LinearLayout layoutBack;
    private Boolean loading;
    private TextView mDateDisplay;
    private android.app.DatePickerDialog.OnDateSetListener mDateSetListener;
    private int mDay;
    private int mMonth;
    private int mYear;
    private FrameLayout nextBtn;
    private EditText password;
    private LinearLayout passwordBox;
    private ImageButton passwordClear;
    private ProgressBar signupLoading;
    private EditText signup_birthdate;
    private LinearLayout signup_birthdatebox;
    private ImageButton signup_birthdateclear;
    private EditText signup_confirmemail;
    private LinearLayout signup_confirmemailbox;
    private ImageButton signup_confirmemailclear;
    private EditText signup_confirmpassword;
    private LinearLayout signup_confirmpasswordbox;
    private ImageButton signup_confirmpasswordclear;
    private LinearLayout signup_countrybox;
    private EditText signup_email;
    private LinearLayout signup_emailbox;
    private ImageButton signup_emailclear;
    private EditText signup_firstname;
    private LinearLayout signup_firstnamebox;
    private ImageButton signup_firstnameclear;
    private LinearLayout signup_genderbox;
    private EditText signup_lastname;
    private LinearLayout signup_lastnamebox;
    private ImageButton signup_lastnameclear;
    private EditText signup_password;
    private LinearLayout signup_passwordbox;
    private ImageButton signup_passwordclear;
    private EditText signup_postalcode;
    private LinearLayout signup_postalcodebox;
    private ImageButton signup_postalcodeclear;
    private CheckBox signup_tos;
    private LinearLayout signup_toscheckbox;
    private EditText username;
    private LinearLayout usernameBox;
    private ImageButton usernameClear;

    public SignUp()
    {
        loading = Boolean.valueOf(false);
        mDateSetListener = new android.app.DatePickerDialog.OnDateSetListener() {

            final SignUp this$0;

            public void onDateSet(DatePicker datepicker, int i, int j, int k)
            {
                mYear = i;
                mMonth = j;
                mDay = k;
                updateDisplay();
            }

            
            {
                this$0 = SignUp.this;
                super();
            }
        };
    }

    private void hideKeyboard(View view)
    {
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void hideKeyboards()
    {
        hideKeyboard(username);
        hideKeyboard(password);
        hideKeyboard(signup_password);
        hideKeyboard(signup_email);
        hideKeyboard(signup_confirmemail);
        hideKeyboard(signup_password);
        hideKeyboard(signup_confirmpassword);
        hideKeyboard(signup_firstname);
        hideKeyboard(signup_lastname);
        hideKeyboard(signup_postalcode);
    }

    private void openRadio()
    {
    }

    private void refresh()
    {
        if (loading.booleanValue())
        {
            return;
        } else
        {
            loading = Boolean.valueOf(true);
            signupLoading.setVisibility(0);
            User.refresh(new User.UserCallback() {

                final SignUp this$0;

                public void always()
                {
                    loading = Boolean.valueOf(false);
                    signupLoading.setVisibility(8);
                }

                public void failure(int i, Exception exception)
                {
                }

                public void success(User.UserData userdata)
                {
                    openRadio();
                }

            
            {
                this$0 = SignUp.this;
                super();
            }
            });
            return;
        }
    }

    private void setBoxBehavior(final EditText box_text, final ImageButton box_clear)
    {
        box_text.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            final SignUp this$0;

            public void onFocusChange(View view, boolean flag)
            {
            }

            
            {
                this$0 = SignUp.this;
                super();
            }
        });
        box_text.addTextChangedListener(new TextWatcher() {

            final SignUp this$0;
            private final ImageButton val$box_clear;
            private final EditText val$box_text;

            public void afterTextChanged(Editable editable)
            {
                if (box_text.length() > 0)
                {
                    box_clear.setVisibility(0);
                    return;
                } else
                {
                    box_clear.setVisibility(8);
                    return;
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            
            {
                this$0 = SignUp.this;
                box_text = edittext;
                box_clear = imagebutton;
                super();
            }
        });
        box_clear.setOnClickListener(new android.view.View.OnClickListener() {

            final SignUp this$0;
            private final EditText val$box_text;

            public void onClick(View view)
            {
                box_text.setText("");
                box_text.requestFocus();
            }

            
            {
                this$0 = SignUp.this;
                box_text = edittext;
                super();
            }
        });
    }

    private void setListeners()
    {
        android.view.View.OnFocusChangeListener onfocuschangelistener = new android.view.View.OnFocusChangeListener() {

            final SignUp this$0;

            public void onFocusChange(View view, boolean flag)
            {
                if (flag)
                {
                    hideKeyboards();
                }
            }

            
            {
                this$0 = SignUp.this;
                super();
            }
        };
        layout.setOnFocusChangeListener(onfocuschangelistener);
        password.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            final SignUp this$0;

            public void onFocusChange(View view, boolean flag)
            {
                if (!flag)
                {
                    hideKeyboard(view);
                }
            }

            
            {
                this$0 = SignUp.this;
                super();
            }
        });
        setBoxBehavior(signup_email, signup_emailclear);
        setBoxBehavior(signup_confirmemail, signup_confirmemailclear);
        setBoxBehavior(signup_password, signup_passwordclear);
        setBoxBehavior(signup_confirmpassword, signup_confirmpasswordclear);
        setBoxBehavior(signup_firstname, signup_firstnameclear);
        setBoxBehavior(signup_lastname, signup_lastnameclear);
        setBoxBehavior(signup_postalcode, signup_postalcodeclear);
        setBoxBehavior(signup_birthdate, signup_birthdateclear);
        username.addTextChangedListener(new TextWatcher() {

            final SignUp this$0;

            public void afterTextChanged(Editable editable)
            {
                if (username.length() > 0)
                {
                    usernameClear.setVisibility(0);
                    return;
                } else
                {
                    usernameClear.setVisibility(8);
                    return;
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            
            {
                this$0 = SignUp.this;
                super();
            }
        });
        usernameClear.setOnClickListener(new android.view.View.OnClickListener() {

            final SignUp this$0;

            public void onClick(View view)
            {
                username.setText("");
                username.requestFocus();
            }

            
            {
                this$0 = SignUp.this;
                super();
            }
        });
        password.addTextChangedListener(new TextWatcher() {

            final SignUp this$0;

            public void afterTextChanged(Editable editable)
            {
                if (password.length() > 0)
                {
                    passwordClear.setVisibility(0);
                    return;
                } else
                {
                    passwordClear.setVisibility(8);
                    return;
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            
            {
                this$0 = SignUp.this;
                super();
            }
        });
        passwordClear.setOnClickListener(new android.view.View.OnClickListener() {

            final SignUp this$0;

            public void onClick(View view)
            {
                password.setText("");
                password.requestFocus();
            }

            
            {
                this$0 = SignUp.this;
                super();
            }
        });
        nextBtn.setOnClickListener(new android.view.View.OnClickListener() {

            final SignUp this$0;

            public void onClick(View view)
            {
                String s;
                String as[];
                String s1;
                String s2;
                hideKeyboards();
                if (username.length() == 0)
                {
                    shake(usernameBox);
                    username.requestFocus();
                    return;
                }
                if (signup_email.length() == 0)
                {
                    shake(signup_emailbox);
                    signup_email.requestFocus();
                    return;
                }
                if (signup_confirmemail.length() == 0)
                {
                    shake(signup_confirmemailbox);
                    signup_confirmemail.requestFocus();
                    return;
                }
                if (password.length() == 0)
                {
                    shake(passwordBox);
                    password.requestFocus();
                    return;
                }
                if (signup_password.length() == 0)
                {
                    shake(signup_passwordbox);
                    signup_password.requestFocus();
                    return;
                }
                if (signup_confirmpassword.length() == 0)
                {
                    shake(signup_confirmpasswordbox);
                    signup_confirmpassword.requestFocus();
                    return;
                }
                if (signup_firstname.length() == 0)
                {
                    shake(signup_firstnamebox);
                    signup_firstname.requestFocus();
                    return;
                }
                if (signup_lastname.length() == 0)
                {
                    shake(signup_lastnamebox);
                    signup_lastname.requestFocus();
                    return;
                }
                if (signup_postalcode.length() == 0)
                {
                    shake(signup_postalcodebox);
                    signup_postalcode.requestFocus();
                    return;
                }
                if (!genderMale.isChecked() && !genderFemale.isChecked())
                {
                    shake(signup_genderbox);
                    genderMale.requestFocus();
                    return;
                }
                if (signup_birthdate.length() == 0)
                {
                    shake(signup_birthdatebox);
                    signup_birthdate.requestFocus();
                    return;
                }
                if (!signup_tos.isChecked())
                {
                    shake(signup_toscheckbox);
                    signup_tos.requestFocus();
                    return;
                }
                s = getResources().getStringArray(0x7f0f0001)[countrySelector.getSelectedItemPosition()];
                as = signup_birthdate.getText().toString().split("/");
                s1 = signup_email.getText().toString();
                s2 = signup_firstname.getText().toString();
                console.log(new Object[] {
                    as[0]
                });
                view = null;
                if (!genderMale.isChecked()) goto _L2; else goto _L1
_L1:
                view = "M";
_L4:
                String s3 = signup_lastname.getText().toString();
                String s4 = signup_password.getText().toString();
                String s5 = username.getText().toString();
                String s6 = signup_postalcode.getText().toString();
                console.log(new Object[] {
                    (new StringBuilder("country=")).append(s).append("&dob_day=").append(as[1]).append("&dob_month=").append(as[0]).append("&dob_year=").append(as[2]).append("&email=").append(s1).append("&firstname=").append(s2).append("&gender=").append(view).append("&lastname=").append(s3).append("&password=").append(s4).append("&tos=1").append("&username=").append(s5).append("&zip=").append(s6).toString()
                });
                signup();
                return;
_L2:
                if (genderFemale.isChecked())
                {
                    view = "F";
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                this$0 = SignUp.this;
                super();
            }
        });
        layoutBack.setOnClickListener(new android.view.View.OnClickListener() {

            final SignUp this$0;

            public void onClick(View view)
            {
                onBackPressed();
            }

            
            {
                this$0 = SignUp.this;
                super();
            }
        });
    }

    private void shake(View view)
    {
        shake(view, null);
    }

    private void shake(View view, final Runnable callback)
    {
        Animation animation = AnimationUtils.loadAnimation(this, 0x7f04000a);
        animation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final SignUp this$0;
            private final Runnable val$callback;

            public void onAnimationEnd(Animation animation1)
            {
                animation1 = getCurrentFocus();
                if (animation1 != username) goto _L2; else goto _L1
_L1:
                showKeyboard(username);
_L4:
                if (callback != null)
                {
                    callback.run();
                }
                return;
_L2:
                if (animation1 == password)
                {
                    showKeyboard(password);
                } else
                if (animation1 == signup_email)
                {
                    showKeyboard(signup_email);
                } else
                if (animation1 == signup_confirmemail)
                {
                    showKeyboard(signup_confirmemail);
                } else
                if (animation1 == signup_password)
                {
                    showKeyboard(signup_password);
                } else
                if (animation1 == signup_confirmpassword)
                {
                    showKeyboard(signup_confirmpassword);
                } else
                if (animation1 == signup_firstname)
                {
                    showKeyboard(signup_firstname);
                } else
                if (animation1 == signup_lastname)
                {
                    showKeyboard(signup_lastname);
                } else
                if (animation1 == signup_postalcode)
                {
                    showKeyboard(signup_postalcode);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            public void onAnimationRepeat(Animation animation1)
            {
            }

            public void onAnimationStart(Animation animation1)
            {
            }

            
            {
                this$0 = SignUp.this;
                callback = runnable;
                super();
            }
        });
        view.startAnimation(animation);
    }

    private void showDialog(String s, String s1)
    {
        (new android.app.AlertDialog.Builder(this)).setTitle(s).setMessage(s1).setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {

            final SignUp this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = SignUp.this;
                super();
            }
        }).setIcon(0x1080027).show();
    }

    private void showKeyboard(View view)
    {
        ((InputMethodManager)getSystemService("input_method")).showSoftInput(view, 0);
    }

    private void signup()
    {
        String s;
        String s1;
        String as[];
        String s2;
        String s3;
        if (loading.booleanValue())
        {
            return;
        }
        loading = Boolean.valueOf(true);
        signupLoading.setVisibility(0);
        s1 = getResources().getStringArray(0x7f0f0001)[countrySelector.getSelectedItemPosition()];
        as = signup_birthdate.getText().toString().split("/");
        s2 = signup_email.getText().toString();
        s3 = signup_firstname.getText().toString();
        console.log(new Object[] {
            as[0]
        });
        s = null;
        if (!genderMale.isChecked()) goto _L2; else goto _L1
_L1:
        s = "M";
_L4:
        String s4 = signup_lastname.getText().toString();
        String s5 = signup_password.getText().toString();
        User.signup(username.getText().toString(), s2, s5, s3, s4, s1, signup_postalcode.getText().toString(), s, as[0], as[1], as[2], new User.SignupCallback() {

            final SignUp this$0;

            public void always()
            {
                loading = Boolean.valueOf(false);
                signupLoading.setVisibility(8);
            }

            public void failure(int i, Exception exception)
            {
            }

            public void signup_failure(String s6)
            {
                console.log(new Object[] {
                    s6
                });
                s6 = s6.replace("\\n", "").replace("\"error\"", "").replace(":", "").replace("Array(", "").replace("Validation failed", "").replace("Errors", "").replace("=>", ":").replace(")", "").replace("{", "").replace("}", "").replace("\"", "").split(",");
                showDialog("Signup Error", (new StringBuilder("Signup Failed for the given reason: ")).append(s6[0]).toString());
            }

            public void success()
            {
                showDialog("Signup Success", "Your account was successfully created and you can now log in!");
                startActivity(new Intent(SignUp.this, com/livemixtapes/Login));
            }

            
            {
                this$0 = SignUp.this;
                super();
            }
        });
        return;
_L2:
        if (genderFemale.isChecked())
        {
            s = "F";
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void updateDisplay()
    {
        mDateDisplay.setText((new StringBuilder()).append(mMonth + 1).append("/").append(mDay).append("/").append(mYear).append(""));
    }

    public void onBackPressed()
    {
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f03003c);
        layout = (LinearLayout)findViewById(0x7f08010d);
        try
        {
            App.scaleViewGroup(layout);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        mDateDisplay = (TextView)findViewById(0x7f08012d);
        countrySelector = (Spinner)findViewById(0x7f080125);
        countrySelector.setSelection(228);
        nextBtn = (FrameLayout)findViewById(0x7f080131);
        username = (EditText)findViewById(0x7f080110);
        password = (EditText)findViewById(0x7f080119);
        signup_email = (EditText)findViewById(0x7f080113);
        signup_confirmemail = (EditText)findViewById(0x7f080116);
        signup_password = (EditText)findViewById(0x7f080119);
        signup_confirmpassword = (EditText)findViewById(0x7f08011c);
        signup_firstname = (EditText)findViewById(0x7f08011f);
        signup_lastname = (EditText)findViewById(0x7f080122);
        signup_postalcode = (EditText)findViewById(0x7f080127);
        signup_birthdate = (EditText)findViewById(0x7f08012d);
        signup_tos = (CheckBox)findViewById(0x7f080130);
        signup_toscheckbox = (LinearLayout)findViewById(0x7f08012f);
        usernameBox = (LinearLayout)findViewById(0x7f08010f);
        passwordBox = (LinearLayout)findViewById(0x7f080118);
        signup_emailbox = (LinearLayout)findViewById(0x7f080112);
        signup_confirmemailbox = (LinearLayout)findViewById(0x7f080115);
        signup_passwordbox = (LinearLayout)findViewById(0x7f080118);
        signup_confirmpasswordbox = (LinearLayout)findViewById(0x7f08011b);
        signup_firstnamebox = (LinearLayout)findViewById(0x7f08011e);
        signup_lastnamebox = (LinearLayout)findViewById(0x7f080121);
        signup_postalcodebox = (LinearLayout)findViewById(0x7f080126);
        signup_birthdatebox = (LinearLayout)findViewById(0x7f08012c);
        signup_genderbox = (LinearLayout)findViewById(0x7f080129);
        genderMale = (RadioButton)findViewById(0x7f08012a);
        genderFemale = (RadioButton)findViewById(0x7f08012b);
        usernameClear = (ImageButton)findViewById(0x7f080111);
        passwordClear = (ImageButton)findViewById(0x7f08011a);
        signup_emailclear = (ImageButton)findViewById(0x7f080114);
        signup_confirmemailclear = (ImageButton)findViewById(0x7f080117);
        signup_passwordclear = (ImageButton)findViewById(0x7f08011a);
        signup_confirmpasswordclear = (ImageButton)findViewById(0x7f08011d);
        signup_firstnameclear = (ImageButton)findViewById(0x7f080120);
        signup_lastnameclear = (ImageButton)findViewById(0x7f080123);
        signup_postalcodeclear = (ImageButton)findViewById(0x7f080128);
        signup_birthdateclear = (ImageButton)findViewById(0x7f08012e);
        signupLoading = (ProgressBar)findViewById(0x7f080132);
        mDateDisplay.setOnClickListener(new android.view.View.OnClickListener() {

            final SignUp this$0;

            public void onClick(View view)
            {
                showDialog(0);
            }

            
            {
                this$0 = SignUp.this;
                super();
            }
        });
        layoutBack = (LinearLayout)findViewById(0x7f08006d);
        setListeners();
    }

    protected Dialog onCreateDialog(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return new DatePickerDialog(this, mDateSetListener, mYear, mMonth, mDay);
        }
    }

    public volatile View onCreateView(View view, String s, Context context, AttributeSet attributeset)
    {
        return super.onCreateView(view, s, context, attributeset);
    }

    public volatile View onCreateView(String s, Context context, AttributeSet attributeset)
    {
        return super.onCreateView(s, context, attributeset);
    }

    public void onResume()
    {
        super.onResume();
        console.log(new Object[] {
            "LOGGING SIGNUP ACTIVITY"
        });
        App app = (App)getApplication();
        app.getDefaultTracker().setScreenName("Image~SignupActivity");
        app.getDefaultTracker().send((new com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder()).build());
    }









































}
