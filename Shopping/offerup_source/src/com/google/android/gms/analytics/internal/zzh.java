// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzh
{

    private final long zzMY;
    private final String zzMZ;
    private final String zzMj;
    private final boolean zzNa;
    private long zzNb;
    private final Map zzvS;

    public zzh(long l, String s, String s1, boolean flag, long l1, 
            Map map)
    {
        zzx.zzcr(s);
        zzx.zzcr(s1);
        zzMY = l;
        zzMj = s;
        zzMZ = s1;
        zzNa = flag;
        zzNb = l1;
        if (map != null)
        {
            zzvS = new HashMap(map);
            return;
        } else
        {
            zzvS = Collections.emptyMap();
            return;
        }
    }

    public String getClientId()
    {
        return zzMj;
    }

    public long zziM()
    {
        return zzMY;
    }

    public String zziN()
    {
        return zzMZ;
    }

    public boolean zziO()
    {
        return zzNa;
    }

    public long zziP()
    {
        return zzNb;
    }

    public Map zzn()
    {
        return zzvS;
    }

    public void zzn(long l)
    {
        zzNb = l;
    }
}
