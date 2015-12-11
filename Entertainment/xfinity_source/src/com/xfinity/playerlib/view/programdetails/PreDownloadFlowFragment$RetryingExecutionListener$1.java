// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.android.view.common.ErrorDialogFactory;
import com.comcast.cim.android.view.common.errorformatter.ErrorFormatter;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.utils.provider.Provider;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

class val.exception
    implements Provider
{

    final get this$1;
    final TaskExecutionException val$exception;

    public CALDialogFragment get()
    {
        Object obj = PreDownloadFlowFragment.access$4600(_fld0).formatError(val$exception.getCause());
        obj = PreDownloadFlowFragment.access$3100(_fld0).createErrorDialogForThrowable(val$exception, ((com.comcast.cim.android.view.common.errorformatter.FormattedError) (obj)), new com.comcast.cim.android.view.common.CALDialogFragment.TryAgainListener() {

            final PreDownloadFlowFragment.RetryingExecutionListener._cls1 this$2;

            public void tryAgain()
            {
                PreDownloadFlowFragment.RetryingExecutionListener.access$4700(this$1).execute(new PreDownloadFlowFragment.DeferWhenPausedTaskExecutionListener(this$0, this$1, null));
            }

            
            {
                this$2 = PreDownloadFlowFragment.RetryingExecutionListener._cls1.this;
                super();
            }
        });
        ((CALDialogFragment) (obj)).setOnCancelListener(PreDownloadFlowFragment.access$700(_fld0));
        return ((CALDialogFragment) (obj));
    }

    public volatile Object get()
    {
        return get();
    }

    _cls1.this._cls2()
    {
        this$1 = final__pcls2;
        val$exception = TaskExecutionException.this;
        super();
    }
}
