// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.helpers;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.widget.LoginButton;
import com.gotv.crackle.Application;
import com.gotv.crackle.FacebookHelperActivity;
import com.gotv.crackle.MyCrackleHistoryActivity;
import com.gotv.crackle.MyCrackleSettingsActivity;
import com.gotv.crackle.base.BaseActivity;
import com.gotv.crackle.data.CrackleAccountManager;
import com.gotv.crackle.data.Localization;
import com.gotv.crackle.model.MediaDetailsItem;
import com.gotv.crackle.util.OmnitureWrapper;
import com.gotv.crackle.views.dpaddatepicker.DatePicker;
import com.sessionm.api.SessionM;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MyCrackleViewHelper
{

    private static final String MALE = "male";
    private CrackleAccountManager mAccountManager;
    private Date mBirthDate;
    public String mBirthDateString;
    private BaseActivity mContext;
    private Button mDateOfBirthEdit;
    private EditText mEmailEdit;
    public String mEmailString;
    private RadioButton mFemaleButton;
    private EditText mFirstNameEdit;
    public String mFirstNameString;
    private Dialog mForgotPasswordDialog;
    private EditText mForgotPasswordEmailEdit;
    private TextWatcher mForgotPasswordTextWatcher;
    public String mGender;
    private EditText mLastNameEdit;
    public String mLastNameString;
    private RadioButton mMaleButton;
    private EditText mPasswordConfirmEdit;
    private EditText mPasswordEdit;
    private Button mRegisterButton;
    private Dialog mRegisterDialog;
    private Dialog mRegisterSignInDialog;
    private Button mSignInButton;
    private Dialog mSignInDialog;
    private Button mSignInRegisterButton;
    private Button mSubmitButton;
    private TextWatcher mTextWatcherRegister;
    private TextWatcher mTextWatcherSignIn;
    private CheckBox mTosCheckBox;

    public MyCrackleViewHelper()
    {
        mTextWatcherRegister = new TextWatcher() {

            final MyCrackleViewHelper this$0;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                checkIfWeHaveEverythingRegister();
            }

            
            {
                this$0 = MyCrackleViewHelper.this;
                super();
            }
        };
        mTextWatcherSignIn = new TextWatcher() {

            final MyCrackleViewHelper this$0;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                checkIfWeHaveEverythingSignIn();
            }

            
            {
                this$0 = MyCrackleViewHelper.this;
                super();
            }
        };
        mForgotPasswordTextWatcher = new TextWatcher() {

            final MyCrackleViewHelper this$0;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                checkIfWeHaveEverythingForgotPassword();
            }

            
            {
                this$0 = MyCrackleViewHelper.this;
                super();
            }
        };
    }

    private void checkIfWeHaveEverythingForgotPassword()
    {
        if (mForgotPasswordEmailEdit.getText().toString().compareTo("") != 0)
        {
            mSubmitButton.setEnabled(true);
            return;
        } else
        {
            mSubmitButton.setEnabled(false);
            return;
        }
    }

    private void checkIfWeHaveEverythingRegister()
    {
        try
        {
            if (mEmailEdit.getText().toString().compareTo("") != 0 && mFirstNameEdit.getText().toString().compareTo("") != 0 && mLastNameEdit.getText().toString().compareTo("") != 0 && mPasswordEdit.getText().toString().compareTo("") != 0 && mPasswordConfirmEdit.getText().toString().compareTo("") != 0 && mBirthDate != null)
            {
                mRegisterButton.setEnabled(true);
                return;
            }
        }
        catch (Exception exception)
        {
            return;
        }
        mRegisterButton.setEnabled(false);
        return;
    }

    private void checkIfWeHaveEverythingSignIn()
    {
        if (mEmailEdit.getText().toString().compareTo("") != 0 && mPasswordEdit.getText().toString().compareTo("") != 0)
        {
            mSignInButton.setEnabled(true);
            return;
        } else
        {
            mSignInButton.setEnabled(false);
            return;
        }
    }

    public static boolean isEnableSessionM()
    {
        return Application.getInstance().getLocalization().allRequestsComplete() && !Application.getInstance().getLocalization().isLatinAmericaUI() && !Application.isKindle() && !Application.isNookTablet() && !Application.isLeanBack();
    }

    private void setUpSignInRegisterView(final BaseActivity context, View view)
    {
        ((Button)view.findViewById(0x7f0a0148)).setOnClickListener(new android.view.View.OnClickListener() {

            final MyCrackleViewHelper this$0;
            final BaseActivity val$context;

            public void onClick(View view1)
            {
                setUpSignInView(context);
            }

            
            {
                this$0 = MyCrackleViewHelper.this;
                context = baseactivity;
                super();
            }
        });
        LoginButton loginbutton = (LoginButton)view.findViewById(0x7f0a014a);
        if (Application.isLeanBack())
        {
            view.findViewById(0x7f0a0149).setVisibility(8);
            loginbutton.setVisibility(8);
        } else
        {
            loginbutton.setOnClickListener(new android.view.View.OnClickListener() {

                final MyCrackleViewHelper this$0;
                final BaseActivity val$context;

                public void onClick(View view1)
                {
                    mRegisterSignInDialog.dismiss();
                    view1 = new Intent(context, com/gotv/crackle/FacebookHelperActivity);
                    view1.putExtra("REQUEST_TYPE", 4);
                    context.startActivity(view1);
                }

            
            {
                this$0 = MyCrackleViewHelper.this;
                context = baseactivity;
                super();
            }
            });
        }
        ((Button)view.findViewById(0x7f0a0131)).setOnClickListener(new android.view.View.OnClickListener() {

            final MyCrackleViewHelper this$0;
            final BaseActivity val$context;

            public void onClick(View view1)
            {
                setUpRegisterView(context);
            }

            
            {
                this$0 = MyCrackleViewHelper.this;
                context = baseactivity;
                super();
            }
        });
    }

    public void dismissForgotPasswordDialog()
    {
        if (mForgotPasswordDialog != null)
        {
            mForgotPasswordDialog.dismiss();
        }
    }

    public void dismissRegistrationDialog()
    {
        if (mRegisterDialog != null)
        {
            mRegisterDialog.dismiss();
        }
    }

    public void dismissSignInDialog()
    {
        if (mSignInDialog != null)
        {
            mSignInDialog.dismiss();
        }
    }

    public void dismissSignInRegistrationDialog()
    {
        if (mRegisterSignInDialog != null)
        {
            mRegisterSignInDialog.dismiss();
        }
    }

    public void setUpLogOut()
    {
        try
        {
            mSignInRegisterButton.setText(mContext.getResources().getString(0x7f0b0066));
            mSignInRegisterButton.setOnClickListener(new android.view.View.OnClickListener() {

                final MyCrackleViewHelper this$0;

                public void onClick(View view)
                {
                    CrackleAccountManager.logOut();
                    mSignInRegisterButton.setText(mContext.getResources().getString(0x7f0b0065));
                    mSignInRegisterButton.setOnClickListener(new android.view.View.OnClickListener() {

                        final _cls2 this$1;

                        public void onClick(View view)
                        {
                            view = ((LayoutInflater)mContext.getSystemService("layout_inflater")).inflate(0x7f030061, null);
                            setUpSignInRegisterView(mContext, view);
                            mRegisterSignInDialog = new Dialog(mContext);
                            ((TextView)mRegisterSignInDialog.findViewById(0x1020016)).setTypeface(Application.getInstance().getTypeFace());
                            mRegisterSignInDialog.setContentView(view);
                            mRegisterSignInDialog.setTitle(mContext.getResources().getString(0x7f0b0081));
                            mRegisterSignInDialog.setCanceledOnTouchOutside(true);
                            mRegisterSignInDialog.show();
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                }

            
            {
                this$0 = MyCrackleViewHelper.this;
                super();
            }
            });
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void setUpMenuLogOut(BaseActivity baseactivity, MenuItem menuitem)
    {
        CrackleAccountManager.logOut();
        menuitem.setTitle(baseactivity.getResources().getString(0x7f0b0065));
    }

    public void setUpRegisterView(final BaseActivity context)
    {
        boolean flag1 = false;
        Application.getInstance().getOmnitureTracker().registrationPage();
        View view = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f03005e, null);
        mAccountManager = new CrackleAccountManager();
        mBirthDate = null;
        mEmailEdit = (EditText)view.findViewById(0x7f0a0125);
        mEmailEdit.addTextChangedListener(mTextWatcherRegister);
        if (mEmailString != null)
        {
            mEmailEdit.setText(mEmailString);
        }
        mFirstNameEdit = (EditText)view.findViewById(0x7f0a0127);
        mFirstNameEdit.addTextChangedListener(mTextWatcherRegister);
        if (mFirstNameEdit != null)
        {
            mFirstNameEdit.setText(mFirstNameString);
        }
        mLastNameEdit = (EditText)view.findViewById(0x7f0a0128);
        mLastNameEdit.addTextChangedListener(mTextWatcherRegister);
        if (mLastNameEdit != null)
        {
            mLastNameEdit.setText(mLastNameString);
        }
        mPasswordEdit = (EditText)view.findViewById(0x7f0a0129);
        mPasswordEdit.addTextChangedListener(mTextWatcherRegister);
        mPasswordConfirmEdit = (EditText)view.findViewById(0x7f0a012a);
        mPasswordConfirmEdit.addTextChangedListener(mTextWatcherRegister);
        mDateOfBirthEdit = (Button)view.findViewById(0x7f0a012b);
        if (Application.isLeanBack())
        {
            mDateOfBirthEdit.setOnClickListener(new android.view.View.OnClickListener() {

                final MyCrackleViewHelper this$0;
                final BaseActivity val$context;

                public void onClick(final View datePicker)
                {
                    Object obj = new android.app.AlertDialog.Builder(context);
                    Object obj1 = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f030041, null);
                    datePicker = (DatePicker)((View) (obj1)).findViewById(0x7f0a00d0);
                    ((android.app.AlertDialog.Builder) (obj)).setView(((View) (obj1)));
                    ((android.app.AlertDialog.Builder) (obj)).setTitle(context.getString(0x7f0b007b));
                    obj1 = (Button)((View) (obj1)).findViewById(0x7f0a00d1);
                    obj = ((android.app.AlertDialog.Builder) (obj)).create();
                    ((AlertDialog) (obj)).show();
                    ((Button) (obj1)).setOnClickListener(((_cls1) (obj)). new android.view.View.OnClickListener() {

                        final _cls6 this$1;
                        final DatePicker val$datePicker;
                        final AlertDialog val$finalDialog;

                        public void onClick(View view)
                        {
                            view = Calendar.getInstance();
                            view.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
                            mBirthDate = view.getTime();
                            view = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
                            mDateOfBirthEdit.setText(view.format(mBirthDate));
                            checkIfWeHaveEverythingRegister();
                            finalDialog.dismiss();
                        }

            
            {
                this$1 = final__pcls6;
                datePicker = datepicker;
                finalDialog = AlertDialog.this;
                super();
            }
                    });
                    datePicker.setFirstFocus();
                }

            
            {
                this$0 = MyCrackleViewHelper.this;
                context = baseactivity;
                super();
            }
            });
        } else
        {
            mDateOfBirthEdit.setOnClickListener(new android.view.View.OnClickListener() {

                final MyCrackleViewHelper this$0;
                final BaseActivity val$context;

                public void onClick(View view1)
                {
                    view1 = new android.app.AlertDialog.Builder(context);
                    View view2 = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f030040, null);
                    android.widget.DatePicker datepicker = (android.widget.DatePicker)view2.findViewById(0x7f0a00d0);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        datepicker.setCalendarViewShown(false);
                    }
                    view1.setView(view2);
                    view1.setPositiveButton("Ok", datepicker. new android.content.DialogInterface.OnClickListener() {

                        final _cls7 this$1;
                        final android.widget.DatePicker val$datePicker;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            Object obj = Calendar.getInstance();
                            ((Calendar) (obj)).set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
                            mBirthDate = ((Calendar) (obj)).getTime();
                            obj = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
                            mDateOfBirthEdit.setText(((SimpleDateFormat) (obj)).format(mBirthDate));
                            checkIfWeHaveEverythingRegister();
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = final__pcls7;
                datePicker = android.widget.DatePicker.this;
                super();
            }
                    });
                    view1.create().show();
                }

            
            {
                this$0 = MyCrackleViewHelper.this;
                context = baseactivity;
                super();
            }
            });
        }
        mFemaleButton = (RadioButton)view.findViewById(0x7f0a012e);
        mMaleButton = (RadioButton)view.findViewById(0x7f0a012d);
        if (mGender != null)
        {
            final CheckBox newsletterCheckBox;
            boolean flag;
            if (mGender.equalsIgnoreCase("male"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            newsletterCheckBox = mFemaleButton;
            if (!flag)
            {
                flag1 = true;
            }
            newsletterCheckBox.setChecked(flag1);
            mMaleButton.setChecked(flag);
        }
        newsletterCheckBox = (CheckBox)view.findViewById(0x7f0a012f);
        mTosCheckBox = (CheckBox)view.findViewById(0x7f0a0130);
        mRegisterButton = (Button)view.findViewById(0x7f0a0131);
        mRegisterButton.setOnClickListener(new android.view.View.OnClickListener() {

            final MyCrackleViewHelper this$0;
            final BaseActivity val$context;
            final CheckBox val$newsletterCheckBox;

            public void onClick(View view1)
            {
                if (mPasswordEdit.getText().toString().compareTo(mPasswordConfirmEdit.getText().toString()) != 0)
                {
                    view1 = new android.app.AlertDialog.Builder(context);
                    view1.setMessage(context.getResources().getString(0x7f0b0085));
                    view1.setPositiveButton("Ok", new android.content.DialogInterface.OnClickListener() {

                        final _cls8 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls8.this;
                super();
            }
                    });
                    view1.create().show();
                    return;
                }
                int i;
                if (mFemaleButton.isChecked())
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                mAccountManager.createAccount(context, null, mEmailEdit.getText().toString(), (new StringBuilder()).append(mFirstNameEdit.getText().toString()).append(" ").append(mLastNameEdit.getText().toString()).toString(), mPasswordEdit.getText().toString(), Integer.valueOf(i), (new StringBuilder()).append("").append(mBirthDate.getTime() / 1000L).toString(), Boolean.valueOf(newsletterCheckBox.isChecked()), Boolean.valueOf(mTosCheckBox.isChecked()), null, null);
                mRegisterDialog.dismiss();
                mRegisterSignInDialog.dismiss();
                Toast.makeText(context.getApplicationContext(), context.getString(0x7f0b0117), 1).show();
            }

            
            {
                this$0 = MyCrackleViewHelper.this;
                context = baseactivity;
                newsletterCheckBox = checkbox;
                super();
            }
        });
        mRegisterDialog = new Dialog(context);
        ((TextView)mRegisterDialog.findViewById(0x1020016)).setTypeface(Application.getInstance().getTypeFace());
        mRegisterDialog.setContentView(view);
        mRegisterDialog.setTitle(context.getResources().getString(0x7f0b0080));
        mRegisterDialog.setCanceledOnTouchOutside(true);
        mRegisterDialog.show();
    }

    public void setUpSignInView(final BaseActivity context)
    {
        Application.getInstance().getOmnitureTracker().loginPage();
        View view = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f030060, null);
        mAccountManager = new CrackleAccountManager();
        mEmailEdit = (EditText)view.findViewById(0x7f0a0125);
        mEmailEdit.addTextChangedListener(mTextWatcherSignIn);
        mPasswordEdit = (EditText)view.findViewById(0x7f0a0129);
        mPasswordEdit.addTextChangedListener(mTextWatcherSignIn);
        mSignInButton = (Button)view.findViewById(0x7f0a0144);
        mSignInButton.setOnClickListener(new android.view.View.OnClickListener() {

            final MyCrackleViewHelper this$0;
            final BaseActivity val$context;

            public void onClick(View view1)
            {
                mAccountManager.verifyUserLogin(context, mEmailEdit.getText().toString(), mPasswordEdit.getText().toString());
                mSignInDialog.dismiss();
                mRegisterSignInDialog.dismiss();
                Toast.makeText(context.getApplicationContext(), context.getString(0x7f0b0118), 0).show();
            }

            
            {
                this$0 = MyCrackleViewHelper.this;
                context = baseactivity;
                super();
            }
        });
        ((Button)view.findViewById(0x7f0a0145)).setOnClickListener(new android.view.View.OnClickListener() {

            final MyCrackleViewHelper this$0;
            final BaseActivity val$context;

            public void onClick(View view1)
            {
                mForgotPasswordDialog = new Dialog(context);
                view1 = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f03005d, null);
                mForgotPasswordDialog.setContentView(view1);
                mForgotPasswordDialog.setTitle(context.getString(0x7f0b0062));
                mForgotPasswordEmailEdit = (EditText)view1.findViewById(0x7f0a0125);
                mForgotPasswordEmailEdit.addTextChangedListener(mForgotPasswordTextWatcher);
                mSubmitButton = (Button)view1.findViewById(0x7f0a0126);
                mSubmitButton.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls12 this$1;

                    public void onClick(View view)
                    {
                        context.showDialogFragment(42340);
                        view = mForgotPasswordEmailEdit.getText().toString().trim();
                        if (view.contains(" "))
                        {
                            view.replace(" ", "");
                            return;
                        } else
                        {
                            mAccountManager.forgotPassword(context, view);
                            return;
                        }
                    }

            
            {
                this$1 = _cls12.this;
                super();
            }
                });
                mForgotPasswordDialog.setCanceledOnTouchOutside(true);
                mForgotPasswordDialog.show();
            }

            
            {
                this$0 = MyCrackleViewHelper.this;
                context = baseactivity;
                super();
            }
        });
        mSignInDialog = new Dialog(context);
        ((TextView)mSignInDialog.findViewById(0x1020016)).setTypeface(Application.getInstance().getTypeFace());
        mSignInDialog.setContentView(view);
        mSignInDialog.setTitle(context.getResources().getString(0x7f0b0081));
        mSignInDialog.setCanceledOnTouchOutside(true);
        mSignInDialog.show();
    }

    public void showAboutCrackle(final BaseActivity context)
    {
        context.runOnUiThread(new Runnable() {

            final MyCrackleViewHelper this$0;
            final BaseActivity val$context;

            public void run()
            {
                View view = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f03003b, null);
                Object obj = new android.app.AlertDialog.Builder(context);
                ((android.app.AlertDialog.Builder) (obj)).setView(view);
                obj = ((android.app.AlertDialog.Builder) (obj)).create();
                ((AlertDialog) (obj)).setCanceledOnTouchOutside(true);
                WebView webview = (WebView)view.findViewById(0x7f0a00bf);
                view.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, Application.getScreenHeight() / 2));
                if (android.os.Build.VERSION.SDK_INT > 13)
                {
                    webview.getSettings().setTextZoom(130);
                }
                webview.loadUrl(context.getResources().getString(0x7f0b0089));
                ((AlertDialog) (obj)).show();
            }

            
            {
                this$0 = MyCrackleViewHelper.this;
                context = baseactivity;
                super();
            }
        });
    }

    public void showAboutNielsen(final BaseActivity context)
    {
        context.runOnUiThread(new Runnable() {

            final MyCrackleViewHelper this$0;
            final BaseActivity val$context;

            public void run()
            {
                Application.isNielsenOptOutShowing = true;
                Application.getInstance().getOmnitureTracker().myCracklePage("about Nielsen");
                Object obj1 = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f03003b, null);
                Object obj = new android.app.AlertDialog.Builder(context);
                ((android.app.AlertDialog.Builder) (obj)).setView(((View) (obj1)));
                obj = ((android.app.AlertDialog.Builder) (obj)).create();
                ((AlertDialog) (obj)).setCanceledOnTouchOutside(true);
                ((AlertDialog) (obj)).show();
                ((AlertDialog) (obj)).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                    final _cls17 this$1;

                    public void onCancel(DialogInterface dialoginterface)
                    {
                        Application.isNielsenOptOutShowing = false;
                    }

            
            {
                this$1 = _cls17.this;
                super();
            }
                });
                Object obj2 = new android.widget.RelativeLayout.LayoutParams(Application.getScreenWidth(), Application.getScreenHeight());
                obj1 = (WebView)((View) (obj1)).findViewById(0x7f0a00bf);
                ((WebView) (obj1)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
                if (android.os.Build.VERSION.SDK_INT > 13)
                {
                    ((WebView) (obj1)).getSettings().setTextZoom(130);
                }
                ((WebView) (obj1)).setWebViewClient(new WebViewClient() {

                    final _cls17 this$1;

                    public boolean shouldOverrideUrlLoading(WebView webview, String s)
                    {
                        if (Application.isFanhattan() && s.startsWith("mailto:"))
                        {
                            webview = s.substring(s.indexOf(":") + 1);
                            s = (new android.app.AlertDialog.Builder(context)).create();
                            s.setTitle("Contact Us");
                            s.setMessage(webview);
                            s.show();
                            return true;
                        } else
                        {
                            return super.shouldOverrideUrlLoading(webview, s);
                        }
                    }

            
            {
                this$1 = _cls17.this;
                super();
            }
                });
                obj2 = BaseActivity.getNielsenOptOutUrl();
                if (obj2 != null)
                {
                    ((WebView) (obj1)).getSettings().setJavaScriptEnabled(true);
                    ((WebView) (obj1)).getSettings().setBuiltInZoomControls(true);
                    ((WebView) (obj1)).getSettings().setDisplayZoomControls(false);
                    ((WebView) (obj1)).getSettings().setLoadWithOverviewMode(true);
                    ((WebView) (obj1)).getSettings().setUseWideViewPort(true);
                    ((WebView) (obj1)).getSettings().setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
                    ((WebView) (obj1)).loadUrl(((String) (obj2)));
                    ((WebView) (obj1)).setWebViewClient(((_cls3) (obj)). new WebViewClient() {

                        final _cls17 this$1;
                        final AlertDialog val$alertDialog;

                        public boolean shouldOverrideUrlLoading(WebView webview, String s)
                        {
                            Log.d("OptOutActivity", (new StringBuilder()).append("shouldOverrideUrlLoading: ").append(s).toString());
                            if (s.indexOf("nielsen") == 0)
                            {
                                BaseActivity.setNielsenUserOptOut(s);
                                alertDialog.dismiss();
                                Application.isNielsenOptOutShowing = false;
                                return false;
                            } else
                            {
                                Application.isNielsenOptOutShowing = false;
                                return true;
                            }
                        }

            
            {
                this$1 = final__pcls17;
                alertDialog = AlertDialog.this;
                super();
            }
                    });
                }
            }

            
            {
                this$0 = MyCrackleViewHelper.this;
                context = baseactivity;
                super();
            }
        });
    }

    public void showBuy(Context context, MediaDetailsItem mediadetailsitem)
    {
        if (mediadetailsitem.getAmazonLink() != null && !mediadetailsitem.getAmazonLink().isEmpty() && !mediadetailsitem.getAmazonLink().equalsIgnoreCase("null"))
        {
            Application.getInstance().getOmnitureTracker().onVideoBuy(mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannelID(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "", "", mediadetailsitem.getDuration());
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(mediadetailsitem.getAmazonLink())));
        }
    }

    public void showFAQ(final BaseActivity context)
    {
        context.runOnUiThread(new Runnable() {

            final MyCrackleViewHelper this$0;
            final BaseActivity val$context;

            public void run()
            {
                Application.getInstance().getOmnitureTracker().myCracklePage("faq");
                Object obj = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f03003b, null);
                Object obj1 = new android.app.AlertDialog.Builder(context);
                ((android.app.AlertDialog.Builder) (obj1)).setView(((View) (obj)));
                obj1 = ((android.app.AlertDialog.Builder) (obj1)).create();
                ((AlertDialog) (obj1)).setCanceledOnTouchOutside(true);
                ((AlertDialog) (obj1)).show();
                obj = (WebView)((View) (obj)).findViewById(0x7f0a00bf);
                if (android.os.Build.VERSION.SDK_INT > 13)
                {
                    ((WebView) (obj)).getSettings().setTextZoom(130);
                }
                ((WebView) (obj)).loadUrl(context.getResources().getString(0x7f0b008a));
            }

            
            {
                this$0 = MyCrackleViewHelper.this;
                context = baseactivity;
                super();
            }
        });
    }

    public void showGiveFeedback(BaseActivity baseactivity)
    {
        Object obj = ((LayoutInflater)baseactivity.getSystemService("layout_inflater")).inflate(0x7f03003b, null);
        int i;
        if (Application.getScreenWidth() <= Application.getScreenHeight())
        {
            i = Application.getScreenWidth();
        } else
        {
            i = Application.getScreenHeight();
        }
        ((View) (obj)).setLayoutParams(new android.widget.FrameLayout.LayoutParams(i - i / 50, i - i / 50));
        obj = (WebView)((View) (obj)).findViewById(0x7f0a00bf);
        ((WebView) (obj)).getSettings().setJavaScriptEnabled(true);
        ((WebView) (obj)).loadUrl(baseactivity.getResources().getString(0x7f0b008d));
    }

    public void showHistory(BaseActivity baseactivity)
    {
        if (CrackleAccountManager.getUserID() != null)
        {
            baseactivity.startActivity(new Intent(baseactivity, com/gotv/crackle/MyCrackleHistoryActivity));
            return;
        } else
        {
            baseactivity.showDialogFragment(0x2d7d7d);
            return;
        }
    }

    public void showPrivacyPolicy(final BaseActivity context)
    {
        context.runOnUiThread(new Runnable() {

            final MyCrackleViewHelper this$0;
            final BaseActivity val$context;

            public void run()
            {
                Application.getInstance().getOmnitureTracker().myCracklePage("privacy policy");
                Object obj = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f03003b, null);
                Object obj1 = new android.app.AlertDialog.Builder(context);
                ((android.app.AlertDialog.Builder) (obj1)).setView(((View) (obj)));
                obj1 = ((android.app.AlertDialog.Builder) (obj1)).create();
                ((AlertDialog) (obj1)).setCanceledOnTouchOutside(true);
                ((AlertDialog) (obj1)).show();
                obj1 = new android.widget.RelativeLayout.LayoutParams(-2, Application.getScreenHeight() / 2);
                obj = (WebView)((View) (obj)).findViewById(0x7f0a00bf);
                ((WebView) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                if (android.os.Build.VERSION.SDK_INT > 13)
                {
                    ((WebView) (obj)).getSettings().setTextZoom(130);
                }
                ((WebView) (obj)).setWebViewClient(new WebViewClient() {

                    final _cls16 this$1;

                    public boolean shouldOverrideUrlLoading(WebView webview, String s)
                    {
                        if (Application.isFanhattan() && s.startsWith("mailto:"))
                        {
                            webview = s.substring(s.indexOf(":") + 1);
                            s = (new android.app.AlertDialog.Builder(context)).create();
                            s.setTitle("Contact Us");
                            s.setMessage(webview);
                            s.show();
                            return true;
                        } else
                        {
                            return super.shouldOverrideUrlLoading(webview, s);
                        }
                    }

            
            {
                this$1 = _cls16.this;
                super();
            }
                });
                ((WebView) (obj)).getSettings().setLoadWithOverviewMode(true);
                ((WebView) (obj)).getSettings().setUseWideViewPort(true);
                ((WebView) (obj)).loadUrl(context.getResources().getString(0x7f0b008c));
            }

            
            {
                this$0 = MyCrackleViewHelper.this;
                context = baseactivity;
                super();
            }
        });
    }

    public void showRateMe(BaseActivity baseactivity)
    {
        Application.getInstance().getOmnitureTracker().myCracklePage("rate me");
        if (Application.isKindle())
        {
            baseactivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("http://www.amazon.com/gp/mas/dl/android?p=").append(Application.getInstance().getPackageName()).toString())));
            return;
        } else
        {
            baseactivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(Application.getInstance().getPackageName()).toString())));
            return;
        }
    }

    public void showSessionMPortal()
    {
        if (!Application.isKindle())
        {
            SessionM.getInstance().presentActivity(com.sessionm.api.SessionM.ActivityType.PORTAL);
        }
    }

    public void showSettings(Context context)
    {
        context.startActivity(new Intent(context, com/gotv/crackle/MyCrackleSettingsActivity));
    }

    public void showSigInOut(BaseActivity baseactivity, MenuItem menuitem)
    {
        if (CrackleAccountManager.isLoggedIn())
        {
            CrackleAccountManager.logOut();
            menuitem.setTitle(baseactivity.getResources().getString(0x7f0b0065));
            return;
        } else
        {
            showSignInDialog(baseactivity);
            return;
        }
    }

    public Dialog showSignInDialog(BaseActivity baseactivity)
    {
        View view = ((LayoutInflater)baseactivity.getSystemService("layout_inflater")).inflate(0x7f030061, null);
        setUpSignInRegisterView(baseactivity, view);
        mRegisterSignInDialog = new Dialog(baseactivity);
        ((TextView)mRegisterSignInDialog.findViewById(0x1020016)).setTypeface(Application.getInstance().getTypeFace());
        mRegisterSignInDialog.setContentView(view);
        mRegisterSignInDialog.setTitle(baseactivity.getResources().getString(0x7f0b0081));
        if (!Application.getInstance().isTablet()) goto _L2; else goto _L1
_L1:
        mRegisterSignInDialog.getWindow().setLayout(500, 700);
_L4:
        mRegisterSignInDialog.setCanceledOnTouchOutside(true);
        mRegisterSignInDialog.show();
        return mRegisterSignInDialog;
_L2:
        if (Application.getInstance().isLandscape())
        {
            mRegisterSignInDialog.getWindow().setLayout(1000, 1000);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void showTOS(final BaseActivity context)
    {
        context.runOnUiThread(new Runnable() {

            final MyCrackleViewHelper this$0;
            final BaseActivity val$context;

            public void run()
            {
                Application.getInstance().getOmnitureTracker().myCracklePage("terms of service");
                Object obj = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f03003b, null);
                Object obj1 = new android.app.AlertDialog.Builder(context);
                ((android.app.AlertDialog.Builder) (obj1)).setView(((View) (obj)));
                obj1 = ((android.app.AlertDialog.Builder) (obj1)).create();
                ((AlertDialog) (obj1)).setCanceledOnTouchOutside(true);
                ((AlertDialog) (obj1)).show();
                obj1 = new android.widget.RelativeLayout.LayoutParams(-2, Application.getScreenHeight() / 2);
                obj = (WebView)((View) (obj)).findViewById(0x7f0a00bf);
                ((WebView) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                if (android.os.Build.VERSION.SDK_INT > 13)
                {
                    ((WebView) (obj)).getSettings().setTextZoom(130);
                }
                ((WebView) (obj)).loadUrl(context.getResources().getString(0x7f0b008b));
            }

            
            {
                this$0 = MyCrackleViewHelper.this;
                context = baseactivity;
                super();
            }
        });
    }














/*
    static Dialog access$1902(MyCrackleViewHelper mycrackleviewhelper, Dialog dialog)
    {
        mycrackleviewhelper.mForgotPasswordDialog = dialog;
        return dialog;
    }

*/




/*
    static EditText access$2002(MyCrackleViewHelper mycrackleviewhelper, EditText edittext)
    {
        mycrackleviewhelper.mForgotPasswordEmailEdit = edittext;
        return edittext;
    }

*/




/*
    static Button access$2202(MyCrackleViewHelper mycrackleviewhelper, Button button)
    {
        mycrackleviewhelper.mSubmitButton = button;
        return button;
    }

*/




/*
    static Dialog access$402(MyCrackleViewHelper mycrackleviewhelper, Dialog dialog)
    {
        mycrackleviewhelper.mRegisterSignInDialog = dialog;
        return dialog;
    }

*/



/*
    static Date access$502(MyCrackleViewHelper mycrackleviewhelper, Date date)
    {
        mycrackleviewhelper.mBirthDate = date;
        return date;
    }

*/




}
