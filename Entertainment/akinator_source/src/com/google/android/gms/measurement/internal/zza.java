// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzp

class zza
{

    final String zzaLK;
    final String zzaLL;
    final String zzaLM;
    final long zzaLN;
    final long zzaLO;
    final String zzaLl;

    zza(String s, String s1, String s2, String s3, long l, long l1)
    {
        zzx.zzcr(s);
        boolean flag;
        if (l >= 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzaa(flag);
        zzaLl = s;
        zzaLK = s1;
        s = s2;
        if (TextUtils.isEmpty(s2))
        {
            s = null;
        }
        zzaLL = s;
        zzaLM = s3;
        zzaLN = l;
        zzaLO = l1;
    }

    public zza zzG(String s, String s1)
    {
        return new zza(zzaLl, s, zzaLL, s1, zzaLN, zzaLO);
    }

    public zza zza(zzp zzp1, long l)
    {
        zzx.zzw(zzp1);
        long l2 = zzaLN + 1L;
        long l1 = l2;
        if (l2 > 0x7fffffffL)
        {
            zzp1.zzzL().zzec("Bundle index overflow");
            l1 = 0L;
        }
        return new zza(zzaLl, zzaLK, zzaLL, zzaLM, l1, l);
    }

    public zza zzdY(String s)
    {
        return new zza(zzaLl, zzaLK, s, zzaLM, zzaLN, zzaLO);
    }
}
