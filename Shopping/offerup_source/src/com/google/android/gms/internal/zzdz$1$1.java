// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;

// Referenced classes of package com.google.android.gms.internal:
//            zzid, zzbb

class zzyv
    implements zzyv
{

    final zzbb zzyv;
    final zzyD zzyw;

    public void zzcj()
    {
        class _cls1
            implements Runnable
        {

            final zzdz._cls1._cls1 zzyx;

            public void run()
            {
label0:
                {
                    synchronized (zzdz.zzc(zzyx.zzyw.zzyu))
                    {
                        if (zzyx.zzyw.zzyt.getStatus() != -1 && zzyx.zzyw.zzyt.getStatus() != 1)
                        {
                            break label0;
                        }
                    }
                    return;
                }
                zzyx.zzyw.zzyt.reject();
                class _cls1
                    implements Runnable
                {

                    final _cls1 zzyy;

                    public void run()
                    {
                        zzyy.zzyx.zzyv.destroy();
                    }

                        _cls1()
                        {
                            zzyy = _cls1.this;
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

            _cls1()
            {
                zzyx = zzdz._cls1._cls1.this;
                super();
            }
        }

        zzid.zzIE.postDelayed(new _cls1(), zzyD);
    }

    _cls1(_cls1 _pcls1, zzbb zzbb)
    {
        zzyw = _pcls1;
        zzyv = zzbb;
        super();
    }
}
