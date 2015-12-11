// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.b;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.a.c.d;
import com.facebook.ads.a.f.c;
import com.facebook.ads.a.f.f;
import com.facebook.ads.a.f.h;
import com.facebook.ads.a.g.a;
import com.facebook.ads.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.facebook.ads.a.b:
//            b, q, c, r, 
//            p, h

public class n extends com.facebook.ads.a.b.b
{

    private static final String c = com/facebook/ads/a/b/n.getSimpleName();
    r a;
    p b;
    private a d;
    private com.facebook.ads.a.b.c e;
    private Map f;
    private Context g;
    private long h;
    private com.facebook.ads.a.f.b.a i;

    public n()
    {
    }

    static long a(n n1, long l)
    {
        n1.h = l;
        return l;
    }

    static com.facebook.ads.a.b.c a(n n1)
    {
        return n1.e;
    }

    static com.facebook.ads.a.f.b.a a(n n1, com.facebook.ads.a.f.b.a a1)
    {
        n1.i = a1;
        return a1;
    }

    static Context b(n n1)
    {
        return n1.g;
    }

    static long c(n n1)
    {
        return n1.h;
    }

    static String c()
    {
        return c;
    }

    static com.facebook.ads.a.f.b.a d(n n1)
    {
        return n1.i;
    }

    public final void a(Context context, com.facebook.ads.a.b.c c1, Map map)
    {
        g = context;
        e = c1;
        f = map;
        context = (d)map.get("definition");
        h = 0L;
        i = null;
        c1 = com.facebook.ads.a.b.q.a((JSONObject)f.get("data"));
        if (com.facebook.ads.a.f.f.a(g, c1))
        {
            context = e;
            c1 = b.b;
            context.a(this);
        } else
        {
            d = new a(g, new com.facebook.ads.a.g.a.a(c1) {

                final q a;
                final n b;

                public final void a()
                {
                    n n1 = b;
                    if (n1.a != null)
                    {
                        n1.a.a();
                    } else
                    if (n1.b != null)
                    {
                        HashMap hashmap = new HashMap();
                        hashmap.put("mil", Boolean.valueOf(false));
                        n1.b.a(hashmap);
                        return;
                    }
                }

                public final void a(int j)
                {
                    if (j == 0 && com.facebook.ads.a.b.n.c(b) > 0L && com.facebook.ads.a.b.n.d(b) != null)
                    {
                        com.facebook.ads.a.f.c.a(com.facebook.ads.a.f.b.a(com.facebook.ads.a.b.n.c(b), com.facebook.ads.a.b.n.d(b), a.e));
                        com.facebook.ads.a.b.n.a(b, 0L);
                        com.facebook.ads.a.b.n.a(b, null);
                    }
                }

                public final void a(String s)
                {
                    if (com.facebook.ads.a.b.n.a(b) != null)
                    {
                        com.facebook.ads.a.b.n.a(b).b();
                    }
                    s = Uri.parse(s);
                    s = com.facebook.ads.a.a.b.a(com.facebook.ads.a.b.n.b(b), s);
                    if (s == null)
                    {
                        break MISSING_BLOCK_LABEL_70;
                    }
                    com.facebook.ads.a.b.n.a(b, s.a());
                    com.facebook.ads.a.b.n.a(b, System.currentTimeMillis());
                    s.b();
                    return;
                    s;
                    Log.e(com.facebook.ads.a.b.n.c(), "Error executing action", s);
                    return;
                }

            
            {
                b = n.this;
                a = q1;
                super();
            }
            }, context.e());
            d.a(context.f(), context.g());
            a = new r(g, d, new com.facebook.ads.a.b.h() {

                final n a;

                public final void b()
                {
                    if (com.facebook.ads.a.b.n.a(a) != null)
                    {
                        com.facebook.ads.a.b.n.a(a).a();
                    }
                }

            
            {
                a = n.this;
                super();
            }
            });
            a.b = c1;
            d.loadDataWithBaseURL(com.facebook.ads.a.f.h.a(), ((q) (c1)).a, "text/html", "utf-8", null);
            if (e != null)
            {
                e.a(this, d);
                return;
            }
        }
    }

    public final void b()
    {
        if (d != null)
        {
            com.facebook.ads.a.f.h.a(d);
            d.destroy();
            d = null;
        }
        if (b != null)
        {
            b = null;
        }
    }

}
