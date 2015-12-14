// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v7.internal.view.ContextThemeWrapper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ViewUtils
{

    private static final String TAG = "ViewUtils";
    private static Method sComputeFitSystemWindowsMethod;

    private ViewUtils()
    {
    }

    public static int combineMeasuredStates(int i, int j)
    {
        return i | j;
    }

    public static void computeFitSystemWindows(View view, Rect rect, Rect rect1)
    {
        if (sComputeFitSystemWindowsMethod == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        sComputeFitSystemWindowsMethod.invoke(view, new Object[] {
            rect, rect1
        });
        return;
        view;
        Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", view);
        return;
    }

    public static boolean isLayoutRtl(View view)
    {
        return ViewCompat.getLayoutDirection(view) == 1;
    }

    public static void makeOptionalFitsSystemWindows(View view)
    {
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
        if (!method.isAccessible())
        {
            method.setAccessible(true);
        }
        method.invoke(view, new Object[0]);
        return;
        view;
        Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        return;
        view;
        Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", view);
        return;
        view;
        Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", view);
        return;
    }

    public static Context themifyContext(Context context, AttributeSet attributeset, boolean flag, boolean flag1)
    {
label0:
        {
            attributeset = context.obtainStyledAttributes(attributeset, android.support.v7.appcompat.R.styleable.View, 0, 0);
            int i = 0;
            if (flag)
            {
                i = attributeset.getResourceId(android.support.v7.appcompat.R.styleable.View_android_theme, 0);
            }
            int k = i;
            if (flag1)
            {
                k = i;
                if (i == 0)
                {
                    int j = attributeset.getResourceId(android.support.v7.appcompat.R.styleable.View_theme, 0);
                    k = j;
                    if (j != 0)
                    {
                        Log.i("ViewUtils", "app:theme is now deprecated. Please move to using android:theme instead.");
                        k = j;
                    }
                }
            }
            attributeset.recycle();
            attributeset = context;
            if (k == 0)
            {
                break label0;
            }
            if (context instanceof ContextThemeWrapper)
            {
                attributeset = context;
                if (((ContextThemeWrapper)context).getThemeResId() == k)
                {
                    break label0;
                }
            }
            attributeset = new ContextThemeWrapper(context, k);
        }
        return attributeset;
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        sComputeFitSystemWindowsMethod = android/view/View.getDeclaredMethod("computeFitSystemWindows", new Class[] {
            android/graphics/Rect, android/graphics/Rect
        });
        if (!sComputeFitSystemWindowsMethod.isAccessible())
        {
            sComputeFitSystemWindowsMethod.setAccessible(true);
        }
        return;
        NoSuchMethodException nosuchmethodexception;
        nosuchmethodexception;
        Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
    }
}
