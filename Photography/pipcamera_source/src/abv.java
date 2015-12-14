// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import io.fabric.sdk.android.services.concurrency.Priority;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class abv
    implements abo, abu, aby
{

    private final List dependencies = new ArrayList();
    private final AtomicBoolean hasRun = new AtomicBoolean(false);
    private final AtomicReference throwable = new AtomicReference(null);

    public abv()
    {
    }

    public static boolean isProperDelegate(Object obj)
    {
        abo abo1;
        aby aby1;
        try
        {
            abo1 = (abo)obj;
            aby1 = (aby)obj;
            obj = (abu)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        return abo1 != null && aby1 != null && obj != null;
    }

    public void addDependency(aby aby1)
    {
        this;
        JVM INSTR monitorenter ;
        dependencies.add(aby1);
        this;
        JVM INSTR monitorexit ;
        return;
        aby1;
        throw aby1;
    }

    public volatile void addDependency(Object obj)
    {
        addDependency((aby)obj);
    }

    public boolean areDependenciesMet()
    {
        for (Iterator iterator = getDependencies().iterator(); iterator.hasNext();)
        {
            if (!((aby)iterator.next()).isFinished())
            {
                return false;
            }
        }

        return true;
    }

    public int compareTo(Object obj)
    {
        return Priority.compareTo(this, obj);
    }

    public Collection getDependencies()
    {
        this;
        JVM INSTR monitorenter ;
        Collection collection = Collections.unmodifiableCollection(dependencies);
        this;
        JVM INSTR monitorexit ;
        return collection;
        Exception exception;
        exception;
        throw exception;
    }

    public Throwable getError()
    {
        return (Throwable)throwable.get();
    }

    public Priority getPriority()
    {
        return Priority.NORMAL;
    }

    public boolean isFinished()
    {
        return hasRun.get();
    }

    public void setError(Throwable throwable1)
    {
        throwable.set(throwable1);
    }

    public void setFinished(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        hasRun.set(flag);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
