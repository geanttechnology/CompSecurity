// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

// Referenced classes of package netswipe:
//            bu

class bx
{

    final bu a;
    private Paint b;
    private String c[];
    private float d;
    private float e;

    public bx(bu bu)
    {
        a = bu;
        super();
        b = null;
        c = null;
        d = 0.0F;
        e = 0.0F;
        b = new Paint();
        b.setAntiAlias(true);
    }

    public float a()
    {
        return b.getTextSize();
    }

    public void a(float f)
    {
        b.setTextScaleX(f);
    }

    public void a(float f, float f1)
    {
        d = f;
        e = f1;
    }

    public void a(int i)
    {
        b.setColor(i);
    }

    public void a(Canvas canvas)
    {
        if (c != null)
        {
            int j = (int)a();
            int k = ((c.length - 1) * j) / 2;
            for (int i = 0; i < c.length; i++)
            {
                canvas.drawText(c[i], d, (e - (float)k) + (float)(i * j), b);
            }

        }
    }

    public void a(android.graphics.Paint.Style style)
    {
        b.setStyle(style);
    }

    public void a(Typeface typeface)
    {
        b.setTypeface(typeface);
    }

    public void a(String s)
    {
        c = s.split("\n");
    }

    public float b()
    {
        float f2 = 0.0F;
        float f = 0.0F;
        float f1 = f2;
        if (c != null)
        {
            f1 = f2;
            if (c.length != 0)
            {
                int i = 0;
                do
                {
                    f1 = f;
                    if (i >= c.length)
                    {
                        break;
                    }
                    float f3 = b.measureText(c[i]);
                    f1 = f;
                    if (f3 > f)
                    {
                        f1 = f3;
                    }
                    i++;
                    f = f1;
                } while (true);
            }
        }
        return f1;
    }

    public void b(float f)
    {
        b.setTextSize(f);
    }

    public void b(int i)
    {
        b.setShadowLayer(1.0F, 1.0F, 1.0F, i);
    }
}
