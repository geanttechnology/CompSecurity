// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;

public class bkd
{

    public int a;
    public int b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public Bitmap i;
    public Matrix j;
    private Paint k;

    public bkd()
    {
        j = new Matrix();
        a = 255;
        k = new Paint();
        k.setDither(true);
        k.setFilterBitmap(true);
    }

    public void a(Canvas canvas)
    {
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        Path path = new Path();
        path.moveTo(0.0F - e, 0.0F - c);
        path.lineTo(g + d, 0.0F - c);
        path.lineTo(g + d, h + f);
        path.lineTo(0.0F - e, h + f);
        path.close();
        path.transform(j);
        Paint paint = new Paint(1);
        paint.setStyle(android.graphics.Paint.Style.FILL);
        paint.setColor(b);
        canvas.drawPath(path, paint);
        canvas.drawBitmap(i, j, k);
    }
}
