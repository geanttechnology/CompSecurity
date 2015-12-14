// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.service.net;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import anz;
import aoo;
import com.crashlytics.android.Crashlytics;
import com.fotoable.ad.FotoCustomReport;
import com.fotoable.ad.HeartBeatAsyncTask;

public class PushService extends IntentService
    implements anz
{

    public PushService()
    {
        super("PushService");
    }

    protected void a()
    {
        aoo.a().a(this, this, "847715203438");
        if (!aoo.b())
        {
            FotoCustomReport.xgToken = aoo.a().a(getApplicationContext());
            return;
        }
        try
        {
            FotoCustomReport.googleToken = aoo.a().a(getApplicationContext());
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
        return;
    }

    public void b(String s)
    {
        if (aoo.b())
        {
            HeartBeatAsyncTask.beat(getApplicationContext(), true);
        }
        stopSelf();
    }

    public void e()
    {
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
        Log.e("PushService", "onDestroy() executed");
    }

    protected void onHandleIntent(Intent intent)
    {
        Log.e("PushService", "onHandleIntent() executed");
        a();
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        Log.e("PushService", "onStartCommand() executed");
        return super.onStartCommand(intent, i, j);
    }
}
