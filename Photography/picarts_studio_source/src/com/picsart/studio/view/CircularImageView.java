// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CircularImageView extends ImageView
{

    private static Bitmap b;
    private Paint a;

    public CircularImageView(Context context)
    {
        this(context, null);
    }

    public CircularImageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public CircularImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = new Paint(3);
        a.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_IN));
    }

    protected void onDraw(Canvas canvas)
    {
        int i = getWidth();
        int j = getHeight();
        super.onDraw(canvas);
        if (b == null || b.getWidth() != i || b.getHeight() != j)
        {
            i /= 2;
            if (b != null)
            {
                b.recycle();
            }
            Object obj = Bitmap.createBitmap(i * 2, i * 2, android.graphics.Bitmap.Config.ARGB_8888);
            b = ((Bitmap) (obj));
            ((Bitmap) (obj)).eraseColor(0);
            obj = new Paint(1);
            ((Paint) (obj)).setStyle(android.graphics.Paint.Style.FILL);
            ((Paint) (obj)).setColor(-1);
            (new Canvas(b)).drawCircle(i, i, i, ((Paint) (obj)));
        }
        canvas.drawBitmap(b, 0.0F, 0.0F, a);
    }
}
