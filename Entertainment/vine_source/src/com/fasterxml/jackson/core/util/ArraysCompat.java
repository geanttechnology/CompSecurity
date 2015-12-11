// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.core.util;

import java.lang.reflect.Array;

public class ArraysCompat
{

    public ArraysCompat()
    {
    }

    public static char[] copyOf(char ac[], int i)
    {
        return copyOfRange(ac, 0, i);
    }

    public static int[] copyOf(int ai[], int i)
    {
        return copyOfRange(ai, 0, i);
    }

    public static Object[] copyOf(Object aobj[], int i)
    {
        return copyOfRange(aobj, 0, i);
    }

    public static char[] copyOfRange(char ac[], int i, int j)
    {
        int k = ac.length;
        j -= i;
        k = Math.min(j, k - i);
        char ac1[] = new char[j];
        System.arraycopy(ac, i, ac1, 0, k);
        return ac1;
    }

    public static int[] copyOfRange(int ai[], int i, int j)
    {
        int k = ai.length;
        j -= i;
        k = Math.min(j, k - i);
        int ai1[] = new int[j];
        System.arraycopy(ai, i, ai1, 0, k);
        return ai1;
    }

    public static Object[] copyOfRange(Object aobj[], int i, int j)
    {
        int k = aobj.length;
        j -= i;
        k = Math.min(j, k - i);
        Object aobj1[] = (Object[])(Object[])Array.newInstance(((Object) (aobj)).getClass().getComponentType(), j);
        System.arraycopy(((Object) (aobj)), i, ((Object) (aobj1)), 0, k);
        return aobj1;
    }
}
