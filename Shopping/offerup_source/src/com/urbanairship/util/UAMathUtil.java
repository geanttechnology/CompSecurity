// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.util;


public abstract class UAMathUtil
{

    public UAMathUtil()
    {
    }

    public static int constrain(int i, int j, int k)
    {
        if (i > k)
        {
            return k;
        }
        if (i < j)
        {
            return j;
        } else
        {
            return i;
        }
    }
}
