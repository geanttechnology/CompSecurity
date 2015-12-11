// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.DisplayMetrics;

// Referenced classes of package com.paypal.android.sdk:
//            cm

public final class cl
{

    private static int A = Color.parseColor("#aa717074");
    private static int B = Color.parseColor("#5a5a5d");
    private static int C = Color.parseColor("#f5f5f5");
    public static final int a;
    public static final int b;
    public static final Drawable c = new ColorDrawable(Color.parseColor("#717074"));
    public static final int d = Color.parseColor("#f5f5f5");
    public static final int e = Color.parseColor("#c4dceb");
    public static final int f = Color.parseColor("#e5e5e5");
    public static final int g;
    public static final int h = Color.parseColor("#797979");
    public static final int i;
    public static final Typeface j = Typeface.create("sans-serif-light", 0);
    public static final Typeface k = Typeface.create("sans-serif-light", 0);
    public static final Typeface l = Typeface.create("sans-serif-bold", 0);
    public static final Typeface m = Typeface.create("sans-serif", 2);
    public static final Typeface n = Typeface.create("sans-serif-light", 0);
    public static final Typeface o = Typeface.create("sans-serif-light", 0);
    public static final ColorStateList p;
    private static int q[] = {
        0x10100a7, 0x101009e
    };
    private static int r[] = {
        0x101009e
    };
    private static int s[] = {
        0xfefeff62
    };
    private static int t[] = {
        0x101009c
    };
    private static int u;
    private static int v;
    private static int w;
    private static int x;
    private static int y = Color.parseColor("#c5ddeb");
    private static int z = Color.parseColor("#717074");

    private static Drawable a(int i1, float f1)
    {
        ColorDrawable colordrawable = new ColorDrawable(i1);
        ShapeDrawable shapedrawable = new ShapeDrawable(new RectShape());
        shapedrawable.getPaint().setStrokeWidth(2.0F * f1);
        shapedrawable.getPaint().setStyle(android.graphics.Paint.Style.STROKE);
        shapedrawable.getPaint().setColor(d);
        return new LayerDrawable(new Drawable[] {
            colordrawable, shapedrawable
        });
    }

    private static Drawable a(int i1, int j1, float f1)
    {
        ColorDrawable colordrawable = new ColorDrawable(i1);
        ShapeDrawable shapedrawable = new ShapeDrawable(new RectShape());
        shapedrawable.getPaint().setStrokeWidth(2.0F * f1);
        shapedrawable.getPaint().setStyle(android.graphics.Paint.Style.STROKE);
        shapedrawable.getPaint().setColor(d);
        ShapeDrawable shapedrawable1 = new ShapeDrawable(new RectShape());
        shapedrawable1.getPaint().setStrokeWidth(f1);
        shapedrawable1.getPaint().setStyle(android.graphics.Paint.Style.STROKE);
        shapedrawable1.getPaint().setColor(j1);
        return new LayerDrawable(new Drawable[] {
            colordrawable, shapedrawable, shapedrawable1
        });
    }

    public static Drawable a(Context context)
    {
        StateListDrawable statelistdrawable = new StateListDrawable();
        statelistdrawable.addState(q, new ColorDrawable(x));
        statelistdrawable.addState(s, new ColorDrawable(y));
        statelistdrawable.addState(t, a(v, w, c(context)));
        statelistdrawable.addState(r, a(v, c(context)));
        return statelistdrawable;
    }

    protected static Drawable b(Context context)
    {
        StateListDrawable statelistdrawable = new StateListDrawable();
        statelistdrawable.addState(t, a(0, w, c(context)));
        statelistdrawable.addState(r, new ColorDrawable(0));
        return statelistdrawable;
    }

    private static float c(Context context)
    {
        return context.getResources().getDisplayMetrics().density * (cm.a("4dip", context) / 2.0F);
    }

    static 
    {
        a = Color.parseColor("#003087");
        Color.parseColor("#aa003087");
        b = Color.parseColor("#009CDE");
        u = Color.parseColor("#aa009CDE");
        v = b;
        w = u;
        x = a;
        Color.parseColor("#333333");
        g = Color.parseColor("#515151");
        Color.parseColor("#b32317");
        i = g;
        Typeface.create("sans-serif-light", 0);
        Typeface.create("sans-serif", 0);
        int ai[] = q;
        int ai1[] = r;
        int i1 = x;
        int j1 = v;
        p = new ColorStateList(new int[][] {
            ai, ai1
        }, new int[] {
            i1, j1
        });
    }
}
