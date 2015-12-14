// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.cyberlink.youcammakeup.utility.aa;

public class MultiColorView extends View
{

    private ColorCount a;
    private float b;
    private Path c;
    private Path d;
    private Paint e;
    private Paint f;
    private int g;
    private int h;
    private int i;
    private int j;

    public MultiColorView(Context context)
    {
        super(context);
        a = ColorCount.a;
        b = 1.0F;
        c = new Path();
        d = new Path();
        e = aa.a();
        f = aa.a();
        g = 0;
        h = 0;
        i = 0;
        j = 0;
        a();
    }

    public MultiColorView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = ColorCount.a;
        b = 1.0F;
        c = new Path();
        d = new Path();
        e = aa.a();
        f = aa.a();
        g = 0;
        h = 0;
        i = 0;
        j = 0;
        a();
    }

    public MultiColorView(Context context, AttributeSet attributeset, int k)
    {
        super(context, attributeset, k);
        a = ColorCount.a;
        b = 1.0F;
        c = new Path();
        d = new Path();
        e = aa.a();
        f = aa.a();
        g = 0;
        h = 0;
        i = 0;
        j = 0;
        a();
    }

    private void a()
    {
        e.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        f.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
    }

    private void a(Canvas canvas)
    {
        canvas.save();
        canvas.drawPath(c, e);
        canvas.drawPath(d, f);
        canvas.restore();
    }

    private void b()
    {
        int k = getWidth();
        int l = getHeight();
        float f1 = (float)k * b;
        float f2 = (float)l * b;
        c.rewind();
        c.moveTo(0.0F, 0.0F);
        c.lineTo(f1, 0.0F);
        c.lineTo(0.0F, f2);
        c.close();
        d.rewind();
        d.moveTo(k, (float)l - f2);
        d.lineTo(k, l);
        d.lineTo((float)k - f1, l);
        d.close();
    }

    private void b(Canvas canvas)
    {
        int k = getWidth();
        int l = getHeight();
        int i1 = Math.round((float)k * 0.5F);
        int j1 = Math.round((float)l * 0.5F);
        canvas.save();
        canvas.clipRect(0, 0, i1, j1);
        canvas.drawColor(g);
        canvas.restore();
        canvas.save();
        canvas.clipRect(i1, 0, k, j1);
        canvas.drawColor(h);
        canvas.restore();
        canvas.save();
        canvas.clipRect(0, j1, i1, l);
        canvas.drawColor(i);
        canvas.restore();
        canvas.save();
        canvas.clipRect(i1, j1, k, l);
        canvas.drawColor(j);
        canvas.restore();
    }

    public void a(int k, int l)
    {
        a(k, k, l, 1.0F);
        a = ColorCount.b;
    }

    public void a(int k, int l, int i1, float f1)
    {
        e.setColor(k);
        super.setBackgroundColor(l);
        f.setColor(i1);
        b = f1;
        a = ColorCount.c;
        b();
        invalidate();
    }

    public void a(int k, int l, int i1, int j1)
    {
        g = k;
        h = l;
        i = i1;
        j = j1;
        a = ColorCount.d;
        invalidate();
    }

    protected void onDraw(Canvas canvas)
    {
        class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[ColorCount.values().length];
                try
                {
                    a[ColorCount.b.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[ColorCount.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[ColorCount.a.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[ColorCount.d.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[a.ordinal()])
        {
        case 3: // '\003'
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
            a(canvas);
            return;

        case 4: // '\004'
            b(canvas);
            break;
        }
    }

    protected void onSizeChanged(int k, int l, int i1, int j1)
    {
        switch (_cls1.a[a.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
            b();
            break;
        }
    }

    public void setBackgroundColor(int k)
    {
        super.setBackgroundColor(k);
        a = ColorCount.a;
        invalidate();
    }

    private class ColorCount extends Enum
    {

        public static final ColorCount a;
        public static final ColorCount b;
        public static final ColorCount c;
        public static final ColorCount d;
        private static final ColorCount e[];

        public static ColorCount valueOf(String s)
        {
            return (ColorCount)Enum.valueOf(com/cyberlink/youcammakeup/widgetpool/common/MultiColorView$ColorCount, s);
        }

        public static ColorCount[] values()
        {
            return (ColorCount[])e.clone();
        }

        static 
        {
            a = new ColorCount("ONE", 0);
            b = new ColorCount("TWO", 1);
            c = new ColorCount("THREE", 2);
            d = new ColorCount("FOUR", 3);
            e = (new ColorCount[] {
                a, b, c, d
            });
        }

        private ColorCount(String s, int k)
        {
            super(s, k);
        }
    }

}
