// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package com.google.android.gms.internal:
//            zzdz, zzid

class zzyx
    implements Runnable
{

    final ient.zzb.v zzyx;

    public void run()
    {
label0:
        {
            synchronized (zzdz.zzc(zzyx.yw.))
            {
                if (zzyx.yw..tStatus() != -1 && zzyx.yw..tStatus() != 1)
                {
                    break label0;
                }
            }
            return;
        }
        zzyx.yw..ject();
        class _cls1
            implements Runnable
        {

            final zzdz._cls1._cls1._cls1 zzyy;

            public void run()
            {
                zzyy.zzyx.zzyv.destroy();
            }

            _cls1()
            {
                zzyy = zzdz._cls1._cls1._cls1.this;
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

    ient.zzb(ient.zzb zzb1)
    {
        zzyx = zzb1;
        super();
    }
}
