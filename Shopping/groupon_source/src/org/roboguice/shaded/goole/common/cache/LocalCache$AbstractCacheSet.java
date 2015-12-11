// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.cache;

import java.util.AbstractSet;
import java.util.concurrent.ConcurrentMap;

// Referenced classes of package org.roboguice.shaded.goole.common.cache:
//            LocalCache

abstract class map extends AbstractSet
{

    final ConcurrentMap map;
    final LocalCache this$0;

    public void clear()
    {
        map.clear();
    }

    public boolean isEmpty()
    {
        return map.isEmpty();
    }

    public int size()
    {
        return map.size();
    }

    I(ConcurrentMap concurrentmap)
    {
        this$0 = LocalCache.this;
        super();
        map = concurrentmap;
    }
}
