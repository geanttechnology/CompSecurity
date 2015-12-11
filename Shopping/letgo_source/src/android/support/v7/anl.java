// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package android.support.v7:
//            and, ank, ann, ang

public class anl
    implements and, ank, ann
{

    private final List dependencies = new ArrayList();
    private final AtomicBoolean hasRun = new AtomicBoolean(false);
    private final AtomicReference throwable = new AtomicReference(null);

    public anl()
    {
    }

    public static boolean isProperDelegate(Object obj)
    {
        and and1;
        ann ann1;
        try
        {
            and1 = (and)obj;
            ann1 = (ann)obj;
            obj = (ank)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        return and1 != null && ann1 != null && obj != null;
    }

    public void addDependency(ann ann1)
    {
        this;
        JVM INSTR monitorenter ;
        dependencies.add(ann1);
        this;
        JVM INSTR monitorexit ;
        return;
        ann1;
        throw ann1;
    }

    public volatile void addDependency(Object obj)
    {
        addDependency((ann)obj);
    }

    public boolean areDependenciesMet()
    {
        for (Iterator iterator = getDependencies().iterator(); iterator.hasNext();)
        {
            if (!((ann)iterator.next()).isFinished())
            {
                return false;
            }
        }

        return true;
    }

    public int compareTo(Object obj)
    {
        return ang.a(this, obj);
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

    public ang getPriority()
    {
        return ang.b;
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
