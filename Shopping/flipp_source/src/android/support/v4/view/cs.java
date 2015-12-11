// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import android.view.ViewPropertyAnimator;

// Referenced classes of package android.support.v4.view:
//            ct, cw

final class cs
{

    public static void a(View view)
    {
        view.animate().cancel();
    }

    public static void a(View view, float f)
    {
        view.animate().alpha(f);
    }

    public static void a(View view, long l)
    {
        view.animate().setDuration(l);
    }

    public static void a(View view, cw cw)
    {
        view.animate().setListener(new ct(cw, view));
    }

    public static void b(View view)
    {
        view.animate().start();
    }

    public static void b(View view, float f)
    {
        view.animate().translationX(f);
    }

    public static void c(View view, float f)
    {
        view.animate().translationY(f);
    }
}
