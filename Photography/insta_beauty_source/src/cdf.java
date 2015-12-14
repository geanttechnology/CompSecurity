// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class cdf
    implements Runnable
{

    final cde a;

    cdf(cde cde1)
    {
        a = cde1;
        super();
    }

    public void run()
    {
        if (cde.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            cde.a(a, OpenGlUtils.a(cde.b(a), -1, true));
        }
    }
}
