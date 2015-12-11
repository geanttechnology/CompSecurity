// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;
import java.lang.reflect.Method;

// Referenced classes of package android.support.v4.app:
//            j

final class i
{

    private static final int a[] = {
        0x101030b
    };

    public static Drawable a(Activity activity)
    {
        activity = activity.obtainStyledAttributes(a);
        Drawable drawable = activity.getDrawable(0);
        activity.recycle();
        return drawable;
    }

    public static Object a(Object obj, Activity activity, int k)
    {
        if (obj == null)
        {
            obj = new j(activity);
        }
        j j1 = (j)obj;
        if (j1.a != null)
        {
            try
            {
                activity = activity.getActionBar();
                j1.b.invoke(activity, new Object[] {
                    Integer.valueOf(k)
                });
                if (android.os.Build.VERSION.SDK_INT <= 19)
                {
                    activity.setSubtitle(activity.getSubtitle());
                }
            }
            // Misplaced declaration of an exception variable
            catch (Activity activity)
            {
                Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set content description via JB-MR2 API", activity);
                return obj;
            }
        }
        return obj;
    }

    public static Object a(Object obj, Activity activity, Drawable drawable, int k)
    {
        if (obj == null)
        {
            obj = new j(activity);
        }
        j j1 = (j)obj;
        if (j1.a != null)
        {
            try
            {
                activity = activity.getActionBar();
                j1.a.invoke(activity, new Object[] {
                    drawable
                });
                j1.b.invoke(activity, new Object[] {
                    Integer.valueOf(k)
                });
            }
            // Misplaced declaration of an exception variable
            catch (Activity activity)
            {
                Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator via JB-MR2 API", activity);
                return obj;
            }
            return obj;
        }
        if (j1.c != null)
        {
            j1.c.setImageDrawable(drawable);
            return obj;
        } else
        {
            Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator");
            return obj;
        }
    }

}
