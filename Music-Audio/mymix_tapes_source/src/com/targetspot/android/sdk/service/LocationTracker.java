// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.service;

import android.content.Context;
import android.location.Location;
import android.os.Message;
import android.util.Log;
import com.targetspot.android.sdk.AdSettings;
import com.targetspot.android.sdk.TSLocationType;
import com.targetspot.android.sdk.util.LocationUtil;

public class LocationTracker
{

    static final int LOCATION_UPDATE_INTERVAL = 0xdbba0;
    Context appContext;
    boolean coarseEnabled;
    Location currentLocation;
    boolean fineEnabled;
    com.targetspot.android.sdk.util.LocationUtil.LocationHandler handler;
    Object notify;
    boolean running;
    TSLocationType type;
    private Runnable update;

    public LocationTracker(Context context)
    {
        boolean flag1 = true;
        super();
        running = false;
        currentLocation = null;
        notify = new Object();
        handler = new com.targetspot.android.sdk.util.LocationUtil.LocationHandler() {

            final LocationTracker this$0;

            public void handleError(Message message)
            {
                Log.e("LocationTracker", "Error obtaining location");
                synchronized (notify)
                {
                    currentLocation = null;
                    notify.notify();
                }
                return;
                exception;
                message;
                JVM INSTR monitorexit ;
                throw exception;
            }

            public void handleLocation(Location location)
            {
                Log.d("LocationTracker", (new StringBuilder()).append("Updated location: ").append(location.getLatitude()).append(" ").append(location.getLongitude()).toString());
                synchronized (notify)
                {
                    currentLocation = location;
                    notify.notify();
                }
                return;
                location;
                obj;
                JVM INSTR monitorexit ;
                throw location;
            }

            
            {
                this$0 = LocationTracker.this;
                super();
            }
        };
        update = new Runnable() {

            final LocationTracker this$0;

            public void run()
            {
                updateLocation();
            }

            
            {
                this$0 = LocationTracker.this;
                super();
            }
        };
        appContext = context;
        boolean flag;
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        fineEnabled = flag;
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        coarseEnabled = flag;
    }

    private boolean isLocationAvailable()
    {
        while (fineEnabled && LocationUtil.isGPSOn(appContext) || (coarseEnabled || fineEnabled) && LocationUtil.isNetworkLocationOn(appContext)) 
        {
            return true;
        }
        return false;
    }

    private void updateLocation()
    {
        handler.removeCallbacks(update);
        Log.d("LocationTracker", "Requesting updated location");
        static class _cls3
        {

            static final int $SwitchMap$com$targetspot$android$sdk$TSLocationType[];

            static 
            {
                $SwitchMap$com$targetspot$android$sdk$TSLocationType = new int[TSLocationType.values().length];
                try
                {
                    $SwitchMap$com$targetspot$android$sdk$TSLocationType[TSLocationType.TSLocationBestAvailable.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$targetspot$android$sdk$TSLocationType[TSLocationType.TSLocationUseNetowrk.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$targetspot$android$sdk$TSLocationType[TSLocationType.TSLocationLastKnown.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$targetspot$android$sdk$TSLocationType[TSLocationType.TSLocationPostalCode.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$targetspot$android$sdk$TSLocationType[TSLocationType.TSLocationUnknown.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        int i = _cls3..SwitchMap.com.targetspot.android.sdk.TSLocationType[type.ordinal()];
        i;
        JVM INSTR tableswitch 1 2: default 56
    //                   1 79
    //                   2 125;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_125;
_L4:
        if (running)
        {
            handler.postDelayed(update, 0xdbba0L);
        }
        return;
_L2:
        try
        {
            LocationUtil.getBestLocation(appContext, handler);
        }
        catch (Exception exception)
        {
            Log.e("LocationTracker", (new StringBuilder()).append("Error getting location: ").append(exception.getMessage()).toString());
        }
          goto _L4
        LocationUtil.getNetworkLocation(appContext, handler);
          goto _L4
    }

    public Location getLocation()
    {
        _cls3..SwitchMap.com.targetspot.android.sdk.TSLocationType[type.ordinal()];
        JVM INSTR tableswitch 1 5: default 44
    //                   1 103
    //                   2 103
    //                   3 44
    //                   4 101
    //                   5 101;
           goto _L1 _L2 _L2 _L1 _L3 _L3
_L1:
        if (currentLocation != null)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj;
        obj = LocationUtil.getLastBestLocation(appContext);
        Log.d("LocationTracker", (new StringBuilder()).append("Using last known locaiton: ").append(((Location) (obj)).getLatitude()).append(" ").append(((Location) (obj)).getLongitude()).toString());
        return ((Location) (obj));
_L3:
        return null;
_L2:
        obj = notify;
        obj;
        JVM INSTR monitorenter ;
        Location location;
        if (!running)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        location = currentLocation;
        if (location != null)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        Exception exception;
        Exception exception1;
        try
        {
            notify.wait(5000L);
        }
        catch (Exception exception2) { }
        obj;
        JVM INSTR monitorexit ;
        if (true) goto _L1; else goto _L4
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        exception;
        Log.d("LocationTracker", (new StringBuilder()).append("Exception getting location: ").append(exception.getMessage()).toString());
_L4:
        return currentLocation;
    }

    public void startTracker(AdSettings adsettings)
    {
        type = adsettings.getLocationType();
        switch (_cls3..SwitchMap.com.targetspot.android.sdk.TSLocationType[type.ordinal()])
        {
        default:
            return;

        case 4: // '\004'
        case 5: // '\005'
            break;

        case 1: // '\001'
        case 2: // '\002'
            if (isLocationAvailable())
            {
                Log.d("LocationTracker", "Starting service");
                updateLocation();
                running = true;
                return;
            }
            if (!fineEnabled && !coarseEnabled)
            {
                Log.e("LocationTracker", "Location requested but permission not granted to application");
            }
            Log.d("LocationTracker", "Location service not available");
            return;

        case 3: // '\003'
            if (isLocationAvailable())
            {
                Log.d("LocationTracker", "Using last known location");
            }
            break;
        }
        Log.d("LocationTracker", "Not starting service");
    }

    public void stopTracker()
    {
        if (running)
        {
            Log.d("LocationTracker", "Stopping service");
            handler.removeCallbacks(update);
            running = false;
        }
    }

}
