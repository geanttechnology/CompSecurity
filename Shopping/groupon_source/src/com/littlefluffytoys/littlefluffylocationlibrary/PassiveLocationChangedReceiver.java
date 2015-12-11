// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.littlefluffytoys.littlefluffylocationlibrary;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

// Referenced classes of package com.littlefluffytoys.littlefluffylocationlibrary:
//            LocationLibrary, LocationInfo, LocationBroadcastService, LocationLibraryConstants

public class PassiveLocationChangedReceiver extends BroadcastReceiver
{

    protected static String TAG = "PassiveLocationChangedReceiver";

    public PassiveLocationChangedReceiver()
    {
    }

    protected static void processLocation(Context context, Location location)
    {
        processLocation(context, location, true, false);
    }

    protected static void processLocation(Context context, Location location, boolean flag, boolean flag1)
    {
        float f2;
        float f3;
        String s;
        boolean flag2;
        int i;
        long l;
        long l1;
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        float f = sharedpreferences.getFloat("LFT_SP_KEY_LAST_LOCATION_UPDATE_LAT", -9.223372E+18F);
        float f1 = sharedpreferences.getFloat("LFT_SP_KEY_LAST_LOCATION_UPDATE_LNG", -9.223372E+18F);
        int j = sharedpreferences.getInt("LFT_SP_KEY_LAST_LOCATION_UPDATE_ACCURACY", 0x7fffffff);
        s = location.getProvider();
        boolean flag3 = false;
        f2 = (float)(int)(location.getLatitude() * 1000000D) / 1000000F;
        f3 = (float)(int)(location.getLongitude() * 1000000D) / 1000000F;
        i = (int)location.getAccuracy();
        l1 = location.getTime();
        l = l1;
        if (l1 == 0L)
        {
            l = System.currentTimeMillis();
        }
        flag2 = flag3;
        if (f != -9.223372E+18F)
        {
            int k = (int)(Math.acos(Math.sin(Math.toRadians(f2)) * Math.sin(Math.toRadians(f)) + Math.cos(Math.toRadians(f2)) * Math.cos(Math.toRadians(f)) * Math.cos(Math.toRadians(f3) - Math.toRadians(f1))) * 6371D * 1000D);
            if (LocationLibrary.showDebugOutput)
            {
                Log.d("LittleFluffyLocationLibrary", (new StringBuilder()).append(TAG).append(": Distance from last reading: ").append(k).append("m").toString());
            }
            flag2 = flag3;
            if (location.hasAccuracy())
            {
                flag2 = flag3;
                if (i > j)
                {
                    flag2 = flag3;
                    if (k < i)
                    {
                        flag2 = true;
                    }
                }
            }
        }
        l1 = sharedpreferences.getLong("LFT_SP_KEY_LAST_LOCATION_UPDATE_TIME", 0L);
        location = sharedpreferences.edit();
        location.putLong("LFT_SP_KEY_LAST_LOCATION_UPDATE_TIME", l);
        if (flag2) goto _L2; else goto _L1
_L1:
        location.putFloat("LFT_SP_KEY_LAST_LOCATION_UPDATE_LAT", f2);
        location.putFloat("LFT_SP_KEY_LAST_LOCATION_UPDATE_LNG", f3);
        location.putInt("LFT_SP_KEY_LAST_LOCATION_UPDATE_ACCURACY", i);
        location.putString("LFT_SP_KEY_LAST_LOCATION_UPDATE_PROVIDER", s);
        if (LocationLibrary.showDebugOutput)
        {
            Log.d("LittleFluffyLocationLibrary", (new StringBuilder()).append(TAG).append(": Storing location update, lat=").append(f2).append(" long=").append(f3).append(" accuracy=").append(i).append(" time=").append(LocationInfo.formatTimestampForDebug(l)).toString());
        }
_L4:
        location.commit();
        if (LocationLibrary.broadcastEveryLocationUpdate)
        {
            LocationBroadcastService.sendBroadcast(context, false);
        }
        if (l - l1 > LocationLibrary.getAlarmFrequency() || flag1)
        {
            if (LocationLibrary.showDebugOutput)
            {
                Log.d("LittleFluffyLocationLibrary", (new StringBuilder()).append(TAG).append(":processLocation: treating this location update as a periodic update, timestamp=").append(LocationInfo.formatTimestampForDebug(l)).toString());
            }
            if (!flag)
            {
                break; /* Loop/switch isn't completed */
            }
            LocationBroadcastService.forceDelayedServiceCall(context, LocationLibrary.stableLocationTimeoutInSeconds);
        }
        return;
_L2:
        if (LocationLibrary.showDebugOutput)
        {
            Log.d("LittleFluffyLocationLibrary", (new StringBuilder()).append(TAG).append(": Storing location update, less accurate so reusing prior location - time=").append(LocationInfo.formatTimestampForDebug(l)).toString());
        }
        if (true) goto _L4; else goto _L3
_L3:
        context.startService(new Intent(context, com/littlefluffytoys/littlefluffylocationlibrary/LocationBroadcastService));
        return;
    }

    public void onReceive(Context context, Intent intent)
    {
        if (!intent.hasCategory("INTENT_CATEGORY_ONE_SHOT_UPDATE")) goto _L2; else goto _L1
_L1:
        if (LocationLibrary.showDebugOutput)
        {
            Log.d("LittleFluffyLocationLibrary", (new StringBuilder()).append(TAG).append(":onReceive: on-demand location update received").toString());
        }
        if (!LocationLibraryConstants.SUPPORTS_JELLYBEAN_4_2 || !intent.hasExtra("location")) goto _L4; else goto _L3
_L3:
        if (LocationLibrary.showDebugOutput)
        {
            Log.d("LittleFluffyLocationLibrary", (new StringBuilder()).append(TAG).append(":onReceive: SUPPORTS_JELLYBEAN_4_2 and contains location key => processing").toString());
        }
        processLocation(context, (Location)intent.getExtras().get("location"), true, true);
_L6:
        return;
_L4:
        if (LocationLibrary.showDebugOutput)
        {
            Log.d("LittleFluffyLocationLibrary", (new StringBuilder()).append(TAG).append(":onReceive: pre-JELLYBEAN_4_2 => wait for update(s) from passive location provider").toString());
        }
        LocationBroadcastService.forceDelayedServiceCall(context, LocationLibrary.stableLocationTimeoutInSeconds);
        return;
_L2:
        if (intent.hasExtra("location"))
        {
            processLocation(context, (Location)intent.getExtras().get("location"));
            return;
        }
        if (LocationLibrary.showDebugOutput)
        {
            Log.w("LittleFluffyLocationLibrary", (new StringBuilder()).append(TAG).append(":onReceive: Unknown update received").toString());
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

}
