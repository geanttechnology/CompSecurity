// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.text.TextUtils;
import com.google.android.gms.common.internal.x;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            wd

public final class uy extends wd
{

    private String a;
    private String b;
    private String c;
    private String d;
    private boolean e;
    private String f;
    private boolean g;
    private double h;

    public uy()
    {
    }

    public String a()
    {
        return a;
    }

    public void a(double d1)
    {
        boolean flag;
        if (d1 >= 0.0D && d1 <= 100D)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        x.b(flag, "Sample rate must be between 0% and 100%");
        h = d1;
    }

    public void a(uy uy1)
    {
        if (!TextUtils.isEmpty(a))
        {
            uy1.a(a);
        }
        if (!TextUtils.isEmpty(b))
        {
            uy1.b(b);
        }
        if (!TextUtils.isEmpty(c))
        {
            uy1.c(c);
        }
        if (!TextUtils.isEmpty(d))
        {
            uy1.d(d);
        }
        if (e)
        {
            uy1.a(true);
        }
        if (!TextUtils.isEmpty(f))
        {
            uy1.e(f);
        }
        if (g)
        {
            uy1.b(g);
        }
        if (h != 0.0D)
        {
            uy1.a(h);
        }
    }

    public volatile void a(wd wd1)
    {
        a((uy)wd1);
    }

    public void a(String s)
    {
        a = s;
    }

    public void a(boolean flag)
    {
        e = flag;
    }

    public String b()
    {
        return b;
    }

    public void b(String s)
    {
        b = s;
    }

    public void b(boolean flag)
    {
        g = flag;
    }

    public String c()
    {
        return c;
    }

    public void c(String s)
    {
        c = s;
    }

    public String d()
    {
        return d;
    }

    public void d(String s)
    {
        d = s;
    }

    public void e(String s)
    {
        f = s;
    }

    public boolean e()
    {
        return e;
    }

    public String f()
    {
        return f;
    }

    public boolean g()
    {
        return g;
    }

    public double h()
    {
        return h;
    }

    public String toString()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("hitType", a);
        hashmap.put("clientId", b);
        hashmap.put("userId", c);
        hashmap.put("androidAdId", d);
        hashmap.put("AdTargetingEnabled", Boolean.valueOf(e));
        hashmap.put("sessionControl", f);
        hashmap.put("nonInteraction", Boolean.valueOf(g));
        hashmap.put("sampleRate", Double.valueOf(h));
        return a(hashmap);
    }
}
