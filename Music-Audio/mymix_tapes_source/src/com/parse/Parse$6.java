// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.concurrent.Executor;

// Referenced classes of package com.parse:
//            Parse, ParseCallback, ParseException

static final class init>
    implements Continuation
{

    final ParseCallback val$callback;
    final boolean val$reportCancellation;
    final bolts.kCompletionSource val$tcs;

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    public Void then(final Task task)
        throws Exception
    {
        if (task.isCancelled() && !val$reportCancellation)
        {
            val$tcs.setCancelled();
            return null;
        } else
        {
            Task.UI_THREAD_EXECUTOR.execute(new Runnable() {

                final Parse._cls6 this$0;
                final Task val$task;

                public void run()
                {
                    Exception exception1 = task.getError();
                    Object obj;
                    obj = exception1;
                    if (exception1 == null)
                    {
                        break MISSING_BLOCK_LABEL_32;
                    }
                    obj = exception1;
                    if (!(exception1 instanceof ParseException))
                    {
                        obj = new ParseException(exception1);
                    }
                    callback.internalDone(task.getResult(), (ParseException)obj);
                    if (task.isCancelled())
                    {
                        tcs.setCancelled();
                        return;
                    }
                    if (task.isFaulted())
                    {
                        tcs.setError(task.getError());
                        return;
                    } else
                    {
                        tcs.setResult(task.getResult());
                        return;
                    }
                    Exception exception;
                    exception;
                    if (task.isCancelled())
                    {
                        tcs.setCancelled();
                    } else
                    if (task.isFaulted())
                    {
                        tcs.setError(task.getError());
                    } else
                    {
                        tcs.setResult(task.getResult());
                    }
                    throw exception;
                }

            
            {
                this$0 = Parse._cls6.this;
                task = task1;
                super();
            }
            });
            return null;
        }
    }

    lback(boolean flag, bolts.kCompletionSource kcompletionsource, ParseCallback parsecallback)
    {
        val$reportCancellation = flag;
        val$tcs = kcompletionsource;
        val$callback = parsecallback;
        super();
    }
}
