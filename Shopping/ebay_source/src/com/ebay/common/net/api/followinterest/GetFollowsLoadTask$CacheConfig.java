// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;


// Referenced classes of package com.ebay.common.net.api.followinterest:
//            GetFollowsLoadTask

public static abstract class 
    implements com.ebay.nautilus.kernel.cachemanager.
{

    public abstract boolean enablePersistence();

    public boolean equals(Object obj)
    {
        if (obj instanceof )
        {
            if (getMemoryLimit() == ((getMemoryLimit) (obj = (getMemoryLimit)obj)).getMemoryLimit() && getFlatMemoryLimit() == ((getFlatMemoryLimit) (obj)).getFlatMemoryLimit() && getDiskLimit() == ((getDiskLimit) (obj)).getDiskLimit() && getMaxTtl() == ((getMaxTtl) (obj)).getMaxTtl() && enablePersistence() == ((enablePersistence) (obj)).enablePersistence())
            {
                return true;
            }
        }
        return false;
    }

    public long getDiskLimit()
    {
        return !enablePersistence() ? 0L : 1L;
    }

    public int getFlatMemoryLimit()
    {
        return 1;
    }

    public abstract long getMaxTtl();

    public int getMemoryLimit()
    {
        return 1;
    }

    public int hashCode()
    {
        int j = getMemoryLimit();
        int k = getFlatMemoryLimit();
        int l = (int)getDiskLimit();
        int i1 = (int)getMaxTtl();
        int i;
        if (enablePersistence())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        return (((j * 31 + k) * 31 + l) * 31 + i1) * 31 + i;
    }

    public ()
    {
    }
}
