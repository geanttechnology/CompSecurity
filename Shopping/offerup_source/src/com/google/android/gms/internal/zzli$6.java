// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            zzlo, zzli

class zzacv
    implements com.google.android.gms.common.api.piClient.OnConnectionFailedListener
{

    final zzli zzacr;
    final zzlo zzacv;

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        zzacv.zzb(new Status(8));
    }

    nResult(zzli zzli, zzlo zzlo1)
    {
        zzacr = zzli;
        zzacv = zzlo1;
        super();
    }
}
