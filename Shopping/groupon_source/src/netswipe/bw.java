// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.graphics.Canvas;
import android.graphics.Paint;

// Referenced classes of package netswipe:
//            bu

class bw
{

    final bu a;
    private int b;
    private int c;
    private int d;
    private int e;
    private boolean f;

    public bw(bu bu1)
    {
        a = bu1;
        super();
        b = 0;
        c = 0;
        d = 0;
        e = 0;
        f = false;
    }

    public void a(int i, int j, int k, int l)
    {
        b = i;
        d = j;
        c = k;
        e = l;
    }

    public void a(Canvas canvas)
    {
        if (!f)
        {
            return;
        } else
        {
            bu.a(a).setStyle(android.graphics.Paint.Style.FILL);
            bu.a(a).setColor(0xff97be0d);
            bu.a(a).setAlpha(128);
            canvas.drawRect(b, d, c, e, bu.a(a));
            bu.a(a).setStyle(android.graphics.Paint.Style.STROKE);
            bu.a(a).setColor(-1);
            bu.a(a).setAlpha(128);
            canvas.drawRect(b, d, c, e, bu.a(a));
            return;
        }
    }

    public void a(boolean flag)
    {
        f = flag;
        a.invalidate();
    }
}
