// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.cs;
import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseCommandCache

class val.finished
    implements ct
{

    final ParseCommandCache this$0;
    final cs val$finished;

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    public Void then(cu cu)
        throws Exception
    {
        val$finished.a(Boolean.valueOf(true));
        synchronized (ParseCommandCache.access$100())
        {
            ParseCommandCache.access$100().notifyAll();
        }
        return null;
        exception;
        cu;
        JVM INSTR monitorexit ;
        throw exception;
    }

    ()
    {
        this$0 = final_parsecommandcache;
        val$finished = cs.this;
        super();
    }
}
