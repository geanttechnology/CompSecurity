// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.at;
import android.support.v4.view.be;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

// Referenced classes of package android.support.v4.widget:
//            bp, bq, au, br

public final class bo
{

    private static final Interpolator v = new bp();
    private int a;
    private int b;
    private int c;
    private float d[];
    private float e[];
    private float f[];
    private float g[];
    private int h[];
    private int i[];
    private int j[];
    private int k;
    private VelocityTracker l;
    private float m;
    private float n;
    private int o;
    private int p;
    private au q;
    private final br r;
    private View s;
    private boolean t;
    private final ViewGroup u;
    private final Runnable w = new bq(this);

    private bo(Context context, ViewGroup viewgroup, br br1)
    {
        c = -1;
        if (viewgroup == null)
        {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (br1 == null)
        {
            throw new IllegalArgumentException("Callback may not be null");
        } else
        {
            u = viewgroup;
            r = br1;
            viewgroup = ViewConfiguration.get(context);
            o = (int)(context.getResources().getDisplayMetrics().density * 20F + 0.5F);
            b = viewgroup.getScaledTouchSlop();
            m = viewgroup.getScaledMaximumFlingVelocity();
            n = viewgroup.getScaledMinimumFlingVelocity();
            q = au.a(context, v);
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

    public static bo a(ViewGroup viewgroup, float f1, br br1)
    {
        viewgroup = a(viewgroup, br1);
        viewgroup.b = (int)((float)((bo) (viewgroup)).b * (1.0F / f1));
        return viewgroup;
    }

    public static bo a(ViewGroup viewgroup, br br1)
    {
        return new bo(viewgroup.getContext(), viewgroup, br1);
    }

    private void a(float f1, float f2)
    {
        t = true;
        r.onViewReleased(s, f1, f2);
        t = false;
        if (a == 1)
        {
            b(0);
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
                System.arraycopy(i, 0, ai1, 0, i.length);
                System.arraycopy(j, 0, ai2, 0, j.length);
            }
            d = af;
            e = af2;
            f = af3;
            g = af4;
            h = ai;
            i = ai1;
            j = ai2;
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
        if (i2 < u.getLeft() + o)
        {
            k1 = 1;
        }
        int j1 = k1;
        if (l1 < u.getTop() + o)
        {
            j1 = k1 | 4;
        }
        k1 = j1;
        if (i2 > u.getRight() - o)
        {
            k1 = j1 | 2;
        }
        j1 = k1;
        if (l1 > u.getBottom() - o)
        {
            j1 = k1 | 8;
        }
        af1[i1] = j1;
        k = k | 1 << i1;
    }

    private boolean a(float f1, float f2, int i1, int j1)
    {
        f1 = Math.abs(f1);
        f2 = Math.abs(f2);
        if ((h[i1] & j1) == j1 && (p & j1) != 0 && (j[i1] & j1) != j1 && (i[i1] & j1) != j1 && (f1 > (float)b || f2 > (float)b))
        {
            if (f1 < f2 * 0.5F && r.onEdgeLock(j1))
            {
                int ai[] = j;
                ai[i1] = ai[i1] | j1;
                return false;
            }
            if ((i[i1] & j1) == 0 && f1 > (float)b)
            {
                return true;
            }
        }
        return false;
    }

    private boolean a(int i1, int j1, int k1, int l1)
    {
        int i2 = s.getLeft();
        int j2 = s.getTop();
        i1 -= i2;
        j1 -= j2;
        if (i1 == 0 && j1 == 0)
        {
            q.h();
            b(0);
            return false;
        }
        View view = s;
        k1 = b(k1, (int)n, (int)m);
        l1 = b(l1, (int)n, (int)m);
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
        k1 = a(i1, k1, r.getViewHorizontalDragRange(view));
        l1 = a(j1, l1, r.getViewVerticalDragRange(view));
        f3 = k1;
        k1 = (int)(f2 * (float)l1 + f1 * f3);
        q.a(i2, j2, i1, j1, k1);
        b(2);
        return true;
    }

    private boolean a(View view, float f1, float f2)
    {
        if (view != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        boolean flag;
        boolean flag1;
        if (r.getViewHorizontalDragRange(view) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (r.getViewVerticalDragRange(view) > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag || !flag1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (f1 * f1 + f2 * f2 > (float)(b * b))
        {
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (Math.abs(f1) <= (float)b) goto _L1; else goto _L4
_L4:
        return true;
        if (!flag1 || Math.abs(f2) <= (float)b) goto _L1; else goto _L5
_L5:
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
            int ai[] = i;
            ai[i1] = ai[i1] | j1;
            r.onEdgeDragStarted(j1, i1);
        }
    }

    private boolean b(View view, int i1)
    {
        if (view == s && c == i1)
        {
            return true;
        }
        if (view != null && r.tryCaptureView(view, i1))
        {
            c = i1;
            a(view, i1);
            return true;
        } else
        {
            return false;
        }
    }

    private void c(MotionEvent motionevent)
    {
        int j1 = at.c(motionevent);
        for (int i1 = 0; i1 < j1; i1++)
        {
            int k1 = at.b(motionevent, i1);
            float f1 = at.c(motionevent, i1);
            float f2 = at.d(motionevent, i1);
            f[k1] = f1;
            g[k1] = f2;
        }

    }

    private void d(int i1)
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
            h[i1] = 0;
            i[i1] = 0;
            j[i1] = 0;
            k = k & ~(1 << i1);
            return;
        }
    }

    private void f()
    {
        l.computeCurrentVelocity(1000, m);
        a(a(be.a(l, c), n, m), a(be.b(l, c), n, m));
    }

    public final int a()
    {
        return a;
    }

    public final void a(float f1)
    {
        n = f1;
    }

    public final void a(int i1)
    {
        p = i1;
    }

    public final void a(View view, int i1)
    {
        if (view.getParent() != u)
        {
            throw new IllegalArgumentException((new StringBuilder("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (")).append(u).append(")").toString());
        } else
        {
            s = view;
            c = i1;
            r.onViewCaptured(view, i1);
            b(1);
            return;
        }
    }

    public final boolean a(int i1, int j1)
    {
        if (!t)
        {
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        } else
        {
            return a(i1, j1, (int)be.a(l, c), (int)be.b(l, c));
        }
    }

    public final boolean a(MotionEvent motionevent)
    {
        int i1;
        int j1;
        j1 = at.a(motionevent);
        i1 = at.b(motionevent);
        if (j1 == 0)
        {
            e();
        }
        if (l == null)
        {
            l = VelocityTracker.obtain();
        }
        l.addMovement(motionevent);
        j1;
        JVM INSTR tableswitch 0 6: default 88
    //                   0 98
    //                   1 603
    //                   2 305
    //                   3 603
    //                   4 88
    //                   5 194
    //                   6 590;
           goto _L1 _L2 _L3 _L4 _L3 _L1 _L5 _L6
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_603;
_L7:
        float f1;
        float f4;
        return a == 1;
_L2:
        f1 = motionevent.getX();
        f4 = motionevent.getY();
        i1 = at.b(motionevent, 0);
        a(f1, f4, i1);
        motionevent = b((int)f1, (int)f4);
        if (motionevent == s && a == 2)
        {
            b(motionevent, i1);
        }
        j1 = h[i1];
        if ((p & j1) != 0)
        {
            r.onEdgeTouched(j1 & p, i1);
        }
          goto _L7
_L5:
        int k1 = at.b(motionevent, i1);
        float f2 = at.c(motionevent, i1);
        float f5 = at.d(motionevent, i1);
        a(f2, f5, k1);
        if (a == 0)
        {
            i1 = h[k1];
            if ((p & i1) != 0)
            {
                r.onEdgeTouched(i1 & p, k1);
            }
        } else
        if (a == 2)
        {
            motionevent = b((int)f2, (int)f5);
            if (motionevent == s)
            {
                b(motionevent, k1);
            }
        }
          goto _L7
_L4:
        if (d != null && e != null)
        {
            int l1 = at.c(motionevent);
            i1 = 0;
            do
            {
                if (i1 >= l1)
                {
                    break;
                }
                int i2 = at.b(motionevent, i1);
                float f3 = at.c(motionevent, i1);
                float f6 = at.d(motionevent, i1);
                float f7 = f3 - d[i2];
                float f8 = f6 - e[i2];
                View view = b((int)f3, (int)f6);
                boolean flag;
                if (view != null && a(view, f7, f8))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    int j2 = view.getLeft();
                    int k2 = (int)f7;
                    k2 = r.clampViewPositionHorizontal(view, k2 + j2, (int)f7);
                    int l2 = view.getTop();
                    int i3 = (int)f8;
                    i3 = r.clampViewPositionVertical(view, i3 + l2, (int)f8);
                    int j3 = r.getViewHorizontalDragRange(view);
                    int k3 = r.getViewVerticalDragRange(view);
                    if ((j3 == 0 || j3 > 0 && k2 == j2) && (k3 == 0 || k3 > 0 && i3 == l2))
                    {
                        break;
                    }
                }
                b(f7, f8, i2);
                if (a == 1 || flag && b(view, i2))
                {
                    break;
                }
                i1++;
            } while (true);
            c(motionevent);
        }
          goto _L7
_L6:
        d(at.b(motionevent, i1));
          goto _L7
        e();
          goto _L7
    }

    public final boolean a(View view, int i1, int j1)
    {
        s = view;
        c = -1;
        boolean flag = a(i1, j1, 0, 0);
        if (!flag && a == 0 && s != null)
        {
            s = null;
        }
        return flag;
    }

    public final boolean a(boolean flag)
    {
        if (a == 2)
        {
            flag = q.g();
            int i1 = q.b();
            int j1 = q.c();
            int k1 = i1 - s.getLeft();
            int l1 = j1 - s.getTop();
            if (k1 != 0)
            {
                s.offsetLeftAndRight(k1);
            }
            if (l1 != 0)
            {
                s.offsetTopAndBottom(l1);
            }
            if (k1 != 0 || l1 != 0)
            {
                r.onViewPositionChanged(s, i1, j1, k1, l1);
            }
            if (flag && i1 == q.d() && j1 == q.e())
            {
                q.h();
                flag = false;
            }
            if (!flag)
            {
                u.post(w);
            }
        }
        return a == 2;
    }

    public final int b()
    {
        return o;
    }

    public final View b(int i1, int j1)
    {
        for (int k1 = u.getChildCount() - 1; k1 >= 0; k1--)
        {
            View view = u.getChildAt(r.getOrderedChildIndex(k1));
            if (i1 >= view.getLeft() && i1 < view.getRight() && j1 >= view.getTop() && j1 < view.getBottom())
            {
                return view;
            }
        }

        return null;
    }

    final void b(int i1)
    {
        u.removeCallbacks(w);
        if (a != i1)
        {
            a = i1;
            r.onViewDragStateChanged(i1);
            if (a == 0)
            {
                s = null;
            }
        }
    }

    public final void b(MotionEvent motionevent)
    {
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        k1 = 0;
        i1 = 0;
        j1 = 0;
        i2 = at.a(motionevent);
        l1 = at.b(motionevent);
        if (i2 == 0)
        {
            e();
        }
        if (l == null)
        {
            l = VelocityTracker.obtain();
        }
        l.addMovement(motionevent);
        i2;
        JVM INSTR tableswitch 0 6: default 96
    //                   0 97
    //                   1 832
    //                   2 356
    //                   3 849
    //                   4 96
    //                   5 175
    //                   6 703;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6 _L7
_L1:
        return;
_L2:
        float f1 = motionevent.getX();
        float f3 = motionevent.getY();
        i1 = at.b(motionevent, 0);
        motionevent = b((int)f1, (int)f3);
        a(f1, f3, i1);
        b(((View) (motionevent)), i1);
        j1 = h[i1];
        if ((p & j1) != 0)
        {
            r.onEdgeTouched(j1 & p, i1);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        float f2;
        float f4;
        k1 = at.b(motionevent, l1);
        f2 = at.c(motionevent, l1);
        f4 = at.d(motionevent, l1);
        a(f2, f4, k1);
        if (a != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        b(b((int)f2, (int)f4), k1);
        i1 = h[k1];
        if ((p & i1) != 0)
        {
            r.onEdgeTouched(i1 & p, k1);
            return;
        }
        if (true) goto _L1; else goto _L8
_L8:
        l1 = (int)f2;
        int j2 = (int)f4;
        motionevent = s;
        i1 = j1;
        if (motionevent != null)
        {
            i1 = j1;
            if (l1 >= motionevent.getLeft())
            {
                i1 = j1;
                if (l1 < motionevent.getRight())
                {
                    i1 = j1;
                    if (j2 >= motionevent.getTop())
                    {
                        i1 = j1;
                        if (j2 < motionevent.getBottom())
                        {
                            i1 = 1;
                        }
                    }
                }
            }
        }
        if (i1 != 0)
        {
            b(s, k1);
            return;
        }
          goto _L1
_L4:
        if (a == 1)
        {
            i1 = at.a(motionevent, c);
            f2 = at.c(motionevent, i1);
            f4 = at.d(motionevent, i1);
            l1 = (int)(f2 - f[c]);
            int k2 = (int)(f4 - g[c]);
            j1 = s.getLeft() + l1;
            k1 = s.getTop() + k2;
            int l2 = s.getLeft();
            int i3 = s.getTop();
            i1 = j1;
            if (l1 != 0)
            {
                i1 = r.clampViewPositionHorizontal(s, j1, l1);
                s.offsetLeftAndRight(i1 - l2);
            }
            j1 = k1;
            if (k2 != 0)
            {
                j1 = r.clampViewPositionVertical(s, k1, k2);
                s.offsetTopAndBottom(j1 - i3);
            }
            if (l1 != 0 || k2 != 0)
            {
                r.onViewPositionChanged(s, i1, j1, i1 - l2, j1 - i3);
            }
            c(motionevent);
            return;
        }
        j1 = at.c(motionevent);
        i1 = k1;
        do
        {
            if (i1 >= j1)
            {
                break;
            }
            k1 = at.b(motionevent, i1);
            f2 = at.c(motionevent, i1);
            f4 = at.d(motionevent, i1);
            float f5 = f2 - d[k1];
            float f6 = f4 - e[k1];
            b(f5, f6, k1);
            if (a == 1)
            {
                break;
            }
            View view = b((int)f2, (int)f4);
            if (a(view, f5, f6) && b(view, k1))
            {
                break;
            }
            i1++;
        } while (true);
        c(motionevent);
        return;
_L7:
        j1 = at.b(motionevent, l1);
        if (a != 1 || j1 != c) goto _L10; else goto _L9
_L9:
        k1 = at.c(motionevent);
_L16:
        if (i1 >= k1) goto _L12; else goto _L11
_L11:
        l1 = at.b(motionevent, i1);
        if (l1 == c) goto _L14; else goto _L13
_L13:
        f2 = at.c(motionevent, i1);
        f4 = at.d(motionevent, i1);
        if (b((int)f2, (int)f4) != s || !b(s, l1)) goto _L14; else goto _L15
_L15:
        i1 = c;
_L17:
        if (i1 == -1)
        {
            f();
        }
_L10:
        d(j1);
        return;
_L14:
        i1++;
          goto _L16
_L3:
        if (a == 1)
        {
            f();
        }
        e();
        return;
_L5:
        if (a == 1)
        {
            a(0.0F, 0.0F);
        }
        e();
        return;
_L12:
        i1 = -1;
          goto _L17
    }

    public final View c()
    {
        return s;
    }

    public final boolean c(int i1)
    {
        int j1;
        int k1;
        k1 = d.length;
        j1 = 0;
_L9:
        if (j1 >= k1) goto _L2; else goto _L1
_L1:
        float f1;
        float f2;
        boolean flag;
        boolean flag1;
        if ((k & 1 << j1) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L4; else goto _L3
_L3:
        if ((i1 & 1) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if ((i1 & 2) == 2)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        f1 = f[j1] - d[j1];
        f2 = g[j1] - e[j1];
        if (!flag || !flag1) goto _L6; else goto _L5
_L5:
        if (f1 * f1 + f2 * f2 > (float)(b * b))
        {
            flag = true;
        } else
        {
            flag = false;
        }
_L8:
        if (flag)
        {
            return true;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (flag)
        {
            if (Math.abs(f1) > (float)b)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (flag1)
        {
            if (Math.abs(f2) > (float)b)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            continue; /* Loop/switch isn't completed */
        }
_L4:
        flag = false;
        if (true) goto _L8; else goto _L7
_L7:
        j1++;
          goto _L9
_L2:
        return false;
    }

    public final int d()
    {
        return b;
    }

    public final void e()
    {
        c = -1;
        if (d != null)
        {
            Arrays.fill(d, 0.0F);
            Arrays.fill(e, 0.0F);
            Arrays.fill(f, 0.0F);
            Arrays.fill(g, 0.0F);
            Arrays.fill(h, 0);
            Arrays.fill(i, 0);
            Arrays.fill(j, 0);
            k = 0;
        }
        if (l != null)
        {
            l.recycle();
            l = null;
        }
    }

}
