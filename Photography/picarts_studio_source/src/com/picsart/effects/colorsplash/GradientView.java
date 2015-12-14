// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.colorsplash;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

public class GradientView extends View
{

    private Shader a;
    private Paint b;
    private float c;
    private float d;

    public GradientView(Context context)
    {
        super(context);
        b = new Paint();
        c = -30F;
        d = 330F;
    }

    public GradientView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b = new Paint();
        c = -30F;
        d = 330F;
    }

    public GradientView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        b = new Paint();
        c = -30F;
        d = 330F;
    }

    private void a(int i)
    {
        float f2 = (d - c) / 12F;
        int ai[] = new int[13];
        float f = c;
        float af[] = new float[3];
        af[1] = 1.0F;
        af[2] = 1.0F;
        int j = 0;
        while (j <= 12) 
        {
            float f1;
            if (f < 0.0F)
            {
                f1 = f + 360F;
            } else
            if (f > 360F)
            {
                f1 = f - 360F;
            } else
            {
                f1 = f;
            }
            af[0] = f1;
            ai[j] = Color.HSVToColor(af);
            f += f2;
            j++;
        }
        a = new LinearGradient(0.0F, 0.0F, i, 0.0F, ai, null, android.graphics.Shader.TileMode.CLAMP);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (a == null)
        {
            a(getWidth());
        }
        if (a != null)
        {
            b.setShader(a);
            canvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), b);
        }
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        a(i);
        invalidate();
    }

    public void setMaxHue(float f)
    {
        d = f;
        a = null;
        invalidate();
    }

    public void setMinHue(float f)
    {
        c = f;
        a = null;
        invalidate();
    }

    public void setMinMaxHue(float f, float f1)
    {
        c = f;
        d = f1;
        a = null;
        invalidate();
    }
}
