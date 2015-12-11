// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.i;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

public class w
{

    public static int a(Context context, int i1)
    {
        context = context.getTheme().obtainStyledAttributes(new int[] {
            i1
        });
        i1 = context.getColor(0, -1);
        context.recycle();
        return i1;
    }

    public static void a(Context context, Drawable drawable)
    {
        a(context, drawable, com.helpshift.b.a.e);
    }

    private static void a(Context context, Drawable drawable, int i1)
    {
        if (drawable != null)
        {
            drawable.setColorFilter(a(context, i1), android.graphics.PorterDuff.Mode.SRC_ATOP);
        }
    }

    public static void b(Context context, Drawable drawable)
    {
        a(context, drawable, com.helpshift.b.a.f);
    }

    public static void c(Context context, Drawable drawable)
    {
        a(context, drawable, com.helpshift.b.a.g);
    }

    public static void d(Context context, Drawable drawable)
    {
        a(context, drawable, com.helpshift.b.a.h);
    }

    public static void e(Context context, Drawable drawable)
    {
        a(context, drawable, com.helpshift.b.a.i);
    }

    public static void f(Context context, Drawable drawable)
    {
        a(context, drawable, com.helpshift.b.a.j);
    }

    public static void g(Context context, Drawable drawable)
    {
        a(context, drawable, com.helpshift.b.a.k);
    }

    public static void h(Context context, Drawable drawable)
    {
        a(context, drawable, com.helpshift.b.a.l);
    }

    public static void i(Context context, Drawable drawable)
    {
        a(context, drawable, com.helpshift.b.a.m);
    }

    public static void j(Context context, Drawable drawable)
    {
        a(context, drawable, com.helpshift.b.a.n);
    }

    public static void k(Context context, Drawable drawable)
    {
        a(context, drawable, com.helpshift.b.a.o);
    }

    public static void l(Context context, Drawable drawable)
    {
        a(context, drawable, com.helpshift.b.a.q);
    }

    public static void m(Context context, Drawable drawable)
    {
        a(context, drawable, com.helpshift.b.a.r);
    }
}
