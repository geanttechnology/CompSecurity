// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.a.b;
import com.facebook.ads.a.c;
import com.facebook.ads.a.d;
import com.facebook.ads.a.f.g;
import com.facebook.ads.a.g.a;
import com.facebook.ads.a.i;

// Referenced classes of package com.facebook.ads:
//            a, e, c, g

public final class f extends RelativeLayout
    implements com.facebook.ads.a
{

    private static final d a;
    private final DisplayMetrics b;
    private final e c;
    private i d;
    private volatile boolean e;
    private com.facebook.ads.c f;
    private com.facebook.ads.g g;
    private View h;
    private boolean i;

    public f(Context context, String s, e e1)
    {
        super(context);
        i = false;
        if (e1 == null || e1 == com.facebook.ads.e.b)
        {
            throw new IllegalArgumentException("adSize");
        } else
        {
            b = getContext().getResources().getDisplayMetrics();
            c = e1;
            d = new i(context, s, com.facebook.ads.a.f.g.a(e1), e1, a, false);
            d.a(new b() {

                final f a;

                public final void a()
                {
                    if (com.facebook.ads.f.b(a) != null)
                    {
                        com.facebook.ads.f.b(a).c();
                    }
                }

                public final void a(View view)
                {
                    if (view == null)
                    {
                        throw new IllegalStateException("Cannot present null view");
                    }
                    com.facebook.ads.f.c(a);
                    com.facebook.ads.f.a(a, view);
                    a.removeAllViews();
                    a.addView(com.facebook.ads.f.d(a));
                    if (com.facebook.ads.f.d(a) instanceof a)
                    {
                        com.facebook.ads.a.f.g.a(f.e(a), com.facebook.ads.f.d(a), f.f(a));
                    }
                    if (com.facebook.ads.f.a(a) != null)
                    {
                        com.facebook.ads.f.a(a).a(a);
                    }
                }

                public final void a(c c1)
                {
                    if (com.facebook.ads.f.a(a) != null)
                    {
                        com.facebook.ads.f.a(a).a(a, c1.a());
                    }
                }

                public final void b()
                {
                    if (com.facebook.ads.f.a(a) != null)
                    {
                        com.facebook.ads.f.a(a).b(a);
                    }
                }

                public final void c()
                {
                    if (com.facebook.ads.f.g(a) != null)
                    {
                        com.facebook.ads.f.g(a);
                    }
                    if ((com.facebook.ads.f.a(a) instanceof com.facebook.ads.g) && com.facebook.ads.f.a(a) != com.facebook.ads.f.g(a))
                    {
                        com.facebook.ads.f.a(a);
                    }
                }

            
            {
                a = f.this;
                super();
            }
            });
            return;
        }
    }

    static View a(f f1, View view)
    {
        f1.h = view;
        return view;
    }

    static com.facebook.ads.c a(f f1)
    {
        return f1.f;
    }

    static i b(f f1)
    {
        return f1.d;
    }

    static boolean c(f f1)
    {
        f1.i = true;
        return true;
    }

    static View d(f f1)
    {
        return f1.h;
    }

    static DisplayMetrics e(f f1)
    {
        return f1.b;
    }

    static e f(f f1)
    {
        return f1.c;
    }

    static com.facebook.ads.g g(f f1)
    {
        return f1.g;
    }

    public final void a()
    {
        if (!e)
        {
            d.b();
            e = true;
        } else
        if (d != null)
        {
            i j = d;
            j.f();
            j.b();
            return;
        }
    }

    public final void b()
    {
        if (d != null)
        {
            d.d();
            d = null;
        }
        removeAllViews();
        h = null;
    }

    protected final void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (h != null)
        {
            com.facebook.ads.a.f.g.a(b, h, c);
        }
    }

    protected final void onWindowVisibilityChanged(int j)
    {
        super.onWindowVisibilityChanged(j);
        if (d != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        i k;
        if (j != 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        if ((k = d).b)
        {
            k.e();
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (j != 8) goto _L1; else goto _L3
_L3:
        i l = d;
        if (l.b)
        {
            l.f();
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public final void setAdListener(com.facebook.ads.c c1)
    {
        f = c1;
    }

    public final void setImpressionListener(com.facebook.ads.g g1)
    {
        g = g1;
    }

    static 
    {
        a = d.a;
    }
}
