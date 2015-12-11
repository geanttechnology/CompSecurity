// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

// Referenced classes of package com.parse:
//            OfflineStore, WeakValueHashMap, ParseObject

class val.uuidsToDelete
    implements i
{

    final OfflineStore this$0;
    final List val$uuidsToDelete;

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    public Void then(j j)
        throws Exception
    {
        j = ((j) (OfflineStore.access$300(OfflineStore.this)));
        j;
        JVM INSTR monitorenter ;
        Iterator iterator = val$uuidsToDelete.iterator();
_L2:
        String s;
        ParseObject parseobject;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_92;
            }
            s = (String)iterator.next();
            parseobject = (ParseObject)OfflineStore.access$400(OfflineStore.this).get(s);
        } while (parseobject == null);
        OfflineStore.access$500(OfflineStore.this).remove(parseobject);
        OfflineStore.access$400(OfflineStore.this).remove(s);
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        j;
        JVM INSTR monitorexit ;
        throw exception;
        j;
        JVM INSTR monitorexit ;
        return null;
    }

    ()
    {
        this$0 = final_offlinestore;
        val$uuidsToDelete = List.this;
        super();
    }
}
