// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
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
//            zzml, zzmw, zznt

public class zznn
    implements ConfigApi
{
    private static class zza extends zzmu.zza
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zza(DataTypeResult datatyperesult)
        {
            zzQz.zzn(datatyperesult);
        }

        private zza(com.google.android.gms.common.api.zzc.zzb zzb)
        {
            zzQz = zzb;
        }

    }


    public zznn()
    {
    }

    public PendingResult createCustomDataType(GoogleApiClient googleapiclient, DataTypeCreateRequest datatypecreaterequest)
    {
        return googleapiclient.zzb(new zzml.zza(googleapiclient, datatypecreaterequest) {

            final DataTypeCreateRequest zzaoT;
            final zznn zzaoU;

            protected DataTypeResult zzI(Status status)
            {
                return DataTypeResult.zzS(status);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzml)zzb1);
            }

            protected void zza(zzml zzml1)
                throws RemoteException
            {
                zza zza1 = new zza(this);
                String s = zzml1.getContext().getPackageName();
                ((zzmw)zzml1.zzoA()).zza(new DataTypeCreateRequest(zzaoT, zza1, s));
            }

            protected Result zzb(Status status)
            {
                return zzI(status);
            }

            
            {
                zzaoU = zznn.this;
                zzaoT = datatypecreaterequest;
                super(googleapiclient);
            }
        });
    }

    public PendingResult disableFit(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zzb(new zzml.zzc(googleapiclient) {

            final zznn zzaoU;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzml)zzb);
            }

            protected void zza(zzml zzml1)
                throws RemoteException
            {
                zznt zznt1 = new zznt(this);
                String s = zzml1.getContext().getPackageName();
                ((zzmw)zzml1.zzoA()).zza(new DisableFitRequest(zznt1, s));
            }

            
            {
                zzaoU = zznn.this;
                super(googleapiclient);
            }
        });
    }

    public PendingResult readDataType(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zza(new zzml.zza(googleapiclient, s) {

            final zznn zzaoU;
            final String zzaoV;

            protected DataTypeResult zzI(Status status)
            {
                return DataTypeResult.zzS(status);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzml)zzb1);
            }

            protected void zza(zzml zzml1)
                throws RemoteException
            {
                zza zza1 = new zza(this);
                String s1 = zzml1.getContext().getPackageName();
                ((zzmw)zzml1.zzoA()).zza(new DataTypeReadRequest(zzaoV, zza1, s1));
            }

            protected Result zzb(Status status)
            {
                return zzI(status);
            }

            
            {
                zzaoU = zznn.this;
                zzaoV = s;
                super(googleapiclient);
            }
        });
    }
}
