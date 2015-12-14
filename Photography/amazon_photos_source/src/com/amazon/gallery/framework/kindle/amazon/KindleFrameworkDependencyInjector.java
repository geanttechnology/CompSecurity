// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.amazon;

import dagger.ObjectGraph;

public class KindleFrameworkDependencyInjector
{

    private static ObjectGraph og;

    public static void inject(Object obj)
    {
        og.inject(obj);
    }

    public static void setObjectGraph(ObjectGraph objectgraph)
    {
        og = objectgraph;
    }
}
