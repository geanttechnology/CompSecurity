// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.support.v4.view.ak;
import android.view.View;

// Referenced classes of package android.support.v4.widget:
//            ak, j, DrawerLayout, ah, 
//            g, f

final class i extends android.support.v4.widget.ak
{

    final int a;
    ah b;
    final DrawerLayout c;
    private final Runnable d = new j(this);

    public i(DrawerLayout drawerlayout, int k)
    {
        c = drawerlayout;
        super();
        a = k;
    }

    public final void a()
    {
        c.removeCallbacks(d);
    }

    public final void a(int k)
    {
        DrawerLayout drawerlayout;
        View view;
        g g1;
        drawerlayout = c;
        view = b.m;
        int l = drawerlayout.a.a;
        int i1 = drawerlayout.b.a;
        if (l == 1 || i1 == 1)
        {
            l = 1;
        } else
        if (l == 2 || i1 == 2)
        {
            l = 2;
        } else
        {
            l = 0;
        }
        if (view == null || k != 0) goto _L2; else goto _L1
_L1:
        g1 = (g)view.getLayoutParams();
        if (g1.b != 0.0F) goto _L4; else goto _L3
_L3:
        g1 = (g)view.getLayoutParams();
        if (g1.d)
        {
            g1.d = false;
            if (drawerlayout.e != null)
            {
                drawerlayout.e.c();
            }
            drawerlayout.a(view, false);
            if (drawerlayout.hasWindowFocus())
            {
                view = drawerlayout.getRootView();
                if (view != null)
                {
                    view.sendAccessibilityEvent(32);
                }
            }
        }
_L2:
        if (l != drawerlayout.c)
        {
            drawerlayout.c = l;
        }
        return;
_L4:
        if (g1.b == 1.0F)
        {
            g g2 = (g)view.getLayoutParams();
            if (!g2.d)
            {
                g2.d = true;
                if (drawerlayout.e != null)
                {
                    drawerlayout.e.b();
                }
                drawerlayout.a(view, true);
                view.requestFocus();
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public final void a(int k, int l)
    {
        View view;
        if ((k & 1) == 1)
        {
            view = c.a(3);
        } else
        {
            view = c.a(5);
        }
        if (view != null && c.a(view) == 0)
        {
            b.a(view, l);
        }
    }

    public final void a(View view, float f1)
    {
        float f2;
        int i1;
        f2 = DrawerLayout.b(view);
        i1 = view.getWidth();
        if (!c.a(view, 3)) goto _L2; else goto _L1
_L1:
        ah ah1;
        int k;
        int l;
        if (f1 > 0.0F || f1 == 0.0F && f2 > 0.5F)
        {
            k = 0;
        } else
        {
            k = -i1;
        }
_L6:
        ah1 = b;
        l = view.getTop();
        if (!ah1.n)
        {
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        } else
        {
            ah1.a(k, l, (int)ak.a(ah1.i, ah1.c), (int)ak.b(ah1.i, ah1.c));
            c.invalidate();
            return;
        }
_L2:
        l = c.getWidth();
        if (f1 < 0.0F) goto _L4; else goto _L3
_L3:
        k = l;
        if (f1 != 0.0F) goto _L6; else goto _L5
_L5:
        k = l;
        if (f2 <= 0.5F) goto _L6; else goto _L4
_L4:
        k = l - i1;
          goto _L6
    }

    public final void a(View view, int k)
    {
        int l = view.getWidth();
        float f1;
        if (c.a(view, 3))
        {
            f1 = (float)(l + k) / (float)l;
        } else
        {
            f1 = (float)(c.getWidth() - k) / (float)l;
        }
        c.a(view, f1);
        if (f1 == 0.0F)
        {
            k = 4;
        } else
        {
            k = 0;
        }
        view.setVisibility(k);
        c.invalidate();
    }

    public final boolean a(View view)
    {
        return DrawerLayout.d(view) && c.a(view, a) && c.a(view) == 0;
    }

    public final int b(View view, int k)
    {
        if (c.a(view, 3))
        {
            return Math.max(-view.getWidth(), Math.min(k, 0));
        } else
        {
            int l = c.getWidth();
            return Math.max(l - view.getWidth(), Math.min(k, l));
        }
    }

    final void b()
    {
        byte byte0 = 3;
        if (a == 3)
        {
            byte0 = 5;
        }
        View view = c.a(byte0);
        if (view != null)
        {
            c.f(view);
        }
    }

    public final void b(View view)
    {
        ((g)view.getLayoutParams()).c = false;
        b();
    }

    public final int c(View view)
    {
        if (DrawerLayout.d(view))
        {
            return view.getWidth();
        } else
        {
            return 0;
        }
    }

    public final void c()
    {
        c.postDelayed(d, 160L);
    }

    public final int d(View view)
    {
        return view.getTop();
    }
}
