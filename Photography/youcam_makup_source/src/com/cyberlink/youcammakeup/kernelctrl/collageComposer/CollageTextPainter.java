// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.collageComposer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.TypedValue;
import com.pf.common.utility.m;
import java.text.Format;
import java.util.Date;
import java.util.Locale;

public class CollageTextPainter
{

    Context a;
    Paint b;
    Paint c;
    int d;
    int e;
    int f;
    String g;
    int h;
    Typeface i;
    int j;
    int k;
    AlignType l;
    Rect m;
    long n;
    Format o;

    public CollageTextPainter(Context context)
    {
        a = null;
        b = new Paint();
        c = new Paint();
        d = 0;
        e = 0;
        f = 0;
        h = 0xff000000;
        i = Typeface.DEFAULT;
        j = 0;
        k = 0;
        l = AlignType.a;
        m = new Rect();
        n = System.currentTimeMillis();
        a = context;
    }

    private int c()
    {
        float f1;
        int j1;
        b.setColor(h);
        b.setAntiAlias(true);
        b.setTypeface(i);
        b.setTextSize(f);
        f1 = b.measureText(g);
        j1 = 0;
        class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[AlignType.values().length];
                try
                {
                    a[AlignType.c.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[AlignType.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[AlignType.a.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[l.ordinal()];
        JVM INSTR tableswitch 1 2: default 92
    //                   1 170
    //                   2 210;
           goto _L1 _L2 _L3
_L1:
        int i1 = j1;
_L5:
        android.graphics.Paint.FontMetrics fontmetrics = b.getFontMetrics();
        Rect rect = m;
        j1 = d;
        int k1 = (int)((float)e + fontmetrics.top);
        int l1 = (int)(f1 + (float)(d + i1));
        f1 = e;
        rect.set(j1 + i1, k1, l1, (int)(fontmetrics.bottom + f1));
        return i1;
_L2:
        i1 = j1;
        if (j != 0)
        {
            i1 = j1;
            if (f1 <= (float)j)
            {
                i1 = Math.round((float)j - f1);
            }
        }
        continue; /* Loop/switch isn't completed */
_L3:
        i1 = j1;
        if (j != 0)
        {
            i1 = j1;
            if (f1 <= (float)j)
            {
                i1 = Math.round(((float)j - f1) / 2.0F);
            }
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public long a()
    {
        return n;
    }

    public void a(int i1)
    {
        com.pf.common.utility.m.e("CollageTextView", (new StringBuilder()).append("pixelSize = ").append(i1).toString());
        f = (int)TypedValue.applyDimension(0, i1, a.getResources().getDisplayMetrics());
        com.pf.common.utility.m.e("CollageTextView", (new StringBuilder()).append("textSize = ").append(f).toString());
    }

    public void a(int i1, int j1)
    {
        d = i1;
        e = j1;
    }

    public void a(long l1)
    {
        n = l1;
    }

    protected void a(Canvas canvas)
    {
        int i1 = c();
        if (o != null)
        {
            g = o.format(new Date(a()));
        }
        canvas.drawText(g, i1 + d, e, b);
    }

    public void a(Typeface typeface)
    {
        i = typeface;
    }

    public void a(AlignType aligntype)
    {
        l = aligntype;
    }

    public void a(String s)
    {
        g = s;
    }

    public void a(Format format)
    {
        o = format;
    }

    protected Rect b()
    {
        return m;
    }

    public void b(int i1)
    {
        h = i1;
    }

    public void b(int i1, int j1)
    {
        j = i1;
        k = j1;
    }

    public void b(String s)
    {
        s = s.toLowerCase(Locale.US);
        if (s.equals("left"))
        {
            a(AlignType.a);
            return;
        }
        if (s.equals("center"))
        {
            a(AlignType.b);
            return;
        }
        if (s.equals("right"))
        {
            a(AlignType.c);
            return;
        } else
        {
            a(AlignType.a);
            return;
        }
    }

    private class AlignType extends Enum
    {

        public static final AlignType a;
        public static final AlignType b;
        public static final AlignType c;
        private static final AlignType d[];

        public static AlignType valueOf(String s)
        {
            return (AlignType)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/collageComposer/CollageTextPainter$AlignType, s);
        }

        public static AlignType[] values()
        {
            return (AlignType[])d.clone();
        }

        static 
        {
            a = new AlignType("Left", 0);
            b = new AlignType("Center", 1);
            c = new AlignType("Right", 2);
            d = (new AlignType[] {
                a, b, c
            });
        }

        private AlignType(String s, int i1)
        {
            super(s, i1);
        }
    }

}
