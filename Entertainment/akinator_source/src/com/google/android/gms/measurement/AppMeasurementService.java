// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.internal.zzag;
import com.google.android.gms.measurement.internal.zzc;
import com.google.android.gms.measurement.internal.zzp;
import com.google.android.gms.measurement.internal.zzu;
import com.google.android.gms.measurement.internal.zzv;
import com.google.android.gms.measurement.internal.zzw;

// Referenced classes of package com.google.android.gms.measurement:
//            AppMeasurementReceiver

public final class AppMeasurementService extends Service
{

    private static Boolean zzLj;
    private final Handler mHandler = new Handler();

    public AppMeasurementService()
    {
    }

    public static boolean zzW(Context context)
    {
        zzx.zzw(context);
        if (zzLj != null)
        {
            return zzLj.booleanValue();
        } else
        {
            boolean flag = zzag.zza(context, com/google/android/gms/measurement/AppMeasurementService);
            zzLj = Boolean.valueOf(flag);
            return flag;
        }
    }

    static Handler zza(AppMeasurementService appmeasurementservice)
    {
        return appmeasurementservice.mHandler;
    }

    private void zzhH()
    {
        Object obj = AppMeasurementReceiver.zzpy;
        obj;
        JVM INSTR monitorenter ;
        android.os.PowerManager.WakeLock wakelock = AppMeasurementReceiver.zzaKH;
        if (wakelock == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        if (wakelock.isHeld())
        {
            wakelock.release();
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        catch (SecurityException securityexception)
        {
            return;
        }
    }

    private zzp zzyd()
    {
        return zzv.zzaL(this).zzyd();
    }

    public IBinder onBind(Intent intent)
    {
        if (intent == null)
        {
            zzyd().zzzK().zzec("onBind called with null intent");
            return null;
        }
        intent = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(intent))
        {
            return new zzw(zzv.zzaL(this));
        } else
        {
            zzyd().zzzL().zzj("onBind received unknown action", intent);
            return null;
        }
    }

    public void onCreate()
    {
        super.onCreate();
        zzv zzv1 = zzv.zzaL(this);
        zzp zzp1 = zzv1.zzyd();
        if (zzv1.zzzt().zzjA())
        {
            zzp1.zzzQ().zzec("Device AppMeasurementService is starting up");
            return;
        } else
        {
            zzp1.zzzQ().zzec("Local AppMeasurementService is starting up");
            return;
        }
    }

    public void onDestroy()
    {
        zzv zzv1 = zzv.zzaL(this);
        zzp zzp1 = zzv1.zzyd();
        if (zzv1.zzzt().zzjA())
        {
            zzp1.zzzQ().zzec("Device AppMeasurementService is shutting down");
        } else
        {
            zzp1.zzzQ().zzec("Local AppMeasurementService is shutting down");
        }
        super.onDestroy();
    }

    public void onRebind(Intent intent)
    {
        if (intent == null)
        {
            zzyd().zzzK().zzec("onRebind called with null intent");
            return;
        } else
        {
            intent = intent.getAction();
            zzyd().zzzQ().zzj("onRebind called. action", intent);
            return;
        }
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        zzhH();
        zzv zzv1 = zzv.zzaL(this);
        zzp zzp1 = zzv1.zzyd();
        intent = intent.getAction();
        if (zzv1.zzzt().zzjA())
        {
            zzp1.zzzQ().zze("Device AppMeasurementService called. startId, action", Integer.valueOf(j), intent);
        } else
        {
            zzp1.zzzQ().zze("Local AppMeasurementService called. startId, action", Integer.valueOf(j), intent);
        }
        if ("com.google.android.gms.measurement.UPLOAD".equals(intent))
        {
            zzv1.zzzr().zzh(new Runnable(zzv1, j, zzp1) {

                final int zzLk;
                final zzv zzaKI;
                final zzp zzaKJ;
                final AppMeasurementService zzaKK;

                public void run()
                {
                    zzaKI.zzAk();
                    AppMeasurementService.zza(zzaKK).post(new Runnable(this) {

                        final _cls1 zzaKL;

                        public void run()
                        {
label0:
                            {
                                if (zzaKL.zzaKK.stopSelfResult(zzaKL.zzLk))
                                {
                                    if (!zzaKL.zzaKI.zzzt().zzjA())
                                    {
                                        break label0;
                                    }
                                    zzaKL.zzaKJ.zzzQ().zzec("Device AppMeasurementService processed last upload request");
                                }
                                return;
                            }
                            zzaKL.zzaKJ.zzzQ().zzec("Local AppMeasurementService processed last upload request");
                        }

            
            {
                zzaKL = _pcls1;
                super();
            }
                    });
                }

            
            {
                zzaKK = AppMeasurementService.this;
                zzaKI = zzv1;
                zzLk = i;
                zzaKJ = zzp1;
                super();
            }
            });
        }
        return 2;
    }

    public boolean onUnbind(Intent intent)
    {
        if (intent == null)
        {
            zzyd().zzzK().zzec("onUnbind called with null intent");
            return true;
        } else
        {
            intent = intent.getAction();
            zzyd().zzzQ().zzj("onUnbind called for intent. action", intent);
            return true;
        }
    }
}
