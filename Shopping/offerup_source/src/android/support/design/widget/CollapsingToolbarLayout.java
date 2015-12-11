// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.a;
import android.support.v4.view.bi;
import android.support.v4.view.dn;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

// Referenced classes of package android.support.design.widget:
//            k, a, l, cb, 
//            bk, m, ca, n, 
//            AppBarLayout, o, bu, h

public class CollapsingToolbarLayout extends FrameLayout
{

    private boolean a;
    private int b;
    private Toolbar c;
    private View d;
    private int e;
    private int f;
    private int g;
    private int h;
    private final Rect i;
    private final k j;
    private boolean k;
    private Drawable l;
    private Drawable m;
    private int n;
    private boolean o;
    private bk p;
    private h q;
    private int r;
    private dn s;

    public CollapsingToolbarLayout(Context context)
    {
        this(context, null);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        a = true;
        i = new Rect();
        j = new k(this);
        j.a(a.b);
        context = context.obtainStyledAttributes(attributeset, a.k, i1, 0x7f0c0192);
        j.c(context.getInt(a.o, 0x800053));
        j.d(context.getInt(a.l, 0x800013));
        i1 = context.getDimensionPixelSize(a.p, 0);
        h = i1;
        g = i1;
        f = i1;
        e = i1;
        int j1;
        if (bi.h(this) == 1)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (context.hasValue(a.s))
        {
            j1 = context.getDimensionPixelSize(a.s, 0);
            if (i1 != 0)
            {
                g = j1;
            } else
            {
                e = j1;
            }
        }
        if (context.hasValue(a.r))
        {
            j1 = context.getDimensionPixelSize(a.r, 0);
            if (i1 != 0)
            {
                e = j1;
            } else
            {
                g = j1;
            }
        }
        if (context.hasValue(a.t))
        {
            f = context.getDimensionPixelSize(a.t, 0);
        }
        if (context.hasValue(a.q))
        {
            h = context.getDimensionPixelSize(a.q, 0);
        }
        k = context.getBoolean(a.x, true);
        setTitle(context.getText(a.w));
        j.f(0x7f0c0124);
        j.e(0x7f0c0117);
        if (context.hasValue(a.u))
        {
            j.f(context.getResourceId(a.u, 0));
        }
        if (context.hasValue(a.m))
        {
            j.e(context.getResourceId(a.m, 0));
        }
        setContentScrim(context.getDrawable(a.n));
        setStatusBarScrim(context.getDrawable(a.v));
        b = context.getResourceId(a.y, -1);
        context.recycle();
        setWillNotDraw(false);
        bi.a(this, new l(this));
    }

    static ca a(View view)
    {
        return b(view);
    }

    static dn a(CollapsingToolbarLayout collapsingtoolbarlayout)
    {
        return collapsingtoolbarlayout.s;
    }

    static dn a(CollapsingToolbarLayout collapsingtoolbarlayout, dn dn1)
    {
        collapsingtoolbarlayout.s = dn1;
        return dn1;
    }

    private void a()
    {
        Object obj;
        int i1;
        int j1;
        if (!a)
        {
            return;
        }
        j1 = getChildCount();
        i1 = 0;
        obj = null;
_L7:
        Object obj1;
        if (i1 >= j1)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        obj1 = getChildAt(i1);
        if (!(obj1 instanceof Toolbar)) goto _L2; else goto _L1
_L1:
        if (b == -1) goto _L4; else goto _L3
_L3:
        if (b != ((View) (obj1)).getId()) goto _L6; else goto _L5
_L5:
        obj1 = (Toolbar)obj1;
_L8:
        if (obj1 != null)
        {
            obj = obj1;
        }
        c = ((Toolbar) (obj));
        b();
        a = false;
        return;
_L6:
        if (obj == null)
        {
            obj = (Toolbar)obj1;
        }
_L2:
        i1++;
          goto _L7
_L4:
        obj1 = (Toolbar)obj1;
          goto _L8
        obj1 = null;
          goto _L8
    }

    private void a(int i1)
    {
        a();
        if (p != null) goto _L2; else goto _L1
_L1:
        p = android.support.design.widget.cb.a();
        p.a(600);
        p.a(android.support.design.widget.a.a);
        p.a(new m(this));
_L4:
        p.a(n, i1);
        p.a();
        return;
_L2:
        if (p.b())
        {
            p.d();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static void a(CollapsingToolbarLayout collapsingtoolbarlayout, int i1)
    {
        collapsingtoolbarlayout.setScrimAlpha(i1);
    }

    static int b(CollapsingToolbarLayout collapsingtoolbarlayout, int i1)
    {
        collapsingtoolbarlayout.r = i1;
        return i1;
    }

    static Drawable b(CollapsingToolbarLayout collapsingtoolbarlayout)
    {
        return collapsingtoolbarlayout.l;
    }

    private static ca b(View view)
    {
        ca ca2 = (ca)view.getTag(0x7f10000b);
        ca ca1 = ca2;
        if (ca2 == null)
        {
            ca1 = new ca(view);
            view.setTag(0x7f10000b, ca1);
        }
        return ca1;
    }

    private void b()
    {
        if (!k && d != null)
        {
            android.view.ViewParent viewparent = d.getParent();
            if (viewparent instanceof ViewGroup)
            {
                ((ViewGroup)viewparent).removeView(d);
            }
        }
        if (k && c != null)
        {
            if (d == null)
            {
                d = new View(getContext());
            }
            if (d.getParent() == null)
            {
                c.addView(d, -1, -1);
            }
        }
    }

    static Drawable c(CollapsingToolbarLayout collapsingtoolbarlayout)
    {
        return collapsingtoolbarlayout.m;
    }

    private n c()
    {
        return new n(super.generateDefaultLayoutParams());
    }

    static void d(CollapsingToolbarLayout collapsingtoolbarlayout)
    {
        if (!collapsingtoolbarlayout.o)
        {
            if (bi.B(collapsingtoolbarlayout) && !collapsingtoolbarlayout.isInEditMode())
            {
                collapsingtoolbarlayout.a(255);
            } else
            {
                collapsingtoolbarlayout.setScrimAlpha(255);
            }
            collapsingtoolbarlayout.o = true;
        }
    }

    static void e(CollapsingToolbarLayout collapsingtoolbarlayout)
    {
        if (collapsingtoolbarlayout.o)
        {
            if (bi.B(collapsingtoolbarlayout) && !collapsingtoolbarlayout.isInEditMode())
            {
                collapsingtoolbarlayout.a(0);
            } else
            {
                collapsingtoolbarlayout.setScrimAlpha(0);
            }
            collapsingtoolbarlayout.o = false;
        }
    }

    static k f(CollapsingToolbarLayout collapsingtoolbarlayout)
    {
        return collapsingtoolbarlayout.j;
    }

    private void setScrimAlpha(int i1)
    {
        if (i1 != n)
        {
            if (l != null && c != null)
            {
                bi.d(c);
            }
            n = i1;
            bi.d(this);
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams instanceof n;
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        a();
        if (c == null && l != null && n > 0)
        {
            l.mutate().setAlpha(n);
            l.draw(canvas);
        }
        if (k)
        {
            j.a(canvas);
        }
        if (m != null && n > 0)
        {
            int i1;
            if (s != null)
            {
                i1 = s.b();
            } else
            {
                i1 = 0;
            }
            if (i1 > 0)
            {
                m.setBounds(0, -r, getWidth(), i1 - r);
                m.mutate().setAlpha(n);
                m.draw(canvas);
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long l1)
    {
        a();
        if (view == c && l != null && n > 0)
        {
            l.mutate().setAlpha(n);
            l.draw(canvas);
        }
        return super.drawChild(canvas, view, l1);
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return c();
    }

    protected android.widget.FrameLayout.LayoutParams generateDefaultLayoutParams()
    {
        return c();
    }

    public volatile android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return generateLayoutParams(attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return new n(layoutparams);
    }

    public android.widget.FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new n(getContext(), attributeset);
    }

    public int getCollapsedTitleGravity()
    {
        return j.b();
    }

    public Drawable getContentScrim()
    {
        return l;
    }

    public int getExpandedTitleGravity()
    {
        return j.a();
    }

    final int getScrimTriggerOffset()
    {
        return bi.p(this) * 2;
    }

    public Drawable getStatusBarScrim()
    {
        return m;
    }

    public CharSequence getTitle()
    {
        if (k)
        {
            return j.d();
        } else
        {
            return null;
        }
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        android.view.ViewParent viewparent = getParent();
        if (viewparent instanceof AppBarLayout)
        {
            if (q == null)
            {
                q = new o(this, (byte)0);
            }
            ((AppBarLayout)viewparent).a(q);
        }
    }

    protected void onDetachedFromWindow()
    {
        android.view.ViewParent viewparent = getParent();
        if (q != null && (viewparent instanceof AppBarLayout))
        {
            ((AppBarLayout)viewparent).b(q);
        }
        super.onDetachedFromWindow();
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        super.onLayout(flag, i1, j1, k1, l1);
        int i2 = 0;
        for (int j2 = getChildCount(); i2 < j2; i2++)
        {
            View view = getChildAt(i2);
            if (s != null && !bi.v(view))
            {
                int k2 = s.b();
                if (view.getTop() < k2)
                {
                    view.offsetTopAndBottom(k2);
                }
            }
            b(view).a();
        }

        if (k && d != null)
        {
            android.support.design.widget.bu.a(this, d, i);
            j.b(i.left, l1 - i.height(), i.right, l1);
            j.a(e, i.bottom + f, k1 - i1 - g, l1 - j1 - h);
            j.c();
        }
        if (c != null)
        {
            if (k && TextUtils.isEmpty(j.d()))
            {
                j.a(c.getTitle());
            }
            setMinimumHeight(c.getHeight());
        }
    }

    protected void onMeasure(int i1, int j1)
    {
        a();
        super.onMeasure(i1, j1);
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        if (l != null)
        {
            l.setBounds(0, 0, i1, j1);
        }
    }

    public void setCollapsedTitleGravity(int i1)
    {
        j.c(i1);
    }

    public void setCollapsedTitleTextAppearance(int i1)
    {
        j.e(i1);
    }

    public void setCollapsedTitleTextColor(int i1)
    {
        j.a(i1);
    }

    public void setContentScrim(Drawable drawable)
    {
        if (l != drawable)
        {
            if (l != null)
            {
                l.setCallback(null);
            }
            l = drawable;
            drawable.setBounds(0, 0, getWidth(), getHeight());
            drawable.setCallback(this);
            drawable.mutate().setAlpha(n);
            bi.d(this);
        }
    }

    public void setContentScrimColor(int i1)
    {
        setContentScrim(new ColorDrawable(i1));
    }

    public void setContentScrimResource(int i1)
    {
        setContentScrim(android.support.v4.b.a.a(getContext(), i1));
    }

    public void setExpandedTitleColor(int i1)
    {
        j.b(i1);
    }

    public void setExpandedTitleGravity(int i1)
    {
        j.c(i1);
    }

    public void setExpandedTitleTextAppearance(int i1)
    {
        j.f(i1);
    }

    public void setStatusBarScrim(Drawable drawable)
    {
        if (m != drawable)
        {
            if (m != null)
            {
                m.setCallback(null);
            }
            m = drawable;
            drawable.setCallback(this);
            drawable.mutate().setAlpha(n);
            bi.d(this);
        }
    }

    public void setStatusBarScrimColor(int i1)
    {
        setStatusBarScrim(new ColorDrawable(i1));
    }

    public void setStatusBarScrimResource(int i1)
    {
        setStatusBarScrim(android.support.v4.b.a.a(getContext(), i1));
    }

    public void setTitle(CharSequence charsequence)
    {
        j.a(charsequence);
    }

    public void setTitleEnabled(boolean flag)
    {
        if (flag != k)
        {
            k = flag;
            b();
            requestLayout();
        }
    }
}
