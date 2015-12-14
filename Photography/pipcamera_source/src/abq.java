// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import io.fabric.sdk.android.services.concurrency.AsyncTask;
import io.fabric.sdk.android.services.concurrency.Priority;
import java.util.Collection;
import java.util.concurrent.ExecutorService;

public abstract class abq extends AsyncTask
    implements abo, abu, aby
{

    private final abv a = new abv();

    public abq()
    {
    }

    public void a(aby aby1)
    {
        if (b() != io.fabric.sdk.android.services.concurrency.AsyncTask.Status.PENDING)
        {
            throw new IllegalStateException("Must not add Dependency after task is running");
        } else
        {
            ((abo)(abu)e()).addDependency(aby1);
            return;
        }
    }

    public final transient void a(ExecutorService executorservice, Object aobj[])
    {
        super.a(new abr(executorservice, this), aobj);
    }

    public void addDependency(Object obj)
    {
        a((aby)obj);
    }

    public boolean areDependenciesMet()
    {
        return ((abo)(abu)e()).areDependenciesMet();
    }

    public int compareTo(Object obj)
    {
        return Priority.compareTo(this, obj);
    }

    public abo e()
    {
        return a;
    }

    public Collection getDependencies()
    {
        return ((abo)(abu)e()).getDependencies();
    }

    public Priority getPriority()
    {
        return ((abu)e()).getPriority();
    }

    public boolean isFinished()
    {
        return ((aby)(abu)e()).isFinished();
    }

    public void setError(Throwable throwable)
    {
        ((aby)(abu)e()).setError(throwable);
    }

    public void setFinished(boolean flag)
    {
        ((aby)(abu)e()).setFinished(flag);
    }
}
