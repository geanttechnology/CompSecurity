// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.cache;

import java.util.AbstractCollection;
import java.util.Iterator;

// Referenced classes of package com.google.common.cache:
//            LocalCache

final class this._cls0 extends AbstractCollection
{

    final LocalCache this$0;

    public void clear()
    {
        LocalCache.this.clear();
    }

    public boolean contains(Object obj)
    {
        return containsValue(obj);
    }

    public boolean isEmpty()
    {
        return LocalCache.this.isEmpty();
    }

    public Iterator iterator()
    {
        return new erator(LocalCache.this);
    }

    public int size()
    {
        return LocalCache.this.size();
    }

    erator()
    {
        this$0 = LocalCache.this;
        super();
    }
}
