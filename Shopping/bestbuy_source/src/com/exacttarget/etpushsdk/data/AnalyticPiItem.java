// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.data;

import android.content.Context;
import android.text.TextUtils;
import com.exacttarget.etpushsdk.util.m;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

public class AnalyticPiItem
{

    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private Boolean g;
    private Double h;
    private Double i;
    private String j;
    private String k;
    private String l;
    private String m;
    private ArrayList n;
    private Context o;

    public AnalyticPiItem(Context context)
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        o = context;
        e = o.getPackageName();
        n = new ArrayList();
    }

    private void a(Date date)
    {
        JSON_Event json_event = new JSON_Event(null);
        json_event.a = "track_event";
        json_event.c = "app_close";
        json_event.b = new Date(date.getTime());
        n.add(json_event);
    }

    private void a(Date date, boolean flag)
    {
        JSON_Event json_event = new JSON_Event(null);
        json_event.a = "track_event";
        json_event.c = "app_open";
        json_event.b = new Date(date.getTime());
        json_event.d = Boolean.valueOf(flag);
        n.add(json_event);
    }

    public String a()
    {
        Object obj;
        JSONObject jsonobject;
        Object obj1;
        obj = new JSONObject();
        try
        {
            ((JSONObject) (obj)).put("api_key", a);
            ((JSONObject) (obj)).put("app_id", b);
            if (!TextUtils.isEmpty(c))
            {
                ((JSONObject) (obj)).put("user_id", c);
            }
            if (!TextUtils.isEmpty(d))
            {
                ((JSONObject) (obj)).put("session_id", d);
            }
            jsonobject = new JSONObject();
            jsonobject.put("app_name", e);
            obj1 = new JSONObject();
            ((JSONObject) (obj1)).put("device_id", f);
            Object obj2 = new JSONObject();
            ((JSONObject) (obj2)).put("push_enabled", g);
            ((JSONObject) (obj1)).put("details", obj2);
            if (h != null && i != null)
            {
                obj2 = new JSONObject();
                ((JSONObject) (obj2)).put("latitude", h);
                ((JSONObject) (obj2)).put("longitude", i);
                ((JSONObject) (obj1)).put("location", obj2);
            }
            obj2 = new JSONObject();
            ((JSONObject) (obj2)).put("manufacturer", j);
            ((JSONObject) (obj2)).put("platform", k);
            ((JSONObject) (obj2)).put("platform_version", l);
            ((JSONObject) (obj2)).put("device_type", m);
            ((JSONObject) (obj1)).put("device", obj2);
            jsonobject.put("user_info", obj1);
            obj1 = new JSONArray();
            obj2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
            ((SimpleDateFormat) (obj2)).setTimeZone(TimeZone.getTimeZone("UTC"));
            JSONObject jsonobject1;
            for (Iterator iterator = n.iterator(); iterator.hasNext(); ((JSONArray) (obj1)).put(jsonobject1))
            {
                JSON_Event json_event = (JSON_Event)iterator.next();
                jsonobject1 = new JSONObject();
                jsonobject1.put("api_endpoint", json_event.a);
                jsonobject1.put("timestamp", ((SimpleDateFormat) (obj2)).format(json_event.b));
                jsonobject1.put("event_name", json_event.c);
                if (json_event.c.equals("app_open"))
                {
                    JSONObject jsonobject2 = new JSONObject();
                    jsonobject2.put("open_from_push", json_event.d);
                    jsonobject1.put("details", jsonobject2);
                }
            }

        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.exacttarget.etpushsdk.util.m.c("~!AnalyticPIItem", ((Exception) (obj)).getMessage(), ((Throwable) (obj)));
            return null;
        }
        jsonobject.put("events", obj1);
        ((JSONObject) (obj)).put("payload", jsonobject);
        return ((JSONObject) (obj)).toString();
    }

    public void a(Date date, Date date1, boolean flag)
    {
        a(date, flag);
        a(date1);
    }

    public String getApiKey()
    {
        return a;
    }

    public String getAppId()
    {
        return b;
    }

    public String getDeviceId()
    {
        return f;
    }

    public String getDeviceType()
    {
        return m;
    }

    public double getLatitude()
    {
        return h.doubleValue();
    }

    public double getLongitude()
    {
        return i.doubleValue();
    }

    public String getManufacturer()
    {
        return j;
    }

    public String getPlatform()
    {
        return k;
    }

    public String getPlatformVersion()
    {
        return l;
    }

    public Boolean getPushEnabled()
    {
        return g;
    }

    public String getSessionId()
    {
        return d;
    }

    public String getUserId()
    {
        return c;
    }

    public void setApiKey(String s)
    {
        a = s;
    }

    public void setAppId(String s)
    {
        b = s;
    }

    public String setDeviceId(String s)
    {
        f = s;
        return s;
    }

    public void setDeviceType(String s)
    {
        m = s;
    }

    public void setLatitude(double d1)
    {
        h = Double.valueOf(d1);
    }

    public void setLongitude(double d1)
    {
        i = Double.valueOf(d1);
    }

    public void setManufacturer(String s)
    {
        j = s;
    }

    public void setPlatform(String s)
    {
        k = s;
    }

    public void setPlatformVersion(String s)
    {
        l = s;
    }

    public void setPushEnabled(Boolean boolean1)
    {
        g = boolean1;
    }

    public void setSessionId(String s)
    {
        d = s;
    }

    public void setUserId(String s)
    {
        c = s;
    }

    private class JSON_Event
    {

        public String a;
        public Date b;
        public String c;
        public Boolean d;
        final AnalyticPiItem e;

        private JSON_Event()
        {
            e = AnalyticPiItem.this;
            super();
            a = "";
            b = null;
            c = "";
            d = null;
        }

        JSON_Event(_cls1 _pcls1)
        {
            this();
        }
    }

}
