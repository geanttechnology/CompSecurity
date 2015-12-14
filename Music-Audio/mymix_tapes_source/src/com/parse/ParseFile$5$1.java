// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.Set;

// Referenced classes of package com.parse:
//            ParseFile, ParseAWSRequest, ProgressCallback, ParseException, 
//            ParseFileUtils

class this._cls1
    implements Continuation
{

    final Result this$1;

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    public Void then(Task task)
        throws Exception
    {
        ParseFile.access$000(_fld0).remove(tcs);
        if (task.isCancelled())
        {
            tcs.trySetCancelled();
        } else
        if (task.isFaulted())
        {
            tcs.trySetError(task.getError());
        } else
        {
            tcs.trySetResult(task.getResult());
        }
        return null;
    }

    ck()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseFile$5

/* anonymous class */
    class ParseFile._cls5
        implements Continuation
    {

        final ParseFile this$0;
        final ProgressCallback val$progressCallback;
        final bolts.Task.TaskCompletionSource val$tcs;

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

        public Void then(Task task)
            throws Exception
        {
            task = (byte[])task.getResult();
            if (task != null)
            {
                tcs.trySetResult(task);
                return null;
            } else
            {
                (new ParseAWSRequest(ParseFile.access$400(ParseFile.this))).executeAsync(progressCallback).continueWithTask(new ParseFile._cls5._cls2()).continueWith(new ParseFile._cls5._cls1());
                return null;
            }
        }

            
            {
                this$0 = final_parsefile;
                tcs = taskcompletionsource;
                progressCallback = ProgressCallback.this;
                super();
            }

        // Unreferenced inner class com/parse/ParseFile$5$2

/* anonymous class */
        class ParseFile._cls5._cls2
            implements Continuation
        {

            final ParseFile._cls5 this$1;

            public Task then(Task task)
                throws Exception
            {
                Task task1;
                if (task.isFaulted() && (task.getError() instanceof IllegalStateException))
                {
                    task1 = Task.forError(new ParseException(100, task.getError().getMessage()));
                } else
                {
                    if (tcs.getTask().isCancelled())
                    {
                        return tcs.getTask();
                    }
                    data = (byte[])task.getResult();
                    task1 = task;
                    if (data != null)
                    {
                        ParseFileUtils.writeByteArrayToFile(getCacheFile(), data);
                        return task;
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
                        this$1 = ParseFile._cls5.this;
                        super();
                    }
        }

    }

}
