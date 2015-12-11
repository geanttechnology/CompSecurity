// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ak;
import android.support.v4.view.z;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

// Referenced classes of package android.support.v4.widget:
//            ai, aj, s, ak

public final class ah
{

    private static final Interpolator v = new ai();
    int a;
    int b;
    int c;
    float d[];
    float e[];
    float f[];
    float g[];
    int h;
    VelocityTracker i;
    float j;
    int k;
    int l;
    View m;
    boolean n;
    private int o[];
    private int p[];
    private int q[];
    private float r;
    private s s;
    private final android.support.v4.widget.ak t;
    private final ViewGroup u;
    private final Runnable w = new aj(this);

    private ah(Context context, ViewGroup viewgroup, android.support.v4.widget.ak ak1)
    {
        c = -1;
        if (viewgroup == null)
        {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (ak1 == null)
        {
            throw new IllegalArgumentException("Callback may not be null");
        } else
        {
            u = viewgroup;
            t = ak1;
            viewgroup = ViewConfiguration.get(context);
            k = (int)(context.getResources().getDisplayMetrics().density * 20F + 0.5F);
            b = viewgroup.getScaledTouchSlop();
            r = viewgroup.getScaledMaximumFlingVelocity();
            j = viewgroup.getScaledMinimumFlingVelocity();
            s = android.support.v4.widget.s.a(context, v);
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
        int l1 = u.getWidth();
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

    public static ah a(ViewGroup viewgroup, android.support.v4.widget.ak ak1)
    {
        viewgroup = new ah(viewgroup.getContext(), viewgroup, ak1);
        viewgroup.b = (int)((float)((ah) (viewgroup)).b * 1.0F);
        return viewgroup;
    }

    private void a(float f1)
    {
        n = true;
        t.a(m, f1);
        n = false;
        if (a == 1)
        {
            a(0);
        }
    }

    private void a(float f1, float f2, int i1)
    {
        int k1 = 0;
        if (d == null || d.length <= i1)
        {
            float af[] = new float[i1 + 1];
            float af2[] = new float[i1 + 1];
            float af3[] = new float[i1 + 1];
            float af4[] = new float[i1 + 1];
            int ai1[] = new int[i1 + 1];
            int ai2[] = new int[i1 + 1];
            int ai3[] = new int[i1 + 1];
            if (d != null)
            {
                System.arraycopy(d, 0, af, 0, d.length);
                System.arraycopy(e, 0, af2, 0, e.length);
                System.arraycopy(f, 0, af3, 0, f.length);
                System.arraycopy(g, 0, af4, 0, g.length);
                System.arraycopy(o, 0, ai1, 0, o.length);
                System.arraycopy(p, 0, ai2, 0, p.length);
                System.arraycopy(q, 0, ai3, 0, q.length);
            }
            d = af;
            e = af2;
            f = af3;
            g = af4;
            o = ai1;
            p = ai2;
            q = ai3;
        }
        float af1[] = d;
        f[i1] = f1;
        af1[i1] = f1;
        af1 = e;
        g[i1] = f2;
        af1[i1] = f2;
        af1 = o;
        int i2 = (int)f1;
        int l1 = (int)f2;
        if (i2 < u.getLeft() + k)
        {
            k1 = 1;
        }
        int j1 = k1;
        if (l1 < u.getTop() + k)
        {
            j1 = k1 | 4;
        }
        k1 = j1;
        if (i2 > u.getRight() - k)
        {
            k1 = j1 | 2;
        }
        j1 = k1;
        if (l1 > u.getBottom() - k)
        {
            j1 = k1 | 8;
        }
        af1[i1] = j1;
        h = h | 1 << i1;
    }

    private boolean a(float f1, float f2, int i1, int j1)
    {
        f1 = Math.abs(f1);
        for (f2 = Math.abs(f2); (o[i1] & j1) != j1 || (l & j1) == 0 || (q[i1] & j1) == j1 || (p[i1] & j1) == j1 || f1 <= (float)b && f2 <= (float)b || (p[i1] & j1) != 0 || f1 <= (float)b;)
        {
            return false;
        }

        return true;
    }

    private boolean a(View view, float f1)
    {
        if (view != null)
        {
            boolean flag;
            if (t.c(view) > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && Math.abs(f1) > (float)b)
            {
                return true;
            }
        }
        return false;
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

    private void b(float f1, float f2, int i1)
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
            int ai1[] = p;
            ai1[i1] = ai1[i1] | j1;
            t.a(j1, i1);
        }
    }

    private void b(int i1)
    {
        if (d == null)
        {
            return;
        } else
        {
            d[i1] = 0.0F;
            e[i1] = 0.0F;
            f[i1] = 0.0F;
            g[i1] = 0.0F;
            o[i1] = 0;
            p[i1] = 0;
            q[i1] = 0;
            h = h & ~(1 << i1);
            return;
        }
    }

    private boolean b(View view, int i1)
    {
        if (view == m && c == i1)
        {
            return true;
        }
        if (view != null && t.a(view))
        {
            c = i1;
            a(view, i1);
            return true;
        } else
        {
            return false;
        }
    }

    public static boolean b(View view, int i1, int j1)
    {
        while (view == null || i1 < view.getLeft() || i1 >= view.getRight() || j1 < view.getTop() || j1 >= view.getBottom()) 
        {
            return false;
        }
        return true;
    }

    private void c(MotionEvent motionevent)
    {
        int j1 = z.c(motionevent);
        for (int i1 = 0; i1 < j1; i1++)
        {
            int k1 = z.b(motionevent, i1);
            float f1 = z.c(motionevent, i1);
            float f2 = z.d(motionevent, i1);
            f[k1] = f1;
            g[k1] = f2;
        }

    }

    private void d()
    {
        i.computeCurrentVelocity(1000, r);
        float f1 = a(ak.a(i, c), j, r);
        a(ak.b(i, c), j, r);
        a(f1);
    }

    public final View a(int i1, int j1)
    {
        for (int k1 = u.getChildCount() - 1; k1 >= 0; k1--)
        {
            View view = u.getChildAt(k1);
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
            Arrays.fill(o, 0);
            Arrays.fill(p, 0);
            Arrays.fill(q, 0);
            h = 0;
        }
        if (i != null)
        {
            i.recycle();
            i = null;
        }
    }

    final void a(int i1)
    {
        if (a != i1)
        {
            a = i1;
            t.a(i1);
            if (a == 0)
            {
                m = null;
            }
        }
    }

    public final void a(View view, int i1)
    {
        if (view.getParent() != u)
        {
            throw new IllegalArgumentException((new StringBuilder("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (")).append(u).append(")").toString());
        } else
        {
            m = view;
            c = i1;
            t.b(view);
            a(1);
            return;
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
            s.f();
            a(0);
            return false;
        }
        View view = m;
        k1 = b(k1, (int)j, (int)r);
        l1 = b(l1, (int)j, (int)r);
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
        k1 = a(i1, k1, t.c(view));
        l1 = a(j1, l1, 0);
        f3 = k1;
        k1 = (int)(f2 * (float)l1 + f1 * f3);
        s.a(i2, j2, i1, j1, k1);
        a(2);
        return true;
    }

    public final boolean a(MotionEvent motionevent)
    {
        int i1;
        int j1;
        j1 = z.a(motionevent);
        i1 = z.b(motionevent);
        if (j1 == 0)
        {
            a();
        }
        if (i == null)
        {
            i = VelocityTracker.obtain();
        }
        i.addMovement(motionevent);
        j1;
        JVM INSTR tableswitch 0 6: default 88
    //                   0 98
    //                   1 515
    //                   2 279
    //                   3 515
    //                   4 88
    //                   5 181
    //                   6 502;
           goto _L1 _L2 _L3 _L4 _L3 _L1 _L5 _L6
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_515;
_L7:
        float f1;
        float f4;
        float f5;
        float f6;
        View view;
        int k1;
        int l1;
        return a == 1;
_L2:
        f1 = motionevent.getX();
        f4 = motionevent.getY();
        i1 = z.b(motionevent, 0);
        a(f1, f4, i1);
        motionevent = a((int)f1, (int)f4);
        if (motionevent == m && a == 2)
        {
            b(motionevent, i1);
        }
        if ((o[i1] & l) != 0)
        {
            t.c();
        }
          goto _L7
_L5:
        j1 = z.b(motionevent, i1);
        float f2 = z.c(motionevent, i1);
        f4 = z.d(motionevent, i1);
        a(f2, f4, j1);
        if (a == 0)
        {
            if ((o[j1] & l) != 0)
            {
                t.c();
            }
        } else
        if (a == 2)
        {
            motionevent = a((int)f2, (int)f4);
            if (motionevent == m)
            {
                b(motionevent, j1);
            }
        }
          goto _L7
_L4:
        k1 = z.c(motionevent);
        i1 = 0;
_L13:
        if (i1 >= k1) goto _L9; else goto _L8
_L8:
        l1 = z.b(motionevent, i1);
        float f3 = z.c(motionevent, i1);
        f4 = z.d(motionevent, i1);
        f5 = f3 - d[l1];
        f6 = e[l1];
        view = a((int)f3, (int)f4);
        int i2;
        int j2;
        int k2;
        if (view != null && a(view, f5))
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (!j1) goto _L11; else goto _L10
_L10:
        i2 = view.getLeft();
        j2 = (int)f5;
        j2 = t.b(view, j2 + i2);
        view.getTop();
        t.d(view);
        k2 = t.c(view);
        if (k2 != 0 && (k2 <= 0 || j2 != i2)) goto _L11; else goto _L9
_L9:
        c(motionevent);
          goto _L7
_L11:
        b(f5, f4 - f6, l1);
        if (a == 1 || j1 && b(view, l1)) goto _L9; else goto _L12
_L12:
        i1++;
          goto _L13
_L6:
        b(z.b(motionevent, i1));
          goto _L7
        a();
          goto _L7
    }

    public final boolean a(View view, int i1, int j1)
    {
        m = view;
        c = -1;
        boolean flag = a(i1, j1, 0, 0);
        if (!flag && a == 0 && m != null)
        {
            m = null;
        }
        return flag;
    }

    public final void b()
    {
        a();
        if (a == 2)
        {
            s.a();
            s.b();
            s.f();
            int i1 = s.a();
            s.b();
            t.a(m, i1);
        }
        a(0);
    }

    public final void b(MotionEvent motionevent)
    {
        int i1;
        int j1;
        int k1;
        int l1;
        i1 = 0;
        j1 = 0;
        l1 = z.a(motionevent);
        k1 = z.b(motionevent);
        if (l1 == 0)
        {
            a();
        }
        if (i == null)
        {
            i = VelocityTracker.obtain();
        }
        i.addMovement(motionevent);
        l1;
        JVM INSTR tableswitch 0 6: default 92
    //                   0 93
    //                   1 711
    //                   2 267
    //                   3 728
    //                   4 92
    //                   5 158
    //                   6 582;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6 _L7
_L1:
        return;
_L2:
        float f1 = motionevent.getX();
        float f3 = motionevent.getY();
        i1 = z.b(motionevent, 0);
        motionevent = a((int)f1, (int)f3);
        a(f1, f3, i1);
        b(((View) (motionevent)), i1);
        if ((o[i1] & l) != 0)
        {
            t.c();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        float f2;
        float f4;
        i1 = z.b(motionevent, k1);
        f2 = z.c(motionevent, k1);
        f4 = z.d(motionevent, k1);
        a(f2, f4, i1);
        if (a != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        b(a((int)f2, (int)f4), i1);
        if ((o[i1] & l) != 0)
        {
            t.c();
            return;
        }
        if (true) goto _L1; else goto _L8
_L8:
        j1 = (int)f2;
        k1 = (int)f4;
        if (b(m, j1, k1))
        {
            b(m, i1);
            return;
        }
          goto _L1
_L4:
        if (a == 1)
        {
            i1 = z.a(motionevent, c);
            f2 = z.c(motionevent, i1);
            f4 = z.d(motionevent, i1);
            k1 = (int)(f2 - f[c]);
            l1 = (int)(f4 - g[c]);
            j1 = m.getLeft() + k1;
            m.getTop();
            int j2 = m.getLeft();
            int i2 = m.getTop();
            i1 = j1;
            if (k1 != 0)
            {
                i1 = t.b(m, j1);
                m.offsetLeftAndRight(i1 - j2);
            }
            if (l1 != 0)
            {
                j1 = t.d(m);
                m.offsetTopAndBottom(j1 - i2);
            }
            if (k1 != 0 || l1 != 0)
            {
                t.a(m, i1);
            }
            c(motionevent);
            return;
        }
        k1 = z.c(motionevent);
        i1 = j1;
        do
        {
            if (i1 >= k1)
            {
                break;
            }
            j1 = z.b(motionevent, i1);
            f2 = z.c(motionevent, i1);
            f4 = z.d(motionevent, i1);
            float f5 = f2 - d[j1];
            b(f5, f4 - e[j1], j1);
            if (a == 1)
            {
                break;
            }
            View view = a((int)f2, (int)f4);
            if (a(view, f5) && b(view, j1))
            {
                break;
            }
            i1++;
        } while (true);
        c(motionevent);
        return;
_L7:
        j1 = z.b(motionevent, k1);
        if (a != 1 || j1 != c) goto _L10; else goto _L9
_L9:
        k1 = z.c(motionevent);
_L16:
        if (i1 >= k1) goto _L12; else goto _L11
_L11:
        l1 = z.b(motionevent, i1);
        if (l1 == c) goto _L14; else goto _L13
_L13:
        f2 = z.c(motionevent, i1);
        f4 = z.d(motionevent, i1);
        if (a((int)f2, (int)f4) != m || !b(m, l1)) goto _L14; else goto _L15
_L15:
        i1 = c;
_L17:
        if (i1 == -1)
        {
            d();
        }
_L10:
        b(j1);
        return;
_L14:
        i1++;
          goto _L16
_L3:
        if (a == 1)
        {
            d();
        }
        a();
        return;
_L5:
        if (a == 1)
        {
            a(0.0F);
        }
        a();
        return;
_L12:
        i1 = -1;
          goto _L17
    }

    public final boolean c()
    {
        boolean flag2 = false;
        if (a == 2)
        {
            boolean flag3 = s.e();
            int i1 = s.a();
            int j1 = s.b();
            int k1 = i1 - m.getLeft();
            int l1 = j1 - m.getTop();
            if (k1 != 0)
            {
                m.offsetLeftAndRight(k1);
            }
            if (l1 != 0)
            {
                m.offsetTopAndBottom(l1);
            }
            if (k1 != 0 || l1 != 0)
            {
                t.a(m, i1);
            }
            boolean flag = flag3;
            if (flag3)
            {
                flag = flag3;
                if (i1 == s.c())
                {
                    flag = flag3;
                    if (j1 == s.d())
                    {
                        s.f();
                        flag = false;
                    }
                }
            }
            if (!flag)
            {
                u.post(w);
            }
        }
        boolean flag1 = flag2;
        if (a == 2)
        {
            flag1 = true;
        }
        return flag1;
    }

}
