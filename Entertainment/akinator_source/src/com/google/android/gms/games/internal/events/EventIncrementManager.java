// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.events;

import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.google.android.gms.games.internal.events:
//            EventIncrementCache

public abstract class EventIncrementManager
{

    private final AtomicReference zzazh = new AtomicReference();

    public EventIncrementManager()
    {
    }

    public void flush()
    {
        EventIncrementCache eventincrementcache = (EventIncrementCache)zzazh.get();
        if (eventincrementcache != null)
        {
            eventincrementcache.flush();
        }
    }

    public void zzp(String s, int i)
    {
        EventIncrementCache eventincrementcache1 = (EventIncrementCache)zzazh.get();
        EventIncrementCache eventincrementcache = eventincrementcache1;
        if (eventincrementcache1 == null)
        {
            EventIncrementCache eventincrementcache2 = zzuU();
            eventincrementcache = eventincrementcache2;
            if (!zzazh.compareAndSet(null, eventincrementcache2))
            {
                eventincrementcache = (EventIncrementCache)zzazh.get();
            }
        }
        eventincrementcache.zzw(s, i);
    }

    protected abstract EventIncrementCache zzuU();
}
