// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

// Referenced classes of package android.support.v7:
//            and, ank, ann, anl, 
//            ang

public class anj extends FutureTask
    implements and, ank, ann
{

    final Object b;

    public anj(Runnable runnable, Object obj)
    {
        super(runnable, obj);
        b = a(runnable);
    }

    public anj(Callable callable)
    {
        super(callable);
        b = a(callable);
    }

    public and a()
    {
        return (and)b;
    }

    protected and a(Object obj)
    {
        if (anl.isProperDelegate(obj))
        {
            return (and)obj;
        } else
        {
            return new anl();
        }
    }

    public void a(ann ann1)
    {
        ((and)(ank)a()).addDependency(ann1);
    }

    public void addDependency(Object obj)
    {
        a((ann)obj);
    }

    public boolean areDependenciesMet()
    {
        return ((and)(ank)a()).areDependenciesMet();
    }

    public int compareTo(Object obj)
    {
        return ((ank)a()).compareTo(obj);
    }

    public Collection getDependencies()
    {
        return ((and)(ank)a()).getDependencies();
    }

    public ang getPriority()
    {
        return ((ank)a()).getPriority();
    }

    public boolean isFinished()
    {
        return ((ann)(ank)a()).isFinished();
    }

    public void setError(Throwable throwable)
    {
        ((ann)(ank)a()).setError(throwable);
    }

    public void setFinished(boolean flag)
    {
        ((ann)(ank)a()).setFinished(flag);
    }
}
