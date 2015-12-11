// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads.b;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

// Referenced classes of package com.mopub.mobileads.b:
//            a

public final class b extends a
{

    private final Paint a = new Paint();

    public b()
    {
        a.setColor(-1);
        a.setStrokeWidth(8F);
        a.setStrokeCap(d.a.a);
    }

    public final void draw(Canvas canvas)
    {
        int i = getBounds().width();
        int j = getBounds().height();
        canvas.drawLine(0.0F, j, i, 0.0F, a);
        canvas.drawLine(0.0F, 0.0F, i, j, a);
    }
}
