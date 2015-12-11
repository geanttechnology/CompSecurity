// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class ArrayUtil
{

    private ArrayUtil()
    {
    }

    public static transient Set asSet(Object aobj[])
    {
        HashSet hashset = new HashSet();
        hashset.addAll(Arrays.asList(aobj));
        return hashset;
    }

    public static int[] copyOf(int ai[], int i)
    {
        int ai1[] = new int[i];
        int j = Math.min(i, ai.length);
        for (i = 0; i < j; i++)
        {
            ai1[i] = ai[i];
        }

        return ai1;
    }
}
