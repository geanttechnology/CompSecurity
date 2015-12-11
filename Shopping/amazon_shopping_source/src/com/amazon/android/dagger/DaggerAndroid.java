// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.dagger;

import dagger.ObjectGraph;
import java.util.concurrent.CountDownLatch;

public final class DaggerAndroid
{

    private static final CountDownLatch DAGGER_OBJECT_GRAPH_LATCH = new CountDownLatch(1);
    private static volatile ObjectGraph graph = null;

    private DaggerAndroid()
    {
    }

    public static void awaitGraphCreation()
        throws InterruptedException
    {
        DAGGER_OBJECT_GRAPH_LATCH.await();
    }

    public static transient ObjectGraph createGraph(Object aobj[])
    {
        com/amazon/android/dagger/DaggerAndroid;
        JVM INSTR monitorenter ;
        graph = ObjectGraph.create(aobj);
        graph.injectStatics();
        DAGGER_OBJECT_GRAPH_LATCH.countDown();
        aobj = graph;
        com/amazon/android/dagger/DaggerAndroid;
        JVM INSTR monitorexit ;
        return ((ObjectGraph) (aobj));
        aobj;
        throw aobj;
    }

    public static ObjectGraph getGraph()
    {
        com/amazon/android/dagger/DaggerAndroid;
        JVM INSTR monitorenter ;
        ObjectGraph objectgraph;
        if (graph == null)
        {
            graph = createGraph(new Object[0]);
        }
        objectgraph = graph;
        com/amazon/android/dagger/DaggerAndroid;
        JVM INSTR monitorexit ;
        return objectgraph;
        Exception exception;
        exception;
        throw exception;
    }

    public static void inject(Object obj)
    {
        com/amazon/android/dagger/DaggerAndroid;
        JVM INSTR monitorenter ;
        getGraph().inject(obj);
        com/amazon/android/dagger/DaggerAndroid;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }

}
