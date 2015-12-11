// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a;

import android.content.Context;
import c.a.a.a.a.b.x;
import java.io.File;
import java.util.Collection;

// Referenced classes of package c.a.a.a:
//            m, e, i, k

public abstract class n
    implements Comparable
{

    Context context;
    e fabric;
    x idManager;
    k initializationCallback;
    m initializationTask;

    public n()
    {
        initializationTask = new m(this);
    }

    public int compareTo(n n1)
    {
        if (!containsAnnotatedDependency(n1))
        {
            if (n1.containsAnnotatedDependency(this))
            {
                return -1;
            }
            if (!hasAnnotatedDependency() || n1.hasAnnotatedDependency())
            {
                return hasAnnotatedDependency() || !n1.hasAnnotatedDependency() ? 0 : -1;
            }
        }
        return 1;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((n)obj);
    }

    boolean containsAnnotatedDependency(n n1)
    {
        c.a.a.a.a.c.n n2 = (c.a.a.a.a.c.n)getClass().getAnnotation(c/a/a/a/a/c/n);
        if (n2 != null)
        {
            Class aclass[] = n2.a();
            int k = aclass.length;
            for (int j = 0; j < k; j++)
            {
                if (aclass[j].equals(n1.getClass()))
                {
                    return true;
                }
            }

        }
        return false;
    }

    protected abstract Object doInBackground();

    public Context getContext()
    {
        return context;
    }

    protected Collection getDependencies()
    {
        return initializationTask.getDependencies();
    }

    public e getFabric()
    {
        return fabric;
    }

    protected x getIdManager()
    {
        return idManager;
    }

    public abstract String getIdentifier();

    public String getPath()
    {
        return (new StringBuilder(".Fabric")).append(File.separator).append(getIdentifier()).toString();
    }

    public abstract String getVersion();

    boolean hasAnnotatedDependency()
    {
        return (c.a.a.a.a.c.n)getClass().getAnnotation(c/a/a/a/a/c/n) != null;
    }

    final void initialize()
    {
        initializationTask.a(fabric.c(), new Void[] {
            null
        });
    }

    void injectParameters(Context context1, e e1, k k, x x)
    {
        fabric = e1;
        context = new i(context1, getIdentifier(), getPath());
        initializationCallback = k;
        idManager = x;
    }

    protected void onCancelled(Object obj)
    {
    }

    protected void onPostExecute(Object obj)
    {
    }

    protected boolean onPreExecute()
    {
        return true;
    }
}
