// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;

// Referenced classes of package jumiomobile:
//            mp, mv, bg, np, 
//            mh, hp

public class mu extends mp
{

    private mv A;
    private mv B;
    private Paint u;
    private int v;
    private int w;
    private int x;
    private mv y;
    private mv z;

    public mu(Context context, hp hp)
    {
        super(context, hp);
        u = null;
        v = 0;
        w = 0;
        x = 0;
        y = null;
        z = null;
        A = null;
        B = null;
        u = new Paint(1);
        u.setStrokeWidth(0.0F);
        u.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        u.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        u.setPathEffect(new CornerPathEffect(1.0F));
        y = new mv(this);
        z = new mv(this);
        A = new mv(this);
        B = new mv(this);
        x = (int)bg.a(context, 27F);
        w = (int)bg.a(context, 4F);
        v = (int)bg.a(context, 3F);
        n = new np(mh.a(getResources(), mh.T));
        o = new np(mh.a(n.a, 90F, mh.ap));
        p = new np(mh.a(n.a, -90F, mh.aq));
        q = new np(mh.a(n.a, 180F, mh.ar));
    }

    static Paint a(mu mu1)
    {
        return mu1.u;
    }

    public void a(boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        y.a(flag);
        A.a(flag2);
        z.a(flag1);
        B.a(flag3);
    }

    public void onDraw(Canvas canvas)
    {
        y.a(canvas);
        z.a(canvas);
        A.a(canvas);
        B.a(canvas);
        canvas.drawBitmap(n.a, null, n.b, null);
        canvas.drawBitmap(o.a, null, o.b, null);
        canvas.drawBitmap(p.a, null, p.b, null);
        canvas.drawBitmap(q.a, null, q.b, null);
        super.onDraw(canvas);
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        y.a(e + x, c - v - w, f - x, c - w);
        z.a(e + x, d + w, f - x, d + v + w);
        A.a(e - v - w, c + x, e - w, d - x);
        B.a(f + w, c + x, f + v + w, d - x);
        i = (int)bg.a(getContext(), 5F);
        n.b = new Rect(e - i, c - i, (e + n.a.getWidth()) - i, (c + n.a.getHeight()) - i);
        o.b = new Rect((f - o.a.getWidth()) + i, c - i, f + i, (c + o.a.getHeight()) - i);
        p.b = new Rect(e - i, (d - p.a.getHeight()) + i, (e + p.a.getWidth()) - i, d + i);
        q.b = new Rect((f - q.a.getWidth()) + i, (d - q.a.getHeight()) + i, f + i, i + d);
    }
}
