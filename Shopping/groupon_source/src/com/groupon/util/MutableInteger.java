// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;


public class MutableInteger
{

    private int value;

    public MutableInteger(int i)
    {
        value = i;
    }

    public int get()
    {
        return value;
    }

    public void increment()
    {
        value = value + 1;
    }

    public void set(int i)
    {
        value = i;
    }
}
