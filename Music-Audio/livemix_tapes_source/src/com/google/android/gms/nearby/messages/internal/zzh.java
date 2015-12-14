// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.messages.internal;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.Strategy;

// Referenced classes of package com.google.android.gms.nearby.messages.internal:
//            zzg, MessageWrapper

public class zzh
    implements Messages
{
    static abstract class zza extends com.google.android.gms.common.api.zzc.zza
    {

        public Result zzb(Status status)
        {
            return zzd(status);
        }

        public Status zzd(Status status)
        {
            return status;
        }

        public zza(GoogleApiClient googleapiclient)
        {
            super(zzh.zzQf, googleapiclient);
        }
    }


    public static final com.google.android.gms.common.api.Api.zzc zzQf = new com.google.android.gms.common.api.Api.zzc();
    public static final com.google.android.gms.common.api.Api.zza zzQg = new com.google.android.gms.common.api.Api.zza() {

        public int getPriority()
        {
            return 0x7fffffff;
        }

        public volatile com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf zzf, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return zza(context, looper, zzf, (MessagesOptions)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public zzg zza(Context context, Looper looper, zzf zzf, MessagesOptions messagesoptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return new zzg(context, looper, connectioncallbacks, onconnectionfailedlistener, zzf, messagesoptions);
        }

    };

    public zzh()
    {
    }

    public PendingResult getPermissionStatus(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zzb(new zza(googleapiclient) {

            final zzh zzaJY;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzg)zzb);
            }

            protected void zza(zzg zzg1)
                throws RemoteException
            {
                zzg1.zzi(this);
            }

            
            {
                zzaJY = zzh.this;
                super(googleapiclient);
            }
        });
    }

    public PendingResult publish(GoogleApiClient googleapiclient, Message message)
    {
        return publish(googleapiclient, message, Strategy.DEFAULT);
    }

    public PendingResult publish(GoogleApiClient googleapiclient, Message message, Strategy strategy)
    {
        zzx.zzv(message);
        zzx.zzv(strategy);
        return googleapiclient.zzb(new zza(googleapiclient, message, strategy) {

            final Message zzaJW;
            final Strategy zzaJX;
            final zzh zzaJY;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzg)zzb);
            }

            protected void zza(zzg zzg1)
                throws RemoteException
            {
                zzg1.zza(this, MessageWrapper.zza(zzaJW), zzaJX);
            }

            
            {
                zzaJY = zzh.this;
                zzaJW = message;
                zzaJX = strategy;
                super(googleapiclient);
            }
        });
    }

    public PendingResult subscribe(GoogleApiClient googleapiclient, MessageListener messagelistener)
    {
        return subscribe(googleapiclient, messagelistener, Strategy.DEFAULT, MessageFilter.INCLUDE_ALL_MY_TYPES);
    }

    public PendingResult subscribe(GoogleApiClient googleapiclient, MessageListener messagelistener, Strategy strategy)
    {
        return subscribe(googleapiclient, messagelistener, strategy, MessageFilter.INCLUDE_ALL_MY_TYPES);
    }

    public PendingResult subscribe(GoogleApiClient googleapiclient, MessageListener messagelistener, Strategy strategy, MessageFilter messagefilter)
    {
        zzx.zzv(messagelistener);
        zzx.zzv(strategy);
        zzx.zzv(messagefilter);
        return googleapiclient.zzb(new zza(googleapiclient, messagelistener, strategy, messagefilter) {

            final Strategy zzaJX;
            final zzh zzaJY;
            final MessageListener zzaJZ;
            final MessageFilter zzaKa;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzg)zzb);
            }

            protected void zza(zzg zzg1)
                throws RemoteException
            {
                zzg1.zza(this, zzaJZ, zzaJX, zzaKa);
            }

            
            {
                zzaJY = zzh.this;
                zzaJZ = messagelistener;
                zzaJX = strategy;
                zzaKa = messagefilter;
                super(googleapiclient);
            }
        });
    }

    public PendingResult unpublish(GoogleApiClient googleapiclient, Message message)
    {
        zzx.zzv(message);
        return googleapiclient.zzb(new zza(googleapiclient, message) {

            final Message zzaJW;
            final zzh zzaJY;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzg)zzb);
            }

            protected void zza(zzg zzg1)
                throws RemoteException
            {
                zzg1.zza(this, MessageWrapper.zza(zzaJW));
            }

            
            {
                zzaJY = zzh.this;
                zzaJW = message;
                super(googleapiclient);
            }
        });
    }

    public PendingResult unsubscribe(GoogleApiClient googleapiclient, MessageListener messagelistener)
    {
        zzx.zzv(messagelistener);
        return googleapiclient.zzb(new zza(googleapiclient, messagelistener) {

            final zzh zzaJY;
            final MessageListener zzaJZ;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzg)zzb);
            }

            protected void zza(zzg zzg1)
                throws RemoteException
            {
                zzg1.zza(this, zzaJZ);
            }

            
            {
                zzaJY = zzh.this;
                zzaJZ = messagelistener;
                super(googleapiclient);
            }
        });
    }

}
