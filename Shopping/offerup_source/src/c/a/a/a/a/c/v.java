// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package c.a.a.a.a.c:
//            l, u, y, o

public class v
    implements l, u, y
{

    private final List dependencies = new ArrayList();
    private final AtomicBoolean hasRun = new AtomicBoolean(false);
    private final AtomicReference throwable = new AtomicReference(null);

    public v()
    {
    }

    public static boolean isProperDelegate(Object obj)
    {
        l l1;
        y y1;
        try
        {
            l1 = (l)obj;
            y1 = (y)obj;
            obj = (u)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        return l1 != null && y1 != null && obj != null;
    }

    public void addDependency(y y1)
    {
        this;
        JVM INSTR monitorenter ;
        dependencies.add(y1);
        this;
        JVM INSTR monitorexit ;
        return;
        y1;
        throw y1;
    }

    public volatile void addDependency(Object obj)
    {
        addDependency((y)obj);
    }

    public boolean areDependenciesMet()
    {
        for (Iterator iterator = getDependencies().iterator(); iterator.hasNext();)
        {
            if (!((y)iterator.next()).isFinished())
            {
                return false;
            }
        }

        return true;
    }

    public int compareTo(Object obj)
    {
        return o.a(this, obj);
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

    public int getPriority$16699175()
    {
        return o.a;
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
