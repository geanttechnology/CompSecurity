// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.LruCache;

// Referenced classes of package com.bumptech.glide.load.engine.cache:
//            MemoryCache

public class LruResourceCache extends LruCache
    implements MemoryCache
{

    private MemoryCache.ResourceRemovedListener listener;

    public LruResourceCache(int i)
    {
        super(i);
    }

    protected int getSize(Resource resource)
    {
        return resource.getSize();
    }

    protected volatile int getSize(Object obj)
    {
        return getSize((Resource)obj);
    }

    protected void onItemEvicted(Key key, Resource resource)
    {
        if (listener != null)
        {
            listener.onResourceRemoved(resource);
        }
    }

    protected volatile void onItemEvicted(Object obj, Object obj1)
    {
        onItemEvicted((Key)obj, (Resource)obj1);
    }

    public volatile Resource put(Key key, Resource resource)
    {
        return (Resource)super.put(key, resource);
    }

    public volatile Resource remove(Key key)
    {
        return (Resource)super.remove(key);
    }

    public void setResourceRemovedListener(MemoryCache.ResourceRemovedListener resourceremovedlistener)
    {
        listener = resourceremovedlistener;
    }

    public void trimMemory(int i)
    {
        if (i >= 60)
        {
            clearMemory();
        } else
        if (i >= 40)
        {
            trimToSize(getCurrentSize() / 2);
            return;
        }
    }
}
