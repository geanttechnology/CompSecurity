// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Capture;
import bolts.Continuation;
import bolts.Task;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseObject, ParseOperationSet

class val.sessionToken
    implements Continuation
{

    final ParseObject this$0;
    final Capture val$operations;
    final String val$sessionToken;

    public Task then(Task task)
        throws Exception
    {
        return saveAsync((ParseOperationSet)val$operations.get(), val$sessionToken).continueWithTask(new Continuation() {

            final ParseObject._cls10 this$1;

            public Task then(Task task1)
                throws Exception
            {
                JSONObject jsonobject = (JSONObject)task1.getResult();
                return handleSaveResultAsync(jsonobject, (ParseOperationSet)operations.get()).continueWithTask(task1. new Continuation() {

                    final _cls1 this$2;
                    final Task val$saveTask;

                    public Task then(Task task)
                        throws Exception
                    {
                        return saveTask.makeVoid();
                    }

                    public volatile Object then(Task task)
                        throws Exception
                    {
                        return then(task);
                    }

            
            {
                this$2 = final__pcls1;
                saveTask = Task.this;
                super();
            }
                });
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$1 = ParseObject._cls10.this;
                super();
            }
        });
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    _cls1.this._cls1()
    {
        this$0 = final_parseobject;
        val$operations = capture;
        val$sessionToken = String.this;
        super();
    }
}
