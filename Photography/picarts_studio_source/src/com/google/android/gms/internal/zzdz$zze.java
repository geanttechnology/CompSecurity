// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.internal:
//            zzit, zzbb, zzid

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
        zzyq zzyq1 = new <init>(this);
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        zza(new zzis.zzc(zzyq1) {

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

            
            {
                zzyK = zzdz.zze.this;
                zzyJ = zzd;
                super();
            }
        }, new zzis.zza(zzyq1) {

            final zzdz.zzd zzyJ;
            final zzdz.zze zzyK;

            public void run()
            {
                zzb.v("Rejecting reference for JS Engine.");
                zzyJ.reject();
            }

            
            {
                zzyK = zzdz.zze.this;
                zzyJ = zzd;
                super();
            }
        });
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
        return zzyq1;
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
        zza(new zzis.zzc() {

            final zzdz.zze zzyK;

            public void zza(zzbb zzbb1)
            {
                zzid.runOnUiThread(new Runnable(this, zzbb1) {

                    final zzbb zzrE;
                    final _cls3 zzyL;

                    public void run()
                    {
                        zzdz.zze.zza(zzyL.zzyK).zzc(zzrE);
                        zzrE.destroy();
                    }

            
            {
                zzyL = _pcls3;
                zzrE = zzbb1;
                super();
            }
                });
            }

            public void zzc(Object obj1)
            {
                zza((zzbb)obj1);
            }

            
            {
                zzyK = zzdz.zze.this;
                super();
            }
        }, new <init>());
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

    public _cls3.zzyK(_cls3.zzyK zzyk)
    {
        zzyq = zzyk;
        zzyH = false;
        zzyI = 0;
    }
}
