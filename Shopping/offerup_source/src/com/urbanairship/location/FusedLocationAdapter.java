// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.location;

import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.urbanairship.Logger;
import com.urbanairship.PendingResult;
import java.util.concurrent.Semaphore;

// Referenced classes of package com.urbanairship.location:
//            LocationAdapter, LocationRequestOptions

class FusedLocationAdapter
    implements LocationAdapter
{

    private GoogleApiClient client;
    private final Context context;

    FusedLocationAdapter(Context context1)
    {
        context = context1;
    }

    private LocationRequest createLocationRequest(LocationRequestOptions locationrequestoptions)
    {
        LocationRequest locationrequest = LocationRequest.create().setInterval(locationrequestoptions.getMinTime()).setSmallestDisplacement(locationrequestoptions.getMinDistance());
        switch (locationrequestoptions.getPriority())
        {
        default:
            return locationrequest;

        case 1: // '\001'
            locationrequest.setPriority(100);
            return locationrequest;

        case 2: // '\002'
            locationrequest.setPriority(102);
            return locationrequest;

        case 3: // '\003'
            locationrequest.setPriority(104);
            return locationrequest;

        case 4: // '\004'
            locationrequest.setPriority(105);
            break;
        }
        return locationrequest;
    }

    public void cancelLocationUpdates(PendingIntent pendingintent)
    {
        if (client == null || !client.isConnected())
        {
            Logger.debug("FusedLocationAdapter - Adapter is not connected. Unable to cancel location updates.");
            return;
        } else
        {
            Logger.verbose("FusedLocationAdapter - Canceling updates.");
            LocationServices.FusedLocationApi.removeLocationUpdates(client, pendingintent);
            return;
        }
    }

    public boolean connect()
    {
        final Object semaphore;
label0:
        {
            semaphore = new Semaphore(0);
            try
            {
                if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0)
                {
                    break label0;
                }
                Logger.debug("FusedLocationAdapter - Google Play services is currently unavailable, unable to connect for fused location.");
            }
            // Misplaced declaration of an exception variable
            catch (final Object semaphore)
            {
                Logger.debug((new StringBuilder("FusedLocationAdapter - Google Play services is currently unavailable, unable to connect for fused location. ")).append(((IllegalStateException) (semaphore)).getMessage()).toString());
                return false;
            }
            return false;
        }
        client = (new com.google.android.gms.common.api.GoogleApiClient.Builder(context)).addApi(LocationServices.API).addConnectionCallbacks(new _cls2()).addOnConnectionFailedListener(new _cls1()).build();
        client.connect();
        try
        {
            ((Semaphore) (semaphore)).acquire();
        }
        catch (InterruptedException interruptedexception)
        {
            Logger.error("FusedLocationAdapter - Exception while connecting to fused location", interruptedexception);
            client.disconnect();
            return false;
        }
        return client.isConnected();
    }

    public void disconnect()
    {
        if (client != null)
        {
            client.disconnect();
        }
    }

    public void requestLocationUpdates(LocationRequestOptions locationrequestoptions, PendingIntent pendingintent)
    {
        if (client == null || !client.isConnected())
        {
            Logger.debug("FusedLocationAdapter - Adapter is not connected. Unable to request location updates.");
            return;
        } else
        {
            Logger.verbose("FusedLocationAdapter - Requesting updates.");
            locationrequestoptions = createLocationRequest(locationrequestoptions);
            LocationServices.FusedLocationApi.requestLocationUpdates(client, locationrequestoptions, pendingintent);
            return;
        }
    }

    public PendingResult requestSingleLocation(LocationRequestOptions locationrequestoptions)
    {
        if (client == null || !client.isConnected())
        {
            Logger.debug("FusedLocationAdapter - Adapter is not connected. Unable to request single location.");
            return null;
        } else
        {
            return new SingleLocationRequest(locationrequestoptions);
        }
    }



    private class _cls2
        implements com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    {

        final FusedLocationAdapter this$0;
        final Semaphore val$semaphore;

        public void onConnected(Bundle bundle)
        {
            Logger.verbose("FusedLocationAdapter - Google Play services connected for fused location.");
            semaphore.release();
        }

        public void onConnectionSuspended(int i)
        {
            Logger.verbose("FusedLocationAdapter - Google Play services connection suspended for fused location.");
        }

        _cls2()
        {
            this$0 = FusedLocationAdapter.this;
            semaphore = semaphore1;
            super();
        }
    }


    private class _cls1
        implements com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    {

        final FusedLocationAdapter this$0;
        final Semaphore val$semaphore;

        public void onConnectionFailed(ConnectionResult connectionresult)
        {
            Logger.verbose("FusedLocationAdapter - Google Play services failed to connect for fused location.");
            semaphore.release();
        }

        _cls1()
        {
            this$0 = FusedLocationAdapter.this;
            semaphore = semaphore1;
            super();
        }
    }


    private class SingleLocationRequest extends PendingLocationResult
    {

        private final LocationListener fusedLocationListener;
        private final LocationRequest locationRequest;
        final FusedLocationAdapter this$0;

        protected void onCancel()
        {
            Logger.verbose("FusedLocationAdapter - Canceling single location request.");
            LocationServices.FusedLocationApi.removeLocationUpdates(client, fusedLocationListener);
        }

        SingleLocationRequest(LocationRequestOptions locationrequestoptions)
        {
            this$0 = FusedLocationAdapter.this;
            super();
            locationRequest = createLocationRequest(locationrequestoptions);
            locationRequest.setNumUpdates(1);
            class _cls1
                implements LocationListener
            {

                final SingleLocationRequest this$1;
                final FusedLocationAdapter val$this$0;

                public void onLocationChanged(Location location)
                {
                    setResult(location);
                }


// JavaClassFileOutputException: Invalid index accessing method local variables table of <init>
            }

            fusedLocationListener = new _cls1();
            Logger.verbose("FusedLocationAdapter - Starting single location request.");
            LocationServices.FusedLocationApi.requestLocationUpdates(client, locationRequest, fusedLocationListener, Looper.myLooper());
        }
    }

}
