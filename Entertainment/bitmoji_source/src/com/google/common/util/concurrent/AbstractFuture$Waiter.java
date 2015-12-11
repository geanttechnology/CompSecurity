// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import java.util.concurrent.locks.LockSupport;

// Referenced classes of package com.google.common.util.concurrent:
//            AbstractFuture

private static final class elper.putThread
{

    static final thread TOMBSTONE = new <init>(false);
    volatile <init> next;
    volatile Thread thread;

    void setNext(elper.putThread putthread)
    {
        AbstractFuture.access$100().putNext(this, putthread);
    }

    void unpark()
    {
        Thread thread1 = thread;
        if (thread1 != null)
        {
            thread = null;
            LockSupport.unpark(thread1);
        }
    }


    elper()
    {
        AbstractFuture.access$100().putThread(this, Thread.currentThread());
    }

    elper.putThread(boolean flag)
    {
    }
}
