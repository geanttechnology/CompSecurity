// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.f.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Method;

public final class com.f.a.a
{
    public static final class a
    {

        public final int a;
        final boolean b;
        final int c;
        final int d;
        private final boolean e;
        private final boolean f;
        private final int g;
        private final boolean h;
        private final float i;

        private static int a(Resources resources, String s)
        {
            int j = 0;
            int k = resources.getIdentifier(s, "dimen", "android");
            if (k > 0)
            {
                j = resources.getDimensionPixelSize(k);
            }
            return j;
        }

        private static boolean a(Context context)
        {
            Resources resources;
            int j;
            resources = context.getResources();
            j = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            if (j == 0) goto _L2; else goto _L1
_L1:
            boolean flag = resources.getBoolean(j);
            if (!"1".equals(com.f.a.a.b())) goto _L4; else goto _L3
_L3:
            return false;
_L4:
            if ("0".equals(com.f.a.a.b()))
            {
                return true;
            } else
            {
                return flag;
            }
_L2:
            if (!ViewConfiguration.get(context).hasPermanentMenuKey())
            {
                return true;
            }
            if (true) goto _L3; else goto _L5
_L5:
        }

        public final boolean a()
        {
            return i >= 600F || h;
        }

        private a(Activity activity, boolean flag, boolean flag1)
        {
            boolean flag3 = true;
            super();
            Resources resources = activity.getResources();
            Object obj1;
            int j;
            boolean flag2;
            if (resources.getConfiguration().orientation == 1)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            h = flag2;
            obj1 = new DisplayMetrics();
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                activity.getWindowManager().getDefaultDisplay().getRealMetrics(((DisplayMetrics) (obj1)));
            } else
            {
                activity.getWindowManager().getDefaultDisplay().getMetrics(((DisplayMetrics) (obj1)));
            }
            i = Math.min((float)((DisplayMetrics) (obj1)).widthPixels / ((DisplayMetrics) (obj1)).density, (float)((DisplayMetrics) (obj1)).heightPixels / ((DisplayMetrics) (obj1)).density);
            a = a(resources, "status_bar_height");
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                TypedValue typedvalue = new TypedValue();
                activity.getTheme().resolveAttribute(0x10102eb, typedvalue, true);
                j = activity.getResources().getDimensionPixelSize(typedvalue.resourceId);
            } else
            {
                j = 0;
            }
            g = j;
            obj1 = activity.getResources();
            if (android.os.Build.VERSION.SDK_INT >= 14 && a(activity))
            {
                Object obj;
                if (h)
                {
                    obj = "navigation_bar_height";
                } else
                {
                    obj = "navigation_bar_height_landscape";
                }
                j = a(((Resources) (obj1)), ((String) (obj)));
            } else
            {
                j = 0;
            }
            c = j;
            obj = activity.getResources();
            if (android.os.Build.VERSION.SDK_INT >= 14 && a(activity))
            {
                j = a(((Resources) (obj)), "navigation_bar_width");
            } else
            {
                j = 0;
            }
            d = j;
            if (c > 0)
            {
                flag2 = flag3;
            } else
            {
                flag2 = false;
            }
            b = flag2;
            e = flag;
            f = flag1;
        }

        a(Activity activity, boolean flag, boolean flag1, byte byte0)
        {
            this(activity, flag, flag1);
        }
    }


    private static String c;
    public final a a;
    public boolean b;
    private boolean d;
    private boolean e;
    private View f;
    private View g;

    public com.f.a.a(Activity activity)
    {
        ViewGroup viewgroup;
        Object obj;
        Window window;
        window = activity.getWindow();
        viewgroup = (ViewGroup)window.getDecorView();
        if (android.os.Build.VERSION.SDK_INT < 19)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        obj = activity.obtainStyledAttributes(new int[] {
            0x10103ef, 0x10103f0
        });
        d = ((TypedArray) (obj)).getBoolean(0, false);
        e = ((TypedArray) (obj)).getBoolean(1, false);
        ((TypedArray) (obj)).recycle();
        obj = window.getAttributes();
        if ((((android.view.WindowManager.LayoutParams) (obj)).flags & 0x4000000) != 0)
        {
            d = true;
        }
        if ((((android.view.WindowManager.LayoutParams) (obj)).flags & 0x8000000) != 0)
        {
            e = true;
        }
        a = new a(activity, d, e, (byte)0);
        if (!a.b)
        {
            e = false;
        }
        if (d)
        {
            f = new View(activity);
            obj = new android.widget.FrameLayout.LayoutParams(-1, a.a);
            obj.gravity = 48;
            if (e && !a.a())
            {
                obj.rightMargin = a.d;
            }
            f.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            f.setBackgroundColor(0x99000000);
            f.setVisibility(8);
            viewgroup.addView(f);
        }
        if (e)
        {
            g = new View(activity);
            if (a.a())
            {
                activity = new android.widget.FrameLayout.LayoutParams(-1, a.c);
                activity.gravity = 80;
            } else
            {
                activity = new android.widget.FrameLayout.LayoutParams(a.d, -1);
                activity.gravity = 5;
            }
            g.setLayoutParams(activity);
            g.setBackgroundColor(0x99000000);
            g.setVisibility(8);
            viewgroup.addView(g);
        }
        return;
        activity;
        ((TypedArray) (obj)).recycle();
        throw activity;
    }

    static String b()
    {
        return c;
    }

    public final void a()
    {
        b = true;
        if (d)
        {
            f.setVisibility(0);
        }
    }

    public final void a(int i)
    {
        if (d)
        {
            f.setBackgroundColor(i);
        }
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT < 19)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        Method method = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[] {
            java/lang/String
        });
        method.setAccessible(true);
        c = (String)method.invoke(null, new Object[] {
            "qemu.hw.mainkeys"
        });
        return;
        Throwable throwable;
        throwable;
        c = null;
    }
}
