// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

// Referenced classes of package com.offerup.android.views:
//            h, f

public final class g extends LinearLayout
{

    private final int a;
    private final Paint b;
    private final int c;
    private final Paint d;
    private final int e;
    private int f;
    private float g;
    private f h;
    private final h i;

    g(Context context)
    {
        this(context, null);
    }

    private g(Context context, AttributeSet attributeset)
    {
        super(context, null);
        setWillNotDraw(false);
        float f1 = getResources().getDisplayMetrics().density;
        attributeset = new TypedValue();
        context.getTheme().resolveAttribute(0x1010030, attributeset, true);
        int j = ((TypedValue) (attributeset)).data;
        e = Color.argb(38, Color.red(j), Color.green(j), Color.blue(j));
        i = new h((byte)0);
        i.a(new int[] {
            0xff33b5e5
        });
        a = (int)(0.0F * f1);
        b = new Paint();
        b.setColor(e);
        c = (int)(f1 * 3F);
        d = new Paint();
    }

    final void a(int j, float f1)
    {
        f = j;
        g = f1;
        invalidate();
    }

    protected final void onDraw(Canvas canvas)
    {
        int k1 = getHeight();
        int j = getChildCount();
        Object obj;
        if (h != null)
        {
            obj = h;
        } else
        {
            obj = i;
        }
        if (j > 0)
        {
            View view = getChildAt(f);
            int j1 = view.getLeft();
            int i1 = view.getRight();
            int l = ((f) (obj)).a(f);
            int k;
            if (g > 0.0F && f < getChildCount() - 1)
            {
                int l1 = ((f) (obj)).a(f + 1);
                k = l;
                if (l != l1)
                {
                    float f1 = g;
                    float f3 = 1.0F - f1;
                    float f5 = Color.red(l1);
                    float f7 = Color.red(l);
                    float f8 = Color.green(l1);
                    float f9 = Color.green(l);
                    float f10 = Color.blue(l1);
                    float f11 = Color.blue(l);
                    k = Color.rgb((int)(f5 * f1 + f7 * f3), (int)(f8 * f1 + f9 * f3), (int)(f11 * f3 + f10 * f1));
                }
                obj = getChildAt(f + 1);
                float f2 = g;
                float f4 = ((View) (obj)).getLeft();
                float f6 = g;
                l = (int)((float)j1 * (1.0F - f6) + f2 * f4);
                f2 = g;
                f4 = ((View) (obj)).getRight();
                f6 = g;
                i1 = (int)((float)i1 * (1.0F - f6) + f4 * f2);
            } else
            {
                k = l;
                l = j1;
            }
            d.setColor(k);
            canvas.drawRect(l, k1 - c, i1, k1, d);
        }
        canvas.drawRect(0.0F, k1 - a, getWidth(), k1, b);
    }

    final void setCustomTabColorizer(f f1)
    {
        h = f1;
        invalidate();
    }

    final transient void setSelectedIndicatorColors(int ai[])
    {
        h = null;
        i.a(ai);
        invalidate();
    }
}
