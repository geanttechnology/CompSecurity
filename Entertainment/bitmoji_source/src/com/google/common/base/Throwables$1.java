// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;

import java.util.AbstractList;

// Referenced classes of package com.google.common.base:
//            Throwables

static final class val.t extends AbstractList
{

    final Throwable val$t;

    public volatile Object get(int i)
    {
        return get(i);
    }

    public StackTraceElement get(int i)
    {
        return (StackTraceElement)Throwables.access$200(Throwables.access$000(), Throwables.access$100(), new Object[] {
            val$t, Integer.valueOf(i)
        });
    }

    public int size()
    {
        return ((Integer)Throwables.access$200(Throwables.access$300(), Throwables.access$100(), new Object[] {
            val$t
        })).intValue();
    }

    (Throwable throwable)
    {
        val$t = throwable;
        super();
    }
}
