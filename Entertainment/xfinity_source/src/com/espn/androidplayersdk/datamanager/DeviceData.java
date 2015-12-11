// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import android.os.AsyncTask;
import android.os.Build;
import com.espn.androidplayersdk.utilities.Utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import org.apache.http.HttpEntity;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            EPSDKPrefs, FeedsServerCom, FeedsCommListener

class DeviceData
{
    class DeviceDataTask extends AsyncTask
    {

        FeedsCommListener DeviceDataListener;
        FeedsServerCom feedsServerCom;
        String msg;
        final DeviceData this$0;
        String url;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            Utils.sdkLog("Device not identified. Initiating ID task", 2, null);
            url = "https://authorization.go.com/token";
            msg = "client_id=DTSS-DEVICE.DATA.WATCH.ESPN.ANDROID-PROD&client_secret=859517d7b6f33154bd9b5b74ca528a9a&grant_type=client_credentials&scope=mcon-devicedata-oneshot";
            avoid = new HashMap();
            avoid.put("POSTMSG", msg);
            feedsServerCom.execTask(url, 3, 5, DeviceDataListener, avoid);
            return null;
        }

        JSONObject getRequest(String s)
        {
            String s1;
            String s2;
            s2 = null;
            s1 = null;
            s = (new URL(s)).openConnection().getInputStream();
            s1 = s;
            s2 = s;
            Object obj = new BufferedReader(new InputStreamReader(s));
            s1 = s;
            s2 = s;
            StringBuilder stringbuilder = new StringBuilder();
_L2:
            s1 = s;
            s2 = s;
            String s3 = ((BufferedReader) (obj)).readLine();
            if (s3 != null)
            {
                break MISSING_BLOCK_LABEL_98;
            }
            s1 = s;
            s2 = s;
            obj = new JSONObject(stringbuilder.toString());
            if (s != null)
            {
                try
                {
                    s.close();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    Utils.sdkLog("Error: Device ID failed", 5, s);
                    return ((JSONObject) (obj));
                }
            }
            return ((JSONObject) (obj));
            s1 = s;
            s2 = s;
            stringbuilder.append((new StringBuilder(String.valueOf(s3))).append("\n").toString());
            if (true) goto _L2; else goto _L1
_L1:
            s;
            s2 = s1;
            Utils.sdkLog("Error: Device ID failed", 5, s);
            if (s1 != null)
            {
                try
                {
                    s1.close();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    Utils.sdkLog("Error: Device ID failed", 5, s);
                }
            }
            return null;
            s;
            if (s2 != null)
            {
                try
                {
                    s2.close();
                }
                catch (IOException ioexception)
                {
                    Utils.sdkLog("Error: Device ID failed", 5, ioexception);
                }
            }
            throw s;
        }

        public DeviceDataTask()
        {
            this$0 = DeviceData.this;
            super();
            url = "";
            msg = "";
            DeviceDataListener = new _cls1();
            feedsServerCom = new FeedsServerCom();
        }
    }


    static final String HANDHELD = "handset";
    static final String TABLET = "tablet";
    private final String AUTH_URL = "https://authorization.go.com/token";
    private final String BASE_URL = "http://api.devicedata.go.com/deviceDataWS/rs/composite-views/deviceatlas/devices/oneshot?oauth_token=";
    private final String CLIENT_ID = "DTSS-DEVICE.DATA.WATCH.ESPN.ANDROID-PROD";
    private final String CLIENT_SCOPE = "mcon-devicedata-oneshot";
    private final String CLIENT_SECRET = "859517d7b6f33154bd9b5b74ca528a9a";

    DeviceData()
    {
    }

    private static boolean checkModelSupported()
    {
        return isAmazonSTB();
    }

    protected static void getDeviceType()
    {
        Utils.sdkLog("Device Data requested", 2, null);
        if (!(new EPSDKPrefs()).getBooleanField("config", "isDeviceIdentified", false))
        {
            if (checkModelSupported())
            {
                (new EPSDKPrefs()).putBooleanField("config", "isDeviceIdentified", true);
                (new EPSDKPrefs()).putField("config", "deviceType", getDeviceTypeByModel());
                return;
            } else
            {
                DeviceData devicedata = new DeviceData();
                devicedata.getClass();
                (devicedata. new DeviceDataTask()).execute(new Void[0]);
                return;
            }
        } else
        {
            Utils.sdkLog("Device already identified", 2, null);
            return;
        }
    }

    private static String getDeviceTypeByModel()
    {
        if (isAmazonSTB())
        {
            return "tablet";
        } else
        {
            return "handset";
        }
    }

    private static boolean isAmazonSTB()
    {
        return Build.MODEL.toLowerCase().startsWith("aftb");
    }

    protected static void overrideDeviceType(String s)
    {
        Utils.sdkLog((new StringBuilder("Overriding Device Type As: ")).append(s).toString(), 2, null);
        (new EPSDKPrefs()).putBooleanField("config", "isDeviceIdentified", true);
        (new EPSDKPrefs()).putBooleanField("config", "deviceOverride", true);
        (new EPSDKPrefs()).putField("config", "deviceType", s);
    }

    // Unreferenced inner class com/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask$1

/* anonymous class */
    class DeviceDataTask._cls1
        implements FeedsCommListener
    {

        final DeviceDataTask this$1;

        public void handleError(int i)
        {
            Utils.sdkLog("Device ID failed. Setting defaults.", 2, null);
            (new EPSDKPrefs()).putBooleanField("config", "isDeviceIdentified", false);
            (new EPSDKPrefs()).putField("config", "deviceType", "handset");
        }

        public void update(HttpEntity httpentity, String s)
        {
        }

        public void update(JSONObject jsonobject, String s, HashMap hashmap)
        {
            if (!jsonobject.has("access_token") || jsonobject.isNull("access_token"))
            {
                break MISSING_BLOCK_LABEL_228;
            }
            Utils.sdkLog("Device token success. Requesting device ID", 2, null);
            jsonobject = (new StringBuilder("http://api.devicedata.go.com/deviceDataWS/rs/composite-views/deviceatlas/devices/oneshot?oauth_token=")).append(jsonobject.getString("access_token")).toString();
            jsonobject = getRequest(jsonobject);
            if (jsonobject == null)
            {
                break MISSING_BLOCK_LABEL_222;
            }
            if (!jsonobject.has("capabilities") || jsonobject.isNull("capabilities"))
            {
                break MISSING_BLOCK_LABEL_222;
            }
            Utils.sdkLog("Device Data received", 2, null);
            jsonobject = jsonobject.getJSONObject("capabilities");
            if (!jsonobject.has("isTablet") && jsonobject.isNull("isTablet"))
            {
                break MISSING_BLOCK_LABEL_216;
            }
            if ("1".equalsIgnoreCase(jsonobject.getString("isTablet")))
            {
                Utils.sdkLog("Device is a tablet", 2, null);
                (new EPSDKPrefs()).putBooleanField("config", "isDeviceIdentified", true);
                (new EPSDKPrefs()).putField("config", "deviceType", "tablet");
                return;
            }
            try
            {
                Utils.sdkLog("Device is a phone", 2, null);
                (new EPSDKPrefs()).putBooleanField("config", "isDeviceIdentified", true);
                (new EPSDKPrefs()).putField("config", "deviceType", "handset");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                Utils.sdkLog("Error: Device ID failed", 5, jsonobject);
            }
            handleError(0);
            return;
            handleError(0);
            return;
            handleError(0);
            return;
            handleError(0);
            return;
        }

            
            {
                this$1 = DeviceDataTask.this;
                super();
            }
    }

}
