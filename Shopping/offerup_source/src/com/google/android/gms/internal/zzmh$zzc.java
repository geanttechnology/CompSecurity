// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzmh

final class zzagL
    implements Set
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
        return zzagL.colIndexOfKey(obj) >= 0;
    }

    public final boolean containsAll(Collection collection)
    {
        return zzmh.containsAllHelper(zzagL.colGetMap(), collection);
    }

    public final boolean equals(Object obj)
    {
        return zzmh.equalsSetHelper(this, obj);
    }

    public final int hashCode()
    {
        int i = zzagL.colGetSize() - 1;
        int j = 0;
        while (i >= 0) 
        {
            Object obj = zzagL.colGetEntry(i, 0);
            int k;
            if (obj == null)
            {
                k = 0;
            } else
            {
                k = obj.hashCode();
            }
            j += k;
            i--;
        }
        return j;
    }

    public final boolean isEmpty()
    {
        return zzagL.colGetSize() == 0;
    }

    public final Iterator iterator()
    {
        return new <init>(zzagL, 0);
    }

    public final boolean remove(Object obj)
    {
        int i = zzagL.colIndexOfKey(obj);
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
        return zzmh.removeAllHelper(zzagL.colGetMap(), collection);
    }

    public final boolean retainAll(Collection collection)
    {
        return zzmh.retainAllHelper(zzagL.colGetMap(), collection);
    }

    public final int size()
    {
        return zzagL.colGetSize();
    }

    public final Object[] toArray()
    {
        return zzagL.toArrayHelper(0);
    }

    public final Object[] toArray(Object aobj[])
    {
        return zzagL.toArrayHelper(aobj, 0);
    }

    (zzmh zzmh1)
    {
        zzagL = zzmh1;
        super();
    }
}
