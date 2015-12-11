// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.view.ad;
import android.support.v4.view.ah;
import android.support.v4.view.w;
import android.support.v7.internal.view.f;
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
    protected final class a
        implements ah
    {

        int a;
        final android.support.v7.internal.widget.a b;
        private boolean c;

        public final a a(ad ad1, int k)
        {
            b.i = ad1;
            a = k;
            return this;
        }

        public final void a(View view)
        {
            b.setVisibility(0);
            c = false;
        }

        public final void b(View view)
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

        public final void c(View view)
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
    protected android.support.v7.widget.a d;
    protected ViewGroup e;
    protected boolean f;
    protected boolean g;
    protected int h;
    protected ad i;

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
        if (context.getTheme().resolveAttribute(android.support.v7.b.a.actionBarPopupTheme, attributeset, true) && ((TypedValue) (attributeset)).resourceId != 0)
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

    protected static int a(View view, int k, int l)
    {
        view.measure(android.view.View.MeasureSpec.makeMeasureSpec(k, 0x80000000), l);
        return Math.max(0, (k - view.getMeasuredWidth()) + 0);
    }

    protected static int a(View view, int k, int l, int i1, boolean flag)
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
                w.c(this, 0.0F);
                if (e != null && c != null)
                {
                    w.c(c, 0.0F);
                }
            }
            ad ad1 = w.n(this).a(1.0F);
            ad1.a(200L);
            ad1.a(j);
            if (e != null && c != null)
            {
                f f1 = new f();
                ad ad3 = w.n(c).a(1.0F);
                ad3.a(200L);
                f1.a(a.a(ad1, k));
                f1.a(ad1).a(ad3);
                f1.a();
                return;
            } else
            {
                ad1.a(a.a(ad1, k));
                ad1.b();
                return;
            }
        }
        ad ad2 = w.n(this).a(0.0F);
        ad2.a(200L);
        ad2.a(j);
        if (e != null && c != null)
        {
            f f2 = new f();
            ad ad4 = w.n(c).a(0.0F);
            ad4.a(200L);
            f2.a(a.a(ad2, k));
            f2.a(ad2).a(ad4);
            f2.a();
            return;
        } else
        {
            ad2.a(a.a(ad2, k));
            ad2.b();
            return;
        }
    }

    public boolean a()
    {
        if (d != null)
        {
            return d.d();
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
        configuration = getContext().obtainStyledAttributes(null, android.support.v7.b.k.ActionBar, android.support.v7.b.a.actionBarStyle, 0);
        setContentHeight(configuration.getLayoutDimension(android.support.v7.b.k.ActionBar_height, 0));
        configuration.recycle();
        if (d != null)
        {
            configuration = d;
            if (!((android.support.v7.widget.a) (configuration)).k)
            {
                configuration.j = ((android.support.v7.widget.a) (configuration)).b.getResources().getInteger(android.support.v7.b.g.abc_max_action_buttons);
            }
            if (((android.support.v7.widget.a) (configuration)).c != null)
            {
                ((android.support.v7.widget.a) (configuration)).c.b(true);
            }
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
