// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.crashlytics.android.Crashlytics;
import org.json.JSONObject;

public class eh
{

    static long a = 0x36ee80L;
    private long b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private int l;
    private int m;

    public eh()
    {
        m = 0;
    }

    public static eh a(JSONObject jsonobject)
    {
        eh eh1 = new eh();
        if (jsonobject.isNull("refreshTime")) goto _L2; else goto _L1
_L1:
        eh1.a(jsonobject.getLong("refreshTime") * 1000L);
_L10:
        if (!jsonobject.isNull("testScheme"))
        {
            eh1.a(jsonobject.getString("testScheme"));
        }
        if (!jsonobject.isNull("itemID"))
        {
            eh1.a(jsonobject.getInt("itemID"));
        }
        if (!jsonobject.isNull("url"))
        {
            eh1.b(jsonobject.getString("url"));
        }
        if (jsonobject.isNull("appid")) goto _L4; else goto _L3
_L3:
        String s = jsonobject.getString("appid");
        if (!s.equalsIgnoreCase("0")) goto _L6; else goto _L5
_L5:
        eh1.c(null);
_L4:
        if (!jsonobject.isNull("title"))
        {
            eh1.d(jsonobject.getString("title"));
        }
        if (!jsonobject.isNull("message"))
        {
            eh1.e(jsonobject.getString("message"));
        }
        if (!jsonobject.isNull("buttontext"))
        {
            eh1.f(jsonobject.getString("buttontext"));
        }
        if (!jsonobject.isNull("iconurl"))
        {
            eh1.h(jsonobject.getString("iconurl"));
        }
        if (!jsonobject.isNull("imageurl"))
        {
            eh1.i(jsonobject.getString("imageurl"));
        }
        if (!jsonobject.isNull("cancelbuttontext"))
        {
            eh1.g(jsonobject.getString("cancelbuttontext"));
        }
        if (jsonobject.isNull("posState")) goto _L8; else goto _L7
_L7:
        eh1.b(jsonobject.getInt("posState"));
        return eh1;
_L2:
        try
        {
            eh1.a(a);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            Crashlytics.logException(jsonobject);
            return null;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        eh1.c(s);
          goto _L4
_L8:
        return eh1;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public static String a(eh eh1)
    {
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("refreshTime", eh1.b());
            if (eh1.c() != null)
            {
                jsonobject.put("testScheme", eh1.c());
            }
            jsonobject.put("itemID", eh1.a());
            if (eh1.d() != null)
            {
                jsonobject.put("url", eh1.d());
            }
            if (eh1.e() != null)
            {
                jsonobject.put("appid", eh1.e());
            }
            if (eh1.f() != null)
            {
                jsonobject.put("title", eh1.f());
            }
            if (eh1.g() != null)
            {
                jsonobject.put("message", eh1.g());
            }
            if (eh1.h() != null)
            {
                jsonobject.put("buttontext", eh1.h());
            }
            if (eh1.j() != null)
            {
                jsonobject.put("iconurl", eh1.j());
            }
            if (eh1.k() != null)
            {
                jsonobject.put("imageurl", eh1.k());
            }
            if (eh1.i() != null)
            {
                jsonobject.put("cancelbuttontext", eh1.i());
            }
            jsonobject.put("posState", eh1.l());
            eh1 = jsonobject.toString();
        }
        // Misplaced declaration of an exception variable
        catch (eh eh1)
        {
            Crashlytics.logException(eh1);
            return null;
        }
        return eh1;
    }

    public int a()
    {
        return l;
    }

    public void a(int i1)
    {
        l = i1;
    }

    public void a(long l1)
    {
        b = l1;
    }

    public void a(String s)
    {
        c = s;
    }

    public long b()
    {
        return b;
    }

    public void b(int i1)
    {
        m = i1;
    }

    public void b(String s)
    {
        d = s;
    }

    public String c()
    {
        return c;
    }

    public void c(String s)
    {
        e = s;
    }

    public String d()
    {
        return d;
    }

    public void d(String s)
    {
        f = s;
    }

    public String e()
    {
        return e;
    }

    public void e(String s)
    {
        g = s;
    }

    public String f()
    {
        return f;
    }

    public void f(String s)
    {
        h = s;
    }

    public String g()
    {
        return g;
    }

    public void g(String s)
    {
        i = s;
    }

    public String h()
    {
        return h;
    }

    public void h(String s)
    {
        j = s;
    }

    public String i()
    {
        return i;
    }

    public void i(String s)
    {
        k = s;
    }

    public String j()
    {
        return j;
    }

    public String k()
    {
        return k;
    }

    public int l()
    {
        return m;
    }

}
