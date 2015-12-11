// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.base;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.bestbuy.android.activities.home.HomeActivity;
import com.exacttarget.etpushsdk.ETException;
import com.exacttarget.etpushsdk.ETPush;
import com.exacttarget.etpushsdk.event.ReadyAimFireInitCompletedEvent;
import com.exacttarget.etpushsdk.event.RegistrationEvent;
import com.exacttarget.etpushsdk.util.EventBus;
import com.inc247.ApplicationStatusModel.ChatRunningStatus;
import fo;
import fs;
import hs;
import kf;
import lq;
import na;
import nb;
import ng;
import nq;

public class BBYApplication extends Application
{

    private static final String TAG = com/bestbuy/android/base/BBYApplication.getSimpleName();
    public static boolean firstLaunch = true;
    private static BBYApplication instance;
    private fo databaseProvider;
    private boolean isRegistrationStarted;
    private boolean mLoginNeeded;
    private boolean mLoginOkay;
    private SensorManager sManager;
    private Sensor sensor;
    private SharedPreferences settingsSharedPrefs;
    private nq shakeEventListener;

    public BBYApplication()
    {
        isRegistrationStarted = false;
    }

    public static BBYApplication getInstance()
    {
        return instance;
    }

    private void initShakeSetting()
    {
        SharedPreferences sharedpreferences = nb.a().b();
        if (sharedpreferences.getString("shake_your_device", "").isEmpty())
        {
            sharedpreferences.edit().putString("shake_your_device", "On").commit();
        }
    }

    public fo getDatabaseProvider()
    {
        return databaseProvider;
    }

    public boolean isLoginNeeded()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mLoginNeeded;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isLoginOkay()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mLoginOkay;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public void onCreate()
    {
        super.onCreate();
        instance = this;
        android.content.SharedPreferences.Editor editor1;
        try
        {
            databaseProvider = new fo(this);
            ng.a(this);
            nb.a(this);
            settingsSharedPrefs = nb.a().c();
            settingsSharedPrefs.edit().putBoolean("IS_MAP_VIEW", false).commit();
            settingsSharedPrefs.edit().putString("APP_STATE", "Background").commit();
            nb.a().f(true);
            na.a(this);
            CookieSyncManager.createInstance(this);
            CookieManager.getInstance().setAcceptCookie(true);
            initShakeSetting();
            mLoginNeeded = false;
            fs.b((new StringBuilder()).append("v").append(getPackageManager().getPackageInfo(getPackageName(), 0).versionName).toString());
        }
        catch (Exception exception)
        {
            kf.a(TAG, exception);
        }
        if (!settingsSharedPrefs.getBoolean("IS_APP_RESET", false))
        {
            getApplicationContext().deleteDatabase("etdb.db");
            android.content.SharedPreferences.Editor editor = getSharedPreferences("ETPush", 0).edit();
            editor.clear();
            editor.commit();
            settingsSharedPrefs.edit().putBoolean("IS_APP_RESET", true).commit();
        }
        EventBus.getDefault().register(this);
        lq.a(this, TAG);
        if (!settingsSharedPrefs.getBoolean("FIRST_APP_LAUNCH", true))
        {
            break MISSING_BLOCK_LABEL_373;
        }
        settingsSharedPrefs.edit().putBoolean("FIRST_APP_LAUNCH", false).commit();
        editor1 = settingsSharedPrefs.edit();
        editor1.putBoolean(getResources().getString(0x7f08004b), true);
        editor1.putBoolean(getResources().getString(0x7f08003e), false);
        editor1.putBoolean(getResources().getString(0x7f08008a), false);
        editor1.commit();
        lq.a(this, null);
_L1:
        kf.b(TAG, "ET push notification");
        return;
        try
        {
            boolean flag = settingsSharedPrefs.getBoolean(getResources().getString(0x7f08004b), false);
            boolean flag1 = settingsSharedPrefs.getBoolean(getResources().getString(0x7f08003e), false);
            boolean flag2 = settingsSharedPrefs.getBoolean(getResources().getString(0x7f08008a), false);
            if (!Boolean.valueOf(flag).booleanValue() && !Boolean.valueOf(flag1).booleanValue() && !Boolean.valueOf(flag2).booleanValue())
            {
                ETPush.pushManager().disablePush();
            }
        }
        catch (Exception exception1)
        {
            kf.e(TAG, (new StringBuilder()).append("PN UA Configaration ERROR: ").append(exception1.getLocalizedMessage()).toString());
            return;
        }
          goto _L1
    }

    public void onEvent(ReadyAimFireInitCompletedEvent readyaimfireinitcompletedevent)
    {
        try
        {
            if (readyaimfireinitcompletedevent.isReadyAimFireReady())
            {
                readyaimfireinitcompletedevent = ETPush.getInstance();
                readyaimfireinitcompletedevent.enablePush();
                readyaimfireinitcompletedevent.setOpenDirectRecipient(com/bestbuy/android/activities/home/HomeActivity);
                readyaimfireinitcompletedevent.setNotificationRecipientClass(com/bestbuy/android/activities/home/HomeActivity);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ReadyAimFireInitCompletedEvent readyaimfireinitcompletedevent)
        {
            readyaimfireinitcompletedevent.printStackTrace();
        }
    }

    public void onEvent(RegistrationEvent registrationevent)
    {
        nb.a().a(registrationevent.getDeviceId());
        nb.a().b(registrationevent.getSystemToken());
        try
        {
            if (registrationevent.getSubscriberKey() == null || TextUtils.isEmpty(registrationevent.getSubscriberKey()) || registrationevent.getSubscriberKey().equals("null"))
            {
                ETPush.getInstance().setSubscriberKey(registrationevent.getDeviceId());
            }
        }
        // Misplaced declaration of an exception variable
        catch (RegistrationEvent registrationevent)
        {
            registrationevent.printStackTrace();
        }
        if (!isRegistrationStarted)
        {
            isRegistrationStarted = true;
            (new hs()).execute(new Void[0]);
        }
    }

    public void registerSensor()
    {
        if (ChatRunningStatus.getChatRunning())
        {
            return;
        } else
        {
            sManager = (SensorManager)getSystemService("sensor");
            sensor = sManager.getDefaultSensor(1);
            shakeEventListener = new nq();
            sManager.registerListener(shakeEventListener, sensor, 3);
            return;
        }
    }

    public void setLoginNeeded(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        mLoginNeeded = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setLoginOkay(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        mLoginOkay = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setLoginOkayAndNotify()
    {
        this;
        JVM INSTR monitorenter ;
        if (!isLoginOkay()) goto _L2; else goto _L1
_L1:
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(new Intent("loginOkay"));
        mLoginNeeded = true;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        mLoginOkay = true;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void unRegisterSensor()
    {
        if (sManager != null)
        {
            sManager.unregisterListener(shakeEventListener);
        }
    }

}
