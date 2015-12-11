// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            ad, bv

public class af extends View
{

    boolean a;
    TextPaint b;
    String c;
    bv d;
    Drawable e;
    Drawable f;
    int g;
    int h;
    float i;

    public af(Context context, String s, int j, bv bv1, Drawable drawable, Drawable drawable1)
    {
        super(context);
        c = s;
        a = false;
        d = bv1;
        e = drawable;
        f = drawable1;
        h = drawable.getIntrinsicHeight();
        i = ad.H();
        a(d.a(bv.c.a), d.a(bv.c.b));
        g = Math.max(80, Math.round(b.measureText(c)) + 4);
        a();
    }

    public af(Context context, String s, bv bv1, bv.d d1, bv.d d2)
    {
        super(context);
        c = s;
        a = false;
        d = bv1;
        context = d.a(d1);
        e = new BitmapDrawable(context);
        f = new BitmapDrawable(d.a(d2));
        g = context.getWidth();
        h = context.getHeight();
        i = ad.E();
        a(bv1.a(bv.c.j), Color.argb(0, 0, 0, 0));
        a();
    }

    private void a()
    {
        setBackgroundDrawable(e);
        setOnTouchListener(new android.view.View.OnTouchListener() {

            final af a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 1 || motionevent.getAction() == 3)
                {
                    a.a = false;
                } else
                {
                    a.a = true;
                }
                af.a(a);
                view.invalidate();
                return false;
            }

            
            {
                a = af.this;
                super();
            }
        });
        setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            final af a;

            public void onFocusChange(View view, boolean flag)
            {
                a.a = flag;
                af.a(a);
                view.invalidate();
            }

            
            {
                a = af.this;
                super();
            }
        });
        setOnKeyListener(new android.view.View.OnKeyListener() {

            final af a;

            public boolean onKey(View view, int j, KeyEvent keyevent)
            {
                if (j == 23)
                {
                    a.a = true;
                    af.a(a);
                    view.invalidate();
                }
                return false;
            }

            
            {
                a = af.this;
                super();
            }
        });
    }

    private void a(int j, int k)
    {
        b = new TextPaint();
        b.setTextSize(i);
        b.setColor(j);
        b.setTypeface(Typeface.create("helvetica", 1));
        b.setAntiAlias(true);
        if (Color.alpha(k) > 0)
        {
            b.setShadowLayer(5F, 0.0F, 0.0F, d.a(bv.c.b));
        }
    }

    static void a(af af1)
    {
        af1.b();
    }

    private void b()
    {
        if (a)
        {
            setBackgroundDrawable(f);
            return;
        } else
        {
            setBackgroundDrawable(e);
            return;
        }
    }

    public void a(String s)
    {
        c = s;
        invalidate();
    }

    public void a(boolean flag)
    {
        if (a != flag)
        {
            a = flag;
            b();
            invalidate();
        }
    }

    protected void onDraw(Canvas canvas)
    {
        Rect rect = new Rect();
        b.getTextBounds(c, 0, c.length(), rect);
        int j = Math.round((g - rect.width()) / 2);
        int k = Math.round((h - rect.height()) / 2);
        canvas.drawText(c, j, rect.height() + k, b);
    }

    protected void onMeasure(int j, int k)
    {
        setMeasuredDimension(g, h);
    }
}
