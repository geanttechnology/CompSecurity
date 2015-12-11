// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class crf
    implements Future, mj
{

    private final nb a = new nb();

    public crf()
    {
    }

    public static crf a()
    {
        return new crf();
    }

    public void a(Object obj)
    {
        a.a(obj);
    }

    public final void a(mp mp)
    {
        a.a(mp);
    }

    public boolean cancel(boolean flag)
    {
        return a.cancel(flag);
    }

    public Object get()
    {
        b.b();
        return a.get();
    }

    public Object get(long l, TimeUnit timeunit)
    {
        b.b();
        return a.get(l, timeunit);
    }

    public boolean isCancelled()
    {
        return a.isCancelled();
    }

    public boolean isDone()
    {
        return a.isDone();
    }
}
