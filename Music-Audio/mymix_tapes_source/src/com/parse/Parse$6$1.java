// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.concurrent.Executor;

// Referenced classes of package com.parse:
//            ParseException, ParseCallback, Parse

class it>
    implements Runnable
{

    final  this$0;
    final Task val$task;

    public void run()
    {
        Exception exception1 = val$task.getError();
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
        callback.internalDone(val$task.getResult(), (ParseException)obj);
        if (val$task.isCancelled())
        {
            tcs.setCancelled();
            return;
        }
        if (val$task.isFaulted())
        {
            tcs.setError(val$task.getError());
            return;
        } else
        {
            tcs.setResult(val$task.getResult());
            return;
        }
        Exception exception;
        exception;
        if (val$task.isCancelled())
        {
            tcs.setCancelled();
        } else
        if (val$task.isFaulted())
        {
            tcs.setError(val$task.getError());
        } else
        {
            tcs.setResult(val$task.getResult());
        }
        throw exception;
    }

    it>()
    {
        this$0 = final_it>;
        val$task = Task.this;
        super();
    }

    // Unreferenced inner class com/parse/Parse$6

/* anonymous class */
    static final class Parse._cls6
        implements Continuation
    {

        final ParseCallback val$callback;
        final boolean val$reportCancellation;
        final bolts.Task.TaskCompletionSource val$tcs;

        public volatile Object then(Task task1)
            throws Exception
        {
            return then(task1);
        }

        public Void then(Task task1)
            throws Exception
        {
            if (task1.isCancelled() && !reportCancellation)
            {
                tcs.setCancelled();
                return null;
            } else
            {
                Task.UI_THREAD_EXECUTOR.execute(task1. new Parse._cls6._cls1());
                return null;
            }
        }

            
            {
                reportCancellation = flag;
                tcs = taskcompletionsource;
                callback = parsecallback;
                super();
            }
    }

}
