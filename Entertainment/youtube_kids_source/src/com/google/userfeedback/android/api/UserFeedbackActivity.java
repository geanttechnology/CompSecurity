// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

// Referenced classes of package com.google.userfeedback.android.api:
//            UserFeedback, UserFeedbackSpec, UiConfigurationOptions

public class UserFeedbackActivity extends Activity
{

    private Spinner mChooseAccount;
    private EditText mFeedbackText;
    private CheckBox mIncludeScreenshot;
    private CheckBox mIncludeSystemLogs;
    private Button mPreviewFeedback;
    private Button mSubmitFeedback;
    private final UserFeedback mUserfeedback = UserFeedback.userFeedback();

    public UserFeedbackActivity()
    {
    }

    private void computeResourcesAndUpdateUi(Context context, Spinner spinner, Button button)
    {
        (new UpdateActivityOnReportCollection(context, spinner, button)).execute(new Void[0]);
    }

    private void configureActivity()
    {
        if (mUserfeedback == null || mUserfeedback.getSpec() == null)
        {
            setResult(0);
            finishActivity(0);
            return;
        }
        updateUi(this);
        if (!mUserfeedback.getSpec().isScreenshotEnabled())
        {
            findViewById(R.id.gf_screenshot_option).setVisibility(8);
        } else
        {
            mIncludeScreenshot = (CheckBox)findViewById(R.id.gf_send_screenshot);
            mIncludeScreenshot.setOnCheckedChangeListener(new OnUserChoiceInputChangeListener(null));
        }
        mFeedbackText = (EditText)findViewById(R.id.gf_feedback);
        if (!mUserfeedback.getSpec().isSystemLogEnabled())
        {
            findViewById(R.id.gf_system_logs_option).setVisibility(8);
        } else
        {
            mIncludeSystemLogs = (CheckBox)findViewById(R.id.gf_send_system_info);
            mIncludeSystemLogs.setOnCheckedChangeListener(new OnUserChoiceInputChangeListener(null));
        }
        mPreviewFeedback = (Button)findViewById(R.id.gf_preview);
        mPreviewFeedback.setOnClickListener(new _cls1());
        mSubmitFeedback = (Button)findViewById(R.id.gf_send);
        mSubmitFeedback.setOnClickListener(new _cls2());
        mChooseAccount = (Spinner)findViewById(R.id.gf_account_spinner);
        mChooseAccount.setBackgroundDrawable(null);
        mChooseAccount.setOnItemSelectedListener(new _cls3());
        findViewById(R.id.gf_privacy_option).setOnClickListener(new _cls4());
        computeResourcesAndUpdateUi(this, mChooseAccount, mPreviewFeedback);
    }

    private void handleClick(boolean flag, boolean flag1, String s)
    {
        UserFeedback.userFeedback().setUserInputParams(flag, flag1, s);
    }

    private void setHeaderUi(int i, UiConfigurationOptions uiconfigurationoptions)
    {
        TextView textview = (TextView)findViewById(i);
        i = uiconfigurationoptions.getHeaderBackgroundResourceId();
        int j = uiconfigurationoptions.getSectionHeaderFontColor();
        if (textview != null)
        {
            if (i < 0)
            {
                textview.setBackgroundDrawable(null);
            } else
            {
                textview.setBackgroundDrawable(getResources().getDrawable(i));
            }
            if (j != 0)
            {
                textview.setTextColor(getResources().getColor(j));
            }
        }
    }

    private boolean shouldIncludeScreenshot()
    {
        if (!mUserfeedback.getSpec().isScreenshotEnabled())
        {
            return false;
        } else
        {
            return mIncludeScreenshot.isChecked();
        }
    }

    private boolean shouldIncludeSystemLogs()
    {
        if (mUserfeedback.getSpec().isSystemLogEnabled())
        {
            return mIncludeSystemLogs.isChecked();
        } else
        {
            return false;
        }
    }

    private void updateAppIcon(final Activity thisActivity)
    {
        (new _cls1FetchAppIconTask()).execute(new Void[0]);
    }

    private void updateUi(Activity activity)
    {
        UiConfigurationOptions uiconfigurationoptions = UserFeedback.userFeedback().getSpec().getUiConfigurationOptions();
        if (uiconfigurationoptions != null)
        {
            if (uiconfigurationoptions.getHideTitleBar())
            {
                findViewById(R.id.gf_app_header).setVisibility(8);
            } else
            {
                updateAppIcon(activity);
            }
            if (uiconfigurationoptions.getBackgroundColor() != 0)
            {
                getWindow().getDecorView().setBackgroundColor(getResources().getColor(uiconfigurationoptions.getBackgroundColor()));
            }
            setHeaderUi(R.id.gf_feedback_header, uiconfigurationoptions);
            setHeaderUi(R.id.gf_privacy, uiconfigurationoptions);
            setHeaderUi(R.id.gf_user_account, uiconfigurationoptions);
            return;
        } else
        {
            updateAppIcon(activity);
            return;
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        switch (j)
        {
        default:
            return;

        case -1: 
            setResult(-1);
            break;
        }
        finish();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.gf_feedback_activity);
        configureActivity();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        UserFeedback.flushBitmapsOnDestroy(this);
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        if (mUserfeedback == null || mUserfeedback.getSpec() == null || mUserfeedback.getReport() == null)
        {
            setResult(0);
            finish();
        }
    }







    private class UpdateActivityOnReportCollection extends AsyncTask
    {

        private Spinner mAccountSpinner;
        private Context mContext;
        private Button mPreviewButton;
        final UserFeedbackActivity this$0;

        private void updatePreviewButton()
        {
            mPreviewButton.setEnabled(true);
        }

        private void updateSpinner()
        {
            int k = 0;
            mAccountSpinner.setEnabled(true);
            String as[];
            String s;
            String s1;
            String as1[];
            int i;
            int j;
            int l;
            try
            {
                as = (String[])mUserfeedback.getReport().accounts.toArray(new String[0]);
            }
            catch (NullPointerException nullpointerexception)
            {
                nullpointerexception = new String[0];
            }
            as1 = new String[as.length + 1];
            as1[0] = mContext.getString(R.string.gf_anonymous);
            s = "";
            s1 = mUserfeedback.getSpec().getSelectedAccount();
            l = as.length;
            i = 0;
            j = 0;
            for (; i < l; i++)
            {
                String s2 = as[i];
                j++;
                as1[j] = s2;
                if (s2.equals(s1))
                {
                    k = j;
                    s = s1;
                }
            }

            ArrayAdapter arrayadapter = new ArrayAdapter(mContext, R.layout.gf_userfeedback_account_spinner, as1);
            arrayadapter.setDropDownViewResource(0x1090009);
            mAccountSpinner.setAdapter(arrayadapter);
            mAccountSpinner.setSelection(k);
            mUserfeedback.getReport().chosenAccount = s;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            if (!mUserfeedback.isReportReady())
            {
                mUserfeedback.blockOnReportConstruction();
            }
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            updateSpinner();
            updatePreviewButton();
        }

        protected void onPreExecute()
        {
            mPreviewButton.setEnabled(false);
            mAccountSpinner.setEnabled(false);
        }

        public UpdateActivityOnReportCollection(Context context, Spinner spinner, Button button)
        {
            this$0 = UserFeedbackActivity.this;
            super();
            mContext = context;
            mAccountSpinner = spinner;
            mPreviewButton = button;
        }
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final UserFeedbackActivity this$0;

        public void onClick(View view)
        {
            handleClick(shouldIncludeScreenshot(), shouldIncludeSystemLogs(), mFeedbackText.getText().toString());
            view = new Intent(getApplicationContext(), com/google/userfeedback/android/api/PreviewActivity);
            startActivityForResult(view, 0);
        }

        _cls1()
        {
            this$0 = UserFeedbackActivity.this;
            super();
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final UserFeedbackActivity this$0;
        final Activity val$thisActivity;

        public void onClick(View view)
        {
            view = mUserfeedback.createDialog(thisActivity, shouldIncludeScreenshot(), shouldIncludeSystemLogs(), mFeedbackText.getText().toString());
            if (view == null)
            {
                mUserfeedback.submitFeedback(shouldIncludeScreenshot(), shouldIncludeSystemLogs(), mFeedbackText.getText().toString(), false);
                setResult(-1);
                finish();
                return;
            } else
            {
                view.show();
                return;
            }
        }

        _cls2()
        {
            this$0 = UserFeedbackActivity.this;
            thisActivity = activity;
            super();
        }
    }


    private class _cls3
        implements android.widget.AdapterView.OnItemSelectedListener
    {

        final UserFeedbackActivity this$0;
        final Context val$cx;

        public void onItemSelected(AdapterView adapterview, View view, int i, long l)
        {
            adapterview = (String)mChooseAccount.getSelectedItem();
            if (!adapterview.equals(cx.getString(R.string.gf_anonymous)))
            {
                mUserfeedback.getReport().chosenAccount = adapterview;
                return;
            } else
            {
                mUserfeedback.getReport().chosenAccount = "";
                return;
            }
        }

        public void onNothingSelected(AdapterView adapterview)
        {
            mUserfeedback.getReport().chosenAccount = "";
        }

        _cls3()
        {
            this$0 = UserFeedbackActivity.this;
            cx = context;
            super();
        }
    }


    private class _cls4
        implements android.view.View.OnClickListener
    {

        final UserFeedbackActivity this$0;

        public void onClick(View view)
        {
            view = (new android.app.AlertDialog.Builder(UserFeedbackActivity.this)).setTitle(getString(R.string.gf_privacy_policy)).setMessage(getString(R.string.gf_privacy_text)).create();
            class _cls1
                implements android.content.DialogInterface.OnClickListener
            {

                final _cls4 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                }

                _cls1()
                {
                    this$1 = _cls4.this;
                    super();
                }
            }

            view.setButton("OK", new _cls1());
            view.show();
        }

        _cls4()
        {
            this$0 = UserFeedbackActivity.this;
            super();
        }
    }


    private class OnUserChoiceInputChangeListener
        implements android.widget.CompoundButton.OnCheckedChangeListener
    {

        final UserFeedbackActivity this$0;

        public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
        {
            handleClick(shouldIncludeScreenshot(), shouldIncludeSystemLogs(), mFeedbackText.getText().toString());
        }

        private OnUserChoiceInputChangeListener()
        {
            this$0 = UserFeedbackActivity.this;
            super();
        }

        OnUserChoiceInputChangeListener(_cls1 _pcls1)
        {
            this();
        }
    }


    private class _cls1FetchAppIconTask extends AsyncTask
    {

        ImageView mAppIcon;
        int mAppIconRes;
        final UserFeedbackActivity this$0;
        final Activity val$thisActivity;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            mAppIcon = (ImageView)thisActivity.findViewById(R.id.gf_app_icon);
            Object obj = UserFeedback.userFeedback().getSpec().getContext();
            avoid = ((Context) (obj)).getPackageName();
            obj = ((Context) (obj)).getPackageManager();
            mAppIconRes = R.drawable.gf_icon;
            try
            {
                mAppIconRes = ((PackageManager) (obj)).getApplicationInfo(avoid, 0).icon;
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[]) { }
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            mAppIcon.setImageResource(mAppIconRes);
        }

        _cls1FetchAppIconTask()
        {
            this$0 = UserFeedbackActivity.this;
            thisActivity = activity;
            super();
        }
    }

}
