// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.util.Pair;
import bolts.Continuation;
import bolts.Task;
import java.util.WeakHashMap;

// Referenced classes of package com.parse:
//            OfflineStore, ParseObject, WeakValueHashMap

class val.object
    implements Continuation
{

    final OfflineStore this$0;
    final ParseObject val$object;

    public Task then(Task task)
        throws Exception
    {
        Object obj = OfflineStore.access$300(OfflineStore.this);
        obj;
        JVM INSTR monitorenter ;
        String s = val$object.getObjectId();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        OfflineStore.access$1500(OfflineStore.this).remove(Pair.create(val$object.getClassName(), s));
        OfflineStore.access$1600(OfflineStore.this).remove(val$object);
        obj;
        JVM INSTR monitorexit ;
        return task;
        task;
        obj;
        JVM INSTR monitorexit ;
        throw task;
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ()
    {
        this$0 = final_offlinestore;
        val$object = ParseObject.this;
        super();
    }
}
