// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.b:
//            ae, a, da, ea, 
//            do, ci, dl, dz

public abstract class cs
    implements Comparable
{

    private final ea.a a;
    private final int b;
    private final String c;
    private final int d;
    private final dl.a e;
    private Integer f;
    private da g;
    private boolean h;
    private boolean i;
    private boolean j;
    private long k;
    private do l;
    private i.a m;

    public cs(int i1, String s1, dl.a a1)
    {
        ea.a a2;
        if (ea.a.a)
        {
            a2 = new ea.a();
        } else
        {
            a2 = null;
        }
        a = a2;
        h = true;
        i = false;
        j = false;
        k = 0L;
        m = null;
        b = i1;
        c = s1;
        e = a1;
        a(new ae());
        d = a(s1);
    }

    private static int a(String s1)
    {
        if (!TextUtils.isEmpty(s1))
        {
            s1 = Uri.parse(s1);
            if (s1 != null)
            {
                s1 = s1.getHost();
                if (s1 != null)
                {
                    return s1.hashCode();
                }
            }
        }
        return 0;
    }

    private byte[] a(Map map, String s1)
    {
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder();
        try
        {
            for (map = map.entrySet().iterator(); map.hasNext(); stringbuilder.append('&'))
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
                stringbuilder.append(URLEncoder.encode((String)entry.getKey(), s1));
                stringbuilder.append('=');
                stringbuilder.append(URLEncoder.encode((String)entry.getValue(), s1));
            }

        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            throw new RuntimeException((new StringBuilder()).append("Encoding not supported: ").append(s1).toString(), map);
        }
        map = stringbuilder.toString().getBytes(s1);
        return map;
    }

    static ea.a b(cs cs1)
    {
        return cs1.a;
    }

    public int a(cs cs1)
    {
        a a1 = q();
        a a2 = cs1.q();
    /* block-local class not found */
    class a {}

        if (a1 == a2)
        {
            return f.intValue() - cs1.f.intValue();
        } else
        {
            return a2.ordinal() - a1.ordinal();
        }
    }

    public final cs a(int i1)
    {
        f = Integer.valueOf(i1);
        return this;
    }

    public cs a(da da1)
    {
        g = da1;
        return this;
    }

    public cs a(do do1)
    {
        l = do1;
        return this;
    }

    public cs a(i.a a1)
    {
        m = a1;
        return this;
    }

    protected abstract dl a(ci ci);

    protected dz a(dz dz)
    {
        return dz;
    }

    public Map a()
        throws a
    {
        return Collections.emptyMap();
    }

    protected abstract void a(Object obj);

    public int b()
    {
        return b;
    }

    public void b(dz dz)
    {
        if (e != null)
        {
            e.a(dz);
        }
    }

    public void b(String s1)
    {
        if (ea.a.a)
        {
            a.a(s1, Thread.currentThread().getId());
        } else
        if (k == 0L)
        {
            k = SystemClock.elapsedRealtime();
            return;
        }
    }

    public int c()
    {
        return d;
    }

    void c(String s1)
    {
        if (g != null)
        {
            g.b(this);
        }
        if (!ea.a.a) goto _L2; else goto _L1
_L1:
        long l1 = Thread.currentThread().getId();
        if (Looper.myLooper() == Looper.getMainLooper()) goto _L4; else goto _L3
_L3:
        (new Handler(Looper.getMainLooper())).post(new _cls1(s1, l1));
_L6:
        return;
_L4:
        a.a(s1, l1);
        a.a(toString());
        return;
_L2:
        long l2 = SystemClock.elapsedRealtime() - k;
        if (l2 >= 3000L)
        {
            ea.b("%d ms: %s", new Object[] {
                Long.valueOf(l2), toString()
            });
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public int compareTo(Object obj)
    {
        return a((cs)obj);
    }

    public String d()
    {
        return c;
    }

    public String e()
    {
        return d();
    }

    public i.a f()
    {
        return m;
    }

    public boolean g()
    {
        return i;
    }

    protected Map h()
        throws a
    {
        return l();
    }

    protected String i()
    {
        return m();
    }

    public String j()
    {
        return n();
    }

    public byte[] k()
        throws a
    {
        Map map = h();
        if (map != null && map.size() > 0)
        {
            return a(map, i());
        } else
        {
            return null;
        }
    }

    protected Map l()
        throws a
    {
        return null;
    }

    protected String m()
    {
        return "UTF-8";
    }

    public String n()
    {
        return (new StringBuilder()).append("application/x-www-form-urlencoded; charset=").append(m()).toString();
    }

    public byte[] o()
        throws a
    {
        Map map = l();
        if (map != null && map.size() > 0)
        {
            return a(map, m());
        } else
        {
            return null;
        }
    }

    public final boolean p()
    {
        return h;
    }

    public a q()
    {
        return a.b;
    }

    public final int r()
    {
        return l.a();
    }

    public do s()
    {
        return l;
    }

    public void t()
    {
        j = true;
    }

    public String toString()
    {
        String s2 = (new StringBuilder()).append("0x").append(Integer.toHexString(c())).toString();
        StringBuilder stringbuilder = new StringBuilder();
        String s1;
        if (i)
        {
            s1 = "[X] ";
        } else
        {
            s1 = "[ ] ";
        }
        return stringbuilder.append(s1).append(d()).append(" ").append(s2).append(" ").append(q()).append(" ").append(f).toString();
    }

    public boolean u()
    {
        return j;
    }

    /* member class not found */
    class _cls1 {}

}
