// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;

public interface MemoryCache
{
    public static interface ResourceRemovedListener
    {

        public abstract void onResourceRemoved(Resource resource);
    }


    public abstract void clearMemory();

    public abstract Resource put(Key key, Resource resource);

    public abstract Resource remove(Key key);

    public abstract void setResourceRemovedListener(ResourceRemovedListener resourceremovedlistener);

    public abstract void trimMemory(int i);
}
