// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.c;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
    static final class a
    {

        private String a;
        private int b;
        private boolean c;

        public String a()
        {
            return a;
        }

        public void a(int i)
        {
            b = i;
        }

        public void a(String s)
        {
            a = s;
        }

        public void a(boolean flag)
        {
            c = flag;
        }

        public int b()
        {
            return b;
        }

        public boolean c()
        {
            return c;
        }

        public a()
        {
        }

        public a(String s, int i, boolean flag)
        {
            a(s);
            a(i);
            a(flag);
        }
    }


    private int a;
    private String b;
    private boolean c;
    private boolean d;
    private Map e;

    public b()
    {
        a = 0;
        b = "telemetry";
        c = false;
        d = false;
        e = new HashMap();
    }

    public b(String s, JSONObject jsonobject, b b1)
    {
        a = 0;
        b = "telemetry";
        c = false;
        d = false;
        e = new HashMap();
        if (jsonobject != null) goto _L2; else goto _L1
_L1:
        a(s, b1);
_L11:
        return;
_L2:
        if (s == null) goto _L4; else goto _L3
_L3:
        if (s.trim().length() != 0) goto _L5; else goto _L4
_L4:
        Object obj = b1.a();
_L22:
        boolean flag;
        b = ((String) (obj));
        if (!jsonobject.has("enabled"))
        {
            break MISSING_BLOCK_LABEL_338;
        }
        flag = jsonobject.getBoolean("enabled");
_L23:
        c = flag;
        if (!jsonobject.has("samplingFactor")) goto _L7; else goto _L6
_L6:
        int i = jsonobject.getInt("samplingFactor");
_L18:
        a(i);
        if (!jsonobject.has("metricEnabled")) goto _L9; else goto _L8
_L8:
        flag = jsonobject.getBoolean("metricEnabled");
_L19:
        a(flag);
        e = new HashMap();
        if (!jsonobject.has("events")) goto _L11; else goto _L10
_L10:
        jsonobject = jsonobject.getJSONArray("events");
        i = 0;
_L17:
        if (i >= jsonobject.length()) goto _L11; else goto _L12
_L12:
        JSONObject jsonobject1;
        obj = new a();
        jsonobject1 = jsonobject.getJSONObject(i);
        ((a) (obj)).a(jsonobject1.getString("type"));
        if (!jsonobject1.has("samplingFactor")) goto _L14; else goto _L13
_L13:
        int j = jsonobject1.getInt("samplingFactor");
_L20:
        ((a) (obj)).a(j);
        if (!jsonobject1.has("metricEnabled")) goto _L16; else goto _L15
_L15:
        flag = jsonobject1.getBoolean("metricEnabled");
_L21:
        ((a) (obj)).a(flag);
        e.put(((a) (obj)).a(), obj);
        i++;
          goto _L17
_L7:
        try
        {
            i = b1.c();
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            a(s, b1);
            return;
        }
          goto _L18
_L9:
        flag = b1.d();
          goto _L19
_L14:
        j = c();
          goto _L20
_L16:
        flag = d();
          goto _L21
_L5:
        obj = s;
          goto _L22
        flag = true;
          goto _L23
    }

    private void a(String s, b b1)
    {
        b(true);
        b(s);
    }

    public a a(String s)
    {
        a a1 = (a)e.get(s);
        if (a1 != null)
        {
            return a1;
        } else
        {
            return new a(s, c(), d());
        }
    }

    public String a()
    {
        return b;
    }

    public void a(int i)
    {
        a = i;
    }

    public void a(boolean flag)
    {
        d = flag;
    }

    public void b(String s)
    {
        b = s;
    }

    public void b(boolean flag)
    {
        c = flag;
    }

    public boolean b()
    {
        return c;
    }

    public int c()
    {
        return a;
    }

    public boolean d()
    {
        return d;
    }
}
