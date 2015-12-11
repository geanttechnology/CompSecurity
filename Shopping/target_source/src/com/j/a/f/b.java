// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.f;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import com.j.a.g.o;
import com.j.a.g.t;

// Referenced classes of package com.j.a.f:
//            c

public class b extends ShapeDrawable
{

    private final Paint a = new Paint(getPaint());
    private final Paint b;
    private final int c;

    public b(int i, float f)
    {
        super(new RectShape());
        c = o.a(f);
        a.setColor(0);
        b = new Paint(a);
        Paint paint = new Paint(a);
        paint.setStyle(android.graphics.Paint.Style.FILL);
        paint.setColor(i);
        b.setStyle(android.graphics.Paint.Style.FILL);
        b.setStrokeWidth(f);
        b.setColor(i);
    }

    public static int a()
    {
        return 0x17ccbc36;
    }

    public static String a(t t1)
    {
        switch (c.a[t1.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return "View Selection Mode";

        case 2: // '\002'
            return "Navigate to desired activity or screen";

        case 3: // '\003'
            return "Choose a button to track clicks.";
        }
    }

    public static int b()
    {
        return 0x17ccbc35;
    }

    public static String b(t t1)
    {
        switch (c.a[t1.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return "Tap any view.";

        case 2: // '\002'
            return "Press the button on Taplytics when you've arrived";
        }
    }

    public static int c()
    {
        return 0x17ccbc34;
    }

    public static int d()
    {
        return 0x17ccbc33;
    }

    protected void onDraw(Shape shape, Canvas canvas, Paint paint)
    {
        int i = o.a(35F);
        int j = canvas.getWidth();
        int k = canvas.getHeight();
        paint = new Rect(0, 0, j, i);
        Rect rect = new Rect(0, i, c, k - c);
        Rect rect1 = new Rect(j - c, i, j, k - c);
        Rect rect2 = new Rect(0, k - c, j, k);
        shape.draw(canvas, a);
        canvas.drawRect(paint, b);
        canvas.drawRect(rect, b);
        canvas.drawRect(rect1, b);
        canvas.drawRect(rect2, b);
    }
}
