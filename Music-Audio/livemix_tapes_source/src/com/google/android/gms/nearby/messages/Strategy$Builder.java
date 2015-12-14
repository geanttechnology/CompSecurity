// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.nearby.messages:
//            Strategy

public static class zzaJP
{

    private int zzaJM;
    private int zzaJN;
    private int zzaJP;
    private int zzaJQ;

    public Strategy build()
    {
        if (zzaJP == 2)
        {
            if (zzaJQ != 3)
            {
                throw new IllegalStateException("Discovery mode must be DISCOVERY_MODE_DEFAULT.");
            }
            if (zzaJN == 1)
            {
                throw new IllegalStateException("Cannot set EARSHOT with BLE only mode.");
            }
        }
        return new Strategy(2, 0, zzaJM, zzaJN, false, zzaJP, zzaJQ);
    }

    public zzaJQ setDiscoveryMode(int i)
    {
        zzaJQ = i;
        return this;
    }

    public zzaJQ setDistanceType(int i)
    {
        zzaJN = i;
        return this;
    }

    public zzaJN setTtlSeconds(int i)
    {
        boolean flag;
        if (i == 0x7fffffff || i > 0 && i <= 0x15180)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "ttlSeconds(%d) must either be TTL_SECONDS_INFINITE, or it must be between 1 and TTL_SECONDS_MAX(%d) inclusive", new Object[] {
            Integer.valueOf(i), Integer.valueOf(0x15180)
        });
        zzaJM = i;
        return this;
    }

    public zzaJM zzim(int i)
    {
        zzaJP = i;
        return this;
    }

    public ()
    {
        zzaJQ = 3;
        zzaJM = 300;
        zzaJN = 0;
        zzaJP = 1;
    }
}
