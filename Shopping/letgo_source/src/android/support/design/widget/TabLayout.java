// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ad;
import android.support.v4.view.ah;
import android.support.v7.internal.widget.p;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package android.support.design.widget:
//            n, a, g

public class TabLayout extends HorizontalScrollView
{
    public static interface a
    {

        public abstract void a(c c1);

        public abstract void b(c c1);

        public abstract void c(c c1);
    }

    private class b extends LinearLayout
    {

        final TabLayout a;
        private int b;
        private final Paint c = new Paint();
        private int d;
        private float e;
        private int f;
        private int g;

        static float a(b b1, float f1)
        {
            b1.e = f1;
            return f1;
        }

        static int a(b b1, int i1)
        {
            b1.d = i1;
            return i1;
        }

        private void a()
        {
            View view = getChildAt(d);
            int i1;
            int j1;
            if (view != null && view.getWidth() > 0)
            {
                int l1 = view.getLeft();
                int k1 = view.getRight();
                i1 = k1;
                j1 = l1;
                if (e > 0.0F)
                {
                    i1 = k1;
                    j1 = l1;
                    if (d < getChildCount() - 1)
                    {
                        View view1 = getChildAt(d + 1);
                        float f1 = e;
                        float f2 = view1.getLeft();
                        float f3 = e;
                        j1 = (int)((float)l1 * (1.0F - f3) + f1 * f2);
                        f1 = e;
                        f2 = view1.getRight();
                        f3 = e;
                        i1 = (int)((float)k1 * (1.0F - f3) + f2 * f1);
                    }
                }
            } else
            {
                i1 = -1;
                j1 = -1;
            }
            b(j1, i1);
        }

        static void a(b b1, int i1, int j1)
        {
            b1.b(i1, j1);
        }

        private void b(int i1, int j1)
        {
            if (i1 != f || j1 != g)
            {
                f = i1;
                g = j1;
                ah.d(this);
            }
        }

        void a(int i1)
        {
            c.setColor(i1);
            ah.d(this);
        }

        void a(int i1, float f1)
        {
            if (TabLayout.a(getAnimation()))
            {
                return;
            } else
            {
                d = i1;
                e = f1;
                a();
                return;
            }
        }

        void a(int i1, int j1)
        {
            View view;
            int k1;
            int l1;
            int i2;
            int j2;
            if (ah.g(this) == 1)
            {
                k1 = 1;
            } else
            {
                k1 = 0;
            }
            view = getChildAt(i1);
            i2 = view.getLeft();
            j2 = view.getRight();
            if (Math.abs(i1 - d) <= 1)
            {
                k1 = f;
                l1 = g;
            } else
            {
                l1 = TabLayout.b(a, 24);
                if (i1 < d)
                {
                    if (k1 != 0)
                    {
                        l1 = i2 - l1;
                        k1 = l1;
                    } else
                    {
                        l1 = j2 + l1;
                        k1 = l1;
                    }
                } else
                if (k1 != 0)
                {
                    l1 = j2 + l1;
                    k1 = l1;
                } else
                {
                    l1 = i2 - l1;
                    k1 = l1;
                }
            }
            if (k1 != i2 || l1 != j2)
            {
                g g1 = android.support.design.widget.n.a();
                g1.a(android.support.design.widget.a.b);
                g1.a(j1);
                g1.a(0.0F, 1.0F);
                g1.a(new g.c(this, k1, i2, l1, j2) {

                    final int a;
                    final int b;
                    final int c;
                    final int d;
                    final b e;

                    public void a(g g1)
                    {
                        float f1 = g1.d();
                        b.a(e, android.support.design.widget.a.a(a, b, f1), android.support.design.widget.a.a(c, d, f1));
                    }

            
            {
                e = b1;
                a = i1;
                b = j1;
                c = k1;
                d = l1;
                super();
            }
                });
                g1.a(new g.b(this, i1) {

                    final int a;
                    final b b;

                    public void a(g g1)
                    {
                        b.a(b, a);
                        b.a(b, 0.0F);
                    }

                    public void b(g g1)
                    {
                        b.a(b, a);
                        b.a(b, 0.0F);
                    }

            
            {
                b = b1;
                a = i1;
                super();
            }
                });
                g1.a();
            }
        }

        void b(int i1)
        {
            b = i1;
            ah.d(this);
        }

        protected void onDraw(Canvas canvas)
        {
            if (f >= 0 && g > f)
            {
                canvas.drawRect(f, getHeight() - b, g, getHeight(), c);
            }
        }

        protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
        {
            super.onLayout(flag, i1, j1, k1, l1);
            if (!TabLayout.a(getAnimation()))
            {
                a();
            }
        }

        protected void onMeasure(int i1, int j1)
        {
            super.onMeasure(i1, j1);
            break MISSING_BLOCK_LABEL_6;
            if (android.view.View.MeasureSpec.getMode(i1) == 0x40000000 && TabLayout.j(a) == 1 && TabLayout.k(a) == 1)
            {
                int k2 = getChildCount();
                int l2 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
                int l1 = 0;
                int k1 = 0;
                for (; l1 < k2; l1++)
                {
                    View view = getChildAt(l1);
                    view.measure(l2, j1);
                    k1 = Math.max(k1, view.getMeasuredWidth());
                }

                if (k1 > 0)
                {
                    int i2 = TabLayout.b(a, 16);
                    if (k1 * k2 <= getMeasuredWidth() - i2 * 2)
                    {
                        for (int j2 = 0; j2 < k2; j2++)
                        {
                            android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)getChildAt(j2).getLayoutParams();
                            layoutparams.width = k1;
                            layoutparams.weight = 0.0F;
                        }

                    } else
                    {
                        TabLayout.c(a, 0);
                        TabLayout.l(a);
                    }
                    super.onMeasure(i1, j1);
                    return;
                }
            }
            return;
        }

        b(Context context)
        {
            a = TabLayout.this;
            super(context);
            d = -1;
            f = -1;
            g = -1;
            setWillNotDraw(false);
        }
    }

    public static final class c
    {

        private Drawable a;
        private CharSequence b;
        private CharSequence c;
        private int d;
        private View e;
        private final TabLayout f;

        static TabLayout a(c c1)
        {
            return c1.f;
        }

        public c a(CharSequence charsequence)
        {
            b = charsequence;
            if (d >= 0)
            {
                TabLayout.a(f, d);
            }
            return this;
        }

        View a()
        {
            return e;
        }

        void a(int i1)
        {
            d = i1;
        }

        public Drawable b()
        {
            return a;
        }

        public int c()
        {
            return d;
        }

        public CharSequence d()
        {
            return b;
        }

        public void e()
        {
            f.b(this);
        }

        public CharSequence f()
        {
            return c;
        }

        c(TabLayout tablayout)
        {
            d = -1;
            f = tablayout;
        }
    }

    public static class d
        implements android.support.v4.view.ViewPager.e
    {

        private final WeakReference a;
        private int b;

        public void a(int i1)
        {
            b = i1;
        }

        public void a(int i1, float f1, int j1)
        {
            boolean flag = true;
            TabLayout tablayout = (TabLayout)a.get();
            if (tablayout != null)
            {
                if (b != 1)
                {
                    flag = false;
                }
                tablayout.a(i1, f1, flag);
            }
        }

        public void b(int i1)
        {
            TabLayout tablayout = (TabLayout)a.get();
            if (tablayout != null)
            {
                tablayout.a(i1).e();
            }
        }

        public d(TabLayout tablayout)
        {
            a = new WeakReference(tablayout);
        }
    }

    class e extends LinearLayout
        implements android.view.View.OnLongClickListener
    {

        final TabLayout a;
        private final c b;
        private TextView c;
        private ImageView d;
        private View e;

        final void a()
        {
            Object obj = b;
            Object obj1 = ((c) (obj)).a();
            if (obj1 != null)
            {
                obj = ((View) (obj1)).getParent();
                if (obj != this)
                {
                    if (obj != null)
                    {
                        ((ViewGroup)obj).removeView(((View) (obj1)));
                    }
                    addView(((View) (obj1)));
                }
                e = ((View) (obj1));
                if (c != null)
                {
                    c.setVisibility(8);
                }
                if (d != null)
                {
                    d.setVisibility(8);
                    d.setImageDrawable(null);
                }
                return;
            }
            if (e != null)
            {
                removeView(e);
                e = null;
            }
            Drawable drawable = ((c) (obj)).b();
            obj1 = ((c) (obj)).d();
            boolean flag;
            if (drawable != null)
            {
                if (d == null)
                {
                    ImageView imageview = new ImageView(getContext());
                    android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2);
                    layoutparams.gravity = 16;
                    imageview.setLayoutParams(layoutparams);
                    addView(imageview, 0);
                    d = imageview;
                }
                d.setImageDrawable(drawable);
                d.setVisibility(0);
            } else
            if (d != null)
            {
                d.setVisibility(8);
                d.setImageDrawable(null);
            }
            if (!TextUtils.isEmpty(((CharSequence) (obj1))))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                if (c == null)
                {
                    AppCompatTextView appcompattextview = new AppCompatTextView(getContext());
                    appcompattextview.setTextAppearance(getContext(), TabLayout.h(a));
                    appcompattextview.setMaxLines(2);
                    appcompattextview.setEllipsize(android.text.TextUtils.TruncateAt.END);
                    appcompattextview.setGravity(17);
                    if (TabLayout.i(a) != null)
                    {
                        appcompattextview.setTextColor(TabLayout.i(a));
                    }
                    addView(appcompattextview, -2, -2);
                    c = appcompattextview;
                }
                c.setText(((CharSequence) (obj1)));
                c.setContentDescription(((c) (obj)).f());
                c.setVisibility(0);
            } else
            if (c != null)
            {
                c.setVisibility(8);
                c.setText(null);
            }
            if (d != null)
            {
                d.setContentDescription(((c) (obj)).f());
            }
            if (!flag && !TextUtils.isEmpty(((c) (obj)).f()))
            {
                setOnLongClickListener(this);
                return;
            } else
            {
                setOnLongClickListener(null);
                setLongClickable(false);
                return;
            }
        }

        public c b()
        {
            return b;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent)
        {
            super.onInitializeAccessibilityEvent(accessibilityevent);
            accessibilityevent.setClassName(android/support/v7/app/ActionBar$b.getName());
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo)
        {
            super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
            accessibilitynodeinfo.setClassName(android/support/v7/app/ActionBar$b.getName());
        }

        public boolean onLongClick(View view)
        {
            view = new int[2];
            getLocationOnScreen(view);
            Object obj = getContext();
            int i1 = getWidth();
            int j1 = getHeight();
            int k1 = ((Context) (obj)).getResources().getDisplayMetrics().widthPixels;
            obj = Toast.makeText(((Context) (obj)), b.f(), 0);
            ((Toast) (obj)).setGravity(49, (view[0] + i1 / 2) - k1 / 2, j1);
            ((Toast) (obj)).show();
            return true;
        }

        public void onMeasure(int i1, int j1)
        {
            super.onMeasure(i1, j1);
            if (TabLayout.f(a) != 0 && getMeasuredWidth() > TabLayout.f(a))
            {
                super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(TabLayout.f(a), 0x40000000), j1);
            } else
            if (TabLayout.g(a) > 0 && getMeasuredHeight() < TabLayout.g(a))
            {
                super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(TabLayout.g(a), 0x40000000), j1);
                return;
            }
        }

        public void setSelected(boolean flag)
        {
            boolean flag1;
            if (isSelected() != flag)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            super.setSelected(flag);
            if (flag1 && flag)
            {
                sendAccessibilityEvent(4);
                if (c != null)
                {
                    c.setSelected(flag);
                }
                if (d != null)
                {
                    d.setSelected(flag);
                }
            }
        }

        public e(Context context, c c1)
        {
            a = TabLayout.this;
            super(context);
            b = c1;
            if (TabLayout.a(TabLayout.this) != 0)
            {
                setBackgroundDrawable(android.support.v7.internal.widget.p.a(context, TabLayout.a(TabLayout.this)));
            }
            ah.a(this, TabLayout.b(TabLayout.this), TabLayout.c(TabLayout.this), TabLayout.d(TabLayout.this), TabLayout.e(TabLayout.this));
            setGravity(17);
            a();
        }
    }

    public static class f
        implements a
    {

        private final ViewPager a;

        public void a(c c1)
        {
            a.setCurrentItem(c1.c());
        }

        public void b(c c1)
        {
        }

        public void c(c c1)
        {
        }

        public f(ViewPager viewpager)
        {
            a = viewpager;
        }
    }


    private final ArrayList a;
    private c b;
    private final b c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private ColorStateList i;
    private final int j;
    private final int k;
    private int l;
    private final int m;
    private int n;
    private int o;
    private int p;
    private a q;
    private android.view.View.OnClickListener r;

    public TabLayout(Context context)
    {
        this(context, null);
    }

    public TabLayout(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public TabLayout(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        a = new ArrayList();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        c = new b(context);
        addView(c, -2, -1);
        context = context.obtainStyledAttributes(attributeset, android.support.v7.a.g.TabLayout, i1, android.support.v7.a.f.Widget_Design_TabLayout);
        c.b(context.getDimensionPixelSize(android.support.v7.a.g.TabLayout_tabIndicatorHeight, 0));
        c.a(context.getColor(android.support.v7.a.g.TabLayout_tabIndicatorColor, 0));
        h = context.getResourceId(android.support.v7.a.g.TabLayout_tabTextAppearance, android.support.v7.a.f.TextAppearance_Design_Tab);
        i1 = context.getDimensionPixelSize(android.support.v7.a.g.TabLayout_tabPadding, 0);
        g = i1;
        f = i1;
        e = i1;
        d = i1;
        d = context.getDimensionPixelSize(android.support.v7.a.g.TabLayout_tabPaddingStart, d);
        e = context.getDimensionPixelSize(android.support.v7.a.g.TabLayout_tabPaddingTop, e);
        f = context.getDimensionPixelSize(android.support.v7.a.g.TabLayout_tabPaddingEnd, f);
        g = context.getDimensionPixelSize(android.support.v7.a.g.TabLayout_tabPaddingBottom, g);
        i = e(h);
        if (context.hasValue(android.support.v7.a.g.TabLayout_tabTextColor))
        {
            i = context.getColorStateList(android.support.v7.a.g.TabLayout_tabTextColor);
        }
        if (context.hasValue(android.support.v7.a.g.TabLayout_tabSelectedTextColor))
        {
            i1 = context.getColor(android.support.v7.a.g.TabLayout_tabSelectedTextColor, 0);
            i = a(i.getDefaultColor(), i1);
        }
        k = context.getDimensionPixelSize(android.support.v7.a.g.TabLayout_tabMinWidth, 0);
        m = context.getDimensionPixelSize(android.support.v7.a.g.TabLayout_tabMaxWidth, 0);
        j = context.getResourceId(android.support.v7.a.g.TabLayout_tabBackground, 0);
        n = context.getDimensionPixelSize(android.support.v7.a.g.TabLayout_tabContentStart, 0);
        p = context.getInt(android.support.v7.a.g.TabLayout_tabMode, 1);
        o = context.getInt(android.support.v7.a.g.TabLayout_tabGravity, 0);
        context.recycle();
        e();
    }

    private int a(int i1, float f1)
    {
        int j1 = 0;
        boolean flag = false;
        if (p == 0)
        {
            View view1 = c.getChildAt(i1);
            float f2;
            View view;
            if (i1 + 1 < c.getChildCount())
            {
                view = c.getChildAt(i1 + 1);
            } else
            {
                view = null;
            }
            if (view1 != null)
            {
                i1 = view1.getWidth();
            } else
            {
                i1 = 0;
            }
            j1 = ((flag) ? 1 : 0);
            if (view != null)
            {
                j1 = view.getWidth();
            }
            f2 = view1.getLeft();
            j1 = (int)(((float)(j1 + i1) * f1 * 0.5F + f2 + (float)view1.getWidth() * 0.5F) - (float)getWidth() * 0.5F);
        }
        return j1;
    }

    static int a(TabLayout tablayout)
    {
        return tablayout.j;
    }

    private static ColorStateList a(int i1, int j1)
    {
        return new ColorStateList(new int[][] {
            SELECTED_STATE_SET, EMPTY_STATE_SET
        }, new int[] {
            j1, i1
        });
    }

    private void a(c c1, int i1)
    {
        c1.a(i1);
        a.add(i1, c1);
        int j1 = a.size();
        for (i1++; i1 < j1; i1++)
        {
            ((c)a.get(i1)).a(i1);
        }

    }

    static void a(TabLayout tablayout, int i1)
    {
        tablayout.b(i1);
    }

    private void a(android.widget.LinearLayout.LayoutParams layoutparams)
    {
        if (p == 1 && o == 0)
        {
            layoutparams.width = 0;
            layoutparams.weight = 1.0F;
            return;
        } else
        {
            layoutparams.width = -2;
            layoutparams.weight = 0.0F;
            return;
        }
    }

    static boolean a(Animation animation)
    {
        return b(animation);
    }

    static int b(TabLayout tablayout)
    {
        return tablayout.d;
    }

    static int b(TabLayout tablayout, int i1)
    {
        return tablayout.c(i1);
    }

    private void b(int i1)
    {
        e e1 = (e)c.getChildAt(i1);
        if (e1 != null)
        {
            e1.a();
        }
    }

    private void b(c c1, boolean flag)
    {
        c1 = c(c1);
        c.addView(c1, d());
        if (flag)
        {
            c1.setSelected(true);
        }
    }

    private static boolean b(Animation animation)
    {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }

    private int c(int i1)
    {
        return Math.round(getResources().getDisplayMetrics().density * (float)i1);
    }

    static int c(TabLayout tablayout)
    {
        return tablayout.e;
    }

    static int c(TabLayout tablayout, int i1)
    {
        tablayout.o = i1;
        return i1;
    }

    private e c(c c1)
    {
        c1 = new e(getContext(), c1);
        c1.setFocusable(true);
        if (r == null)
        {
            r = new android.view.View.OnClickListener() {

                final TabLayout a;

                public void onClick(View view)
                {
                    ((e)view).b().e();
                }

            
            {
                a = TabLayout.this;
                super();
            }
            };
        }
        c1.setOnClickListener(r);
        return c1;
    }

    private void c()
    {
        int i1 = 0;
        for (int j1 = c.getChildCount(); i1 < j1; i1++)
        {
            b(i1);
        }

    }

    static int d(TabLayout tablayout)
    {
        return tablayout.f;
    }

    private android.widget.LinearLayout.LayoutParams d()
    {
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -1);
        a(layoutparams);
        return layoutparams;
    }

    private void d(int i1)
    {
        clearAnimation();
        if (i1 == -1)
        {
            return;
        }
        if (getWindowToken() == null || !ah.z(this))
        {
            a(i1, 0.0F, true);
            return;
        }
        int j1 = getScrollX();
        int k1 = a(i1, 0.0F);
        if (j1 != k1)
        {
            g g1 = android.support.design.widget.n.a();
            g1.a(android.support.design.widget.a.b);
            g1.a(300);
            g1.a(j1, k1);
            g1.a(new g.c() {

                final TabLayout a;

                public void a(g g2)
                {
                    a.scrollTo(g2.b(), 0);
                }

            
            {
                a = TabLayout.this;
                super();
            }
            });
            g1.a();
        }
        c.a(i1, 300);
    }

    static int e(TabLayout tablayout)
    {
        return tablayout.g;
    }

    private ColorStateList e(int i1)
    {
        TypedArray typedarray = getContext().obtainStyledAttributes(i1, android.support.v7.a.g.TextAppearance);
        ColorStateList colorstatelist = typedarray.getColorStateList(android.support.v7.a.g.TextAppearance_android_textColor);
        typedarray.recycle();
        return colorstatelist;
        Exception exception;
        exception;
        typedarray.recycle();
        throw exception;
    }

    private void e()
    {
        int i1;
        if (p == 0)
        {
            i1 = Math.max(0, n - d);
        } else
        {
            i1 = 0;
        }
        ah.a(c, i1, 0, 0, 0);
        p;
        JVM INSTR tableswitch 0 1: default 60
    //                   0 76
    //                   1 65;
           goto _L1 _L2 _L3
_L1:
        f();
        return;
_L3:
        c.setGravity(1);
        continue; /* Loop/switch isn't completed */
_L2:
        c.setGravity(0x800003);
        if (true) goto _L1; else goto _L4
_L4:
    }

    static int f(TabLayout tablayout)
    {
        return tablayout.l;
    }

    private void f()
    {
        for (int i1 = 0; i1 < c.getChildCount(); i1++)
        {
            View view = c.getChildAt(i1);
            a((android.widget.LinearLayout.LayoutParams)view.getLayoutParams());
            view.requestLayout();
        }

    }

    static int g(TabLayout tablayout)
    {
        return tablayout.k;
    }

    static int h(TabLayout tablayout)
    {
        return tablayout.h;
    }

    static ColorStateList i(TabLayout tablayout)
    {
        return tablayout.i;
    }

    static int j(TabLayout tablayout)
    {
        return tablayout.p;
    }

    static int k(TabLayout tablayout)
    {
        return tablayout.o;
    }

    static void l(TabLayout tablayout)
    {
        tablayout.f();
    }

    private void setSelectedTabView(int i1)
    {
        int k1 = c.getChildCount();
        int j1 = 0;
        while (j1 < k1) 
        {
            View view = c.getChildAt(j1);
            boolean flag;
            if (j1 == i1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.setSelected(flag);
            j1++;
        }
    }

    public c a()
    {
        return new c(this);
    }

    public c a(int i1)
    {
        return (c)a.get(i1);
    }

    public void a(int i1, float f1, boolean flag)
    {
        if (!b(getAnimation()) && i1 >= 0 && i1 < c.getChildCount())
        {
            c.a(i1, f1);
            scrollTo(a(i1, f1), 0);
            if (flag)
            {
                setSelectedTabView(Math.round((float)i1 + f1));
                return;
            }
        }
    }

    public void a(c c1)
    {
        a(c1, a.isEmpty());
    }

    public void a(c c1, boolean flag)
    {
        if (c.a(c1) != this)
        {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        b(c1, flag);
        a(c1, a.size());
        if (flag)
        {
            c1.e();
        }
    }

    public void b()
    {
        c.removeAllViews();
        for (Iterator iterator = a.iterator(); iterator.hasNext(); iterator.remove())
        {
            ((c)iterator.next()).a(-1);
        }

    }

    void b(c c1)
    {
        if (b == c1)
        {
            if (b != null)
            {
                if (q != null)
                {
                    q.c(b);
                }
                d(c1.c());
            }
        } else
        {
            int i1;
            if (c1 != null)
            {
                i1 = c1.c();
            } else
            {
                i1 = -1;
            }
            setSelectedTabView(i1);
            if ((b == null || b.c() == -1) && i1 != -1)
            {
                a(i1, 0.0F, true);
            } else
            {
                d(i1);
            }
            if (b != null && q != null)
            {
                q.b(b);
            }
            b = c1;
            if (b != null && q != null)
            {
                q.a(b);
                return;
            }
        }
    }

    public int getTabCount()
    {
        return a.size();
    }

    public int getTabGravity()
    {
        return o;
    }

    public int getTabMode()
    {
        return p;
    }

    public ColorStateList getTabTextColors()
    {
        return i;
    }

    protected void onMeasure(int i1, int j1)
    {
        android.view.View.MeasureSpec.getMode(j1);
        JVM INSTR lookupswitch 2: default 32
    //                   -2147483648: 145
    //                   0: 168;
           goto _L1 _L2 _L3
_L1:
label0:
        {
            super.onMeasure(i1, j1);
            if (p == 1 && getChildCount() == 1)
            {
                View view = getChildAt(0);
                i1 = getMeasuredWidth();
                if (view.getMeasuredWidth() > i1)
                {
                    j1 = getChildMeasureSpec(j1, getPaddingTop() + getPaddingBottom(), view.getLayoutParams().height);
                    view.measure(android.view.View.MeasureSpec.makeMeasureSpec(i1, 0x40000000), j1);
                }
            }
            j1 = m;
            int k1 = getMeasuredWidth() - c(56);
            if (j1 != 0)
            {
                i1 = j1;
                if (j1 <= k1)
                {
                    break label0;
                }
            }
            i1 = k1;
        }
        l = i1;
        return;
_L2:
        j1 = android.view.View.MeasureSpec.makeMeasureSpec(Math.min(c(48), android.view.View.MeasureSpec.getSize(j1)), 0x40000000);
        continue; /* Loop/switch isn't completed */
_L3:
        j1 = android.view.View.MeasureSpec.makeMeasureSpec(c(48), 0x40000000);
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void setOnTabSelectedListener(a a1)
    {
        q = a1;
    }

    public void setTabGravity(int i1)
    {
        if (o != i1)
        {
            o = i1;
            e();
        }
    }

    public void setTabMode(int i1)
    {
        if (i1 != p)
        {
            p = i1;
            e();
        }
    }

    public void setTabTextColors(ColorStateList colorstatelist)
    {
        if (i != colorstatelist)
        {
            i = colorstatelist;
            c();
        }
    }

    public void setTabsFromPagerAdapter(ad ad1)
    {
        b();
        int i1 = 0;
        for (int j1 = ad1.b(); i1 < j1; i1++)
        {
            a(a().a(ad1.c(i1)));
        }

    }

    public void setupWithViewPager(ViewPager viewpager)
    {
        ad ad1 = viewpager.getAdapter();
        if (ad1 == null)
        {
            throw new IllegalArgumentException("ViewPager does not have a PagerAdapter set");
        } else
        {
            setTabsFromPagerAdapter(ad1);
            viewpager.a(new d(this));
            setOnTabSelectedListener(new f(viewpager));
            return;
        }
    }
}
