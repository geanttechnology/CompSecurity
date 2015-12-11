// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import java.util.UUID;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzai

public final class <init>
{

    private final String mName;
    private final long zzPG;
    final zzai zzPH;

    private void zzkU()
    {
        long l = zzPH.zzit().currentTimeMillis();
        android.content.ferences.Editor editor = zzai.zza(zzPH).edit();
        editor.remove(zzkZ());
        editor.remove(zzla());
        editor.putLong(zzkY(), l);
        editor.commit();
    }

    private long zzkV()
    {
        long l = zzkX();
        if (l == 0L)
        {
            return 0L;
        } else
        {
            return Math.abs(l - zzPH.zzit().currentTimeMillis());
        }
    }

    private long zzkX()
    {
        return zzai.zza(zzPH).getLong(zzkY(), 0L);
    }

    private String zzkY()
    {
        return (new StringBuilder()).append(mName).append(":start").toString();
    }

    private String zzkZ()
    {
        return (new StringBuilder()).append(mName).append(":count").toString();
    }

    public void zzbn(String s)
    {
        String s1;
        if (zzkX() == 0L)
        {
            zzkU();
        }
        s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        this;
        JVM INSTR monitorenter ;
        long l = zzai.zza(zzPH).getLong(zzkZ(), 0L);
        if (l > 0L)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        s = zzai.zza(zzPH).edit();
        s.putString(zzla(), s1);
        s.putLong(zzkZ(), 1L);
        s.apply();
        this;
        JVM INSTR monitorexit ;
        return;
        boolean flag;
        if ((UUID.randomUUID().getLeastSignificantBits() & 0x7fffffffffffffffL) < 0x7fffffffffffffffL / (l + 1L))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s = zzai.zza(zzPH).edit();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        s.putString(zzla(), s1);
        s.putLong(zzkZ(), l + 1L);
        s.apply();
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public Pair zzkW()
    {
        long l = zzkV();
        if (l >= zzPG)
        {
            if (l > zzPG * 2L)
            {
                zzkU();
                return null;
            }
            String s = zzai.zza(zzPH).getString(zzla(), null);
            l = zzai.zza(zzPH).getLong(zzkZ(), 0L);
            zzkU();
            if (s != null && l > 0L)
            {
                return new Pair(s, Long.valueOf(l));
            }
        }
        return null;
    }

    protected String zzla()
    {
        return (new StringBuilder()).append(mName).append(":value").toString();
    }

    private (zzai zzai1, String s, long l)
    {
        zzPH = zzai1;
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
        mName = s;
        zzPG = l;
    }

    zzPG(zzai zzai1, String s, long l, zzPG zzpg)
    {
        this(zzai1, s, l);
    }
}
