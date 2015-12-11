// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.graphics.Canvas;
import android.graphics.Paint;

// Referenced classes of package jumiomobile:
//            mu

class mv
{

    final mu a;
    private int b;
    private int c;
    private int d;
    private int e;
    private boolean f;

    public mv(mu mu1)
    {
        a = mu1;
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
            mu.a(a).setStyle(android.graphics.Paint.Style.FILL);
            mu.a(a).setColor(0xff97be0d);
            mu.a(a).setAlpha(128);
            canvas.drawRect(b, d, c, e, mu.a(a));
            mu.a(a).setStyle(android.graphics.Paint.Style.STROKE);
            mu.a(a).setColor(-1);
            mu.a(a).setAlpha(128);
            canvas.drawRect(b, d, c, e, mu.a(a));
            return;
        }
    }

    public void a(boolean flag)
    {
        f = flag;
        a.invalidate();
    }
}
