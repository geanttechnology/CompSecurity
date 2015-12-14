// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.Bundle;
import com.google.android.gms.cast.internal.zzl;

// Referenced classes of package com.google.android.gms.cast:
//            CastRemoteDisplayLocalService

class zzTR
    implements com.google.android.gms.common.api.cks
{

    final CastRemoteDisplayLocalService zzTR;

    public void onConnected(Bundle bundle)
    {
        CastRemoteDisplayLocalService.zza(zzTR, "onConnected");
        CastRemoteDisplayLocalService.zzf(zzTR);
    }

    public void onConnectionSuspended(int i)
    {
        CastRemoteDisplayLocalService.zzlV().zzf(String.format("[Instance: %s] ConnectionSuspended %d", new Object[] {
            this, Integer.valueOf(i)
        }), new Object[0]);
    }

    Callbacks(CastRemoteDisplayLocalService castremotedisplaylocalservice)
    {
        zzTR = castremotedisplaylocalservice;
        super();
    }
}
