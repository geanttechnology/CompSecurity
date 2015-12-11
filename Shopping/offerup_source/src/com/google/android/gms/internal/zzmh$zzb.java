// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzmh, zzmf

final class zzagL
    implements Set
{

    final zzmh zzagL;

    public final volatile boolean add(Object obj)
    {
        return add((java.util.)obj);
    }

    public final boolean add(java.util. )
    {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection collection)
    {
        int i = zzagL.colGetSize();
        java.util. ;
        for (collection = collection.iterator(); collection.hasNext(); zzagL.colPut(.getKey(), .getValue()))
        {
             = (java.util.)collection.next();
        }

        return i != zzagL.colGetSize();
    }

    public final void clear()
    {
        zzagL.colClear();
    }

    public final boolean contains(Object obj)
    {
        if (obj instanceof java.util.)
        {
            obj = (java.util.)obj;
            int i = zzagL.colIndexOfKey(((java.util.) (obj)).getKey());
            if (i >= 0)
            {
                return zzmf.equal(zzagL.colGetEntry(i, 1), ((java.util.) (obj)).getValue());
            }
        }
        return false;
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

    public final boolean equals(Object obj)
    {
        return zzmh.equalsSetHelper(this, obj);
    }

    public final int hashCode()
    {
        int j = zzagL.colGetSize() - 1;
        int i = 0;
        while (j >= 0) 
        {
            Object obj = zzagL.colGetEntry(j, 0);
            Object obj1 = zzagL.colGetEntry(j, 1);
            int k;
            int l;
            if (obj == null)
            {
                k = 0;
            } else
            {
                k = obj.hashCode();
            }
            if (obj1 == null)
            {
                l = 0;
            } else
            {
                l = obj1.hashCode();
            }
            j--;
            i += l ^ k;
        }
        return i;
    }

    public final boolean isEmpty()
    {
        return zzagL.colGetSize() == 0;
    }

    public final Iterator iterator()
    {
        return new <init>(zzagL);
    }

    public final boolean remove(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public final boolean removeAll(Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public final boolean retainAll(Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public final int size()
    {
        return zzagL.colGetSize();
    }

    public final Object[] toArray()
    {
        throw new UnsupportedOperationException();
    }

    public final Object[] toArray(Object aobj[])
    {
        throw new UnsupportedOperationException();
    }

    (zzmh zzmh1)
    {
        zzagL = zzmh1;
        super();
    }
}
