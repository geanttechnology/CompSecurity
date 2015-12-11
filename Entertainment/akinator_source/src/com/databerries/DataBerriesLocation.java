// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.databerries;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

// Referenced classes of package com.databerries:
//            LocationReceiver

class DataBerriesLocation
    implements com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener, ResultCallback
{

    private static final String TAG = "DataBerriesLocation";
    private static final int eventModulo = 30;
    private static final int maxCount = 1020;
    private static final int timeSpan = 10800;
    private final Context context;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    private final int minUpdateTime = 60;
    private final int updateTime = 300;

    public DataBerriesLocation(Context context1)
    {
        mLocationRequest = null;
        context = context1;
        buildGoogleApiClient();
        mGoogleApiClient.connect();
    }

    private void buildGoogleApiClient()
    {
        this;
        JVM INSTR monitorenter ;
        mGoogleApiClient = (new com.google.android.gms.common.api.GoogleApiClient.Builder(context)).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(LocationServices.API).build();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static int getEventModulo()
    {
        return 30;
    }

    static int getMaxCount()
    {
        return 1020;
    }

    static int getTimeSpan()
    {
        return 10800;
    }

    private void setLocationRequest()
        throws Exception
    {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(0x493e0L);
        mLocationRequest.setFastestInterval(60000L);
        mLocationRequest.setPriority(102);
        Log.d("DataBerriesLocation", "setLocationRequest");
    }

    public void onConnected(Bundle bundle)
    {
        Log.d("DataBerriesLocation", "Connected to GoogleApiClient");
        try
        {
            setLocationRequest();
            bundle = new Intent(context, com/databerries/LocationReceiver);
            bundle = PendingIntent.getBroadcast(context, 42, bundle, 0x10000000);
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            Log.e("DataBerries", "catch Exception in DataBerriesLocation's onConnected, maybe you don't have location permission");
        }
        bundle.printStackTrace();
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        Log.e("DataBerriesLocation", (new StringBuilder()).append("Connection failed: ConnectionResult.getErrorCode() = ").append(connectionresult.getErrorCode()).toString());
    }

    public void onConnectionSuspended(int i)
    {
        Log.d("DataBerriesLocation", "Connection suspended");
    }

    public volatile void onResult(Result result)
    {
        onResult((Status)result);
    }

    public void onResult(Status status)
    {
    }
}
