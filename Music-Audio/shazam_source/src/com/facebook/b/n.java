// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.b;

import com.facebook.k;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

public final class n
{

    Object a;
    CountDownLatch b;

    public n(Callable callable)
    {
        b = new CountDownLatch(1);
        k.e().execute(new FutureTask(new Callable(callable) {

            final Callable a;
            final n b;

            private Void a()
            {
                b.a = a.call();
                b.b.countDown();
                return null;
                Exception exception;
                exception;
                b.b.countDown();
                throw exception;
            }

            public final Object call()
            {
                return a();
            }

            
            {
                b = n.this;
                a = callable;
                super();
            }
        }));
    }
}
