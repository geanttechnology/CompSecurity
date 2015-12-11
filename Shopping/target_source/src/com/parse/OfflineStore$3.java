// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import android.database.Cursor;
import java.util.WeakHashMap;

// Referenced classes of package com.parse:
//            OfflineStore, WeakValueHashMap, ParseObject

class val.uuid
    implements i
{

    final OfflineStore this$0;
    final String val$uuid;

    public ParseObject then(j j1)
        throws Exception
    {
        Object obj;
        obj = (Cursor)j1.e();
        ((Cursor) (obj)).moveToFirst();
        if (((Cursor) (obj)).isAfterLast())
        {
            ((Cursor) (obj)).close();
            throw new IllegalStateException((new StringBuilder()).append("Attempted to find non-existent uuid ").append(val$uuid).toString());
        }
        j1 = ((j) (OfflineStore.access$300(OfflineStore.this)));
        j1;
        JVM INSTR monitorenter ;
        Object obj1 = (ParseObject)OfflineStore.access$400(OfflineStore.this).get(val$uuid);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        j1;
        JVM INSTR monitorexit ;
        return ((ParseObject) (obj1));
        String s = ((Cursor) (obj)).getString(0);
        obj1 = ((Cursor) (obj)).getString(1);
        ((Cursor) (obj)).close();
        obj = ParseObject.createWithoutData(s, ((String) (obj1)));
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_164;
        }
        OfflineStore.access$400(OfflineStore.this).put(val$uuid, obj);
        OfflineStore.access$500(OfflineStore.this).put(obj, j.a(val$uuid));
        j1;
        JVM INSTR monitorexit ;
        return ((ParseObject) (obj));
        Exception exception;
        exception;
        j1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    p()
    {
        this$0 = final_offlinestore;
        val$uuid = String.this;
        super();
    }
}
