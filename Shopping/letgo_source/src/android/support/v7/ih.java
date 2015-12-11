// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;

// Referenced classes of package android.support.v7:
//            alh

public class ih
    implements alh
{

    public ih()
    {
    }

    public Bitmap a(Bitmap bitmap)
    {
        if (bitmap == null)
        {
            return null;
        }
        int i = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - i) / 2, (bitmap.getHeight() - i) / 2, i, i);
        if (bitmap1 != bitmap)
        {
            bitmap.recycle();
        }
        bitmap = Bitmap.createBitmap(i, i, bitmap.getConfig());
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(bitmap1, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        float f = (float)i / 2.0F;
        canvas.drawCircle(f, f, f, paint);
        bitmap1.recycle();
        return bitmap;
    }

    public String a()
    {
        return "circle";
    }
}
