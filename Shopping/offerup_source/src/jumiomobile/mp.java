// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;

// Referenced classes of package jumiomobile:
//            nj, bg, nt, hp, 
//            au

public class mp extends nj
{

    private Path A;
    private Paint B;
    private Paint C;
    private nt D;
    protected hp a;
    protected int b;
    protected int c;
    protected int d;
    protected int e;
    protected int f;
    protected Rect g;
    private Paint u;
    private RectF v;
    private RectF w;
    private Path x;
    private Path y;
    private Path z;

    public mp(Context context, hp hp1)
    {
        super(context);
        a = null;
        b = 0;
        c = 0;
        d = 0;
        e = 0;
        f = 0;
        D = null;
        a = hp1;
        b = (int)bg.a(getContext(), 15F);
        u = new Paint();
        u.setColor(0xff000000);
        u.setStyle(android.graphics.Paint.Style.FILL);
        u.setAlpha(90);
        B = new Paint();
        B.setColor(-1);
        B.setStyle(android.graphics.Paint.Style.STROKE);
        B.setDither(true);
        B.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        B.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        B.setAntiAlias(true);
        B.setAlpha(74);
        B.setStrokeWidth(1.0F);
        C = new Paint();
        C.setColor(0xff000000);
        C.setStyle(android.graphics.Paint.Style.STROKE);
        C.setDither(true);
        C.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        C.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        C.setAntiAlias(true);
        C.setAlpha(72);
        C.setStrokeWidth(1.0F);
        D = new nt();
        D.a(-1);
        D.c(0xff000000);
        D.a(android.graphics.Paint.Style.FILL);
        D.b(178);
        D.a(bg.a(context, 18F));
        D.a(Typeface.defaultFromStyle(3));
    }

    private void a()
    {
        D.a((float)((double)((float)getWidth() - D.b()) * 0.5D), c + (int)bg.a(getContext(), 30F));
        invalidate();
    }

    public int a(int i)
    {
        return 0;
    }

    public int getROIXOffset()
    {
        return h + s;
    }

    protected void onDraw(Canvas canvas)
    {
        canvas.drawRect(v, u);
        canvas.drawRect(w, u);
        canvas.drawPath(x, u);
        canvas.drawPath(y, u);
        canvas.drawPath(A, C);
        canvas.drawPath(z, B);
        D.a(canvas);
        super.onDraw(canvas);
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        if ((float)i / (float)j >= 1.333333F)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        if (k != 0)
        {
            m = j;
            this.l = (m << 2) / 3;
            r = 0;
            s = (i - this.l) / 2;
        } else
        {
            this.l = i;
            m = (this.l * 3) / 4;
            r = (j - m) / 2;
            s = 0;
        }
        h = a.a(this.l);
        this.i = a.b(this.l);
        this.j = a.c(m);
        this.k = a.d(m);
        f = i - (this.i + s);
        d = j - (this.k + r);
        e = h + s;
        c = this.j + r;
        g = new Rect(e, c, f, d);
        z = au.a(g, b, b, b, b);
        k = e;
        l = f;
        A = au.a(new Rect(k - 1, c, l, d + 1), b, b, b, b);
        v = new RectF(0.0F, 0.0F, i, c);
        w = new RectF(0.0F, d, i, j);
        x = new Path();
        x.moveTo(0.0F, c);
        x.lineTo(e + b, c);
        x.quadTo(e, c, e, c + b);
        x.lineTo(e, d - b);
        x.quadTo(e, d, e + b, d);
        x.lineTo(0.0F, d);
        x.close();
        y = new Path();
        y.moveTo(i, c);
        y.lineTo(f - b, c);
        y.quadTo(f, c, f, c + b);
        y.lineTo(f, d - b);
        y.quadTo(f, d, f - b, d);
        y.lineTo(i, d);
        y.lineTo(i, c);
        y.close();
        a();
    }

    public void setOverlayText(String s)
    {
        D.a(s);
        a();
    }
}
