// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;

// Referenced classes of package com.google.android.gms.maps:
//            StreetViewPanorama, OnStreetViewPanoramaReadyCallback

class zzaJl extends com.google.android.gms.maps.internal._01_
{

    final etViewPanoramaReady zzaJD;
    final OnStreetViewPanoramaReadyCallback zzaJl;

    public void zza(IStreetViewPanoramaDelegate istreetviewpanoramadelegate)
    {
        zzaJl.onStreetViewPanoramaReady(new StreetViewPanorama(istreetviewpanoramadelegate));
    }

    I(I i, OnStreetViewPanoramaReadyCallback onstreetviewpanoramareadycallback)
    {
        zzaJD = i;
        zzaJl = onstreetviewpanoramareadycallback;
        super();
    }
}
