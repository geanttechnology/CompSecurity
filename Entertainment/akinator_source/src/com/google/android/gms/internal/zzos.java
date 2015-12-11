// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
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
//            zznr, zzoc, zzou

public class zzos
    implements SensorsApi
{
    private static interface zza
    {

        public abstract void zzsL();
    }

    private static class zzb extends zznv.zza
    {

        private final zzlb.zzb zzagy;

        public void zza(DataSourcesResult datasourcesresult)
        {
            zzagy.zzp(datasourcesresult);
        }

        private zzb(zzlb.zzb zzb1)
        {
            zzagy = zzb1;
        }

    }

    private static class zzc extends zzoj.zza
    {

        private final zzlb.zzb zzagy;
        private final zza zzarO;

        public void zzo(Status status)
        {
            if (zzarO != null && status.isSuccess())
            {
                zzarO.zzsL();
            }
            zzagy.zzp(status);
        }

        private zzc(zzlb.zzb zzb1, zza zza1)
        {
            zzagy = zzb1;
            zzarO = zza1;
        }

    }


    public zzos()
    {
    }

    private PendingResult zza(GoogleApiClient googleapiclient, zzj zzj, PendingIntent pendingintent, zza zza1)
    {
        return googleapiclient.zzb(new zznr.zzc(googleapiclient, zza1, zzj, pendingintent) {

            final zzos zzarG;
            final zza zzarL;
            final zzj zzarM;
            final PendingIntent zzarN;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zznr)zzb1);
            }

            protected void zza(zznr zznr1)
                throws RemoteException
            {
                zzc zzc1 = new zzc(this, zzarL);
                ((zzoc)zznr1.zzpc()).zza(new SensorUnregistrationRequest(zzarM, zzarN, zzc1));
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
                zzarG = zzos.this;
                zzarL = zza1;
                zzarM = zzj;
                zzarN = pendingintent;
                super(googleapiclient);
            }
        });
    }

    private PendingResult zza(GoogleApiClient googleapiclient, SensorRequest sensorrequest, zzj zzj, PendingIntent pendingintent)
    {
        return googleapiclient.zza(new zznr.zzc(googleapiclient, sensorrequest, zzj, pendingintent) {

            final zzos zzarG;
            final SensorRequest zzarH;
            final zzj zzarI;
            final PendingIntent zzarJ;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zznr)zzb1);
            }

            protected void zza(zznr zznr1)
                throws RemoteException
            {
                zzou zzou1 = new zzou(this);
                ((zzoc)zznr1.zzpc()).zza(new SensorRegistrationRequest(zzarH, zzarI, zzarJ, zzou1));
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
                zzarG = zzos.this;
                zzarH = sensorrequest;
                zzarI = zzj;
                zzarJ = pendingintent;
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
        return zza(googleapiclient, sensorrequest, com.google.android.gms.fitness.data.zzk.zza.zzsx().zza(ondatapointlistener), ((PendingIntent) (null)));
    }

    public PendingResult findDataSources(GoogleApiClient googleapiclient, DataSourcesRequest datasourcesrequest)
    {
        return googleapiclient.zza(new zznr.zza(googleapiclient, datasourcesrequest) {

            final DataSourcesRequest zzarF;
            final zzos zzarG;

            protected DataSourcesResult zzM(Status status)
            {
                return DataSourcesResult.zzQ(status);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zznr)zzb1);
            }

            protected void zza(zznr zznr1)
                throws RemoteException
            {
                zzb zzb1 = new zzb(this);
                ((zzoc)zznr1.zzpc()).zza(new DataSourcesRequest(zzarF, zzb1));
            }

            protected Result zzb(Status status)
            {
                return zzM(status);
            }

            
            {
                zzarG = zzos.this;
                zzarF = datasourcesrequest;
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
        com.google.android.gms.fitness.data.zzk zzk = com.google.android.gms.fitness.data.zzk.zza.zzsx().zzb(ondatapointlistener);
        if (zzk == null)
        {
            return PendingResults.zza(Status.zzabb, googleapiclient);
        } else
        {
            return zza(googleapiclient, zzk, ((PendingIntent) (null)), new zza(ondatapointlistener) {

                final zzos zzarG;
                final OnDataPointListener zzarK;

                public void zzsL()
                {
                    com.google.android.gms.fitness.data.zzk.zza.zzsx().zzc(zzarK);
                }

            
            {
                zzarG = zzos.this;
                zzarK = ondatapointlistener;
                super();
            }
            });
        }
    }
}
