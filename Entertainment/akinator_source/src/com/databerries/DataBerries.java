// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.databerries;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.loopj.android.http.AsyncHttpResponseHandler;
import cz.msebera.android.httpclient.Header;
import java.io.IOException;

// Referenced classes of package com.databerries:
//            DeviceInfo, Protocol, DataBerriesLocation, RestClient

public class DataBerries
{

    private static final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 0xc508ca;
    private static final String TAG = "DataBerriesRestClient";
    private static com.google.android.gms.ads.identifier.AdvertisingIdClient.Info adInfo;
    private static Application application;
    private static DataBerries instance = null;
    private static String key;
    private static Boolean useHttps;
    private Context context;
    private DataBerriesLocation dataBerriesLocation;

    private DataBerries(String s, Application application1, Boolean boolean1)
    {
        try
        {
            boolean1 = convertUseHttpsToProtocol(boolean1);
            application = application1;
            context = application1.getApplicationContext();
            DeviceInfo.setProtocol(boolean1);
            DeviceInfo.setKey(s);
            registerDevice();
            DeviceInfo.findAdInfo(application1.getApplicationContext(), this);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.d("DataBerriesRestClient", "catch dataBerries");
        }
        s.printStackTrace();
    }

    public static Boolean checkLocationPermission(Context context1)
    {
        boolean flag = true;
        Boolean boolean1 = Boolean.valueOf(true);
        Context context2 = context1.getApplicationContext();
        context1 = boolean1;
        if (android.os.Build.VERSION.SDK_INT >= 23)
        {
            if (context2.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
            {
                flag = false;
            }
            context1 = Boolean.valueOf(flag);
        }
        return context1;
    }

    private Protocol convertUseHttpsToProtocol(Boolean boolean1)
    {
label0:
        {
            Protocol protocol = Protocol.HTTP;
            if (boolean1 != null)
            {
                if (!boolean1.booleanValue())
                {
                    break label0;
                }
                protocol = Protocol.HTTPS;
            }
            return protocol;
        }
        return Protocol.HTTP;
    }

    private static com.google.android.gms.ads.identifier.AdvertisingIdClient.Info getIdInfoInThread(Context context1)
    {
        try
        {
            context1 = AdvertisingIdClient.getAdvertisingIdInfo(context1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context1)
        {
            context1.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Context context1)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Context context1)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Context context1)
        {
            return null;
        }
        return context1;
    }

    public static String getSdkVersion()
    {
        return "1.6.1";
    }

    public static void initialize(Activity activity)
    {
        try
        {
            initializeAll(null, null, activity, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            Log.d("DataBerriesRestClient", "Error at initialization");
        }
        Log.d("DataBerriesRestClient", Log.getStackTraceString(activity));
    }

    public static void initialize(String s, Application application1)
    {
        try
        {
            initializeAll(s, application1, null, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.d("DataBerriesRestClient", "Error at initialization");
        }
        Log.d("DataBerriesRestClient", Log.getStackTraceString(s));
    }

    public static void initialize(String s, Application application1, Boolean boolean1)
    {
        try
        {
            initializeAll(s, application1, null, boolean1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.d("DataBerriesRestClient", "Error at initialization");
        }
        Log.d("DataBerriesRestClient", Log.getStackTraceString(s));
    }

    private static void initializeAll(String s, Application application1, Activity activity, Boolean boolean1)
    {
label0:
        {
            if (s != null)
            {
                key = s;
            }
            if (application1 != null)
            {
                application = application1;
            }
            if (boolean1 != null)
            {
                useHttps = boolean1;
            }
            if (instance == null)
            {
                if (!checkLocationPermission(application).booleanValue())
                {
                    break label0;
                }
                instance = new DataBerries(s, application1, boolean1);
            }
            return;
        }
        Log.d("DataBerriesRestClient", "The SDK does not have the location permission.");
        if (activity != null)
        {
            requestPermission(activity);
            return;
        } else
        {
            Log.d("DataBerriesRestClient", "No permissions for location and no activity handler to request it. SDK won't be initialized right now.");
            return;
        }
    }

    public static void onRequestPermissionsResult(int i, String as[], int ai[])
    {
        if (i != 0xc508ca || ai[0] != 0)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        initializeAll(key, application, null, useHttps);
        return;
        as;
        Log.d("DataBerriesRestClient", "Error at permission check.");
        Log.d("DataBerriesRestClient", Log.getStackTraceString(as));
        return;
    }

    private void registerDevice()
    {
        (new Thread(new Runnable() {

            final DataBerries this$0;
            final AsyncHttpResponseHandler val$responseHandler;

            public void run()
            {
                try
                {
                    DataBerries.adInfo = DataBerries.getIdInfoInThread(context);
                    if (DataBerries.adInfo != null && !DataBerries.adInfo.isLimitAdTrackingEnabled())
                    {
                        String s = DeviceInfo.getKey();
                        RestClient.postDevice(DataBerries.adInfo.getId(), s, responseHandler);
                    }
                    return;
                }
                catch (Exception exception)
                {
                    Log.d("DataBerriesRestClient", "catch Exception in Databerries registerDevice");
                    exception.printStackTrace();
                    return;
                }
            }

            
            {
                this$0 = DataBerries.this;
                responseHandler = asynchttpresponsehandler;
                super();
            }
        })).start();
    }

    private static void requestPermission(Activity activity)
    {
        if (android.os.Build.VERSION.SDK_INT >= 23)
        {
            activity.requestPermissions(new String[] {
                "android.permission.ACCESS_FINE_LOCATION"
            }, 0xc508ca);
        }
    }

    void adInfoCallback()
    {
        try
        {
            dataBerriesLocation = new DataBerriesLocation(application.getApplicationContext());
            Log.d("DataBerriesRestClient", "DataBerries SDK successfully initialized.");
            return;
        }
        catch (Exception exception)
        {
            Log.d("DataBerriesRestClient", "catch DataberriesLocation");
            exception.printStackTrace();
            return;
        }
    }




/*
    static com.google.android.gms.ads.identifier.AdvertisingIdClient.Info access$002(com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info)
    {
        adInfo = info;
        return info;
    }

*/



    // Unreferenced inner class com/databerries/DataBerries$1

/* anonymous class */
    class _cls1 extends AsyncHttpResponseHandler
    {

        final DataBerries this$0;

        public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
        {
        }

        public void onSuccess(int i, Header aheader[], byte abyte0[])
        {
        }

            
            {
                this$0 = DataBerries.this;
                super();
            }
    }

}
