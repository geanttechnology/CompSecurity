// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRegistrationRequest;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.SensorUnregistrationRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;

// Referenced classes of package com.google.android.gms.internal:
//            zznj, zzmp, zzna, zznt

public class zznr
    implements SensorsApi
{
    private static interface zza
    {

        public abstract void zzrZ();
    }

    private static class zzb extends zzmt.zza
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zza(DataSourcesResult datasourcesresult)
        {
            zzQz.zzn(datasourcesresult);
        }

        private zzb(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = zzb1;
        }

    }

    private static class zzc extends zznh.zza
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;
        private final zza zzapr;

        public void zzr(Status status)
        {
            if (zzapr != null && status.isSuccess())
            {
                zzapr.zzrZ();
            }
            zzQz.zzn(status);
        }

        private zzc(com.google.android.gms.common.api.zzc.zzb zzb1, zza zza1)
        {
            zzQz = zzb1;
            zzapr = zza1;
        }

    }


    public zznr()
    {
    }

    private PendingResult zza(GoogleApiClient googleapiclient, zzj zzj, PendingIntent pendingintent, zza zza1)
    {
        return googleapiclient.zzb(new zzmp.zzc(googleapiclient, zza1, zzj, pendingintent) {

            final zznr zzapj;
            final zza zzapo;
            final zzj zzapp;
            final PendingIntent zzapq;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzmp)zzb1);
            }

            protected void zza(zzmp zzmp1)
                throws RemoteException
            {
                zzc zzc1 = new zzc(this, zzapo);
                String s = zzmp1.getContext().getPackageName();
                ((zzna)zzmp1.zzoA()).zza(new SensorUnregistrationRequest(zzapp, zzapq, zzc1, s));
            }

            protected Result zzb(Status status)
            {
                return zzd(status);
            }

            protected Status zzd(Status status)
            {
                return status;
            }

            
            {
                zzapj = zznr.this;
                zzapo = zza1;
                zzapp = zzj;
                zzapq = pendingintent;
                super(googleapiclient);
            }
        });
    }

    private PendingResult zza(GoogleApiClient googleapiclient, SensorRequest sensorrequest, zzj zzj, PendingIntent pendingintent)
    {
        return googleapiclient.zza(new zzmp.zzc(googleapiclient, sensorrequest, zzj, pendingintent) {

            final zznr zzapj;
            final SensorRequest zzapk;
            final zzj zzapl;
            final PendingIntent zzapm;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzmp)zzb1);
            }

            protected void zza(zzmp zzmp1)
                throws RemoteException
            {
                zznt zznt1 = new zznt(this);
                String s = zzmp1.getContext().getPackageName();
                ((zzna)zzmp1.zzoA()).zza(new SensorRegistrationRequest(zzapk, zzapl, zzapm, zznt1, s));
            }

            protected Result zzb(Status status)
            {
                return zzd(status);
            }

            protected Status zzd(Status status)
            {
                return status;
            }

            
            {
                zzapj = zznr.this;
                zzapk = sensorrequest;
                zzapl = zzj;
                zzapm = pendingintent;
                super(googleapiclient);
            }
        });
    }

    public PendingResult add(GoogleApiClient googleapiclient, SensorRequest sensorrequest, PendingIntent pendingintent)
    {
        return zza(googleapiclient, sensorrequest, ((zzj) (null)), pendingintent);
    }

    public PendingResult add(GoogleApiClient googleapiclient, SensorRequest sensorrequest, OnDataPointListener ondatapointlistener)
    {
        return zza(googleapiclient, sensorrequest, com.google.android.gms.fitness.data.zzk.zza.zzrL().zza(ondatapointlistener), ((PendingIntent) (null)));
    }

    public PendingResult findDataSources(GoogleApiClient googleapiclient, DataSourcesRequest datasourcesrequest)
    {
        return googleapiclient.zza(new zzmp.zza(googleapiclient, datasourcesrequest) {

            final DataSourcesRequest zzapi;
            final zznr zzapj;

            protected DataSourcesResult zzM(Status status)
            {
                return DataSourcesResult.zzR(status);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzmp)zzb1);
            }

            protected void zza(zzmp zzmp1)
                throws RemoteException
            {
                zzb zzb1 = new zzb(this);
                String s = zzmp1.getContext().getPackageName();
                ((zzna)zzmp1.zzoA()).zza(new DataSourcesRequest(zzapi, zzb1, s));
            }

            protected Result zzb(Status status)
            {
                return zzM(status);
            }

            
            {
                zzapj = zznr.this;
                zzapi = datasourcesrequest;
                super(googleapiclient);
            }
        });
    }

    public PendingResult remove(GoogleApiClient googleapiclient, PendingIntent pendingintent)
    {
        return zza(googleapiclient, ((zzj) (null)), pendingintent, ((zza) (null)));
    }

    public PendingResult remove(GoogleApiClient googleapiclient, OnDataPointListener ondatapointlistener)
    {
        com.google.android.gms.fitness.data.zzk zzk = com.google.android.gms.fitness.data.zzk.zza.zzrL().zzb(ondatapointlistener);
        if (zzk == null)
        {
            return new zznj(Status.zzaaD);
        } else
        {
            return zza(googleapiclient, zzk, ((PendingIntent) (null)), new zza(ondatapointlistener) {

                final zznr zzapj;
                final OnDataPointListener zzapn;

                public void zzrZ()
                {
                    com.google.android.gms.fitness.data.zzk.zza.zzrL().zzc(zzapn);
                }

            
            {
                zzapj = zznr.this;
                zzapn = ondatapointlistener;
                super();
            }
            });
        }
    }
}
