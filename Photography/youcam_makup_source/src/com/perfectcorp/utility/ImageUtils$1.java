// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.perfectcorp.utility;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

// Referenced classes of package com.perfectcorp.utility:
//            j, ImageUtils, e

final class a extends j
{

    final View a;

    protected Bitmap a(View view)
    {
        view = Bitmap.createBitmap(view.getWidth(), view.getHeight(), android.graphics..ARGB_8888);
        view.eraseColor(0);
        return view;
    }

    protected volatile Object a(Object obj)
    {
        return a((View)obj);
    }

    protected void a(Bitmap bitmap)
    {
        Canvas canvas = new Canvas(bitmap);
        a.draw(canvas);
        if (e.a)
        {
            Paint paint = new Paint();
            paint.setColor(0xffff0000);
            paint.setAntiAlias(true);
            paint.setTextSize(40F);
            paint.setFakeBoldText(true);
            paint.setStyle(android.graphics.ILL);
            canvas.drawText("[CACHE]", 100F, 100F, paint);
            paint.setColor(-1);
            paint.setStrokeWidth(1.0F);
            paint.setStyle(android.graphics.TROKE);
            canvas.drawText("[CACHE]", 100F, 100F, paint);
        }
        super.a_(bitmap);
    }

    protected void a_(Object obj)
    {
        a((Bitmap)obj);
    }

    (View view)
    {
        a = view;
        super();
    }
}
