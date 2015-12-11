// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;

class ao
{

    public static int a(View view)
    {
        return view.getLayoutDirection();
    }

    public static void a(View view, int i, int j, int k, int l)
    {
        view.setPaddingRelative(i, j, k, l);
    }

    public static int b(View view)
    {
        return view.getPaddingStart();
    }

    public static int c(View view)
    {
        return view.getPaddingEnd();
    }

    public static int d(View view)
    {
        return view.getWindowSystemUiVisibility();
    }

    public static boolean e(View view)
    {
        return view.isPaddingRelative();
    }
}
