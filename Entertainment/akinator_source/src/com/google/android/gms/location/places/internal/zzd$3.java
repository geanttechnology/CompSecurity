// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.zzl;
import com.google.android.gms.maps.model.LatLngBounds;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            zzd, zze

class zzaGZ extends com.google.android.gms.location.places.a
{

    final zzd zzaGW;
    final LatLngBounds zzaGY;
    final AutocompleteFilter zzaGZ;
    final String zzaxk;

    protected volatile void zza(com.google.android.gms.common.api.b b)
        throws RemoteException
    {
        zza((zze)b);
    }

    protected void zza(zze zze1)
        throws RemoteException
    {
        zze1.zza(new zzl(this), zzaxk, zzaGY, zzaGZ);
    }

    ter(zzd zzd1, com.google.android.gms.common.api.c c, GoogleApiClient googleapiclient, String s, LatLngBounds latlngbounds, AutocompleteFilter autocompletefilter)
    {
        zzaGW = zzd1;
        zzaxk = s;
        zzaGY = latlngbounds;
        zzaGZ = autocompletefilter;
        super(c, googleapiclient);
    }
}
