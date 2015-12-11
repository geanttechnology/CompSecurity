// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ai;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

// Referenced classes of package android.support.v7.app:
//            m, c

public class android.support.v7.app.b
    implements android.support.v4.widget.DrawerLayout.f
{
    public static interface a
    {

        public abstract Drawable a();

        public abstract void a(int i);

        public abstract void a(Drawable drawable, int i);

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
            return ai.h(a.getWindow().getDecorView()) == 1;
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

        public void a(int i)
        {
        }

        public void a(Drawable drawable, int i)
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
        c.a b;

        public Drawable a()
        {
            return android.support.v7.app.c.a(a);
        }

        public void a(int i)
        {
            b = android.support.v7.app.c.a(b, a, i);
        }

        public void a(Drawable drawable, int i)
        {
            a.getActionBar().setDisplayShowHomeEnabled(true);
            b = android.support.v7.app.c.a(b, a, drawable, i);
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

        public void a(int i)
        {
            ActionBar actionbar = a.getActionBar();
            if (actionbar != null)
            {
                actionbar.setHomeActionContentDescription(i);
            }
        }

        public void a(Drawable drawable, int i)
        {
            ActionBar actionbar = a.getActionBar();
            if (actionbar != null)
            {
                actionbar.setHomeAsUpIndicator(drawable);
                actionbar.setHomeActionContentDescription(i);
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

        public void a(int i)
        {
            if (i == 0)
            {
                a.setNavigationContentDescription(c);
                return;
            } else
            {
                a.setNavigationContentDescription(i);
                return;
            }
        }

        public void a(Drawable drawable, int i)
        {
            a.setNavigationIcon(drawable);
            a(i);
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


    private final a mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    private boolean mDrawerIndicatorEnabled;
    private final DrawerLayout mDrawerLayout;
    private boolean mHasCustomUpIndicator;
    private Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private d mSlider;
    private android.view.View.OnClickListener mToolbarNavigationClickListener;
    private boolean mWarnedForDisplayHomeAsUp;

    public android.support.v7.app.b(Activity activity, DrawerLayout drawerlayout, int i, int j)
    {
        this(activity, null, drawerlayout, null, i, j);
    }

    android.support.v7.app.b(Activity activity, Toolbar toolbar, DrawerLayout drawerlayout, Drawable drawable, int i, int j)
    {
        mDrawerIndicatorEnabled = true;
        mWarnedForDisplayHomeAsUp = false;
        if (toolbar != null)
        {
            mActivityImpl = new h(toolbar);
            toolbar.setNavigationOnClickListener(new android.view.View.OnClickListener() {

                final android.support.v7.app.b a;

                public void onClick(View view)
                {
                    if (android.support.v7.app.b.a(a))
                    {
                        android.support.v7.app.b.b(a);
                    } else
                    if (android.support.v7.app.b.c(a) != null)
                    {
                        android.support.v7.app.b.c(a).onClick(view);
                        return;
                    }
                }

            
            {
                a = android.support.v7.app.b.this;
                super();
            }
            });
        } else
        if (activity instanceof b)
        {
            mActivityImpl = ((b)activity).b();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 18)
        {
            mActivityImpl = new g(activity);
        } else
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            mActivityImpl = new f(activity);
        } else
        {
            mActivityImpl = new e(activity);
        }
        mDrawerLayout = drawerlayout;
        mOpenDrawerContentDescRes = i;
        mCloseDrawerContentDescRes = j;
        if (drawable == null)
        {
            mSlider = new c(activity, mActivityImpl.b());
        } else
        {
            mSlider = (d)drawable;
        }
        mHomeAsUpIndicator = b();
    }

    static boolean a(android.support.v7.app.b b1)
    {
        return b1.mDrawerIndicatorEnabled;
    }

    static void b(android.support.v7.app.b b1)
    {
        b1.c();
    }

    static android.view.View.OnClickListener c(android.support.v7.app.b b1)
    {
        return b1.mToolbarNavigationClickListener;
    }

    private void c()
    {
        if (mDrawerLayout.g(0x800003))
        {
            mDrawerLayout.e(0x800003);
            return;
        } else
        {
            mDrawerLayout.d(0x800003);
            return;
        }
    }

    public void a()
    {
        if (mDrawerLayout.f(0x800003))
        {
            mSlider.a(1.0F);
        } else
        {
            mSlider.a(0.0F);
        }
        if (mDrawerIndicatorEnabled)
        {
            Drawable drawable = (Drawable)mSlider;
            int i;
            if (mDrawerLayout.f(0x800003))
            {
                i = mCloseDrawerContentDescRes;
            } else
            {
                i = mOpenDrawerContentDescRes;
            }
            a(drawable, i);
        }
    }

    public void a(int i)
    {
    }

    public void a(Configuration configuration)
    {
        if (!mHasCustomUpIndicator)
        {
            mHomeAsUpIndicator = b();
        }
        a();
    }

    void a(Drawable drawable, int i)
    {
        if (!mWarnedForDisplayHomeAsUp && !mActivityImpl.c())
        {
            Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
            mWarnedForDisplayHomeAsUp = true;
        }
        mActivityImpl.a(drawable, i);
    }

    public void a(View view)
    {
        mSlider.a(1.0F);
        if (mDrawerIndicatorEnabled)
        {
            b(mCloseDrawerContentDescRes);
        }
    }

    public void a(View view, float f1)
    {
        mSlider.a(Math.min(1.0F, Math.max(0.0F, f1)));
    }

    public void a(boolean flag)
    {
        if (flag != mDrawerIndicatorEnabled)
        {
            if (flag)
            {
                Drawable drawable = (Drawable)mSlider;
                int i;
                if (mDrawerLayout.f(0x800003))
                {
                    i = mCloseDrawerContentDescRes;
                } else
                {
                    i = mOpenDrawerContentDescRes;
                }
                a(drawable, i);
            } else
            {
                a(mHomeAsUpIndicator, 0);
            }
            mDrawerIndicatorEnabled = flag;
        }
    }

    public boolean a(MenuItem menuitem)
    {
        if (menuitem != null && menuitem.getItemId() == 0x102002c && mDrawerIndicatorEnabled)
        {
            c();
            return true;
        } else
        {
            return false;
        }
    }

    Drawable b()
    {
        return mActivityImpl.a();
    }

    void b(int i)
    {
        mActivityImpl.a(i);
    }

    public void b(View view)
    {
        mSlider.a(0.0F);
        if (mDrawerIndicatorEnabled)
        {
            b(mOpenDrawerContentDescRes);
        }
    }
}
