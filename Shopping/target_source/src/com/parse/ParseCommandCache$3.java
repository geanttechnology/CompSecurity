// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.h;
import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseCommandCache

class val.finished
    implements i
{

    final ParseCommandCache this$0;
    final h val$finished;

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    public Void then(j j)
        throws Exception
    {
        val$finished.a(Boolean.valueOf(true));
        synchronized (ParseCommandCache.access$100())
        {
            ParseCommandCache.access$100().notifyAll();
        }
        return null;
        exception;
        j;
        JVM INSTR monitorexit ;
        throw exception;
    }

    ()
    {
        this$0 = final_parsecommandcache;
        val$finished = h.this;
        super();
    }
}
