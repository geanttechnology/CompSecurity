// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.util.Pair;
import com.wishabi.flipp.content.c;
import com.wishabi.flipp.content.o;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public final class m
    implements Comparator
{

    private HashMap a;

    public m(HashMap hashmap)
    {
        a = hashmap;
    }

    private int a(Pair pair, Pair pair1)
    {
        this;
        JVM INSTR monitorenter ;
        Integer integer;
        Integer integer1;
        c c1;
        c c2;
        integer = (Integer)pair.first;
        integer1 = (Integer)pair1.first;
        c1 = (c)pair.second;
        c2 = (c)pair1.second;
        if (a != null) goto _L2; else goto _L1
_L1:
        int i = integer.compareTo(integer1);
_L22:
        this;
        JVM INSTR monitorexit ;
        return i;
_L2:
        pair = (ArrayList)a.get(Integer.valueOf(c1.a));
        pair1 = (ArrayList)a.get(Integer.valueOf(c2.a));
        if (pair == null) goto _L4; else goto _L3
_L3:
        if (pair.isEmpty()) goto _L4; else goto _L5
_L5:
        pair = (o)pair.get(0);
_L15:
        if (pair1 == null) goto _L7; else goto _L6
_L6:
        if (pair1.isEmpty()) goto _L7; else goto _L8
_L8:
        pair1 = (o)pair1.get(0);
_L14:
        if (pair != null || pair1 != null) goto _L10; else goto _L9
_L9:
        i = integer.compareTo(integer1);
        continue; /* Loop/switch isn't completed */
_L17:
        int j;
        i = c1.o;
        j = c2.o;
          goto _L11
_L18:
        pair = ((o) (pair)).k;
        pair1 = ((o) (pair1)).k;
        if (pair != null || pair1 != null) goto _L13; else goto _L12
_L12:
        i = integer.compareTo(integer1);
        continue; /* Loop/switch isn't completed */
_L20:
        if (pair.equals(pair1))
        {
            i = integer.compareTo(integer1);
            continue; /* Loop/switch isn't completed */
        }
        i = pair1.compareTo(pair);
        continue; /* Loop/switch isn't completed */
        pair;
        throw pair;
_L7:
        pair1 = null;
          goto _L14
_L4:
        pair = null;
          goto _L15
_L10:
        if (pair != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = 1;
        continue; /* Loop/switch isn't completed */
        if (pair1 != null) goto _L17; else goto _L16
_L16:
        i = -1;
        continue; /* Loop/switch isn't completed */
_L11:
        if (i < j)
        {
            i = -1;
            continue; /* Loop/switch isn't completed */
        }
        if (j < i)
        {
            i = 1;
            continue; /* Loop/switch isn't completed */
        }
          goto _L18
_L13:
        if (pair != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = 1;
        continue; /* Loop/switch isn't completed */
        if (pair1 != null) goto _L20; else goto _L19
_L19:
        i = -1;
        if (true) goto _L22; else goto _L21
_L21:
    }

    public final int compare(Object obj, Object obj1)
    {
        return a((Pair)obj, (Pair)obj1);
    }
}
