// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.common.ConnectionResult;

// Referenced classes of package com.google.android.gms.cast:
//            CastRemoteDisplayLocalService

class zzTR
    implements com.google.android.gms.common.api.edListener
{

    final CastRemoteDisplayLocalService zzTR;

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        CastRemoteDisplayLocalService.zzb(zzTR, (new StringBuilder()).append("Connection failed: ").append(connectionresult).toString());
        CastRemoteDisplayLocalService.zzc(zzTR);
    }

    onFailedListener(CastRemoteDisplayLocalService castremotedisplaylocalservice)
    {
        zzTR = castremotedisplaylocalservice;
        super();
    }
}
