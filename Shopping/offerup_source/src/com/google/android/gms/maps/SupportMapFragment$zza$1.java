// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.IGoogleMapDelegate;

// Referenced classes of package com.google.android.gms.maps:
//            GoogleMap, OnMapReadyCallback

class zzaIQ extends com.google.android.gms.maps.internal.
{

    final OnMapReadyCallback zzaIQ;
    final te zzaJB;

    public void zza(IGoogleMapDelegate igooglemapdelegate)
    {
        zzaIQ.onMapReady(new GoogleMap(igooglemapdelegate));
    }

    te(te te, OnMapReadyCallback onmapreadycallback)
    {
        zzaJB = te;
        zzaIQ = onmapreadycallback;
        super();
    }
}
