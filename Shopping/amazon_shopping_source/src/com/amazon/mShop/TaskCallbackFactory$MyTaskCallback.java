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
//            TaskCallbackFactory, AmazonProgressDialog, AmazonActivity

private class <init>
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
        TaskCallbackFactory.access$102(TaskCallbackFactory.this, this);
        boolean flag1;
        if (TaskCallbackFactory.access$200(TaskCallbackFactory.this) != null && !flag)
        {
            try
            {
                TaskCallbackFactory.access$200(TaskCallbackFactory.this).dismiss();
            }
            catch (Exception exception)
            {
                Log.e("ProgressDialog", exception.getMessage());
            }
        }
        flag1 = false;
        if (!flag || TaskCallbackFactory.access$200(TaskCallbackFactory.this) == null)
        {
            flag1 = true;
            TaskCallbackFactory.access$202(TaskCallbackFactory.this, new AmazonProgressDialog(TaskCallbackFactory.access$000(TaskCallbackFactory.this)));
        }
        if (!Util.isEmpty(title))
        {
            TaskCallbackFactory.access$200(TaskCallbackFactory.this).setTitle(title);
        }
        TaskCallbackFactory.access$200(TaskCallbackFactory.this).setCanceledOnTouchOutside(false);
        TaskCallbackFactory.access$200(TaskCallbackFactory.this).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final TaskCallbackFactory.MyTaskCallback this$1;

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
                this$1 = TaskCallbackFactory.MyTaskCallback.this;
                super();
            }
        });
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        TaskCallbackFactory.access$200(TaskCallbackFactory.this).show();
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
        if (this == TaskCallbackFactory.access$100(TaskCallbackFactory.this))
        {
            if (flag && TaskCallbackFactory.access$200(TaskCallbackFactory.this) != null)
            {
                try
                {
                    TaskCallbackFactory.access$200(TaskCallbackFactory.this).dismiss();
                }
                catch (Exception exception)
                {
                    Log.e("ProgressDialog", exception.getMessage());
                }
                TaskCallbackFactory.access$202(TaskCallbackFactory.this, null);
            }
            TaskCallbackFactory.access$102(TaskCallbackFactory.this, null);
        }
    }

    protected void setProgressDialog(AmazonProgressDialog amazonprogressdialog)
    {
        if (amazonprogressdialog == null)
        {
            return;
        } else
        {
            TaskCallbackFactory.access$202(TaskCallbackFactory.this, amazonprogressdialog);
            return;
        }
    }




    private _cls1.this._cls1(Cancellable cancellable1, AmazonActivity amazonactivity, boolean flag)
    {
        this$0 = TaskCallbackFactory.this;
        super();
        cancellable = cancellable1;
        amazonActivity = amazonactivity;
        finishActivityOnCancel = flag;
        title = null;
    }

    private title(Cancellable cancellable1, AmazonActivity amazonactivity, boolean flag, int i)
    {
        this$0 = TaskCallbackFactory.this;
        super();
        cancellable = cancellable1;
        amazonActivity = amazonactivity;
        finishActivityOnCancel = flag;
        title = TaskCallbackFactory.access$000(TaskCallbackFactory.this).getString(i);
    }

    title(Cancellable cancellable1, AmazonActivity amazonactivity, boolean flag, int i, title title1)
    {
        this(cancellable1, amazonactivity, flag, i);
    }

    <init>(Cancellable cancellable1, AmazonActivity amazonactivity, boolean flag, <init> <init>1)
    {
        this(cancellable1, amazonactivity, flag);
    }

    private <init>(Cancellable cancellable1, AmazonActivity amazonactivity, boolean flag, String s)
    {
        this$0 = TaskCallbackFactory.this;
        super();
        cancellable = cancellable1;
        amazonActivity = amazonactivity;
        finishActivityOnCancel = flag;
        title = s;
    }

    title(Cancellable cancellable1, AmazonActivity amazonactivity, boolean flag, String s, title title1)
    {
        this(cancellable1, amazonactivity, flag, s);
    }
}
