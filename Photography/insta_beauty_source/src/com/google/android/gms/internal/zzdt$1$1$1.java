// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.TimerTask;

// Referenced classes of package com.google.android.gms.internal:
//            zzdt, zzhl

class zzwX extends TimerTask
{

    final ient.zzb.zzaB zzwX;

    public void run()
    {
label0:
        {
            synchronized (zzdt.zzc(zzwX.wW.))
            {
                if (zzwX.wW..tStatus() != -1 && zzwX.wW..tStatus() != 1)
                {
                    break label0;
                }
            }
            return;
        }
        zzwX.wW..ject();
        class _cls1
            implements Runnable
        {

            final zzdt._cls1._cls1._cls1 zzwY;

            public void run()
            {
                zzwY.zzwX.zzwV.destroy();
            }

            _cls1()
            {
                zzwY = zzdt._cls1._cls1._cls1.this;
                super();
            }
        }

        zzhl.runOnUiThread(new _cls1());
        zzb.zzaB("Could not receive loaded message in a timely manner. Rejecting.");
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
        zzwX = zzb1;
        super();
    }
}
