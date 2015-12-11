// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
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
    public static class zza extends com.google.android.gms.common.api.Api.zza
    {

        private final String zzaHd;
        private final String zzaHe;

        public com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf zzf1, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return zzb(context, looper, zzf1, (PlacesOptions)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public zzk zzb(Context context, Looper looper, zzf zzf1, PlacesOptions placesoptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            String s;
            String s1;
            if (zzaHd != null)
            {
                s = zzaHd;
            } else
            {
                s = context.getPackageName();
            }
            if (zzaHe != null)
            {
                s1 = zzaHe;
            } else
            {
                s1 = context.getPackageName();
            }
            if (placesoptions == null)
            {
                placesoptions = (new com.google.android.gms.location.places.PlacesOptions.Builder()).build();
            }
            return new zzk(context, looper, zzf1, connectioncallbacks, onconnectionfailedlistener, s, s1, placesoptions);
        }

        public zza(String s, String s1)
        {
            zzaHd = s;
            zzaHe = s1;
        }
    }


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
        throws RemoteException
    {
        PlaceFilter placefilter1 = placefilter;
        if (placefilter == null)
        {
            placefilter1 = PlaceFilter.zzwT();
        }
        ((com.google.android.gms.location.places.internal.zzf)zzpc()).zza(placefilter1, zzaHb, zzl);
    }

    public void zza(zzl zzl, PlaceReport placereport)
        throws RemoteException
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
