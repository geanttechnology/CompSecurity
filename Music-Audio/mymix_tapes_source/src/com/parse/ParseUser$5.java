// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseUser, ParseOperationSet, ParseCommand

class >
    implements Continuation
{

    final ParseUser this$0;
    final String val$sessionToken;

    public Task then(final Task operations)
        throws Exception
    {
        operations = (ParseOperationSet)operations.getResult();
        ParseCommand parsecommand = ParseUser.access$300(ParseUser.this, operations, val$sessionToken);
        if (parsecommand == null)
        {
            return Task.forResult(null);
        } else
        {
            return parsecommand.executeAsync().continueWithTask(new Continuation() {

                final ParseUser._cls5 this$1;
                final ParseOperationSet val$operations;

                public Task then(Task task)
                    throws Exception
                {
                    return handleSaveResultAsync((JSONObject)task.getResult(), operations).continueWithTask(task. new Continuation() {

                        final _cls1 this$2;
                        final Task val$signUpTask;

                        public Task then(Task task)
                            throws Exception
                        {
                            if (!signUpTask.isCancelled() && !signUpTask.isFaulted())
                            {
                                synchronized (mutex)
                                {
                                    ParseUser.access$402(this$0, true);
                                    ParseUser.access$502(this$0, false);
                                }
                                return ParseUser.access$100(this$0).makeVoid();
                            } else
                            {
                                return signUpTask.makeVoid();
                            }
                            exception;
                            task;
                            JVM INSTR monitorexit ;
                            throw exception;
                        }

                        public volatile Object then(Task task)
                            throws Exception
                        {
                            return then(task);
                        }

            
            {
                this$2 = final__pcls1;
                signUpTask = Task.this;
                super();
            }
                    });
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$1 = ParseUser._cls5.this;
                operations = parseoperationset;
                super();
            }
            });
        }
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    >()
    {
        this$0 = final_parseuser;
        val$sessionToken = String.this;
        super();
    }
}
