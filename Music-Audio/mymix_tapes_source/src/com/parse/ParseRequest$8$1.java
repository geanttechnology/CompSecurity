// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.http.client.methods.HttpUriRequest;

// Referenced classes of package com.parse:
//            ParseRequest, ParseException, Parse, ProgressCallback

class urce
    implements Runnable
{

    final _cls1.then this$1;
    final bolts.onSource val$retryTask;

    public void run()
    {
        ParseRequest.access$300(_fld0, attemptsMade + 1, delay * 2L, progressCallback).continueWithTask(new Continuation() {

            final ParseRequest._cls8._cls1 this$2;

            public Task then(Task task)
                throws Exception
            {
                if (task.isCancelled())
                {
                    retryTask.setCancelled();
                } else
                if (task.isFaulted())
                {
                    retryTask.setError(task.getError());
                } else
                {
                    retryTask.setResult(task.getResult());
                }
                return null;
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$2 = ParseRequest._cls8._cls1.this;
                super();
            }
        });
    }

    urce()
    {
        this$1 = final_urce;
        val$retryTask = bolts.onSource.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseRequest$8

/* anonymous class */
    class ParseRequest._cls8
        implements Continuation
    {

        final ParseRequest this$0;
        final int val$attemptsMade;
        final long val$delay;
        final ProgressCallback val$progressCallback;

        public Task then(Task task)
            throws Exception
        {
            Task task1 = task;
            if (task.isFaulted())
            {
                task1 = task;
                if (task.getError() instanceof ParseException)
                {
                    if (((bolts.Task.TaskCompletionSource)ParseRequest.access$400(ParseRequest.this).get()).getTask().isCancelled())
                    {
                        task1 = Task.cancelled();
                    } else
                    {
                        if (attemptsMade < maxRetries)
                        {
                            Parse.logI("com.parse.ParseRequest", (new StringBuilder()).append("Request failed. Waiting ").append(delay).append(" milliseconds before attempt #").append(attemptsMade + 1).toString());
                            task = Task.create();
                            Parse.getScheduledExecutor().schedule(task. new ParseRequest._cls8._cls1(), delay, TimeUnit.MILLISECONDS);
                            return task.getTask();
                        }
                        task1 = task;
                        if (!ParseRequest.access$000(ParseRequest.this).isAborted())
                        {
                            Parse.logI("com.parse.ParseRequest", "Request failed. Giving up.");
                            return task;
                        }
                    }
                }
            }
            return task1;
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$0 = final_parserequest;
                attemptsMade = i;
                delay = l;
                progressCallback = ProgressCallback.this;
                super();
            }
    }

}
