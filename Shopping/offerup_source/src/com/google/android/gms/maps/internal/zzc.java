// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.internal;

import android.os.IInterface;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.model.internal.zza;

// Referenced classes of package com.google.android.gms.maps.internal:
//            IMapViewDelegate, IStreetViewPanoramaViewDelegate, IMapFragmentDelegate, IStreetViewPanoramaFragmentDelegate, 
//            ICameraUpdateFactoryDelegate

public interface zzc
    extends IInterface
{

    public abstract IMapViewDelegate zza(zzd zzd1, GoogleMapOptions googlemapoptions);

    public abstract IStreetViewPanoramaViewDelegate zza(zzd zzd1, StreetViewPanoramaOptions streetviewpanoramaoptions);

    public abstract void zzd(zzd zzd1, int i);

    public abstract void zzs(zzd zzd1);

    public abstract IMapFragmentDelegate zzt(zzd zzd1);

    public abstract IStreetViewPanoramaFragmentDelegate zzu(zzd zzd1);

    public abstract ICameraUpdateFactoryDelegate zzxT();

    public abstract zza zzxU();
}
