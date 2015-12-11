// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

// Referenced classes of package netswipe:
//            bu

class bv
{

    final bu a;
    private Path b;
    private boolean c;

    public bv(bu bu1)
    {
        a = bu1;
        super();
        b = null;
        c = true;
        b = new Path();
    }

    public void a(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        b.reset();
        if (k == 0)
        {
            i = l - bu.b(a) - bu.c(a);
            j = i1 - bu.b(a) - bu.c(a);
            b.moveTo(i, j);
            i += bu.d(a);
            b.lineTo(i, j);
            j += bu.b(a);
            b.lineTo(i, j);
            k = (i - bu.d(a)) + bu.b(a);
            b.lineTo(k, j);
            i = (j + bu.d(a)) - bu.b(a);
            b.lineTo(k, i);
            j = k - bu.b(a);
            b.lineTo(j, i);
            k = bu.d(a);
            b.lineTo(j, i - k);
        } else
        {
            if (k == 1)
            {
                i = (i - j1) + bu.b(a) + bu.c(a);
                j = i1 - bu.b(a) - bu.c(a);
                b.moveTo(i, j);
                i -= bu.d(a);
                b.lineTo(i, j);
                j += bu.b(a);
                b.lineTo(i, j);
                k = (i + bu.d(a)) - bu.b(a);
                b.lineTo(k, j);
                i = (j + bu.d(a)) - bu.b(a);
                b.lineTo(k, i);
                j = k + bu.b(a);
                b.lineTo(j, i);
                k = bu.d(a);
                b.lineTo(j, i - k);
                return;
            }
            if (k == 2)
            {
                i = l - bu.b(a) - bu.c(a);
                j = (j - k1) + bu.b(a) + bu.c(a);
                b.moveTo(i, j);
                i += bu.d(a);
                b.lineTo(i, j);
                j -= bu.b(a);
                b.lineTo(i, j);
                k = (i - bu.d(a)) + bu.b(a);
                b.lineTo(k, j);
                i = (j - bu.d(a)) + bu.b(a);
                b.lineTo(k, i);
                j = k - bu.b(a);
                b.lineTo(j, i);
                k = bu.d(a);
                b.lineTo(j, i + k);
                return;
            }
            if (k == 3)
            {
                i = (i - j1) + bu.b(a) + bu.c(a);
                j = (j - k1) + bu.b(a) + bu.c(a);
                b.moveTo(i, j);
                i -= bu.d(a);
                b.lineTo(i, j);
                j -= bu.b(a);
                b.lineTo(i, j);
                k = (i + bu.d(a)) - bu.b(a);
                b.lineTo(k, j);
                i = (j - bu.d(a)) + bu.b(a);
                b.lineTo(k, i);
                j = k + bu.b(a);
                b.lineTo(j, i);
                k = bu.d(a);
                b.lineTo(j, i + k);
                return;
            }
        }
    }

    public void a(Canvas canvas)
    {
        if (!c)
        {
            return;
        } else
        {
            bu.a(a).setStyle(android.graphics.Paint.Style.FILL);
            bu.a(a).setColor(0xff97be0d);
            bu.a(a).setAlpha(128);
            canvas.drawPath(b, bu.a(a));
            bu.a(a).setStyle(android.graphics.Paint.Style.STROKE);
            bu.a(a).setColor(-1);
            bu.a(a).setAlpha(128);
            canvas.drawPath(b, bu.a(a));
            return;
        }
    }
}
