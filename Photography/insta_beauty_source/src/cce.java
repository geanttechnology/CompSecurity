// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class cce
    implements Runnable
{

    final ccc a;

    cce(ccc ccc1)
    {
        a = ccc1;
        super();
    }

    public void run()
    {
        if (ccc.c(a) != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                ccc.c(a)
            }, 0);
            ccc.b(a, -1);
        }
        GLES20.glActiveTexture(33986);
        ccc.b(a, OpenGlUtils.a(ccc.d(a), -1, true));
    }
}
