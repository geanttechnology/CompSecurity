// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.view.ai;
import android.support.v4.view.ba;
import android.support.v4.view.be;
import android.support.v7.internal.view.f;
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
        implements be
    {

        int a;
        final android.support.v7.internal.widget.a b;
        private boolean c;

        public a a(ba ba1, int k)
        {
            b.i = ba1;
            a = k;
            return this;
        }

        public void a(View view)
        {
            b.setVisibility(0);
            c = false;
        }

        public void b(View view)
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

        public void c(View view)
        {
            c = true;
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
    protected ba i;

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
        if (context.getTheme().resolveAttribute(android.support.v7.a.a.actionBarPopupTheme, attributeset, true) && ((TypedValue) (attributeset)).resourceId != 0)
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
                ai.c(this, 0.0F);
                if (e != null && c != null)
                {
                    ai.c(c, 0.0F);
                }
            }
            ba ba1 = ai.s(this).a(1.0F);
            ba1.a(200L);
            ba1.a(j);
            if (e != null && c != null)
            {
                f f1 = new f();
                ba ba3 = ai.s(c).a(1.0F);
                ba3.a(200L);
                f1.a(a.a(ba1, k));
                f1.a(ba1).a(ba3);
                f1.a();
                return;
            } else
            {
                ba1.a(a.a(ba1, k));
                ba1.b();
                return;
            }
        }
        ba ba2 = ai.s(this).a(0.0F);
        ba2.a(200L);
        ba2.a(j);
        if (e != null && c != null)
        {
            f f2 = new f();
            ba ba4 = ai.s(c).a(0.0F);
            ba4.a(200L);
            f2.a(a.a(ba2, k));
            f2.a(ba2).a(ba4);
            f2.a();
            return;
        } else
        {
            ba2.a(a.a(ba2, k));
            ba2.b();
            return;
        }
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
        TypedArray typedarray = getContext().obtainStyledAttributes(null, android.support.v7.a.k.ActionBar, android.support.v7.a.a.actionBarStyle, 0);
        setContentHeight(typedarray.getLayoutDimension(android.support.v7.a.k.ActionBar_height, 0));
        typedarray.recycle();
        if (d != null)
        {
            d.a(configuration);
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
