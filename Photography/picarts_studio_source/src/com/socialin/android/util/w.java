// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.exception.ExceptionReportService;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.d;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.android.photo.imgop.ImageResize;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.util:
//            c, FileUtils, n, o, 
//            Utils, NativeUtil

public final class w
{

    private static float a = 1.0F;

    public static int a(Activity activity, Intent intent, String s)
    {
        int k = b(activity, intent);
        int j = k;
        if (k == 0)
        {
            j = m.d(s);
        }
        return j;
    }

    private static int a(Activity activity, Uri uri)
    {
        int j;
        boolean flag;
        flag = false;
        j = ((flag) ? 1 : 0);
        if (uri.getScheme() != null)
        {
            j = ((flag) ? 1 : 0);
            try
            {
                if (uri.getScheme().startsWith("content"))
                {
                    j = b(uri, activity);
                }
            }
            // Misplaced declaration of an exception variable
            catch (Activity activity)
            {
                com.socialin.android.d.b(d.a, "getImageOrientation", activity);
                return 0;
            }
        }
        return j;
    }

    public static int a(Activity activity, Uri uri, String s)
    {
        int k = a(activity, uri);
        int j = k;
        if (k == 0)
        {
            j = m.d(s);
        }
        return j;
    }

    public static Bitmap a(int j, int k, String s)
    {
        return a(j, k, c(s, j, k));
    }

    public static Bitmap a(int j, int k, ByteBuffer bytebuffer)
    {
        Bitmap bitmap = Bitmap.createBitmap(j, k, android.graphics.Bitmap.Config.ARGB_8888);
        bytebuffer.rewind();
        bitmap.copyPixelsFromBuffer(bytebuffer);
        return bitmap;
    }

    public static Bitmap a(Bitmap bitmap)
    {
        int j = Math.max(bitmap.getWidth(), bitmap.getHeight());
        Bitmap bitmap1 = Bitmap.createBitmap(j, j, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap1);
        canvas.drawColor(-1);
        canvas.drawBitmap(bitmap, (j - bitmap.getWidth()) / 2, (j - bitmap.getHeight()) / 2, null);
        return bitmap1;
    }

    public static Bitmap a(Bitmap bitmap, float f1)
    {
        Matrix matrix = new Matrix();
        Paint paint = new Paint();
        paint.setFilterBitmap(true);
        matrix.reset();
        Bitmap bitmap1 = com.socialin.android.util.c.a(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        if (bitmap1 != null)
        {
            matrix.postScale(f1, 1.0F, (float)bitmap.getWidth() / 2.0F, (float)bitmap.getHeight() / 2.0F);
            (new Canvas(bitmap1)).drawBitmap(bitmap, matrix, paint);
            com.socialin.android.util.c.a(bitmap);
        }
        return bitmap1;
    }

    public static Bitmap a(Bitmap bitmap, int j)
    {
label0:
        {
            Bitmap bitmap1;
label1:
            {
                Rect rect;
                int k;
                int l;
label2:
                {
                    int j1 = bitmap.getWidth();
                    int i1 = bitmap.getHeight();
                    if (bitmap.isMutable() && bitmap.getRowBytes() * i1 == j1 * i1 * 4)
                    {
                        bitmap1 = bitmap;
                        if (j <= 0)
                        {
                            break label1;
                        }
                        if (j1 <= j)
                        {
                            bitmap1 = bitmap;
                            if (i1 <= j)
                            {
                                break label1;
                            }
                        }
                    }
                    rect = new Rect(0, 0, j1, i1);
                    if (j1 <= j)
                    {
                        l = i1;
                        k = j1;
                        if (i1 <= j)
                        {
                            break label2;
                        }
                    }
                    float f1 = Math.min((float)j / (float)j1, (float)j / (float)i1);
                    k = (int)((float)j1 * f1);
                    l = (int)((float)i1 * f1);
                }
                Rect rect1 = new Rect(0, 0, k, l);
                bitmap1 = com.socialin.android.util.c.a(k, l, android.graphics.Bitmap.Config.ARGB_8888);
                if (bitmap1 == null)
                {
                    break label0;
                }
                (new Canvas(bitmap1)).drawBitmap(bitmap, rect, rect1, new Paint(2));
            }
            return bitmap1;
        }
        return null;
    }

    public static Bitmap a(Bitmap bitmap, int j, int k)
    {
        float f1 = Math.min((float)j / (float)bitmap.getWidth(), (float)k / (float)bitmap.getHeight());
        Bitmap bitmap1 = com.socialin.android.util.c.a(Math.round((float)bitmap.getWidth() * f1), Math.round((float)bitmap.getHeight() * f1), android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap1);
        Paint paint = new Paint();
        paint.setFilterBitmap(true);
        paint.setDither(false);
        Matrix matrix = new Matrix();
        matrix.postScale(f1, f1);
        canvas.drawBitmap(bitmap, matrix, paint);
        return bitmap1;
    }

    public static Bitmap a(Bitmap bitmap, int j, boolean flag)
    {
        Bitmap bitmap1;
        if (bitmap.getWidth() > j || bitmap.getHeight() > j)
        {
            Bitmap bitmap2;
            int k;
            int l;
            if (bitmap.getWidth() > bitmap.getHeight())
            {
                l = (bitmap.getHeight() * j) / bitmap.getWidth();
                k = j;
            } else
            {
                k = (bitmap.getWidth() * j) / bitmap.getHeight();
                l = j;
            }
            bitmap1 = Bitmap.createScaledBitmap(bitmap, k, l, false);
        } else
        {
            bitmap1 = bitmap;
        }
        bitmap2 = bitmap1;
        if (bitmap1 == bitmap)
        {
            bitmap2 = bitmap1;
            if (flag)
            {
                bitmap2 = bitmap.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
            }
        }
        return bitmap2;
    }

    public static Bitmap a(Bitmap bitmap, Matrix matrix, int j, int k, android.graphics.Bitmap.Config config)
    {
        com/socialin/android/util/w;
        JVM INSTR monitorenter ;
        Canvas canvas;
        Paint paint;
        config = Bitmap.createBitmap(j, k, config);
        canvas = new Canvas(config);
        paint = new Paint();
        paint.setDither(true);
        paint.setFilterBitmap(true);
        if (matrix == null) goto _L2; else goto _L1
_L1:
        canvas.drawBitmap(bitmap, matrix, paint);
_L4:
        com/socialin/android/util/w;
        JVM INSTR monitorexit ;
        return config;
_L2:
        canvas.drawBitmap(bitmap, 0.0F, 0.0F, paint);
        if (true) goto _L4; else goto _L3
_L3:
        bitmap;
        throw bitmap;
    }

    public static Bitmap a(Matrix matrix, Bitmap bitmap, int j, int k, boolean flag)
    {
        Object obj = null;
        bitmap.getWidth();
        bitmap.getHeight();
        float f1 = bitmap.getWidth();
        float f2 = bitmap.getHeight();
        if (f1 / f2 > (float)j / (float)k)
        {
            f1 = (float)k / f2;
            if (f1 < 0.9F || f1 > 1.0F)
            {
                matrix.setScale(f1, f1);
                obj = matrix;
            }
        } else
        {
            f1 = (float)j / f1;
            if (f1 < 0.9F || f1 > 1.0F)
            {
                matrix.setScale(f1, f1);
                obj = matrix;
            }
        }
        if (obj != null)
        {
            matrix = com.socialin.android.util.c.a(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), ((Matrix) (obj)), true);
        } else
        {
            matrix = bitmap;
        }
        if (matrix == null)
        {
            return bitmap;
        }
        if (flag && matrix != bitmap)
        {
            com.socialin.android.util.c.a(bitmap);
        }
        if (matrix.getWidth() == j && matrix.getHeight() == k)
        {
            obj = matrix;
        } else
        {
            int l = Math.max(0, matrix.getWidth() - j);
            int i1 = Math.max(0, matrix.getHeight() - k);
            obj = com.socialin.android.util.c.a(matrix, l / 2, i1 / 2, j, k);
        }
        if (obj != matrix && (flag || matrix != bitmap))
        {
            com.socialin.android.util.c.a(matrix);
        }
        return ((Bitmap) (obj));
    }

    public static Bitmap a(String s, int j)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
        return d(com.socialin.android.util.c.a(s, options), j);
    }

    public static Bitmap a(String s, int j, int k)
    {
        float f1;
        Bitmap bitmap;
        int l;
        int i1;
        try
        {
            bitmap = com.socialin.android.util.c.a(s);
            (new StringBuilder("getScaledBitmapFromPath() - path:")).append(s).append(" bitmap:").append(bitmap);
            i1 = bitmap.getWidth();
            l = bitmap.getHeight();
            f1 = Math.min((float)j / (float)i1, (float)k / (float)l);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.socialin.android.d.b(d.a, "getScaledBitmapFromPath", s);
            return null;
        }
        j = (int)((float)i1 * f1);
        k = (int)((float)l * f1);
        (new StringBuilder("getScaledDrawableFromPath - scale:")).append(f1).append("  w from:").append(bitmap.getWidth()).append(" to:").append(j).append(" h from:").append(bitmap.getHeight()).append(" to:").append(k);
        s = com.socialin.android.util.c.a(bitmap, j, k, true);
        com.socialin.android.util.c.a(bitmap);
        return s;
    }

    public static Bitmap a(String s, int j, int k, int l)
    {
        Object obj;
        Object obj1;
        int k1;
        int l1;
        obj = new android.graphics.BitmapFactory.Options();
        obj.inJustDecodeBounds = true;
        com.socialin.android.util.c.a(s, ((android.graphics.BitmapFactory.Options) (obj)));
        k1 = ((android.graphics.BitmapFactory.Options) (obj)).outWidth;
        l1 = ((android.graphics.BitmapFactory.Options) (obj)).outHeight;
        obj = null;
        obj1 = null;
        if (k1 < l1) goto _L2; else goto _L1
_L1:
        if (k1 <= j) goto _L4; else goto _L3
_L3:
        float f1 = 1.0F;
_L21:
        obj = obj1;
        if (obj1 != null) goto _L2; else goto _L5
_L5:
        if (f1 <= 4F) goto _L7; else goto _L6
_L6:
        obj = null;
_L2:
        obj1 = obj;
        if (k1 >= l1) goto _L9; else goto _L8
_L8:
        if (l1 <= j) goto _L11; else goto _L10
_L10:
        f1 = 1.0F;
_L17:
        obj1 = obj;
        if (obj != null) goto _L9; else goto _L12
_L12:
        if (f1 <= 4F) goto _L14; else goto _L13
_L13:
        obj1 = null;
_L9:
        return ((Bitmap) (obj1));
_L7:
        float f2 = (float)j / f1;
        try
        {
            obj1 = a(s, Math.round(f2), Math.round((float)k / f1), k1, l1, l);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.socialin.android.d.b(d.a, "getScaledBitmapFromRealPath", ((Throwable) (obj)));
            obj1 = null;
            continue; /* Loop/switch isn't completed */
        }
        f1 = (float)((double)f1 * 1.1000000000000001D);
        continue; /* Loop/switch isn't completed */
_L4:
        obj1 = com.socialin.android.util.c.a(s);
        obj = obj1;
        if (obj1 == null)
        {
            System.gc();
            obj1 = new android.graphics.BitmapFactory.Options();
            int i1;
            try
            {
                obj = i(s);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.socialin.android.d.b(d.a, "getScaledBitmapFromRealPath", ((Throwable) (obj)));
                obj = null;
            }
            if (obj != null)
            {
                i1 = obj.length;
            } else
            {
                i1 = 0;
            }
            obj = com.socialin.android.util.c.a(((byte []) (obj)), 0, i1, ((android.graphics.BitmapFactory.Options) (obj1)));
        }
        obj1 = obj;
        if (l == 0) goto _L9; else goto _L15
_L15:
        obj1 = obj;
        if (l == 360) goto _L9; else goto _L16
_L16:
        obj = c(((Bitmap) (obj)), l);
          goto _L2
_L14:
        int j1;
        int i2;
        j1 = (int)((float)k / f1);
        i2 = (int)((float)j / f1);
        obj = a(s, j1, i2, k1, l1, l);
        f1 = (float)((double)f1 * 1.1000000000000001D);
          goto _L17
        obj1;
        obj = null;
        com.socialin.android.d.b(d.a, "getScaledBitmapFromRealPath", ((Throwable) (obj1)));
          goto _L17
_L11:
        obj1 = com.socialin.android.util.c.a(s);
        obj = obj1;
        if (obj1 == null)
        {
            System.gc();
            obj = com.socialin.android.util.c.a(s);
        }
        obj1 = obj;
        if (l == 0) goto _L9; else goto _L18
_L18:
        obj1 = obj;
        if (l == 360) goto _L9; else goto _L19
_L19:
        return c(((Bitmap) (obj)), l);
        if (true) goto _L21; else goto _L20
_L20:
    }

    public static Bitmap a(String s, int j, int k, int l, int i1, int j1)
    {
        float f1 = (float)j / (float)l;
        float f2 = (float)k / (float)i1;
        Object obj;
        try
        {
            f1 = Math.min(f1, f2);
            obj = new android.graphics.BitmapFactory.Options();
            obj.inSampleSize = (int)(1.0F / f1);
            s = com.socialin.android.util.c.a(s, ((android.graphics.BitmapFactory.Options) (obj)));
            obj = b(s, j, k);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.socialin.android.d.b(d.a, "getScaledBitmap", s);
            return null;
        }
        if (s == obj)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        com.socialin.android.util.c.a(s);
        s = ((String) (obj));
        if (j1 == 0)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        s = new Matrix();
        s.postRotate(j1);
        s = com.socialin.android.util.c.a(((Bitmap) (obj)), 0, 0, ((Bitmap) (obj)).getWidth(), ((Bitmap) (obj)).getHeight(), s, true);
        com.socialin.android.util.c.a(((Bitmap) (obj)));
        return s;
    }

    public static Bitmap a(HashMap hashmap, int j, int k)
    {
        int l = ((Integer)hashmap.get("width")).intValue();
        int i1 = ((Integer)hashmap.get("height")).intValue();
        Object obj = (String)hashmap.get("path");
        boolean flag = ImageOpCommon.a;
        if (flag)
        {
            hashmap = ImageOpCommon.allocNativeBuffer(l * 4 * i1);
        } else
        {
            hashmap = ByteBuffer.allocate(l * 4 * i1);
        }
        try
        {
            FileUtils.b(((String) (obj)), hashmap);
        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap)
        {
            com.socialin.android.d.b(d.a, "getScaledBitmapFromBufferPathFast", hashmap);
            return null;
        }
        if (j == 0 && k == 0)
        {
            obj = com.socialin.android.util.c.a(l, i1, android.graphics.Bitmap.Config.ARGB_8888);
            hashmap.position(0);
            if (obj != null)
            {
                ((Bitmap) (obj)).copyPixelsFromBuffer(hashmap);
            }
            if (flag)
            {
                ImageOpCommon.freeNativeBuffer(hashmap);
            }
        } else
        {
            if (l * i1 > j)
            {
                Log.e("ex1", "scale < 1");
                obj = a(new n(l, i1), j);
                j = ((n) (obj)).b;
                int j1 = ((n) (obj)).a;
                Bitmap bitmap;
                if (flag)
                {
                    obj = ImageOpCommon.allocNativeBuffer(j1 * 4 * j);
                } else
                {
                    obj = ByteBuffer.allocate(j1 * 4 * j);
                }
                ImageResize.resize(hashmap, l, i1, ((ByteBuffer) (obj)), j1, j, 4);
                if (flag)
                {
                    ImageOpCommon.freeNativeBuffer(hashmap);
                }
                ((ByteBuffer) (obj)).position(0);
                bitmap = com.socialin.android.util.c.a(j1, j, android.graphics.Bitmap.Config.ARGB_8888);
                if (bitmap != null)
                {
                    bitmap.copyPixelsFromBuffer(((java.nio.Buffer) (obj)));
                }
                hashmap = bitmap;
                if (flag)
                {
                    ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj)));
                    hashmap = bitmap;
                }
            } else
            {
                Log.e("ex1", "scale >= 1");
                obj = com.socialin.android.util.c.a(l, i1, android.graphics.Bitmap.Config.ARGB_8888);
                hashmap.position(0);
                if (obj != null)
                {
                    ((Bitmap) (obj)).copyPixelsFromBuffer(hashmap);
                }
                if (flag)
                {
                    ImageOpCommon.freeNativeBuffer(hashmap);
                }
                hashmap = ((HashMap) (obj));
            }
            if (hashmap == null)
            {
                return null;
            }
            obj = hashmap;
            if (k != 0)
            {
                obj = hashmap;
                if (k != 360)
                {
                    return d(hashmap, k);
                }
            }
        }
        return ((Bitmap) (obj));
    }

    public static Bitmap a(HashMap hashmap, int j, int k, int l)
    {
        Object obj;
        int i1 = ((Integer)hashmap.get("width")).intValue();
        int j1 = ((Integer)hashmap.get("height")).intValue();
        obj = (String)hashmap.get("path");
        float f1;
        Matrix matrix;
        Paint paint;
        Canvas canvas;
        boolean flag;
        try
        {
            flag = ImageOpCommon.a;
        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap)
        {
            com.socialin.android.d.b(d.a, "getScaledBitmapFromBufferPath", hashmap);
            return null;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        hashmap = ImageOpCommon.allocNativeBuffer(i1 * 4 * j1);
_L5:
        FileUtils.b(((String) (obj)), hashmap);
        obj = com.socialin.android.util.c.a(i1, j1, android.graphics.Bitmap.Config.ARGB_8888);
        hashmap.position(0);
        ((Bitmap) (obj)).copyPixelsFromBuffer(hashmap);
        if (!flag) goto _L4; else goto _L3
_L3:
        ImageOpCommon.freeNativeBuffer(hashmap);
          goto _L4
_L2:
        hashmap = ByteBuffer.allocate(i1 * 4 * j1);
          goto _L5
_L7:
        matrix = new Matrix();
        paint = new Paint();
        paint.setFilterBitmap(true);
        paint.setDither(false);
        f1 = Math.min((float)j / (float)((Bitmap) (obj)).getWidth(), (float)k / (float)((Bitmap) (obj)).getHeight());
        hashmap = ((HashMap) (obj));
        if (f1 >= 1.0F)
        {
            break MISSING_BLOCK_LABEL_247;
        }
        hashmap = com.socialin.android.util.c.a((int)((float)((Bitmap) (obj)).getWidth() * f1), (int)((float)((Bitmap) (obj)).getHeight() * f1), android.graphics.Bitmap.Config.ARGB_8888);
        canvas = new Canvas(hashmap);
        matrix.postScale(f1, f1);
        canvas.drawBitmap(((Bitmap) (obj)), matrix, paint);
        com.socialin.android.util.c.a(((Bitmap) (obj)));
        obj = hashmap;
        if (l == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = hashmap;
        if (l == 360)
        {
            break; /* Loop/switch isn't completed */
        }
        hashmap = d(hashmap, l);
        return hashmap;
_L4:
        if (j != 0 || k != 0 || l != 0) goto _L7; else goto _L6
_L6:
        return ((Bitmap) (obj));
    }

    public static Bitmap a(HashMap hashmap, int j, int k, int l, int i1, int j1)
    {
        try
        {
            hashmap = b(hashmap, j, k, j1);
        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap)
        {
            com.socialin.android.d.b(d.a, "getThumbNailFromBuffer", hashmap);
            hashmap = null;
        }
        if (hashmap == null)
        {
            return null;
        } else
        {
            return a(new Matrix(), ((Bitmap) (hashmap)), l, i1, true);
        }
    }

    public static Bitmap a(HashMap hashmap, String s, int j, int k)
    {
        if (hashmap != null)
        {
            return a(hashmap, k, 0);
        }
        try
        {
            hashmap = b(s, k, j);
        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap)
        {
            com.socialin.android.d.b(d.a, "getBitmap", hashmap);
            ExceptionReportService.report(hashmap);
            return null;
        }
        return hashmap;
    }

    public static Bitmap a(Map map, int j)
    {
        return a((HashMap)map, j, 0);
    }

    public static Bitmap a(Map map, int j, int k, int l)
    {
        return a((HashMap)map, j, k, l);
    }

    public static android.graphics.BitmapFactory.Options a(String s)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        com.socialin.android.util.c.a(s, options);
        return options;
    }

    public static Point a(Point point)
    {
        byte byte0 = -1;
        int j = byte0;
        if (Build.MANUFACTURER.toLowerCase().equalsIgnoreCase("samsung"))
        {
            j = byte0;
            if (Build.MODEL.toLowerCase().equalsIgnoreCase("gt-i9500"))
            {
                j = 0x5f5e10;
            }
        }
        Point point1 = point;
        if (j > 0)
        {
            point1 = point;
            if (point.x * point.y > 0x5f5e10)
            {
                Log.e("ex1", "pixelsMaxCount > 0 && bitmapSize.x*bitmapSize.y > pixelsMaxCount");
                point = a(new n(point.x, point.y), 0x5f5e10);
                point1 = new Point(((n) (point)).a, ((n) (point)).b);
            }
        }
        return point1;
    }

    public static n a(n n1, int j)
    {
        if (n1.c <= j)
        {
            return n1;
        }
        float f1 = (float)n1.a / (float)n1.b;
        int k = Math.round((float)Math.sqrt((float)j / f1));
        int l;
        for (l = Math.round(f1 * (float)k); l * k > j;)
        {
            if (n1.a == n1.b)
            {
                l--;
                k--;
            } else
            if (l < k)
            {
                k--;
            } else
            {
                l--;
            }
        }

        return new n(l, k);
    }

    public static n a(String s, Map map)
    {
        if (map != null)
        {
            return new n(((Integer)map.get("width")).intValue(), ((Integer)map.get("height")).intValue());
        } else
        {
            s = a(s);
            return new n(((android.graphics.BitmapFactory.Options) (s)).outWidth, ((android.graphics.BitmapFactory.Options) (s)).outHeight);
        }
    }

    public static File a(String s, Context context)
    {
label0:
        {
            File file1 = Environment.getExternalStorageDirectory();
            Object obj = null;
            File file = obj;
            if (file1.exists())
            {
                file = obj;
                if (file1.canWrite())
                {
                    context = new File(file1, context.getResources().getString(m.e(context, "image_dir")));
                    context.mkdirs();
                    file = obj;
                    if (context.exists())
                    {
                        file = obj;
                        if (context.canWrite())
                        {
                            if (s == null)
                            {
                                break label0;
                            }
                            file = new File(context, s);
                            file.mkdirs();
                        }
                    }
                }
            }
            return file;
        }
        return context;
    }

    public static File a(String s, String s1, Bitmap bitmap, Activity activity, android.graphics.Bitmap.CompressFormat compressformat, boolean flag)
    {
        Object obj1 = null;
        Object obj = null;
        s = a(s, ((Context) (activity)));
        if (s == null)
        {
            s1 = obj;
        } else
        {
            if (s.exists() && s.canWrite())
            {
                s = new File(s, s1);
                try
                {
                    s.createNewFile();
                }
                // Misplaced declaration of an exception variable
                catch (String s1)
                {
                    com.socialin.android.d.b(d.a, "saveBitmapToSdCard", s1);
                }
                if (s.exists() && s.canWrite())
                {
                    if (a(compressformat, bitmap, 90, ((File) (s)), ((Context) (activity))) && android.graphics.Bitmap.CompressFormat.JPEG.equals(compressformat))
                    {
                        if (SocialinV3.getInstance().isRegistered())
                        {
                            s1 = String.valueOf(SocialinV3.getInstance().getUser().id);
                        } else
                        {
                            s1 = null;
                        }
                        m.a(s.getAbsolutePath(), s1, null);
                    }
                } else
                {
                    Log.e(d.a, "error writing to file");
                }
            } else
            {
                Utils.a(activity, m.e(activity, "msg_text_no_sdcard"));
                Log.e(d.a, "ERROR, unable to write to /sdcard/");
                s = obj1;
            }
            s1 = s;
            if (flag)
            {
                new o(activity, s.getAbsolutePath(), "image/*");
                return s;
            }
        }
        return s1;
    }

    public static File a(String s, String s1, Bitmap bitmap, Context context, android.graphics.Bitmap.CompressFormat compressformat, boolean flag)
    {
        Object obj = null;
        Object obj1 = null;
        if (s == null)
        {
            s1 = obj1;
        } else
        {
            s = new File(s);
            if (s.exists() && s.canWrite())
            {
                s = new File(s, s1);
                try
                {
                    s.createNewFile();
                }
                // Misplaced declaration of an exception variable
                catch (String s1)
                {
                    com.socialin.android.d.b(d.a, "saveBitmapToGivenDir", s1);
                }
                if (s.exists() && s.canWrite())
                {
                    if (a(compressformat, bitmap, 90, ((File) (s)), context) && android.graphics.Bitmap.CompressFormat.JPEG.equals(compressformat))
                    {
                        if (SocialinV3.getInstance().isRegistered())
                        {
                            s1 = String.valueOf(SocialinV3.getInstance().getUser().id);
                        } else
                        {
                            s1 = null;
                        }
                        m.a(s.getAbsolutePath(), s1, null);
                    }
                } else
                {
                    Log.e(d.a, "error writing to file");
                    s = obj;
                }
            } else
            {
                Log.e(d.a, "ERROR, unable to write to /sdcard/");
                s = obj;
            }
            s1 = s;
            if (flag)
            {
                s1 = s;
                if (s != null)
                {
                    new o(context, s.getAbsolutePath(), "image/*");
                    return s;
                }
            }
        }
        return s1;
    }

    public static String a(Activity activity, Intent intent)
    {
        Object obj;
        Object obj1;
        Object obj2;
        obj2 = null;
        if (intent == null)
        {
            return "";
        }
        Uri uri = intent.getData();
        com.socialin.android.d.b("PhotoUtils - ", new Object[] {
            "currImageURI:", uri
        });
        if (uri == null)
        {
            return "";
        }
        obj1 = uri.toString();
        boolean flag;
        if (uri.getScheme() != null && uri.getScheme().startsWith("content"))
        {
            obj = a(uri, ((Context) (activity)));
        } else
        {
            obj = obj1;
            if (uri.getScheme() != null)
            {
                obj = obj1;
                if (uri.getScheme().startsWith("file"))
                {
                    obj = obj1;
                    if (uri.getPath() != null)
                    {
                        obj = uri.getPath();
                        com.socialin.android.d.b("PhotoUtils - ", new Object[] {
                            "realPath:", obj
                        });
                    }
                }
            }
        }
        obj1 = obj;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        flag = (new File(((String) (obj)))).exists();
        obj1 = obj;
        if (!flag)
        {
            obj1 = null;
        }
_L4:
        obj = obj1;
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        intent = activity.getContentResolver().openInputStream(Uri.parse(intent.getData().toString()));
_L5:
        if (intent == null)
        {
            return "";
        }
          goto _L3
        obj1;
        com.socialin.android.d.b(d.a, "getRealPathFromAlbumPic", ((Throwable) (obj1)));
        obj1 = obj;
          goto _L4
        intent;
        com.socialin.android.d.b(d.a, "getRealPathFromAlbumPic", intent);
        intent = obj2;
          goto _L5
        activity;
        com.socialin.android.d.b(d.a, "getRealPathFromAlbumPic", activity);
        obj = obj1;
_L2:
        com.socialin.android.d.b("PhotoUtils - ", new Object[] {
            "realPath:", obj
        });
        com.socialin.android.d.b("startMainActivityFor realPath:", new Object[] {
            obj
        });
        return ((String) (obj));
_L3:
        activity = new File(a(activity.getResources().getString(m.e(activity, "tmp_dir")), ((Context) (activity))), (new StringBuilder("tmp_")).append(System.currentTimeMillis()).toString());
        activity.createNewFile();
_L8:
        obj = obj1;
        if (!activity.exists()) goto _L2; else goto _L6
_L6:
        obj = obj1;
        if (!activity.canRead()) goto _L2; else goto _L7
_L7:
        FileUtils.a(intent, new FileOutputStream(activity));
        obj = activity.getAbsolutePath();
          goto _L2
        IOException ioexception;
        ioexception;
        com.socialin.android.d.b(d.a, "getRealPathFromAlbumPic", ioexception);
          goto _L8
    }

    public static String a(Activity activity, Intent intent, File file)
    {
        com.socialin.android.d.b("onActivityResult data:", new Object[] {
            intent, " tmpFile:", file
        });
        if (file != null && file.exists() && file.canRead())
        {
            com.socialin.android.d.b("startMainActivityFor realPath:", new Object[] {
                file.getPath()
            });
            return file.getPath();
        }
        if (intent != null)
        {
            if (intent.getData() != null)
            {
                intent = intent.getData();
                com.socialin.android.d.b("PhotoUtils getRealPathFromCameraPic currImageURI:", new Object[] {
                    intent
                });
                activity = a(((Uri) (intent)), ((Context) (activity)));
                com.socialin.android.d.b("PhotoUtils getRealPathFromCameraPic realPath:", new Object[] {
                    activity
                });
                return activity;
            }
            if (intent.getExtras() != null)
            {
                return intent.getExtras().getString("android.intent.extra.title");
            }
        }
        return null;
    }

    private static String a(Context context, Uri uri)
    {
        if (uri != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        uri = new FileInputStream(context.getContentResolver().openFileDescriptor(uri, "r").getFileDescriptor());
        Object obj;
        obj = File.createTempFile("prefix", "extension", context.getCacheDir()).getAbsolutePath();
        context = new FileOutputStream(((String) (obj)));
        Uri uri1;
        Context context1;
        context1 = context;
        uri1 = uri;
        byte abyte0[] = new byte[4096];
_L4:
        context1 = context;
        uri1 = uri;
        int j = uri.read(abyte0);
        if (j == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        context1 = context;
        uri1 = uri;
        context.write(abyte0, 0, j);
        if (true) goto _L4; else goto _L3
        obj;
_L7:
        context1 = context;
        uri1 = uri;
        com.socialin.android.d.b(d.a, "getRealPathFromURIPfd", ((Throwable) (obj)));
        if (uri != null)
        {
            try
            {
                uri.close();
            }
            // Misplaced declaration of an exception variable
            catch (Uri uri) { }
        }
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return null;
            }
            return null;
        }
          goto _L1
_L3:
        try
        {
            uri.close();
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri) { }
        try
        {
            context.close();
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        return ((String) (obj));
        context;
        context1 = null;
        uri = null;
_L6:
        if (uri != null)
        {
            try
            {
                uri.close();
            }
            // Misplaced declaration of an exception variable
            catch (Uri uri) { }
        }
        if (context1 != null)
        {
            try
            {
                context1.close();
            }
            // Misplaced declaration of an exception variable
            catch (Uri uri) { }
        }
        throw context;
        context;
        context1 = null;
        continue; /* Loop/switch isn't completed */
        context;
        uri = uri1;
        if (true) goto _L6; else goto _L5
_L5:
        obj;
        context = null;
        uri = null;
          goto _L7
        obj;
        context = null;
          goto _L7
    }

    public static String a(Context context, Uri uri, String s)
    {
        String s1;
        Object obj = null;
        s1 = obj;
        if (uri == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        s1 = obj;
        if (uri.getAuthority() == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        uri = context.getContentResolver().openInputStream(uri);
        context = uri;
        s1 = FileUtils.a(s, (new StringBuilder("PicsArt_")).append(System.currentTimeMillis()).toString(), uri).getAbsolutePath();
        try
        {
            uri.close();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.socialin.android.d.b(d.a, "getRealPathFromURIWithAuthority", context);
            return s1;
        }
        return s1;
        s;
        uri = null;
_L4:
        context = uri;
        s.printStackTrace();
        try
        {
            uri.close();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.socialin.android.d.b(d.a, "getRealPathFromURIWithAuthority", context);
            return null;
        }
        return null;
        uri;
        context = null;
_L2:
        try
        {
            context.close();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.socialin.android.d.b(d.a, "getRealPathFromURIWithAuthority", context);
        }
        throw uri;
        uri;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String a(Uri uri, Context context)
    {
        Cursor cursor = context.getContentResolver().query(uri, new String[] {
            "_data"
        }, null, null, null);
        if (cursor == null) goto _L2; else goto _L1
_L1:
        Object obj = cursor;
        cursor.moveToFirst();
        obj = cursor;
        String s = cursor.getString(cursor.getColumnIndex("_data"));
        obj = cursor;
        cursor.close();
        uri = s;
        if (cursor != null)
        {
            try
            {
                cursor.close();
            }
            // Misplaced declaration of an exception variable
            catch (Uri uri)
            {
                com.socialin.android.d.b(d.a, "getRealPathFromURI", uri);
                return s;
            }
            uri = s;
        }
_L4:
        return uri;
_L2:
        obj = cursor;
        s = uri.getPath();
        context = s;
        uri = context;
        if (cursor == null) goto _L4; else goto _L3
_L3:
        try
        {
            cursor.close();
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            com.socialin.android.d.b(d.a, "getRealPathFromURI", uri);
            return context;
        }
        return context;
        obj;
        cursor = null;
_L10:
        obj = cursor;
        context = a(context, uri);
        uri = context;
        if (cursor == null) goto _L4; else goto _L5
_L5:
        try
        {
            cursor.close();
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            com.socialin.android.d.b(d.a, "getRealPathFromURI", uri);
            return context;
        }
        return context;
        context;
        cursor = null;
_L9:
        obj = cursor;
        com.socialin.android.d.b(d.a, "getRealPathFromURI", context);
        obj = cursor;
        context = uri.getPath();
        uri = context;
        if (cursor == null) goto _L4; else goto _L6
_L6:
        try
        {
            cursor.close();
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            com.socialin.android.d.b(d.a, "getRealPathFromURI", uri);
            return context;
        }
        return context;
        uri;
        obj = null;
_L8:
        if (obj != null)
        {
            try
            {
                ((Cursor) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                com.socialin.android.d.b(d.a, "getRealPathFromURI", context);
            }
        }
        throw uri;
        uri;
        if (true) goto _L8; else goto _L7
_L7:
        context;
          goto _L9
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
          goto _L10
    }

    public static ByteBuffer a(File file, int j)
    {
        ByteBuffer bytebuffer;
        if (ImageOpCommon.a)
        {
            bytebuffer = ImageOpCommon.allocNativeBuffer(j);
        } else
        {
            bytebuffer = ByteBuffer.allocate(j);
        }
        try
        {
            FileUtils.b(file.getAbsolutePath(), bytebuffer);
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            com.socialin.android.d.b(d.a, "loadBufferFromFile", file);
            return null;
        }
        return bytebuffer;
    }

    public static HashMap a(String s, Bitmap bitmap)
    {
        int j = bitmap.getWidth();
        int k = bitmap.getHeight();
        ByteBuffer bytebuffer;
        if (ImageOpCommon.a)
        {
            bytebuffer = ImageOpCommon.allocNativeBuffer(j * 4 * k);
        } else
        {
            bytebuffer = ByteBuffer.allocate(j * 4 * k);
        }
        bitmap.copyPixelsToBuffer(bytebuffer);
        bytebuffer.position(0);
        try
        {
            FileUtils.a(s, bytebuffer);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            com.socialin.android.d.b(d.a, "saveBitmapBufferToSDCard", bitmap);
        }
        ImageOpCommon.freeNativeBuffer(bytebuffer);
        bitmap = new HashMap();
        bitmap.put("width", Integer.valueOf(j));
        bitmap.put("height", Integer.valueOf(k));
        bitmap.put("path", s);
        return bitmap;
    }

    public static HashMap a(String s, String s1, Bitmap bitmap, Activity activity)
    {
        s = a(s, ((Context) (activity)));
        if (s == null)
        {
            return null;
        }
        if (s.exists() && s.canWrite())
        {
            s = new File(s, s1);
            try
            {
                s.createNewFile();
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                com.socialin.android.d.b(d.a, "saveBitmapBufferToSDCard", s1);
            }
            if (s.exists() && s.canWrite())
            {
                return a(s.getPath(), bitmap);
            } else
            {
                Log.e(d.a, "error writing to file");
                return null;
            }
        } else
        {
            Utils.a(activity, m.e(activity, "msg_text_no_sdcard"));
            Log.e(d.a, "ERROR, unable to write to /sdcard/");
            return null;
        }
    }

    public static HashMap a(String s, ByteBuffer bytebuffer, int j, int k)
    {
        try
        {
            FileUtils.a(s, bytebuffer);
        }
        // Misplaced declaration of an exception variable
        catch (ByteBuffer bytebuffer)
        {
            com.socialin.android.d.b(d.a, "saveBufferToSDCard", bytebuffer);
        }
        bytebuffer = new HashMap();
        bytebuffer.put("width", Integer.valueOf(j));
        bytebuffer.put("height", Integer.valueOf(k));
        bytebuffer.put("path", s);
        return bytebuffer;
    }

    public static void a(Bitmap bitmap, String s)
    {
        int j;
        s = new File(s);
        if (!s.exists() && s.getParent() != null)
        {
            File file = s.getParentFile();
            if (!file.exists())
            {
                file.mkdirs();
            }
        }
        s = new DataOutputStream(new FileOutputStream(s));
        s.writeInt(0x2e524157);
        s.writeInt(bitmap.getWidth());
        s.writeInt(bitmap.getHeight());
        if (bitmap.getConfig() == null)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        j = bitmap.getConfig().ordinal();
_L1:
        s.writeInt(j);
        byte abyte0[] = new byte[bitmap.getRowBytes() * bitmap.getHeight()];
        bitmap.copyPixelsToBuffer(ByteBuffer.wrap(abyte0));
        s.write(abyte0);
        s.close();
        return;
        try
        {
            j = android.graphics.Bitmap.Config.ARGB_8888.ordinal();
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
            return;
        }
          goto _L1
    }

    private static void a(File file)
    {
        file = file.listFiles();
        if (file == null) goto _L2; else goto _L1
_L1:
        int k = file.length;
        int j = 0;
_L3:
        File file1;
        if (j >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        file1 = file[j];
        if (file1.isDirectory())
        {
            a(file1);
        }
        file1.delete();
        j++;
        if (true) goto _L3; else goto _L2
        file;
        com.socialin.android.d.b(d.a, "clearDir", file);
_L2:
    }

    public static boolean a(Activity activity)
    {
        if (Environment.getExternalStorageState().equals("mounted"))
        {
            return true;
        } else
        {
            Utils.c(activity, "SD card is not available.");
            return false;
        }
    }

    private static boolean a(android.graphics.Bitmap.CompressFormat compressformat, int j, File file, Bitmap bitmap, Context context)
    {
        FileOutputStream fileoutputstream = new FileOutputStream(file);
        file = fileoutputstream;
        bitmap.compress(compressformat, j, fileoutputstream);
        try
        {
            fileoutputstream.flush();
            fileoutputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (android.graphics.Bitmap.CompressFormat compressformat)
        {
            com.socialin.android.d.b(d.a, "saveBitmap", compressformat);
        }
        return true;
        bitmap;
        compressformat = null;
_L4:
        file = compressformat;
        bitmap.printStackTrace();
        file = compressformat;
        com.socialin.android.d.b(d.a, "saveBitmapToFile", bitmap);
        file = compressformat;
        if (!(context instanceof Activity))
        {
            break MISSING_BLOCK_LABEL_94;
        }
        file = compressformat;
        Utils.b((Activity)context, "Failed save to sdcard");
        if (compressformat != null)
        {
            try
            {
                compressformat.flush();
                compressformat.close();
            }
            // Misplaced declaration of an exception variable
            catch (android.graphics.Bitmap.CompressFormat compressformat)
            {
                com.socialin.android.d.b(d.a, "saveBitmap", compressformat);
            }
        }
        return false;
        compressformat;
        file = null;
_L2:
        if (file != null)
        {
            try
            {
                file.flush();
                file.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                com.socialin.android.d.b(d.a, "saveBitmap", file);
            }
        }
        throw compressformat;
        compressformat;
        if (true) goto _L2; else goto _L1
_L1:
        bitmap;
        compressformat = fileoutputstream;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static boolean a(android.graphics.Bitmap.CompressFormat compressformat, Bitmap bitmap, int j, File file, Context context)
    {
        boolean flag = false;
        if (compressformat != android.graphics.Bitmap.CompressFormat.JPEG) goto _L2; else goto _L1
_L1:
        String s = System.getProperty("os.arch").substring(0, 3).toUpperCase();
        if (s.equals("ARM") || s.equals("AAR"))
        {
            flag = true;
        }
        if (!flag) goto _L2; else goto _L3
_L3:
        NativeUtil.a(bitmap, j, file.getAbsolutePath());
        return true;
        Object obj;
        obj;
_L5:
        return a(compressformat, j, file, bitmap, context);
_L2:
        return a(compressformat, j, file, bitmap, context);
        obj;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static boolean a(File file, Bitmap bitmap, android.graphics.Bitmap.CompressFormat compressformat, Context context)
    {
        if (!FileUtils.a() || bitmap == null)
        {
            if (context instanceof Activity)
            {
                Utils.a((Activity)context, m.e(context, "msg_text_no_sdcard"));
                Log.e(d.a, "ERROR, unable to write to /sdcard/");
            }
            return false;
        }
        if (file.getParentFile() != null)
        {
            file.getParentFile().mkdirs();
        }
        if (a(compressformat, bitmap, 90, file, context) && android.graphics.Bitmap.CompressFormat.JPEG.equals(compressformat))
        {
            if (SocialinV3.getInstance().isRegistered())
            {
                bitmap = String.valueOf(SocialinV3.getInstance().getUser().id);
            } else
            {
                bitmap = null;
            }
            m.a(file.getAbsolutePath(), bitmap, null);
        }
        return true;
    }

    private static int b(Activity activity, Intent intent)
    {
        int j;
        boolean flag;
        flag = false;
        intent = intent.getData();
        com.socialin.android.d.b("PhotoUtils - ", new Object[] {
            "currImageURI:", intent
        });
        j = ((flag) ? 1 : 0);
        if (intent.getScheme() != null)
        {
            j = ((flag) ? 1 : 0);
            try
            {
                if (intent.getScheme().startsWith("content"))
                {
                    j = b(((Uri) (intent)), ((Context) (activity)));
                }
            }
            // Misplaced declaration of an exception variable
            catch (Activity activity)
            {
                com.socialin.android.d.b(d.a, "getImageOrientation", activity);
                return 0;
            }
        }
        return j;
    }

    private static int b(Uri uri, Context context)
    {
        int j;
        try
        {
            uri = context.getContentResolver().query(uri, new String[] {
                "orientation"
            }, null, null, null);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            com.socialin.android.d.b(d.a, "getOrientation", uri);
            return 0;
        }
        if (uri == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        if (uri.getCount() != 1)
        {
            return 0;
        }
        uri.moveToFirst();
        j = uri.getInt(0);
        uri.close();
        return j;
        return 0;
    }

    public static Bitmap b(Bitmap bitmap, int j)
    {
        Matrix matrix = new Matrix();
        matrix.postRotate(j);
        return com.socialin.android.util.c.a(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap b(Bitmap bitmap, int j, int k)
    {
        int l = bitmap.getWidth();
        int i1 = bitmap.getHeight();
        a = Math.min((float)j / (float)l, (float)k / (float)i1);
        return com.socialin.android.util.c.a(bitmap, (int)((float)l * a), (int)((float)i1 * a), true);
    }

    public static Bitmap b(String s, int j)
    {
        Object obj = new android.graphics.BitmapFactory.Options();
        obj.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(s, ((android.graphics.BitmapFactory.Options) (obj)));
        String s1 = null;
        int k = ((android.graphics.BitmapFactory.Options) (obj)).outHeight / j;
        Object obj1 = new android.graphics.BitmapFactory.Options();
        obj1.inSampleSize = k;
        obj1 = BitmapFactory.decodeFile(s, ((android.graphics.BitmapFactory.Options) (obj1)));
        if (obj1 != null)
        {
            if (((android.graphics.BitmapFactory.Options) (obj)).outWidth > ((android.graphics.BitmapFactory.Options) (obj)).outHeight)
            {
                obj = com.socialin.android.util.c.a(((Bitmap) (obj1)), (((Bitmap) (obj1)).getWidth() * j) / ((Bitmap) (obj1)).getHeight(), j, false);
                s = com.socialin.android.util.c.a(((Bitmap) (obj)), ((Bitmap) (obj)).getWidth() / 2 - j / 2, 0, j, j);
            } else
            {
                obj = com.socialin.android.util.c.a(((Bitmap) (obj1)), j, (((Bitmap) (obj1)).getHeight() * j) / ((Bitmap) (obj1)).getWidth(), false);
                s = com.socialin.android.util.c.a(((Bitmap) (obj)), 0, ((Bitmap) (obj)).getHeight() / 2 - j / 2, j, j);
            }
            s1 = s;
            if (obj1 != obj)
            {
                s1 = s;
                if (obj1 != s)
                {
                    ((Bitmap) (obj1)).recycle();
                    s1 = s;
                }
            }
        }
        return s1;
    }

    public static Bitmap b(String s, int j, int k)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        com.socialin.android.util.c.a(s, options);
        int l = options.outWidth;
        int i1 = options.outHeight;
        if (l * i1 > j)
        {
            n n1 = a(new n(l, i1), j);
            return b(s, n1.a, n1.b, l, i1, k);
        } else
        {
            return a(s, k);
        }
    }

    public static Bitmap b(String s, int j, int k, int l)
    {
        return c(s, j, k, l);
    }

    public static Bitmap b(String s, int j, int k, int l, int i1, int j1)
    {
        float f1 = Math.min((float)j / (float)l, (float)k / (float)i1);
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inSampleSize = (int)(1.0F / f1);
        options.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
        s = com.socialin.android.util.c.a(s, options);
        if (s != null)
        {
            Matrix matrix = new Matrix();
            Paint paint = new Paint();
            paint.setFilterBitmap(true);
            paint.setDither(false);
            float f2 = Math.min((float)j / (float)s.getWidth(), (float)k / (float)s.getHeight());
            Bitmap bitmap = com.socialin.android.util.c.a(Math.round((float)s.getWidth() * f2), Math.round((float)s.getHeight() * f2), android.graphics.Bitmap.Config.ARGB_8888);
            (new StringBuilder("scaledBitmapWidth: ")).append(bitmap.getWidth()).append(" scaledBitmapHeight: ").append(bitmap.getHeight());
            Canvas canvas = new Canvas(bitmap);
            matrix.postScale(f2, f2);
            canvas.drawBitmap(s, matrix, paint);
            com.socialin.android.util.c.a(s);
            if (j1 == 0 || j1 == 360)
            {
                return bitmap;
            } else
            {
                return d(bitmap, j1);
            }
        } else
        {
            return null;
        }
    }

    public static Bitmap b(HashMap hashmap, int j, int k, int l)
    {
        int i1 = ((Integer)hashmap.get("width")).intValue();
        int j1 = ((Integer)hashmap.get("height")).intValue();
        Object obj = (String)hashmap.get("path");
        boolean flag = ImageOpCommon.a;
        if (flag)
        {
            hashmap = ImageOpCommon.allocNativeBuffer(i1 * 4 * j1);
        } else
        {
            hashmap = ByteBuffer.allocate(i1 * 4 * j1);
        }
        try
        {
            FileUtils.b(((String) (obj)), hashmap);
        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap)
        {
            com.socialin.android.d.b(d.a, "getScaledBitmapFromBufferPathFast", hashmap);
            return null;
        }
        if (j == 0 && k == 0 && l == 0)
        {
            obj = com.socialin.android.util.c.a(i1, j1, android.graphics.Bitmap.Config.ARGB_8888);
            hashmap.position(0);
            ((Bitmap) (obj)).copyPixelsFromBuffer(hashmap);
            if (flag)
            {
                ImageOpCommon.freeNativeBuffer(hashmap);
            }
        } else
        {
            float f1 = Math.min((float)j / (float)i1, (float)k / (float)j1);
            if (f1 < 1.0F)
            {
                j = Math.round((float)i1 * f1);
                k = Math.round(f1 * (float)j1);
                Bitmap bitmap1;
                if (flag)
                {
                    obj = ImageOpCommon.allocNativeBuffer(j * 4 * k);
                } else
                {
                    obj = ByteBuffer.allocate(j * 4 * k);
                }
                ImageResize.resize(hashmap, i1, j1, ((ByteBuffer) (obj)), j, k, 4);
                if (flag)
                {
                    ImageOpCommon.freeNativeBuffer(hashmap);
                }
                ((ByteBuffer) (obj)).position(0);
                bitmap1 = com.socialin.android.util.c.a(j, k, android.graphics.Bitmap.Config.ARGB_8888);
                bitmap1.copyPixelsFromBuffer(((java.nio.Buffer) (obj)));
                hashmap = bitmap1;
                if (flag)
                {
                    ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj)));
                    hashmap = bitmap1;
                }
            } else
            {
                Bitmap bitmap = com.socialin.android.util.c.a(i1, j1, android.graphics.Bitmap.Config.ARGB_8888);
                hashmap.position(0);
                bitmap.copyPixelsFromBuffer(hashmap);
                if (flag)
                {
                    ImageOpCommon.freeNativeBuffer(hashmap);
                }
                hashmap = bitmap;
            }
            obj = hashmap;
            if (l != 0)
            {
                obj = hashmap;
                if (l != 360)
                {
                    return d(hashmap, l);
                }
            }
        }
        return ((Bitmap) (obj));
    }

    public static String b(String s)
    {
        Object obj = null;
        String s1 = a(s).outMimeType;
        s = obj;
        if (s1 != null)
        {
            s = s1.substring(s1.indexOf("/") + 1);
        }
        return s;
    }

    public static ByteBuffer b(Bitmap bitmap)
    {
        ByteBuffer bytebuffer = ImageOpCommon.allocNativeBuffer(bitmap.getWidth() * bitmap.getHeight() * 4);
        bytebuffer.position(0);
        bitmap.copyPixelsToBuffer(bytebuffer);
        bytebuffer.position(0);
        return bytebuffer;
    }

    public static Bitmap c(Bitmap bitmap)
    {
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ALPHA_8);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[] {
            0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 
            0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F
        })));
        Canvas canvas = new Canvas(bitmap1);
        canvas.setDensity(0);
        canvas.drawBitmap(bitmap, 0.0F, 0.0F, paint);
        return bitmap1;
    }

    public static Bitmap c(Bitmap bitmap, int j)
    {
        Object obj = new Matrix();
        ((Matrix) (obj)).postRotate(j);
        obj = com.socialin.android.util.c.a(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), ((Matrix) (obj)), true);
        if (obj != bitmap)
        {
            com.socialin.android.util.c.a(bitmap);
        }
        return ((Bitmap) (obj));
    }

    private static Bitmap c(String s, int j, int k, int l)
    {
        Object obj;
        Bitmap bitmap;
        Object obj1;
        int i1;
        int j1;
        long l2;
        l2 = System.currentTimeMillis();
        obj1 = null;
        bitmap = null;
        obj = null;
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        com.socialin.android.util.c.a(s, options);
        i1 = options.outWidth;
        j1 = options.outHeight;
        if (i1 < j1) goto _L2; else goto _L1
_L1:
        if (i1 <= j) goto _L4; else goto _L3
_L3:
        float f1;
        f1 = 1.0F;
        bitmap = ((Bitmap) (obj));
_L9:
        obj = bitmap;
        if (bitmap != null) goto _L6; else goto _L5
_L5:
        if (f1 <= 4F) goto _L8; else goto _L7
_L7:
        obj = null;
_L6:
        (new StringBuilder("+++++++++++++++++++++++++load done in ")).append(System.currentTimeMillis() - l2).append(" ms");
        return ((Bitmap) (obj));
_L8:
        int k1;
        int l1;
        k1 = (int)((float)j / f1);
        l1 = (int)((float)k / f1);
        bitmap = b(s, k1, l1, i1, j1, l);
        f1 = (float)((double)f1 * 1.1000000000000001D);
          goto _L9
        obj;
        com.socialin.android.d.b(d.a, "getScaledBitmapFromRealPath_ARGB8", ((Throwable) (obj)));
        f1 = (float)((double)f1 * 1.1000000000000001D);
        bitmap = null;
          goto _L9
        s;
        throw s;
_L4:
        obj = a(s, l);
          goto _L6
_L2:
        obj = obj1;
        if (i1 >= j1) goto _L6; else goto _L10
_L10:
        if (j1 <= j)
        {
            break MISSING_BLOCK_LABEL_328;
        }
        f1 = 1.0F;
_L11:
        obj = bitmap;
        if (bitmap == null)
        {
label0:
            {
                if (f1 <= 4F)
                {
                    break label0;
                }
                obj = null;
            }
        }
          goto _L6
        k1 = (int)((float)k / f1);
        l1 = (int)((float)j / f1);
        bitmap = b(s, k1, l1, i1, j1, l);
        f1 = (float)((double)f1 * 1.1000000000000001D);
          goto _L11
        obj;
        com.socialin.android.d.b(d.a, "getScaledBitmapFromRealPath_ARGB8", ((Throwable) (obj)));
        f1 = (float)((double)f1 * 1.1000000000000001D);
        bitmap = null;
          goto _L11
        s;
        throw s;
        obj = a(s, l);
          goto _L6
    }

    public static Bitmap c(String s, int j, int k, int l, int i1, int j1)
    {
        try
        {
            s = c(s, j, k, j1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.socialin.android.d.b(d.a, "getThumbNailFromRealPath", s);
            s = null;
        }
        if (s == null)
        {
            return null;
        } else
        {
            return a(new Matrix(), s, l, i1, true);
        }
    }

    private static ByteBuffer c(String s, int j, int k)
    {
        Object obj = new FileInputStream(s);
        IOException ioexception;
        long l = j * k * 4;
        Object obj1;
        String s1;
        ByteBuffer bytebuffer;
        try
        {
            bytebuffer = ImageOpCommon.allocNativeBuffer(l);
            s = ((FileInputStream) (obj)).getChannel();
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            s = null;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            s1 = null;
            continue; /* Loop/switch isn't completed */
        }
        s1 = s;
        obj1 = obj;
        s.read(bytebuffer);
        try
        {
            ((FileInputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.socialin.android.d.b(d.a, "readBufferFromFile", ((Throwable) (obj)));
        }
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                com.socialin.android.d.b(d.a, "readBufferFromFile", s);
                return bytebuffer;
            }
        }
        return bytebuffer;
        ioexception;
        s = null;
        obj = null;
_L4:
        s1 = s;
        obj1 = obj;
        com.socialin.android.d.b(d.a, "readBufferFromFile", ioexception);
        if (obj != null)
        {
            try
            {
                ((FileInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.socialin.android.d.b(d.a, "readBufferFromFile", ((Throwable) (obj)));
            }
        }
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                com.socialin.android.d.b(d.a, "readBufferFromFile", s);
            }
        }
        return null;
        s;
        s1 = null;
        obj = null;
_L2:
        if (obj != null)
        {
            try
            {
                ((FileInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.socialin.android.d.b(d.a, "readBufferFromFile", ((Throwable) (obj)));
            }
        }
        if (s1 != null)
        {
            try
            {
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.socialin.android.d.b(d.a, "readBufferFromFile", ((Throwable) (obj)));
            }
        }
        throw s;
        s;
        obj = obj1;
        if (true) goto _L2; else goto _L1
        ioexception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void c(String s)
    {
        s = FileUtils.a(s, "");
        a(s);
        try
        {
            s.delete();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.socialin.android.d.b(d.a, "clearDir", s);
        }
    }

    public static Bitmap d(Bitmap bitmap)
    {
        if (bitmap == null || bitmap.isRecycled())
        {
            throw new IllegalArgumentException("Source bitmap is null or recycled");
        }
        if (bitmap.isMutable() && bitmap.getConfig() == android.graphics.Bitmap.Config.ARGB_8888)
        {
            return bitmap;
        } else
        {
            return bitmap.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
        }
    }

    public static Bitmap d(Bitmap bitmap, int j)
    {
        while (bitmap == null || bitmap.isRecycled() || j == 0 || j == 360) 
        {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.reset();
        Bitmap bitmap1;
        if (j == 90 || j == 270)
        {
            bitmap1 = com.socialin.android.util.c.a(bitmap.getHeight(), bitmap.getWidth(), android.graphics.Bitmap.Config.ARGB_8888);
            if (j == 90)
            {
                matrix.postRotate(90F);
                matrix.postTranslate(bitmap1.getWidth(), 0.0F);
            } else
            {
                matrix.postRotate(270F);
                matrix.postTranslate(0.0F, bitmap1.getHeight());
            }
        } else
        {
            bitmap1 = com.socialin.android.util.c.a(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            matrix.postRotate(180F);
            matrix.postTranslate(bitmap1.getWidth(), bitmap1.getHeight());
        }
        (new Canvas(bitmap1)).drawBitmap(bitmap, matrix, new Paint(2));
        com.socialin.android.util.c.a(bitmap);
        return bitmap1;
    }

    public static void d(String s)
    {
        s = FileUtils.a(s, "");
        s = s.listFiles();
        if (s == null) goto _L2; else goto _L1
_L1:
        int k = s.length;
        int j = 0;
_L3:
        File file;
        if (j >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        file = s[j];
        if (System.currentTimeMillis() - file.lastModified() > 0x1d4c0L)
        {
            (new StringBuilder("photo util delete file --")).append(file.getName());
            a(file);
            file.delete();
        }
        j++;
        if (true) goto _L3; else goto _L2
        s;
        com.socialin.android.d.b(d.a, "clearDirForLast", s);
_L2:
    }

    public static Bitmap e(Bitmap bitmap)
    {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setStyle(android.graphics.Paint.Style.FILL);
        int j = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap bitmap1 = Bitmap.createBitmap(j, j, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap1);
        paint.setXfermode(null);
        canvas.drawCircle(j / 2, j / 2, j / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        canvas.translate(j / 2 - bitmap.getWidth() / 2, j / 2 - bitmap.getHeight() / 2);
        canvas.drawBitmap(bitmap, 0.0F, 0.0F, paint);
        return bitmap1;
    }

    public static Bitmap e(Bitmap bitmap, int j)
    {
        if (bitmap == null || bitmap.isRecycled())
        {
            return null;
        }
        int k = Math.min(bitmap.getWidth(), bitmap.getHeight());
        int l = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap bitmap1 = Bitmap.createBitmap(k, l, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap1);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, k, l);
        RectF rectf = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(0xff424242);
        canvas.drawRoundRect(rectf, j, j, paint);
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        try
        {
            canvas.drawBitmap(bitmap, rect, rect, paint);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            com.socialin.android.d.b(d.a, "getRoundedRectBitmap", bitmap);
            return null;
        }
        return bitmap1;
    }

    public static boolean e(String s)
    {
        int j;
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(s, options);
        if (options.outWidth <= 0)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        j = options.outHeight;
        if (j > 0)
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_49;
        s;
        com.socialin.android.d.b(d.a, "isValidImageFile", s);
        return false;
    }

    public static Bitmap f(Bitmap bitmap, int j)
    {
        return a(bitmap, j, false);
    }

    public static Bitmap f(String s)
    {
        return b(s, 0x100000, 0);
    }

    public static Bitmap g(String s)
    {
        DataInputStream datainputstream = new DataInputStream(new FileInputStream(s));
        if (datainputstream.readInt() != 0x2e524157) goto _L2; else goto _L1
_L1:
        s = Bitmap.createBitmap(datainputstream.readInt(), datainputstream.readInt(), android.graphics.Bitmap.Config.values()[datainputstream.readInt()]);
        IOException ioexception;
        try
        {
            byte abyte0[] = new byte[s.getRowBytes() * s.getHeight()];
            datainputstream.readFully(abyte0);
            s.copyPixelsFromBuffer(ByteBuffer.wrap(abyte0));
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            continue; /* Loop/switch isn't completed */
        }
_L5:
        datainputstream.close();
        return s;
        ioexception;
        s = null;
_L3:
        ioexception.printStackTrace();
        ExceptionReportService.report(ioexception);
        return s;
        ioexception;
        if (true) goto _L3; else goto _L2
_L2:
        s = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static Point h(String s)
    {
        Point point = new Point();
        try
        {
            s = new DataInputStream(new FileInputStream(s));
            if (s.readInt() == 0x2e524157)
            {
                point.set(s.readInt(), s.readInt());
            }
            s.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return point;
        }
        return point;
    }

    private static byte[] i(String s)
    {
        File file = new File(s);
        byte abyte0[];
        try
        {
            s = new FileInputStream(file);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.socialin.android.d.b(d.a, "getByteArrayFromRealPath", s);
            s = null;
        }
        abyte0 = new byte[(int)file.length()];
        if (s == null)
        {
            return abyte0;
        }
        int j = 0;
        do
        {
            if (j >= abyte0.length)
            {
                break;
            }
            int k = s.read(abyte0, j, abyte0.length - j);
            if (k < 0)
            {
                break;
            }
            j += k;
        } while (true);
        if (j < abyte0.length)
        {
            throw new IOException((new StringBuilder("Could not completely read file ")).append(file.getName()).toString());
        } else
        {
            s.close();
            return abyte0;
        }
    }

}
