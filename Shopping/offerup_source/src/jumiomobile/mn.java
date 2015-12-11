// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.ViewTreeObserver;

// Referenced classes of package jumiomobile:
//            nj, nu, mo, np, 
//            mh

public class mn extends nj
{

    private nu a;
    private int b;

    public mn(Context context, nu nu1)
    {
        super(context);
        a = nu1;
        if (a != null)
        {
            a.getViewTreeObserver().addOnGlobalLayoutListener(new mo(this));
        } else
        {
            b = 0;
        }
        n = new np(mh.a(getResources(), mh.T));
        o = new np(mh.a(n.a, 90F, mh.ap));
        p = new np(mh.a(n.a, -90F, mh.aq));
        q = new np(mh.a(n.a, 180F, mh.ar));
    }

    static int a(mn mn1, int i)
    {
        mn1.b = i;
        return i;
    }

    static nu a(mn mn1)
    {
        return mn1.a;
    }

    static void a(mn mn1, boolean flag)
    {
        mn1.b(flag);
    }

    private void b(boolean flag)
    {
        int j = 0;
        int i = s;
        int k = this.l + i;
        i = r;
        int l = m + i;
        if (flag)
        {
            i = (int)((double)l * 0.089999999999999997D);
        } else
        {
            i = 0;
        }
        if (!flag)
        {
            j = (int)((double)k * 0.10000000000000001D);
        }
        k -= this.i;
        i = l - this.k - i;
        n.b = new Rect(h + j, this.j + b, h + n.a.getWidth() + j, this.j + n.a.getHeight() + b);
        o.b = new Rect(k - o.a.getWidth() - j, this.j + b, k - j, this.j + o.a.getHeight() + b);
        p.b = new Rect(h + j, i - p.a.getHeight(), h + p.a.getWidth() + j, i);
        q.b = new Rect(k - q.a.getWidth() - j, i - q.a.getHeight(), k - j, i);
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
        boolean flag;
        if (getHeight() > getWidth())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b(flag);
        canvas.drawBitmap(n.a, null, n.b, null);
        canvas.drawBitmap(o.a, null, o.b, null);
        canvas.drawBitmap(p.a, null, p.b, null);
        canvas.drawBitmap(q.a, null, q.b, null);
        super.onDraw(canvas);
    }

    protected void onMeasure(int i, int j)
    {
        i = android.view.View.MeasureSpec.getSize(i);
        j = android.view.View.MeasureSpec.getSize(j);
        h = (int)((double)i * 0.029999999999999999D);
        this.i = (int)((double)i * 0.029999999999999999D);
        this.j = (int)((double)j * 0.029999999999999999D);
        k = (int)((double)j * 0.059999999999999998D);
        setMeasuredDimension(i, j);
        l = i - s;
        m = j;
    }
}
