// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.google.userfeedback.android.api:
//            UserFeedbackSpec, FeedbackConnectivityReceiver, UserFeedbackReportBuilder, UserFeedbackReport, 
//            UserFeedbackActivity, SendUserFeedbackService

public class UserFeedback
{

    private static boolean mServiceToastShown;
    private static UserFeedback sUserFeedback;
    private boolean isSilentReport;
    private String mFeedbacktext;
    private boolean mIncludeScreenshot;
    private boolean mIncludeSystemLogs;
    private UserFeedbackReport mReport;
    public UserFeedbackReportBuilder mReportBuilder;
    private AsyncTask mReportBuilderTask;
    private UserFeedbackSpec mSpec;

    public UserFeedback()
    {
        sUserFeedback = this;
        mServiceToastShown = false;
        isSilentReport = false;
    }

    private AlertDialog buildDialog(final Activity activity, final boolean includeScreenshot, final boolean includeSystemLogs, final String feedbackText, String s)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
        builder.setMessage(s).setCancelable(false).setPositiveButton(activity.getString(R.string.gf_yes), new _cls2()).setNegativeButton(activity.getString(R.string.gf_no), new _cls1());
        return builder.create();
    }

    private void configureAndSendFeedback(UserFeedbackSpec userfeedbackspec, String s, boolean flag)
    {
        mSpec = UserFeedbackSpec.defensiveCopyFrom(userfeedbackspec);
        FeedbackConnectivityReceiver.setEnabled(userfeedbackspec.getContext(), true);
        buildAndSubmitReport(s, flag);
    }

    protected static void flushBitmapsOnDestroy(Activity activity)
    {
        nullBitmapsRecursively(activity.getWindow().peekDecorView());
    }

    protected static boolean isServiceToastShown()
    {
        return mServiceToastShown;
    }

    private static void nullBitmapsRecursively(View view)
    {
        if (view instanceof ViewGroup)
        {
            view = (ViewGroup)view;
            for (int i = 0; i < view.getChildCount(); i++)
            {
                nullBitmapsRecursively(view.getChildAt(i));
            }

        } else
        if (view instanceof ImageView)
        {
            ((ImageView)view).setImageDrawable(null);
        }
    }

    protected static void serviceToastShown()
    {
        mServiceToastShown = true;
    }

    protected static UserFeedback userFeedback()
    {
        return sUserFeedback;
    }

    protected void blockOnReportConstruction()
    {
        try
        {
            mReportBuilderTask.get();
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.getMessage();
            return;
        }
        catch (ExecutionException executionexception)
        {
            executionexception.getMessage();
        }
    }

    protected void buildAndSubmitReport(final String description, final boolean sendSynchronously)
    {
        serviceToastShown();
        mReportBuilder = new UserFeedbackReportBuilder(mSpec);
        mReport = new UserFeedbackReport();
        if (isSilentReport && !TextUtils.isEmpty(mSpec.getSelectedAccount()))
        {
            mReport.chosenAccount = mSpec.getSelectedAccount();
        }
        if (sendSynchronously)
        {
            mReportBuilder.buildReportSynchronously(mReport);
            submitFeedback(false, false, description, sendSynchronously);
            return;
        } else
        {
            mReportBuilder.buildReportWithListener(mReport, new _cls3());
            return;
        }
    }

    protected void buildReport()
    {
        mReportBuilder = new UserFeedbackReportBuilder(mSpec);
        mReport = new UserFeedbackReport();
        mReportBuilderTask = mReportBuilder.buildReport(mReport);
    }

    protected void configureFeedback(UserFeedbackSpec userfeedbackspec)
    {
        mSpec = UserFeedbackSpec.defensiveCopyFrom(userfeedbackspec);
        FeedbackConnectivityReceiver.setEnabled(userfeedbackspec.getContext(), true);
        buildReport();
    }

    protected Dialog createDialog(Activity activity, boolean flag, boolean flag1, String s)
    {
        if (s.trim().length() == 0)
        {
            if (mSpec.shouldShowPopupForEmptyDescription())
            {
                return buildDialog(activity, flag, flag1, s, activity.getString(R.string.gf_should_submit_on_empty_description));
            }
        } else
        if (getReport().chosenAccount == "" && mSpec.shouldShowPopupForAnonymousSubmission())
        {
            return buildDialog(activity, flag, flag1, s, activity.getString(R.string.gf_should_submit_anonymously));
        }
        return null;
    }

    protected String getFeedbackText()
    {
        return mFeedbacktext;
    }

    protected UserFeedbackReport getReport()
    {
        return mReport;
    }

    public UserFeedbackSpec getSpec()
    {
        return mSpec;
    }

    protected boolean isReportReady()
    {
        while (isSilentReport || mReportBuilderTask.getStatus() == android.os.AsyncTask.Status.FINISHED) 
        {
            return true;
        }
        return false;
    }

    protected void setFeedbackText(String s)
    {
        mFeedbacktext = s;
        if (!isReportReady())
        {
            break MISSING_BLOCK_LABEL_20;
        }
        mReport.description = s;
        return;
        s;
        Log.e("GFEEDBACK", "Race condition made report description to throw an NPE");
        return;
    }

    protected void setIncludeScreenshot(boolean flag)
    {
        mIncludeScreenshot = flag;
    }

    protected void setIncludeSystemLogs(boolean flag)
    {
        mIncludeSystemLogs = flag;
    }

    protected void setUserInputParams(boolean flag, boolean flag1, String s)
    {
        setFeedbackText(s);
        setIncludeScreenshot(flag);
        setIncludeSystemLogs(flag1);
    }

    protected boolean shouldIncludeScreenshot()
    {
        return mIncludeScreenshot;
    }

    protected boolean shouldIncludeSystemLogs()
    {
        return mIncludeSystemLogs;
    }

    public void silentSubmitFeedback(UserFeedbackSpec userfeedbackspec, String s)
    {
        isSilentReport = true;
        configureAndSendFeedback(userfeedbackspec, s, false);
    }

    public void silentSubmitFeedbackSynchronously(UserFeedbackSpec userfeedbackspec, String s)
    {
        isSilentReport = true;
        configureAndSendFeedback(userfeedbackspec, s, true);
    }

    public void startFeedback(UserFeedbackSpec userfeedbackspec)
    {
        startFeedback(userfeedbackspec, 0);
    }

    public void startFeedback(UserFeedbackSpec userfeedbackspec, int i)
    {
        if (userfeedbackspec.getActivity() != null)
        {
            configureFeedback(userfeedbackspec);
            Intent intent = new Intent(userfeedbackspec.getActivity(), com/google/userfeedback/android/api/UserFeedbackActivity);
            userfeedbackspec.getActivity().startActivityForResult(intent, i);
        }
    }

    protected void startSendUserFeedbackIntent()
    {
        Context context = mSpec.getContext();
        context.startService(new Intent(context, com/google/userfeedback/android/api/SendUserFeedbackService));
    }

    protected void submitFeedback(boolean flag, boolean flag1, String s, boolean flag2)
    {
        setUserInputParams(flag, flag1, s);
        mReport.setReadyToSubmit(true);
        if (flag2)
        {
            startSendUserFeedbackIntent();
            return;
        } else
        {
            (new _cls1SubmitTask()).execute(new Void[0]);
            return;
        }
    }

    private class _cls2
        implements android.content.DialogInterface.OnClickListener
    {

        final UserFeedback this$0;
        final Activity val$activity;
        final String val$feedbackText;
        final boolean val$includeScreenshot;
        final boolean val$includeSystemLogs;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            submitFeedback(includeScreenshot, includeSystemLogs, feedbackText, false);
            activity.setResult(-1);
            activity.finish();
        }

        _cls2()
        {
            this$0 = UserFeedback.this;
            includeScreenshot = flag;
            includeSystemLogs = flag1;
            feedbackText = s;
            activity = activity1;
            super();
        }
    }


    private class _cls1
        implements android.content.DialogInterface.OnClickListener
    {

        final UserFeedback this$0;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            dialoginterface.cancel();
        }

        _cls1()
        {
            this$0 = UserFeedback.this;
            super();
        }
    }


    private class _cls3
        implements UserFeedbackReportBuilder.BuilderListener
    {

        final UserFeedback this$0;
        final String val$description;
        final boolean val$sendSynchronously;

        public void onComplete()
        {
            submitFeedback(false, false, description, sendSynchronously);
        }

        _cls3()
        {
            this$0 = UserFeedback.this;
            description = s;
            sendSynchronously = flag;
            super();
        }
    }


    private class _cls1SubmitTask extends AsyncTask
    {

        final UserFeedback this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            if (!isReportReady())
            {
                blockOnReportConstruction();
            }
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            startSendUserFeedbackIntent();
        }

        _cls1SubmitTask()
        {
            this$0 = UserFeedback.this;
            super();
        }
    }

}
