// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseObject, OfflineStore

class val.store
    implements i
{

    final ParseObject this$0;
    final OfflineStore val$store;

    public j then(j j)
        throws Exception
    {
label0:
        {
            j j1;
            synchronized (mutex)
            {
                if (!isDeleted)
                {
                    break label0;
                }
                val$store.unregisterObject(ParseObject.this);
                j1 = val$store.deleteDataForObjectAsync(ParseObject.this);
            }
            return j1;
        }
        j j2 = val$store.updateDataForObjectAsync(ParseObject.this);
        j;
        JVM INSTR monitorexit ;
        return j2;
        exception;
        j;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    ()
    {
        this$0 = final_parseobject;
        val$store = OfflineStore.this;
        super();
    }
}
