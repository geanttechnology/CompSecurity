// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.ListSubscriptionsRequest;
import com.google.android.gms.fitness.request.SubscribeRequest;
import com.google.android.gms.fitness.request.UnsubscribeRequest;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

// Referenced classes of package com.google.android.gms.internal:
//            zznq, zzob, zzou

public class zzor
    implements RecordingApi
{
    private static class zza extends zzoe.zza
    {

        private final zzlb.zzb zzagy;

        public void zza(ListSubscriptionsResult listsubscriptionsresult)
        {
            zzagy.zzp(listsubscriptionsresult);
        }

        private zza(zzlb.zzb zzb)
        {
            zzagy = zzb;
        }

    }


    public zzor()
    {
    }

    private PendingResult zza(GoogleApiClient googleapiclient, Subscription subscription)
    {
        return googleapiclient.zza(new zznq.zzc(googleapiclient, subscription) {

            final zzor zzarC;
            final Subscription zzarD;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zznq)zzb);
            }

            protected void zza(zznq zznq1)
                throws RemoteException
            {
                zzou zzou1 = new zzou(this);
                ((zzob)zznq1.zzpc()).zza(new SubscribeRequest(zzarD, false, zzou1));
            }

            
            {
                zzarC = zzor.this;
                zzarD = subscription;
                super(googleapiclient);
            }
        });
    }

    public PendingResult listSubscriptions(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zza(new zznq.zza(googleapiclient) {

            final zzor zzarC;

            protected ListSubscriptionsResult zzL(Status status)
            {
                return ListSubscriptionsResult.zzS(status);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zznq)zzb1);
            }

            protected void zza(zznq zznq1)
                throws RemoteException
            {
                zza zza1 = new zza(this);
                ((zzob)zznq1.zzpc()).zza(new ListSubscriptionsRequest(null, zza1));
            }

            protected Result zzb(Status status)
            {
                return zzL(status);
            }

            
            {
                zzarC = zzor.this;
                super(googleapiclient);
            }
        });
    }

    public PendingResult listSubscriptions(GoogleApiClient googleapiclient, DataType datatype)
    {
        return googleapiclient.zza(new zznq.zza(googleapiclient, datatype) {

            final zzor zzarC;
            final DataType zzary;

            protected ListSubscriptionsResult zzL(Status status)
            {
                return ListSubscriptionsResult.zzS(status);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zznq)zzb1);
            }

            protected void zza(zznq zznq1)
                throws RemoteException
            {
                zza zza1 = new zza(this);
                ((zzob)zznq1.zzpc()).zza(new ListSubscriptionsRequest(zzary, zza1));
            }

            protected Result zzb(Status status)
            {
                return zzL(status);
            }

            
            {
                zzarC = zzor.this;
                zzary = datatype;
                super(googleapiclient);
            }
        });
    }

    public PendingResult subscribe(GoogleApiClient googleapiclient, DataSource datasource)
    {
        return zza(googleapiclient, (new com.google.android.gms.fitness.data.Subscription.zza()).zzb(datasource).zzsD());
    }

    public PendingResult subscribe(GoogleApiClient googleapiclient, DataType datatype)
    {
        return zza(googleapiclient, (new com.google.android.gms.fitness.data.Subscription.zza()).zzb(datatype).zzsD());
    }

    public PendingResult unsubscribe(GoogleApiClient googleapiclient, DataSource datasource)
    {
        return googleapiclient.zzb(new zznq.zzc(googleapiclient, datasource) {

            final zzor zzarC;
            final DataSource zzarE;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zznq)zzb);
            }

            protected void zza(zznq zznq1)
                throws RemoteException
            {
                zzou zzou1 = new zzou(this);
                ((zzob)zznq1.zzpc()).zza(new UnsubscribeRequest(null, zzarE, zzou1));
            }

            
            {
                zzarC = zzor.this;
                zzarE = datasource;
                super(googleapiclient);
            }
        });
    }

    public PendingResult unsubscribe(GoogleApiClient googleapiclient, DataType datatype)
    {
        return googleapiclient.zzb(new zznq.zzc(googleapiclient, datatype) {

            final zzor zzarC;
            final DataType zzary;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zznq)zzb);
            }

            protected void zza(zznq zznq1)
                throws RemoteException
            {
                zzou zzou1 = new zzou(this);
                ((zzob)zznq1.zzpc()).zza(new UnsubscribeRequest(zzary, null, zzou1));
            }

            
            {
                zzarC = zzor.this;
                zzary = datatype;
                super(googleapiclient);
            }
        });
    }

    public PendingResult unsubscribe(GoogleApiClient googleapiclient, Subscription subscription)
    {
        if (subscription.getDataType() == null)
        {
            return unsubscribe(googleapiclient, subscription.getDataSource());
        } else
        {
            return unsubscribe(googleapiclient, subscription.getDataType());
        }
    }
}
