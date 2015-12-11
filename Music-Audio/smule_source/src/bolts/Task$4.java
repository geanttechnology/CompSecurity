// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bolts;

import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package bolts:
//            Continuation, Task

final class ect
    implements Continuation
{

    final skCompletionSource val$firstCompleted;
    final AtomicBoolean val$isAnyTaskComplete;

    public volatile Object then(Task task)
    {
        return then(task);
    }

    public Void then(Task task)
    {
        if (val$isAnyTaskComplete.compareAndSet(false, true))
        {
            val$firstCompleted.setResult(task);
        }
        return null;
    }

    ource()
    {
        val$isAnyTaskComplete = atomicboolean;
        val$firstCompleted = skcompletionsource;
        super();
    }
}
