// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Capture;
import bolts.Continuation;
import bolts.Task;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseOperationSet, ParseObject

class this._cls1
    implements Continuation
{

    final then this$1;

    public Task then(final Task saveTask)
        throws Exception
    {
        JSONObject jsonobject = (JSONObject)saveTask.getResult();
        return handleSaveResultAsync(jsonobject, (ParseOperationSet)operations.get()).continueWithTask(new Continuation() {

            final ParseObject._cls10._cls1 this$2;
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
                this$2 = ParseObject._cls10._cls1.this;
                saveTask = task;
                super();
            }
        });
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    l.sessionToken()
    {
        this$1 = this._cls1.this;
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

}
