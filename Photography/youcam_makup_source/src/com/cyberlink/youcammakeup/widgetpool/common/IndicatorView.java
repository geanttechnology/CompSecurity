// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.cyberlink.youcammakeup.utility.c;

public class IndicatorView extends View
{

    private int a;
    private int b;
    private int c;
    private Drawable d;
    private Drawable e;
    private Orientation f;
    private Gravity g;

    public IndicatorView(Context context)
    {
        super(context);
        a = 0;
        b = -1;
        c = 0;
        d = null;
        e = null;
        f = Orientation.a;
        g = Gravity.b;
    }

    public IndicatorView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = 0;
        b = -1;
        c = 0;
        d = null;
        e = null;
        f = Orientation.a;
        g = Gravity.b;
    }

    public IndicatorView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = 0;
        b = -1;
        c = 0;
        d = null;
        e = null;
        f = Orientation.a;
        g = Gravity.b;
    }

    public void a(float f1, int i)
    {
        c = (int)TypedValue.applyDimension(i, f1, getResources().getDisplayMetrics());
        invalidate();
    }

    public void a(Drawable drawable, float f1, float f2, int i)
    {
        android.util.DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        drawable.setBounds(0, 0, (int)TypedValue.applyDimension(i, f1, displaymetrics), (int)TypedValue.applyDimension(i, f2, displaymetrics));
        d = drawable;
        invalidate();
    }

    public void b(Drawable drawable, float f1, float f2, int i)
    {
        android.util.DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        drawable.setBounds(0, 0, (int)TypedValue.applyDimension(i, f1, displaymetrics), (int)TypedValue.applyDimension(i, f2, displaymetrics));
        e = drawable;
        invalidate();
    }

    public int getCount()
    {
        return a;
    }

    public Gravity getGravity()
    {
        return g;
    }

    public Drawable getHighlightDrawable()
    {
        return e;
    }

    public int getIndex()
    {
        return b;
    }

    public float getMargin()
    {
        return (float)c;
    }

    public Drawable getNormalDrawable()
    {
        return d;
    }

    public Orientation getOrientation()
    {
        return f;
    }

    protected void onDraw(Canvas canvas)
    {
        int j;
        int k;
        k = 0;
        j = 0;
        if (!isInEditMode() && a > 0 && c >= 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i1;
        int j1;
        int l1;
        int i2;
        i1 = getWidth();
        j1 = getHeight();
        l1 = getPaddingLeft() + getPaddingRight();
        i2 = getPaddingTop() + getPaddingBottom();
        if (f != Orientation.a) goto _L4; else goto _L3
_L3:
        class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[Gravity.values().length];
                try
                {
                    a[Gravity.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.cyberlink.youcammakeup.widgetpool.common.Gravity.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[Gravity.b.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[g.ordinal()];
        JVM INSTR tableswitch 1 2: default 104
    //                   1 166
    //                   2 175;
           goto _L5 _L6 _L7
_L5:
        int i = (i1 - l1 - (a - 1) * c) / 2 + getPaddingLeft();
_L9:
        while (j < a) 
        {
            Drawable drawable;
            if (j == b)
            {
                drawable = e;
            } else
            {
                drawable = d;
            }
            if (drawable != null)
            {
                Rect rect = drawable.getBounds();
                k = c;
                i1 = rect.width() / 2;
                l1 = (j1 - i2 - rect.height()) / 2;
                int k2 = getPaddingTop();
                canvas.save();
                canvas.translate((k * j + i) - i1, l1 + k2);
                drawable.draw(canvas);
                canvas.restore();
            }
            j++;
        }
          goto _L8
_L6:
        i = getPaddingLeft();
          goto _L9
_L7:
        i = i1 - getPaddingRight() - (a - 1) * c;
          goto _L9
_L4:
        _cls1.a[g.ordinal()];
        JVM INSTR tableswitch 1 2: default 320
    //                   1 386
    //                   2 399;
           goto _L10 _L11 _L12
_L10:
        i = (j1 - i2 - (a - 1) * c) / 2 + getPaddingTop();
        j = k;
_L13:
        while (j < a) 
        {
            Drawable drawable1;
            if (j == b)
            {
                drawable1 = e;
            } else
            {
                drawable1 = d;
            }
            if (drawable1 != null)
            {
                Rect rect1 = drawable1.getBounds();
                int l = (i1 - l1 - rect1.width()) / 2;
                int k1 = getPaddingLeft();
                int j2 = c;
                int l2 = rect1.height() / 2;
                canvas.save();
                canvas.translate(l + k1, (j2 * j + i) - l2);
                drawable1.draw(canvas);
                canvas.restore();
            }
            j++;
        }
_L8:
        if (true) goto _L1; else goto _L11
_L11:
        i = getPaddingTop();
        j = k;
          goto _L13
_L12:
        i = j1 - getPaddingBottom() - (a - 1) * c;
        j = k;
          goto _L13
    }

    public void setCount(int i)
    {
        a = i;
        if (a <= 0)
        {
            b = -1;
        }
        invalidate();
    }

    public void setGravity(Gravity gravity)
    {
        if (gravity == null)
        {
            g = Gravity.b;
        } else
        {
            g = gravity;
        }
        invalidate();
    }

    public void setIndex(int i)
    {
        com.cyberlink.youcammakeup.utility.c.a(i, a);
        b = i;
        invalidate();
    }

    public void setOrientation(Orientation orientation)
    {
        if (orientation == null)
        {
            f = Orientation.a;
        } else
        {
            f = orientation;
        }
        invalidate();
    }

    private class Orientation extends Enum
    {

        public static final Orientation a;
        public static final Orientation b;
        private static final Orientation c[];

        public static Orientation valueOf(String s)
        {
            return (Orientation)Enum.valueOf(com/cyberlink/youcammakeup/widgetpool/common/IndicatorView$Orientation, s);
        }

        public static Orientation[] values()
        {
            return (Orientation[])c.clone();
        }

        static 
        {
            a = new Orientation("HORIZONTAL", 0);
            b = new Orientation("VERTICAL", 1);
            c = (new Orientation[] {
                a, b
            });
        }

        private Orientation(String s, int i)
        {
            super(s, i);
        }
    }


    private class Gravity extends Enum
    {

        public static final Gravity a;
        public static final Gravity b;
        public static final Gravity c;
        private static final Gravity d[];

        public static Gravity valueOf(String s)
        {
            return (Gravity)Enum.valueOf(com/cyberlink/youcammakeup/widgetpool/common/IndicatorView$Gravity, s);
        }

        public static Gravity[] values()
        {
            return (Gravity[])d.clone();
        }

        static 
        {
            a = new Gravity("LEFT", 0);
            b = new Gravity("CENTER", 1);
            c = new Gravity("RIGHT", 2);
            d = (new Gravity[] {
                a, b, c
            });
        }

        private Gravity(String s, int i)
        {
            super(s, i);
        }
    }

}
