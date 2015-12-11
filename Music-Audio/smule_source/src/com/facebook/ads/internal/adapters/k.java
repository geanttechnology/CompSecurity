// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.adapters;

import android.content.Context;
import com.facebook.ads.AdError;
import com.facebook.ads.internal.util.b;
import com.facebook.ads.internal.util.f;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.facebook.ads.internal.adapters:
//            p, n, q

public class k extends p
{

    private Context a;
    private q b;
    private n c;

    public k()
    {
    }

    public void a(int i1)
    {
        if (c == null)
        {
            return;
        } else
        {
            c.a(i1);
            return;
        }
    }

    public void a(Context context, q q1, Map map)
    {
        c = com.facebook.ads.internal.adapters.n.a((JSONObject)map.get("data"));
        a = context;
        b = q1;
        if (c == null || com.facebook.ads.internal.util.f.a(context, c))
        {
            b.a(this, AdError.NO_FILL);
            return;
        }
        if (b != null)
        {
            b.a(this);
        }
        b.a = c.s();
    }

    public void a(Map map)
    {
        if (c == null)
        {
            return;
        } else
        {
            c.a(map);
            return;
        }
    }

    public boolean a()
    {
        if (!r())
        {
            return false;
        } else
        {
            return c.l();
        }
    }

    public void b(Map map)
    {
        if (c == null)
        {
            return;
        } else
        {
            c.a(a, map);
            return;
        }
    }

    public boolean b()
    {
        return c.m();
    }

    public boolean c()
    {
        return c.n();
    }

    public int d()
    {
        return c.o();
    }

    public int e()
    {
        return c.t();
    }

    public int f()
    {
        return c.u();
    }

    public com.facebook.ads.NativeAd.Image g()
    {
        if (!r())
        {
            return null;
        } else
        {
            return c.d();
        }
    }

    public com.facebook.ads.NativeAd.Image h()
    {
        if (!r())
        {
            return null;
        } else
        {
            return c.e();
        }
    }

    public String i()
    {
        if (!r())
        {
            return null;
        } else
        {
            return c.f();
        }
    }

    public String j()
    {
        if (!r())
        {
            return null;
        } else
        {
            return c.g();
        }
    }

    public String k()
    {
        if (!r())
        {
            return null;
        } else
        {
            return c.h();
        }
    }

    public String l()
    {
        if (!r())
        {
            return null;
        } else
        {
            return c.i();
        }
    }

    public String m()
    {
        if (!r())
        {
            return null;
        } else
        {
            return c.j();
        }
    }

    public com.facebook.ads.NativeAd.Rating n()
    {
        if (!r())
        {
            return null;
        } else
        {
            return c.k();
        }
    }

    public String o()
    {
        if (!r())
        {
            return null;
        } else
        {
            return c.p();
        }
    }

    public void onDestroy()
    {
    }

    public com.facebook.ads.NativeAd.Image p()
    {
        if (!r())
        {
            return null;
        } else
        {
            return c.q();
        }
    }

    public String q()
    {
        if (!r())
        {
            return null;
        } else
        {
            return c.r();
        }
    }

    public boolean r()
    {
        return c != null;
    }
}
