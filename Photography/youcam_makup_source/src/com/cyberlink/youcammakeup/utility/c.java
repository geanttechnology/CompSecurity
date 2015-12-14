// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;


public class c
{

    public static void a(int i, int j)
    {
        if (i < 0 || i >= j)
        {
            throw new IndexOutOfBoundsException((new StringBuilder()).append("Invalid index ").append(i).append(", size is ").append(j).toString());
        } else
        {
            return;
        }
    }

    public static int[] b(int i, int j)
    {
        int k = 0;
        boolean flag = false;
        int l = Math.abs(j - i) + 1;
        int ai[] = new int[l];
        if (j < i)
        {
            for (j = ((flag) ? 1 : 0); j < l; j++)
            {
                ai[j] = i - j;
            }

        } else
        {
            for (; k < l; k++)
            {
                ai[k] = i + k;
            }

        }
        return ai;
    }
}
