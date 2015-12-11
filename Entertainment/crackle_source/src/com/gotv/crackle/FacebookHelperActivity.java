// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.Request;
import com.facebook.RequestAsyncTask;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.Settings;
import com.facebook.model.GraphObject;
import com.facebook.widget.WebDialog;
import com.gotv.crackle.base.BaseActivity;
import com.gotv.crackle.data.CrackleAccountManager;
import com.gotv.crackle.data.SocialOnAPI;
import com.gotv.crackle.helpers.SharedPrefsManager;
import com.gotv.crackle.util.Log;
import com.gotv.crackle.util.OmnitureWrapper;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.gotv.crackle:
//            Application

public class FacebookHelperActivity extends BaseActivity
    implements com.gotv.crackle.data.DataRequest.DataRequestListener
{
    public static class RequestTypes
    {

        public static final int FacebookShareDialog = 1;
        public static final int FacebookShareSilent = 2;
        public static final int LoginWithFacebook = 4;
        public static final int SocialONEnable = 0;

        public RequestTypes()
        {
        }
    }


    public static final String EXTRA_REQUEST_TYPE = "REQUEST_TYPE";
    public static final String EXTRA_SHARE_STRING = "SHARE_STRING";
    private static final String MALE = "male";
    public static final String PERMISSION_EMAIL = "email";
    public static String mEmail;
    public static String mFirstname;
    public static String mGender;
    public static String mLastname;
    public static boolean mThreadDone = false;
    private CrackleAccountManager mAccountManager;
    private Date mBirthDate;
    private Button mDateOfBirthEdit;
    private EditText mEmailEdit;
    private RadioButton mFemaleButton;
    private EditText mFirstNameEdit;
    private EditText mLastNameEdit;
    private RadioButton mMaleButton;
    private EditText mPasswordConfirmEdit;
    private EditText mPasswordEdit;
    private Button mRegisterButton;
    private Dialog mRegisterDialog;
    private int mRequestType;
    private String mShareString;
    private SocialOnAPI mSocialOnAPI;
    private AlertDialog mSocialOnDialog;
    private com.facebook.Session.StatusCallback mStatusCallback;
    private TextWatcher mTextWatcherRegister;
    private CheckBox mTosCheckBox;

    public FacebookHelperActivity()
    {
        mStatusCallback = new com.facebook.Session.StatusCallback() {

            final FacebookHelperActivity this$0;

            public void call(Session session, SessionState sessionstate, Exception exception)
            {
                Log.d("FACEBOOK TEST", (new StringBuilder()).append("FACEBOOK TEST = ").append(session.isOpened()).toString());
                if (exception == null) goto _L2; else goto _L1
_L1:
                Toast.makeText(getThis().getApplicationContext(), exception.getLocalizedMessage(), 1).show();
                getThis().finish();
_L4:
                return;
_L2:
                if (!session.getPermissions().contains("email") || CrackleAccountManager.isLoggedIn())
                {
                    continue; /* Loop/switch isn't completed */
                }
                mSocialOnAPI = new SocialOnAPI();
                sessionstate = CrackleAccountManager.getUserID();
                mSocialOnAPI.callSSOService(getThis(), session.getAccessToken(), sessionstate);
                while (!FacebookHelperActivity.mThreadDone) ;
                if (FacebookHelperActivity.mEmail == null) goto _L4; else goto _L3
_L3:
                setUpRegisterView();
                return;
                if (sessionstate != SessionState.OPENED && sessionstate != SessionState.OPENED_TOKEN_UPDATED) goto _L4; else goto _L5
_L5:
                if (!session.getPermissions().contains("email"))
                {
                    requestNeededPermissions(session);
                    return;
                } else
                {
                    handleSuccess(session);
                    return;
                }
            }

            
            {
                this$0 = FacebookHelperActivity.this;
                super();
            }
        };
        mTextWatcherRegister = new TextWatcher() {

            final FacebookHelperActivity this$0;

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
                this$0 = FacebookHelperActivity.this;
                super();
            }
        };
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

    private void requestNeededPermissions(Session session)
    {
        session.requestNewReadPermissions(new com.facebook.Session.NewPermissionsRequest(getThis(), Arrays.asList(new String[] {
            "email"
        })));
    }

    public static void setFacebookUserInfo(String s, String s1, String s2, String s3, Boolean boolean1)
    {
        mFirstname = s;
        mLastname = s1;
        mEmail = s2;
        mGender = s3;
        mThreadDone = boolean1.booleanValue();
    }

    protected FacebookHelperActivity getThis()
    {
        return this;
    }

    public void handleSuccess(final Session session)
    {
        runOnUiThread(new Runnable() );
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        Session.getActiveSession().onActivityResult(this, i, j, intent);
    }

    public void onCreate(Bundle bundle)
    {
        Object obj;
        super.onCreate(bundle);
        setContentView(0x7f030045);
        obj = getIntent();
        mRequestType = ((Intent) (obj)).getIntExtra("REQUEST_TYPE", 0);
        mRequestType;
        JVM INSTR tableswitch 1 2: default 56
    //                   1 157
    //                   2 157;
           goto _L1 _L2 _L2
_L2:
        mShareString = ((Intent) (obj)).getStringExtra("SHARE_STRING");
_L1:
        Settings.addLoggingBehavior(LoggingBehavior.INCLUDE_ACCESS_TOKENS);
        obj = Session.getActiveSession();
        if (obj == null)
        {
            if (bundle != null)
            {
                obj = Session.restoreSession(this, null, mStatusCallback, bundle);
            }
            bundle = ((Bundle) (obj));
            if (obj == null)
            {
                bundle = new Session(this);
            }
            Session.setActiveSession(bundle);
            if (!bundle.isOpened() && !bundle.isClosed())
            {
                obj = (new com.facebook.Session.OpenRequest(this)).setCallback(mStatusCallback);
                ((com.facebook.Session.OpenRequest) (obj)).setPermissions(Arrays.asList(new String[] {
                    "email"
                }));
                bundle.openForRead(((com.facebook.Session.OpenRequest) (obj)));
                return;
            } else
            {
                Session.openActiveSession(this, true, mStatusCallback);
                return;
            }
        }
        Session.setActiveSession(((Session) (obj)));
        if (!((Session) (obj)).isOpened())
        {
            Session.openActiveSession(this, true, mStatusCallback);
            return;
        } else
        {
            mStatusCallback.call(((Session) (obj)), ((Session) (obj)).getState(), null);
            return;
        }
    }

    public void onDataFailed(String s, final String Message)
    {
        runOnUiThread(new Runnable() {

            final FacebookHelperActivity this$0;
            final String val$Message;

            public void run()
            {
                Toast.makeText(getThis().getApplicationContext(), Message, 1).show();
            }

            
            {
                this$0 = FacebookHelperActivity.this;
                Message = s;
                super();
            }
        });
        getThis().finish();
    }

    public void onDataSuccess(final String builder)
    {
        if (!builder.equalsIgnoreCase("ACCOUNT_SSO") || mRequestType == 0) goto _L2; else goto _L1
_L1:
        if (!SharedPrefsManager.getSocialOnEnabled()) goto _L4; else goto _L3
_L3:
        builder = new android.app.AlertDialog.Builder(getThis());
        builder.setMessage(getResources().getString(0x7f0b0138));
        builder.setPositiveButton(getResources().getString(0x7f0b013a), new android.content.DialogInterface.OnClickListener() {

            final FacebookHelperActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                String s = CrackleAccountManager.getUserID();
                mSocialOnAPI.updateSocialSettings(getThis(), s, true, true);
                dialoginterface.dismiss();
            }

            
            {
                this$0 = FacebookHelperActivity.this;
                super();
            }
        });
        builder.setNegativeButton(getResources().getString(0x7f0b0139), new android.content.DialogInterface.OnClickListener() {

            final FacebookHelperActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                SharedPrefsManager.setSocialOnEnabled(false);
                String s = CrackleAccountManager.getUserID();
                mSocialOnAPI.updateSocialSettings(getThis(), s, false, true);
                dialoginterface.dismiss();
            }

            
            {
                this$0 = FacebookHelperActivity.this;
                super();
            }
        });
        runOnUiThread(new Runnable() {

            final FacebookHelperActivity this$0;
            final android.app.AlertDialog.Builder val$builder;

            public void run()
            {
                mSocialOnDialog = builder.create();
                mSocialOnDialog.setCancelable(false);
                mSocialOnDialog.setCanceledOnTouchOutside(false);
                mSocialOnDialog.show();
            }

            
            {
                this$0 = FacebookHelperActivity.this;
                builder = builder1;
                super();
            }
        });
_L6:
        return;
_L4:
        handleSuccess(Session.getActiveSession());
        return;
_L2:
        if (builder.equalsIgnoreCase("ACCOUNT_SSO") && mRequestType == 0)
        {
            handleSuccess(Session.getActiveSession());
            return;
        }
        if (builder.equalsIgnoreCase("SOCIAL SETTINGS") && mRequestType != 0)
        {
            handleSuccess(Session.getActiveSession());
            return;
        }
        if (builder.equalsIgnoreCase("SOCIAL SETTINGS") && mRequestType == 0)
        {
            SharedPrefsManager.setSocialOnEnabled(true);
            finish();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        Session session = Session.getActiveSession();
        if (session.isOpened())
        {
            Session.saveSession(session, bundle);
        }
    }

    public void onStart()
    {
        super.onStart();
        Session.getActiveSession().addCallback(mStatusCallback);
    }

    public void onStop()
    {
        super.onStop();
        Session.getActiveSession().removeCallback(mStatusCallback);
    }

    protected void performMenuAction(int i)
    {
    }

    public void postDialog(Session session, String s)
    {
        Bundle bundle = new Bundle();
        bundle.putString("link", s);
        ((com.facebook.widget.WebDialog.FeedDialogBuilder)(new com.facebook.widget.WebDialog.FeedDialogBuilder(this, session, bundle)).setOnCompleteListener(new com.facebook.widget.WebDialog.OnCompleteListener() {

            final FacebookHelperActivity this$0;

            public void onComplete(Bundle bundle1, FacebookException facebookexception)
            {
                if (facebookexception == null)
                {
                    if (bundle1.getString("post_id") != null)
                    {
                        Toast.makeText(getThis(), getThis().getString(0x7f0b00c7), 0).show();
                        getThis().finish();
                        return;
                    } else
                    {
                        Toast.makeText(getThis().getApplicationContext(), getThis().getString(0x7f0b00c8), 0).show();
                        getThis().finish();
                        return;
                    }
                }
                if (facebookexception instanceof FacebookOperationCanceledException)
                {
                    Toast.makeText(getThis().getApplicationContext(), facebookexception.getLocalizedMessage(), 1).show();
                    getThis().finish();
                    return;
                } else
                {
                    Toast.makeText(getThis().getApplicationContext(), facebookexception.getLocalizedMessage(), 1).show();
                    getThis().finish();
                    return;
                }
            }

            
            {
                this$0 = FacebookHelperActivity.this;
                super();
            }
        })).build().show();
    }

    public void postSilent(Session session, String s)
    {
        Bundle bundle = new Bundle();
        bundle.putString("link", s);
        s = new com.facebook.Request.Callback() {

            final FacebookHelperActivity this$0;

            public void onCompleted(Response response)
            {
                JSONObject jsonobject = response.getGraphObject().getInnerJSONObject();
                try
                {
                    jsonobject.getString("id");
                }
                catch (JSONException jsonexception)
                {
                    Toast.makeText(getThis().getApplicationContext(), jsonexception.getLocalizedMessage(), 1).show();
                    getThis().finish();
                }
                response = response.getError();
                if (response != null)
                {
                    Toast.makeText(getThis().getApplicationContext(), response.getErrorMessage(), 1).show();
                    getThis().finish();
                    return;
                } else
                {
                    Toast.makeText(getThis(), getThis().getString(0x7f0b00c7), 0).show();
                    getThis().finish();
                    return;
                }
            }

            
            {
                this$0 = FacebookHelperActivity.this;
                super();
            }
        };
        (new RequestAsyncTask(new Request[] {
            new Request(session, "me/feed", bundle, HttpMethod.POST, s)
        })).execute(new Void[0]);
    }

    public void printHashKey()
    {
        int i = 0;
        Signature asignature[];
        Signature signature;
        MessageDigest messagedigest;
        int j;
        try
        {
            asignature = getPackageManager().getPackageInfo("com.gotv.crackle.handset", 64).signatures;
            j = asignature.length;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return;
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            break; /* Loop/switch isn't completed */
        }
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        signature = asignature[i];
        messagedigest = MessageDigest.getInstance("SHA");
        messagedigest.update(signature.toByteArray());
        Log.d("TEMPTAGHASH KEY:", Base64.encodeToString(messagedigest.digest(), 0));
        i++;
        continue; /* Loop/switch isn't completed */
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_23;
_L1:
    }

    public void setUpRegisterView()
    {
        boolean flag1 = false;
        Application.getInstance().getOmnitureTracker().registrationPage();
        View view = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f03005e, null);
        mAccountManager = new CrackleAccountManager();
        mBirthDate = null;
        mEmailEdit = (EditText)view.findViewById(0x7f0a0125);
        mEmailEdit.addTextChangedListener(mTextWatcherRegister);
        if (mEmail != null)
        {
            mEmailEdit.setText(mEmail);
        }
        mFirstNameEdit = (EditText)view.findViewById(0x7f0a0127);
        mFirstNameEdit.addTextChangedListener(mTextWatcherRegister);
        if (mFirstname != null)
        {
            mFirstNameEdit.setText(mFirstname);
        }
        mLastNameEdit = (EditText)view.findViewById(0x7f0a0128);
        mLastNameEdit.addTextChangedListener(mTextWatcherRegister);
        if (mLastname != null)
        {
            mLastNameEdit.setText(mLastname);
        }
        mPasswordEdit = (EditText)view.findViewById(0x7f0a0129);
        mPasswordEdit.addTextChangedListener(mTextWatcherRegister);
        mPasswordConfirmEdit = (EditText)view.findViewById(0x7f0a012a);
        mPasswordConfirmEdit.addTextChangedListener(mTextWatcherRegister);
        mDateOfBirthEdit = (Button)view.findViewById(0x7f0a012b);
        if (Application.isLeanBack())
        {
            mDateOfBirthEdit.setOnClickListener(new android.view.View.OnClickListener() {

                final FacebookHelperActivity this$0;

                public void onClick(final View datePicker)
                {
                    Object obj = new android.app.AlertDialog.Builder(FacebookHelperActivity.this);
                    Object obj1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f030041, null);
                    datePicker = (com.gotv.crackle.views.dpaddatepicker.DatePicker)((View) (obj1)).findViewById(0x7f0a00d0);
                    ((android.app.AlertDialog.Builder) (obj)).setView(((View) (obj1)));
                    ((android.app.AlertDialog.Builder) (obj)).setTitle(getString(0x7f0b007b));
                    obj1 = (Button)((View) (obj1)).findViewById(0x7f0a00d1);
                    obj = ((android.app.AlertDialog.Builder) (obj)).create();
                    ((AlertDialog) (obj)).show();
                    ((Button) (obj1)).setOnClickListener(((_cls1) (obj)). new android.view.View.OnClickListener() {

                        final _cls9 this$1;
                        final com.gotv.crackle.views.dpaddatepicker.DatePicker val$datePicker;
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
                this$1 = final__pcls9;
                datePicker = datepicker;
                finalDialog = AlertDialog.this;
                super();
            }
                    });
                    datePicker.setFirstFocus();
                }

            
            {
                this$0 = FacebookHelperActivity.this;
                super();
            }
            });
        } else
        {
            mDateOfBirthEdit.setOnClickListener(new android.view.View.OnClickListener() {

                final FacebookHelperActivity this$0;

                public void onClick(View view1)
                {
                    view1 = new android.app.AlertDialog.Builder(FacebookHelperActivity.this);
                    View view2 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f030040, null);
                    DatePicker datepicker = (DatePicker)view2.findViewById(0x7f0a00d0);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        datepicker.setCalendarViewShown(false);
                    }
                    view1.setView(view2);
                    view1.setPositiveButton("Ok", datepicker. new android.content.DialogInterface.OnClickListener() {

                        final _cls10 this$1;
                        final DatePicker val$datePicker;

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
                this$1 = final__pcls10;
                datePicker = DatePicker.this;
                super();
            }
                    });
                    view1.create().show();
                }

            
            {
                this$0 = FacebookHelperActivity.this;
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

            final FacebookHelperActivity this$0;
            final CheckBox val$newsletterCheckBox;

            public void onClick(View view1)
            {
                if (mPasswordEdit.getText().toString().compareTo(mPasswordConfirmEdit.getText().toString()) != 0)
                {
                    view1 = new android.app.AlertDialog.Builder(FacebookHelperActivity.this);
                    view1.setMessage(getResources().getString(0x7f0b0085));
                    view1.setPositiveButton("Ok", new android.content.DialogInterface.OnClickListener() {

                        final _cls11 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls11.this;
                super();
            }
                    });
                    view1.create().show();
                    return;
                }
                if (!mTosCheckBox.isChecked())
                {
                    view1 = new android.app.AlertDialog.Builder(FacebookHelperActivity.this);
                    view1.setMessage(getResources().getString(0x7f0b0090));
                    view1.setPositiveButton("Ok", new android.content.DialogInterface.OnClickListener() {

                        final _cls11 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls11.this;
                super();
            }
                    });
                    view1.create().show();
                    return;
                }
                showDialog(42340);
                int i;
                if (mFemaleButton.isChecked())
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                mAccountManager.createAccount(FacebookHelperActivity.this, null, mEmailEdit.getText().toString(), (new StringBuilder()).append(mFirstNameEdit.getText().toString()).append(" ").append(mLastNameEdit.getText().toString()).toString(), mPasswordEdit.getText().toString(), Integer.valueOf(i), (new StringBuilder()).append("").append(mBirthDate.getTime() / 1000L).toString(), Boolean.valueOf(newsletterCheckBox.isChecked()), Boolean.valueOf(mTosCheckBox.isChecked()), null, null);
                finish();
            }

            
            {
                this$0 = FacebookHelperActivity.this;
                newsletterCheckBox = checkbox;
                super();
            }
        });
        mRegisterDialog = new Dialog(this);
        ((TextView)mRegisterDialog.findViewById(0x1020016)).setTypeface(Application.getInstance().getTypeFace());
        mRegisterDialog.setContentView(view);
        mRegisterDialog.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final FacebookHelperActivity this$0;

            public void onCancel(DialogInterface dialoginterface)
            {
                finish();
            }

            
            {
                this$0 = FacebookHelperActivity.this;
                super();
            }
        });
        mRegisterDialog.setTitle(getResources().getString(0x7f0b0080));
        mRegisterDialog.setCanceledOnTouchOutside(true);
        mRegisterDialog.show();
    }






/*
    static SocialOnAPI access$102(FacebookHelperActivity facebookhelperactivity, SocialOnAPI socialonapi)
    {
        facebookhelperactivity.mSocialOnAPI = socialonapi;
        return socialonapi;
    }

*/










/*
    static AlertDialog access$402(FacebookHelperActivity facebookhelperactivity, AlertDialog alertdialog)
    {
        facebookhelperactivity.mSocialOnDialog = alertdialog;
        return alertdialog;
    }

*/



/*
    static Date access$502(FacebookHelperActivity facebookhelperactivity, Date date)
    {
        facebookhelperactivity.mBirthDate = date;
        return date;
    }

*/




}
