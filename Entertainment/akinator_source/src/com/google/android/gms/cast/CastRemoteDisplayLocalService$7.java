// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.common.ConnectionResult;

// Referenced classes of package com.google.android.gms.cast:
//            CastRemoteDisplayLocalService

class zzVH
    implements com.google.android.gms.common.api.edListener
{

    final CastRemoteDisplayLocalService zzVH;

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        CastRemoteDisplayLocalService.zzb(zzVH, (new StringBuilder()).append("Connection failed: ").append(connectionresult).toString());
        CastRemoteDisplayLocalService.zzc(zzVH);
    }

    onFailedListener(CastRemoteDisplayLocalService castremotedisplaylocalservice)
    {
        zzVH = castremotedisplaylocalservice;
        super();
    }
}
