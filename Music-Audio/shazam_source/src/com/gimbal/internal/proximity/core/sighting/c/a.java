// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.sighting.c;

import com.gimbal.internal.c.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class com.gimbal.internal.proximity.core.sighting.c.a
{
    public final class a
    {

        public int a;
        public long b;

        public a(int i, long l)
        {
            a = i;
            b = l;
        }
    }


    private int a;
    private Integer b;
    private List c;
    private List d;
    private c e;
    private com.gimbal.internal.persistance.a f;

    public com.gimbal.internal.proximity.core.sighting.c.a(c c1, com.gimbal.internal.persistance.a a1)
    {
        e = c1;
        f = a1;
        a = 0;
        c = new ArrayList();
        d = new ArrayList();
    }

    public final Integer a(int i)
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        Object obj;
        int j;
        j = i * 1000;
        Integer integer;
        if (j >= -25000)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i == 0) goto _L2; else goto _L1
_L1:
        integer = b;
        obj = integer;
        if (integer == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        i = integer.intValue() / 1000;
        obj = Integer.valueOf(i);
_L11:
        this;
        JVM INSTR monitorexit ;
        return ((Integer) (obj));
_L2:
        long l1;
        l1 = System.currentTimeMillis();
        if (c.size() > 0)
        {
            obj = (a)c.get(c.size() - 1);
            if (System.currentTimeMillis() - ((a) (obj)).b < 2000L)
            {
                break MISSING_BLOCK_LABEL_217;
            }
            b = null;
            d.clear();
            c.clear();
            a = 0;
        }
_L4:
        obj = new a(j, l1);
        c.add(obj);
        if (c.size() == 1)
        {
            d.add(Integer.valueOf(j));
            b = Integer.valueOf(j);
            obj = Integer.valueOf(j / 1000);
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_285;
        if (c.size() >= f.b())
        {
            c.remove(0);
        }
        if (d.size() >= f.b())
        {
            d.remove(0);
        }
        if (true) goto _L4; else goto _L3
_L3:
        obj;
        throw obj;
        if (Math.abs(b.intValue() - j) >= 5000) goto _L6; else goto _L5
_L5:
        d.add(Integer.valueOf(j));
        b = Integer.valueOf(j);
        a = 0;
_L8:
        obj = d.iterator();
        i = ((flag) ? 1 : 0);
        while (((Iterator) (obj)).hasNext()) 
        {
            i += ((Integer)((Iterator) (obj)).next()).intValue();
        }
        break MISSING_BLOCK_LABEL_512;
_L6:
        int l;
        a = a + 1;
        if (a < 3)
        {
            break MISSING_BLOCK_LABEL_495;
        }
        a = 0;
        b = Integer.valueOf(j);
        d.add(Integer.valueOf(j));
        l = c.size() - 1;
        int k = l - 3;
        i = k;
        if (k < 0)
        {
            i = 0;
        }
_L9:
        if (i > l) goto _L8; else goto _L7
_L7:
        d.set(i, Integer.valueOf(((a)c.get(i)).a));
        i++;
          goto _L9
        d.add(b);
          goto _L8
        i = i / d.size() / 1000;
        obj = Integer.valueOf(i);
        if (true) goto _L11; else goto _L10
_L10:
    }
}
