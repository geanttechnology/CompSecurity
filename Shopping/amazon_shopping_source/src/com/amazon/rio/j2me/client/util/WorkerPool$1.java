// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.util;


// Referenced classes of package com.amazon.rio.j2me.client.util:
//            LifecycleManager, WorkerPool, Worker, LifecycleException

class val.name
    implements LifecycleManager
{

    private int cnt;
    final String val$name;

    public Worker createInstance()
    {
        StringBuilder stringbuilder = (new StringBuilder()).append(val$name).append("-");
        int i = cnt;
        cnt = i + 1;
        return new Worker(stringbuilder.append(i).toString());
    }

    public volatile Object createInstance()
        throws LifecycleException
    {
        return createInstance();
    }

    public void destroyInstance(Worker worker)
    {
        worker.stopWorker();
    }

    public volatile void destroyInstance(Object obj)
    {
        destroyInstance((Worker)obj);
    }

    ption()
    {
        val$name = s;
        super();
    }
}
