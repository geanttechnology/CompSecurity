// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import java.lang.ref.ReferenceQueue;
import java.util.Map;

// Referenced classes of package com.bumptech.glide.load.engine:
//            Engine

private static class queue
    implements android.os.RefQueueIdleHandler
{

    private final Map activeResources;
    private final ReferenceQueue queue;

    public boolean queueIdle()
    {
        e e = (e)queue.poll();
        if (e != null)
        {
            activeResources.remove(e.access._mth000(e));
        }
        return true;
    }

    public e(Map map, ReferenceQueue referencequeue)
    {
        activeResources = map;
        queue = referencequeue;
    }
}
