// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import java.util.Comparator;

// Referenced classes of package com.ebay.nautilus.kernel.util:
//            TimedCache

class this._cls0
    implements Comparator
{

    final TimedCache this$0;

    public int compare(cheEntry cheentry, cheEntry cheentry1)
    {
        int i;
        if (cheentry == cheentry1)
        {
            i = 0;
        } else
        {
            int j = TimedCache.access$000(TimedCache.this, cheentry.expiresAt, cheentry1.expiresAt);
            i = j;
            if (j == 0)
            {
                return TimedCache.access$000(TimedCache.this, cheentry.creationId, cheentry1.creationId);
            }
        }
        return i;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((cheEntry)obj, (cheEntry)obj1);
    }

    cheEntry()
    {
        this$0 = TimedCache.this;
        super();
    }
}
