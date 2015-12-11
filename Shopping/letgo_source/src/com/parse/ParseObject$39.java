// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.parse:
//            ParseObject

static final class val.usersComplete
    implements ct
{

    final AtomicBoolean val$usersComplete;

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    public Void then(cu cu)
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
