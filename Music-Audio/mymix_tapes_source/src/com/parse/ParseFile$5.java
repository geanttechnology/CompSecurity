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

class >
    implements Continuation
{

    final ParseFile this$0;
    final ProgressCallback val$progressCallback;
    final bolts.pletionSource val$tcs;

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
            val$tcs.trySetResult(task);
            return null;
        } else
        {
            (new ParseAWSRequest(ParseFile.access$400(ParseFile.this))).executeAsync(val$progressCallback).continueWithTask(new Continuation() {

                final ParseFile._cls5 this$1;

                public Task then(Task task1)
                    throws Exception
                {
                    Task task2;
                    if (task1.isFaulted() && (task1.getError() instanceof IllegalStateException))
                    {
                        task2 = Task.forError(new ParseException(100, task1.getError().getMessage()));
                    } else
                    {
                        if (tcs.getTask().isCancelled())
                        {
                            return tcs.getTask();
                        }
                        data = (byte[])task1.getResult();
                        task2 = task1;
                        if (data != null)
                        {
                            ParseFileUtils.writeByteArrayToFile(getCacheFile(), data);
                            return task1;
                        }
                    }
                    return task2;
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                this$1 = ParseFile._cls5.this;
                super();
            }
            }).continueWith(new Continuation() {

                final ParseFile._cls5 this$1;

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

                public Void then(Task task1)
                    throws Exception
                {
                    ParseFile.access$000(this$0).remove(tcs);
                    if (task1.isCancelled())
                    {
                        tcs.trySetCancelled();
                    } else
                    if (task1.isFaulted())
                    {
                        tcs.trySetError(task1.getError());
                    } else
                    {
                        tcs.trySetResult(task1.getResult());
                    }
                    return null;
                }

            
            {
                this$1 = ParseFile._cls5.this;
                super();
            }
            });
            return null;
        }
    }

    back()
    {
        this$0 = final_parsefile;
        val$tcs = pletionsource;
        val$progressCallback = ProgressCallback.this;
        super();
    }
}
