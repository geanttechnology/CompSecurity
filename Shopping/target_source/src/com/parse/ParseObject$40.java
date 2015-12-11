// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.h;
import java.util.Set;
import java.util.concurrent.Callable;

// Referenced classes of package com.parse:
//            ParseObject

static final class val.remaining
    implements Callable
{

    final h val$remaining;

    public Boolean call()
        throws Exception
    {
        boolean flag;
        if (((Set)val$remaining.a()).size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    able(h h1)
    {
        val$remaining = h1;
        super();
    }
}
