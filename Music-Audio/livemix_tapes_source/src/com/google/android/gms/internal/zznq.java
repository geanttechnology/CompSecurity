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
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.ListSubscriptionsRequest;
import com.google.android.gms.fitness.request.SubscribeRequest;
import com.google.android.gms.fitness.request.UnsubscribeRequest;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

// Referenced classes of package com.google.android.gms.internal:
//            zzmo, zzmz, zznt

public class zznq
    implements RecordingApi
{
    private static class zza extends zznc.zza
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zza(ListSubscriptionsResult listsubscriptionsresult)
        {
            zzQz.zzn(listsubscriptionsresult);
        }

        private zza(com.google.android.gms.common.api.zzc.zzb zzb)
        {
            zzQz = zzb;
        }

    }


    public zznq()
    {
    }

    private PendingResult zza(GoogleApiClient googleapiclient, Subscription subscription)
    {
        return googleapiclient.zza(new zzmo.zzc(googleapiclient, subscription) {

            final zznq zzapf;
            final Subscription zzapg;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzmo)zzb);
            }

            protected void zza(zzmo zzmo1)
                throws RemoteException
            {
                zznt zznt1 = new zznt(this);
                String s = zzmo1.getContext().getPackageName();
                ((zzmz)zzmo1.zzoA()).zza(new SubscribeRequest(zzapg, false, zznt1, s));
            }

            
            {
                zzapf = zznq.this;
                zzapg = subscription;
                super(googleapiclient);
            }
        });
    }

    public PendingResult listSubscriptions(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zza(new zzmo.zza(googleapiclient) {

            final zznq zzapf;

            protected ListSubscriptionsResult zzL(Status status)
            {
                return ListSubscriptionsResult.zzT(status);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzmo)zzb1);
            }

            protected void zza(zzmo zzmo1)
                throws RemoteException
            {
                zza zza1 = new zza(this);
                String s = zzmo1.getContext().getPackageName();
                ((zzmz)zzmo1.zzoA()).zza(new ListSubscriptionsRequest(null, zza1, s));
            }

            protected Result zzb(Status status)
            {
                return zzL(status);
            }

            
            {
                zzapf = zznq.this;
                super(googleapiclient);
            }
        });
    }

    public PendingResult listSubscriptions(GoogleApiClient googleapiclient, DataType datatype)
    {
        return googleapiclient.zza(new zzmo.zza(googleapiclient, datatype) {

            final DataType zzapb;
            final zznq zzapf;

            protected ListSubscriptionsResult zzL(Status status)
            {
                return ListSubscriptionsResult.zzT(status);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzmo)zzb1);
            }

            protected void zza(zzmo zzmo1)
                throws RemoteException
            {
                zza zza1 = new zza(this);
                String s = zzmo1.getContext().getPackageName();
                ((zzmz)zzmo1.zzoA()).zza(new ListSubscriptionsRequest(zzapb, zza1, s));
            }

            protected Result zzb(Status status)
            {
                return zzL(status);
            }

            
            {
                zzapf = zznq.this;
                zzapb = datatype;
                super(googleapiclient);
            }
        });
    }

    public PendingResult subscribe(GoogleApiClient googleapiclient, DataSource datasource)
    {
        return zza(googleapiclient, (new com.google.android.gms.fitness.data.Subscription.zza()).zzb(datasource).zzrR());
    }

    public PendingResult subscribe(GoogleApiClient googleapiclient, DataType datatype)
    {
        return zza(googleapiclient, (new com.google.android.gms.fitness.data.Subscription.zza()).zzb(datatype).zzrR());
    }

    public PendingResult unsubscribe(GoogleApiClient googleapiclient, DataSource datasource)
    {
        return googleapiclient.zzb(new zzmo.zzc(googleapiclient, datasource) {

            final zznq zzapf;
            final DataSource zzaph;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzmo)zzb);
            }

            protected void zza(zzmo zzmo1)
                throws RemoteException
            {
                zznt zznt1 = new zznt(this);
                String s = zzmo1.getContext().getPackageName();
                ((zzmz)zzmo1.zzoA()).zza(new UnsubscribeRequest(null, zzaph, zznt1, s));
            }

            
            {
                zzapf = zznq.this;
                zzaph = datasource;
                super(googleapiclient);
            }
        });
    }

    public PendingResult unsubscribe(GoogleApiClient googleapiclient, DataType datatype)
    {
        return googleapiclient.zzb(new zzmo.zzc(googleapiclient, datatype) {

            final DataType zzapb;
            final zznq zzapf;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzmo)zzb);
            }

            protected void zza(zzmo zzmo1)
                throws RemoteException
            {
                zznt zznt1 = new zznt(this);
                String s = zzmo1.getContext().getPackageName();
                ((zzmz)zzmo1.zzoA()).zza(new UnsubscribeRequest(zzapb, null, zznt1, s));
            }

            
            {
                zzapf = zznq.this;
                zzapb = datatype;
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
