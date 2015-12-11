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

class this._cls2
    implements com.comcast.cim.android.view.common.r._cls1._cls1
{

    final is._cls1 this$2;

    public void tryAgain()
    {
        ss._mth4700(_fld1).execute(new stener(_fld0, _fld1, null));
    }

    l.exception()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener$1

/* anonymous class */
    class PreDownloadFlowFragment.RetryingExecutionListener._cls1
        implements Provider
    {

        final PreDownloadFlowFragment.RetryingExecutionListener this$1;
        final TaskExecutionException val$exception;

        public CALDialogFragment get()
        {
            Object obj = PreDownloadFlowFragment.access$4600(this$0).formatError(exception.getCause());
            obj = PreDownloadFlowFragment.access$3100(this$0).createErrorDialogForThrowable(exception, ((com.comcast.cim.android.view.common.errorformatter.FormattedError) (obj)), new PreDownloadFlowFragment.RetryingExecutionListener._cls1._cls1());
            ((CALDialogFragment) (obj)).setOnCancelListener(PreDownloadFlowFragment.access$700(this$0));
            return ((CALDialogFragment) (obj));
        }

        public volatile Object get()
        {
            return get();
        }

            
            {
                this$1 = final_retryingexecutionlistener;
                exception = TaskExecutionException.this;
                super();
            }
    }

}
