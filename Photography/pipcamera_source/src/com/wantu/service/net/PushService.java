// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.service.net;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.fotoable.ad.FotoCustomReport;
import com.fotoable.ad.HeartBeatAsyncTask;
import jd;
import jj;

public class PushService extends IntentService
    implements jd
{

    public PushService()
    {
        super("PushService");
    }

    public void a()
    {
    }

    public void a(String s)
    {
        if (jj.b())
        {
            HeartBeatAsyncTask.beat(getApplicationContext(), true);
        }
        stopSelf();
    }

    protected void b()
    {
        jj.a().a(this, this, "847715203438");
        if (!jj.b())
        {
            FotoCustomReport.xgToken = jj.a().a(getApplicationContext());
            return;
        }
        try
        {
            FotoCustomReport.googleToken = jj.a().a(getApplicationContext());
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
        return;
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
        Log.e("PushService", "onCreate() executed");
    }

    public void onDestroy()
    {
        super.onDestroy();
        Log.d("PushService", "onDestroy() executed");
    }

    protected void onHandleIntent(Intent intent)
    {
        b();
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        Log.d("PushService", "onStartCommand() executed");
        return super.onStartCommand(intent, i, j);
    }
}
