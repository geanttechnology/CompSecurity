// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;


public class BitFlagTracker
{

    private long active;

    public BitFlagTracker()
    {
    }

    public BitFlagTracker(long l)
    {
        setActive(l);
    }

    public void addActiveMask(long l)
    {
        active = active | l;
    }

    public boolean clearActiveMask(long l)
    {
        active = active & (-1L ^ l);
        return isAllClear();
    }

    public boolean isAllClear()
    {
        return active == 0L;
    }

    public boolean isOnlyAtLeastOneBitSet(long l)
    {
        while ((active & (-1L ^ l)) != 0L || (active & l) == 0L) 
        {
            return false;
        }
        return true;
    }

    public boolean isOnlyMaskSet(long l)
    {
        return active == l;
    }

    public void setActive(long l)
    {
        active = l;
    }
}
