// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.List;

public final class bc
{

    public static void a(List list, int i)
    {
        if (i < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        if (i > 0)
        {
            int k = list.size();
            if (i > k)
            {
                throw new IndexOutOfBoundsException();
            }
            int j = i;
            if (i == k)
            {
                list.clear();
            } else
            {
                while (j > 0) 
                {
                    list.remove(0);
                    j--;
                }
            }
        }
    }
}
