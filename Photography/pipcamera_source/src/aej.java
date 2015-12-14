// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.AsyncTask;
import java.io.IOException;
import jp.co.cyberagent.android.gpuimage.GPUImage;

public abstract class aej extends AsyncTask
{

    private final GPUImage a;
    final GPUImage b;
    private int c;
    private int d;

    public aej(GPUImage gpuimage, GPUImage gpuimage1)
    {
        b = gpuimage;
        super();
        a = gpuimage1;
    }

    private boolean a(boolean flag, boolean flag1)
    {
label0:
        {
            boolean flag2 = false;
            if (GPUImage.f(b) == jp.co.cyberagent.android.gpuimage.GPUImage.ScaleType.CENTER_CROP)
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
        if (GPUImage.f(b) == jp.co.cyberagent.android.gpuimage.GPUImage.ScaleType.CENTER_CROP)
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
                obj.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
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
        Bitmap bitmap1 = Bitmap.createScaledBitmap(bitmap, ai[0], ai[1], true);
        bitmap.recycle();
        System.gc();
        if (GPUImage.f(b) == jp.co.cyberagent.android.gpuimage.GPUImage.ScaleType.CENTER_CROP)
        {
            int i = ai[0] - c;
            int j = ai[1] - d;
            bitmap = Bitmap.createBitmap(bitmap1, i / 2, j / 2, ai[0] - i, ai[1] - j);
            bitmap1.recycle();
            return bitmap;
        } else
        {
            return bitmap1;
        }
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
        if (GPUImage.c(b) == null || GPUImage.c(b).b() != 0)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        synchronized (GPUImage.c(b).b)
        {
            GPUImage.c(b).b.wait(3000L);
        }
_L2:
        c = GPUImage.d(b);
        d = GPUImage.e(b);
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
        a.a(bitmap);
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
