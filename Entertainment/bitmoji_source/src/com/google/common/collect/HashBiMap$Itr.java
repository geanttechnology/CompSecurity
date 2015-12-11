// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package com.google.common.collect:
//            HashBiMap, CollectPreconditions

abstract class this._cls0
    implements Iterator
{

    int expectedModCount;
    try next;
    final HashBiMap this$0;
    try toRemove;

    public boolean hasNext()
    {
        if (HashBiMap.access$100(HashBiMap.this) != expectedModCount)
        {
            throw new ConcurrentModificationException();
        }
        return next != null;
    }

    public Object next()
    {
        if (!hasNext())
        {
            throw new NoSuchElementException();
        } else
        {
            try try1 = next;
            next = try1.nextInKeyInsertionOrder;
            toRemove = try1;
            return output(try1);
        }
    }

    abstract Object output(try try1);

    public void remove()
    {
        if (HashBiMap.access$100(HashBiMap.this) != expectedModCount)
        {
            throw new ConcurrentModificationException();
        }
        boolean flag;
        if (toRemove != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        CollectPreconditions.checkRemove(flag);
        HashBiMap.access$200(HashBiMap.this, toRemove);
        expectedModCount = HashBiMap.access$100(HashBiMap.this);
        toRemove = null;
    }

    try()
    {
        this$0 = HashBiMap.this;
        super();
        next = HashBiMap.access$000(HashBiMap.this);
        toRemove = null;
        expectedModCount = HashBiMap.access$100(HashBiMap.this);
    }
}
