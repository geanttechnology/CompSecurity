// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;

public class ij extends Drawable
{

    final int a = 44;
    private Context b;
    private Drawable c;
    private Drawable d;
    private int e;
    private int f;
    private boolean g;
    private Paint h;

    public ij(Context context)
    {
        g = true;
        h = new Paint();
        h.setARGB(200, 50, 50, 50);
        h.setStrokeWidth(1.0F);
        h.setStyle(android.graphics.Paint.Style.STROKE);
        h.setAntiAlias(true);
        h.setColor(-1);
        b = context;
        f();
    }

    private void f()
    {
        c = b.getResources().getDrawable(0x7f0200ad);
        d = b.getResources().getDrawable(0x7f0200ae);
    }

    public int a()
    {
        int i;
        if (g)
        {
            i = getBounds().top;
        } else
        {
            i = getBounds().left;
        }
        if (e < f)
        {
            return e - i;
        } else
        {
            return f - i;
        }
    }

    public int a(Context context, float f1)
    {
        return (int)(context.getResources().getDisplayMetrics().density * f1 + 0.5F);
    }

    public void a(int i)
    {
        e = e + i;
        e();
    }

    public void a(boolean flag)
    {
        g = flag;
        if (g)
        {
            e = getBounds().top + (getBounds().bottom - getBounds().top) / 3;
            f = getBounds().top + ((getBounds().bottom - getBounds().top) / 3) * 2;
        } else
        {
            e = getBounds().left + (getBounds().right - getBounds().left) / 3;
            f = getBounds().left + ((getBounds().right - getBounds().left) / 3) * 2;
        }
        e();
    }

    public int b()
    {
        int i;
        if (g)
        {
            i = getBounds().top;
        } else
        {
            i = getBounds().left;
        }
        if (e > f)
        {
            return e - i;
        } else
        {
            return f - i;
        }
    }

    public void b(int i)
    {
        f = f + i;
        e();
    }

    public Rect c()
    {
        if (g)
        {
            return new Rect(0, e - a(b, 44F) / 2, getBounds().right + getBounds().left, e + a(b, 44F) / 2);
        } else
        {
            return new Rect(e - a(b, 44F) / 2, 0, e + a(b, 44F) / 2, getBounds().bottom + getBounds().top);
        }
    }

    public Rect d()
    {
        if (g)
        {
            return new Rect(0, f - a(b, 44F) / 2, getBounds().right + getBounds().left, f + a(b, 44F) / 2);
        } else
        {
            return new Rect(f - a(b, 44F) / 2, 0, f + a(b, 44F) / 2, getBounds().bottom + getBounds().top);
        }
    }

    public void draw(Canvas canvas)
    {
        int i = getBounds().left;
        int j = getBounds().top;
        int k = getBounds().right;
        int l = getBounds().bottom;
        if (g)
        {
            canvas.drawLine(0.0F, e, (k + i) - a(b, 38F), e, h);
            canvas.drawLine(0.0F, f, (k + i) - a(b, 38F), f, h);
            c.setBounds((k + i) - a(b, 44F), e - a(b, 44F) / 2, k + i, e + a(b, 44F) / 2);
            c.draw(canvas);
            d.setBounds((k + i) - a(b, 44F), f - a(b, 44F) / 2, k + i, f + a(b, 44F) / 2);
            d.draw(canvas);
            return;
        } else
        {
            canvas.drawLine(e, 0.0F, e, (l + j) - a(b, 38F), h);
            canvas.drawLine(f, 0.0F, f, (l + j) - a(b, 38F), h);
            c.setBounds(e - a(b, 44F) / 2, (l + j) - a(b, 44F), e + a(b, 44F) / 2, l + j);
            c.draw(canvas);
            d.setBounds(f - a(b, 44F) / 2, (l + j) - a(b, 44F), f + a(b, 44F) / 2, j + l);
            d.draw(canvas);
            return;
        }
    }

    public void e()
    {
        if (g)
        {
            c = b.getResources().getDrawable(0x7f0200ad);
            d = b.getResources().getDrawable(0x7f0200ae);
            if (e > f)
            {
                c = b.getResources().getDrawable(0x7f0200ae);
                d = b.getResources().getDrawable(0x7f0200ad);
            }
            if (e < getBounds().top)
            {
                e = getBounds().top;
            }
            if (f < getBounds().top)
            {
                f = getBounds().top;
            }
            if (e > getBounds().bottom)
            {
                e = getBounds().bottom;
            }
            if (f > getBounds().bottom)
            {
                f = getBounds().bottom;
            }
        } else
        {
            c = b.getResources().getDrawable(0x7f0200ab);
            d = b.getResources().getDrawable(0x7f0200ac);
            if (e > f)
            {
                c = b.getResources().getDrawable(0x7f0200ac);
                d = b.getResources().getDrawable(0x7f0200ab);
            }
            if (e < getBounds().left)
            {
                e = getBounds().left;
            }
            if (f < getBounds().left)
            {
                f = getBounds().left;
            }
            if (e > getBounds().right)
            {
                e = getBounds().right;
            }
            if (f > getBounds().right)
            {
                f = getBounds().right;
                return;
            }
        }
    }

    public int getOpacity()
    {
        return 0;
    }

    public void setAlpha(int i)
    {
    }

    public void setBounds(Rect rect)
    {
        super.setBounds(new Rect(rect.left, rect.top, rect.right, rect.bottom));
        if (g)
        {
            e = getBounds().top + (getBounds().bottom - getBounds().top) / 3;
            f = getBounds().top + ((getBounds().bottom - getBounds().top) / 3) * 2;
        } else
        {
            e = getBounds().left + (getBounds().right - getBounds().left) / 3;
            f = getBounds().left + ((getBounds().right - getBounds().left) / 3) * 2;
        }
        e();
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
    }
}
