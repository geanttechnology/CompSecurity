// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.measurement.AppMeasurementService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzy, zzac, zzv, zzp, 
//            zzc, zzu, zze, zzs, 
//            zzw, zzm, zzn, zzag, 
//            zzo

public class zzab extends zzy
{
    protected class zza
        implements ServiceConnection, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    {

        final zzab zzaOs;
        private volatile boolean zzaOt;
        private volatile zzo zzaOu;

        public void onConnected(Bundle bundle)
        {
            zzx.zzci("MeasurementServiceConnection.onConnected");
            this;
            JVM INSTR monitorenter ;
            zzaOt = false;
            bundle = (zzm)zzaOu.zzpc();
            zzaOu = null;
            zzaOs.zzzr().zzh(new Runnable(this, bundle) {

                final zza zzaOw;
                final zzm zzaOx;

                public void run()
                {
                    if (!zzaOw.zzaOs.isConnected())
                    {
                        zzaOw.zzaOs.zzyd().zzzP().zzec("Connected to remote service");
                        zzab.zza(zzaOw.zzaOs, zzaOx);
                    }
                }

            
            {
                zzaOw = zza1;
                zzaOx = zzm;
                super();
            }
            });
_L2:
            this;
            JVM INSTR monitorexit ;
            return;
_L3:
            zzaOu = null;
            if (true) goto _L2; else goto _L1
_L1:
            bundle;
            this;
            JVM INSTR monitorexit ;
            throw bundle;
            bundle;
              goto _L3
            bundle;
              goto _L3
        }

        public void onConnectionFailed(ConnectionResult connectionresult)
        {
            zzx.zzci("MeasurementServiceConnection.onConnectionFailed");
            this;
            JVM INSTR monitorenter ;
            zzaOu = null;
            this;
            JVM INSTR monitorexit ;
            return;
            connectionresult;
            this;
            JVM INSTR monitorexit ;
            throw connectionresult;
        }

        public void onConnectionSuspended(int i)
        {
            zzx.zzci("MeasurementServiceConnection.onConnectionSuspended");
            zzaOs.zzzr().zzh(new Runnable(this) {

                final zza zzaOw;

                public void run()
                {
                    zzab.zza(zzaOw.zzaOs, new ComponentName(zzaOw.zzaOs.getContext(), com/google/android/gms/measurement/AppMeasurementService));
                }

            
            {
                zzaOw = zza1;
                super();
            }
            });
        }

        public void onServiceConnected(ComponentName componentname, IBinder ibinder)
        {
            zzx.zzci("MeasurementServiceConnection.onServiceConnected");
            this;
            JVM INSTR monitorenter ;
            zzaOt = false;
            if (ibinder != null)
            {
                break MISSING_BLOCK_LABEL_34;
            }
            zzaOs.zzyd().zzzK().zzec("Service connected with null binder");
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
            if (!"com.google.android.gms.measurement.internal.IMeasurementService".equals(s)) goto _L2; else goto _L1
_L1:
            componentname = obj1;
            ibinder = zzm.zza.zzcZ(ibinder);
            componentname = ibinder;
            zzaOs.zzyd().zzzQ().zzec("Bound to IMeasurementService interface");
            componentname = ibinder;
_L4:
            if (componentname != null)
            {
                break MISSING_BLOCK_LABEL_166;
            }
            try
            {
                com.google.android.gms.common.stats.zzb.zzqh().zza(zzaOs.getContext(), zzab.zza(zzaOs));
            }
            // Misplaced declaration of an exception variable
            catch (ComponentName componentname) { }
            this;
            JVM INSTR monitorexit ;
            return;
            componentname;
            this;
            JVM INSTR monitorexit ;
            throw componentname;
_L2:
            componentname = obj1;
            zzaOs.zzyd().zzzK().zzj("Got binder with a wrong descriptor", s);
            componentname = obj;
            continue; /* Loop/switch isn't completed */
            ibinder;
            zzaOs.zzyd().zzzK().zzec("Service connect failed to get IMeasurementService");
            if (true) goto _L4; else goto _L3
_L3:
            zzaOs.zzzr().zzh(new Runnable(this, componentname) {

                final zzm zzaOv;
                final zza zzaOw;

                public void run()
                {
                    if (!zzaOw.zzaOs.isConnected())
                    {
                        zzaOw.zzaOs.zzyd().zzzP().zzec("Connected to service");
                        zzab.zza(zzaOw.zzaOs, zzaOv);
                    }
                }

            
            {
                zzaOw = zza1;
                zzaOv = zzm;
                super();
            }
            });
            break MISSING_BLOCK_LABEL_114;
        }

        public void onServiceDisconnected(ComponentName componentname)
        {
            zzx.zzci("MeasurementServiceConnection.onServiceDisconnected");
            zzaOs.zzzr().zzh(new Runnable(this, componentname) {

                final ComponentName zzNl;
                final zza zzaOw;

                public void run()
                {
                    zzab.zza(zzaOw.zzaOs, zzNl);
                }

            
            {
                zzaOw = zza1;
                zzNl = componentname;
                super();
            }
            });
        }

        public void zzAw()
        {
            zzaOs.zzis();
            Object obj = zzaOs.getContext();
            this;
            JVM INSTR monitorenter ;
            if (!zzaOt)
            {
                break MISSING_BLOCK_LABEL_42;
            }
            zzaOs.zzyd().zzzQ().zzec("Connection attempt already in progress");
            this;
            JVM INSTR monitorexit ;
            return;
            if (zzaOu == null)
            {
                break MISSING_BLOCK_LABEL_72;
            }
            zzaOs.zzyd().zzzQ().zzec("Already awaiting connection attempt");
            this;
            JVM INSTR monitorexit ;
            return;
            obj;
            this;
            JVM INSTR monitorexit ;
            throw obj;
            zzaOu = new zzo(((Context) (obj)), Looper.getMainLooper(), zzf.zzak(((Context) (obj))), this, this);
            zzaOs.zzyd().zzzQ().zzec("Connecting to remote service");
            zzaOt = true;
            zzaOu.zzoZ();
            this;
            JVM INSTR monitorexit ;
        }

        public void zzu(Intent intent)
        {
            Context context;
            zzaOs.zzis();
            context = zzaOs.getContext();
            zzb zzb1 = com.google.android.gms.common.stats.zzb.zzqh();
            this;
            JVM INSTR monitorenter ;
            if (!zzaOt)
            {
                break MISSING_BLOCK_LABEL_46;
            }
            zzaOs.zzyd().zzzQ().zzec("Connection attempt already in progress");
            this;
            JVM INSTR monitorexit ;
            return;
            zzaOt = true;
            zzb1.zza(context, intent, zzab.zza(zzaOs), 129);
            this;
            JVM INSTR monitorexit ;
            return;
            intent;
            this;
            JVM INSTR monitorexit ;
            throw intent;
        }

        protected zza()
        {
            zzaOs = zzab.this;
            super();
        }
    }


    private final zza zzaOl = new zza();
    private zzm zzaOm;
    private Boolean zzaOn;
    private final zze zzaOo;
    private final zzac zzaOp;
    private final List zzaOq = new ArrayList();
    private final zze zzaOr;

    protected zzab(zzv zzv1)
    {
        super(zzv1);
        zzaOp = new zzac(zzv1.zzit());
        zzaOo = new zze(zzv1) {

            final zzab zzaOs;

            public void run()
            {
                com.google.android.gms.measurement.internal.zzab.zzb(zzaOs);
            }

            
            {
                zzaOs = zzab.this;
                super(zzv1);
            }
        };
        zzaOr = new zze(zzv1) {

            final zzab zzaOs;

            public void run()
            {
                zzaOs.zzyd().zzzL().zzec("Tasks have been queued for a long time");
            }

            
            {
                zzaOs = zzab.this;
                super(zzv1);
            }
        };
    }

    private void onServiceDisconnected(ComponentName componentname)
    {
        zzis();
        if (zzaOm != null)
        {
            zzaOm = null;
            zzyd().zzzQ().zzj("Disconnected from device MeasurementService", componentname);
            zzAu();
        }
    }

    private boolean zzAs()
    {
        List list = getContext().getPackageManager().queryIntentServices(new Intent(getContext(), com/google/android/gms/measurement/AppMeasurementService), 0x10000);
        return list != null && list.size() > 0;
    }

    private boolean zzAt()
    {
        zzis();
        zziE();
        if (zzzt().zzjA())
        {
            return true;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.measurement.service.MeasurementBrokerService"));
        zzb zzb1 = com.google.android.gms.common.stats.zzb.zzqh();
        zzyd().zzzQ().zzec("Checking service availability");
        if (zzb1.zza(getContext(), intent, new ServiceConnection() {

        final zzab zzaOs;

        public void onServiceConnected(ComponentName componentname, IBinder ibinder)
        {
        }

        public void onServiceDisconnected(ComponentName componentname)
        {
        }

            
            {
                zzaOs = zzab.this;
                super();
            }
    }, 0))
        {
            zzyd().zzzQ().zzec("Service available");
            return true;
        } else
        {
            return false;
        }
    }

    private void zzAu()
    {
        zzis();
        zzjg();
    }

    private void zzAv()
    {
        zzis();
        zzyd().zzzQ().zzj("Flushing task queue", Integer.valueOf(zzaOq.size()));
        Runnable runnable;
        for (Iterator iterator = zzaOq.iterator(); iterator.hasNext(); zzzr().zzh(runnable))
        {
            runnable = (Runnable)iterator.next();
        }

        zzaOq.clear();
        zzaOr.cancel();
    }

    static zza zza(zzab zzab1)
    {
        return zzab1.zzaOl;
    }

    static void zza(zzab zzab1, ComponentName componentname)
    {
        zzab1.onServiceDisconnected(componentname);
    }

    static void zza(zzab zzab1, zzm zzm)
    {
        zzab1.zza(zzm);
    }

    private void zza(zzm zzm)
    {
        zzis();
        zzx.zzw(zzm);
        zzaOm = zzm;
        zziR();
        zzAv();
    }

    static void zzb(zzab zzab1)
    {
        zzab1.zziS();
    }

    static zzm zzc(zzab zzab1)
    {
        return zzab1.zzaOm;
    }

    static void zzd(zzab zzab1)
    {
        zzab1.zziR();
    }

    private void zziR()
    {
        zzis();
        zzaOp.start();
        zzaOo.zzt(zzzt().zzjV());
    }

    private void zziS()
    {
        zzis();
        if (!isConnected())
        {
            return;
        } else
        {
            zzyd().zzzQ().zzec("Inactivity, disconnecting from AppMeasurementService");
            disconnect();
            return;
        }
    }

    private void zzj(Runnable runnable)
        throws IllegalStateException
    {
        zzis();
        if (isConnected())
        {
            runnable.run();
            return;
        }
        if ((long)zzaOq.size() >= zzzt().zzze())
        {
            zzyd().zzzK().zzec("Discarding data. Max runnable queue size reached");
            return;
        } else
        {
            zzaOq.add(runnable);
            zzaOr.zzt(60000L);
            zzjg();
            return;
        }
    }

    private void zzjg()
    {
        zzis();
        zziE();
        if (isConnected())
        {
            return;
        }
        if (zzaOn == null)
        {
            zzaOn = zzzs().zzzW();
            if (zzaOn == null)
            {
                zzyd().zzzQ().zzec("State of service unknown");
                zzaOn = Boolean.valueOf(zzAt());
                zzzs().zzan(zzaOn.booleanValue());
            }
        }
        if (zzaOn.booleanValue())
        {
            zzyd().zzzQ().zzec("Using measurement service");
            zzaOl.zzAw();
            return;
        }
        if (zzAs())
        {
            zzyd().zzzQ().zzec("Using local app measurement service");
            Intent intent = new Intent("com.google.android.gms.measurement.START");
            intent.setComponent(new ComponentName(getContext(), com/google/android/gms/measurement/AppMeasurementService));
            zzaOl.zzu(intent);
            return;
        }
        if (zzzt().zzjB())
        {
            zzyd().zzzQ().zzec("Using direct local measurement implementation");
            zza(new zzw(zzaKG, true));
            return;
        } else
        {
            zzyd().zzzK().zzec("Not in main process. Unable to use local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
    }

    public void disconnect()
    {
        zzis();
        zziE();
        try
        {
            com.google.android.gms.common.stats.zzb.zzqh().zza(getContext(), zzaOl);
        }
        catch (IllegalStateException illegalstateexception) { }
        catch (IllegalArgumentException illegalargumentexception) { }
        if (zzaOm != null)
        {
            zzaOm = null;
        }
    }

    public volatile Context getContext()
    {
        return super.getContext();
    }

    public boolean isConnected()
    {
        zzis();
        zziE();
        return zzaOm != null;
    }

    protected void zzAr()
    {
        zzis();
        zziE();
        zzj(new Runnable() {

            final zzab zzaOs;

            public void run()
            {
                zzm zzm1 = zzab.zzc(zzaOs);
                if (zzm1 == null)
                {
                    zzaOs.zzyd().zzzK().zzec("Discarding data. Failed to send app launch");
                    return;
                }
                try
                {
                    zzm1.zza(zzaOs.zzzo().zzzG());
                    zzab.zzd(zzaOs);
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    zzaOs.zzyd().zzzK().zzj("Failed to send app launch to AppMeasurementService", remoteexception);
                }
            }

            
            {
                zzaOs = zzab.this;
                super();
            }
        });
    }

    protected void zzhR()
    {
    }

    public volatile void zzir()
    {
        super.zzir();
    }

    public volatile void zzis()
    {
        super.zzis();
    }

    public volatile zzmn zzit()
    {
        return super.zzit();
    }

    public volatile zzp zzyd()
    {
        return super.zzyd();
    }

    public volatile void zzzn()
    {
        super.zzzn();
    }

    public volatile zzn zzzo()
    {
        return super.zzzo();
    }

    public volatile zzab zzzp()
    {
        return super.zzzp();
    }

    public volatile zzag zzzq()
    {
        return super.zzzq();
    }

    public volatile zzu zzzr()
    {
        return super.zzzr();
    }

    public volatile zzs zzzs()
    {
        return super.zzzs();
    }

    public volatile zzc zzzt()
    {
        return super.zzzt();
    }
}
