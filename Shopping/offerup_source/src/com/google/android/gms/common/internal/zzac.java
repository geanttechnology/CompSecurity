// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

// Referenced classes of package com.google.android.gms.common.internal:
//            zzj, zzf

public class zzac extends zzj
{

    private final com.google.android.gms.common.api.Api.zzd zzagt;

    public zzac(Context context, Looper looper, int i, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, zzf zzf, com.google.android.gms.common.api.Api.zzd zzd)
    {
        super(context, looper, i, zzf, connectioncallbacks, onconnectionfailedlistener);
        zzagt = zzd;
    }

    protected IInterface zzW(IBinder ibinder)
    {
        return zzagt.zzW(ibinder);
    }

    protected void zzc(int i, IInterface iinterface)
    {
        zzagt.zza(i, iinterface);
    }

    protected String zzfK()
    {
        return zzagt.zzfK();
    }

    protected String zzfL()
    {
        return zzagt.zzfL();
    }
}
