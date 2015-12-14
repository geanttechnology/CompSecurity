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

public class ajf extends Drawable
{

    private Context a;
    private Drawable b;
    private Drawable c;
    private Drawable d;
    private Drawable e;
    private Drawable f;
    private boolean g;
    private Paint h;
    private Paint i;
    private Paint j;
    private int k;
    private int l;

    public ajf(Context context)
    {
        g = false;
        h = new Paint();
        h.setARGB(200, 50, 50, 50);
        h.setStrokeWidth(1.0F);
        h.setStyle(android.graphics.Paint.Style.STROKE);
        h.setAntiAlias(true);
        h.setColor(-1);
        i = new Paint();
        i.setARGB(200, 50, 50, 50);
        i.setStrokeWidth(0.0F);
        i.setStyle(android.graphics.Paint.Style.STROKE);
        i.setAntiAlias(true);
        i.setColor(0);
        j = new Paint();
        j.setARGB(200, 50, 50, 50);
        j.setStrokeWidth(2.0F);
        j.setStyle(android.graphics.Paint.Style.STROKE);
        j.setAntiAlias(true);
        j.setColor(-1);
        k = 15;
        l = 11;
        a = context;
        f();
    }

    private void f()
    {
        b = a.getResources().getDrawable(0x7f0201da);
        c = a.getResources().getDrawable(0x7f0201da);
        d = a.getResources().getDrawable(0x7f0201db);
        e = a.getResources().getDrawable(0x7f0201d7);
        f = a.getResources().getDrawable(0x7f0201d8);
        h.setTextSize(yp.c(a, 16F));
    }

    public int a()
    {
        return getBounds().right - yp.a(a, k) - (getBounds().left + yp.a(a, k));
    }

    public void a(boolean flag)
    {
        g = flag;
    }

    public int b()
    {
        return getBounds().bottom - yp.a(a, k) - (getBounds().top + yp.a(a, k));
    }

    public int c()
    {
        return b.getIntrinsicWidth();
    }

    public int d()
    {
        return b.getIntrinsicHeight();
    }

    public void draw(Canvas canvas)
    {
        int i1 = getBounds().left;
        int j1 = getBounds().top;
        int k1 = getBounds().right;
        int l1 = getBounds().bottom;
        int i2 = i1 + b.getIntrinsicWidth() / 2;
        int j2 = j1 + b.getIntrinsicHeight() / 2;
        int k2 = k1 - b.getIntrinsicWidth() / 2;
        int l2 = l1 - b.getIntrinsicHeight() / 2;
        int i3 = k2 - i2;
        int j3 = l2 - j2;
        canvas.drawRect(new Rect(i2, j2, k2, l2), j);
        canvas.drawLine(i3 / 3 + i2, j2, i3 / 3 + i2, l2, h);
        canvas.drawLine((i3 * 2) / 3 + i2, j2, (i3 * 2) / 3 + i2, l2, h);
        canvas.drawLine(i2, j3 / 3 + j2, k2, j3 / 3 + j2, h);
        canvas.drawLine(i2, (j3 * 2) / 3 + j2, k2, (j3 * 2) / 3 + j2, h);
        b.setBounds(yp.a(a, l) + i1, yp.a(a, l) + j1, b.getIntrinsicWidth() + i1 + yp.a(a, l), b.getIntrinsicHeight() + j1 + yp.a(a, l));
        b.draw(canvas);
        d.setBounds(k1 - b.getIntrinsicWidth() - yp.a(a, l), yp.a(a, l) + j1, k1 - yp.a(a, l), b.getIntrinsicHeight() + j1 + yp.a(a, l));
        d.draw(canvas);
        e.setBounds(yp.a(a, l) + i1, l1 - b.getIntrinsicHeight() - yp.a(a, l), b.getIntrinsicWidth() + i1 + yp.a(a, l), l1 - yp.a(a, l));
        e.draw(canvas);
        f.setBounds(k1 - b.getIntrinsicWidth() - yp.a(a, l), l1 - b.getIntrinsicHeight() - yp.a(a, l), k1 - yp.a(a, l), l1 - yp.a(a, l));
        f.draw(canvas);
        if (g)
        {
            canvas.drawLine(yp.a(a, k) + i1, yp.a(a, k) + j1, k1 - yp.a(a, k), yp.a(a, k) + j1, i);
            canvas.drawLine(yp.a(a, k) + i1, l1 - yp.a(a, k), k1 - yp.a(a, k), l1 - yp.a(a, k), i);
            canvas.drawLine(yp.a(a, k) + i1, yp.a(a, k) + j1, yp.a(a, k) + i1, l1 - yp.a(a, k), i);
            canvas.drawLine(k1 - yp.a(a, k), yp.a(a, k) + j1, k1 - yp.a(a, k), l1 - yp.a(a, k), i);
        }
    }

    public boolean e()
    {
        return g;
    }

    public int getOpacity()
    {
        return 0;
    }

    public void setAlpha(int i1)
    {
    }

    public void setBounds(Rect rect)
    {
        super.setBounds(new Rect(rect.left - b.getIntrinsicWidth() / 2, rect.top - b.getIntrinsicHeight() / 2, rect.right + b.getIntrinsicWidth() / 2, rect.bottom + b.getIntrinsicHeight() / 2));
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
    }
}
