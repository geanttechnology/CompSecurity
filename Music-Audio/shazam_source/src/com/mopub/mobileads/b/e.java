// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.mopub.common.d.d;

// Referenced classes of package com.mopub.mobileads.b:
//            a

public final class e extends a
{

    public int a;
    public int b;
    public int c;
    public int d;
    public float e;
    private final Paint f = new Paint();
    private final Paint g = new Paint();
    private final int h;

    public e(Context context)
    {
        f.setColor(-1);
        f.setAlpha(128);
        f.setStyle(d.d.a);
        f.setAntiAlias(true);
        g.setColor(d.d.b);
        g.setAlpha(255);
        g.setStyle(d.d.c);
        g.setAntiAlias(true);
        h = com.mopub.common.d.d.b(4F, context);
    }

    public final void draw(Canvas canvas)
    {
        canvas.drawRect(getBounds(), f);
        float f1 = (float)c / (float)a;
        canvas.drawRect(getBounds().left, getBounds().top, (float)getBounds().right * f1, getBounds().bottom, g);
        if (b > 0 && b < a)
        {
            float f2 = getBounds().right;
            f2 = e * f2;
            canvas.drawRect(f2, getBounds().top, f2 + (float)h, getBounds().bottom, g);
        }
    }
}
