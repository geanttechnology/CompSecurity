// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.medialets.thrift.AdEvent;
import com.medialets.thrift.Event;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;

// Referenced classes of package com.medialets.analytics:
//            b, c, a, MMEvent, 
//            d, e, f

public class MMAnalyticsManager
{
    public static interface AnalyticsListener
    {

        public abstract void onPostComplete();
    }

    protected class ExceptionHandler
        implements Thread.UncaughtExceptionHandler
    {

        private MMAnalyticsManager a;

        public void uncaughtException(Thread thread, Throwable throwable)
        {
            StringBuffer stringbuffer = new StringBuffer();
            StackTraceElement astacktraceelement[] = throwable.getStackTrace();
            int j = astacktraceelement.length;
            for (int i = 0; i < j; i++)
            {
                stringbuffer.append(astacktraceelement[i]);
                stringbuffer.append("@br@");
            }

            MMEvent mmevent = new MMEvent("RuntimeException");
            mmevent.setStringForKey("StackTrace", stringbuffer.toString());
            a.trackEvent(mmevent);
            a.pause();
            a.stop();
            thread.getThreadGroup().uncaughtException(thread, throwable);
        }

        protected ExceptionHandler()
        {
            a = MMAnalyticsManager.this;
            super();
        }
    }


    protected static final int DATA_POSTED = 1;
    private static MMAnalyticsManager a;
    private int b;
    private e c;
    private boolean d;
    private final LocationListener e = new c(this);
    protected AnalyticsListener mAnalyticsListener;
    protected String mAppId;
    protected String mAppVersion;
    protected Location mCachedLocation;
    protected Context mContext;
    protected d mDatabase;
    protected Handler mHandler;
    protected boolean mIsTracking;
    protected LocationManager mLocationManager;
    protected String mLocationProvider;
    protected boolean mLocationTrackingEnabled;

    private MMAnalyticsManager(Context context)
    {
        b = 0;
        d = false;
        mIsTracking = false;
        mLocationProvider = null;
        mLocationTrackingEnabled = false;
        mHandler = new b(this);
        mContext = context;
        mDatabase = new a(mContext);
    }

    private void a(boolean flag)
    {
label0:
        {
            Location location = null;
            if (c != null)
            {
                if (!flag)
                {
                    break label0;
                }
                MMEvent mmevent = new MMEvent("MMInventoryTrackingForSession");
                mmevent.addStringsFromMap(mDatabase.b());
                trackEvent(mmevent);
                Event event = new Event();
                mmevent = new MMEvent("UIApplicationWillTerminateNotification");
                mmevent.a(event);
                TSerializer tserializer = new TSerializer();
                try
                {
                    byte abyte0[] = tserializer.serialize(event);
                    int i = com.medialets.analytics.e.a(mContext);
                    if (mLocationTrackingEnabled)
                    {
                        location = getLocation();
                    }
                    mDatabase.a(c, mmevent.mKey, abyte0, i, location, false, System.currentTimeMillis(), "", 0);
                    mDatabase.a(c);
                    c = null;
                }
                catch (TException texception)
                {
                    Log.d("MMT.MMAnalyticsManager", (new StringBuilder()).append("TException caught:: ").append(texception.toString()).toString());
                }
                Log.d("MMT.MMAnalyticsManager", "Run closed.");
            }
            return;
        }
        c.b();
    }

    public static MMAnalyticsManager sharedInstance(Context context)
    {
        if (a == null)
        {
            a = new MMAnalyticsManager(context);
        }
        return a;
    }

    public String getAppId()
    {
        return mAppId;
    }

    public String getAppVersion()
    {
        return mAppVersion;
    }

    protected Location getLocation()
    {
        if (!mLocationTrackingEnabled)
        {
            return null;
        }
        if (mCachedLocation != null)
        {
            return mCachedLocation;
        }
        Location location;
        try
        {
            location = mLocationManager.getLastKnownLocation(mLocationProvider);
        }
        catch (Exception exception)
        {
            Log.d("MMT.MMAnalyticsManager", (new StringBuilder()).append("Location exception caught:: ").append(exception.toString()).toString());
            return null;
        }
        return location;
    }

    public void incrementSlotForecasting(String s)
    {
        mDatabase.a(s);
    }

    public void initRun()
    {
        c = mDatabase.a();
        if (mAppVersion == null)
        {
            try
            {
                mAppVersion = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0).versionName;
            }
            catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
            {
                Log.d("MMT.MMAnalyticsManager", (new StringBuilder()).append("Error getting package info:: ").append(namenotfoundexception.toString()).toString());
            }
            Log.d("MMT.MMAnalyticsManager", (new StringBuilder()).append("No version provided, using manifest app version: ").append(mAppVersion).toString());
        }
        Log.d("MMT.MMAnalyticsManager", "Initialized run with id");
    }

    public void pause()
    {
        this;
        JVM INSTR monitorenter ;
        if (mLocationTrackingEnabled)
        {
            stopLocationServices();
        }
        a(false);
        d = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void registerExceptionHandler()
    {
        Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());
    }

    public void resume()
    {
        this;
        JVM INSTR monitorenter ;
        if (mLocationTrackingEnabled)
        {
            startLocationServices();
        }
        touchActiveRun();
        d = false;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setAnalyticsListener(AnalyticsListener analyticslistener)
    {
        mAnalyticsListener = analyticslistener;
    }

    public void setAppId(String s)
    {
        mAppId = s;
    }

    public void setAppVersion(String s)
    {
        mAppVersion = s;
    }

    protected void setLocationProvider(String s)
    {
        if (s == null && mLocationProvider != null && !mLocationProvider.equals(s))
        {
            mLocationManager.removeUpdates(e);
        }
        mLocationProvider = s;
        if (s != null)
        {
            mLocationManager.requestLocationUpdates(s, 0x493e0L, 0.0F, e);
        }
    }

    public void start(String s, String s1, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        mAppId = s;
        mAppVersion = s1;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        throw new IllegalArgumentException("appId cannot be null.");
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        startLocationServices();
        mIsTracking = true;
        initRun();
        b = b + 1;
        this;
        JVM INSTR monitorexit ;
    }

    protected void startLocationServices()
    {
        this;
        JVM INSTR monitorenter ;
        Criteria criteria = new Criteria();
        criteria.setAccuracy(2);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(false);
        criteria.setPowerRequirement(1);
        criteria.setSpeedRequired(false);
        mLocationManager = (LocationManager)mContext.getSystemService("location");
        if (mLocationManager != null)
        {
            mLocationProvider = mLocationManager.getBestProvider(criteria, true);
            mLocationTrackingEnabled = true;
            if (mLocationProvider == null)
            {
                mLocationProvider = "network";
            }
            mLocationManager.requestLocationUpdates(mLocationProvider, 0x493e0L, 0.0F, e);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void stop()
    {
        this;
        JVM INSTR monitorenter ;
        mIsTracking = false;
        b = b - 1;
        Log.v("MMT.MMAnalyticsManager", (new StringBuilder()).append("Analytics ref count... ").append(b).toString());
        if (b == 0)
        {
            a(true);
            (new Thread(new f(mContext, mLocationProvider, mAppId, mAppVersion))).start();
        }
        if (mLocationTrackingEnabled)
        {
            stopLocationServices();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void stopLocationServices()
    {
        this;
        JVM INSTR monitorenter ;
        mLocationTrackingEnabled = false;
        mLocationManager.removeUpdates(e);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void touchActiveRun()
    {
        Log.d("MMT.MMAnalyticsManager", "Touching the active run...");
        if (c == null)
        {
            initRun();
            return;
        }
        if (c.c() && d)
        {
            a(true);
            (new Thread(new f(mContext, mLocationProvider, mAppId, mAppVersion))).start();
            initRun();
            return;
        } else
        {
            c.b();
            return;
        }
    }

    public AdEvent trackAdEvent(MMEvent mmevent)
    {
        this;
        JVM INSTR monitorenter ;
        if (mmevent == null)
        {
            break MISSING_BLOCK_LABEL_414;
        }
        AdEvent adevent;
        if (mmevent.mKey == null)
        {
            break MISSING_BLOCK_LABEL_414;
        }
        adevent = new AdEvent();
        mmevent.a(adevent);
        if (!Log.isLoggable("MMT.MMAnalyticsManager", 2)) goto _L2; else goto _L1
_L1:
        String s;
        for (Iterator iterator = mmevent.a.keySet().iterator(); iterator.hasNext(); Log.v("MMT.MMAnalyticsManager", (new StringBuilder()).append("String: ").append(s).append(" = ").append(mmevent.getStringForKey(s)).toString()))
        {
            s = (String)iterator.next();
        }

          goto _L3
_L4:
        Log.d("MMT.MMAnalyticsManager", (new StringBuilder()).append("Exception caught:: ").append(mmevent.toString()).toString());
_L5:
        mmevent = adevent;
_L6:
        this;
        JVM INSTR monitorexit ;
        return mmevent;
_L3:
        try
        {
            String s1;
            for (Iterator iterator1 = mmevent.b.keySet().iterator(); iterator1.hasNext(); Log.v("MMT.MMAnalyticsManager", (new StringBuilder()).append("Number: ").append(s1).append(" = ").append(mmevent.getNumberForKey(s1)).toString()))
            {
                s1 = (String)iterator1.next();
            }

            break MISSING_BLOCK_LABEL_245;
        }
        // Misplaced declaration of an exception variable
        catch (MMEvent mmevent) { }
        finally
        {
            throw mmevent;
        }
          goto _L4
        String s2;
        for (Iterator iterator2 = mmevent.c.keySet().iterator(); iterator2.hasNext(); Log.v("MMT.MMAnalyticsManager", (new StringBuilder()).append("Duration: ").append(s2).append(" = ").append(mmevent.getDurationForKey(s2)).toString()))
        {
            s2 = (String)iterator2.next();
        }

_L2:
        byte abyte0[];
        int i;
        abyte0 = (new TSerializer()).serialize(adevent);
        i = com.medialets.analytics.e.a(mContext);
        Location location = null;
        if (mLocationTrackingEnabled)
        {
            location = getLocation();
        }
        double d1 = mmevent.getDurationForKey("MMAdViewDuration").doubleValue();
        mDatabase.a(c, mmevent.mKey, abyte0, i, location, true, System.currentTimeMillis(), mmevent.slotName, (int)d1);
          goto _L5
        mmevent = null;
          goto _L6
    }

    public void trackEvent(MMEvent mmevent)
    {
        this;
        JVM INSTR monitorenter ;
        if (mmevent == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        Object obj;
        if (mmevent.mKey == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        obj = new Event();
        mmevent.a(((Event) (obj)));
        byte abyte0[];
        int i;
        abyte0 = (new TSerializer()).serialize(((org.apache.thrift.TBase) (obj)));
        i = com.medialets.analytics.e.a(mContext);
        obj = null;
        if (mLocationTrackingEnabled)
        {
            obj = getLocation();
        }
        mDatabase.a(c, mmevent.mKey, abyte0, i, ((Location) (obj)), false, System.currentTimeMillis(), "", 0);
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        mmevent;
        Log.d("MMT.MMAnalyticsManager", (new StringBuilder()).append("Exception caught:: ").append(mmevent.toString()).toString());
        if (true) goto _L2; else goto _L1
_L1:
        mmevent;
        throw mmevent;
    }

    public void useTestServers()
    {
        Log.d("MMT.MMAnalyticsManager", "Setting Analytics to use test servers");
        mContext.getSharedPreferences("com.medialets", 0).edit().putBoolean("useTestServer", true).commit();
    }

    // Unreferenced inner class com/medialets/analytics/b
    final class b extends Handler
    {

        private MMAnalyticsManager a;

        public final void handleMessage(Message message)
        {
            message.what;
            JVM INSTR tableswitch 1 1: default 24
        //                       1 25;
               goto _L1 _L2
_L1:
            return;
_L2:
            if (a.mAnalyticsListener != null)
            {
                a.mAnalyticsListener.onPostComplete();
                return;
            }
            if (true) goto _L1; else goto _L3
_L3:
        }

            b()
            {
                a = MMAnalyticsManager.this;
                super();
            }
    }


    // Unreferenced inner class com/medialets/analytics/c
    final class c
        implements LocationListener
    {

        private MMAnalyticsManager a;

        public final void onLocationChanged(Location location)
        {
            a.mCachedLocation = location;
        }

        public final void onProviderDisabled(String s)
        {
        }

        public final void onProviderEnabled(String s)
        {
        }

        public final void onStatusChanged(String s, int i, Bundle bundle)
        {
        }

            c()
            {
                a = MMAnalyticsManager.this;
                super();
            }
    }

}
