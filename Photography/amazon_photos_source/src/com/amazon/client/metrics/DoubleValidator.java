// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;


public class DoubleValidator
{

    public static void validateDouble(double d)
    {
        if (Double.isNaN(d) || Double.isInfinite(d))
        {
            throw new IllegalArgumentException(String.format("Invalid value %f.  Cannot be NaN or infinite.", new Object[] {
                Double.valueOf(d)
            }));
        } else
        {
            return;
        }
    }
}
