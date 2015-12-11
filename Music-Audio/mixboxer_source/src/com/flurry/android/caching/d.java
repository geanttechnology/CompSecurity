// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.caching;

import java.util.LinkedHashMap;

final class d
{

    d()
    {
    }

    public static LinkedHashMap a(int i, long l)
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        i = 0;
        while (i < 7) 
        {
            long l1;
            if (i == 0)
            {
                l1 = 0L;
            } else
            {
                l1 = l;
            }
            linkedhashmap.put(Integer.valueOf(i), Long.valueOf(l1));
            i++;
        }
        return linkedhashmap;
    }
}
