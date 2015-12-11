// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.cache;

import com.google.common.collect.ForwardingObject;
import java.util.concurrent.ConcurrentMap;

// Referenced classes of package com.google.common.cache:
//            Cache

public abstract class ForwardingCache extends ForwardingObject
    implements Cache
{

    protected ForwardingCache()
    {
    }

    public Object apply(Object obj)
    {
        return _mthdelegate().apply(obj);
    }

    public ConcurrentMap asMap()
    {
        return _mthdelegate().asMap();
    }

    protected abstract Cache _mthdelegate();

    protected volatile Object _mthdelegate()
    {
        return _mthdelegate();
    }

    public Object getUnchecked(Object obj)
    {
        return _mthdelegate().getUnchecked(obj);
    }
}
