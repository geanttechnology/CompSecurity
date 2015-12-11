// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.Bundle;
import com.google.android.gms.cast.internal.zzl;

// Referenced classes of package com.google.android.gms.cast:
//            CastRemoteDisplayLocalService

class zzVH
    implements com.google.android.gms.common.api.cks
{

    final CastRemoteDisplayLocalService zzVH;

    public void onConnected(Bundle bundle)
    {
        CastRemoteDisplayLocalService.zza(zzVH, "onConnected");
        CastRemoteDisplayLocalService.zzf(zzVH);
    }

    public void onConnectionSuspended(int i)
    {
        CastRemoteDisplayLocalService.zzms().zzf(String.format("[Instance: %s] ConnectionSuspended %d", new Object[] {
            this, Integer.valueOf(i)
        }), new Object[0]);
    }

    Callbacks(CastRemoteDisplayLocalService castremotedisplaylocalservice)
    {
        zzVH = castremotedisplaylocalservice;
        super();
    }
}
