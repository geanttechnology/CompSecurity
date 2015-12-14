// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// Referenced classes of package com.sina.weibo.sdk.utils:
//            BitmapHelper, NetworkHelper

public class ImageUtils
{

    public ImageUtils()
    {
    }

    private static void delete(File file)
    {
        if (file != null && file.exists() && !file.delete())
        {
            throw new RuntimeException((new StringBuilder(String.valueOf(file.getAbsolutePath()))).append(" doesn't be deleted!").toString());
        } else
        {
            return;
        }
    }

    private static boolean deleteDependon(String s)
    {
        boolean flag;
        boolean flag1;
        flag = false;
        flag1 = false;
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        return flag1;
_L2:
        int i;
        s = new File(s);
        i = 1;
        if (s == null) goto _L1; else goto _L3
_L3:
        flag1 = flag;
        if (flag) goto _L1; else goto _L4
_L4:
        flag1 = flag;
        if (i > 5) goto _L1; else goto _L5
_L5:
        flag1 = flag;
        if (!s.isFile()) goto _L1; else goto _L6
_L6:
        flag1 = flag;
        if (!s.exists()) goto _L1; else goto _L7
_L7:
        boolean flag2 = s.delete();
        flag = flag2;
        if (!flag2)
        {
            i++;
            flag = flag2;
        }
          goto _L3
    }

    private static boolean isFileExisted(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            if ((s = new File(s)) != null && s.exists())
            {
                return true;
            }
        }
        return false;
    }

    private static boolean isParentExist(File file)
    {
        File file1;
        if (file != null)
        {
            if ((file1 = file.getParentFile()) != null && !file1.exists() && (file.exists() || file.mkdirs()))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean isWifi(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        return context != null && context.getType() == 1;
    }

    private static void makesureFileExist(String s)
    {
        if (s != null)
        {
            if ((s = new File(s)) != null && !s.exists() && isParentExist(s))
            {
                if (s.exists())
                {
                    delete(s);
                }
                try
                {
                    s.createNewFile();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    s.printStackTrace();
                }
                return;
            }
        }
    }

    private static void revitionImageSize(String s, int i, int j)
    {
        if (i <= 0)
        {
            throw new IllegalArgumentException("size must be greater than 0!");
        }
        if (!isFileExisted(s))
        {
            String s1 = s;
            if (s == null)
            {
                s1 = "null";
            }
            throw new FileNotFoundException(s1);
        }
        if (!BitmapHelper.verifyBitmap(s))
        {
            throw new IOException("");
        }
        Object obj = new FileInputStream(s);
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(((java.io.InputStream) (obj)), null, options);
        int k;
        try
        {
            ((FileInputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
        }
        k = 0;
        do
        {
            if (options.outWidth >> k <= i && options.outHeight >> k <= i)
            {
                options.inSampleSize = (int)Math.pow(2D, k);
                options.inJustDecodeBounds = false;
                obj = safeDecodeBimtapFile(s, options);
                if (obj == null)
                {
                    throw new IOException("Bitmap decode error!");
                }
                break;
            }
            k++;
        } while (true);
        deleteDependon(s);
        makesureFileExist(s);
        s = new FileOutputStream(s);
        if (options != null && options.outMimeType != null && options.outMimeType.contains("png"))
        {
            ((Bitmap) (obj)).compress(android.graphics.Bitmap.CompressFormat.PNG, j, s);
        } else
        {
            ((Bitmap) (obj)).compress(android.graphics.Bitmap.CompressFormat.JPEG, j, s);
        }
        try
        {
            s.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        ((Bitmap) (obj)).recycle();
    }

    private static void revitionImageSizeHD(String s, int i, int j)
    {
        float f;
        Object obj;
        if (i <= 0)
        {
            throw new IllegalArgumentException("size must be greater than 0!");
        }
        if (!isFileExisted(s))
        {
            String s1 = s;
            if (s == null)
            {
                s1 = "null";
            }
            throw new FileNotFoundException(s1);
        }
        if (!BitmapHelper.verifyBitmap(s))
        {
            throw new IOException("");
        }
        int l = i * 2;
        obj = new FileInputStream(s);
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(((java.io.InputStream) (obj)), null, options);
        Bitmap bitmap;
        int k;
        try
        {
            ((FileInputStream) (obj)).close();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        k = 0;
        do
        {
            if (options.outWidth >> k <= l && options.outHeight >> k <= l)
            {
                options.inSampleSize = (int)Math.pow(2D, k);
                options.inJustDecodeBounds = false;
                bitmap = safeDecodeBimtapFile(s, options);
                if (bitmap == null)
                {
                    throw new IOException("Bitmap decode error!");
                }
                break;
            }
            k++;
        } while (true);
        deleteDependon(s);
        makesureFileExist(s);
        Canvas canvas;
        Matrix matrix;
        if (bitmap.getWidth() > bitmap.getHeight())
        {
            k = bitmap.getWidth();
        } else
        {
            k = bitmap.getHeight();
        }
        f = (float)i / (float)k;
        exception = bitmap;
        if (f >= 1.0F) goto _L2; else goto _L1
_L1:
        exception = Bitmap.createBitmap((int)((float)bitmap.getWidth() * f), (int)((float)bitmap.getHeight() * f), android.graphics.Bitmap.Config.ARGB_8888);
        if (exception == null)
        {
            bitmap.recycle();
        }
        canvas = new Canvas(exception);
        matrix = new Matrix();
        matrix.setScale(f, f);
        canvas.drawBitmap(bitmap, matrix, new Paint());
        bitmap.recycle();
_L2:
        s = new FileOutputStream(s);
        if (options != null && options.outMimeType != null && options.outMimeType.contains("png"))
        {
            exception.compress(android.graphics.Bitmap.CompressFormat.PNG, j, s);
        } else
        {
            exception.compress(android.graphics.Bitmap.CompressFormat.JPEG, j, s);
        }
        try
        {
            s.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        exception.recycle();
        return;
        exception;
        System.gc();
        f = (float)((double)f * 0.80000000000000004D);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static boolean revitionPostImageSize(Context context, String s)
    {
label0:
        {
            if (NetworkHelper.isWifiValid(context))
            {
                revitionImageSizeHD(s, 1600, 75);
                break label0;
            }
            try
            {
                revitionImageSize(s, 1024, 75);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
                return false;
            }
        }
        return true;
    }

    private static Bitmap safeDecodeBimtapFile(String s, android.graphics.BitmapFactory.Options options)
    {
        Object obj1 = null;
        Object obj;
        android.graphics.BitmapFactory.Options options1;
        Object obj2;
        FileInputStream fileinputstream;
        OutOfMemoryError outofmemoryerror;
        Object obj3;
        int i;
        if (options == null)
        {
            options1 = new android.graphics.BitmapFactory.Options();
            options1.inSampleSize = 1;
        } else
        {
            options1 = options;
        }
        i = 0;
        obj = null;
        if (i >= 5)
        {
            return ((Bitmap) (obj));
        }
        obj2 = obj;
        fileinputstream = new FileInputStream(s);
        obj1 = obj;
        obj2 = obj;
        obj = BitmapFactory.decodeStream(fileinputstream, null, options);
        obj1 = obj;
        obj2 = obj;
        fileinputstream.close();
        return ((Bitmap) (obj));
        obj3;
        obj1 = obj;
        obj2 = obj;
        ((IOException) (obj3)).printStackTrace();
        return ((Bitmap) (obj));
        obj3;
        obj2 = fileinputstream;
        obj = obj1;
        outofmemoryerror = ((OutOfMemoryError) (obj3));
        obj1 = obj2;
_L2:
        outofmemoryerror.printStackTrace();
        options1.inSampleSize = options1.inSampleSize * 2;
        try
        {
            ((FileInputStream) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2)
        {
            ((IOException) (obj2)).printStackTrace();
        }
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_26;
        }
        s;
        return ((Bitmap) (obj2));
        outofmemoryerror;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
