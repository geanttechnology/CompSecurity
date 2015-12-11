// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.b.a;
import android.support.v4.view.at;
import android.support.v4.view.bi;
import android.support.v4.view.ca;
import android.support.v4.view.s;
import android.support.v4.view.w;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.widget:
//            aa, j, s, q, 
//            w, bo, p, r, 
//            u, t

public class DrawerLayout extends ViewGroup
    implements aa
{

    private static r G;
    private static final int a[] = {
        0x10100b3
    };
    private static final boolean b;
    private static final boolean c;
    private boolean A;
    private Drawable B;
    private Drawable C;
    private Drawable D;
    private Drawable E;
    private final ArrayList F;
    private final q d;
    private float e;
    private int f;
    private int g;
    private float h;
    private Paint i;
    private final bo j;
    private final bo k;
    private final android.support.v4.widget.w l;
    private final android.support.v4.widget.w m;
    private int n;
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private boolean s;
    private t t;
    private float u;
    private float v;
    private Drawable w;
    private Drawable x;
    private Drawable y;
    private Object z;

    public DrawerLayout(Context context)
    {
        this(context, null);
    }

    public DrawerLayout(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        d = new q(this);
        g = 0x99000000;
        i = new Paint();
        p = true;
        B = null;
        C = null;
        D = null;
        E = null;
        setDescendantFocusability(0x40000);
        float f1 = getResources().getDisplayMetrics().density;
        f = (int)(64F * f1 + 0.5F);
        float f2 = 400F * f1;
        l = new android.support.v4.widget.w(this, 3);
        m = new android.support.v4.widget.w(this, 5);
        j = android.support.v4.widget.bo.a(this, 1.0F, l);
        j.a(1);
        j.a(f2);
        l.a(j);
        k = android.support.v4.widget.bo.a(this, 1.0F, m);
        k.a(2);
        k.a(f2);
        m.a(k);
        setFocusableInTouchMode(true);
        bi.c(this, 1);
        bi.a(this, new p(this));
        ca.a(this, false);
        if (bi.v(this))
        {
            G.a(this);
            w = G.a(context);
        }
        e = f1 * 10F;
        F = new ArrayList();
    }

    static View a(DrawerLayout drawerlayout)
    {
        return drawerlayout.f();
    }

    private void a(int i1, int j1)
    {
        j1 = android.support.v4.view.s.a(j1, bi.h(this));
        if (j1 == 3)
        {
            q = i1;
        } else
        if (j1 == 5)
        {
            r = i1;
        }
        if (i1 != 0)
        {
            bo bo1;
            if (j1 == 3)
            {
                bo1 = j;
            } else
            {
                bo1 = k;
            }
            bo1.e();
        }
        i1;
        JVM INSTR tableswitch 1 2: default 60
    //                   1 98
    //                   2 82;
           goto _L1 _L2 _L3
_L1:
        View view;
        return;
_L3:
        if ((view = a(j1)) != null)
        {
            h(view);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if ((view = a(j1)) != null)
        {
            e(view);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private void a(View view, boolean flag)
    {
        int j1 = getChildCount();
        int i1 = 0;
        while (i1 < j1) 
        {
            View view1 = getChildAt(i1);
            if (!flag && !d(view1) || flag && view1 == view)
            {
                bi.c(view1, 1);
            } else
            {
                bi.c(view1, 4);
            }
            i1++;
        }
    }

    private void a(boolean flag)
    {
        int l1 = getChildCount();
        int j1 = 0;
        int i1 = 0;
        while (j1 < l1) 
        {
label0:
            {
                View view = getChildAt(j1);
                u u1 = (u)view.getLayoutParams();
                int k1 = i1;
                if (!d(view))
                {
                    break label0;
                }
                if (flag)
                {
                    k1 = i1;
                    if (!u1.c)
                    {
                        break label0;
                    }
                }
                k1 = view.getWidth();
                if (a(view, 3))
                {
                    i1 |= j.a(view, -k1, view.getTop());
                } else
                {
                    i1 |= k.a(view, getWidth(), view.getTop());
                }
                u1.c = false;
                k1 = i1;
            }
            j1++;
            i1 = k1;
        }
        l.a();
        m.a();
        if (i1 != 0)
        {
            invalidate();
        }
    }

    static float b(View view)
    {
        return ((u)view.getLayoutParams()).b;
    }

    static int[] c()
    {
        return a;
    }

    private static String d(int i1)
    {
        if ((i1 & 3) == 3)
        {
            return "LEFT";
        }
        if ((i1 & 5) == 5)
        {
            return "RIGHT";
        } else
        {
            return Integer.toHexString(i1);
        }
    }

    static boolean d()
    {
        return b;
    }

    static boolean d(View view)
    {
        return (android.support.v4.view.s.a(((u)view.getLayoutParams()).a, bi.h(view)) & 7) != 0;
    }

    private View e()
    {
        int j1 = getChildCount();
        for (int i1 = 0; i1 < j1; i1++)
        {
            View view = getChildAt(i1);
            if (((u)view.getLayoutParams()).d)
            {
                return view;
            }
        }

        return null;
    }

    private View f()
    {
        int j1 = getChildCount();
        boolean flag;
        for (int i1 = 0; i1 < j1; i1++)
        {
            View view = getChildAt(i1);
            if (!d(view))
            {
                continue;
            }
            if (!d(view))
            {
                throw new IllegalArgumentException((new StringBuilder("View ")).append(view).append(" is not a drawer").toString());
            }
            if (((u)view.getLayoutParams()).b > 0.0F)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                return view;
            }
        }

        return null;
    }

    static boolean f(View view)
    {
        return bi.e(view) != 4 && bi.e(view) != 2;
    }

    private static boolean g(View view)
    {
        return ((u)view.getLayoutParams()).a == 0;
    }

    private void h(View view)
    {
        if (!d(view))
        {
            throw new IllegalArgumentException((new StringBuilder("View ")).append(view).append(" is not a sliding drawer").toString());
        }
        if (p)
        {
            u u1 = (u)view.getLayoutParams();
            u1.b = 1.0F;
            u1.d = true;
            a(view, true);
        } else
        if (a(view, 3))
        {
            j.a(view, 0, view.getTop());
        } else
        {
            k.a(view, getWidth() - view.getWidth(), view.getTop());
        }
        invalidate();
    }

    private boolean i(View view)
    {
        if (!d(view))
        {
            throw new IllegalArgumentException((new StringBuilder("View ")).append(view).append(" is not a drawer").toString());
        } else
        {
            return ((u)view.getLayoutParams()).d;
        }
    }

    public final int a(View view)
    {
        int i1 = c(view);
        if (i1 == 3)
        {
            return q;
        }
        if (i1 == 5)
        {
            return r;
        } else
        {
            return 0;
        }
    }

    final View a(int i1)
    {
        int j1 = android.support.v4.view.s.a(i1, bi.h(this));
        int k1 = getChildCount();
        for (i1 = 0; i1 < k1; i1++)
        {
            View view = getChildAt(i1);
            if ((c(view) & 7) == (j1 & 7))
            {
                return view;
            }
        }

        return null;
    }

    public final void a()
    {
        a(false);
    }

    final void a(int i1, View view)
    {
        u u1;
        int j1 = j.a();
        int k1 = k.a();
        if (j1 == 1 || k1 == 1)
        {
            j1 = 1;
        } else
        if (j1 == 2 || k1 == 2)
        {
            j1 = 2;
        } else
        {
            j1 = 0;
        }
        if (view == null || i1 != 0) goto _L2; else goto _L1
_L1:
        u1 = (u)view.getLayoutParams();
        if (u1.b != 0.0F) goto _L4; else goto _L3
_L3:
        u1 = (u)view.getLayoutParams();
        if (u1.d)
        {
            u1.d = false;
            if (t != null)
            {
                t.onDrawerClosed(view);
            }
            a(view, false);
            if (hasWindowFocus())
            {
                view = getRootView();
                if (view != null)
                {
                    view.sendAccessibilityEvent(32);
                }
            }
        }
_L2:
        if (j1 != n)
        {
            n = j1;
            if (t != null)
            {
                t.onDrawerStateChanged(j1);
            }
        }
        return;
_L4:
        if (u1.b == 1.0F)
        {
            u u2 = (u)view.getLayoutParams();
            if (!u2.d)
            {
                u2.d = true;
                if (t != null)
                {
                    t.onDrawerOpened(view);
                }
                a(view, true);
                if (hasWindowFocus())
                {
                    sendAccessibilityEvent(32);
                }
                view.requestFocus();
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    final void a(View view, float f1)
    {
        u u1 = (u)view.getLayoutParams();
        if (f1 != u1.b)
        {
            u1.b = f1;
            if (t != null)
            {
                t.onDrawerSlide(view, f1);
                return;
            }
        }
    }

    public final void a(Object obj, boolean flag)
    {
        z = obj;
        A = flag;
        if (!flag && getBackground() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setWillNotDraw(flag);
        requestLayout();
    }

    final boolean a(View view, int i1)
    {
        return (c(view) & i1) == i1;
    }

    public void addFocusables(ArrayList arraylist, int i1, int j1)
    {
        boolean flag1 = false;
        if (getDescendantFocusability() == 0x60000)
        {
            return;
        }
        int j2 = getChildCount();
        int k1 = 0;
        boolean flag = false;
        while (k1 < j2) 
        {
            View view = getChildAt(k1);
            if (d(view))
            {
                if (i(view))
                {
                    flag = true;
                    view.addFocusables(arraylist, i1, j1);
                }
            } else
            {
                F.add(view);
            }
            k1++;
        }
        if (!flag)
        {
            int i2 = F.size();
            for (int l1 = ((flag1) ? 1 : 0); l1 < i2; l1++)
            {
                View view1 = (View)F.get(l1);
                if (view1.getVisibility() == 0)
                {
                    view1.addFocusables(arraylist, i1, j1);
                }
            }

        }
        F.clear();
    }

    public void addView(View view, int i1, android.view.ViewGroup.LayoutParams layoutparams)
    {
        super.addView(view, i1, layoutparams);
        if (e() != null || d(view))
        {
            bi.c(view, 4);
        } else
        {
            bi.c(view, 1);
        }
        if (!b)
        {
            bi.a(view, d);
        }
    }

    final void b()
    {
        int i1 = 0;
        if (!s)
        {
            long l1 = SystemClock.uptimeMillis();
            MotionEvent motionevent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
            for (int j1 = getChildCount(); i1 < j1; i1++)
            {
                getChildAt(i1).dispatchTouchEvent(motionevent);
            }

            motionevent.recycle();
            s = true;
        }
    }

    public final void b(int i1)
    {
        View view = a(0x800003);
        if (view == null)
        {
            throw new IllegalArgumentException((new StringBuilder("No drawer view found with gravity ")).append(d(0x800003)).toString());
        } else
        {
            h(view);
            return;
        }
    }

    final int c(View view)
    {
        return android.support.v4.view.s.a(((u)view.getLayoutParams()).a, bi.h(this));
    }

    public final boolean c(int i1)
    {
        View view = a(0x800003);
        if (view != null)
        {
            return i(view);
        } else
        {
            return false;
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return (layoutparams instanceof u) && super.checkLayoutParams(layoutparams);
    }

    public void computeScroll()
    {
        int j1 = getChildCount();
        float f1 = 0.0F;
        for (int i1 = 0; i1 < j1; i1++)
        {
            f1 = Math.max(f1, ((u)getChildAt(i1).getLayoutParams()).b);
        }

        h = f1;
        if (j.a(true) | k.a(true))
        {
            bi.d(this);
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long l1)
    {
        int i1;
        int j2;
        int i3;
        int l3;
        int i5;
        int j5;
        int k5;
        boolean flag1;
        i5 = getHeight();
        flag1 = g(view);
        j2 = 0;
        boolean flag = false;
        i1 = getWidth();
        j5 = canvas.save();
        i3 = i1;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_244;
        }
        k5 = getChildCount();
        l3 = 0;
        j2 = ((flag) ? 1 : 0);
_L6:
        View view1;
        if (l3 >= k5)
        {
            break MISSING_BLOCK_LABEL_226;
        }
        view1 = getChildAt(l3);
        if (view1 == view || view1.getVisibility() != 0) goto _L2; else goto _L1
_L1:
        int k4;
        Drawable drawable = view1.getBackground();
        if (drawable != null)
        {
            if (drawable.getOpacity() == -1)
            {
                i3 = 1;
            } else
            {
                i3 = 0;
            }
        } else
        {
            i3 = 0;
        }
        if (i3 == 0 || !d(view1) || view1.getHeight() < i5) goto _L2; else goto _L3
_L3:
        if (!a(view1, 3)) goto _L5; else goto _L4
_L4:
        i3 = view1.getRight();
        if (i3 > j2)
        {
            j2 = i3;
        }
        k4 = j2;
        i3 = i1;
_L7:
        l3++;
        i1 = i3;
        j2 = k4;
          goto _L6
_L5:
        int l4;
        l4 = view1.getLeft();
        i3 = l4;
        k4 = j2;
        if (l4 < i1) goto _L7; else goto _L2
_L2:
        i3 = i1;
        k4 = j2;
          goto _L7
        canvas.clipRect(j2, 0, i1, getHeight());
        i3 = i1;
        boolean flag2 = super.drawChild(canvas, view, l1);
        canvas.restoreToCount(j5);
        if (h > 0.0F && flag1)
        {
            int j1 = (int)((float)((g & 0xff000000) >>> 24) * h);
            int i4 = g;
            i.setColor(j1 << 24 | i4 & 0xffffff);
            canvas.drawRect(j2, 0.0F, i3, getHeight(), i);
        } else
        {
            if (x != null && a(view, 3))
            {
                int k1 = x.getIntrinsicWidth();
                int k2 = view.getRight();
                int j3 = j.b();
                float f1 = Math.max(0.0F, Math.min((float)k2 / (float)j3, 1.0F));
                x.setBounds(k2, view.getTop(), k1 + k2, view.getBottom());
                x.setAlpha((int)(255F * f1));
                x.draw(canvas);
                return flag2;
            }
            if (y != null && a(view, 5))
            {
                int i2 = y.getIntrinsicWidth();
                int l2 = view.getLeft();
                int k3 = getWidth();
                int j4 = k.b();
                float f2 = Math.max(0.0F, Math.min((float)(k3 - l2) / (float)j4, 1.0F));
                y.setBounds(l2 - i2, view.getTop(), l2, view.getBottom());
                y.setAlpha((int)(255F * f2));
                y.draw(canvas);
                return flag2;
            }
        }
        return flag2;
    }

    public final void e(View view)
    {
        if (!d(view))
        {
            throw new IllegalArgumentException((new StringBuilder("View ")).append(view).append(" is not a sliding drawer").toString());
        }
        if (p)
        {
            view = (u)view.getLayoutParams();
            view.b = 0.0F;
            view.d = false;
        } else
        if (a(view, 3))
        {
            j.a(view, -view.getWidth(), view.getTop());
        } else
        {
            k.a(view, getWidth(), view.getTop());
        }
        invalidate();
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new u(-1, -1);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new u(getContext(), attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (layoutparams instanceof u)
        {
            return new u((u)layoutparams);
        }
        if (layoutparams instanceof android.view.ViewGroup.MarginLayoutParams)
        {
            return new u((android.view.ViewGroup.MarginLayoutParams)layoutparams);
        } else
        {
            return new u(layoutparams);
        }
    }

    public float getDrawerElevation()
    {
        if (c)
        {
            return e;
        } else
        {
            return 0.0F;
        }
    }

    public Drawable getStatusBarBackgroundDrawable()
    {
        return w;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        p = true;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        p = true;
    }

    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (A && w != null)
        {
            int i1 = G.a(z);
            if (i1 > 0)
            {
                w.setBounds(0, 0, getWidth(), i1);
                w.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i1;
        boolean flag;
        boolean flag1;
        boolean flag2;
        flag = false;
        i1 = at.a(motionevent);
        flag1 = j.a(motionevent);
        flag2 = k.a(motionevent);
        i1;
        JVM INSTR tableswitch 0 3: default 60
    //                   0 131
    //                   1 225
    //                   2 194
    //                   3 225;
           goto _L1 _L2 _L3 _L4 _L3
_L1:
        i1 = 0;
_L15:
        if (flag1 | flag2 || i1 != 0) goto _L6; else goto _L5
_L5:
        int j1;
        j1 = getChildCount();
        i1 = 0;
_L17:
        if (i1 >= j1) goto _L8; else goto _L7
_L7:
        if (!((u)getChildAt(i1).getLayoutParams()).c) goto _L10; else goto _L9
_L9:
        i1 = 1;
_L18:
        if (i1 == 0 && !s) goto _L11; else goto _L6
_L6:
        flag = true;
_L11:
        return flag;
_L2:
        float f1;
        float f2;
        f1 = motionevent.getX();
        f2 = motionevent.getY();
        u = f1;
        v = f2;
        if (h <= 0.0F) goto _L13; else goto _L12
_L12:
        motionevent = j.b((int)f1, (int)f2);
        if (motionevent == null || !g(motionevent)) goto _L13; else goto _L14
_L14:
        i1 = 1;
_L19:
        s = false;
          goto _L15
_L4:
        if (!j.c(3)) goto _L1; else goto _L16
_L16:
        l.a();
        m.a();
        i1 = 0;
          goto _L15
_L3:
        a(true);
        s = false;
          goto _L1
_L10:
        i1++;
          goto _L17
_L8:
        i1 = 0;
          goto _L18
_L13:
        i1 = 0;
          goto _L19
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4)
        {
            boolean flag;
            if (f() != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                android.support.v4.view.w.b(keyevent);
                return true;
            }
        }
        return super.onKeyDown(i1, keyevent);
    }

    public boolean onKeyUp(int i1, KeyEvent keyevent)
    {
        boolean flag = false;
        if (i1 == 4)
        {
            keyevent = f();
            if (keyevent != null && a(keyevent) == 0)
            {
                a(false);
            }
            if (keyevent != null)
            {
                flag = true;
            }
            return flag;
        } else
        {
            return super.onKeyUp(i1, keyevent);
        }
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        int k2;
        int l2;
        o = true;
        k2 = k1 - i1;
        l2 = getChildCount();
        k1 = 0;
_L2:
        View view;
        u u1;
        if (k1 >= l2)
        {
            break MISSING_BLOCK_LABEL_446;
        }
        view = getChildAt(k1);
        if (view.getVisibility() != 8)
        {
            u1 = (u)view.getLayoutParams();
            if (!g(view))
            {
                break; /* Loop/switch isn't completed */
            }
            view.layout(u1.leftMargin, u1.topMargin, u1.leftMargin + view.getMeasuredWidth(), u1.topMargin + view.getMeasuredHeight());
        }
_L6:
        k1++;
        if (true) goto _L2; else goto _L1
_L1:
        int i2;
        int i3;
        int j3;
        i3 = view.getMeasuredWidth();
        j3 = view.getMeasuredHeight();
        float f1;
        boolean flag1;
        if (a(view, 3))
        {
            i1 = -i3;
            i2 = (int)((float)i3 * u1.b) + i1;
            f1 = (float)(i3 + i2) / (float)i3;
        } else
        {
            i2 = k2 - (int)((float)i3 * u1.b);
            f1 = (float)(k2 - i2) / (float)i3;
        }
        if (f1 != u1.b)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        u1.a & 0x70;
        JVM INSTR lookupswitch 2: default 212
    //                   16: 356
    //                   80: 316;
           goto _L3 _L4 _L5
_L4:
        break MISSING_BLOCK_LABEL_356;
_L3:
        view.layout(i2, u1.topMargin, i3 + i2, j3 + u1.topMargin);
_L7:
        if (flag1)
        {
            a(view, f1);
        }
        int j2;
        int k3;
        if (u1.b > 0.0F)
        {
            i1 = 0;
        } else
        {
            i1 = 4;
        }
        if (view.getVisibility() != i1)
        {
            view.setVisibility(i1);
        }
          goto _L6
_L5:
        i1 = l1 - j1;
        view.layout(i2, i1 - u1.bottomMargin - view.getMeasuredHeight(), i3 + i2, i1 - u1.bottomMargin);
          goto _L7
        k3 = l1 - j1;
        j2 = (k3 - j3) / 2;
        if (j2 < u1.topMargin)
        {
            i1 = u1.topMargin;
        } else
        {
            i1 = j2;
            if (j2 + j3 > k3 - u1.bottomMargin)
            {
                i1 = k3 - u1.bottomMargin - j3;
            }
        }
        view.layout(i2, i1, i3 + i2, j3 + i1);
          goto _L7
        o = false;
        p = false;
        return;
          goto _L6
    }

    protected void onMeasure(int i1, int j1)
    {
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int l3;
        k2 = 300;
        j2 = 0;
        l3 = android.view.View.MeasureSpec.getMode(i1);
        i3 = android.view.View.MeasureSpec.getMode(j1);
        i2 = android.view.View.MeasureSpec.getSize(i1);
        l2 = android.view.View.MeasureSpec.getSize(j1);
        if (l3 != 0x40000000) goto _L2; else goto _L1
_L1:
        int l1 = i2;
        if (i3 == 0x40000000) goto _L3; else goto _L2
_L2:
        int k1;
        boolean flag;
        if (isInEditMode())
        {
            k1 = i2;
            if (l3 != 0x80000000)
            {
                k1 = i2;
                if (l3 == 0)
                {
                    k1 = 300;
                }
            }
            l1 = k1;
            if (i3 != 0x80000000)
            {
label0:
                {
                    l1 = k1;
                    if (i3 == 0)
                    {
                        l1 = k1;
                        k1 = k2;
                        break label0;
                    }
                }
            }
        } else
        {
            throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
        }
          goto _L3
_L5:
        setMeasuredDimension(l1, k1);
        if (z != null && bi.v(this))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        k2 = bi.h(this);
        l2 = getChildCount();
        while (j2 < l2) 
        {
            View view = getChildAt(j2);
            if (view.getVisibility() != 8)
            {
                u u1 = (u)view.getLayoutParams();
                if (flag)
                {
                    int j3 = android.support.v4.view.s.a(u1.a, k2);
                    if (bi.v(view))
                    {
                        G.a(view, z, j3);
                    } else
                    {
                        G.a(u1, z, j3);
                    }
                }
                if (g(view))
                {
                    view.measure(android.view.View.MeasureSpec.makeMeasureSpec(l1 - u1.leftMargin - u1.rightMargin, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(k1 - u1.topMargin - u1.bottomMargin, 0x40000000));
                } else
                if (d(view))
                {
                    if (c && bi.s(view) != e)
                    {
                        bi.f(view, e);
                    }
                    int k3 = c(view) & 7;
                    if ((k3 & 0) != 0)
                    {
                        throw new IllegalStateException((new StringBuilder("Child drawer has absolute gravity ")).append(d(k3)).append(" but this DrawerLayout").append(" already has a drawer view along that edge").toString());
                    }
                    view.measure(getChildMeasureSpec(i1, f + u1.leftMargin + u1.rightMargin, u1.width), getChildMeasureSpec(j1, u1.topMargin + u1.bottomMargin, u1.height));
                } else
                {
                    throw new IllegalStateException((new StringBuilder("Child ")).append(view).append(" at index ").append(j2).append(" does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY").toString());
                }
            }
            j2++;
        }
        return;
_L3:
        k1 = l2;
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        if (((SavedState) (parcelable)).a != 0)
        {
            View view = a(((SavedState) (parcelable)).a);
            if (view != null)
            {
                h(view);
            }
        }
        a(((SavedState) (parcelable)).b, 3);
        a(((SavedState) (parcelable)).c, 5);
    }

    public void onRtlPropertiesChanged(int i1)
    {
        if (!c)
        {
            bi.h(this);
            x = null;
            bi.h(this);
            y = null;
        }
    }

    protected Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        View view = e();
        if (view != null)
        {
            savedstate.a = ((u)view.getLayoutParams()).a;
        }
        savedstate.b = q;
        savedstate.c = r;
        return savedstate;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag;
        flag = false;
        j.b(motionevent);
        k.b(motionevent);
        motionevent.getAction() & 0xff;
        JVM INSTR tableswitch 0 3: default 56
    //                   0 58
    //                   1 85
    //                   2 56
    //                   3 187;
           goto _L1 _L2 _L3 _L1 _L4
_L1:
        return true;
_L2:
        float f1 = motionevent.getX();
        float f3 = motionevent.getY();
        u = f1;
        v = f3;
        s = false;
        return true;
_L3:
        float f2;
        float f4;
        f4 = motionevent.getX();
        f2 = motionevent.getY();
        motionevent = j.b((int)f4, (int)f2);
        if (motionevent == null || !g(motionevent)) goto _L6; else goto _L5
_L5:
        int i1;
        f4 -= u;
        f2 -= v;
        i1 = j.d();
        if (f4 * f4 + f2 * f2 >= (float)(i1 * i1)) goto _L6; else goto _L7
_L7:
        motionevent = e();
        if (motionevent == null) goto _L6; else goto _L8
_L8:
        if (a(motionevent) == 2)
        {
            flag = true;
        }
_L10:
        a(flag);
        return true;
_L4:
        a(true);
        s = false;
        return true;
_L6:
        flag = true;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void requestDisallowInterceptTouchEvent(boolean flag)
    {
        super.requestDisallowInterceptTouchEvent(flag);
        if (flag)
        {
            a(true);
        }
    }

    public void requestLayout()
    {
        if (!o)
        {
            super.requestLayout();
        }
    }

    public void setDrawerElevation(float f1)
    {
        e = f1;
        for (int i1 = 0; i1 < getChildCount(); i1++)
        {
            View view = getChildAt(i1);
            if (d(view))
            {
                bi.f(view, e);
            }
        }

    }

    public void setDrawerListener(t t1)
    {
        t = t1;
    }

    public void setDrawerLockMode(int i1)
    {
        a(i1, 3);
        a(i1, 5);
    }

    public void setScrimColor(int i1)
    {
        g = i1;
        invalidate();
    }

    public void setStatusBarBackground(int i1)
    {
        Drawable drawable;
        if (i1 != 0)
        {
            drawable = android.support.v4.b.a.a(getContext(), i1);
        } else
        {
            drawable = null;
        }
        w = drawable;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable)
    {
        w = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i1)
    {
        w = new ColorDrawable(i1);
        invalidate();
    }

    static 
    {
        boolean flag1 = true;
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b = flag;
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        c = flag;
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            G = new j();
        } else
        {
            G = new android.support.v4.widget.s();
        }
    }

    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new v();
        int a;
        int b;
        int c;

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            parcel.writeInt(a);
        }


        public SavedState(Parcel parcel)
        {
            super(parcel);
            a = 0;
            b = 0;
            c = 0;
            a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
            a = 0;
            b = 0;
            c = 0;
        }
    }

}
