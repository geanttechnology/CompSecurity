// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Rect;
import android.view.View;
import java.lang.reflect.Method;

public final class ie
{

    private static Method a;

    public static int a(int i, int j)
    {
        return i | j;
    }

    public static void a(View view, Rect rect, Rect rect1)
    {
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        a.invoke(view, new Object[] {
            rect, rect1
        });
        return;
        view;
    }

    public static boolean a(View view)
    {
        return dz.a(view) == 1;
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        Method method = android/view/View.getDeclaredMethod("computeFitSystemWindows", new Class[] {
            android/graphics/Rect, android/graphics/Rect
        });
        a = method;
        if (!method.isAccessible())
        {
            a.setAccessible(true);
        }
        return;
        NoSuchMethodException nosuchmethodexception;
        nosuchmethodexception;
    }
}
