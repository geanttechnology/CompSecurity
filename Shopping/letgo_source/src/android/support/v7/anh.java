// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

// Referenced classes of package android.support.v7:
//            anc, and, ank, ann, 
//            anl, ang, anj

public abstract class anh extends anc
    implements and, ank, ann
{
    private static class a
        implements Executor
    {

        private final Executor a;
        private final anh b;

        static anh a(a a1)
        {
            return a1.b;
        }

        public void execute(Runnable runnable)
        {
            a.execute(new anj(this, runnable, null) {

                final a a;

                public and a()
                {
                    return a.a(a);
                }

            
            {
                a = a1;
                super(runnable, obj);
            }
            });
        }

        public a(Executor executor, anh anh1)
        {
            a = executor;
            b = anh1;
        }
    }


    private final anl a = new anl();

    public anh()
    {
    }

    public void a(ann ann1)
    {
        if (b() != anc.d.a)
        {
            throw new IllegalStateException("Must not add Dependency after task is running");
        } else
        {
            ((and)(ank)e()).addDependency(ann1);
            return;
        }
    }

    public final transient void a(ExecutorService executorservice, Object aobj[])
    {
        super.a(new a(executorservice, this), aobj);
    }

    public void addDependency(Object obj)
    {
        a((ann)obj);
    }

    public boolean areDependenciesMet()
    {
        return ((and)(ank)e()).areDependenciesMet();
    }

    public int compareTo(Object obj)
    {
        return ang.a(this, obj);
    }

    public and e()
    {
        return a;
    }

    public Collection getDependencies()
    {
        return ((and)(ank)e()).getDependencies();
    }

    public ang getPriority()
    {
        return ((ank)e()).getPriority();
    }

    public boolean isFinished()
    {
        return ((ann)(ank)e()).isFinished();
    }

    public void setError(Throwable throwable)
    {
        ((ann)(ank)e()).setError(throwable);
    }

    public void setFinished(boolean flag)
    {
        ((ann)(ank)e()).setFinished(flag);
    }
}
