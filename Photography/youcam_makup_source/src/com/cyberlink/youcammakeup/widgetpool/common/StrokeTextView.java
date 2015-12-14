// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.cyberlink.youcammakeup.utility.aa;

public class StrokeTextView extends View
{

    private float a;
    private int b;
    private int c;
    private String d;
    private Paint e;
    private Paint f;
    private Path g;
    private Rect h;
    private Bitmap i;

    public StrokeTextView(Context context)
    {
        super(context);
        i = null;
        b();
    }

    public StrokeTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        i = null;
        b();
    }

    public StrokeTextView(Context context, AttributeSet attributeset, int j)
    {
        super(context, attributeset, j);
        i = null;
        b();
    }

    public static Paint a()
    {
        return new Paint(195);
    }

    private void a(int j, int k)
    {
        Rect rect = new Rect();
        f.getTextBounds(d, 0, d.length(), rect);
        g.rewind();
        Paint paint = f;
        String s = d;
        j = d.length();
        float f1 = (float)(getWidth() - rect.width()) / 2.0F;
        k = getHeight();
        paint.getTextPath(s, 0, j, f1, (float)(rect.height() + k) / 2.0F, g);
        d();
    }

    private void b()
    {
        e = a();
        e.setStyle(android.graphics.Paint.Style.STROKE);
        e.setTypeface(Typeface.DEFAULT);
        e.setStrokeWidth(2.5F);
        f = a();
        f.setStyle(android.graphics.Paint.Style.FILL);
        f.setTypeface(Typeface.DEFAULT);
        g = new Path();
        h = new Rect();
        setText("");
        setTextHeightRatio(0.5F);
        setTextFillColor(0xff000000);
        setTextStrokeColor(0);
        setLayerType(1, null);
    }

    private void c()
    {
        e.setTextSize((float)getHeight() * a);
        f.setTextSize((float)getHeight() * a);
        a(getWidth(), getHeight());
    }

    private void d()
    {
        aa.a(i);
        i = null;
        if (getWidth() <= 0 || getHeight() <= 0)
        {
            return;
        } else
        {
            invalidate();
            return;
        }
    }

    protected void onDraw(Canvas canvas)
    {
        f.getTextBounds(d, 0, d.length(), h);
        canvas.drawText(d, (float)(getWidth() - h.width()) / 2.0F, (float)(getHeight() - h.height()) / 2.0F + (float)h.height(), e);
        canvas.drawText(d, (float)(getWidth() - h.width()) / 2.0F, (float)(getHeight() - h.height()) / 2.0F + (float)h.height(), f);
    }

    protected void onSizeChanged(int j, int k, int l, int i1)
    {
        super.onSizeChanged(j, k, l, i1);
        c();
    }

    public void setText(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        d = s1;
        a(getWidth(), getHeight());
    }

    public void setTextFillColor(int j)
    {
        b = j;
        f.setColor(b);
        d();
    }

    public void setTextHeightRatio(float f1)
    {
        float f2 = 1.0F;
        float f3 = 0.0F;
        if (f1 < 0.0F)
        {
            f1 = f3;
        }
        if (f1 > 1.0F)
        {
            f1 = f2;
        }
        a = f1;
        c();
    }

    public void setTextStrokeColor(int j)
    {
        c = j;
        e.setColor(c);
        d();
    }
}
