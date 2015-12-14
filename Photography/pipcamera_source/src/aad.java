// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import io.fabric.sdk.android.services.common.IdManager;
import java.io.File;
import java.util.Collection;

public abstract class aad
    implements Comparable
{

    Context context;
    zw fabric;
    IdManager idManager;
    aaa initializationCallback;
    aac initializationTask;

    public aad()
    {
        initializationTask = new aac(this);
    }

    public int compareTo(aad aad1)
    {
        if (!containsAnnotatedDependency(aad1))
        {
            if (aad1.containsAnnotatedDependency(this))
            {
                return -1;
            }
            if (!hasAnnotatedDependency() || aad1.hasAnnotatedDependency())
            {
                return hasAnnotatedDependency() || !aad1.hasAnnotatedDependency() ? 0 : -1;
            }
        }
        return 1;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((aad)obj);
    }

    boolean containsAnnotatedDependency(aad aad1)
    {
        abp abp1 = (abp)getClass().getAnnotation(abp);
        if (abp1 != null)
        {
            Class aclass[] = abp1.a();
            int j = aclass.length;
            for (int i = 0; i < j; i++)
            {
                if (aclass[i].equals(aad1.getClass()))
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

    public zw getFabric()
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
        return (abp)getClass().getAnnotation(abp) != null;
    }

    final void initialize()
    {
        initializationTask.a(fabric.f(), new Void[] {
            (Void)null
        });
    }

    void injectParameters(Context context1, zw zw1, aaa aaa, IdManager idmanager)
    {
        fabric = zw1;
        context = new zy(context1, getIdentifier(), getPath());
        initializationCallback = aaa;
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
