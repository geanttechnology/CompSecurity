// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

// Referenced classes of package com.google.android.gms.internal:
//            zzko, zzkn, zzkp

public class zzkm extends zzj
    implements android.os.IBinder.DeathRecipient
{

    private static final zzl zzTy = new zzl("CastRemoteDisplayClientImpl");
    private CastDevice zzTj;
    private com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionCallbacks zzYd;

    public zzkm(Context context, Looper looper, zzf zzf, CastDevice castdevice, com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionCallbacks castremotedisplaysessioncallbacks, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        super(context, looper, 83, zzf, connectioncallbacks, onconnectionfailedlistener);
        zzTy.zzb("instance created", new Object[0]);
        zzYd = castremotedisplaysessioncallbacks;
        zzTj = castdevice;
    }

    static com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionCallbacks zzb(zzkm zzkm1)
    {
        return zzkm1.zzYd;
    }

    static zzl zzmQ()
    {
        return zzTy;
    }

    public void binderDied()
    {
    }

    public void disconnect()
    {
        Exception exception;
        zzTy.zzb("disconnect", new Object[0]);
        zzYd = null;
        zzTj = null;
        try
        {
            ((zzko)zzoA()).disconnect();
        }
        catch (RemoteException remoteexception)
        {
            super.disconnect();
            return;
        }
        finally
        {
            super.disconnect();
        }
        super.disconnect();
        return;
        throw exception;
    }

    public IInterface zzV(IBinder ibinder)
    {
        return zzaC(ibinder);
    }

    public void zza(zzkn zzkn)
        throws RemoteException
    {
        zzTy.zzb("stopRemoteDisplay", new Object[0]);
        ((zzko)zzoA()).zza(zzkn);
    }

    public void zza(zzkn zzkn, int i)
        throws RemoteException
    {
        ((zzko)zzoA()).zza(zzkn, i);
    }

    public void zza(zzkn zzkn, zzkp zzkp, String s)
        throws RemoteException
    {
        zzTy.zzb("startRemoteDisplay", new Object[0]);
        zzkp = new zzkp.zza(zzkp) {

            final zzkp zzYe;
            final zzkm zzYf;

            public void zzaZ(int i)
                throws RemoteException
            {
                zzkm.zzmQ().zzb("onRemoteDisplayEnded", new Object[0]);
                if (zzYe != null)
                {
                    zzYe.zzaZ(i);
                }
                if (zzkm.zzb(zzYf) != null)
                {
                    zzkm.zzb(zzYf).onRemoteDisplayEnded(new Status(i));
                }
            }

            
            {
                zzYf = zzkm.this;
                zzYe = zzkp1;
                super();
            }
        };
        ((zzko)zzoA()).zza(zzkn, zzkp, zzTj.getDeviceId(), s);
    }

    public zzko zzaC(IBinder ibinder)
    {
        return zzko.zza.zzaE(ibinder);
    }

    protected String zzfA()
    {
        return "com.google.android.gms.cast.remote_display.service.START";
    }

    protected String zzfB()
    {
        return "com.google.android.gms.cast.remote_display.ICastRemoteDisplayService";
    }

}
