// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.Canvas;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class byn
    implements Runnable
{

    final Bitmap a;
    final boolean b;
    final byi c;

    byn(byi byi1, Bitmap bitmap, boolean flag)
    {
        c = byi1;
        a = bitmap;
        b = flag;
        super();
    }

    public void run()
    {
        Bitmap bitmap;
        Bitmap bitmap1;
        byi byi1;
        if (a.getWidth() % 2 == 1)
        {
            bitmap = Bitmap.createBitmap(a.getWidth() + 1, a.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            canvas.drawARGB(0, 0, 0, 0);
            canvas.drawBitmap(a, 0.0F, 0.0F, null);
            byi.d(c, 1);
        } else
        {
            byi.d(c, 0);
            bitmap = null;
        }
        byi1 = c;
        if (bitmap != null)
        {
            bitmap1 = bitmap;
        } else
        {
            bitmap1 = a;
        }
        byi.a(byi1, OpenGlUtils.a(bitmap1, byi.b(c), b));
        if (bitmap != null)
        {
            bitmap.recycle();
        }
        byi.b(c, a.getWidth());
        byi.c(c, a.getHeight());
        byi.e(c);
    }
}
