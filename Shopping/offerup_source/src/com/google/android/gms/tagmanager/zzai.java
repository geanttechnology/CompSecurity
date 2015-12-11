// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import java.util.Map;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzak, zzcp, zzdf

class zzai extends zzak
{

    private static final String ID;
    private final zzcp zzaVS;

    public zzai(zzcp zzcp1)
    {
        super(ID, new String[0]);
        zzaVS = zzcp1;
    }

    public boolean zzCo()
    {
        return false;
    }

    public com.google.android.gms.internal.zzag.zza zzI(Map map)
    {
        map = zzaVS.zzDw();
        if (map == null)
        {
            return zzdf.zzDX();
        } else
        {
            return zzdf.zzQ(map);
        }
    }

    static 
    {
        ID = zzad.zzbv.toString();
    }
}
