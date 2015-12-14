// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.sharing.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

// Referenced classes of package com.google.android.gms.nearby.sharing.internal:
//            zzd

class zze extends zzj
{

    public zze(Context context, Looper looper, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, zzf zzf)
    {
        super(context, looper, 49, zzf, connectioncallbacks, onconnectionfailedlistener);
    }

    protected IInterface zzV(IBinder ibinder)
    {
        return zzdp(ibinder);
    }

    protected zzd zzdp(IBinder ibinder)
    {
        return zzd.zza.zzdo(ibinder);
    }

    protected String zzfA()
    {
        return "com.google.android.gms.nearby.sharing.service.NearbySharingService.START";
    }

    protected String zzfB()
    {
        return "com.google.android.gms.nearby.sharing.internal.INearbySharingService";
    }
}
