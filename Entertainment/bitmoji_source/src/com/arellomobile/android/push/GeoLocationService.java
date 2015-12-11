// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.ToneGenerator;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;
import com.arellomobile.android.push.data.PushZoneLocation;
import com.arellomobile.android.push.utils.WorkerTask;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.arellomobile.android.push:
//            DeviceFeature2_5

public class GeoLocationService extends Service
    implements LocationListener
{
    private class PostLocationTask extends WorkerTask
    {

        protected Location mLocation;
        protected PushZoneLocation mZoneLocation;
        final GeoLocationService this$0;

        protected void doWork(Context context)
            throws Exception
        {
            Log.d("LocationUpdateService", "Executing PostLocationTask#doInBackground");
            mZoneLocation = DeviceFeature2_5.getNearestZone(context, mLocation);
            if (mZoneLocation != null)
            {
                long l = mZoneLocation.getDistanceTo();
                ((GeoLocationService)context).distanceFilter = Integer.valueOf((int)(l / 2L));
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            Log.d("LocationUpdateService", "PostLocationTask#onPostExecture");
            super.onPostExecute(void1);
        }

        protected PostLocationTask(GeoLocationService geolocationservice1, Location location)
        {
            this$0 = GeoLocationService.this;
            super(geolocationservice1);
            mLocation = location;
        }
    }


    public static final String ARG_DESIRED_ACCURACY = "desiredAccuracy";
    public static final String ARG_DISTANCE_FILTER = "distanceFilter";
    public static final String ARG_LOCATION_TIMEOUT = "locationTimeout";
    public static final String ARG_STATIONARY_RADIUS = "stationaryRadius";
    private static final Integer MAX_SPEED_ACQUISITION_ATTEMPTS = Integer.valueOf(3);
    private static final Integer MAX_STATIONARY_ACQUISITION_ATTEMPTS = Integer.valueOf(5);
    private static final String SINGLE_LOCATION_UPDATE_ACTION = "com.tenforwardconsulting.cordova.bgloc.SINGLE_LOCATION_UPDATE_ACTION";
    private static final String STATIONARY_ALARM_ACTION = "com.tenforwardconsulting.cordova.bgloc.STATIONARY_ALARM_ACTION";
    private static final String STATIONARY_LOCATION_MONITOR_ACTION = "com.tenforwardconsulting.cordova.bgloc.STATIONARY_LOCATION_MONITOR_ACTION";
    private static final long STATIONARY_LOCATION_POLLING_INTERVAL_AGGRESSIVE = 60000L;
    private static final long STATIONARY_LOCATION_POLLING_INTERVAL_LAZY = 0x2bf20L;
    private static final String STATIONARY_REGION_ACTION = "com.tenforwardconsulting.cordova.bgloc.STATIONARY_REGION_ACTION";
    private static final long STATIONARY_TIMEOUT = 0x493e0L;
    private static final String TAG = "LocationUpdateService";
    public static TelephonyManager telephonyManager = null;
    private AlarmManager alarmManager;
    private ConnectivityManager connectivityManager;
    private Criteria criteria;
    private Integer desiredAccuracy;
    private Integer distanceFilter;
    private Boolean isAcquiringSpeed;
    private Boolean isAcquiringStationaryLocation;
    private Boolean isDebugging;
    private Boolean isMoving;
    private Location lastLocation;
    private Integer locationAcquisitionAttempts;
    private LocationManager locationManager;
    private Integer locationTimeout;
    private PhoneStateListener phoneStateListener;
    private Integer scaledDistanceFilter;
    private PendingIntent singleUpdatePI;
    private BroadcastReceiver singleUpdateReceiver;
    private PendingIntent stationaryAlarmPI;
    private BroadcastReceiver stationaryAlarmReceiver;
    private Location stationaryLocation;
    private BroadcastReceiver stationaryLocationMonitorReceiver;
    private long stationaryLocationPollingInterval;
    private PendingIntent stationaryLocationPollingPI;
    private float stationaryRadius;
    private PendingIntent stationaryRegionPI;
    private BroadcastReceiver stationaryRegionReceiver;
    private ToneGenerator toneGenerator;
    private android.os.PowerManager.WakeLock wakeLock;

    public GeoLocationService()
    {
        isMoving = Boolean.valueOf(false);
        isAcquiringStationaryLocation = Boolean.valueOf(false);
        isAcquiringSpeed = Boolean.valueOf(false);
        locationAcquisitionAttempts = Integer.valueOf(0);
        desiredAccuracy = Integer.valueOf(100);
        distanceFilter = Integer.valueOf(30);
        locationTimeout = Integer.valueOf(30);
        singleUpdateReceiver = new BroadcastReceiver() {

            final GeoLocationService this$0;

            public void onReceive(Context context, Intent intent)
            {
                context = (Location)intent.getExtras().get("location");
                if (context != null)
                {
                    Log.d("LocationUpdateService", (new StringBuilder()).append("- singleUpdateReciever").append(context.toString()).toString());
                    onPollStationaryLocation(context);
                }
            }

            
            {
                this$0 = GeoLocationService.this;
                super();
            }
        };
        stationaryAlarmReceiver = new BroadcastReceiver() {

            final GeoLocationService this$0;

            public void onReceive(Context context, Intent intent)
            {
                Log.i("LocationUpdateService", "- stationaryAlarm fired");
                setPace(Boolean.valueOf(false));
            }

            
            {
                this$0 = GeoLocationService.this;
                super();
            }
        };
        stationaryLocationMonitorReceiver = new BroadcastReceiver() {

            final GeoLocationService this$0;

            public void onReceive(Context context, Intent intent)
            {
                Log.i("LocationUpdateService", "- stationaryLocationMonitorReceiver fired");
                if (isDebugging.booleanValue())
                {
                    startTone("dialtone");
                }
                criteria.setAccuracy(1);
                criteria.setHorizontalAccuracy(3);
                criteria.setPowerRequirement(3);
                locationManager.requestSingleUpdate(criteria, singleUpdatePI);
            }

            
            {
                this$0 = GeoLocationService.this;
                super();
            }
        };
        stationaryRegionReceiver = new BroadcastReceiver() {

            final GeoLocationService this$0;

            public void onReceive(Context context, Intent intent)
            {
                Log.i("LocationUpdateService", "stationaryRegionReceiver");
                if (Boolean.valueOf(intent.getBooleanExtra("entering", false)).booleanValue())
                {
                    Log.d("LocationUpdateService", "- ENTER");
                    if (isMoving.booleanValue())
                    {
                        setPace(Boolean.valueOf(false));
                    }
                } else
                {
                    Log.d("LocationUpdateService", "- EXIT");
                    context = getLastBestLocation();
                    if (context != null)
                    {
                        onExitStationaryRegion(context);
                        return;
                    }
                }
            }

            
            {
                this$0 = GeoLocationService.this;
                super();
            }
        };
        phoneStateListener = new PhoneStateListener() {

            final GeoLocationService this$0;

            public void onCellLocationChanged(CellLocation celllocation)
            {
                onCellLocationChange(celllocation);
            }

            
            {
                this$0 = GeoLocationService.this;
                super();
            }
        };
    }

    private Integer calculateDistanceFilter(Float float1)
    {
        Double double1 = Double.valueOf(distanceFilter.intValue());
        if (float1.floatValue() < 100F)
        {
            double1 = Double.valueOf(Math.pow((float)(Math.round(float1.floatValue() / 5F) * 5), 2D) + (double)distanceFilter.intValue());
        }
        int i;
        if (double1.intValue() < 1000)
        {
            i = double1.intValue();
        } else
        {
            i = 1000;
        }
        return Integer.valueOf(i);
    }

    private void cleanUp()
    {
        locationManager.removeUpdates(this);
        alarmManager.cancel(stationaryAlarmPI);
        alarmManager.cancel(stationaryLocationPollingPI);
        toneGenerator.release();
        unregisterReceiver(stationaryAlarmReceiver);
        unregisterReceiver(singleUpdateReceiver);
        unregisterReceiver(stationaryRegionReceiver);
        unregisterReceiver(stationaryLocationMonitorReceiver);
        if (stationaryLocation != null && !isMoving.booleanValue())
        {
            try
            {
                locationManager.removeProximityAlert(stationaryRegionPI);
            }
            catch (Throwable throwable)
            {
                Log.w("LocationUpdateService", "- Something bad happened while removing proximity-alert");
            }
        }
        wakeLock.release();
    }

    private boolean isNetworkConnected()
    {
        NetworkInfo networkinfo = connectivityManager.getActiveNetworkInfo();
        if (networkinfo != null)
        {
            Log.d("LocationUpdateService", (new StringBuilder()).append("Network found, type = ").append(networkinfo.getTypeName()).toString());
            return networkinfo.isConnected();
        } else
        {
            Log.d("LocationUpdateService", "No active network info");
            return false;
        }
    }

    private void schedulePostLocations(Location location)
    {
        location = new PostLocationTask(this, location);
        Log.d("LocationUpdateService", (new StringBuilder()).append("beforeexecute ").append(location.getStatus()).toString());
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            location.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else
        {
            location.execute(new Void[0]);
        }
        Log.d("LocationUpdateService", (new StringBuilder()).append("afterexecute ").append(location.getStatus()).toString());
    }

    private void setPace(Boolean boolean1)
    {
        Log.i("LocationUpdateService", (new StringBuilder()).append("setPace: ").append(boolean1).toString());
        Boolean boolean2 = isMoving;
        isMoving = boolean1;
        isAcquiringStationaryLocation = Boolean.valueOf(false);
        isAcquiringSpeed = Boolean.valueOf(false);
        stationaryLocation = null;
        locationManager.removeUpdates(this);
        criteria.setAccuracy(1);
        criteria.setHorizontalAccuracy(translateDesiredAccuracy(desiredAccuracy).intValue());
        criteria.setPowerRequirement(3);
        if (isMoving.booleanValue())
        {
            if (!boolean2.booleanValue())
            {
                isAcquiringSpeed = Boolean.valueOf(true);
            }
        } else
        {
            isAcquiringStationaryLocation = Boolean.valueOf(true);
        }
        if (isAcquiringSpeed.booleanValue() || isAcquiringStationaryLocation.booleanValue())
        {
            locationAcquisitionAttempts = Integer.valueOf(0);
            boolean1 = locationManager.getAllProviders().iterator();
            do
            {
                if (!boolean1.hasNext())
                {
                    break;
                }
                String s = (String)boolean1.next();
                if (s != "passive")
                {
                    locationManager.requestLocationUpdates(s, 0L, 0.0F, this);
                }
            } while (true);
        } else
        {
            locationManager.requestLocationUpdates(locationManager.getBestProvider(criteria, true), locationTimeout.intValue() * 1000, scaledDistanceFilter.intValue(), this);
        }
    }

    private void startMonitoringStationaryRegion(Location location)
    {
        locationManager.removeUpdates(this);
        stationaryLocation = location;
        Log.i("LocationUpdateService", (new StringBuilder()).append("- startMonitoringStationaryRegion (").append(location.getLatitude()).append(",").append(location.getLongitude()).append("), accuracy:").append(location.getAccuracy()).toString());
        LocationManager locationmanager = locationManager;
        double d = location.getLatitude();
        double d1 = location.getLongitude();
        float f;
        if (location.getAccuracy() < stationaryRadius)
        {
            f = stationaryRadius;
        } else
        {
            f = location.getAccuracy();
        }
        locationmanager.addProximityAlert(d, d1, f, -1L, stationaryRegionPI);
        startPollingStationaryLocation(0x2bf20L);
    }

    private void startTone(String s)
    {
        byte byte0 = 0;
        if (!s.equals("beep")) goto _L2; else goto _L1
_L1:
        byte0 = 24;
_L4:
        toneGenerator.startTone(byte0, 1000);
        return;
_L2:
        if (s.equals("beep_beep_beep"))
        {
            byte0 = 41;
        } else
        if (s.equals("long_beep"))
        {
            byte0 = 97;
        } else
        if (s.equals("doodly_doo"))
        {
            byte0 = 86;
        } else
        if (s.equals("chirp_chirp_chirp"))
        {
            byte0 = 93;
        } else
        if (s.equals("dialtone"))
        {
            byte0 = 23;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private Integer translateDesiredAccuracy(Integer integer)
    {
        switch (integer.intValue())
        {
        default:
            return Integer.valueOf(2);

        case 1000: 
            return Integer.valueOf(1);

        case 100: // 'd'
            return Integer.valueOf(2);

        case 10: // '\n'
            return Integer.valueOf(3);

        case 0: // '\0'
            return Integer.valueOf(3);
        }
    }

    public Location getLastBestLocation()
    {
        int i = (int)stationaryRadius;
        long l = System.currentTimeMillis() - (long)(locationTimeout.intValue() * 1000);
        Log.i("LocationUpdateService", (new StringBuilder()).append("- fetching last best location ").append(i).append(",").append(l).toString());
        Location location = null;
        float f = 3.402823E+38F;
        Iterator iterator = locationManager.getAllProviders().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (String)iterator.next();
            Log.d("LocationUpdateService", (new StringBuilder()).append("- provider: ").append(((String) (obj))).toString());
            obj = locationManager.getLastKnownLocation(((String) (obj)));
            if (obj != null)
            {
                Log.d("LocationUpdateService", (new StringBuilder()).append(" location: ").append(((Location) (obj)).getLatitude()).append(",").append(((Location) (obj)).getLongitude()).append(",").append(((Location) (obj)).getAccuracy()).append(",").append(((Location) (obj)).getSpeed()).append("m/s").toString());
                float f1 = ((Location) (obj)).getAccuracy();
                long l1 = ((Location) (obj)).getTime();
                StringBuilder stringbuilder = (new StringBuilder()).append("time>minTime: ");
                boolean flag;
                if (l1 > l)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                stringbuilder = stringbuilder.append(flag).append(", accuracy<bestAccuracy: ");
                if (f1 < f)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                Log.d("LocationUpdateService", stringbuilder.append(flag).toString());
                if (l1 > l && f1 < f)
                {
                    location = ((Location) (obj));
                    f = f1;
                }
            }
        } while (true);
        return location;
    }

    public IBinder onBind(Intent intent)
    {
        Log.i("LocationUpdateService", (new StringBuilder()).append("OnBind").append(intent).toString());
        return null;
    }

    public void onCellLocationChange(CellLocation celllocation)
    {
        Log.i("LocationUpdateService", (new StringBuilder()).append("- onCellLocationChange").append(celllocation.toString()).toString());
        if (isDebugging.booleanValue())
        {
            Toast.makeText(this, "Cellular location change", 1).show();
            startTone("chirp_chirp_chirp");
        }
        if (!isMoving.booleanValue() && stationaryLocation != null)
        {
            criteria.setAccuracy(1);
            criteria.setHorizontalAccuracy(3);
            criteria.setPowerRequirement(3);
            locationManager.requestSingleUpdate(criteria, singleUpdatePI);
        }
    }

    public void onCreate()
    {
        super.onCreate();
        Log.i("LocationUpdateService", "OnCreate");
        locationManager = (LocationManager)getSystemService("location");
        alarmManager = (AlarmManager)getSystemService("alarm");
        toneGenerator = new ToneGenerator(5, 100);
        connectivityManager = (ConnectivityManager)getSystemService("connectivity");
        telephonyManager = (TelephonyManager)getSystemService("phone");
        stationaryAlarmPI = PendingIntent.getBroadcast(this, 0, new Intent("com.tenforwardconsulting.cordova.bgloc.STATIONARY_ALARM_ACTION"), 0);
        registerReceiver(stationaryAlarmReceiver, new IntentFilter("com.tenforwardconsulting.cordova.bgloc.STATIONARY_ALARM_ACTION"));
        stationaryRegionPI = PendingIntent.getBroadcast(this, 0, new Intent("com.tenforwardconsulting.cordova.bgloc.STATIONARY_REGION_ACTION"), 0x10000000);
        registerReceiver(stationaryRegionReceiver, new IntentFilter("com.tenforwardconsulting.cordova.bgloc.STATIONARY_REGION_ACTION"));
        stationaryLocationPollingPI = PendingIntent.getBroadcast(this, 0, new Intent("com.tenforwardconsulting.cordova.bgloc.STATIONARY_LOCATION_MONITOR_ACTION"), 0);
        registerReceiver(stationaryLocationMonitorReceiver, new IntentFilter("com.tenforwardconsulting.cordova.bgloc.STATIONARY_LOCATION_MONITOR_ACTION"));
        singleUpdatePI = PendingIntent.getBroadcast(this, 0, new Intent("com.tenforwardconsulting.cordova.bgloc.SINGLE_LOCATION_UPDATE_ACTION"), 0x10000000);
        registerReceiver(singleUpdateReceiver, new IntentFilter("com.tenforwardconsulting.cordova.bgloc.SINGLE_LOCATION_UPDATE_ACTION"));
        wakeLock = ((PowerManager)getSystemService("power")).newWakeLock(1, "LocationUpdateService");
        wakeLock.acquire();
        criteria = new Criteria();
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setSpeedRequired(true);
        criteria.setCostAllowed(true);
    }

    public void onDestroy()
    {
        Log.w("LocationUpdateService", "------------------------------------------ Destroyed Location update Service");
        cleanUp();
        super.onDestroy();
    }

    public void onExitStationaryRegion(Location location)
    {
        if (isDebugging.booleanValue())
        {
            startTone("beep_beep_beep");
        }
        alarmManager.cancel(stationaryLocationPollingPI);
        locationManager.removeProximityAlert(stationaryRegionPI);
        setPace(Boolean.valueOf(true));
    }

    public void onLocationChanged(Location location)
    {
        Log.d("LocationUpdateService", (new StringBuilder()).append("- onLocationChanged: ").append(location.getLatitude()).append(",").append(location.getLongitude()).append(", accuracy: ").append(location.getAccuracy()).append(", isMoving: ").append(isMoving).append(", speed: ").append(location.getSpeed()).toString());
        if (!isMoving.booleanValue() && !isAcquiringStationaryLocation.booleanValue() && stationaryLocation == null)
        {
            setPace(Boolean.valueOf(false));
        }
        if (isDebugging.booleanValue())
        {
            Toast.makeText(this, (new StringBuilder()).append("mv:").append(isMoving).append(",acy:").append(location.getAccuracy()).append(",v:").append(location.getSpeed()).append(",df:").append(scaledDistanceFilter).toString(), 1).show();
        }
        if (!isAcquiringStationaryLocation.booleanValue()) goto _L2; else goto _L1
_L1:
        Integer integer;
        if (stationaryLocation == null || stationaryLocation.getAccuracy() > location.getAccuracy())
        {
            stationaryLocation = location;
        }
        integer = Integer.valueOf(locationAcquisitionAttempts.intValue() + 1);
        locationAcquisitionAttempts = integer;
        if (integer != MAX_STATIONARY_ACQUISITION_ATTEMPTS) goto _L4; else goto _L3
_L3:
        isAcquiringStationaryLocation = Boolean.valueOf(false);
        startMonitoringStationaryRegion(stationaryLocation);
        if (isDebugging.booleanValue())
        {
            startTone("long_beep");
        }
_L7:
        lastLocation = location;
        if (!isNetworkConnected())
        {
            break MISSING_BLOCK_LABEL_599;
        }
        Log.d("LocationUpdateService", "Scheduling location network post");
        schedulePostLocations(location);
_L6:
        return;
_L4:
        if (!isDebugging.booleanValue()) goto _L6; else goto _L5
_L5:
        startTone("beep");
        return;
_L2:
        if (!isAcquiringSpeed.booleanValue())
        {
            break MISSING_BLOCK_LABEL_440;
        }
        Integer integer1 = Integer.valueOf(locationAcquisitionAttempts.intValue() + 1);
        locationAcquisitionAttempts = integer1;
        if (integer1 != MAX_SPEED_ACQUISITION_ATTEMPTS)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (isDebugging.booleanValue())
        {
            startTone("doodly_doo");
        }
        isAcquiringSpeed = Boolean.valueOf(false);
        scaledDistanceFilter = calculateDistanceFilter(Float.valueOf(location.getSpeed()));
        setPace(Boolean.valueOf(true));
          goto _L7
        if (!isDebugging.booleanValue()) goto _L6; else goto _L8
_L8:
        startTone("beep");
        return;
        if (!isMoving.booleanValue())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (isDebugging.booleanValue())
        {
            startTone("beep");
        }
        if (location.getSpeed() >= 1.0F && location.getAccuracy() <= stationaryRadius)
        {
            resetStationaryAlarm();
        }
        Integer integer2 = calculateDistanceFilter(Float.valueOf(location.getSpeed()));
        if (integer2.intValue() != scaledDistanceFilter.intValue())
        {
            Log.i("LocationUpdateService", (new StringBuilder()).append("- updated distanceFilter, new: ").append(integer2).append(", old: ").append(scaledDistanceFilter).toString());
            scaledDistanceFilter = integer2;
            setPace(Boolean.valueOf(true));
        }
        if (location.distanceTo(lastLocation) >= (float)distanceFilter.intValue()) goto _L7; else goto _L9
_L9:
        return;
        if (stationaryLocation == null) goto _L7; else goto _L10
_L10:
        return;
        Log.d("LocationUpdateService", "Network unavailable, waiting for now");
        return;
    }

    public void onPollStationaryLocation(Location location)
    {
        if (!isMoving.booleanValue())
        {
            if (isDebugging.booleanValue())
            {
                startTone("beep");
            }
            float f = Math.abs(location.distanceTo(stationaryLocation) - stationaryLocation.getAccuracy() - location.getAccuracy());
            if (isDebugging.booleanValue())
            {
                Toast.makeText(this, (new StringBuilder()).append("Stationary exit in ").append(stationaryRadius - f).append("m").toString(), 1).show();
            }
            Log.i("LocationUpdateService", (new StringBuilder()).append("- distance from stationary location: ").append(f).toString());
            if (f > stationaryRadius)
            {
                onExitStationaryRegion(location);
                return;
            }
            if (f > 0.0F)
            {
                startPollingStationaryLocation(60000L);
                return;
            }
            if (stationaryLocationPollingInterval != 0x2bf20L)
            {
                startPollingStationaryLocation(0x2bf20L);
                return;
            }
        }
    }

    public void onProviderDisabled(String s)
    {
        Log.d("LocationUpdateService", (new StringBuilder()).append("- onProviderDisabled: ").append(s).toString());
    }

    public void onProviderEnabled(String s)
    {
        Log.d("LocationUpdateService", (new StringBuilder()).append("- onProviderEnabled: ").append(s).toString());
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        Log.i("LocationUpdateService", (new StringBuilder()).append("Received start id ").append(j).append(": ").append(intent).toString());
        if (intent != null)
        {
            stationaryRadius = intent.getFloatExtra("stationaryRadius", 20F);
            desiredAccuracy = Integer.valueOf(intent.getIntExtra("desiredAccuracy", 10));
            locationTimeout = Integer.valueOf(intent.getIntExtra("locationTimeout", 30));
            distanceFilter = Integer.valueOf(intent.getIntExtra("distanceFilter", 30));
            scaledDistanceFilter = distanceFilter;
            isDebugging = Boolean.valueOf(intent.getBooleanExtra("isDebugging", false));
        }
        Log.i("LocationUpdateService", (new StringBuilder()).append("- stationaryRadius: ").append(stationaryRadius).toString());
        Log.i("LocationUpdateService", (new StringBuilder()).append("- distanceFilter: ").append(distanceFilter).toString());
        Log.i("LocationUpdateService", (new StringBuilder()).append("- desiredAccuracy: ").append(desiredAccuracy).toString());
        Log.i("LocationUpdateService", (new StringBuilder()).append("- locationTimeout: ").append(locationTimeout).toString());
        Log.i("LocationUpdateService", (new StringBuilder()).append("- isDebugging: ").append(isDebugging).toString());
        setPace(Boolean.valueOf(false));
        return 1;
    }

    public void onStatusChanged(String s, int i, Bundle bundle)
    {
        Log.d("LocationUpdateService", (new StringBuilder()).append("- onStatusChanged: ").append(s).append(", status: ").append(i).toString());
    }

    public void onTaskRemoved(Intent intent)
    {
        stopSelf();
        super.onTaskRemoved(intent);
    }

    public void resetStationaryAlarm()
    {
        alarmManager.cancel(stationaryAlarmPI);
        alarmManager.set(0, System.currentTimeMillis() + 0x493e0L, stationaryAlarmPI);
    }

    public void startPollingStationaryLocation(long l)
    {
        stationaryLocationPollingInterval = l;
        alarmManager.cancel(stationaryLocationPollingPI);
        long l1 = System.currentTimeMillis();
        alarmManager.setInexactRepeating(0, 60000L + l1, l, stationaryLocationPollingPI);
    }

    public boolean stopService(Intent intent)
    {
        Log.i("LocationUpdateService", (new StringBuilder()).append("- Received stop: ").append(intent).toString());
        cleanUp();
        if (isDebugging.booleanValue())
        {
            Toast.makeText(this, "Background location tracking stopped", 0).show();
        }
        return super.stopService(intent);
    }










/*
    static Integer access$702(GeoLocationService geolocationservice, Integer integer)
    {
        geolocationservice.distanceFilter = integer;
        return integer;
    }

*/
}
