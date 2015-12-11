// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzb;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzr;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqy;
import com.google.android.gms.measurement.zzg;

// Referenced classes of package com.google.android.gms.analytics:
//            CampaignTrackingReceiver

public class CampaignTrackingService extends Service
{

    private static Boolean zzLj;
    private Handler mHandler;

    public CampaignTrackingService()
    {
    }

    private Handler getHandler()
    {
        Handler handler1 = mHandler;
        Handler handler = handler1;
        if (handler1 == null)
        {
            handler = new Handler(getMainLooper());
            mHandler = handler;
        }
        return handler;
    }

    public static boolean zzW(Context context)
    {
        zzx.zzw(context);
        if (zzLj != null)
        {
            return zzLj.booleanValue();
        } else
        {
            boolean flag = zzam.zza(context, com/google/android/gms/analytics/CampaignTrackingService);
            zzLj = Boolean.valueOf(flag);
            return flag;
        }
    }

    private void zzhH()
    {
        Object obj = CampaignTrackingReceiver.zzpy;
        obj;
        JVM INSTR monitorenter ;
        zzqy zzqy1 = CampaignTrackingReceiver.zzLh;
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

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
        zzf.zzX(this).zziu().zzba("CampaignTrackingService is starting up");
    }

    public void onDestroy()
    {
        zzf.zzX(this).zziu().zzba("CampaignTrackingService is shutting down");
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        zzhH();
        zzf zzf1 = zzf.zzX(this);
        zzaf zzaf1 = zzf1.zziu();
        Handler handler = null;
        if (zzf1.zziv().zzjA())
        {
            zzaf1.zzbe("Unexpected installation campaign (package side)");
            intent = handler;
        } else
        {
            intent = intent.getStringExtra("referrer");
        }
        handler = getHandler();
        if (TextUtils.isEmpty(intent))
        {
            if (!zzf1.zziv().zzjA())
            {
                zzaf1.zzbd("No campaign found on com.android.vending.INSTALL_REFERRER \"referrer\" extra");
            }
            zzf1.zziw().zzg(new _cls1(zzaf1, handler, j));
            return 2;
        }
        i = zzf1.zziv().zzjE();
        if (intent.length() > i)
        {
            zzaf1.zzc("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(intent.length()), Integer.valueOf(i));
            intent = intent.substring(0, i);
        }
        zzaf1.zza("CampaignTrackingService called. startId, campaign", Integer.valueOf(j), intent);
        zzf1.zzhP().zza(intent, new _cls2(zzaf1, handler, j));
        return 2;
    }

    protected void zza(zzaf zzaf1, Handler handler, int i)
    {
        handler.post(new _cls3(i, zzaf1));
    }

    private class _cls1
        implements Runnable
    {

        final int zzLk;
        final zzaf zzLm;
        final CampaignTrackingService zzLu;
        final Handler zzt;

        public void run()
        {
            zzLu.zza(zzLm, zzt, zzLk);
        }

        _cls1(zzaf zzaf1, Handler handler, int i)
        {
            zzLu = CampaignTrackingService.this;
            zzLm = zzaf1;
            zzt = handler;
            zzLk = i;
            super();
        }
    }


    private class _cls2
        implements Runnable
    {

        final int zzLk;
        final zzaf zzLm;
        final CampaignTrackingService zzLu;
        final Handler zzt;

        public void run()
        {
            zzLu.zza(zzLm, zzt, zzLk);
        }

        _cls2(zzaf zzaf1, Handler handler, int i)
        {
            zzLu = CampaignTrackingService.this;
            zzLm = zzaf1;
            zzt = handler;
            zzLk = i;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final int zzLk;
        final zzaf zzLm;
        final CampaignTrackingService zzLu;

        public void run()
        {
            boolean flag = zzLu.stopSelfResult(zzLk);
            if (flag)
            {
                zzLm.zza("Install campaign broadcast processed", Boolean.valueOf(flag));
            }
        }

        _cls3(int i, zzaf zzaf1)
        {
            zzLu = CampaignTrackingService.this;
            zzLk = i;
            zzLm = zzaf1;
            super();
        }
    }

}
