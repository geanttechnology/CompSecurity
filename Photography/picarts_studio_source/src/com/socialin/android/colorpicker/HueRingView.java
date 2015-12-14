// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.colorpicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import myobfuscated.bf.a;

// Referenced classes of package com.socialin.android.colorpicker:
//            b, a

public class HueRingView extends View
    implements b
{

    private static final int a[] = {
        0xffff0000, -65281, 0xff0000ff, 0xff00ffff, 0xff00ff00, -256, 0xffff0000
    };
    private double b;
    private float c;
    private float d;
    private float e;
    private Paint f;
    private Paint g;
    private Paint h;
    private float i[];
    private com.socialin.android.colorpicker.a j;

    public HueRingView(Context context)
    {
        this(context, null);
    }

    public HueRingView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public HueRingView(Context context, AttributeSet attributeset, int k)
    {
        super(context, attributeset, k);
        b = 0.0D;
        i = new float[2];
        context = context.getTheme().obtainStyledAttributes(attributeset, a.HueRingView, 0, 0);
        e = context.getDimensionPixelSize(a.HueRingView_hue_pointer_radius, 20);
        c = context.getDimensionPixelSize(a.HueRingView_ring_thickness, 40);
        context.recycle();
        f = new Paint(1);
        context = new SweepGradient(0.0F, 0.0F, a, null);
        f.setStyle(android.graphics.Paint.Style.STROKE);
        f.setShader(context);
        f.setStrokeWidth(c);
        g = new Paint(1);
        g.setColor(-1);
        g.setStyle(android.graphics.Paint.Style.STROKE);
        g.setStrokeWidth(2.0F);
        h = new Paint(1);
        h.setColor(0xff000000);
        h.setStyle(android.graphics.Paint.Style.STROKE);
        h.setStrokeWidth(2.0F);
        return;
        attributeset;
        context.recycle();
        throw attributeset;
    }

    private float[] a(double d1)
    {
        d1 = Math.toRadians(d1);
        return (new float[] {
            (float)Math.round(Math.cos(d1) * (double)d), (float)Math.round(Math.sin(d1) * (double)d)
        });
    }

    public final void a()
    {
        i = a(-j.a());
        invalidate();
    }

    protected void onDraw(Canvas canvas)
    {
        canvas.translate((float)getWidth() / 2.0F, (float)getHeight() / 2.0F);
        canvas.drawCircle(0.0F, 0.0F, d, f);
        canvas.drawCircle(i[0], i[1], e, g);
        canvas.drawCircle(i[0], i[1], e - 2.0F, h);
    }

    protected void onSizeChanged(int k, int l, int i1, int j1)
    {
        super.onSizeChanged(k, l, i1, j1);
        if (k >= l)
        {
            d = (float)l / 2.0F - (float)getPaddingLeft() - (float)getPaddingRight() - Math.max(e, c / 2.0F);
        } else
        {
            d = (float)k / 2.0F - (float)getPaddingLeft() - (float)getPaddingRight() - Math.max(e, c / 2.0F);
        }
        i = a(-j.a());
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        float f1 = motionevent.getX();
        float f2 = motionevent.getY();
        double d1 = f1 - (float)getWidth() / 2.0F;
        b = Math.toDegrees(Math.atan2(f2 - (float)getHeight() / 2.0F, d1));
        if (motionevent.getActionMasked() == 0 || motionevent.getActionMasked() == 2)
        {
            i = a(b);
            double d2;
            if (j.c() == 0.0F)
            {
                j.c(1.0F);
                j.b(1.0F);
            } else
            if (j.b() == 0.0F)
            {
                j.c(1.0F);
                j.b(1.0F);
            }
            motionevent = j;
            d2 = b;
            if (d2 <= 0.0D)
            {
                d2 = Math.abs(d2);
            } else
            {
                d2 = Math.abs(d2 - 360D);
            }
            motionevent.a((float)d2);
            invalidate();
        }
        return true;
    }

    public void setColorData(com.socialin.android.colorpicker.a a1)
    {
        j = a1;
        j.a(this);
    }

}
