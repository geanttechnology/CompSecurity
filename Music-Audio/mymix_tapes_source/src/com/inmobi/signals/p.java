// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.signals;

import com.inmobi.commons.core.configs.a;
import com.inmobi.commons.core.utilities.Logger;
import org.json.JSONException;
import org.json.JSONObject;

class p extends com.inmobi.commons.core.configs.a
{
    public static class a
    {

        private boolean a;
        private String b;
        private String c;
        private int d;
        private int e;
        private int f;
        private int g;
        private long h;

        static int a(a a1, int i)
        {
            a1.d = i;
            return i;
        }

        static long a(a a1, long l)
        {
            a1.h = l;
            return l;
        }

        static String a(a a1, String s)
        {
            a1.b = s;
            return s;
        }

        static boolean a(a a1)
        {
            return a1.a;
        }

        static boolean a(a a1, boolean flag)
        {
            a1.a = flag;
            return flag;
        }

        static int b(a a1, int i)
        {
            a1.e = i;
            return i;
        }

        static String b(a a1)
        {
            return a1.b;
        }

        static String b(a a1, String s)
        {
            a1.c = s;
            return s;
        }

        static int c(a a1, int i)
        {
            a1.f = i;
            return i;
        }

        static String c(a a1)
        {
            return a1.c;
        }

        static int d(a a1)
        {
            return a1.d;
        }

        static int d(a a1, int i)
        {
            a1.g = i;
            return i;
        }

        static int e(a a1)
        {
            return a1.e;
        }

        static int f(a a1)
        {
            return a1.f;
        }

        static int g(a a1)
        {
            return a1.g;
        }

        static long h(a a1)
        {
            return a1.h;
        }

        public boolean a()
        {
            return a;
        }

        public String b()
        {
            return b;
        }

        public String c()
        {
            return c;
        }

        public int d()
        {
            return d;
        }

        public int e()
        {
            return e;
        }

        public int f()
        {
            return f;
        }

        public int g()
        {
            return g;
        }

        public long h()
        {
            return h;
        }

        public a()
        {
            a = false;
            b = "http://dock.inmobi.com/carb/v1/i";
            c = "http://dock.inmobi.com/carb/v1/o";
            d = 0x15180;
            e = 3;
            f = 60;
            g = 60;
            h = 0x4b000L;
        }
    }

    public static class b
    {

        private boolean a;
        private int b;
        private int c;
        private int d;
        private String e;
        private int f;
        private int g;
        private boolean h;
        private boolean i;
        private int j;
        private boolean k;
        private boolean l;
        private int m;
        private boolean n;
        private boolean o;
        private boolean p;
        private boolean q;
        private int r;
        private int s;

        static int a(b b1)
        {
            return b1.b;
        }

        static int a(b b1, int i1)
        {
            b1.b = i1;
            return i1;
        }

        static String a(b b1, String s1)
        {
            b1.e = s1;
            return s1;
        }

        static boolean a(b b1, boolean flag)
        {
            b1.a = flag;
            return flag;
        }

        static int b(b b1)
        {
            return b1.c;
        }

        static int b(b b1, int i1)
        {
            b1.d = i1;
            return i1;
        }

        static boolean b(b b1, boolean flag)
        {
            b1.h = flag;
            return flag;
        }

        static int c(b b1)
        {
            return b1.d;
        }

        static int c(b b1, int i1)
        {
            b1.c = i1;
            return i1;
        }

        static boolean c(b b1, boolean flag)
        {
            b1.i = flag;
            return flag;
        }

        static int d(b b1, int i1)
        {
            b1.f = i1;
            return i1;
        }

        static boolean d(b b1)
        {
            return b1.a;
        }

        static boolean d(b b1, boolean flag)
        {
            b1.l = flag;
            return flag;
        }

        static int e(b b1, int i1)
        {
            b1.g = i1;
            return i1;
        }

        static String e(b b1)
        {
            return b1.e;
        }

        static boolean e(b b1, boolean flag)
        {
            b1.k = flag;
            return flag;
        }

        static int f(b b1)
        {
            return b1.f;
        }

        static int f(b b1, int i1)
        {
            b1.j = i1;
            return i1;
        }

        static boolean f(b b1, boolean flag)
        {
            b1.n = flag;
            return flag;
        }

        static int g(b b1)
        {
            return b1.g;
        }

        static int g(b b1, int i1)
        {
            b1.m = i1;
            return i1;
        }

        static boolean g(b b1, boolean flag)
        {
            b1.p = flag;
            return flag;
        }

        static int h(b b1, int i1)
        {
            b1.r = i1;
            return i1;
        }

        static boolean h(b b1)
        {
            return b1.h;
        }

        static boolean h(b b1, boolean flag)
        {
            b1.o = flag;
            return flag;
        }

        static int i(b b1, int i1)
        {
            b1.s = i1;
            return i1;
        }

        static boolean i(b b1)
        {
            return b1.i;
        }

        static boolean i(b b1, boolean flag)
        {
            b1.q = flag;
            return flag;
        }

        static int j(b b1)
        {
            return b1.j;
        }

        static boolean k(b b1)
        {
            return b1.k;
        }

        static boolean l(b b1)
        {
            return b1.l;
        }

        static int m(b b1)
        {
            return b1.m;
        }

        static boolean n(b b1)
        {
            return b1.o;
        }

        static boolean o(b b1)
        {
            return b1.p;
        }

        static boolean p(b b1)
        {
            return b1.n;
        }

        static boolean q(b b1)
        {
            return b1.q;
        }

        static int r(b b1)
        {
            return b1.r;
        }

        static int s(b b1)
        {
            return b1.s;
        }

        public boolean a()
        {
            return a;
        }

        public int b()
        {
            return b;
        }

        public int c()
        {
            return c;
        }

        public int d()
        {
            return d;
        }

        public String e()
        {
            return e;
        }

        public int f()
        {
            return f;
        }

        public int g()
        {
            return g;
        }

        public boolean h()
        {
            return h && a;
        }

        public boolean i()
        {
            return i && a;
        }

        public int j()
        {
            return j;
        }

        public boolean k()
        {
            return k && a;
        }

        public boolean l()
        {
            return l && a;
        }

        public int m()
        {
            return m;
        }

        public boolean n()
        {
            return n && a;
        }

        public boolean o()
        {
            return o && a;
        }

        public boolean p()
        {
            return p && a;
        }

        public boolean q()
        {
            return q && a;
        }

        public int r()
        {
            return r;
        }

        public int s()
        {
            return s;
        }

        public b()
        {
            a = false;
            b = 300;
            c = 3;
            d = 50;
            e = "https://sdkm.w.inmobi.com/user/e.asm";
            f = 3;
            g = 60;
            h = false;
            i = false;
            j = 0;
            k = false;
            l = false;
            m = 0;
            n = false;
            o = false;
            p = false;
            q = false;
            r = 180;
            s = 50;
        }
    }


    private static final String a = com/inmobi/commons/core/configs/a.getSimpleName();
    private b b;
    private a c;
    private JSONObject d;

    public p()
    {
        b = new b();
        c = new a();
        try
        {
            d = h();
            return;
        }
        catch (JSONException jsonexception)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Default telemetry config provided for ads is invalid.", jsonexception);
        }
    }

    private JSONObject h()
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("enabled", false);
        jsonobject.put("samplingFactor", 0);
        jsonobject.put("metricEnabled", false);
        return jsonobject;
    }

    public String a()
    {
        return "signals";
    }

    public void a(JSONObject jsonobject)
        throws JSONException
    {
        super.a(jsonobject);
        JSONObject jsonobject1 = jsonobject.getJSONObject("ice");
        com.inmobi.signals.b.a(b, jsonobject1.getInt("sampleInterval"));
        b.b(b, jsonobject1.getInt("sampleHistorySize"));
        b.c(b, jsonobject1.getInt("stopRequestTimeout"));
        com.inmobi.signals.b.a(b, jsonobject1.getBoolean("enabled"));
        com.inmobi.signals.b.a(b, jsonobject1.getString("endPoint"));
        b.d(b, jsonobject1.getInt("maxRetries"));
        b.e(b, jsonobject1.getInt("retryInterval"));
        b.b(b, jsonobject1.getBoolean("locationEnabled"));
        b.c(b, jsonobject1.getBoolean("sessionEnabled"));
        JSONObject jsonobject2 = jsonobject1.getJSONObject("w");
        b.f(b, jsonobject2.getInt("wf"));
        b.d(b, jsonobject2.getBoolean("cwe"));
        b.e(b, jsonobject2.getBoolean("vwe"));
        jsonobject2 = jsonobject1.getJSONObject("c");
        b.f(b, jsonobject2.getBoolean("oe"));
        b.g(b, jsonobject2.getBoolean("cce"));
        b.h(b, jsonobject2.getBoolean("vce"));
        b.g(b, jsonobject2.getInt("cof"));
        jsonobject1 = jsonobject1.getJSONObject("ar");
        b.i(b, jsonobject1.getBoolean("e"));
        b.h(b, jsonobject1.getInt("sampleInterval"));
        b.i(b, jsonobject1.getInt("maxHistorySize"));
        jsonobject1 = jsonobject.getJSONObject("carb");
        com.inmobi.signals.a.a(c, jsonobject1.getBoolean("enabled"));
        com.inmobi.signals.a.a(c, jsonobject1.getString("getEndPoint"));
        a.b(c, jsonobject1.getString("postEndPoint"));
        com.inmobi.signals.a.a(c, jsonobject1.getInt("retrieveFrequency"));
        a.b(c, jsonobject1.getInt("maxRetries"));
        a.c(c, jsonobject1.getInt("retryInterval"));
        a.d(c, jsonobject1.getInt("timeoutInterval"));
        com.inmobi.signals.a.a(c, jsonobject1.getLong("maxGetResponseSize"));
        d = jsonobject.optJSONObject("telemetry");
    }

    public JSONObject b()
        throws JSONException
    {
        JSONObject jsonobject = super.b();
        JSONObject jsonobject1 = new JSONObject();
        jsonobject1.put("sampleInterval", com.inmobi.signals.b.a(b));
        jsonobject1.put("stopRequestTimeout", b.b(b));
        jsonobject1.put("sampleHistorySize", b.c(b));
        jsonobject1.put("enabled", b.d(b));
        jsonobject1.put("endPoint", b.e(b));
        jsonobject1.put("maxRetries", b.f(b));
        jsonobject1.put("retryInterval", b.g(b));
        jsonobject1.put("locationEnabled", b.h(b));
        jsonobject1.put("sessionEnabled", b.i(b));
        JSONObject jsonobject2 = new JSONObject();
        jsonobject2.put("wf", b.j(b));
        jsonobject2.put("vwe", b.k(b));
        jsonobject2.put("cwe", b.l(b));
        jsonobject1.put("w", jsonobject2);
        jsonobject2 = new JSONObject();
        jsonobject2.put("cof", b.m(b));
        jsonobject2.put("vce", b.n(b));
        jsonobject2.put("cce", b.o(b));
        jsonobject2.put("oe", b.p(b));
        jsonobject1.put("c", jsonobject2);
        jsonobject2 = new JSONObject();
        jsonobject2.put("e", b.q(b));
        jsonobject2.put("sampleInterval", b.r(b));
        jsonobject2.put("maxHistorySize", b.s(b));
        jsonobject1.put("ar", jsonobject2);
        jsonobject.put("ice", jsonobject1);
        jsonobject1 = new JSONObject();
        jsonobject1.put("enabled", com.inmobi.signals.a.a(c));
        jsonobject1.put("getEndPoint", a.b(c));
        jsonobject1.put("postEndPoint", a.c(c));
        jsonobject1.put("retrieveFrequency", a.d(c));
        jsonobject1.put("maxRetries", a.e(c));
        jsonobject1.put("retryInterval", a.f(c));
        jsonobject1.put("timeoutInterval", a.g(c));
        jsonobject1.put("maxGetResponseSize", c.h());
        jsonobject.put("carb", jsonobject1);
        jsonobject.put("telemetry", d);
        return jsonobject;
    }

    public boolean c()
    {
        while (com.inmobi.signals.b.a(b) < 0 || b.c(b) < 0 || b.b(b) < 0 || b.e(b).trim().length() == 0 || b.f(b) < 0 || b.g(b) < 0 || b.j() < 0 || b.m() < 0 || b.s(b) < 0 || b.r(b) < 0 || a.b(c).trim().length() == 0 || a.c(c).trim().length() == 0 || !a.b(c).startsWith("http://") && !a.b(c).startsWith("https://") || !a.c(c).startsWith("http://") && !a.c(c).startsWith("https://") || a.d(c) < 0 || a.e(c) < 0 || a.f(c) < 0 || a.g(c) < 0 || a.h(c) < 0L) 
        {
            return false;
        }
        return true;
    }

    public com.inmobi.commons.core.configs.a d()
    {
        return new p();
    }

    public JSONObject e()
    {
        return d;
    }

    public b f()
    {
        return b;
    }

    public a g()
    {
        return c;
    }

}
