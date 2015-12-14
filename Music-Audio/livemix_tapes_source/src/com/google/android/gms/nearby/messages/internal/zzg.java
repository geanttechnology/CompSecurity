// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.messages.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.Strategy;

// Referenced classes of package com.google.android.gms.nearby.messages.internal:
//            UnsubscribeRequest, zzj, zzd, SubscribeRequest, 
//            UnpublishRequest, PublishRequest, GetPermissionStatusRequest, MessageWrapper

class zzg extends zzj
{
    private static class zza extends zzb.zza
    {

        private final MessageListener zzaJV;

        public void zza(MessageWrapper messagewrapper)
            throws RemoteException
        {
            zzaJV.onFound(messagewrapper.zzaJS);
        }

        public void zzb(MessageWrapper messagewrapper)
            throws RemoteException
        {
            zzaJV.onLost(messagewrapper.zzaJS);
        }

        private zza(MessageListener messagelistener)
        {
            zzaJV = messagelistener;
        }

    }


    private String zzQl;
    private String zzaJT;
    private boolean zzaJU;

    zzg(Context context, Looper looper, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, zzf zzf1, MessagesOptions messagesoptions)
    {
        super(context, looper, 62, zzf1, connectioncallbacks, onconnectionfailedlistener);
        zzQl = zzf1.zzol();
        if (messagesoptions != null)
        {
            zzaJT = messagesoptions.zzaCr;
            zzaJU = messagesoptions.zzaJJ;
        }
    }

    protected IInterface zzV(IBinder ibinder)
    {
        return zzdk(ibinder);
    }

    void zza(com.google.android.gms.common.api.zzc.zzb zzb, MessageListener messagelistener)
        throws RemoteException
    {
        zzoz();
        zzb = new UnsubscribeRequest(new zza(messagelistener), com.google.android.gms.nearby.messages.internal.zzj.zzj(zzb), null, messagelistener.hashCode(), zzaJT, zzQl);
        ((zzd)zzoA()).zza(zzb);
    }

    void zza(com.google.android.gms.common.api.zzc.zzb zzb, MessageListener messagelistener, Strategy strategy, MessageFilter messagefilter)
        throws RemoteException
    {
        zzoz();
        zzb = new SubscribeRequest(new zza(messagelistener), strategy, com.google.android.gms.nearby.messages.internal.zzj.zzj(zzb), messagefilter, null, messagelistener.hashCode(), zzaJT, zzQl, null, zzaJU);
        ((zzd)zzoA()).zza(zzb);
    }

    void zza(com.google.android.gms.common.api.zzc.zzb zzb, MessageWrapper messagewrapper)
        throws RemoteException
    {
        zzoz();
        zzb = new UnpublishRequest(messagewrapper, com.google.android.gms.nearby.messages.internal.zzj.zzj(zzb), zzaJT, zzQl);
        ((zzd)zzoA()).zza(zzb);
    }

    void zza(com.google.android.gms.common.api.zzc.zzb zzb, MessageWrapper messagewrapper, Strategy strategy)
        throws RemoteException
    {
        zzoz();
        zzb = new PublishRequest(messagewrapper, strategy, com.google.android.gms.nearby.messages.internal.zzj.zzj(zzb), zzaJT, zzQl, zzaJU);
        ((zzd)zzoA()).zza(zzb);
    }

    protected zzd zzdk(IBinder ibinder)
    {
        return zzd.zza.zzdj(ibinder);
    }

    protected String zzfA()
    {
        return "com.google.android.gms.nearby.messages.service.NearbyMessagesService.START";
    }

    protected String zzfB()
    {
        return "com.google.android.gms.nearby.messages.internal.INearbyMessagesService";
    }

    void zzi(com.google.android.gms.common.api.zzc.zzb zzb)
        throws RemoteException
    {
        zzoz();
        zzb = new GetPermissionStatusRequest(com.google.android.gms.nearby.messages.internal.zzj.zzj(zzb), zzaJT);
        ((zzd)zzoA()).zza(zzb);
    }
}
