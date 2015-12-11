// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

// Referenced classes of package jumiomobile:
//            mp, hq, bg, hp

public class ni extends mp
{

    private int A;
    private int B;
    private int u;
    private Paint v;
    private Paint w;
    private Paint x;
    private Rect y;
    private Rect z;

    public ni(Context context, hp hp1, hq hq1)
    {
        super(context, hp1);
        int i;
        if (hq1 == hq.c)
        {
            i = 3;
        } else
        {
            i = 2;
        }
        u = i;
        B = (int)bg.a(getContext(), 15F);
        A = (int)bg.a(getContext(), 2.0F);
        v = new Paint();
        v.setColor(0xff97be0d);
        v.setStyle(android.graphics.Paint.Style.STROKE);
        v.setDither(true);
        v.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        v.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        v.setAntiAlias(true);
        v.setStrokeWidth(A);
        w = new Paint();
        w.setColor(0xff97be0d);
        w.setStyle(android.graphics.Paint.Style.STROKE);
        w.setDither(true);
        w.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        w.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        w.setAntiAlias(true);
        w.setStrokeWidth((int)bg.a(getContext(), 1.0F));
        x = new Paint();
        x.setColor(0xff97be0d);
        x.setStyle(android.graphics.Paint.Style.FILL);
        x.setAlpha(64);
    }

    public int a(int i)
    {
        int j = y.bottom;
        int k = y.top;
        return y.top - (i - (j - k)) / 2;
    }

    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.drawRect(z, v);
        canvas.drawRect(z, x);
        float f = (float)(y.bottom - y.top) / (float)u;
        for (int i = 1; i < u; i++)
        {
            float f1 = (float)y.top + (float)i * f;
            canvas.drawLine(y.left + B, f1, y.right - B, f1, w);
        }

    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        i = d - a.f(m);
        j = i - a.e(m);
        k = A / 2;
        y = new Rect(e, j, f, i);
        z = new Rect(e + k, j - k, f - k, i - k);
    }
}
