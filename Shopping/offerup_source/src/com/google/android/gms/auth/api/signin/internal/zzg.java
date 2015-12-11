// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.auth.api.signin.internal:
//            zze

public class zzg extends zzj
{

    private final com.google.android.gms.auth.api.signin.zzg zzTq;

    public zzg(Context context, Looper looper, zzf zzf, com.google.android.gms.auth.api.signin.zzg zzg1, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        super(context, looper, 87, zzf, connectioncallbacks, onconnectionfailedlistener);
        zzTq = (com.google.android.gms.auth.api.signin.zzg)zzx.zzw(zzg1);
    }

    protected IInterface zzW(IBinder ibinder)
    {
        return zzax(ibinder);
    }

    protected zze zzax(IBinder ibinder)
    {
        return zze.zza.zzaz(ibinder);
    }

    protected String zzfK()
    {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    protected String zzfL()
    {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }
}
