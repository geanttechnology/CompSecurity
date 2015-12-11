// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.measurement.zzg;
import java.util.Collections;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzd, zzaj, zzf, zzb, 
//            zzr, zzt, zzab, zzac

public class zzi extends zzd
{
    protected class zza
        implements ServiceConnection
    {

        final zzi zzNg;
        private volatile zzac zzNh;
        private volatile boolean zzNi;

        public void onServiceConnected(ComponentName componentname, IBinder ibinder)
        {
            zzx.zzci("AnalyticsServiceConnection.onServiceConnected");
            this;
            JVM INSTR monitorenter ;
            if (ibinder != null)
            {
                break MISSING_BLOCK_LABEL_27;
            }
            zzNg.zzbe("Service connected with null binder");
            notifyAll();
            this;
            JVM INSTR monitorexit ;
            return;
            Object obj;
            Object obj1;
            obj1 = null;
            obj = null;
            componentname = obj1;
            String s = ibinder.getInterfaceDescriptor();
            componentname = obj1;
            if (!"com.google.android.gms.analytics.internal.IAnalyticsService".equals(s)) goto _L2; else goto _L1
_L1:
            componentname = obj1;
            ibinder = zzac.zza.zzaf(ibinder);
            componentname = ibinder;
            zzNg.zzba("Bound to IAnalyticsService interface");
            componentname = ibinder;
_L4:
            {
                if (componentname != null)
                {
                    break; /* Loop/switch isn't completed */
                }
                try
                {
                    com.google.android.gms.common.stats.zzb.zzqh().zza(zzNg.getContext(), zzi.zza(zzNg));
                }
                // Misplaced declaration of an exception variable
                catch (ComponentName componentname) { }
                finally { }
            }
            notifyAll();
            this;
            JVM INSTR monitorexit ;
            return;
            componentname;
            this;
            JVM INSTR monitorexit ;
            throw componentname;
_L2:
            componentname = obj1;
            zzNg.zze("Got binder with a wrong descriptor", s);
            componentname = obj;
            continue; /* Loop/switch isn't completed */
            ibinder;
            zzNg.zzbe("Service connect failed to get IAnalyticsService");
            if (true) goto _L4; else goto _L3
            notifyAll();
            throw componentname;
_L3:
label0:
            {
                if (zzNi)
                {
                    break label0;
                }
                zzNg.zzbd("onServiceConnected received after the timeout limit");
                zzNg.zziw().zzg(new Runnable(this, componentname) {

                    final zzac zzNj;
                    final zza zzNk;

                    public void run()
                    {
                        if (!zzNk.zzNg.isConnected())
                        {
                            zzNk.zzNg.zzbb("Connected to service after a timeout");
                            zzi.zza(zzNk.zzNg, zzNj);
                        }
                    }

            
            {
                zzNk = zza1;
                zzNj = zzac1;
                super();
            }
                });
            }
            break MISSING_BLOCK_LABEL_101;
            zzNh = componentname;
            break MISSING_BLOCK_LABEL_101;
        }

        public void onServiceDisconnected(ComponentName componentname)
        {
            zzx.zzci("AnalyticsServiceConnection.onServiceDisconnected");
            zzNg.zziw().zzg(new Runnable(this, componentname) {

                final zza zzNk;
                final ComponentName zzNl;

                public void run()
                {
                    zzi.zza(zzNk.zzNg, zzNl);
                }

            
            {
                zzNk = zza1;
                zzNl = componentname;
                super();
            }
            });
        }

        public zzac zziT()
        {
            Object obj;
            Context context;
            zzNg.zzis();
            obj = new Intent("com.google.android.gms.analytics.service.START");
            ((Intent) (obj)).setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
            context = zzNg.getContext();
            ((Intent) (obj)).putExtra("app_package_name", context.getPackageName());
            zzb zzb1 = com.google.android.gms.common.stats.zzb.zzqh();
            this;
            JVM INSTR monitorenter ;
            boolean flag;
            zzNh = null;
            zzNi = true;
            flag = zzb1.zza(context, ((Intent) (obj)), zzi.zza(zzNg), 129);
            zzNg.zza("Bind to service requested", Boolean.valueOf(flag));
            if (flag)
            {
                break MISSING_BLOCK_LABEL_114;
            }
            zzNi = false;
            this;
            JVM INSTR monitorexit ;
            return null;
            wait(zzNg.zziv().zzjW());
_L1:
            zzNi = false;
            obj = zzNh;
            zzNh = null;
            if (obj != null)
            {
                break MISSING_BLOCK_LABEL_156;
            }
            zzNg.zzbe("Successfully bound to service but never got onServiceConnected callback");
            this;
            JVM INSTR monitorexit ;
            return ((zzac) (obj));
            Object obj1;
            obj1;
            this;
            JVM INSTR monitorexit ;
            throw obj1;
            obj1;
            zzNg.zzbd("Wait for service connect was interrupted");
              goto _L1
        }

        protected zza()
        {
            zzNg = zzi.this;
            super();
        }
    }


    private final zza zzNc = new zza();
    private zzac zzNd;
    private final zzt zzNe;
    private zzaj zzNf;

    protected zzi(zzf zzf1)
    {
        super(zzf1);
        zzNf = new zzaj(zzf1.zzit());
        zzNe = new zzt(zzf1) {

            final zzi zzNg;

            public void run()
            {
                com.google.android.gms.analytics.internal.zzi.zzb(zzNg);
            }

            
            {
                zzNg = zzi.this;
                super(zzf1);
            }
        };
    }

    private void onDisconnect()
    {
        zzhP().zzin();
    }

    private void onServiceDisconnected(ComponentName componentname)
    {
        zzis();
        if (zzNd != null)
        {
            zzNd = null;
            zza("Disconnected from device AnalyticsService", componentname);
            onDisconnect();
        }
    }

    static zza zza(zzi zzi1)
    {
        return zzi1.zzNc;
    }

    private void zza(zzac zzac1)
    {
        zzis();
        zzNd = zzac1;
        zziR();
        zzhP().onServiceConnected();
    }

    static void zza(zzi zzi1, ComponentName componentname)
    {
        zzi1.onServiceDisconnected(componentname);
    }

    static void zza(zzi zzi1, zzac zzac1)
    {
        zzi1.zza(zzac1);
    }

    static void zzb(zzi zzi1)
    {
        zzi1.zziS();
    }

    private void zziR()
    {
        zzNf.start();
        zzNe.zzt(zziv().zzjV());
    }

    private void zziS()
    {
        zzis();
        if (!isConnected())
        {
            return;
        } else
        {
            zzba("Inactivity, disconnecting from device AnalyticsService");
            disconnect();
            return;
        }
    }

    public boolean connect()
    {
        zzis();
        zziE();
        if (zzNd != null)
        {
            return true;
        }
        zzac zzac1 = zzNc.zziT();
        if (zzac1 != null)
        {
            zzNd = zzac1;
            zziR();
            return true;
        } else
        {
            return false;
        }
    }

    public void disconnect()
    {
        zzis();
        zziE();
        try
        {
            com.google.android.gms.common.stats.zzb.zzqh().zza(getContext(), zzNc);
        }
        catch (IllegalStateException illegalstateexception) { }
        catch (IllegalArgumentException illegalargumentexception) { }
        if (zzNd != null)
        {
            zzNd = null;
            onDisconnect();
        }
    }

    public boolean isConnected()
    {
        zzis();
        zziE();
        return zzNd != null;
    }

    public boolean zzb(zzab zzab1)
    {
        zzx.zzw(zzab1);
        zzis();
        zziE();
        zzac zzac1 = zzNd;
        if (zzac1 == null)
        {
            return false;
        }
        String s;
        java.util.List list;
        if (zzab1.zzkC())
        {
            s = zziv().zzjO();
        } else
        {
            s = zziv().zzjP();
        }
        list = Collections.emptyList();
        try
        {
            zzac1.zza(zzab1.zzn(), zzab1.zzkA(), s, list);
            zziR();
        }
        // Misplaced declaration of an exception variable
        catch (zzab zzab1)
        {
            zzba("Failed to send hits to AnalyticsService");
            return false;
        }
        return true;
    }

    protected void zzhR()
    {
    }

    public boolean zziQ()
    {
        zzis();
        zziE();
        zzac zzac1 = zzNd;
        if (zzac1 == null)
        {
            return false;
        }
        try
        {
            zzac1.zzik();
            zziR();
        }
        catch (RemoteException remoteexception)
        {
            zzba("Failed to clear hits from AnalyticsService");
            return false;
        }
        return true;
    }
}
