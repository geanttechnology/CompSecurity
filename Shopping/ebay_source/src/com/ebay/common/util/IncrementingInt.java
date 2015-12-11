// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.util;


public final class IncrementingInt
{

    private int value;

    public IncrementingInt()
    {
        value = 0;
    }

    public void increment()
    {
        value = value + 1;
    }

    public int intValue()
    {
        return value;
    }

    public String toString()
    {
        return String.valueOf(value);
    }
}
