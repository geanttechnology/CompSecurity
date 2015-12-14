// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.lensflare;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

// Referenced classes of package com.socialin.android.photo.lensflare:
//            a

public final class b extends a
{

    private Bitmap e;

    public b(float f, float f1, boolean flag, boolean flag1, Bitmap bitmap)
    {
        super(f, f1, flag, flag1);
        if (bitmap == null)
        {
            throw new NullPointerException();
        } else
        {
            e = bitmap;
            return;
        }
    }

    public final float a()
    {
        return (float)e.getWidth();
    }

    public final void a(Canvas canvas, Paint paint)
    {
        canvas.drawBitmap(e, 0.0F, 0.0F, paint);
    }

    public final float b()
    {
        return (float)e.getHeight();
    }
}
