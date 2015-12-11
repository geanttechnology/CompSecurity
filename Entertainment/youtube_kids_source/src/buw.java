// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public final class buw
{

    private static Random b = new Random();
    final List a;

    private buw(List list)
    {
        a = Collections.unmodifiableList(list);
    }

    public static buw a(int i, List list)
    {
        ArrayList arraylist;
        b.a(list);
        arraylist = new ArrayList();
        for (int j = 0; j < list.size(); j++)
        {
            arraylist.add(Integer.valueOf(j));
        }

        if (i != 1) goto _L2; else goto _L1
_L1:
        if (b.nextBoolean())
        {
            Collections.reverse(arraylist);
        }
_L4:
        return new buw(arraylist);
_L2:
        if (i == 0)
        {
            Collections.shuffle(arraylist, b);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final boolean equals(Object obj)
    {
        if (obj == null || !getClass().equals(obj.getClass()))
        {
            return false;
        } else
        {
            obj = (buw)obj;
            return b.a(a, ((buw) (obj)).a);
        }
    }

}
