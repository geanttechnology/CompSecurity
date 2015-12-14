// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.concurrent.Executor;

// Referenced classes of package com.parse:
//            PushRouter

class val.task
    implements Runnable
{

    final val.task this$0;
    final Task val$task;

    public void run()
    {
        throw new RuntimeException(val$task.getError());
    }

    tor()
    {
        this$0 = final_tor;
        val$task = Task.this;
        super();
    }

    // Unreferenced inner class com/parse/PushRouter$13

/* anonymous class */
    static final class PushRouter._cls13
        implements Continuation
    {

        public volatile Object then(Task task1)
            throws Exception
        {
            return then(task1);
        }

        public Void then(Task task1)
        {
            if (task1.isFaulted())
            {
                Task.UI_THREAD_EXECUTOR.execute(task1. new PushRouter._cls13._cls1());
            }
            return null;
        }

    }

}
