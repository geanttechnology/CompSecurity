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

public final class c extends a
{

    public String a;
    private final Paint b = new Paint();
    private final Paint c = new Paint();
    private final Paint d = new Paint();
    private final RectF e = new RectF();
    private final Rect f = new Rect();
    private final int g;

    public c(Context context)
    {
        int i = com.mopub.common.d.d.b(2.0F, context);
        float f1 = com.mopub.common.d.d.a(context);
        b.setColor(0xff000000);
        b.setAlpha(51);
        b.setStyle(d.b.a);
        b.setAntiAlias(true);
        c.setColor(-1);
        c.setAlpha(51);
        c.setStyle(d.b.b);
        c.setStrokeWidth(i);
        c.setAntiAlias(true);
        d.setColor(-1);
        d.setTextAlign(com.mopub.mobileads.b.d.b.d);
        d.setTypeface(d.b.c);
        d.setTextSize(20F * f1);
        d.setAntiAlias(true);
        a = "Learn More";
        g = com.mopub.common.d.d.b(6F, context);
    }

    public final void draw(Canvas canvas)
    {
        e.set(getBounds());
        canvas.drawRoundRect(e, g, g, b);
        canvas.drawRoundRect(e, g, g, c);
        a(canvas, d, f, a);
    }
}
