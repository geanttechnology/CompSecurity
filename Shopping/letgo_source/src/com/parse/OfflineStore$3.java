// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.database.Cursor;
import android.support.v7.ct;
import android.support.v7.cu;
import java.util.WeakHashMap;

// Referenced classes of package com.parse:
//            OfflineStore, WeakValueHashMap, ParseObject

class val.uuid
    implements ct
{

    final OfflineStore this$0;
    final String val$uuid;

    public ParseObject then(cu cu1)
        throws Exception
    {
        Object obj;
        obj = (Cursor)cu1.e();
        ((Cursor) (obj)).moveToFirst();
        if (((Cursor) (obj)).isAfterLast())
        {
            ((Cursor) (obj)).close();
            throw new IllegalStateException((new StringBuilder()).append("Attempted to find non-existent uuid ").append(val$uuid).toString());
        }
        cu1 = ((cu) (OfflineStore.access$300(OfflineStore.this)));
        cu1;
        JVM INSTR monitorenter ;
        Object obj1 = (ParseObject)OfflineStore.access$400(OfflineStore.this).get(val$uuid);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        cu1;
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
        OfflineStore.access$500(OfflineStore.this).put(obj, cu.a(val$uuid));
        cu1;
        JVM INSTR monitorexit ;
        return ((ParseObject) (obj));
        Exception exception;
        exception;
        cu1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    p()
    {
        this$0 = final_offlinestore;
        val$uuid = String.this;
        super();
    }
}
