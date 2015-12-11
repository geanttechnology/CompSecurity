// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.data;

import android.content.Context;
import com.exacttarget.etpushsdk.util.g;
import com.exacttarget.etpushsdk.util.m;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class LocationUpdate extends g
{

    protected static final String JF_ACCURACY = "accuracy";
    protected static final String JF_DEVICE_ID = "deviceId";
    protected static final String JF_ISO8601_LOCAL_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    protected static final String JF_LAST_SENT_TIME = "lastSent";
    protected static final String JF_LATITUDE = "latitude";
    protected static final String JF_LOCATION_DATE_TIME_UTC = "location_DateTime_Utc";
    protected static final String JF_LOCATION_ID = "id";
    protected static final String JF_LONGITUDE = "longitude";
    public static final String TAG = "~!LocationUpdate";
    private Integer accuracy;
    private String deviceId;
    private Integer id;
    private Long lastSent;
    private Double latitude;
    private Double longitude;
    private Date timestamp;

    public LocationUpdate()
    {
        lastSent = Long.valueOf(0L);
    }

    public LocationUpdate(Context context)
    {
        lastSent = Long.valueOf(0L);
        deviceId = uniqueDeviceIdentifier(context);
    }

    public Integer getAccuracy()
    {
        return accuracy;
    }

    public String getDeviceId()
    {
        return deviceId;
    }

    public Integer getId()
    {
        return id;
    }

    public Long getLastSent()
    {
        return lastSent;
    }

    public Double getLatitude()
    {
        return latitude;
    }

    public Double getLongitude()
    {
        return longitude;
    }

    public Date getTimestamp()
    {
        return timestamp;
    }

    public void setAccuracy(Integer integer)
    {
        accuracy = integer;
    }

    public void setDeviceId(String s)
    {
        deviceId = s;
    }

    public void setId(Integer integer)
    {
        id = integer;
    }

    public void setLastSent(Long long1)
    {
        lastSent = long1;
    }

    public void setLatitude(Double double1)
    {
        latitude = double1;
    }

    public void setLongitude(Double double1)
    {
        longitude = double1;
    }

    public void setTimestamp(Date date)
    {
        timestamp = date;
    }

    public String toJson()
    {
        Object obj;
        try
        {
            obj = new JSONObject();
            ((JSONObject) (obj)).put("accuracy", accuracy);
            ((JSONObject) (obj)).put("deviceId", deviceId);
            ((JSONObject) (obj)).put("id", id);
            ((JSONObject) (obj)).put("lastSent", lastSent);
            ((JSONObject) (obj)).put("latitude", latitude);
            ((JSONObject) (obj)).put("longitude", longitude);
            ((JSONObject) (obj)).put("location_DateTime_Utc", (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)).format(Long.valueOf(System.currentTimeMillis())));
            obj = ((JSONObject) (obj)).toString();
        }
        catch (JSONException jsonexception)
        {
            m.a("~!LocationUpdate", String.format("Error converting AnalyticItem to JSON: %1$s", new Object[] {
                jsonexception.getMessage()
            }), jsonexception);
            return null;
        }
        return ((String) (obj));
    }
}
