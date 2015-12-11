// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ah;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;

// Referenced classes of package android.support.v7.app:
//            m, b

public class android.support.v7.app.a
    implements android.support.v4.widget.DrawerLayout.f
{
    public static interface a
    {

        public abstract Drawable a();

        public abstract void a(int k);

        public abstract void a(Drawable drawable, int k);

        public abstract Context b();

        public abstract boolean c();
    }

    public static interface b
    {

        public abstract a b();
    }

    static class c extends m
        implements d
    {

        private final Activity a;

        public void a(float f1)
        {
            if (f1 != 1.0F) goto _L2; else goto _L1
_L1:
            a(true);
_L4:
            super.b(f1);
            return;
_L2:
            if (f1 == 0.0F)
            {
                a(false);
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        boolean a()
        {
            return ah.g(a.getWindow().getDecorView()) == 1;
        }

        public c(Activity activity, Context context)
        {
            super(context);
            a = activity;
        }
    }

    static interface d
    {

        public abstract void a(float f1);
    }

    static class e
        implements a
    {

        final Activity a;

        public Drawable a()
        {
            return null;
        }

        public void a(int k)
        {
        }

        public void a(Drawable drawable, int k)
        {
        }

        public Context b()
        {
            return a;
        }

        public boolean c()
        {
            return true;
        }

        e(Activity activity)
        {
            a = activity;
        }
    }

    private static class f
        implements a
    {

        final Activity a;
        b.a b;

        public Drawable a()
        {
            return android.support.v7.app.b.a(a);
        }

        public void a(int k)
        {
            b = android.support.v7.app.b.a(b, a, k);
        }

        public void a(Drawable drawable, int k)
        {
            a.getActionBar().setDisplayShowHomeEnabled(true);
            b = android.support.v7.app.b.a(b, a, drawable, k);
            a.getActionBar().setDisplayShowHomeEnabled(false);
        }

        public Context b()
        {
            ActionBar actionbar = a.getActionBar();
            if (actionbar != null)
            {
                return actionbar.getThemedContext();
            } else
            {
                return a;
            }
        }

        public boolean c()
        {
            ActionBar actionbar = a.getActionBar();
            return actionbar != null && (actionbar.getDisplayOptions() & 4) != 0;
        }

        private f(Activity activity)
        {
            a = activity;
        }

    }

    private static class g
        implements a
    {

        final Activity a;

        public Drawable a()
        {
            TypedArray typedarray = b().obtainStyledAttributes(null, new int[] {
                0x101030b
            }, 0x10102ce, 0);
            Drawable drawable = typedarray.getDrawable(0);
            typedarray.recycle();
            return drawable;
        }

        public void a(int k)
        {
            ActionBar actionbar = a.getActionBar();
            if (actionbar != null)
            {
                actionbar.setHomeActionContentDescription(k);
            }
        }

        public void a(Drawable drawable, int k)
        {
            ActionBar actionbar = a.getActionBar();
            if (actionbar != null)
            {
                actionbar.setHomeAsUpIndicator(drawable);
                actionbar.setHomeActionContentDescription(k);
            }
        }

        public Context b()
        {
            ActionBar actionbar = a.getActionBar();
            if (actionbar != null)
            {
                return actionbar.getThemedContext();
            } else
            {
                return a;
            }
        }

        public boolean c()
        {
            ActionBar actionbar = a.getActionBar();
            return actionbar != null && (actionbar.getDisplayOptions() & 4) != 0;
        }

        private g(Activity activity)
        {
            a = activity;
        }

    }

    static class h
        implements a
    {

        final Toolbar a;
        final Drawable b;
        final CharSequence c;

        public Drawable a()
        {
            return b;
        }

        public void a(int k)
        {
            if (k == 0)
            {
                a.setNavigationContentDescription(c);
                return;
            } else
            {
                a.setNavigationContentDescription(k);
                return;
            }
        }

        public void a(Drawable drawable, int k)
        {
            a.setNavigationIcon(drawable);
            a(k);
        }

        public Context b()
        {
            return a.getContext();
        }

        public boolean c()
        {
            return true;
        }

        h(Toolbar toolbar)
        {
            a = toolbar;
            b = toolbar.getNavigationIcon();
            c = toolbar.getNavigationContentDescription();
        }
    }


    private final a a;
    private final DrawerLayout b;
    private d c;
    private Drawable d;
    private boolean e;
    private boolean f;
    private final int g;
    private final int h;
    private android.view.View.OnClickListener i;
    private boolean j;

    public android.support.v7.app.a(Activity activity, DrawerLayout drawerlayout, Toolbar toolbar, int k, int l)
    {
        this(activity, toolbar, drawerlayout, null, k, l);
    }

    android.support.v7.app.a(Activity activity, Toolbar toolbar, DrawerLayout drawerlayout, Drawable drawable, int k, int l)
    {
        e = true;
        j = false;
        if (toolbar != null)
        {
            a = new h(toolbar);
            toolbar.setNavigationOnClickListener(new android.view.View.OnClickListener() {

                final android.support.v7.app.a a;

                public void onClick(View view)
                {
                    if (android.support.v7.app.a.a(a))
                    {
                        android.support.v7.app.a.b(a);
                    } else
                    if (android.support.v7.app.a.c(a) != null)
                    {
                        android.support.v7.app.a.c(a).onClick(view);
                        return;
                    }
                }

            
            {
                a = android.support.v7.app.a.this;
                super();
            }
            });
        } else
        if (activity instanceof b)
        {
            a = ((b)activity).b();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 18)
        {
            a = new g(activity);
        } else
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            a = new f(activity);
        } else
        {
            a = new e(activity);
        }
        b = drawerlayout;
        g = k;
        h = l;
        if (drawable == null)
        {
            c = new c(activity, a.b());
        } else
        {
            c = (d)drawable;
        }
        d = c();
    }

    static boolean a(android.support.v7.app.a a1)
    {
        return a1.e;
    }

    static void b(android.support.v7.app.a a1)
    {
        a1.d();
    }

    static android.view.View.OnClickListener c(android.support.v7.app.a a1)
    {
        return a1.i;
    }

    private void d()
    {
        if (b.g(0x800003))
        {
            b.e(0x800003);
            return;
        } else
        {
            b.d(0x800003);
            return;
        }
    }

    public void a()
    {
        if (b.f(0x800003))
        {
            c.a(1.0F);
        } else
        {
            c.a(0.0F);
        }
        if (e)
        {
            Drawable drawable = (Drawable)c;
            int k;
            if (b.f(0x800003))
            {
                k = h;
            } else
            {
                k = g;
            }
            a(drawable, k);
        }
    }

    public void a(int k)
    {
    }

    public void a(Configuration configuration)
    {
        if (!f)
        {
            d = c();
        }
        a();
    }

    public void a(Drawable drawable)
    {
        if (drawable == null)
        {
            d = c();
            f = false;
        } else
        {
            d = drawable;
            f = true;
        }
        if (!e)
        {
            a(d, 0);
        }
    }

    void a(Drawable drawable, int k)
    {
        if (!j && !a.c())
        {
            Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
            j = true;
        }
        a.a(drawable, k);
    }

    public void a(android.view.View.OnClickListener onclicklistener)
    {
        i = onclicklistener;
    }

    public void a(View view)
    {
        c.a(1.0F);
        if (e)
        {
            c(h);
        }
    }

    public void a(View view, float f1)
    {
        c.a(Math.min(1.0F, Math.max(0.0F, f1)));
    }

    public void a(boolean flag)
    {
        if (flag != e)
        {
            if (flag)
            {
                Drawable drawable = (Drawable)c;
                int k;
                if (b.f(0x800003))
                {
                    k = h;
                } else
                {
                    k = g;
                }
                a(drawable, k);
            } else
            {
                a(d, 0);
            }
            e = flag;
        }
    }

    public android.view.View.OnClickListener b()
    {
        return i;
    }

    public void b(int k)
    {
        Drawable drawable = null;
        if (k != 0)
        {
            drawable = b.getResources().getDrawable(k);
        }
        a(drawable);
    }

    public void b(View view)
    {
        c.a(0.0F);
        if (e)
        {
            c(g);
        }
    }

    Drawable c()
    {
        return a.a();
    }

    void c(int k)
    {
        a.a(k);
    }
}
