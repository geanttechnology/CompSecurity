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

// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzi, zzr, zzac

protected class zzNg
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
        ibinder = .zzaf(ibinder);
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
                zzb.zzqh().zza(zzNg.getContext(), zzi.zza(zzNg));
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
            zzNg.zziw().zzg(new Runnable(componentname) {

                final zzac zzNj;
                final zzi.zza zzNk;

                public void run()
                {
                    if (!zzNk.zzNg.isConnected())
                    {
                        zzNk.zzNg.zzbb("Connected to service after a timeout");
                        zzi.zza(zzNk.zzNg, zzNj);
                    }
                }

            
            {
                zzNk = zzi.zza.this;
                zzNj = zzac;
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
        zzNg.zziw().zzg(new Runnable(componentname) {

            final zzi.zza zzNk;
            final ComponentName zzNl;

            public void run()
            {
                zzi.zza(zzNk.zzNg, zzNl);
            }

            
            {
                zzNk = zzi.zza.this;
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
        zzb zzb1 = zzb.zzqh();
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

    protected _cls2.zzNl(zzi zzi1)
    {
        zzNg = zzi1;
        super();
    }
}
