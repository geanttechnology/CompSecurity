// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import org.json.JSONException;
import org.json.JSONObject;

public class ahg
{

    private String a;
    private String b;
    private int c;
    private int d;
    private int e;
    private int f;
    private String g;
    private String h;
    private int i;
    private long j;

    protected ahg(String s, String s1, int k, int l, long l1)
    {
        a = s;
        b = s1;
        if (b != null)
        {
            b.replace("-", "").trim();
        }
        c = k;
        d = l;
        if (j < 1L)
        {
            j = System.currentTimeMillis() / 1000L + 0x15180L;
            return;
        } else
        {
            j = l1;
            return;
        }
    }

    protected static String a(byte abyte0[])
    {
        String s = "";
        for (int k = 0; k < abyte0.length; k++)
        {
            s = (new StringBuilder()).append(s).append(String.format("%2X", new Object[] {
                Byte.valueOf(abyte0[k])
            })).toString();
        }

        return s;
    }

    public String a()
    {
        return a;
    }

    protected void a(int k)
    {
        e = k;
    }

    protected void a(String s)
    {
        a = s;
    }

    public String b()
    {
        return b;
    }

    protected void b(int k)
    {
        f = k;
    }

    protected void b(String s)
    {
        h = s;
    }

    public int c()
    {
        return c;
    }

    protected void c(int k)
    {
        i = k;
    }

    protected void c(String s)
    {
        g = s;
    }

    public int d()
    {
        return d;
    }

    protected int e()
    {
        return e;
    }

    public boolean equals(Object obj)
    {
        if (obj != null && getClass() == obj.getClass())
        {
            obj = (ahg)obj;
            if (b != null && b.equalsIgnoreCase(((ahg) (obj)).b()))
            {
                boolean flag;
                boolean flag1;
                if (c < 0 || ((ahg) (obj)).c() < 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (d < 0 || ((ahg) (obj)).d() < 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag && flag1)
                {
                    return true;
                }
                if (c == ((ahg) (obj)).c() && d == ((ahg) (obj)).d())
                {
                    return true;
                }
            }
        }
        return false;
    }

    protected int f()
    {
        return f;
    }

    protected JSONObject g()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("id", a);
            jsonobject.put("uuid", b);
            jsonobject.put("major", c);
            jsonobject.put("minor", d);
            jsonobject.put("expiry", j);
        }
        catch (JSONException jsonexception)
        {
            return jsonobject;
        }
        return jsonobject;
    }

    public String toString()
    {
        return (new StringBuilder()).append("UUID:").append(b()).append(" M:").append(c()).append(" m:").append(d()).append(" p:").append(f()).toString();
    }
}
