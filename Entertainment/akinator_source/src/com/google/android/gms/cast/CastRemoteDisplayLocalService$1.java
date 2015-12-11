// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.support.v7.media.MediaRouter;

// Referenced classes of package com.google.android.gms.cast:
//            CastRemoteDisplayLocalService, CastDevice

class zzVH extends android.support.v7.media.._cls1
{

    final CastRemoteDisplayLocalService zzVH;

    public void onRouteUnselected(MediaRouter mediarouter, android.support.v7.media.._cls1 _pcls1)
    {
        CastRemoteDisplayLocalService.zza(zzVH, "onRouteUnselected");
        if (CastRemoteDisplayLocalService.zza(zzVH) == null)
        {
            CastRemoteDisplayLocalService.zza(zzVH, "onRouteUnselected, no device was selected");
            return;
        }
        if (!CastDevice.getFromBundle(_pcls1.zzVH()).getDeviceId().equals(CastRemoteDisplayLocalService.zza(zzVH).getDeviceId()))
        {
            CastRemoteDisplayLocalService.zza(zzVH, "onRouteUnselected, device does not match");
            return;
        } else
        {
            CastRemoteDisplayLocalService.stopService();
            return;
        }
    }

    A(CastRemoteDisplayLocalService castremotedisplaylocalservice)
    {
        zzVH = castremotedisplaylocalservice;
        super();
    }
}
