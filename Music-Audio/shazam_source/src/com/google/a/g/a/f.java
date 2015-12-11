// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.g.a;

import com.google.a.c.t;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public abstract class f extends t
    implements Future
{

    protected f()
    {
    }

    protected abstract Future a();

    protected Object b()
    {
        return a();
    }

    public boolean cancel(boolean flag)
    {
        return a().cancel(flag);
    }

    public Object get()
    {
        return a().get();
    }

    public Object get(long l, TimeUnit timeunit)
    {
        return a().get(l, timeunit);
    }

    public boolean isCancelled()
    {
        return a().isCancelled();
    }

    public boolean isDone()
    {
        return a().isDone();
    }
}
