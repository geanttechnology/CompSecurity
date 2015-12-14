// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.database.Cursor;
import bolts.Continuation;
import bolts.Task;
import java.util.WeakHashMap;

// Referenced classes of package com.parse:
//            OfflineStore, ParseException, WeakValueHashMap, ParseObject

class val.object
    implements Continuation
{

    final OfflineStore this$0;
    final ParseObject val$object;

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    public String then(Task task)
        throws Exception
    {
        Cursor cursor = (Cursor)task.getResult();
        cursor.moveToFirst();
        if (cursor.isAfterLast())
        {
            throw new ParseException(120, "This object is not available in the offline cache.");
        }
        task = cursor.getString(0);
        String s = cursor.getString(1);
        synchronized (OfflineStore.access$300(OfflineStore.this))
        {
            OfflineStore.access$500(OfflineStore.this).put(val$object, Task.forResult(s));
            OfflineStore.access$400(OfflineStore.this).put(s, val$object);
        }
        return task;
        task;
        obj;
        JVM INSTR monitorexit ;
        throw task;
    }

    ()
    {
        this$0 = final_offlinestore;
        val$object = ParseObject.this;
        super();
    }
}
