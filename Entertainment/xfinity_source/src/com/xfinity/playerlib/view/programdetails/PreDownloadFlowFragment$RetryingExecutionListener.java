// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.android.view.common.ErrorDialogFactory;
import com.comcast.cim.android.view.common.errorformatter.ErrorFormatter;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.utils.provider.Provider;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

private abstract class provider extends DefaultTaskExecutionListener
{

    private final TaskExecutor provider;
    final PreDownloadFlowFragment this$0;

    public void onError(final TaskExecutionException exception)
    {
        PreDownloadFlowFragment.access$3200(PreDownloadFlowFragment.this, new Provider() {

            final PreDownloadFlowFragment.RetryingExecutionListener this$1;
            final TaskExecutionException val$exception;

            public CALDialogFragment get()
            {
                Object obj = PreDownloadFlowFragment.access$4600(this$0).formatError(exception.getCause());
                obj = PreDownloadFlowFragment.access$3100(this$0).createErrorDialogForThrowable(exception, ((com.comcast.cim.android.view.common.errorformatter.FormattedError) (obj)), new com.comcast.cim.android.view.common.CALDialogFragment.TryAgainListener() {

                    final _cls1 this$2;

                    public void tryAgain()
                    {
                        provider.execute(new PreDownloadFlowFragment.DeferWhenPausedTaskExecutionListener(this$0, _fld1, null));
                    }

            
            {
                this$2 = _cls1.this;
                super();
            }
                });
                ((CALDialogFragment) (obj)).setOnCancelListener(PreDownloadFlowFragment.access$700(this$0));
                return ((CALDialogFragment) (obj));
            }

            public volatile Object get()
            {
                return get();
            }

            
            {
                this$1 = PreDownloadFlowFragment.RetryingExecutionListener.this;
                exception = taskexecutionexception;
                super();
            }
        }, "RetryingTaskExecutionListener", false);
    }


    protected _cls1.val.exception(TaskExecutor taskexecutor)
    {
        this$0 = PreDownloadFlowFragment.this;
        super();
        provider = taskexecutor;
    }
}
