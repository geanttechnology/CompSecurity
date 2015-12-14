// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.widget.ScrollerCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

// Referenced classes of package com.picsart.studio.view:
//            o

public final class n
{

    private static final Interpolator v = new Interpolator() {

        public final float getInterpolation(float f1)
        {
            f1--;
            return f1 * (f1 * f1 * f1 * f1) + 1.0F;
        }

    };
    int a;
    int b;
    int c;
    float d[];
    float e[];
    float f[];
    float g[];
    int h[];
    VelocityTracker i;
    float j;
    ScrollerCompat k;
    final o l;
    View m;
    boolean n;
    final ViewGroup o;
    final Runnable p = new Runnable() {

        private n a;

        public final void run()
        {
            a.b(0);
        }

            
            {
                a = n.this;
                super();
            }
    };
    private int q[];
    private int r[];
    private int s;
    private float t;
    private int u;

    private n(Context context, ViewGroup viewgroup, o o1)
    {
        c = -1;
        if (viewgroup == null)
        {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (o1 == null)
        {
            throw new IllegalArgumentException("Callback may not be null");
        } else
        {
            o = viewgroup;
            l = o1;
            viewgroup = ViewConfiguration.get(context);
            u = (int)(context.getResources().getDisplayMetrics().density * 20F + 0.5F);
            b = viewgroup.getScaledTouchSlop();
            t = viewgroup.getScaledMaximumFlingVelocity();
            j = viewgroup.getScaledMinimumFlingVelocity();
            k = ScrollerCompat.create(context, v);
            return;
        }
    }

    private static float a(float f1, float f2, float f3)
    {
        float f4 = Math.abs(f1);
        if (f4 < f2)
        {
            f2 = 0.0F;
        } else
        if (f4 > f3)
        {
            f2 = f3;
            if (f1 <= 0.0F)
            {
                return -f3;
            }
        } else
        {
            return f1;
        }
        return f2;
    }

    private int a(int i1, int j1, int k1)
    {
        if (i1 == 0)
        {
            return 0;
        }
        int l1 = o.getWidth();
        int i2 = l1 / 2;
        float f3 = Math.min(1.0F, (float)Math.abs(i1) / (float)l1);
        float f1 = i2;
        float f2 = i2;
        f3 = (float)Math.sin((float)((double)(f3 - 0.5F) * 0.4712389167638204D));
        j1 = Math.abs(j1);
        if (j1 > 0)
        {
            i1 = Math.round(Math.abs((f3 * f2 + f1) / (float)j1) * 1000F) * 4;
        } else
        {
            i1 = (int)(((float)Math.abs(i1) / (float)k1 + 1.0F) * 256F);
        }
        return Math.min(i1, 600);
    }

    public static n a(ViewGroup viewgroup, o o1)
    {
        viewgroup = new n(viewgroup.getContext(), viewgroup, o1);
        viewgroup.b = (int)((float)((n) (viewgroup)).b * 2.0F);
        return viewgroup;
    }

    private boolean a(float f1, float f2, int i1, int j1)
    {
        f1 = Math.abs(f1);
        for (f2 = Math.abs(f2); (h[i1] & j1) != j1 || (j1 & 0) == 0 || (r[i1] & j1) == j1 || (q[i1] & j1) == j1 || f1 <= (float)b && f2 <= (float)b || (q[i1] & j1) != 0 || f1 <= (float)b;)
        {
            return false;
        }

        return true;
    }

    public static boolean a(View view, int i1, int j1)
    {
        while (view == null || i1 < view.getLeft() || i1 >= view.getRight() || j1 < view.getTop() || j1 >= view.getBottom()) 
        {
            return false;
        }
        return true;
    }

    private static int b(int i1, int j1, int k1)
    {
        int l1 = Math.abs(i1);
        if (l1 < j1)
        {
            j1 = 0;
        } else
        if (l1 > k1)
        {
            j1 = k1;
            if (i1 <= 0)
            {
                return -k1;
            }
        } else
        {
            return i1;
        }
        return j1;
    }

    public final View a(int i1, int j1)
    {
        for (int k1 = o.getChildCount() - 1; k1 >= 0; k1--)
        {
            View view = o.getChildAt(k1);
            if (i1 >= view.getLeft() && i1 < view.getRight() && j1 >= view.getTop() && j1 < view.getBottom())
            {
                return view;
            }
        }

        return null;
    }

    public final void a()
    {
        c = -1;
        if (d != null)
        {
            Arrays.fill(d, 0.0F);
            Arrays.fill(e, 0.0F);
            Arrays.fill(f, 0.0F);
            Arrays.fill(g, 0.0F);
            Arrays.fill(h, 0);
            Arrays.fill(q, 0);
            Arrays.fill(r, 0);
            s = 0;
        }
        if (i != null)
        {
            i.recycle();
            i = null;
        }
    }

    final void a(float f1)
    {
        n = true;
        l.a(m, f1);
        n = false;
        if (a == 1)
        {
            b(0);
        }
    }

    final void a(float f1, float f2, int i1)
    {
        int k1 = 0;
        if (d == null || d.length <= i1)
        {
            float af[] = new float[i1 + 1];
            float af2[] = new float[i1 + 1];
            float af3[] = new float[i1 + 1];
            float af4[] = new float[i1 + 1];
            int ai[] = new int[i1 + 1];
            int ai1[] = new int[i1 + 1];
            int ai2[] = new int[i1 + 1];
            if (d != null)
            {
                System.arraycopy(d, 0, af, 0, d.length);
                System.arraycopy(e, 0, af2, 0, e.length);
                System.arraycopy(f, 0, af3, 0, f.length);
                System.arraycopy(g, 0, af4, 0, g.length);
                System.arraycopy(h, 0, ai, 0, h.length);
                System.arraycopy(q, 0, ai1, 0, q.length);
                System.arraycopy(r, 0, ai2, 0, r.length);
            }
            d = af;
            e = af2;
            f = af3;
            g = af4;
            h = ai;
            q = ai1;
            r = ai2;
        }
        float af1[] = d;
        f[i1] = f1;
        af1[i1] = f1;
        af1 = e;
        g[i1] = f2;
        af1[i1] = f2;
        af1 = h;
        int i2 = (int)f1;
        int l1 = (int)f2;
        if (i2 < o.getLeft() + u)
        {
            k1 = 1;
        }
        int j1 = k1;
        if (l1 < o.getTop() + u)
        {
            j1 = k1 | 4;
        }
        k1 = j1;
        if (i2 > o.getRight() - u)
        {
            k1 = j1 | 2;
        }
        j1 = k1;
        if (l1 > o.getBottom() - u)
        {
            j1 = k1 | 8;
        }
        af1[i1] = j1;
        s = s | 1 << i1;
    }

    final void a(int i1)
    {
        if (d == null)
        {
            return;
        }
        try
        {
            d[i1] = 0.0F;
            e[i1] = 0.0F;
            f[i1] = 0.0F;
            g[i1] = 0.0F;
            h[i1] = 0;
            q[i1] = 0;
            r[i1] = 0;
            s = s & ~(1 << i1);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    final void a(MotionEvent motionevent)
    {
        int j1 = MotionEventCompat.getPointerCount(motionevent);
        for (int i1 = 0; i1 < j1; i1++)
        {
            int k1 = MotionEventCompat.getPointerId(motionevent, i1);
            float f1 = MotionEventCompat.getX(motionevent, i1);
            float f2 = MotionEventCompat.getY(motionevent, i1);
            if (f != null && g != null)
            {
                f[k1] = f1;
                g[k1] = f2;
            }
        }

    }

    final boolean a(int i1, int j1, int k1, int l1)
    {
        int i2 = m.getLeft();
        int j2 = m.getTop();
        i1 -= i2;
        j1 -= j2;
        if (i1 == 0 && j1 == 0)
        {
            k.abortAnimation();
            b(0);
            return false;
        }
        k1 = b(k1, (int)j, (int)t);
        l1 = b(l1, (int)j, (int)t);
        int k2 = Math.abs(i1);
        int l2 = Math.abs(j1);
        int i3 = Math.abs(k1);
        int j3 = Math.abs(l1);
        int k3 = i3 + j3;
        int l3 = k2 + l2;
        float f1;
        float f2;
        float f3;
        if (k1 != 0)
        {
            f1 = (float)i3 / (float)k3;
        } else
        {
            f1 = (float)k2 / (float)l3;
        }
        if (l1 != 0)
        {
            f2 = (float)j3 / (float)k3;
        } else
        {
            f2 = (float)l2 / (float)l3;
        }
        k1 = a(i1, k1, 0);
        l1 = a(j1, l1, l.c());
        f3 = k1;
        k1 = (int)(f2 * (float)l1 + f1 * f3);
        k.startScroll(i2, j2, i1, j1, k1);
        b(2);
        return true;
    }

    final boolean a(View view, float f1)
    {
        if (view != null)
        {
            boolean flag;
            if (l.c() > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && Math.abs(f1) > (float)(b * 3))
            {
                return true;
            }
        }
        return false;
    }

    final boolean a(View view, int i1)
    {
        if (view == m && c == i1)
        {
            return true;
        }
        if (view != null && l.a(view))
        {
            c = i1;
            if (view.getParent() != o)
            {
                throw new IllegalArgumentException((new StringBuilder("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (")).append(o).append(")").toString());
            } else
            {
                m = view;
                c = i1;
                l.b();
                b(1);
                return true;
            }
        } else
        {
            return false;
        }
    }

    final void b()
    {
        i.computeCurrentVelocity(1000, t);
        a(VelocityTrackerCompat.getXVelocity(i, c), j, t);
        a(a(VelocityTrackerCompat.getYVelocity(i, c), j, t));
    }

    final void b(float f1, float f2, int i1)
    {
        int k1 = 1;
        int j1;
        if (!a(f1, f2, i1, 1))
        {
            k1 = 0;
        }
        j1 = k1;
        if (a(f2, f1, i1, 4))
        {
            j1 = k1 | 4;
        }
        k1 = j1;
        if (a(f1, f2, i1, 2))
        {
            k1 = j1 | 2;
        }
        j1 = k1;
        if (a(f2, f1, i1, 8))
        {
            j1 = k1 | 8;
        }
        if (j1 != 0)
        {
            int ai[] = q;
            ai[i1] = j1 | ai[i1];
        }
    }

    final void b(int i1)
    {
        if (a != i1)
        {
            a = i1;
            l.a();
            if (i1 == 0)
            {
                m = null;
            }
        }
    }

}
