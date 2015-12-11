// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import java.io.File;
import java.util.Collection;

// Referenced classes of package android.support.v7:
//            aly, anf, alt, alu, 
//            amw, alw

public abstract class alz
    implements Comparable
{

    Context context;
    alt fabric;
    amw idManager;
    alw initializationCallback;
    aly initializationTask;

    public alz()
    {
        initializationTask = new aly(this);
    }

    public int compareTo(alz alz1)
    {
        if (!containsAnnotatedDependency(alz1))
        {
            if (alz1.containsAnnotatedDependency(this))
            {
                return -1;
            }
            if (!hasAnnotatedDependency() || alz1.hasAnnotatedDependency())
            {
                return hasAnnotatedDependency() || !alz1.hasAnnotatedDependency() ? 0 : -1;
            }
        }
        return 1;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((alz)obj);
    }

    boolean containsAnnotatedDependency(alz alz1)
    {
        anf anf1 = (anf)getClass().getAnnotation(android/support/v7/anf);
        if (anf1 != null)
        {
            Class aclass[] = anf1.a();
            int j = aclass.length;
            for (int i = 0; i < j; i++)
            {
                if (aclass[i].equals(alz1.getClass()))
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

    public alt getFabric()
    {
        return fabric;
    }

    protected amw getIdManager()
    {
        return idManager;
    }

    public abstract String getIdentifier();

    public String getPath()
    {
        return (new StringBuilder()).append(".Fabric").append(File.separator).append(getIdentifier()).toString();
    }

    public abstract String getVersion();

    boolean hasAnnotatedDependency()
    {
        return (anf)getClass().getAnnotation(android/support/v7/anf) != null;
    }

    final void initialize()
    {
        initializationTask.a(fabric.f(), new Void[] {
            (Void)null
        });
    }

    void injectParameters(Context context1, alt alt1, alw alw, amw amw)
    {
        fabric = alt1;
        context = new alu(context1, getIdentifier(), getPath());
        initializationCallback = alw;
        idManager = amw;
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
