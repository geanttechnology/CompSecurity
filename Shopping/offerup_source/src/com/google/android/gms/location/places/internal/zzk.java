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
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.zzl;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            PlacesParams, zzf

public class zzk extends zzj
{

    private final PlacesParams zzaHb;
    private final Locale zzaHc = Locale.getDefault();

    public zzk(Context context, Looper looper, zzf zzf1, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, String s, String s1, 
            PlacesOptions placesoptions)
    {
        super(context, looper, 67, zzf1, connectioncallbacks, onconnectionfailedlistener);
        context = null;
        if (zzf1.getAccount() != null)
        {
            context = zzf1.getAccount().name;
        }
        zzaHb = new PlacesParams(s, zzaHc, context, placesoptions.zzaGG, s1);
    }

    protected IInterface zzW(IBinder ibinder)
    {
        return zzci(ibinder);
    }

    public void zza(zzl zzl, PlaceFilter placefilter)
    {
        PlaceFilter placefilter1 = placefilter;
        if (placefilter == null)
        {
            placefilter1 = PlaceFilter.zzwT();
        }
        ((com.google.android.gms.location.places.internal.zzf)zzpc()).zza(placefilter1, zzaHb, zzl);
    }

    public void zza(zzl zzl, PlaceReport placereport)
    {
        zzx.zzw(placereport);
        ((com.google.android.gms.location.places.internal.zzf)zzpc()).zza(placereport, zzaHb, zzl);
    }

    protected com.google.android.gms.location.places.internal.zzf zzci(IBinder ibinder)
    {
        return zzf.zza.zzce(ibinder);
    }

    protected String zzfK()
    {
        return "com.google.android.gms.location.places.PlaceDetectionApi";
    }

    protected String zzfL()
    {
        return "com.google.android.gms.location.places.internal.IGooglePlaceDetectionService";
    }
}
