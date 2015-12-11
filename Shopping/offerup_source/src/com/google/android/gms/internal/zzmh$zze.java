// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.google.android.gms.internal:
//            zzmh

final class zzagL
    implements Collection
{

    final zzmh zzagL;

    public final boolean add(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public final void clear()
    {
        zzagL.colClear();
    }

    public final boolean contains(Object obj)
    {
        return zzagL.colIndexOfValue(obj) >= 0;
    }

    public final boolean containsAll(Collection collection)
    {
        for (collection = collection.iterator(); collection.hasNext();)
        {
            if (!contains(collection.next()))
            {
                return false;
            }
        }

        return true;
    }

    public final boolean isEmpty()
    {
        return zzagL.colGetSize() == 0;
    }

    public final Iterator iterator()
    {
        return new <init>(zzagL, 1);
    }

    public final boolean remove(Object obj)
    {
        int i = zzagL.colIndexOfValue(obj);
        if (i >= 0)
        {
            zzagL.colRemoveAt(i);
            return true;
        } else
        {
            return false;
        }
    }

    public final boolean removeAll(Collection collection)
    {
        int i = 0;
        int j = zzagL.colGetSize();
        boolean flag = false;
        int k;
        for (; i < j; j = k)
        {
            int l = i;
            k = j;
            if (collection.contains(zzagL.colGetEntry(i, 1)))
            {
                zzagL.colRemoveAt(i);
                l = i - 1;
                k = j - 1;
                flag = true;
            }
            i = l + 1;
        }

        return flag;
    }

    public final boolean retainAll(Collection collection)
    {
        int i = 0;
        int j = zzagL.colGetSize();
        boolean flag = false;
        int k;
        for (; i < j; j = k)
        {
            int l = i;
            k = j;
            if (!collection.contains(zzagL.colGetEntry(i, 1)))
            {
                zzagL.colRemoveAt(i);
                l = i - 1;
                k = j - 1;
                flag = true;
            }
            i = l + 1;
        }

        return flag;
    }

    public final int size()
    {
        return zzagL.colGetSize();
    }

    public final Object[] toArray()
    {
        return zzagL.toArrayHelper(1);
    }

    public final Object[] toArray(Object aobj[])
    {
        return zzagL.toArrayHelper(aobj, 1);
    }

    (zzmh zzmh1)
    {
        zzagL = zzmh1;
        super();
    }
}
