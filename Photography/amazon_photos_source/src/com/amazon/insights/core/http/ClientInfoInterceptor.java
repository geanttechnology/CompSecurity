// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.http;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class ClientInfoInterceptor
    implements HttpClient.Interceptor
{
    static final class ClientInfo
    {

        private String carrier;
        private String manufacturer;
        private String model;
        private String networkType;
        private String os;
        private String osVersion;

        public String getCarrier()
        {
            return carrier;
        }

        public String getManufacturer()
        {
            return manufacturer;
        }

        public String getModel()
        {
            return model;
        }

        public String getNetworkType()
        {
            return networkType;
        }

        public String getOS()
        {
            return os;
        }

        public String getOSVersion()
        {
            return osVersion;
        }

        public void setCarrier(String s)
        {
            carrier = s;
        }

        public void setManufacturer(String s)
        {
            manufacturer = s;
        }

        public void setModel(String s)
        {
            model = s;
        }

        public void setNetworkType(String s)
        {
            networkType = s;
        }

        public void setOS(String s)
        {
            os = s;
        }

        public void setOSVersion(String s)
        {
            osVersion = s;
        }

        protected JSONObject toJsonObject()
        {
            JSONObject jsonobject = new JSONObject();
            try
            {
                jsonobject.put("os", getOS());
                jsonobject.put("osVersion", getOSVersion());
                jsonobject.put("model", getModel());
                jsonobject.put("manufacturer", getManufacturer());
                jsonobject.put("networkType", getNetworkType());
                jsonobject.put("carrier", getCarrier());
            }
            catch (JSONException jsonexception)
            {
                Log.w("ClientInfo", "Couldn't serialize clientInfo to a JSONObject");
                return jsonobject;
            }
            return jsonobject;
        }

        public String toString()
        {
            return toJsonObject().toString();
        }

        public ClientInfo()
        {
            this("Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown");
        }

        public ClientInfo(String s, String s1, String s2, String s3, String s4, String s5)
        {
            setOS(s);
            setOSVersion(s1);
            setModel(s2);
            setManufacturer(s3);
            setNetworkType(s4);
            setCarrier(s5);
        }
    }


    private Context context;

    public ClientInfoInterceptor(Context context1)
    {
        setContext(context1);
    }

    private ClientInfo getClientInfo()
    {
        ClientInfo clientinfo;
        clientinfo = new ClientInfo();
        clientinfo.setOS("Android");
        clientinfo.setOSVersion(android.os.Build.VERSION.RELEASE);
        clientinfo.setModel(Build.MODEL);
        clientinfo.setManufacturer(Build.MANUFACTURER);
        TelephonyManager telephonymanager = (TelephonyManager)getContext().getSystemService("phone");
        if (telephonymanager.getNetworkOperatorName() == null || telephonymanager.getNetworkOperatorName().equals("")) goto _L2; else goto _L1
_L1:
        clientinfo.setCarrier(telephonymanager.getNetworkOperatorName());
_L4:
        NetworkInfo networkinfo;
        Exception exception;
        try
        {
            networkinfo = ((ConnectivityManager)getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        }
        catch (Exception exception1)
        {
            clientinfo.setNetworkType("Unknown");
            return clientinfo;
        }
        if (networkinfo == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!networkinfo.isConnected() || !networkinfo.isAvailable())
        {
            break; /* Loop/switch isn't completed */
        }
        clientinfo.setNetworkType(networkinfo.getTypeName());
        return clientinfo;
_L2:
        try
        {
            clientinfo.setCarrier("Unknown");
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            clientinfo.setCarrier("Unknown");
        }
        if (true) goto _L4; else goto _L3
_L3:
        clientinfo.setNetworkType("Unknown");
        return clientinfo;
    }

    public void after(HttpClient.Response response)
    {
    }

    public void before(HttpClient.Request request)
    {
        if (request != null)
        {
            request.addHeader("x-amzn-ClientInfo", getClientInfo().toString());
        }
    }

    Context getContext()
    {
        return context;
    }

    void setContext(Context context1)
    {
        context = context1;
    }
}
