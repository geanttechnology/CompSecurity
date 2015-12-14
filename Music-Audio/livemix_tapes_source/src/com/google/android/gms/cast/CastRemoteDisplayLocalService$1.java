// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.support.v7.media.MediaRouter;

// Referenced classes of package com.google.android.gms.cast:
//            CastRemoteDisplayLocalService, CastDevice

class zzTR extends android.support.v7.media.._cls1
{

    final CastRemoteDisplayLocalService zzTR;

    public void onRouteUnselected(MediaRouter mediarouter, android.support.v7.media.._cls1 _pcls1)
    {
        CastRemoteDisplayLocalService.zza(zzTR, "onRouteUnselected");
        if (CastRemoteDisplayLocalService.zza(zzTR) == null)
        {
            CastRemoteDisplayLocalService.zza(zzTR, "onRouteUnselected, no device was selected");
            return;
        }
        if (!CastDevice.getFromBundle(_pcls1.zzTR()).getDeviceId().equals(CastRemoteDisplayLocalService.zza(zzTR).getDeviceId()))
        {
            CastRemoteDisplayLocalService.zza(zzTR, "onRouteUnselected, device does not match");
            return;
        } else
        {
            CastRemoteDisplayLocalService.stopService();
            return;
        }
    }

    A(CastRemoteDisplayLocalService castremotedisplaylocalservice)
    {
        zzTR = castremotedisplaylocalservice;
        super();
    }
}
