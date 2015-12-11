// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.json.JSONObject;

// Referenced classes of package com.paypal.android.sdk:
//            ci, ck, a, dd, 
//            bf, ch, ac

public class be extends ci
{

    private final bf a;

    public be(ch ch, ck ck1, ac ac, bf bf1)
    {
        super(ch, ck1, ac, null);
        a = bf1;
        a("Accept", "application/json; charset=utf-8");
        a("Accept-Language", "en_US");
        a("Content-Type", "application/json");
    }

    private static JSONObject a(Map map)
    {
        JSONObject jsonobject = new JSONObject();
        String s;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); jsonobject.accumulate(s, map.get(s)))
        {
            s = (String)iterator.next();
        }

        return jsonobject;
    }

    public final String a(ch ch)
    {
        return "https://api.paypal.com/v1/tracking/events";
    }

    public final boolean a()
    {
        return true;
    }

    public final String b()
    {
        Object obj = dd.a(s().d().e());
        String s = a.a;
        JSONObject jsonobject1 = new JSONObject();
        jsonobject1.accumulate("tracking_visitor_id", obj);
        jsonobject1.accumulate("tracking_visit_id", s);
        JSONObject jsonobject = new JSONObject();
        jsonobject.accumulate("actor", jsonobject1);
        jsonobject.accumulate("channel", "mobile");
        long l = System.currentTimeMillis();
        jsonobject.accumulate("tracking_event", Long.toString(l));
        long l1 = (new GregorianCalendar()).getTimeZone().getRawOffset();
        a.b.put("t", Long.toString(l - l1));
        a.b.put("dsid", obj);
        a.b.put("vid", s);
        jsonobject.accumulate("event_params", a(a.b));
        obj = new JSONObject();
        ((JSONObject) (obj)).accumulate("events", jsonobject);
        return ((JSONObject) (obj)).toString();
    }

    public final void c()
    {
    }

    public final void d()
    {
    }

    public final String e()
    {
        return "mockResponse";
    }

    static 
    {
        com/paypal/android/sdk/be.getSimpleName();
    }
}
