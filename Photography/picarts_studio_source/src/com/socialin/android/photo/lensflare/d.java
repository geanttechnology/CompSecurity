// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.lensflare;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.socialin.android.photo.svg.Svg;

// Referenced classes of package com.socialin.android.photo.lensflare:
//            a

public final class d extends a
{

    private Svg e;

    public d(float f, float f1, boolean flag, boolean flag1, Svg svg)
    {
        super(f, f1, flag, flag1);
        e = svg;
        svg.a(256F / svg.a());
    }

    public final float a()
    {
        return e.a();
    }

    public final void a(Canvas canvas, Paint paint)
    {
        e.a(canvas, paint.getAlpha(), paint.getColor(), true, false, paint.getXfermode(), paint.getColorFilter());
    }

    public final float b()
    {
        return e.a();
    }
}
