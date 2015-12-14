// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

// Referenced classes of package com.google.android.gms.internal:
//            zzph

public class zzpj extends zzj
{

    public zzpj(Context context, Looper looper, zzf zzf, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        super(context, looper, 3, zzf, connectioncallbacks, onconnectionfailedlistener);
    }

    public IInterface zzV(IBinder ibinder)
    {
        return zzds(ibinder);
    }

    public zzph zzds(IBinder ibinder)
    {
        return zzph.zza.zzdr(ibinder);
    }

    protected String zzfA()
    {
        return "com.google.android.gms.panorama.service.START";
    }

    protected String zzfB()
    {
        return "com.google.android.gms.panorama.internal.IPanoramaService";
    }
}
