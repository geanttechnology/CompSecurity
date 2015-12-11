// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.webkit.WebView;
import com.medialets.analytics.MMAnalyticsManager;
import com.medialets.analytics.MMEvent;
import java.lang.ref.WeakReference;
import java.util.HashMap;

// Referenced classes of package com.medialets.advertising:
//            c, e, InterstitialAdView, a, 
//            BannerAdView, AdManagerService, DataSource, AdListener

public final class AdManager
{
    public static interface ServiceListener
    {

        public abstract void onServiceConnected();
    }

    public static interface SyncListener
    {

        public abstract void onSyncComplete();

        public abstract void onSyncFailed(int i);

        public abstract void onSyncStarted();
    }


    protected static final int SYNC_COMPLETE = 3;
    public static final int SYNC_NO_NETWORK = 1;
    public static final int SYNC_UNEXPECTED_ERROR = 2;
    private static AdManager c;
    private static Class d = com/medialets/advertising/AdManager;
    String a;
    String b;
    private WeakReference e;
    private ActivityInfo f;
    private DataSource g;
    private Handler h;
    protected AdListener mAdListener;
    protected boolean mDisconnectRequested;
    protected AdManagerService mService;
    protected ServiceConnection mServiceConnection;
    protected ServiceListener mServiceListener;
    protected boolean mServiceRunning;
    protected boolean mShouldSync;
    protected SyncListener mSyncListener;
    protected boolean mUseTestServers;

    private AdManager()
    {
        mUseTestServers = false;
        mServiceRunning = false;
        mDisconnectRequested = false;
        mShouldSync = true;
        mServiceConnection = new e(this);
        h = new c(this);
    }

    private AdManager(String s, String s1)
    {
        mUseTestServers = false;
        mServiceRunning = false;
        mDisconnectRequested = false;
        mShouldSync = true;
        mServiceConnection = new e(this);
        h = new c(this);
        a = s;
        b = s1;
    }

    static DataSource a(AdManager admanager)
    {
        return admanager.g;
    }

    public static AdManager getInstance()
    {
        synchronized (d)
        {
            if (c == null)
            {
                c = new AdManager();
            }
        }
        return c;
        exception;
        class1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static AdManager getInstance(String s, String s1)
    {
        synchronized (d)
        {
            if (c == null)
            {
                c = new AdManager(s, s1);
            }
        }
        return c;
        s;
        class1;
        JVM INSTR monitorexit ;
        throw s;
    }

    public final void displayInterstitialAd()
    {
    }

    public final void displayInterstitialAd(InterstitialAdView interstitialadview)
    {
        interstitialadview.prepare();
    }

    public final void displayInterstitialAd(InterstitialAdView interstitialadview, String s)
    {
        interstitialadview.prepare(s);
    }

    protected final Activity getCurrentActivity()
    {
        this;
        JVM INSTR monitorenter ;
        Activity activity = (Activity)e.get();
        this;
        JVM INSTR monitorexit ;
        return activity;
        Exception exception;
        exception;
        throw exception;
    }

    protected final ActivityInfo getCurrentActivityInfo()
    {
        this;
        JVM INSTR monitorenter ;
        ActivityInfo activityinfo = f;
        this;
        JVM INSTR monitorexit ;
        return activityinfo;
        Exception exception;
        exception;
        throw exception;
    }

    protected final void onSyncStarted()
    {
        com.medialets.advertising.a.d("Ad cache sync has started...");
        if (mSyncListener != null)
        {
            mSyncListener.onSyncStarted();
        }
    }

    public final void pause()
    {
    }

    public final boolean prepare(BannerAdView banneradview)
    {
        return banneradview.prepare();
    }

    public final boolean prepare(BannerAdView banneradview, String s)
    {
        return banneradview.prepare(s);
    }

    public final boolean prepare(BannerAdView banneradview, String s, String s1)
    {
        banneradview.setSlotKeywords(s);
        banneradview.setBlockedKeywords(s1);
        return banneradview.prepare();
    }

    public final boolean prepare(BannerAdView banneradview, String s, String s1, HashMap hashmap)
    {
        banneradview.setSlotKeywords(s);
        banneradview.setBlockedKeywords(s1);
        banneradview.setCustomMacros(hashmap);
        return banneradview.prepare();
    }

    public final void registerWebView(WebView webview, String s, int i, String s1, String s2)
    {
    }

    public final void resume(Activity activity)
    {
        e = new WeakReference(activity);
        f = activity.getPackageManager().resolveActivity(activity.getIntent(), 0).activityInfo;
    }

    protected final void sendMessage(int i, Object obj)
    {
        Message.obtain(h, i, obj).sendToTarget();
    }

    public final void setAdListener(AdListener adlistener)
    {
        mAdListener = adlistener;
    }

    public final void setCurrentActivity(Activity activity)
    {
        e = new WeakReference(activity);
        f = activity.getPackageManager().resolveActivity(activity.getIntent(), 0).activityInfo;
    }

    protected final void setDataSource(DataSource datasource)
    {
        g = datasource;
    }

    public final void setServiceListener(ServiceListener servicelistener)
    {
        mServiceListener = servicelistener;
    }

    public final void setSyncListener(SyncListener synclistener)
    {
        mSyncListener = synclistener;
    }

    public final void start(Activity activity)
    {
        e = new WeakReference(activity);
        f = activity.getPackageManager().resolveActivity(activity.getIntent(), 0).activityInfo;
        activity.bindService(new Intent(activity, com/medialets/advertising/AdManagerService), mServiceConnection, 1);
        mServiceRunning = true;
    }

    protected final void start(Activity activity, boolean flag)
    {
        mShouldSync = flag;
        start(activity);
    }

    public final void stop(Activity activity)
    {
        activity.unbindService(mServiceConnection);
    }

    public final void trackEvent(MMEvent mmevent)
    {
        if (mService != null)
        {
            mService.getAnalyticsManager().trackEvent(mmevent);
        }
    }

    public final void useTestServers()
    {
        mUseTestServers = true;
    }


    // Unreferenced inner class com/medialets/advertising/c
    final class c extends Handler
    {

        private AdManager a;

        public final void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                com.medialets.advertising.a.d((new StringBuilder()).append("Unexpected message: ").append(message.what).toString());
                return;

            case 1: // '\001'
                com.medialets.advertising.a.a("Ad cache sync failed: No Network Connection.");
                if (a.mSyncListener != null)
                {
                    a.mSyncListener.onSyncFailed(1);
                }
                a.mService.onSyncCompleted();
                return;

            case 2: // '\002'
                com.medialets.advertising.a.a((new StringBuilder()).append("Ad cache sync failed: Unexpected error: ").append(message.obj).toString());
                if (a.mSyncListener != null)
                {
                    a.mSyncListener.onSyncFailed(2);
                }
                a.mService.onSyncCompleted();
                return;

            case 3: // '\003'
                com.medialets.advertising.a.a("Ad cache sync completed successfully.");
                break;
            }
            if (a.mSyncListener != null)
            {
                a.mSyncListener.onSyncComplete();
            }
            a.mService.onSyncCompleted();
        }

            c()
            {
                a = AdManager.this;
                super();
            }
    }


    // Unreferenced inner class com/medialets/advertising/e
    final class e
        implements ServiceConnection
    {

        private AdManager a;

        public final void onServiceConnected(ComponentName componentname, IBinder ibinder)
        {
            a.mService = ((AdManagerService.AdBinder)ibinder).getService();
            if (a.mUseTestServers)
            {
                a.mService.useTestServers();
            }
            if (a.a != null)
            {
                a.mService.setApplicationId(a.a);
            }
            if (a.b != null)
            {
                a.mService.setApplicationVersion(a.b);
            }
            if (AdManager.a(a) != null)
            {
                a.mService.setDataSource(AdManager.a(a));
            }
            a.mService.onConnected();
            if (a.mServiceListener != null)
            {
                a.mServiceListener.onServiceConnected();
            }
        }

        public final void onServiceDisconnected(ComponentName componentname)
        {
            com.medialets.advertising.a.c("Service disconnected.");
            a.mServiceListener = null;
            a.mService = null;
        }

            e()
            {
                a = AdManager.this;
                super();
            }
    }

}
