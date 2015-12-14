// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import io.fabric.sdk.android.services.concurrency.Priority;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class bvc extends FutureTask
    implements buw, bvd, bvh
{

    final Object b;

    public bvc(Runnable runnable, Object obj)
    {
        super(runnable, obj);
        b = a(runnable);
    }

    public bvc(Callable callable)
    {
        super(callable);
        b = a(callable);
    }

    public buw a()
    {
        return (buw)b;
    }

    protected buw a(Object obj)
    {
        if (bve.isProperDelegate(obj))
        {
            return (buw)obj;
        } else
        {
            return new bve();
        }
    }

    public void a(bvh bvh1)
    {
        ((buw)(bvd)a()).addDependency(bvh1);
    }

    public void addDependency(Object obj)
    {
        a((bvh)obj);
    }

    public boolean areDependenciesMet()
    {
        return ((buw)(bvd)a()).areDependenciesMet();
    }

    public int compareTo(Object obj)
    {
        return ((bvd)a()).compareTo(obj);
    }

    public Collection getDependencies()
    {
        return ((buw)(bvd)a()).getDependencies();
    }

    public Priority getPriority()
    {
        return ((bvd)a()).getPriority();
    }

    public boolean isFinished()
    {
        return ((bvh)(bvd)a()).isFinished();
    }

    public void setError(Throwable throwable)
    {
        ((bvh)(bvd)a()).setError(throwable);
    }

    public void setFinished(boolean flag)
    {
        ((bvh)(bvd)a()).setFinished(flag);
    }
}
