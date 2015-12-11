// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.littlefluffytoys.littlefluffylocationlibrary;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.preference.PreferenceManager;
import android.util.Log;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.littlefluffytoys.littlefluffylocationlibrary:
//            LocationLibrary, LocationInfo, LocationLibraryConstants, PassiveLocationChangedReceiver

public class LocationBroadcastService extends Service
{

    private final IBinder mBinder = new Binder() {

        final LocationBroadcastService this$0;

        protected boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
            throws RemoteException
        {
            return super.onTransact(i, parcel, parcel1, j);
        }

            
            {
                this$0 = LocationBroadcastService.this;
                super();
            }
    };
    Runnable mTask;
    final LocationListener preGingerbreadUpdatesListener = new LocationListener() {

        final LocationBroadcastService this$0;

        public void onLocationChanged(Location location)
        {
            if (LocationLibrary.showDebugOutput)
            {
                Log.d("LittleFluffyLocationLibrary", (new StringBuilder()).append("LocationBroadcastService: Single Location Update Received: ").append(location.getLatitude()).append(",").append(location.getLongitude()).toString());
            }
            ((LocationManager)getApplicationContext().getSystemService("location")).removeUpdates(preGingerbreadUpdatesListener);
            if (!LocationLibraryConstants.SUPPORTS_FROYO)
            {
                PassiveLocationChangedReceiver.processLocation(LocationBroadcastService.this, location);
            }
            LocationBroadcastService.forceDelayedServiceCall(getApplicationContext(), 1);
            stopSelf();
        }

        public void onProviderDisabled(String s)
        {
        }

        public void onProviderEnabled(String s)
        {
        }

        public void onStatusChanged(String s, int i, Bundle bundle)
        {
        }

            
            {
                this$0 = LocationBroadcastService.this;
                super();
            }
    };

    public LocationBroadcastService()
    {
        mTask = new Runnable() {

            final LocationBroadcastService this$0;

            public void run()
            {
                boolean flag = true;
                Object obj = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                long l = ((SharedPreferences) (obj)).getLong("LFT_SP_KEY_LAST_LOCATION_UPDATE_TIME", 0L);
                long l1 = ((SharedPreferences) (obj)).getLong("LFT_SP_KEY_LAST_LOCATION_SUBMIT_TIME", 0L);
                boolean flag1 = ((SharedPreferences) (obj)).getBoolean("LFT_SP_KEY_FORCE_LOCATION_UPDATE", false);
                if (l1 == l)
                {
                    if (LocationLibrary.showDebugOutput)
                    {
                        Log.d("LittleFluffyLocationLibrary", (new StringBuilder()).append("LocationBroadcastService: No new location update found since ").append(LocationInfo.formatTimestampForDebug(l)).toString());
                    }
                    if (flag1 || System.currentTimeMillis() - l > (long)LocationLibrary.getLocationMaximumAge())
                    {
                        if (flag1)
                        {
                            ((SharedPreferences) (obj)).edit().putBoolean("LFT_SP_KEY_FORCE_LOCATION_UPDATE", false).commit();
                        }
                        if (!forceLocationUpdate())
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                    }
                } else
                {
                    if (LocationLibrary.showDebugOutput)
                    {
                        Log.d("LittleFluffyLocationLibrary", (new StringBuilder()).append("LocationBroadcastService: New location update found at ").append(LocationInfo.formatTimestampForDebug(l)).toString());
                    }
                    obj = ((SharedPreferences) (obj)).edit();
                    ((android.content.SharedPreferences.Editor) (obj)).putLong("LFT_SP_KEY_LAST_LOCATION_SUBMIT_TIME", l);
                    if (flag1)
                    {
                        ((android.content.SharedPreferences.Editor) (obj)).putBoolean("LFT_SP_KEY_FORCE_LOCATION_UPDATE", false);
                    }
                    ((android.content.SharedPreferences.Editor) (obj)).commit();
                    LocationBroadcastService.sendBroadcast(getBaseContext(), true);
                }
                if (flag)
                {
                    stopSelf();
                }
            }

            
            {
                this$0 = LocationBroadcastService.this;
                super();
            }
        };
    }

    public static void forceDelayedServiceCall(Context context, int i)
    {
        PendingIntent pendingintent = PendingIntent.getService(context, 1, new Intent(context, com/littlefluffytoys/littlefluffylocationlibrary/LocationBroadcastService), 0x40000000);
        ((AlarmManager)context.getSystemService("alarm")).set(0, System.currentTimeMillis() + (long)(i * 1000), pendingintent);
    }

    protected static void sendBroadcast(Context context, boolean flag)
    {
        Object obj = (new StringBuilder()).append(LocationLibrary.broadcastPrefix);
        String s;
        if (flag)
        {
            s = ".littlefluffylocationlibrary.LOCATION_CHANGED";
        } else
        {
            s = ".littlefluffylocationlibrary.LOCATION_CHANGED_TICK";
        }
        obj = new Intent(((StringBuilder) (obj)).append(s).toString());
        ((Intent) (obj)).putExtra("com.littlefluffytoys.littlefluffylocationlibrary.LocationInfo", new LocationInfo(context));
        if (LocationLibrary.showDebugOutput)
        {
            StringBuilder stringbuilder = (new StringBuilder()).append("LocationBroadcastService: Broadcasting ");
            if (flag)
            {
                s = "periodic";
            } else
            {
                s = "latest";
            }
            Log.d("LittleFluffyLocationLibrary", stringbuilder.append(s).append(" location update timed at ").append(LocationInfo.formatTimeAndDay(PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext()).getLong("LFT_SP_KEY_LAST_LOCATION_UPDATE_TIME", System.currentTimeMillis()), true)).toString());
        }
        context.sendBroadcast(((Intent) (obj)), "android.permission.ACCESS_FINE_LOCATION");
    }

    public boolean forceLocationUpdate()
    {
        final Object locationManager;
        Object obj;
        locationManager = (LocationManager)getApplicationContext().getSystemService("location");
        obj = new Criteria();
        final PendingIntent oneshotReceiver;
        byte byte0;
        if (!LocationLibrary.useFineAccuracyForRequests && ((LocationManager) (locationManager)).isProviderEnabled("network"))
        {
            byte0 = 2;
        } else
        {
            byte0 = 1;
        }
        ((Criteria) (obj)).setAccuracy(byte0);
        if (!LocationLibraryConstants.SUPPORTS_GINGERBREAD) goto _L2; else goto _L1
_L1:
        if (LocationLibrary.showDebugOutput)
        {
            Log.d("LittleFluffyLocationLibrary", "LocationBroadcastService: Force a single location update, as current location is beyond the oldest location permitted");
        }
        oneshotReceiver = (new Intent(getApplicationContext(), com/littlefluffytoys/littlefluffylocationlibrary/PassiveLocationChangedReceiver)).addCategory("INTENT_CATEGORY_ONE_SHOT_UPDATE");
        oneshotReceiver = PendingIntent.getBroadcast(getApplicationContext(), 0, oneshotReceiver, 0x8000000);
        ((LocationManager) (locationManager)).requestSingleUpdate(((Criteria) (obj)), oneshotReceiver);
        if (LocationLibrary.showDebugOutput)
        {
            Log.d("LittleFluffyLocationLibrary", "LocationBroadcastService: schedule timer to kill locationlistener in 30 seconds");
        }
        (new Timer()).schedule(new TimerTask() {

            final LocationBroadcastService this$0;
            final LocationManager val$locationManager;
            final PendingIntent val$oneshotReceiver;

            public void run()
            {
                try
                {
                    if (LocationLibrary.showDebugOutput)
                    {
                        Log.d("LittleFluffyLocationLibrary", "LocationBroadcastService: remove updates after 30 seconds");
                    }
                    locationManager.removeUpdates(oneshotReceiver);
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
                stopSelf();
            }

            
            {
                this$0 = LocationBroadcastService.this;
                locationManager = locationmanager;
                oneshotReceiver = pendingintent;
                super();
            }
        }, 30000L);
        return true;
        locationManager;
        if (LocationLibrary.showDebugOutput)
        {
            Log.w("LittleFluffyLocationLibrary", (new StringBuilder()).append("LocationBroadcastService: IllegalArgumentException during call to locationManager.requestSingleUpdate - probable cause is that all location providers are off. Details: ").append(((IllegalArgumentException) (locationManager)).getMessage()).toString());
        }
_L4:
        return false;
        locationManager;
        if (LocationLibrary.showDebugOutput)
        {
            Log.w("LittleFluffyLocationLibrary", (new StringBuilder()).append("LocationBroadcastService: SecurityException during call to locationManager.requestSingleUpdate - probable cause is that location permission is off. Details: ").append(((SecurityException) (locationManager)).getMessage()).toString());
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L2:
        if (LocationLibrary.showDebugOutput)
        {
            Log.d("LittleFluffyLocationLibrary", "LocationBroadcastService: Force location updates (pre-Gingerbread), as current location is beyond the oldest location permitted");
        }
        obj = ((LocationManager) (locationManager)).getBestProvider(((Criteria) (obj)), true);
        if (obj != null)
        {
            ((LocationManager) (locationManager)).requestLocationUpdates(((String) (obj)), 0L, 0.0F, preGingerbreadUpdatesListener, getMainLooper());
            return true;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public IBinder onBind(Intent intent)
    {
        return mBinder;
    }

    public void onDestroy()
    {
        if (LocationLibrary.showDebugOutput)
        {
            Log.d("LittleFluffyLocationLibrary", "LocationBroadcastService: onDestroy");
        }
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        if (LocationLibrary.showDebugOutput)
        {
            Log.d("LittleFluffyLocationLibrary", "LocationBroadcastService: onStartCommand");
        }
        (new Thread(null, mTask, "LocationBroadcastService")).start();
        return 1;
    }
}
