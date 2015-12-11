// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.app.PendingIntent;
import android.os.IInterface;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.NearbyAlertRequest;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlaceRequest;
import com.google.android.gms.location.places.UserDataType;
import com.google.android.gms.location.places.personalized.PlaceAlias;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            PlacesParams, zzi, zzh

public interface zzg
    extends IInterface
{

    public abstract void zza(AddPlaceRequest addplacerequest, PlacesParams placesparams, zzi zzi);

    public abstract void zza(NearbyAlertRequest nearbyalertrequest, PlacesParams placesparams, PendingIntent pendingintent);

    public abstract void zza(PlaceReport placereport, PlacesParams placesparams);

    public abstract void zza(PlaceRequest placerequest, PlacesParams placesparams, PendingIntent pendingintent);

    public abstract void zza(UserDataType userdatatype, LatLngBounds latlngbounds, List list, PlacesParams placesparams, zzi zzi);

    public abstract void zza(PlacesParams placesparams, PendingIntent pendingintent);

    public abstract void zza(PlaceAlias placealias, String s, String s1, PlacesParams placesparams, zzi zzi);

    public abstract void zza(LatLng latlng, PlaceFilter placefilter, PlacesParams placesparams, zzi zzi);

    public abstract void zza(LatLngBounds latlngbounds, int i, String s, PlaceFilter placefilter, PlacesParams placesparams, zzi zzi);

    public abstract void zza(String s, int i, int j, int k, PlacesParams placesparams, zzh zzh);

    public abstract void zza(String s, int i, PlacesParams placesparams, zzi zzi);

    public abstract void zza(String s, PlacesParams placesparams, zzh zzh);

    public abstract void zza(String s, PlacesParams placesparams, zzi zzi);

    public abstract void zza(String s, LatLngBounds latlngbounds, AutocompleteFilter autocompletefilter, PlacesParams placesparams, zzi zzi);

    public abstract void zza(List list, PlacesParams placesparams, zzi zzi);

    public abstract void zzb(PlaceFilter placefilter, PlacesParams placesparams, zzi zzi);

    public abstract void zzb(PlacesParams placesparams, PendingIntent pendingintent);

    public abstract void zzb(String s, PlacesParams placesparams, zzi zzi);

    public abstract void zzb(List list, PlacesParams placesparams, zzi zzi);
}
