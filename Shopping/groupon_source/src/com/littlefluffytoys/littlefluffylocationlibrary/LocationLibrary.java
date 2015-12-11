// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.littlefluffytoys.littlefluffylocationlibrary;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationManager;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.util.Log;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.littlefluffytoys.littlefluffylocationlibrary:
//            LocationBroadcastService, PassiveLocationChangedReceiver, LocationLibraryConstants

public class LocationLibrary
{

    private static long alarmFrequency = 0xdbba0L;
    protected static boolean broadcastEveryLocationUpdate = false;
    protected static String broadcastPrefix;
    private static boolean initialised = false;
    private static int locationMaximumAge = 0x36ee80;
    protected static boolean showDebugOutput = false;
    protected static int stableLocationTimeoutInSeconds = 5;
    protected static boolean useFineAccuracyForRequests = false;

    public static void forceLocationUpdate(Context context)
    {
        if (showDebugOutput)
        {
            Log.d("LittleFluffyLocationLibrary", "LocationLibrary: forceLocationUpdate called to force a location update");
        }
        PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext()).edit().putBoolean("LFT_SP_KEY_FORCE_LOCATION_UPDATE", true).commit();
        context.startService(new Intent(context, com/littlefluffytoys/littlefluffylocationlibrary/LocationBroadcastService));
    }

    protected static long getAlarmFrequency()
    {
        return alarmFrequency;
    }

    protected static int getLocationMaximumAge()
    {
        return locationMaximumAge;
    }

    public static void initialiseLibrary(Context context, String s)
        throws UnsupportedOperationException
    {
label0:
        {
label1:
            {
                if (!initialised)
                {
                    if (showDebugOutput)
                    {
                        Log.d("LittleFluffyLocationLibrary", "LocationLibrary: initialiseLibrary");
                    }
                    broadcastPrefix = s;
                    s = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
                    if (!s.getBoolean("LFT_SP_KEY_RUN_ONCE", Boolean.FALSE.booleanValue()))
                    {
                        if (showDebugOutput)
                        {
                            Log.d("LittleFluffyLocationLibrary", "LocationLibrary: initialiseLibrary: first time ever run -> start alarm and listener");
                        }
                        startAlarmAndListener(context);
                        s.edit().putBoolean("LFT_SP_KEY_RUN_ONCE", Boolean.TRUE.booleanValue()).commit();
                        LocationManager locationmanager = (LocationManager)context.getSystemService("location");
                        if (locationmanager == null)
                        {
                            break label0;
                        }
                        if (locationmanager.getAllProviders().size() <= 0)
                        {
                            break label1;
                        }
                        s = null;
                        Iterator iterator = locationmanager.getAllProviders().iterator();
                        do
                        {
                            if (!iterator.hasNext())
                            {
                                break;
                            }
                            Location location = locationmanager.getLastKnownLocation((String)iterator.next());
                            if (location != null && (s == null || !s.hasAccuracy() || location.hasAccuracy() && location.getAccuracy() < s.getAccuracy()))
                            {
                                s = location;
                            }
                        } while (true);
                        if (s != null)
                        {
                            if (showDebugOutput)
                            {
                                Log.d("LittleFluffyLocationLibrary", (new StringBuilder()).append("LocationLibrary: initialiseLibrary: remembering best location ").append(s.getLatitude()).append(",").append(s.getLongitude()).toString());
                            }
                            PassiveLocationChangedReceiver.processLocation(context, s, false, false);
                        }
                    }
                    initialised = true;
                }
                return;
            }
            throw new UnsupportedOperationException("No location providers found on this device");
        }
        throw new UnsupportedOperationException("Location service not found on this device");
    }

    public static void startAlarmAndListener(Context context)
    {
        if (showDebugOutput)
        {
            Object obj1 = (new StringBuilder()).append("LocationLibrary: startAlarmAndListener: alarmFrequency=");
            Object obj;
            if (alarmFrequency == 0xdbba0L)
            {
                obj = "default:";
            } else
            {
                obj = "";
            }
            obj1 = ((StringBuilder) (obj1)).append(((String) (obj))).append(alarmFrequency / 1000L).append(" secs, locationMaximumAge=");
            if (locationMaximumAge == 0x36ee80)
            {
                obj = "default:";
            } else
            {
                obj = "";
            }
            Log.d("LittleFluffyLocationLibrary", ((StringBuilder) (obj1)).append(((String) (obj))).append(locationMaximumAge / 1000).append(" secs").toString());
        }
        obj = PendingIntent.getService(context, 2, new Intent(context, com/littlefluffytoys/littlefluffylocationlibrary/LocationBroadcastService), 0x8000000);
        obj1 = (AlarmManager)context.getSystemService("alarm");
        ((AlarmManager) (obj1)).cancel(((PendingIntent) (obj)));
        ((AlarmManager) (obj1)).setInexactRepeating(2, SystemClock.elapsedRealtime(), getAlarmFrequency(), ((PendingIntent) (obj)));
        if (!LocationLibraryConstants.SUPPORTS_FROYO)
        {
            break MISSING_BLOCK_LABEL_197;
        }
        obj = (LocationManager)context.getSystemService("location");
        context = PendingIntent.getBroadcast(context, 0, new Intent(context, com/littlefluffytoys/littlefluffylocationlibrary/PassiveLocationChangedReceiver), 0x8000000);
        ((LocationManager) (obj)).requestLocationUpdates("passive", 0L, 0.0F, context);
        if (showDebugOutput)
        {
            Log.d("LittleFluffyLocationLibrary", "LocationLibrary: startAlarmAndListener completed");
        }
_L1:
        return;
        context;
        if (showDebugOutput)
        {
            Log.w("LittleFluffyLocationLibrary", (new StringBuilder()).append("LocationLibrary: SecurityException during call to LocationLibrary.startAlarmAndListener - probable cause is that location permission is off. Details: ").append(context.getMessage()).toString());
            return;
        }
          goto _L1
    }

}
