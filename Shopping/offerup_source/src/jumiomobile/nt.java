// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

public class nt
{

    private Paint a;
    private String b[];
    private float c;
    private float d;

    public nt()
    {
        a = null;
        b = null;
        c = 0.0F;
        d = 0.0F;
        a = new Paint();
        a.setAntiAlias(true);
    }

    public float a()
    {
        return a.getTextSize();
    }

    public void a(float f)
    {
        a.setTextSize(f);
    }

    public void a(float f, float f1)
    {
        c = f;
        d = f1;
    }

    public void a(int i)
    {
        a.setColor(i);
    }

    public void a(Canvas canvas)
    {
        if (b != null)
        {
            int j = (int)a();
            int k = ((b.length - 1) * j) / 2;
            for (int i = 0; i < b.length; i++)
            {
                canvas.drawText(b[i], c, (d - (float)k) + (float)(i * j), a);
            }

        }
    }

    public void a(android.graphics.Paint.Style style)
    {
        a.setStyle(style);
    }

    public void a(Typeface typeface)
    {
        a.setTypeface(typeface);
    }

    public void a(String s)
    {
        b = s.split("\n");
    }

    public float b()
    {
        float f2 = 0.0F;
        float f = 0.0F;
        float f1 = f2;
        if (b != null)
        {
            f1 = f2;
            if (b.length != 0)
            {
                int i = 0;
                do
                {
                    f1 = f;
                    if (i >= b.length)
                    {
                        break;
                    }
                    float f3 = a.measureText(b[i]);
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

    public void b(int i)
    {
        a.setAlpha(i);
    }

    public void c(int i)
    {
        a.setShadowLayer(1.0F, 1.0F, 1.0F, i);
    }
}
