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
//            zzkd

public class zzkb extends zzj
{

    public zzkb(Context context, Looper looper, zzf zzf, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        super(context, looper, 74, zzf, connectioncallbacks, onconnectionfailedlistener);
    }

    protected IInterface zzW(IBinder ibinder)
    {
        return zzam(ibinder);
    }

    protected zzkd zzam(IBinder ibinder)
    {
        return zzkd.zza.zzao(ibinder);
    }

    protected String zzfK()
    {
        return "com.google.android.gms.auth.api.accountstatus.START";
    }

    protected String zzfL()
    {
        return "com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusService";
    }
}
