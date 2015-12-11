// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.view.View;

// Referenced classes of package android.support.v4.widget:
//            br, x, bo, DrawerLayout, 
//            u

final class w extends br
{

    private final int a;
    private bo b;
    private final Runnable c = new x(this);
    private DrawerLayout d;

    public w(DrawerLayout drawerlayout, int i)
    {
        d = drawerlayout;
        super();
        a = i;
    }

    static void a(w w1)
    {
        int i = 0;
        int j = w1.b.b();
        View view;
        boolean flag;
        if (w1.a == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            view = w1.d.a(3);
            if (view != null)
            {
                i = -view.getWidth();
            }
            i += j;
        } else
        {
            view = w1.d.a(5);
            i = w1.d.getWidth();
            i -= j;
        }
        if (view != null && (flag && view.getLeft() < i || !flag && view.getLeft() > i) && w1.d.a(view) == 0)
        {
            u u1 = (u)view.getLayoutParams();
            w1.b.a(view, i, view.getTop());
            u1.c = true;
            w1.d.invalidate();
            w1.b();
            w1.d.b();
        }
    }

    private void b()
    {
        byte byte0 = 3;
        if (a == 3)
        {
            byte0 = 5;
        }
        View view = d.a(byte0);
        if (view != null)
        {
            d.e(view);
        }
    }

    public final void a()
    {
        d.removeCallbacks(c);
    }

    public final void a(bo bo1)
    {
        b = bo1;
    }

    public final int clampViewPositionHorizontal(View view, int i, int j)
    {
        if (d.a(view, 3))
        {
            return Math.max(-view.getWidth(), Math.min(i, 0));
        } else
        {
            j = d.getWidth();
            return Math.max(j - view.getWidth(), Math.min(i, j));
        }
    }

    public final int clampViewPositionVertical(View view, int i, int j)
    {
        return view.getTop();
    }

    public final int getViewHorizontalDragRange(View view)
    {
        if (DrawerLayout.d(view))
        {
            return view.getWidth();
        } else
        {
            return 0;
        }
    }

    public final void onEdgeDragStarted(int i, int j)
    {
        View view;
        if ((i & 1) == 1)
        {
            view = d.a(3);
        } else
        {
            view = d.a(5);
        }
        if (view != null && d.a(view) == 0)
        {
            b.a(view, j);
        }
    }

    public final boolean onEdgeLock(int i)
    {
        return false;
    }

    public final void onEdgeTouched(int i, int j)
    {
        d.postDelayed(c, 160L);
    }

    public final void onViewCaptured(View view, int i)
    {
        ((u)view.getLayoutParams()).c = false;
        b();
    }

    public final void onViewDragStateChanged(int i)
    {
        d.a(i, b.c());
    }

    public final void onViewPositionChanged(View view, int i, int j, int k, int l)
    {
        j = view.getWidth();
        float f;
        if (d.a(view, 3))
        {
            f = (float)(j + i) / (float)j;
        } else
        {
            f = (float)(d.getWidth() - i) / (float)j;
        }
        d.a(view, f);
        if (f == 0.0F)
        {
            i = 4;
        } else
        {
            i = 0;
        }
        view.setVisibility(i);
        d.invalidate();
    }

    public final void onViewReleased(View view, float f, float f1)
    {
        int k;
        f1 = DrawerLayout.b(view);
        k = view.getWidth();
        if (!d.a(view, 3)) goto _L2; else goto _L1
_L1:
        int i;
        if (f > 0.0F || f == 0.0F && f1 > 0.5F)
        {
            i = 0;
        } else
        {
            i = -k;
        }
_L4:
        b.a(i, view.getTop());
        d.invalidate();
        return;
_L2:
        int j = d.getWidth();
        if (f >= 0.0F)
        {
            i = j;
            if (f != 0.0F)
            {
                continue; /* Loop/switch isn't completed */
            }
            i = j;
            if (f1 <= 0.5F)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        i = j - k;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final boolean tryCaptureView(View view, int i)
    {
        return DrawerLayout.d(view) && d.a(view, a) && d.a(view) == 0;
    }
}
