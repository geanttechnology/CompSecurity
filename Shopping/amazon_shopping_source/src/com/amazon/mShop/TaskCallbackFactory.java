// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import com.amazon.mShop.control.Cancellable;
import com.amazon.mShop.control.TaskCallback;
import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop:
//            AmazonProgressDialog, AmazonActivity

public class TaskCallbackFactory
{
    public class LocaleSwithchTaskCallback extends MyTaskCallback
    {

        final TaskCallbackFactory this$0;

        public void beginTask()
        {
            beginTaskProcessor(true);
        }

        public volatile void endTask()
        {
            super.endTask();
        }

        public void endTaskWithoutDismissProgDiag()
        {
            endTaskProcessor(false);
        }

        public AmazonProgressDialog getProgressDialog()
        {
            return progressDialog;
        }

        private LocaleSwithchTaskCallback(Cancellable cancellable, AmazonActivity amazonactivity, boolean flag, String s, AmazonProgressDialog amazonprogressdialog)
        {
            this$0 = TaskCallbackFactory.this;
            super(cancellable, amazonactivity, flag, s);
            setProgressDialog(amazonprogressdialog);
        }

    }

    private class MyTaskCallback
        implements TaskCallback
    {

        private final AmazonActivity amazonActivity;
        private final Cancellable cancellable;
        private final boolean finishActivityOnCancel;
        final TaskCallbackFactory this$0;
        private final String title;

        public void beginTask()
        {
            beginTaskProcessor(false);
        }

        protected void beginTaskProcessor(boolean flag)
        {
            currentTaskCallback = this;
            boolean flag1;
            if (progressDialog != null && !flag)
            {
                try
                {
                    progressDialog.dismiss();
                }
                catch (Exception exception)
                {
                    Log.e("ProgressDialog", exception.getMessage());
                }
            }
            flag1 = false;
            if (!flag || progressDialog == null)
            {
                flag1 = true;
                progressDialog = new AmazonProgressDialog(context);
            }
            if (!Util.isEmpty(title))
            {
                progressDialog.setTitle(title);
            }
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                final MyTaskCallback this$1;

                public void onCancel(DialogInterface dialoginterface)
                {
label0:
                    {
                        if (cancellable != null)
                        {
                            cancellable.cancel();
                        }
                        if (amazonActivity != null)
                        {
                            if (!finishActivityOnCancel)
                            {
                                break label0;
                            }
                            amazonActivity.finish();
                        }
                        return;
                    }
                    amazonActivity.popView();
                }

            
            {
                this$1 = MyTaskCallback.this;
                super();
            }
            });
            if (!flag1)
            {
                break MISSING_BLOCK_LABEL_140;
            }
            progressDialog.show();
            return;
            Exception exception1;
            exception1;
            Log.e("ProgressDialog", exception1.getMessage());
            return;
        }

        public void endTask()
        {
            endTaskProcessor(true);
        }

        protected void endTaskProcessor(boolean flag)
        {
            if (this == currentTaskCallback)
            {
                if (flag && progressDialog != null)
                {
                    try
                    {
                        progressDialog.dismiss();
                    }
                    catch (Exception exception)
                    {
                        Log.e("ProgressDialog", exception.getMessage());
                    }
                    progressDialog = null;
                }
                currentTaskCallback = null;
            }
        }

        protected void setProgressDialog(AmazonProgressDialog amazonprogressdialog)
        {
            if (amazonprogressdialog == null)
            {
                return;
            } else
            {
                progressDialog = amazonprogressdialog;
                return;
            }
        }




        private MyTaskCallback(Cancellable cancellable1, AmazonActivity amazonactivity, boolean flag)
        {
            this$0 = TaskCallbackFactory.this;
            super();
            cancellable = cancellable1;
            amazonActivity = amazonactivity;
            finishActivityOnCancel = flag;
            title = null;
        }

        private MyTaskCallback(Cancellable cancellable1, AmazonActivity amazonactivity, boolean flag, int i)
        {
            this$0 = TaskCallbackFactory.this;
            super();
            cancellable = cancellable1;
            amazonActivity = amazonactivity;
            finishActivityOnCancel = flag;
            title = context.getString(i);
        }



        private MyTaskCallback(Cancellable cancellable1, AmazonActivity amazonactivity, boolean flag, String s)
        {
            this$0 = TaskCallbackFactory.this;
            super();
            cancellable = cancellable1;
            amazonActivity = amazonactivity;
            finishActivityOnCancel = flag;
            title = s;
        }

    }


    private final Context context;
    private TaskCallback currentTaskCallback;
    private AmazonProgressDialog progressDialog;

    public TaskCallbackFactory(Context context1)
    {
        context = context1;
    }

    public TaskCallback getFinishTaskCallback(Cancellable cancellable, AmazonActivity amazonactivity, int i)
    {
        return new MyTaskCallback(cancellable, amazonactivity, true, i);
    }

    public TaskCallback getFinishTaskCallback(Cancellable cancellable, AmazonActivity amazonactivity, String s)
    {
        return new MyTaskCallback(cancellable, amazonactivity, true, s);
    }

    public TaskCallback getLocaleSwitchFinishTaskCallback(Cancellable cancellable, AmazonActivity amazonactivity, String s, AmazonProgressDialog amazonprogressdialog)
    {
        return new LocaleSwithchTaskCallback(cancellable, amazonactivity, true, s, amazonprogressdialog);
    }

    public TaskCallback getPopViewTaskCallback(Cancellable cancellable, AmazonActivity amazonactivity, int i)
    {
        return new MyTaskCallback(cancellable, amazonactivity, false, i);
    }

    public TaskCallback getTaskCallback(Cancellable cancellable)
    {
        return new MyTaskCallback(cancellable, null, false);
    }

    public TaskCallback getTaskCallback(Cancellable cancellable, int i)
    {
        return new MyTaskCallback(cancellable, null, false, i);
    }

    public TaskCallback getTaskCallback(Cancellable cancellable, String s)
    {
        return new MyTaskCallback(cancellable, null, false, s);
    }




/*
    static TaskCallback access$102(TaskCallbackFactory taskcallbackfactory, TaskCallback taskcallback)
    {
        taskcallbackfactory.currentTaskCallback = taskcallback;
        return taskcallback;
    }

*/



/*
    static AmazonProgressDialog access$202(TaskCallbackFactory taskcallbackfactory, AmazonProgressDialog amazonprogressdialog)
    {
        taskcallbackfactory.progressDialog = amazonprogressdialog;
        return amazonprogressdialog;
    }

*/
}
