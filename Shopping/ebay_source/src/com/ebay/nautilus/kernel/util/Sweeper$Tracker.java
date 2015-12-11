// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import android.os.SystemClock;

// Referenced classes of package com.ebay.nautilus.kernel.util:
//            Sweeper

protected static final class prepExpire
{

    protected long expiresAt;
    protected ttl sweep;
    protected long ttl;

    protected long getExpiresAt()
    {
        return expiresAt;
    }

    protected boolean isExpired(long l)
    {
        return expiresAt < l;
    }

    protected void prepExpire(long l)
    {
        expiresAt = ttl + l;
    }

    protected ( , long l)
    {
        sweep = ;
        ttl = l;
        prepExpire(SystemClock.uptimeMillis());
    }
}
