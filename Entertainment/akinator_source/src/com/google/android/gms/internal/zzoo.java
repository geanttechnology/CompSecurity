// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.DataTypeReadRequest;
import com.google.android.gms.fitness.request.DisableFitRequest;
import com.google.android.gms.fitness.result.DataTypeResult;

// Referenced classes of package com.google.android.gms.internal:
//            zznn, zzny, zzou

public class zzoo
    implements ConfigApi
{
    private static class zza extends zznw.zza
    {

        private final zzlb.zzb zzagy;

        public void zza(DataTypeResult datatyperesult)
        {
            zzagy.zzp(datatyperesult);
        }

        private zza(zzlb.zzb zzb)
        {
            zzagy = zzb;
        }

    }


    public zzoo()
    {
    }

    public PendingResult createCustomDataType(GoogleApiClient googleapiclient, DataTypeCreateRequest datatypecreaterequest)
    {
        return googleapiclient.zzb(new zznn.zza(googleapiclient, datatypecreaterequest) {

            final DataTypeCreateRequest zzarq;
            final zzoo zzarr;

            protected DataTypeResult zzI(Status status)
            {
                return DataTypeResult.zzR(status);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zznn)zzb1);
            }

            protected void zza(zznn zznn1)
                throws RemoteException
            {
                zza zza1 = new zza(this);
                ((zzny)zznn1.zzpc()).zza(new DataTypeCreateRequest(zzarq, zza1));
            }

            protected Result zzb(Status status)
            {
                return zzI(status);
            }

            
            {
                zzarr = zzoo.this;
                zzarq = datatypecreaterequest;
                super(googleapiclient);
            }
        });
    }

    public PendingResult disableFit(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zzb(new zznn.zzc(googleapiclient) {

            final zzoo zzarr;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zznn)zzb);
            }

            protected void zza(zznn zznn1)
                throws RemoteException
            {
                zzou zzou1 = new zzou(this);
                ((zzny)zznn1.zzpc()).zza(new DisableFitRequest(zzou1));
            }

            
            {
                zzarr = zzoo.this;
                super(googleapiclient);
            }
        });
    }

    public PendingResult readDataType(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zza(new zznn.zza(googleapiclient, s) {

            final zzoo zzarr;
            final String zzars;

            protected DataTypeResult zzI(Status status)
            {
                return DataTypeResult.zzR(status);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zznn)zzb1);
            }

            protected void zza(zznn zznn1)
                throws RemoteException
            {
                zza zza1 = new zza(this);
                ((zzny)zznn1.zzpc()).zza(new DataTypeReadRequest(zzars, zza1));
            }

            protected Result zzb(Status status)
            {
                return zzI(status);
            }

            
            {
                zzarr = zzoo.this;
                zzars = s;
                super(googleapiclient);
            }
        });
    }
}
