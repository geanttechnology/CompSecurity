// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Timer;

// Referenced classes of package com.google.android.gms.internal:
//            zzbb

class zzwV
    implements zzwV
{

    final zzbb zzwV;
    final zzxd zzwW;

    public void zzcf()
    {
        class _cls1 extends TimerTask
        {

            final zzdt._cls1._cls1 zzwX;

            public void run()
            {
label0:
                {
                    synchronized (zzdt.zzc(zzwX.zzwW.zzwU))
                    {
                        if (zzwX.zzwW.zzwT.getStatus() != -1 && zzwX.zzwW.zzwT.getStatus() != 1)
                        {
                            break label0;
                        }
                    }
                    return;
                }
                zzwX.zzwW.zzwT.reject();
                class _cls1
                    implements Runnable
                {

                    final _cls1 zzwY;

                    public void run()
                    {
                        zzwY.zzwX.zzwV.destroy();
                    }

                        _cls1()
                        {
                            zzwY = _cls1.this;
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

            _cls1()
            {
                zzwX = zzdt._cls1._cls1.this;
                super();
            }
        }

        (new Timer()).schedule(new _cls1(), zzxd);
    }

    _cls1(_cls1 _pcls1, zzbb zzbb)
    {
        zzwW = _pcls1;
        zzwV = zzbb;
        super();
    }
}
