// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ai;
import android.support.v4.view.ba;
import android.support.v4.view.be;
import android.support.v7.d.a;
import android.support.v7.internal.view.f;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ActionMenuView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

// Referenced classes of package android.support.v7.internal.widget:
//            a, s, u

public class ActionBarContextView extends android.support.v7.internal.widget.a
    implements be
{

    private CharSequence j;
    private CharSequence k;
    private View l;
    private View m;
    private LinearLayout n;
    private TextView o;
    private TextView p;
    private int q;
    private int r;
    private Drawable s;
    private boolean t;
    private int u;
    private f v;
    private boolean w;
    private int x;

    public ActionBarContextView(Context context)
    {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, android.support.v7.a.a.a.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        context = android.support.v7.internal.widget.s.a(context, attributeset, android.support.v7.a.a.k.ActionMode, i, 0);
        setBackgroundDrawable(context.a(android.support.v7.a.a.k.ActionMode_background));
        q = context.f(android.support.v7.a.a.k.ActionMode_titleTextStyle, 0);
        r = context.f(android.support.v7.a.a.k.ActionMode_subtitleTextStyle, 0);
        h = context.e(android.support.v7.a.a.k.ActionMode_height, 0);
        s = context.a(android.support.v7.a.a.k.ActionMode_backgroundSplit);
        u = context.f(android.support.v7.a.a.k.ActionMode_closeItemLayout, android.support.v7.a.a.h.abc_action_mode_close_item_material);
        context.b();
    }

    private void e()
    {
label0:
        {
            byte byte1 = 8;
            boolean flag = true;
            if (n == null)
            {
                LayoutInflater.from(getContext()).inflate(android.support.v7.a.a.h.abc_action_bar_title_item, this);
                n = (LinearLayout)getChildAt(getChildCount() - 1);
                o = (TextView)n.findViewById(android.support.v7.a.a.f.action_bar_title);
                p = (TextView)n.findViewById(android.support.v7.a.a.f.action_bar_subtitle);
                if (q != 0)
                {
                    o.setTextAppearance(getContext(), q);
                }
                if (r != 0)
                {
                    p.setTextAppearance(getContext(), r);
                }
            }
            o.setText(j);
            p.setText(k);
            Object obj;
            byte byte0;
            int i;
            if (!TextUtils.isEmpty(j))
            {
                byte0 = 1;
            } else
            {
                byte0 = 0;
            }
            if (TextUtils.isEmpty(k))
            {
                flag = false;
            }
            obj = p;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            ((TextView) (obj)).setVisibility(i);
            obj = n;
            if (byte0 == 0)
            {
                byte0 = byte1;
                if (!flag)
                {
                    break label0;
                }
            }
            byte0 = 0;
        }
        ((LinearLayout) (obj)).setVisibility(byte0);
        if (n.getParent() == null)
        {
            addView(n);
        }
    }

    private void f()
    {
        f f1 = v;
        if (f1 != null)
        {
            v = null;
            f1.b();
        }
    }

    private f g()
    {
        ai.a(l, -l.getWidth() - ((android.view.ViewGroup.MarginLayoutParams)l.getLayoutParams()).leftMargin);
        ba ba1 = ai.s(l).b(0.0F);
        ba1.a(200L);
        ba1.a(this);
        ba1.a(new DecelerateInterpolator());
        f f1 = new f();
        f1.a(ba1);
        if (c != null)
        {
            int i = c.getChildCount();
            if (i > 0)
            {
                int j1 = i - 1;
                for (int i1 = 0; j1 >= 0; i1++)
                {
                    Object obj = c.getChildAt(j1);
                    ai.e(((View) (obj)), 0.0F);
                    obj = ai.s(((View) (obj))).d(1.0F);
                    ((ba) (obj)).a(300L);
                    f1.a(((ba) (obj)));
                    j1--;
                }

            }
        }
        return f1;
    }

    private f h()
    {
        ba ba1 = ai.s(l).b(-l.getWidth() - ((android.view.ViewGroup.MarginLayoutParams)l.getLayoutParams()).leftMargin);
        ba1.a(200L);
        ba1.a(this);
        ba1.a(new DecelerateInterpolator());
        f f1 = new f();
        f1.a(ba1);
        if (c != null)
        {
            if (c.getChildCount() <= 0);
        }
        return f1;
    }

    public volatile void a(int i)
    {
        super.a(i);
    }

    public void a(a a1)
    {
        android.view.ViewGroup.LayoutParams layoutparams;
        if (l == null)
        {
            l = LayoutInflater.from(getContext()).inflate(u, this, false);
            addView(l);
        } else
        if (l.getParent() == null)
        {
            addView(l);
        }
        l.findViewById(android.support.v7.a.a.f.action_mode_close_button).setOnClickListener(new android.view.View.OnClickListener(a1) {

            final a a;
            final ActionBarContextView b;

            public void onClick(View view)
            {
                a.c();
            }

            
            {
                b = ActionBarContextView.this;
                a = a1;
                super();
            }
        });
        a1 = (android.support.v7.internal.view.menu.f)a1.b();
        if (d != null)
        {
            d.g();
        }
        d = new ActionMenuPresenter(getContext());
        d.c(true);
        layoutparams = new android.view.ViewGroup.LayoutParams(-2, -1);
        if (!f)
        {
            a1.a(d, b);
            c = (ActionMenuView)d.a(this);
            c.setBackgroundDrawable(null);
            addView(c, layoutparams);
        } else
        {
            d.a(getContext().getResources().getDisplayMetrics().widthPixels, true);
            d.b(0x7fffffff);
            layoutparams.width = -1;
            layoutparams.height = h;
            a1.a(d, b);
            c = (ActionMenuView)d.a(this);
            c.setBackgroundDrawable(s);
            e.addView(c, layoutparams);
        }
        w = true;
    }

    public void a(View view)
    {
    }

    public boolean a()
    {
        if (d != null)
        {
            return d.e();
        } else
        {
            return false;
        }
    }

    public void b()
    {
        if (x == 2)
        {
            return;
        }
        if (l == null)
        {
            c();
            return;
        } else
        {
            f();
            x = 2;
            v = h();
            v.a();
            return;
        }
    }

    public void b(View view)
    {
        if (x == 2)
        {
            c();
        }
        x = 0;
    }

    public void c()
    {
        f();
        removeAllViews();
        if (e != null)
        {
            e.removeView(c);
        }
        m = null;
        c = null;
        w = false;
    }

    public void c(View view)
    {
    }

    public boolean d()
    {
        return t;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new android.view.ViewGroup.MarginLayoutParams(-1, -2);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new android.view.ViewGroup.MarginLayoutParams(getContext(), attributeset);
    }

    public volatile int getAnimatedVisibility()
    {
        return super.getAnimatedVisibility();
    }

    public volatile int getContentHeight()
    {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle()
    {
        return k;
    }

    public CharSequence getTitle()
    {
        return j;
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (d != null)
        {
            d.f();
            d.h();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
label0:
        {
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                if (accessibilityevent.getEventType() != 32)
                {
                    break label0;
                }
                accessibilityevent.setSource(this);
                accessibilityevent.setClassName(getClass().getName());
                accessibilityevent.setPackageName(getContext().getPackageName());
                accessibilityevent.setContentDescription(j);
            }
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityevent);
    }

    protected void onLayout(boolean flag, int i, int i1, int j1, int k1)
    {
        flag = android.support.v7.internal.widget.u.a(this);
        int l1;
        int i2;
        int j2;
        if (flag)
        {
            l1 = j1 - i - getPaddingRight();
        } else
        {
            l1 = getPaddingLeft();
        }
        i2 = getPaddingTop();
        j2 = k1 - i1 - getPaddingTop() - getPaddingBottom();
        i1 = l1;
        if (l != null)
        {
            i1 = l1;
            if (l.getVisibility() != 8)
            {
                Object obj = (android.view.ViewGroup.MarginLayoutParams)l.getLayoutParams();
                if (flag)
                {
                    i1 = ((android.view.ViewGroup.MarginLayoutParams) (obj)).rightMargin;
                } else
                {
                    i1 = ((android.view.ViewGroup.MarginLayoutParams) (obj)).leftMargin;
                }
                if (flag)
                {
                    k1 = ((android.view.ViewGroup.MarginLayoutParams) (obj)).leftMargin;
                } else
                {
                    k1 = ((android.view.ViewGroup.MarginLayoutParams) (obj)).rightMargin;
                }
                i1 = a(l1, i1, flag);
                k1 = a(a(l, i1, i2, j2, flag) + i1, k1, flag);
                i1 = k1;
                if (w)
                {
                    x = 1;
                    v = g();
                    v.a();
                    w = false;
                    i1 = k1;
                }
            }
        }
        k1 = i1;
        if (n != null)
        {
            k1 = i1;
            if (m == null)
            {
                k1 = i1;
                if (n.getVisibility() != 8)
                {
                    k1 = i1 + a(n, i1, i2, j2, flag);
                }
            }
        }
        if (m != null)
        {
            a(m, k1, i2, j2, flag);
        }
        if (flag)
        {
            i = getPaddingLeft();
        } else
        {
            i = j1 - i - getPaddingRight();
        }
        if (c != null)
        {
            obj = c;
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            a(((View) (obj)), i, i2, j2, flag);
        }
    }

    protected void onMeasure(int i, int i1)
    {
        int l1 = 0x40000000;
        boolean flag = false;
        if (android.view.View.MeasureSpec.getMode(i) != 0x40000000)
        {
            throw new IllegalStateException((new StringBuilder()).append(getClass().getSimpleName()).append(" can only be used ").append("with android:layout_width=\"match_parent\" (or fill_parent)").toString());
        }
        if (android.view.View.MeasureSpec.getMode(i1) == 0)
        {
            throw new IllegalStateException((new StringBuilder()).append(getClass().getSimpleName()).append(" can only be used ").append("with android:layout_height=\"wrap_content\"").toString());
        }
        int j2 = android.view.View.MeasureSpec.getSize(i);
        int j1;
        int k1;
        int i2;
        int k2;
        if (h > 0)
        {
            j1 = h;
        } else
        {
            j1 = android.view.View.MeasureSpec.getSize(i1);
        }
        k2 = getPaddingTop() + getPaddingBottom();
        i = j2 - getPaddingLeft() - getPaddingRight();
        i2 = j1 - k2;
        k1 = android.view.View.MeasureSpec.makeMeasureSpec(i2, 0x80000000);
        i1 = i;
        if (l != null)
        {
            i = a(l, i, k1, 0);
            android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)l.getLayoutParams();
            i1 = marginlayoutparams.leftMargin;
            i1 = i - (marginlayoutparams.rightMargin + i1);
        }
        i = i1;
        if (c != null)
        {
            i = i1;
            if (c.getParent() == this)
            {
                i = a(c, i1, k1, 0);
            }
        }
        i1 = i;
        if (n != null)
        {
            i1 = i;
            if (m == null)
            {
                if (t)
                {
                    i1 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
                    n.measure(i1, k1);
                    int l2 = n.getMeasuredWidth();
                    Object obj;
                    if (l2 <= i)
                    {
                        k1 = 1;
                    } else
                    {
                        k1 = 0;
                    }
                    i1 = i;
                    if (k1 != 0)
                    {
                        i1 = i - l2;
                    }
                    obj = n;
                    if (k1 != 0)
                    {
                        i = 0;
                    } else
                    {
                        i = 8;
                    }
                    ((LinearLayout) (obj)).setVisibility(i);
                } else
                {
                    i1 = a(n, i, k1, 0);
                }
            }
        }
        if (m != null)
        {
            obj = m.getLayoutParams();
            if (((android.view.ViewGroup.LayoutParams) (obj)).width != -2)
            {
                i = 0x40000000;
            } else
            {
                i = 0x80000000;
            }
            k1 = i1;
            if (((android.view.ViewGroup.LayoutParams) (obj)).width >= 0)
            {
                k1 = Math.min(((android.view.ViewGroup.LayoutParams) (obj)).width, i1);
            }
            if (((android.view.ViewGroup.LayoutParams) (obj)).height != -2)
            {
                i1 = l1;
            } else
            {
                i1 = 0x80000000;
            }
            if (((android.view.ViewGroup.LayoutParams) (obj)).height >= 0)
            {
                l1 = Math.min(((android.view.ViewGroup.LayoutParams) (obj)).height, i2);
            } else
            {
                l1 = i2;
            }
            m.measure(android.view.View.MeasureSpec.makeMeasureSpec(k1, i), android.view.View.MeasureSpec.makeMeasureSpec(l1, i1));
        }
        if (h <= 0)
        {
            k1 = getChildCount();
            i = 0;
            for (i1 = ((flag) ? 1 : 0); i1 < k1; i1++)
            {
                j1 = getChildAt(i1).getMeasuredHeight() + k2;
                if (j1 > i)
                {
                    i = j1;
                }
            }

            setMeasuredDimension(j2, i);
            return;
        } else
        {
            setMeasuredDimension(j2, j1);
            return;
        }
    }

    public void setContentHeight(int i)
    {
        h = i;
    }

    public void setCustomView(View view)
    {
        if (m != null)
        {
            removeView(m);
        }
        m = view;
        if (n != null)
        {
            removeView(n);
            n = null;
        }
        if (view != null)
        {
            addView(view);
        }
        requestLayout();
    }

    public void setSplitToolbar(boolean flag)
    {
        if (f != flag)
        {
            if (d != null)
            {
                android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(-2, -1);
                if (!flag)
                {
                    c = (ActionMenuView)d.a(this);
                    c.setBackgroundDrawable(null);
                    ViewGroup viewgroup = (ViewGroup)c.getParent();
                    if (viewgroup != null)
                    {
                        viewgroup.removeView(c);
                    }
                    addView(c, layoutparams);
                } else
                {
                    d.a(getContext().getResources().getDisplayMetrics().widthPixels, true);
                    d.b(0x7fffffff);
                    layoutparams.width = -1;
                    layoutparams.height = h;
                    c = (ActionMenuView)d.a(this);
                    c.setBackgroundDrawable(s);
                    ViewGroup viewgroup1 = (ViewGroup)c.getParent();
                    if (viewgroup1 != null)
                    {
                        viewgroup1.removeView(c);
                    }
                    e.addView(c, layoutparams);
                }
            }
            super.setSplitToolbar(flag);
        }
    }

    public volatile void setSplitView(ViewGroup viewgroup)
    {
        super.setSplitView(viewgroup);
    }

    public volatile void setSplitWhenNarrow(boolean flag)
    {
        super.setSplitWhenNarrow(flag);
    }

    public void setSubtitle(CharSequence charsequence)
    {
        k = charsequence;
        e();
    }

    public void setTitle(CharSequence charsequence)
    {
        j = charsequence;
        e();
    }

    public void setTitleOptional(boolean flag)
    {
        if (flag != t)
        {
            requestLayout();
        }
        t = flag;
    }

    public boolean shouldDelayChildPressedState()
    {
        return false;
    }
}
