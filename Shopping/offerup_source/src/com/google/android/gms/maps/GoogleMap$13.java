// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.internal.zzf;

// Referenced classes of package com.google.android.gms.maps:
//            GoogleMap

class zza extends com.google.android.gms.maps.internal.>
{

    final GoogleMap zzaIk;
    final oWindowAdapter zzaIy;

    public zzd zzf(zzf zzf1)
    {
        return zze.zzy(zzaIy.getInfoWindow(new Marker(zzf1)));
    }

    public zzd zzg(zzf zzf1)
    {
        return zze.zzy(zzaIy.getInfoContents(new Marker(zzf1)));
    }

    oWindowAdapter(GoogleMap googlemap, oWindowAdapter owindowadapter)
    {
        zzaIk = googlemap;
        zzaIy = owindowadapter;
        super();
    }
}
