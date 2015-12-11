// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzmh, zzme

class nit> extends zzmh
{

    final zzme zzagA;

    protected void colClear()
    {
        zzagA.clear();
    }

    protected Object colGetEntry(int i, int j)
    {
        return zzagA.mArray[(i << 1) + j];
    }

    protected Map colGetMap()
    {
        return zzagA;
    }

    protected int colGetSize()
    {
        return zzagA.mSize;
    }

    protected int colIndexOfKey(Object obj)
    {
        if (obj == null)
        {
            return zzagA.indexOfNull();
        } else
        {
            return zzagA.indexOf(obj, obj.hashCode());
        }
    }

    protected int colIndexOfValue(Object obj)
    {
        return zzagA.indexOfValue(obj);
    }

    protected void colPut(Object obj, Object obj1)
    {
        zzagA.put(obj, obj1);
    }

    protected void colRemoveAt(int i)
    {
        zzagA.removeAt(i);
    }

    protected Object colSetValue(int i, Object obj)
    {
        return zzagA.setValueAt(i, obj);
    }

    (zzme zzme1)
    {
        zzagA = zzme1;
        super();
    }
}
