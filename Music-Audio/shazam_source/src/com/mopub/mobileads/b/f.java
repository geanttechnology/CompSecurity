// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.mopub.common.d.d;

// Referenced classes of package com.mopub.mobileads.b:
//            a

public final class f extends a
{

    public int a;
    public int b;
    public float c;
    private final Paint d = new Paint();
    private final Paint e = new Paint();
    private final Paint f = new Paint();
    private Rect g;

    public f(Context context)
    {
        int i = com.mopub.common.d.d.b(3F, context);
        float f1 = com.mopub.common.d.d.a(context);
        d.setColor(-1);
        d.setAlpha(128);
        d.setStyle(d.e.a);
        d.setStrokeWidth(i);
        d.setAntiAlias(true);
        e.setColor(-1);
        e.setAlpha(255);
        e.setStyle(d.e.b);
        e.setStrokeWidth(i);
        e.setAntiAlias(true);
        f.setColor(-1);
        f.setTextAlign(d.e.c);
        f.setTextSize(18F * f1);
        f.setAntiAlias(true);
        g = new Rect();
    }

    public final void draw(Canvas canvas)
    {
        int i = getBounds().centerX();
        int j = getBounds().centerY();
        int k = Math.min(i, j);
        canvas.drawCircle(i, j, k, d);
        i = b;
        a(canvas, f, g, String.valueOf(i));
        canvas.drawArc(new RectF(getBounds()), -90F, c, false, e);
    }
}
