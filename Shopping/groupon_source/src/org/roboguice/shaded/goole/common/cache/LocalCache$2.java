// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.cache;

import java.util.AbstractQueue;
import java.util.Iterator;
import org.roboguice.shaded.goole.common.collect.Iterators;

// Referenced classes of package org.roboguice.shaded.goole.common.cache:
//            LocalCache

static final class  extends AbstractQueue
{

    public Iterator iterator()
    {
        return Iterators.emptyIterator();
    }

    public boolean offer(Object obj)
    {
        return true;
    }

    public Object peek()
    {
        return null;
    }

    public Object poll()
    {
        return null;
    }

    public int size()
    {
        return 0;
    }

    ()
    {
    }
}
