// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.drawable.shapes.OvalShape;

// Referenced classes of package android.support.v4.widget:
//            d

final class e extends OvalShape
{

    private RadialGradient a;
    private Paint b;
    private int c;
    private d d;

    public e(d d1, int i, int j)
    {
        d = d1;
        super();
        b = new Paint();
        android.support.v4.widget.d.a(d1, i);
        c = j;
        float f = c / 2;
        float f1 = c / 2;
        float f2 = android.support.v4.widget.d.a(d1);
        d1 = android.graphics.Shader.TileMode.CLAMP;
        a = new RadialGradient(f, f1, f2, new int[] {
            0x3d000000, 0
        }, null, d1);
        b.setShader(a);
    }

    public final void draw(Canvas canvas, Paint paint)
    {
        int i = d.getWidth();
        int j = d.getHeight();
        canvas.drawCircle(i / 2, j / 2, c / 2 + android.support.v4.widget.d.a(d), b);
        canvas.drawCircle(i / 2, j / 2, c / 2, paint);
    }
}
