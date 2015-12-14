// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class bkj
{

    public Bitmap a;
    public int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private Paint g;

    public bkj(Bitmap bitmap)
    {
        a = bitmap;
        g = new Paint();
        g.setDither(true);
        g.setFilterBitmap(true);
    }

    public int a()
    {
        return c;
    }

    public void a(int i)
    {
        b = i;
    }

    public void a(Canvas canvas)
    {
label0:
        {
            if (c > 0 && d > 0)
            {
                if (a != null)
                {
                    break label0;
                }
                new Rect(0, 0, c, d);
                canvas.drawColor(b);
            }
            return;
        }
        Rect rect = new Rect(0, 0, c, d);
        f = a.getHeight();
        e = a.getWidth();
        Rect rect1 = new Rect(0, 0, c, d);
        canvas.drawBitmap(a, rect, rect1, g);
    }

    public int b()
    {
        return d;
    }

    public void b(int i)
    {
        c = i;
    }

    public void c(int i)
    {
        d = i;
    }
}
