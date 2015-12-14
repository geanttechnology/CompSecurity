// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bq;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.TypedValue;

// Referenced classes of package myobfuscated.bq:
//            b

public final class a
{

    private static float b;
    private static int c;
    private static int d;
    private static int e;
    private static float f;
    private static final int g = Color.argb(128, 0, 0, 0);
    public int a;
    private PointF h;
    private Paint i;
    private final b j;
    private float k;
    private float l;

    public a(Resources resources, b b1)
    {
        h = new PointF();
        i = new Paint();
        j = b1;
        i.setStyle(android.graphics.Paint.Style.STROKE);
        i.setAntiAlias(true);
        b = (int)TypedValue.applyDimension(1, 75F, resources.getDisplayMetrics());
        c = (int)TypedValue.applyDimension(1, 15F, resources.getDisplayMetrics());
        d = (int)TypedValue.applyDimension(1, 20F, resources.getDisplayMetrics());
        e = (int)TypedValue.applyDimension(1, 22F, resources.getDisplayMetrics());
        f = (int)TypedValue.applyDimension(1, 2.0F, resources.getDisplayMetrics());
        float f1 = resources.getDisplayMetrics().widthPixels;
        float f2 = resources.getDisplayMetrics().heightPixels;
        k = f1 / 2.0F;
        l = f2 / 2.0F;
    }

    public final void a(float f1, float f2)
    {
        k = f1;
        l = f2;
    }

    public final void a(int i1, float f1, float f2)
    {
        switch (i1)
        {
        case 1: // '\001'
        default:
            return;

        case 0: // '\0'
        case 2: // '\002'
            k = f1;
            break;
        }
        l = f2;
        a = j.a((int)f1, (int)f2);
    }

    public final void a(Canvas canvas)
    {
        canvas.translate(k, l);
        i.setStrokeWidth(e);
        i.setColor(g);
        canvas.drawCircle(h.x, h.y, b, i);
        i.setStrokeWidth(d);
        i.setColor(-1);
        canvas.drawCircle(h.x, h.y, b, i);
        i.setStrokeWidth(c);
        i.setColor(a);
        canvas.drawCircle(h.x, h.y, b, i);
        i.setStrokeWidth(f);
        i.setColor(g);
        float f1 = h.x;
        float f2 = b / 6F;
        float f3 = h.y;
        float f4 = h.x;
        canvas.drawLine(f1 - f2, f3, b / 6F + f4, h.y, i);
        f1 = h.x;
        f2 = h.y;
        f3 = b / 6F;
        f4 = h.x;
        float f5 = h.y;
        canvas.drawLine(f1, f2 - f3, f4, b / 6F + f5, i);
    }

}
