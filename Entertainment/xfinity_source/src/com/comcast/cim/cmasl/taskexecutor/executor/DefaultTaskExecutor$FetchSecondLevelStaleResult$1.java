// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.taskexecutor.executor;

import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import java.util.Set;
import java.util.concurrent.Executor;
import org.slf4j.Logger;

// Referenced classes of package com.comcast.cim.cmasl.taskexecutor.executor:
//            DefaultTaskExecutor

class val.finalResult
    implements Runnable
{

    final this._cls1 this$1;
    final Object val$finalResult;

    public void run()
    {
        if (DefaultTaskExecutor.access$500(_fld0).contains(cess._mth400(this._cls1.this)))
        {
            if (val$finalResult != null)
            {
                DefaultTaskExecutor.access$300().debug("Calling listener with second level stale result from {}", DefaultTaskExecutor.access$200(_fld0));
                cess._mth400(this._cls1.this).onStaleResultAvailable(val$finalResult);
            } else
            {
                DefaultTaskExecutor.access$300().debug("Second level stale result not available from {}", DefaultTaskExecutor.access$200(_fld0));
            }
            DefaultTaskExecutor.access$300().debug("Second level stale result fetch complete, fetching up to date result from {}", DefaultTaskExecutor.access$200(_fld0));
            cess._mth400(this._cls1.this).onPreAsynchronousExecute();
            DefaultTaskExecutor.access$600(_fld0).execute(new is._cls0(_fld0, cess._mth400(this._cls1.this), null));
        }
    }

    ()
    {
        this$1 = final_;
        val$finalResult = Object.this;
        super();
    }
}
