// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;

// Referenced classes of package jumiomobile:
//            nj, np, mh, hp, 
//            nt, bg, au

public class nk extends nj
{

    private Path A;
    private Path B;
    private Path C;
    private Path D;
    private Paint E;
    private Paint F;
    private Paint G;
    private hp H;
    private np a;
    private Rect b;
    private Rect c;
    private int d;
    private Paint e;
    private RectF f;
    private RectF g;
    private Path u;
    private Path v;
    private nt w;
    private Paint x;
    private Paint y;
    private Rect z;

    public nk(Context context, boolean flag, boolean flag1)
    {
        super(context);
        a = null;
        w = null;
        H = null;
        t = flag;
        a = new np(mh.a(getResources(), mh.S));
        H = hp.d;
        e = new Paint();
        e.setColor(0xff000000);
        e.setStyle(android.graphics.Paint.Style.FILL);
        e.setAlpha(90);
        w = new nt();
        w.a(-1);
        w.c(0xff000000);
        w.a(android.graphics.Paint.Style.FILL);
        w.a(bg.a(context, 20F));
        w.a(Typeface.defaultFromStyle(1));
        nt nt1 = w;
        if (flag1)
        {
            context = "VISA";
        } else
        {
            context = "PASSPORT";
        }
        nt1.a(context);
        F = new Paint();
        F.setColor(-1);
        F.setStyle(android.graphics.Paint.Style.STROKE);
        F.setDither(true);
        F.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        F.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        F.setAntiAlias(true);
        F.setAlpha(74);
        F.setStrokeWidth(1.0F);
        E = new Paint();
        E.setColor(-1);
        E.setStyle(android.graphics.Paint.Style.STROKE);
        E.setDither(true);
        E.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        E.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        E.setAntiAlias(true);
        E.setAlpha(55);
        E.setStrokeWidth(1.0F);
        G = new Paint();
        G.setColor(0xff000000);
        G.setStyle(android.graphics.Paint.Style.STROKE);
        G.setDither(true);
        G.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        G.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        G.setAntiAlias(true);
        G.setAlpha(72);
        G.setStrokeWidth(1.0F);
        x = new Paint();
        x.setColor(0xff97be0d);
        x.setStyle(android.graphics.Paint.Style.STROKE);
        x.setDither(true);
        x.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        x.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        x.setAntiAlias(true);
        x.setStrokeWidth(bg.a(getContext(), 2.0F));
        y = new Paint();
        y.setColor(0xff97be0d);
        y.setStyle(android.graphics.Paint.Style.FILL);
        y.setAlpha(64);
    }

    public int a(int i)
    {
        int j = z.bottom;
        int k = z.top;
        return z.top - (i - (j - k)) / 2;
    }

    public int getROIXOffset()
    {
        return h + s;
    }

    protected void onDraw(Canvas canvas)
    {
        canvas.drawRect(f, e);
        canvas.drawRect(g, e);
        canvas.drawPath(u, e);
        canvas.drawPath(v, e);
        canvas.drawPath(C, G);
        canvas.drawPath(D, E);
        canvas.drawPath(B, F);
        canvas.drawPath(A, x);
        canvas.drawPath(A, y);
        if (t)
        {
            a.b = c;
        } else
        {
            a.b = b;
        }
        w.a((float)a.b.left + ((float)a.a.getWidth() - w.b()) / 2.0F, d);
        w.a(canvas);
        canvas.drawBitmap(a.a, null, a.b, null);
        super.onDraw(canvas);
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        if ((float)i / (float)j >= 1.333333F)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        h = (int)((double)i * 0.021999999999999999D);
        this.i = (int)((double)i * 0.021999999999999999D);
        this.j = (int)((double)j * 0.021999999999999999D);
        this.k = (int)((double)j * 0.021999999999999999D);
        if (k != 0)
        {
            r = (int)bg.a(getContext(), 39F);
            l = 0;
            k = j - this.j - this.k;
            s = (i - ((int)((double)k * H.e()) - h - this.i)) / 2;
        } else
        {
            s = 0;
            k = (int)((double)(i - h - this.i) / H.e());
            l = this.j;
            k = this.k + (k + l);
            l = (j - k) / 2;
            r = l;
        }
        this.l = i - s * 2;
        m = j - r - l;
        i1 = i - s - this.i;
        k1 = j - l - this.k;
        l = h + s;
        j1 = this.j + r;
        l1 = (int)bg.a(getContext(), 5F);
        k = k1 - (int)((double)k * H.f());
        B = au.a(new Rect(l, j1, i1, k1), 0, 0, l1, l1);
        D = new Path();
        D.moveTo(l, 0.0F);
        D.lineTo(l, j1);
        D.moveTo(i1, 0.0F);
        D.lineTo(i1, j1);
        i2 = l - 1;
        j2 = j1 + 1;
        k2 = k1 + 1;
        C = au.a(new Rect(i2, j2, i1, k2), 0, 0, l1, l1);
        C = new Path();
        C.moveTo(i1, j2);
        C.lineTo(i1, k2 - l1);
        C.quadTo(i1, k2, i1 - l1, k2);
        C.lineTo(i2 + l1, k2);
        C.quadTo(i2, k2, i2, k2 - l1);
        C.lineTo(i2, j1);
        i2 = (int)bg.a(getContext(), 2.0F);
        z = new Rect(l, k, i1, k1);
        A = au.a(new Rect(i2 / 2 + l, k, i1 - i2 / 2, k1 - i2 / 2), 0, 0, l1, l1);
        f = new RectF(0.0F, 0.0F, i, j1);
        g = new RectF(0.0F, k1, i, j);
        u = new Path();
        u.moveTo(0.0F, j1);
        u.lineTo(l, j1);
        u.lineTo(l, k1 - l1);
        u.quadTo(l, k1, l + l1, k1);
        u.lineTo(0.0F, k1);
        u.close();
        v = new Path();
        v.moveTo(i1, j1);
        v.lineTo(i, j1);
        v.lineTo(i, k1);
        v.lineTo(i1 - l1, k1);
        v.quadTo(i1, k1, i1, k1 - l1);
        v.lineTo(i1, j1);
        v.close();
        i = (int)bg.a(getContext(), 43F);
        j = (int)bg.a(getContext(), 20F);
        d = (int)bg.a(getContext(), 26F) + j1;
        b = new Rect(l + j, j1 + i, l + a.a.getWidth() + j, a.a.getHeight() + j1 + i);
        c = new Rect(i1 - j - a.a.getWidth(), j1 + i, i1 - j, i + (a.a.getHeight() + j1));
    }
}
