// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzp, zzi

public class zzb extends zzj
{

    private final String zzaFa;
    protected final zzp zzaFb = new zzp() {

        final zzb zzaFc;

        public void zzpb()
        {
            zzb.zza(zzaFc);
        }

        public IInterface zzpc()
            throws DeadObjectException
        {
            return zzwB();
        }

        public zzi zzwB()
            throws DeadObjectException
        {
            return (zzi)zzaFc.zzpc();
        }

            
            {
                zzaFc = zzb.this;
                super();
            }
    };

    public zzb(Context context, Looper looper, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, String s, zzf zzf)
    {
        super(context, looper, 23, zzf, connectioncallbacks, onconnectionfailedlistener);
        zzaFa = s;
    }

    static void zza(zzb zzb1)
    {
        zzb1.zzpb();
    }

    protected IInterface zzW(IBinder ibinder)
    {
        return zzbY(ibinder);
    }

    protected zzi zzbY(IBinder ibinder)
    {
        return zzi.zza.zzcb(ibinder);
    }

    protected String zzfK()
    {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    protected String zzfL()
    {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    protected Bundle zzly()
    {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", zzaFa);
        return bundle;
    }
}
