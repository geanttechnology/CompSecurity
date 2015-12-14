// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

// Referenced classes of package com.google.android.gms.ads.internal.request:
//            zzj

public class zze extends zzj
{

    final int zzEl;

    public zze(Context context, Looper looper, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, int i)
    {
        super(context, looper, 8, zzf.zzak(context), connectioncallbacks, onconnectionfailedlistener);
        zzEl = i;
    }

    protected com.google.android.gms.ads.internal.request.zzj zzV(IBinder ibinder)
    {
        return zzj.zza.zzX(ibinder);
    }

    protected IInterface zzW(IBinder ibinder)
    {
        return zzV(ibinder);
    }

    protected String zzfK()
    {
        return "com.google.android.gms.ads.service.START";
    }

    protected String zzfL()
    {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    public com.google.android.gms.ads.internal.request.zzj zzfM()
    {
        return (com.google.android.gms.ads.internal.request.zzj)super.zzpc();
    }
}
