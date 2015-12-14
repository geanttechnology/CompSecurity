// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

// Referenced classes of package com.livemixtapes:
//            User, MainActivity, SignUp, console, 
//            App

public class Login extends Activity
{

    private TextView continueAsGuest;
    private TextView forgotPassword;
    private LinearLayout layout;
    private Boolean loading;
    private FrameLayout loginBtn;
    private ProgressBar loginLoading;
    AsyncTask mRegisterTask;
    private EditText password;
    private LinearLayout passwordBox;
    private ImageButton passwordClear;
    private Button signupBtn;
    private EditText username;
    private LinearLayout usernameBox;
    private ImageButton usernameClear;

    public Login()
    {
        loading = Boolean.valueOf(false);
    }

    private void hideKeyboard(View view)
    {
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void hideKeyboards()
    {
        hideKeyboard(username);
        hideKeyboard(password);
    }

    private void login()
    {
        if (loading.booleanValue())
        {
            return;
        } else
        {
            loading = Boolean.valueOf(true);
            loginLoading.setVisibility(0);
            User.login(username.getText().toString(), password.getText().toString(), new User.UserCallback() {

                final Login this$0;

                public void always()
                {
                    loading = Boolean.valueOf(false);
                    loginLoading.setVisibility(8);
                }

                public void failure(int i, Exception exception)
                {
                    if (i == 1)
                    {
                        shake(username);
                        shake(password, new Runnable() {

                            final _cls14 this$1;

                            public void run()
                            {
                                showDialog("Error", "The given user name or password is invalid.");
                            }

            
            {
                this$1 = _cls14.this;
                super();
            }
                        });
                        return;
                    } else
                    {
                        showDialog("Error", "There was an unknown error while logging in.");
                        return;
                    }
                }

                public void success(User.UserData userdata)
                {
                    openRadio();
                }


            
            {
                this$0 = Login.this;
                super();
            }
            });
            return;
        }
    }

    private void openRadio()
    {
        startActivity(new Intent(this, com/livemixtapes/MainActivity));
    }

    private void openSignup()
    {
        startActivity(new Intent(this, com/livemixtapes/SignUp));
    }

    private void refresh()
    {
        if (loading.booleanValue())
        {
            return;
        } else
        {
            loading = Boolean.valueOf(true);
            loginLoading.setVisibility(0);
            User.refresh(new User.UserCallback() {

                final Login this$0;

                public void always()
                {
                    loading = Boolean.valueOf(false);
                    loginLoading.setVisibility(8);
                }

                public void failure(int i, Exception exception)
                {
                }

                public void success(User.UserData userdata)
                {
                    openRadio();
                }

            
            {
                this$0 = Login.this;
                super();
            }
            });
            return;
        }
    }

    private void setListeners()
    {
        android.view.View.OnFocusChangeListener onfocuschangelistener = new android.view.View.OnFocusChangeListener() {

            final Login this$0;

            public void onFocusChange(View view, boolean flag)
            {
                if (flag)
                {
                    hideKeyboards();
                }
            }

            
            {
                this$0 = Login.this;
                super();
            }
        };
        layout.setOnFocusChangeListener(onfocuschangelistener);
        password.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            final Login this$0;

            public void onFocusChange(View view, boolean flag)
            {
                if (!flag)
                {
                    hideKeyboard(view);
                }
            }

            
            {
                this$0 = Login.this;
                super();
            }
        });
        password.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final Login this$0;

            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
            {
                if (i == 2 || i == 0)
                {
                    loginBtn.performClick();
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = Login.this;
                super();
            }
        });
        username.addTextChangedListener(new TextWatcher() {

            final Login this$0;

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
                this$0 = Login.this;
                super();
            }
        });
        usernameClear.setOnClickListener(new android.view.View.OnClickListener() {

            final Login this$0;

            public void onClick(View view)
            {
                username.setText("");
                username.requestFocus();
            }

            
            {
                this$0 = Login.this;
                super();
            }
        });
        password.addTextChangedListener(new TextWatcher() {

            final Login this$0;

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
                this$0 = Login.this;
                super();
            }
        });
        passwordClear.setOnClickListener(new android.view.View.OnClickListener() {

            final Login this$0;

            public void onClick(View view)
            {
                password.setText("");
                password.requestFocus();
            }

            
            {
                this$0 = Login.this;
                super();
            }
        });
        loginBtn.setOnClickListener(new android.view.View.OnClickListener() {

            final Login this$0;

            public void onClick(View view)
            {
                hideKeyboards();
                if (username.length() == 0)
                {
                    shake(usernameBox);
                    username.requestFocus();
                    return;
                }
                if (password.length() == 0)
                {
                    shake(passwordBox);
                    password.requestFocus();
                    return;
                } else
                {
                    login();
                    return;
                }
            }

            
            {
                this$0 = Login.this;
                super();
            }
        });
        signupBtn.setOnClickListener(new android.view.View.OnClickListener() {

            final Login this$0;

            public void onClick(View view)
            {
                hideKeyboards();
                openSignup();
            }

            
            {
                this$0 = Login.this;
                super();
            }
        });
        forgotPassword.setOnClickListener(new android.view.View.OnClickListener() {

            final Login this$0;

            public void onClick(View view)
            {
                hideKeyboards();
            }

            
            {
                this$0 = Login.this;
                super();
            }
        });
        continueAsGuest.setOnClickListener(new android.view.View.OnClickListener() {

            final Login this$0;

            public void onClick(View view)
            {
                hideKeyboards();
                openRadio();
            }

            
            {
                this$0 = Login.this;
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

            final Login this$0;
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
                this$0 = Login.this;
                callback = runnable;
                super();
            }
        });
        view.startAnimation(animation);
    }

    private void showDialog(String s, String s1)
    {
        (new android.app.AlertDialog.Builder(this)).setTitle(s).setMessage(s1).setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {

            final Login this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = Login.this;
                super();
            }
        }).setIcon(0x1080027).show();
    }

    private void showKeyboard(View view)
    {
        ((InputMethodManager)getSystemService("input_method")).showSoftInput(view, 0);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        console.log(new Object[] {
            "LOGIN ACTIVITY"
        });
        requestWindowFeature(1);
        setContentView(0x7f030023);
        layout = (LinearLayout)findViewById(0x7f080084);
        try
        {
            App.scaleViewGroup(layout);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        loginBtn = (FrameLayout)findViewById(0x7f08008c);
        signupBtn = (Button)findViewById(0x7f08008f);
        username = (EditText)findViewById(0x7f080087);
        password = (EditText)findViewById(0x7f08008a);
        forgotPassword = (TextView)findViewById(0x7f08008e);
        continueAsGuest = (TextView)findViewById(0x7f080090);
        usernameBox = (LinearLayout)findViewById(0x7f080086);
        passwordBox = (LinearLayout)findViewById(0x7f080089);
        usernameClear = (ImageButton)findViewById(0x7f080088);
        passwordClear = (ImageButton)findViewById(0x7f08008b);
        loginLoading = (ProgressBar)findViewById(0x7f08008d);
        setListeners();
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }


















}
