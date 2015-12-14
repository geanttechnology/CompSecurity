// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ScrollerCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import myobfuscated.bf.a;

// Referenced classes of package com.picsart.studio.view:
//            j, n, o, k

public class SlidingUpPanelLayout extends ViewGroup
{

    private static PanelState d;
    private static final int e[] = {
        0x10100af
    };
    private float A;
    private final n B;
    private final Rect C;
    public PanelState a;
    k b;
    public boolean c;
    private int f;
    private int g;
    private final Paint h;
    private final Drawable i;
    private int j;
    private int k;
    private int l;
    private boolean m;
    private boolean n;
    private View o;
    private int p;
    private View q;
    private View r;
    private Context s;
    private float t;
    private int u;
    private boolean v;
    private boolean w;
    private boolean x;
    private float y;
    private float z;

    public SlidingUpPanelLayout(Context context)
    {
        this(context, null);
        s = context;
    }

    public SlidingUpPanelLayout(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
        s = context;
    }

    public SlidingUpPanelLayout(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        f = 400;
        g = 0x99000000;
        h = new Paint();
        j = -1;
        k = -1;
        l = -1;
        n = false;
        p = -1;
        a = PanelState.COLLAPSED;
        A = 1.0F;
        c = true;
        C = new Rect();
        s = context;
        if (isInEditMode())
        {
            i = null;
            B = null;
            return;
        }
        if (attributeset != null)
        {
            TypedArray typedarray = context.obtainStyledAttributes(attributeset, e);
            if (typedarray != null)
            {
                i1 = typedarray.getInt(0, 0);
                if (i1 != 48 && i1 != 80)
                {
                    throw new IllegalArgumentException("gravity must be set to either top or bottom");
                }
                float f1;
                boolean flag;
                if (i1 == 80)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                m = flag;
            }
            typedarray.recycle();
            attributeset = context.obtainStyledAttributes(attributeset, a.SlidingUpPanelLayout);
            if (attributeset != null)
            {
                j = attributeset.getDimensionPixelSize(a.SlidingUpPanelLayout_panelHeight, -1);
                k = attributeset.getDimensionPixelSize(a.SlidingUpPanelLayout_shadowHeight, -1);
                l = attributeset.getDimensionPixelSize(a.SlidingUpPanelLayout_paralaxOffset, -1);
                f = attributeset.getInt(a.SlidingUpPanelLayout_flingVelocity, 400);
                g = attributeset.getColor(a.SlidingUpPanelLayout_fadeColor, 0x99000000);
                p = attributeset.getResourceId(a.SlidingUpPanelLayout_dragView, -1);
                n = attributeset.getBoolean(a.SlidingUpPanelLayout_overlay, false);
                A = attributeset.getFloat(a.SlidingUpPanelLayout_anchorPoint, 1.0F);
                a = PanelState.values()[attributeset.getInt(a.SlidingUpPanelLayout_initialState, d.ordinal())];
            }
            attributeset.recycle();
        }
        f1 = context.getResources().getDisplayMetrics().density;
        if (j == -1)
        {
            j = (int)(68F * f1 + 0.5F);
        }
        if (k == -1)
        {
            k = (int)(4F * f1 + 0.5F);
        }
        if (l == -1)
        {
            l = (int)(0.0F * f1);
        }
        if (k > 0)
        {
            if (m)
            {
                i = getResources().getDrawable(0x7f02003b);
            } else
            {
                i = getResources().getDrawable(0x7f020073);
            }
        } else
        {
            i = null;
        }
        setWillNotDraw(false);
        B = com.picsart.studio.view.n.a(this, new j(this, (byte)0));
        B.j = f1 * (float)f;
        w = true;
    }

    private float a(int i1)
    {
        int j1 = b(0.0F);
        if (m)
        {
            return (float)(j1 - i1) / (float)u;
        } else
        {
            return (float)(i1 - j1) / (float)u;
        }
    }

    static float a(SlidingUpPanelLayout slidinguppanellayout)
    {
        return slidinguppanellayout.A;
    }

    static float a(SlidingUpPanelLayout slidinguppanellayout, float f1)
    {
        slidinguppanellayout.t = f1;
        return f1;
    }

    static float a(SlidingUpPanelLayout slidinguppanellayout, int i1)
    {
        return slidinguppanellayout.a(i1);
    }

    static PanelState a(SlidingUpPanelLayout slidinguppanellayout, PanelState panelstate)
    {
        slidinguppanellayout.a = panelstate;
        return panelstate;
    }

    private int b(float f1)
    {
        int i1;
        int j1;
        if (q != null)
        {
            i1 = q.getMeasuredHeight();
        } else
        {
            i1 = 0;
        }
        j1 = (int)((float)u * f1);
        if (m)
        {
            return getMeasuredHeight() - getPaddingBottom() - j - j1;
        } else
        {
            return (getPaddingTop() - i1) + j + j1;
        }
    }

    static int b(SlidingUpPanelLayout slidinguppanellayout, float f1)
    {
        return slidinguppanellayout.b(f1);
    }

    static void b(SlidingUpPanelLayout slidinguppanellayout, int i1)
    {
        slidinguppanellayout.a = PanelState.DRAGGING;
        slidinguppanellayout.t = slidinguppanellayout.a(i1);
        if (slidinguppanellayout.l > 0 && slidinguppanellayout.t >= 0.0F)
        {
            int k1 = (int)((float)slidinguppanellayout.l * Math.max(slidinguppanellayout.t, 0.0F));
            int j1 = k1;
            if (slidinguppanellayout.m)
            {
                j1 = -k1;
            }
            LayoutParams layoutparams;
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                slidinguppanellayout.r.setTranslationY(j1);
            } else
            {
                myobfuscated.at.a.a(slidinguppanellayout.r).b(j1);
            }
        }
        if (slidinguppanellayout.t <= 0.0F && !slidinguppanellayout.n)
        {
            layoutparams = (LayoutParams)slidinguppanellayout.r.getLayoutParams();
            if (slidinguppanellayout.m)
            {
                i1 -= slidinguppanellayout.getPaddingBottom();
            } else
            {
                i1 = slidinguppanellayout.getHeight() - slidinguppanellayout.getPaddingBottom() - slidinguppanellayout.q.getMeasuredHeight() - i1;
            }
            layoutparams.height = i1;
            slidinguppanellayout.r.requestLayout();
        }
    }

    static boolean b(SlidingUpPanelLayout slidinguppanellayout)
    {
        return slidinguppanellayout.v;
    }

    static View c(SlidingUpPanelLayout slidinguppanellayout)
    {
        return slidinguppanellayout.q;
    }

    private boolean c(float f1)
    {
        if (f())
        {
            int i1 = b(f1);
            n n1 = B;
            View view = q;
            int j1 = q.getLeft();
            n1.m = view;
            n1.c = -1;
            if (n1.a(j1, i1, 0, 0))
            {
                b();
                ViewCompat.postInvalidateOnAnimation(this);
                return true;
            }
        }
        return false;
    }

    static n d(SlidingUpPanelLayout slidinguppanellayout)
    {
        return slidinguppanellayout.B;
    }

    static float e(SlidingUpPanelLayout slidinguppanellayout)
    {
        return slidinguppanellayout.t;
    }

    static PanelState f(SlidingUpPanelLayout slidinguppanellayout)
    {
        return slidinguppanellayout.a;
    }

    private boolean f()
    {
        return w && q != null;
    }

    static boolean g(SlidingUpPanelLayout slidinguppanellayout)
    {
        return slidinguppanellayout.m;
    }

    static int h(SlidingUpPanelLayout slidinguppanellayout)
    {
        return slidinguppanellayout.u;
    }

    final void a()
    {
        int i2;
        boolean flag;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        flag = false;
        if (getChildCount() == 0)
        {
            return;
        }
        j3 = getPaddingLeft();
        k2 = getWidth();
        l2 = getPaddingRight();
        i3 = getPaddingTop();
        i2 = getHeight();
        j2 = getPaddingBottom();
        if (q == null) goto _L2; else goto _L1
_L1:
        int i1;
        int j1;
        int k1;
        int l1;
        Object obj = q.getBackground();
        if (obj != null && ((Drawable) (obj)).getOpacity() == -1)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 == 0) goto _L2; else goto _L3
_L3:
        l1 = q.getLeft();
        k1 = q.getRight();
        j1 = q.getTop();
        i1 = q.getBottom();
_L5:
        obj = getChildAt(0);
        j3 = Math.max(j3, ((View) (obj)).getLeft());
        i3 = Math.max(i3, ((View) (obj)).getTop());
        k2 = Math.min(k2 - l2, ((View) (obj)).getRight());
        j2 = Math.min(i2 - j2, ((View) (obj)).getBottom());
        i2 = ((flag) ? 1 : 0);
        if (j3 >= l1)
        {
            i2 = ((flag) ? 1 : 0);
            if (i3 >= j1)
            {
                i2 = ((flag) ? 1 : 0);
                if (k2 <= k1)
                {
                    i2 = ((flag) ? 1 : 0);
                    if (j2 <= i1)
                    {
                        i2 = 4;
                    }
                }
            }
        }
        ((View) (obj)).setVisibility(i2);
        return;
_L2:
        i1 = 0;
        j1 = 0;
        k1 = 0;
        l1 = 0;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final boolean a(float f1)
    {
        if (q != null && (a != PanelState.EXPANDED || f1 != 1.0F))
        {
            q.setVisibility(0);
            if (c || c(f1))
            {
                return true;
            }
        }
        return false;
    }

    final void b()
    {
        int j1 = getChildCount();
        for (int i1 = 0; i1 < j1; i1++)
        {
            View view = getChildAt(i1);
            if (view.getVisibility() == 4)
            {
                view.setVisibility(0);
            }
        }

    }

    public final boolean c()
    {
        if (c)
        {
            a = PanelState.COLLAPSED;
        } else
        {
            if (a == PanelState.HIDDEN || a == PanelState.COLLAPSED)
            {
                return false;
            }
            if (!c && !c(0.0F))
            {
                return false;
            }
        }
        return true;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return (layoutparams instanceof LayoutParams) && super.checkLayoutParams(layoutparams);
    }

    public void computeScroll()
    {
        if (B == null) goto _L2; else goto _L1
_L1:
        n n1 = B;
        if (n1.m == null) goto _L4; else goto _L3
_L3:
        if (n1.a == 2)
        {
            boolean flag1 = n1.k.computeScrollOffset();
            int i1 = n1.k.getCurrX();
            int k1 = n1.k.getCurrY();
            int l1 = i1 - n1.m.getLeft();
            int i2 = k1 - n1.m.getTop();
            if (l1 != 0)
            {
                n1.m.offsetLeftAndRight(l1);
            }
            if (i2 != 0)
            {
                n1.m.offsetTopAndBottom(i2);
            }
            if (l1 != 0 || i2 != 0)
            {
                n1.l.a(k1);
            }
            boolean flag = flag1;
            if (flag1)
            {
                flag = flag1;
                if (i1 == n1.k.getFinalX())
                {
                    flag = flag1;
                    if (k1 == n1.k.getFinalY())
                    {
                        n1.k.abortAnimation();
                        flag = n1.k.isFinished();
                    }
                }
            }
            if (!flag)
            {
                n1.o.post(n1.p);
            }
        }
        if (n1.a != 2) goto _L4; else goto _L5
_L5:
        int j1 = 1;
_L7:
        if (j1 != 0)
        {
            if (f())
            {
                break; /* Loop/switch isn't completed */
            }
            n n2 = B;
            n2.a();
            if (n2.a == 2)
            {
                n2.k.getCurrX();
                n2.k.getCurrY();
                n2.k.abortAnimation();
                n2.k.getCurrX();
                j1 = n2.k.getCurrY();
                n2.l.a(j1);
            }
            n2.b(0);
        }
_L2:
        return;
_L4:
        j1 = 0;
        if (true) goto _L7; else goto _L6
_L6:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    }

    public final boolean d()
    {
        return a == PanelState.EXPANDED;
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        if (f())
        {
            int k1 = q.getRight();
            int i1;
            int j1;
            int l1;
            if (m)
            {
                j1 = q.getTop() - k;
                i1 = q.getTop();
            } else
            {
                j1 = q.getBottom();
                i1 = q.getBottom() + k;
            }
            l1 = q.getLeft();
            if (i != null)
            {
                i.setBounds(l1, j1, k1, i1);
                i.draw(canvas);
                return;
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long l1)
    {
        int i1 = canvas.save(2);
        if (f() && q != view)
        {
            canvas.getClipBounds(C);
            boolean flag;
            if (!n)
            {
                if (m)
                {
                    C.bottom = Math.min(C.bottom, q.getTop());
                } else
                {
                    C.top = Math.max(C.top, q.getBottom());
                }
            }
            canvas.clipRect(C);
            if (g != 0 && t > 0.0F)
            {
                int j1 = (int)((float)((g & 0xff000000) >>> 24) * t);
                int k1 = g;
                h.setColor(j1 << 24 | k1 & 0xffffff);
                canvas.drawRect(C, h);
            }
        }
        flag = super.drawChild(canvas, view, l1);
        canvas.restoreToCount(i1);
        return flag;
    }

    public final void e()
    {
        if (c)
        {
            a = PanelState.HIDDEN;
        } else
        if (a != PanelState.DRAGGING && a != PanelState.HIDDEN)
        {
            int j1 = b(0.0F);
            int i1;
            if (m)
            {
                i1 = j;
            } else
            {
                i1 = -j;
            }
            c(a(i1 + j1));
            return;
        }
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new LayoutParams();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new LayoutParams(getContext(), attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (layoutparams instanceof android.view.ViewGroup.MarginLayoutParams)
        {
            return new LayoutParams((android.view.ViewGroup.MarginLayoutParams)layoutparams);
        } else
        {
            return new LayoutParams(layoutparams);
        }
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        c = true;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        c = true;
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        if (p != -1)
        {
            setDragView(findViewById(p));
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        boolean flag = false;
        if (motionevent.getPointerCount() <= 1) goto _L2; else goto _L1
_L1:
        flag = true;
_L12:
        return flag;
_L2:
        float f1;
        float f5;
        int i1;
        i1 = MotionEventCompat.getActionMasked(motionevent);
        if (!isEnabled() || !w || v && i1 != 0)
        {
            B.a();
            return super.onInterceptTouchEvent(motionevent);
        }
        if (i1 == 3 || i1 == 1)
        {
            B.a();
            return false;
        }
        f5 = motionevent.getX();
        f1 = motionevent.getY();
        i1;
        JVM INSTR tableswitch 0 2: default 120
    //                   0 227
    //                   1 120
    //                   2 245;
           goto _L3 _L4 _L3 _L5
_L3:
        int ai[];
        int j1;
        ai = B;
        j1 = MotionEventCompat.getActionMasked(motionevent);
        i1 = MotionEventCompat.getActionIndex(motionevent);
        if (j1 == 0)
        {
            ai.a();
        }
        if (((n) (ai)).i == null)
        {
            ai.i = VelocityTracker.obtain();
        }
        ((n) (ai)).i.addMovement(motionevent);
        j1;
        JVM INSTR tableswitch 0 6: default 216
    //                   0 507
    //                   1 871
    //                   2 665
    //                   3 871
    //                   4 216
    //                   5 586
    //                   6 857;
           goto _L6 _L7 _L8 _L9 _L8 _L6 _L10 _L11
_L6:
        if (((n) (ai)).a == 1)
        {
            return true;
        }
          goto _L12
_L4:
        v = false;
        y = f5;
        z = f1;
          goto _L3
_L5:
        f5 = Math.abs(f5 - y);
        float f9 = Math.abs(f1 - z);
        i1 = B.b;
        if (x)
        {
            return super.onInterceptTouchEvent(motionevent);
        }
        if (f1 - z > (float)(i1 * 3) && ((double)t == 1.0D || (double)t == 0.0D))
        {
            B.a();
            v = true;
            ((Activity)s).onBackPressed();
            return true;
        }
        if (f9 > (float)i1 && f5 > f9)
        {
            break; /* Loop/switch isn't completed */
        }
        j1 = (int)y;
        i1 = (int)z;
        if (o == null) goto _L14; else goto _L13
_L13:
        ai = new int[2];
        o.getLocationOnScreen(ai);
        int ai1[] = new int[2];
        getLocationOnScreen(ai1);
        j1 += ai1[0];
        i1 += ai1[1];
        if (j1 < ai[0] || j1 >= ai[0] + o.getWidth() || i1 < ai[1] || i1 >= ai[1] + o.getHeight()) goto _L14; else goto _L15
_L15:
        i1 = 1;
_L17:
        if (i1 != 0) goto _L3; else goto _L16
_L16:
        B.a();
        v = true;
        return false;
_L14:
        i1 = 0;
          goto _L17
          goto _L3
_L7:
        float f2 = motionevent.getX();
        float f6 = motionevent.getY();
        i1 = MotionEventCompat.getPointerId(motionevent, 0);
        ai.a(f2, f6, i1);
        motionevent = ai.a((int)f2, (int)f6);
        if (motionevent == ((n) (ai)).m && ((n) (ai)).a == 2)
        {
            ai.a(motionevent, i1);
        }
        if ((((n) (ai)).h[i1] & 0) == 0);
          goto _L6
_L10:
        int k1 = MotionEventCompat.getPointerId(motionevent, i1);
        float f3 = MotionEventCompat.getX(motionevent, i1);
        float f7 = MotionEventCompat.getY(motionevent, i1);
        ai.a(f3, f7, k1);
        if (((n) (ai)).a != 0 && ((n) (ai)).a == 2)
        {
            motionevent = ai.a((int)f3, (int)f7);
            if (motionevent == ((n) (ai)).m)
            {
                ai.a(motionevent, k1);
            }
        }
          goto _L6
_L9:
        int l1 = MotionEventCompat.getPointerCount(motionevent);
        for (i1 = 0; i1 < l1 && ((n) (ai)).d != null && ((n) (ai)).e != null; i1++)
        {
            int i2 = MotionEventCompat.getPointerId(motionevent, i1);
            if (i2 >= ((n) (ai)).d.length || i2 >= ((n) (ai)).e.length)
            {
                continue;
            }
            float f4 = MotionEventCompat.getX(motionevent, i1);
            float f10 = MotionEventCompat.getY(motionevent, i1);
            float f8 = ((n) (ai)).d[i2];
            f10 -= ((n) (ai)).e[i2];
            ai.b(f4 - f8, f10, i2);
            if (((n) (ai)).a == 1)
            {
                break;
            }
            View view = ai.a((int)((n) (ai)).d[i2], (int)((n) (ai)).e[i2]);
            if (view != null && ai.a(view, f10) && ai.a(view, i2))
            {
                break;
            }
        }

        ai.a(motionevent);
          goto _L6
_L11:
        ai.a(MotionEventCompat.getPointerId(motionevent, i1));
          goto _L6
_L8:
        ai.a();
          goto _L6
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        int i2;
        int j2;
        i2 = getPaddingLeft();
        l1 = getPaddingTop();
        j2 = getChildCount();
        if (!c) goto _L2; else goto _L1
_L1:
        final class _cls2
        {

            static final int a[];

            static 
            {
                a = new int[PanelState.values().length];
                try
                {
                    a[PanelState.EXPANDED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[PanelState.ANCHORED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[PanelState.HIDDEN.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        com.picsart.studio.view._cls2.a[a.ordinal()];
        JVM INSTR tableswitch 1 3: default 64
    //                   1 209
    //                   2 217
    //                   3 228;
           goto _L3 _L4 _L5 _L6
_L6:
        break MISSING_BLOCK_LABEL_228;
_L3:
        t = 0.0F;
_L2:
        j1 = 0;
        while (j1 < j2) 
        {
            View view = getChildAt(j1);
            if (view.getVisibility() != 8 || j1 != 0 && !c)
            {
                int k2 = view.getMeasuredHeight();
                if (view == q)
                {
                    i1 = b(t);
                } else
                {
                    i1 = l1;
                }
                k1 = i1;
                if (!m)
                {
                    k1 = i1;
                    if (view == r)
                    {
                        k1 = i1;
                        if (!n)
                        {
                            k1 = b(t) + q.getMeasuredHeight();
                        }
                    }
                }
                view.layout(i2, k1, view.getMeasuredWidth() + i2, k2 + k1);
            }
            j1++;
        }
        break MISSING_BLOCK_LABEL_269;
_L4:
        t = 1.0F;
          goto _L2
_L5:
        t = A;
          goto _L2
        j1 = b(0.0F);
        if (m)
        {
            i1 = j;
        } else
        {
            i1 = -j;
        }
        t = a(i1 + j1);
          goto _L2
        if (c)
        {
            a();
        }
        c = false;
        return;
    }

    protected void onMeasure(int i1, int j1)
    {
        int k1 = android.view.View.MeasureSpec.getMode(i1);
        int i2 = android.view.View.MeasureSpec.getSize(i1);
        i1 = android.view.View.MeasureSpec.getMode(j1);
        int j2 = android.view.View.MeasureSpec.getSize(j1);
        if (k1 != 0x40000000)
        {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        }
        if (i1 != 0x40000000)
        {
            throw new IllegalStateException("Height must have an exact value or MATCH_PARENT");
        }
        int k2 = getChildCount();
        if (k2 != 2)
        {
            throw new IllegalStateException("Sliding up panel layout must have exactly 2 children!");
        }
        r = getChildAt(0);
        q = getChildAt(1);
        if (o == null)
        {
            setDragView(q);
        }
        if (q.getVisibility() == 8)
        {
            a = PanelState.HIDDEN;
        }
        int l1 = j2 - getPaddingTop() - getPaddingBottom();
        k1 = 0;
        do
        {
            while (k1 < k2) 
            {
                View view = getChildAt(k1);
                LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
                if (view.getVisibility() != 8 || k1 != 0)
                {
                    if (view == r && !n && a != PanelState.HIDDEN)
                    {
                        j1 = l1 - j;
                    } else
                    {
                        j1 = l1;
                    }
                    if (layoutparams.width == -2)
                    {
                        i1 = android.view.View.MeasureSpec.makeMeasureSpec(i2, 0x80000000);
                    } else
                    if (layoutparams.width == -1)
                    {
                        i1 = android.view.View.MeasureSpec.makeMeasureSpec(i2, 0x40000000);
                    } else
                    {
                        i1 = android.view.View.MeasureSpec.makeMeasureSpec(layoutparams.width, 0x40000000);
                    }
                    if (layoutparams.height == -2)
                    {
                        j1 = android.view.View.MeasureSpec.makeMeasureSpec(j1, 0x80000000);
                    } else
                    if (layoutparams.height == -1)
                    {
                        j1 = android.view.View.MeasureSpec.makeMeasureSpec(j1, 0x40000000);
                    } else
                    {
                        j1 = android.view.View.MeasureSpec.makeMeasureSpec(layoutparams.height, 0x40000000);
                    }
                    view.measure(i1, j1);
                    if (view == q)
                    {
                        u = q.getMeasuredHeight() - j;
                    }
                }
                k1++;
            }
            setMeasuredDimension(i2, j2);
            return;
        } while (true);
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        a = ((SavedState) (parcelable)).a;
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.a = a;
        return savedstate;
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        if (j1 != l1)
        {
            c = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int j1;
        j1 = 0;
        if (motionevent.getPointerCount() > 1)
        {
            return true;
        }
        if (!f())
        {
            return super.onTouchEvent(motionevent);
        }
        if (motionevent.getAction() != 0 || motionevent.getY() >= (float)q.getTop()) goto _L2; else goto _L1
_L1:
        ((Activity)s).onBackPressed();
        B.a();
_L3:
        return true;
_L2:
        n n1;
        int i1;
        int i2;
        n1 = B;
        i1 = MotionEventCompat.getActionMasked(motionevent);
        i2 = MotionEventCompat.getActionIndex(motionevent);
        if (i1 == 0)
        {
            n1.a();
        }
        if (n1.i == null)
        {
            n1.i = VelocityTracker.obtain();
        }
        n1.i.addMovement(motionevent);
        i1;
        JVM INSTR tableswitch 0 6: default 164
    //                   0 167
    //                   1 783
    //                   2 326
    //                   3 805
    //                   4 164
    //                   5 228
    //                   6 509;
           goto _L3 _L4 _L5 _L6 _L7 _L3 _L8 _L9
_L4:
        float f1 = motionevent.getX();
        float f5 = motionevent.getY();
        i1 = MotionEventCompat.getPointerId(motionevent, 0);
        motionevent = n1.a((int)f1, (int)f5);
        n1.a(f1, f5, i1);
        n1.a(motionevent, i1);
        if ((n1.h[i1] & 0) == 0);
          goto _L3
_L8:
        i1 = MotionEventCompat.getPointerId(motionevent, i2);
        float f2 = MotionEventCompat.getX(motionevent, i2);
        float f6 = MotionEventCompat.getY(motionevent, i2);
        n1.a(f2, f6, i1);
        if (n1.a == 0)
        {
            n1.a(n1.a((int)f2, (int)f6), i1);
        } else
        {
            j1 = (int)f2;
            int k1 = (int)f6;
            if (com.picsart.studio.view.n.a(n1.m, j1, k1))
            {
                n1.a(n1.m, i1);
            }
        }
          goto _L3
_L6:
        if (n1.a != 1) goto _L11; else goto _L10
_L10:
        int l1;
        int j2;
        int k2;
        int l2;
        i1 = MotionEventCompat.findPointerIndex(motionevent, n1.c);
        float f3 = MotionEventCompat.getX(motionevent, i1);
        float f7 = MotionEventCompat.getY(motionevent, i1);
        j2 = (int)(f3 - n1.f[n1.c]);
        k2 = (int)(f7 - n1.g[n1.c]);
        n1.m.getLeft();
        l1 = n1.m.getTop() + k2;
        i1 = n1.m.getLeft();
        l2 = n1.m.getTop();
        if (j2 == 0) goto _L13; else goto _L12
_L12:
        n1.m.offsetLeftAndRight(0 - i1);
_L13:
        i1 = l1;
        if (k2 == 0) goto _L15; else goto _L14
_L14:
        i1 = n1.l.b(l1);
        n1.m.offsetTopAndBottom(i1 - l2);
          goto _L15
_L29:
        n1.l.a(i1);
_L30:
        n1.a(motionevent);
          goto _L3
        Exception exception;
        exception;
_L9:
        l1 = MotionEventCompat.getPointerId(motionevent, i2);
        if (n1.a != 1 || l1 != n1.c) goto _L17; else goto _L16
_L16:
        i2 = MotionEventCompat.getPointerCount(motionevent);
        i1 = j1;
_L27:
        if (i1 >= i2) goto _L19; else goto _L18
_L18:
        j1 = MotionEventCompat.getPointerId(motionevent, i1);
        if (j1 == n1.c) goto _L21; else goto _L20
_L20:
        float f4;
        float f8;
        f4 = MotionEventCompat.getX(motionevent, i1);
        f8 = MotionEventCompat.getY(motionevent, i1);
        if (n1.a((int)f4, (int)f8) != n1.m || !n1.a(n1.m, j1)) goto _L21; else goto _L22
_L22:
        i1 = n1.c;
_L28:
        if (i1 == -1)
        {
            n1.b();
        }
_L17:
        n1.a(l1);
          goto _L3
_L11:
        l1 = MotionEventCompat.getPointerCount(motionevent);
        i1 = 0;
_L31:
        if (i1 >= l1) goto _L24; else goto _L23
_L23:
        float f10;
        j2 = MotionEventCompat.getPointerId(motionevent, i1);
        f4 = MotionEventCompat.getX(motionevent, i1);
        f8 = MotionEventCompat.getY(motionevent, i1);
        float f9 = n1.d[j2];
        f10 = f8 - n1.e[j2];
        n1.b(f4 - f9, f10, j2);
        if (n1.a == 1) goto _L24; else goto _L25
_L25:
        View view = n1.a((int)f4, (int)f8);
        if (n1.a(view, f10) && n1.a(view, j2)) goto _L24; else goto _L26
_L24:
        n1.a(motionevent);
          goto _L3
_L21:
        i1++;
          goto _L27
_L5:
        if (n1.a == 1)
        {
            n1.b();
        }
        n1.a();
          goto _L3
_L7:
        if (n1.a == 1)
        {
            n1.a(0.0F);
        }
        n1.a();
          goto _L3
_L19:
        i1 = -1;
          goto _L28
_L15:
        if (j2 == 0 && k2 == 0) goto _L30; else goto _L29
_L26:
        i1++;
          goto _L31
    }

    public void setAnchorPoint(float f1)
    {
        if (f1 > 0.0F && f1 <= 1.0F)
        {
            A = f1;
        }
    }

    public void setCoveredFadeColor(int i1)
    {
        g = i1;
        invalidate();
    }

    public void setDragView(View view)
    {
        if (o != null)
        {
            o.setOnClickListener(null);
        }
        o = view;
        if (o != null)
        {
            o.setClickable(true);
            o.setFocusable(false);
            o.setFocusableInTouchMode(false);
            o.setOnClickListener(new android.view.View.OnClickListener() {

                private SlidingUpPanelLayout a;

                public final void onClick(View view1)
                {
                    if (!a.isEnabled())
                    {
                        return;
                    }
                    if (!a.d())
                    {
                        boolean flag;
                        if (a.a == PanelState.ANCHORED)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        if (!flag)
                        {
                            a.a(com.picsart.studio.view.SlidingUpPanelLayout.a(a));
                            return;
                        }
                    }
                    a.c();
                }

            
            {
                a = SlidingUpPanelLayout.this;
                super();
            }
            });
        }
    }

    public void setEnableDragViewTouchEvents(boolean flag)
    {
        x = flag;
    }

    public void setEnabled(boolean flag)
    {
        if (!flag)
        {
            c();
        }
        super.setEnabled(flag);
    }

    public void setOverlayed(boolean flag)
    {
        n = flag;
    }

    public void setPanelHeight(int i1)
    {
        j = i1;
        requestLayout();
    }

    public void setPanelSlideListener(k k1)
    {
        b = k1;
    }

    public void setParalaxOffset(int i1)
    {
        l = i1;
        requestLayout();
    }

    public void setSlidingEnabled(boolean flag)
    {
        w = flag;
    }

    static 
    {
        d = PanelState.COLLAPSED;
    }

    private class PanelState extends Enum
    {

        private static final PanelState $VALUES[];
        public static final PanelState ANCHORED;
        public static final PanelState COLLAPSED;
        public static final PanelState DRAGGING;
        public static final PanelState EXPANDED;
        public static final PanelState HIDDEN;

        public static PanelState valueOf(String s1)
        {
            return (PanelState)Enum.valueOf(com/picsart/studio/view/SlidingUpPanelLayout$PanelState, s1);
        }

        public static PanelState[] values()
        {
            return (PanelState[])$VALUES.clone();
        }

        static 
        {
            EXPANDED = new PanelState("EXPANDED", 0);
            COLLAPSED = new PanelState("COLLAPSED", 1);
            ANCHORED = new PanelState("ANCHORED", 2);
            HIDDEN = new PanelState("HIDDEN", 3);
            DRAGGING = new PanelState("DRAGGING", 4);
            $VALUES = (new PanelState[] {
                EXPANDED, COLLAPSED, ANCHORED, HIDDEN, DRAGGING
            });
        }

        private PanelState(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    private class LayoutParams extends android.view.ViewGroup.MarginLayoutParams
    {

        private static final int a[] = {
            0x1010181
        };


        public LayoutParams()
        {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
            context.obtainStyledAttributes(attributeset, a).recycle();
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
        {
            super(layoutparams);
        }

        public LayoutParams(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
        {
            super(marginlayoutparams);
        }
    }


    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public final Object createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel, (byte)0);
            }

            public final volatile Object[] newArray(int i1)
            {
                return new SavedState[i1];
            }

        };
        PanelState a;

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            parcel.writeString(a.toString());
        }


        private SavedState(Parcel parcel)
        {
            super(parcel);
            try
            {
                a = (PanelState)Enum.valueOf(com/picsart/studio/view/SlidingUpPanelLayout$PanelState, parcel.readString());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Parcel parcel)
            {
                a = PanelState.COLLAPSED;
            }
        }

        SavedState(Parcel parcel, byte byte0)
        {
            this(parcel);
        }

        SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

}
