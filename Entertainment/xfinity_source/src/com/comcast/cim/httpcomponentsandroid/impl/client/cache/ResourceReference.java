// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.client.cache;

import com.comcast.cim.httpcomponentsandroid.client.cache.HttpCacheEntry;
import com.comcast.cim.httpcomponentsandroid.client.cache.Resource;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

class ResourceReference extends PhantomReference
{

    private final Resource resource;

    public ResourceReference(HttpCacheEntry httpcacheentry, ReferenceQueue referencequeue)
    {
        super(httpcacheentry, referencequeue);
        if (httpcacheentry.getResource() == null)
        {
            throw new IllegalArgumentException("Resource may not be null");
        } else
        {
            resource = httpcacheentry.getResource();
            return;
        }
    }

    public boolean equals(Object obj)
    {
        return resource.equals(obj);
    }

    public int hashCode()
    {
        return resource.hashCode();
    }
}
