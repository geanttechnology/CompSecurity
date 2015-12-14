// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.select;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import com.socialin.android.util.Utils;
import com.socialin.android.util.l;

// Referenced classes of package com.socialin.android.photo.select:
//            d

public final class c
{

    float A;
    float B;
    float C;
    float D;
    RectF E;
    public Bitmap F;
    int G;
    int H;
    public d I;
    private PointF J;
    private PointF K;
    private PointF L;
    Bitmap a;
    Bitmap b;
    Bitmap c;
    float d;
    float e;
    float f;
    Rect g;
    Rect h;
    Rect i;
    RectF j;
    RectF k;
    public RectF l;
    public Rect m;
    public float n;
    public PointF o;
    public Paint p;
    Paint q;
    Paint r;
    boolean s;
    int t;
    float u;
    PointF v;
    Integer w;
    public boolean x;
    public boolean y;
    RectF z;

    public c(Context context, RectF rectf, RectF rectf1, Bitmap bitmap)
    {
        d = 40F;
        e = 26.66667F;
        f = 40F;
        g = new Rect();
        h = new Rect();
        i = new Rect();
        j = new RectF();
        k = new RectF();
        l = new RectF();
        m = new Rect();
        o = new PointF(0.5F, 0.5F);
        s = true;
        J = new PointF();
        K = new PointF();
        L = new PointF();
        t = 1;
        u = 0.0F;
        v = new PointF();
        w = null;
        x = false;
        y = false;
        z = new RectF();
        A = 1.0F;
        B = 1.0F;
        C = 1.0F;
        D = 1.0F;
        E = new RectF();
        G = -1;
        H = 255;
        k.set(rectf);
        l.set(rectf);
        a(rectf1);
        if (a == null)
        {
            a = com.socialin.android.util.c.a(context.getResources(), 0x7f02024a);
            d = Utils.a(40F, context);
            g.set(0, 0, a.getWidth(), a.getHeight());
        }
        if (b == null)
        {
            b = com.socialin.android.util.c.a(context.getResources(), 0x7f02024b);
            e = Utils.a(26.66667F, context);
            h.set(0, 0, b.getWidth(), b.getHeight());
        }
        if (c == null)
        {
            c = com.socialin.android.util.c.a(context.getResources(), 0x7f02024c);
            f = Utils.a(40F, context);
            i.set(0, 0, c.getWidth(), c.getHeight());
        }
        Log.e("ex", (new StringBuilder("handleCornerSize = ")).append(d).toString());
        q = new Paint(1);
        q.setColor(-1);
        q.setStyle(android.graphics.Paint.Style.STROKE);
        q.setStrokeWidth(1.0F);
        r = new Paint(1);
        r.setColor(0x99000000);
        r.setStyle(android.graphics.Paint.Style.STROKE);
        r.setStrokeWidth(1.0F);
        p = new Paint(2);
        F = bitmap;
        m.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
    }

    public final void a()
    {
        if (a != null && !a.isRecycled())
        {
            com.socialin.android.util.c.a(a);
        }
        a = null;
        if (b != null && !b.isRecycled())
        {
            com.socialin.android.util.c.a(b);
        }
        b = null;
        if (c != null && !c.isRecycled())
        {
            com.socialin.android.util.c.a(c);
        }
        c = null;
    }

    final void a(float f1, float f2)
    {
        boolean flag1 = true;
        float f3 = z.width();
        float f4 = z.height();
        f3 *= Math.abs(f1);
        f4 *= Math.abs(f2);
        l.left = z.centerX() - f3 / 2.0F;
        RectF rectf = l;
        float f5 = z.centerX();
        rectf.right = f3 / 2.0F + f5;
        l.top = z.centerY() - f4 / 2.0F;
        rectf = l;
        f3 = z.centerY();
        rectf.bottom = f4 / 2.0F + f3;
        boolean flag;
        if (A * f1 < 0.0F)
        {
            if (!x)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            x = flag;
            A = -A;
        }
        if (B * f2 < 0.0F)
        {
            if (!y)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            y = flag;
            B = -B;
        }
        if (I != null)
        {
            I.a();
        }
    }

    public final void a(RectF rectf)
    {
        com.socialin.android.util.l.a(new PointF(l.centerX(), l.centerY()), J, rectf);
        K.x = l.width() / rectf.width();
        K.y = l.height() / rectf.width();
    }

    public final boolean a(PointF pointf)
    {
        Matrix matrix = new Matrix();
        float f1 = o.x;
        float f2 = l.width();
        float f3 = l.left;
        float f4 = o.y;
        float f5 = l.height();
        float f6 = l.top;
        matrix.postRotate(-n, f1 * f2 + f3, f4 * f5 + f6);
        float af[] = new float[2];
        af[0] = pointf.x;
        af[1] = pointf.y;
        matrix.mapPoints(af);
        return l.contains(af[0], af[1]);
    }

    public final void b(RectF rectf)
    {
        com.socialin.android.util.l.b(L, J, rectf);
        l.offset(L.x - l.centerX(), L.y - l.centerY());
        float f1 = K.x;
        float f2 = rectf.width();
        float f3 = K.y;
        float f4 = rectf.width();
        float f5 = l.width();
        float f6 = l.height();
        l.inset(-(f1 * f2 - f5) / 2.0F, -(f3 * f4 - f6) / 2.0F);
    }
}
