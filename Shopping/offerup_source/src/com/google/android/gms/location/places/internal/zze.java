// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.zzl;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            PlacesParams, zzg

public class zze extends zzj
{

    private final PlacesParams zzaHb;
    private final Locale zzaHc = Locale.getDefault();

    public zze(Context context, Looper looper, zzf zzf1, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, String s, String s1, 
            PlacesOptions placesoptions)
    {
        super(context, looper, 65, zzf1, connectioncallbacks, onconnectionfailedlistener);
        context = null;
        if (zzf1.getAccount() != null)
        {
            context = zzf1.getAccount().name;
        }
        zzaHb = new PlacesParams(s, zzaHc, context, placesoptions.zzaGG, s1);
    }

    protected IInterface zzW(IBinder ibinder)
    {
        return zzcd(ibinder);
    }

    public void zza(com.google.android.gms.location.places.zzf zzf1, String s)
    {
        zzx.zzb(s, "placeId cannot be null");
        ((zzg)zzpc()).zza(s, zzaHb, zzf1);
    }

    public void zza(com.google.android.gms.location.places.zzf zzf1, String s, int i, int j, int k)
    {
        boolean flag1 = true;
        zzx.zzb(s, "fifeUrl cannot be null");
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "width should be > 0");
        if (i > 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "height should be > 0");
        ((zzg)zzpc()).zza(s, i, j, k, zzaHb, zzf1);
    }

    public void zza(zzl zzl, AddPlaceRequest addplacerequest)
    {
        zzx.zzb(addplacerequest, "userAddedPlace == null");
        ((zzg)zzpc()).zza(addplacerequest, zzaHb, zzl);
    }

    public void zza(zzl zzl, String s, LatLngBounds latlngbounds, AutocompleteFilter autocompletefilter)
    {
        zzx.zzb(s, "query == null");
        zzx.zzb(zzl, "callback == null");
        if (autocompletefilter == null)
        {
            autocompletefilter = AutocompleteFilter.create(null);
        }
        ((zzg)zzpc()).zza(s, latlngbounds, autocompletefilter, zzaHb, zzl);
    }

    public void zza(zzl zzl, List list)
    {
        ((zzg)zzpc()).zzb(list, zzaHb, zzl);
    }

    protected zzg zzcd(IBinder ibinder)
    {
        return zzg.zza.zzcf(ibinder);
    }

    protected String zzfK()
    {
        return "com.google.android.gms.location.places.GeoDataApi";
    }

    protected String zzfL()
    {
        return "com.google.android.gms.location.places.internal.IGooglePlacesService";
    }
}
