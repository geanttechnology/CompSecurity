// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class ccq
    implements Runnable
{

    final Bitmap a;
    final cco b;

    ccq(cco cco1, Bitmap bitmap)
    {
        b = cco1;
        a = bitmap;
        super();
    }

    public void run()
    {
        if (cco.c(b) == -1)
        {
            GLES20.glActiveTexture(33987);
            cco.b(b, OpenGlUtils.a(a, -1, true));
        }
    }
}
