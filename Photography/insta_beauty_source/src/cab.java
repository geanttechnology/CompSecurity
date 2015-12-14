// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class cab
    implements Runnable
{

    final caa a;

    cab(caa caa1)
    {
        a = caa1;
        super();
    }

    public void run()
    {
        if (caa.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            caa.a(a, OpenGlUtils.a(caa.b(a), -1, true));
        }
    }
}
