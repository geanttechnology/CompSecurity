// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ad;
import android.support.v4.view.ah;
import android.support.v4.view.w;
import android.support.v7.e.a;
import android.support.v7.internal.view.menu.f;
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
import java.lang.ref.WeakReference;

// Referenced classes of package android.support.v7.internal.widget:
//            a, r, t

public class ActionBarContextView extends android.support.v7.internal.widget.a
    implements ah
{

    public View j;
    public boolean k;
    public android.support.v7.internal.view.f l;
    public int m;
    private CharSequence n;
    private CharSequence o;
    private View p;
    private LinearLayout q;
    private TextView r;
    private TextView s;
    private int t;
    private int u;
    private Drawable v;
    private int w;
    private boolean x;

    public ActionBarContextView(Context context)
    {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, android.support.v7.b.a.a.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        context = android.support.v7.internal.widget.r.a(context, attributeset, android.support.v7.b.a.k.ActionMode, i);
        setBackgroundDrawable(context.a(android.support.v7.b.a.k.ActionMode_background));
        t = context.e(android.support.v7.b.a.k.ActionMode_titleTextStyle, 0);
        u = context.e(android.support.v7.b.a.k.ActionMode_subtitleTextStyle, 0);
        h = context.d(android.support.v7.b.a.k.ActionMode_height, 0);
        v = context.a(android.support.v7.b.a.k.ActionMode_backgroundSplit);
        w = context.e(android.support.v7.b.a.k.ActionMode_closeItemLayout, android.support.v7.b.a.h.abc_action_mode_close_item_material);
        ((r) (context)).a.recycle();
    }

    private void e()
    {
label0:
        {
            byte byte1 = 8;
            boolean flag = true;
            if (q == null)
            {
                LayoutInflater.from(getContext()).inflate(android.support.v7.b.a.h.abc_action_bar_title_item, this);
                q = (LinearLayout)getChildAt(getChildCount() - 1);
                r = (TextView)q.findViewById(android.support.v7.b.a.f.action_bar_title);
                s = (TextView)q.findViewById(android.support.v7.b.a.f.action_bar_subtitle);
                if (t != 0)
                {
                    r.setTextAppearance(getContext(), t);
                }
                if (u != 0)
                {
                    s.setTextAppearance(getContext(), u);
                }
            }
            r.setText(n);
            s.setText(o);
            Object obj;
            byte byte0;
            int i;
            if (!TextUtils.isEmpty(n))
            {
                byte0 = 1;
            } else
            {
                byte0 = 0;
            }
            if (TextUtils.isEmpty(o))
            {
                flag = false;
            }
            obj = s;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            ((TextView) (obj)).setVisibility(i);
            obj = q;
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
        if (q.getParent() == null)
        {
            addView(q);
        }
    }

    public final volatile void a(int i)
    {
        super.a(i);
    }

    public final void a(a a1)
    {
        android.view.ViewGroup.LayoutParams layoutparams;
        if (j == null)
        {
            j = LayoutInflater.from(getContext()).inflate(w, this, false);
            addView(j);
        } else
        if (j.getParent() == null)
        {
            addView(j);
        }
        j.findViewById(android.support.v7.b.a.f.action_mode_close_button).setOnClickListener(new android.view.View.OnClickListener(a1) {

            final a a;
            final ActionBarContextView b;

            public final void onClick(View view)
            {
                a.c();
            }

            
            {
                b = ActionBarContextView.this;
                a = a1;
                super();
            }
        });
        a1 = (f)a1.b();
        if (d != null)
        {
            d.f();
        }
        d = new android.support.v7.widget.a(getContext());
        d.b();
        layoutparams = new android.view.ViewGroup.LayoutParams(-2, -1);
        if (!f)
        {
            a1.a(d, b);
            c = (ActionMenuView)d.a(this);
            c.setBackgroundDrawable(null);
            addView(c, layoutparams);
        } else
        {
            d.a(getContext().getResources().getDisplayMetrics().widthPixels);
            d.c();
            layoutparams.width = -1;
            layoutparams.height = h;
            a1.a(d, b);
            c = (ActionMenuView)d.a(this);
            c.setBackgroundDrawable(v);
            e.addView(c, layoutparams);
        }
        x = true;
    }

    public final void a(View view)
    {
    }

    public final boolean a()
    {
        if (d != null)
        {
            return d.d();
        } else
        {
            return false;
        }
    }

    public final void b()
    {
        android.support.v7.internal.view.f f1 = l;
        if (f1 != null)
        {
            l = null;
            f1.b();
        }
    }

    public final void b(View view)
    {
        if (m == 2)
        {
            c();
        }
        m = 0;
    }

    public final void c()
    {
        b();
        removeAllViews();
        if (e != null)
        {
            e.removeView(c);
        }
        p = null;
        c = null;
        x = false;
    }

    public final void c(View view)
    {
    }

    public final android.support.v7.internal.view.f d()
    {
        ad ad1 = android.support.v4.view.w.n(j).b(-j.getWidth() - ((android.view.ViewGroup.MarginLayoutParams)j.getLayoutParams()).leftMargin);
        ad1.a(200L);
        ad1.a(this);
        ad1.a(new DecelerateInterpolator());
        android.support.v7.internal.view.f f1 = new android.support.v7.internal.view.f();
        f1.a(ad1);
        if (c != null)
        {
            c.getChildCount();
        }
        return f1;
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
        return o;
    }

    public CharSequence getTitle()
    {
        return n;
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (d != null)
        {
            d.e();
            d.g();
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
                accessibilityevent.setContentDescription(n);
            }
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityevent);
    }

    protected void onLayout(boolean flag, int i, int i1, int j1, int k1)
    {
        flag = android.support.v7.internal.widget.t.a(this);
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
        if (j != null)
        {
            i1 = l1;
            if (j.getVisibility() != 8)
            {
                Object obj = (android.view.ViewGroup.MarginLayoutParams)j.getLayoutParams();
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
                k1 = a(i1 + a(j, i1, i2, j2, flag), k1, flag);
                i1 = k1;
                if (x)
                {
                    m = 1;
                    android.support.v4.view.w.a(j, -j.getWidth() - ((android.view.ViewGroup.MarginLayoutParams)j.getLayoutParams()).leftMargin);
                    ad ad1 = android.support.v4.view.w.n(j).b(0.0F);
                    ad1.a(200L);
                    ad1.a(this);
                    ad1.a(new DecelerateInterpolator());
                    obj = new android.support.v7.internal.view.f();
                    ((android.support.v7.internal.view.f) (obj)).a(ad1);
                    if (c != null)
                    {
                        i1 = c.getChildCount();
                        if (i1 > 0)
                        {
                            for (i1--; i1 >= 0; i1--)
                            {
                                Object obj1 = c.getChildAt(i1);
                                android.support.v4.view.w.e(((View) (obj1)), 0.0F);
                                obj1 = android.support.v4.view.w.n(((View) (obj1)));
                                View view = (View)((ad) (obj1)).a.get();
                                if (view != null)
                                {
                                    ad.b.a(((ad) (obj1)), view);
                                }
                                ((ad) (obj1)).a(300L);
                                ((android.support.v7.internal.view.f) (obj)).a(((ad) (obj1)));
                            }

                        }
                    }
                    l = ((android.support.v7.internal.view.f) (obj));
                    l.a();
                    x = false;
                    i1 = k1;
                }
            }
        }
        k1 = i1;
        if (q != null)
        {
            k1 = i1;
            if (p == null)
            {
                k1 = i1;
                if (q.getVisibility() != 8)
                {
                    k1 = i1 + a(q, i1, i2, j2, flag);
                }
            }
        }
        if (p != null)
        {
            a(p, k1, i2, j2, flag);
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
            ActionMenuView actionmenuview = c;
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            a(actionmenuview, i, i2, j2, flag);
        }
    }

    protected void onMeasure(int i, int i1)
    {
        int l1 = 0x40000000;
        boolean flag = false;
        if (android.view.View.MeasureSpec.getMode(i) != 0x40000000)
        {
            throw new IllegalStateException((new StringBuilder()).append(getClass().getSimpleName()).append(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)").toString());
        }
        if (android.view.View.MeasureSpec.getMode(i1) == 0)
        {
            throw new IllegalStateException((new StringBuilder()).append(getClass().getSimpleName()).append(" can only be used with android:layout_height=\"wrap_content\"").toString());
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
        if (j != null)
        {
            i = a(j, i, k1);
            android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)j.getLayoutParams();
            i1 = marginlayoutparams.leftMargin;
            i1 = i - (marginlayoutparams.rightMargin + i1);
        }
        i = i1;
        if (c != null)
        {
            i = i1;
            if (c.getParent() == this)
            {
                i = a(c, i1, k1);
            }
        }
        i1 = i;
        if (q != null)
        {
            i1 = i;
            if (p == null)
            {
                if (k)
                {
                    i1 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
                    q.measure(i1, k1);
                    int l2 = q.getMeasuredWidth();
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
                    obj = q;
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
                    i1 = a(q, i, k1);
                }
            }
        }
        if (p != null)
        {
            obj = p.getLayoutParams();
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
            p.measure(android.view.View.MeasureSpec.makeMeasureSpec(k1, i), android.view.View.MeasureSpec.makeMeasureSpec(l1, i1));
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
        if (p != null)
        {
            removeView(p);
        }
        p = view;
        if (q != null)
        {
            removeView(q);
            q = null;
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
                    d.a(getContext().getResources().getDisplayMetrics().widthPixels);
                    d.c();
                    layoutparams.width = -1;
                    layoutparams.height = h;
                    c = (ActionMenuView)d.a(this);
                    c.setBackgroundDrawable(v);
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
        o = charsequence;
        e();
    }

    public void setTitle(CharSequence charsequence)
    {
        n = charsequence;
        e();
    }

    public void setTitleOptional(boolean flag)
    {
        if (flag != k)
        {
            requestLayout();
        }
        k = flag;
    }

    public boolean shouldDelayChildPressedState()
    {
        return false;
    }
}
