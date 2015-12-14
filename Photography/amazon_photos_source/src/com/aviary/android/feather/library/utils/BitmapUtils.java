// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.aviary.android.feather.library.graphics.Point2D;
import java.io.ByteArrayOutputStream;

public final class BitmapUtils
{
    public static final class FLIP_MODE extends Enum
    {

        private static final FLIP_MODE $VALUES[];
        public static final FLIP_MODE Horizontal;
        public static final FLIP_MODE HorizontalVertical;
        public static final FLIP_MODE None;
        public static final FLIP_MODE Vertical;

        public static FLIP_MODE valueOf(String s)
        {
            return (FLIP_MODE)Enum.valueOf(com/aviary/android/feather/library/utils/BitmapUtils$FLIP_MODE, s);
        }

        public static FLIP_MODE[] values()
        {
            return (FLIP_MODE[])$VALUES.clone();
        }

        static 
        {
            None = new FLIP_MODE("None", 0);
            Horizontal = new FLIP_MODE("Horizontal", 1);
            Vertical = new FLIP_MODE("Vertical", 2);
            HorizontalVertical = new FLIP_MODE("HorizontalVertical", 3);
            $VALUES = (new FLIP_MODE[] {
                None, Horizontal, Vertical, HorizontalVertical
            });
        }

        private FLIP_MODE(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class ROTATION extends Enum
    {

        private static final ROTATION $VALUES[];
        public static final ROTATION ROTATE_180;
        public static final ROTATION ROTATE_270;
        public static final ROTATION ROTATE_90;
        public static final ROTATION ROTATE_NULL;

        public static ROTATION valueOf(String s)
        {
            return (ROTATION)Enum.valueOf(com/aviary/android/feather/library/utils/BitmapUtils$ROTATION, s);
        }

        public static ROTATION[] values()
        {
            return (ROTATION[])$VALUES.clone();
        }

        static 
        {
            ROTATE_90 = new ROTATION("ROTATE_90", 0);
            ROTATE_180 = new ROTATION("ROTATE_180", 1);
            ROTATE_270 = new ROTATION("ROTATE_270", 2);
            ROTATE_NULL = new ROTATION("ROTATE_NULL", 3);
            $VALUES = (new ROTATION[] {
                ROTATE_90, ROTATE_180, ROTATE_270, ROTATE_NULL
            });
        }

        private ROTATION(String s, int i)
        {
            super(s, i);
        }
    }


    private static final int COMPRESS_JPEG_QUALITY = 90;
    static final String LOG_TAG = "bitmap-utils";
    public static final int UNCONSTRAINED = -1;
    static PorterDuffColorFilter mWhiteMultiplyFilter;

    private BitmapUtils()
    {
    }

    public static Bitmap circleMask(Bitmap bitmap, float f)
    {
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap1);
        Shader shader = createShader(bitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(shader);
        canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2, f, paint);
        return bitmap1;
    }

    public static boolean compareBySize(Drawable drawable, Bitmap bitmap)
    {
        while (drawable == null || bitmap == null || drawable.getIntrinsicWidth() != bitmap.getWidth() || drawable.getIntrinsicHeight() != bitmap.getHeight()) 
        {
            return true;
        }
        return false;
    }

    public static boolean compareBySize(Drawable drawable, Drawable drawable1)
    {
        while (drawable == null || drawable1 == null || drawable.getIntrinsicWidth() != drawable1.getIntrinsicWidth() || drawable.getIntrinsicHeight() != drawable1.getIntrinsicHeight()) 
        {
            return true;
        }
        return false;
    }

    public static byte[] compressBitmap(Bitmap bitmap)
    {
        return compressBitmap(bitmap, android.graphics.Bitmap.CompressFormat.JPEG, 90);
    }

    public static byte[] compressBitmap(Bitmap bitmap, android.graphics.Bitmap.CompressFormat compressformat, int i)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        bitmap.compress(compressformat, i, bytearrayoutputstream);
        return bytearrayoutputstream.toByteArray();
    }

    private static int computeInitialSampleSize(int i, int j, int k, int l)
    {
        boolean flag = true;
        int i1 = 1;
        if (l != -1 || k != -1)
        {
            if (l == -1)
            {
                l = ((flag) ? 1 : 0);
            } else
            {
                l = (int)Math.ceil(Math.sqrt((double)(i * j) / (double)l));
            }
            i1 = l;
            if (k != -1)
            {
                return Math.max(Math.min(i / k, j / k), l);
            }
        }
        return i1;
    }

    public static int computeSampleSizeWithMaxPixels(int i, int j, int k, int l)
    {
        return computeInitialSampleSize(i, j, k, l);
    }

    public static int computeSampleSizeWithMaxPixels(int i, int j, int k, int l, int i1)
    {
        int j1 = i;
        int k1 = j;
        if (i1 == 90 || i1 == 270)
        {
            j1 = j;
            k1 = i;
        }
        return computeSampleSizeWithMaxPixels(j1, k1, k, l);
    }

    public static Bitmap convertToAlphaMask(Bitmap bitmap)
    {
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ALPHA_8);
        (new Canvas(bitmap1)).drawBitmap(bitmap, 0.0F, 0.0F, null);
        return bitmap1;
    }

    public static Bitmap copy(Bitmap bitmap, int i)
    {
        Bitmap bitmap1;
        Paint paint;
        try
        {
            bitmap1 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            return null;
        }
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setAlpha(i);
        (new Canvas(bitmap1)).drawBitmap(bitmap, new Matrix(), paint);
        return bitmap1;
    }

    public static Bitmap copy(Bitmap bitmap, android.graphics.Bitmap.Config config)
    {
        int i = bitmap.getWidth();
        int j = bitmap.getHeight();
        android.graphics.Bitmap.Config config1 = config;
        if (config == null)
        {
            config1 = android.graphics.Bitmap.Config.ARGB_8888;
        }
        config = Bitmap.createBitmap(i, j, config1);
        (new Canvas(config)).drawBitmap(bitmap, new Matrix(), null);
        return config;
    }

    public static void copy(Bitmap bitmap, Bitmap bitmap1)
    {
        if (bitmap.getWidth() == bitmap1.getWidth() && bitmap.getHeight() == bitmap1.getHeight())
        {
            (new Canvas(bitmap1)).drawBitmap(bitmap, new Matrix(), null);
            return;
        } else
        {
            Canvas canvas = new Canvas(bitmap1);
            Paint paint = new Paint();
            canvas.drawBitmap(bitmap, null, new Rect(0, 0, bitmap1.getWidth(), bitmap1.getHeight()), paint);
            return;
        }
    }

    public static Shader createShader(Bitmap bitmap)
    {
        return new BitmapShader(bitmap, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP);
    }

    public static Bitmap createThumbnail(Bitmap bitmap, int i, int j, int k, int l)
    {
        return createThumbnail(bitmap, i, j, ROTATION.ROTATE_NULL, FLIP_MODE.None, null, k, l, 0, 0.0F);
    }

    public static Bitmap createThumbnail(Bitmap bitmap, int i, int j, ColorMatrixColorFilter colormatrixcolorfilter, int k)
    {
        return createThumbnail(bitmap, i, j, ROTATION.ROTATE_NULL, FLIP_MODE.None, colormatrixcolorfilter, k, k, 0, 0.0F);
    }

    public static Bitmap createThumbnail(Bitmap bitmap, int i, int j, FLIP_MODE flip_mode, int k)
        throws OutOfMemoryError
    {
        return createThumbnail(bitmap, i, j, ROTATION.ROTATE_NULL, flip_mode, null, k, k, 0, 0.0F);
    }

    public static Bitmap createThumbnail(Bitmap bitmap, int i, int j, ROTATION rotation, int k)
        throws OutOfMemoryError
    {
        return createThumbnail(bitmap, i, j, rotation, FLIP_MODE.None, null, k, k, 0, 0.0F);
    }

    public static Bitmap createThumbnail(Bitmap bitmap, int i, int j, ROTATION rotation, FLIP_MODE flip_mode, ColorMatrixColorFilter colormatrixcolorfilter, int k, int l, 
            int i1, float f)
        throws OutOfMemoryError
    {
        RectF rectf = new RectF(0.0F, 0.0F, i, j);
        Bitmap bitmap1 = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap1);
        canvas.drawColor(0);
        Paint paint = new Paint(1);
        paint.setAntiAlias(true);
        paint.setStyle(android.graphics.Paint.Style.FILL);
        paint.setColor(k);
        Path path = new Path();
        path.addRoundRect(rectf, f, f, android.graphics.Path.Direction.CW);
        canvas.clipPath(path, android.graphics.Region.Op.REPLACE);
        canvas.drawRect(rectf, paint);
        drawBitmapOnCanvas(bitmap, i, j, rotation, flip_mode, colormatrixcolorfilter, i1, canvas);
        if (l != k)
        {
            bitmap = new Paint(1);
            bitmap.setStyle(android.graphics.Paint.Style.STROKE);
            bitmap.setStrokeWidth(4F);
            bitmap.setColor(l);
            canvas.drawRoundRect(rectf, f, f, bitmap);
        }
        return bitmap1;
    }

    public static Bitmap createThumbnail(Bitmap bitmap, int i, int j, ROTATION rotation, FLIP_MODE flip_mode, ColorMatrixColorFilter colormatrixcolorfilter, Drawable drawable, int k, 
            float f)
        throws OutOfMemoryError
    {
        Bitmap bitmap1 = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap1);
        canvas.drawColor(0);
        drawable.setBounds(0, 0, i, j);
        drawable.draw(canvas);
        drawBitmapOnCanvas(bitmap, i, j, rotation, flip_mode, colormatrixcolorfilter, k, canvas);
        return bitmap1;
    }

    public static Bitmap cropCenter(Bitmap bitmap, int i, int j, android.graphics.Bitmap.Config config)
    {
        Bitmap bitmap1;
label0:
        {
            int k = bitmap.getWidth();
            int l = bitmap.getHeight();
            if (k <= i)
            {
                bitmap1 = bitmap;
                if (l <= j)
                {
                    break label0;
                }
            }
            bitmap1 = Bitmap.createBitmap(i, j, config);
            config = new Canvas(bitmap1);
            config.translate((i - k) / 2, (j - l) / 2);
            config.drawBitmap(bitmap, 0.0F, 0.0F, new Paint(2));
        }
        return bitmap1;
    }

    private static void drawBitmapOnCanvas(Bitmap bitmap, int i, int j, ROTATION rotation, FLIP_MODE flip_mode, ColorMatrixColorFilter colormatrixcolorfilter, int k, Canvas canvas)
    {
        Matrix matrix;
        float f;
        float f2;
        float f4;
        float f5;
        Paint paint;
label0:
        {
            paint = new Paint();
            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            matrix = new Matrix();
            int l = bitmap.getWidth();
            int i1 = bitmap.getHeight();
            float f3 = (float)i - (float)k;
            float f1 = (float)j - (float)k;
            f4 = l;
            f5 = i1;
            f2 = f1;
            f = f3;
            if (rotation == null)
            {
                break label0;
            }
            if (rotation != ROTATION.ROTATE_90)
            {
                f2 = f1;
                f = f3;
                if (rotation != ROTATION.ROTATE_270)
                {
                    break label0;
                }
            }
            f = f1;
            f2 = i;
        }
        f = Math.min(f / f4, f2 / f5);
        if (rotation == null)
        {
            k = 0;
        } else
        {
            k = getRotationDegrees(rotation);
        }
        matrix.preTranslate(-f4 / 2.0F, -f5 / 2.0F);
        matrix.postScale(f, f);
        if (k != 0)
        {
            matrix.postRotate(k);
        }
        if (flip_mode == FLIP_MODE.None) goto _L2; else goto _L1
_L1:
        if (flip_mode != FLIP_MODE.Horizontal) goto _L4; else goto _L3
_L3:
        matrix.postScale(-1F, 1.0F);
_L2:
        matrix.postTranslate((float)i / 2.0F, (float)j / 2.0F);
        if (colormatrixcolorfilter != null)
        {
            paint.setColorFilter(colormatrixcolorfilter);
        }
        canvas.drawBitmap(bitmap, matrix, paint);
        return;
_L4:
        if (flip_mode == FLIP_MODE.Vertical)
        {
            matrix.postScale(1.0F, -1F);
        } else
        if (flip_mode == FLIP_MODE.HorizontalVertical)
        {
            matrix.postScale(-1F, -1F);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public static Bitmap extractDrawable(Drawable drawable, int i, int j)
    {
        if (drawable instanceof BitmapDrawable)
        {
            return Bitmap.createScaledBitmap(((BitmapDrawable)drawable).getBitmap(), i, j, false);
        } else
        {
            Bitmap bitmap = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, i, j);
            drawable.draw(canvas);
            return bitmap;
        }
    }

    public static Bitmap flattenDrawables(Drawable drawable, Drawable drawable1, float f, float f1)
    {
        int i = drawable.getIntrinsicWidth();
        int j = drawable.getIntrinsicHeight();
        drawable.setBounds(0, 0, i, j);
        Bitmap bitmap = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.draw(canvas);
        float f2 = (float)i * f;
        f = (float)j * f;
        float f3 = ((float)i - f2) / 2.0F;
        f1 = ((float)j - f) / 2.0F + (float)j * f1;
        drawable1.setBounds((int)f3, (int)f1, (int)(f3 + f2), (int)(f1 + f));
        drawable1.setColorFilter(mWhiteMultiplyFilter);
        drawable1.setFilterBitmap(true);
        drawable1.draw(canvas);
        return bitmap;
    }

    public static Bitmap flip(Bitmap bitmap, FLIP_MODE flip_mode)
        throws OutOfMemoryError
    {
        Matrix matrix = new Matrix();
        static class _cls1
        {

            static final int $SwitchMap$com$aviary$android$feather$library$utils$BitmapUtils$FLIP_MODE[];
            static final int $SwitchMap$com$aviary$android$feather$library$utils$BitmapUtils$ROTATION[];

            static 
            {
                $SwitchMap$com$aviary$android$feather$library$utils$BitmapUtils$ROTATION = new int[ROTATION.values().length];
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$utils$BitmapUtils$ROTATION[ROTATION.ROTATE_NULL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$utils$BitmapUtils$ROTATION[ROTATION.ROTATE_90.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$utils$BitmapUtils$ROTATION[ROTATION.ROTATE_180.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$utils$BitmapUtils$ROTATION[ROTATION.ROTATE_270.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                $SwitchMap$com$aviary$android$feather$library$utils$BitmapUtils$FLIP_MODE = new int[FLIP_MODE.values().length];
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$utils$BitmapUtils$FLIP_MODE[FLIP_MODE.None.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$utils$BitmapUtils$FLIP_MODE[FLIP_MODE.Horizontal.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$utils$BitmapUtils$FLIP_MODE[FLIP_MODE.Vertical.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$utils$BitmapUtils$FLIP_MODE[FLIP_MODE.HorizontalVertical.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.aviary.android.feather.library.utils.BitmapUtils.FLIP_MODE[flip_mode.ordinal()];
        JVM INSTR tableswitch 2 4: default 44
    //                   2 46
    //                   3 71
    //                   4 82;
           goto _L1 _L2 _L3 _L4
_L1:
        return bitmap;
_L2:
        matrix.setScale(-1F, 1.0F);
_L6:
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
_L3:
        matrix.setScale(1.0F, -1F);
        continue; /* Loop/switch isn't completed */
_L4:
        matrix.setScale(-1F, -1F);
        if (true) goto _L6; else goto _L5
_L5:
    }

    private static android.graphics.Bitmap.Config getConfig(Bitmap bitmap)
    {
        android.graphics.Bitmap.Config config = bitmap.getConfig();
        bitmap = config;
        if (config == null)
        {
            bitmap = android.graphics.Bitmap.Config.ARGB_8888;
        }
        return bitmap;
    }

    public static int getRotationDegrees(ROTATION rotation)
    {
        switch (_cls1..SwitchMap.com.aviary.android.feather.library.utils.BitmapUtils.ROTATION[rotation.ordinal()])
        {
        default:
            return 0;

        case 2: // '\002'
            return 90;

        case 3: // '\003'
            return 180;

        case 4: // '\004'
            return 270;
        }
    }

    public static Bitmap glow(Bitmap bitmap, int i)
    {
        Bitmap bitmap1 = copy(bitmap, android.graphics.Bitmap.Config.ARGB_8888);
        if (bitmap1 != null)
        {
            glow(bitmap, bitmap1, i);
            return bitmap1;
        } else
        {
            return null;
        }
    }

    public static void glow(Bitmap bitmap, Bitmap bitmap1, int i)
    {
        bitmap = bitmap.extractAlpha();
        BlurMaskFilter blurmaskfilter = new BlurMaskFilter(i, android.graphics.BlurMaskFilter.Blur.OUTER);
        Paint paint = new Paint();
        paint.setMaskFilter(blurmaskfilter);
        paint.setColor(0xff0090f4);
        (new Canvas(bitmap1)).drawBitmap(bitmap, 0.0F, 0.0F, paint);
    }

    public static int[] resize(int i, int j, int k, int l, int i1)
    {
        int ai[];
        int j1;
        int k1;
        j1 = k;
        k1 = l;
        if (i1 == 90 || i1 == 270)
        {
            j1 = l;
            k1 = k;
        }
        k = 0;
        if (i > j1 || j > k1)
        {
            k = 1;
            if ((double)i / (double)j1 > (double)j / (double)k1)
            {
                double d = (double)j1 / (double)i;
                k1 = (int)((double)j * d);
            } else
            {
                double d1 = (double)k1 / (double)j;
                j1 = (int)((double)i * d1);
            }
        } else
        {
            j1 = i;
            k1 = j;
        }
        if (k == 0 && i1 == 0)
        {
            break MISSING_BLOCK_LABEL_242;
        }
        if (i1 != 0) goto _L2; else goto _L1
_L1:
        ai = new int[2];
        ai[0] = j1;
        ai[1] = k1;
_L4:
        return ai;
_L2:
        Log.e("bitmap-utils", (new StringBuilder()).append("rotation: ").append(i1).toString());
        i = (int)Point2D.angle360(i1);
        Log.e("bitmap-utils", (new StringBuilder()).append("rotation(2): ").append(i).toString());
        ai = new int[2];
        ai[0] = j1;
        ai[1] = k1;
        if (i != 90 && i != 270) goto _L4; else goto _L3
_L3:
        return (new int[] {
            k1, j1
        });
        return (new int[] {
            i, j
        });
    }

    public static Bitmap resizeAndRotateBySide(Bitmap bitmap, int i, int j, boolean flag, int k, boolean flag1)
    {
        int i1 = bitmap.getWidth();
        int l = bitmap.getHeight();
        if (k == 90 || k == 270)
        {
            i1 = bitmap.getHeight();
            l = bitmap.getWidth();
        }
        float f;
        float f1;
        boolean flag2;
        if (k != 0)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        f1 = 0.0F;
        if (i1 > i && flag)
        {
            f = (float)i / (float)i1;
        } else
        {
            f = f1;
            if (l > j)
            {
                f = f1;
                if (!flag)
                {
                    f = (float)j / (float)l;
                }
            }
        }
        if (f != 0.0F)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i == 0 && !flag2)
        {
            return bitmap;
        }
        Bitmap bitmap1;
        int j1;
        if (f != 0.0F)
        {
            j1 = Math.round((float)i1 * f);
            j = Math.round((float)l * f);
        } else
        {
            j1 = i1;
            j = l;
        }
        if (!flag2)
        {
            bitmap1 = Bitmap.createScaledBitmap(bitmap, j1, j, true);
        } else
        {
            if (i == 0)
            {
                f = 1.0F;
            }
            bitmap1 = Bitmap.createBitmap(j1, j, getConfig(bitmap));
            Canvas canvas = new Canvas(bitmap1);
            Matrix matrix = new Matrix();
            matrix.postTranslate(-bitmap.getWidth() / 2, -bitmap.getHeight() / 2);
            matrix.postScale(f, f);
            matrix.postRotate(k);
            matrix.postTranslate(((float)i1 * f) / 2.0F, ((float)l * f) / 2.0F);
            canvas.drawBitmap(bitmap, matrix, new Paint(6));
        }
        if (flag1)
        {
            bitmap.recycle();
        }
        return bitmap1;
    }

    public static Bitmap resizeBitmap(Bitmap bitmap, int i, int j)
        throws OutOfMemoryError
    {
        return resizeBitmap(bitmap, i, j, 0);
    }

    public static Bitmap resizeBitmap(Bitmap bitmap, int i, int j, int k)
        throws OutOfMemoryError
    {
label0:
        {
            int l = i;
            int i1 = j;
            int j1 = bitmap.getWidth();
            int k1 = bitmap.getHeight();
            if (k == 90 || k == 270)
            {
                l = j;
                i1 = i;
            }
            i = 0;
            if (j1 > l || k1 > i1)
            {
                i = 1;
                Bitmap bitmap1;
                if ((double)j1 / (double)l > (double)k1 / (double)i1)
                {
                    double d = (double)l / (double)j1;
                    i1 = (int)((double)k1 * d);
                } else
                {
                    double d1 = (double)i1 / (double)k1;
                    l = (int)((double)j1 * d1);
                }
            } else
            {
                l = j1;
                i1 = k1;
            }
            if (i == 0)
            {
                bitmap1 = bitmap;
                if (k == 0)
                {
                    break label0;
                }
            }
            if (k == 0)
            {
                bitmap = Bitmap.createScaledBitmap(bitmap, l, i1, true);
            } else
            {
                Matrix matrix = new Matrix();
                matrix.postScale((float)l / (float)j1, (float)i1 / (float)k1);
                matrix.postRotate(k);
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, j1, k1, matrix, true);
            }
            bitmap1 = bitmap;
        }
        return bitmap1;
    }

    public static Bitmap rotate(Bitmap bitmap, int i, boolean flag)
    {
        if (i % 360 == 0)
        {
            return bitmap;
        }
        Object obj = new Matrix();
        ((Matrix) (obj)).postRotate(i);
        obj = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), ((Matrix) (obj)), true);
        if (flag)
        {
            bitmap.recycle();
        }
        return ((Bitmap) (obj));
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, ROTATION rotation)
        throws OutOfMemoryError
    {
        if (rotation != ROTATION.ROTATE_NULL)
        {
            Matrix matrix = new Matrix();
            matrix.setRotate(getRotationDegrees(rotation), (float)bitmap.getWidth() / 2.0F, (float)bitmap.getHeight() / 2.0F);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } else
        {
            return bitmap;
        }
    }

    public static Bitmap roundedCorners(Bitmap bitmap, float f, float f1)
    {
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap1);
        Shader shader = createShader(bitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(shader);
        canvas.drawRoundRect(new RectF(0.0F, 0.0F, bitmap.getWidth(), bitmap.getHeight()), f, f1, paint);
        return bitmap1;
    }

    static 
    {
        mWhiteMultiplyFilter = new PorterDuffColorFilter(-1, android.graphics.PorterDuff.Mode.MULTIPLY);
    }
}
