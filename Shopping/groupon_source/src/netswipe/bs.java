// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

// Referenced classes of package netswipe:
//            bt, aq

public class bs extends View
{

    private bt a;
    private bt b;
    private bt c;
    private bt d;
    private bt e;
    private bt f;
    private bt g;
    private bt h;
    private int i;
    private int j;
    private int k;
    private int l;
    private bt m;
    private bt n;
    private bt o;
    private bt p;
    private bt q;
    private bt r;
    private bt s;
    private bt t;
    private bt u;
    private bt v;
    private bt w;
    private bt x;

    public bs(Context context)
    {
        super(context);
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = 0;
        j = 0;
        k = 0;
        l = 0;
        m = null;
        n = null;
        o = null;
        p = null;
        q = null;
        r = null;
        s = null;
        t = null;
        u = null;
        v = null;
        w = null;
        x = null;
        a = new bt(this, aq.a(getResources(), aq.I));
        b = new bt(this, aq.a(getResources(), aq.J));
        c = new bt(this, aq.a(getResources(), aq.K));
        d = new bt(this, aq.a(getResources(), aq.L));
        e = new bt(this, aq.a(getResources(), aq.M));
        f = new bt(this, aq.a(getResources(), aq.N));
        g = new bt(this, aq.a(getResources(), aq.O));
        h = new bt(this, aq.a(getResources(), aq.P));
        p = new bt(this, aq.a(getResources(), aq.x));
        q = new bt(this, aq.a(getResources(), aq.y));
        r = new bt(this, aq.a(getResources(), aq.z));
        m = new bt(this, aq.a(getResources(), aq.t));
        n = new bt(this, aq.a(getResources(), aq.u));
        o = new bt(this, aq.a(getResources(), aq.v));
        s = new bt(this, aq.a(getResources(), aq.B));
        t = new bt(this, aq.a(getResources(), aq.C));
        u = new bt(this, aq.a(getResources(), aq.D));
        v = new bt(this, aq.a(getResources(), aq.F));
        w = new bt(this, aq.a(getResources(), aq.G));
        x = new bt(this, aq.a(getResources(), aq.H));
    }

    protected void onDraw(Canvas canvas)
    {
        canvas.drawBitmap(q.a, null, q.b, null);
        canvas.drawBitmap(p.a, null, p.b, null);
        canvas.drawBitmap(r.a, null, r.b, null);
        canvas.drawBitmap(n.a, null, n.b, null);
        canvas.drawBitmap(m.a, null, m.b, null);
        canvas.drawBitmap(o.a, null, o.b, null);
        canvas.drawBitmap(s.a, null, s.b, null);
        canvas.drawBitmap(t.a, null, t.b, null);
        canvas.drawBitmap(u.a, null, u.b, null);
        canvas.drawBitmap(v.a, null, v.b, null);
        canvas.drawBitmap(w.a, null, w.b, null);
        canvas.drawBitmap(x.a, null, x.b, null);
        canvas.drawBitmap(a.a, null, a.b, null);
        canvas.drawBitmap(b.a, null, b.b, null);
        canvas.drawBitmap(c.a, null, c.b, null);
        canvas.drawBitmap(d.a, null, d.b, null);
        canvas.drawBitmap(e.a, null, e.b, null);
        canvas.drawBitmap(f.a, null, f.b, null);
        canvas.drawBitmap(g.a, null, g.b, null);
        canvas.drawBitmap(h.a, null, h.b, null);
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
        setMeasuredDimension(j1, i1);
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        i = (int)((double)(float)i1 * 0.067500000000000004D);
        j = (int)((double)(float)i1 * 0.067500000000000004D);
        k = (int)((double)(float)j1 * 0.13800000000000001D);
        l = (int)((double)(float)j1 * 0.13800000000000001D);
        i1 = getWidth() - j;
        j1 = getHeight() - l;
        e.b = new Rect(0, 0, i, k);
        f.b = new Rect(i1, 0, getWidth(), k);
        g.b = new Rect(0, j1, i, getHeight());
        h.b = new Rect(i1, j1, getWidth(), getHeight());
        p.b = new Rect(i1 - p.a.getWidth(), j1, i1, getHeight());
        q.b = new Rect(i, j1, i + q.a.getWidth(), getHeight());
        r.b = new Rect(q.b.right, j1, p.b.left, getHeight());
        m.b = new Rect(i1 - m.a.getWidth(), 0, i1, k);
        n.b = new Rect(i, 0, i + n.a.getWidth(), k);
        o.b = new Rect(n.b.right, 0, m.b.left, k);
        s.b = new Rect(0, k, i, k + s.a.getHeight());
        t.b = new Rect(0, j1 - t.a.getHeight(), i, j1);
        u.b = new Rect(0, s.b.bottom, i, t.b.top);
        v.b = new Rect(i1, k, getWidth(), k + v.a.getHeight());
        w.b = new Rect(i1, j1 - w.a.getHeight(), getWidth(), j1);
        x.b = new Rect(i1, v.b.bottom, getWidth(), w.b.top);
        a.b = new Rect(i, k, i + a.a.getWidth(), k + a.a.getHeight());
        b.b = new Rect(i1 - b.a.getWidth(), k, i1, k + b.a.getHeight());
        c.b = new Rect(i, j1 - c.a.getHeight(), i + c.a.getWidth(), j1);
        d.b = new Rect(i1 - d.a.getWidth(), j1 - d.a.getHeight(), i1, j1);
    }
}
