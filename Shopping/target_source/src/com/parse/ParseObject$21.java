// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseObject

class te
    implements i
{

    final ParseObject this$0;
    final te val$result;

    public j then(j j)
        throws Exception
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (!val$result.isComplete())
        {
            break MISSING_BLOCK_LABEL_37;
        }
        j = val$result;
_L1:
        setState(j);
        return null;
        j = getState().newBuilder().apply(val$result).build();
          goto _L1
        j;
        obj;
        JVM INSTR monitorexit ;
        throw j;
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    te()
    {
        this$0 = final_parseobject;
        val$result = te.this;
        super();
    }
}
