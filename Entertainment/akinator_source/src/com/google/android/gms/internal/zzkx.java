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
//            zzkz, zzky, zzla

public class zzkx extends zzj
    implements android.os.IBinder.DeathRecipient
{

    private static final zzl zzVo = new zzl("CastRemoteDisplayClientImpl");
    private CastDevice zzUY;
    private com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionCallbacks zzZT;

    public zzkx(Context context, Looper looper, zzf zzf, CastDevice castdevice, com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionCallbacks castremotedisplaysessioncallbacks, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        super(context, looper, 83, zzf, connectioncallbacks, onconnectionfailedlistener);
        zzVo.zzb("instance created", new Object[0]);
        zzZT = castremotedisplaysessioncallbacks;
        zzUY = castdevice;
    }

    static com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionCallbacks zzb(zzkx zzkx1)
    {
        return zzkx1.zzZT;
    }

    static zzl zznm()
    {
        return zzVo;
    }

    public void binderDied()
    {
    }

    public void disconnect()
    {
        zzVo.zzb("disconnect", new Object[0]);
        zzZT = null;
        zzUY = null;
        ((zzkz)zzpc()).disconnect();
        super.disconnect();
        return;
        Object obj;
        obj;
_L2:
        super.disconnect();
        return;
        obj;
        super.disconnect();
        throw obj;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public IInterface zzW(IBinder ibinder)
    {
        return zzaC(ibinder);
    }

    public void zza(zzky zzky)
        throws RemoteException
    {
        zzVo.zzb("stopRemoteDisplay", new Object[0]);
        ((zzkz)zzpc()).zza(zzky);
    }

    public void zza(zzky zzky, int i)
        throws RemoteException
    {
        ((zzkz)zzpc()).zza(zzky, i);
    }

    public void zza(zzky zzky, zzla zzla, String s)
        throws RemoteException
    {
        zzVo.zzb("startRemoteDisplay", new Object[0]);
        zzla = new zzla.zza(zzla) {

            final zzla zzZU;
            final zzkx zzZV;

            public void zzbg(int i)
                throws RemoteException
            {
                zzkx.zznm().zzb("onRemoteDisplayEnded", new Object[0]);
                if (zzZU != null)
                {
                    zzZU.zzbg(i);
                }
                if (zzkx.zzb(zzZV) != null)
                {
                    zzkx.zzb(zzZV).onRemoteDisplayEnded(new Status(i));
                }
            }

            
            {
                zzZV = zzkx.this;
                zzZU = zzla1;
                super();
            }
        };
        ((zzkz)zzpc()).zza(zzky, zzla, zzUY.getDeviceId(), s);
    }

    public zzkz zzaC(IBinder ibinder)
    {
        return zzkz.zza.zzaE(ibinder);
    }

    protected String zzfK()
    {
        return "com.google.android.gms.cast.remote_display.service.START";
    }

    protected String zzfL()
    {
        return "com.google.android.gms.cast.remote_display.ICastRemoteDisplayService";
    }

}
