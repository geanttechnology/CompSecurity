// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;
import com.cyberlink.youcammakeup.jniproxy.ai;
import com.cyberlink.youcammakeup.kernelctrl.VenusHelper;
import com.cyberlink.youcammakeup.kernelctrl.ar;
import com.cyberlink.youcammakeup.masteraccess.Exporter;
import com.pf.common.utility.m;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import junit.framework.Assert;

public class aa
{

    public static Bitmap a(Resources resources, int i)
    {
        Bitmap bitmap;
        try
        {
            bitmap = BitmapFactory.decodeResource(resources, i);
        }
        catch (Exception exception)
        {
            try
            {
                resources = BitmapFactory.decodeResource(resources, i);
            }
            // Misplaced declaration of an exception variable
            catch (Resources resources)
            {
                return null;
            }
            return resources;
        }
        return bitmap;
    }

    public static Bitmap a(Bitmap bitmap, ar ar1, UIImageOrientation uiimageorientation, boolean flag)
    {
        uiimageorientation = new ar(ar1.a);
        uiimageorientation.b = VenusHelper.a(bitmap.getWidth(), bitmap.getHeight(), ar1.b, UIImageOrientation.b);
        ar1 = a(new Rect(((ar) (uiimageorientation)).b.b(), ((ar) (uiimageorientation)).b.c(), ((ar) (uiimageorientation)).b.d(), ((ar) (uiimageorientation)).b.e()), 172, 211, bitmap.getWidth(), bitmap.getHeight(), flag);
        uiimageorientation = new Canvas();
        int i = ((Rect) (ar1)).right - ((Rect) (ar1)).left;
        int j = ((Rect) (ar1)).bottom - ((Rect) (ar1)).top;
        RectF rectf = new RectF(0.0F, 0.0F, i, j);
        Bitmap bitmap1 = Bitmap.createBitmap(i, j, bitmap.getConfig());
        uiimageorientation.setBitmap(bitmap1);
        uiimageorientation.drawBitmap(bitmap, ar1, rectf, new Paint());
        return bitmap1;
    }

    public static Bitmap a(Bitmap bitmap, boolean flag)
    {
        int j;
        int k;
        int i1;
        k = bitmap.getWidth();
        i1 = bitmap.getHeight();
        j = k;
        if (!flag) goto _L2; else goto _L1
_L1:
        int i;
        i = k;
        if (k % 2 == 1)
        {
            i = k + 1;
        }
        j = i;
        if (i1 % 2 != 1) goto _L2; else goto _L3
_L3:
        int l = i1 + 1;
        j = i;
        i = l;
_L5:
        Bitmap bitmap1 = Bitmap.createBitmap(j, i, android.graphics.Bitmap.Config.RGB_565);
        (new Canvas(bitmap1)).drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, bitmap1.getWidth(), bitmap1.getHeight()), a());
        return bitmap1;
_L2:
        i = i1;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static Bitmap a(String s, int i, int j, int k, boolean flag)
    {
        double d;
        double d1;
        double d2;
        Object obj;
        Bitmap bitmap;
        boolean flag1;
        if (s != null && !s.equals("") && j > 0 && i > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assert.assertTrue(flag1);
        obj = new android.graphics.BitmapFactory.Options();
        obj.inJustDecodeBounds = true;
        bitmap = BitmapFactory.decodeFile(s, ((android.graphics.BitmapFactory.Options) (obj)));
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        bitmap.recycle();
        m.b("ImageUtils", (new StringBuilder()).append("extractThumbNail: round=").append(i).append("x").append(j).append(", crop=").append(flag).toString());
        d1 = ((double)((android.graphics.BitmapFactory.Options) (obj)).outHeight * 1.0D) / (double)j;
        d2 = ((double)((android.graphics.BitmapFactory.Options) (obj)).outWidth * 1.0D) / (double)i;
        m.b("ImageUtils", (new StringBuilder()).append("extractThumbNail: extract beX = ").append(d2).append(", beY = ").append(d1).toString());
        if (flag)
        {
            if (d1 > d2)
            {
                d = d2;
            } else
            {
                d = d1;
            }
        } else
        if (d1 < d2)
        {
            d = d2;
        } else
        {
            d = d1;
        }
        obj.inSampleSize = (int)d;
        if (((android.graphics.BitmapFactory.Options) (obj)).inSampleSize <= 1)
        {
            obj.inSampleSize = 1;
        }
        for (; (((android.graphics.BitmapFactory.Options) (obj)).outHeight * ((android.graphics.BitmapFactory.Options) (obj)).outWidth) / ((android.graphics.BitmapFactory.Options) (obj)).inSampleSize > k; obj.inSampleSize = ((android.graphics.BitmapFactory.Options) (obj)).inSampleSize + 1) { }
          goto _L1
        s;
        m.e("ImageUtils", (new StringBuilder()).append("decode bitmap failed: ").append(s.getMessage()).toString());
        obj = null;
_L11:
        return ((Bitmap) (obj));
_L1:
        if (!flag) goto _L3; else goto _L2
_L2:
        if (d1 <= d2) goto _L5; else goto _L4
_L4:
        d = i;
        int l = (int)((d * 1.0D * (double)((android.graphics.BitmapFactory.Options) (obj)).outHeight) / (double)((android.graphics.BitmapFactory.Options) (obj)).outWidth);
        k = i;
_L7:
        obj.inJustDecodeBounds = false;
        m.c("ImageUtils", (new StringBuilder()).append("bitmap required size=").append(k).append("x").append(l).append(", orig=").append(((android.graphics.BitmapFactory.Options) (obj)).outWidth).append("x").append(((android.graphics.BitmapFactory.Options) (obj)).outHeight).append(", sample=").append(((android.graphics.BitmapFactory.Options) (obj)).inSampleSize).toString());
        obj = BitmapFactory.decodeFile(s, ((android.graphics.BitmapFactory.Options) (obj)));
        if (obj != null)
        {
            break; /* Loop/switch isn't completed */
        }
        m.e("ImageUtils", "bitmap decode failed");
        return null;
_L5:
        k = (int)(((double)j * 1.0D * (double)((android.graphics.BitmapFactory.Options) (obj)).outWidth) / (double)((android.graphics.BitmapFactory.Options) (obj)).outHeight);
        l = j;
        continue; /* Loop/switch isn't completed */
_L3:
        if (d1 >= d2)
        {
            break MISSING_BLOCK_LABEL_517;
        }
        l = (int)(((double)i * 1.0D * (double)((android.graphics.BitmapFactory.Options) (obj)).outHeight) / (double)((android.graphics.BitmapFactory.Options) (obj)).outWidth);
        k = i;
        continue; /* Loop/switch isn't completed */
        k = (int)(((double)j * 1.0D * (double)((android.graphics.BitmapFactory.Options) (obj)).outWidth) / (double)((android.graphics.BitmapFactory.Options) (obj)).outHeight);
        l = j;
        if (true) goto _L7; else goto _L6
_L6:
        m.c("ImageUtils", (new StringBuilder()).append("bitmap decoded size=").append(((Bitmap) (obj)).getWidth()).append("x").append(((Bitmap) (obj)).getHeight()).toString());
        if (k == ((Bitmap) (obj)).getWidth() && l == ((Bitmap) (obj)).getHeight()) goto _L9; else goto _L8
_L8:
        s = Bitmap.createScaledBitmap(((Bitmap) (obj)), k, l, true);
_L12:
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_719;
        }
        ((Bitmap) (obj)).recycle();
_L13:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_709;
        }
        Bitmap bitmap1 = Bitmap.createBitmap(s, s.getWidth() - i >> 1, s.getHeight() - j >> 1, i, j);
        obj = s;
        if (bitmap1 == null) goto _L11; else goto _L10
_L10:
        s.recycle();
        m.c("ImageUtils", (new StringBuilder()).append("bitmap croped size=").append(bitmap1.getWidth()).append("x").append(bitmap1.getHeight()).toString());
        s = bitmap1;
        return s;
_L9:
        s = null;
          goto _L12
        s = ((String) (obj));
          goto _L13
    }

    public static Paint a()
    {
        return new Paint(195);
    }

    public static Rect a(Rect rect, int i, int j, int k, int l, boolean flag)
    {
        boolean flag1 = false;
        float f;
        float f1;
        if (flag)
        {
            int i1 = rect.left - rect.width() / 4;
            int l1 = rect.right + rect.width() / 4;
            int k1 = rect.top - rect.height() / 2;
            int j1 = rect.bottom;
            if (i1 <= 0)
            {
                i1 = 0;
            }
            rect.left = i1;
            i1 = k;
            if (l1 < k)
            {
                i1 = l1;
            }
            rect.right = i1;
            k = ((flag1) ? 1 : 0);
            if (k1 > 0)
            {
                k = k1;
            }
            rect.top = k;
            k = l;
            if (j1 < l)
            {
                k = j1;
            }
            rect.bottom = k;
        }
        k = rect.right - rect.left;
        l = rect.bottom - rect.top;
        f = (float)i / (float)j;
        f1 = (float)k / (float)l;
        if (f1 <= f || f1 > f && f1 > 1.0F && f < 1.0F)
        {
            i = (int)((float)l * f);
            j = rect.left;
            rect.left = (int)((double)(k - i) / 2D) + j;
            rect.right = rect.left + i;
        } else
        if (f1 > f)
        {
            rect.bottom = (int)((float)k / f) + rect.top;
            return rect;
        }
        return rect;
    }

    public static final void a(Bitmap bitmap)
    {
        if (bitmap == null || bitmap.isRecycled())
        {
            break MISSING_BLOCK_LABEL_15;
        }
        bitmap.recycle();
        return;
        bitmap;
    }

    public static void a(Bitmap bitmap, android.graphics.Bitmap.CompressFormat compressformat, String s, boolean flag)
    {
        if (flag)
        {
            Exporter.a(s);
        }
        s = new File(s);
        FileOutputStream fileoutputstream = new FileOutputStream(s);
        s = fileoutputstream;
        bitmap.compress(compressformat, 100, fileoutputstream);
        if (fileoutputstream == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        fileoutputstream.flush();
        fileoutputstream.close();
_L2:
        return;
        bitmap;
        m.e("dumpBitmap", bitmap.getMessage());
        return;
        compressformat;
        bitmap = null;
_L5:
        s = bitmap;
        m.b("ImageUtils", "dumpBitmap", compressformat);
        if (bitmap == null) goto _L2; else goto _L1
_L1:
        try
        {
            bitmap.flush();
            bitmap.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            m.e("dumpBitmap", bitmap.getMessage());
        }
        return;
        bitmap;
        s = null;
_L4:
        if (s != null)
        {
            try
            {
                s.flush();
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (android.graphics.Bitmap.CompressFormat compressformat)
            {
                m.e("dumpBitmap", compressformat.getMessage());
            }
        }
        throw bitmap;
        bitmap;
        if (true) goto _L4; else goto _L3
_L3:
        compressformat;
        bitmap = fileoutputstream;
          goto _L5
    }

    public static void a(Drawable drawable)
    {
        if (drawable instanceof BitmapDrawable)
        {
            a(((BitmapDrawable)drawable).getBitmap());
        }
        drawable.setCallback(null);
    }

    public static void a(int ai1[], int i, int j, android.graphics.Bitmap.Config config, int k, int l, int i1, int j1)
    {
        config = Bitmap.createBitmap(i, j, config);
        config.setPixels(ai1, k, l, i1, j1, i, j);
        config = c(config);
        config.getPixels(ai1, 0, config.getWidth(), 0, 0, config.getWidth(), config.getHeight());
        a(((Bitmap) (config)));
    }

    public static final boolean b(Bitmap bitmap)
    {
        return bitmap != null && !bitmap.isRecycled();
    }

    public static byte[] b(Bitmap bitmap, boolean flag)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, bytearrayoutputstream);
        if (flag)
        {
            bitmap.recycle();
        }
        bitmap = bytearrayoutputstream.toByteArray();
        try
        {
            bytearrayoutputstream.close();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return bitmap;
        }
        return bitmap;
    }

    public static Bitmap c(Bitmap bitmap)
    {
        Matrix matrix = new Matrix();
        matrix.preScale(-1F, 1.0F);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }
}
