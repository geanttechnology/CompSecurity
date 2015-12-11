// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

final class alm
{

    private static Animation a;
    private static Animation b;
    private static int c;
    private static int d;

    static Animation a(View view)
    {
        if (!c(view) || a == null)
        {
            a = new TranslateAnimation(0.0F, 0.0F, -view.getMeasuredHeight(), 0.0F);
            a.setDuration(400L);
            a(view.getMeasuredHeight());
        }
        return a;
    }

    private static void a(int i)
    {
        c = i;
    }

    private static boolean a(int i, View view)
    {
        return i == view.getMeasuredHeight();
    }

    static Animation b(View view)
    {
        if (!d(view) || b == null)
        {
            b = new TranslateAnimation(0.0F, 0.0F, 0.0F, -view.getMeasuredHeight());
            b.setDuration(400L);
            b(view.getMeasuredHeight());
        }
        return b;
    }

    private static void b(int i)
    {
        d = i;
    }

    private static boolean c(View view)
    {
        return a(c, view);
    }

    private static boolean d(View view)
    {
        return a(d, view);
    }
}
