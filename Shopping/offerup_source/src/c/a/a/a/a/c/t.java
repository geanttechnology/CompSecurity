// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.c;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

// Referenced classes of package c.a.a.a.a.c:
//            l, u, y, v

public class t extends FutureTask
    implements l, u, y
{

    private Object a;

    public t(Runnable runnable, Object obj)
    {
        super(runnable, obj);
        a = a(runnable);
    }

    public t(Callable callable)
    {
        super(callable);
        a = a(callable);
    }

    private static l a(Object obj)
    {
        if (v.isProperDelegate(obj))
        {
            return (l)obj;
        } else
        {
            return new v();
        }
    }

    public l a()
    {
        return (l)a;
    }

    public void addDependency(Object obj)
    {
        obj = (y)obj;
        ((l)(u)a()).addDependency(obj);
    }

    public boolean areDependenciesMet()
    {
        return ((l)(u)a()).areDependenciesMet();
    }

    public int compareTo(Object obj)
    {
        return ((u)a()).compareTo(obj);
    }

    public Collection getDependencies()
    {
        return ((l)(u)a()).getDependencies();
    }

    public int getPriority$16699175()
    {
        return ((u)a()).getPriority$16699175();
    }

    public boolean isFinished()
    {
        return ((y)(u)a()).isFinished();
    }

    public void setError(Throwable throwable)
    {
        ((y)(u)a()).setError(throwable);
    }

    public void setFinished(boolean flag)
    {
        ((y)(u)a()).setFinished(flag);
    }
}
