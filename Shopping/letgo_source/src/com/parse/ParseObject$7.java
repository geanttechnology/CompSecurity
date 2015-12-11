// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseObject, ParseOperationSet

class Set
    implements ct
{

    final ParseObject this$0;
    final ParseOperationSet val$operationsBeforeSave;
    final ate val$result;

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    public Void then(cu cu)
        throws Exception
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (!val$result.isComplete())
        {
            break MISSING_BLOCK_LABEL_37;
        }
        cu = val$result;
_L1:
        setState(cu);
        return null;
        cu = getState().newBuilder().apply(val$operationsBeforeSave).apply(val$result).build();
          goto _L1
        cu;
        obj;
        JVM INSTR monitorexit ;
        throw cu;
    }

    Set()
    {
        this$0 = final_parseobject;
        val$result = ate;
        val$operationsBeforeSave = ParseOperationSet.this;
        super();
    }
}
