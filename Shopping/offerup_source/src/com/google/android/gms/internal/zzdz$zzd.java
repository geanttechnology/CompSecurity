// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzit

public class zzyE extends zzit
{

    private final Object zzpd = new Object();
    private final _cls3 zzyE;
    private boolean zzyF;

    static zzyE zza(zzyE zzye)
    {
        return zzye.zzyE;
    }

    public void release()
    {
label0:
        {
            synchronized (zzpd)
            {
                if (!zzyF)
                {
                    break label0;
                }
            }
            return;
        }
        zzyF = true;
        class _cls1
            implements zzis.zzc
        {

            final zzdz.zzd zzyG;

            public void zzb(zzbe zzbe1)
            {
                com.google.android.gms.ads.internal.util.client.zzb.v("Ending javascript session.");
                ((zzbf)zzbe1).zzck();
            }

            public void zzc(Object obj1)
            {
                zzb((zzbe)obj1);
            }

            _cls1()
            {
                zzyG = zzdz.zzd.this;
                super();
            }
        }

        zza(new _cls1(), new <init>());
        class _cls2
            implements zzis.zzc
        {

            final zzdz.zzd zzyG;

            public void zzb(zzbe zzbe1)
            {
                com.google.android.gms.ads.internal.util.client.zzb.v("Releasing engine reference.");
                zzdz.zzd.zza(zzyG).zzdQ();
            }

            public void zzc(Object obj1)
            {
                zzb((zzbe)obj1);
            }

            _cls2()
            {
                zzyG = zzdz.zzd.this;
                super();
            }
        }

        class _cls3
            implements zzis.zza
        {

            final zzdz.zzd zzyG;

            public void run()
            {
                zzdz.zzd.zza(zzyG).zzdQ();
            }

            _cls3()
            {
                zzyG = zzdz.zzd.this;
                super();
            }
        }

        zza(new _cls2(), new _cls3());
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public _cls3(_cls3 _pcls3)
    {
        zzyE = _pcls3;
    }
}
