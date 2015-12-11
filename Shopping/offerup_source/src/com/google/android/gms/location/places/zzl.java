// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmz;
import com.google.android.gms.location.places.personalized.zzd;

// Referenced classes of package com.google.android.gms.location.places:
//            PlaceLikelihoodBuffer, AutocompletePredictionBuffer, PlaceBuffer

public class zzl extends com.google.android.gms.location.places.internal.zzi.zza
{

    private static final String TAG = com/google/android/gms/location/places/zzl.getSimpleName();
    private final Context mContext;
    private final zzd zzaGB;
    private final zza zzaGC;
    private final zze zzaGD;
    private final zzf zzaGE;
    private final zzc zzaGF;

    public zzl(zza zza)
    {
        zzaGB = null;
        zzaGC = zza;
        zzaGD = null;
        zzaGE = null;
        zzaGF = null;
        mContext = null;
    }

    public zzl(zzc zzc, Context context)
    {
        zzaGB = null;
        zzaGC = null;
        zzaGD = null;
        zzaGE = null;
        zzaGF = zzc;
        mContext = context;
    }

    public zzl(zzd zzd1, Context context)
    {
        zzaGB = zzd1;
        zzaGC = null;
        zzaGD = null;
        zzaGE = null;
        zzaGF = null;
        mContext = context;
    }

    public zzl(zzf zzf)
    {
        zzaGB = null;
        zzaGC = null;
        zzaGD = null;
        zzaGE = zzf;
        zzaGF = null;
        mContext = null;
    }

    public void zzaN(Status status)
    {
        zzaGE.zzb(status);
    }

    public void zzab(DataHolder dataholder)
    {
        boolean flag;
        if (zzaGB != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "placeEstimator cannot be null");
        if (dataholder == null)
        {
            if (Log.isLoggable(TAG, 6))
            {
                Log.e(TAG, (new StringBuilder("onPlaceEstimated received null DataHolder: ")).append(zzmz.zzqF()).toString());
            }
            zzaGB.zzv(Status.zzabd);
            return;
        } else
        {
            dataholder = new PlaceLikelihoodBuffer(dataholder, 100, mContext);
            zzaGB.zzb(dataholder);
            return;
        }
    }

    public void zzac(DataHolder dataholder)
    {
        if (dataholder == null)
        {
            if (Log.isLoggable(TAG, 6))
            {
                Log.e(TAG, (new StringBuilder("onAutocompletePrediction received null DataHolder: ")).append(zzmz.zzqF()).toString());
            }
            zzaGC.zzv(Status.zzabd);
            return;
        } else
        {
            zzaGC.zzb(new AutocompletePredictionBuffer(dataholder));
            return;
        }
    }

    public void zzad(DataHolder dataholder)
    {
        if (dataholder == null)
        {
            if (Log.isLoggable(TAG, 6))
            {
                Log.e(TAG, (new StringBuilder("onPlaceUserDataFetched received null DataHolder: ")).append(zzmz.zzqF()).toString());
            }
            zzaGD.zzv(Status.zzabd);
            return;
        } else
        {
            zzaGD.zzb(new com.google.android.gms.location.places.personalized.zzd(dataholder));
            return;
        }
    }

    public void zzae(DataHolder dataholder)
    {
        dataholder = new PlaceBuffer(dataholder, mContext);
        zzaGF.zzb(dataholder);
    }


    private class zzf extends zzb
    {
        private class zzb extends com.google.android.gms.internal.zzlb.zza
        {

            public zzb(com.google.android.gms.common.api.Api.zzc zzc, GoogleApiClient googleapiclient)
            {
                super(zzc, googleapiclient);
            }
        }


        protected Result zzb(Status status)
        {
            return zzd(status);
        }

        protected Status zzd(Status status)
        {
            return status;
        }

        public zzf(com.google.android.gms.common.api.Api.zzc zzc, GoogleApiClient googleapiclient)
        {
            super(zzc, googleapiclient);
        }
    }


    private class zzd extends zzb
    {

        protected PlaceLikelihoodBuffer zzaQ(Status status)
        {
            return new PlaceLikelihoodBuffer(DataHolder.zzbu(status.getStatusCode()), 100, null);
        }

        protected Result zzb(Status status)
        {
            return zzaQ(status);
        }

        public zzd(com.google.android.gms.common.api.Api.zzc zzc, GoogleApiClient googleapiclient)
        {
            super(zzc, googleapiclient);
        }
    }


    private class zza extends zzb
    {

        protected AutocompletePredictionBuffer zzaO(Status status)
        {
            return new AutocompletePredictionBuffer(DataHolder.zzbu(status.getStatusCode()));
        }

        protected Result zzb(Status status)
        {
            return zzaO(status);
        }

        public zza(com.google.android.gms.common.api.Api.zzc zzc, GoogleApiClient googleapiclient)
        {
            super(zzc, googleapiclient);
        }
    }


    private class zze extends zzb
    {

        protected com.google.android.gms.location.places.personalized.zzd zzaR(Status status)
        {
            return com.google.android.gms.location.places.personalized.zzd.zzaS(status);
        }

        protected Result zzb(Status status)
        {
            return zzaR(status);
        }
    }


    private class zzc extends zzb
    {

        protected PlaceBuffer zzaP(Status status)
        {
            return new PlaceBuffer(DataHolder.zzbu(status.getStatusCode()), null);
        }

        protected Result zzb(Status status)
        {
            return zzaP(status);
        }

        public zzc(com.google.android.gms.common.api.Api.zzc zzc1, GoogleApiClient googleapiclient)
        {
            super(zzc1, googleapiclient);
        }
    }

}
