// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.measurement:
//            zze, zzg, zzf

public final class zzc
{

    private final zzf zzaKP;
    private boolean zzaKQ;
    private long zzaKR;
    private long zzaKS;
    private long zzaKT;
    private long zzaKU;
    private long zzaKV;
    private boolean zzaKW;
    private final Map zzaKX;
    private final List zzaKY;
    private final zzmn zzpW;

    zzc(zzc zzc1)
    {
        zzaKP = zzc1.zzaKP;
        zzpW = zzc1.zzpW;
        zzaKR = zzc1.zzaKR;
        zzaKS = zzc1.zzaKS;
        zzaKT = zzc1.zzaKT;
        zzaKU = zzc1.zzaKU;
        zzaKV = zzc1.zzaKV;
        zzaKY = new ArrayList(zzc1.zzaKY);
        zzaKX = new HashMap(zzc1.zzaKX.size());
        java.util.Map.Entry entry;
        zze zze1;
        for (zzc1 = zzc1.zzaKX.entrySet().iterator(); zzc1.hasNext(); zzaKX.put(entry.getKey(), zze1))
        {
            entry = (java.util.Map.Entry)zzc1.next();
            zze1 = zzf((Class)entry.getKey());
            ((zze)entry.getValue()).zza(zze1);
        }

    }

    zzc(zzf zzf1, zzmn zzmn1)
    {
        zzx.zzw(zzf1);
        zzx.zzw(zzmn1);
        zzaKP = zzf1;
        zzpW = zzmn1;
        zzaKU = 0x1b7740L;
        zzaKV = 0xb43e9400L;
        zzaKX = new HashMap();
        zzaKY = new ArrayList();
    }

    private static zze zzf(Class class1)
    {
        try
        {
            class1 = (zze)class1.newInstance();
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new IllegalArgumentException("dataType doesn't have default constructor", class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new IllegalArgumentException("dataType default constructor is not accessible", class1);
        }
        return class1;
    }

    public void zzL(long l)
    {
        zzaKS = l;
    }

    public void zzb(zze zze1)
    {
        zzx.zzw(zze1);
        Class class1 = zze1.getClass();
        if (class1.getSuperclass() != com/google/android/gms/measurement/zze)
        {
            throw new IllegalArgumentException();
        } else
        {
            zze1.zza(zze(class1));
            return;
        }
    }

    public zze zzd(Class class1)
    {
        return (zze)zzaKX.get(class1);
    }

    public zze zze(Class class1)
    {
        zze zze2 = (zze)zzaKX.get(class1);
        zze zze1 = zze2;
        if (zze2 == null)
        {
            zze1 = zzf(class1);
            zzaKX.put(class1, zze1);
        }
        return zze1;
    }

    public zzc zzye()
    {
        return new zzc(this);
    }

    public Collection zzyf()
    {
        return zzaKX.values();
    }

    public List zzyg()
    {
        return zzaKY;
    }

    public long zzyh()
    {
        return zzaKR;
    }

    public void zzyi()
    {
        zzym().zze(this);
    }

    public boolean zzyj()
    {
        return zzaKQ;
    }

    void zzyk()
    {
        zzaKT = zzpW.elapsedRealtime();
        if (zzaKS != 0L)
        {
            zzaKR = zzaKS;
        } else
        {
            zzaKR = zzpW.currentTimeMillis();
        }
        zzaKQ = true;
    }

    zzf zzyl()
    {
        return zzaKP;
    }

    zzg zzym()
    {
        return zzaKP.zzym();
    }

    boolean zzyn()
    {
        return zzaKW;
    }

    void zzyo()
    {
        zzaKW = true;
    }
}
