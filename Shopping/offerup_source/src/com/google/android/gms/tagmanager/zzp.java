// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlc;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmp;
import com.google.android.gms.internal.zzra;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzcb, zzcn, zzcm, zzbe, 
//            zzs, zzbg, Container, TagManager, 
//            zzo, zzcd, ContainerHolder

public class zzp extends zzlc
{

    private final Context mContext;
    private final String zzaVQ;
    private long zzaVV;
    private final TagManager zzaWc;
    private final zzd zzaWf;
    private final zzcd zzaWg;
    private final int zzaWh;
    private zzf zzaWi;
    private zzra zzaWj;
    private volatile zzo zzaWk;
    private volatile boolean zzaWl;
    private com.google.android.gms.internal.zzaf.zzj zzaWm;
    private String zzaWn;
    private zze zzaWo;
    private zza zzaWp;
    private final Looper zzaaO;
    private final zzmn zzpW;

    zzp(Context context, TagManager tagmanager, Looper looper, String s, int i, zzf zzf1, zze zze1, 
            zzra zzra1, zzmn zzmn1, zzcd zzcd)
    {
        Looper looper1;
        if (looper == null)
        {
            looper1 = Looper.getMainLooper();
        } else
        {
            looper1 = looper;
        }
        super(looper1);
        mContext = context;
        zzaWc = tagmanager;
        context = looper;
        if (looper == null)
        {
            context = Looper.getMainLooper();
        }
        zzaaO = context;
        zzaVQ = s;
        zzaWh = i;
        zzaWi = zzf1;
        zzaWo = zze1;
        zzaWj = zzra1;
        zzaWf = new zzd(null);
        zzaWm = new com.google.android.gms.internal.zzaf.zzj();
        zzpW = zzmn1;
        zzaWg = zzcd;
        if (zzCB())
        {
            zzeE(zzcb.zzDm().zzDo());
        }
    }

    public zzp(Context context, TagManager tagmanager, Looper looper, String s, int i, zzs zzs1)
    {
        this(context, tagmanager, looper, s, i, ((zzf) (new zzcn(context, s))), ((zze) (new zzcm(context, s, zzs1))), new zzra(context), zzmp.zzqt(), ((zzcd) (new zzbe(30, 0xdbba0L, 5000L, "refreshing", zzmp.zzqt()))));
        zzaWj.zzfm(zzs1.zzCE());
    }

    private boolean zzCB()
    {
        zzcb zzcb1 = zzcb.zzDm();
        return (zzcb1.zzDn() == zzcb.zza.zzaXZ || zzcb1.zzDn() == zzcb.zza.zzaYa) && zzaVQ.equals(zzcb1.getContainerId());
    }

    private void zzU(long l)
    {
        this;
        JVM INSTR monitorenter ;
        if (zzaWo != null) goto _L2; else goto _L1
_L1:
        zzbg.zzaH("Refresh requested, but no network load scheduler.");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        zzaWo.zzf(l, zzaWm.zziS);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    static zzcd zza(zzp zzp1)
    {
        return zzp1.zzaWg;
    }

    private void zza(com.google.android.gms.internal.zzaf.zzj zzj)
    {
        this;
        JVM INSTR monitorenter ;
        if (zzaWi != null)
        {
            com.google.android.gms.internal.zzqz.zza zza1 = new com.google.android.gms.internal.zzqz.zza();
            zza1.zzbai = zzaVV;
            zza1.zziR = new com.google.android.gms.internal.zzaf.zzf();
            zza1.zzbaj = zzj;
            zzaWi.zzb(zza1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        zzj;
        throw zzj;
    }

    private void zza(com.google.android.gms.internal.zzaf.zzj zzj, long l, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (!flag) goto _L2; else goto _L1
_L1:
        flag = zzaWl;
        if (!flag) goto _L2; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        zzo zzo1;
        if (isReady())
        {
            zzo1 = zzaWk;
        }
        zzaWm = zzj;
        zzaVV = l;
        zzU(Math.max(0L, Math.min(0x2932e00L, (zzaVV + 0x2932e00L) - zzpW.currentTimeMillis())));
        zzj = new Container(mContext, zzaWc.getDataLayer(), zzaVQ, l, zzj);
        if (zzaWk != null)
        {
            break; /* Loop/switch isn't completed */
        }
        zzaWk = new zzo(zzaWc, zzaaO, zzj, zzaWf);
_L5:
        if (!isReady() && zzaWp.zzb(zzj))
        {
            zzb(zzaWk);
        }
        if (true) goto _L3; else goto _L4
        zzj;
        throw zzj;
_L4:
        zzaWk.zza(zzj);
          goto _L5
    }

    static void zza(zzp zzp1, long l)
    {
        zzp1.zzU(l);
    }

    static void zza(zzp zzp1, com.google.android.gms.internal.zzaf.zzj zzj)
    {
        zzp1.zza(zzj);
    }

    static void zza(zzp zzp1, com.google.android.gms.internal.zzaf.zzj zzj, long l, boolean flag)
    {
        zzp1.zza(zzj, l, flag);
    }

    private void zzar(boolean flag)
    {
        zzaWi.zza(new zzb(null));
        zzaWo.zza(new zzc(null));
        com.google.android.gms.internal.zzrb.zzc zzc1 = zzaWi.zzjs(zzaWh);
        if (zzc1 != null)
        {
            zzaWk = new zzo(zzaWc, zzaaO, new Container(mContext, zzaWc.getDataLayer(), zzaVQ, 0L, zzc1), zzaWf);
        }
        zzaWp = new _cls3(flag);
        if (zzCB())
        {
            zzaWo.zzf(0L, "");
            return;
        } else
        {
            zzaWi.zzCD();
            return;
        }
    }

    static zzo zzb(zzp zzp1)
    {
        return zzp1.zzaWk;
    }

    static zzmn zzc(zzp zzp1)
    {
        return zzp1.zzpW;
    }

    static boolean zzd(zzp zzp1)
    {
        return zzp1.zzaWl;
    }

    static com.google.android.gms.internal.zzaf.zzj zze(zzp zzp1)
    {
        return zzp1.zzaWm;
    }

    static long zzf(zzp zzp1)
    {
        return zzp1.zzaVV;
    }

    static boolean zzg(zzp zzp1)
    {
        return zzp1.zzCB();
    }

    public void zzCA()
    {
        zzar(true);
    }

    String zzCv()
    {
        this;
        JVM INSTR monitorenter ;
        String s = zzaWn;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public void zzCy()
    {
        Object obj = zzaWi.zzjs(zzaWh);
        if (obj != null)
        {
            obj = new Container(mContext, zzaWc.getDataLayer(), zzaVQ, 0L, ((com.google.android.gms.internal.zzrb.zzc) (obj)));
            zzb(new zzo(zzaWc, zzaaO, ((Container) (obj)), new _cls2()));
        } else
        {
            zzbg.e("Default was requested, but no default container was found");
            zzb(zzbf(new Status(10, "Default was requested, but no default container was found", null)));
        }
        zzaWo = null;
        zzaWi = null;
    }

    public void zzCz()
    {
        zzar(false);
    }

    protected Result zzb(Status status)
    {
        return zzbf(status);
    }

    protected ContainerHolder zzbf(Status status)
    {
        if (zzaWk != null)
        {
            return zzaWk;
        }
        if (status == Status.zzabe)
        {
            zzbg.e("timer expired: setting result to failure");
        }
        return new zzo(status);
    }

    void zzeE(String s)
    {
        this;
        JVM INSTR monitorenter ;
        zzaWn = s;
        if (zzaWo != null)
        {
            zzaWo.zzeH(s);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    private class zzd
        implements zzo.zza
    {

        final zzp zzaWq;

        public String zzCv()
        {
            return zzaWq.zzCv();
        }

        public void zzCx()
        {
            if (zzp.zza(zzaWq).zzkF())
            {
                zzp.zza(zzaWq, 0L);
            }
        }

        public void zzeE(String s)
        {
            zzaWq.zzeE(s);
        }

        private zzd()
        {
            zzaWq = zzp.this;
            super();
        }

        zzd(_cls1 _pcls1)
        {
            this();
        }
    }


    private class zze
        implements Releasable
    {

        public abstract void zza(zzbf zzbf1);

        public abstract void zzeH(String s);

        public abstract void zzf(long l, String s);
    }


    private class zzf
        implements Releasable
    {

        public abstract void zzCD();

        public abstract void zza(zzbf zzbf1);

        public abstract void zzb(com.google.android.gms.internal.zzqz.zza zza1);

        public abstract com.google.android.gms.internal.zzrb.zzc zzjs(int i);
    }


    private class zza
    {

        public abstract boolean zzb(Container container);
    }


    private class zzb
        implements zzbf
    {

        final zzp zzaWq;

        public void zzCC()
        {
        }

        public void zzH(Object obj)
        {
            zza((com.google.android.gms.internal.zzqz.zza)obj);
        }

        public void zza(com.google.android.gms.internal.zzqz.zza zza1)
        {
            com.google.android.gms.internal.zzaf.zzj zzj;
            if (zza1.zzbaj != null)
            {
                zzj = zza1.zzbaj;
            } else
            {
                com.google.android.gms.internal.zzaf.zzf zzf1 = zza1.zziR;
                zzj = new com.google.android.gms.internal.zzaf.zzj();
                zzj.zziR = zzf1;
                zzj.zziQ = null;
                zzj.zziS = zzf1.version;
            }
            zzp.zza(zzaWq, zzj, zza1.zzbai, true);
        }

        public void zza(zzbf.zza zza1)
        {
            if (!zzp.zzd(zzaWq))
            {
                zzp.zza(zzaWq, 0L);
            }
        }

        private zzb()
        {
            zzaWq = zzp.this;
            super();
        }

        zzb(_cls1 _pcls1)
        {
            this();
        }
    }


    private class zzc
        implements zzbf
    {

        final zzp zzaWq;

        public void zzCC()
        {
        }

        public void zzH(Object obj)
        {
            zzb((com.google.android.gms.internal.zzaf.zzj)obj);
        }

        public void zza(zzbf.zza zza1)
        {
            zza1 = zzaWq;
            zza1;
            JVM INSTR monitorenter ;
            if (!zzaWq.isReady())
            {
                if (zzp.zzb(zzaWq) == null)
                {
                    break MISSING_BLOCK_LABEL_54;
                }
                zzaWq.zzb(zzp.zzb(zzaWq));
            }
_L2:
            zzp.zza(zzaWq, 0x36ee80L);
            return;
            zzaWq.zzb(zzaWq.zzbf(Status.zzabe));
            if (true) goto _L2; else goto _L1
_L1:
            Exception exception;
            exception;
            zza1;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void zzb(com.google.android.gms.internal.zzaf.zzj zzj)
        {
label0:
            {
                synchronized (zzaWq)
                {
                    if (zzj.zziR != null)
                    {
                        break MISSING_BLOCK_LABEL_59;
                    }
                    if (zzp.zze(zzaWq).zziR != null)
                    {
                        break label0;
                    }
                    zzbg.e("Current resource is null; network resource is also null");
                    zzp.zza(zzaWq, 0x36ee80L);
                }
                return;
            }
            zzj.zziR = zzp.zze(zzaWq).zziR;
            zzp.zza(zzaWq, zzj, zzp.zzc(zzaWq).currentTimeMillis(), false);
            zzbg.v((new StringBuilder("setting refresh time to current time: ")).append(zzp.zzf(zzaWq)).toString());
            if (!zzp.zzg(zzaWq))
            {
                zzp.zza(zzaWq, zzj);
            }
            zzp1;
            JVM INSTR monitorexit ;
            return;
            zzj;
            zzp1;
            JVM INSTR monitorexit ;
            throw zzj;
        }

        private zzc()
        {
            zzaWq = zzp.this;
            super();
        }

        zzc(_cls1 _pcls1)
        {
            this();
        }
    }


    private class _cls3
        implements zza
    {

        final zzp zzaWq;
        final boolean zzaWr;

        public boolean zzb(Container container)
        {
            if (!zzaWr) goto _L2; else goto _L1
_L1:
            if (container.getLastRefreshTime() + 0x2932e00L < zzp.zzc(zzaWq).currentTimeMillis()) goto _L4; else goto _L3
_L3:
            return true;
_L4:
            return false;
_L2:
            if (container.isDefault())
            {
                return false;
            }
            if (true) goto _L3; else goto _L5
_L5:
        }

        _cls3(boolean flag)
        {
            zzaWq = zzp.this;
            zzaWr = flag;
            super();
        }
    }


    private class _cls2
        implements zzo.zza
    {

        final zzp zzaWq;

        public String zzCv()
        {
            return zzaWq.zzCv();
        }

        public void zzCx()
        {
            zzbg.zzaH("Refresh ignored: container loaded as default only.");
        }

        public void zzeE(String s)
        {
            zzaWq.zzeE(s);
        }

        _cls2()
        {
            zzaWq = zzp.this;
            super();
        }
    }

}
