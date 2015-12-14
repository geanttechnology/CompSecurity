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

public class BlueBarView extends View
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

    public BlueBarView(Context context)
    {
        this(context, null);
    }

    public BlueBarView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public BlueBarView(Context context, AttributeSet attributeset, int i)
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
        int i = Color.rgb(Color.red(h.b), Color.green(h.b), 0);
        int j = Color.rgb(Color.red(h.b), Color.green(h.b), 255);
        g = new LinearGradient(a.left, a.top, a.right, a.bottom, i, j, android.graphics.Shader.TileMode.CLAMP);
        e.setShader(g);
    }

    private void c()
    {
        c = Math.round(((float)Color.blue(h.b) * a.width()) / 255F + a.left);
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
        b();
        c();
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
        int i = Math.round(((f1 - a.left) * 255F) / a.width());
        h.c(i);
        c = f1;
        invalidate();
_L2:
        return true;
_L4:
        f1 = f2;
        if (f2 < a.left)
        {
            f1 = a.left;
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
