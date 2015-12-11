// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import java.util.Map;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzak, zzdf

class zzbi extends zzak
{

    private static final String ID;
    private static final String zzaWU;

    public zzbi()
    {
        super(ID, new String[] {
            zzaWU
        });
    }

    public boolean zzCo()
    {
        return true;
    }

    public com.google.android.gms.internal.zzag.zza zzI(Map map)
    {
        return zzdf.zzQ(zzdf.zzg((com.google.android.gms.internal.zzag.zza)map.get(zzaWU)).toLowerCase());
    }

    static 
    {
        ID = zzad.zzbT.toString();
        zzaWU = zzae.zzdz.toString();
    }
}
