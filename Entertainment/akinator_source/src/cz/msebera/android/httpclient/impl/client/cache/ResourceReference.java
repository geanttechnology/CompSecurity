// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.cache.Resource;
import cz.msebera.android.httpclient.util.Args;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

class ResourceReference extends PhantomReference
{

    private final Resource resource;

    public ResourceReference(HttpCacheEntry httpcacheentry, ReferenceQueue referencequeue)
    {
        super(httpcacheentry, referencequeue);
        Args.notNull(httpcacheentry.getResource(), "Resource");
        resource = httpcacheentry.getResource();
    }

    public boolean equals(Object obj)
    {
        return resource.equals(obj);
    }

    public Resource getResource()
    {
        return resource;
    }

    public int hashCode()
    {
        return resource.hashCode();
    }
}
