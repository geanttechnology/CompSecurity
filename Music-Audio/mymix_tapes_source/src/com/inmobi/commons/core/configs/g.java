// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.configs;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.core.configs:
//            a

class g extends com.inmobi.commons.core.configs.a
{
    static final class a
    {

        private String a;
        private long b;
        private String c;
        private String d;

        static long a(a a1, long l)
        {
            a1.b = l;
            return l;
        }

        static String a(a a1)
        {
            return a1.a;
        }

        static String a(a a1, String s)
        {
            a1.a = s;
            return s;
        }

        static long b(a a1)
        {
            return a1.b;
        }

        static String b(a a1, String s)
        {
            a1.c = s;
            return s;
        }

        static String c(a a1)
        {
            return a1.c;
        }

        static String c(a a1, String s)
        {
            a1.d = s;
            return s;
        }

        static String d(a a1)
        {
            return a1.d;
        }

        public String a()
        {
            return a;
        }

        public Long b()
        {
            return Long.valueOf(b);
        }

        public String c()
        {
            return c;
        }

        public String d()
        {
            return d;
        }

        a()
        {
        }
    }

    public static final class b
    {

        private String a;
        private String b;

        static String a(b b1)
        {
            return b1.a;
        }

        static String a(b b1, String s)
        {
            b1.a = s;
            return s;
        }

        static String b(b b1)
        {
            return b1.b;
        }

        static String b(b b1, String s)
        {
            b1.b = s;
            return s;
        }

        public String a()
        {
            return a;
        }

        public String b()
        {
            return b;
        }

        public b()
        {
            a = com.inmobi.commons.a.b.b();
            b = com.inmobi.commons.a.b.f();
        }
    }


    private int a;
    private int b;
    private int c;
    private List d;
    private b e;
    private JSONObject f;

    public g()
    {
        a = 3;
        b = 60;
        c = 3;
        d = new ArrayList();
        e = new b();
        f = new JSONObject();
    }

    public long a(String s)
    {
        for (int j = 0; j < d.size(); j++)
        {
            a a1 = (a)d.get(j);
            if (s.equals(a.a(a1)))
            {
                return a.b(a1);
            }
        }

        return 0x15180L;
    }

    public String a()
    {
        return "root";
    }

    public void a(JSONObject jsonobject)
        throws JSONException
    {
        super.a(jsonobject);
        a = jsonobject.getInt("maxRetries");
        b = jsonobject.getInt("retryInterval");
        c = jsonobject.getInt("waitTime");
        JSONObject jsonobject1 = jsonobject.getJSONObject("latestSdkInfo");
        b.a(e, jsonobject1.getString("version"));
        b.b(e, jsonobject1.getString("url"));
        jsonobject = jsonobject.getJSONArray("components");
        d.clear();
        for (int j = 0; j < jsonobject.length(); j++)
        {
            JSONObject jsonobject2 = jsonobject.getJSONObject(j);
            a a1 = new a();
            a.a(a1, jsonobject2.getString("type"));
            a.a(a1, jsonobject2.getLong("expiry"));
            a.b(a1, jsonobject2.getString("protocol"));
            a.c(a1, jsonobject2.getString("url"));
            d.add(a1);
        }

    }

    public String b(String s)
    {
        for (int j = 0; j < d.size(); j++)
        {
            a a1 = (a)d.get(j);
            if (s.equals(a.a(a1)))
            {
                return a.d(a1);
            }
        }

        return "";
    }

    public JSONObject b()
        throws JSONException
    {
        JSONObject jsonobject = super.b();
        JSONArray jsonarray = new JSONArray();
        jsonobject.put("maxRetries", a);
        jsonobject.put("retryInterval", b);
        jsonobject.put("waitTime", c);
        JSONObject jsonobject1 = new JSONObject();
        jsonobject1.put("version", b.a(e));
        jsonobject1.put("url", b.b(e));
        jsonobject.put("latestSdkInfo", jsonobject1);
        for (int j = 0; j < d.size(); j++)
        {
            JSONObject jsonobject2 = new JSONObject();
            jsonobject2.put("type", a.a((a)d.get(j)));
            jsonobject2.put("expiry", a.b((a)d.get(j)));
            jsonobject2.put("protocol", a.c((a)d.get(j)));
            jsonobject2.put("url", a.d((a)d.get(j)));
            jsonarray.put(jsonobject2);
        }

        jsonobject.put("components", jsonarray);
        return jsonobject;
    }

    public boolean c()
    {
_L2:
        return false;
        if (d == null || a < 0 || b < 0 || c < 0 || e.a().trim().length() == 0 || !e.b().startsWith("http://") && !e.b().startsWith("https://")) goto _L2; else goto _L1
_L1:
        int j = 0;
label0:
        do
        {
label1:
            {
                if (j >= d.size())
                {
                    break label1;
                }
                a a1 = (a)d.get(j);
                if (a1.a().trim().length() == 0 || a1.b().longValue() < 0L || a1.b().longValue() > 0xd2f00L || a1.c().trim().length() == 0 || a1.d() == null || a1.d().trim().length() == 0 || !a1.d().startsWith("http://") && !a1.d().startsWith("https://"))
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L2; else goto _L3
_L3:
        return true;
    }

    public com.inmobi.commons.core.configs.a d()
    {
        return new g();
    }

    public int e()
    {
        return a;
    }

    public int f()
    {
        return b;
    }

    public int g()
    {
        return c;
    }

    public b h()
    {
        return e;
    }

    public JSONObject i()
    {
        return f;
    }
}
