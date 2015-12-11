// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.support.v4.view.ap;
import com.a.b.aw;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.wishabi.flipp.widget:
//            dy, dw

public final class dx
    implements aw
{

    public int a;
    public final dy b;
    public Bitmap c;
    public final byte d[] = new byte[16384];
    public final AtomicInteger e = new AtomicInteger(0);
    public final RectF f;
    final dw g;

    public dx(dw dw1, int i, int j, int k, float f1, float f2, float f3, 
            float f4)
    {
        g = dw1;
        super();
        c = Bitmap.createBitmap(256, 256, android.graphics.Bitmap.Config.RGB_565);
        a = k;
        b = new dy(i, j, k);
        f = new RectF(f1, f2, f3, f4);
    }

    public final void a()
    {
        dw.a(g).put(b, this);
        ap.d(g);
        g.invalidate();
        dw.b(g).remove(b);
    }

    public final void b()
    {
        dw.b(g).remove(b);
        dw.c(g).push(this);
    }
}
