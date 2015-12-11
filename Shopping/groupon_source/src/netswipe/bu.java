// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.widget.FrameLayout;
import com.jumio.netswipe.sdk.environment.Environment;

// Referenced classes of package netswipe:
//            bw, dc, bv, ar, 
//            bx

public class bu extends FrameLayout
{

    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private String F;
    private String G;
    private String H;
    private String I;
    private String J;
    private Paint a;
    private int b;
    private int c;
    private int d;
    private bw e;
    private bw f;
    private bw g;
    private bw h;
    private int i;
    private int j;
    private int k;
    private bv l;
    private bv m;
    private bv n;
    private bv o;
    private bx p;
    private bx q;
    private bx r;
    private bx s;
    private bx t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    public bu(Context context)
    {
        super(context);
        a = null;
        b = 0;
        c = 0;
        d = 0;
        h = null;
        i = 0;
        j = 0;
        k = 0;
        o = null;
        p = null;
        q = null;
        r = null;
        s = null;
        t = null;
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
        E = 0;
        F = "";
        G = "";
        H = "";
        I = "";
        J = "";
        setWillNotDraw(false);
        a = new Paint(1);
        a.setStrokeWidth(0.0F);
        a.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        a.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        a.setPathEffect(new CornerPathEffect(1.0F));
        e = new bw(this);
        f = new bw(this);
        g = new bw(this);
        h = new bw(this);
        d = dc.a(context, 27);
        c = dc.a(context, 4);
        b = dc.a(context, 3);
        j = dc.a(context, 7);
        k = dc.a(context, 4);
        i = dc.a(context, 31);
        l = new bv(this);
        m = new bv(this);
        n = new bv(this);
        o = new bv(this);
        F = ar.a(context, "scan_area_use_front_of_card");
        G = ar.a(context, "scan_area_card_holder");
        H = ar.a(context, "scan_area_creditcard_number");
        I = ar.a(context, "scan_area_expiry_date");
        J = ar.a(context, "scan_area_valid_thru");
        v = dc.a(context, 32);
        x = dc.a(context, 56);
        w = dc.a(context, 18);
        y = dc.a(context, 108);
        A = dc.a(context, 8);
        z = dc.a(context, 37);
        C = dc.a(context, 35);
        D = dc.a(context, 18);
        E = dc.a(context, 12);
        p = new bx(this);
        p.a(-1);
        p.b(0xff000000);
        p.a(android.graphics.Paint.Style.FILL);
        p.b(dc.a(context, 15, true));
        p.a(Typeface.defaultFromStyle(3));
        p.a(F);
        u = (int)p.b();
        q = new bx(this);
        q.a(-1);
        q.b(0xff000000);
        q.a(android.graphics.Paint.Style.FILL);
        q.b(dc.a(context, 12, true));
        q.a(Environment.loadOcraFontTypeface(context));
        q.a(G);
        s = new bx(this);
        s.a(-1);
        s.b(0xff000000);
        s.a(android.graphics.Paint.Style.FILL);
        s.b(dc.a(context, 7, true));
        s.a(J);
        B = (int)s.b();
        t = new bx(this);
        t.a(-1);
        t.b(0xff000000);
        t.a(android.graphics.Paint.Style.FILL);
        t.b(dc.a(context, 12, true));
        t.a(Environment.loadOcraFontTypeface(context));
        t.a(I);
        r = new bx(this);
        r.a(-1);
        r.b(0xff000000);
        r.a(android.graphics.Paint.Style.FILL);
        r.b(dc.a(context, 16, true));
        r.a(Environment.loadOcraFontTypeface(context));
        r.a(H);
        r.a(0.93F);
    }

    static Paint a(bu bu1)
    {
        return bu1.a;
    }

    static int b(bu bu1)
    {
        return bu1.j;
    }

    static int c(bu bu1)
    {
        return bu1.k;
    }

    static int d(bu bu1)
    {
        return bu1.i;
    }

    public void a()
    {
        a(false, false, false, false);
        setVisibility(0);
    }

    public void a(boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        e.a(flag);
        g.a(flag2);
        f.a(flag1);
        h.a(flag3);
    }

    protected void onDraw(Canvas canvas)
    {
        p.a(canvas);
        q.a(canvas);
        t.a(canvas);
        s.a(canvas);
        r.a(canvas);
        e.a(canvas);
        f.a(canvas);
        g.a(canvas);
        h.a(canvas);
        l.a(canvas);
        m.a(canvas);
        n.a(canvas);
        o.a(canvas);
        super.onDraw(canvas);
    }

    protected void onMeasure(int i1, int j1)
    {
        i1 = android.view.View.MeasureSpec.getSize(i1);
        j1 = android.view.View.MeasureSpec.getSize(j1);
        if (i1 < j1)
        {
            int k1 = (i1 * 3) / 4;
            j1 = i1;
            i1 = k1;
        } else
        {
            int l1 = (j1 * 4) / 3;
            i1 = j1;
            j1 = l1;
        }
        super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(j1, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(i1, 0x40000000));
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        k1 = (int)((double)(float)i1 * 0.067500000000000004D);
        l1 = (int)((double)(float)i1 * 0.067500000000000004D);
        int i2 = (int)((double)(float)j1 * 0.13800000000000001D);
        int j2 = (int)((double)(float)j1 * 0.13800000000000001D);
        p.a((float)((double)(i1 - u) * 0.5D), v + i2);
        r.a(w + k1, j1 - j2 - x);
        int k2 = w + k1 + y;
        s.a(k2, j1 - j2 - z);
        t.a(k2 + B + A, j1 - j2 - C);
        q.a(D + k1, j1 - j2 - E);
        e.a(d + k1, i2 - b - c, i1 - l1 - d, i2 - c);
        f.a(d + k1, (j1 - j2) + c, i1 - l1 - d, (j1 - j2) + b + c);
        g.a(k1 - b - c, d + i2, k1 - c, j1 - j2 - d);
        h.a((i1 - l1) + c, d + i2, (i1 - l1) + b + c, j1 - j2 - d);
        l.a(i1, j1, 0, k1, i2, l1, j2);
        m.a(i1, j1, 2, k1, i2, l1, j2);
        n.a(i1, j1, 1, k1, i2, l1, j2);
        o.a(i1, j1, 3, k1, i2, l1, j2);
    }
}
