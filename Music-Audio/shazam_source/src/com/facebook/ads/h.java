// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import android.content.Context;
import android.view.View;
import com.facebook.ads.a.b;
import com.facebook.ads.a.c;
import com.facebook.ads.a.d;
import com.facebook.ads.a.f.g;
import com.facebook.ads.a.i;

// Referenced classes of package com.facebook.ads:
//            a, e, b, i, 
//            g

public final class h
    implements a
{

    private static final d a;
    private final Context b;
    private final String c;
    private i d;
    private boolean e;
    private boolean f;
    private com.facebook.ads.i g;
    private com.facebook.ads.g h;

    public h(Context context, String s)
    {
        b = context;
        c = s;
    }

    static com.facebook.ads.i a(h h1)
    {
        return h1.g;
    }

    static boolean b(h h1)
    {
        h1.e = true;
        return true;
    }

    static com.facebook.ads.g c(h h1)
    {
        return h1.h;
    }

    static boolean d(h h1)
    {
        h1.f = false;
        return false;
    }

    static i e(h h1)
    {
        return h1.d;
    }

    static i f(h h1)
    {
        h1.d = null;
        return null;
    }

    public final void a()
    {
        e = false;
        if (f)
        {
            throw new IllegalStateException("InterstitialAd cannot be loaded while being displayed. Make sure your adapter calls adapterListener.onInterstitialDismissed().");
        }
        if (d != null)
        {
            d.d();
            d = null;
        }
        e e1 = com.facebook.ads.e.b;
        com.facebook.ads.a.f f1 = com.facebook.ads.a.f.g.a(com.facebook.ads.e.b);
        d = new i(b, c, f1, e1, a, true);
        d.a(new b() {

            final h a;

            public final void a()
            {
                com.facebook.ads.h.b(a);
                if (h.a(a) != null)
                {
                    h.a(a).a(a);
                }
            }

            public final void a(View view)
            {
            }

            public final void a(c c1)
            {
                if (h.a(a) != null)
                {
                    h.a(a).a(a, c1.a());
                }
            }

            public final void b()
            {
                if (h.a(a) != null)
                {
                    h.a(a).b(a);
                }
            }

            public final void c()
            {
                if (com.facebook.ads.h.c(a) != null)
                {
                    com.facebook.ads.h.c(a);
                }
                if ((h.a(a) instanceof com.facebook.ads.g) && h.a(a) != com.facebook.ads.h.c(a))
                {
                    h.a(a);
                }
            }

            public final void d()
            {
                if (h.a(a) != null)
                {
                    h.a(a).b();
                }
            }

            public final void e()
            {
                com.facebook.ads.h.d(a);
                if (h.e(a) != null)
                {
                    h.e(a).d();
                    h.f(a);
                }
                if (h.a(a) != null)
                {
                    h.a(a).a();
                }
            }

            
            {
                a = h.this;
                super();
            }
        });
        d.b();
    }

    public final void a(com.facebook.ads.i j)
    {
        g = j;
    }

    public final void b()
    {
        if (d != null)
        {
            d.d();
            d = null;
        }
    }

    public final boolean c()
    {
        return e;
    }

    public final boolean d()
    {
        if (!e)
        {
            if (g != null)
            {
                g.a(this, b.e);
            }
            return false;
        } else
        {
            d.c();
            f = true;
            e = false;
            return true;
        }
    }

    static 
    {
        a = d.a;
    }
}
