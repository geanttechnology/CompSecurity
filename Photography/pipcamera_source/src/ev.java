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
import android.util.Log;
import java.io.InputStream;
import java.lang.reflect.Array;

public class ev
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

    public static android.graphics.Bitmap.Config a(boolean flag)
    {
        if (flag)
        {
            return android.graphics.Bitmap.Config.RGB_565;
        } else
        {
            return android.graphics.Bitmap.Config.ARGB_8888;
        }
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

    public static Bitmap a(Bitmap bitmap, int i)
    {
        bitmap = bitmap.copy(bitmap.getConfig(), true);
        if (i < 1)
        {
            return null;
        }
        int k10 = bitmap.getWidth();
        int l10 = bitmap.getHeight();
        int ai[] = new int[k10 * l10];
        Log.e("pix", (new StringBuilder()).append(k10).append(" ").append(l10).append(" ").append(ai.length).toString());
        bitmap.getPixels(ai, 0, k10, 0, 0, k10, l10);
        int l9 = k10 - 1;
        int i11 = l10 - 1;
        int j = k10 * l10;
        int j11 = i + i + 1;
        int ai1[] = new int[j];
        int ai2[] = new int[j];
        int ai3[] = new int[j];
        int ai4[] = new int[Math.max(k10, l10)];
        j = j11 + 1 >> 1;
        int k11 = j * j;
        int ai5[] = new int[256];
        for (j = 0; j < 256; j++)
        {
            ai5[j] = j;
        }

        int ai6[][] = (int[][])Array.newInstance(Integer.TYPE, new int[] {
            j11, 3
        });
        int l11 = i + 1;
        int j6 = 0;
        j = 0;
        for (int l5 = 0; l5 < l10; l5++)
        {
            int l = 0;
            int l6 = -i;
            int i2 = 0;
            int k2 = 0;
            int i3 = 0;
            int k3 = 0;
            int i4 = 0;
            int l4 = 0;
            int j5 = 0;
            int k1 = 0;
            while (l6 <= i) 
            {
                int k7 = ai[Math.min(l9, Math.max(l6, 0)) + j];
                int ai7[] = ai6[l6 + i];
                ai7[0] = (0xff0000 & k7) >> 16;
                ai7[1] = (0xff00 & k7) >> 8;
                ai7[2] = k7 & 0xff;
                k7 = l11 - Math.abs(l6);
                j5 += ai7[0] * k7;
                l4 += ai7[1] * k7;
                i4 += k7 * ai7[2];
                if (l6 > 0)
                {
                    i2 += ai7[0];
                    k1 += ai7[1];
                    l += ai7[2];
                } else
                {
                    k3 += ai7[0];
                    i3 += ai7[1];
                    k2 += ai7[2];
                }
                l6++;
            }
            l6 = l4;
            boolean flag = false;
            l4 = i;
            int l7 = j5;
            j5 = i4;
            for (int j4 = ((flag) ? 1 : 0); j4 < k10; j4++)
            {
                ai1[j] = ai5[l7 / k11];
                ai2[j] = ai5[l6 / k11];
                ai3[j] = ai5[j5 / k11];
                int ai8[] = ai6[((l4 - i) + j11) % j11];
                int l12 = ai8[0];
                int i12 = ai8[1];
                int l8 = ai8[2];
                if (l5 == 0)
                {
                    ai4[j4] = Math.min(j4 + i + 1, l9);
                }
                int i13 = ai[ai4[j4] + j6];
                ai8[0] = (0xff0000 & i13) >> 16;
                ai8[1] = (0xff00 & i13) >> 8;
                ai8[2] = i13 & 0xff;
                i2 += ai8[0];
                k1 += ai8[1];
                l += ai8[2];
                l7 = (l7 - k3) + i2;
                l6 = (l6 - i3) + k1;
                j5 = (j5 - k2) + l;
                l4 = (l4 + 1) % j11;
                ai8 = ai6[l4 % j11];
                k3 = (k3 - l12) + ai8[0];
                i3 = (i3 - i12) + ai8[1];
                k2 = (k2 - l8) + ai8[2];
                i2 -= ai8[0];
                k1 -= ai8[1];
                l -= ai8[2];
                j++;
            }

            j6 += k10;
        }

        for (int k = 0; k < k10; k++)
        {
            int k5 = 0;
            int k6 = -i * k10;
            int i6 = -i;
            int k4 = 0;
            int l2 = 0;
            int j3 = 0;
            int l3 = 0;
            int i1 = 0;
            int j2 = 0;
            int l1 = 0;
            int i5 = 0;
            while (i6 <= i) 
            {
                int i7 = Math.max(0, k6) + k;
                int ai9[] = ai6[i6 + i];
                ai9[0] = ai1[i7];
                ai9[1] = ai2[i7];
                ai9[2] = ai3[i7];
                int i8 = l11 - Math.abs(i6);
                int i9 = ai1[i7];
                int i10 = ai2[i7];
                int j12 = ai3[i7];
                if (i6 > 0)
                {
                    k4 += ai9[0];
                    i5 += ai9[1];
                    k5 += ai9[2];
                } else
                {
                    l3 += ai9[0];
                    j3 += ai9[1];
                    l2 += ai9[2];
                }
                i7 = k6;
                if (i6 < i11)
                {
                    i7 = k6 + k10;
                }
                i6++;
                i1 = j12 * i8 + i1;
                j2 = i10 * i8 + j2;
                l1 = i9 * i8 + l1;
                k6 = i7;
            }
            int j8 = j2;
            int j9 = l1;
            boolean flag1 = false;
            l1 = k;
            i6 = k5;
            k6 = i5;
            int j7 = k4;
            j2 = l2;
            l2 = j3;
            j3 = l3;
            l3 = i;
            k5 = j9;
            i5 = j8;
            k4 = i1;
            for (int j1 = ((flag1) ? 1 : 0); j1 < l10; j1++)
            {
                ai[l1] = 0xff000000 & ai[l1] | ai5[k5 / k11] << 16 | ai5[i5 / k11] << 8 | ai5[k4 / k11];
                int ai10[] = ai6[((l3 - i) + j11) % j11];
                int j10 = ai10[0];
                int k9 = ai10[1];
                int k8 = ai10[2];
                if (k == 0)
                {
                    ai4[j1] = Math.min(j1 + l11, i11) * k10;
                }
                int k12 = ai4[j1] + k;
                ai10[0] = ai1[k12];
                ai10[1] = ai2[k12];
                ai10[2] = ai3[k12];
                j7 += ai10[0];
                k6 += ai10[1];
                i6 += ai10[2];
                k5 = (k5 - j3) + j7;
                i5 = (i5 - l2) + k6;
                k4 = (k4 - j2) + i6;
                l3 = (l3 + 1) % j11;
                ai10 = ai6[l3];
                j3 = (j3 - j10) + ai10[0];
                l2 = (l2 - k9) + ai10[1];
                j2 = (j2 - k8) + ai10[2];
                j7 -= ai10[0];
                k6 -= ai10[1];
                i6 -= ai10[2];
                l1 += k10;
            }

        }

        Log.e("pix", (new StringBuilder()).append(k10).append(" ").append(l10).append(" ").append(ai.length).toString());
        bitmap.setPixels(ai, 0, k10, 0, 0, k10, l10);
        return bitmap;
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

    public static Bitmap a(Bitmap bitmap, int i, int j, android.graphics.Bitmap.Config config)
    {
        float f2 = bitmap.getWidth();
        float f3 = bitmap.getHeight();
        config = Bitmap.createBitmap(i, j, config);
        Canvas canvas = new Canvas(config);
        for (float f = 0.0F; f < (float)i; f += f2)
        {
            for (float f1 = 0.0F; f1 < (float)j; f1 += f3)
            {
                canvas.drawBitmap(bitmap, f, f1, null);
            }

        }

        return config;
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
}
