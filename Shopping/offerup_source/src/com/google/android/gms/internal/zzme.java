// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzmi, zzmh

public class zzme extends zzmi
    implements Map
{

    zzmh zzagz;

    public zzme()
    {
    }

    private zzmh zzpx()
    {
        if (zzagz == null)
        {
            zzagz = new _cls1();
        }
        return zzagz;
    }

    public Set entrySet()
    {
        return zzpx().getEntrySet();
    }

    public Set keySet()
    {
        return zzpx().getKeySet();
    }

    public void putAll(Map map)
    {
        ensureCapacity(mSize + map.size());
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); put(entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

    }

    public Collection values()
    {
        return zzpx().getValues();
    }

    private class _cls1 extends zzmh
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

        _cls1()
        {
            zzagA = zzme.this;
            super();
        }
    }

}
