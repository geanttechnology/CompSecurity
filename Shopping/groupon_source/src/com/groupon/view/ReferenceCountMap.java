// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import java.util.WeakHashMap;

public class ReferenceCountMap
{

    private WeakHashMap counts;

    public ReferenceCountMap()
    {
        counts = new WeakHashMap();
    }

    public int decrement(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        if (obj != null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L3:
        this;
        JVM INSTR monitorexit ;
        return i;
_L2:
        Integer integer1 = (Integer)counts.get(obj);
        Integer integer;
        integer = integer1;
        if (integer1 != null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        integer = Integer.valueOf(1);
        integer = Integer.valueOf(integer.intValue() - 1);
        if (integer.intValue() != 0)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        counts.remove(obj);
_L4:
        i = integer.intValue();
          goto _L3
        counts.put(obj, integer);
          goto _L4
        obj;
        throw obj;
    }

    public int increment(Object obj)
    {
        int i = 0;
        this;
        JVM INSTR monitorenter ;
        if (obj != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return i;
_L2:
        Integer integer1 = (Integer)counts.get(obj);
        Integer integer;
        integer = integer1;
        if (integer1 != null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        integer = Integer.valueOf(0);
        integer = Integer.valueOf(integer.intValue() + 1);
        counts.put(obj, integer);
        i = integer.intValue();
        if (true) goto _L1; else goto _L3
_L3:
        obj;
        throw obj;
    }
}
