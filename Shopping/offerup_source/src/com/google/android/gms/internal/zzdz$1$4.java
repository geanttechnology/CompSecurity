// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package com.google.android.gms.internal:
//            zzdz, zzid, zzbb

class zzyv
    implements Runnable
{

    final zzbb zzyv;
    final client.zzb.v zzyw;

    public void run()
    {
label0:
        {
            synchronized (zzdz.zzc(zzyw.yu))
            {
                if (zzyw.yt.getStatus() != -1 && zzyw.yt.getStatus() != 1)
                {
                    break label0;
                }
            }
            return;
        }
        zzyw.yt.reject();
        class _cls1
            implements Runnable
        {

            final zzdz._cls1._cls4 zzyA;

            public void run()
            {
                zzyA.zzyv.destroy();
            }

            _cls1()
            {
                zzyA = zzdz._cls1._cls4.this;
                super();
            }
        }

        zzid.runOnUiThread(new _cls1());
        zzb.v("Could not receive loaded message in a timely manner. Rejecting.");
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    client.zzb(client.zzb zzb1, zzbb zzbb)
    {
        zzyw = zzb1;
        zzyv = zzbb;
        super();
    }
}
