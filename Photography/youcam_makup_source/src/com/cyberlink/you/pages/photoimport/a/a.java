// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.pages.photoimport.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.AvoidXfermode;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.util.DisplayMetrics;
import android.util.Log;
import java.io.File;
import java.io.IOException;

public class a
{

    public static int a(android.graphics.BitmapFactory.Options options, int i, int j)
    {
        int k1 = options.outHeight;
        int l1 = options.outWidth;
        int l = 1;
        if (k1 > j || l1 > i)
        {
            int k = (int)Math.ceil((float)k1 / (float)j);
            l = (int)Math.ceil((float)l1 / (float)i);
            int i1 = k1 / 2;
            int j1 = l1 / 2;
            if (k >= l)
            {
                k = l;
            }
            for (; k1 / k > j && l1 / k > i; k++) { }
            float f = l1 * k1;
            float f1 = i * j * 2;
            l = k;
            if (f / (float)(k * k) > f1)
            {
                for (; i1 / k > j || j1 / k > i; k++) { }
                l = (int)Math.pow(2D, (int)Math.ceil(Math.sqrt(k)));
            }
        }
        return l;
    }

    public static int a(String s)
    {
        s = new ExifInterface(s);
        if (s == null) goto _L2; else goto _L1
_L1:
        int i = s.getAttributeInt("Orientation", -1);
        if (i == -1) goto _L2; else goto _L3
_L3:
        i;
        JVM INSTR tableswitch 3 8: default 64
    //                   3 69
    //                   4 64
    //                   5 64
    //                   6 66
    //                   7 64
    //                   8 73;
           goto _L2 _L4 _L2 _L2 _L5 _L2 _L6
_L2:
        return 0;
_L5:
        return 90;
_L4:
        return 180;
_L6:
        return 270;
    }

    public static Bitmap a(Context context, Bitmap bitmap, float f, float f1, float f2, float f3, int i, int j)
    {
        float f4 = context.getResources().getDisplayMetrics().density;
        context = Bitmap.createScaledBitmap(bitmap, Math.round((float)i * f4), Math.round((float)j * f4), true);
        bitmap = Bitmap.createBitmap(Math.round((float)i * f4), Math.round((float)j * f4), android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        i = canvas.getWidth();
        j = canvas.getHeight();
        f *= f4;
        f1 *= f4;
        f2 *= f4;
        f3 = f4 * f3;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-1);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(f, f, f, paint);
        canvas.drawCircle((float)i - f1, f1, f1, paint);
        canvas.drawCircle((float)i - f2, (float)j - f2, f2, paint);
        canvas.drawCircle(f3, (float)j - f3, f3, paint);
        Object obj = new RectF(f, 0.0F, (float)i - f1, j / 2);
        RectF rectf = new RectF(i / 2, f1, i, (float)j - f2);
        RectF rectf1 = new RectF(f3, j / 2, (float)i - f2, j);
        RectF rectf2 = new RectF(0.0F, f, i / 2, (float)j - f3);
        canvas.drawRect(((RectF) (obj)), paint);
        canvas.drawRect(rectf, paint);
        canvas.drawRect(rectf1, paint);
        canvas.drawRect(rectf2, paint);
        obj = new Rect(0, 0, i, j);
        paint.setXfermode(new AvoidXfermode(-1, 255, android.graphics.AvoidXfermode.Mode.TARGET));
        canvas.drawBitmap(context, ((Rect) (obj)), ((Rect) (obj)), paint);
        return bitmap;
    }

    public static Bitmap a(String s, boolean flag, int i)
    {
        Bitmap bitmap;
        int l1;
        Log.d("ImageUtil", "[decodeSampledBitmapFromFileWithEXIF] in");
        if (s == null || !(new File(s)).exists())
        {
            return null;
        }
        Object obj = new android.graphics.BitmapFactory.Options();
        obj.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(s, ((android.graphics.BitmapFactory.Options) (obj)));
        int j = ((android.graphics.BitmapFactory.Options) (obj)).outWidth;
        int l = ((android.graphics.BitmapFactory.Options) (obj)).outHeight;
        if (j <= 0 || l <= 0)
        {
            Log.d("ImageUtil", (new StringBuilder()).append("[decodeSampledBitmapFromFileWithEXIF] Decode File - 1 : width=").append(j).append(", height=").append(l).toString());
            return null;
        }
        if (j <= l)
        {
            j = l;
        }
        if (i <= 0)
        {
            i = 1280;
        }
        l1 = i;
        if (i > j)
        {
            l1 = j;
        }
        obj.inJustDecodeBounds = false;
        obj.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
        obj.inPurgeable = true;
        obj.inInputShareable = true;
        obj.inSampleSize = a(((android.graphics.BitmapFactory.Options) (obj)), l1, l1);
        bitmap = null;
        obj = BitmapFactory.decodeFile(s, ((android.graphics.BitmapFactory.Options) (obj)));
        bitmap = ((Bitmap) (obj));
_L2:
        if (bitmap == null)
        {
            return null;
        }
        break; /* Loop/switch isn't completed */
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        Log.e("ImageUtil", (new StringBuilder()).append("decodeFile ").append(s).append(" OutOfMemoryError").toString());
        if (true) goto _L2; else goto _L1
_L1:
        int k = bitmap.getWidth();
        i = bitmap.getHeight();
        if (k <= 0 || i <= 0)
        {
            Log.d("ImageUtil", (new StringBuilder()).append("[decodeSampledBitmapFromFileWithEXIF] Decode File - 2 : width=").append(k).append(", height=").append(i).toString());
            return null;
        }
        float f;
        int i1;
        int j1;
        int k1;
        boolean flag3;
        if (k < i)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        try
        {
            k1 = a(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("ImageUtil", "cannot get exif attribute", s);
            k1 = 0;
        }
        if (flag)
        {
            float f1;
            if (flag3)
            {
                j1 = 0;
            } else
            {
                j1 = (k - i) / 2;
            }
            if (flag3)
            {
                i1 = (i - k) / 2;
            } else
            {
                i1 = 0;
            }
            if (flag3)
            {
                i = k;
            }
            f1 = (float)l1 / (float)i;
            f = f1;
            if (f1 <= 0.0F)
            {
                f = 1.0F;
            }
            l1 = j1;
            j1 = i;
            k = i1;
            i1 = i;
            i = l1;
        } else
        {
            if (flag3)
            {
                i1 = i;
            } else
            {
                i1 = k;
            }
            f = (float)l1 / (float)i1;
            if (f <= 0.0F)
            {
                boolean flag1 = false;
                i1 = k;
                f = 1.0F;
                k = 0;
                j1 = i;
                i = k;
                k = ((flag1) ? 1 : 0);
            } else
            {
                boolean flag2 = false;
                i1 = k;
                k = 0;
                j1 = i;
                i = k;
                k = ((flag2) ? 1 : 0);
            }
        }
        l1 = 0;
        if (i != 0 || k != 0 || i1 != bitmap.getWidth() || j1 != bitmap.getHeight() || f != 1.0F || k1 != 0)
        {
            l1 = 1;
        }
        if (l1 != 0)
        {
            s = new Matrix();
            s.postScale(f, f);
            s.postRotate(k1);
            try
            {
                s = Bitmap.createBitmap(bitmap, i, k, i1, j1, s, true);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                s = null;
            }
            bitmap.recycle();
            return s;
        } else
        {
            return bitmap;
        }
    }

    public static void a(ExifInterface exifinterface, ExifInterface exifinterface1)
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 11)
        {
            if (exifinterface.getAttribute("FNumber") != null)
            {
                exifinterface1.setAttribute("FNumber", exifinterface.getAttribute("FNumber"));
            }
            if (exifinterface.getAttribute("ExposureTime") != null)
            {
                exifinterface1.setAttribute("ExposureTime", exifinterface.getAttribute("ExposureTime"));
            }
            if (exifinterface.getAttribute("ISOSpeedRatings") != null)
            {
                exifinterface1.setAttribute("ISOSpeedRatings", exifinterface.getAttribute("ISOSpeedRatings"));
            }
        }
        if (i >= 9)
        {
            if (exifinterface.getAttribute("GPSAltitude") != null)
            {
                exifinterface1.setAttribute("GPSAltitude", exifinterface.getAttribute("GPSAltitude"));
            }
            if (exifinterface.getAttribute("GPSAltitudeRef") != null)
            {
                exifinterface1.setAttribute("GPSAltitudeRef", exifinterface.getAttribute("GPSAltitudeRef"));
            }
        }
        if (i >= 8)
        {
            if (exifinterface.getAttribute("FocalLength") != null)
            {
                exifinterface1.setAttribute("FocalLength", exifinterface.getAttribute("FocalLength"));
            }
            if (exifinterface.getAttribute("GPSDateStamp") != null)
            {
                exifinterface1.setAttribute("GPSDateStamp", exifinterface.getAttribute("GPSDateStamp"));
            }
            if (exifinterface.getAttribute("GPSProcessingMethod") != null)
            {
                exifinterface1.setAttribute("GPSProcessingMethod", exifinterface.getAttribute("GPSProcessingMethod"));
            }
            if (exifinterface.getAttribute("GPSTimeStamp") != null)
            {
                exifinterface1.setAttribute("GPSTimeStamp", (new StringBuilder()).append("").append(exifinterface.getAttribute("GPSTimeStamp")).toString());
            }
        }
        if (exifinterface.getAttribute("DateTime") != null)
        {
            exifinterface1.setAttribute("DateTime", exifinterface.getAttribute("DateTime"));
        }
        if (exifinterface.getAttribute("Flash") != null)
        {
            exifinterface1.setAttribute("Flash", exifinterface.getAttribute("Flash"));
        }
        if (exifinterface.getAttribute("GPSLatitude") != null)
        {
            exifinterface1.setAttribute("GPSLatitude", exifinterface.getAttribute("GPSLatitude"));
        }
        if (exifinterface.getAttribute("GPSLatitudeRef") != null)
        {
            exifinterface1.setAttribute("GPSLatitudeRef", exifinterface.getAttribute("GPSLatitudeRef"));
        }
        if (exifinterface.getAttribute("GPSLongitude") != null)
        {
            exifinterface1.setAttribute("GPSLongitude", exifinterface.getAttribute("GPSLongitude"));
        }
        if (exifinterface.getAttribute("GPSLongitudeRef") != null)
        {
            exifinterface1.setAttribute("GPSLongitudeRef", exifinterface.getAttribute("GPSLongitudeRef"));
        }
        if (exifinterface.getAttribute("ImageLength") != null)
        {
            exifinterface1.setAttribute("ImageLength", exifinterface.getAttribute("ImageLength"));
        }
        if (exifinterface.getAttribute("ImageWidth") != null)
        {
            exifinterface1.setAttribute("ImageWidth", exifinterface.getAttribute("ImageWidth"));
        }
        if (exifinterface.getAttribute("Make") != null)
        {
            exifinterface1.setAttribute("Make", exifinterface.getAttribute("Make"));
        }
        if (exifinterface.getAttribute("Model") != null)
        {
            exifinterface1.setAttribute("Model", exifinterface.getAttribute("Model"));
        }
        if (exifinterface.getAttribute("Orientation") != null)
        {
            exifinterface1.setAttribute("Orientation", exifinterface.getAttribute("Orientation"));
        }
        if (exifinterface.getAttribute("WhiteBalance") != null)
        {
            exifinterface1.setAttribute("WhiteBalance", exifinterface.getAttribute("WhiteBalance"));
        }
    }
}
