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

class val.saveTask
    implements Continuation
{

    final then this$2;
    final Task val$saveTask;

    public Task then(Task task)
        throws Exception
    {
        return val$saveTask.makeVoid();
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    sessionToken()
    {
        this$2 = final_sessiontoken;
        val$saveTask = Task.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseObject$10

/* anonymous class */
    class ParseObject._cls10
        implements Continuation
    {

        final ParseObject this$0;
        final Capture val$operations;
        final String val$sessionToken;

        public Task then(Task task)
            throws Exception
        {
            return saveAsync((ParseOperationSet)operations.get(), sessionToken).continueWithTask(new ParseObject._cls10._cls1());
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$0 = final_parseobject;
                operations = capture;
                sessionToken = String.this;
                super();
            }
    }


    // Unreferenced inner class com/parse/ParseObject$10$1

/* anonymous class */
    class ParseObject._cls10._cls1
        implements Continuation
    {

        final ParseObject._cls10 this$1;

        public Task then(Task task)
            throws Exception
        {
            JSONObject jsonobject = (JSONObject)task.getResult();
            return handleSaveResultAsync(jsonobject, (ParseOperationSet)operations.get()).continueWithTask(task. new ParseObject._cls10._cls1._cls1());
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$1 = ParseObject._cls10.this;
                super();
            }
    }

}
