// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.c;

import com.inmobi.commons.core.configs.a;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.core.c:
//            b

class c extends a
{

    private b a;
    private String b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public c()
    {
        b = "http://tm.inmobi.com/telemetry-collector/v1/collect";
        c = 300;
        d = 60;
        e = 50;
        f = 3;
        g = 1000;
        h = 10;
        a = new b();
    }

    private void a(int i1)
    {
        c = i1;
    }

    private void a(String s)
    {
        b = s;
    }

    private void b(int i1)
    {
        f = i1;
    }

    private void c(int i1)
    {
        e = i1;
    }

    private void d(int i1)
    {
        g = i1;
    }

    private void e(int i1)
    {
        h = i1;
    }

    private void f(int i1)
    {
        d = i1;
    }

    public String a()
    {
        return "telemetry";
    }

    public void a(JSONObject jsonobject)
        throws JSONException
    {
        super.a(jsonobject);
        JSONObject jsonobject1 = jsonobject.getJSONObject("base");
        a.b(jsonobject1.getBoolean("enabled"));
        a.a(jsonobject1.getInt("samplingFactor"));
        a.a(jsonobject1.getBoolean("metricEnabled"));
        a(jsonobject.getString("url"));
        a(jsonobject.getInt("processingInterval"));
        f(jsonobject.getInt("retryInterval"));
        c(jsonobject.getInt("maxBatchSize"));
        b(jsonobject.getInt("maxRetryCount"));
        d(jsonobject.getInt("maxEventsToPersist"));
        e(jsonobject.getInt("memoryThreshold"));
    }

    public JSONObject b()
        throws JSONException
    {
        JSONObject jsonobject = super.b();
        JSONObject jsonobject1 = new JSONObject();
        jsonobject1.put("enabled", a.b());
        jsonobject1.put("samplingFactor", a.c());
        jsonobject1.put("metricEnabled", a.d());
        jsonobject.put("base", jsonobject1);
        jsonobject.put("url", f());
        jsonobject.put("processingInterval", k());
        jsonobject.put("retryInterval", g());
        jsonobject.put("maxBatchSize", i());
        jsonobject.put("maxRetryCount", j());
        jsonobject.put("maxEventsToPersist", l());
        jsonobject.put("memoryThreshold", h());
        return jsonobject;
    }

    public boolean c()
    {
        while (a == null || a.c() < 0 || b.trim().length() == 0 || !b.startsWith("http://") && !b.startsWith("https://") || d < 0 || c < 0 || f < 0 || h <= 0 || e <= 0 || g <= 0) 
        {
            return false;
        }
        return true;
    }

    public a d()
    {
        return new c();
    }

    public boolean e()
    {
        return a.b();
    }

    public String f()
    {
        return b;
    }

    public int g()
    {
        return d;
    }

    public int h()
    {
        return h;
    }

    public int i()
    {
        return e;
    }

    public int j()
    {
        return f;
    }

    public int k()
    {
        return c;
    }

    public int l()
    {
        return g;
    }

    public b m()
    {
        return a;
    }
}
