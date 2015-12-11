// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.view.ah;
import android.support.v4.view.ay;
import android.support.v4.view.bc;
import android.support.v7.cf;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ActionMenuView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

abstract class android.support.v7.internal.widget.a extends ViewGroup
{
    protected class a
        implements bc
    {

        int a;
        final android.support.v7.internal.widget.a b;
        private boolean c;

        public a a(ay ay1, int k)
        {
            b.i = ay1;
            a = k;
            return this;
        }

        public void onAnimationCancel(View view)
        {
            c = true;
        }

        public void onAnimationEnd(View view)
        {
            if (!c)
            {
                b.i = null;
                b.setVisibility(a);
                if (b.e != null && b.c != null)
                {
                    b.c.setVisibility(a);
                    return;
                }
            }
        }

        public void onAnimationStart(View view)
        {
            b.setVisibility(0);
            c = false;
        }

        protected a()
        {
            b = android.support.v7.internal.widget.a.this;
            super();
            c = false;
        }
    }


    private static final Interpolator j = new DecelerateInterpolator();
    protected final a a;
    protected final Context b;
    protected ActionMenuView c;
    protected ActionMenuPresenter d;
    protected ViewGroup e;
    protected boolean f;
    protected boolean g;
    protected int h;
    protected ay i;

    android.support.v7.internal.widget.a(Context context)
    {
        this(context, null);
    }

    android.support.v7.internal.widget.a(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    android.support.v7.internal.widget.a(Context context, AttributeSet attributeset, int k)
    {
        super(context, attributeset, k);
        a = new a();
        attributeset = new TypedValue();
        if (context.getTheme().resolveAttribute(android.support.v7.br.a.actionBarPopupTheme, attributeset, true) && ((TypedValue) (attributeset)).resourceId != 0)
        {
            b = new ContextThemeWrapper(context, ((TypedValue) (attributeset)).resourceId);
            return;
        } else
        {
            b = context;
            return;
        }
    }

    protected static int a(int k, int l, boolean flag)
    {
        if (flag)
        {
            return k - l;
        } else
        {
            return k + l;
        }
    }

    protected int a(View view, int k, int l, int i1)
    {
        view.measure(android.view.View.MeasureSpec.makeMeasureSpec(k, 0x80000000), l);
        return Math.max(0, k - view.getMeasuredWidth() - i1);
    }

    protected int a(View view, int k, int l, int i1, boolean flag)
    {
        int j1 = view.getMeasuredWidth();
        int k1 = view.getMeasuredHeight();
        l = (i1 - k1) / 2 + l;
        if (flag)
        {
            view.layout(k - j1, l, k, k1 + l);
        } else
        {
            view.layout(k, l, k + j1, k1 + l);
        }
        k = j1;
        if (flag)
        {
            k = -j1;
        }
        return k;
    }

    public void a(int k)
    {
        if (i != null)
        {
            i.a();
        }
        if (k == 0)
        {
            if (getVisibility() != 0)
            {
                ah.c(this, 0.0F);
                if (e != null && c != null)
                {
                    ah.c(c, 0.0F);
                }
            }
            ay ay1 = ah.q(this).a(1.0F);
            ay1.a(200L);
            ay1.a(j);
            if (e != null && c != null)
            {
                cf cf1 = new cf();
                ay ay3 = ah.q(c).a(1.0F);
                ay3.a(200L);
                cf1.a(a.a(ay1, k));
                cf1.a(ay1).a(ay3);
                cf1.a();
                return;
            } else
            {
                ay1.a(a.a(ay1, k));
                ay1.b();
                return;
            }
        }
        ay ay2 = ah.q(this).a(0.0F);
        ay2.a(200L);
        ay2.a(j);
        if (e != null && c != null)
        {
            cf cf2 = new cf();
            ay ay4 = ah.q(c).a(0.0F);
            ay4.a(200L);
            cf2.a(a.a(ay2, k));
            cf2.a(ay2).a(ay4);
            cf2.a();
            return;
        } else
        {
            ay2.a(a.a(ay2, k));
            ay2.b();
            return;
        }
    }

    public boolean a()
    {
        if (d != null)
        {
            return d.showOverflowMenu();
        } else
        {
            return false;
        }
    }

    public int getAnimatedVisibility()
    {
        if (i != null)
        {
            return a.a;
        } else
        {
            return getVisibility();
        }
    }

    public int getContentHeight()
    {
        return h;
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            super.onConfigurationChanged(configuration);
        }
        TypedArray typedarray = getContext().obtainStyledAttributes(null, android.support.v7.br.k.ActionBar, android.support.v7.br.a.actionBarStyle, 0);
        setContentHeight(typedarray.getLayoutDimension(android.support.v7.br.k.ActionBar_height, 0));
        typedarray.recycle();
        if (d != null)
        {
            d.onConfigurationChanged(configuration);
        }
    }

    public void setContentHeight(int k)
    {
        h = k;
        requestLayout();
    }

    public void setSplitToolbar(boolean flag)
    {
        f = flag;
    }

    public void setSplitView(ViewGroup viewgroup)
    {
        e = viewgroup;
    }

    public void setSplitWhenNarrow(boolean flag)
    {
        g = flag;
    }

}
