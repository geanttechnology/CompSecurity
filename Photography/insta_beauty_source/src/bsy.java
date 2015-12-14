// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import io.fabric.sdk.android.services.common.IdManager;
import java.io.File;
import java.util.Collection;

public abstract class bsy
    implements Comparable
{

    Context context;
    bso fabric;
    IdManager idManager;
    bsu initializationCallback;
    bsx initializationTask;

    public bsy()
    {
        initializationTask = new bsx(this);
    }

    public int compareTo(bsy bsy1)
    {
        if (!containsAnnotatedDependency(bsy1))
        {
            if (bsy1.containsAnnotatedDependency(this))
            {
                return -1;
            }
            if (!hasAnnotatedDependency() || bsy1.hasAnnotatedDependency())
            {
                return hasAnnotatedDependency() || !bsy1.hasAnnotatedDependency() ? 0 : -1;
            }
        }
        return 1;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((bsy)obj);
    }

    boolean containsAnnotatedDependency(bsy bsy1)
    {
        bux bux1 = (bux)getClass().getAnnotation(bux);
        if (bux1 != null)
        {
            Class aclass[] = bux1.a();
            int j = aclass.length;
            for (int i = 0; i < j; i++)
            {
                if (aclass[i].equals(bsy1.getClass()))
                {
                    return true;
                }
            }

        }
        return false;
    }

    public abstract Object doInBackground();

    public Context getContext()
    {
        return context;
    }

    public Collection getDependencies()
    {
        return initializationTask.getDependencies();
    }

    public bso getFabric()
    {
        return fabric;
    }

    public IdManager getIdManager()
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
        return (bux)getClass().getAnnotation(bux) != null;
    }

    final void initialize()
    {
        initializationTask.a(fabric.f(), new Void[] {
            (Void)null
        });
    }

    void injectParameters(Context context1, bso bso1, bsu bsu, IdManager idmanager)
    {
        fabric = bso1;
        context = new bss(context1, getIdentifier(), getPath());
        initializationCallback = bsu;
        idManager = idmanager;
    }

    protected void onCancelled(Object obj)
    {
    }

    protected void onPostExecute(Object obj)
    {
    }

    public boolean onPreExecute()
    {
        return true;
    }
}
