// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.http;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.insights.core.http:
//            ClientInfoInterceptor

static final class setCarrier
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

    public ()
    {
        this("Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown");
    }

    public <init>(String s, String s1, String s2, String s3, String s4, String s5)
    {
        setOS(s);
        setOSVersion(s1);
        setModel(s2);
        setManufacturer(s3);
        setNetworkType(s4);
        setCarrier(s5);
    }
}
