// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseObject, OfflineStore

class val.store
    implements Continuation
{

    final ParseObject this$0;
    final OfflineStore val$store;

    public Task then(Task task)
        throws Exception
    {
label0:
        {
            Task task1;
            synchronized (mutex)
            {
                if (!isDeleted)
                {
                    break label0;
                }
                task1 = val$store.deleteDataForObjectAsync(ParseObject.this);
            }
            return task1;
        }
        Task task2 = val$store.updateDataForObjectAsync(ParseObject.this);
        task;
        JVM INSTR monitorexit ;
        return task2;
        exception;
        task;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ()
    {
        this$0 = final_parseobject;
        val$store = OfflineStore.this;
        super();
    }
}
