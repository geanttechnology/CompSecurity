// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.Handler;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.cast:
//            CastRemoteDisplayLocalService

class zzVH
    implements laySessionCallbacks
{

    final CastRemoteDisplayLocalService zzVH;

    public void onRemoteDisplayEnded(Status status)
    {
        CastRemoteDisplayLocalService.zzms().zzb(String.format("Cast screen has ended: %d", new Object[] {
            Integer.valueOf(status.getStatusCode())
        }), new Object[0]);
        if (CastRemoteDisplayLocalService.zzb(zzVH) != null)
        {
            CastRemoteDisplayLocalService.zzb(zzVH).post(new Runnable() {

                final CastRemoteDisplayLocalService._cls3 zzVM;

                public void run()
                {
                    CastRemoteDisplayLocalService.zzT(false);
                }

            
            {
                zzVM = CastRemoteDisplayLocalService._cls3.this;
                super();
            }
            });
        }
    }

    _cls1.zzVM(CastRemoteDisplayLocalService castremotedisplaylocalservice)
    {
        zzVH = castremotedisplaylocalservice;
        super();
    }
}
