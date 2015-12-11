// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.app.PendingIntent;
import android.os.IInterface;
import com.google.android.gms.location.places.NearbyAlertRequest;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlaceRequest;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            PlacesParams, zzi

public interface zzf
    extends IInterface
{

    public abstract void zza(NearbyAlertRequest nearbyalertrequest, PlacesParams placesparams, PendingIntent pendingintent, zzi zzi);

    public abstract void zza(PlaceFilter placefilter, PlacesParams placesparams, zzi zzi);

    public abstract void zza(PlaceReport placereport, PlacesParams placesparams, zzi zzi);

    public abstract void zza(PlaceRequest placerequest, PlacesParams placesparams, PendingIntent pendingintent, zzi zzi);

    public abstract void zza(PlacesParams placesparams, PendingIntent pendingintent, zzi zzi);

    public abstract void zzb(PlacesParams placesparams, PendingIntent pendingintent, zzi zzi);
}
