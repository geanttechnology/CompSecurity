// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.cache;

import com.android.internal.util.Predicate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

// Referenced classes of package com.facebook.imagepipeline.cache:
//            ValueDescriptor

public class CountingLruMap
{

    private final LinkedHashMap mMap = new LinkedHashMap();
    private int mSizeInBytes;
    private final ValueDescriptor mValueDescriptor;

    public CountingLruMap(ValueDescriptor valuedescriptor)
    {
        mSizeInBytes = 0;
        mValueDescriptor = valuedescriptor;
    }

    private int getValueSizeInBytes(Object obj)
    {
        if (obj == null)
        {
            return 0;
        } else
        {
            return mValueDescriptor.getSizeInBytes(obj);
        }
    }

    public ArrayList clear()
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        arraylist = new ArrayList(mMap.values());
        mMap.clear();
        mSizeInBytes = 0;
        this;
        JVM INSTR monitorexit ;
        return arraylist;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean contains(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mMap.containsKey(obj);
        this;
        JVM INSTR monitorexit ;
        return flag;
        obj;
        throw obj;
    }

    public Object get(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        obj = mMap.get(obj);
        this;
        JVM INSTR monitorexit ;
        return obj;
        obj;
        throw obj;
    }

    public int getCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = mMap.size();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public Object getFirstKey()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mMap.isEmpty();
        if (!flag) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return obj;
_L2:
        obj = mMap.keySet().iterator().next();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    ArrayList getKeys()
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist = new ArrayList(mMap.keySet());
        this;
        JVM INSTR monitorexit ;
        return arraylist;
        Exception exception;
        exception;
        throw exception;
    }

    public ArrayList getMatchingEntries(Predicate predicate)
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        Iterator iterator;
        arraylist = new ArrayList();
        iterator = mMap.entrySet().iterator();
_L3:
        java.util.Map.Entry entry;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_78;
        }
        entry = (java.util.Map.Entry)iterator.next();
        if (predicate == null) goto _L2; else goto _L1
_L1:
        if (!predicate.apply(entry.getKey())) goto _L3; else goto _L2
_L2:
        arraylist.add(entry);
          goto _L3
        predicate;
        throw predicate;
        this;
        JVM INSTR monitorexit ;
        return arraylist;
    }

    public int getSizeInBytes()
    {
        this;
        JVM INSTR monitorenter ;
        int i = mSizeInBytes;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    ArrayList getValues()
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist = new ArrayList(mMap.values());
        this;
        JVM INSTR monitorexit ;
        return arraylist;
        Exception exception;
        exception;
        throw exception;
    }

    public Object put(Object obj, Object obj1)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj2;
        obj2 = mMap.remove(obj);
        mSizeInBytes = mSizeInBytes - getValueSizeInBytes(obj2);
        mMap.put(obj, obj1);
        mSizeInBytes = mSizeInBytes + getValueSizeInBytes(obj1);
        this;
        JVM INSTR monitorexit ;
        return obj2;
        obj;
        throw obj;
    }

    public Object remove(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        obj = mMap.remove(obj);
        mSizeInBytes = mSizeInBytes - getValueSizeInBytes(obj);
        this;
        JVM INSTR monitorexit ;
        return obj;
        obj;
        throw obj;
    }

    public ArrayList removeAll(Predicate predicate)
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        Iterator iterator;
        arraylist = new ArrayList();
        iterator = mMap.entrySet().iterator();
_L3:
        java.util.Map.Entry entry;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_109;
        }
        entry = (java.util.Map.Entry)iterator.next();
        if (predicate == null) goto _L2; else goto _L1
_L1:
        if (!predicate.apply(entry.getKey())) goto _L3; else goto _L2
_L2:
        arraylist.add(entry.getValue());
        mSizeInBytes = mSizeInBytes - getValueSizeInBytes(entry.getValue());
        iterator.remove();
          goto _L3
        predicate;
        throw predicate;
        this;
        JVM INSTR monitorexit ;
        return arraylist;
    }
}
