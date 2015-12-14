// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils.transformations;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.squareup.picasso.Transformation;

public class CropSquareTransformation
    implements Transformation
{

    public CropSquareTransformation()
    {
    }

    public String key()
    {
        return "circle";
    }

    public Bitmap transform(Bitmap bitmap)
    {
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
}
