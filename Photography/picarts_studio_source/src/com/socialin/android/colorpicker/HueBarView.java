// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.colorpicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.socialin.android.colorpicker:
//            b, a

public class HueBarView extends View
    implements b
{

    private RectF a;
    private float b;
    private float c;
    private float d;
    private Paint e;
    private Paint f;
    private Shader g;
    private a h;

    public HueBarView(Context context)
    {
        this(context, null);
    }

    public HueBarView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public HueBarView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        if (h == null)
        {
            h = new a();
        }
        e = new Paint(1);
        e.setShader(g);
        f = new Paint(1);
        f.setStyle(android.graphics.Paint.Style.FILL);
        f.setColor(-1);
    }

    private void b()
    {
        g = new LinearGradient(a.left, a.top, a.right, a.bottom, d(), null, android.graphics.Shader.TileMode.CLAMP);
        e.setShader(g);
    }

    private void c()
    {
        c = (h.a() * a.width()) / 360F + a.left;
    }

    private int[] d()
    {
        int ai[] = new int[361];
        float f1 = h.b();
        float f2 = h.c();
        int j = 0;
        for (int i = 0; j < 361; i++)
        {
            ai[i] = Color.HSVToColor(new float[] {
                (float)j, f1, f2
            });
            j++;
        }

        return ai;
    }

    public final void a()
    {
        if (a == null)
        {
            return;
        } else
        {
            b();
            c();
            invalidate();
            return;
        }
    }

    protected void onDraw(Canvas canvas)
    {
        canvas.drawRoundRect(a, d, d, e);
        canvas.drawCircle(c, a.centerY(), b, f);
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        d = getResources().getDimensionPixelSize(0x7f0b0043);
        b = j / 2;
        a = new RectF((float)getPaddingLeft() + b, getPaddingTop(), (float)i - b - (float)getPaddingRight(), j - getPaddingBottom());
        c();
        b();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        float f2 = motionevent.getX();
        if (motionevent.getActionMasked() != 0 && motionevent.getActionMasked() != 2) goto _L2; else goto _L1
_L1:
        if (f2 <= a.right) goto _L4; else goto _L3
_L3:
        float f1 = a.right;
_L6:
        c = f1;
        h.a(((f1 - a.left) * 360F) / a.width());
        invalidate();
_L2:
        return true;
_L4:
        f1 = f2;
        if (f2 < a.left)
        {
            f1 = a.left + 0.01F;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void setColorData(a a1)
    {
        h = a1;
        h.a(this);
    }
}
