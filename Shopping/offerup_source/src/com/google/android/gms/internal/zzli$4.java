// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import java.util.concurrent.locks.Lock;

// Referenced classes of package com.google.android.gms.internal:
//            zzli, zzlj

class zzact
    implements com.google.android.gms.common.api.piClient.OnConnectionFailedListener
{

    final zzli zzacr;
    final Api zzacs;
    final int zzact;

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        zzli.zzb(zzacr).lock();
        zzli.zzc(zzacr).zza(connectionresult, zzacs, zzact);
        zzli.zzb(zzacr).unlock();
        return;
        connectionresult;
        zzli.zzb(zzacr).unlock();
        throw connectionresult;
    }

    nResult(zzli zzli1, Api api, int i)
    {
        zzacr = zzli1;
        zzacs = api;
        zzact = i;
        super();
    }
}
