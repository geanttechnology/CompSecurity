// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.databerries;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.ResponseHandlerInterface;
import cz.msebera.android.httpclient.Header;
import java.sql.SQLException;
import java.util.UUID;

// Referenced classes of package com.databerries:
//            LocationDataHandler, DataBerriesLocation, DeviceInfo, RestClient

public class LocationReceiver extends BroadcastReceiver
{

    protected static final String TAG = "DataBerriesLocation";
    protected Context mcontext;
    protected Location mloc;

    public LocationReceiver()
    {
        mloc = null;
    }

    private boolean checkPosting(LocationDataHandler locationdatahandler)
    {
        int i = locationdatahandler.getFirstDate();
        return locationdatahandler.getLastDate() - i >= DataBerriesLocation.getTimeSpan() && locationdatahandler.countLocations() != 0 && locationdatahandler.countLocations() % DataBerriesLocation.getEventModulo() == 0;
    }

    private void dumpLocationDataBase(Context context, ResponseHandlerInterface responsehandlerinterface)
        throws Exception
    {
        LocationDataHandler locationdatahandler = new LocationDataHandler(context);
        String s = DeviceInfo.getAdvertiserId();
        String s1 = DeviceInfo.getKey();
        try
        {
            locationdatahandler.open();
        }
        catch (SQLException sqlexception)
        {
            sqlexception.printStackTrace();
        }
        RestClient.postEventLocation(context, responsehandlerinterface, s, s1, locationdatahandler.getAllLocations());
        locationdatahandler.close();
    }

    public void onReceive(final Context context, final Intent LocationHandler)
    {
        Log.d("DataBerriesLocation", "Location received");
        String s;
        long l;
        try
        {
            LocationHandler = (Location)LocationHandler.getExtras().get("com.google.android.location.LOCATION");
        }
        // Misplaced declaration of an exception variable
        catch (final Context context)
        {
            Log.d("DataBerries", "catch Exception in LocationReceiver's OnReceive");
            context.printStackTrace();
            return;
        }
        if (LocationHandler == null)
        {
            break MISSING_BLOCK_LABEL_186;
        }
        if (!DeviceInfo.hasAdvertiserId())
        {
            return;
        }
        mcontext = context;
        mloc = LocationHandler;
        LocationHandler = new LocationDataHandler(context);
        LocationHandler.open();
_L1:
        l = System.currentTimeMillis() / 1000L;
        if (LocationHandler.countLocations() >= DataBerriesLocation.getMaxCount())
        {
            LocationHandler.deleteSomeLocations();
        }
        s = UUID.randomUUID().toString();
        LocationHandler.addLocation(mloc.getLongitude(), mloc.getLatitude(), mloc.getAccuracy(), Integer.valueOf(String.valueOf(l)).intValue(), s);
        if (!checkPosting(LocationHandler))
        {
            LocationHandler.close();
            return;
        }
        break MISSING_BLOCK_LABEL_157;
        SQLException sqlexception;
        sqlexception;
        sqlexception.printStackTrace();
          goto _L1
        (new Thread(new Runnable() {

            final LocationReceiver this$0;
            final Context val$context;
            final ResponseHandlerInterface val$responseHandler;

            public void run()
            {
                try
                {
                    dumpLocationDataBase(context, responseHandler);
                    return;
                }
                catch (Exception exception)
                {
                    Log.d("DataBerries", "catch exception in LocationReceiver's onReceive");
                    exception.printStackTrace();
                    return;
                }
            }

            
            {
                this$0 = LocationReceiver.this;
                context = context1;
                responseHandler = responsehandlerinterface;
                super();
            }
        })).start();
        return;
        Log.d("DataBerriesLocation", "Location is null. Skip.");
        return;
    }


    // Unreferenced inner class com/databerries/LocationReceiver$1

/* anonymous class */
    class _cls1 extends AsyncHttpResponseHandler
    {

        final LocationReceiver this$0;
        final LocationDataHandler val$LocationHandler;

        public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
        {
            LocationHandler.close();
        }

        public void onSuccess(int i, Header aheader[], byte abyte0[])
        {
            LocationHandler.deleteAllLocations();
            LocationHandler.close();
        }

            
            {
                this$0 = LocationReceiver.this;
                LocationHandler = locationdatahandler;
                super();
            }
    }

}
