// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.taskexecutor.executor;

import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import java.util.Set;
import org.slf4j.Logger;

// Referenced classes of package com.comcast.cim.cmasl.taskexecutor.executor:
//            DefaultTaskExecutor

class val.finalResult
    implements Runnable
{

    final val.finalResult this$1;
    final RuntimeException val$finalCaughtException;
    final Object val$finalResult;

    public void run()
    {
label0:
        {
            if (DefaultTaskExecutor.access$500(_fld0).remove(cess._mth800(this._cls1.this)))
            {
                DefaultTaskExecutor.access$300().debug("Up to date result fetch from {} completed", DefaultTaskExecutor.access$200(_fld0));
                if (val$finalCaughtException == null)
                {
                    break label0;
                }
                TaskExecutionListener taskexecutionlistener = cess._mth800(this._cls1.this);
                TaskExecutionException taskexecutionexception;
                if (val$finalCaughtException instanceof TaskExecutionException)
                {
                    taskexecutionexception = (TaskExecutionException)val$finalCaughtException;
                } else
                {
                    taskexecutionexception = new TaskExecutionException(val$finalCaughtException);
                }
                taskexecutionlistener.onError(taskexecutionexception);
            }
            return;
        }
        cess._mth800(this._cls1.this).onPostExecute(val$finalResult);
    }

    ()
    {
        this$1 = final_;
        val$finalCaughtException = runtimeexception;
        val$finalResult = Object.this;
        super();
    }
}
