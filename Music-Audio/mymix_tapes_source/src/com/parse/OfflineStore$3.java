// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.database.Cursor;
import bolts.Continuation;
import bolts.Task;
import java.util.WeakHashMap;

// Referenced classes of package com.parse:
//            OfflineStore, WeakValueHashMap, ParseObject

class val.uuid
    implements Continuation
{

    final OfflineStore this$0;
    final String val$uuid;

    public ParseObject then(Task task)
        throws Exception
    {
        Object obj;
        obj = (Cursor)task.getResult();
        ((Cursor) (obj)).moveToFirst();
        if (((Cursor) (obj)).isAfterLast())
        {
            throw new IllegalStateException((new StringBuilder()).append("Attempted to find non-existent uuid ").append(val$uuid).toString());
        }
        task = ((Task) (OfflineStore.access$300(OfflineStore.this)));
        task;
        JVM INSTR monitorenter ;
        Object obj1 = (ParseObject)OfflineStore.access$400(OfflineStore.this).get(val$uuid);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        task;
        JVM INSTR monitorexit ;
        return ((ParseObject) (obj1));
        obj1 = ((Cursor) (obj)).getString(0);
        obj = ((Cursor) (obj)).getString(1);
        obj1 = ParseObject.createWithoutData(((String) (obj1)), ((String) (obj)));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        OfflineStore.access$400(OfflineStore.this).put(val$uuid, obj1);
        OfflineStore.access$500(OfflineStore.this).put(obj1, Task.forResult(val$uuid));
        task;
        JVM INSTR monitorexit ;
        return ((ParseObject) (obj1));
        Exception exception;
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

    p()
    {
        this$0 = final_offlinestore;
        val$uuid = String.this;
        super();
    }
}
