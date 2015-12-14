// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import android.os.Looper;
import com.bumptech.glide.load.Key;

// Referenced classes of package com.bumptech.glide.load.engine:
//            Resource

class EngineResource
    implements Resource
{
    static interface ResourceListener
    {

        public abstract void onResourceReleased(Key key1, EngineResource engineresource);
    }


    private int acquired;
    private final boolean isCacheable;
    private boolean isRecycled;
    private Key key;
    private ResourceListener listener;
    private final Resource resource;

    EngineResource(Resource resource1, boolean flag)
    {
        if (resource1 == null)
        {
            throw new NullPointerException("Wrapped resource must not be null");
        } else
        {
            resource = resource1;
            isCacheable = flag;
            return;
        }
    }

    void acquire()
    {
        if (isRecycled)
        {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        if (!Looper.getMainLooper().equals(Looper.myLooper()))
        {
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        } else
        {
            acquired = acquired + 1;
            return;
        }
    }

    public Object get()
    {
        return resource.get();
    }

    public int getSize()
    {
        return resource.getSize();
    }

    boolean isCacheable()
    {
        return isCacheable;
    }

    public void recycle()
    {
        if (acquired > 0)
        {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (isRecycled)
        {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        } else
        {
            isRecycled = true;
            resource.recycle();
            return;
        }
    }

    void release()
    {
        if (acquired <= 0)
        {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        }
        if (!Looper.getMainLooper().equals(Looper.myLooper()))
        {
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
        int i = acquired - 1;
        acquired = i;
        if (i == 0)
        {
            listener.onResourceReleased(key, this);
        }
    }

    void setResourceListener(Key key1, ResourceListener resourcelistener)
    {
        key = key1;
        listener = resourcelistener;
    }
}
