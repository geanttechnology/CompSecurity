// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.c;

import java.util.Collection;
import java.util.concurrent.ExecutorService;

// Referenced classes of package c.a.a.a.a.c:
//            a, l, u, y, 
//            v, j, q, o

public abstract class p extends a
    implements l, u, y
{

    private final v b = new v();

    public p()
    {
    }

    public final void a(y y1)
    {
        if (b() != j.a)
        {
            throw new IllegalStateException("Must not add Dependency after task is running");
        } else
        {
            ((l)(u)b).addDependency(y1);
            return;
        }
    }

    public final transient void a(ExecutorService executorservice, Object aobj[])
    {
        super.a(new q(executorservice, this), aobj);
    }

    public void addDependency(Object obj)
    {
        a((y)obj);
    }

    public boolean areDependenciesMet()
    {
        return ((l)(u)b).areDependenciesMet();
    }

    public int compareTo(Object obj)
    {
        return o.a(this, obj);
    }

    public Collection getDependencies()
    {
        return ((l)(u)b).getDependencies();
    }

    public int getPriority$16699175()
    {
        return ((u)b).getPriority$16699175();
    }

    public boolean isFinished()
    {
        return ((y)(u)b).isFinished();
    }

    public void setError(Throwable throwable)
    {
        ((y)(u)b).setError(throwable);
    }

    public void setFinished(boolean flag)
    {
        ((y)(u)b).setFinished(flag);
    }
}
