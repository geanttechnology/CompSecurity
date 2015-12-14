// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseFile, ParseUser, ProgressCallback, ParseFileUtils, 
//            ParseCommand

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
        if (!isDirty())
        {
            val$tcs.trySetResult(null);
            return null;
        } else
        {
            Task.call(new Callable() {

                final ParseFile._cls3 this$1;
                final String val$sessionToken;

                public ParseCommand call()
                    throws Exception
                {
                    ParseCommand parsecommand = ParseFile.access$300(this$0, sessionToken);
                    tcs.getTask().continueWith(parsecommand. new Continuation() {

                        final _cls5 this$2;
                        final ParseCommand val$command;

                        public volatile Object then(Task task)
                            throws Exception
                        {
                            return then(task);
                        }

                        public Void then(Task task)
                            throws Exception
                        {
                            if (task.isCancelled())
                            {
                                command.cancel();
                            }
                            return null;
                        }

            
            {
                this$2 = final__pcls5;
                command = ParseCommand.this;
                super();
            }
                    });
                    return parsecommand;
                }

                public volatile Object call()
                    throws Exception
                {
                    return call();
                }

            
            {
                this$1 = ParseFile._cls3.this;
                sessionToken = s;
                super();
            }
            }).onSuccessTask(new Continuation() {

                final ParseFile._cls3 this$1;

                public Task then(Task task1)
                    throws Exception
                {
                    return ((ParseCommand)task1.getResult()).executeAsync();
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                this$1 = ParseFile._cls3.this;
                super();
            }
            }).onSuccessTask(new Continuation() {

                final ParseFile._cls3 this$1;

                public Task then(Task task1)
                    throws Exception
                {
                    return ParseFile.access$200(this$0, (JSONObject)task1.getResult(), progressCallback);
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                this$1 = ParseFile._cls3.this;
                super();
            }
            }).continueWithTask(new Continuation() {

                final ParseFile._cls3 this$1;

                public Task then(Task task1)
                    throws Exception
                {
                    if (!task1.isFaulted())
                    {
                        try
                        {
                            ParseFileUtils.writeByteArrayToFile(getCacheFile(), data);
                        }
                        catch (IOException ioexception) { }
                        ParseFile.access$102(this$0, false);
                    }
                    return task1;
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                this$1 = ParseFile._cls3.this;
                super();
            }
            }).continueWith(new Continuation() {

                final ParseFile._cls3 this$1;

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
                this$1 = ParseFile._cls3.this;
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
