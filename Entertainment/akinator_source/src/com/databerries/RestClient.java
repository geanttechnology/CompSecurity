// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.databerries;

import android.content.Context;
import android.util.Log;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.ResponseHandlerInterface;
import com.loopj.android.http.SyncHttpClient;
import cz.msebera.android.httpclient.entity.StringEntity;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.databerries:
//            LocationData, DeviceInfo, Protocol

class RestClient
{

    private static final String DEVICE_URL = "/device/";
    private static final String LOCATION_URL = "/event/location/";
    static final String SDK_VERSION = "1.6.1";
    private static final String TAG = "DataBerriesRestClient";
    private static final String URL_PROD = "://v1.blueberry.cloud.databerries.com/mobile_backend";
    private static final String URL_STAGING = "://v1.blueberry.staging.databerries.com/mobile_backend";
    private static final AsyncHttpClient client = new AsyncHttpClient();
    private static final SyncHttpClient clientSynch = new SyncHttpClient();
    private static final boolean use_staging = false;

    RestClient()
    {
    }

    static void postDevice(String s, String s1, AsyncHttpResponseHandler asynchttpresponsehandler)
        throws Exception
    {
        setHeaders(s, s1);
        Log.d("DataBerriesRestClient", "Register device");
        client.post(setUrlForPostId(s), asynchttpresponsehandler);
    }

    static void postEventLocation(Context context, ResponseHandlerInterface responsehandlerinterface, String s, String s1, List list)
        throws Exception
    {
        setSynchHeaders(s, s1);
        s = new JSONArray();
        Log.d("post", "post location");
        for (int i = 0; i < list.size(); i++)
        {
            s1 = new JSONObject();
            s1.put("latitude", ((LocationData)list.get(i)).get_latitude());
            s1.put("longitude", ((LocationData)list.get(i)).get_longitude());
            s1.put("radius", ((LocationData)list.get(i)).get_accuracy());
            s1.put("timestamp", ((LocationData)list.get(i)).get_date());
            s1.put("uuid", ((LocationData)list.get(i)).get_uuid());
            s.put(s1);
        }

        try
        {
            s = new StringEntity(s.toString());
            clientSynch.post(context, (new StringBuilder()).append(DeviceInfo.getProtocol().toString()).append("://v1.blueberry.cloud.databerries.com/mobile_backend").append("/event/location/").toString(), s, "application/json", responsehandlerinterface);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }

    private static void setHeaders(String s, String s1)
    {
        String s2 = DeviceInfo.getAndroidVersion();
        client.addHeader("device", s);
        client.addHeader("operating-system", "android");
        client.addHeader("device-bluetooth", "false");
        client.addHeader("device-version", s2);
        client.addHeader("app-key", s1);
        client.addHeader("sdk-version", "1.6.1");
    }

    private static void setSynchHeaders(String s, String s1)
    {
        String s2 = DeviceInfo.getAndroidVersion();
        clientSynch.addHeader("device", s);
        clientSynch.addHeader("operating-system", "android");
        clientSynch.addHeader("device-bluetooth", "false");
        clientSynch.addHeader("device-version", s2);
        clientSynch.addHeader("app-key", s1);
        clientSynch.addHeader("sdk-version", "1.6.1");
    }

    private static String setUrlForPostId(String s)
    {
        return (new StringBuilder()).append(DeviceInfo.getProtocol().toString()).append("://v1.blueberry.cloud.databerries.com/mobile_backend").append("/device/").append(s).append("/").toString();
    }

}
