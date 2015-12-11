// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;

public class db
{

    public static Bitmap a(Bitmap bitmap)
    {
        return bitmap.copy(bitmap.getConfig(), true);
    }

    public static Bitmap a(Bitmap bitmap, int i, int j)
    {
        Bitmap bitmap1 = Bitmap.createBitmap(i, j, bitmap.getConfig());
        Canvas canvas = new Canvas(bitmap1);
        Matrix matrix = new Matrix();
        matrix.setScale((float)i / (float)bitmap.getWidth(), (float)j / (float)bitmap.getHeight());
        canvas.drawBitmap(bitmap, matrix, null);
        return bitmap1;
    }

    public static void b(Bitmap bitmap)
    {
        if (bitmap != null)
        {
            if (bitmap.isMutable())
            {
                bitmap.eraseColor(0xff000000);
            }
            bitmap.recycle();
        }
    }
}
