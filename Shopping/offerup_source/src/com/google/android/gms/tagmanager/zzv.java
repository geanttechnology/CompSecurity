// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import java.util.Map;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzak, zzdf, DataLayer

class zzv extends zzak
{

    private static final String ID;
    private static final String NAME;
    private static final String zzaWE;
    private final DataLayer zzaVR;

    public zzv(DataLayer datalayer)
    {
        super(ID, new String[] {
            NAME
        });
        zzaVR = datalayer;
    }

    public boolean zzCo()
    {
        return false;
    }

    public com.google.android.gms.internal.zzag.zza zzI(Map map)
    {
        Object obj = zzaVR.get(zzdf.zzg((com.google.android.gms.internal.zzag.zza)map.get(NAME)));
        if (obj == null)
        {
            map = (com.google.android.gms.internal.zzag.zza)map.get(zzaWE);
            if (map != null)
            {
                return map;
            } else
            {
                return zzdf.zzDX();
            }
        } else
        {
            return zzdf.zzQ(obj);
        }
    }

    static 
    {
        ID = zzad.zzbn.toString();
        NAME = zzae.zzfR.toString();
        zzaWE = zzae.zzeC.toString();
    }
}
