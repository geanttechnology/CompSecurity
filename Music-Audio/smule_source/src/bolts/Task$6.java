// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bolts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package bolts:
//            Continuation, Task

final class ect
    implements Continuation
{

    final Collection val$tasks;

    public volatile Object then(Task task)
    {
        return then(task);
    }

    public List then(Task task)
    {
        if (val$tasks.size() == 0)
        {
            return Collections.emptyList();
        }
        task = new ArrayList();
        for (Iterator iterator = val$tasks.iterator(); iterator.hasNext(); task.add(((Task)iterator.next()).getResult())) { }
        return task;
    }

    lection()
    {
        val$tasks = collection;
        super();
    }
}
