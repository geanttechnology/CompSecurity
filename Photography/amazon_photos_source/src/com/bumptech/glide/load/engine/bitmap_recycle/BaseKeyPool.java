// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.util.Util;
import java.util.Queue;

// Referenced classes of package com.bumptech.glide.load.engine.bitmap_recycle:
//            Poolable

abstract class BaseKeyPool
{

    private final Queue keyPool = Util.createQueue(20);

    BaseKeyPool()
    {
    }

    protected abstract Poolable create();

    protected Poolable get()
    {
        Poolable poolable1 = (Poolable)keyPool.poll();
        Poolable poolable = poolable1;
        if (poolable1 == null)
        {
            poolable = create();
        }
        return poolable;
    }

    public void offer(Poolable poolable)
    {
        if (keyPool.size() < 20)
        {
            keyPool.offer(poolable);
        }
    }
}
