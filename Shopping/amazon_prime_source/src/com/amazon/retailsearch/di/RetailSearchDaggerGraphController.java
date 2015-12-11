// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.di;

import dagger.ObjectGraph;

public final class RetailSearchDaggerGraphController
{

    private static volatile ObjectGraph graph = null;

    private RetailSearchDaggerGraphController()
    {
    }

    public static transient ObjectGraph createGraph(Object aobj[])
    {
        com/amazon/retailsearch/di/RetailSearchDaggerGraphController;
        JVM INSTR monitorenter ;
        graph = ObjectGraph.create(aobj);
        aobj = graph;
        com/amazon/retailsearch/di/RetailSearchDaggerGraphController;
        JVM INSTR monitorexit ;
        return ((ObjectGraph) (aobj));
        aobj;
        throw aobj;
    }

    public static ObjectGraph getGraph()
    {
        com/amazon/retailsearch/di/RetailSearchDaggerGraphController;
        JVM INSTR monitorenter ;
        ObjectGraph objectgraph;
        if (graph == null)
        {
            graph = createGraph(new Object[0]);
        }
        objectgraph = graph;
        com/amazon/retailsearch/di/RetailSearchDaggerGraphController;
        JVM INSTR monitorexit ;
        return objectgraph;
        Exception exception;
        exception;
        throw exception;
    }

    public static void inject(Object obj)
    {
        com/amazon/retailsearch/di/RetailSearchDaggerGraphController;
        JVM INSTR monitorenter ;
        getGraph().inject(obj);
        com/amazon/retailsearch/di/RetailSearchDaggerGraphController;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }

    static void setGraph(ObjectGraph objectgraph)
    {
        graph = objectgraph;
    }

}
