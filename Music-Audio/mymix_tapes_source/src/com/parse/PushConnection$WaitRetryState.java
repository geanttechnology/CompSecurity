// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.Set;

// Referenced classes of package com.parse:
//            PushConnection

public class delay extends delay
{

    private long delay;
    final PushConnection this$0;

    public long getDelay()
    {
        return delay;
    }

    public delay runState()
    {
        PushConnection.access$300(PushConnection.this).Events(new Events[] {
            Events
        });
        long l = delay;
        if (!PushConnection.ENABLE_RETRY_DELAY)
        {
            l = 0L;
        }
        Set set = PushConnection.access$300(PushConnection.this).wait(l, new wait[] {
            wait, wait
        });
        if (set.contains(wait))
        {
            return new nit>(PushConnection.this);
        }
        if (set.contains(this._fld0))
        {
            return new nit>(PushConnection.this, 0L);
        } else
        {
            return new nit>(PushConnection.this, delay);
        }
    }

    public (long l)
    {
        this$0 = PushConnection.this;
        super(PushConnection.this);
        delay = l;
    }
}
