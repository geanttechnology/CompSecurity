// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.widget.FrameLayout;
import com.jumio.mobile.sdk.environment.Environment;

// Referenced classes of package jumiomobile:
//            ec, bf, ex

public class ew extends FrameLayout
{

    private int A;
    private int B;
    private int C;
    private int D;
    private String E;
    private String F;
    private String G;
    private String H;
    private String I;
    private int J;
    Paint a;
    Paint b;
    Paint c;
    private RectF d;
    private RectF e;
    private Path f;
    private Path g;
    private RectF h;
    private RectF i;
    private int j;
    private int k;
    private int l;
    private int m;
    private float n;
    private ex o;
    private ex p;
    private ex q;
    private ex r;
    private ex s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    public ew(Context context)
    {
        super(context);
        o = null;
        p = null;
        q = null;
        r = null;
        s = null;
        t = 0;
        u = 0;
        v = 0;
        w = 0;
        x = 0;
        y = 0;
        z = 0;
        A = 0;
        B = 0;
        C = 0;
        D = 0;
        E = "";
        F = "";
        G = "";
        H = "";
        I = "";
        J = 0;
        setWillNotDraw(false);
        a = new Paint();
        a.setColor(0xff000000);
        a.setStyle(android.graphics.Paint.Style.FILL);
        a.setAlpha(90);
        b = new Paint();
        b.setColor(-1);
        b.setStyle(android.graphics.Paint.Style.STROKE);
        b.setDither(true);
        b.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        b.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        b.setAntiAlias(true);
        b.setAlpha(64);
        b.setStrokeWidth(1.0F);
        c = new Paint();
        c.setColor(0xff000000);
        c.setStyle(android.graphics.Paint.Style.STROKE);
        c.setDither(true);
        c.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        c.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        c.setAntiAlias(true);
        c.setAlpha(102);
        c.setStrokeWidth(1.0F);
        E = ec.a(context, "scan_area_present_your_card_number");
        F = ec.a(context, "scan_area_card_holder");
        G = ec.a(context, "scan_area_creditcard_number");
        H = ec.a(context, "scan_area_expiry_date");
        I = ec.a(context, "scan_area_valid_thru");
        u = bf.a(context, 32);
        w = bf.a(context, 64);
        v = bf.a(context, 18);
        x = bf.a(context, 103);
        z = bf.a(context, 8);
        y = bf.a(context, 45);
        B = bf.a(context, 43);
        C = bf.a(context, 18);
        D = bf.a(context, 23);
        o = new ex(this);
        o.a(-1);
        o.b(178);
        o.c(0xff000000);
        o.a(android.graphics.Paint.Style.FILL);
        o.a(bf.a(context, 15, true));
        o.a(Typeface.defaultFromStyle(3));
        o.a(E);
        t = (int)o.b();
        p = new ex(this);
        p.a(-1);
        p.b(178);
        p.c(0xff000000);
        p.a(android.graphics.Paint.Style.FILL);
        p.a(bf.a(context, 12, true));
        p.a(Environment.loadOcraFontTypeface(context));
        p.a(F);
        r = new ex(this);
        r.a(-1);
        r.b(178);
        r.c(0xff000000);
        r.a(android.graphics.Paint.Style.FILL);
        r.a(bf.a(context, 7, true));
        r.a(I);
        A = (int)r.b();
        s = new ex(this);
        s.a(-1);
        s.b(178);
        s.c(0xff000000);
        s.a(android.graphics.Paint.Style.FILL);
        s.a(bf.a(context, 12, true));
        s.a(Environment.loadOcraFontTypeface(context));
        s.a(H);
        q = new ex(this);
        q.a(-1);
        q.b(178);
        q.c(0xff000000);
        q.a(android.graphics.Paint.Style.FILL);
        q.a(bf.a(context, 16, true));
        q.a(Environment.loadOcraFontTypeface(context));
        q.a(G);
    }

    public int getBottomPositionOfRoi()
    {
        return m;
    }

    public int getVerticalOffsetCard()
    {
        return J;
    }

    protected void onDraw(Canvas canvas)
    {
        canvas.drawRect(d, a);
        canvas.drawRect(e, a);
        canvas.drawPath(f, a);
        canvas.drawPath(g, a);
        canvas.drawRoundRect(i, n, n, c);
        canvas.drawRoundRect(h, n, n, b);
        o.a(canvas);
        p.a(canvas);
        s.a(canvas);
        r.a(canvas);
        q.a(canvas);
        super.onDraw(canvas);
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        int i2;
        int j2;
        int k2;
        if ((float)i1 / (float)j1 >= 1.333333F)
        {
            k1 = 1;
        } else
        {
            k1 = 0;
        }
        if (k1 != 0)
        {
            l1 = (int)((double)j1 * 0.13800000000000001D);
            k1 = J + l1;
            float f1 = j1 - l1 - k1;
            i2 = Math.round(((float)i1 - f1 * 1.586F) / 2.0F);
            j2 = i2;
        } else
        {
            i2 = (int)((double)i1 * 0.067500000000000004D);
            float f2 = (float)(i1 - i2 - i2) / 1.586F;
            l1 = Math.round(((float)j1 - f2 - (float)J) / 2.0F);
            k1 = Math.round((((float)j1 - f2) + (float)J) / 2.0F);
            j2 = i2;
        }
        o.a((float)((double)(i1 - t) * 0.5D), u + l1);
        q.a(v + j2, j1 - k1 - w);
        k2 = v + j2 + x;
        r.a(k2, j1 - k1 - y);
        s.a(k2 + A + z, j1 - k1 - B);
        p.a(C + j2, j1 - k1 - D);
        j = j2;
        k = i1 - i2;
        l = l1;
        m = j1 - k1;
        d = new RectF(0.0F, 0.0F, i1, l);
        e = new RectF(0.0F, m, i1, j1);
        n = (float)(i1 - j2 - i2) * 0.035F;
        i = new RectF(j - 1, l, k, m + 1);
        h = new RectF(j, l, k, m);
        f = new Path();
        f.moveTo(0.0F, l);
        f.lineTo((float)j + n, l);
        f.quadTo(j, l, j, (float)l + n);
        f.lineTo(j, (float)m - n);
        f.quadTo(j, m, (float)j + n, m);
        f.lineTo(0.0F, m);
        f.close();
        g = new Path();
        g.moveTo((float)k - n, l);
        g.lineTo(i1, l);
        g.lineTo(i1, m);
        g.lineTo((float)k - n, m);
        g.quadTo(k, m, k, (float)m - n);
        g.lineTo(k, (float)l + n);
        g.quadTo(k, l, (float)k - n, l);
        g.close();
    }

    public void setTextVisible(boolean flag)
    {
        char c1;
        if (flag)
        {
            c1 = '\262';
        } else
        {
            c1 = '\0';
        }
        o.b(c1);
        p.b(c1);
        q.b(c1);
        r.b(c1);
        s.b(c1);
        invalidate();
    }

    public void setVerticalOffsetCard(int i1)
    {
        J = i1;
    }
}
