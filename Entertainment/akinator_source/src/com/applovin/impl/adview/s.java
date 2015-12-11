// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

// Referenced classes of package com.applovin.impl.adview:
//            t

public class s extends View
{

    private final int A;
    protected Paint a;
    protected Paint b;
    private Paint c;
    private Paint d;
    private RectF e;
    private float f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private float l;
    private int m;
    private String n;
    private String o;
    private float p;
    private String q;
    private float r;
    private final float s;
    private final int t;
    private final int u;
    private final int v;
    private final int w;
    private final int x;
    private final float y;
    private final float z;

    public s(Context context)
    {
        this(context, null);
    }

    public s(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public s(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        e = new RectF();
        i = 0;
        n = "";
        o = "";
        q = "";
        t = Color.rgb(66, 145, 241);
        u = Color.rgb(66, 145, 241);
        v = Color.rgb(66, 145, 241);
        w = 0;
        x = 100;
        y = com.applovin.impl.adview.t.b(getResources(), 14F);
        A = (int)com.applovin.impl.adview.t.a(getResources(), 100F);
        s = com.applovin.impl.adview.t.a(getResources(), 4F);
        z = com.applovin.impl.adview.t.b(getResources(), 18F);
        b();
        a();
    }

    private int e(int i1)
    {
        int j1 = android.view.View.MeasureSpec.getMode(i1);
        i1 = android.view.View.MeasureSpec.getSize(i1);
        if (j1 == 0x40000000)
        {
            return i1;
        }
        int k1 = A;
        if (j1 == 0x80000000)
        {
            return Math.min(k1, i1);
        } else
        {
            return k1;
        }
    }

    private float o()
    {
        return ((float)d() / (float)j) * 360F;
    }

    protected void a()
    {
        a = new TextPaint();
        a.setColor(g);
        a.setTextSize(f);
        a.setAntiAlias(true);
        b = new TextPaint();
        b.setColor(h);
        b.setTextSize(p);
        b.setAntiAlias(true);
        c = new Paint();
        c.setColor(k);
        c.setStyle(android.graphics.Paint.Style.STROKE);
        c.setAntiAlias(true);
        c.setStrokeWidth(l);
        d = new Paint();
        d.setColor(m);
        d.setAntiAlias(true);
    }

    public void a(float f1)
    {
        l = f1;
        invalidate();
    }

    public void a(int i1)
    {
        i = i1;
        if (i > e())
        {
            i = i % e();
        }
        invalidate();
    }

    protected void b()
    {
        k = t;
        g = u;
        f = y;
        b(100);
        a(0);
        l = s;
        m = 0;
        p = z;
        h = v;
    }

    public void b(float f1)
    {
        f = f1;
        invalidate();
    }

    public void b(int i1)
    {
        if (i1 > 0)
        {
            j = i1;
            invalidate();
        }
    }

    public float c()
    {
        return l;
    }

    public void c(int i1)
    {
        g = i1;
        invalidate();
    }

    public int d()
    {
        return i;
    }

    public void d(int i1)
    {
        k = i1;
        invalidate();
    }

    public int e()
    {
        return j;
    }

    public float f()
    {
        return f;
    }

    public int g()
    {
        return g;
    }

    public int h()
    {
        return k;
    }

    public String i()
    {
        return o;
    }

    public void invalidate()
    {
        a();
        super.invalidate();
    }

    public String j()
    {
        return n;
    }

    public int k()
    {
        return m;
    }

    public String l()
    {
        return q;
    }

    public float m()
    {
        return p;
    }

    public int n()
    {
        return h;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        float f1 = l;
        e.set(f1, f1, (float)getWidth() - f1, (float)getHeight() - f1);
        f1 = (((float)getWidth() - l) + l) / 2.0F;
        canvas.drawCircle((float)getWidth() / 2.0F, (float)getHeight() / 2.0F, f1, d);
        canvas.drawArc(e, 270F, -o(), false, c);
        String s1 = (new StringBuilder()).append(n).append(i).append(o).toString();
        if (!TextUtils.isEmpty(s1))
        {
            float f2 = a.descent();
            float f4 = a.ascent();
            canvas.drawText(s1, ((float)getWidth() - a.measureText(s1)) / 2.0F, ((float)getWidth() - (f2 + f4)) / 2.0F, a);
        }
        if (!TextUtils.isEmpty(l()))
        {
            b.setTextSize(p);
            float f3 = getHeight();
            float f5 = r;
            float f6 = (a.descent() + a.ascent()) / 2.0F;
            canvas.drawText(l(), ((float)getWidth() - b.measureText(l())) / 2.0F, f3 - f5 - f6, b);
        }
    }

    protected void onMeasure(int i1, int j1)
    {
        setMeasuredDimension(e(i1), e(j1));
        r = getHeight() - (getHeight() * 3) / 4;
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        if (parcelable instanceof Bundle)
        {
            parcelable = (Bundle)parcelable;
            g = parcelable.getInt("text_color");
            f = parcelable.getFloat("text_size");
            p = parcelable.getFloat("inner_bottom_text_size");
            q = parcelable.getString("inner_bottom_text");
            h = parcelable.getInt("inner_bottom_text_color");
            k = parcelable.getInt("finished_stroke_color");
            l = parcelable.getFloat("finished_stroke_width");
            m = parcelable.getInt("inner_background_color");
            a();
            b(parcelable.getInt("max"));
            a(parcelable.getInt("progress"));
            n = parcelable.getString("prefix");
            o = parcelable.getString("suffix");
            super.onRestoreInstanceState(parcelable.getParcelable("saved_instance"));
            return;
        } else
        {
            super.onRestoreInstanceState(parcelable);
            return;
        }
    }

    protected Parcelable onSaveInstanceState()
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("saved_instance", super.onSaveInstanceState());
        bundle.putInt("text_color", g());
        bundle.putFloat("text_size", f());
        bundle.putFloat("inner_bottom_text_size", m());
        bundle.putFloat("inner_bottom_text_color", n());
        bundle.putString("inner_bottom_text", l());
        bundle.putInt("inner_bottom_text_color", n());
        bundle.putInt("finished_stroke_color", h());
        bundle.putInt("max", e());
        bundle.putInt("progress", d());
        bundle.putString("suffix", i());
        bundle.putString("prefix", j());
        bundle.putFloat("finished_stroke_width", c());
        bundle.putInt("inner_background_color", k());
        return bundle;
    }
}
