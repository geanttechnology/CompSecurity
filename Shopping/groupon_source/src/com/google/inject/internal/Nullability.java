// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import java.lang.annotation.Annotation;

public class Nullability
{

    private Nullability()
    {
    }

    public static boolean allowsNull(Annotation aannotation[])
    {
        boolean flag1 = false;
        int j = aannotation.length;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < j)
                {
                    if (!"Nullable".equals(aannotation[i].annotationType().getSimpleName()))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
    }
}
