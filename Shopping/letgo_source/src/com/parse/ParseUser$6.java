// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.concurrent.Callable;

// Referenced classes of package com.parse:
//            ParseUser, ParseOperationSet

class >
    implements Callable
{

    final ParseUser this$0;

    public ParseOperationSet call()
        throws Exception
    {
        ParseOperationSet parseoperationset;
        synchronized (mutex)
        {
            parseoperationset = startSave();
        }
        return parseoperationset;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    onSet()
    {
        this$0 = ParseUser.this;
        super();
    }
}
