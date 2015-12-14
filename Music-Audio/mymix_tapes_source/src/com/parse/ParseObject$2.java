// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseObject

static final class val.fullTask
    implements Continuation
{

    final List val$childTasks;
    final Task val$fullTask;

    public Task then(Task task)
        throws Exception
    {
        val$childTasks.add(task);
        return val$fullTask;
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    (List list, Task task)
    {
        val$childTasks = list;
        val$fullTask = task;
        super();
    }
}
