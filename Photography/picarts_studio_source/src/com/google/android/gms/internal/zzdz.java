// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzid, zzbd, zzbb, zzil, 
//            zzdk, zziz

public class zzdz
{

    private final Context mContext;
    private final VersionInfoParcel zzpb;
    private final Object zzpd;
    private final String zzyo;
    private zzb zzyp;
    private zzb zzyq;
    private zze zzyr;
    private int zzys;

    public zzdz(Context context, VersionInfoParcel versioninfoparcel, String s)
    {
        zzpd = new Object();
        zzys = 1;
        zzyo = s;
        mContext = context.getApplicationContext();
        zzpb = versioninfoparcel;
        zzyp = new zzc();
        zzyq = new zzc();
    }

    public zzdz(Context context, VersionInfoParcel versioninfoparcel, String s, zzb zzb1, zzb zzb2)
    {
        this(context, versioninfoparcel, s);
        zzyp = zzb1;
        zzyq = zzb2;
    }

    static int zza(zzdz zzdz1, int i)
    {
        zzdz1.zzys = i;
        return i;
    }

    static Context zza(zzdz zzdz1)
    {
        return zzdz1.mContext;
    }

    static zze zza(zzdz zzdz1, zze zze1)
    {
        zzdz1.zzyr = zze1;
        return zze1;
    }

    static VersionInfoParcel zzb(zzdz zzdz1)
    {
        return zzdz1.zzpb;
    }

    static Object zzc(zzdz zzdz1)
    {
        return zzdz1.zzpd;
    }

    static zzb zzd(zzdz zzdz1)
    {
        return zzdz1.zzyp;
    }

    private zze zzdM()
    {
        zze zze1 = new zze(zzyq);
        zzid.runOnUiThread(new Runnable(zze1) {

            final zze zzyt;
            final zzdz zzyu;

            public void run()
            {
                zzbb zzbb1 = zzyu.zza(zzdz.zza(zzyu), com.google.android.gms.internal.zzdz.zzb(zzyu));
                zzbb1.zza(new zzbb.zza(this, zzbb1) {

                    final zzbb zzyv;
                    final _cls1 zzyw;

                    public void zzcj()
                    {
                        zzid.zzIE.postDelayed(new Runnable(this) {

                            final _cls1 zzyx;

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
                                zzid.runOnUiThread(new Runnable(this) {

                                    final _cls1 zzyy;

                                    public void run()
                                    {
                                        zzyy.zzyx.zzyv.destroy();
                                    }

            
            {
                zzyy = _pcls1;
                super();
            }
                                });
                                com.google.android.gms.ads.internal.util.client.zzb.v("Could not receive loaded message in a timely manner. Rejecting.");
                                obj;
                                JVM INSTR monitorexit ;
                                return;
                                exception;
                                obj;
                                JVM INSTR monitorexit ;
                                throw exception;
                            }

            
            {
                zzyx = _pcls1;
                super();
            }
                        }, zza.zzyD);
                    }

            
            {
                zzyw = _pcls1;
                zzyv = zzbb;
                super();
            }
                });
                zzbb1.zza("/jsLoaded", new zzdk(this, zzbb1) {

                    final zzbb zzyv;
                    final _cls1 zzyw;

                    public void zza(zziz zziz, Map map)
                    {
label0:
                        {
                            synchronized (zzdz.zzc(zzyw.zzyu))
                            {
                                if (zzyw.zzyt.getStatus() != -1 && zzyw.zzyt.getStatus() != 1)
                                {
                                    break label0;
                                }
                            }
                            return;
                        }
                        zzdz.zza(zzyw.zzyu, 0);
                        zzdz.zzd(zzyw.zzyu).zzc(zzyv);
                        zzyw.zzyt.zzg(zzyv);
                        zzdz.zza(zzyw.zzyu, zzyw.zzyt);
                        com.google.android.gms.ads.internal.util.client.zzb.v("Successfully loaded JS Engine.");
                        zziz;
                        JVM INSTR monitorexit ;
                        return;
                        map;
                        zziz;
                        JVM INSTR monitorexit ;
                        throw map;
                    }

            
            {
                zzyw = _pcls1;
                zzyv = zzbb;
                super();
            }

                    private class zzb
                    {

                        public abstract void zzc(Object obj);
                    }

                });
                zzil zzil1 = new zzil();
                zzdk zzdk = new zzdk(this, zzbb1, zzil1) {

                    final zzbb zzyv;
                    final _cls1 zzyw;
                    final zzil zzyz;

                    public void zza(zziz zziz, Map map)
                    {
                        synchronized (zzdz.zzc(zzyw.zzyu))
                        {
                            com.google.android.gms.ads.internal.util.client.zzb.zzaG("JS Engine is requesting an update");
                            if (zzdz.zze(zzyw.zzyu) == 0)
                            {
                                com.google.android.gms.ads.internal.util.client.zzb.zzaG("Starting reload.");
                                zzdz.zza(zzyw.zzyu, 2);
                                zzyw.zzyu.zzdN();
                            }
                            zzyv.zzb("/requestReload", (zzdk)zzyz.get());
                        }
                        return;
                        map;
                        zziz;
                        JVM INSTR monitorexit ;
                        throw map;
                    }

            
            {
                zzyw = _pcls1;
                zzyv = zzbb1;
                zzyz = zzil1;
                super();
            }
                };
                zzil1.set(zzdk);
                zzbb1.zza("/requestReload", zzdk);
                if (zzdz.zzf(zzyu).endsWith(".js"))
                {
                    zzbb1.zzs(zzdz.zzf(zzyu));
                } else
                if (zzdz.zzf(zzyu).startsWith("<html>"))
                {
                    zzbb1.zzu(zzdz.zzf(zzyu));
                } else
                {
                    zzbb1.zzt(zzdz.zzf(zzyu));
                }
                zzid.zzIE.postDelayed(new Runnable(this, zzbb1) {

                    final zzbb zzyv;
                    final _cls1 zzyw;

                    public void run()
                    {
label0:
                        {
                            synchronized (zzdz.zzc(zzyw.zzyu))
                            {
                                if (zzyw.zzyt.getStatus() != -1 && zzyw.zzyt.getStatus() != 1)
                                {
                                    break label0;
                                }
                            }
                            return;
                        }
                        zzyw.zzyt.reject();
                        zzid.runOnUiThread(new Runnable(this) {

                            final _cls4 zzyA;

                            public void run()
                            {
                                zzyA.zzyv.destroy();
                            }

            
            {
                zzyA = _pcls4;
                super();
            }
                        });
                        com.google.android.gms.ads.internal.util.client.zzb.v("Could not receive loaded message in a timely manner. Rejecting.");
                        obj;
                        JVM INSTR monitorexit ;
                        return;
                        exception;
                        obj;
                        JVM INSTR monitorexit ;
                        throw exception;
                    }

            
            {
                zzyw = _pcls1;
                zzyv = zzbb;
                super();
            }
                }, zza.zzyC);
            }

            
            {
                zzyu = zzdz.this;
                zzyt = zze1;
                super();
            }

            private class zza
            {

                static int zzyC = 60000;
                static int zzyD = 10000;

            }

        });
        return zze1;
    }

    static int zze(zzdz zzdz1)
    {
        return zzdz1.zzys;
    }

    static String zzf(zzdz zzdz1)
    {
        return zzdz1.zzyo;
    }

    static zze zzg(zzdz zzdz1)
    {
        return zzdz1.zzyr;
    }

    protected zzbb zza(Context context, VersionInfoParcel versioninfoparcel)
    {
        return new zzbd(context, versioninfoparcel, null);
    }

    protected zze zzdN()
    {
        zze zze1 = zzdM();
        zze1.zza(new zzis.zzc(zze1) {

            final zze zzyB;
            final zzdz zzyu;

            public void zza(zzbb zzbb1)
            {
                synchronized (zzdz.zzc(zzyu))
                {
                    zzdz.zza(zzyu, 0);
                    if (zzdz.zzg(zzyu) != null && zzyB != zzdz.zzg(zzyu))
                    {
                        com.google.android.gms.ads.internal.util.client.zzb.v("New JS engine is loaded, marking previous one as destroyable.");
                        zzdz.zzg(zzyu).zzdR();
                    }
                    zzdz.zza(zzyu, zzyB);
                }
                return;
                exception;
                zzbb1;
                JVM INSTR monitorexit ;
                throw exception;
            }

            public void zzc(Object obj)
            {
                zza((zzbb)obj);
            }

            
            {
                zzyu = zzdz.this;
                zzyB = zze1;
                super();
            }
        }, new zzis.zza(zze1) {

            final zze zzyB;
            final zzdz zzyu;

            public void run()
            {
                synchronized (zzdz.zzc(zzyu))
                {
                    zzdz.zza(zzyu, 1);
                    com.google.android.gms.ads.internal.util.client.zzb.v("Failed loading new engine. Marking new engine destroyable.");
                    zzyB.zzdR();
                }
                return;
                exception;
                obj;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                zzyu = zzdz.this;
                zzyB = zze1;
                super();
            }
        });
        return zze1;
    }

    public zzd zzdO()
    {
label0:
        {
            zzd zzd1;
            synchronized (zzpd)
            {
                if (zzyr != null && zzyr.getStatus() != -1)
                {
                    break label0;
                }
                zzys = 2;
                zzyr = zzdN();
                zzd1 = zzyr.zzdP();
            }
            return zzd1;
        }
        zzd zzd2;
        if (zzys != 0)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        zzd2 = zzyr.zzdP();
        obj;
        JVM INSTR monitorexit ;
        return zzd2;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        if (zzys != 1)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        zzys = 2;
        zzdN();
        exception = zzyr.zzdP();
        obj;
        JVM INSTR monitorexit ;
        return exception;
        if (zzys != 2)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        exception = zzyr.zzdP();
        obj;
        JVM INSTR monitorexit ;
        return exception;
        exception = zzyr.zzdP();
        obj;
        JVM INSTR monitorexit ;
        return exception;
    }

    private class zzc
        implements zzb
    {

        public void zzc(Object obj)
        {
        }

        public zzc()
        {
        }
    }


    private class zze extends zzit
    {

        private final Object zzpd = new Object();
        private boolean zzyH;
        private int zzyI;
        private zzb zzyq;

        static zzb zza(zze zze1)
        {
            return zze1.zzyq;
        }

        public zzd zzdP()
        {
            zzd zzd1 = new zzd();
            Object obj = zzpd;
            obj;
            JVM INSTR monitorenter ;
            zza(new zzis.zzc(zzd1) {

                final zzd zzyJ;
                final zze zzyK;

                public void zza(zzbb zzbb1)
                {
                    com.google.android.gms.ads.internal.util.client.zzb.v("Getting a new session for JS Engine.");
                    zzyJ.zzg(zzbb1.zzci());
                }

                public void zzc(Object obj1)
                {
                    zza((zzbb)obj1);
                }

                
                {
                    zzyK = zze.this;
                    zzyJ = zzd1;
                    super();
                }
            }, new zzis.zza(zzd1) {

                final zzd zzyJ;
                final zze zzyK;

                public void run()
                {
                    com.google.android.gms.ads.internal.util.client.zzb.v("Rejecting reference for JS Engine.");
                    zzyJ.reject();
                }

                
                {
                    zzyK = zze.this;
                    zzyJ = zzd1;
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
            return zzd1;
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
            com.google.android.gms.ads.internal.util.client.zzb.v("Releasing 1 reference for JS Engine");
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
            com.google.android.gms.ads.internal.util.client.zzb.v("Releasing root reference. JS Engine will be destroyed once other references are released.");
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
            com.google.android.gms.ads.internal.util.client.zzb.v("No reference is left (including root). Cleaning up engine.");
            zza(new zzis.zzc() {

                final zze zzyK;

                public void zza(zzbb zzbb1)
                {
                    zzid.runOnUiThread(new Runnable(this, zzbb1) {

                        final zzbb zzrE;
                        final _cls3 zzyL;

                        public void run()
                        {
                            zze.zza(zzyL.zzyK).zzc(zzrE);
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
                    zzyK = zze.this;
                    super();
                }
            }, new zzis.zzb());
_L2:
            obj;
            JVM INSTR monitorexit ;
            return;
            com.google.android.gms.ads.internal.util.client.zzb.v("There are still references to the engine. Not destroying.");
            if (true) goto _L2; else goto _L1
_L1:
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public zze(zzb zzb1)
        {
            zzyq = zzb1;
            zzyH = false;
            zzyI = 0;
        }

        private class zzd extends zzit
        {

            private final Object zzpd = new Object();
            private final zze zzyE;
            private boolean zzyF;

            static zze zza(zzd zzd1)
            {
                return zzd1.zzyE;
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
                zza(new zzis.zzc() {

                    final zzd zzyG;

                    public void zzb(zzbe zzbe1)
                    {
                        com.google.android.gms.ads.internal.util.client.zzb.v("Ending javascript session.");
                        ((zzbf)zzbe1).zzck();
                    }

                    public void zzc(Object obj1)
                    {
                        zzb((zzbe)obj1);
                    }

                    
                    {
                        zzyG = zzd.this;
                        super();
                    }
                }, new zzis.zzb());
                zza(new zzis.zzc() {

                    final zzd zzyG;

                    public void zzb(zzbe zzbe1)
                    {
                        com.google.android.gms.ads.internal.util.client.zzb.v("Releasing engine reference.");
                        zzd.zza(zzyG).zzdQ();
                    }

                    public void zzc(Object obj1)
                    {
                        zzb((zzbe)obj1);
                    }

                    
                    {
                        zzyG = zzd.this;
                        super();
                    }
                }, new zzis.zza() {

                    final zzd zzyG;

                    public void run()
                    {
                        zzd.zza(zzyG).zzdQ();
                    }

                    
                    {
                        zzyG = zzd.this;
                        super();
                    }
                });
                obj;
                JVM INSTR monitorexit ;
                return;
                exception;
                obj;
                JVM INSTR monitorexit ;
                throw exception;
            }

            public zzd()
            {
                zzyE = zze.this;
            }
        }

    }

}
