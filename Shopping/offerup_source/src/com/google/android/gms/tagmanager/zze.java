// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import java.util.Map;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzak, zzdf, zzax

class zze extends zzak
{

    private static final String ID;
    private static final String zzaVH;
    private static final String zzaVI;
    private final Context context;

    public zze(Context context1)
    {
        super(ID, new String[] {
            zzaVI
        });
        context = context1;
    }

    public boolean zzCo()
    {
        return true;
    }

    public com.google.android.gms.internal.zzag.zza zzI(Map map)
    {
        Object obj = (com.google.android.gms.internal.zzag.zza)map.get(zzaVI);
        if (obj == null)
        {
            return zzdf.zzDX();
        }
        obj = zzdf.zzg(((com.google.android.gms.internal.zzag.zza) (obj)));
        map = (com.google.android.gms.internal.zzag.zza)map.get(zzaVH);
        if (map != null)
        {
            map = zzdf.zzg(map);
        } else
        {
            map = null;
        }
        map = zzax.zzf(context, ((String) (obj)), map);
        if (map != null)
        {
            return zzdf.zzQ(map);
        } else
        {
            return zzdf.zzDX();
        }
    }

    static 
    {
        ID = zzad.zzbJ.toString();
        zzaVH = zzae.zzeb.toString();
        zzaVI = zzae.zzee.toString();
    }
}
