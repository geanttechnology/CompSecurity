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
import android.support.v4.a.a;
import android.support.v4.view.ap;
import android.support.v4.view.bn;
import android.support.v4.view.n;
import android.support.v4.view.s;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package android.support.v4.widget:
//            m, d, e, b, 
//            i, ah, a, c, 
//            g, f

public class DrawerLayout extends ViewGroup
    implements m
{

    static final c h;
    private static final int i[] = {
        0x10100b3
    };
    private static final boolean j;
    private Drawable A;
    private Object B;
    private boolean C;
    final ah a;
    final ah b;
    int c;
    boolean d;
    f e;
    CharSequence f;
    CharSequence g;
    private final b k;
    private int l;
    private int m;
    private float n;
    private Paint o;
    private final i p;
    private final i q;
    private boolean r;
    private boolean s;
    private int t;
    private int u;
    private boolean v;
    private float w;
    private float x;
    private Drawable y;
    private Drawable z;

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
        k = new b(this);
        m = 0x99000000;
        o = new Paint();
        s = true;
        setDescendantFocusability(0x40000);
        float f1 = getResources().getDisplayMetrics().density;
        l = (int)(64F * f1 + 0.5F);
        f1 *= 400F;
        p = new i(this, 3);
        q = new i(this, 5);
        a = android.support.v4.widget.ah.a(this, p);
        a.l = 1;
        a.j = f1;
        p.b = a;
        b = android.support.v4.widget.ah.a(this, q);
        b.l = 2;
        b.j = f1;
        q.b = b;
        setFocusableInTouchMode(true);
        ap.c(this, 1);
        ap.a(this, new android.support.v4.widget.a(this));
        bn.a(this);
        if (ap.p(this))
        {
            h.a(this);
        }
    }

    static View a(DrawerLayout drawerlayout)
    {
        return drawerlayout.e();
    }

    private void a(int i1, int j1)
    {
        j1 = android.support.v4.view.n.a(j1, ap.h(this));
        if (j1 == 3)
        {
            t = i1;
        } else
        if (j1 == 5)
        {
            u = i1;
        }
        if (i1 != 0)
        {
            ah ah1;
            if (j1 == 3)
            {
                ah1 = a;
            } else
            {
                ah1 = b;
            }
            ah1.a();
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
            e(view);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if ((view = a(j1)) != null)
        {
            f(view);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    static float b(View view)
    {
        return ((g)view.getLayoutParams()).b;
    }

    public static String b(int i1)
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

    static int[] b()
    {
        return i;
    }

    static boolean c()
    {
        return j;
    }

    private View d()
    {
        int j1 = getChildCount();
        for (int i1 = 0; i1 < j1; i1++)
        {
            View view = getChildAt(i1);
            if (((g)view.getLayoutParams()).d)
            {
                return view;
            }
        }

        return null;
    }

    static boolean d(View view)
    {
        return (android.support.v4.view.n.a(((g)view.getLayoutParams()).a, ap.h(view)) & 7) != 0;
    }

    private View e()
    {
        int j1 = getChildCount();
        for (int i1 = 0; i1 < j1; i1++)
        {
            View view = getChildAt(i1);
            if (d(view) && g(view))
            {
                return view;
            }
        }

        return null;
    }

    public static boolean g(View view)
    {
        if (!d(view))
        {
            throw new IllegalArgumentException((new StringBuilder("View ")).append(view).append(" is not a drawer").toString());
        }
        return ((g)view.getLayoutParams()).b > 0.0F;
    }

    static boolean h(View view)
    {
        return ap.e(view) != 4 && ap.e(view) != 2;
    }

    private static boolean i(View view)
    {
        return ((g)view.getLayoutParams()).a == 0;
    }

    public final int a(View view)
    {
        int i1 = c(view);
        if (i1 == 3)
        {
            return t;
        }
        if (i1 == 5)
        {
            return u;
        } else
        {
            return 0;
        }
    }

    public final View a(int i1)
    {
        int j1 = android.support.v4.view.n.a(i1, ap.h(this));
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

    final void a(View view, float f1)
    {
        view = (g)view.getLayoutParams();
        if (f1 != ((g) (view)).b)
        {
            view.b = f1;
            if (e != null)
            {
                e.a(f1);
                return;
            }
        }
    }

    final void a(View view, boolean flag)
    {
        int j1 = getChildCount();
        int i1 = 0;
        while (i1 < j1) 
        {
            View view1 = getChildAt(i1);
            if (!flag && !d(view1) || flag && view1 == view)
            {
                ap.c(view1, 1);
            } else
            {
                ap.c(view1, 4);
            }
            i1++;
        }
    }

    public final void a(Object obj, boolean flag)
    {
        B = obj;
        C = flag;
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

    public final void a(boolean flag)
    {
        int l1 = getChildCount();
        int j1 = 0;
        int i1 = 0;
        while (j1 < l1) 
        {
label0:
            {
                View view = getChildAt(j1);
                g g1 = (g)view.getLayoutParams();
                int k1 = i1;
                if (!d(view))
                {
                    break label0;
                }
                if (flag)
                {
                    k1 = i1;
                    if (!g1.c)
                    {
                        break label0;
                    }
                }
                k1 = view.getWidth();
                if (a(view, 3))
                {
                    i1 |= a.a(view, -k1, view.getTop());
                } else
                {
                    i1 |= b.a(view, getWidth(), view.getTop());
                }
                g1.c = false;
                k1 = i1;
            }
            j1++;
            i1 = k1;
        }
        p.a();
        q.a();
        if (i1 != 0)
        {
            invalidate();
        }
    }

    public final boolean a()
    {
        View view = a(0x800003);
        if (view != null)
        {
            if (!d(view))
            {
                throw new IllegalArgumentException((new StringBuilder("View ")).append(view).append(" is not a drawer").toString());
            } else
            {
                return ((g)view.getLayoutParams()).d;
            }
        } else
        {
            return false;
        }
    }

    final boolean a(View view, int i1)
    {
        return (c(view) & i1) == i1;
    }

    public void addView(View view, int i1, android.view.ViewGroup.LayoutParams layoutparams)
    {
        super.addView(view, i1, layoutparams);
        if (d() != null || d(view))
        {
            ap.c(view, 4);
        } else
        {
            ap.c(view, 1);
        }
        if (!j)
        {
            ap.a(view, k);
        }
    }

    final int c(View view)
    {
        return android.support.v4.view.n.a(((g)view.getLayoutParams()).a, ap.h(this));
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return (layoutparams instanceof g) && super.checkLayoutParams(layoutparams);
    }

    public void computeScroll()
    {
        int j1 = getChildCount();
        float f1 = 0.0F;
        for (int i1 = 0; i1 < j1; i1++)
        {
            f1 = Math.max(f1, ((g)getChildAt(i1).getLayoutParams()).b);
        }

        n = f1;
        if (a.c() | b.c())
        {
            ap.d(this);
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
        flag1 = i(view);
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
        if (n > 0.0F && flag1)
        {
            int j1 = (int)((float)((m & 0xff000000) >>> 24) * n);
            int i4 = m;
            o.setColor(j1 << 24 | i4 & 0xffffff);
            canvas.drawRect(j2, 0.0F, i3, getHeight(), o);
        } else
        {
            if (y != null && a(view, 3))
            {
                int k1 = y.getIntrinsicWidth();
                int k2 = view.getRight();
                int j3 = a.k;
                float f1 = Math.max(0.0F, Math.min((float)k2 / (float)j3, 1.0F));
                y.setBounds(k2, view.getTop(), k1 + k2, view.getBottom());
                y.setAlpha((int)(255F * f1));
                y.draw(canvas);
                return flag2;
            }
            if (z != null && a(view, 5))
            {
                int i2 = z.getIntrinsicWidth();
                int l2 = view.getLeft();
                int k3 = getWidth();
                int j4 = b.k;
                float f2 = Math.max(0.0F, Math.min((float)(k3 - l2) / (float)j4, 1.0F));
                z.setBounds(l2 - i2, view.getTop(), l2, view.getBottom());
                z.setAlpha((int)(255F * f2));
                z.draw(canvas);
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
        if (s)
        {
            g g1 = (g)view.getLayoutParams();
            g1.b = 1.0F;
            g1.d = true;
            a(view, true);
        } else
        if (a(view, 3))
        {
            a.a(view, 0, view.getTop());
        } else
        {
            b.a(view, getWidth() - view.getWidth(), view.getTop());
        }
        invalidate();
    }

    public final void f(View view)
    {
        if (!d(view))
        {
            throw new IllegalArgumentException((new StringBuilder("View ")).append(view).append(" is not a sliding drawer").toString());
        }
        if (s)
        {
            view = (g)view.getLayoutParams();
            view.b = 0.0F;
            view.d = false;
        } else
        if (a(view, 3))
        {
            a.a(view, -view.getWidth(), view.getTop());
        } else
        {
            b.a(view, getWidth(), view.getTop());
        }
        invalidate();
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new g();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new g(getContext(), attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (layoutparams instanceof g)
        {
            return new g((g)layoutparams);
        }
        if (layoutparams instanceof android.view.ViewGroup.MarginLayoutParams)
        {
            return new g((android.view.ViewGroup.MarginLayoutParams)layoutparams);
        } else
        {
            return new g(layoutparams);
        }
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        s = true;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        s = true;
    }

    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (C && A != null)
        {
            int i1 = h.a(B);
            if (i1 > 0)
            {
                A.setBounds(0, 0, getWidth(), i1);
                A.draw(canvas);
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
        i1 = android.support.v4.view.z.a(motionevent);
        flag1 = a.a(motionevent);
        flag2 = b.a(motionevent);
        i1;
        JVM INSTR tableswitch 0 3: default 60
    //                   0 131
    //                   1 363
    //                   2 199
    //                   3 363;
           goto _L1 _L2 _L3 _L4 _L3
_L1:
        i1 = 0;
_L15:
        if (flag2 | flag1 || i1 != 0) goto _L6; else goto _L5
_L5:
        int j1;
        j1 = getChildCount();
        i1 = 0;
_L23:
        if (i1 >= j1) goto _L8; else goto _L7
_L7:
        if (!((g)getChildAt(i1).getLayoutParams()).c) goto _L10; else goto _L9
_L9:
        i1 = 1;
_L24:
        if (i1 == 0 && !d) goto _L11; else goto _L6
_L6:
        flag = true;
_L11:
        return flag;
_L2:
        float f1;
        float f3;
        f1 = motionevent.getX();
        f3 = motionevent.getY();
        w = f1;
        x = f3;
        if (n <= 0.0F) goto _L13; else goto _L12
_L12:
        motionevent = a.a((int)f1, (int)f3);
        if (motionevent == null || !i(motionevent)) goto _L13; else goto _L14
_L14:
        i1 = 1;
_L25:
        v = false;
        d = false;
          goto _L15
_L4:
        int k1;
        motionevent = a;
        k1 = ((ah) (motionevent)).d.length;
        j1 = 0;
_L21:
        if (j1 >= k1) goto _L17; else goto _L16
_L16:
        if ((((ah) (motionevent)).h & 1 << j1) != 0)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            float f2 = ((ah) (motionevent)).f[j1] - ((ah) (motionevent)).d[j1];
            float f4 = ((ah) (motionevent)).g[j1] - ((ah) (motionevent)).e[j1];
            if (f2 * f2 + f4 * f4 > (float)(((ah) (motionevent)).b * ((ah) (motionevent)).b))
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
        } else
        {
            i1 = 0;
        }
        if (i1 == 0) goto _L19; else goto _L18
_L18:
        i1 = 1;
_L22:
        if (i1 == 0) goto _L1; else goto _L20
_L20:
        p.a();
        q.a();
        i1 = 0;
          goto _L15
_L19:
        j1++;
          goto _L21
_L17:
        i1 = 0;
          goto _L22
_L3:
        a(true);
        v = false;
        d = false;
          goto _L1
_L10:
        i1++;
          goto _L23
_L8:
        i1 = 0;
          goto _L24
_L13:
        i1 = 0;
          goto _L25
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4)
        {
            boolean flag;
            if (e() != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                android.support.v4.view.s.c(keyevent);
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
            keyevent = e();
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
        r = true;
        k2 = k1 - i1;
        l2 = getChildCount();
        k1 = 0;
_L2:
        View view;
        g g1;
        if (k1 >= l2)
        {
            break MISSING_BLOCK_LABEL_446;
        }
        view = getChildAt(k1);
        if (view.getVisibility() != 8)
        {
            g1 = (g)view.getLayoutParams();
            if (!i(view))
            {
                break; /* Loop/switch isn't completed */
            }
            view.layout(g1.leftMargin, g1.topMargin, g1.leftMargin + view.getMeasuredWidth(), g1.topMargin + view.getMeasuredHeight());
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
            i2 = (int)((float)i3 * g1.b) + i1;
            f1 = (float)(i3 + i2) / (float)i3;
        } else
        {
            i2 = k2 - (int)((float)i3 * g1.b);
            f1 = (float)(k2 - i2) / (float)i3;
        }
        if (f1 != g1.b)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        g1.a & 0x70;
        JVM INSTR lookupswitch 2: default 212
    //                   16: 356
    //                   80: 316;
           goto _L3 _L4 _L5
_L4:
        break MISSING_BLOCK_LABEL_356;
_L3:
        view.layout(i2, g1.topMargin, i3 + i2, j3 + g1.topMargin);
_L7:
        if (flag1)
        {
            a(view, f1);
        }
        int j2;
        int k3;
        if (g1.b > 0.0F)
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
        view.layout(i2, i1 - g1.bottomMargin - view.getMeasuredHeight(), i3 + i2, i1 - g1.bottomMargin);
          goto _L7
        k3 = l1 - j1;
        j2 = (k3 - j3) / 2;
        if (j2 < g1.topMargin)
        {
            i1 = g1.topMargin;
        } else
        {
            i1 = j2;
            if (j2 + j3 > k3 - g1.bottomMargin)
            {
                i1 = k3 - g1.bottomMargin - j3;
            }
        }
        view.layout(i2, i1, i3 + i2, j3 + i1);
          goto _L7
        r = false;
        s = false;
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
        if (B != null && ap.p(this))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        k2 = ap.h(this);
        l2 = getChildCount();
        while (j2 < l2) 
        {
            View view = getChildAt(j2);
            if (view.getVisibility() != 8)
            {
                g g1 = (g)view.getLayoutParams();
                if (flag)
                {
                    int j3 = android.support.v4.view.n.a(g1.a, k2);
                    if (ap.p(view))
                    {
                        h.a(view, B, j3);
                    } else
                    {
                        h.a(g1, B, j3);
                    }
                }
                if (i(view))
                {
                    view.measure(android.view.View.MeasureSpec.makeMeasureSpec(l1 - g1.leftMargin - g1.rightMargin, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(k1 - g1.topMargin - g1.bottomMargin, 0x40000000));
                } else
                if (d(view))
                {
                    int k3 = c(view) & 7;
                    if ((k3 & 0) != 0)
                    {
                        throw new IllegalStateException((new StringBuilder("Child drawer has absolute gravity ")).append(b(k3)).append(" but this DrawerLayout already has a drawer view along that edge").toString());
                    }
                    view.measure(getChildMeasureSpec(i1, l + g1.leftMargin + g1.rightMargin, g1.width), getChildMeasureSpec(j1, g1.topMargin + g1.bottomMargin, g1.height));
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
                e(view);
            }
        }
        a(((SavedState) (parcelable)).b, 3);
        a(((SavedState) (parcelable)).c, 5);
    }

    protected Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        View view = d();
        if (view != null)
        {
            savedstate.a = ((g)view.getLayoutParams()).a;
        }
        savedstate.b = t;
        savedstate.c = u;
        return savedstate;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        a.b(motionevent);
        b.b(motionevent);
        motionevent.getAction() & 0xff;
        JVM INSTR tableswitch 0 3: default 56
    //                   0 58
    //                   1 90
    //                   2 56
    //                   3 203;
           goto _L1 _L2 _L3 _L1 _L4
_L1:
        return true;
_L2:
        float f1 = motionevent.getX();
        float f3 = motionevent.getY();
        w = f1;
        x = f3;
        v = false;
        d = false;
        return true;
_L3:
        float f2;
        float f4;
        f4 = motionevent.getX();
        f2 = motionevent.getY();
        motionevent = a.a((int)f4, (int)f2);
        if (motionevent == null || !i(motionevent)) goto _L6; else goto _L5
_L5:
        int i1;
        f4 -= w;
        f2 -= x;
        i1 = a.b;
        if (f4 * f4 + f2 * f2 >= (float)(i1 * i1)) goto _L6; else goto _L7
_L7:
        motionevent = d();
        if (motionevent == null) goto _L6; else goto _L8
_L8:
        boolean flag;
        if (a(motionevent) == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
_L10:
        a(flag);
        v = false;
        return true;
_L4:
        a(true);
        v = false;
        d = false;
        return true;
_L6:
        flag = true;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void requestDisallowInterceptTouchEvent(boolean flag)
    {
        super.requestDisallowInterceptTouchEvent(flag);
        v = flag;
        if (flag)
        {
            a(true);
        }
    }

    public void requestLayout()
    {
        if (!r)
        {
            super.requestLayout();
        }
    }

    public void setDrawerListener(f f1)
    {
        e = f1;
    }

    public void setDrawerLockMode(int i1)
    {
        a(i1, 3);
        a(i1, 5);
    }

    public void setScrimColor(int i1)
    {
        m = i1;
        invalidate();
    }

    public void setStatusBarBackground(int i1)
    {
        Drawable drawable;
        if (i1 != 0)
        {
            drawable = android.support.v4.a.a.a(getContext(), i1);
        } else
        {
            drawable = null;
        }
        A = drawable;
    }

    public void setStatusBarBackground(Drawable drawable)
    {
        A = drawable;
    }

    public void setStatusBarBackgroundColor(int i1)
    {
        A = new ColorDrawable(i1);
    }

    static 
    {
        boolean flag = true;
        if (android.os.Build.VERSION.SDK_INT < 19)
        {
            flag = false;
        }
        j = flag;
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            h = new d();
        } else
        {
            h = new e();
        }
    }

    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new h();
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
