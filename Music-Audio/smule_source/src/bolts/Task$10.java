// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bolts;

import java.util.concurrent.Executor;

// Referenced classes of package bolts:
//            Continuation, Task, CancellationToken

class ct
    implements Continuation
{

    final Task this$0;
    final Continuation val$continuation;
    final CancellationToken val$ct;
    final Executor val$executor;
    final kCompletionSource val$tcs;

    public volatile Object then(Task task)
    {
        return then(task);
    }

    public Void then(Task task)
    {
        Task.access$200(val$tcs, val$continuation, task, val$executor, val$ct);
        return null;
    }

    tionToken()
    {
        this$0 = final_task;
        val$tcs = kcompletionsource;
        val$continuation = continuation1;
        val$executor = executor1;
        val$ct = CancellationToken.this;
        super();
    }
}
