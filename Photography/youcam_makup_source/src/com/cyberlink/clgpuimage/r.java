// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.AsyncTask;
import java.io.IOException;

// Referenced classes of package com.cyberlink.clgpuimage:
//            GPUImage, z

abstract class r extends AsyncTask
{

    final GPUImage a;
    private final GPUImage b;
    private int c;
    private int d;

    public r(GPUImage gpuimage, GPUImage gpuimage1)
    {
        a = gpuimage;
        super();
        b = gpuimage1;
    }

    private boolean a(boolean flag, boolean flag1)
    {
label0:
        {
            boolean flag2 = false;
            if (GPUImage.e(a) == GPUImage.ScaleType.b)
            {
                return flag && flag1;
            }
            if (!flag)
            {
                flag = flag2;
                if (!flag1)
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    private int[] a(int i, int j)
    {
        float f = (float)i / (float)c;
        float f1 = (float)j / (float)d;
        boolean flag;
        if (GPUImage.e(a) == GPUImage.ScaleType.b)
        {
            if (f > f1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        if (f < f1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            f = d;
            f1 = (f / (float)j) * (float)i;
        } else
        {
            f1 = c;
            f = (f1 / (float)i) * (float)j;
        }
        return (new int[] {
            Math.round(f1), Math.round(f)
        });
    }

    private Bitmap b()
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        a(options);
        int i = 1;
        do
        {
            boolean flag;
            boolean flag1;
            if (options.outWidth / i > c)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (options.outHeight / i > d)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (a(flag, flag1))
            {
                i++;
            } else
            {
                int j = i - 1;
                i = j;
                if (j < 1)
                {
                    i = 1;
                }
                Object obj = new android.graphics.BitmapFactory.Options();
                obj.inSampleSize = i;
                obj.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
                obj.inPurgeable = true;
                obj.inTempStorage = new byte[32768];
                obj = a(((android.graphics.BitmapFactory.Options) (obj)));
                if (obj == null)
                {
                    return null;
                } else
                {
                    return b(c(((Bitmap) (obj))));
                }
            }
        } while (true);
    }

    private Bitmap b(Bitmap bitmap)
    {
        int ai[] = a(bitmap.getWidth(), bitmap.getHeight());
        Bitmap bitmap2 = Bitmap.createScaledBitmap(bitmap, ai[0], ai[1], true);
        Bitmap bitmap1 = bitmap;
        if (bitmap2 != bitmap)
        {
            bitmap.recycle();
            bitmap1 = bitmap2;
            System.gc();
        }
        bitmap = bitmap1;
        if (GPUImage.e(a) == GPUImage.ScaleType.b)
        {
            int i = ai[0] - c;
            int j = ai[1] - d;
            Bitmap bitmap3 = Bitmap.createBitmap(bitmap1, i / 2, j / 2, ai[0] - i, ai[1] - j);
            bitmap = bitmap1;
            if (bitmap3 != bitmap1)
            {
                bitmap1.recycle();
                bitmap = bitmap3;
            }
        }
        return bitmap;
    }

    private Bitmap c(Bitmap bitmap)
    {
        if (bitmap != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((Bitmap) (obj));
_L2:
        int i = a();
        obj = bitmap;
        if (i == 0) goto _L4; else goto _L3
_L3:
        obj = new Matrix();
        ((Matrix) (obj)).postRotate(i);
        obj = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), ((Matrix) (obj)), true);
        bitmap.recycle();
        return ((Bitmap) (obj));
        obj;
_L6:
        ((IOException) (obj)).printStackTrace();
        return bitmap;
        IOException ioexception;
        ioexception;
        bitmap = ((Bitmap) (obj));
        obj = ioexception;
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected abstract int a();

    protected abstract Bitmap a(android.graphics.BitmapFactory.Options options);

    protected transient Bitmap a(Void avoid[])
    {
        if (GPUImage.b(a) == null || GPUImage.b(a).c() != 0)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        synchronized (GPUImage.b(a).d)
        {
            GPUImage.b(a).d.wait(3000L);
        }
_L2:
        c = GPUImage.c(a);
        d = GPUImage.d(a);
        return b();
        exception;
        avoid;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            avoid.printStackTrace();
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected void a(Bitmap bitmap)
    {
        super.onPostExecute(bitmap);
        b.d();
        b.a(bitmap);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Bitmap)obj);
    }
}
