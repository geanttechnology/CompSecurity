// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.taskexecutor.listener;

import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.cmasl.taskexecutor.listener:
//            DefaultTaskExecutionListener, TaskExecutionListener

public abstract class DeferringTaskExecutionListener extends DefaultTaskExecutionListener
{

    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private final TaskExecutionListener _flddelegate;

    protected DeferringTaskExecutionListener(TaskExecutionListener taskexecutionlistener)
    {
        _flddelegate = taskexecutionlistener;
    }

    protected abstract void onDefer(Runnable runnable);

    public void onError(final TaskExecutionException exception)
    {
        if (shouldDefer())
        {
            LOG.info("Deferring onError");
            onDefer(new Runnable() {

                final DeferringTaskExecutionListener this$0;
                final TaskExecutionException val$exception;

                public void run()
                {
                    _flddelegate.onError(exception);
                }

            
            {
                this$0 = DeferringTaskExecutionListener.this;
                exception = taskexecutionexception;
                super();
            }
            });
            return;
        } else
        {
            _flddelegate.onError(exception);
            return;
        }
    }

    public void onPostExecute(final Object result)
    {
        if (shouldDefer())
        {
            LOG.info("Deferring onPostExecute");
            onDefer(new Runnable() {

                final DeferringTaskExecutionListener this$0;
                final Object val$result;

                public void run()
                {
                    _flddelegate.onPostExecute(result);
                }

            
            {
                this$0 = DeferringTaskExecutionListener.this;
                result = obj;
                super();
            }
            });
            return;
        } else
        {
            _flddelegate.onPostExecute(result);
            return;
        }
    }

    protected abstract boolean shouldDefer();

}
