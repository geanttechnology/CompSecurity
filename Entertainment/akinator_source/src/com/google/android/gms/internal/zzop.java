// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

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
//            zzno, zzou, zznz

public class zzop
    implements HistoryApi
{
    private static class zza extends zznu.zza
    {

        private final zzlb.zzb zzagy;
        private int zzarA;
        private DataReadResult zzarB;

        public void zza(DataReadResult datareadresult)
        {
            this;
            JVM INSTR monitorenter ;
            Log.v("Fitness", "Received batch result");
            if (zzarB != null)
            {
                break MISSING_BLOCK_LABEL_62;
            }
            zzarB = datareadresult;
_L2:
            zzarA = zzarA + 1;
            if (zzarA == zzarB.zztn())
            {
                zzagy.zzp(zzarB);
            }
            this;
            JVM INSTR monitorexit ;
            return;
            zzarB.zzb(datareadresult);
            if (true) goto _L2; else goto _L1
_L1:
            datareadresult;
            this;
            JVM INSTR monitorexit ;
            throw datareadresult;
        }

        private zza(zzlb.zzb zzb)
        {
            zzarA = 0;
            zzarB = null;
            zzagy = zzb;
        }

    }


    public zzop()
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
        zzx.zzb(dataset.getDataSource().zzsr(), "Must set the app package name for the data source");
        return googleapiclient.zza(new zzno.zzc(googleapiclient, dataset, flag) {

            final DataSet zzart;
            final boolean zzaru;
            final zzop zzarv;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzno)zzb);
            }

            protected void zza(zzno zzno1)
                throws RemoteException
            {
                zzou zzou1 = new zzou(this);
                ((zznz)zzno1.zzpc()).zza(new DataInsertRequest(zzart, zzou1, zzaru));
            }

            
            {
                zzarv = zzop.this;
                zzart = dataset;
                zzaru = flag;
                super(googleapiclient);
            }
        });
    }

    public PendingResult deleteData(GoogleApiClient googleapiclient, DataDeleteRequest datadeleterequest)
    {
        return googleapiclient.zza(new zzno.zzc(googleapiclient, datadeleterequest) {

            final zzop zzarv;
            final DataDeleteRequest zzarw;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzno)zzb);
            }

            protected void zza(zzno zzno1)
                throws RemoteException
            {
                zzou zzou1 = new zzou(this);
                ((zznz)zzno1.zzpc()).zza(new DataDeleteRequest(zzarw, zzou1));
            }

            
            {
                zzarv = zzop.this;
                zzarw = datadeleterequest;
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
        return googleapiclient.zza(new zzno.zza(googleapiclient, datatype) {

            final zzop zzarv;
            final DataType zzary;

            protected DailyTotalResult zzK(Status status)
            {
                return DailyTotalResult.zza(status, zzary);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzno)zzb1);
            }

            protected void zza(zzno zzno1)
                throws RemoteException
            {
                DailyTotalRequest dailytotalrequest = new DailyTotalRequest(new zznt.zza(this) {

                    final _cls4 zzarz;

                    public void zza(DailyTotalResult dailytotalresult)
                        throws RemoteException
                    {
                        zzarz.zzb(dailytotalresult);
                    }

            
            {
                zzarz = _pcls4;
                super();
            }
                }, zzary);
                ((zznz)zzno1.zzpc()).zza(dailytotalrequest);
            }

            protected Result zzb(Status status)
            {
                return zzK(status);
            }

            
            {
                zzarv = zzop.this;
                zzary = datatype;
                super(googleapiclient);
            }
        });
    }

    public PendingResult readData(GoogleApiClient googleapiclient, DataReadRequest datareadrequest)
    {
        return googleapiclient.zza(new zzno.zza(googleapiclient, datareadrequest) {

            final zzop zzarv;
            final DataReadRequest zzarx;

            protected DataReadResult zzJ(Status status)
            {
                return DataReadResult.zza(status, zzarx);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzno)zzb1);
            }

            protected void zza(zzno zzno1)
                throws RemoteException
            {
                zza zza1 = new zza(this);
                ((zznz)zzno1.zzpc()).zza(new DataReadRequest(zzarx, zza1));
            }

            protected Result zzb(Status status)
            {
                return zzJ(status);
            }

            
            {
                zzarv = zzop.this;
                zzarx = datareadrequest;
                super(googleapiclient);
            }
        });
    }
}
