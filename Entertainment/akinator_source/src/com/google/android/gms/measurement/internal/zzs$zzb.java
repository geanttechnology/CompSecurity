// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import java.util.UUID;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzs

public final class <init>
{

    private final long zzPG;
    final zzs zzaNr;
    final String zzaNs;
    private final String zzaNt;
    private final String zzaNu;

    private void zzkU()
    {
        zzaNr.zzis();
        long l = zzaNr.zzit().currentTimeMillis();
        android.content.eferences.Editor editor = zzs.zza(zzaNr).edit();
        editor.remove(zzaNt);
        editor.remove(zzaNu);
        editor.putLong(zzaNs, l);
        editor.apply();
    }

    private long zzkV()
    {
        zzaNr.zzis();
        long l = zzkX();
        if (l == 0L)
        {
            zzkU();
            return 0L;
        } else
        {
            return Math.abs(l - zzaNr.zzit().currentTimeMillis());
        }
    }

    private long zzkX()
    {
        return zzs.zzb(zzaNr).getLong(zzaNs, 0L);
    }

    public void zzbn(String s)
    {
        zzaNr.zzis();
        if (zzkX() == 0L)
        {
            zzkU();
        }
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        long l = zzs.zza(zzaNr).getLong(zzaNt, 0L);
        if (l <= 0L)
        {
            s = zzs.zza(zzaNr).edit();
            s.putString(zzaNu, s1);
            s.putLong(zzaNt, 1L);
            s.apply();
            return;
        }
        boolean flag;
        if ((UUID.randomUUID().getLeastSignificantBits() & 0x7fffffffffffffffL) < 0x7fffffffffffffffL / (l + 1L))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s = zzs.zza(zzaNr).edit();
        if (flag)
        {
            s.putString(zzaNu, s1);
        }
        s.putLong(zzaNt, l + 1L);
        s.apply();
    }

    public Pair zzkW()
    {
        zzaNr.zzis();
        long l = zzkV();
        if (l < zzPG)
        {
            return null;
        }
        if (l > zzPG * 2L)
        {
            zzkU();
            return null;
        }
        String s = zzs.zzb(zzaNr).getString(zzaNu, null);
        l = zzs.zzb(zzaNr).getLong(zzaNt, 0L);
        zzkU();
        if (s == null || l <= 0L)
        {
            return zzs.zzaNg;
        } else
        {
            return new Pair(s, Long.valueOf(l));
        }
    }

    private _cls9(zzs zzs1, String s, long l)
    {
        zzaNr = zzs1;
        super();
        zzx.zzcr(s);
        boolean flag;
        if (l > 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzaa(flag);
        zzaNs = (new StringBuilder()).append(s).append(":start").toString();
        zzaNt = (new StringBuilder()).append(s).append(":count").toString();
        zzaNu = (new StringBuilder()).append(s).append(":value").toString();
        zzPG = l;
    }

    zzPG(zzs zzs1, String s, long l, zzPG zzpg)
    {
        this(zzs1, s, l);
    }
}
