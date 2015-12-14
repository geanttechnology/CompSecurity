// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DailyTotalRequest;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataInsertRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DailyTotalResult;
import com.google.android.gms.fitness.result.DataReadResult;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzmm, zznt, zzmx

public class zzno
    implements HistoryApi
{
    private static class zza extends zzms.zza
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;
        private int zzapd;
        private DataReadResult zzape;

        public void zza(DataReadResult datareadresult)
        {
            this;
            JVM INSTR monitorenter ;
            Log.v("Fitness", "Received batch result");
            if (zzape != null)
            {
                break MISSING_BLOCK_LABEL_62;
            }
            zzape = datareadresult;
_L2:
            zzapd = zzapd + 1;
            if (zzapd == zzape.zzsB())
            {
                zzQz.zzn(zzape);
            }
            this;
            JVM INSTR monitorexit ;
            return;
            zzape.zzb(datareadresult);
            if (true) goto _L2; else goto _L1
_L1:
            datareadresult;
            this;
            JVM INSTR monitorexit ;
            throw datareadresult;
        }

        private zza(com.google.android.gms.common.api.zzc.zzb zzb)
        {
            zzapd = 0;
            zzape = null;
            zzQz = zzb;
        }

    }


    public zzno()
    {
    }

    private PendingResult zza(GoogleApiClient googleapiclient, DataSet dataset, boolean flag)
    {
        zzx.zzb(dataset, "Must set the data set");
        boolean flag1;
        if (!dataset.getDataPoints().isEmpty())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        zzx.zza(flag1, "Cannot use an empty data set");
        zzx.zzb(dataset.getDataSource().zzrF(), "Must set the app package name for the data source");
        return googleapiclient.zza(new zzmm.zzc(googleapiclient, dataset, flag) {

            final DataSet zzaoW;
            final boolean zzaoX;
            final zzno zzaoY;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzmm)zzb);
            }

            protected void zza(zzmm zzmm1)
                throws RemoteException
            {
                zznt zznt1 = new zznt(this);
                String s = zzmm1.getContext().getPackageName();
                ((zzmx)zzmm1.zzoA()).zza(new DataInsertRequest(zzaoW, zznt1, s, zzaoX));
            }

            
            {
                zzaoY = zzno.this;
                zzaoW = dataset;
                zzaoX = flag;
                super(googleapiclient);
            }
        });
    }

    public PendingResult deleteData(GoogleApiClient googleapiclient, DataDeleteRequest datadeleterequest)
    {
        return googleapiclient.zza(new zzmm.zzc(googleapiclient, datadeleterequest) {

            final zzno zzaoY;
            final DataDeleteRequest zzaoZ;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzmm)zzb);
            }

            protected void zza(zzmm zzmm1)
                throws RemoteException
            {
                zznt zznt1 = new zznt(this);
                String s = zzmm1.getContext().getPackageName();
                ((zzmx)zzmm1.zzoA()).zza(new DataDeleteRequest(zzaoZ, zznt1, s));
            }

            
            {
                zzaoY = zzno.this;
                zzaoZ = datadeleterequest;
                super(googleapiclient);
            }
        });
    }

    public PendingResult insertData(GoogleApiClient googleapiclient, DataSet dataset)
    {
        return zza(googleapiclient, dataset, false);
    }

    public PendingResult readDailyTotal(GoogleApiClient googleapiclient, DataType datatype)
    {
        return googleapiclient.zza(new zzmm.zza(googleapiclient, datatype) {

            final zzno zzaoY;
            final DataType zzapb;

            protected DailyTotalResult zzK(Status status)
            {
                return DailyTotalResult.zzQ(status);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzmm)zzb1);
            }

            protected void zza(zzmm zzmm1)
                throws RemoteException
            {
                Object obj = new zzmr.zza(this) {

                    final _cls4 zzapc;

                    public void zza(DailyTotalResult dailytotalresult)
                        throws RemoteException
                    {
                        zzapc.zza(dailytotalresult);
                    }

            
            {
                zzapc = _pcls4;
                super();
            }
                };
                String s = zzmm1.getContext().getPackageName();
                obj = new DailyTotalRequest(((zzmr) (obj)), zzapb, s);
                ((zzmx)zzmm1.zzoA()).zza(((DailyTotalRequest) (obj)));
            }

            protected Result zzb(Status status)
            {
                return zzK(status);
            }

            
            {
                zzaoY = zzno.this;
                zzapb = datatype;
                super(googleapiclient);
            }
        });
    }

    public PendingResult readData(GoogleApiClient googleapiclient, DataReadRequest datareadrequest)
    {
        return googleapiclient.zza(new zzmm.zza(googleapiclient, datareadrequest) {

            final zzno zzaoY;
            final DataReadRequest zzapa;

            protected DataReadResult zzJ(Status status)
            {
                return DataReadResult.zza(status, zzapa);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzmm)zzb1);
            }

            protected void zza(zzmm zzmm1)
                throws RemoteException
            {
                zza zza1 = new zza(this);
                String s = zzmm1.getContext().getPackageName();
                ((zzmx)zzmm1.zzoA()).zza(new DataReadRequest(zzapa, zza1, s));
            }

            protected Result zzb(Status status)
            {
                return zzJ(status);
            }

            
            {
                zzaoY = zzno.this;
                zzapa = datareadrequest;
                super(googleapiclient);
            }
        });
    }
}
