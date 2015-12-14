// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

final class SlidingTabStrip extends LinearLayout
{

    Drawable a;
    float b;
    IndicatorPosition c;
    private final IndicatorPosition d;
    private Drawable e;
    private Drawable f;
    private int g;
    private float h;

    SlidingTabStrip(Context context)
    {
        this(context, (byte)0);
    }

    private SlidingTabStrip(Context context, byte byte0)
    {
        super(context, null);
        d = IndicatorPosition.BOTTOM;
        setWillNotDraw(false);
        TypedValue typedvalue = new TypedValue();
        context.getTheme().resolveAttribute(0x1010030, typedvalue, true);
        b = 0.5F;
        c = d;
    }

    final void a(int i, float f1)
    {
        g = i;
        h = f1;
        invalidate();
    }

    public final void a(Drawable drawable)
    {
        e = drawable;
        invalidate();
    }

    protected final void dispatchDraw(Canvas canvas)
    {
        float f2;
        float f3;
        int j;
        int k;
        int l1;
        super.dispatchDraw(canvas);
        f3 = getResources().getDisplayMetrics().density;
        l1 = getHeight();
        k = getChildCount();
        if (f != null)
        {
            float f1 = f.getIntrinsicWidth();
            int l;
            int j1;
            if (f1 <= 0.0F)
            {
                f1 = 1.0F * f3;
            }
            l = (int)(Math.min(Math.max(0.0F, b), 1.0F) * (float)l1);
            j1 = (l1 - l) / 2;
            for (int i = 0; i < k - 1; i++)
            {
                View view = getChildAt(i);
                int i2 = Math.round((float)view.getRight() - f1 / 2.0F);
                int j2 = Math.round(j1);
                int k2 = Math.round((float)view.getRight() + f1 / 2.0F);
                int l2 = Math.round(j1 + l);
                f.setBounds(i2, j2, k2, l2);
                f.draw(canvas);
            }

        }
        if (a != null)
        {
            f2 = a.getIntrinsicHeight();
            final class _cls1
            {

                static final int a[];

                static 
                {
                    a = new int[IndicatorPosition.values().length];
                    try
                    {
                        a[IndicatorPosition.BOTTOM.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        a[IndicatorPosition.TOP.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            float f4;
            float f5;
            View view1;
            int i1;
            int k1;
            if (f2 <= 0.0F)
            {
                f2 = 2.0F * f3;
            }
            a.setBounds(0, Math.round((float)l1 - f2), getWidth(), l1);
            a.draw(canvas);
        }
        if (k <= 0) goto _L2; else goto _L1
_L1:
        view1 = getChildAt(g);
        k1 = view1.getLeft();
        i1 = view1.getRight();
        k = k1;
        j = i1;
        if (h > 0.0F)
        {
            k = k1;
            j = i1;
            if (g < getChildCount() - 1)
            {
                view1 = getChildAt(g + 1);
                f2 = h;
                f4 = view1.getLeft();
                f5 = h;
                k = (int)((float)k1 * (1.0F - f5) + f2 * f4);
                f2 = h;
                f4 = view1.getRight();
                f5 = h;
                j = (int)((float)i1 * (1.0F - f5) + f4 * f2);
            }
        }
        if (e == null) goto _L2; else goto _L3
_L3:
        f2 = e.getIntrinsicHeight();
        if (f2 <= 0.0F)
        {
            f2 = 2.0F * f3;
        }
        _cls1.a[c.ordinal()];
        JVM INSTR tableswitch 1 2: default 444
    //                   1 467
    //                   2 491;
           goto _L4 _L5 _L6
_L4:
        e.draw(canvas);
_L2:
        return;
_L5:
        e.setBounds(k, Math.round((float)l1 - f2), j, l1);
        continue; /* Loop/switch isn't completed */
_L6:
        e.setBounds(k, 0, j, Math.round(f2));
        if (true) goto _L4; else goto _L7
_L7:
    }

    public final void setDividerDrawable(Drawable drawable)
    {
        f = drawable;
        invalidate();
    }

    private class IndicatorPosition extends Enum
    {

        private static final IndicatorPosition $VALUES[];
        public static final IndicatorPosition BOTTOM;
        public static final IndicatorPosition TOP;

        public static IndicatorPosition valueOf(String s)
        {
            return (IndicatorPosition)Enum.valueOf(com/picsart/studio/view/SlidingTabStrip$IndicatorPosition, s);
        }

        public static IndicatorPosition[] values()
        {
            return (IndicatorPosition[])$VALUES.clone();
        }

        static 
        {
            TOP = new IndicatorPosition("TOP", 0);
            BOTTOM = new IndicatorPosition("BOTTOM", 1);
            $VALUES = (new IndicatorPosition[] {
                TOP, BOTTOM
            });
        }

        private IndicatorPosition(String s, int i)
        {
            super(s, i);
        }
    }

}
