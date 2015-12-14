// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.concurrent.Executor;

// Referenced classes of package com.parse:
//            PushRouter

static final class _cls1.val.task
    implements Continuation
{

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    public Void then(final Task task)
    {
        if (task.isFaulted())
        {
            Task.UI_THREAD_EXECUTOR.execute(new Runnable() {

                final PushRouter._cls13 this$0;
                final Task val$task;

                public void run()
                {
                    throw new RuntimeException(task.getError());
                }

            
            {
                this$0 = PushRouter._cls13.this;
                task = task1;
                super();
            }
            });
        }
        return null;
    }

    _cls1.val.task()
    {
    }
}
