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

class zzaw extends zzak
{

    private static final String ID;
    private static final String zzaVH;
    private final Context context;

    public zzaw(Context context1)
    {
        super(ID, new String[0]);
        context = context1;
    }

    public boolean zzCo()
    {
        return true;
    }

    public com.google.android.gms.internal.zzag.zza zzI(Map map)
    {
        if ((com.google.android.gms.internal.zzag.zza)map.get(zzaVH) != null)
        {
            map = zzdf.zzg((com.google.android.gms.internal.zzag.zza)map.get(zzaVH));
        } else
        {
            map = null;
        }
        map = zzax.zzn(context, map);
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
        ID = zzad.zzbO.toString();
        zzaVH = zzae.zzeb.toString();
    }
}
