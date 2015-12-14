// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.util;

import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import com.socialin.android.brushlib.layer.b;

// Referenced classes of package com.socialin.android.brushlib.util:
//            c, d

final class b
    implements Runnable
{

    final b a;
    final d b;
    private Canvas c;
    private c d;

    public final void run()
    {
        com.socialin.android.brushlib.util.c.a(d, d.c, d.d);
        c.save();
        c.drawBitmap(d.f, 0.0F, 0.0F, null);
        c.scale((float)d.c / (float)a.i(), (float)d.d / (float)a.j());
        a.b(c);
        c.restore();
        if (b != null)
        {
            d.e.post(new Runnable() {

                private c._cls1 a;

                public final void run()
                {
                    a.b.a(a.a);
                }

            
            {
                a = c._cls1.this;
                super();
            }
            });
        }
    }

    e(c c1, Canvas canvas, b b1, d d1, BitmapDrawable bitmapdrawable)
    {
        d = c1;
        c = canvas;
        a = b1;
        b = d1;
        super();
    }
}
