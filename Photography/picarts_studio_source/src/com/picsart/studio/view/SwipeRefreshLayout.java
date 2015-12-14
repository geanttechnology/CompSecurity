// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import com.melnykov.fab.a;

// Referenced classes of package com.picsart.studio.view:
//            l, m

public class SwipeRefreshLayout extends ViewGroup
{

    private static final int r[] = {
        0x101000e
    };
    private l a;
    private View b;
    private int c;
    private MotionEvent d;
    private int e;
    private boolean f;
    private int g;
    private float h;
    private float i;
    private int j;
    private float k;
    private float l;
    private int m;
    private int n;
    private boolean o;
    private final DecelerateInterpolator p;
    private final AccelerateInterpolator q;
    private final Animation s;
    private Animation t = new Animation() {

        private SwipeRefreshLayout a;

        public final void applyTransformation(float f1, Transformation transformation)
        {
            float f2 = SwipeRefreshLayout.d(a);
            float f3 = SwipeRefreshLayout.d(a);
            SwipeRefreshLayout.e(a).a(f2 + (0.0F - f3) * f1);
        }

            
            {
                a = SwipeRefreshLayout.this;
                super();
            }
    };
    private final android.view.animation.Animation.AnimationListener u;
    private final android.view.animation.Animation.AnimationListener v;
    private final Runnable w;
    private final Runnable x;

    public SwipeRefreshLayout(Context context)
    {
        this(context, null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        f = false;
        h = -1F;
        k = 0.0F;
        l = 0.0F;
        s = new Animation() {

            private SwipeRefreshLayout a;

            public final void applyTransformation(float f1, Transformation transformation)
            {
                int i1 = 0;
                if (com.picsart.studio.view.SwipeRefreshLayout.a(a) != SwipeRefreshLayout.b(a))
                {
                    i1 = com.picsart.studio.view.SwipeRefreshLayout.a(a) + (int)((float)(SwipeRefreshLayout.b(a) - com.picsart.studio.view.SwipeRefreshLayout.a(a)) * f1);
                }
                int j1 = i1 - SwipeRefreshLayout.c(a).getTop();
                int k1 = SwipeRefreshLayout.c(a).getTop();
                i1 = j1;
                if (j1 + k1 < 0)
                {
                    i1 = 0 - k1;
                }
                com.picsart.studio.view.SwipeRefreshLayout.a(a, i1);
            }

            
            {
                a = SwipeRefreshLayout.this;
                super();
            }
        };
        u = new m() {

            private SwipeRefreshLayout a;

            public final void onAnimationEnd(Animation animation)
            {
                SwipeRefreshLayout.f(a);
            }

            
            {
                a = SwipeRefreshLayout.this;
                super(SwipeRefreshLayout.this);
            }
        };
        v = new m() {

            private SwipeRefreshLayout a;

            public final void onAnimationEnd(Animation animation)
            {
                SwipeRefreshLayout.g(a);
            }

            
            {
                a = SwipeRefreshLayout.this;
                super(SwipeRefreshLayout.this);
            }
        };
        w = new Runnable() {

            private SwipeRefreshLayout a;

            public final void run()
            {
                SwipeRefreshLayout.h(a);
                com.picsart.studio.view.SwipeRefreshLayout.a(a, SwipeRefreshLayout.i(a) + a.getPaddingTop(), SwipeRefreshLayout.j(a));
            }

            
            {
                a = SwipeRefreshLayout.this;
                super();
            }
        };
        x = new Runnable() {

            private SwipeRefreshLayout a;

            public final void run()
            {
                SwipeRefreshLayout.h(a);
                if (SwipeRefreshLayout.e(a) != null)
                {
                    com.picsart.studio.view.SwipeRefreshLayout.a(a, SwipeRefreshLayout.k(a));
                    SwipeRefreshLayout.m(a).setDuration(SwipeRefreshLayout.l(a));
                    SwipeRefreshLayout.m(a).setAnimationListener(SwipeRefreshLayout.n(a));
                    SwipeRefreshLayout.m(a).reset();
                    SwipeRefreshLayout.m(a).setInterpolator(SwipeRefreshLayout.o(a));
                    a.startAnimation(SwipeRefreshLayout.m(a));
                }
                com.picsart.studio.view.SwipeRefreshLayout.a(a, SwipeRefreshLayout.i(a) + a.getPaddingTop(), SwipeRefreshLayout.j(a));
            }

            
            {
                a = SwipeRefreshLayout.this;
                super();
            }
        };
        g = ViewConfiguration.get(context).getScaledTouchSlop();
        j = getResources().getInteger(0x10e0001);
        setWillNotDraw(false);
        a = new l(this);
        m = (int)(getResources().getDisplayMetrics().density * 4F);
        p = new DecelerateInterpolator(2.0F);
        q = new AccelerateInterpolator(1.5F);
        context = context.obtainStyledAttributes(attributeset, r);
        setEnabled(context.getBoolean(0, true));
        context.recycle();
    }

    static float a(SwipeRefreshLayout swiperefreshlayout, float f1)
    {
        swiperefreshlayout.k = f1;
        return f1;
    }

    static int a(SwipeRefreshLayout swiperefreshlayout)
    {
        return swiperefreshlayout.e;
    }

    private void a()
    {
        if (b == null)
        {
            if (getChildCount() > 1 && !isInEditMode())
            {
                throw new IllegalStateException("SwipeRefreshLayout can host only one direct child");
            }
            b = getChildAt(0);
            c = b.getTop() + getPaddingTop();
        }
        if (h == -1F && getParent() != null && ((View)getParent()).getHeight() > 0)
        {
            DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
            h = (int)Math.min((float)((View)getParent()).getHeight() * 0.6F, displaymetrics.density * 120F);
        }
    }

    private void a(int i1)
    {
        b.offsetTopAndBottom(i1);
        n = b.getTop();
    }

    static void a(SwipeRefreshLayout swiperefreshlayout, int i1)
    {
        swiperefreshlayout.a(i1);
    }

    static void a(SwipeRefreshLayout swiperefreshlayout, int i1, android.view.animation.Animation.AnimationListener animationlistener)
    {
        swiperefreshlayout.e = i1;
        swiperefreshlayout.s.reset();
        swiperefreshlayout.s.setDuration(swiperefreshlayout.j);
        swiperefreshlayout.s.setAnimationListener(animationlistener);
        swiperefreshlayout.s.setInterpolator(swiperefreshlayout.p);
        swiperefreshlayout.b.startAnimation(swiperefreshlayout.s);
    }

    static int b(SwipeRefreshLayout swiperefreshlayout)
    {
        return swiperefreshlayout.c;
    }

    static View c(SwipeRefreshLayout swiperefreshlayout)
    {
        return swiperefreshlayout.b;
    }

    static float d(SwipeRefreshLayout swiperefreshlayout)
    {
        return swiperefreshlayout.k;
    }

    static l e(SwipeRefreshLayout swiperefreshlayout)
    {
        return swiperefreshlayout.a;
    }

    static int f(SwipeRefreshLayout swiperefreshlayout)
    {
        swiperefreshlayout.n = 0;
        return 0;
    }

    static float g(SwipeRefreshLayout swiperefreshlayout)
    {
        swiperefreshlayout.l = 0.0F;
        return 0.0F;
    }

    static boolean h(SwipeRefreshLayout swiperefreshlayout)
    {
        swiperefreshlayout.o = true;
        return true;
    }

    static int i(SwipeRefreshLayout swiperefreshlayout)
    {
        return swiperefreshlayout.n;
    }

    static android.view.animation.Animation.AnimationListener j(SwipeRefreshLayout swiperefreshlayout)
    {
        return swiperefreshlayout.u;
    }

    static float k(SwipeRefreshLayout swiperefreshlayout)
    {
        return swiperefreshlayout.l;
    }

    static int l(SwipeRefreshLayout swiperefreshlayout)
    {
        return swiperefreshlayout.j;
    }

    static Animation m(SwipeRefreshLayout swiperefreshlayout)
    {
        return swiperefreshlayout.t;
    }

    static android.view.animation.Animation.AnimationListener n(SwipeRefreshLayout swiperefreshlayout)
    {
        return swiperefreshlayout.v;
    }

    static DecelerateInterpolator o(SwipeRefreshLayout swiperefreshlayout)
    {
        return swiperefreshlayout.p;
    }

    public void draw(Canvas canvas)
    {
label0:
        {
            {
                super.draw(canvas);
                l l1 = a;
                int i1 = l1.l.width();
                int j1 = l1.l.height();
                int k1 = i1 / 2;
                int i2 = j1 / 2;
                i1 = canvas.save();
                canvas.clipRect(l1.l);
                if (!l1.f && l1.e <= 0L)
                {
                    break label0;
                }
                long l2 = AnimationUtils.currentAnimationTimeMillis();
                long l3 = l1.d;
                long l4 = (l2 - l1.d) / 2000L;
                float f1 = (float)((l2 - l3) % 2000L) / 20F;
                if (!l1.f)
                {
                    if (l2 - l1.e >= 1000L)
                    {
                        l1.e = 0L;
                        return;
                    }
                    float f2 = (float)((l2 - l1.e) % 1000L) / 10F / 100F;
                    float f7 = k1;
                    f2 = com.picsart.studio.view.l.a.getInterpolation(f2) * f7;
                    l1.b.set((float)k1 - f2, 0.0F, f2 + (float)k1, j1);
                    canvas.saveLayerAlpha(l1.b, 0, 0);
                    j1 = 1;
                } else
                {
                    j1 = 0;
                }
                if (l4 == 0L)
                {
                    canvas.drawColor(l1.g);
                } else
                if (f1 >= 0.0F && f1 < 25F)
                {
                    canvas.drawColor(l1.j);
                } else
                if (f1 >= 25F && f1 < 50F)
                {
                    canvas.drawColor(l1.g);
                } else
                if (f1 >= 50F && f1 < 75F)
                {
                    canvas.drawColor(l1.h);
                } else
                {
                    canvas.drawColor(l1.i);
                }
                if (f1 >= 0.0F && f1 <= 25F)
                {
                    float f3 = ((25F + f1) * 2.0F) / 100F;
                    l1.a(canvas, k1, i2, l1.g, f3);
                }
                if (f1 >= 0.0F && f1 <= 50F)
                {
                    float f4 = (2.0F * f1) / 100F;
                    l1.a(canvas, k1, i2, l1.h, f4);
                }
                if (f1 >= 25F && f1 <= 75F)
                {
                    float f5 = ((f1 - 25F) * 2.0F) / 100F;
                    l1.a(canvas, k1, i2, l1.i, f5);
                }
                if (f1 >= 50F && f1 <= 100F)
                {
                    float f6 = ((f1 - 50F) * 2.0F) / 100F;
                    l1.a(canvas, k1, i2, l1.j, f6);
                }
                if (f1 >= 75F && f1 <= 100F)
                {
                    f1 = ((f1 - 75F) * 2.0F) / 100F;
                    l1.a(canvas, k1, i2, l1.g, f1);
                }
                if (l1.c > 0.0F && j1 != 0)
                {
                    canvas.restoreToCount(i1);
                    i1 = canvas.save();
                    canvas.clipRect(l1.l);
                    l1.a(canvas, k1, i2);
                }
                ViewCompat.postInvalidateOnAnimation(l1.k);
                j1 = i1;
            }
            canvas.restoreToCount(j1);
            return;
        }
        j1 = i1;
        if (l1.c > 0.0F)
        {
            j1 = i1;
            if ((double)l1.c <= 1.0D)
            {
                l1.a(canvas, k1, i2);
                j1 = i1;
            }
        }
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_522;
        }
    }

    public void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        removeCallbacks(x);
        removeCallbacks(w);
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        removeCallbacks(w);
        removeCallbacks(x);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        a();
        if (o && motionevent.getAction() == 0)
        {
            o = false;
        }
        if (!isEnabled() || o) goto _L2; else goto _L1
_L1:
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            if (b instanceof AbsListView)
            {
                AbsListView abslistview = (AbsListView)b;
                boolean flag1;
                if (abslistview.getChildCount() > 0 && (abslistview.getFirstVisiblePosition() > 0 || abslistview.getChildAt(0).getTop() < abslistview.getPaddingTop()))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            if (b.getScrollY() > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            flag = ViewCompat.canScrollVertically(b, -1);
        }
        if (flag) goto _L2; else goto _L3
_L3:
        flag = onTouchEvent(motionevent);
_L5:
        flag1 = flag;
        if (!flag)
        {
            flag1 = super.onInterceptTouchEvent(motionevent);
        }
        return flag1;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        i1 = getMeasuredWidth();
        j1 = getMeasuredHeight();
        l l2 = a;
        k1 = m;
        l2.l.left = 0;
        l2.l.top = 0;
        l2.l.right = i1;
        l2.l.bottom = k1;
        if (getChildCount() == 0)
        {
            return;
        } else
        {
            View view = getChildAt(0);
            k1 = getPaddingLeft();
            l1 = n + getPaddingTop();
            view.layout(k1, l1, (i1 - getPaddingLeft() - getPaddingRight()) + k1, (j1 - getPaddingTop() - getPaddingBottom()) + l1);
            return;
        }
    }

    public void onMeasure(int i1, int j1)
    {
        super.onMeasure(i1, j1);
        if (getChildCount() > 1 && !isInEditMode())
        {
            throw new IllegalStateException("SwipeRefreshLayout can host only one direct child");
        }
        if (getChildCount() > 0)
        {
            getChildAt(0).measure(android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 0x40000000));
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 36
    //                   0 38
    //                   1 322
    //                   2 64
    //                   3 322;
           goto _L1 _L2 _L3 _L4 _L3
_L1:
        return false;
_L2:
        l = 0.0F;
        d = MotionEvent.obtain(motionevent);
        i = d.getY();
        return false;
_L4:
        if (d != null && !o)
        {
            float f3 = motionevent.getY();
            float f2 = f3 - d.getY();
            if (f2 > (float)g)
            {
                if (f2 > h)
                {
                    removeCallbacks(x);
                    w.run();
                    setRefreshing(true);
                    return true;
                }
                float f1 = q.getInterpolation(f2 / h);
                int i1;
                int j1;
                int k1;
                if (f1 == 0.0F)
                {
                    l = 0.0F;
                } else
                {
                    l = f1;
                    a.a(f1);
                }
                f1 = f2;
                if (i > f3)
                {
                    f1 = f2 - (float)g;
                }
                j1 = (int)f1;
                k1 = b.getTop();
                if ((float)j1 > h)
                {
                    i1 = (int)h;
                } else
                {
                    i1 = j1;
                    if (j1 < 0)
                    {
                        i1 = 0;
                    }
                }
                a(i1 - k1);
                if (i > f3 && b.getTop() < g)
                {
                    removeCallbacks(x);
                } else
                {
                    removeCallbacks(x);
                    postDelayed(x, 300L);
                }
                i = motionevent.getY();
                return true;
            }
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (d != null)
        {
            d.recycle();
            d = null;
            return false;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void requestDisallowInterceptTouchEvent(boolean flag)
    {
    }

    public void setColorScheme(int i1, int j1, int k1, int l1)
    {
        a();
        Object obj = getResources();
        i1 = ((Resources) (obj)).getColor(i1);
        j1 = ((Resources) (obj)).getColor(j1);
        k1 = ((Resources) (obj)).getColor(k1);
        l1 = ((Resources) (obj)).getColor(l1);
        obj = a;
        obj.g = i1;
        obj.h = j1;
        obj.i = k1;
        obj.j = l1;
    }

    public void setOnRefreshListener$d83d4c7(a a1)
    {
    }

    public void setRefreshing(boolean flag)
    {
        if (f != flag)
        {
            a();
            l = 0.0F;
            f = flag;
            if (f)
            {
                l l1 = a;
                if (!l1.f)
                {
                    l1.c = 0.0F;
                    l1.d = AnimationUtils.currentAnimationTimeMillis();
                    l1.f = true;
                    l1.k.postInvalidate();
                }
            } else
            {
                l l2 = a;
                if (l2.f)
                {
                    l2.c = 0.0F;
                    l2.e = AnimationUtils.currentAnimationTimeMillis();
                    l2.f = false;
                    l2.k.postInvalidate();
                    return;
                }
            }
        }
    }

}
