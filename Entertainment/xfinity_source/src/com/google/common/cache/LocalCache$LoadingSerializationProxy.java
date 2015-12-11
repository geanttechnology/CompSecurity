// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.cache;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

// Referenced classes of package com.google.common.cache:
//            LoadingCache, LocalCache, CacheBuilder

static final class init> extends init>
    implements LoadingCache, Serializable
{

    transient LoadingCache autoDelegate;

    private void readObject(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        objectinputstream.defaultReadObject();
        autoDelegate = recreateCacheBuilder().build(loader);
    }

    private Object readResolve()
    {
        return autoDelegate;
    }

    public final Object apply(Object obj)
    {
        return autoDelegate.apply(obj);
    }

    public Object getUnchecked(Object obj)
    {
        return autoDelegate.getUnchecked(obj);
    }

    (LocalCache localcache)
    {
        super(localcache);
    }
}
