// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            TaskQueue

static final class >
    implements Continuation
{

    final Task val$toAwait;

    public Task then(final Task task)
        throws Exception
    {
        return val$toAwait.continueWithTask(new Continuation() {

            final TaskQueue._cls2 this$0;
            final Task val$task;

            public Task then(Task task1)
                throws Exception
            {
                return task;
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = TaskQueue._cls2.this;
                task = task1;
                super();
            }
        });
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    >(Task task)
    {
        val$toAwait = task;
        super();
    }
}
