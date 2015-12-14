// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.parse:
//            OfflineStore

class this._cls1
    implements Continuation
{

    final then this$1;

    public Task then(Task task)
        throws Exception
    {
label0:
        {
            Task task2;
            synchronized (cess._mth000(this._cls1.this))
            {
                Iterator iterator = cess._mth100(this._cls1.this).iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    task2 = (Task)iterator.next();
                } while (!task2.isFaulted() && !task2.isCancelled());
            }
            return task2;
        }
        Task task1;
        cess._mth100(this._cls1.this).clear();
        task1 = Task.forResult((Void)null);
        task;
        JVM INSTR monitorexit ;
        return task1;
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
        this$1 = this._cls1.this;
        super();
    }
}
