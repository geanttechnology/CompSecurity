// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzae;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzak, zzdf

public abstract class zzca extends zzak
{

    private static final String zzaWU;
    private static final String zzaXS;

    public zzca(String s)
    {
        super(s, new String[] {
            zzaWU, zzaXS
        });
    }

    public volatile String zzCT()
    {
        return super.zzCT();
    }

    public volatile Set zzCU()
    {
        return super.zzCU();
    }

    public boolean zzCo()
    {
        return true;
    }

    public com.google.android.gms.internal.zzag.zza zzI(Map map)
    {
        for (Iterator iterator = map.values().iterator(); iterator.hasNext();)
        {
            if ((com.google.android.gms.internal.zzag.zza)iterator.next() == zzdf.zzDX())
            {
                return zzdf.zzQ(Boolean.valueOf(false));
            }
        }

        com.google.android.gms.internal.zzag.zza zza1 = (com.google.android.gms.internal.zzag.zza)map.get(zzaWU);
        com.google.android.gms.internal.zzag.zza zza2 = (com.google.android.gms.internal.zzag.zza)map.get(zzaXS);
        boolean flag;
        if (zza1 == null || zza2 == null)
        {
            flag = false;
        } else
        {
            flag = zza(zza1, zza2, map);
        }
        return zzdf.zzQ(Boolean.valueOf(flag));
    }

    protected abstract boolean zza(com.google.android.gms.internal.zzag.zza zza1, com.google.android.gms.internal.zzag.zza zza2, Map map);

    static 
    {
        zzaWU = zzae.zzdz.toString();
        zzaXS = zzae.zzdA.toString();
    }
}
