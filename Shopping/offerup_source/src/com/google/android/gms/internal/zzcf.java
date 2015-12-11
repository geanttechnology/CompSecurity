// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzce, zzcc, zzcg

public class zzcf
{

    private final zzcg zzoo;
    private final Map zzvQ = new HashMap();

    public zzcf(zzcg zzcg)
    {
        zzoo = zzcg;
    }

    public void zza(String s, zzce zzce1)
    {
        zzvQ.put(s, zzce1);
    }

    public void zza(String s, String s1, long l)
    {
        zzcc.zza(zzoo, (zzce)zzvQ.get(s1), l, new String[] {
            s
        });
        zzvQ.put(s, zzcc.zza(zzoo, l));
    }

    public zzcg zzdm()
    {
        return zzoo;
    }
}
