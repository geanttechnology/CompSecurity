// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.google_api;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.LocationServices;
import java.util.ArrayList;
import java.util.List;
import roboguice.util.Ln;

public class GeofenceSetter
    implements com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
{

    private Context context;
    private List currentGeofences;
    private PendingIntent geofencePendingIntent;
    private boolean inProgress;
    private GoogleApiClient locationClient;

    public GeofenceSetter()
    {
        geofencePendingIntent = null;
        locationClient = null;
        inProgress = false;
    }

    private void afterConnected()
    {
        geofencePendingIntent = createRequestPendingIntent();
        LocationServices.GeofencingApi.removeGeofences(locationClient, geofencePendingIntent).setResultCallback(new ResultCallback() {

            final GeofenceSetter this$0;

            public volatile void onResult(Result result)
            {
                onResult((Status)result);
            }

            public void onResult(Status status)
            {
                Ln.d((new StringBuilder()).append("Proximity_Notifications - GeofenceSetter: Removed geofences : ").append(status.isSuccess()).toString(), new Object[0]);
                onRemoveGeofencesByPendingIntentResult(status.getStatusCode(), null);
            }

            
            {
                this$0 = GeofenceSetter.this;
                super();
            }
        });
    }

    private void afterGeofencesRemoved()
    {
        geofencePendingIntent = createRequestPendingIntent();
        if (currentGeofences.size() > 0)
        {
            LocationServices.GeofencingApi.addGeofences(locationClient, currentGeofences, geofencePendingIntent).setResultCallback(new ResultCallback() {

                final GeofenceSetter this$0;

                public volatile void onResult(Result result)
                {
                    onResult((Status)result);
                }

                public void onResult(Status status)
                {
                    Ln.d((new StringBuilder()).append("Proximity_Notifications - GeofenceSetter: Added geofences : ").append(status.isSuccess()).toString(), new Object[0]);
                    onAddGeofencesResult(status.getStatusCode(), null);
                }

            
            {
                this$0 = GeofenceSetter.this;
                super();
            }
            });
            return;
        } else
        {
            requestDisconnection();
            return;
        }
    }

    private PendingIntent createRequestPendingIntent()
    {
        if (geofencePendingIntent != null)
        {
            return geofencePendingIntent;
        } else
        {
            Intent intent = new Intent("com.groupon.ACTION_RECEIVE_GEOFENCE");
            return PendingIntent.getBroadcast(context, 0, intent, 0x8000000);
        }
    }

    private GoogleApiClient getLocationClient()
    {
        if (locationClient == null)
        {
            locationClient = (new com.google.android.gms.common.api.GoogleApiClient.Builder(context)).addApi(LocationServices.API).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
        }
        return locationClient;
    }

    private void requestConnection()
    {
        getLocationClient().connect();
    }

    private void requestDisconnection()
    {
        inProgress = false;
        getLocationClient().disconnect();
    }

    public void clearGeofences()
    {
        setGeofences(new ArrayList());
    }

    public void onAddGeofencesResult(int i, String as[])
    {
        requestDisconnection();
    }

    public void onConnected(Bundle bundle)
    {
        afterConnected();
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        inProgress = false;
    }

    public void onConnectionSuspended(int i)
    {
        requestDisconnection();
    }

    public void onDisconnected()
    {
        inProgress = false;
        locationClient = null;
    }

    public void onRemoveGeofencesByPendingIntentResult(int i, PendingIntent pendingintent)
    {
        if (i == 0)
        {
            afterGeofencesRemoved();
            return;
        } else
        {
            requestDisconnection();
            return;
        }
    }

    public void setGeofences(List list)
        throws UnsupportedOperationException
    {
        currentGeofences = (ArrayList)list;
        if (!inProgress)
        {
            inProgress = true;
            requestConnection();
            return;
        } else
        {
            throw new UnsupportedOperationException();
        }
    }
}
