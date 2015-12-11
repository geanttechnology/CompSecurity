// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.cache;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.cache:
//            ICache

public abstract class Cache
    implements ICache
{

    protected String cacheName;
    protected int capacity;

    public Cache()
    {
        capacity = -1;
    }

    public abstract boolean isEmpty();

    public void setCacheName(String s)
    {
        cacheName = s;
    }

    public void setCapacity(int i)
    {
        capacity = i;
    }
}
