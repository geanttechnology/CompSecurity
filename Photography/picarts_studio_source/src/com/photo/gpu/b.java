// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.gpu;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import com.socialin.android.util.w;
import java.io.IOException;

// Referenced classes of package com.photo.gpu:
//            GPUImage, e

abstract class b extends AsyncTask
{

    private final GPUImage a;
    private int b;
    private int c;
    private GPUImage d;

    public b(GPUImage gpuimage, GPUImage gpuimage1)
    {
        d = gpuimage;
        super();
        a = gpuimage1;
    }

    private transient Bitmap b()
    {
        if (d.b.c != 0)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        synchronized (d.b.b)
        {
            d.b.b.wait(3000L);
        }
_L2:
        b = 3200;
        c = 3200;
        Log.e("ex1", (new StringBuilder("mOutputWidth = ")).append(b).toString());
        Log.e("ex1", (new StringBuilder("mOutputHeight = ")).append(c).toString());
        return c();
        exception;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    private Bitmap c()
    {
        int i;
        boolean flag2;
        flag2 = true;
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        a(options);
        i = 1;
        do
        {
label0:
            {
                boolean flag;
                boolean flag1;
                if (options.outWidth / i > b)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (options.outHeight / i > c)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag || flag1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        Object obj;
        i--;
        if (i <= 0)
        {
            i = ((flag2) ? 1 : 0);
        }
        obj = new android.graphics.BitmapFactory.Options();
        obj.inSampleSize = i;
        obj.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
        obj = a(((android.graphics.BitmapFactory.Options) (obj)));
        if (obj == null)
        {
            return null;
        }
        Bitmap bitmap = w.b(((Bitmap) (obj)), a());
        obj = bitmap;
_L2:
        Log.e("ex1", "bitmap size after rotate");
        Log.e("ex1", (new StringBuilder("size = ")).append(((Bitmap) (obj)).getWidth()).append(" h = ").append(((Bitmap) (obj)).getHeight()).toString());
        return ((Bitmap) (obj));
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected abstract int a();

    protected abstract Bitmap a(android.graphics.BitmapFactory.Options options);

    protected Object doInBackground(Object aobj[])
    {
        return b();
    }

    protected void onPostExecute(Object obj)
    {
        obj = (Bitmap)obj;
        super.onPostExecute(obj);
        a.c();
        a.a(((Bitmap) (obj)));
    }
}
