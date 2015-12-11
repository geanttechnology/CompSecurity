// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.parse:
//            ParseObject

static final class val.usersComplete
    implements i
{

    final AtomicBoolean val$usersComplete;

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    public Void then(j j)
        throws Exception
    {
        val$usersComplete.set(true);
        return null;
    }

    ic.AtomicBoolean(AtomicBoolean atomicboolean)
    {
        val$usersComplete = atomicboolean;
        super();
    }
}
