// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.ebay.nautilus.kernel.util:
//            TimedCache

private static final class setExpiration
{

    private static AtomicLong idGen = new AtomicLong(1L);
    protected final long creationId;
    protected long expiresAt;
    protected final Object key;
    protected final Object value;

    public long expiresIn(long l)
    {
        return expiresAt - l;
    }

    public boolean isExpired(long l)
    {
        return expiresIn(l) < 0L;
    }

    protected void setExpiration(long l, long l1)
    {
        expiresAt = l + l1;
    }


    protected _cls9(long l)
    {
        key = null;
        value = null;
        expiresAt = l - 1L;
        creationId = 0x7fffffffffffffffL;
    }

    protected creationId(Object obj, Object obj1, long l, long l1)
    {
        key = obj;
        value = obj1;
        creationId = idGen.incrementAndGet();
        setExpiration(l, l1);
    }
}
