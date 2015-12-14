// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzhy

public class zzxe extends zzhy
{

    private final Object zzqt = new Object();
    private final _cls3 zzxe;
    private boolean zzxf;

    static zzxe zza(zzxe zzxe1)
    {
        return zzxe1.zzxe;
    }

    public void release()
    {
label0:
        {
            synchronized (zzqt)
            {
                if (!zzxf)
                {
                    break label0;
                }
            }
            return;
        }
        zzxf = true;
        class _cls1
            implements zzhx.zzc
        {

            final zzdt.zzd zzxg;

            public void zzb(zzbe zzbe1)
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzaB("Ending javascript session.");
                ((zzbf)zzbe1).zzcg();
            }

            public void zzc(Object obj1)
            {
                zzb((zzbe)obj1);
            }

            _cls1()
            {
                zzxg = zzdt.zzd.this;
                super();
            }
        }

        zza(new _cls1(), new <init>());
        class _cls2
            implements zzhx.zzc
        {

            final zzdt.zzd zzxg;

            public void zzb(zzbe zzbe1)
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzaB("Releasing engine reference.");
                zzdt.zzd.zza(zzxg).zzdW();
            }

            public void zzc(Object obj1)
            {
                zzb((zzbe)obj1);
            }

            _cls2()
            {
                zzxg = zzdt.zzd.this;
                super();
            }
        }

        class _cls3
            implements zzhx.zza
        {

            final zzdt.zzd zzxg;

            public void run()
            {
                zzdt.zzd.zza(zzxg).zzdW();
            }

            _cls3()
            {
                zzxg = zzdt.zzd.this;
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
        zzxe = _pcls3;
    }
}
