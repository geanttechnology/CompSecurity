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
import com.instabeauty.application.InstaBeautyApplication;

public class alk extends Drawable
{

    final int a = 44;
    private Context b;
    private Drawable c;
    private Drawable d;
    private int e;
    private int f;
    private boolean g;
    private Paint h;
    private Paint i;
    private Paint j;
    private boolean k;

    public alk(Context context)
    {
        g = true;
        h = new Paint();
        i = new Paint();
        j = new Paint();
        k = false;
        h.setARGB(90, 50, 50, 50);
        h.setStrokeWidth(1.0F);
        h.setStyle(android.graphics.Paint.Style.STROKE);
        h.setAntiAlias(true);
        h.setColor(-1);
        i.setARGB(80, 0, 0, 255);
        j.setTextSize(yp.c(InstaBeautyApplication.a, 12F));
        j.setColor(-1);
        b = context;
        f();
    }

    private void f()
    {
        c = b.getResources().getDrawable(0x7f020175);
        d = b.getResources().getDrawable(0x7f020176);
    }

    public int a()
    {
        int l;
        if (g)
        {
            l = getBounds().top;
        } else
        {
            l = getBounds().left;
        }
        if (e < f)
        {
            return e - l;
        } else
        {
            return f - l;
        }
    }

    public int a(Context context, float f1)
    {
        return (int)(context.getResources().getDisplayMetrics().density * f1 + 0.5F);
    }

    public void a(int l)
    {
        e = l;
        e();
    }

    public void a(boolean flag)
    {
        g = flag;
        if (g)
        {
            e = (int)((double)getBounds().top + (double)(getBounds().bottom - getBounds().top) * 0.55000000000000004D);
            f = (int)((double)getBounds().top + (double)(getBounds().bottom - getBounds().top) * 0.84999999999999998D);
        }
        e();
    }

    public int b()
    {
        int l;
        if (g)
        {
            l = getBounds().top;
        } else
        {
            l = getBounds().left;
        }
        if (e > f)
        {
            return e - l;
        } else
        {
            return f - l;
        }
    }

    public void b(int l)
    {
        f = l;
        e();
    }

    public void b(boolean flag)
    {
        k = flag;
    }

    public Rect c()
    {
        return new Rect(0, e - a(b, 44F) / 2, getBounds().right + getBounds().left, e + a(b, 44F) / 2);
    }

    public void c(int l)
    {
        e = e + l;
        e();
    }

    public Rect d()
    {
        return new Rect(0, f - a(b, 44F) / 2, getBounds().right + getBounds().left, f + a(b, 44F) / 2);
    }

    public void d(int l)
    {
        f = f + l;
        e();
    }

    public void draw(Canvas canvas)
    {
        int l = getBounds().left;
        int i1 = getBounds().right;
        if (k)
        {
            String s = b.getResources().getString(0x7f060030);
            float f1 = j.measureText(s, 0, s.length());
            float f2 = j.descent() - j.ascent();
            canvas.drawRect(new Rect(l, e, i1, f), i);
            if ((float)Math.abs(f - e) >= f2)
            {
                canvas.drawText(s, ((float)(i1 + l) - f1) / 2.0F, ((float)(e + f) - f2) / 2.0F - j.ascent(), j);
            }
        }
        if (g)
        {
            canvas.drawLine(l, e, (i1 - a(b, 44F)) + a(b, 12F), e, h);
            canvas.drawLine(l, f, (i1 - a(b, 44F)) + a(b, 12F), f, h);
            c.setBounds((i1 - a(b, 44F)) + a(b, 6F), e - a(b, 44F) / 2, a(b, 6F) + i1, e + a(b, 44F) / 2);
            c.draw(canvas);
            d.setBounds((i1 - a(b, 44F)) + a(b, 6F), f - a(b, 44F) / 2, a(b, 6F) + i1, f + a(b, 44F) / 2);
            d.draw(canvas);
        }
    }

    public void e()
    {
        if (g)
        {
            c = b.getResources().getDrawable(0x7f020175);
            d = b.getResources().getDrawable(0x7f020176);
            if (e > f)
            {
                c = b.getResources().getDrawable(0x7f020176);
                d = b.getResources().getDrawable(0x7f020175);
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
        }
    }

    public int getOpacity()
    {
        return 0;
    }

    public void setAlpha(int l)
    {
    }

    public void setBounds(Rect rect)
    {
        super.setBounds(new Rect(rect.left, rect.top, rect.right, rect.bottom));
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
    }
}
