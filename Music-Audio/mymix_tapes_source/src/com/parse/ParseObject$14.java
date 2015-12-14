// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseObject, ParseOperationSet, Parse, ParseEventuallyQueue

class et
    implements Continuation
{

    final ParseObject this$0;
    final ParseOperationSet val$operationSet;

    public Task then(Task task)
        throws Exception
    {
        return task.continueWithTask(new Continuation() {

            final ParseObject._cls14 this$1;

            public Task then(Task task1)
                throws Exception
            {
                return Parse.getEventuallyQueue().waitForOperationSetAndEventuallyPin(operationSet, null).makeVoid();
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$1 = ParseObject._cls14.this;
                super();
            }
        });
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    et()
    {
        this$0 = final_parseobject;
        val$operationSet = ParseOperationSet.this;
        super();
    }
}
