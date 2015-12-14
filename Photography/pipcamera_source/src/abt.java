// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import io.fabric.sdk.android.services.concurrency.Priority;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class abt extends FutureTask
    implements abo, abu, aby
{

    final Object b;

    public abt(Runnable runnable, Object obj)
    {
        super(runnable, obj);
        b = a(runnable);
    }

    public abt(Callable callable)
    {
        super(callable);
        b = a(callable);
    }

    public abo a()
    {
        return (abo)b;
    }

    protected abo a(Object obj)
    {
        if (abv.isProperDelegate(obj))
        {
            return (abo)obj;
        } else
        {
            return new abv();
        }
    }

    public void a(aby aby1)
    {
        ((abo)(abu)a()).addDependency(aby1);
    }

    public void addDependency(Object obj)
    {
        a((aby)obj);
    }

    public boolean areDependenciesMet()
    {
        return ((abo)(abu)a()).areDependenciesMet();
    }

    public int compareTo(Object obj)
    {
        return ((abu)a()).compareTo(obj);
    }

    public Collection getDependencies()
    {
        return ((abo)(abu)a()).getDependencies();
    }

    public Priority getPriority()
    {
        return ((abu)a()).getPriority();
    }

    public boolean isFinished()
    {
        return ((aby)(abu)a()).isFinished();
    }

    public void setError(Throwable throwable)
    {
        ((aby)(abu)a()).setError(throwable);
    }

    public void setFinished(boolean flag)
    {
        ((aby)(abu)a()).setFinished(flag);
    }
}
