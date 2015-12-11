// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.data;

import android.content.Context;
import com.exacttarget.etpushsdk.util.d;
import com.exacttarget.etpushsdk.util.g;
import com.exacttarget.etpushsdk.util.m;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AnalyticItem extends g
{

    private Integer a;
    private String b;
    private String c;
    private Date d;
    private List e;
    private List f;
    private Integer g;
    private Long h;
    private Boolean i;
    private String j;

    public AnalyticItem()
    {
        e = new ArrayList();
        f = new ArrayList();
        h = Long.valueOf(0L);
        i = Boolean.FALSE;
        b = com.exacttarget.etpushsdk.util.d.b();
    }

    public AnalyticItem(Context context)
    {
        e = new ArrayList();
        f = new ArrayList();
        h = Long.valueOf(0L);
        i = Boolean.FALSE;
        c = uniqueDeviceIdentifier(context);
        b = com.exacttarget.etpushsdk.util.d.b();
    }

    public AnalyticItem(AnalyticItem analyticitem)
    {
        e = new ArrayList();
        f = new ArrayList();
        h = Long.valueOf(0L);
        i = Boolean.FALSE;
        a(analyticitem);
    }

    private void a(AnalyticItem analyticitem)
    {
        setEtAppId(analyticitem.getEtAppId());
        setDeviceId(analyticitem.getDeviceId());
        setEventDate(analyticitem.getEventDate());
        setAnalyticTypes(analyticitem.getAnalyticTypes());
        setObjectIds(analyticitem.getObjectIds());
        setValue(analyticitem.getValue());
        setLastSent(analyticitem.getLastSent());
        setReadyToSend(analyticitem.getReadyToSend());
        setPiAppKey(analyticitem.getPiAppKey());
    }

    public String a()
    {
        Object obj;
        try
        {
            obj = new JSONObject();
            ((JSONObject) (obj)).put("deviceId", c);
            ((JSONObject) (obj)).put("etAppId", b);
            ((JSONObject) (obj)).put("eventDate", (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)).format(d));
            ((JSONObject) (obj)).put("value", g);
            ((JSONObject) (obj)).put("piAppKey", j);
            ((JSONObject) (obj)).put("objectIds", new JSONArray(f));
            ((JSONObject) (obj)).put("analyticTypes", new JSONArray(e));
            obj = ((JSONObject) (obj)).toString();
        }
        catch (JSONException jsonexception)
        {
            m.a("~!AnalyticItem", String.format("Error converting AnalyticItem to JSON: %1$s", new Object[] {
                jsonexception.getMessage()
            }), jsonexception);
            return null;
        }
        return ((String) (obj));
    }

    public void a(int k)
    {
        e.add(Integer.valueOf(k));
    }

    public void a(String s)
    {
        f.add(s);
    }

    public List getAnalyticTypes()
    {
        return e;
    }

    public String getDeviceId()
    {
        return c;
    }

    public String getEtAppId()
    {
        return b;
    }

    public Date getEventDate()
    {
        return d;
    }

    public Integer getId()
    {
        return a;
    }

    public Long getLastSent()
    {
        return h;
    }

    public List getObjectIds()
    {
        return f;
    }

    public String getPiAppKey()
    {
        return j;
    }

    public Boolean getReadyToSend()
    {
        return i;
    }

    public Integer getValue()
    {
        return g;
    }

    public void setAnalyticTypes(List list)
    {
        e = new ArrayList(list);
    }

    public void setDeviceId(String s)
    {
        c = s;
    }

    public void setEtAppId(String s)
    {
        b = s;
    }

    public void setEventDate(Date date)
    {
        d = date;
    }

    public void setId(Integer integer)
    {
        a = integer;
    }

    public void setLastSent(Long long1)
    {
        h = long1;
    }

    public void setObjectIds(List list)
    {
        f = new ArrayList(list);
    }

    public void setPiAppKey(String s)
    {
        j = s;
    }

    public void setReadyToSend(Boolean boolean1)
    {
        i = boolean1;
    }

    public void setValue(Integer integer)
    {
        g = integer;
    }
}
