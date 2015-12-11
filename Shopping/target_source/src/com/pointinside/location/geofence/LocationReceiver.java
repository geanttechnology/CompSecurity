// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.geofence;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import com.pointinside.feeds.VenueEntity;
import com.pointinside.internal.utils.LogUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.pointinside.location.geofence:
//            VenueProximityService, VenueProximityCache, VenueProximityState, GeofenceCacheManagement, 
//            VenueProximityManager

public class LocationReceiver extends BroadcastReceiver
{
    private static class Utils
    {

        private static float distanceToFence(VenueProximityState venueproximitystate)
        {
            VenueProximityState.VenueLocation venuelocation = venueproximitystate.venueLocation;
            float f = venueproximitystate.distance;
            float f1 = venuelocation.venue.geofence;
            return f - (venuelocation.getAccuracy() + f1);
        }

        private static Location getLocation(Intent intent)
        {
            return (Location)intent.getExtras().get("com.pointinside.location.geofence.LocationReceiver.Location");
        }

        private static void queueNextAlarm(Context context, VenueProximityState venueproximitystate)
        {
            int i = timeToNextAlarm(venueproximitystate);
            VenueProximityService.setNextAlarm(context, VenueProximityService.getStartIntent(context.getPackageName(), i, -1), i);
        }

        private static int timeToNextAlarm(VenueProximityState venueproximitystate)
        {
            float f = distanceToFence(venueproximitystate);
            byte byte0 = 120;
            int i = 0;
            int j = Float.valueOf(f / 26.6F).intValue();
            if (j >= 0)
            {
                i = j;
            }
            j = i;
            if (i > 120)
            {
                j = 120;
            }
            if (venueproximitystate.type == VenueProximityState.Type.DISABLED)
            {
                i = byte0;
            } else
            {
                i = j;
            }
            return i * 1000;
        }



        private Utils()
        {
        }
    }


    private static final String ACTION_LOCATION_UPDATE = "com.pointinside.android.action.LOCATION_UPDATE";
    static final String CLASS_NAME = com/pointinside/location/geofence/LocationReceiver.getName();
    private static final String LOCATION_UPDATE = "com.pointinside.location.geofence.LocationReceiver.Location";
    private static int errorCount = 0;
    static final Set locationListeners = new HashSet();
    static VenueProximityState proximityState = VenueProximityState.Factory.zeroState();
    static final Set venueListeners = new HashSet();

    public LocationReceiver()
    {
    }

    static void addListener(VenueProximityManager.LocationListener locationlistener)
    {
        locationListeners.add(locationlistener);
        String s = VenueProximityService.LOG_TAG;
        StringBuilder stringbuilder = (new StringBuilder()).append(locationListeners.size()).append(" location listener");
        if (locationListeners.size() > 1)
        {
            locationlistener = "s";
        } else
        {
            locationlistener = "";
        }
        LogUtils.logD(s, stringbuilder.append(locationlistener).toString());
    }

    static void addListener(VenueProximityManager.VenueProximityListener venueproximitylistener)
    {
        venueListeners.add(venueproximitylistener);
        String s = VenueProximityService.LOG_TAG;
        StringBuilder stringbuilder = (new StringBuilder()).append(venueListeners.size()).append(" venue listener");
        if (venueListeners.size() > 1)
        {
            venueproximitylistener = "s";
        } else
        {
            venueproximitylistener = "";
        }
        LogUtils.logD(s, stringbuilder.append(venueproximitylistener).toString());
    }

    static void clearLocaitonListeners()
    {
        locationListeners.clear();
    }

    static void clearVenueListeners()
    {
        venueListeners.clear();
    }

    static Intent getIntent(String s, Location location)
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.pointinside.location.geofence.LocationReceiver.Location", location);
        location = new Intent();
        location.setComponent(new ComponentName(s, CLASS_NAME));
        location.setAction("com.pointinside.android.action.LOCATION_UPDATE");
        location.putExtras(bundle);
        return location;
    }

    private void notifyLocationListeners(Location location)
    {
        VenueProximityCache.setLocation(location);
        String s = VenueProximityService.LOG_TAG;
        StringBuilder stringbuilder = (new StringBuilder()).append("-- Notify ").append(locationListeners.size()).append(" Location Listener");
        Object obj;
        if (locationListeners.size() == 1)
        {
            obj = "";
        } else
        {
            obj = "s";
        }
        LogUtils.logD(s, stringbuilder.append(((String) (obj))).toString());
        VenueProximityManager.LocationListener locationlistener;
        for (obj = locationListeners.iterator(); ((Iterator) (obj)).hasNext(); locationlistener.onNewLocation(location))
        {
            locationlistener = (VenueProximityManager.LocationListener)((Iterator) (obj)).next();
            LogUtils.logD(VenueProximityService.LOG_TAG, "loclistener notified");
        }

    }

    public static void onDestroy()
    {
        clearLocaitonListeners();
        clearVenueListeners();
    }

    static void removeLocationListener(VenueProximityManager.LocationListener locationlistener)
    {
        locationListeners.remove(locationlistener);
    }

    static void removeVenueListener(VenueProximityManager.VenueProximityListener venueproximitylistener)
    {
        venueListeners.remove(venueproximitylistener);
    }

    private void tryToNotifyVenueListeners()
    {
        VenueProximityCache.setState(proximityState);
        String s = VenueProximityService.LOG_TAG;
        StringBuilder stringbuilder = (new StringBuilder()).append("-- Notify ").append(venueListeners.size()).append(" Venue Listener");
        Object obj;
        if (venueListeners.size() == 1)
        {
            obj = "";
        } else
        {
            obj = "s";
        }
        LogUtils.logD(s, stringbuilder.append(((String) (obj))).append("(").append(proximityState.venueLocation.getLatitude()).append(" ").append(proximityState.venueLocation.getLongitude()).append(")").toString());
        obj = (new VenueProximityManager.VenueProximityEventBuilder()).setState(proximityState).build();
        VenueProximityManager.VenueProximityListener venueproximitylistener;
        for (Iterator iterator = venueListeners.iterator(); iterator.hasNext(); venueproximitylistener.onVenueProximityEvent(((VenueProximityManager.VenueProximityEvent) (obj))))
        {
            venueproximitylistener = (VenueProximityManager.VenueProximityListener)iterator.next();
            LogUtils.logD(VenueProximityService.LOG_TAG, "venueListener notified");
        }

    }

    public void onReceive(Context context, final Intent curLoc)
    {
        curLoc = Utils.getLocation(curLoc);
        if (curLoc == null) goto _L2; else goto _L1
_L1:
        if (!curLoc.getProvider().equals(VenueProximityState.Type.DISABLED.toString())) goto _L4; else goto _L3
_L3:
        proximityState = VenueProximityState.Factory.disable(proximityState);
        tryToNotifyVenueListeners();
_L2:
        Utils.queueNextAlarm(context, proximityState);
        return;
_L4:
        notifyLocationListeners(curLoc);
        LogUtils.logD(VenueProximityService.LOG_TAG, (new StringBuilder()).append("Query on (lat lng):(").append(curLoc.getLatitude()).append(" ").append(curLoc.getLongitude()).append(")").toString());
        GeofenceCacheManagement geofencecachemanagement = GeofenceCacheManagement.getInstance();
        try
        {
            geofencecachemanagement.doVenueLookup(context, curLoc, new GeofenceCacheManagement.VenueLookupListener() {

                final LocationReceiver this$0;
                final Location val$curLoc;

                public void onSuccessfulLookup(VenueEntity venueentity)
                {
                    if (venueentity != null)
                    {
                        LogUtils.logD(VenueProximityService.LOG_TAG, (new StringBuilder()).append("query succeeded::nearestVenue@(").append(venueentity.latitude).append(" ").append(venueentity.longitude).append(")").toString());
                        LocationReceiver.proximityState = VenueProximityState.Factory.buildOn(LocationReceiver.proximityState, venueentity, curLoc);
                        tryToNotifyVenueListeners();
                        LocationReceiver.errorCount = 0;
                        return;
                    } else
                    {
                        int i = _22_query_20_succeeded_3A__3A_nearestVenue_40__28__22_;
                        return;
                    }
                }

            
            {
                this$0 = LocationReceiver.this;
                curLoc = location;
                super();
            }
            });
        }
        // Misplaced declaration of an exception variable
        catch (final Intent curLoc)
        {
            String s = VenueProximityService.LOG_TAG;
            StringBuilder stringbuilder = (new StringBuilder()).append("VenueLookup created exception(");
            int i = errorCount + 1;
            errorCount = i;
            LogUtils.logW(s, stringbuilder.append(i).append(")::\n").toString(), curLoc);
            if (errorCount > 2)
            {
                errorCount = 0;
                LogUtils.logE(VenueProximityService.LOG_TAG, "VenueLookup is lousy, shutting down VenueProximityService");
                VenueProximityManager.stopService(context);
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
    }




/*
    static int access$202(int i)
    {
        errorCount = i;
        return i;
    }

*/


/*
    static int access$208()
    {
        int i = errorCount;
        errorCount = i + 1;
        return i;
    }

*/
}
