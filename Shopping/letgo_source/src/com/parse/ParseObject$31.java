// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseObject, OfflineStore

class val.store
    implements ct
{

    final ParseObject this$0;
    final OfflineStore val$store;

    public cu then(cu cu)
        throws Exception
    {
label0:
        {
            cu cu1;
            synchronized (mutex)
            {
                if (!isDeleted)
                {
                    break label0;
                }
                val$store.unregisterObject(ParseObject.this);
                cu1 = val$store.deleteDataForObjectAsync(ParseObject.this);
            }
            return cu1;
        }
        cu cu2 = val$store.updateDataForObjectAsync(ParseObject.this);
        cu;
        JVM INSTR monitorexit ;
        return cu2;
        exception;
        cu;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    ()
    {
        this$0 = final_parseobject;
        val$store = OfflineStore.this;
        super();
    }
}
