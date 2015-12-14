// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class byg
    implements Runnable
{

    final Bitmap a;
    final byf b;

    byg(byf byf1, Bitmap bitmap)
    {
        b = byf1;
        a = bitmap;
        super();
    }

    public void run()
    {
        if (byf.a(b) == -1)
        {
            GLES20.glActiveTexture(33987);
            byf.a(b, OpenGlUtils.a(a, -1, false));
        }
    }
}
