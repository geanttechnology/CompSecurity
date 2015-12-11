// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.internal.zzf;

// Referenced classes of package com.google.android.gms.maps:
//            GoogleMap

class zza extends com.google.android.gms.maps.internal.>
{

    final GoogleMap zzaIk;
    final arkerDragListener zzaIw;

    public void zzb(zzf zzf)
    {
        zzaIw.onMarkerDragStart(new Marker(zzf));
    }

    public void zzc(zzf zzf)
    {
        zzaIw.onMarkerDragEnd(new Marker(zzf));
    }

    public void zzd(zzf zzf)
    {
        zzaIw.onMarkerDrag(new Marker(zzf));
    }

    arkerDragListener(GoogleMap googlemap, arkerDragListener arkerdraglistener)
    {
        zzaIk = googlemap;
        zzaIw = arkerdraglistener;
        super();
    }
}
