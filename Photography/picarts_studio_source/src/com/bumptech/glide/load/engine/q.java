// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import java.lang.ref.ReferenceQueue;
import java.util.Map;

// Referenced classes of package com.bumptech.glide.load.engine:
//            r

final class q
    implements android.os.MessageQueue.IdleHandler
{

    private final Map a;
    private final ReferenceQueue b;

    public q(Map map, ReferenceQueue referencequeue)
    {
        a = map;
        b = referencequeue;
    }

    public final boolean queueIdle()
    {
        r r1 = (r)b.poll();
        if (r1 != null)
        {
            a.remove(r.a(r1));
        }
        return true;
    }
}
