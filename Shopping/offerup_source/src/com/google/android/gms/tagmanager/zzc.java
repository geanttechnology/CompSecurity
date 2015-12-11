// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzad;
import java.util.Map;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzak, zza, zzdf

class zzc extends zzak
{

    private static final String ID;
    private final zza zzaVG;

    public zzc(Context context)
    {
        this(zza.zzaN(context));
    }

    zzc(zza zza1)
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
        boolean flag;
        if (!zzaVG.isLimitAdTrackingEnabled())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return zzdf.zzQ(Boolean.valueOf(flag));
    }

    static 
    {
        ID = zzad.zzbg.toString();
    }
}
