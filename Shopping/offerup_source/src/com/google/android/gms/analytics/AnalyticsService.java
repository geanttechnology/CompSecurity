// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzb;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzr;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqy;

// Referenced classes of package com.google.android.gms.analytics:
//            AnalyticsReceiver

public final class AnalyticsService extends Service
{

    private static Boolean zzLj;
    private final Handler mHandler = new Handler();

    public AnalyticsService()
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
            boolean flag = zzam.zza(context, com/google/android/gms/analytics/AnalyticsService);
            zzLj = Boolean.valueOf(flag);
            return flag;
        }
    }

    static Handler zza(AnalyticsService analyticsservice)
    {
        return analyticsservice.mHandler;
    }

    private void zzhH()
    {
        Object obj = AnalyticsReceiver.zzpy;
        obj;
        JVM INSTR monitorenter ;
        zzqy zzqy1 = AnalyticsReceiver.zzLh;
        if (zzqy1 == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        if (zzqy1.isHeld())
        {
            zzqy1.release();
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

    public final IBinder onBind(Intent intent)
    {
        return null;
    }

    public final void onCreate()
    {
        super.onCreate();
        zzf zzf1 = zzf.zzX(this);
        zzaf zzaf1 = zzf1.zziu();
        if (zzf1.zziv().zzjA())
        {
            zzaf1.zzba("Device AnalyticsService is starting up");
            return;
        } else
        {
            zzaf1.zzba("Local AnalyticsService is starting up");
            return;
        }
    }

    public final void onDestroy()
    {
        zzf zzf1 = zzf.zzX(this);
        zzaf zzaf1 = zzf1.zziu();
        if (zzf1.zziv().zzjA())
        {
            zzaf1.zzba("Device AnalyticsService is shutting down");
        } else
        {
            zzaf1.zzba("Local AnalyticsService is shutting down");
        }
        super.onDestroy();
    }

    public final int onStartCommand(Intent intent, int i, int j)
    {
        zzhH();
        zzf zzf1 = zzf.zzX(this);
        zzaf zzaf1 = zzf1.zziu();
        intent = intent.getAction();
        if (zzf1.zziv().zzjA())
        {
            zzaf1.zza("Device AnalyticsService called. startId, action", Integer.valueOf(j), intent);
        } else
        {
            zzaf1.zza("Local AnalyticsService called. startId, action", Integer.valueOf(j), intent);
        }
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(intent))
        {
            zzf1.zzhP().zza(new _cls1(j, zzf1, zzaf1));
        }
        return 2;
    }

    private class _cls1
        implements zzw
    {

        final int zzLk;
        final zzf zzLl;
        final zzaf zzLm;
        final AnalyticsService zzLn;

        public void zzc(Throwable throwable)
        {
            class _cls1
                implements Runnable
            {

                final _cls1 zzLo;

                public void run()
                {
label0:
                    {
                        if (zzLo.zzLn.stopSelfResult(zzLo.zzLk))
                        {
                            if (!zzLo.zzLl.zziv().zzjA())
                            {
                                break label0;
                            }
                            zzLo.zzLm.zzba("Device AnalyticsService processed last dispatch request");
                        }
                        return;
                    }
                    zzLo.zzLm.zzba("Local AnalyticsService processed last dispatch request");
                }

                _cls1()
                {
                    zzLo = _cls1.this;
                    super();
                }
            }

            AnalyticsService.zza(zzLn).post(new _cls1());
        }

        _cls1(int i, zzf zzf1, zzaf zzaf1)
        {
            zzLn = AnalyticsService.this;
            zzLk = i;
            zzLl = zzf1;
            zzLm = zzaf1;
            super();
        }
    }

}
