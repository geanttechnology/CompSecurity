// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.intentsoftware.addapptr.fullscreens;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class CloseDrawable extends Drawable
{

    private static int SHADOW_COLORS[] = {
        0x88000000, 0x88000000, 0
    };
    private static float SHADOW_POSITIONS[] = {
        0.0F, 0.8F, 1.0F
    };
    boolean enabled;

    public CloseDrawable(boolean flag)
    {
        enabled = flag;
    }

    public void draw(Canvas canvas)
    {
        Object obj = getBounds();
        float f = ((Rect) (obj)).height();
        float f1 = ((Rect) (obj)).width();
        float f3 = (f1 + f) * 0.5F;
        float f2 = f3 * 0.5F;
        f3 = f3 * 0.85F * 0.5F;
        float f4 = f3 * 0.2F;
        float f5 = f4 * 0.55F;
        float f6 = f4 * 1.5F;
        int i;
        int j;
        int k;
        if (enabled)
        {
            i = -1;
            j = 0xff000000;
        } else
        {
            i = 0xff000000;
            j = -1;
        }
        k = canvas.save();
        canvas.translate(f1 / 2.0F, f / 2.0F);
        obj = new Paint();
        ((Paint) (obj)).setFlags(1);
        ((Paint) (obj)).setShader(new RadialGradient(0.0F, 0.0F, f2, SHADOW_COLORS, SHADOW_POSITIONS, android.graphics.Shader.TileMode.CLAMP));
        canvas.drawCircle(0.0F, 0.0F, f2, ((Paint) (obj)));
        ((Paint) (obj)).setShader(null);
        ((Paint) (obj)).setColor(i);
        ((Paint) (obj)).setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        canvas.drawCircle(0.0F, 0.0F, f3, ((Paint) (obj)));
        ((Paint) (obj)).setColor(j);
        canvas.drawCircle(0.0F, 0.0F, f3 - f4, ((Paint) (obj)));
        ((Paint) (obj)).setColor(i);
        ((Paint) (obj)).setPathEffect(new CornerPathEffect(f5 * 0.75F));
        canvas.rotate(45F, 0.0F, 0.0F);
        canvas.drawRect(-f5, -f3 + f6, f5, f3 - f6, ((Paint) (obj)));
        canvas.drawRect(-f3 + f6, -f5, f3 - f6, f5, ((Paint) (obj)));
        canvas.restoreToCount(k);
    }

    public int getOpacity()
    {
        return 0;
    }

    public void setAlpha(int i)
    {
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
    }

}
