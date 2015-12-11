// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch.cache;


// Referenced classes of package com.amazon.ansel.fetch.cache:
//            ResourceCacheListener, ResourceCache

public interface ResourceCacheFactory
{

    public abstract ResourceCache getCache(ResourceCacheListener resourcecachelistener);
}
