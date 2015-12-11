// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.model.provider;

import android.app.Activity;
import android.content.Context;
import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.android.view.common.ErrorDialogFactory;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;

public abstract class RetryingTaskExecutionListener extends DefaultTaskExecutionListener
{

    private android.content.DialogInterface.OnCancelListener cancelListener;
    private final Context context;
    private final ErrorDialogFactory errorDialogFactory;
    private final TaskExecutor provider;

    protected RetryingTaskExecutionListener(TaskExecutor taskexecutor, Context context1, ErrorDialogFactory errordialogfactory)
    {
        provider = taskexecutor;
        context = context1;
        errorDialogFactory = errordialogfactory;
    }

    protected RetryingTaskExecutionListener(TaskExecutor taskexecutor, Context context1, ErrorDialogFactory errordialogfactory, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        this(taskexecutor, context1, errordialogfactory);
        cancelListener = oncancellistener;
    }

    public void onError(TaskExecutionException taskexecutionexception)
    {
        taskexecutionexception = errorDialogFactory.createErrorDialogForThrowable(taskexecutionexception, new com.comcast.cim.android.view.common.CALDialogFragment.TryAgainListener() {

            final RetryingTaskExecutionListener this$0;

            public void tryAgain()
            {
                provider.execute(RetryingTaskExecutionListener.this);
            }

            
            {
                this$0 = RetryingTaskExecutionListener.this;
                super();
            }
        });
        taskexecutionexception.setOnCancelListener(cancelListener);
        taskexecutionexception.show(((Activity)context).getFragmentManager(), "caldialogfragment");
    }

}
