// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import android.view.WindowInsets;

// Referenced classes of package android.support.v4.view:
//            bg, bf, ac

class aq
{

    public static bf a(View view, bf bf)
    {
        Object obj = bf;
        if (bf instanceof bg)
        {
            WindowInsets windowinsets = ((bg)bf).g();
            view = view.onApplyWindowInsets(windowinsets);
            obj = bf;
            if (view != windowinsets)
            {
                obj = new bg(view);
            }
        }
        return ((bf) (obj));
    }

    public static void a(View view)
    {
        view.requestApplyInsets();
    }

    public static void a(View view, float f)
    {
        view.setElevation(f);
    }

    public static void a(View view, ac ac)
    {
        view.setOnApplyWindowInsetsListener(new android.view.View.OnApplyWindowInsetsListener(ac) {

            final ac a;

            public WindowInsets onApplyWindowInsets(View view1, WindowInsets windowinsets)
            {
                windowinsets = new bg(windowinsets);
                return ((bg)a.a(view1, windowinsets)).g();
            }

            
            {
                a = ac1;
                super();
            }
        });
    }

    public static float b(View view)
    {
        return view.getElevation();
    }

    public static bf b(View view, bf bf)
    {
        Object obj = bf;
        if (bf instanceof bg)
        {
            WindowInsets windowinsets = ((bg)bf).g();
            view = view.dispatchApplyWindowInsets(windowinsets);
            obj = bf;
            if (view != windowinsets)
            {
                obj = new bg(view);
            }
        }
        return ((bf) (obj));
    }

    public static float c(View view)
    {
        return view.getTranslationZ();
    }

    public static void d(View view)
    {
        view.stopNestedScroll();
    }

    public static float e(View view)
    {
        return view.getZ();
    }
}
