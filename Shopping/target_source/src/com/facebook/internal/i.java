// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

public class i
{

    private Object a;
    private CountDownLatch b;

    public i(Callable callable)
    {
        b = new CountDownLatch(1);
        com.facebook.i.d().execute(new FutureTask(new Callable(callable) {

            final Callable a;
            final i b;

            public Void a()
                throws Exception
            {
                i.a(b, a.call());
                i.a(b).countDown();
                return null;
                Exception exception;
                exception;
                i.a(b).countDown();
                throw exception;
            }

            public Object call()
                throws Exception
            {
                return a();
            }

            
            {
                b = i.this;
                a = callable;
                super();
            }
        }));
    }

    static Object a(i j, Object obj)
    {
        j.a = obj;
        return obj;
    }

    static CountDownLatch a(i j)
    {
        return j.b;
    }
}
