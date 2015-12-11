// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.graphics.Point;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class cb
{

    private static final List a = a();
    private static final SparseArray b = b();

    public static int a(Point point)
    {
        Iterator iterator;
        if (point == null)
        {
            return -1;
        }
        iterator = a.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Integer integer;
        Point point1;
        integer = (Integer)iterator.next();
        point1 = a(integer.intValue());
        if (point1 == null || point.x < point1.x || point.y < point1.y) goto _L4; else goto _L3
_L3:
        int i = integer.intValue();
_L6:
        return i;
_L2:
        i = -1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static Point a(int i)
    {
        return (Point)b.get(i);
    }

    private static List a()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(Integer.valueOf(4));
        arraylist.add(Integer.valueOf(3));
        arraylist.add(Integer.valueOf(1));
        arraylist.add(Integer.valueOf(2));
        return Collections.unmodifiableList(arraylist);
    }

    private static SparseArray b()
    {
        SparseArray sparsearray = new SparseArray();
        sparsearray.put(4, new Point(728, 90));
        sparsearray.put(3, new Point(480, 60));
        sparsearray.put(1, new Point(320, 50));
        sparsearray.put(2, new Point(300, 250));
        return sparsearray;
    }

}
