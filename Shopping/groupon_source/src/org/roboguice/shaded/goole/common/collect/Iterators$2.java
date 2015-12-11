// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            Iterators, CollectPreconditions

static final class nditions
    implements Iterator
{

    public boolean hasNext()
    {
        return false;
    }

    public Object next()
    {
        throw new NoSuchElementException();
    }

    public void remove()
    {
        CollectPreconditions.checkRemove(false);
    }

    nditions()
    {
    }
}
