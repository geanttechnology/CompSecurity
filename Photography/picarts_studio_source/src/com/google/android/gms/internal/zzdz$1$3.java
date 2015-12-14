// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzdk, zzdz, zzil, zzbb, 
//            zziz, zzid

class zzyz
    implements zzdk
{

    final zzbb zzyv;
    final zzyz zzyw;
    final zzil zzyz;

    public void zza(zziz zziz, Map map)
    {
        synchronized (zzdz.zzc(zzyw.yu))
        {
            zzb.zzaG("JS Engine is requesting an update");
            if (zzdz.zze(zzyw.yu) == 0)
            {
                zzb.zzaG("Starting reload.");
                zzdz.zza(zzyw.yu, 2);
                zzyw.yu.zzdN();
            }
            zzyv.zzb("/requestReload", (zzdk)zzyz.get());
        }
        return;
        map;
        zziz;
        JVM INSTR monitorexit ;
        throw map;
    }

    yt(yt yt, zzbb zzbb1, zzil zzil1)
    {
        zzyw = yt;
        zzyv = zzbb1;
        zzyz = zzil1;
        super();
    }

    // Unreferenced inner class com/google/android/gms/internal/zzdz$1

/* anonymous class */
    class zzdz._cls1
        implements Runnable
    {

        final zzdz.zze zzyt;
        final zzdz zzyu;

        public void run()
        {
            zzbb zzbb1 = zzyu.zza(zzdz.zza(zzyu), com.google.android.gms.internal.zzdz.zzb(zzyu));
            zzbb1.zza(new zzdz._cls1._cls1(zzbb1));
            zzbb1.zza("/jsLoaded", new zzdz._cls1._cls2(zzbb1));
            zzil zzil1 = new zzil();
            zzdz._cls1._cls3 _lcls3 = new zzdz._cls1._cls3(this, zzbb1, zzil1);
            zzil1.set(_lcls3);
            zzbb1.zza("/requestReload", _lcls3);
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
            zzid.zzIE.postDelayed(new zzdz._cls1._cls4(zzbb1), zzdz.zza.zzyC);
        }

            
            {
                zzyu = zzdz1;
                zzyt = zze;
                super();
            }

        // Unreferenced inner class com/google/android/gms/internal/zzdz$1$1

/* anonymous class */
        class zzdz._cls1._cls1
            implements zzbb.zza
        {

            final zzbb zzyv;
            final zzdz._cls1 zzyw;

            public void zzcj()
            {
                zzid.zzIE.postDelayed(new zzdz._cls1._cls1._cls1(this), zzdz.zza.zzyD);
            }

                    
                    {
                        zzyw = zzdz._cls1.this;
                        zzyv = zzbb1;
                        super();
                    }
        }


        // Unreferenced inner class com/google/android/gms/internal/zzdz$1$1$1

/* anonymous class */
        class zzdz._cls1._cls1._cls1
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
                zzid.runOnUiThread(new zzdz._cls1._cls1._cls1._cls1(this));
                zzb.v("Could not receive loaded message in a timely manner. Rejecting.");
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
        }


        // Unreferenced inner class com/google/android/gms/internal/zzdz$1$1$1$1

/* anonymous class */
        class zzdz._cls1._cls1._cls1._cls1
            implements Runnable
        {

            final zzdz._cls1._cls1._cls1 zzyy;

            public void run()
            {
                zzyy.zzyx.zzyv.destroy();
            }

                    
                    {
                        zzyy = _pcls1;
                        super();
                    }
        }


        // Unreferenced inner class com/google/android/gms/internal/zzdz$1$2

/* anonymous class */
        class zzdz._cls1._cls2
            implements zzdk
        {

            final zzbb zzyv;
            final zzdz._cls1 zzyw;

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
                zzb.v("Successfully loaded JS Engine.");
                zziz;
                JVM INSTR monitorexit ;
                return;
                map;
                zziz;
                JVM INSTR monitorexit ;
                throw map;
            }

                    
                    {
                        zzyw = zzdz._cls1.this;
                        zzyv = zzbb1;
                        super();
                    }
        }


        // Unreferenced inner class com/google/android/gms/internal/zzdz$1$4

/* anonymous class */
        class zzdz._cls1._cls4
            implements Runnable
        {

            final zzbb zzyv;
            final zzdz._cls1 zzyw;

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
                zzid.runOnUiThread(new zzdz._cls1._cls4._cls1(this));
                zzb.v("Could not receive loaded message in a timely manner. Rejecting.");
                obj;
                JVM INSTR monitorexit ;
                return;
                exception;
                obj;
                JVM INSTR monitorexit ;
                throw exception;
            }

                    
                    {
                        zzyw = zzdz._cls1.this;
                        zzyv = zzbb1;
                        super();
                    }
        }


        // Unreferenced inner class com/google/android/gms/internal/zzdz$1$4$1

/* anonymous class */
        class zzdz._cls1._cls4._cls1
            implements Runnable
        {

            final zzdz._cls1._cls4 zzyA;

            public void run()
            {
                zzyA.zzyv.destroy();
            }

                    
                    {
                        zzyA = _pcls4;
                        super();
                    }
        }

    }

}
