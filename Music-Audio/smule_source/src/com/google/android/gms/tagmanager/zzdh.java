// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzb;
import java.util.Map;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzak, zzdf

class zzdh extends zzak
{

    private static final String ID;
    private static final String zzaDq;

    public zzdh()
    {
        super(ID, new String[] {
            zzaDq
        });
    }

    public com.google.android.gms.internal.zzd.zza zzD(Map map)
    {
        return zzdf.zzE(zzdf.zzg((com.google.android.gms.internal.zzd.zza)map.get(zzaDq)).toUpperCase());
    }

    public boolean zzwn()
    {
        return true;
    }

    static 
    {
        ID = zza.zzaj.toString();
        zzaDq = zzb.zzbO.toString();
    }
}
