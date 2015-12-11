// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.internal.er;
import com.google.android.gms.internal.hi;
import com.google.android.gms.internal.hj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.location:
//            Geofence, LocationListener, LocationRequest

public class LocationClient
    implements GooglePlayServicesClient
{
    public static interface OnAddGeofencesResultListener
    {

        public abstract void onAddGeofencesResult(int i, String as[]);
    }

    public static interface OnRemoveGeofencesResultListener
    {

        public abstract void onRemoveGeofencesByPendingIntentResult(int i, PendingIntent pendingintent);

        public abstract void onRemoveGeofencesByRequestIdsResult(int i, String as[]);
    }


    public static final String KEY_LOCATION_CHANGED = "com.google.android.location.LOCATION";
    public static final String KEY_MOCK_LOCATION = "mockLocation";
    private final hi KO;

    public LocationClient(Context context, com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        KO = new hi(context, connectioncallbacks, onconnectionfailedlistener, "location");
    }

    public static int getErrorCode(Intent intent)
    {
        return intent.getIntExtra("gms_error_code", -1);
    }

    public static int getGeofenceTransition(Intent intent)
    {
        int i;
        for (i = intent.getIntExtra("com.google.android.location.intent.extra.transition", -1); i == -1 || i != 1 && i != 2 && i != 4;)
        {
            return -1;
        }

        return i;
    }

    public static List getTriggeringGeofences(Intent intent)
    {
        Object obj = (ArrayList)intent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
        if (obj == null)
        {
            return null;
        }
        intent = new ArrayList(((ArrayList) (obj)).size());
        for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); intent.add(hj.h((byte[])((Iterator) (obj)).next()))) { }
        return intent;
    }

    public static boolean hasError(Intent intent)
    {
        return intent.hasExtra("gms_error_code");
    }

    public void addGeofences(List list, PendingIntent pendingintent, OnAddGeofencesResultListener onaddgeofencesresultlistener)
    {
        ArrayList arraylist = null;
        if (list != null)
        {
            arraylist = new ArrayList();
            Geofence geofence;
            for (list = list.iterator(); list.hasNext(); arraylist.add((hj)geofence))
            {
                geofence = (Geofence)list.next();
                er.b(geofence instanceof hj, "Geofence must be created using Geofence.Builder.");
            }

        }
        KO.addGeofences(arraylist, pendingintent, onaddgeofencesresultlistener);
    }

    public void connect()
    {
        KO.connect();
    }

    public void disconnect()
    {
        KO.disconnect();
    }

    public Location getLastLocation()
    {
        return KO.getLastLocation();
    }

    public boolean isConnected()
    {
        return KO.isConnected();
    }

    public boolean isConnecting()
    {
        return KO.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
    {
        return KO.isConnectionCallbacksRegistered(connectioncallbacks);
    }

    public boolean isConnectionFailedListenerRegistered(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        return KO.isConnectionFailedListenerRegistered(onconnectionfailedlistener);
    }

    public void registerConnectionCallbacks(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
    {
        KO.registerConnectionCallbacks(connectioncallbacks);
    }

    public void registerConnectionFailedListener(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        KO.registerConnectionFailedListener(onconnectionfailedlistener);
    }

    public void removeGeofences(PendingIntent pendingintent, OnRemoveGeofencesResultListener onremovegeofencesresultlistener)
    {
        KO.removeGeofences(pendingintent, onremovegeofencesresultlistener);
    }

    public void removeGeofences(List list, OnRemoveGeofencesResultListener onremovegeofencesresultlistener)
    {
        KO.removeGeofences(list, onremovegeofencesresultlistener);
    }

    public void removeLocationUpdates(PendingIntent pendingintent)
    {
        KO.removeLocationUpdates(pendingintent);
    }

    public void removeLocationUpdates(LocationListener locationlistener)
    {
        KO.removeLocationUpdates(locationlistener);
    }

    public void requestLocationUpdates(LocationRequest locationrequest, PendingIntent pendingintent)
    {
        KO.requestLocationUpdates(locationrequest, pendingintent);
    }

    public void requestLocationUpdates(LocationRequest locationrequest, LocationListener locationlistener)
    {
        KO.requestLocationUpdates(locationrequest, locationlistener);
    }

    public void requestLocationUpdates(LocationRequest locationrequest, LocationListener locationlistener, Looper looper)
    {
        KO.requestLocationUpdates(locationrequest, locationlistener, looper);
    }

    public void setMockLocation(Location location)
    {
        KO.setMockLocation(location);
    }

    public void setMockMode(boolean flag)
    {
        KO.setMockMode(flag);
    }

    public void unregisterConnectionCallbacks(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
    {
        KO.unregisterConnectionCallbacks(connectioncallbacks);
    }

    public void unregisterConnectionFailedListener(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        KO.unregisterConnectionFailedListener(onconnectionfailedlistener);
    }
}
