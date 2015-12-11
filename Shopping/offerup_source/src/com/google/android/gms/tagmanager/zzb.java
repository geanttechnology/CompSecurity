// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzad;
import java.util.Map;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzak, zza, zzdf

class zzb extends zzak
{

    private static final String ID;
    private final zza zzaVG;

    public zzb(Context context)
    {
        this(zza.zzaN(context));
    }

    zzb(zza zza1)
    {
        super(ID, new String[0]);
        zzaVG = zza1;
    }

    public boolean zzCo()
    {
        return false;
    }

    public com.google.android.gms.internal.zzag.zza zzI(Map map)
    {
        map = zzaVG.zzCk();
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
        ID = zzad.zzbf.toString();
    }
}
