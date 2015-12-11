// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.at;
import android.support.v4.view.ay;
import android.support.v4.view.az;
import android.support.v4.view.bi;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import com.offerup.android.network.b;
import e.c.g;

// Referenced classes of package android.support.v4.widget:
//            az, be, bf, bg, 
//            d, ah, bc, bb, 
//            bd, bh, ba, bi

public class SwipeRefreshLayout extends ViewGroup
    implements ay, az
{

    private static final String c = android/support/v4/widget/SwipeRefreshLayout.getSimpleName();
    private static final int v[] = {
        0x101000e
    };
    private Animation A;
    private Animation B;
    private Animation C;
    private Animation D;
    private Animation E;
    private float F;
    private boolean G;
    private int H;
    private int I;
    private boolean J;
    private android.view.animation.Animation.AnimationListener K;
    private final Animation L;
    private final Animation M;
    protected int a;
    protected int b;
    private View d;
    private android.support.v4.widget.bi e;
    private boolean f;
    private int g;
    private float h;
    private float i;
    private final g j;
    private final b k;
    private final int l[];
    private int m;
    private int n;
    private boolean o;
    private float p;
    private float q;
    private boolean r;
    private int s;
    private boolean t;
    private final DecelerateInterpolator u;
    private d w;
    private int x;
    private float y;
    private ah z;

    public SwipeRefreshLayout(Context context)
    {
        this(context, null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        f = false;
        h = -1F;
        l = new int[2];
        o = false;
        s = -1;
        x = -1;
        K = new android.support.v4.widget.az(this);
        L = new be(this);
        new bf(this);
        M = new bg(this);
        g = ViewConfiguration.get(context).getScaledTouchSlop();
        m = getResources().getInteger(0x10e0001);
        setWillNotDraw(false);
        u = new DecelerateInterpolator(2.0F);
        context = context.obtainStyledAttributes(attributeset, v);
        setEnabled(context.getBoolean(0, true));
        context.recycle();
        context = getResources().getDisplayMetrics();
        H = (int)(((DisplayMetrics) (context)).density * 40F);
        I = (int)(((DisplayMetrics) (context)).density * 40F);
        w = new d(getContext(), 0xfffafafa, 20F);
        z = new ah(getContext(), this);
        z.b(0xfffafafa);
        w.setImageDrawable(z);
        w.setVisibility(8);
        addView(w);
        bi.a(this, true);
        F = ((DisplayMetrics) (context)).density * 64F;
        h = F;
        j = new g(this);
        k = new b(this);
        setNestedScrollingEnabled(true);
    }

    private static float a(MotionEvent motionevent, int i1)
    {
        i1 = at.a(motionevent, i1);
        if (i1 < 0)
        {
            return -1F;
        } else
        {
            return at.d(motionevent, i1);
        }
    }

    private Animation a(int i1, int j1)
    {
        if (t && b())
        {
            return null;
        } else
        {
            bc bc1 = new bc(this, i1, j1);
            bc1.setDuration(300L);
            w.a(null);
            w.clearAnimation();
            w.startAnimation(bc1);
            return bc1;
        }
    }

    private void a(float f1)
    {
        z.a(true);
        float f3 = Math.min(1.0F, Math.abs(f1 / h));
        float f4 = ((float)Math.max((double)f3 - 0.40000000000000002D, 0.0D) * 5F) / 3F;
        float f5 = Math.abs(f1);
        float f6 = h;
        float f2;
        int i1;
        int j1;
        if (J)
        {
            f2 = F - (float)b;
        } else
        {
            f2 = F;
        }
        f5 = Math.max(0.0F, Math.min(f5 - f6, f2 * 2.0F) / f2);
        f5 = (float)((double)(f5 / 4F) - Math.pow(f5 / 4F, 2D)) * 2.0F;
        i1 = b;
        j1 = (int)(f2 * f3 + f2 * f5 * 2.0F);
        if (w.getVisibility() != 0)
        {
            w.setVisibility(0);
        }
        if (!t)
        {
            bi.d(w, 1.0F);
            bi.e(w, 1.0F);
        }
        if (f1 >= h) goto _L2; else goto _L1
_L1:
        if (t)
        {
            setAnimationProgress(f1 / h);
        }
        if (z.getAlpha() > 76 && !a(C))
        {
            C = a(z.getAlpha(), 76);
        }
        z.a(0.0F, Math.min(0.8F, f4 * 0.8F));
        z.a(Math.min(1.0F, f4));
_L4:
        z.b((-0.25F + f4 * 0.4F + f5 * 2.0F) * 0.5F);
        a((j1 + i1) - n, true);
        return;
_L2:
        if (z.getAlpha() < 255 && !a(D))
        {
            D = a(z.getAlpha(), 255);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(int i1, boolean flag)
    {
        w.bringToFront();
        w.offsetTopAndBottom(i1);
        n = w.getTop();
        if (flag && android.os.Build.VERSION.SDK_INT < 11)
        {
            invalidate();
        }
    }

    static void a(SwipeRefreshLayout swiperefreshlayout, float f1)
    {
        swiperefreshlayout.setAnimationProgress(f1);
    }

    static void a(SwipeRefreshLayout swiperefreshlayout, int i1)
    {
        swiperefreshlayout.setColorViewAlpha(255);
    }

    static void a(SwipeRefreshLayout swiperefreshlayout, int i1, boolean flag)
    {
        swiperefreshlayout.a(i1, flag);
    }

    static void a(SwipeRefreshLayout swiperefreshlayout, android.view.animation.Animation.AnimationListener animationlistener)
    {
        swiperefreshlayout.a(((android.view.animation.Animation.AnimationListener) (null)));
    }

    private void a(MotionEvent motionevent)
    {
        int i1 = at.b(motionevent);
        if (at.b(motionevent, i1) == s)
        {
            if (i1 == 0)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            s = at.b(motionevent, i1);
        }
    }

    private void a(android.view.animation.Animation.AnimationListener animationlistener)
    {
        B = new bb(this);
        B.setDuration(150L);
        w.a(animationlistener);
        w.clearAnimation();
        w.startAnimation(B);
    }

    private void a(boolean flag, boolean flag1)
    {
label0:
        {
            if (f != flag)
            {
                G = flag1;
                c();
                f = flag;
                if (!f)
                {
                    break label0;
                }
                int i1 = n;
                android.view.animation.Animation.AnimationListener animationlistener = K;
                a = i1;
                L.reset();
                L.setDuration(200L);
                L.setInterpolator(u);
                if (animationlistener != null)
                {
                    w.a(animationlistener);
                }
                w.clearAnimation();
                w.startAnimation(L);
            }
            return;
        }
        a(K);
    }

    static boolean a(SwipeRefreshLayout swiperefreshlayout)
    {
        return swiperefreshlayout.f;
    }

    private static boolean a(Animation animation)
    {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }

    static int b(SwipeRefreshLayout swiperefreshlayout, int i1)
    {
        swiperefreshlayout.n = i1;
        return i1;
    }

    static ah b(SwipeRefreshLayout swiperefreshlayout)
    {
        return swiperefreshlayout.z;
    }

    private void b(float f1)
    {
        if (f1 > h)
        {
            a(true, true);
            return;
        }
        f = false;
        z.a(0.0F, 0.0F);
        bd bd1 = null;
        if (!t)
        {
            bd1 = new bd(this);
        }
        int i1 = n;
        if (t)
        {
            a = i1;
            if (b())
            {
                y = z.getAlpha();
            } else
            {
                y = bi.r(w);
            }
            E = new bh(this);
            E.setDuration(150L);
            if (bd1 != null)
            {
                w.a(bd1);
            }
            w.clearAnimation();
            w.startAnimation(E);
        } else
        {
            a = i1;
            M.reset();
            M.setDuration(200L);
            M.setInterpolator(u);
            if (bd1 != null)
            {
                w.a(bd1);
            }
            w.clearAnimation();
            w.startAnimation(M);
        }
        z.a(false);
    }

    static void b(SwipeRefreshLayout swiperefreshlayout, float f1)
    {
        swiperefreshlayout.a((swiperefreshlayout.a + (int)((float)(swiperefreshlayout.b - swiperefreshlayout.a) * f1)) - swiperefreshlayout.w.getTop(), false);
    }

    private static boolean b()
    {
        return android.os.Build.VERSION.SDK_INT < 11;
    }

    private void c()
    {
        if (d != null) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L7:
        if (i1 >= getChildCount()) goto _L2; else goto _L3
_L3:
        View view = getChildAt(i1);
        if (view.equals(w)) goto _L5; else goto _L4
_L4:
        d = view;
_L2:
        return;
_L5:
        i1++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    static boolean c(SwipeRefreshLayout swiperefreshlayout)
    {
        return swiperefreshlayout.G;
    }

    static android.support.v4.widget.bi d(SwipeRefreshLayout swiperefreshlayout)
    {
        return swiperefreshlayout.e;
    }

    private boolean d()
    {
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            if (d instanceof AbsListView)
            {
                AbsListView abslistview = (AbsListView)d;
                return abslistview.getChildCount() > 0 && (abslistview.getFirstVisiblePosition() > 0 || abslistview.getChildAt(0).getTop() < abslistview.getPaddingTop());
            }
            return bi.b(d, -1) || d.getScrollY() > 0;
        } else
        {
            return bi.b(d, -1);
        }
    }

    static d e(SwipeRefreshLayout swiperefreshlayout)
    {
        return swiperefreshlayout.w;
    }

    static boolean f(SwipeRefreshLayout swiperefreshlayout)
    {
        return swiperefreshlayout.t;
    }

    static int g(SwipeRefreshLayout swiperefreshlayout)
    {
        return swiperefreshlayout.n;
    }

    static boolean h(SwipeRefreshLayout swiperefreshlayout)
    {
        return swiperefreshlayout.J;
    }

    static float i(SwipeRefreshLayout swiperefreshlayout)
    {
        return swiperefreshlayout.F;
    }

    static float j(SwipeRefreshLayout swiperefreshlayout)
    {
        return swiperefreshlayout.y;
    }

    private void setAnimationProgress(float f1)
    {
        if (b())
        {
            setColorViewAlpha((int)(255F * f1));
            return;
        } else
        {
            bi.d(w, f1);
            bi.e(w, f1);
            return;
        }
    }

    private void setColorViewAlpha(int i1)
    {
        w.getBackground().setAlpha(i1);
        z.setAlpha(i1);
    }

    public final void a(boolean flag, int i1, int j1)
    {
        t = true;
        w.setVisibility(8);
        n = i1;
        b = i1;
        F = j1;
        J = true;
        w.invalidate();
    }

    public final boolean a()
    {
        return f;
    }

    public boolean dispatchNestedFling(float f1, float f2, boolean flag)
    {
        return k.a(f1, f2, flag);
    }

    public boolean dispatchNestedPreFling(float f1, float f2)
    {
        return k.a(f1, f2);
    }

    public boolean dispatchNestedPreScroll(int i1, int j1, int ai[], int ai1[])
    {
        return k.a(i1, j1, ai, ai1);
    }

    public boolean dispatchNestedScroll(int i1, int j1, int k1, int l1, int ai[])
    {
        return k.a(i1, j1, k1, l1, ai);
    }

    protected int getChildDrawingOrder(int i1, int j1)
    {
        if (x >= 0)
        {
            if (j1 == i1 - 1)
            {
                return x;
            }
            if (j1 >= x)
            {
                return j1 + 1;
            }
        }
        return j1;
    }

    public int getNestedScrollAxes()
    {
        return j.a();
    }

    public int getProgressCircleDiameter()
    {
        if (w != null)
        {
            return w.getMeasuredHeight();
        } else
        {
            return 0;
        }
    }

    public boolean hasNestedScrollingParent()
    {
        return k.c();
    }

    public boolean isNestedScrollingEnabled()
    {
        return k.b();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i1;
        c();
        i1 = at.a(motionevent);
        if (isEnabled() && !d() && !f) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        i1;
        JVM INSTR tableswitch 0 6: default 76
    //                   0 81
    //                   1 233
    //                   2 136
    //                   3 233
    //                   4 76
    //                   5 76
    //                   6 225;
           goto _L3 _L4 _L5 _L6 _L5 _L3 _L3 _L7
_L3:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_233;
_L9:
        return r;
_L4:
        float f1;
        a(b - w.getTop(), true);
        s = at.b(motionevent, 0);
        r = false;
        f1 = a(motionevent, s);
        if (f1 == -1F) goto _L1; else goto _L8
_L8:
        q = f1;
          goto _L9
_L6:
        if (s == -1)
        {
            Log.e(c, "Got ACTION_MOVE event but don't have an active pointer id.");
            return false;
        }
        f1 = a(motionevent, s);
        if (f1 == -1F) goto _L1; else goto _L10
_L10:
        if (f1 - q > (float)g && !r)
        {
            p = q + (float)g;
            r = true;
            z.setAlpha(76);
        }
          goto _L9
_L7:
        a(motionevent);
          goto _L9
        r = false;
        s = -1;
          goto _L9
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        i1 = getMeasuredWidth();
        j1 = getMeasuredHeight();
        if (getChildCount() != 0)
        {
            if (d == null)
            {
                c();
            }
            if (d != null)
            {
                View view = d;
                k1 = getPaddingLeft();
                l1 = getPaddingTop();
                view.layout(k1, l1, (i1 - getPaddingLeft() - getPaddingRight()) + k1, (j1 - getPaddingTop() - getPaddingBottom()) + l1);
                j1 = w.getMeasuredWidth();
                k1 = w.getMeasuredHeight();
                w.layout(i1 / 2 - j1 / 2, n, i1 / 2 + j1 / 2, n + k1);
                return;
            }
        }
    }

    public void onMeasure(int i1, int j1)
    {
        super.onMeasure(i1, j1);
        if (d == null)
        {
            c();
        }
        if (d != null)
        {
            d.measure(android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 0x40000000));
            w.measure(android.view.View.MeasureSpec.makeMeasureSpec(H, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(I, 0x40000000));
            if (!J && !o)
            {
                o = true;
                i1 = -w.getMeasuredHeight();
                b = i1;
                n = i1;
            }
            x = -1;
            i1 = 0;
            while (i1 < getChildCount()) 
            {
                if (getChildAt(i1) == w)
                {
                    x = i1;
                    return;
                }
                i1++;
            }
        }
    }

    public boolean onNestedFling(View view, float f1, float f2, boolean flag)
    {
        return false;
    }

    public boolean onNestedPreFling(View view, float f1, float f2)
    {
        return false;
    }

    public void onNestedPreScroll(View view, int i1, int j1, int ai[])
    {
        if (j1 > 0 && i > 0.0F)
        {
            if ((float)j1 > i)
            {
                ai[1] = j1 - (int)i;
                i = 0.0F;
            } else
            {
                i = i - (float)j1;
                ai[1] = j1;
            }
            a(i);
        }
        view = l;
        if (dispatchNestedPreScroll(i1 - ai[0], j1 - ai[1], view, null))
        {
            ai[0] = ai[0] + view[0];
            i1 = ai[1];
            ai[1] = view[1] + i1;
        }
    }

    public void onNestedScroll(View view, int i1, int j1, int k1, int l1)
    {
        if (l1 < 0)
        {
            l1 = Math.abs(l1);
            float f1 = i;
            i = (float)l1 + f1;
            a(i);
        }
        dispatchNestedScroll(i1, j1, k1, i1, null);
    }

    public void onNestedScrollAccepted(View view, View view1, int i1)
    {
        j.a(i1);
        i = 0.0F;
    }

    public boolean onStartNestedScroll(View view, View view1, int i1)
    {
        if (isEnabled() && (i1 & 2) != 0)
        {
            startNestedScroll(i1 & 2);
            return true;
        } else
        {
            return false;
        }
    }

    public void onStopNestedScroll(View view)
    {
        j.b();
        if (i > 0.0F)
        {
            b(i);
            i = 0.0F;
        }
        stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i1 = at.a(motionevent);
        if (isEnabled() && !d()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        i1;
        JVM INSTR tableswitch 0 6: default 68
    //                   0 70
    //                   1 174
    //                   2 87
    //                   3 174
    //                   4 68
    //                   5 151
    //                   6 166;
           goto _L3 _L4 _L5 _L6 _L5 _L3 _L7 _L8
_L3:
        return true;
_L4:
        s = at.b(motionevent, 0);
        r = false;
        continue; /* Loop/switch isn't completed */
_L6:
        i1 = at.a(motionevent, s);
        if (i1 < 0)
        {
            Log.e(c, "Got ACTION_MOVE event but have an invalid active pointer id.");
            return false;
        }
        float f1 = (at.d(motionevent, i1) - p) * 0.5F;
        if (r)
        {
            if (f1 <= 0.0F)
            {
                continue; /* Loop/switch isn't completed */
            }
            a(f1);
        }
        continue; /* Loop/switch isn't completed */
_L7:
        s = at.b(motionevent, at.b(motionevent));
        continue; /* Loop/switch isn't completed */
_L8:
        a(motionevent);
        if (true) goto _L3; else goto _L5
_L5:
        if (s == -1)
        {
            if (i1 == 1)
            {
                Log.e(c, "Got ACTION_UP event but don't have an active pointer id.");
                return false;
            }
        } else
        {
            float f2 = at.d(motionevent, at.a(motionevent, s));
            float f3 = p;
            r = false;
            b((f2 - f3) * 0.5F);
            s = -1;
            return false;
        }
        if (true) goto _L1; else goto _L9
_L9:
    }

    public void requestDisallowInterceptTouchEvent(boolean flag)
    {
        if ((android.os.Build.VERSION.SDK_INT >= 21 || !(d instanceof AbsListView)) && (d == null || bi.z(d)))
        {
            super.requestDisallowInterceptTouchEvent(flag);
        }
    }

    public transient void setColorScheme(int ai[])
    {
        setColorSchemeResources(ai);
    }

    public transient void setColorSchemeColors(int ai[])
    {
        c();
        z.a(ai);
    }

    public transient void setColorSchemeResources(int ai[])
    {
        Resources resources = getResources();
        int ai1[] = new int[ai.length];
        for (int i1 = 0; i1 < ai.length; i1++)
        {
            ai1[i1] = resources.getColor(ai[i1]);
        }

        setColorSchemeColors(ai1);
    }

    public void setDistanceToTriggerSync(int i1)
    {
        h = i1;
    }

    public void setNestedScrollingEnabled(boolean flag)
    {
        k.a(flag);
    }

    public void setOnRefreshListener(android.support.v4.widget.bi bi1)
    {
        e = bi1;
    }

    public void setProgressBackgroundColor(int i1)
    {
        setProgressBackgroundColorSchemeResource(i1);
    }

    public void setProgressBackgroundColorSchemeColor(int i1)
    {
        w.setBackgroundColor(i1);
        z.b(i1);
    }

    public void setProgressBackgroundColorSchemeResource(int i1)
    {
        setProgressBackgroundColorSchemeColor(getResources().getColor(i1));
    }

    public void setRefreshing(boolean flag)
    {
        if (flag && f != flag)
        {
            f = flag;
            android.view.animation.Animation.AnimationListener animationlistener;
            int i1;
            if (!J)
            {
                i1 = (int)(F + (float)b);
            } else
            {
                i1 = (int)F;
            }
            a(i1 - n, true);
            G = false;
            animationlistener = K;
            w.setVisibility(0);
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                z.setAlpha(255);
            }
            A = new ba(this);
            A.setDuration(m);
            if (animationlistener != null)
            {
                w.a(animationlistener);
            }
            w.clearAnimation();
            w.startAnimation(A);
            return;
        } else
        {
            a(flag, false);
            return;
        }
    }

    public void setSize(int i1)
    {
        if (i1 != 0 && i1 != 1)
        {
            return;
        }
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        if (i1 == 0)
        {
            int j1 = (int)(displaymetrics.density * 56F);
            H = j1;
            I = j1;
        } else
        {
            int k1 = (int)(displaymetrics.density * 40F);
            H = k1;
            I = k1;
        }
        w.setImageDrawable(null);
        z.a(i1);
        w.setImageDrawable(z);
    }

    public boolean startNestedScroll(int i1)
    {
        return k.a(i1);
    }

    public void stopNestedScroll()
    {
        k.d();
    }

}
