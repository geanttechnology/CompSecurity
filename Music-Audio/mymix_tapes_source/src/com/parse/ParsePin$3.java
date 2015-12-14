// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.List;

// Referenced classes of package com.parse:
//            ParsePin, OfflineStore

static final class t>
    implements Continuation
{

    final List val$objects;

    public Task then(Task task)
        throws Exception
    {
        task = (ParsePin)task.getResult();
        OfflineStore offlinestore = OfflineStore.getCurrent();
        List list = task.getObjects();
        if (list == null)
        {
            return Task.forResult(null);
        }
        list.removeAll(val$objects);
        if (list.size() == 0)
        {
            return offlinestore.unpinAsync(task);
        } else
        {
            task.setObjects(list);
            return offlinestore.saveLocallyAsync(task, true);
        }
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    e(List list)
    {
        val$objects = list;
        super();
    }
}
