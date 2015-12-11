// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.cache;

import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package org.roboguice.shaded.goole.common.cache:
//            LongAddable, LongAddables

private static final class <init> extends AtomicLong
    implements LongAddable
{

    public void add(long l)
    {
        getAndAdd(l);
    }

    public void increment()
    {
        getAndIncrement();
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
