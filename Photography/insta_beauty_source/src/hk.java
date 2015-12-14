// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.json.JSONObject;

public class hk
{

    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private int k;

    public hk()
    {
    }

    public static hk a(JSONObject jsonobject)
    {
        hk hk1 = new hk();
        Object obj;
        if (!jsonobject.isNull("id"))
        {
            hk1.a(String.valueOf(jsonobject.getInt("id")));
        }
        if (!jsonobject.isNull("testScheme"))
        {
            hk1.b(jsonobject.getString("testScheme"));
        }
        if (!jsonobject.isNull("itemID"))
        {
            hk1.a(jsonobject.getInt("itemID"));
        }
        if (!jsonobject.isNull("url"))
        {
            hk1.c(jsonobject.getString("url"));
        }
        if (!jsonobject.isNull("appid"))
        {
            obj = jsonobject.getString("appid");
            if (!((String) (obj)).equalsIgnoreCase("0"))
            {
                break MISSING_BLOCK_LABEL_235;
            }
            hk1.d(null);
        }
_L1:
        if (!jsonobject.isNull("title"))
        {
            hk1.e(jsonobject.getString("title"));
        }
        if (!jsonobject.isNull("message"))
        {
            hk1.f(jsonobject.getString("message"));
        }
        if (!jsonobject.isNull("buttontext"))
        {
            hk1.g(jsonobject.getString("buttontext"));
        }
        if (!jsonobject.isNull("iconurl"))
        {
            hk1.i(jsonobject.getString("iconurl"));
        }
        if (!jsonobject.isNull("imageurl"))
        {
            hk1.j(jsonobject.getString("imageurl"));
        }
        obj = hk1;
        if (jsonobject.isNull("cancelbuttontext"))
        {
            break MISSING_BLOCK_LABEL_246;
        }
        hk1.h(jsonobject.getString("cancelbuttontext"));
        return hk1;
        hk1.d(((String) (obj)));
          goto _L1
        jsonobject;
        obj = null;
        return ((hk) (obj));
    }

    public static String a(hk hk1)
    {
        try
        {
            JSONObject jsonobject = new JSONObject();
            if (hk1.c() != null)
            {
                jsonobject.put("testScheme", hk1.c());
            }
            jsonobject.put("itemID", hk1.a());
            if (hk1.d() != null)
            {
                jsonobject.put("url", hk1.d());
            }
            if (hk1.e() != null)
            {
                jsonobject.put("appid", hk1.e());
            }
            if (hk1.f() != null)
            {
                jsonobject.put("title", hk1.f());
            }
            if (hk1.g() != null)
            {
                jsonobject.put("message", hk1.g());
            }
            if (hk1.h() != null)
            {
                jsonobject.put("buttontext", hk1.h());
            }
            if (hk1.j() != null)
            {
                jsonobject.put("iconurl", hk1.j());
            }
            if (hk1.k() != null)
            {
                jsonobject.put("imageurl", hk1.k());
            }
            if (hk1.i() != null)
            {
                jsonobject.put("cancelbuttontext", hk1.i());
            }
            hk1 = jsonobject.toString();
        }
        // Misplaced declaration of an exception variable
        catch (hk hk1)
        {
            return null;
        }
        return hk1;
    }

    public int a()
    {
        return k;
    }

    public void a(int l)
    {
        k = l;
    }

    public void a(String s)
    {
        a = s;
    }

    public String b()
    {
        return a;
    }

    public void b(String s)
    {
        b = s;
    }

    public String c()
    {
        return b;
    }

    public void c(String s)
    {
        c = s;
    }

    public String d()
    {
        return c;
    }

    public void d(String s)
    {
        d = s;
    }

    public String e()
    {
        return d;
    }

    public void e(String s)
    {
        e = s;
    }

    public String f()
    {
        return e;
    }

    public void f(String s)
    {
        f = s;
    }

    public String g()
    {
        return f;
    }

    public void g(String s)
    {
        g = s;
    }

    public String h()
    {
        return g;
    }

    public void h(String s)
    {
        h = s;
    }

    public String i()
    {
        return h;
    }

    public void i(String s)
    {
        i = s;
    }

    public String j()
    {
        return i;
    }

    public void j(String s)
    {
        j = s;
    }

    public String k()
    {
        return j;
    }
}
