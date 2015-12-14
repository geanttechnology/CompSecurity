// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import java.io.InputStream;

public class yo
{

    public static int a(android.graphics.BitmapFactory.Options options, int i, int j)
    {
        int i1 = options.outHeight;
        int j1 = options.outWidth;
        int l = 1;
        int k = 1;
        if (i1 > j || j1 > i)
        {
            i1 /= 2;
            j1 /= 2;
            do
            {
                if (i1 / k <= j)
                {
                    l = k;
                    if (j1 / k <= i)
                    {
                        break;
                    }
                }
                k *= 2;
            } while (true);
        }
        return l;
    }

    public static Bitmap a(Resources resources, int i, int j, int k)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, options);
        options.inSampleSize = a(options, j, k);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i, options);
    }

    public static Bitmap a(Bitmap bitmap)
    {
        Bitmap bitmap1;
        try
        {
            int i = bitmap.getWidth();
            int j = bitmap.getHeight();
            bitmap1 = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap1);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, i, j);
            RectF rectf = new RectF(rect);
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(0xff424242);
            canvas.drawRoundRect(rectf, (float)i / 2.0F, (float)j / 2.0F, paint);
            paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect, paint);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            return null;
        }
        return bitmap1;
    }

    public static Bitmap a(Bitmap bitmap, float f)
    {
        Bitmap bitmap1;
        try
        {
            int i = bitmap.getWidth();
            int j = bitmap.getHeight();
            bitmap1 = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap1);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, i, j);
            RectF rectf = new RectF(rect);
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(0xff424242);
            canvas.drawRoundRect(rectf, f, f, paint);
            paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect, paint);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            return null;
        }
        return bitmap1;
    }

    public static Bitmap a(Bitmap bitmap, int i, int j)
    {
        int k = bitmap.getWidth();
        int l = bitmap.getHeight();
        float f;
        Rect rect;
        Matrix matrix;
        if (k > l)
        {
            rect = new Rect((k - l) / 2, 0, (k - l) / 2 + l, l);
            f = (float)j / (float)rect.height();
        } else
        {
            rect = new Rect(0, (l - k) / 2, k, (l - k) / 2 + k);
            f = (float)i / (float)rect.width();
        }
        matrix = new Matrix();
        matrix.postScale(f, f);
        return Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height(), matrix, true);
    }

    public static Bitmap a(Drawable drawable)
    {
        if (drawable instanceof BitmapDrawable)
        {
            return ((BitmapDrawable)drawable).getBitmap();
        }
        if (drawable instanceof NinePatchDrawable)
        {
            int i = drawable.getIntrinsicWidth();
            int j = drawable.getIntrinsicHeight();
            Object obj;
            Canvas canvas;
            if (drawable.getOpacity() != -1)
            {
                obj = android.graphics.Bitmap.Config.ARGB_8888;
            } else
            {
                obj = android.graphics.Bitmap.Config.RGB_565;
            }
            obj = Bitmap.createBitmap(i, j, ((android.graphics.Bitmap.Config) (obj)));
            canvas = new Canvas(((Bitmap) (obj)));
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            return ((Bitmap) (obj));
        } else
        {
            return null;
        }
    }

    public static Bitmap a(InputStream inputstream, InputStream inputstream1, int i, int j)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputstream, null, options);
        options.inSampleSize = a(options, i, j);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeStream(inputstream1, null, options);
    }

    public static Bitmap a(String s, int i, int j)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(s, options);
        options.inSampleSize = a(options, i, j);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(s, options);
    }

    public static Bitmap a(String s, int i, int j, boolean flag)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(s, options);
        options.inSampleSize = a(options, i, j);
        options.inJustDecodeBounds = false;
        if (flag)
        {
            options.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
        }
        return BitmapFactory.decodeFile(s, options);
    }

    public static Bitmap a(byte abyte0[], byte abyte1[], int i, int j)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length, options);
        options.inSampleSize = a(options, i, j);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(abyte1, 0, abyte1.length, options);
    }

    public static Bitmap a(byte abyte0[], byte abyte1[], boolean flag)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length, options);
        options.inSampleSize = 1;
        options.inJustDecodeBounds = false;
        if (flag)
        {
            options.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
        }
        return BitmapFactory.decodeByteArray(abyte1, 0, abyte1.length, options);
    }

    public static Point a(String s, Context context)
    {
        context = new android.graphics.BitmapFactory.Options();
        context.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(s, context);
        return new Point(((android.graphics.BitmapFactory.Options) (context)).outWidth, ((android.graphics.BitmapFactory.Options) (context)).outHeight);
    }

    public static Drawable a(Context context, int i)
    {
        try
        {
            context = context.getResources().getDrawable(i);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        return context;
    }

    public static Bitmap b(Bitmap bitmap)
    {
        if (bitmap == null)
        {
            return null;
        } else
        {
            Matrix matrix = new Matrix();
            matrix.setScale(1.0F, -1F, (float)bitmap.getWidth() / 2.0F, (float)bitmap.getHeight() / 2.0F);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }
    }

    public static Bitmap b(Bitmap bitmap, int i, int j)
    {
        int k = bitmap.getWidth();
        int l = bitmap.getHeight();
        float f = (float)k / (float)l;
        float f1 = (float)i / (float)j;
        Rect rect;
        Matrix matrix;
        if (f1 > f)
        {
            rect = new Rect(0, (int)((float)l - (float)k / f1) / 2, k, (int)((float)l + (float)k / f1) / 2);
            f = (float)i / (float)rect.width();
        } else
        {
            rect = new Rect((int)((float)k - (float)l * f1) / 2, 0, (int)((float)k + f1 * (float)l) / 2, l);
            f = (float)j / (float)rect.height();
        }
        matrix = new Matrix();
        matrix.postScale(f, f);
        return Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height(), matrix, true);
    }

    public static Bitmap b(InputStream inputstream, InputStream inputstream1, int i, int j)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputstream, null, options);
        options.inSampleSize = a(options, i, j);
        options.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeStream(inputstream1, null, options);
    }
}
