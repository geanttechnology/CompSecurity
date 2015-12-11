// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;

// Referenced classes of package com.amazon.device.ads:
//            as, ds

final class at
{
    public static final class a
    {

        final as a;

        public a(as as1)
        {
            a = as1;
        }
    }

    public final class a.a
    {

        final WebSettings a;
        final a b;

        public a.a(a a1, WebSettings websettings)
        {
            b = a1;
            super();
            a = websettings;
        }
    }

    private static final class b
    {
    }


    public static final a a = new a(new as());
    private static boolean b = false;

    public static int a(Display display)
    {
        if (a(8))
        {
            return display.getRotation();
        } else
        {
            return display.getOrientation();
        }
    }

    public static BitmapDrawable a(Resources resources, String s)
    {
        if (a(5))
        {
            return new BitmapDrawable(resources, s);
        } else
        {
            return new BitmapDrawable(s);
        }
    }

    public static a a()
    {
        return a;
    }

    public static String a(Context context)
    {
        return context.getPackageCodePath();
    }

    public static void a(Activity activity)
    {
        if (a(11))
        {
            ActionBar actionbar = activity.getActionBar();
            if (actionbar != null)
            {
                actionbar.hide();
            }
        }
        if (a(16))
        {
            activity.getWindow().getDecorView().setSystemUiVisibility(4);
        }
    }

    public static void a(android.content.SharedPreferences.Editor editor)
    {
        editor.apply();
    }

    public static final void a(View view)
    {
        view.setLayerType(1, null);
    }

    public static void a(Window window)
    {
        if (a(11))
        {
            window.setFlags(0x1000000, 0x1000000);
        }
    }

    public static void a(WebView webview, String s)
    {
        webview.removeJavascriptInterface(s);
    }

    public static void a(ImageButton imagebutton, int i)
    {
        if (a(16))
        {
            imagebutton.setImageAlpha(i);
            return;
        } else
        {
            imagebutton.setAlpha(i);
            return;
        }
    }

    public static transient void a(ds.f f, Object aobj[])
    {
        if (a(11))
        {
            f.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, aobj);
            return;
        } else
        {
            f.execute(aobj);
            return;
        }
    }

    public static boolean a(int i)
    {
        return android.os.Build.VERSION.SDK_INT >= i;
    }

    public static boolean a(SQLiteException sqliteexception)
    {
        return sqliteexception instanceof SQLiteDatabaseLockedException;
    }

    public static boolean a(as as1)
    {
        return a(as1, 11) && b(as1, 13);
    }

    public static boolean a(as as1, int i)
    {
        return as1.a >= i;
    }

    public static void b()
    {
        if (a(19))
        {
            ds.c(new Runnable() {

                final boolean a = true;

                public final void run()
                {
                    WebView.setWebContentsDebuggingEnabled(a);
                }

            
            {
                super();
            }
            });
        }
    }

    public static boolean b(as as1, int i)
    {
        return as1.a <= i;
    }

    public static boolean c(as as1, int i)
    {
        return as1.a == i;
    }

}
