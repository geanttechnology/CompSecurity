// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.b;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.facebook.ads.a.a.a;
import com.facebook.ads.a.f.b;
import com.facebook.ads.a.f.c;
import com.facebook.ads.a.f.f;
import com.facebook.ads.a.f.g;
import com.facebook.ads.a.f.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.facebook.ads.a.b:
//            u, s, v

public final class p extends u
{

    private Context a;
    private s b;

    public p()
    {
    }

    public final void a(int i1)
    {
        if (b != null)
        {
            s s1 = b;
            if (i1 == 0 && s1.z > 0L && s1.A != null)
            {
                com.facebook.ads.a.f.c.a(com.facebook.ads.a.f.b.a(s1.z, s1.A, s1.u));
                s1.z = 0L;
                s1.A = null;
                return;
            }
        }
    }

    public final void a(Context context, v v1, Map map)
    {
        b = com.facebook.ads.a.b.s.a((JSONObject)map.get("data"));
        a = context;
        if (b == null || com.facebook.ads.a.f.f.a(context, b))
        {
            context = com.facebook.ads.b.b;
            v1.b(this);
            return;
        } else
        {
            v1.a(this);
            b.a = b.u;
            return;
        }
    }

    public final void a(Map map)
    {
        s s1;
        if (b != null)
        {
            if (!(s1 = b).x)
            {
                HashMap hashmap = new HashMap();
                com.facebook.ads.a.b.s.a(hashmap, map);
                com.facebook.ads.a.b.s.b(hashmap, map);
                (new o(hashmap)).execute(new String[] {
                    s1.i
                });
                if (s1.l || s1.m)
                {
                    try
                    {
                        map = com.facebook.ads.a.b.s.a(map);
                        (new Handler()).postDelayed(new s._cls1(s1, hashmap, map), s1.n * 1000);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Map map) { }
                }
                s1.v.a("impression");
                s1.x = true;
                return;
            }
        }
    }

    public final void b()
    {
    }

    public final void b(Map map)
    {
        if (b != null)
        {
            s s1 = b;
            Context context = a;
            if (!s1.y)
            {
                HashMap hashmap = new HashMap();
                com.facebook.ads.a.b.s.a(hashmap, map);
                com.facebook.ads.a.b.s.b(hashmap, map);
                hashmap.put("touch", com.facebook.ads.a.f.g.a(map));
                (new o(hashmap)).execute(new String[] {
                    s1.j
                });
                s1.v.a("click");
                s1.y = true;
                com.facebook.ads.a.f.g.a(context, "Click logged");
            }
            map = com.facebook.ads.a.a.b.a(context, s1.b);
            if (map != null)
            {
                try
                {
                    s1.z = System.currentTimeMillis();
                    s1.A = map.a();
                    map.b();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Map map)
                {
                    Log.e(com.facebook.ads.a.b.s.a, "Error executing action", map);
                }
                return;
            }
        }
    }

    public final boolean c()
    {
        return s() && b.k;
    }

    public final boolean d()
    {
        return b.l;
    }

    public final boolean e()
    {
        return b.m;
    }

    public final int f()
    {
        s s1 = b;
        if (s1.o < 0 || s1.o > 100)
        {
            return 0;
        } else
        {
            return s1.o;
        }
    }

    public final int g()
    {
        return b.p;
    }

    public final int h()
    {
        return b.q;
    }

    public final com.facebook.ads.k.a i()
    {
        if (!s())
        {
            return null;
        } else
        {
            return b.f;
        }
    }

    public final com.facebook.ads.k.a j()
    {
        if (!s())
        {
            return null;
        } else
        {
            return b.g;
        }
    }

    public final String k()
    {
        if (!s())
        {
            return null;
        } else
        {
            s s1 = b;
            s1.d();
            return s1.c;
        }
    }

    public final String l()
    {
        if (!s())
        {
            return null;
        } else
        {
            s s1 = b;
            s1.d();
            return s1.d;
        }
    }

    public final String m()
    {
        if (!s())
        {
            return null;
        } else
        {
            s s1 = b;
            s1.d();
            return s1.e;
        }
    }

    public final com.facebook.ads.k.c n()
    {
        if (!s())
        {
            return null;
        } else
        {
            s s1 = b;
            s1.d();
            return s1.h;
        }
    }

    public final String o()
    {
        if (!s())
        {
            return null;
        } else
        {
            return b.w;
        }
    }

    public final String p()
    {
        if (!s())
        {
            return null;
        } else
        {
            return b.r;
        }
    }

    public final String q()
    {
        if (!s())
        {
            return null;
        } else
        {
            return b.s;
        }
    }

    public final String r()
    {
        if (!s())
        {
            return null;
        } else
        {
            return b.t;
        }
    }

    public final boolean s()
    {
        return b != null;
    }
}
