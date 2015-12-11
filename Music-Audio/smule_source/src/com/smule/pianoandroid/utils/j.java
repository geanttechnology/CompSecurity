// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.DisplayMetrics;
import android.util.StateSet;
import android.view.View;

public class j
{

    public static int a(int i, Context context)
    {
        context = context.getResources().getDisplayMetrics();
        float f = i;
        return (int)(((DisplayMetrics) (context)).density * f + 0.5F);
    }

    public static int a(Context context)
    {
        context = context.getResources().getDisplayMetrics();
        float f = ((DisplayMetrics) (context)).density;
        return (int)((float)((DisplayMetrics) (context)).heightPixels / f + 0.5F);
    }

    public static Drawable a(String s)
    {
        s = new GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, new int[] {
            Color.parseColor(s), Color.parseColor(s)
        });
        s.setGradientType(0);
        s.setCornerRadius(4F);
        return s;
    }

    public static Drawable a(String s, String s1)
    {
        StateListDrawable statelistdrawable = new StateListDrawable();
        s = a(s);
        statelistdrawable.addState(new int[] {
            0x10100a7
        }, s);
        statelistdrawable.addState(StateSet.WILD_CARD, a(s1));
        return statelistdrawable;
    }

    public static void a(View view, Context context)
    {
        if (a(context) < 350)
        {
            int i = a(5, context);
            view.setPadding(i, i, i, i);
        }
    }
}
