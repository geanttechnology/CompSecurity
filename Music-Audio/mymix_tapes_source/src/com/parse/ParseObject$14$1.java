// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            Parse, ParseEventuallyQueue, ParseObject, ParseOperationSet

class this._cls1
    implements Continuation
{

    final then this$1;

    public Task then(Task task)
        throws Exception
    {
        return Parse.getEventuallyQueue().waitForOperationSetAndEventuallyPin(operationSet, null).makeVoid();
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseObject$14

/* anonymous class */
    class ParseObject._cls14
        implements Continuation
    {

        final ParseObject this$0;
        final ParseOperationSet val$operationSet;

        public Task then(Task task)
            throws Exception
        {
            return task.continueWithTask(new ParseObject._cls14._cls1());
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$0 = final_parseobject;
                operationSet = ParseOperationSet.this;
                super();
            }
    }

}
