// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.util;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public final class a
{

    public static boolean a(Object aobj[])
    {
        return aobj == null || aobj.length == 0;
    }

    public static int[] a(List list)
    {
        int j = list.size();
        int ai[] = new int[j];
        for (int i = 0; i < j; i++)
        {
            ai[i] = ((Integer)list.get(i)).intValue();
        }

        return ai;
    }

    public static Object[] a(Object aobj[], Object aobj1[])
    {
        int i = aobj.length;
        int j = aobj1.length;
        Object aobj2[] = (Object[])(Object[])Array.newInstance(((Object) (aobj)).getClass().getComponentType(), i + j);
        System.arraycopy(((Object) (aobj)), 0, ((Object) (aobj2)), 0, i);
        System.arraycopy(((Object) (aobj1)), 0, ((Object) (aobj2)), i, j);
        return aobj2;
    }

    public static transient String[] a(String as[], String as1[])
    {
        if (a(((Object []) (as))) && a(((Object []) (as1))))
        {
            return null;
        }
        if (a(((Object []) (as))))
        {
            return (String[])Arrays.copyOf(as1, as1.length);
        }
        if (a(((Object []) (as1))))
        {
            return (String[])Arrays.copyOf(as, as.length);
        } else
        {
            String as2[] = new String[as.length + as1.length];
            System.arraycopy(as, 0, as2, 0, as.length);
            System.arraycopy(as1, 0, as2, as.length, as1.length);
            return as2;
        }
    }
}
