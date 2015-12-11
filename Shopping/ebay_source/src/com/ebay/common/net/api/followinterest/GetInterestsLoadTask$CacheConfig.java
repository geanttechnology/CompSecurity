// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;


// Referenced classes of package com.ebay.common.net.api.followinterest:
//            GetInterestsLoadTask

public static abstract class 
    implements com.ebay.nautilus.kernel.cachemanager.
{

    public boolean enablePersistence()
    {
        return true;
    }

    public long getDiskLimit()
    {
        if (enablePersistence())
        {
            return (long)getMemoryLimit();
        } else
        {
            return 0L;
        }
    }

    public int getFlatMemoryLimit()
    {
        return 0;
    }

    public long getMaxTtl()
    {
        return 0x9a7ec800L;
    }

    public int getMemoryLimit()
    {
        return 200;
    }

    public ()
    {
    }
}
