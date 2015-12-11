// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzm

public class zzo extends zzj
{

    public zzo(Context context, Looper looper, zzf zzf, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        super(context, looper, 93, zzf, connectioncallbacks, onconnectionfailedlistener);
    }

    public IInterface zzW(IBinder ibinder)
    {
        return zzda(ibinder);
    }

    public zzm zzda(IBinder ibinder)
    {
        return zzm.zza.zzcZ(ibinder);
    }

    protected String zzfK()
    {
        return "com.google.android.gms.measurement.START";
    }

    protected String zzfL()
    {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }
}
