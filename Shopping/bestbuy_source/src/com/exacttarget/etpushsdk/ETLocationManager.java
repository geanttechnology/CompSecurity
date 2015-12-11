// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.RemoteException;
import android.os.SystemClock;
import com.exacttarget.etpushsdk.data.Message;
import com.exacttarget.etpushsdk.data.Region;
import com.exacttarget.etpushsdk.data.RegionMessage;
import com.exacttarget.etpushsdk.data.Registration;
import com.exacttarget.etpushsdk.database.e;
import com.exacttarget.etpushsdk.database.f;
import com.exacttarget.etpushsdk.event.BackgroundEvent;
import com.exacttarget.etpushsdk.event.BackgroundEventListener;
import com.exacttarget.etpushsdk.event.BeaconResponseEvent;
import com.exacttarget.etpushsdk.event.BeaconResponseEventListener;
import com.exacttarget.etpushsdk.event.GeofenceResponseEvent;
import com.exacttarget.etpushsdk.event.GeofenceResponseEventListener;
import com.exacttarget.etpushsdk.event.LastKnownLocationEvent;
import com.exacttarget.etpushsdk.event.LastKnownLocationEventListener;
import com.exacttarget.etpushsdk.event.LocationUpdateEvent;
import com.exacttarget.etpushsdk.event.LocationUpdateEventListener;
import com.exacttarget.etpushsdk.event.PowerStatusChangedEvent;
import com.exacttarget.etpushsdk.location.a;
import com.exacttarget.etpushsdk.location.b;
import com.exacttarget.etpushsdk.location.c;
import com.exacttarget.etpushsdk.location.g;
import com.exacttarget.etpushsdk.util.EventBus;
import com.exacttarget.etpushsdk.util.d;
import com.exacttarget.etpushsdk.util.j;
import com.exacttarget.etpushsdk.util.m;
import com.radiusnetworks.ibeacon.IBeaconManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import qm;

// Referenced classes of package com.exacttarget.etpushsdk:
//            c, ETPush, ETLocationReceiver, ETException, 
//            e, f, g, h, 
//            i, j, k, l, 
//            d

public class ETLocationManager
    implements BackgroundEventListener, BeaconResponseEventListener, GeofenceResponseEventListener, LastKnownLocationEventListener, LocationUpdateEventListener
{

    private static final Object b = new Object();
    private static final Object c = new Object();
    private static ETLocationManager d;
    private static Boolean e = null;
    private static Boolean f = null;
    private static CountDownLatch g = new CountDownLatch(0);
    private static CountDownLatch h = new CountDownLatch(0);
    protected a a;
    private Context i;
    private AlarmManager j;
    private PendingIntent k;
    private PendingIntent l;
    private qm m;
    private c n;
    private IBeaconManager o;
    private b p;
    private boolean q;
    private BroadcastReceiver r;

    private ETLocationManager(Context context)
    {
        q = false;
        r = new com.exacttarget.etpushsdk.c(this);
        i = context;
        EventBus.getInstance().register(this);
        a = new com.exacttarget.etpushsdk.location.c(context);
        j = (AlarmManager)context.getSystemService("alarm");
        n = new c(null);
        f(true);
        h(true);
    }

    static b a(ETLocationManager etlocationmanager)
    {
        return etlocationmanager.p;
    }

    static CountDownLatch a(CountDownLatch countdownlatch)
    {
        g = countdownlatch;
        return countdownlatch;
    }

    static qm a(ETLocationManager etlocationmanager, qm qm)
    {
        etlocationmanager.m = qm;
        return qm;
    }

    protected static void a(Context context)
    {
        if (d == null)
        {
            com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "readyAimFire()");
            d = new ETLocationManager(context);
            com.exacttarget.etpushsdk.util.d.a(com.exacttarget.etpushsdk.ETPush.a(), "et_key_run_once", Boolean.valueOf(true));
            com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "start receiving passive location updates");
            b b1 = new b((LocationManager)context.getSystemService("location"));
            Intent intent = new Intent(context, com/exacttarget/etpushsdk/ETLocationReceiver);
            intent.setAction("et_location_action_passive_location_change");
            b1.a(0x493e0L, 0L, PendingIntent.getActivity(context, 1003, intent, 0x8000000));
            com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "finished receiving passive location updates");
            if (d.c())
            {
                com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "want to watch locations, so start watching");
                d.a(false);
            } else
            {
                com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "DO NOT WANT to watch locations");
                e = Boolean.valueOf(false);
            }
            if (d.e())
            {
                d.b(false);
                return;
            } else
            {
                f = Boolean.valueOf(false);
                return;
            }
        } else
        {
            throw new ETException("You must have called readyAimFire more than once.");
        }
    }

    static boolean a(ETLocationManager etlocationmanager, boolean flag)
    {
        etlocationmanager.q = flag;
        return flag;
    }

    static IBeaconManager b(ETLocationManager etlocationmanager)
    {
        return etlocationmanager.o;
    }

    static CountDownLatch b(CountDownLatch countdownlatch)
    {
        h = countdownlatch;
        return countdownlatch;
    }

    static qm c(ETLocationManager etlocationmanager)
    {
        return etlocationmanager.m;
    }

    static c d(ETLocationManager etlocationmanager)
    {
        return etlocationmanager.n;
    }

    static Context e(ETLocationManager etlocationmanager)
    {
        return etlocationmanager.i;
    }

    static void f(ETLocationManager etlocationmanager)
    {
        etlocationmanager.l();
    }

    static boolean g(ETLocationManager etlocationmanager)
    {
        return etlocationmanager.q;
    }

    public static ETLocationManager getInstance()
    {
        com/exacttarget/etpushsdk/ETLocationManager;
        JVM INSTR monitorenter ;
        com.exacttarget.etpushsdk.ETPush.c();
        if (!com.exacttarget.etpushsdk.util.d.h())
        {
            break MISSING_BLOCK_LABEL_43;
        }
        if (d == null)
        {
            throw new ETException("You forgot to call readyAimFire first.");
        }
        break MISSING_BLOCK_LABEL_34;
        Exception exception;
        exception;
        com/exacttarget/etpushsdk/ETLocationManager;
        JVM INSTR monitorexit ;
        throw exception;
        ETLocationManager etlocationmanager = d;
        com/exacttarget/etpushsdk/ETLocationManager;
        JVM INSTR monitorexit ;
        return etlocationmanager;
        throw new ETException("ETLocationManager disabled. Ensure you called readyAimFire and enabled it first.");
    }

    static BroadcastReceiver h(ETLocationManager etlocationmanager)
    {
        return etlocationmanager.r;
    }

    static CountDownLatch h()
    {
        return g;
    }

    static CountDownLatch i()
    {
        return h;
    }

    static void i(ETLocationManager etlocationmanager)
    {
        etlocationmanager.m();
    }

    static Boolean j()
    {
        return e;
    }

    static Boolean k()
    {
        return f;
    }

    private void l()
    {
        com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "startLocationBackgroundWatcher() started");
        if (!g())
        {
            com.exacttarget.etpushsdk.util.m.c("~!ETLocationManager", "No Location Providers available.  ET will wait patiently until they are turned on to start watching location.");
            return;
        }
        com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "Getting PowerStatusChangedEvent.");
        PowerStatusChangedEvent powerstatuschangedevent = (PowerStatusChangedEvent)EventBus.getInstance().a(com/exacttarget/etpushsdk/event/PowerStatusChangedEvent);
        com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "Have PowerStatusChangedEvent.");
        if (powerstatuschangedevent == null || powerstatuschangedevent.getStatus() == 1)
        {
            com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "Getting getLastBestLocation.");
            Object obj = a.a(100, System.currentTimeMillis() - 0xdbba0L);
            if (obj != null)
            {
                com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", String.format("Have getLastBestLocation.  lat: %.7f lng: %.7f", new Object[] {
                    Double.valueOf(((Location) (obj)).getLatitude()), Double.valueOf(((Location) (obj)).getLongitude())
                }));
            }
            obj = new Intent(i, com/exacttarget/etpushsdk/ETLocationReceiver);
            ((Intent) (obj)).setAction("et_location_action_timeout");
            k = PendingIntent.getBroadcast(i, 1000, ((Intent) (obj)), 0x8000000);
            j.set(2, SystemClock.elapsedRealtime() + 60000L, k);
            if (l == null)
            {
                com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "Set recurring 15-minute locationWakeup Alarm.");
                Intent intent = new Intent(i, com/exacttarget/etpushsdk/ETLocationReceiver);
                intent.setAction("et_location_action_15minute_update");
                l = PendingIntent.getBroadcast(i, 1001, intent, 0x8000000);
                j.setInexactRepeating(2, SystemClock.elapsedRealtime() + 0xdbba0L, 0xdbba0L, l);
            }
        }
        com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "startLocationBackgroundWatcher() ended");
    }

    public static ETLocationManager locationManager()
    {
        com/exacttarget/etpushsdk/ETLocationManager;
        JVM INSTR monitorenter ;
        ETLocationManager etlocationmanager = getInstance();
        com/exacttarget/etpushsdk/ETLocationManager;
        JVM INSTR monitorexit ;
        return etlocationmanager;
        Exception exception;
        exception;
        throw exception;
    }

    private void m()
    {
        com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "stopLocationBackgroundWatcher() started");
        if (!f.booleanValue() && !e.booleanValue())
        {
            com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "stopLocationBackgroundWatcher stopping services...");
            if (a != null)
            {
                a.a();
            }
            if (k != null)
            {
                j.cancel(k);
                k = null;
            }
            if (l != null)
            {
                j.cancel(l);
                l = null;
            }
        }
        com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "stopLocationBackgroundWatcher() ended");
    }

    public void a()
    {
        com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "enterLowPowerMode()");
        if (a != null)
        {
            a.a();
        }
        if (k != null)
        {
            j.cancel(k);
            k = null;
        }
        if (l != null)
        {
            j.cancel(l);
            l = null;
        }
    }

    protected void a(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "startWatchingLocation() started");
        if (com.exacttarget.etpushsdk.util.d.h()) goto _L2; else goto _L1
_L1:
        com.exacttarget.etpushsdk.util.m.c("~!ETLocationManager", "nothing to do.  LocationManager is not active");
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (com.exacttarget.etpushsdk.util.j.a(i))
        {
            break MISSING_BLOCK_LABEL_56;
        }
        com.exacttarget.etpushsdk.util.m.c("~!ETLocationManager", "nothing to do.  Google Play Services not available");
          goto _L3
        Exception exception;
        exception;
        throw exception;
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        Thread thread;
        e = Boolean.valueOf(true);
        com.exacttarget.etpushsdk.ETPush.b().setLocationEnabled(Boolean.valueOf(true));
        thread = new Thread(new com.exacttarget.etpushsdk.e(this, flag));
        if (g.getCount() != 0L)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "stopWatchingLocation is not running.  Now continue with locationStateThread start.");
        g = new CountDownLatch(1);
        thread.start();
_L4:
        com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "startWatchingLocation() ended.  Check locationStateThread start for final result.");
          goto _L3
        (new Thread(new com.exacttarget.etpushsdk.f(this, thread))).start();
          goto _L4
        Exception exception1;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
          goto _L3
    }

    public void b()
    {
        a(false);
    }

    protected boolean b(boolean flag)
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "startWatchingProximity() started.");
        if (com.exacttarget.etpushsdk.util.d.h() || com.exacttarget.etpushsdk.util.d.i()) goto _L2; else goto _L1
_L1:
        com.exacttarget.etpushsdk.util.m.c("~!ETLocationManager", "Nothing to do.  Neither LocationManager nor Proximity are active");
        flag = flag1;
_L3:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        if (com.exacttarget.etpushsdk.util.d.i() && o == null)
        {
            o = IBeaconManager.getInstanceForApplication(i);
            o.setBackgroundScanPeriod(5000L);
            o.setBackgroundBetweenScanPeriod(10000L);
            p = new b(null);
        }
        if (o.checkAvailability())
        {
            break MISSING_BLOCK_LABEL_142;
        }
        com.exacttarget.etpushsdk.util.m.c("~!ETLocationManager", "Bluetooth LE available, but not currently turned on in settings.");
        flag = flag1;
          goto _L3
        Object obj;
        obj;
        o = null;
        p = null;
        throw obj;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        Object obj1 = c;
        obj1;
        JVM INSTR monitorenter ;
        Thread thread;
        f = Boolean.valueOf(true);
        thread = new Thread(new com.exacttarget.etpushsdk.g(this, flag));
        if (h.getCount() != 0L)
        {
            break MISSING_BLOCK_LABEL_214;
        }
        com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "stopWatchingProximityThread is not running.  So continue to start watching proximity.");
        h = new CountDownLatch(1);
        thread.start();
_L4:
        flag = true;
          goto _L3
        (new Thread(new h(this, thread))).start();
          goto _L4
        Exception exception;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
          goto _L3
    }

    protected void c(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "stopWatchingLocation() started");
        if (com.exacttarget.etpushsdk.util.d.h()) goto _L2; else goto _L1
_L1:
        com.exacttarget.etpushsdk.util.m.c("~!ETLocationManager", "nothing to do.  LocationManager is not active");
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        Thread thread;
        e = Boolean.valueOf(flag);
        com.exacttarget.etpushsdk.ETPush.b().setLocationEnabled(Boolean.valueOf(flag));
        thread = new Thread(new i(this, flag));
        if (g.getCount() != 0L)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "startWatchingLocation is not running.  Now continue with locationStateThread stop.");
        g = new CountDownLatch(1);
        thread.start();
_L4:
        com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "stopWatchingLocation() ended.  check locationStateThread stop for final result.");
          goto _L3
        obj;
        throw obj;
        (new Thread(new com.exacttarget.etpushsdk.j(this, thread))).start();
          goto _L4
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
          goto _L3
    }

    public boolean c()
    {
        return ((Boolean)com.exacttarget.etpushsdk.util.d.a(i, "et_geo_enabled_key", Boolean.valueOf(true), new Object[] {
            i.getSharedPreferences("~!ETLocationManager", 0)
        })).booleanValue();
    }

    protected void d(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "stopWatchingProximity() Began");
        if (com.exacttarget.etpushsdk.util.d.h() || com.exacttarget.etpushsdk.util.d.i()) goto _L2; else goto _L1
_L1:
        com.exacttarget.etpushsdk.util.m.c("~!ETLocationManager", "Nothing to do.  Either Location or Proximity was not enabled in readyAimFire().");
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (isWatchingProximity())
        {
            break MISSING_BLOCK_LABEL_59;
        }
        com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "Nothing to do. Not watching proximity.");
          goto _L3
        Exception exception;
        exception;
        throw exception;
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        Thread thread;
        f = Boolean.valueOf(false);
        thread = new Thread(new k(this, flag));
        if (h.getCount() != 0L)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "startWatchingProximityThread is not running.  So continue to stop watching proximity.");
        h = new CountDownLatch(1);
        thread.start();
_L4:
        com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "stopWatchingProximity() Ended");
          goto _L3
        (new Thread(new l(this, thread))).start();
          goto _L4
        Exception exception1;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
          goto _L3
    }

    protected boolean d()
    {
        return ((Boolean)com.exacttarget.etpushsdk.util.d.a(i, "et_geofence_invalidated_key", Boolean.valueOf(true), new Object[] {
            i.getSharedPreferences("~!ETLocationManager", 0)
        })).booleanValue();
    }

    public void e(boolean flag)
    {
        com.exacttarget.etpushsdk.util.d.a(com.exacttarget.etpushsdk.ETPush.a(), "et_geo_enabled_key", Boolean.valueOf(flag));
    }

    public boolean e()
    {
        return ((Boolean)com.exacttarget.etpushsdk.util.d.a(i, "et_proximity_enabled_key", Boolean.valueOf(false), new Object[] {
            i.getSharedPreferences("~!ETLocationManager", 0)
        })).booleanValue();
    }

    public void f(boolean flag)
    {
        com.exacttarget.etpushsdk.util.d.a(com.exacttarget.etpushsdk.ETPush.a(), "et_geofence_invalidated_key", Boolean.valueOf(flag));
    }

    protected boolean f()
    {
        return ((Boolean)com.exacttarget.etpushsdk.util.d.a(i, "et_proximity_invalidated_key", Boolean.valueOf(true), new Object[] {
            i.getSharedPreferences("~!ETLocationManager", 0)
        })).booleanValue();
    }

    public void g(boolean flag)
    {
        com.exacttarget.etpushsdk.util.d.a(com.exacttarget.etpushsdk.ETPush.a(), "et_proximity_enabled_key", Boolean.valueOf(flag));
    }

    public boolean g()
    {
        LocationManager locationmanager = (LocationManager)i.getSystemService("location");
        return locationmanager.isProviderEnabled("gps") || locationmanager.isProviderEnabled("network");
    }

    public void h(boolean flag)
    {
        com.exacttarget.etpushsdk.util.d.a(com.exacttarget.etpushsdk.ETPush.a(), "et_proximity_invalidated_key", Boolean.valueOf(flag));
    }

    public boolean isWatchingLocation()
    {
        try
        {
            com.exacttarget.etpushsdk.ETPush.c();
            if (e == null)
            {
                e = Boolean.valueOf(c());
            }
        }
        catch (Exception exception)
        {
            com.exacttarget.etpushsdk.util.m.c("~!ETLocationManager", exception.getMessage(), exception);
            e = Boolean.valueOf(true);
        }
        return e.booleanValue();
    }

    public boolean isWatchingProximity()
    {
        try
        {
            com.exacttarget.etpushsdk.ETPush.c();
            if (f == null)
            {
                f = Boolean.valueOf(e());
            }
        }
        catch (Exception exception)
        {
            com.exacttarget.etpushsdk.util.m.c("~!ETLocationManager", exception.getMessage(), exception);
            f = Boolean.valueOf(true);
        }
        return f.booleanValue();
    }

    public void onEvent(BackgroundEvent backgroundevent)
    {
        com.exacttarget.etpushsdk.ETPush.c();
        if (!com.exacttarget.etpushsdk.util.d.h())
        {
            break MISSING_BLOCK_LABEL_195;
        }
        if (!backgroundevent.isInBackground())
        {
            com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "In FOREGROUND...");
            if (e.booleanValue())
            {
                com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "... and watching location, so get updated location");
                f(true);
                a(false);
            }
            if (f.booleanValue())
            {
                com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "... and watching proximity, so change proximity checking");
                if (o.isBound(p))
                {
                    com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "BeaconManager: In FOREGROUND");
                    o.setBackgroundMode(p, false);
                }
                h(true);
                b(false);
                return;
            }
            break MISSING_BLOCK_LABEL_195;
        }
        try
        {
            com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "In BACKGROUND...");
            if (f.booleanValue())
            {
                com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "... and watching proximity, so change proximity checking");
                if (o.isBound(p))
                {
                    com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "BeaconManager: In BACKGROUND");
                    o.setBackgroundMode(p, true);
                    return;
                }
            }
        }
        // Misplaced declaration of an exception variable
        catch (BackgroundEvent backgroundevent)
        {
            com.exacttarget.etpushsdk.util.m.c("~!ETLocationManager", backgroundevent.getMessage(), backgroundevent);
        }
    }

    public void onEvent(BeaconResponseEvent beaconresponseevent)
    {
        com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "onEvent(BeaconResponseEvent)");
        com.exacttarget.etpushsdk.ETPush.c();
        if (!o.checkAvailability())
        {
            break MISSING_BLOCK_LABEL_1104;
        }
        if (!o.isBound(p))
        {
            o.bind(p);
            com.exacttarget.etpushsdk.util.m.c("~!ETLocationManager", "for some weird reason, iBeaconMonitor wasn't bound.");
            return;
        }
        Object obj;
        try
        {
            Object obj1 = com.exacttarget.etpushsdk.database.f.a(null, null, null, null, null);
            obj = new ArrayList();
            obj1 = ((List) (obj1)).iterator();
            do
            {
                if (!((Iterator) (obj1)).hasNext())
                {
                    break;
                }
                RegionMessage regionmessage = (RegionMessage)((Iterator) (obj1)).next();
                if (com.exacttarget.etpushsdk.database.g.a(regionmessage.getRegion().getId()).getLocationType().intValue() == 3)
                {
                    ((List) (obj)).add(regionmessage.getId());
                }
            } while (true);
        }
        // Misplaced declaration of an exception variable
        catch (BeaconResponseEvent beaconresponseevent)
        {
            com.exacttarget.etpushsdk.util.m.c("~!ETLocationManager", beaconresponseevent.getMessage(), beaconresponseevent);
            return;
        }
        if (!((List) (obj)).isEmpty())
        {
            com.exacttarget.etpushsdk.database.f.a(((List) (obj)));
        }
        if (beaconresponseevent.getBeacons() == null || beaconresponseevent.getBeacons().isEmpty())
        {
            break MISSING_BLOCK_LABEL_1090;
        }
        obj = beaconresponseevent.getBeacons().iterator();
_L9:
        Object obj2;
        Iterator iterator;
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_405;
        }
        obj2 = (Region)((Iterator) (obj)).next();
        iterator = ((Region) (obj2)).getMessages().iterator();
_L1:
        Message message;
        Message message1;
        if (!iterator.hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
        message = (Message)iterator.next();
        message1 = com.exacttarget.etpushsdk.database.e.a(message.getId());
        if (message1 == null)
        {
            break MISSING_BLOCK_LABEL_326;
        }
        message.setLastShownDate(message1.getLastShownDate());
        message.setNextAllowedShow(message1.getNextAllowedShow());
        message.setShowCount(message1.getShowCount());
        message.setHasEntered(message1.getHasEntered());
        if (!message1.getPeriodType().equals(message.getPeriodType()))
        {
            break MISSING_BLOCK_LABEL_393;
        }
        message.setPeriodShowCount(message1.getPeriodShowCount());
_L2:
        if (message.getMessagesPerPeriod().intValue() <= 0 && message.getNumberOfPeriods().intValue() > 0 && !message.getPeriodType().equals(Integer.valueOf(0)))
        {
            message.setMessagesPerPeriod(Integer.valueOf(1));
        }
        com.exacttarget.etpushsdk.database.e.b(message);
        com.exacttarget.etpushsdk.database.f.a(new RegionMessage(((Region) (obj2)), message));
          goto _L1
        continue; /* Loop/switch isn't completed */
        message.setPeriodShowCount(Integer.valueOf(0));
          goto _L2
        obj = com.exacttarget.etpushsdk.database.g.a("location_type = ? AND active = ?", new String[] {
            String.valueOf(3), "1"
        }, null, null, null).iterator();
_L3:
        boolean flag;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_624;
            }
            obj2 = (Region)((Iterator) (obj)).next();
            flag = beaconresponseevent.getBeacons().contains(obj2);
        } while (flag);
        ((Region) (obj2)).setActive(Boolean.FALSE);
        ((Region) (obj2)).setHasEntered(Boolean.FALSE);
        com.exacttarget.etpushsdk.database.g.c(((Region) (obj2)));
        obj2 = new com.radiusnetworks.ibeacon.Region(((Region) (obj2)).getId(), ((Region) (obj2)).getGuid(), ((Region) (obj2)).getMajor(), ((Region) (obj2)).getMinor());
        o.stopMonitoringBeaconsInRegion(((com.radiusnetworks.ibeacon.Region) (obj2)));
        o.stopRangingBeaconsInRegion(((com.radiusnetworks.ibeacon.Region) (obj2)));
        com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", (new StringBuilder()).append("stopRangingBeacon - {id: '").append(((com.radiusnetworks.ibeacon.Region) (obj2)).getUniqueId()).append("', uuid: '").append(((com.radiusnetworks.ibeacon.Region) (obj2)).getProximityUuid()).append("', major: ").append(((com.radiusnetworks.ibeacon.Region) (obj2)).getMajor()).append(", minor: ").append(((com.radiusnetworks.ibeacon.Region) (obj2)).getMinor()).append("}").toString());
          goto _L3
        RemoteException remoteexception;
        remoteexception;
        com.exacttarget.etpushsdk.util.m.c("~!ETLocationManager", remoteexception.getMessage(), remoteexception);
          goto _L3
        remoteexception = beaconresponseevent.getBeacons().iterator();
_L6:
        if (!remoteexception.hasNext())
        {
            break MISSING_BLOCK_LABEL_1099;
        }
        beaconresponseevent = (Region)remoteexception.next();
        obj = com.exacttarget.etpushsdk.database.g.a(beaconresponseevent.getId());
        if (obj != null) goto _L5; else goto _L4
_L4:
        beaconresponseevent.setActive(Boolean.TRUE);
        com.exacttarget.etpushsdk.database.g.a(beaconresponseevent);
_L7:
        obj = new com.radiusnetworks.ibeacon.Region(beaconresponseevent.getId(), beaconresponseevent.getGuid(), beaconresponseevent.getMajor(), beaconresponseevent.getMinor());
        if (o.getRangedRegions().contains(obj))
        {
            break MISSING_BLOCK_LABEL_1013;
        }
        com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", (new StringBuilder()).append("startRangingBeacon - {id: '").append(((com.radiusnetworks.ibeacon.Region) (obj)).getUniqueId()).append("', uuid: '").append(((com.radiusnetworks.ibeacon.Region) (obj)).getProximityUuid()).append("', major: ").append(((com.radiusnetworks.ibeacon.Region) (obj)).getMajor()).append(", minor: ").append(((com.radiusnetworks.ibeacon.Region) (obj)).getMinor()).append("}").toString());
        o.startMonitoringBeaconsInRegion(((com.radiusnetworks.ibeacon.Region) (obj)));
        o.startRangingBeaconsInRegion(((com.radiusnetworks.ibeacon.Region) (obj)));
          goto _L6
        obj;
        com.exacttarget.etpushsdk.util.m.c("~!ETLocationManager", ((RemoteException) (obj)).getMessage(), ((Throwable) (obj)));
        beaconresponseevent.setActive(Boolean.FALSE);
        com.exacttarget.etpushsdk.database.g.c(beaconresponseevent);
          goto _L6
_L5:
label0:
        {
            if (!Boolean.TRUE.equals(((Region) (obj)).getActive()))
            {
                break label0;
            }
            com.radiusnetworks.ibeacon.Region region = new com.radiusnetworks.ibeacon.Region(((Region) (obj)).getId(), ((Region) (obj)).getGuid(), ((Region) (obj)).getMajor(), ((Region) (obj)).getMinor());
            if (!o.getRangedRegions().contains(region))
            {
                break label0;
            }
            com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", (new StringBuilder()).append("alreadyRangingBeacon - {id: '").append(region.getUniqueId()).append("', uuid: '").append(region.getProximityUuid()).append("', major: ").append(region.getMajor()).append(", minor: ").append(region.getMinor()).append("}").toString());
        }
          goto _L6
        ((Region) (obj)).setActive(Boolean.TRUE);
        ((Region) (obj)).setGuid(beaconresponseevent.getGuid());
        ((Region) (obj)).setMajor(beaconresponseevent.getMajor());
        ((Region) (obj)).setMinor(beaconresponseevent.getMinor());
        com.exacttarget.etpushsdk.database.g.c(((Region) (obj)));
        beaconresponseevent = ((BeaconResponseEvent) (obj));
          goto _L7
        com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", (new StringBuilder()).append("alreadyMonitoringBeacon2 - {id: '").append(((com.radiusnetworks.ibeacon.Region) (obj)).getUniqueId()).append("', uuid: '").append(((com.radiusnetworks.ibeacon.Region) (obj)).getProximityUuid()).append("', major: ").append(((com.radiusnetworks.ibeacon.Region) (obj)).getMajor()).append(", minor: ").append(((com.radiusnetworks.ibeacon.Region) (obj)).getMinor()).append("}").toString());
          goto _L6
        com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "Empty beacon list from server.");
        h(false);
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public void onEvent(GeofenceResponseEvent geofenceresponseevent)
    {
        com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "onEventGeofenceResponse()");
        try
        {
            com.exacttarget.etpushsdk.ETPush.c();
            if (!e.booleanValue())
            {
                com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "No longer watching locations.  Skipping the geoFenceResponseEvent update.");
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (GeofenceResponseEvent geofenceresponseevent)
        {
            com.exacttarget.etpushsdk.util.m.c("~!ETLocationManager", geofenceresponseevent.getMessage(), geofenceresponseevent);
            return;
        }
        if (geofenceresponseevent.getRefreshCenter() == null)
        {
            com.exacttarget.etpushsdk.util.m.c("~!ETLocationManager", "Got a bad response from retrieving geofences. Try to get them the next time we get a location.");
            f(true);
            return;
        }
        Object obj;
        Object obj1 = com.exacttarget.etpushsdk.database.f.a(null, null, null, null, null);
        obj = new ArrayList();
        obj1 = ((List) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            RegionMessage regionmessage = (RegionMessage)((Iterator) (obj1)).next();
            if (com.exacttarget.etpushsdk.database.g.a(regionmessage.getRegion().getId()).getLocationType().intValue() == 1)
            {
                ((List) (obj)).add(regionmessage.getId());
            }
        } while (true);
        Object obj2;
        if (!((List) (obj)).isEmpty())
        {
            com.exacttarget.etpushsdk.database.f.a(((List) (obj)));
        }
        obj = com.exacttarget.etpushsdk.database.g.a("location_type = ? AND active = ?", new String[] {
            String.valueOf(1), "1"
        }, null, null, null);
        n.a(((List) (obj)));
        obj = new ContentValues();
        ((ContentValues) (obj)).put("active", Integer.valueOf(0));
        com.exacttarget.etpushsdk.database.g.a("location_type = ?", new String[] {
            String.valueOf(1)
        }, ((ContentValues) (obj)));
        obj2 = com.exacttarget.etpushsdk.database.g.a("~~m@g1c_f3nc3~~");
        obj = obj2;
        if (obj2 != null)
        {
            break MISSING_BLOCK_LABEL_261;
        }
        obj = new Region();
        ((Region) (obj)).setId("~~m@g1c_f3nc3~~");
        ((Region) (obj)).setActive(Boolean.TRUE);
        ((Region) (obj)).setCenter(geofenceresponseevent.getRefreshCenter());
        ((Region) (obj)).setRadius(geofenceresponseevent.getRefreshRadius());
        com.exacttarget.etpushsdk.database.g.b(((Region) (obj)));
        geofenceresponseevent = geofenceresponseevent.getFences().iterator();
_L6:
        if (!geofenceresponseevent.hasNext()) goto _L2; else goto _L1
_L1:
        obj = (Region)geofenceresponseevent.next();
        ((Region) (obj)).setActive(Boolean.TRUE);
        obj2 = com.exacttarget.etpushsdk.database.g.a(((Region) (obj)).getId());
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_352;
        }
        ((Region) (obj)).setEntryCount(((Region) (obj2)).getEntryCount());
        ((Region) (obj)).setExitCount(((Region) (obj2)).getExitCount());
        com.exacttarget.etpushsdk.database.g.b(((Region) (obj)));
        obj2 = ((Region) (obj)).getMessages().iterator();
_L3:
        Message message;
        Message message1;
        if (!((Iterator) (obj2)).hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
        message = (Message)((Iterator) (obj2)).next();
        message1 = com.exacttarget.etpushsdk.database.e.a(message.getId());
        if (message1 == null)
        {
            break MISSING_BLOCK_LABEL_457;
        }
        message.setLastShownDate(message1.getLastShownDate());
        message.setNextAllowedShow(message1.getNextAllowedShow());
        message.setShowCount(message1.getShowCount());
        if (!message1.getPeriodType().equals(message.getPeriodType()))
        {
            break MISSING_BLOCK_LABEL_524;
        }
        message.setPeriodShowCount(message1.getPeriodShowCount());
_L4:
        if (message.getMessagesPerPeriod().intValue() <= 0 && message.getNumberOfPeriods().intValue() > 0 && !message.getPeriodType().equals(Integer.valueOf(0)))
        {
            message.setMessagesPerPeriod(Integer.valueOf(1));
        }
        com.exacttarget.etpushsdk.database.e.b(message);
        com.exacttarget.etpushsdk.database.f.a(new RegionMessage(((Region) (obj)), message));
          goto _L3
        message.setPeriodShowCount(Integer.valueOf(0));
          goto _L4
_L2:
        f(false);
        com.exacttarget.etpushsdk.c.a(n);
        return;
          goto _L3
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onEvent(LastKnownLocationEvent lastknownlocationevent)
    {
        com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "onEventLocationChanged()");
        com.exacttarget.etpushsdk.ETPush.c();
        if (System.currentTimeMillis() - lastknownlocationevent.getLocation().getTime() < 0xdbba0L)
        {
            if (k != null)
            {
                j.cancel(k);
            }
            com.exacttarget.etpushsdk.util.d.a(com.exacttarget.etpushsdk.ETPush.a(), "et_last_location_latitude", String.valueOf(lastknownlocationevent.getLocation().getLatitude()));
            com.exacttarget.etpushsdk.util.d.a(com.exacttarget.etpushsdk.ETPush.a(), "et_last_location_longitude", String.valueOf(lastknownlocationevent.getLocation().getLongitude()));
            com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", (new StringBuilder()).append("Provider: ").append(lastknownlocationevent.getLocation().getProvider()).append(", Lat: ").append(lastknownlocationevent.getLocation().getLatitude()).append(", Lon: ").append(lastknownlocationevent.getLocation().getLongitude()).append(", Accuracy: ").append(lastknownlocationevent.getLocation().getAccuracy()).append(", Timestamp: ").append(new Date(lastknownlocationevent.getLocation().getTime())).toString());
            (new Thread(new com.exacttarget.etpushsdk.d(this, lastknownlocationevent))).start();
            return;
        }
        try
        {
            com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", "stale location, older than 15 minutes.");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (LastKnownLocationEvent lastknownlocationevent)
        {
            com.exacttarget.etpushsdk.util.m.c("~!ETLocationManager", lastknownlocationevent.getMessage(), lastknownlocationevent);
        }
        return;
    }

    public void onEvent(LocationUpdateEvent locationupdateevent)
    {
        int i1;
        com.exacttarget.etpushsdk.ETPush.c();
        i1 = com.exacttarget.etpushsdk.database.d.a(locationupdateevent.getId().intValue());
        if (i1 == 1)
        {
            try
            {
                com.exacttarget.etpushsdk.util.m.a("~!ETLocationManager", (new StringBuilder()).append("removed locationupdate id: ").append(locationupdateevent.getId()).toString());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (LocationUpdateEvent locationupdateevent)
            {
                com.exacttarget.etpushsdk.util.m.c("~!ETLocationManager", locationupdateevent.getMessage(), locationupdateevent);
            }
            break MISSING_BLOCK_LABEL_88;
        }
        com.exacttarget.etpushsdk.util.m.d("~!ETLocationManager", (new StringBuilder()).append("Error: rowsUpdated = ").append(i1).toString());
        return;
    }

    public void startWatchingLocation()
    {
        this;
        JVM INSTR monitorenter ;
        a(true);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean startWatchingProximity()
    {
        return b(true);
    }

    public void stopWatchingLocation()
    {
        this;
        JVM INSTR monitorenter ;
        c(false);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void stopWatchingProximity()
    {
        d(true);
    }


    private class c
        implements qo, qp
    {

        final ETLocationManager a;
        private Boolean b;
        private List c;
        private List d;
        private PendingIntent e;

        static Boolean a(c c1, Boolean boolean1)
        {
            c1.b = boolean1;
            return boolean1;
        }

        static String a(c c1, Status status)
        {
            return c1.a(status);
        }

        private String a(Status status)
        {
            if (status == null)
            {
                return "NULL";
            }
            switch (status.f())
            {
            default:
                return "UNKNOWN_ERROR";

            case 1000: 
                return "GEOFENCE_NOT_AVAILABLE";

            case 1001: 
                return "GEOFENCE_TOO_MANY_GEOFENCES";

            case 1002: 
                return "GEOFENCE_TOO_MANY_PENDING_INTENTS";

            case 1: // '\001'
                return "UNSPECIFIED_ERROR";

            case 0: // '\0'
                return "SUCCESS";
            }
        }

        private qu a(a a1, PendingIntent pendingintent)
        {
            return new n(this, a1);
        }

        private qu a(a a1, List list)
        {
            return new com.exacttarget.etpushsdk.m(this, a1, list);
        }

        static void a(c c1)
        {
            c1.c();
        }

        private PendingIntent b()
        {
            com.exacttarget.etpushsdk.util.m.a("~!RegionMonitor", "getGeofencePendingIntent()");
            if (e == null)
            {
                com.exacttarget.etpushsdk.util.m.a("~!RegionMonitor", "Create New GeofencePendingIntent");
                Intent intent = new Intent(com.exacttarget.etpushsdk.ETLocationManager.e(a), com/exacttarget/etpushsdk/ETLocationReceiver);
                intent.setAction("et_location_action_geofence_cross");
                e = PendingIntent.getBroadcast(com.exacttarget.etpushsdk.ETLocationManager.e(a), 1002, intent, 0x8000000);
            } else
            {
                com.exacttarget.etpushsdk.util.m.a("~!RegionMonitor", "Reuse Existing GeofencePendingIntent");
            }
            return e;
        }

        private void c()
        {
            com.exacttarget.etpushsdk.util.m.a("~!RegionMonitor", "updateGeofencesFromDatabase()");
            if (c == null)
            {
                com.exacttarget.etpushsdk.util.m.a("~!RegionMonitor", "No Monitored Regions Yet");
                return;
            }
            ArrayList arraylist;
            Object obj1;
            Object obj2;
            obj1 = com.exacttarget.etpushsdk.database.g.a("location_type = ? AND active = ?", new String[] {
                String.valueOf(1), "1"
            }, null, null, null);
            arraylist = new ArrayList();
            com.exacttarget.etpushsdk.util.m.a("~!RegionMonitor", "Removing Regions ...");
            obj2 = c.iterator();
_L7:
            Object obj3;
            if (!((Iterator) (obj2)).hasNext())
            {
                break MISSING_BLOCK_LABEL_286;
            }
            obj3 = (Region)((Iterator) (obj2)).next();
            if (((List) (obj1)).contains(obj3) && !"~~m@g1c_f3nc3~~".equals(((Region) (obj3)).getId())) goto _L2; else goto _L1
_L1:
            arraylist.add(((Region) (obj3)).getId());
            if (TextUtils.isEmpty(((Region) (obj3)).getName())) goto _L4; else goto _L3
_L3:
            Object obj = ((Region) (obj3)).getName();
_L8:
            if (!((String) (obj)).equals("~~m@g1c_f3nc3~~")) goto _L6; else goto _L5
_L5:
            com.exacttarget.etpushsdk.util.m.a("~!RegionMonitor", String.format("Removing Region: %1$s @ (%2$s, %3$s)", new Object[] {
                obj, ((Region) (obj3)).getLatitude(), ((Region) (obj3)).getLongitude()
            }));
              goto _L7
_L4:
            try
            {
                obj = ((Region) (obj3)).getId();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.exacttarget.etpushsdk.util.m.c("~!RegionMonitor", ((Exception) (obj)).getMessage(), ((Throwable) (obj)));
                return;
            }
              goto _L8
_L6:
            com.exacttarget.etpushsdk.util.m.a("~!RegionMonitor", String.format("Removing Region: %1$s", new Object[] {
                obj
            }));
              goto _L7
_L2:
            Message message;
            if (((Region) (obj3)).getActive().booleanValue())
            {
                obj = "ACTIVE";
            } else
            {
                obj = "INACTIVE";
            }
            com.exacttarget.etpushsdk.util.m.a("~!RegionMonitor", String.format("Ignoring %1$s Region: %2$s", new Object[] {
                obj, ((Region) (obj3)).getName()
            }));
              goto _L7
            if (arraylist.size() > 0)
            {
                com.exacttarget.etpushsdk.util.m.a("~!RegionMonitor", String.format("Removing %1$d Region(s)", new Object[] {
                    Integer.valueOf(arraylist.size())
                }));
                ahy.c.a(com.exacttarget.etpushsdk.ETLocationManager.c(a), arraylist).a(a(com.exacttarget.etpushsdk.a.c, arraylist));
            }
            arraylist = new ArrayList();
            com.exacttarget.etpushsdk.util.m.a("~!RegionMonitor", "Adding Regions ...");
            obj1 = ((List) (obj1)).iterator();
_L13:
            if (!((Iterator) (obj1)).hasNext())
            {
                break MISSING_BLOCK_LABEL_555;
            }
            obj2 = (Region)((Iterator) (obj1)).next();
            if (c.contains(obj2) && !"~~m@g1c_f3nc3~~".equals(((Region) (obj2)).getId()))
            {
                break MISSING_BLOCK_LABEL_528;
            }
            arraylist.add(obj2);
            if (TextUtils.isEmpty(((Region) (obj2)).getName())) goto _L10; else goto _L9
_L9:
            obj = ((Region) (obj2)).getName();
_L14:
            if (!((String) (obj)).equals("~~m@g1c_f3nc3~~")) goto _L12; else goto _L11
_L11:
            com.exacttarget.etpushsdk.util.m.a("~!RegionMonitor", String.format("Adding Region: %1$s @ (%2$s, %3$s)", new Object[] {
                obj, ((Region) (obj2)).getLatitude(), ((Region) (obj2)).getLongitude()
            }));
              goto _L13
_L10:
            obj = ((Region) (obj2)).getId();
              goto _L14
_L12:
            com.exacttarget.etpushsdk.util.m.a("~!RegionMonitor", String.format("Adding Region: %1$s", new Object[] {
                obj
            }));
              goto _L13
            com.exacttarget.etpushsdk.util.m.a("~!RegionMonitor", String.format("Already Monitoring Region: %1$s", new Object[] {
                ((Region) (obj2)).getName()
            }));
              goto _L13
            d = new ArrayList();
            obj = arraylist.iterator();
_L16:
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_744;
            }
            obj1 = (Region)((Iterator) (obj)).next();
            obj2 = new ArrayList();
            obj3 = com.exacttarget.etpushsdk.database.f.a("region_id = ?", new String[] {
                ((Region) (obj1)).getId()
            }, null, null, null).iterator();
_L15:
            do
            {
                if (!((Iterator) (obj3)).hasNext())
                {
                    break MISSING_BLOCK_LABEL_677;
                }
                message = com.exacttarget.etpushsdk.database.e.a(((RegionMessage)((Iterator) (obj3)).next()).getMessage().getId());
            } while (message == null);
            ((List) (obj2)).add(message);
              goto _L15
            ((Region) (obj1)).setMessages(((List) (obj2)));
            com.exacttarget.etpushsdk.util.m.a("~!RegionMonitor", String.format("Creating Geofence from Region: %1$s at (%2$s, %3$s) w/Radius of %4$dm", new Object[] {
                ((Region) (obj1)).getId(), ((Region) (obj1)).getLatitude(), ((Region) (obj1)).getLongitude(), ((Region) (obj1)).getRadius()
            }));
            d.add(((Region) (obj1)).a());
              goto _L16
            if (d.size() > 0)
            {
                com.exacttarget.etpushsdk.util.m.a("~!RegionMonitor", String.format("Adding %1$d Region(s)", new Object[] {
                    Integer.valueOf(arraylist.size())
                }));
                ahy.c.a(com.exacttarget.etpushsdk.ETLocationManager.c(a), d, b()).a(a(com.exacttarget.etpushsdk.a.a, d));
                return;
            }
            com.exacttarget.etpushsdk.util.m.a("~!RegionMonitor", "No New Fences to Monitor");
            return;
        }

        public void a()
        {
            com.exacttarget.etpushsdk.util.m.a("~!RegionMonitor", "Removing All Geofences");
            ahy.c.a(com.exacttarget.etpushsdk.ETLocationManager.c(a), b()).a(a(com.exacttarget.etpushsdk.a.b, b()));
        }

        public void a(Boolean boolean1)
        {
            b = boolean1;
        }

        public void a(List list)
        {
            c = list;
        }

        public void onConnected(Bundle bundle)
        {
            com.exacttarget.etpushsdk.util.m.a("~!RegionMonitor", "GoogleApiClient onConnected()");
            if (!com.exacttarget.etpushsdk.util.d.h())
            {
                com.exacttarget.etpushsdk.util.m.a("~!RegionMonitor", "Not Watching Location, Return");
                return;
            }
            if (b.booleanValue())
            {
                a();
                return;
            } else
            {
                c();
                return;
            }
        }

        public void onConnectionFailed(pp pp1)
        {
            com.exacttarget.etpushsdk.util.m.a("~!RegionMonitor", "onConnectionFailed()");
            com.exacttarget.etpushsdk.util.m.d("~!RegionMonitor", (new StringBuilder()).append("PlayServices connection failed: ").append(pp1.c()).toString());
        }

        public void onConnectionSuspended(int i1)
        {
            com.exacttarget.etpushsdk.util.m.a("~!RegionMonitor", String.format("onConnectionSuspended(%1$d)", new Object[] {
                Integer.valueOf(i1)
            }));
        }

        private c()
        {
            a = ETLocationManager.this;
            super();
            b = Boolean.FALSE;
            c = null;
            d = null;
        }

        c(com.exacttarget.etpushsdk.c c1)
        {
            this();
        }

        private class a extends Enum
        {

            public static final a a;
            public static final a b;
            public static final a c;
            private static final a d[];

            public static a valueOf(String s)
            {
                return (a)Enum.valueOf(com/exacttarget/etpushsdk/ETLocationManager$a, s);
            }

            public static a[] values()
            {
                return (a[])d.clone();
            }

            static 
            {
                a = new a("ADD_FENCES", 0);
                b = new a("REMOVE_ALL", 1);
                c = new a("REMOVE_FENCES", 2);
                d = (new a[] {
                    a, b, c
                });
            }

            private a(String s, int i1)
            {
                super(s, i1);
            }
        }

    }


    private class b
        implements IBeaconConsumer, MonitorNotifier, RangeNotifier
    {

        final ETLocationManager a;

        public boolean bindService(Intent intent, ServiceConnection serviceconnection, int i1)
        {
            com.exacttarget.etpushsdk.util.m.a("~!IBeaconMonitor", "bindService");
            return getApplicationContext().bindService(intent, serviceconnection, i1);
        }

        public void didDetermineStateForRegion(int i1, com.radiusnetworks.ibeacon.Region region)
        {
            com.exacttarget.etpushsdk.util.m.a("~!IBeaconMonitor", (new StringBuilder()).append("BeaconState - {state: ").append(i1).append(", id: '").append(region.getUniqueId()).append("', uuid: '").append(region.getProximityUuid()).append("', major: ").append(region.getMajor()).append(", minor: ").append(region.getMinor()).append("}").toString());
        }

        public void didEnterRegion(com.radiusnetworks.ibeacon.Region region)
        {
            com.exacttarget.etpushsdk.util.m.a("~!IBeaconMonitor", (new StringBuilder()).append("didEnterRegion - {id: '").append(region.getUniqueId()).append("', uuid: '").append(region.getProximityUuid()).append("', major: ").append(region.getMajor()).append(", minor: ").append(region.getMinor()).append("}").toString());
            try
            {
                region = com.exacttarget.etpushsdk.database.g.a(region.getUniqueId());
                region.setEntryCount(Integer.valueOf(region.getEntryCount().intValue() + 1));
                region.setHasEntered(Boolean.TRUE);
                com.exacttarget.etpushsdk.database.g.c(region);
                com.exacttarget.etpushsdk.util.m.a("~!IBeaconMonitor", (new StringBuilder()).append("Beacon: ").append(region.getId()).append(", EntryCount: ").append(region.getEntryCount()).toString());
                if (com.exacttarget.etpushsdk.util.d.f())
                {
                    com.exacttarget.etpushsdk.ETAnalytics.a().a(region.getId(), true);
                }
                EventBus.getInstance().a(new BeaconRegionEnterEvent(region));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (com.radiusnetworks.ibeacon.Region region)
            {
                com.exacttarget.etpushsdk.util.m.c("~!IBeaconMonitor", region.getMessage(), region);
            }
        }

        public void didExitRegion(com.radiusnetworks.ibeacon.Region region)
        {
            com.exacttarget.etpushsdk.util.m.a("~!IBeaconMonitor", (new StringBuilder()).append("didExitRegion - {id: '").append(region.getUniqueId()).append("', uuid: '").append(region.getProximityUuid()).append("', major: ").append(region.getMajor()).append(", minor: ").append(region.getMinor()).append("}").toString());
            try
            {
                region = com.exacttarget.etpushsdk.database.g.a(region.getUniqueId());
                region.setExitCount(Integer.valueOf(region.getExitCount().intValue() + 1));
                region.setHasEntered(Boolean.FALSE);
                com.exacttarget.etpushsdk.database.g.c(region);
                com.exacttarget.etpushsdk.util.m.a("~!IBeaconMonitor", (new StringBuilder()).append("Beacon: ").append(region.getId()).append(", ExitCount: ").append(region.getEntryCount()).toString());
                Message message;
                for (Iterator iterator = com.exacttarget.etpushsdk.database.f.a("region_id = ?", new String[] {
        region.getId()
    }, null, null, null).iterator(); iterator.hasNext(); com.exacttarget.etpushsdk.database.e.c(message))
                {
                    message = com.exacttarget.etpushsdk.database.e.a(((RegionMessage)iterator.next()).getMessage().getId());
                    message.setHasEntered(Boolean.FALSE);
                    message.setEntryTime(Long.valueOf(0L));
                    if (message.getEphemeralMessage().booleanValue() && message.getNotifyId() != null)
                    {
                        ((NotificationManager)com.exacttarget.etpushsdk.ETLocationManager.e(a).getSystemService("notification")).cancel(message.getNotifyId().intValue());
                        message.setNotifyId(null);
                    }
                }

            }
            // Misplaced declaration of an exception variable
            catch (com.radiusnetworks.ibeacon.Region region)
            {
                com.exacttarget.etpushsdk.util.m.c("~!IBeaconMonitor", region.getMessage(), region);
                return;
            }
            if (com.exacttarget.etpushsdk.util.d.f())
            {
                com.exacttarget.etpushsdk.ETAnalytics.a().a(region.getId());
            }
            EventBus.getInstance().a(new BeaconRegionExitEvent(region));
            return;
        }

        public void didRangeBeaconsInRegion(Collection collection, com.radiusnetworks.ibeacon.Region region)
        {
            collection = collection.iterator();
_L4:
            if (!collection.hasNext()) goto _L2; else goto _L1
_L1:
            IBeacon ibeacon;
            Region region1;
            ibeacon = (IBeacon)collection.next();
            com.exacttarget.etpushsdk.util.m.a("~!IBeaconMonitor", (new StringBuilder()).append("didRangeBeaconsInRegion - {proximity: ").append(ibeacon.getProximity()).append(", id: '").append(region.getUniqueId()).append("', uuid: '").append(region.getProximityUuid()).append("', major: ").append(region.getMajor()).append(", minor: ").append(region.getMinor()).append("}").toString());
            region1 = com.exacttarget.etpushsdk.database.g.a(region.getUniqueId());
            if (region1 == null) goto _L4; else goto _L3
_L3:
            if (!region1.getHasEntered().booleanValue())
            {
                break MISSING_BLOCK_LABEL_191;
            }
            ETPush.getInstance().a(region.getUniqueId(), -1, ibeacon.getProximity());
            EventBus.getInstance().a(new BeaconRegionRangeEvent(region1, ibeacon.getProximity(), ibeacon.getRssi(), ibeacon.getAccuracy()));
              goto _L4
            collection;
            com.exacttarget.etpushsdk.util.m.c("~!IBeaconMonitor", collection.getMessage(), collection);
_L2:
            return;
            com.exacttarget.etpushsdk.util.m.a("~!IBeaconMonitor", (new StringBuilder()).append("Ranged region ").append(region1.getId()).append(" but monitoring hasn't yet entered").toString());
              goto _L4
        }

        public Context getApplicationContext()
        {
            return com.exacttarget.etpushsdk.ETLocationManager.e(a);
        }

        public void onIBeaconServiceConnect()
        {
            com.exacttarget.etpushsdk.util.m.a("~!IBeaconMonitor", "onIBeaconServiceConnect");
            com.exacttarget.etpushsdk.ETLocationManager.b(a).setMonitorNotifier(this);
            com.exacttarget.etpushsdk.ETLocationManager.b(a).setRangeNotifier(this);
            if (ETLocationManager.k().booleanValue() && a.f())
            {
                a.b(false);
            }
            BackgroundEvent backgroundevent = (BackgroundEvent)EventBus.getInstance().a(com/exacttarget/etpushsdk/event/BackgroundEvent);
            if (backgroundevent == null || backgroundevent.isInBackground())
            {
                com.exacttarget.etpushsdk.ETLocationManager.b(a).setBackgroundMode(com.exacttarget.etpushsdk.ETLocationManager.a(a), true);
            }
        }

        public void unbindService(ServiceConnection serviceconnection)
        {
            com.exacttarget.etpushsdk.util.m.a("~!IBeaconMonitor", "unbindService");
            getApplicationContext().unbindService(serviceconnection);
        }

        private b()
        {
            a = ETLocationManager.this;
            super();
        }

        b(com.exacttarget.etpushsdk.c c1)
        {
            this();
        }
    }

}
