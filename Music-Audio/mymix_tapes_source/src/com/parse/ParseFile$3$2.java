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
//            ParseFile, ParseFileUtils, ParseUser, ProgressCallback, 
//            ParseCommand

class this._cls1
    implements Continuation
{

    final then this$1;

    public Task then(Task task)
        throws Exception
    {
        if (!task.isFaulted())
        {
            try
            {
                ParseFileUtils.writeByteArrayToFile(getCacheFile(), data);
            }
            catch (IOException ioexception) { }
            ParseFile.access$102(_fld0, false);
        }
        return task;
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ck()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseFile$3

/* anonymous class */
    class ParseFile._cls3
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
            if (!isDirty())
            {
                tcs.trySetResult(null);
                return null;
            } else
            {
                Task.call(new ParseFile._cls3._cls5()).onSuccessTask(new ParseFile._cls3._cls4()).onSuccessTask(new ParseFile._cls3._cls3()).continueWithTask(new ParseFile._cls3._cls2()).continueWith(new ParseFile._cls3._cls1());
                return null;
            }
        }

            
            {
                this$0 = final_parsefile;
                tcs = taskcompletionsource;
                progressCallback = ProgressCallback.this;
                super();
            }

        // Unreferenced inner class com/parse/ParseFile$3$1

/* anonymous class */
        class ParseFile._cls3._cls1
            implements Continuation
        {

            final ParseFile._cls3 this$1;

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            public Void then(Task task)
                throws Exception
            {
                ParseFile.access$000(this$0).remove(tcs);
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

                    
                    {
                        this$1 = ParseFile._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/parse/ParseFile$3$3

/* anonymous class */
        class ParseFile._cls3._cls3
            implements Continuation
        {

            final ParseFile._cls3 this$1;

            public Task then(Task task)
                throws Exception
            {
                return ParseFile.access$200(this$0, (JSONObject)task.getResult(), progressCallback);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

                    
                    {
                        this$1 = ParseFile._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/parse/ParseFile$3$4

/* anonymous class */
        class ParseFile._cls3._cls4
            implements Continuation
        {

            final ParseFile._cls3 this$1;

            public Task then(Task task)
                throws Exception
            {
                return ((ParseCommand)task.getResult()).executeAsync();
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

                    
                    {
                        this$1 = ParseFile._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/parse/ParseFile$3$5

/* anonymous class */
        class ParseFile._cls3._cls5
            implements Callable
        {

            final ParseFile._cls3 this$1;
            final String val$sessionToken;

            public ParseCommand call()
                throws Exception
            {
                ParseCommand parsecommand = ParseFile.access$300(this$0, sessionToken);
                tcs.getTask().continueWith(parsecommand. new ParseFile._cls3._cls5._cls1());
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
        }


        // Unreferenced inner class com/parse/ParseFile$3$5$1

/* anonymous class */
        class ParseFile._cls3._cls5._cls1
            implements Continuation
        {

            final ParseFile._cls3._cls5 this$2;
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
        }

    }

}
