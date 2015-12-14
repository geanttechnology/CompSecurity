// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseUser, ParseOperationSet, ParseCommand

class val.signUpTask
    implements Continuation
{

    final then this$2;
    final Task val$signUpTask;

    public Task then(Task task)
        throws Exception
    {
        if (!val$signUpTask.isCancelled() && !val$signUpTask.isFaulted())
        {
            synchronized (mutex)
            {
                ParseUser.access$402(_fld0, true);
                ParseUser.access$502(_fld0, false);
            }
            return ParseUser.access$100(_fld0).makeVoid();
        } else
        {
            return val$signUpTask.makeVoid();
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

    sessionToken()
    {
        this$2 = final_sessiontoken;
        val$signUpTask = Task.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseUser$5

/* anonymous class */
    class ParseUser._cls5
        implements Continuation
    {

        final ParseUser this$0;
        final String val$sessionToken;

        public Task then(Task task)
            throws Exception
        {
            task = (ParseOperationSet)task.getResult();
            ParseCommand parsecommand = ParseUser.access$300(ParseUser.this, task, sessionToken);
            if (parsecommand == null)
            {
                return Task.forResult(null);
            } else
            {
                return parsecommand.executeAsync().continueWithTask(task. new ParseUser._cls5._cls1());
            }
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$0 = final_parseuser;
                sessionToken = String.this;
                super();
            }
    }


    // Unreferenced inner class com/parse/ParseUser$5$1

/* anonymous class */
    class ParseUser._cls5._cls1
        implements Continuation
    {

        final ParseUser._cls5 this$1;
        final ParseOperationSet val$operations;

        public Task then(Task task)
            throws Exception
        {
            return handleSaveResultAsync((JSONObject)task.getResult(), operations).continueWithTask(task. new ParseUser._cls5._cls1._cls1());
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$1 = final__pcls5;
                operations = ParseOperationSet.this;
                super();
            }
    }

}
