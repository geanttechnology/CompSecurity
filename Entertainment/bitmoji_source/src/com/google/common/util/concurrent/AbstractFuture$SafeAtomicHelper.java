// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

// Referenced classes of package com.google.common.util.concurrent:
//            AbstractFuture

private static final class <init> extends <init>
{

    boolean casListeners(AbstractFuture abstractfuture, <init> <init>1, <init> <init>2)
    {
        return AbstractFuture.access$1000().compareAndSet(abstractfuture, <init>1, <init>2);
    }

    boolean casValue(AbstractFuture abstractfuture, Object obj, Object obj1)
    {
        return AbstractFuture.access$1100().compareAndSet(abstractfuture, obj, obj1);
    }

    boolean casWaiters(AbstractFuture abstractfuture, Set set, Set set1)
    {
        return AbstractFuture.access$900().compareAndSet(abstractfuture, set, set1);
    }

    void putNext(Set set, Set set1)
    {
        AbstractFuture.access$800().lazySet(set, set1);
    }

    void putThread(Set set, Thread thread)
    {
        AbstractFuture.access$700().lazySet(set, thread);
    }

    private ()
    {
        super(null);
    }

    t>(t> t>)
    {
        this();
    }
}
