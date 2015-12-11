// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.x;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

// Referenced classes of package android.support.v7:
//            wd

public final class wq extends wd
{

    private String a;
    private int b;
    private int c;
    private String d;
    private String e;
    private boolean f;
    private boolean g;
    private boolean h;

    public wq()
    {
        this(false);
    }

    public wq(boolean flag)
    {
        this(flag, a());
    }

    public wq(boolean flag, int k)
    {
        x.a(k);
        b = k;
        g = flag;
    }

    static int a()
    {
        UUID uuid = UUID.randomUUID();
        int k = (int)(uuid.getLeastSignificantBits() & 0x7fffffffL);
        if (k == 0)
        {
            int l = (int)(uuid.getMostSignificantBits() & 0x7fffffffL);
            k = l;
            if (l == 0)
            {
                Log.e("GAv4", "UUID.randomUUID() returned 0.");
                return 0x7fffffff;
            }
        }
        return k;
    }

    private void j()
    {
        if (h)
        {
            throw new IllegalStateException("ScreenViewInfo is immutable");
        } else
        {
            return;
        }
    }

    public void a(int k)
    {
        j();
        b = k;
    }

    public void a(wd wd1)
    {
        a((wq)wd1);
    }

    public void a(wq wq1)
    {
        if (!TextUtils.isEmpty(a))
        {
            wq1.a(a);
        }
        if (b != 0)
        {
            wq1.a(b);
        }
        if (c != 0)
        {
            wq1.b(c);
        }
        if (!TextUtils.isEmpty(d))
        {
            wq1.b(d);
        }
        if (!TextUtils.isEmpty(e))
        {
            wq1.c(e);
        }
        if (f)
        {
            wq1.b(f);
        }
        if (g)
        {
            wq1.a(g);
        }
    }

    public void a(String s)
    {
        j();
        a = s;
    }

    public void a(boolean flag)
    {
        j();
        g = flag;
    }

    public String b()
    {
        return a;
    }

    public void b(int k)
    {
        j();
        c = k;
    }

    public void b(String s)
    {
        j();
        d = s;
    }

    public void b(boolean flag)
    {
        j();
        f = flag;
    }

    public int c()
    {
        return b;
    }

    public void c(String s)
    {
        j();
        if (TextUtils.isEmpty(s))
        {
            e = null;
            return;
        } else
        {
            e = s;
            return;
        }
    }

    public int d()
    {
        return c;
    }

    public String e()
    {
        return d;
    }

    public String f()
    {
        return e;
    }

    public boolean g()
    {
        return !h;
    }

    public void h()
    {
        h = true;
    }

    public boolean i()
    {
        return f;
    }

    public String toString()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("screenName", a);
        hashmap.put("interstitial", Boolean.valueOf(f));
        hashmap.put("automatic", Boolean.valueOf(g));
        hashmap.put("screenId", Integer.valueOf(b));
        hashmap.put("referrerScreenId", Integer.valueOf(c));
        hashmap.put("referrerScreenName", d);
        hashmap.put("referrerUri", e);
        return a(hashmap);
    }
}
