// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;

public final class blv extends BitmapDrawable
{

    private final int a = 10;
    private final Rect b = new Rect();
    private final Rect c = new Rect();

    public blv(Context context, Bitmap bitmap, int i)
    {
        super(context.getResources(), bmd.a(context, bitmap, 10F));
    }

    public final void draw(Canvas canvas)
    {
        Bitmap bitmap = getBitmap();
        android.graphics.Paint paint = getPaint();
        copyBounds(c);
        int i = c.width() - a;
        int j = Math.round(((float)i * (float)c.height()) / (float)c.width());
        b.left = c.left;
        b.top = c.top;
        b.right = i + c.left;
        b.bottom = j + c.top;
        canvas.drawBitmap(bitmap, b, c, paint);
    }
}
