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

public class xm extends Drawable
{

    private Context a;
    private Drawable b;
    private Drawable c;
    private Drawable d;
    private boolean e;
    private Paint f;

    public xm(Context context)
    {
        e = false;
        f = new Paint();
        f.setARGB(200, 50, 50, 50);
        f.setStrokeWidth(1.0F);
        f.setStyle(android.graphics.Paint.Style.STROKE);
        f.setAntiAlias(true);
        f.setColor(-1);
        a = context;
        f();
    }

    private void f()
    {
        b = a.getResources().getDrawable(0x7f02044e);
        c = a.getResources().getDrawable(0x7f02044d);
        d = a.getResources().getDrawable(0x7f02044f);
    }

    public int a()
    {
        return c.getIntrinsicWidth();
    }

    public void a(boolean flag)
    {
        e = flag;
    }

    public int b()
    {
        return c.getIntrinsicHeight();
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
        int k1 = getBounds().top;
        int i2 = getBounds().right;
        int k2 = getBounds().bottom;
        int i = i1 + b.getIntrinsicWidth() / 2;
        int j = k1 + b.getIntrinsicHeight() / 2;
        int k = i2 - b.getIntrinsicWidth() / 2;
        int l = k2 - b.getIntrinsicHeight() / 2;
        int i3 = k - i;
        int j3 = l - j;
        canvas.drawRect(new Rect(i, j, k, l), f);
        canvas.drawLine(i3 / 3 + i, j, i3 / 3 + i, l, f);
        canvas.drawLine((i3 * 2) / 3 + i, j, (i3 * 2) / 3 + i, l, f);
        canvas.drawLine(i, j3 / 3 + j, k, j3 / 3 + j, f);
        canvas.drawLine(i, (j3 * 2) / 3 + j, k, (j3 * 2) / 3 + j, f);
        b.setBounds(i1, k1, b.getIntrinsicWidth() + i1, b.getIntrinsicHeight() + k1);
        b.draw(canvas);
        b.setBounds(i2 - b.getIntrinsicWidth(), k1, i2, b.getIntrinsicHeight() + k1);
        b.draw(canvas);
        b.setBounds(i1, k2 - b.getIntrinsicHeight(), b.getIntrinsicWidth() + i1, k2);
        b.draw(canvas);
        b.setBounds(i2 - b.getIntrinsicWidth(), k2 - b.getIntrinsicHeight(), i2, k2);
        b.draw(canvas);
        if (e)
        {
            int j1 = (i + k) / 2;
            int l1 = (j + l) / 2;
            int j2 = a() / 3;
            int l2 = b() / 3;
            c.setBounds(j1 - j2, j - l2, j1 + j2, j + l2);
            c.draw(canvas);
            c.setBounds(j1 - j2, l - l2, j1 + j2, l + l2);
            c.draw(canvas);
            d.setBounds(i - l2, l1 - j2, i + l2, l1 + j2);
            d.draw(canvas);
            d.setBounds(k - l2, l1 - j2, l2 + k, l1 + j2);
            d.draw(canvas);
        }
    }

    public boolean e()
    {
        return e;
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
        super.setBounds(new Rect(rect.left - b.getIntrinsicWidth() / 2, rect.top - b.getIntrinsicHeight() / 2, rect.right + b.getIntrinsicWidth() / 2, rect.bottom + b.getIntrinsicHeight() / 2));
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
    }
}
