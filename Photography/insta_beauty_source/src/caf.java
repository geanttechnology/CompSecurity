// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class caf
    implements Runnable
{

    final cae a;

    caf(cae cae1)
    {
        a = cae1;
        super();
    }

    public void run()
    {
        if (cae.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            cae.a(a, OpenGlUtils.a(cae.b(a), -1, true));
        }
    }
}
