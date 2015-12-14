// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            TaskQueue

class val.task
    implements Continuation
{

    final then this$0;
    final Task val$task;

    public Task then(Task task1)
        throws Exception
    {
        return val$task;
    }

    public volatile Object then(Task task1)
        throws Exception
    {
        return then(task1);
    }

    l.toAwait()
    {
        this$0 = final_toawait;
        val$task = Task.this;
        super();
    }

    // Unreferenced inner class com/parse/TaskQueue$2

/* anonymous class */
    static final class TaskQueue._cls2
        implements Continuation
    {

        final Task val$toAwait;

        public Task then(Task task1)
            throws Exception
        {
            return toAwait.continueWithTask(task1. new TaskQueue._cls2._cls1());
        }

        public volatile Object then(Task task1)
            throws Exception
        {
            return then(task1);
        }

            
            {
                toAwait = task1;
                super();
            }
    }

}
