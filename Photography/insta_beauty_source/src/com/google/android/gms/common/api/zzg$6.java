// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import com.google.android.gms.common.ConnectionResult;

// Referenced classes of package com.google.android.gms.common.api:
//            Status, zzl, zzg

class zzXI
    implements ApiClient.OnConnectionFailedListener
{

    final zzg zzXE;
    final zzl zzXI;

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        zzXI.setResult(new Status(8));
    }

    Result(zzg zzg, zzl zzl1)
    {
        zzXE = zzg;
        zzXI = zzl1;
        super();
    }
}
