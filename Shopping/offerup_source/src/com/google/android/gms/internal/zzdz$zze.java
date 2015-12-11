// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.internal:
//            zzit

public class zzyI extends zzit
{

    private final Object zzpd = new Object();
    private boolean zzyH;
    private int zzyI;
    private client.zzb.v zzyq;

    static zzyI zza(zzyI zzyi)
    {
        return zzyi.zzyq;
    }

    public zzyq zzdP()
    {
        _cls2.zzyJ zzyj = new <init>(this);
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        class _cls1
            implements zzis.zzc
        {

            final zzdz.zzd zzyJ;
            final zzdz.zze zzyK;

            public void zza(zzbb zzbb1)
            {
                zzb.v("Getting a new session for JS Engine.");
                zzyJ.zzg(zzbb1.zzci());
            }

            public void zzc(Object obj1)
            {
                zza((zzbb)obj1);
            }

            _cls1(zzdz.zzd zzd)
            {
                zzyK = zzdz.zze.this;
                zzyJ = zzd;
                super();
            }
        }

        class _cls2
            implements zzis.zza
        {

            final zzdz.zzd zzyJ;
            final zzdz.zze zzyK;

            public void run()
            {
                zzb.v("Rejecting reference for JS Engine.");
                zzyJ.reject();
            }

            _cls2(zzdz.zzd zzd)
            {
                zzyK = zzdz.zze.this;
                zzyJ = zzd;
                super();
            }
        }

        zza(new _cls1(zzyj), new _cls2(zzyj));
        Exception exception;
        boolean flag;
        if (zzyI >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzZ(flag);
        zzyI = zzyI + 1;
        obj;
        JVM INSTR monitorexit ;
        return zzyj;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void zzdQ()
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (zzyI > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzZ(flag);
        zzb.v("Releasing 1 reference for JS Engine");
        zzyI = zzyI - 1;
        zzdS();
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzdR()
    {
        boolean flag = true;
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        if (zzyI < 0)
        {
            flag = false;
        }
        zzx.zzZ(flag);
        zzb.v("Releasing root reference. JS Engine will be destroyed once other references are released.");
        zzyH = true;
        zzdS();
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void zzdS()
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        class _cls3
            implements zzis.zzc
        {

            final zzdz.zze zzyK;

            public void zza(zzbb zzbb1)
            {
                class _cls1
                    implements Runnable
                {

                    final zzbb zzrE;
                    final _cls3 zzyL;

                    public void run()
                    {
                        zzdz.zze.zza(zzyL.zzyK).zzc(zzrE);
                        zzrE.destroy();
                    }

                        _cls1(zzbb zzbb1)
                        {
                            zzyL = _cls3.this;
                            zzrE = zzbb1;
                            super();
                        }
                }

                zzid.runOnUiThread(new _cls1(zzbb1));
            }

            public void zzc(Object obj1)
            {
                zza((zzbb)obj1);
            }

            _cls3()
            {
                zzyK = zzdz.zze.this;
                super();
            }
        }

        Exception exception;
        boolean flag;
        if (zzyI >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzZ(flag);
        if (!zzyH || zzyI != 0)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        zzb.v("No reference is left (including root). Cleaning up engine.");
        zza(new _cls3(), new <init>());
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        zzb.v("There are still references to the engine. Not destroying.");
        if (true) goto _L2; else goto _L1
_L1:
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public _cls3(_cls3 _pcls3)
    {
        zzyq = _pcls3;
        zzyH = false;
        zzyI = 0;
    }
}
