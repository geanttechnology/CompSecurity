// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import io.fabric.sdk.android.services.concurrency.AsyncTask;
import io.fabric.sdk.android.services.concurrency.Priority;
import java.util.Collection;
import java.util.concurrent.ExecutorService;

public abstract class buy extends AsyncTask
    implements buw, bvd, bvh
{

    private final bve a = new bve();

    public buy()
    {
    }

    public void a(bvh bvh1)
    {
        if (b() != io.fabric.sdk.android.services.concurrency.AsyncTask.Status.PENDING)
        {
            throw new IllegalStateException("Must not add Dependency after task is running");
        } else
        {
            ((buw)(bvd)e()).addDependency(bvh1);
            return;
        }
    }

    public final transient void a(ExecutorService executorservice, Object aobj[])
    {
        super.a(new buz(executorservice, this), aobj);
    }

    public void addDependency(Object obj)
    {
        a((bvh)obj);
    }

    public boolean areDependenciesMet()
    {
        return ((buw)(bvd)e()).areDependenciesMet();
    }

    public int compareTo(Object obj)
    {
        return Priority.compareTo(this, obj);
    }

    public buw e()
    {
        return a;
    }

    public Collection getDependencies()
    {
        return ((buw)(bvd)e()).getDependencies();
    }

    public Priority getPriority()
    {
        return ((bvd)e()).getPriority();
    }

    public boolean isFinished()
    {
        return ((bvh)(bvd)e()).isFinished();
    }

    public void setError(Throwable throwable)
    {
        ((bvh)(bvd)e()).setError(throwable);
    }

    public void setFinished(boolean flag)
    {
        ((bvh)(bvd)e()).setFinished(flag);
    }
}
