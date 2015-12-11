// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

// Referenced classes of package com.parse:
//            OfflineStore, WeakValueHashMap, ParseObject

class val.uuidsToDelete
    implements ct
{

    final OfflineStore this$0;
    final List val$uuidsToDelete;

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    public Void then(cu cu)
        throws Exception
    {
        cu = ((cu) (OfflineStore.access$300(OfflineStore.this)));
        cu;
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
        cu;
        JVM INSTR monitorexit ;
        throw exception;
        cu;
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
